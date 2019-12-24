package com.acurian.selenium.utils;

import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.ChildResult;
import com.acurian.selenium.utils.db.RadiantResults;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DBConnection {

//            String myURL = "jdbc:oracle:thin:@(DESCRIPTION=" +
//                        "(ADDRESS=(PROTOCOL=TCP)(HOST=dev-db-scan.acurian.com)(PORT=1521))" +
//                        "(CONNECT_DATA=(SERVER=dedicated)(SERVICE_NAME=acustg_users.acurian.com)))";

    private final String stageURL = "jdbc:oracle:thin:@dev-db-scan.acurian.com:1521/acustg_users.acurian.com";
    private final String prodURL = "jdbc:oracle:thin:@prd-db-scan.acurian.com:1521/ACUPRD_users.acurian.com";
    private final String qaURL = "jdbc:oracle:thin:@dev-db-scan.acurian.com:1521/acuqa_users.acurian.com";
    private final String userName = "autotest";
    private final String password = "autotest";

//    String environment = "PRD";
//    String pidNumber = "64293501";//prod- 64293501, stg- 63071241,

    private ResultSet rset = null;
    private Statement stmt = null;
    private Connection conn = null;

    private String dispoCode = null;
    private String applicantStatus = null;

    private Connection getDbCon(String environment) {
        OracleDataSource ods;
        try {
            ods = new OracleDataSource();
            ods.setURL(getUrlByEnv(environment));
            ods.setUser(userName);
            ods.setPassword(password);
            conn = ods.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void dbCOPYProc(String environment, String pidNumber) {
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "DECLARE\n" +
                    "    v_user_id  NUMBER :=5953; \n" +
                    "    v_study_id NUMBER;\n" +
                    "    v_call_id NUMBER;\n" +
                    "    v_study_group_id NUMBER;    \n" +
                    "BEGIN\n" +
                    "    FOR REC IN\n" +
                    "    ( select call_id ,PATIENT_ID,STUDY_ID\n" +
                    "    from call where patient_id IN ('" + pidNumber + "')-- enter patient id\n" +
                    "    ) LOOP\n" +
                    "        BEGIN    \n" +
                    "            select study_group_id INTO v_study_group_id from study_group \n" +
                    "            where STUDY_GROUP_TYPE = 'SU' and GENERAL_STUDY_ID = REC.STUDY_ID;\n" +
                    "            cc_dev.mega_study.process_call(v_study_group_id,REC.CALL_ID, v_user_id);\n" +
                    "            COMMIT;\n" +
                    "        END ;  \n" +
                    "    END LOOP;\n" +
                    "END;";
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                dispoCode = rset.getString("dispo_cd");
                applicantStatus = rset.getString("applicant_status_cd");
            }
            //System.out.println("DB parent: dispo = " + dispoCode + applicantStatus +", parent pid =" + pidNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public void dbReadPID(String environment, String pidNumber) {
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "select * from call where patient_id in ('" + pidNumber + "')";
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                dispoCode = rset.getString("dispo_cd");
                applicantStatus = rset.getString("applicant_status_cd");
            }
            System.out.println("DB parent: dispo = " + dispoCode + applicantStatus + ", parent pid =" + pidNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public void convert54Cto1R(String environment, String pidNumber) {
        try {
            Connection connTemp = getDbCon(environment);
            stmt = connTemp.createStatement();
            connTemp.setAutoCommit(false);
            stmt = connTemp.createStatement();
            String sql = "DECLARE " +
                    "BEGIN " +
                    "cc_dev.patient_admin_pkg.fix_54C_patient('" + pidNumber + "', 1, 'R'); " +
                    "END;";
            stmt.execute(sql);
            connTemp.commit();
            connTemp.setAutoCommit(true);
            System.out.println("DB dispo converted from 54C to 1R");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public String dbReadChildDOB(String env, String pidNumber, String studyId) {
        String dobCell = null;
        try {
            stmt = getDbCon(env).createStatement();
            final String query = "select ANSWER_DATE from PATIENT_QSTNR_ANSWER_RESP where patient_id in (select patient_id from call where old_patient_id = '" + pidNumber + "' " +
                    "and phone_number like '" + studyId + "%')";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                dobCell = rset.getString("ANSWER_DATE");
                if (dobCell != null) break;
            }
            System.out.println("DB fetched child DOB cell: " + dobCell);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return dobCell;
    }

    public String dbReadFulValue(String env, String pid) {
        String fulCell = null;
        try {
            stmt = getDbCon(env).createStatement();
            final String query = "SELECT VALUE from S_CALL.CALL_ATTRIBUTE a where a.PATIENT_ID IN '" + pid + "' AND a.KEY = 'FOLLOW_UP_LETTER'";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                fulCell = rset.getString("VALUE");
            }
            System.out.println("DB fetched value of FUL cell: " + fulCell);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return Objects.requireNonNull(fulCell, "Returned fulCell is NULL!");
    }

    public RadiantResults dbReadRadiant(String environment, String pidNumber) {
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "select * from S_EXT_CONTACT.CNL_OUTBOUND_LOG where Patient_ID IN(select patient_id from call where old_patient_id ='" + pidNumber + "')";
            rset = stmt.executeQuery(sql);

            RadiantResults radiantResults = null;
            while (rset.next()) {
                radiantResults = new RadiantResults();
                radiantResults.setCurrentStatus(rset.getString("current_status"));
                radiantResults.setStudyReference(rset.getString("study_reference"));
                radiantResults.setResponseMessage(rset.getString("response_message"));

            }
            System.out.println("DB Radiant: current status = " + radiantResults.getCurrentStatus() +
                    ", study reference = " + radiantResults.getStudyReference() +
                    ", response message = " + radiantResults.getResponseMessage());
            return radiantResults;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    public ChildResult dbReadChildPID(String environment, String pidNumber, String... firstPartOfChildPhoneNumber) {
        try {
            stmt = getDbCon(environment).createStatement();

            String sql = "select * from CALL where old_Patient_ID ='" + pidNumber + "'";
            if (firstPartOfChildPhoneNumber.length == 1) {
                sql = "select * from CALL where old_Patient_ID ='" + pidNumber + "'" +
                        " and PHONE_NUMBER like '" + firstPartOfChildPhoneNumber[0] + "%'";
            }

            rset = stmt.executeQuery(sql);

            ChildResult childResult = null;
            while (rset.next()) {
                childResult = new ChildResult();
                childResult.setDispoCd(rset.getString("dispo_cd"));
                childResult.setApplicantStatus(rset.getString("applicant_status_cd"));
                childResult.setPhoneNumber(rset.getString("phone_number"));
                childResult.setChildPid(rset.getString("patient_id"));
            }
            System.out.println("DB Child: dispo =" + childResult.getDispoCd() + childResult.getApplicantStatus() +
                    ", phone number = " + childResult.getPhoneNumber() +
                    ", child PID = " + childResult.getChildPid());
            return childResult;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    public AnomalyResults dbReadAnomaly(String environment, String pidNumber) {
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "select * from SECOND_SCREEN_PROCESSING where Patient_ID =" + pidNumber;
            rset = stmt.executeQuery(sql);

            AnomalyResults anomalyResults = null;
            while (rset.next()) {
                anomalyResults = new AnomalyResults();
                anomalyResults.setCurrentStatus(rset.getString("current_status"));
                anomalyResults.setRequestStatus(rset.getString("request_status_id"));
            }
            System.out.println("DB Anomaly: current status = " + anomalyResults.getCurrentStatus() +
                    ", request status id = " + anomalyResults.getRequestStatus());
            return anomalyResults;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    public String dbGetStatusFlare(String env, String childPid) {
        String flareStatus = null;
        try {
            stmt = getDbCon(env).createStatement();
            final String query = "select * from patient_study_secondary_status where patient_id = "+childPid;
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                flareStatus = rset.getString("STATUS_SET_MEMBER_ID");
                System.out.println(flareStatus);
            }
            System.out.println("DB fetched value of FLARE cell: " + flareStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return flareStatus;
    }

    public String getPIDByPhoneNumberAndStartTime(String env, String phoneNumber, Date date) {
        String patient_id = null;
        SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy hh:mm:ss a");
        try {
            stmt = getDbCon(env).createStatement();
            final String query = String.format("select PATIENT_ID from call where phone_number = '%s' " +
                            "and START_TIME >= to_date('%s','mon/dd/yyyy hh:mi:ss AM')",
                    phoneNumber, formatter.format(date));
            System.out.println("SQL query: " + query);
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                patient_id = rset.getString("PATIENT_ID");
            }
            System.out.println("DB fetched value of PID: " + patient_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return patient_id;
    }

    public String getStudyIdByProjectCode(String env, String projectCode) {
        String studyId = null;
        try {
            stmt = getDbCon(env).createStatement();
            final String query = "SELECT study_id FROM study WHERE project_code ='" + projectCode + "'";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                studyId = rset.getString("study_id");
            }
            System.out.println("DB fetched value of STUDY_ID: " + studyId + " for projectCode: " + projectCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return Objects.requireNonNull(studyId, "Returned STUDY_ID is NULL!");
    }

    public List<String> getRmgOrderPriorityList(String env) {
        List<String> studyId = new LinkedList<>();
        try {
            stmt = getDbCon(env).createStatement();
            final String query = "SELECT study_id from S_STUDY.STUDY_RMG_PRIORITY_CONFIG";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                studyId.add(rset.getString("study_id"));
            }
            System.out.println("DB fetched value(s) for STUDY_RMG_PRIORITY_CONFIG: " + studyId.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return Objects.requireNonNull(studyId, "Returned STUDY_ID list is NULL!");
    }

    private void closeResources() {
        try {
            if (rset != null) rset.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getUrlByEnv(String environment) {
        switch (environment) {
            case "QA":
                return qaURL;
            case "STG":
                return stageURL;
            case "PRD":
                return prodURL;
            default:
                return stageURL;
        }
    }

    public String getDispoCode() {
        return dispoCode;
    }

    public String getApplicantStatus() {
        return applicantStatus;
    }

    public String getDispo() {
        return dispoCode + applicantStatus;
    }
}

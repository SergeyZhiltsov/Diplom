package com.acurian.utils;

import com.acurian.utils.db.AnomalyResults;
import com.acurian.utils.db.ChildResult;
import com.acurian.utils.db.RadiantResults;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Step;

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

    private static Logger Log = LogManager.getLogger(DBConnection.class.getName());

//            String myURL = "jdbc:oracle:thin:@(DESCRIPTION=" +
//                        "(ADDRESS=(PROTOCOL=TCP)(HOST=dev-db-scan.acurian.com)(PORT=1521))" +
//                        "(CONNECT_DATA=(SERVER=dedicated)(SERVICE_NAME=acustg_users.acurian.com)))";

    private final String stageURL = "jdbc:oracle:thin:@dev-db-scan.acurian.com:1521/acustg_users.acurian.com";
    private final String prodURL = "jdbc:oracle:thin:@prd-db-scan.acurian.com:1521/ACUPRD_users.acurian.com";
    private final String qaURL = "jdbc:oracle:thin:@dev-db-scan.acurian.com:1521/acuqa_users.acurian.com";
    private final String userName = "autotest";
    private final String password = "autotest";
    private String studyNum = null;
    private String studyID = null;
    private String projectCode = null;
    private String studyName = null;
    private String createDate = null;
    private String updateDate = null;
    private String facilityCD = null;
    private String displayInd = null;
    private String testSiteInd = null;


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
            ods.setLoginTimeout(120);
            conn = ods.getConnection();
        } catch (SQLException e) {
            Log.error(e.getMessage());
            throw new RuntimeException();
        }
        return conn;
    }

    public void dbCOPYProc(String environment, String pidNumber) {
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "DECLARE\n" +
                    "    v_user_id  NUMBER; \n" +
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
            //Log.info("DB parent: dispoBlinx = " + dispoCode + applicantStatus +", parent pid =" + pidNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    /**
     * Extract digit from string.
     *
     * @param word the word
     * @return the string as number
     */
    public static String extractNumberFromString(String word) {
        String number = word.replaceAll("\\s+", "");
        return number.replaceAll("[^0-9]", "");
    }

    public void dbReadPID(String environment, String pidNumber) {
        try {
            String pidWithoutChars = extractNumberFromString(pidNumber);
            stmt = getDbCon(environment).createStatement();
            stmt.setQueryTimeout(120);
            String sql = "select * from call where patient_id in (" + pidWithoutChars + ")";
            logToAllure("Initiated sql is: " + sql);
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                dispoCode = rset.getString("dispo_cd");
                applicantStatus = rset.getString("applicant_status_cd");
            }
            Log.info("DB parent: dispoBlinx = " + dispoCode + applicantStatus + ", parent pid =" + pidNumber);
        } catch (SQLException e) {
            Log.error(e.getMessage());
            throw new RuntimeException();
        } finally {
            closeResources();
        }
    }

    @Step
    private void logToAllure(String s) {
        Log.info(s);
    }

    @Step
    public void checkTestFlag(String environment) {
        SoftAssert softAssert = new SoftAssert();
        int i = 0;
        try {
            stmt = getDbCon(environment).createStatement();

            String sql = "SELECT * FROM STUDY_SITE inner join study on STUDY_SITE.study_id = study.study_id WHERE (SITE_NUM LIKE '%AUT%' OR SITE_NUM LIKE '%QA%' OR SITE_NUM LIKE '%AUTS%' OR SITE_NUM LIKE '%QAV%' OR SITE_NUM LIKE '%QAVS%' OR SITE_NUM LIKE '%QAV_%') AND TEST_SITE_IND = 'N'";
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                try {
                    studyNum = rset.getString("site_num");
                    studyID = rset.getString("study_id");
                    projectCode = rset.getString("project_code");
                    studyName = rset.getString("study_name");
                    createDate = rset.getString("create_date");
                    updateDate = rset.getString("update_date");
                    facilityCD = rset.getString("facility_cd");
                    displayInd = rset.getString("display_ind");
                    testSiteInd = rset.getString("test_site_ind");
                    logToAllure("Test site without test flag:" + "\n"
                            + "site_num: " + studyNum + ", "
                            + "study_id: " + studyID + ", "
                            + "project_code: " + projectCode + ", "
                            + "study_name: " + studyName + ", "
                            + "create_date: " + createDate + ", "
                            + "update_date: " + updateDate + ", "
                            + "facility_cd: " + facilityCD + ", "
                            + "display_ind: " + displayInd + ", "
                            + "test_site_ind: " + testSiteInd + ".");
                    i++;
                    if (studyNum.contains("AUT_TEMP")) {
                        i--;
                    }
                } catch (NullPointerException e) {
                    logToAllure("All test sites are flagged");
                    break;
                }
            }
            softAssert.assertEquals(i, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        softAssert.assertAll();
    }

    public void convert54Cto1R(String environment, String pidNumber) {
        try {
            Log.info("12314231 " + pidNumber);
            Connection connTemp = getDbCon(environment);
            stmt = connTemp.createStatement();
            connTemp.setAutoCommit(false);
            stmt = connTemp.createStatement();
            String sql = "DECLARE " +
                    "BEGIN " +
                    "cc_dev.patient_admin_pkg.fix_54C_patient(" + pidNumber + ", 1, 'R'); " +
                    "END;";
            stmt.execute(sql);
            connTemp.commit();
            connTemp.setAutoCommit(true);
            Log.info("DB dispoBlinx converted from 54C to 1R");
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
            Log.info("DB fetched child DOB cell: " + dobCell);
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
            Log.info("DB fetched value of FUL cell: " + fulCell);
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
            Log.info("DB Radiant: current status = " + radiantResults.getCurrentStatus() +
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
            Log.info("DB Child: dispoBlinx =" + childResult.getDispoCd() + childResult.getApplicantStatus() +
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
            Log.info("DB Anomaly: current status = " + anomalyResults.getCurrentStatus() +
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
            final String query = "Select patient_id, status_set_member_id from patient_study_secondary_status where patient_id in (" + childPid + ")";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                flareStatus = rset.getString("STATUS_SET_MEMBER_ID");
            }
            Log.info("DB fetched value of FLARE cell: " + flareStatus);
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
            Log.info("SQL query: " + query);
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                patient_id = rset.getString("PATIENT_ID");
            }
            Log.info("DB fetched value of PID: " + patient_id);
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
            Log.info("DB fetched value of STUDY_ID: " + studyId + " for projectCode: " + projectCode);
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
            Log.info("DB fetched value(s) for STUDY_RMG_PRIORITY_CONFIG: " + studyId.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return Objects.requireNonNull(studyId, "Returned STUDY_ID list is NULL!");
    }

    public void closeResources() {
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

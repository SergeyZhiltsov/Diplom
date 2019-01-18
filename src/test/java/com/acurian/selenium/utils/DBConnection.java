package com.acurian.selenium.utils;

import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.RadiantResults;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void dbReadPID(String environment, String pidNumber){
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "select * from call where patient_id in ('"+pidNumber+"')";
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                dispoCode = rset.getString("dispo_cd");
                applicantStatus = rset.getString("applicant_status_cd");
            }
            System.out.println("--::DispoRead from DB::--");
            System.out.println("Dispo ="+dispoCode+applicantStatus);
            System.out.println("DB read completed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
            System.out.println("--::DispoConvert 54C to 1R::--");
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
                    "and phone_number like '" + studyId + "%');";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                dobCell = rset.getString("ANSWER_DATE");
                if(dobCell != null) break;
            }
            System.out.println("--::ChildDOBRead from DB::--");
            System.out.println("Fetched child DOB cell: " + dobCell);
            System.out.println("DB read completed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeResources();
        }
        return dobCell;
    }

    public RadiantResults dbReadRadiant(String environment, String pidNumber) {
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "select * from S_EXT_CONTACT.CNL_OUTBOUND_LOG where Patient_ID IN(select patient_id from call where old_patient_id ='" +pidNumber+ "')";
            rset = stmt.executeQuery(sql);

            RadiantResults radiantResults = null;
            while (rset.next()) {
                radiantResults = new RadiantResults();
                radiantResults.setCurrentStatus(rset.getString("current_status"));
            }
            System.out.println("--::Radiant read::--");
            System.out.println("Current Status =" + radiantResults.getCurrentStatus());
            System.out.println("DB read completed");
            return radiantResults;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeResources();
        }
        return null;
    }
    
    public String dbReadChilPID(String environment, String pidNumber) {
        try {
            stmt = getDbCon(environment).createStatement();
            String sql = "select * from CALL where old_Patient_ID ='" +pidNumber+ "'";
            rset = stmt.executeQuery(sql);

            String childPID = null;
            while (rset.next()) {
                childPID = rset.getString("patient_id");
            }
            System.out.println("--::Child PID read::--");
            System.out.println("Child PID =" + childPID);
            System.out.println("DB read completed");
            return childPID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
            System.out.println("--::Anomaly read::--");
            System.out.println("Current Status =" + anomalyResults.getCurrentStatus());
            System.out.println("Request Status id=" + anomalyResults.getRequestStatus());
            System.out.println("DB read completed");
            return anomalyResults;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeResources();
        }
        return null;
    }

    private void closeResources(){
        try {
            if (rset != null) rset.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getUrlByEnv(String environment){
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
        return dispoCode+applicantStatus;
    }
}

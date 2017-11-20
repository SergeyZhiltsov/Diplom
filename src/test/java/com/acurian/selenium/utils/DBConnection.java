package com.acurian.selenium.utils;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

//            String myURL = "jdbc:oracle:thin:@(DESCRIPTION=" +
//                        "(ADDRESS=(PROTOCOL=TCP)(HOST=dev-db-scan.acurian.com)(PORT=1521))" +
//                        "(CONNECT_DATA=(SERVER=dedicated)(SERVICE_NAME=acustg_users.acurian.com)))";

    private String stageURL = "jdbc:oracle:thin:@dev-db-scan.acurian.com:1521/acustg_users.acurian.com";
    private String prodURL = "jdbc:oracle:thin:@prd-db-scan.acurian.com:1521/ACUPRD_users.acurian.com";
    private String qaURL = "";
    private String userName = "autotest";
    private String password = "autotest";

//    String environment = "PRD";
//    String pidNumber = "64293501";//prod- 64293501, stg- 63071241,

    private ResultSet rset = null;
    private Statement stmt = null;
    private Connection conn = null;

    private String dispoCode = null;
    private String applicantStatus = null;

    public void dbRead(String environment, String pidNumber){
        OracleDataSource ods = null;
        try {
            ods = new OracleDataSource();
            ods.setURL(getUrlByEnv(environment));
            ods.setUser(userName);
            ods.setPassword(password);
            conn = ods.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from call where patient_id in ('"+pidNumber+"')";
            rset = stmt.executeQuery(sql);

            while (rset.next()) {
                dispoCode = rset.getString("dispo_cd");
                applicantStatus = rset.getString("applicant_status_cd");
            }

            System.out.println("Dispo ="+dispoCode+applicantStatus);
            System.out.println("DB read completed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rset.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

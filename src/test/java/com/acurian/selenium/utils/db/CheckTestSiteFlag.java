package com.acurian.selenium.utils.db;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.utils.DBConnection;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class CheckTestSiteFlag extends BaseTest {
    @Test()
    public void checkFlag() {
        final String env = System.getProperty("acurian.env", "STG");
        DBConnection dBConnection = new DBConnection();
        dBConnection
                .checkTestFlag(env);
    }
}

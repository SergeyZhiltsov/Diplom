package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ServerStatusOLS extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"http://ols1.acuriantrials.com/welcome.do?method=beginCall&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&phoneNumber=800AMS1UAP", "AHOALAPPV-prod-21"},
                {"http://ols2.acuriantrials.com/welcome.do?method=beginCall&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&phoneNumber=800AMS1UAP", "AHOALAPPV-prod-22"},
                {"https://acurianhealth.com/questionnaire-direct-api/api3/welcome?show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&pn=800AMS1UAP", "AHOALAPPV-prod-17"},
                {"https://acurianhealth.com/questionnaire-direct-api/api4/welcome?show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&pn=800AMS1UAP", "AHOALAPPV-prod-18"},
        };
    }

    @Test(dataProvider = "testData")
    public void healthCheckConnectivity(String testURL, String serverName) {
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        MainPageOLS mainPageOLS = new MainPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        getDriver().navigate().to(testURL);
        dateOfBirthPageOLS.
                waitForPageLoadPsoariaticArthritis();
        mainPageOLS
                .getPage(debugPageOLS)
                .assertServerConnectivity("Server:" + serverName);
    }
}

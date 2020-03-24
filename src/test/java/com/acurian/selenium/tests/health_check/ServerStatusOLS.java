package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.ServerStatus.ServerStatusStartPageOLS;
import com.acurian.selenium.pages.ServerStatus.ServerStatusZipOLS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ServerStatusOLS extends BaseTest {


    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"http://ols1.acuriantrials.com/welcome.do?method=beginCall&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&phoneNumber=AUTAMS1GEN", "Server:AHOALAPPV-prod-21"},
                {"http://ols2.acuriantrials.com/welcome.do?method=beginCall&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&phoneNumber=AUTAMS1GEN", "Server:AHOALAPPV-prod-22"},
                {"https://acurianhealth.com/questionnaire-direct-api/api3/welcome?show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&pn=AUTAMS1GEN", "SERVER: AHOALAPPV-prod-23"},
                {"https://acurianhealth.com/questionnaire-direct-api/api4/welcome?show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7&pn=AUTAMS1GEN", "SERVER: AHOALAPPV-prod-24"},
        };
    }

    @Test(dataProvider = "testData")
    public void healthCheckConnectivityOLS(String testURL, String serverName) {
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        MainPageOLS mainPageOLS = new MainPageOLS();
        ServerStatusStartPageOLS serverStatusStartPageOLS = new ServerStatusStartPageOLS();

        getDriver().navigate().to(testURL);
        serverStatusStartPageOLS
                .waitForPageLoadServer();
        mainPageOLS
                .getPage(debugPageOLS)
                .assertServerConnectivity(serverName);
        serverStatusStartPageOLS
                .waitForPageLoad()
                .clickOnYes()
                .clickNextButtonCH(new ServerStatusZipOLS())
                .waitForPageLoad();
    }
}

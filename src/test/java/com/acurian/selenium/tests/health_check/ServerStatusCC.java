package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.utils.Properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServerStatusCC extends BaseTest {
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
                {"https://cc1.acuriancalls.com", "Server:AHOALAPPV-prod-17"},
                {"https://cc2.acuriancalls.com", "Server:AHOALAPPV-prod-18"},
        };
    }

    @Test(dataProvider = "testData")
    public void healthCheckConnectivity(String testURL, String serverName) {
        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
        CallCenterIntroductionPageCC callCenterIntroductionPageCC = new CallCenterIntroductionPageCC();
        SelectActionPageCC selectActionPageCC = new SelectActionPageCC();

        final String phoneNumber = "AUTAMS1GEN";
        String env = System.getProperty("acurian.env", "PRD");

        getDriver().navigate().to(testURL);

        loginPageCC
                .waitForPageLoad()
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad2Ver()
                .getPage(debugPageCC)
                .assertServerConnectivityCC(serverName);
    }
}

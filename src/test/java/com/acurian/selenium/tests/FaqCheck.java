package com.acurian.selenium.tests;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.faq.FaqPage;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.utils.DataProviderPool;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaqCheck extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Faq Check")
    public void faqCheck(final String username, final String password) {
        final String phoneNumber = "AUTAMS1CV1";
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        FaqPage faqPage = callCenterIntroductionPageCC
                .waitForPageLoad()
                .chooseFromNavigationMenu("FAQ", new FaqPage());

//        faqPage
//                .waitForPageLoad()

    }
}

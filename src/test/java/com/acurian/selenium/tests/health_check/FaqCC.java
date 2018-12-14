package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.common_elements.HeaderMenuPage;
import com.acurian.selenium.pages.CC.faq.FaqPage;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class FaqCC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("FAQ Links checks in CC")
    public void faqTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1AST";

        String env = System.getProperty("acurian.env", "PRD");

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

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");

        HeaderMenuPage headerMenuPage = new HeaderMenuPage();
        FaqPage faqPage = headerMenuPage
                .chooseFromNavigationMenu("FAQ", new FaqPage())
                .switchTab();

        Assert.assertEquals(faqPage.getHeaderText(),"Frequently Asked Questions", "FAQ Header Text is diff");
        Assert.assertEquals(faqPage.getProjectText(),"(ACURIAN PROJECT CODE: AMS1)", "FAQ Project Code is diff");
        Assert.assertEquals(faqPage.getFirstNavigationText(),"General Information", "FAQ navigation content Text is diff");
        Assert.assertEquals(faqPage.getStudyHeaderText(),"Study Questions", "FAQ Study Text is diff");

        for (int i = 0; i < faqPage.expectedFaqTitles.size(); i++) {
            System.out.println("Comparing " + "[" + faqPage.expectedFaqTitles.get(i) + "] with [" + faqPage.faqTitles.get(i).getText() + "]");
            Assert.assertEquals(faqPage.faqTitles.get(i).getText(), faqPage.expectedFaqTitles.get(i),"Glossary term is Diff");
        }
        faqPage.filtereFaqDefinitions();
        for (int i = 0; i < faqPage.expectedFaqDefinisions.size(); i++) {
            System.out.println("Comparing " + "[" + faqPage.filteredDefinitions.get(i).getText() + "] with [" + faqPage.expectedFaqDefinisions.get(i) + "]");
            Assert.assertEquals(faqPage.filteredDefinitions.get(i).getText(), faqPage.expectedFaqDefinisions.get(i), " Glossary definision is Diff");
        }
    }
}

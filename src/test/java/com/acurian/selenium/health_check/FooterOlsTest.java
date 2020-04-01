package com.acurian.selenium.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.common_elements.FooterPageOLs;
import com.acurian.selenium.pages.OLS.common_elements.MoreAboutPage;
import com.acurian.selenium.pages.OLS.common_elements.PrivacyPolicyPage;
import com.acurian.selenium.pages.OLS.common_elements.TermOfUsePage;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class FooterOlsTest extends BaseTest {

    @Test
    @Description("Test for items(links, text) in footer, or external URLs")
    public void footerOlsTest() {
        String phoneNumber = "AUTAMS1MIG";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber);
            if (env.equals("QA")) {
                dateOfBirthPageOLS.waitForPageLoadServer(); //"a migraine study is absent in QA Gembs
            } else {
                dateOfBirthPageOLS.waitForPageLoadServer();
            }

        FooterPageOLs FooterPageOLS = new FooterPageOLs();

        if(env.equals("QA")) Assert.assertEquals(FooterPageOLS.getFooterText(), "* In a clinical research study, " +
                "the participants may receive investigational study product or may receive an inactive substance, " +
                "or placebo, depending on the study design. Participants receive study-related care from a " +
                "doctor/research team for the duration of the study. Reasonable payments will be made for participation " +
                "and the length of the study may vary.");
        else Assert.assertEquals(FooterPageOLS.getFooterText(), "* In a research study, the participants may receive " +
                "investigational study product or may receive an inactive substance, or placebo, depending on the study " +
                "design. Participants receive study-related care from a doctor/research team for the duration of the " +
                "study. For studies that offer compensation, reasonable payments will be made for participation. " +
                "The length of the study may vary.");

        PrivacyPolicyPage privacyPolicyPage = FooterPageOLS.clickPrivacyPolicyLink();
        privacyPolicyPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "Privacy Policy");
        privacyPolicyPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        MoreAboutPage moreAboutPage = FooterPageOLS.clickMoreAboutLink();
        moreAboutPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "When you can’t afford a delay in patient enrollment");
        moreAboutPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        TermOfUsePage termOfUsePage = FooterPageOLS.clickTermOfUseLink();
        termOfUsePage.switchTab();
        Assert.assertEquals(termOfUsePage.getHeaderText(), "Terms of Use");
        termOfUsePage.getDriver().close();
        privacyPolicyPage.switchToMainTab();
    }
}

package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.common_elements.FooterPageOls;
import com.acurian.selenium.pages.OLS.common_elements.MoreAboutPage;
import com.acurian.selenium.pages.OLS.common_elements.PrivacyPolicyPage;
import com.acurian.selenium.pages.OLS.common_elements.TermOfUsePage;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class FooterOlsTest extends BaseTest {

    @Test
    @Description("Test for items(links, text) in footer")
    public void footerOlsTest() {
        String phoneNumber = "AUTAMS1MIG";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();

        FooterPageOls footerPageOls = new FooterPageOls();

        Assert.assertEquals(footerPageOls.getFooterText(), "* In a clinical research study, the participants may"+
                " receive investigational study product or may receive an inactive substance,"+
                " or placebo, depending on the study design. Participants receive study-related care from a doctor/research"+
                " team for the duration of the study. Reasonable payments will be made for participation and the length of the study may vary.");


        PrivacyPolicyPage privacyPolicyPage = footerPageOls.clickPrivacyPolicyLink();
        privacyPolicyPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "Privacy Policy");
        privacyPolicyPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        MoreAboutPage moreAboutPage = footerPageOls.clickMoreAboutLink();
        moreAboutPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "When you can’t afford a delay in patient enrollment");
        moreAboutPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        TermOfUsePage termOfUsePage = footerPageOls.clickTermOfUseLink();
        termOfUsePage.switchTab();
        Assert.assertEquals(termOfUsePage.getHeaderText(), "Terms of Use");
        termOfUsePage.getDriver().close();
        privacyPolicyPage.switchToMainTab();
    }
}
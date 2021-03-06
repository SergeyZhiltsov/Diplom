package com.acurian.selenium.health_checkBlinx;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.common_elements.FooterPageBlinx;
import com.acurian.selenium.pages.blinx.ams.common_elements.MoreAboutPage;
import com.acurian.selenium.pages.blinx.ams.common_elements.PrivacyPolicyPage;
import com.acurian.selenium.pages.blinx.ams.common_elements.TermOfUsePage;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterOlsTest extends BaseTest {

    @Test
    @Description("Test for items(links, text) in footer, or external URLs")
    public void footerOlsTest() {
        String phoneNumber = "AUTAMS1MIG";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber);

        dateOfBirthPageOLS.waitForPageLoad0("a migraine study", "400");

        FooterPageBlinx FooterPageBlinx = new FooterPageBlinx();


        Assert.assertEquals(FooterPageBlinx.getFooterText(), "* In a research study, the participants may receive " +
                "investigational study product or may receive an inactive substance, or placebo, depending on the study " +
                "design. Participants receive study-related care from a doctor/research team for the duration of the " +
                "study. For studies that offer compensation, reasonable payments will be made for participation. " +
                "The length of the study may vary.");

        PrivacyPolicyPage privacyPolicyPage = FooterPageBlinx.clickPrivacyPolicyLink();
        privacyPolicyPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "Privacy Policy");
        privacyPolicyPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        MoreAboutPage moreAboutPage = FooterPageBlinx.clickMoreAboutLink();
        moreAboutPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "When you can’t afford a delay in patient enrollment");
        moreAboutPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        TermOfUsePage termOfUsePage = FooterPageBlinx.clickTermOfUseLink();
        termOfUsePage.switchTab();
        Assert.assertEquals(termOfUsePage.getHeaderText(), "Terms of Use");
        termOfUsePage.getDriver().close();
        privacyPolicyPage.switchToMainTab();
    }
}

package com.acurian.selenium.blinx;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.LessThan18YearsOldPageOLS;
import com.acurian.selenium.pages.blinx.ams.common_elements.FooterPageBlinx;
import com.acurian.selenium.pages.blinx.ams.common_elements.MoreAboutPage;
import com.acurian.selenium.pages.blinx.ams.common_elements.PrivacyPolicyPage;
import com.acurian.selenium.pages.blinx.ams.common_elements.TermOfUsePage;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AHLandingPage_OLSBlinx extends BaseTest {

    @Test(enabled = true)
    public void AH_landingPage_OLS() {
        String phoneNumberAH = "AUTAMS1GEN";
        String zipCode = "19044";
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        String env = System.getProperty("acurian.env", "STG");

        if (env.equals("STG")) {
            env = "AH_STG";
        } else if (env.equals("PRD")) {
            env = "AH_PROD";
        }

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberAH)
                .waitForPageAHLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextAH(), dateOfBirthPageOLS.titleAHExpected, "Title is diff");


        //---Validate Footer, and links : 'Privacy Policy','More about Acurian, Inc', 'Terms of Use'
        FooterPageBlinx footerPageBlinx = new FooterPageBlinx();
        Assert.assertEquals(footerPageBlinx.getFooterText(), "* In a research study, the participants may receive " +
                "investigational study product or may receive an inactive substance, or placebo, depending on the " +
                "study design. Participants receive study-related care from a doctor/research team for the duration " +
                "of the study. For studies that offer compensation, reasonable payments will be made for participation. " +
                "The length of the study may vary.");

        PrivacyPolicyPage privacyPolicyPage = footerPageBlinx.clickPrivacyPolicyLink();
        privacyPolicyPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "Privacy Policy");
        privacyPolicyPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        MoreAboutPage moreAboutPage = footerPageBlinx.clickMoreAboutLink();
        moreAboutPage.switchTab();
        Assert.assertEquals(privacyPolicyPage.getHeaderText(), "When you can’t afford a delay in patient enrollment");
        moreAboutPage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        TermOfUsePage termOfUsePage = footerPageBlinx.clickTermOfUseLink();
        termOfUsePage.switchTab();
        Assert.assertEquals(termOfUsePage.getHeaderText(), "Terms of Use");
        termOfUsePage.getDriver().close();
        privacyPolicyPage.switchToMainTab();

        //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QSI8006", protocol1, protocol2)
                .back(dateOfBirthPageOLS);
        dateOfBirthPageOLS
                .waitForPageAHLoad();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .setZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female");

        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpectedPart1, "Title is diff");

        //----------SiteSelection Page--------------------

        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
        if(siteSelectionPageOLS.getHostName().equals(Properties.getHostName())) {
            siteSelectionPageOLS
                    .getPID();
        }
    }
}

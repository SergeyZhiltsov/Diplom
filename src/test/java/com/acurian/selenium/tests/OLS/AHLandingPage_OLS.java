package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.*;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.LessThan18YearsOldPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.common_elements.FooterPageOls;
import com.acurian.selenium.pages.OLS.common_elements.MoreAboutPage;
import com.acurian.selenium.pages.OLS.common_elements.PrivacyPolicyPage;
import com.acurian.selenium.pages.OLS.common_elements.TermOfUsePage;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AHLandingPage_OLS extends BaseTest {

    @Test(enabled = true)
    public void AH_landingPage_OLS() {
        String phoneNumberAH = "AUTAMS1GEN";
        String zipCode = "19044";

        String env = System.getProperty("acurian.env", "STG");

        if (env.equals("STG"))
        {env = "AH_STG";}
        else
        if (env.equals("PRD"))
        {env = "AH_PROD";}

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberAH)
                .waitForPageAHLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextAH(), dateOfBirthPageOLS.titleAHExpected, "Title is diff");


        //---Validate Footer, and links : 'Privacy Policy','More about Acurian, Inc', 'Terms of Use'
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


        //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .setDate("09092005")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QSI8006", protocol1, protocol2)
                .back();
        dateOfBirthPageOLS
                .waitForPageAHLoad();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");


                //----------SiteSelection Page--------------------
        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS()
                .getPID();
    }
}
package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.RA.standalone.HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.UnqualifiedCloseOLS_GMEGA;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega.HasAHealthcareDiagnosedWithAnyTypeOfArthOLS;
import com.acurian.selenium.pages.OLS.gmega.HaveYouExperiencedanyOftheFollowingConfOLS;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.WhereDoYouHaveArthritisPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class SB_AUTSBSS extends BaseTest{

    @Test(enabled = true)
    @TestCaseId("001124")
    @Description("SB_Standalone test Screener")
    public void sb_AUTSBSS() {
        String phoneNumber = "AUTSBSS001";
        String protocol1 = "RA01_Generic";
        String studyName = "an arthritis";
        String siteName = "AUT_SB_SS_site";
        String zipCode = "19901";
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HasAHealthcareDiagnosedWithAnyTypeOfArthOLS hasAHealthcareDiagnosedWithAnyTypeOfArthOLS = genderPageOLS
                .clickOnAnswer("Female1")
                .clickNextButton(new HasAHealthcareDiagnosedWithAnyTypeOfArthOLS());

        hasAHealthcareDiagnosedWithAnyTypeOfArthOLS
                .waitForPageLoadSB();
        Assert.assertEquals(hasAHealthcareDiagnosedWithAnyTypeOfArthOLS.getTitleTextSB(), hasAHealthcareDiagnosedWithAnyTypeOfArthOLS.titleExpected, "Title is diff");
        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = hasAHealthcareDiagnosedWithAnyTypeOfArthOLS
                .clickOnAnswers_SB("Rheumatoid Arthritis, a serious disease caused by your immune system attacking your joints, which can cause fatigue with pain and swelling of multiple joints throughout your body")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad();
        HaveYouExperiencedanyOftheFollowingConfOLS haveYouExperiencedanyOftheFollowingConfOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(new HaveYouExperiencedanyOftheFollowingConfOLS());

        haveYouExperiencedanyOftheFollowingConfOLS
                .waitForPageLoadSB();
        IdentificationPageOLS identificationPageOLS = haveYouExperiencedanyOftheFollowingConfOLS
                .clickOnAnswers_SB("None of the above")
                .clickNextButton(new IdentificationPageOLS());


        identificationPageOLS
                .clickNextButton(identificationPageOLS)
                .waitForPageLoadSB()
                .clickNextButton(new SiteSelectionPageOLS())
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .threadSleep(2000);
                //.waitForPageLoad()
        identificationPageOLS
                .clickNextButton(new ThankYouCloseGmegaOLS())
                //.waitForPageLoad()
                .threadSleep(2000);
        identificationPageOLS
                .clickNextButton(new AboutHealthPageOLS())
                .threadSleep(4000);
                //.waitForPageLoad()
        identificationPageOLS
                .pidFromDbToLog(env)
                .dispoShouldMatch("1R");
    }
}
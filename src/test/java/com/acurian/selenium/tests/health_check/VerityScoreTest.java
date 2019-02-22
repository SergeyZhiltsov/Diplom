package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.RA_2821.WhenYouDiagnosedWithRaPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class VerityScoreTest extends BaseTest {

    @Test(enabled = true)
    @Description("Test for 1R and Verity Check")
    public void verityScoreTest() {
        String phoneNumber = "GMEGA30003";
        String studyName = "a rheumatoid arthritis (RA)";
        String siteName = "AUT_GRA1_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleGmegaExpected, "Title is diff");
        IdentificationPageOLS identificationPageOLS= dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoadNotQ();
        Assert.assertEquals(debugPageOLS.getVerityText(), "Verity Score: -1", "verity score is diff");
        GenderPageOLS genderPageOLS = identificationPageOLS
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = genderPageOLS
                .waitForPageLoadGmega()
                .clickOnAnswer("Female")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhenYouDiagnosedWithRaPageOLS whenYouDiagnosedWithRaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageOLS());

        whenYouDiagnosedWithRaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageOLS);

        identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName);
        HSGeneralPageOLS hsGeneralPageOLS = identificationPageOLS
                .clickNextButton(new HSGeneralPageOLS());

        if (env.equals("QA")) {
            hsGeneralPageOLS.waitForPageLoadByTitle(new HSGeneralPageOLS().titleRaExpectedQA);
        } else {
            hsGeneralPageOLS.waitForPageLoadByTitle(new HSGeneralPageOLS().titleRaExpectedSTGGMEGA3);
        }

        Assert.assertEquals(debugPageOLS.getVerityText(), "Verity Score: 0", "verity score is diff");
    }
}
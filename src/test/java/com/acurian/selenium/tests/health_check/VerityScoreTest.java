package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.RA.WhenYouDiagnosedWithRaPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class VerityScoreTest extends BaseTest {

    @Test(enabled = true)
    @Description("Test for 1R and Verity Check")
    public void verityScoreTest() {
        String phoneNumber = "AUTGMEGA03"; //Indication RA
        String studyName = "a rheumatoid arthritis (RA)";
        String siteName = "AUT_GRA1_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleRA2821Expected, "Title is diff");
        IdentificationPageOLS identificationPageOLS= dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoadNotQ();
        Assert.assertEquals(debugPageOLS.getVerityText(), "Verity Score: -1", "verity score is diff");
        GenderPageOLS genderPageOLS = identificationPageOLS
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = genderPageOLS
                .waitForPageLoadGmega()
                .clickOnAnswer("Female")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(identificationPageOLS);

        identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName);
        HSGeneralPageOLS hsGeneralPageOLS = identificationPageOLS
                .clickNextButton(new HSGeneralPageOLS());
        switch (env) {
            case "QA":
                hsGeneralPageOLS.waitForPageLoadByTitle(hsGeneralPageOLS.titleRaExpectedQA);
                break;
            case "STG":
                hsGeneralPageOLS.waitForPageLoadByTitle(hsGeneralPageOLS.titleRaExpectedSTG);
                break;
            case "PRD":
                hsGeneralPageOLS.waitForPageLoadByTitle(hsGeneralPageOLS.titleRaExpectedSTGGMEGA3);
                break;
        }
        Assert.assertEquals(debugPageOLS.getVerityText(), "Verity Score: 0", "verity score is diff");
    }
}
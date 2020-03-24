package com.acurian.selenium.health_check;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class VerityScoreTest extends BaseTest {

    @Test(enabled = true)
    @Description("Test for 1R and Verity Check")
    public void verityScoreTest() {
        Site site = Site.AUT_GRA1_Site;
        String phoneNumber = "AUTGMEGA03"; //Indication RA
        String studyName = "a rheumatoid arthritis (RA)";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA("a rheumatoid arthritis (RA)", "625");

        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        IdentificationPageOLS identificationPageOLS =  behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoadNotQ();
        Assert.assertEquals(debugPageOLS.getVerityText(), "Verity Score: -1", "verity score is diff");
        GenderPageOLS genderPageOLS = identificationPageOLS
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpected)
                .clickOnAnswer("Female")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoadGMEGA()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        boneOrJointConditionsPageOLS
                .waitForPageLoadGMEGA()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(identificationPageOLS);

        identificationPageOLS
                .waitForPageLoadGMEGA2()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoadGMEGA(studyName)
                .getPID()
                .clickOnFacilityName(site.name);
        HSGeneralPageOLS hsGeneralPageOLS = identificationPageOLS
                .clickNextButton(new HSGeneralPageOLS());
        hsGeneralPageOLS
                .waitForPageLoadByTitleGMEGA(hsGeneralPageOLS.titleRaExpectedQA);

        Assert.assertEquals(debugPageOLS.getVerityText(), "Verity Score: 0", "verity score is diff");
    }
}
package com.acurian.selenium.health_checkBlinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.gmega.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.blinx.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class HelloSignOls extends BaseTest {

    private static Logger Log = LogManager.getLogger(com.acurian.selenium.health_check.HelloSignOls.class.getName());

    @Test(enabled = true)
    @Description("Test for Hello Sign")
    public void helloSignOlsTest() {
        Site site = Site.AUT_GRA1_Site;
        String phoneNumber = "AUTGMEGA03"; //Indication RA
        String studyName = "a rheumatoid arthritis (RA)";

        String env = System.getProperty("acurian.env", "QA");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA(studyName, "625")
                .setDate("09091980")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        IdentificationPageOLS identificationPageOLS = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = genderPageOLS
                .waitForPageLoadGMEGASelect()
                .clickOnAnswer("Female")
                .clickNextButton(new WhatKindOfArthritisPageOLS()); //BoneOrJointConditionsPageOLS

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

        HSGeneralPageOLS hsGeneralPageOLS = identificationPageOLS
                .waitForPageLoad2()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad2(studyName + " study!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new HSGeneralPageOLS());

        DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = hsGeneralPageOLS
                .waitForPageLoadCut()
                .clickNextButton(new DoctorInformationCollectionPageOLS());

        HS1PageOLS hs1PageOLS = doctorInformationCollectionPageOLS
                .waitForPageLoadGMEGA()
                .clickNextButton(new HS1PageOLS());

        hs1PageOLS
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = new ThankYouCloseGmegaOLS();
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseGmegaOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env);
        }
    }
}

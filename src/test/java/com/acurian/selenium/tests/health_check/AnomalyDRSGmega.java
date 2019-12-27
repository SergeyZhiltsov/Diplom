package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DRSBlinx;
import com.acurian.selenium.pages.blinx.gmega.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.PleaseConfirmYourGenderPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.ProvidingInformationPageOLS;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.ArrayList;

public class AnomalyDRSGmega extends BaseTest
    {

        @Test(enabled = true)
        @Description("Test for 41C Anomaly DRS Blinx")
        public void anomalyTestDRSBlinx() {
        String phoneNumber = "AUTGMEG41C";
        String siteName = "AUT_GEMGA_01A";
        String zipCode = "19422";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
            ProvidingInformationPageOLS providingInformationPageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2("a rheumatoid arthritis (RA)", "625")
                .setDate("09091980")
               .clickNextButton(new ProvidingInformationPageOLS());

        IdentificationPageOLS identificationPageOLS = providingInformationPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

            PleaseConfirmYourGenderPageOLS pleaseConfirmYourGenderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode, "Blue Bell", "Pennsylvania")
                .clickNextButton(new PleaseConfirmYourGenderPageOLS());

            ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = pleaseConfirmYourGenderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightWeightPageOLS());

            EverDiagnosedFollowingNeurologicalConditionsPageOLS everDiagnosedFollowingNeurologicalConditionsPageOLS = approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "160")
                .clickNextButton(new EverDiagnosedFollowingNeurologicalConditionsPageOLS());

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = everDiagnosedFollowingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());

            FollowingBoneOrJointConditionsPageOLS FollowingBoneOrJointConditionsPageOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingBoneOrJointConditionsPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = FollowingBoneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

            DiagnosedWithRAPageOLS diagnosedWithRAPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new DiagnosedWithRAPageOLS());

        DRSBlinx dRSBlinx = diagnosedWithRAPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoad2()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad("Arthritis, a low back pain study, a rheumatoid arthritis (RA) study!")
                .getPID()
                .clickOnFacilityName("Acurian-1234")
                .clickNextButton(new DRSBlinx());
        dRSBlinx
                .waitForPageLoad2()
                .clickOnBtnNoApp()
                .waitForUnf()
                .clickOnUnfNext();
//                .clickOnBtnPrev()
//                .waitForPageLoadBlinx()
//                .clickOnDay()
//                .clickOnTime()
//                .clickOnNext()
//                .waitForPageLoadClientDetails()
//                .dateCheck()
//                .startsAtCheck()
//                .serviceProviderCheck()
//                .clickOnAgree()
//                .clickOnSendSMS();

            QualifiedClosePageOLS qualifiedClosePageOLS = new QualifiedClosePageOLS();
            qualifiedClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad2()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getAnomalyDbToLog(env);
    }
    }
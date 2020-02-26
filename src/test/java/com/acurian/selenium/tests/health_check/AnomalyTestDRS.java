package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.Vaccine.DirectSheduleVaccOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DRSBlinx;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.ArrayList;

public class AnomalyTestDRS extends BaseTest {

    @Test(enabled = true)
    @Description("Test for 41C Anomaly DRS")
    public void anomalyTestDRS() {
        String phoneNumber = "AUTGMEG41C";
        String siteName = "AUT_GEMGA_01A";
        String zipCode = "19422";
        String env = System.getProperty("acurian.env", "STG");
        String studyName = env.equals("QA") ?
                "Arthritis,a low back pain study,a rheumatoid arthritis (RA)" : "Arthritis, a low back pain study, a rheumatoid arthritis (RA)";


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA("a rheumatoid arthritis (RA)", "625")
                .setDate("09091980")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        IdentificationPageOLS identificationPageOLS = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpectedGmega)
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());

        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = followingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        DirectSheduleVaccOLS directSheduleBlinx = new DirectSheduleVaccOLS();
        DRSBlinx dRSBlinx = new DRSBlinx();
        whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoadGMEGA()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName("Acurian-1234")
                .clickNextButton(new DirectSheduleVaccOLS());
        if(env.equals("PRD")){
            directSheduleBlinx
                    .waitForPageLoadSTG();
        }
        if(env.equals("STG")){
            directSheduleBlinx
                    .waitForPageLoadSTG();
        }
        directSheduleBlinx
                .clickSheduleBtnBlinx(dRSBlinx);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        dRSBlinx
                .waitForPageLoadBlinx()
                .clickOnDay()
                .clickOnTime()
                .clickOnNext()
                .waitForPageLoadClientDetails()
                .dateCheck()
                .startsAtCheck()
                .serviceProviderCheck();
                //.assertClientData("qa.acurian@gmail.com", "9999999999")
//                .clickBook()
//                .waitForPageLoadSuccess();
//                .clickOnBtnNext()
//                .waitForThankYou();


        getDriver().switchTo().window(tabs.get(0));
        if(env.equals("PRD")){
            directSheduleBlinx
                    .waitForPageLoadSTG();
        }
        if(env.equals("STG")){
            directSheduleBlinx
                    .waitForPageLoadSTG();
        }
        directSheduleBlinx
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoadGMEGA()
                .clickNextButton(new ThankYouCloseGmegaOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getAnomalyDbToLog(env);
    }
}

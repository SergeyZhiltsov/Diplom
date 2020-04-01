package com.acurian.selenium.blinx.dispo;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.gmega.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Dispo2CsiteProximityBlinx extends BaseTest {

    @Test(enabled = true)
    @Description("Dispo_2C_SiteProximity")
    public void dispo2C() {
        String phoneNumber = "AUTGMEGA01";
        String env = System.getProperty("acurian.env", "STG");
        String zipCode = "99546";

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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", zipCode)
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

        BasedOnInformationGmegaPageOLS basedOnInformationGmegaPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new BasedOnInformationGmegaPageOLS());
        if (env.equals("QA")) {
            basedOnInformationGmegaPageOLS
                    .waitForPageLoadByTitle(basedOnInformationGmegaPageOLS.titleExpectedQA)
                    .clickOnAnswer("No");
        } else {
            basedOnInformationGmegaPageOLS
                    .waitForPageLoad();
        }
        AboutHealthPageOLS aboutHealthPageOLS = basedOnInformationGmegaPageOLS
                .getPage(new SiteSelectionPageOLS())
                .getPID()
                .clickNextButton(new ThankYouCloseGmegaOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        if(aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .dispoShouldMatch("2C")
                    .copyRun(env)
                    .childPidFromDbToLog(env);
        }
    }
}

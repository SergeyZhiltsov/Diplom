package com.acurian.selenium.dispoBlinx;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Dispo3I extends BaseTest {

    @Test(enabled = true)
    @Description("Dispo_3I_NonQRDisq")
    public void dispo3I() {
        String phoneNumber = "AUTGMEGA01";
        String env = System.getProperty("acurian.env", "STG");
        String zipCode = "08204";

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

        WhereDoYouHaveArthritisPageOLS whereDoYouHaveArthritisPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new WhereDoYouHaveArthritisPageOLS());

        TakingAcetaminophenTylenolPageOLS takingAcetaminophenTylenolPageOLS = whereDoYouHaveArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Left Knee")
                .clickNextButton(new TakingAcetaminophenTylenolPageOLS());

        UnqualifiedCloseOLS_GMEGA unqualifiedCloseOLS_gmega = takingAcetaminophenTylenolPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new UnqualifiedCloseOLS_GMEGA());

        AboutHealthPageOLS aboutHealthPageOLS = unqualifiedCloseOLS_gmega
                .waitForPageLoad()
                .getPage(new SiteSelectionPageOLS())
                .getPID()
                .getPage(unqualifiedCloseOLS_gmega)
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseGmegaOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .dispoShouldMatch("3I")
                    .copyRun(env)
                    .childPidFromDbToLog(env);
        }
    }
}

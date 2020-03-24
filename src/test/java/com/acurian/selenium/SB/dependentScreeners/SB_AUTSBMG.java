package com.acurian.selenium.SB.dependentScreeners;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class SB_AUTSBMG extends BaseTest {

    @Test(enabled= true)
    @Description("SreenerBuilder_AUTSBMG")
    public void sb_AUTSBMG() {
        String phoneNumber = "AUTSBMG001";
        String env = System.getProperty("acurian.env", "STG");

        String studyName = env.equals("QA") ?
                "Arthritis,a low back pain study,a rheumatoid arthritis (RA)" : "Arthritis, a low back pain study, a rheumatoid arthritis (RA)";
        String siteName = "AUT_SB_MG_site";
        String zipCode = "19901";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), dateOfBirthPageOLS.titleExpected, "Question is diff");

        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
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

        whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageOLS);

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .clickOnFacilityName(siteName)
                .getPID()
                .clickNextButton(new QualifiedClose2PageOLS());

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = qualifiedClose2PageOLS
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseGmegaOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseGmegaOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch("1R");
    }
}
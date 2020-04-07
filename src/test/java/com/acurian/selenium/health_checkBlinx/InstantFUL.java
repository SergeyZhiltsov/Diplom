package com.acurian.selenium.health_checkBlinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.gmega.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.blinx.gmega.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.blinx.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InstantFUL extends BaseTest {

    @DataProvider(name = "sites")
    public static Object[][] getData() {
        return new Object[][]{
                {Site.AUT_GRA_FUL_Site},
                {Site.AUT_GRA_FULm_Site}
        };
    }

    private String env = System.getProperty("acurian.env", "QA");

    @Test(dataProvider = "sites")
    @Description("Test for Instant Follow-Up Letter (FUL) Validation")
    public void instantFUL(Site site) {
        final String phoneNumber = "GMEGA00001";
        final String studyName = "a rheumatoid arthritis (RA)";
        final String studyNameClose = env.equals("QA") ? "Arthritis,a low back pain study,a rheumatoid arthritis (RA) study!" :
                "Arthritis, a low back pain study, a rheumatoid arthritis (RA) study!";

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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpectedGmega)
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad();
        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsOLS = approximateHeightPageOLS
                .setAll("5", "5", "160")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = followingNeurologicalConditionsOLS
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

        SiteSelectionPageOLS siteSelectionPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoad2()
                .clickNextButton(new SiteSelectionPageOLS());

        siteSelectionPageOLS
                .waitForPageLoad(studyNameClose)
                .clickOnFacilityName(site.name)
                .getPID();
        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .clickNextButton(new QualifiedClose2PageOLS());

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = qualifiedClose2PageOLS
                .waitForPageLoadGMEGA2()
                .clickNextButton(new ThankYouCloseGmegaOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseGmegaOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad();
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .assertGeneratedFul(env, site);
        }
    }
}

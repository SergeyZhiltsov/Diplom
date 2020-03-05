package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.gmega.*;
import com.acurian.selenium.pages.blinx.gmega.intro.LetsGetStartedPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.PleaseConfirmYourGenderPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.ProvidingInformationPageOLS;
import org.testng.annotations.Test;

public class BlinxGmega extends BaseTest {

    @Test()
    public void blinxGmegaTest() {

        //Date date = new Date();
        LetsGetStartedPageOLS letsGetStartedPageOLS = new LetsGetStartedPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        BaseTest.getDriver().navigate()
                .to("https://sf.acu2.aws.blinxsolutions.systems/welcome.do?method=beginCall&phoneNumber=AUTGMEGA01&up[]=CLIENT_BLINX" +
                        "&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7");

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        ProvidingInformationPageOLS providingInformationPageOLS = letsGetStartedPageOLS
                .waitForPageLoad("a rheumatoid arthritis (RA) study!", "625")
                .setDate("09091990")
                .clickNextButton(new ProvidingInformationPageOLS());
        letsGetStartedPageOLS
                .waitForAnimation();

        IdentificationPageOLS identificationPageOLS = providingInformationPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());
        providingInformationPageOLS
                .waitForAnimation();

        PleaseConfirmYourGenderPageOLS pleaseConfirmYourGenderPageOLS = new PleaseConfirmYourGenderPageOLS();
                (env.equals("PRD") ? identificationPageOLS.waitForPageLoad2() : identificationPageOLS.waitForPageLoadSTG())
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", "08204", "Cape May", "New Jersey")
                .clickNextButton(pleaseConfirmYourGenderPageOLS);
        identificationPageOLS
                .waitForAnimation();

        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = pleaseConfirmYourGenderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightWeightPageOLS());
        pleaseConfirmYourGenderPageOLS
                .waitForAnimation();

        EverDiagnosedFollowingNeurologicalConditionsPageOLS everDiagnosedFollowingNeurologicalConditionsPageOLS =
                approximateHeightWeightPageOLS
                        .waitForPageLoadGMEGA()
                        .setAllFields("5", "5", "160")
                        .clickNextButton(new EverDiagnosedFollowingNeurologicalConditionsPageOLS());
        everDiagnosedFollowingNeurologicalConditionsPageOLS
                .waitForAnimation();

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = everDiagnosedFollowingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());
        everDiagnosedFollowingNeurologicalConditionsPageOLS
                .waitForAnimation();

        FollowingBoneOrJointConditionsPageOLS followingBoneOrJointConditionsPageOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingBoneOrJointConditionsPageOLS());
        digestiveConditionsPageOLS
                .waitForAnimation();

        WhatKindOfArthritisDoYouHavePageOLS whatKindOfArthritisDoYouHavePageOLS = followingBoneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisDoYouHavePageOLS());
        followingBoneOrJointConditionsPageOLS
                .waitForAnimation();

        DiagnosedWithRAPageOLS diagnosedWithRAPageOLS = whatKindOfArthritisDoYouHavePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new DiagnosedWithRAPageOLS());
        whatKindOfArthritisDoYouHavePageOLS
                .waitForAnimation();

        diagnosedWithRAPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(identificationPageOLS);
        diagnosedWithRAPageOLS
                .waitForAnimation();

        SiteSelectionPageOLS siteSelectionPageOLS =
                (env.equals("PRD")? identificationPageOLS.waitForPageLoad2():identificationPageOLS.waitForPageLoadSTG())
                .clickNextButton(new SiteSelectionPageOLS());
        identificationPageOLS
                .waitForAnimation();

        QualifiedClosePageOLS qualifiedClosePageOLS = siteSelectionPageOLS
                .waitForPageLoad("Arthritis, a low back pain study, a rheumatoid arthritis (RA) study!")
                .getPage(debugPageOLS)
                .getPID()
                .getPage(siteSelectionPageOLS)
                .clickOnFacilityName("AUT_GMEGA_New")
                .clickNextButton(new QualifiedClosePageOLS());
        siteSelectionPageOLS
                .waitForAnimation();

        ThankYouClosePageOLS thankYouClosePageOLS = qualifiedClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new ThankYouClosePageOLS());
        qualifiedClosePageOLS
                .waitForAnimation();

        AboutHealthPageOLS aboutHealthPageOLS = thankYouClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLogWithCopy(env)
                .dispoShouldMatch("1R", "1R");

//        DBConnection dbConnection = new DBConnection();
//        String pid = dbConnection.getPIDByPhoneNumberAndStartTime("PRD", "AUTGMEGA01", date);
//        dbConnection.dbReadPID("PRD", pid);
//        Assert.assertEquals(dbConnection.getDispo(), "1R", "Dispo for Parent is different");
    }
}

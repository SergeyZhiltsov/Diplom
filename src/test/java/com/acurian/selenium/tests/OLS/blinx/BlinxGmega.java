package com.acurian.selenium.tests.OLS.blinx;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.DebugPageBlinxOLS;
import com.acurian.selenium.pages.blinx.gmega.*;
import com.acurian.selenium.pages.blinx.gmega.intro.LetsGetStartedPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.PersonalIdentificationPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.PleaseConfirmYourGenderPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.ProvidingInformationPageOLS;
import com.acurian.selenium.utils.DBConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class BlinxGmega extends BaseTest {

    @Test()
    public void blinxGmegaTest() {

        //Date date = new Date();
        LetsGetStartedPageOLS letsGetStartedPageOLS = new LetsGetStartedPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        BaseTest.getDriver().navigate()
                .to("https://screener.acurianhealth.com/welcome.do?method=beginCall&phoneNumber=GRA1OBXEKS&up[]=CLIENT_BLINX" +
                        "&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7");

        DebugPageBlinxOLS debugPageBlinxOLS = new DebugPageBlinxOLS();

        ProvidingInformationPageOLS providingInformationPageOLS = letsGetStartedPageOLS
                .waitForPageLoad("a rheumatoid arthritis (RA) study!", "625")
                .setDate("09091990")
                .clickNextButton(new ProvidingInformationPageOLS());

        PersonalIdentificationPageOLS personalIdentificationPageOLS = providingInformationPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new PersonalIdentificationPageOLS());

        PleaseConfirmYourGenderPageOLS pleaseConfirmYourGenderPageOLS = personalIdentificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", "08204", "Cape May", "New Jersey")
                .clickNextButton(new PleaseConfirmYourGenderPageOLS());

        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = pleaseConfirmYourGenderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightWeightPageOLS());

        EverDiagnosedFollowingNeurologicalConditionsPageOLS everDiagnosedFollowingNeurologicalConditionsPageOLS =
                approximateHeightWeightPageOLS
                        .waitForPageLoad()
                        .setAllFields("5", "5", "160")
                        .clickNextButton(new EverDiagnosedFollowingNeurologicalConditionsPageOLS());

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = everDiagnosedFollowingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());

        FollowingBoneOrJointConditionsPageOLS followingBoneOrJointConditionsPageOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingBoneOrJointConditionsPageOLS());

        WhatKindOfArthritisDoYouHavePageOLS whatKindOfArthritisDoYouHavePageOLS = followingBoneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisDoYouHavePageOLS());

        DiagnosedWithRAPageOLS diagnosedWithRAPageOLS = whatKindOfArthritisDoYouHavePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new DiagnosedWithRAPageOLS());

        diagnosedWithRAPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(personalIdentificationPageOLS);

        SiteSelectionPageOLS siteSelectionPageOLS = personalIdentificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClosePageOLS qualifiedClosePageOLS = siteSelectionPageOLS
                .waitForPageLoad("Arthritis, a low back pain study, a rheumatoid arthritis (RA) study!")
                .getPage(debugPageBlinxOLS)
                .getPID()
                .getPage(siteSelectionPageOLS)
                .clickOnFacilityName("AUT_GMEGA_New")
                .clickNextButton(new QualifiedClosePageOLS());

        ThankYouClosePageOLS thankYouClosePageOLS = qualifiedClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new ThankYouClosePageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch("1R", "1R");

//        DBConnection dbConnection = new DBConnection();
//        String pid = dbConnection.getPIDByPhoneNumberAndStartTime("PRD", "AUTGMEGA01", date);
//        dbConnection.dbReadPID("PRD", pid);
//        Assert.assertEquals(dbConnection.getDispo(), "1R", "Dispo for Parent is different");
    }
}

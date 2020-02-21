package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer1;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.gmega.WarmTransferGmegaPageCC;
import com.acurian.selenium.pages.CC.gmega.WhenYouDiagnosedWithRaGmegaPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class RadiantWTtest extends BaseTest {

    @Test(enabled = true)
    @Description("WT for RA , wt + 41C = directSchedule")
    public void warmTransferFor41CTest() {
        String phoneNumber = "AUTGMEGA01";
        String studyReferenceSql = "UCBPXLPSO014:109010";
//        String studyName = "an osteoarthritis study";
        String siteName = "AUT_GRA_WT_site";//AUT_GOA3_2108_Site
        String zipCode = "08204";
        String env = System.getProperty("acurian.env", "STG");
        String studyName = env.equals("QA") ?
                "Arthritis,a low back pain study,a rheumatoid arthritis (RA) study" : "Arthritis, a low back pain study, a rheumatoid arthritis (RA) study";

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("GMEGA")
                .clickPopupStudy("GMEGA")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        DateOfBirthPageCC dateOfBirthPageCC = new DateOfBirthPageCC();
        dateOfBirthPageCC
                .waitForPageLoadGmega("a rheumatoid arthritis (RA) study", "625");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleGmega3RAexpected, "Title is diff");

        BehalfOfSomeoneElsePageCC behalfOfSomeoneElsePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new BehalfOfSomeoneElsePageCC());

        IdentificationPageCC identificationPageCC = behalfOfSomeoneElsePageCC
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        ApproximateHeightPageCC approximateHeightPageOLS = genderPageCC
               .waitForPageLoadByTitle(genderPageCC.titleExpected3)
               .getPage(new CallCenterIntroductionPageCC())
               .activateDebugOnProd(env)
               .getPage(genderPageCC)
               .clickOnAnswerGmega("Female")
               .clickNextButton(new ApproximateHeightPageCC());

        FollowingNeurologicalConditions followingNeurologicalConditions = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new FollowingNeurologicalConditions());

        FollowingDigestiveConditionsPageCC followingDigestiveConditionsPageCC = followingNeurologicalConditions
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingDigestiveConditionsPageCC());

        BoneOrJointConditionsPageCC boneOrJointConditionsPageCC = followingDigestiveConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageCC());

        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = boneOrJointConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageCC());

        WhenYouDiagnosedWithRaGmegaPageCC whenYouDiagnosedWithRaGmegaPageCC = whatKindOfArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageCC());

        whenYouDiagnosedWithRaGmegaPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageCC)
                .waitForPageLoad2()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad5(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoadGMEGA()
                .clickNextButton(new Regular_WarmTransfer1())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WarmTransferGmegaPageCC());
                WarmTransferGmegaPageCC warmTransferGmegaPageCC = new WarmTransferGmegaPageCC();
                    if(env.equals("QA")){
                        warmTransferGmegaPageCC.waitForPageLoad();
                    }
                    else {
                        warmTransferGmegaPageCC.waitForPageLoadPRD();
                    }
        warmTransferGmegaPageCC
                .clickOnAnswer("No: Ok - we will send their RPA over within the next 24 hours and you can review their qualifications at a more convenient time. Their name is (Patient Name)")
                .clickOnAnswer("[site not available]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
//        if(env.equals("QA")){
//            selectActionPageCC
//                .getRadiantDbToLog(env, studyReferenceSql);
//        }
    }
}
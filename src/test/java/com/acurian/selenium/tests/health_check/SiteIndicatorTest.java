package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.gmega.WhenYouDiagnosedWithRaGmegaPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class SiteIndicatorTest extends BaseTest {

    @Test(enabled = true)
    @Description("Site Indicator Test, yellow mark check")
    public void siteIndicatorTest() {
        String phoneNumber = "AUTGMEGA01";
        String siteName = "AUT_GEMGA_01A";
        String zipCode = "19422";
        String env = System.getProperty("acurian.env", "STG");
        String studyName = env.equals("QA") ?
         "Arthritis,a low back pain study,a rheumatoid arthritis (RA) study" :
         "Arthritis, a low back pain study, a rheumatoid arthritis (RA) study";

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:",
                "Title text is diff");
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
                .clickBeginButton()
                .activateDebugOnProd(env);

        DateOfBirthPageCC dateOfBirthPageCC = new DateOfBirthPageCC();
        dateOfBirthPageCC
                .waitForPageLoadGmega("a rheumatoid arthritis (RA) study", "625");

//        Assert.assertEquals(dateOfBirthPageCC.getQuestionTextIBD(), dateOfBirthPageCC.titleExpectedGmemga,
//                "Title is diff");

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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        zipCode)
                .clickNextButton(new GenderPageCC());

        ApproximateHeightPageCC approximateHeightPageOLS = genderPageCC
                .waitForPageLoadByTitle(genderPageCC.titleExpected3)
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
                .assertTestSiteIndicator(siteName);
    }
}
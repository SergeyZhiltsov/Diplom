package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.RA_2821.WhenYouDiagnosedWithRaPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer1;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.gmega.WarmTransferGmegaPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class RadiantWTtest extends BaseTest {

    @Test(enabled = true)
    @Description("WT for RA , wt + 41C = directSchedule")
    public void warmTransferFor41CTest() {
        String phoneNumber = "AUTGMEGA01";
//        String studyName = "an osteoarthritis study";
        String siteName = "AUT_GRA_WT_site";//AUT_GOA3_2108_Site
        String zipCode = "08204";
        String env = System.getProperty("acurian.env", "STG");
        String studyName = env.equals("QA") ?
                "an osteoarthritis study" : "Arthritis, a low back pain study, a rheumatoid arthritis (RA) study";

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleGmega3RAexpected, "Title is diff");
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        ApproximateHeightPageCC approximateHeightPageOLS = genderPageCC
                .waitForPageLoadGmega()
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

        WhatKindOfArthritisCC whatKindOfArthritisCC = boneOrJointConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisCC());

        WhenYouDiagnosedWithRaPageCC whenYouDiagnosedWithRaPageCC = whatKindOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageCC());

        whenYouDiagnosedWithRaPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageCC)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoadGmega(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new Regular_WarmTransfer1())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WarmTransferGmegaPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Successful transfer made to site")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

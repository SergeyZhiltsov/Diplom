package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.RA_2821.WhenYouDiagnosedWithRaPageCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.pediatric.HSCrohns2PageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class HelloSignCC extends BaseTest {

    @Test
    @Description("Hello sign CC")
    public void helloSignCCtest() {
        final String phoneNumber = "GMEGA30003";
        String studyName = "a rheumatoid arthritis (RA) study";
        String siteName = "AUT_GRA1_Site";
        String zipCode = "19901";
        String env = System.getProperty("acurian.env", "STG");

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
                .typeStudyName("GMEGA3")
                .clickPopupStudy("GMEGA3")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        DateOfBirthPageCC dateOfBirthPageCC = new DateOfBirthPageCC();
        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleGmegaExpected, "Title is diff");
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        BoneOrJointConditionsPageCC boneOrJointConditionsPageCC = genderPageCC
                .waitForPageLoadGmega()
                .getPage(new CallCenterIntroductionPageCC())
                .activateDebugOnProd(env)
                .getPage(genderPageCC)
                .clickOnAnswerGmega("Female")
                .clickNextButton(new BoneOrJointConditionsPageCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = boneOrJointConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisCC());

        WhenYouDiagnosedWithRaPageCC whenYouDiagnosedWithRaPageCC = whatKindOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageCC());

        SiteSelectionPageCC siteSelectionPageCC = whenYouDiagnosedWithRaPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageCC)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC());

        if (env.equals("QA")) {
            siteSelectionPageCC.waitForPageLoad(studyName);
        } else {
            siteSelectionPageCC.waitForPageLoadGmega(studyName);
        }

        siteSelectionPageCC
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSCrohns2PageCC())
                .waitForPageLoadByTitle(new HSCrohns2PageCC().titleExpectedGmega)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoadGmega()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoadGmega()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

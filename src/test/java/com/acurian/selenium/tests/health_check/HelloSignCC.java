package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.gmega.WhenYouDiagnosedWithRaGmegaPageCC;
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
        Site site = Site.AUT_GRA1_Site;
        final String phoneNumber = "AUTGMEGA03"; //Indication RA
        String studyName = "a rheumatoid arthritis (RA) study";
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

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("GMEGA3")
                .clickPopupStudy("GMEGA3")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);

        DateOfBirthPageCC dateOfBirthPageCC = new DateOfBirthPageCC();
        dateOfBirthPageCC
                .waitForPageLoadGmega();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleGmega3RAexpected, "Title is diff");

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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = genderPageCC
                .waitForPageLoadByTitle(genderPageCC.titleExpected)
                .clickOnAnswer("Female")
                .clickNextButton(new WhatKindOfArthritisCC());

        WhenYouDiagnosedWithRaGmegaPageCC whenYouDiagnosedWithRaGmegaPageCC = whatKindOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageCC());

        BoneOrJointConditionsPageCC boneOrJointConditionsPageCC = whenYouDiagnosedWithRaGmegaPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new BoneOrJointConditionsPageCC());

        boneOrJointConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(identificationPageCC);

        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC());

        HSCrohns2PageCC hsCrohns2PageCC = siteSelectionPageCC
                .waitForPageLoadGmega(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new HSCrohns2PageCC());

        DoctorInformationCollectionPageCC doctorInformationCollectionPageCC = hsCrohns2PageCC
                .waitForPageLoadByTitle(hsCrohns2PageCC.titleExpectedGmegaQA)
                .clickNextButton(new DoctorInformationCollectionPageCC());

        HSMedicalRecordsPageCC hsMedicalRecordsPageCC = doctorInformationCollectionPageCC
                .waitForPageLoadByTitle(doctorInformationCollectionPageCC.titleExpectedGmega)
                .clickNextButton(new HSMedicalRecordsPageCC());

        ThankYouCloseSimplePageCC thankYouCloseSimplePageCC =  hsMedicalRecordsPageCC
                .waitForPageLoadByTitle(hsMedicalRecordsPageCC.titleExpectedGmegaSTG)
                .clickNextButton(new ThankYouCloseSimplePageCC());

        thankYouCloseSimplePageCC
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC);

        selectActionPageCC
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

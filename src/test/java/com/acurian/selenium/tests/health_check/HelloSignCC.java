package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.RA.WhenYouDiagnosedWithRaPageCC;
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
        final String phoneNumber = "AUTGMEGA03"; //Indication RA
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
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = genderPageCC
                .waitForPageLoad()
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
                .clickOnAnswer(siteName)
                .clickNextButton(new HSCrohns2PageCC());
        DoctorInformationCollectionPageCC doctorInformationCollectionPageCC = new DoctorInformationCollectionPageCC();
        ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = new ThankYouCloseSimplePageCC();
        HSMedicalRecordsPageCC hsMedicalRecordsPageCC = new HSMedicalRecordsPageCC();
        switch (env){
            case "QA":
                hsCrohns2PageCC
                        .waitForPageLoadByTitle(hsCrohns2PageCC.titleExpectedGmegaQA)
                        .clickNextButton(doctorInformationCollectionPageCC)
                        .waitForPageLoadByTitle(doctorInformationCollectionPageCC.titleExpectedGmega)
                        .clickNextButton(hsMedicalRecordsPageCC)
                        .waitForPageLoadByTitle(hsMedicalRecordsPageCC.titleExpectedGmegaSTG);

                break;
            case "STG":
                hsCrohns2PageCC
                        .waitForPageLoadByTitle(hsCrohns2PageCC.titleExpectedGmegaSTG)
                        .clickNextButton(doctorInformationCollectionPageCC)
                        .waitForPageLoadByTitle(doctorInformationCollectionPageCC.titleExpectedGmega)
                        .clickNextButton(hsMedicalRecordsPageCC)
                        .waitForPageLoadByTitle(hsMedicalRecordsPageCC.titleExpectedGmegaSTG);
                break;
            case "PRD":
                hsCrohns2PageCC.waitForPageLoadByTitle(hsCrohns2PageCC.titleExpectedGmegaPRD)
                        .clickNextButton(doctorInformationCollectionPageCC)
                        .waitForPageLoadByTitle(doctorInformationCollectionPageCC.titleExpectedGmegaPRD)
                        .clickNextButton(hsMedicalRecordsPageCC)
                        .waitForPageLoadByTitle(hsMedicalRecordsPageCC.titleExpectedGmega);
                break;
        }
        hsMedicalRecordsPageCC
                .clickNextButton(thankYouCloseSimplePageCC)
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC);
        selectActionPageCC
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

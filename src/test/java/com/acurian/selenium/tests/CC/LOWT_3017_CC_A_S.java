package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class LOWT_3017_CC_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_LOWT_3017S_Site},
                //{Site.AUT_LOWT_3017_Site} //deactivated in R55
        };
    }

    @Test(dataProvider = "sites")
    @Description("LOWT_3017_CC_A_S")
    public void lowTcc(Site site) {
        String phoneNumber = "AUTAMSLOWT";
        List<String> protocols = Arrays.asList("M16_100", "R727_CL_1532");
        String protocol1 = "M16_100";
        String protocol2 = "M16_100_S";
//        String esperionProtocol = "1002_043";    //Deactivate 3140 Esperion HC & CVD (all protocols: 1002-043_A & 1002-043)
//        String esperionProtocolA = "1002_043_A"; //R74	74.0	6/21/2019 & 6/24/2019
        String kowaProtocolA = "K_877_302_A";
        String kowaProtocolS = "K_877_302_S";
        String studyName = "a high cholesterol and heart disease";
        String siteIndication = "low testosterone or hypogonadism";

        String env = System.getProperty("acurian.env", "STG");
        DebugPageCC debugPageCC = new DebugPageCC();

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),
                "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());


        dateOfBirthPageCC
                .waitForPageLoad();

        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                .getExpectedModifiedTitle("a study", "600"), "Title is diff");

        dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        dateOfBirthPageCC //Disqualify (“Age < 18 years old”) if <18
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC())
                .waitForPageLoad()
                .back();
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                genderPageCC
                        .waitForPageLoad()
                        .setMonth("Apr")
                        .setDay("5")
                        .setYear("1938")
                        .clickOnAnswer("Male")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", protocol2)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1975")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", protocol2)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1960")
                .clickOnAnswer("Female")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", protocol2)
                .back();
        PersonaQuestionsCC personaQuestionsCC = genderPageCC
                .waitForPageLoad()
                .setYear("1941")
                .clickOnAnswer("Male")
                .clickNextButton(new PersonaQuestionsCC());

//new Intro
//        dateOfBirthPageCC
//                .waitForPageLoad2Ver();
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
//                ("a study", "600"), "Title is diff");
//        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
////                .setMonth("Sep")
////                .setDay("9")
////                .setYear("1940")
////                .clickOnAnswer("Yes")
//                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
//                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
//                .clickNextButton(new ZipCodePageCC());
//
//        zipCodePageCC
//                .waitForPageLoad();
//        GenderPageCC genderPageCC = zipCodePageCC
//                .typeZipCode("19044")
//                .clickNextButton(new GenderPageCC());
//
//        genderPageCC
//                .waitForPageLoad();
//
//        DebugPageCC debugPageCC = new DebugPageCC();
//
//        PersonaQuestionsCC personaQuestionsCC = genderPageCC
//                .setMonth("Sep")
//                .setDay("9")
//                .setYear("1941")
//                .clickNextButton(new PersonaQuestionsCC());


//        DebugPageCC debugPageCC = new DebugPageCC();
//        LoginPageCC loginPageCC = new LoginPageCC();
//        loginPageCC
//                .openPage(env)
//                .waitForPageLoad();
//        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
//        SelectActionPageCC selectActionPageCC = loginPageCC
//                .typeUsername(Properties.getUsername())
//                .typePassword(Properties.getPassword())
//                .clickLoginButton();
//
//        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
//                .waitForPageLoad()
//                .typeStudyName("AMS1")
//                .clickPopupStudy("AMS1")
//                .typePhoneNumber(phoneNumber)
//                .clickPopupPhoneNumber(phoneNumber)
//                .clickBeginButton();
//
//        callCenterIntroductionPageCC
//                .waitForPageLoad();
//        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
//        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
//                .activateDebugOnProd(env)
//                .clickOnAnswer("Learn more about matching to clinical trials")
//                .clickNextButton(new DateOfBirthPageCC());
//
//        dateOfBirthPageCC
//                .waitForPageLoad2Ver();
//        Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleExpectedLOWT, "Title is diff");
//        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
//                .setMonth("Sep")
//                .setDay("9")
//                .setYear("1990")
//                .clickOnAnswer("Yes")
//                .clickNextButton(new ZipCodePageCC());
//        zipCodePageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
//                .back(dateOfBirthPageCC)
//                .waitForPageLoad2Ver()
//                .setYear("1941")
//                .clickNextButton(zipCodePageCC);
//
//        GenderPageCC genderPageCC = zipCodePageCC
//                .waitForPageLoad()
//                .typeZipCode(site.zipCode)
//                .clickNextButton(new GenderPageCC());

//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = genderPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Male")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

//        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsEquals("This part of the questionnaire requires that we ask about your gender. To confirm, please tell me, i...", protocol1, protocol2)
//                .back();

//        PersonaQuestionsCC personaQuestionsCC = genderPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Male")
//                .clickNextButton(new PersonaQuestionsCC());

        ExperiencedAnyOfFollowingCC experiencedAnyOfFollowingCC = personaQuestionsCC
                .waitForPageLoad()
                .clickNextButton(new ExperiencedAnyOfFollowingCC());

        DiagnosedYouWithLowTestosteroneCC diagnosedYouWithLowTestosteroneCC = experiencedAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DiagnosedYouWithLowTestosteroneCC());
        diagnosedYouWithLowTestosteroneCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                //      .checkProtocolsEquals("Have you experienced any of the following? Agent Note: Select all that applyHave you experienced any...", protocol1, protocol2);
                .checkProtocolsContainsForQNumber("QS5616", protocol2);

        ApproximateHeightPageCC approximateHeightPageCC = diagnosedYouWithLowTestosteroneCC
                .clickOnAnswer("Yes")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .back(diagnosedYouWithLowTestosteroneCC)
                .waitForPageLoad()
                .back();


//        cardiovascularDiseaseThanOthersPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("High cholesterol or high triglycerides")
//                .clickNextButton(approximateHeightPageCC)
//                .waitForPageLoad()
//                .clickNextButton(cholesterolTriglyceridesLipidsPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS5632", kowaProtocolA, kowaProtocolS)
//                .checkProtocolsContainsForQNumber("QS6703", kowaProtocolA, kowaProtocolS)
//                .back(approximateHeightPageCC)
//                .waitForPageLoad()
//                .back();
//
//        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Diabetes or High Blood Sugar")
//                .clickNextButton(new WhatKindOfDiabetesPageCC());
//        approximateHeightPageCC
//                .waitForPageLoad()
//                .clickNextButton(whatKindOfDiabetesPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS5632", kowaProtocolA, kowaProtocolS)
//                .back(approximateHeightPageCC)
//                .waitForPageLoad()
//                .back();
//
//        WithType2DiabetesPageCC withType2DiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("High cholesterol or high triglycerides")
//                .clickNextButton(approximateHeightPageCC)
//                .waitForPageLoad()
//                .clickNextButton(whatKindOfDiabetesPageCC)
//                .waitForPageLoad()
//                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
//                .clickNextButton(new WithType2DiabetesPageCC());
//
//        withType2DiabetesPageCC
//                .waitForPageLoad()
//                .back(whatKindOfDiabetesPageCC)
//                .waitForPageLoad()
//                .back(approximateHeightPageCC)
//                .waitForPageLoad()
//                .back(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .back(diagnosedYouWithLowTestosteroneCC)
//                .waitForPageLoad()
//                .back(experiencedAnyOfFollowingCC);

        //module started
        experiencedAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("Decreased sexual desire or libido",
                        "Decreased spontaneous erections (e.g., morning erections)",
                        "Decreased energy or fatigue/feeling tired",
                        "Low mood or depressed mood",
                        "Loss of body (axillary and pubic) hair or reduced shaving",
                        "Hot flashes")
                .clickNextButton(diagnosedYouWithLowTestosteroneCC);

        LevelOrHypogonadismPageСС levelOrHypogonadismPageСС = diagnosedYouWithLowTestosteroneCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new LevelOrHypogonadismPageСС());
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);
//
//        LevelOrHypogonadismPageСС levelOrHypogonadismPageСС = cardiovascularDiseaseThanOthersPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Diabetes or High Blood Sugar",
//                        "High cholesterol or high triglycerides",
//                        "High blood pressure or hypertension",
//                        "Chronic Kidney Disease")
//                .clickNextButton(new LevelOrHypogonadismPageСС());

        //EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = levelOrHypogonadismPageСС
        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = levelOrHypogonadismPageСС
                .waitForPageLoad()
                .clickOnAnswers("AndroGel", "Endoderm patch", "Fortesta gel", "Striant (testosterone buccal system)",
                        "Testim gel", "Other testosterone medication not on this list", "Unsure")
                .clickOnAnswers("Testosterone injection (Depo-Testosterone, Testosterone enanthate, Testosterone Cypionate, Delatestryl)",
                        "Clomiphene (brand name Serophene) or another anti-estrogen therapy")
                .clickOnAnswers("Axiron gel")
                .clickNextButton(new HeartOrBloodVesselPageCC());
//                .clickNextButton(new EverSmokedCigarettesPageCC());
//
//        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = everSmokedCigarettesPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("No, I never smoked")
//                .clickNextButton(new HeartOrBloodVesselPageCC());

        CardiovascularInterventionsOrSurgeriesPageCC cardiovascularInterventionsOrSurgeriesPageCC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital",
                        "Coronary Artery Disease (blockage in a heart vessel)",
                        "Peripheral Vascular Disease (for example a blockage in your leg vessel)",
                        "Amputation of a digit or limb due to Peripheral Vascular Disease")
                .clickOnAnswers("None of the above")
                .clickNextButton(new CardiovascularInterventionsOrSurgeriesPageCC());
        cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad()
                .back(heartOrBloodVesselPageCC)
                .waitForPageLoad();
        WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC =
                heartOrBloodVesselPageCC
                        .clickOnAnswers("Heart attack")
                        .clickNextButton(new WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC());

        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5622", protocol2)
                .back(whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5622", protocol2)
                .back(whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC)
                .waitForPageLoad()
                .back();

        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC
                .waitForPageLoad(1, whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC.titleExpected2)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5622", protocol2)
                .back();
        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC
                .waitForPageLoad(1, whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC.titleExpected2)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5622", protocol2)
                .back();
        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC.back();

        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"Mini-Stroke\"")
                .clickNextButton(whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC);
        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC
                .waitForPageLoad(1, whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC.titleExpected3)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5622", protocol2)
                .back();
        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC
                .waitForPageLoad(1, whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC.titleExpected3)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5622", protocol2)
                .back();
        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC.back();
        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC);
        whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC
                .waitForPageLoad(1, whenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC.titleExpected2)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC);

        HasDoctorEverDiagnosedMedicalCondDiseases_CC hasDoctorEverDiagnosedMedicalCondDiseases_CC = cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC())
                .waitForPageLoad();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC.back();
        cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad();
        ReceivedHeartProcedurePageCC receivedHeartProcedurePageCC = cardiovascularInterventionsOrSurgeriesPageCC
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                        "Coronary Artery Bypass Graft, also known as CABG, “cabbage”, or heart bypass surgery",
                        "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                        "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                .clickNextButton(new ReceivedHeartProcedurePageCC());

        receivedHeartProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(hasDoctorEverDiagnosedMedicalCondDiseases_CC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5624", protocol2)
                .back();
        receivedHeartProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(hasDoctorEverDiagnosedMedicalCondDiseases_CC);

        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad()
                .clickOnAnswers("History of Prostate or Breast Cancer")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5626", protocol2)
                .back();

        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Other cancer within the past 2 years (except skin cancer)")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5626", protocol2)
                .back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Sleep apnea that is not currently being treated")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5626", protocol2)
                .back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5626", protocol2)
                .back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        TransitionalStatementLowtPageCC transitionalStatementLowtPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("4", "0", "166")
                .clickNextButton(new TransitionalStatementLowtPageCC());
        transitionalStatementLowtPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5627", protocol2)
                .back();

        SiteSelectionPageCC selectionPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "6", "166")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a men's health study")
                .getPID();
        switch (site) {
            case AUT_LOWT_3017S_Site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
//                        .clickNextButton(new HSGeneralCC())
//                        .waitForPageLoad(siteIndication)
//                        .clickNextButton(new DoctorInformationCollectionPageCC())
//                        .waitForPageLoad()
//                        .clickNextButton(new HSMedicalRecordsPageCC())
//                        .waitForPageLoad()
                        .clickNextButton(new MedicalRecordsOptionPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue with medical records")
                        .clickNextButton(new DoctorInformationCollectionPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "04/05/1941", "US",
                                "Blue Bell, PA", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", env.equals("PRD") ? "aut3017test" : "123456A",
                                site.name, env.equals("PRD") ? "ABVCOVCAR100,ABVCOVCAR100H" : "ABVCOVCAR100")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env, "3017")
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_LOWT_3017_Site:
                selectionPageCC
                        .clickOnAnswer(site.name)
//                        .clickNextButton(new HSGeneralCC())
//                        .waitForPageLoad(siteIndication)
                        .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
//                        .clickNextButton(new HSMedicalRecordsPageCC())
//                        .waitForPageLoad()
                        .clickNextButton(new SynexusHealthyMindsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env, "3017")
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
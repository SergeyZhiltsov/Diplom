package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import com.acurian.selenium.pages.CC.closes.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.ThankYouForAnsweringCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LOWT.AreYouCurrentlyTakingAnyOfTheFollowingMedications_CC;
import com.acurian.selenium.pages.CC.LOWT.CurrentlyTakingFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.LOWT.DiagnosedYouWithLowTestosteroneCC;
import com.acurian.selenium.pages.CC.LOWT.ExperiencedAnyOfFollowingCC;
import com.acurian.selenium.pages.CC.LOWT.HasDoctorEverDiagnosedMedicalCondDiseases_CC;
import com.acurian.selenium.pages.CC.LOWT.HasDoctorEverDiagnosedYouWithMedicalCond_CC;
import com.acurian.selenium.pages.CC.LOWT.HaveDoctorEverDiagnosedYou_CC;
import com.acurian.selenium.pages.CC.LOWT.HaveYouEverSmokedCigarettes_CC;
import com.acurian.selenium.pages.CC.LOWT.HaveYouExpAnyOfFollowingHeartBlood_CC;
import com.acurian.selenium.pages.CC.LOWT.PersonaQuestionsCC;
import com.acurian.selenium.pages.CC.LOWT.WhenWasTheLastTimeYouReceivedHeartProcedure_CC;
import com.acurian.selenium.pages.CC.MDD_3159.WhenWasYourMostRecentHeartProcedureCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMensHealthConditionsCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC;
import com.acurian.selenium.pages.CC.shared.HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementLowT_CC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS;
import com.acurian.selenium.utils.DataProviderPool;

public class LowTS_3017S_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)

    public void lowts_3017_CC(final String username, final String password) {
        String phoneNumber = "AUTAMSLOWT";
        List<String> protocols = Arrays.asList("M16_100", "R727_CL_1532");
        String protocol1 = "M16_100";
        String protocol2 = "M16_100_S";
        String studyName = "a high cholesterol and heart disease";
        String siteName = "AUT_LOWT_3017S_Site";
        String site_Indication = "Hypogonadism";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad();
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //dateOfBirthPageCC.waitForPageLoad();
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1990")
                .clickNextButton(new ZipCodePageCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        dateOfBirthPageCC
                .waitForPageLoadAKC()
                .setYear("1960")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        debugPageCC.checkProtocolsEquals("This part of the questionnaire requires that we ask about your gender. To confirm, please tell me, i...", protocol1, protocol2);
        debugPageCC.back();
        PersonaQuestionsCC personaQuestionsCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new PersonaQuestionsCC());


        ExperiencedAnyOfFollowingCC experiencedAnyOfFollowingCC = personaQuestionsCC
                .waitForPageLoad()
                .clickNextButton(new ExperiencedAnyOfFollowingCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = experiencedAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        debugPageCC.checkProtocolsEquals("Have you experienced any of the following? Agent Note: Select all that applyHave you experienced any...", protocol1, protocol2);
        debugPageCC.back();
        DiagnosedYouWithLowTestosteroneCC diagnosedYouWithLowTestosteroneCC = experiencedAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("Decreased sexual desire or libido", "Decreased spontaneous erections (e.g., morning erections)", "Decreased energy or fatigue/feeling tired")
                .clickOnAnswers("Loss of body (axillary and pubic) hair or reduced shaving", "Hot flashes", "Low mood or depressed mood")
                .clickNextButton(new DiagnosedYouWithLowTestosteroneCC());

        HasDoctorEverDiagnosedYouWithMedicalCond_CC hasDoctorEverDiagnosedYouWithMedicalCond_CC = diagnosedYouWithLowTestosteroneCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithMedicalCond_CC());


        AreYouCurrentlyTakingAnyOfTheFollowingMedications_CC areYouCurrentlyTakingAnyOfTheFollowingMedications_CC = hasDoctorEverDiagnosedYouWithMedicalCond_CC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension",
                        "Chronic Kidney Disease")
                .clickNextButton(new AreYouCurrentlyTakingAnyOfTheFollowingMedications_CC());


        HaveYouEverSmokedCigarettes_CC haveYouEverSmokedCigarettes_CC = areYouCurrentlyTakingAnyOfTheFollowingMedications_CC
                .waitForPageLoad()
                .clickOnAnswers("AndroGel", "Endoderm patch", "Fortesta gel", "Striant (testosterone buccal system)", "Testim gel", "Other testosterone medication not on this list", "Unsure")
                .clickOnAnswers("Testosterone injection (Depo-Testosterone, Testosterone enanthate, Testosterone Cypionate, Delatestryl)", "Clomiphene (brand name Serophene) or another anti-estrogen therapy")
                .clickOnAnswers("Axiron gel")
                .clickNextButton(new HaveYouEverSmokedCigarettes_CC());


        HaveYouExpAnyOfFollowingHeartBlood_CC haveYouExpAnyOfFollowingHeartBlood_CC = haveYouEverSmokedCigarettes_CC
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new HaveYouExpAnyOfFollowingHeartBlood_CC());


        HaveDoctorEverDiagnosedYou_CC haveDoctorEverDiagnosedYou_CC = haveYouExpAnyOfFollowingHeartBlood_CC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital",
                        "Coronary Artery Disease (blockage in a heart vessel)",
                        "Peripheral Vascular Disease (for example a blockage in your leg vessel)",
                        "Amputation of a digit or limb due to Peripheral Vascular Disease")
                .clickOnAnswers("None of the Above")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        haveDoctorEverDiagnosedYou_CC.back();
        haveYouExpAnyOfFollowingHeartBlood_CC
                .waitForPageLoad();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouExpAnyOfFollowingHeartBlood_CC
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());


        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        haveYouExpAnyOfFollowingHeartBlood_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        haveYouExpAnyOfFollowingHeartBlood_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoadTIA()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoadTIA()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();
        haveYouExpAnyOfFollowingHeartBlood_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());


        HasDoctorEverDiagnosedMedicalCondDiseases_CC hasDoctorEverDiagnosedMedicalCondDiseases_CC = haveDoctorEverDiagnosedYou_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC())
                .waitForPageLoad();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC.back();
        haveDoctorEverDiagnosedYou_CC
                .waitForPageLoad();
        WhenWasTheLastTimeYouReceivedHeartProcedure_CC whenWasTheLastTimeYouReceivedHeartProcedure_CC = haveDoctorEverDiagnosedYou_CC
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                        "Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
                        "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                        "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                .clickNextButton(new WhenWasTheLastTimeYouReceivedHeartProcedure_CC());


        whenWasTheLastTimeYouReceivedHeartProcedure_CC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017037-QS5624-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whenWasTheLastTimeYouReceivedHeartProcedure_CC
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC());


        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad();
        ApproximateHeightPageCC approximateHeightPageCC = hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("History of Prostate or Breast Cancer")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Other cancer within the past 2 years (except skin cancer)")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Sleep apnea that is not currently being treated")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        TransitionStatementLowT_CC transitionStatementLowT_CC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("4", "0", "166")
                .clickNextButton(new TransitionStatementLowT_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0004980-QS5627-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "6", "166")
//                .clickNextButton(new ChildrenUnderPageCC())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a men's low testosterone study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
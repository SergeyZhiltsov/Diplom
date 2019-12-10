package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.PSO_456.DiagnosedWithPsoriasisCC;
import com.acurian.selenium.pages.CC.PsoriaticArthritis.EverReceivedAnyBiologicMedicationsPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose1PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.KAD_4631_OLS;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class KAD_4631_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "sites", dataProviderClass = KAD_4631_OLS.class)
    @Description("KAD 4631 Kiniksa Atopic Derm for CC")
    public void kad4631_CCTest(Site site) {
        String phoneNumber = "AUTAMS1KAD";
        String studyName = "an eczema (atopic dermatitis) study";
        String studyNameForTrans = "eczema, or atopic dermatitis";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageCC debugPageCC = new DebugPageCC();

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS,
                "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

//------------dateOfBirthPageCC----------------
        dateOfBirthPageCC
                .waitForPageLoad(studyName, "600");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle(studyName, "600"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .waitForPageLoad(studyName, "600")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new IdentificationPageCC());


        //------------PII Question------------
        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQCrohn()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new GenderPageCC());

        //-----------GenderPageCC-------------
        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC =
                genderPageCC
                        .waitForPageLoad()
                        .setMonth("Mar")
                        .setDay("2")
                        .setYear("1980")
                        .clickOnAnswer("Female")
                        .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        //------------Q2:  hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC----
        DiagnosedWithPsoriasisCC diagnosedWithPsoriasisCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithPsoriasisCC());

        diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back();

        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_CC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());
        HowMuchEczemaYouHaveOnYOurBody_CC howMuchEczemaYouHaveOnYOurBody_CC = new HowMuchEczemaYouHaveOnYOurBody_CC();
//        //Q3
////        HowMuchEczemaYouHaveOnYOurBody_CC howMuchEczemaYouHaveOnYOurBody_CC =
////                new HowMuchEczemaYouHaveOnYOurBody_CC();
////        List<String> disqualifyQ3 = Arrays.asList("2 months or less",
////                "3 - 6 months",
////                "7 - 11 months");
////        for (String answer : disqualifyQ3) {
////            System.out.println(answer);
////            howLongHaveYouBeenSufferingFromEczema_CC
////                    .waitForPageLoad()
////                    .clickOnAnswer(answer)
////                    .clickNextButton(howMuchEczemaYouHaveOnYOurBody_CC)
////                    .waitForPageLoad()
////                    .getPage(debugPageCC)
////                    //.checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
////                    .back();
////        }
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_CC);


        HowWouldYouDescribeTheEczemaCurrentlyPageCC howWouldYouDescribeTheEczemaCurrentlyPageCC =
                new HowWouldYouDescribeTheEczemaCurrentlyPageCC();
        List<String> disqualifyQ4 = Arrays.asList("0", "1", "2", "3", "4", "5");
        for (String answer : disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            howMuchEczemaYouHaveOnYOurBody_CC
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5832", site.activeProtocols)
                    .back();
        }
//-----------STATUS SET validation:  PATIENT_PRIORITY_YES = 8 14 -------------
        List<String> studyLevelStatus = Arrays.asList("13", "14", "15", "16", "17", "18", "19", "20");
        for (String answer : studyLevelStatus) {
            System.out.println("Select answer to get study level status logic for Q4: " + answer);
            howMuchEczemaYouHaveOnYOurBody_CC
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    //.checkStudyStatusContainsForQNumber("QS5832", env.equals("PRD") ? "12-18" : "8-14")
                    .back();
        }
        howMuchEczemaYouHaveOnYOurBody_CC
                .waitForPageLoad()
                .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageCC);


        //---------------------------------------------QS24 DQ, Go to QS25---------------------------------------------
        HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC haveYouTriedAnyFollowingTreatmentsForEczemaPageCC = howWouldYouDescribeTheEczemaCurrentlyPageCC
                .waitForPageLoad()
                .clickOnAnswer("None: Skin is completely clear / eczema is not active now")
                .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC());
        haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
                .back();

        howWouldYouDescribeTheEczemaCurrentlyPageCC
                .waitForPageLoad()
                .clickOnAnswer("Minor: Mostly clear or almost clear")
                .clickOnAnswer("Mild: Covers a small amount of total skin on my body")
                .clickOnAnswer("Moderate: Covers a medium amount of total skin on my body")
                .clickOnAnswer("Severe: Covers a large amount of total skin on my body")
                .clickNextButton(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC);


//        HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC haveYouTriedAnyFollowingTreatmentsForEczemaPageCC =
//                howManyDaysHasSkinBeenItchyCC
//                        .waitForPageLoad()
//                        .clickOnAnswer("1 - 2 days")
//                        .clickOnAnswer("3 - 4 days")
//                        .clickOnAnswer("5 - 6 days")
//                        .clickOnAnswer("My skin is itchy every day")
//                        .clickOnAnswer("My skin is never itchy")
//                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC());

//        //Q26
//        RateAverageItchinessEczemaPageCC rateAverageItchinessEczemaPageCC = howManyDaysHasSkinBeenItchyCC
//                .waitForPageLoad()
//                .clickOnAnswer("My skin is itchy every day")
//                .clickNextButton(new RateAverageItchinessEczemaPageCC());
//        //Q27
//        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = rateAverageItchinessEczemaPageCC
//                .waitForPageLoad()
//                .selectFromDropDown("2")
//                .clickNextButton(new EczemaSymptomsExperienceCC());
//        //Q28
//        HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC haveYouTriedAnyFollowingTreatmentsForEczemaPageCC =
//                eczemaSymptomsExperienceCC
//                        .waitForPageLoad()
//                        .clickOnAnswers("Redness",
//                                "Swelling",
//                                "Oozing/Crusting",
//                                "Dryness",
//                                "Scratch marks",
//                                "Skin thickening")
//                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC());
        //Q27
        SatisfiedEczemaTreatmentsCC satisfiedEczemaTreatmentsCC = haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                .waitForPageLoad()
                .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
                        "Medications taken by mouth (oral medications)",
                        "Shots or IV infusions (injectable medications)",
                        "Self-treatment with tanning beds or sunbathing",
                        "Phototherapy (Ultraviolet or UV light treatment)")
                .clickNextButton(new SatisfiedEczemaTreatmentsCC());


        AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC =
                satisfiedEczemaTreatmentsCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickOnAnswer("No")
                        .clickOnAnswer("I am not using any treatments right now")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC());

        //Q31F
        DupixentInjectionPageCC dupixentInjectionPageCC =
                areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes") //Disqualify (“Current biologic use”)
                        .clickNextButton(new DupixentInjectionPageCC());
        dupixentInjectionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5850", site.activeProtocols)
                .back(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(dupixentInjectionPageCC);

        //Q32
//        DupixentInjectionPageCC dupixentInjectionPageCC = currentlyTakingFollowingMedicationsCC
//                .waitForPageLoad()
//                .clickOnAnswers("Cosentyx (Agent Note: co-SEN-tix)", "Fasenra (Agent Note: fa-SEN-ra)",
//                        "Nucala (Agent Note: new-CA-la)", "Otezla (Agent Note: oh-TEZ-la)")
//                .clickNextButton(new DupixentInjectionPageCC());

        //Q33
//        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC =
        TransitionStatementCC transitionStatementCC = dupixentInjectionPageCC
                .waitForPageLoad()
                .clickOnAnswer("No, never took")
//                .clickNextButton(new HaveYouEverTakenEitherAnyOfFollowingMeds_CC());
//
//        //Q34
//        TransitionStatementCC transitionStatementCC = haveYouEverTakenEitherAnyOfFollowingMeds_CC
//                        .waitForPageLoad()
//                        .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)",
//                                "Olumiant (Agent Note: oh-LOO-me-ant)",
//                                "Xeljanz (Agent Note: ZEL-jans)")
                .clickNextButton(new TransitionStatementCC());
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                transitionStatementCC
                        .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        //-------------------New GENERAL HEALTH---------------------------
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        KidneyProblemsPage kidneyProblemsPage = subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageСС())
                .waitForPageLoad()
                .back(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage)
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());

        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .back();

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WomenHealthConditionsCC())
                .clickOnAnswers("Endometriosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageCC());

        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "10", "120")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(letMeSeePageCC);

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                //.clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4631")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
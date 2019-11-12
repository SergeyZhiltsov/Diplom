package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CurrentlyTakingFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.LPS_4442.EitherOfFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.Obesity_4605.ExperienceExcessiveHungerOrIncreasedAppetiteOLS;
import com.acurian.selenium.pages.OLS.PS_4656.HealthcareDiagnosedPsoriasisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class KAD_4631_OLS extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "sites")
    public Object[][] getData() {
        return new Object[][] {
                {Site.AUT_DERM_4631_Site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("4631 Kiniksa Atopic Derm for OLS")
    public void kad4631olsTest(Site site) {
        String phoneNumber = "AUTAMS1KAD";
        String studyName = "an eczema (atopic dermatitis)";
        String env = System.getProperty("acurian.env", "STG");

        String eMailId = "qa.acurian@gmail.com";

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"),
                "Title is diff");

        PersonalDetails personalDetails = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", eMailId, "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS =
                genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS =
                hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());
        healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back();

        HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_OLS =
                hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());

        IfYouUseYourHandToCoverAllOfTheEczema_OLS ifYouUseYourHandToCoverAllOfTheEczema_OLS = new IfYouUseYourHandToCoverAllOfTheEczema_OLS();
        List<String> disqualifyQ3 = Arrays.asList("2 months or less", "3 - 6 months", "7 - 11 months");
        for (String answer: disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            howLongHaveYouBeenSufferingFromEczema_OLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(ifYouUseYourHandToCoverAllOfTheEczema_OLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                    .back();
        }
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
                .clickNextButton(ifYouUseYourHandToCoverAllOfTheEczema_OLS);

        HowWouldYouDescribeTheEczemaCurrentlyPageOLS howWouldYouDescribeTheEczemaCurrentlyPageOLS =
                new HowWouldYouDescribeTheEczemaCurrentlyPageOLS();
        List<String> disqualifyQ4 = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        for (String answer : disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            ifYouUseYourHandToCoverAllOfTheEczema_OLS
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5832", site.activeProtocols)
                    .back();
        }
//-----------STATUS SET validation:  PATIENT_PRIORITY_YES = 8 14 -------------
        List<String> studyLevelStatus = Arrays.asList("13", "14", "15", "16", "17", "18", "19", "20");
        for (String answer : studyLevelStatus) {
            System.out.println("Select answer to get study level status logic for Q4: " + answer);
            ifYouUseYourHandToCoverAllOfTheEczema_OLS
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkStudyStatusContainsForQNumber(env.equals("PRD") ? "12-18" : "8-14")
                    .back();
        }

        ifYouUseYourHandToCoverAllOfTheEczema_OLS
                .waitForPageLoad()
                .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS);


        //---------------------------------------------QS24 DQ, Go to QS25---------------------------------------------
        HowManyDaysHasSkinBeenItchyOLS howManyDaysHasSkinBeenItchyOLS = howWouldYouDescribeTheEczemaCurrentlyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("None: Skin is completely clear / eczema is not active now")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyOLS());
        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
                .back();

        howWouldYouDescribeTheEczemaCurrentlyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Minor: Mostly clear or almost clear")
                .clickOnAnswer("Mild: Covers a small amount of total skin on my body")
                .clickOnAnswer("Moderate: Covers a medium amount of total skin on my body")
                .clickOnAnswer("Severe: Covers a large amount of total skin on my body")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);


        HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS =
                howManyDaysHasSkinBeenItchyOLS
                        .waitForPageLoad()
                        .clickOnAnswer("1 - 2 days")
                        .clickOnAnswer("3 - 4 days")
                        .clickOnAnswer("5 - 6 days")
                        .clickOnAnswer("My skin is itchy every day")
                        .clickOnAnswer("My skin is never itchy")
                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());

//        //------------------------------------------------------QS25----------------------------------------------------
//        HowManyDaysHasSkinBeenItchyOLS howManyDaysHasSkinBeenItchyOLS = haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HowManyDaysHasSkinBeenItchyOLS());
//
//        howManyDaysHasSkinBeenItchyOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
//                .back();
//
//        haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Eczema that covers a medium to large amount of total skin on my body",
//                        "Eczema that looks red or dark red",
//                        "Eczema that feels very or intensely itchy and scratchy")
//                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);
//
//        howManyDaysHasSkinBeenItchyOLS
//                .waitForPageLoad()
//                .back(haveYouEverHadAnyOfTheFollowingSymptomsPageOLS)
//                .back();
//
//        //--------------------------------QS24 Q, Skip to QS26 "How many days ... itchy?--------------------------------
//        howWouldYouDescribeTheEczemaCurrentlyPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Severe: Covers a large amount of total skin on my body")
//                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);
//
//        //-----------------------------------------------------QS26-----------------------------------------------------
//        EczemaSymptomsExperienceOLS eczemaSymptomsExperienceOLS = howManyDaysHasSkinBeenItchyOLS
//                .waitForPageLoad()
//                .clickOnAnswer("My skin is never itchy")
//                .clickNextButton(new EczemaSymptomsExperienceOLS());
//
//        eczemaSymptomsExperienceOLS
//                .waitForPageLoad()
//                .back();
//
//        RateAverageItchinessEczemaPageOLS rateAverageItchinessEczemaPageOLS = howManyDaysHasSkinBeenItchyOLS
//                .waitForPageLoad()
//                .clickOnAnswer("1 - 2 days")
//                .clickNextButton(new RateAverageItchinessEczemaPageOLS());
//        rateAverageItchinessEczemaPageOLS
//                .waitForPageLoad()
//                .selectFromDropDown("2")
//                .clickNextButton(eczemaSymptomsExperienceOLS);
//
//        HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS =
//                eczemaSymptomsExperienceOLS
//                        .waitForPageLoad()
//                        .clickOnAnswers("Redness",
//                                "Swelling",
//                                "Oozing/Crusting",
//                                "Dryness",
//                                "Scratch marks",
//                                "Skin thickening")
//                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());

        SatisfiedEczemaTreatmentsOLS satisfiedEczemaTreatmentsOLS = haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
                                "Medications taken by mouth (oral medications)",
                                "Shots or IV infusions (injectable medications)",
                                "Self-treatment with tanning beds or sunbathing",
                                "Phototherapy (Ultraviolet or UV light treatment)")
                        .clickNextButton(new SatisfiedEczemaTreatmentsOLS());


        AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS =
                satisfiedEczemaTreatmentsOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickOnAnswer("No")
                        .clickOnAnswer("I am not using any treatments right now")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS());

        //-------------------------------------QS31 "biologics" with radiobuttons -------------------------------------
        DupixentInjectionPageOLS dupixentInjectionPageOLS = areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new DupixentInjectionPageOLS());
        dupixentInjectionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5850", site.activeProtocols)
                .back();


        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(dupixentInjectionPageOLS);

//        DupixentInjectionPageOLS dupixentInjectionPageOLS=
//                currentlyTakingFollowingMedicationsOLS
//                        .waitForPageLoad()
//                        .clickOnAnswers("Cosentyx",
//                                "Fasenra",
//                                "Nucala",
//                                "Otezla")
//                        .clickNextButton(new DupixentInjectionPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                dupixentInjectionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, currently taking")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
//        eitherOfFollowingMedicationsOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Jakafi",
//                        "Olumiant",
//                        "Xeljanz")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        CancerPage cancerPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new CancerPage());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = cancerPage
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        cancerPage
                .waitForPageLoad()
                .back();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());


        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageOLS())
                .waitForPageLoad()
                .back(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        List<String> disqualifyQS51 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer: disqualifyQS51) {
            System.out.println("Select answer for QS51: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .back();

        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        List<String> disqualifyQS53 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer: disqualifyQS53) {
            System.out.println(answer);
            followingMentalEmotionalHealthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        List<String> disqualifyQS59 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis", "Drug or alcohol abuse within the past year", "Hepatitis B", "Hepatitis C", "HIV or AIDS");
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        for (String answer: disqualifyQS59) {
            System.out.println(answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQS61 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer: disqualifyQS61) {
            System.out.println(answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "10", "120") //BMI 17.25
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());
        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();

        ExperienceExcessiveHungerOrIncreasedAppetiteOLS experienceExcessiveHungerOrIncreasedAppetiteOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setFeatwithClear("4")
                .setIncheswithClear("5")
                .setLbs("188") //BMI=47.15, proceed to Obesity module
                .clickNextButton(new ExperienceExcessiveHungerOrIncreasedAppetiteOLS());
        experienceExcessiveHungerOrIncreasedAppetiteOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setFeatwithClear("5")
                .setLbs("160")
                .clickNextButton(new IdentificationPageOLS());


        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());


        QualifiedClose1PageOLS qualifiedClose1PageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS());


        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose1PageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS());


        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());


        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4631")
                .dispoShouldMatch(site.dispo, site.dispo)
                .assertGeneratedFul(env, site);
    }
}
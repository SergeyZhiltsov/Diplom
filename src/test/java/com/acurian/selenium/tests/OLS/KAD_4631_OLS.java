package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.LessThan18YearsOldPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAD_4631_OLS extends BaseTest {

    @Test(enabled = true)
    @TestCaseId("00002")
    @Description("KAD 4631 for OLS")
    public void kad_4631() {
        Site site = Site.AUT_DERM_4631_Site;
        String phoneNumberMIG = "AUTAMS1KAD";
        String studyName = "an eczema (atopic dermatitis)";
        String env = System.getProperty("acurian.env", "STG");

        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .setDate("09092003")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols);
        debugPageOLS.back();
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("09091951")
                .clickNextButton(new PersonalDetails());
        personalDetails.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols);
        debugPageOLS.back();
        dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickNextButton(new PersonalDetails());


        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", eMailId, "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back();
        HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_OLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());


        WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS = howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months")
                .clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());
        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5803", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 to less than 6 months")
                .clickNextButton(whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5803", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("6 to less than 12 months")
                .clickNextButton(whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5803", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 years or more")
                .clickNextButton(whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS);


        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of these")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5805", site.activeProtocols)
                .back();
        WeWantToMakeSureTheImagesDisplayProperly_OLS weWantToMakeSureTheImagesDisplayProperly_OLS = whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
                .waitForPageLoad()
                .clickOnAnswers("Head, face, and neck", "Chest, stomach, and back", "Arms and hands", "Legs and feet")
                .clickNextButton(new WeWantToMakeSureTheImagesDisplayProperly_OLS());


        WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS = weWantToMakeSureTheImagesDisplayProperly_OLS
                .waitForPageLoad()
                .clickOnAnswer("Computer or tablet")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS = whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS = whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS = whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS());

        HaveYouEverTreatedYourEczema_OLS haveYouEverTreatedYourEczema_OLS = whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new HaveYouEverTreatedYourEczema_OLS());

        haveYouEverTreatedYourEczema_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("B")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("C")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .back();
        whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS
                .waitForPageLoad()
                .back();
        whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS
                .waitForPageLoad()
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .back();
        weWantToMakeSureTheImagesDisplayProperly_OLS
                .waitForPageLoad()
                .back();
        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
                .waitForPageLoad()
                .clickOnAnswers("Chest, stomach, and back", "Arms and hands", "Legs and feet")
                .clickNextButton(weWantToMakeSureTheImagesDisplayProperly_OLS);


        weWantToMakeSureTheImagesDisplayProperly_OLS
                .waitForPageLoad()
                .clickOnAnswer("Computer or tablet")
                .clickNextButton(weWantToMakeSureTheImagesDisplayProperly_OLS);


        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("B")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("C")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("D")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("G")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back(whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS)
                .waitForPageLoad()
                .back(weWantToMakeSureTheImagesDisplayProperly_OLS)
                .waitForPageLoad()
                .back();

        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
                .waitForPageLoad()
                .clickOnAnswers("Legs and feet")
                .clickNextButton(weWantToMakeSureTheImagesDisplayProperly_OLS)
                .waitForPageLoad()
                .clickOnAnswer("Computer or tablet")
                .clickNextButton(whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS);

        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("D")
                .clickNextButton(whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS)
                .waitForPageLoad()
                .clickOnAnswer("C")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS);


        //--------------Q17- HaveYouEverTreatedYourEczema_OLS ----------
        haveYouEverTreatedYourEczema_OLS
                .waitForPageLoad();
        //-----------select NO to skip to Q19, otherwise goto Q18
        WhichofthefollowingMedicationsTherapies_OLS whichofthefollowingMedicationsTherapies_OLS = haveYouEverTreatedYourEczema_OLS
                .clickOnAnswer("No")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_OLS());
        whichofthefollowingMedicationsTherapies_OLS
                .waitForPageLoad()
                .back();
        haveYouEverTreatedYourEczema_OLS
                .waitForPageLoad();
        OverallHowWellDidTopicalMedicationYouTried_OLS overallHowWellDidTopicalMedicationYouTried_OLS = haveYouEverTreatedYourEczema_OLS
                .clickOnAnswer("Yes, within the past year")    //final selection
                .clickNextButton(new OverallHowWellDidTopicalMedicationYouTried_OLS());


        //--------------Q18- OverallHowWellDidTopicalMedicationYouTried_OLS ----------
        overallHowWellDidTopicalMedicationYouTried_OLS
                .waitForPageLoad()
                .clickOnAnswer("My symptoms went away completely")  //final selection
                .clickNextButton(whichofthefollowingMedicationsTherapies_OLS);

        //--------------Q19- whichofthefollowingMedicationsTherapies_OLS ----------
        BiologicMedications biologicMedications = whichofthefollowingMedicationsTherapies_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedications());
        biologicMedications
                .waitForPageLoadKAD()
                .back();
        DidYouReceiveAnyTherapiesPastYear_OLS didYouReceiveAnyTherapiesPastYear_OLS = whichofthefollowingMedicationsTherapies_OLS
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran (azathioprine)")
                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_OLS());

        //--------------Q20- DidYouReceiveAnyTherapiesPastYear_OLS ----------
        didYouReceiveAnyTherapiesPastYear_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(biologicMedications);

        //---------Q22:  BiologicMedications---------------
        HaveYouEverTakenEitherAnyOfFollowingMeds_OLS haveYouEverTakenEitherAnyOfFollowingMeds_ols = new HaveYouEverTakenEitherAnyOfFollowingMeds_OLS();
        HashMap<String, List<String>> cases = new HashMap<>();
        cases.put("Actemra", Arrays.asList(site.activeProtocols));
        cases.put("Benlysta", Arrays.asList(site.activeProtocols));
        cases.put("Cimzia", Arrays.asList(site.activeProtocols));
        cases.put("Cosentyx", Arrays.asList(site.activeProtocols));
        cases.put("Enbrel", Arrays.asList(site.activeProtocols));
        cases.put("Entyvio", Arrays.asList(site.activeProtocols));
        cases.put("Humira", Arrays.asList(site.activeProtocols));
        cases.put("Kineret", Arrays.asList(site.activeProtocols));
        cases.put("Orencia", Arrays.asList(site.activeProtocols));
        cases.put("Prolia or Xgeva", Arrays.asList(site.activeProtocols));
        cases.put("Raptiva", Arrays.asList(site.activeProtocols));
        cases.put("Remicade", Arrays.asList(site.activeProtocols));
        cases.put("Rituxan", Arrays.asList(site.activeProtocols));
        cases.put("Simponi", Arrays.asList(site.activeProtocols));
        cases.put("Stelara", Arrays.asList(site.activeProtocols));
        cases.put("Taltz", Arrays.asList(site.activeProtocols));
        cases.put("Tysabri", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : cases.entrySet()) {
            biologicMedications
                    .waitForPageLoadKAD()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_ols)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5821", (String[]) entry.getValue().toArray())
                    .back();
        }

        biologicMedications
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_ols);


        //------------Q23- HaveYouEverTakenEitherAnyOfFollowingMeds ----------------
        haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .waitForPageLoad()
                .clickOnAnswers("Jakafi")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad();

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
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"mini-stroke\"", "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
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

        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
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

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageOLS)
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS);
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        EthnicBackgroundPageOLS ethnicBackgroundPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "10", "120")
                .clickNextButton(new EthnicBackgroundPageOLS());
        ethnicBackgroundPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .setFeatwithClear("4")
                .setIncheswithClear("5")
                .setLbs("188")
                .clickNextButton(ethnicBackgroundPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .setFeatwithClear("5")
                .setLbs("160")
                .clickNextButton(ethnicBackgroundPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env);
    }
}
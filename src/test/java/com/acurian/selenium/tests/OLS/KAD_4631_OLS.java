package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.HaveYouEverTakenEitherAnyOfFollowingMeds_CC;
import com.acurian.selenium.pages.CC.generalHealth.WhenDiagnosedWithCancer;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.AgeUnqualifiedClose_OLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
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
        String phoneNumberMIG = "AUTAMS1KAD";
        String protocol1 = "KPL_716_C001";
        String studyName = "an eczema (atopic dermatitis)";
        String siteName = "AUT_DERM_4631_Site";
        String zipCode = "19901";
        String env = System.getProperty("acurian.env", "STG");

        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                .setDate("09092003")
                .clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1);
        debugPageOLS.back();
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("09091951")
                .clickNextButton(new PersonalDetails());
        personalDetails.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1);
        debugPageOLS.back();
        dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickNextButton(new PersonalDetails());


        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", eMailId, "9999999999", zipCode)
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
                .checkProtocolsContainsForQNumber("QS5802", protocol1)
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
                .checkProtocolsContainsForQNumber("QS5803", protocol1)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 to less than 6 months")
                .clickNextButton(whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5803", protocol1)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("6 to less than 12 months")
                .clickNextButton(whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5803", protocol1)
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
                .checkProtocolsContainsForQNumber("QS5805", protocol1)
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
                .checkProtocolsContainsForQNumber("QS5815", protocol1)
                .back();
        whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("B")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", protocol1)
                .back();
        whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("C")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", protocol1)
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
                .clickNextButton(new WeWantToMakeSureTheImagesDisplayProperly_OLS());


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
                .checkProtocolsContainsForQNumber("QS5815", protocol1)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("B")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", protocol1)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("C")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", protocol1)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("D")
                .clickNextButton(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", protocol1)
                .back();
        whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("G")
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
        cases.put("Actemra", Arrays.asList(protocol1));
        cases.put("Benlysta", Arrays.asList(protocol1));
        cases.put("Cimzia", Arrays.asList(protocol1));
        cases.put("Cosentyx", Arrays.asList(protocol1));
        cases.put("Enbrel", Arrays.asList(protocol1));
        cases.put("Entyvio", Arrays.asList(protocol1));
        cases.put("Humira", Arrays.asList(protocol1));
        cases.put("Kineret", Arrays.asList(protocol1));
        cases.put("Orencia", Arrays.asList(protocol1));
        cases.put("Prolia or Xgeva", Arrays.asList(protocol1));
        cases.put("Raptiva", Arrays.asList(protocol1));
        cases.put("Remicade", Arrays.asList(protocol1));
        cases.put("Rituxan", Arrays.asList(protocol1));
        cases.put("Simponi", Arrays.asList(protocol1));
        cases.put("Stelara", Arrays.asList(protocol1));
        cases.put("Taltz", Arrays.asList(protocol1));
        cases.put("Tysabri", Arrays.asList(protocol1));
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
                .checkProtocolsContainsForQNumber("QS42", protocol1)
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
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1), subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2), subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(3), subquestionExperiencedHeartPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(4), subquestionExperiencedHeartPageOLS.titleExpected4, "Title is diff");
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocol1)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocol1)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
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
                .checkProtocolsContainsForQNumber("QS60", protocol1)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .setFeatwithClear("4")
                .setIncheswithClear("5")
                .setLbs("188")
                .clickNextButton(ethnicBackgroundPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", protocol1)
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
                .clickOnFacilityName(siteName)
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
package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
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

public class DERM_7036_OLS extends BaseTest {

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
                {Site.AUT_AMS1_7036_Site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("DERM_7036_OLS")
    public void derm7036OLS(final Site site) {
        final String phoneNumber = "AUTAMSDERM";
        String studyName = "an eczema (atopic dermatitis)";
        DebugPageOLS debugPageOls = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "400"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .setDate("09092003")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("09091942")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());

        healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back(hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols);

        HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_OLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());

        HowMuchEczemaYouHaveOnYourBody_OLS howMuchEczemaYouHaveOnYourBody_ols = howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 months or less")
                .clickNextButton(new HowMuchEczemaYouHaveOnYourBody_OLS());
        howMuchEczemaYouHaveOnYourBody_ols
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(howMuchEczemaYouHaveOnYourBody_ols)
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months")
                .clickNextButton(howMuchEczemaYouHaveOnYourBody_ols)
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 years")
                .clickNextButton(howMuchEczemaYouHaveOnYourBody_ols);


        WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols = howMuchEczemaYouHaveOnYourBody_ols
                .waitForPageLoad()
                .selectFromDropDown("6")
                .clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());

        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols
                .waitForPageLoad()
                .clickOnAnswers("None of these")
                .clickNextButton(healthcareDiagnosedPsoriasisPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5805", site.activeProtocols)
                .back();
        WeWantToMakeSureTheImagesDisplayProperly_OLS weWantToMakeSureTheImagesDisplayProperly_OLS = whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols
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

        HowManyDaysHasSkinBeenItchyOLS howManyDaysHasSkinBeenItchyOLS = whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyOLS());

        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back(whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS)
                .waitForPageLoad()
                .clickOnAnswer("G")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);

        EczemaSymptomsExperienceOLS eczemaSymptomsExperienceOLS = howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new EczemaSymptomsExperienceOLS());

        HaveYouEverTreatedYourEczema_OLS haveYouEverTreatedYourEczema_OLS = eczemaSymptomsExperienceOLS
                .waitForPageLoad()
                .clickOnAnswers("Redness",
                        "Swelling",
                        "Oozing/Crusting",
                        "Dryness",
                        "Scratch marks",
                        "Skin thickening")
                .clickNextButton(new HaveYouEverTreatedYourEczema_OLS());

        WhichofthefollowingMedicationsTherapies_OLS whichofthefollowingMedicationsTherapies_ols = haveYouEverTreatedYourEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, within the past year")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_OLS());

        DidYouReceiveAnyTherapiesPastYear_OLS didYouReceiveAnyTherapiesPastYear_ols = whichofthefollowingMedicationsTherapies_ols
                .waitForPageLoad()
                .clickOnAnswers("Dupixent (dupilumab)")
                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_OLS());

        didYouReceiveAnyTherapiesPastYear_ols
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5827", site.activeProtocols)
                .back(whichofthefollowingMedicationsTherapies_ols);
        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols =
        whichofthefollowingMedicationsTherapies_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS());
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic") //Must ... in Q22 selected "Yes, within the past year"
                .back(whichofthefollowingMedicationsTherapies_ols)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes, but more than 1 year ago")
                .clickNextButton(whichofthefollowingMedicationsTherapies_ols)
                .waitForPageLoad()
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols)
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic")
                .back(whichofthefollowingMedicationsTherapies_ols)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_OLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(whichofthefollowingMedicationsTherapies_ols);
        whichofthefollowingMedicationsTherapies_ols
                .waitForPageLoad()
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols)
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5829", site.activeProtocols)
                .back(whichofthefollowingMedicationsTherapies_ols)
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran (azathioprine)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_ols);

        didYouReceiveAnyTherapiesPastYear_ols
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols);

        List<String> medications = Arrays.asList(
                "Actemra",
                "Benlysta",
                "Cimzia",
                "Cosentyx",
                "Enbrel",
                "Entyvio",
                "Humira",
                "Kineret",
                "Orencia",
                "Prolia or Xgeva",
                "Raptiva",
                "Remicade",
                "Rituxan",
                "Simponi",
                "Stelara",
                "Taltz",
                "Tysabri"
        );
        HaveYouEverTakenEitherAnyOfFollowingMeds_OLS haveYouEverTakenEitherAnyOfFollowingMeds_ols = new HaveYouEverTakenEitherAnyOfFollowingMeds_OLS();
        for (String medication : medications) {
            areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(medication)
                    .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_ols)
                    .waitForPageLoad()
                    .getPage(debugPageOls)
                    .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
                    .back();
        }
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_ols);

        haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .waitForPageLoad()
                .clickOnAnswers("Jakafi")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
                .back();
        haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Olumiant")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
                .back();
        haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xeljanz")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
                .back();
        haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS heartrelatedMedicalConditionsProceduresPageCC = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();

        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(heartrelatedMedicalConditionsProceduresPageCC);

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                                "Stroke",
                                "TIA or \"mini-stroke\"",
                                "Angina (heart-related chest pain) that required an overnight hospital stay",
                                "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected5);
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"More than 1 year ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageOLS);

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOls)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        List<String> diagnoses = Arrays.asList(
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS"
        );
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        for(String diagnose : diagnoses){
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOls)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }

        //EthnicBackgroundPageOLS ethnicBackgroundPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "7036")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
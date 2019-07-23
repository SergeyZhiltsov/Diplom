package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CurrentlyTakingFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.LPS_4442.EitherOfFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.PS_4656.HealthcareDiagnosedPsoriasisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class DERM_4825_OLS extends BaseTest {

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
                {Site.AUT_AMS1_4825_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("DERM_4825_OLS")
    public void derm4825Ols(final Site site) {
        final String phoneNumber = "AUTAMSDERM";
        String studyName = "an eczema (atopic dermatitis)";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols = genderPageOLS
                .waitForPageLoad()
                .setDate("04042001")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());

        healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
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
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(howMuchEczemaYouHaveOnYourBody_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months")
                .clickNextButton(howMuchEczemaYouHaveOnYourBody_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 years")
                .clickNextButton(howMuchEczemaYouHaveOnYourBody_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
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
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5805", site.activeProtocols)
                .back();
        //WeWantToMakeSureTheImagesDisplayProperly_OLS weWantToMakeSureTheImagesDisplayProperly_OLS =
        WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS =
                whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols
                .waitForPageLoad()
                .clickOnAnswers("Head, face, and neck", "Chest, stomach, and back", "Arms and hands", "Legs and feet")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS());

//        WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS = weWantToMakeSureTheImagesDisplayProperly_OLS
//                .waitForPageLoad()
//                .clickOnAnswer("Computer or tablet")
//                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS =
                whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS =
                whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS =
                whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS());

        HowManyDaysHasSkinBeenItchyOLS howManyDaysHasSkinBeenItchyOLS = whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyOLS());

        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5843", site.activeProtocols)
                .back(whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS)
                .waitForPageLoad()
                .clickOnAnswer("G")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);

        EczemaSymptomsExperienceOLS eczemaSymptomsExperienceOLS = howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new EczemaSymptomsExperienceOLS());

        eczemaSymptomsExperienceOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5837", site.activeProtocols)
                .back();

        RateAverageItchinessEczemaPageOLS rateAverageItchinessEczemaPageOLS = howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days")
                .clickNextButton(new RateAverageItchinessEczemaPageOLS());
        rateAverageItchinessEczemaPageOLS
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(eczemaSymptomsExperienceOLS);

        HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS =
                eczemaSymptomsExperienceOLS
                .waitForPageLoad()
                .clickOnAnswers("Redness",
                        "Swelling",
                        "Oozing/Crusting",
                        "Dryness",
                        "Scratch marks",
                        "Skin thickening")
                .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
                                "Medications taken by mouth (oral medications)",
                                "Shots or IV infusions (injectable medications)",
                                "Self-treatment with tanning beds or sunbathing",
                                "Phototherapy (Ultraviolet or UV light treatment)")
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Self-treatment with tanning beds or sunbathing",
                                "Phototherapy (Ultraviolet or UV light treatment)")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS5845", site.activeProtocols)
                        .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Shots or IV infusions (injectable medications)")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS());

        List<String> disqualifyQ29 = Arrays.asList("Actemra",
                "Benlysta",
                "Cimzia",
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
                "Tysabri");
        CurrentlyTakingFollowingMedicationsOLS currentlyTakingFollowingMedicationsOLS = new
                CurrentlyTakingFollowingMedicationsOLS();
        for (String answer: disqualifyQ29) {
            areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTakingFollowingMedicationsOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
                    .back();
        }
        DupixentInjectionPageOLS dupixentInjectionPageOLS = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cosentyx")
                .clickNextButton(new DupixentInjectionPageOLS());
        dupixentInjectionPageOLS
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
                .back();

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTakingFollowingMedicationsOLS);
        //Q30
        currentlyTakingFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Fasenra (benralizumab)",
                        "Nucala (mepolizumab)",
                        "Otezla (apremilast)")
                .clickNextButton(dupixentInjectionPageOLS);

        dupixentInjectionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, currently taking")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5847", site.activeProtocols)
                .back(dupixentInjectionPageOLS)
                .waitForPageLoad()
                .back(currentlyTakingFollowingMedicationsOLS)
                .waitForPageLoad()
                .back(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS)
                .waitForPageLoad()
                .back();

        EitherOfFollowingMedicationsOLS eitherOfFollowingMedicationsOLS =
                haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Medications taken by mouth (oral medications)")
                        .clickNextButton(currentlyTakingFollowingMedicationsOLS)
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new EitherOfFollowingMedicationsOLS());

        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Jakafi",
                        "Olumiant",
                        "Xeljanz")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


//        WhichofthefollowingMedicationsTherapies_OLS whichofthefollowingMedicationsTherapies_ols = haveYouEverTreatedYourEczema_OLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes, within the past year")
//                .clickNextButton(new WhichofthefollowingMedicationsTherapies_OLS());
//
//        DidYouReceiveAnyTherapiesPastYear_OLS didYouReceiveAnyTherapiesPastYear_ols = whichofthefollowingMedicationsTherapies_ols
//                .waitForPageLoad()
//                .clickOnAnswers("Dupixent (dupilumab)")
//                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_OLS());
//
//        didYouReceiveAnyTherapiesPastYear_ols
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5827", site.activeProtocols)
//                .back(whichofthefollowingMedicationsTherapies_ols);
//        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols =
//        whichofthefollowingMedicationsTherapies_ols
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS());
//        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic") //Must ... in Q22 selected "Yes, within the past year"
//                .back(whichofthefollowingMedicationsTherapies_ols)
//                .waitForPageLoad()
//                .back(haveYouEverTreatedYourEczema_OLS)
//                .waitForPageLoad()
//                .clickOnAnswer("Yes, but more than 1 year ago")
//                .clickNextButton(whichofthefollowingMedicationsTherapies_ols)
//                .waitForPageLoad()
//                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic")
//                .back(whichofthefollowingMedicationsTherapies_ols)
//                .waitForPageLoad()
//                .back(haveYouEverTreatedYourEczema_OLS)
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(whichofthefollowingMedicationsTherapies_ols);
//        whichofthefollowingMedicationsTherapies_ols
//                .waitForPageLoad()
//                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5829", site.activeProtocols)
//                .back(whichofthefollowingMedicationsTherapies_ols)
//                .waitForPageLoad()
//                .clickOnAnswers("Azasan or Imuran (azathioprine)")
//                .clickNextButton(didYouReceiveAnyTherapiesPastYear_ols);
//
//        didYouReceiveAnyTherapiesPastYear_ols
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols);
//
//        List<String> medications = Arrays.asList(
//                "Actemra",
//                "Benlysta",
//                "Cimzia",
//                "Cosentyx",
//                "Enbrel",
//                "Entyvio",
//                "Humira",
//                "Kineret",
//                "Orencia",
//                "Prolia or Xgeva",
//                "Raptiva",
//                "Remicade",
//                "Rituxan",
//                "Simponi",
//                "Stelara",
//                "Taltz",
//                "Tysabri"
//        );
//        HaveYouEverTakenEitherAnyOfFollowingMeds_OLS haveYouEverTakenEitherAnyOfFollowingMeds_ols = new HaveYouEverTakenEitherAnyOfFollowingMeds_OLS();
//        for (String medication : medications) {
//            areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(medication)
//                    .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_ols)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
//                    .back();
//        }
//        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_ols);
//
//        haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Olumiant")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
//                .waitForPageLoad()
//                .back();
//        haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Xeljanz")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
//                .waitForPageLoad()
//                .back();
//        haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .waitForPageLoad();
//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

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
                .clickOnAnswers("Cancer",
                "Heart or circulation problems (heart attack, heart failure, stroke)",
                "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                "Kidney disease",
                "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        //HaveYouEverExperiencedHeartRelatedMedicalCondOLS heartrelatedMedicalConditionsProceduresPageCC = otherThanSkinCancerPageOLS
        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                //.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS);


        HaveYouEverExperiencedHeartRelatedMedicalCondOLS heartrelatedMedicalConditionsProceduresPageOLS = whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());


        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = heartrelatedMedicalConditionsProceduresPageOLS
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
                .clickOnAnswerForSubQuestion(1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
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
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
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
                .getPage(debugPageOLS)
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
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }


        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "100")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "155")
                //----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
               // .clickNextButton(new SynexusHealthyMindsPageOLS())
               // .waitForPageLoad()
              //  .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4825")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CurrentlyTakingFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.LPS_4442.EitherOfFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.PS_4656.HealthcareDiagnosedPsoriasisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
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

public class DERM_4814_OLS extends BaseTest {

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
 //               {Site.AUT_AD4814_site},
                {Site.AUT_AD4814S_site}
        };
    }

    @Test(enabled = true, dataProvider = "sites")
    @Description("DERM_4814_OLS_test")
    public void derm4814olsTest(final Site site) {
        String phoneNumber = "AUTAMSDERM";
        String[] protocols = site.activeProtocols;
        String studyName = "an eczema (atopic dermatitis)";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"),
                "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());
        healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5802", protocols)
                .back();
        HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_ols = hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());

        HowMuchEczemaYouHaveOnYourBody_OLS howMuchEczemaYouHaveOnYourBody_ols = new HowMuchEczemaYouHaveOnYourBody_OLS();
        List<String> disqualifyQ3 = Arrays.asList("2 months or less", "3 - 6 months", "7 - 11 months", "1 year");
        for(String answer: disqualifyQ3) {
            System.out.println(answer);
            howLongHaveYouBeenSufferingFromEczema_ols
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howMuchEczemaYouHaveOnYourBody_ols)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                    .back();
        }
        IfYouUseYourHandToCoverAllOfTheEczema_OLS ifYouUseYourHandToCoverAllOfTheEczema_OLS =
                howLongHaveYouBeenSufferingFromEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_OLS());

        WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols =
                howMuchEczemaYouHaveOnYourBody_ols
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());

        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols
                .waitForPageLoad()
                .clickOnAnswers("None of these")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5805", protocols)
                .back();

        WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS =
        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols
                .waitForPageLoad()
                .clickOnAnswers("Head, face, and neck",
                        "Chest, stomach, and back",
                        "Arms and hands",
                        "Legs and feet")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS whichOfThesePicsLooksSimilarOnYourChestStomachBack_comp_ols =
                whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS whichOfThesePicsLooksSimilarOnYourArmsHands_comp_ols = 
                whichOfThesePicsLooksSimilarOnYourChestStomachBack_comp_ols
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS());

        WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS whichOfThesePicsLooksSimilarOnYourLegsFeet_comp_ols =
                whichOfThesePicsLooksSimilarOnYourArmsHands_comp_ols
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS());

        HowManyDaysHasSkinBeenItchyOLS howManyDaysHasSkinBeenItchyOLS = whichOfThesePicsLooksSimilarOnYourLegsFeet_comp_ols
                .waitForPageLoad()
                .clickOnAnswer("B")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyOLS());

        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5843", protocols)
                .back();

        whichOfThesePicsLooksSimilarOnYourLegsFeet_comp_ols
                .waitForPageLoad()
                .back(whichOfThesePicsLooksSimilarOnYourArmsHands_comp_ols)
                .waitForPageLoad()
                .back(whichOfThesePicsLooksSimilarOnYourChestStomachBack_comp_ols)
                .waitForPageLoad()
                .back(whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS)
                .waitForPageLoad()
                .back(whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols)
                .waitForPageLoad()
                .back(howMuchEczemaYouHaveOnYourBody_ols)
                .waitForPageLoad()
                .selectFromDropDown("21+")
                .clickNextButton(whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols)
                .waitForPageLoad()
                .clickNextButton(whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS)
                .waitForPageLoad()
                .clickNextButton(whichOfThesePicsLooksSimilarOnYourChestStomachBack_comp_ols)
                .waitForPageLoad()
                .clickNextButton(whichOfThesePicsLooksSimilarOnYourArmsHands_comp_ols)
                .waitForPageLoad()
                .clickNextButton(whichOfThesePicsLooksSimilarOnYourLegsFeet_comp_ols)
                .waitForPageLoad()
                .clickOnAnswer("E")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);
        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5843", protocols)
                .back();
        whichOfThesePicsLooksSimilarOnYourLegsFeet_comp_ols
                .waitForPageLoad()
                .clickOnAnswer("D")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);

        EczemaSymptomsExperienceOLS eczemaSymptomsExperienceOLS = howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new EczemaSymptomsExperienceOLS());

        RateAverageItchinessEczemaPageOLS rateAverageItchinessEczemaPageOLS = eczemaSymptomsExperienceOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5837", site.activeProtocols)
                .back(howManyDaysHasSkinBeenItchyOLS)
                .waitForPageLoad()
                .clickOnAnswer("My skin is itchy every day")
                .clickNextButton(new RateAverageItchinessEczemaPageOLS());

        //Q20
        rateAverageItchinessEczemaPageOLS
                .waitForPageLoad()
                .selectFromDropDown("0 - No itch")
                .clickNextButton(eczemaSymptomsExperienceOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5838", protocols)
                .back(rateAverageItchinessEczemaPageOLS)
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(eczemaSymptomsExperienceOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5838", protocols)
                .back(rateAverageItchinessEczemaPageOLS)
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(eczemaSymptomsExperienceOLS);

        HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS =
                eczemaSymptomsExperienceOLS
                .waitForPageLoad()
                .clickOnAnswers("None")
                .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());
        haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5835", protocols)
                .back(eczemaSymptomsExperienceOLS)
                .waitForPageLoad()
                .clickOnAnswers("Redness",
                        "Swelling",
                        "Oozing/Crusting",
                        "Dryness",
                        "Scratch marks",
                        "Skin thickening")
                .clickNextButton(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS);

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
                        .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Shots or IV infusions (injectable medications)")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS());

        DupixentInjectionPageOLS dupixentInjectionPageOLS = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS
                .waitForPageLoad()
                .clickOnAnswers("Actemra",
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
                "Tysabri")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cosentyx")
                .clickNextButton(new DupixentInjectionPageOLS());
        CurrentlyTakingFollowingMedicationsOLS currentlyTakingFollowingMedicationsOLS = dupixentInjectionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
                .back(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Actemra")
                .clickNextButton(new CurrentlyTakingFollowingMedicationsOLS());

        EitherOfFollowingMedicationsOLS eitherOfFollowingMedicationsOLS = new EitherOfFollowingMedicationsOLS();
        List<String> disqualifyQ30 = Arrays.asList("Fasenra (benralizumab)", "Nucala (mepolizumab)",
                "Otezla (apremilast)");
        for (String answer: disqualifyQ30) {
            System.out.println(answer);
            currentlyTakingFollowingMedicationsOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(dupixentInjectionPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5846", site.activeProtocols)
                    .back();
        }

        currentlyTakingFollowingMedicationsOLS
                .waitForPageLoad()
                .back(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS)
                .waitForPageLoad()
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Medications taken by mouth (oral medications)")
                .clickNextButton(currentlyTakingFollowingMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(eitherOfFollowingMedicationsOLS);

        //Q32
        List<String> disqualifyQ27 = Arrays.asList("Jakafi", "Olumiant", "Xeljanz");
        for (String answer: disqualifyQ27) {
            System.out.println(answer);
            eitherOfFollowingMedicationsOLS
                    .waitForPageLoad()
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
                    .back();
        }
        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .back(currentlyTakingFollowingMedicationsOLS)
                .waitForPageLoad()
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

//General_Health
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected5)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocols)
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
                .checkProtocolsContainsForQNumber("QS47", protocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
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
                .checkProtocolsContainsForQNumber("QS51", protocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", protocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS = following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS55", protocols)
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();
        otherThanSkinCancerPageOLS
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
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        AboutHealthPageOLS aboutHealthPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        switch (site) {
            case AUT_AD4814_site: //1R
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .assertGeneratedFul(env, site)
                        .assertChildDOBIsNull(env, "4814");
                break;
            case AUT_AD4814S_site: //41C
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .assertChildDOBIsNull(env, "4814");
                break;
        }
    }
}
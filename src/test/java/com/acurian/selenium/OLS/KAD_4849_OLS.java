package com.acurian.selenium.OLS;

import com.acurian.selenium.CC.PSA_5071_CC;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.PS_4656.HealthcareDiagnosedPsoriasisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.LessThan18YearsOldPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAD_4849_OLS extends BaseTest {

    private static Logger Log = LogManager.getLogger(KAD_4849_OLS.class.getName());

    @Test(enabled = false)
    @Description("kad4849 OLS Test")
    public void kad4849_OLS_Test() {
        Site site = Site.AUT_DERM_4849_Site;
        String phoneNumberMIG = "AUTAMS1KAD";
        String studyName = "an eczema (atopic dermatitis)";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad("an eczema (atopic dermatitis) study", "400");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "400"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .setDate("09092003")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        PersonalDetails personalDetails = dateOfBirthPageOLS
                .waitForPageLoad("an eczema (atopic dermatitis) study", "400")
                .setDate("09091942")
                .clickNextButton(new PersonalDetails());
        personalDetails
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoad("an eczema (atopic dermatitis) study", "400")
                .setDate("09091980")
                .clickNextButton(personalDetails);

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", eMailId, "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());

        healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back();

        HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_OLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());

        HowMuchEczemaYouHaveOnYourBody_OLS howMuchEczemaOnYourBody_ols = howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 months or less")
                .clickNextButton(new HowMuchEczemaYouHaveOnYourBody_OLS());

        howMuchEczemaOnYourBody_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();

        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(howMuchEczemaOnYourBody_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();

        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 years")
                .clickNextButton(howMuchEczemaOnYourBody_ols);

        WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols = howMuchEczemaOnYourBody_ols
                .waitForPageLoad()
                .selectFromDropDown("9")
                .clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());

        whichPartsOfYourBodyAreCurrentlyAffectedByEczema_ols
                .waitForPageLoad()
                .clickOnAnswers("None of these")
                .clickNextButton(healthcareDiagnosedPsoriasisPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
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
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5815", site.activeProtocols)
                .back(whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS)
                .waitForPageLoad()
                .clickOnAnswer("G")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);

        EczemaSymptomsExperienceOLS eczemaSymptomsExperienceOLS = howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new EczemaSymptomsExperienceOLS());

        eczemaSymptomsExperienceOLS //check flow
                .waitForPageLoad()
                .back();

        RateAverageItchinessEczemaPageOLS rateAverageItchinessEczemaPageOLS = howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days")
                .clickNextButton(new RateAverageItchinessEczemaPageOLS());
        rateAverageItchinessEczemaPageOLS
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(eczemaSymptomsExperienceOLS);

        HaveYouEverTreatedYourEczema_OLS haveYouEverTreatedYourEczema_OLS = eczemaSymptomsExperienceOLS
                .waitForPageLoad()
                .clickOnAnswers("Redness",
                        "Swelling",
                        "Oozing/Crusting",
                        "Dryness",
                        "Scratch marks",
                        "Skin thickening")
                .clickNextButton(new HaveYouEverTreatedYourEczema_OLS());

        WhichofthefollowingMedicationsTherapies_OLS whichofthefollowingMedicationsTherapies_OLS = haveYouEverTreatedYourEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, within the past year")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_OLS());

        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols = whichofthefollowingMedicationsTherapies_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS());

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic")
                .back(whichofthefollowingMedicationsTherapies_OLS)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_OLS);
        haveYouEverTreatedYourEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, but more than 1 year ago")
                .clickNextButton(whichofthefollowingMedicationsTherapies_OLS)
                .waitForPageLoad()
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic")
                .back(whichofthefollowingMedicationsTherapies_OLS)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_OLS);
        haveYouEverTreatedYourEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(whichofthefollowingMedicationsTherapies_OLS)
                .waitForPageLoad();

        DidYouReceiveAnyTherapiesPastYear_OLS didYouReceiveAnyTherapiesPastYear_ols = new DidYouReceiveAnyTherapiesPastYear_OLS();
        HashMap<String, List<String>> disqualifyQ23 = new HashMap<>();
        disqualifyQ23.put("Fasenra (benralizumab)", Arrays.asList(site.activeProtocols));
        disqualifyQ23.put("Nucala (mepolizumab)", Arrays.asList(site.activeProtocols));
        disqualifyQ23.put("Otezla (apremilast)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ23.entrySet()) {
            Log.info(entry.getKey());
            whichofthefollowingMedicationsTherapies_OLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(didYouReceiveAnyTherapiesPastYear_ols)
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5829", site.activeProtocols)
                    .back(didYouReceiveAnyTherapiesPastYear_ols)
                    .waitForPageLoad()
                    .back(whichofthefollowingMedicationsTherapies_OLS);
        }


        whichofthefollowingMedicationsTherapies_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Dupixent (dupilumab)")
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
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
                    .back();
        }

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_ols);

        //------------Q23- HaveYouEverTakenEitherAnyOfFollowingMeds ----------------
        haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouEverTakenEitherAnyOfFollowingMeds_ols
                .clickOnAnswers("Jakafi")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        //**************************************************
        //------------GENERAL HEALTH  Questions-------------
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();

        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4);
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS61", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS61", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", site.activeProtocols);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                //.setAllFields("Acurian", "Trial", eMailId, "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        aboutHealthPageOLS
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
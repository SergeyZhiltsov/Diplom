package com.acurian.selenium.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.GERD.CurrentlySufferOfAnyOfFollowingOLS;
import com.acurian.selenium.pages.OLS.Obesity_4605.ExperienceExcessiveHungerOrIncreasedAppetiteOLS;
import com.acurian.selenium.pages.OLS.PS_4656.HealthcareDiagnosedPsoriasisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class DERM_4631_OLS extends BaseTest {



    @DataProvider(name = "sites")
    public Object[][] getData() {
        return new Object[][]{
                {Site.AUT_DERM_4631_Site}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("4631 Kiniksa Atopic Derm for OLS")
    public void DERM_4631_OLS(Site site) {
        String phoneNumber = "AUTAMS1KAD";
        String studyName = "an eczema (atopic dermatitis)";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("an eczema (atopic dermatitis) study", "600");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"),
//                "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        PersonalDetails personalDetails = dateOfBirthPageOLS
                .waitForPageLoad("an eczema (atopic dermatitis) study", "600")
                .clickOnAnswer("Yes")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS = genderPageOLS
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
        HowMuchEczemaYouHaveOnYourBody_OLS howMuchEczemaYouHaveOnYourBody_OLS = new HowMuchEczemaYouHaveOnYourBody_OLS();
        HowWouldYouDescribeTheEczemaCurrentlyPageOLS howWouldYouDescribeTheEczemaCurrentlyPageOLS = new HowWouldYouDescribeTheEczemaCurrentlyPageOLS();
//        List<String> disqualifyQ3 = Arrays.asList("2 months or less", "3 - 6 months", "7 - 11 months");
//        for (String answer : disqualifyQ3) {
//            Log.info(answer);
//            howLongHaveYouBeenSufferingFromEczema_OLS
//                    .waitForPageLoad()
//                    .clickOnAnswer(answer)
//                    .clickNextButton(howMuchEczemaYouHaveOnYourBody_OLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
//                    .back();
//        }

        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
                .clickNextButton(/*howWouldYouDescribeTheEczemaCurrentlyPageOLS*/howMuchEczemaYouHaveOnYourBody_OLS);

        howMuchEczemaYouHaveOnYourBody_OLS
                .waitForPageLoad()
                .selectFromDropDown("10")
                .clickNextButton(new HaveYouEverHadAnyOfTheFollowingSymptomsPageOLS());

//---------------------------------------------QS24 DQ, Go to QS25---------------------------------------------
        HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS =
                howWouldYouDescribeTheEczemaCurrentlyPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Minor: Mostly clear or almost clear")
                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());

//        haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
//                .back();
//
//        howWouldYouDescribeTheEczemaCurrentlyPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Mild: Covers a small amount of total skin on my body")
//                .clickNextButton(haveYouEverHadAnyOfTheFollowingSymptomsPageOLS);
//
//        haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols);
//
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
//                .clickOnAnswer("Moderate: Covers a medium amount of total skin on my body")
//                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);
//
//        howManyDaysHasSkinBeenItchyOLS
//                .waitForPageLoad()
//                .back();
//
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

        SatisfiedEczemaTreatmentsOLS satisfiedEczemaTreatmentsOLS =
                haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
                                "Medications taken by mouth (oral medications)",
                                "Shots or IV infusions (injectable medications)",
                                "Self-treatment with tanning beds or sunbathing",
                                "Phototherapy (Ultraviolet or UV light treatment)")
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Shots or IV infusions (injectable medications)")
                        .clickNextButton(new SatisfiedEczemaTreatmentsOLS());

        AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS =
                satisfiedEczemaTreatmentsOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS());
//                        .getPage(debugPageOLS)
//                        .checkProtocolsContainsForQNumber("QS5845", site.activeProtocols)
//                        .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
//                        .waitForPageLoad()


        //-------------------------------------QS31 "biologics" with radiobuttons -------------------------------------
        DupixentInjectionPageOLS dupixentInjectionPageOLS =
                areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
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
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = dupixentInjectionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, currently taking")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


//        currentlyTakingFollowingMedicationsOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5850", site.activeProtocols)
//                .back();
//
//        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(currentlyTakingFollowingMedicationsOLS);
//
//        DupixentInjectionPageOLS dupixentInjectionPageOLS=
//                currentlyTakingFollowingMedicationsOLS
//                        .waitForPageLoad()
//                        .clickOnAnswers("Fasenra",
//                                "Nucala",
//                                "Otezla",
//                                "Cosentyx" )
//                        .clickNextButton(new DupixentInjectionPageOLS());
//
//        dupixentInjectionPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes, currently taking")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
//                .waitForPageLoad()
////                .getPage(debugPageOLS)
////                .checkProtocolsContainsForQNumber("QS5847", site.activeProtocols)
//                .back(dupixentInjectionPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswer("Yes, took in the past but not now")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
//                .waitForPageLoad()
////                .getPage(debugPageOLS)
////                .checkProtocolsContainsForQNumber("QS5847", site.activeProtocols[0])
//                .back(dupixentInjectionPageOLS)
//                .waitForPageLoad()
//                .back(currentlyTakingFollowingMedicationsOLS)
//                .waitForPageLoad()
//                .back(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS)
//                .waitForPageLoad()
//                .back();
//
//        EitherOfFollowingMedicationsOLS eitherOfFollowingMedicationsOLS =
//                haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
//                        .waitForPageLoad()
//                        .clickOnAnswers("None of the above")
//                        .clickOnAnswers("Medications taken by mouth (oral medications)")
//                        .clickNextButton(currentlyTakingFollowingMedicationsOLS)
//                        .waitForPageLoad()
//                        .clickOnAnswers("None of the above")
//                        .clickNextButton(new EitherOfFollowingMedicationsOLS());
//
//        eitherOfFollowingMedicationsOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Jakafi",
//                        "Olumiant",
//                        "Xeljanz")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

//        RateAverageItchinessEczemaPageOLS rateAverageItchinessEczemaPageOLS = howManyDaysHasSkinBeenItchyOLS
//                .waitForPageLoad()
//                .clickOnAnswer("1 - 2 days")
//                .clickNextButton(new RateAverageItchinessEczemaPageOLS());
//        EczemaSymptomsExperienceOLS eczemaSymptomsExperienceOLS = rateAverageItchinessEczemaPageOLS
//                .waitForPageLoad()
//                .selectFromDropDown("2")
//                .clickNextButton(new EczemaSymptomsExperienceOLS());
//
//        HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS =
//                eczemaSymptomsExperienceOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Redness",
//                        "Swelling",
//                        "Oozing/Crusting",
//                        "Dryness",
//                        "Scratch marks",
//                        "Skin thickening")
//                .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());
//
//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
//                haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
//                        "Medications taken by mouth (oral medications)",
//                        "Shots or IV infusions (injectable medications)",
//                        "Self-treatment with tanning beds or sunbathing",
//                        "Phototherapy (Ultraviolet or UV light treatment)")
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Self-treatment with tanning beds or sunbathing",
//                        "Phototherapy (Ultraviolet or UV light treatment)")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
//
//        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS =
//                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
//                .waitForPageLoad()
//                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Shots or IV infusions (injectable medications)")
//                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS());
//
//        List<String> medications = Arrays.asList("Actemra",
//                "Benlysta",
//                "Cimzia",
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
//                "Tysabri");
//        CurrentlyTakingFollowingMedicationsOLS currentlyTakingFollowingMedicationsOLS =
//                new CurrentlyTakingFollowingMedicationsOLS();
//        for (String answer: medications) {
//              areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(answer)
//                    .clickNextButton(currentlyTakingFollowingMedicationsOLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
//                    .back();}
//
//        DupixentInjectionPageOLS dupixentInjectionPageOLS = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Cosentyx")
//                .clickNextButton(new DupixentInjectionPageOLS());
//        dupixentInjectionPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5821", site.activeProtocols)
//                .back(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS)
//                .waitForPageLoad()
//                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Medications taken by mouth (oral medications)")
//                .clickNextButton(currentlyTakingFollowingMedicationsOLS);
//
//        EitherOfFollowingMedicationsOLS eitherOfFollowingMedicationsOLS = currentlyTakingFollowingMedicationsOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Fasenra (benralizumab)",
//                        "Nucala (mepolizumab)" ,
//                        "Otezla (apremilast)")
//                .clickNextButton(new EitherOfFollowingMedicationsOLS());
//
//        eitherOfFollowingMedicationsOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Jakafi",
//                        "Olumiant",
//                        "Xeljanz")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

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
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight", "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4);
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        CurrentlySufferOfAnyOfFollowingOLS currentlySufferOfAnyOfFollowingOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "10", "120")
                .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS());
        currentlySufferOfAnyOfFollowingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .clickOnQNumber("QS60");
        ExperienceExcessiveHungerOrIncreasedAppetiteOLS experienceExcessiveHungerOrIncreasedAppetiteOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setFeatwithClear("4")
                .setIncheswithClear("5")
                .setLbs("188")
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
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        //----------PII (IdentificationPageOLS) Page--------------------
        identificationPageOLS
                .waitForPageLoad()
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
                .childPidFromDbToLog(env, "4631")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
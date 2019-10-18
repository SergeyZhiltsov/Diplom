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
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class DERM_4815_OLS_A_S extends BaseTest {

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
                {Site.AUT_DERM_4815_Site},
                {Site.AUT_DERM_4815S_Site}
        };
    }

    @Test(dataProvider = "sites", enabled = false) //Deactivated in R79.2
    @Description("DERM_4815_OLS_A_S")
    public void derm4815Ols(final Site site) {
        final String phoneNumber = "AUTAMSDERM";
        String studyName = "an eczema (atopic dermatitis)";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"),
                "Title is diff");
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
                .setDate("09091942")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS =
                hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());

        healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back(hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols);

        HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_OLS =
                hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());

        HowWouldYouDescribeTheEczemaCurrentlyPageOLS howWouldYouDescribeTheEczemaCurrentlyPageOLS =
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 months or less")
                .clickNextButton(new HowWouldYouDescribeTheEczemaCurrentlyPageOLS());
        howWouldYouDescribeTheEczemaCurrentlyPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months")
                .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 years")
                .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS);

        //---------------------------------------------QS24 DQ, Go to QS25---------------------------------------------
        HaveYouEverHadAnyOfTheFollowingSymptomsPageOLS haveYouEverHadAnyOfTheFollowingSymptomsPageOLS =
                howWouldYouDescribeTheEczemaCurrentlyPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Minor: Mostly or almost clear")
                        .clickNextButton(new HaveYouEverHadAnyOfTheFollowingSymptomsPageOLS());

        haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
                .back();

        howWouldYouDescribeTheEczemaCurrentlyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild: Covers a small amount of total skin on my body")
                .clickNextButton(haveYouEverHadAnyOfTheFollowingSymptomsPageOLS);

        haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols);

        //------------------------------------------------------QS25----------------------------------------------------
        HowManyDaysHasSkinBeenItchyOLS howManyDaysHasSkinBeenItchyOLS = haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyOLS());

        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
                .back();

        haveYouEverHadAnyOfTheFollowingSymptomsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Eczema that covers a medium to large amount of total skin on my body",
                        "Eczema that looks red or dark red",
                        "Eczema that feels very or intensely itchy and scratchy")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);

        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .back(haveYouEverHadAnyOfTheFollowingSymptomsPageOLS)
                .back();

        //--------------------------------QS24 Q, Skip to QS26 "How many days ... itchy?--------------------------------
        howWouldYouDescribeTheEczemaCurrentlyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Moderate: Covers a medium amount of total skin on my body")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);

        howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .back();

        howWouldYouDescribeTheEczemaCurrentlyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Severe: Covers a large amount of total skin on my body")
                .clickNextButton(howManyDaysHasSkinBeenItchyOLS);

        //-----------------------------------------------------QS26-----------------------------------------------------
        EczemaSymptomsExperienceOLS eczemaSymptomsExperienceOLS = howManyDaysHasSkinBeenItchyOLS
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new EczemaSymptomsExperienceOLS());

        eczemaSymptomsExperienceOLS
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

        AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS5845", site.activeProtocols)
                        .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Shots or IV infusions (injectable medications)")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS());

        //-------------------------------------QS31 "biologics" with radiobuttons -------------------------------------
        CurrentlyTakingFollowingMedicationsOLS currentlyTakingFollowingMedicationsOLS =
                areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new CurrentlyTakingFollowingMedicationsOLS());

        currentlyTakingFollowingMedicationsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5850", site.activeProtocols)
                .back();

        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(currentlyTakingFollowingMedicationsOLS);

        DupixentInjectionPageOLS dupixentInjectionPageOLS=
                currentlyTakingFollowingMedicationsOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Fasenra",
                                "Nucala",
                                "Otezla",
                                "Cosentyx" )
                        .clickNextButton(new DupixentInjectionPageOLS());

        dupixentInjectionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, currently taking")
                .clickNextButton(healthcareDiagnosedPsoriasisPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5847", site.activeProtocols)
                .back(dupixentInjectionPageOLS)
                .waitForPageLoad()
                .back(currentlyTakingFollowingMedicationsOLS)
                .waitForPageLoad()
                .back(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS)
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

        List<String> disqualifyQ32 = Arrays.asList("Jakafi", "Olumiant", "Xeljanz");
        for (String answer: disqualifyQ32) {
            System.out.println(answer);
            eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers(answer)
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
                .back();
        }
                eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

//        WhichofthefollowingMedicationsTherapies_OLS whichofthefollowingMedicationsTherapies_ols =
//                haveYouEverTreatedYourEczema_OLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes, within the past year")
//                .clickNextButton(new WhichofthefollowingMedicationsTherapies_OLS());
//
//        DidYouReceiveAnyTherapiesPastYear_OLS didYouReceiveAnyTherapiesPastYear_ols =
//                whichofthefollowingMedicationsTherapies_ols
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
//        HaveYouEverTakenEitherAnyOfFollowingMeds_OLS haveYouEverTakenEitherAnyOfFollowingMeds_ols =
//                new HaveYouEverTakenEitherAnyOfFollowingMeds_OLS();
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
//        //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
//                // haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .clickOnAnswers("Jakafi")
//                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
//                .back();
//        haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Olumiant")
//                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
//                .back();
//
//        haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Xeljanz")
//                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
//                .back();
//
//        haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .waitForPageLoad();
//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
//                haveYouEverTakenEitherAnyOfFollowingMeds_ols
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer",
                "Heart or circulation problems (heart attack, heart failure, stroke)",
                "Kidney disease",
                "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS heartrelatedMedicalConditionsProceduresPageCC =
                otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();

        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(heartrelatedMedicalConditionsProceduresPageCC);

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS =
                heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
						"Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4);
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

        //EthnicBackgroundPageOLS ethnicBackgroundPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
        AboutHealthPageOLS aboutHealthPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "250")
                /* .clickNextButton(new EthnicBackgroundPageOLS());

         ethnicBackgroundPageOLS
                 .waitForPageLoad()
                 .clickOnAnswers("Prefer not to answer")*/
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        switch (site) {
                case AUT_DERM_4815_Site: //1R
                    aboutHealthPageOLS
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env, "4815")
                            .assertGeneratedFul(env, site)
                            .dispoShouldMatch(site.dispo, site.dispo);
                    break;
                case AUT_DERM_4815S_Site: //41C
                    aboutHealthPageOLS
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .getRadiantDbToLog(env)
                            .getAnomalyDbToLog(env)
                            .childPidFromDbToLog(env, "4815")
                            .dispoShouldMatch(site.dispo, site.dispo);
                    break;
                }
    }
}

package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LOWT.CurrentlyTakingFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.PSO_456.HealthcareDiagnosedPsoriasisPageCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.OLS.DERM_4815_OLS_A_S;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.List;

public class DERM_4815_CC_A_S extends BaseTest {

    private static Logger Log = LogManager.getLogger(DERM_4815_CC_A_S.class.getName());

    @Test(dataProvider = "sites", dataProviderClass = DERM_4815_OLS_A_S.class, enabled = false) //Deactivated in R79.2
    @Description("DERM_4815_CC_A_S")
    public void derm4815ccAasTest(Site site) {
        final String phoneNumber = "AUTAMSDERM";
        String studyName = "an eczema (atopic dermatitis) study";
        String studyNameForTrans = "eczema, or atopic dermatitis";
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected,
                "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"),
//                "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .waitForPageLoad("an eczema (atopic dermatitis) study", "600")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad("an eczema (atopic dermatitis) study", "600")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("1942")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        HealthcareDiagnosedPsoriasisPageCC healthcareDiagnosedPsoriasisPageCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageCC());

        healthcareDiagnosedPsoriasisPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back();

        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_cc = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());

        //Q3
        HowWouldYouDescribeTheEczemaCurrentlyPageCC howWouldYouDescribeTheEczemaCurrentlyPageCC =
                new HowWouldYouDescribeTheEczemaCurrentlyPageCC();
        List<String> disqualifyQ3 = Arrays.asList("2 months or less",
                "3 - 6 months",
                "7 - 11 months");
        for (String answer: disqualifyQ3) {
            Log.info(answer);
            howLongHaveYouBeenSufferingFromEczema_cc
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                    .back();
        }
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
                .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageCC);

        //Q24
        HaveYouEverHadAnyOfTheFollowingSymptomsPageСС haveYouEverHadAnyOfTheFollowingSymptomsPageСС =
                new HaveYouEverHadAnyOfTheFollowingSymptomsPageСС();
        List<String> disqualifyQ24 = Arrays.asList("Minor: Mostly or almost clear",
                "Mild: Covers a small amount of total skin on my body");
        for (String answer: disqualifyQ24) {
            Log.info("Select answer for Q24: " + answer);
            howWouldYouDescribeTheEczemaCurrentlyPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(haveYouEverHadAnyOfTheFollowingSymptomsPageСС)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
                    .back();
        }
        howWouldYouDescribeTheEczemaCurrentlyPageCC
                .waitForPageLoad()
                .clickNextButton(haveYouEverHadAnyOfTheFollowingSymptomsPageСС);
        HowManyDaysHasSkinBeenItchyCC howManyDaysHasSkinBeenItchyCC = haveYouEverHadAnyOfTheFollowingSymptomsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Eczema that covers a medium to large amount of total skin on my body",
                        "Eczema that looks red or dark red",
                        "Eczema that feels very or intensely itchy and scratchy")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyCC());
        howManyDaysHasSkinBeenItchyCC         //Q26
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5849", site.activeProtocols)
                .back(haveYouEverHadAnyOfTheFollowingSymptomsPageСС)
                .waitForPageLoad()
                .back(howWouldYouDescribeTheEczemaCurrentlyPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Severe: Covers a large amount of total skin on my body")
                .clickNextButton(howManyDaysHasSkinBeenItchyCC);

        //Q26
        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy") //Disqualify ("No pruritus")
                .clickNextButton(new EczemaSymptomsExperienceCC());
        RateAverageItchinessEczemaPageCC rateAverageItchinessEczemaPageCC = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5837", site.activeProtocols)
                .back(howManyDaysHasSkinBeenItchyCC)
                .waitForPageLoad()
                .clickOnAnswer("My skin is itchy every day")
                .clickNextButton(new RateAverageItchinessEczemaPageCC());
        //Q27
        rateAverageItchinessEczemaPageCC
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(eczemaSymptomsExperienceCC);
        //Q28
        HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC haveYouTriedAnyFollowingTreatmentsForEczemaPageCC =
                eczemaSymptomsExperienceCC
                        .waitForPageLoad()
                        .clickOnAnswers("Redness",
                                "Swelling",
                                "Oozing/Crusting",
                                "Dryness",
                                "Scratch marks",
                                "Skin thickening")
                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC());
        //Q27
        TransitionStatementCC transitionStatementCC = haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                .waitForPageLoad()
                .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
                        "Medications taken by mouth (oral medications)",
                        "Shots or IV infusions (injectable medications)",
                        "Self-treatment with tanning beds or sunbathing",
                        "Phototherapy (Ultraviolet or UV light treatment)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Self-treatment with tanning beds or sunbathing",
                        "Phototherapy (Ultraviolet or UV light treatment)")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5845", site.activeProtocols)
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC);
        haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC);
        CurrentlyTakingFollowingMedicationsCC currentlyTakingFollowingMedicationsCC =
                haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Medications taken by mouth (oral medications)")
                        .clickNextButton(new CurrentlyTakingFollowingMedicationsCC());
        currentlyTakingFollowingMedicationsCC
                .waitForPageLoad()
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC);
        AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC =
                haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Shots or IV infusions (injectable medications)")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC());
        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC
                .waitForPageLoad()
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Medications taken by mouth (oral medications)") //Added to display Q35
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC);
        //Q31
        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Disqualify (“Current biologic use”)
                .clickNextButton(currentlyTakingFollowingMedicationsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5850", site.activeProtocols)
                .back(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(currentlyTakingFollowingMedicationsCC);

        //Q32
        DupixentInjectionPageCC dupixentInjectionPageCC = currentlyTakingFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Cosentyx (Agent Note: co-SEN-tix)", "Fasenra (Agent Note: fa-SEN-ra)",
                        "Nucala (Agent Note: new-CA-la)", "Otezla (Agent Note: oh-TEZ-la)")
                .clickNextButton(new DupixentInjectionPageCC());

        //Q33
        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC = dupixentInjectionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, currently taking")
                .clickNextButton(new HaveYouEverTakenEitherAnyOfFollowingMeds_CC());
        haveYouEverTakenEitherAnyOfFollowingMeds_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5847", site.activeProtocols)
                .back(dupixentInjectionPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No, never took")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC);

        //Q34

        List<String> disqualifyQ27 = Arrays.asList("Jakafi (Agent Note: JAK-uh-fie)",
                "Olumiant (Agent Note: oh-LOO-me-ant)",
                "Xeljanz (Agent Note: ZEL-jans)");
        for (String answer: disqualifyQ27) {
            Log.info("Select answer for Q34 " + answer);
            haveYouEverTakenEitherAnyOfFollowingMeds_CC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(healthcareDiagnosedPsoriasisPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5830", site.activeProtocols)
                    .back();
        }
        haveYouEverTakenEitherAnyOfFollowingMeds_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                transitionStatementCC
                        .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        //-------------------New GENERAL HEALTH---------------------------
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC heartrelatedMedicalConditionsProceduresPageCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(heartrelatedMedicalConditionsProceduresPageCC);

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                        "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"1 - 3 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
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
                .back();

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        List<String> diagnoses = Arrays.asList(
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS"
        );
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        for(String diagnose : diagnoses){
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }

        LetMeSeePageCC letMeSeePageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new LetMeSeePageCC());

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());
                //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_DERM_4815_Site: //1R
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new SynexusHealthyMindsPageCC())
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env,"4815")
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_DERM_4815S_Site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "03/02/1942", "US",
                                "Cincinnati, OH", site.zipCode, "qa.acurian@gmail.com",
                                "999 -999-9999", "123456a", site.name, "PFZICNATO029")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env,"4815")
                        .dispoShouldMatch(site.dispo, site.dispo);
        }

    }
}
package com.acurian.selenium.CC;


import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.PSO_456.*;
import com.acurian.selenium.pages.CC.PsoriaticArthritis.PsoriaticArthritisConditionPageCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.MostRecentHeartRelatedSurgeryProcedurePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.List;

public class PS_7469_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(PS_7469_CC.class.getName());

    @Test(enabled = true)
    @Description("PS_7469_CC")
    public void ps7469cctest() {

        String phoneNumber = "AUTAMS1PSO";
        String studyName = "a psoriasis study";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageCC debugPageCC = new DebugPageCC();
        final Site site = Site.AUT_S10484;

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad(studyName, "300");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageOLS = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad("a psoriasis study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        HasHealthCareProfessionalDiagnosedPsoriasisCC hasHealthCareProfessionalDiagnosedPsoriasisCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("15")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthCareProfessionalDiagnosedPsoriasisCC());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC  hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc =
                hasHealthCareProfessionalDiagnosedPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7002", site.activeProtocols)
                .back(hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc);

        WhenDiagnosedWithPsoriasisCC whenDiagnosedWithPsoriasisCC = hasHealthCareProfessionalDiagnosedPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedWithPsoriasisCC());

        WhichTypeOfPsoriasisDoYouHaveCC whichTypeOfPsoriasisDoYouHaveCC = whenDiagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("5 or fewer months ago")
                .clickNextButton(new WhichTypeOfPsoriasisDoYouHaveCC());

        whichTypeOfPsoriasisDoYouHaveCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7003", site.activeProtocols)
                .back(whenDiagnosedWithPsoriasisCC);

        whenDiagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("1 year ago or more")
                .clickNextButton(whichTypeOfPsoriasisDoYouHaveCC);

        TransitionStatementCC transitionStatementCC = whichTypeOfPsoriasisDoYouHaveCC
                .waitForPageLoad()
                .clickOnAnswers("Another type of psoriasis (Guttate, Pustular, Erythtodermic, Inverse)")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoadPsoriasis()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7020", site.activeProtocols)
                .back(whichTypeOfPsoriasisDoYouHaveCC);

        EnoughPsoriasisToEqualAtLeastOneHandprintCC enoughPsoriasisToEqualAtLeastOneHandprintCC = whichTypeOfPsoriasisDoYouHaveCC
                .waitForPageLoad()
                .clickOnAnswers("I'm not sure")
                .clickNextButton(new EnoughPsoriasisToEqualAtLeastOneHandprintCC());

        TreatYourPsoriasisPageCC treatYourPsoriasisPageCC = enoughPsoriasisToEqualAtLeastOneHandprintCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TreatYourPsoriasisPageCC());

        treatYourPsoriasisPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7026", site.activeProtocols)
                .back(enoughPsoriasisToEqualAtLeastOneHandprintCC);

        enoughPsoriasisToEqualAtLeastOneHandprintCC
                .waitForPageLoad()
                .clickOnAnswer("I'm not sure")
                .clickNextButton(treatYourPsoriasisPageCC);

        InjectableMedicationToTreatPsoriasisCC injectableMedicationToTreatPsoriasisCC = treatYourPsoriasisPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadPsoriasis()
                .back(treatYourPsoriasisPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Shots or IV infusion (injectable medications)")
                .clickNextButton(new InjectableMedicationToTreatPsoriasisCC());

        PsoriaticArthritisConditionPageCC psoriaticArthritisConditionPageCC = injectableMedicationToTreatPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("Within the last 6 months")
                .clickNextButton(new PsoriaticArthritisConditionPageCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                psoriaticArthritisConditionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7013", site.activeProtocols)
                .back(injectableMedicationToTreatPsoriasisCC)
                .waitForPageLoad()
                .clickOnAnswer("Between 7 months and 1 year ago")
                .clickNextButton(psoriaticArthritisConditionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7013", site.activeProtocols)
                .back(injectableMedicationToTreatPsoriasisCC)
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadPsoriasis()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        //--------------------------------------GENERAL HEALTH QUESTIONS----------------------------------------------
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartrelatedMedicalProceduresPageCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswerForSubQuestion(1,"Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC

                .waitForPageLoad(1, subquestionExperiencedHeartPageCC
                        .titleExpected3)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC
                );
        subquestionExperiencedHeartPageCC

                .waitForPageLoad(1, subquestionExperiencedHeartPageCC
                        .titleExpected3)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC
                );
        subquestionExperiencedHeartPageCC

                .waitForPageLoad(1, subquestionExperiencedHeartPageCC
                        .titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC
                );
        subquestionExperiencedHeartPageCC

                .waitForPageLoad(1, subquestionExperiencedHeartPageCC
                        .titleExpected4)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC
                );
        subquestionExperiencedHeartPageCC

                .waitForPageLoad(1, subquestionExperiencedHeartPageCC
                        .titleExpected4)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                )
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC
                );
        subquestionExperiencedHeartPageCC

                .waitForPageLoad(1, subquestionExperiencedHeartPageCC
                        .titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());

        MostRecentHeartRelatedSurgeryProcedurePageCC mostRecentHeartRelatedSurgeryProcedurePageCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageCC());


        List<String> disqualifyQS49 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer : disqualifyQS49) {
            Log.info("Select answer for QS49: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                    .back(mostRecentHeartRelatedSurgeryProcedurePageCC);
        }

        mostRecentHeartRelatedSurgeryProcedurePageCC
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                );

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC

                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = new DoAnyOftheFollowingAdditionalDiagnosesCC();

        List<String> disqualifyQS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis", "Gastroparesis, or delayed gastric emptying");
        for (String answer : disqualifyQS44) {
            Log.info("Select answer for QS44: " + answer);
            whichOfFollowingDigestiveConditionPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back(whichOfFollowingDigestiveConditionPageCC);
        }

        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                );

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Seizure disorder such as epilepsy")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "180")
                .clickNextButton(new LetMeSeePageCC());

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());

        SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = siteSelectionPageCC
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new SynexusRadiantDirectScheduleCC());
        synexusRadiantDirectScheduleCC
                .waitForPageLoadSyn()
                .assertVariablesNew("Acurian", "Trial", "09/15/1980", "US",
                        "Dover, DE", site.zipCode, "qa.acurian@gmail.com",
                        "999-999-9999", "S10484", site.name,
                        "EVLPPDPSO201 - Evelo Psoriasis")
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC);
        if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    //.assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

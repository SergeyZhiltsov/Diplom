package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.HowLongAgoDiagnosedDiabetesPageCC;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LOWT.HasDoctorEverDiagnosedYouMedicalCondCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.List;

public class CV_4450_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(CV_4450_CC.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_CV1_4450S_Syn}
        };
    }

    @Test(dataProvider = "sites")
    @Description("CV 4450 CC")
    public void cv4450ccTest(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String studyName = "a heart health study";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad2("a heart health study", "750");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
//                ("Cardiovascular Disease", "750"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1952") //"Disqualify (“Age”) if < 45
                .clickOnAnswer("Female")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageCC());

        TakingFollowingStaticMedicationCC takingFollowingStaticMedicationCC = cholesterolTriglyceridesLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakingFollowingStaticMedicationCC());

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = takingFollowingStaticMedicationCC
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageCC);

        WithType1DiabetesPageCC withType1DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageCC());

        withType1DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageCC);

        HowLongAgoDiagnosedDiabetesPageCC howLongAgoDiagnosedDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HowLongAgoDiagnosedDiabetesPageCC());

        StatementsApplyToYouCC statementsApplyToYouCC = howLongAgoDiagnosedDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new StatementsApplyToYouCC());

        SufferedFollowingHeartRelatedConditionsPageCC sufferedFollowingHeartRelatedConditionsPageCC = statementsApplyToYouCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = sufferedFollowingHeartRelatedConditionsPageCC
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
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        MajorStrokeCausedPermanentLossFunctionsCC majorStrokeCausedPermanentLossFunctionsCC = new MajorStrokeCausedPermanentLossFunctionsCC();

        sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(majorStrokeCausedPermanentLossFunctionsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(majorStrokeCausedPermanentLossFunctionsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());

        MostRecentHeartRelatedSurgeryProcedurePageCC mostRecentHeartRelatedSurgeryProcedurePageCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageCC());


        List<String> disqualifyQS49 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQS49) {
            Log.info("Select answer for QS49: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(new AdditionalHeartRelatedConditionsPageCC())
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6739", site.activeProtocols)
                    .back(mostRecentHeartRelatedSurgeryProcedurePageCC);
        }

        mostRecentHeartRelatedSurgeryProcedurePageCC
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);
        AdditionalHeartRelatedConditionsPageCC additionalHeartRelatedConditionsPageCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AdditionalHeartRelatedConditionsPageCC());
        ApproximateHeightPageCC approximateHeightPageCC = additionalHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());
        HasDoctorEverDiagnosedYouMedicalCondCC hasDoctorEverDiagnosedYouMedicalCondCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("7", "7", "500")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCondCC());

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = new HealthcareDiagnosedConditionsPageCC();
        hasDoctorEverDiagnosedYouMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("5","5","150")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6743", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("7", "7", "500")
                .clickNextButton(healthcareDiagnosedConditionsPageCC);

        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        List<String> disqualifyQ18 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String answer : disqualifyQ18) {
            Log.info("Select answer for Q18: " + answer);
            healthcareDiagnosedConditionsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(hasDoctorEverDiagnosedYouMedicalCondCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back(healthcareDiagnosedConditionsPageCC);
        }

        IdentificationPageCC identificationPageCC = healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
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
                .assertVariablesNew("Acurian", "Trial", "09/09/1952", "US",
                        "Dover, DE", site.zipCode, "qa.acurian@gmail.com",
                        "999-999-9999", "12345D", site.name, "NNDXXXCAR388 - Novo Nordisk cardiovascular outcomes")
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
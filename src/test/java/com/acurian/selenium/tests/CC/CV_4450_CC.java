package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.CurrentlyTreatingYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.IBD.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.closes.CurrentlyParticipatingInStudy;
import com.acurian.selenium.pages.CC.closes.RequirePassDrugTest;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class CV_4450_CC extends BaseTest {

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

        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1952") //"Disqualify (“Age”) if < 45
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

        //Q3: QS	Certain conditions are more closely linked to cardiovascular disease than others.
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC =
                cardiovascularDiseaseThanOthersPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Diabetes or High Blood Sugar",
                                "High cholesterol or high triglycerides",
                                "High blood pressure or hypertension")
                        .clickOnAnswers("None of the above") //skip to Q14 (Heart-related events)
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        //Q14
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC =
                cardiovascularDiseaseThanOthersPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("High cholesterol or high triglycerides") //go to Q4 (NEW Q4)
                        .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC());

        //Q4 Have you had a blood test that confirms you have high cholesterol or high triglycerides?
        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC =
                haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                        .clickNextButton(new CholesterolTriglyceridesLipidsPageCC());

        //Q13 Are you currently taking medication to manage high cholesterol, triglycerides, or lipids?
        cholesterolTriglyceridesLipidsPageCC
                .waitForPageLoad()
                .back(haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC)
                .waitForPageLoad()
                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        //Q5	What kind of diabetes do you have?
        WithType1DiabetesPageCC withType1DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageCC());
        withType1DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());
        withType2DiabetesPageCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        SufferedFollowingHeartRelatedConditionsPageCC sufferedFollowingHeartRelatedConditionsPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes")
                .clickOnAnswer("Unsure")
                .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageCC());

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC =
                sufferedFollowingHeartRelatedConditionsPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack",
                                "Stroke",
                                "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                                "Heart failure or congestive heart failure (CHF)")
                        .clickOnAnswers("None of the above") //Skip to Q16
                        .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .back();

        SubquestionHeartPageCC subquestionHeartPageCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionHeartPageCC());

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionHeartPageCC);

        //Q15.1	When was the last time that you experienced had a heart attack?
        List<String> disqualifyQ15 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.1: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageCC);

        //Q15.2	When was the last time that you experienced had a stroke?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.2: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionHeartPageCC);

        //Q15.3	When was the last time that you experienced had a mini-stroke or TIA?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.3: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected3)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageCC);

        //Q15.4	When was the last time that you experienced suffered from angina or chest pain that required you to stay in a hospital overnight?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.4: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected4)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        MostRecentHeartRelatedSurgeryProcedurePageCC mostRecentHeartRelatedSurgeryProcedurePageCC =
                heartRelatedSurgeriesProceduresPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Stent placement in your heart, neck or legs")
                        .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageCC());

        //Q17	When was your most recent heart-related surgery or procedure?
        AdditionalHeartRelatedConditionsPageCC additionalHeartRelatedConditionsPageCC =
                new AdditionalHeartRelatedConditionsPageCC();
        List<String> disqualifyQ17 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ17) {
            System.out.println("Select answer for Q17: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(additionalHeartRelatedConditionsPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6739", site.activeProtocols)
                    .back();
        }
        mostRecentHeartRelatedSurgeryProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(additionalHeartRelatedConditionsPageCC);

        //Q18	Have you ever been diagnosed with any of the following additional heart-related conditions?
        ApproximateHeightPageCC approximateHeightPageCC = additionalHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

//------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------
        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());
        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageCC)
                .clickOnAnswers("None of the above")
                .back(mostRecentHeartRelatedSurgeryProcedurePageCC)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke") //Qualifying answer Ghost Question
                .clickNextButton(subquestionHeartPageCC)
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .clickOnAnswerForAllSubQuestion("More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageCC)
                .waitForPageLoad()
                .clickNextButton(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC);
        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .clickNextButton(new HealthcareDiagnosedConditionsPageCC());

        healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .back(mostRecentHeartRelatedSurgeryProcedurePageCC)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .back(subquestionHeartPageCC)
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //deselect previous qualifying answer
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Any other surgery on the arteries in your legs, neck or heart") //Qualifying answer Ghost Question
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageCC)
                .waitForPageLoad()
                .clickNextButton(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .clickNextButton(healthcareDiagnosedConditionsPageCC);

        healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .back(mostRecentHeartRelatedSurgeryProcedurePageCC)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)") //Qualifying answer Ghost Question
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .clickNextButton(healthcareDiagnosedConditionsPageCC);
//------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------

        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        List<String> disqualifyQ26 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
            healthcareDiagnosedConditionsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back();
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

        identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .assertVariablesNew("Acurian", "Trial", "09/09/1952", "US",
                        "Dover, DE", site.zipCode, "qa.acurian@gmail.com",
                        "999-999-9999", "12345D", site.name, "NNDXXXCAR388 - Novo Nordisk cardiovascular outcomes")
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();
        if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .getRadiantDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
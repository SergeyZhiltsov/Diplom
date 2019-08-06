package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.IBD.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.CV_5034_OLS_A_S;

import java.util.Arrays;
import java.util.List;

import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class CV_5034_CC_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "5034Sites", dataProviderClass = CV_5034_OLS_A_S.class)
    @Description("Diabetes_5034_Synexus for CC")
    public void CV_5034_CC_Test(Site site) {
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //-------Date of Birth Page--------
        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleCVExpected, "Title is diff");

        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad2Ver()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageCC = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDay("1")
                .setMonth("Aug")
                .setYear("2005")//Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1992")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        List<String> disqualifyQ3 = Arrays.asList("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides",
                "High blood pressure or hypertension", "Chronic Kidney Disease");
        for (String answer: disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            cardiovascularDiseaseThanOthersPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadDYS()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                    .back();
        }
        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC =
                cardiovascularDiseaseThanOthersPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides")
                        .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC());

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = new WhatKindOfDiabetesPageCC();
        if (site == Site.AUT_CV_5034A_site) {
            haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("No")
                    .clickNextButton(whatKindOfDiabetesPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6735", site.activeProtocols)
                    .back();
        }
        haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                .clickNextButton(whatKindOfDiabetesPageCC);

        //Q5	What kind of diabetes do you have?
        List<String> disqualifyQ5 = Arrays.asList("Type 1 diabetes (sometimes called Juvenile diabetes)",
                "Gestational diabetes (diabetes only during pregnancy)", "High blood sugar only", "Unsure");
        for (String answer: disqualifyQ5) {
            System.out.println("Select answer Q3: " + answer);
            whatKindOfDiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadDYS()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                    .back();
        }
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        //Q6	How long ago were you diagnosed with type 2 diabetes?
        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC = withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageCC());
        cholesterolTriglyceridesLipidsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6705", site.activeProtocols)
                .back(withType2DiabetesPageCC)
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(cholesterolTriglyceridesLipidsPageCC);

        //Q13	Are you currently taking medication to manage high cholesterol, triglycerides, or lipids?
        SufferedFollowingHeartRelatedConditionsPageCC sufferedFollowingHeartRelatedConditionsPageCC =
                cholesterolTriglyceridesLipidsPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageCC());
        sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6734", site.activeProtocols)
                .back(cholesterolTriglyceridesLipidsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(sufferedFollowingHeartRelatedConditionsPageCC);

        //Q15
        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC =
                sufferedFollowingHeartRelatedConditionsPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack",
                                "Stroke",
                                "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                                "Heart failure or congestive heart failure (CHF)")
                        .clickOnAnswers("None of the above") //Skip to Q16
                        .clickNextButton(new HeartrelatedMedicalProceduresPageCC());

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        heartrelatedMedicalProceduresPageCC
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
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(subquestionHeartPageCC);

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        MostRecentHeartRelatedSurgeryProcedurePageCC mostRecentHeartRelatedSurgeryProcedurePageCC =
                heartrelatedMedicalProceduresPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Stent placement in your heart, neck or legs")
                        .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageCC());

        //Q17	When was your most recent heart-related surgery or procedure?
        mostRecentHeartRelatedSurgeryProcedurePageCC
                .waitForPageLoad()
                .back();

        AdditionalHeartRelatedConditionsPageCC additionalHeartRelatedConditionsPageCC =
                heartrelatedMedicalProceduresPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new AdditionalHeartRelatedConditionsPageCC());

        //Q18	Have you ever been diagnosed with any of the following additional heart-related conditions?
        ApproximateHeightPageCC approximateHeightPageCC = additionalHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)")
                .clickNextButton(new ApproximateHeightPageCC());

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(new HealthcareDiagnosedConditionsPageCC());

        List<String> options = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String entry: options) {
            System.out.println(entry);
            healthcareDiagnosedConditionsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadDYS()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back();
        }
        IdentificationPageCC identificationPageCC = healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageCC());
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_CV_5034A_site: //1R
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_CV_5034S_site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "08/01/1992", "US",
                                "Dover, DE", site.zipCode, "qa.acurian@gmail.com",
                                "999 -999-9999", "5034SAUT", "AUT_CV_5034S_site",
                                "KOWQUICAR302")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .getRadiantDbToLog(env)
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
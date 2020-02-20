package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ADG_4357.WithType1DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CurrentlyTreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.cv_study.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class CV_4450_OLS extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "sites")
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_CV1_4450S_Syn},
        };
    }

    @Test(dataProvider = "sites")
    @Description("CV 4450 OLS Novo Nordisk CV")
    public void cv4450olsTest(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String studyName = "a heart health";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a heart health study", "750");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
                dateOfBirthPageOLS.getExpectedModifiedTitle("a heart health study", "750"),
                "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01081976")//"Disqualify (“Age”) if < 45
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01081970")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        //Q3: QS	Certain conditions are more closely linked to cardiovascular disease than others.
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension",
                        "Chronic Kidney Disease")
                .clickOnAnswers("None of the above") //skip to Q13 (current lipid lowering med use)
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        //Q14
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS =
                cardiovascularDiseaseThanOthersPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("High cholesterol or high triglycerides") //go to Q4 (NEW Q4)
                        .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS());

        //Q4 Have you had a blood test that confirms you have high cholesterol or high triglycerides?
        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS =
                haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                        .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());

        //Q13 Are you currently taking medication to manage high cholesterol, triglycerides, or lipids?
        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .back(haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS)
                .waitForPageLoad()
                .back();


        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        //Q5	What kind of diabetes do you have?
        WithType1DiabetesPageOLS withType1DiabetesPageCC = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageOLS());
        withType1DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        SufferedFollowingHeartRelatedConditionsPageOLS sufferedFollowingHeartRelatedConditionsPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes")
                .clickOnAnswer("Unsure")
                .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageOLS());

        HeartRelatedSurgeriesProceduresPageOLS heartRelatedSurgeriesProceduresPageOLS =
                sufferedFollowingHeartRelatedConditionsPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack",
                                "Stroke",
                                "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                                "Heart failure or congestive heart failure (CHF)")
                        .clickOnAnswers("None of the above") //Skip to Q16
                        .clickNextButton(new HeartRelatedSurgeriesProceduresPageOLS());

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .back();

        SubquestionHeartPageOLS subquestionHeartPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionHeartPageOLS());

        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageOLS.titleExpected4)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.1	When was the last time that you experienced had a heart attack?
        List<String> disqualifyQ15 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.1: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.2	When was the last time that you experienced had a stroke?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.2: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.3	When was the last time that you experienced had a mini-stroke or TIA?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.3: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected3)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.4	When was the last time that you experienced suffered from angina or chest pain that required you to stay in a hospital overnight?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.4: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected4)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS);

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        MostRecentHeartRelatedSurgeryProcedurePageOLS mostRecentHeartRelatedSurgeryProcedurePageOLS =
                heartRelatedSurgeriesProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Stent placement in your heart, neck or legs")
                        .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLS());

        //Q17	When was your most recent heart-related surgery or procedure?
        AdditionalHeartRelatedConditionsPageOLS additionalHeartRelatedConditionsPageOLS =
                new AdditionalHeartRelatedConditionsPageOLS();
        List<String> disqualifyQ17 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ17) {
            System.out.println("Select answer for Q17: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6739", site.activeProtocols)
                    .back();
        }
        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS);

        //Q18	Have you ever been diagnosed with any of the following additional heart-related conditions?
        ApproximateHeightPageOLS approximateHeightPageOLS = additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

//------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS =
                approximateHeightPageOLS
                        .waitForPageLoad()
                        .setAll("5", "5", "170")
                        .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .back(mostRecentHeartRelatedSurgeryProcedurePageOLS)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke") //Qualifying answer Ghost Question
                .clickNextButton(subquestionHeartPageOLS)
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageOLS)
                .waitForPageLoad()
                .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS);
        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .back(mostRecentHeartRelatedSurgeryProcedurePageOLS)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .back(subquestionHeartPageOLS)
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageOLS.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //deselect previous qualifying answer
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Any other surgery on the arteries in your legs, neck or heart") //Qualifying answer Ghost Question
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageOLS)
                .waitForPageLoad()
                .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .back(mostRecentHeartRelatedSurgeryProcedurePageOLS)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)") //Qualifying answer Ghost Question
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);
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
            healthcareDiagnosedConditionsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back();
        }
        IdentificationPageOLS identificationPageOLS = healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AlzheimerClosePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
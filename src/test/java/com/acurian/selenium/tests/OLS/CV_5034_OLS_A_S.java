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
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class CV_5034_OLS_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "5034Sites")
    public static Object[][] getData() {
        return new Object[][]{
                {Site.AUT_CV_5034A_site},
                {Site.AUT_CV_5034S_site}
        };
    }

    @Test(dataProvider = "5034Sites")
    @Description("CV_5034_OLS_A_S")
    public void cv5034olsTest(Site site) {
        final String phoneNumber = "AUTAMS1CV1";
        final String studyName = "a heart health";

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
                .setDate("01081990")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        List<String> disqualifyQ3 = Arrays.asList("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides",
                "High blood pressure or hypertension", "Chronic Kidney Disease");
        for (String answer : disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            cardiovascularDiseaseThanOthersPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                    .back();
        }
        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS =
                cardiovascularDiseaseThanOthersPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides")
                        .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS());

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = new WhatKindOfDiabetesPageOLS();
        if (site == Site.AUT_CV_5034A_site) {
            haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("No")
                    .clickNextButton(whatKindOfDiabetesPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6735", site.activeProtocols)
                    .back();
        }
        haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                .clickNextButton(whatKindOfDiabetesPageOLS);

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
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                whatKindOfDiabetesPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS1 = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
        currentlyTreatingYourDiabetesPageOLS1
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        //Q6	How long ago were you diagnosed with type 2 diabetes?
        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());
        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6705", site.activeProtocols)
                .back(withType2DiabetesPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);

        //Q13	Are you currently taking medication to manage high cholesterol, triglycerides, or lipids?
        SufferedFollowingHeartRelatedConditionsPageOLS sufferedFollowingHeartRelatedConditionsPageOLS =
                cholesterolTriglyceridesLipidsPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageOLS());
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6734", site.activeProtocols)
                .back(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(sufferedFollowingHeartRelatedConditionsPageOLS);

        //Q15
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
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(subquestionHeartPageOLS);

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        MostRecentHeartRelatedSurgeryProcedurePageOLS mostRecentHeartRelatedSurgeryProcedurePageOLS =
                heartRelatedSurgeriesProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Stent placement in your heart, neck or legs")
                        .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLS());

        //Q17	When was your most recent heart-related surgery or procedure?
        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .back();

        AdditionalHeartRelatedConditionsPageOLS additionalHeartRelatedConditionsPageOLS =
                heartRelatedSurgeriesProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS());

        //Q18	Have you ever been diagnosed with any of the following additional heart-related conditions?
        ApproximateHeightPageOLS approximateHeightPageOLS = additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        //Q22
        //------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS1)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .clickOnQNumber("QS6736");

        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight") //Qualifying answer
                .clickNextButton(subquestionHeartPageOLS)
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS);
        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());
        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .clickOnQNumber("QS6736");

        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs",
                        "Heart bypass surgery or Coronary Artery Bypass Graft (CABG)",
                        "Any other surgery on the arteries in your legs, neck or heart")
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .clickNextButton(healthcareDiagnosedConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .clickOnQNumber("QS6738");

        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)",
                        "Heart disease such as coronary artery disease (CAD)",
                        "Carotid artery disease (narrowing or blockage of the major arteries in your neck)",
                        "Stenosis (narrowing of the blood vessels or arteries)")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

//------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = new CurrentlyTreatingYourDiabetesPageOLS();
        List<String> options = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String entry : options) {
            System.out.println(entry);
            healthcareDiagnosedConditionsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry)
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
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        /*MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());

        ChatfillMedicalRecordReleaseFormPageOLS chatfillMedicalRecordReleaseFormPageOLS = medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new ChatfillMedicalRecordReleaseFormPageOLS());

        AdobeSignMedAuthFormPage adobeSignMedAuthFormPage = chatfillMedicalRecordReleaseFormPageOLS
                .waitForPageLoad()
                .confirmPatientInformation()
                .setAllDataMedicalRecordReleaseForm("Acurian", "PA", "9999999999",
                        "2 walnut grove dr.", "HORSHAM", "19901")
                .clickSignForm(new AdobeSignMedAuthFormPage());

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = adobeSignMedAuthFormPage
                .waitForPageLoad()
                .setSignature("Acurian Trial")
                .clickToSignButton(new ThankYouCloseSimplePageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);

        switch (site) {
            case AUT_CV_5034A_site:
                aboutHealthPageOLS
                        .assertGeneratedFul(env, site);
                break;
            case AUT_CV_5034S_site:
                aboutHealthPageOLS
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env);
                break;
        }*/

        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());

        DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS());

        HS1PageOLS hS1PageOLS = doctorInformationCollectionPageOLS
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS());

        hS1PageOLS
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS =new ThankYouCloseSimplePageOLS();
        thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo)
                .assertRmgOrderPriority(env, "5034");
    }
}
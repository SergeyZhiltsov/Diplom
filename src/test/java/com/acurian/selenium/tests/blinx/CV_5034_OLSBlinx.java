package com.acurian.selenium.tests.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.*;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.cv_study.*;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.gmega.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ApproximateHeightWeightPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CV_5034_OLSBlinx extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "data")
    private Object[][] getTestData() {
        return new Object[][]{
                {Site.AUT_CV_5034A_site, "Cincinnati", "Ohio"},
                {Site.AUT_CV_5034S_site, "Dover", "Delaware"}
        };
    }

    @Test(dataProvider = "data", enabled = false) //todo turn on after PDV
    public void CV_5034_Blinx(Site site, String city, String state) {
        String phoneNumber = "AUTAMS1CV1";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS);

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("01081990")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

//        ConfirmsHighCholesterolTriglyceridesPageOLS confirmsHighCholesterolTriglyceridesPageOLS = cardiovascularDiseasePageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides")
//                .clickNextButton(new ConfirmsHighCholesterolTriglyceridesPageOLS());

        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();

        List<String> disqualifyQ3 = Arrays.asList("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides",
                "High blood pressure or hypertension");
        for (String answer : disqualifyQ3) {
            System.out.println("Select an swer for Q3: " + answer);
            cardiovascularDiseaseThanOthersPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                    .back(cardiovascularDiseaseThanOthersPageOLS);
        }
        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back(cardiovascularDiseaseThanOthersPageOLS);

        ConfirmsHighCholesterolTriglyceridesPageOLS confirmsHighCholesterolTriglyceridesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides")
                .clickNextButton(new ConfirmsHighCholesterolTriglyceridesPageOLS());

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = new WhatKindOfDiabetesPageOLS();

        if (site == Site.AUT_CV_5034A_site) {
            confirmsHighCholesterolTriglyceridesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("No")
                    .clickNextButton(whatKindOfDiabetesPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6735", site.activeProtocols)
                    .back(confirmsHighCholesterolTriglyceridesPageOLS);
        }

        confirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                .clickNextButton(whatKindOfDiabetesPageOLS);

        //Q5	What kind of diabetes do you have?
        WithType1DiabetesPageOLS withType1DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageOLS());

        withType1DiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);

        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);

        WithType2diabetesPageOLS withType2diabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2diabetesPageOLS());

        //Q6	How long ago were you diagnosed with type 2 diabetes?
        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = withType2diabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());
        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6705", site.activeProtocols)
                .back(withType2diabetesPageOLS);
        withType2diabetesPageOLS
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
                .back(cholesterolTriglyceridesLipidsPageOLS);
        cholesterolTriglyceridesLipidsPageOLS
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
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);

        SubquestionHeartPageOLS subquestionHeartPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionHeartPageOLS());

        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .waitForPageLoad(3, subquestionHeartPageOLS.getTitleExpected3())
                .waitForPageLoad(4, subquestionHeartPageOLS.getTitleExpected4())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
        sufferedFollowingHeartRelatedConditionsPageOLS
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
        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS);

        AdditionalHeartRelatedConditionsPageOLS additionalHeartRelatedConditionsPageOLS =
                heartRelatedSurgeriesProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS());

        //Q18	Have you ever been diagnosed with any of the following additional heart-related conditions?
        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightWeightPageOLS());

        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS);

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .clickOnQNumber("QS6736");

        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight") //Qualifying answer
                .clickNextButton(subquestionHeartPageOLS);

        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .waitForPageLoad(3, subquestionHeartPageOLS.getTitleExpected3())
                .waitForPageLoad(4, subquestionHeartPageOLS.getTitleExpected4())
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(5, "Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS);

        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS);

        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightWeightPageOLS);

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .clickOnQNumber("QS6736");

        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS);

        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs",
                        "Heart bypass surgery or Coronary Artery Bypass Graft (CABG)",
                        "Any other surgery on the arteries in your legs, neck or heart")
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageOLS);

        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS);

        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightWeightPageOLS);

        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .clickOnQNumber("QS6738");

        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS);

        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)",
                        "Heart disease such as coronary artery disease (CAD)",
                        "Carotid artery disease (narrowing or blockage of the major arteries in your neck)",
                        "Stenosis (narrowing of the blood vessels or arteries)")
                .clickNextButton(approximateHeightWeightPageOLS);

        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

//------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------
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
                    .back(healthcareDiagnosedConditionsPageOLS);
        }

        IdentificationPageOLS identificationPageOLS = healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoadPrequalified()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode, city, state)
                .clickNextButton(new SiteSelectionPageOLS());

        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad5("a heart health study!")
                .getPage(debugPageOLS)
                .getPID()
                .getPage(siteSelectionPageOLS)
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());

        DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS()); //trick
        HS1PageOLS hs1PageOLS = doctorInformationCollectionPageOLS
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS());


//        ChatfillMedicalRecordReleaseFormPageOLS chatfillMedicalRecordReleaseFormPageOLS =
//                new ChatfillMedicalRecordReleaseFormPageOLS();

        hs1PageOLS
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();
//                .waitToClickNext()
//                .getPage(new AdobeSignMedAuthFormPageBlinx());
//                .setAllDataMedicalRecordReleaseForm("Acurian", "PA", "9999999999",
//                        "2 walnut grove dr.", "HORSHAM", "19901")
//                .clickSignForm(new AdobeSignMedAuthFormPageBlinx());

//        adobeSignMedAuthFormPageBlinx
//                .waitForPageLoad()
//                .setSignature("Acurian Trial")
//                .clickToSignButton(adobeSignMedAuthFormPageBlinx); //trick

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}

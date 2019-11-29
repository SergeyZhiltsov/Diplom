package com.acurian.selenium.tests.OLS.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.closes.AdobeSignMedAuthFormPage;
import com.acurian.selenium.pages.OLS.closes.ChatfillMedicalRecordReleaseFormPageOLS;
import com.acurian.selenium.pages.blinx.DebugPageBlinxOLS;
import com.acurian.selenium.pages.blinx.ams.*;
import com.acurian.selenium.pages.blinx.gmega.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ApproximateHeightWeightPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.PersonalIdentificationPageOLS;
import com.sun.xml.internal.bind.v2.TODO;
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
        return new Object[][] {
                {Site.AUT_CV_5034A_site, "Cincinnati", "Ohio"},
                {Site.AUT_CV_5034S_site, "Dover", "Delaware" }
        };
    }

    @Test(dataProvider = "data") //todo turn on after PDV
    public void cv5034olsBlinxTest(Site site, String city, String state) {
        DebugPageBlinxOLS debugPageBlinxOLS = new DebugPageBlinxOLS();
        LetsGetStartedPageOLS letsGetStartedPageOLS = new LetsGetStartedPageOLS();

        String env = System.getProperty("acurian.env", "STG");

        String url = null;
        switch (env) {
    case "PRD":
        url = "https://screener.acurianhealth.com/welcome.do?method=beginCall&phoneNumber=AUTAMS1CV1&up[]" +
                        "=CLIENT_BLINX&testing_key=51fa2780f2430b542923956ac1974bb7&show_debug=1#";
        break;
    case "STG":
        url = "https://sf.acu2.aws.blinxsolutions.systems/welcome.do?method=beginCall&phoneNumber=AUTAMS1CV1&up[]" +
                "=CLIENT_BLINX&testing_key=51fa2780f2430b542923956ac1974bb7&show_debug=1#";
        break;
}
        BaseTest.getDriver().navigate().to(url);

        LessThan18YearsOldPageOLSBlinx lessThan18YearsOldPageOLSBlinx = letsGetStartedPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLSBlinx());

        lessThan18YearsOldPageOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .clickPreviousQuestion();

        ZipCodePageOLS zipCodePageOLS = letsGetStartedPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        DateOfBirthAndGenderPageOLS dateOfBirthAndGenderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new DateOfBirthAndGenderPageOLS());

        dateOfBirthAndGenderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLSBlinx)
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .clickPreviousQuestion();
        CardiovascularDiseasePageOLS cardiovascularDiseasePageOLS = dateOfBirthAndGenderPageOLS
                .waitForPageLoad()
                .setDate("01081990")
                .clickNextButton(new CardiovascularDiseasePageOLS());

//        ConfirmsHighCholesterolTriglyceridesPageOLS confirmsHighCholesterolTriglyceridesPageOLS = cardiovascularDiseasePageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides")
//                .clickNextButton(new ConfirmsHighCholesterolTriglyceridesPageOLS());

        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx();

        List<String> disqualifyQ3 = Arrays.asList("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides",
                "High blood pressure or hypertension");
        for (String answer : disqualifyQ3) {
            System.out.println("Select an swer for Q3: " + answer);
            cardiovascularDiseasePageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx)
                    .waitForPageLoad()
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                    .clickPreviousQuestion();
        }
        cardiovascularDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx)
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .clickPreviousQuestion();

        ConfirmsHighCholesterolTriglyceridesPageOLS confirmsHighCholesterolTriglyceridesPageOLS = cardiovascularDiseasePageOLS
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
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6735", site.activeProtocols)
                    .clickPreviousQuestion();
        }

        confirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                .clickNextButton(whatKindOfDiabetesPageOLS);

        //Q5	What kind of diabetes do you have?
        WithType1DiabetesPageOLSBlinx withType1DiabetesPageOLSBlinx = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageOLSBlinx());

        withType1DiabetesPageOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .clickPreviousQuestion();

        whatKindOfDiabetesPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .clickPreviousQuestion();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .clickPreviousQuestion();
        CurrentlyTreatingYourDiabetesPageOLSBlinx currentlyTreatingYourDiabetesPageOLSBlinx = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLSBlinx());
        currentlyTreatingYourDiabetesPageOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .clickPreviousQuestion();

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
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6705", site.activeProtocols)
                .clickPreviousQuestion();
        withType2diabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);

        //Q13	Are you currently taking medication to manage high cholesterol, triglycerides, or lipids?
        HeartRelatedEventsOrConditionsPageOLS heartRelatedEventsOrConditionsPageOLS =
                cholesterolTriglyceridesLipidsPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HeartRelatedEventsOrConditionsPageOLS());
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6734", site.activeProtocols)
                .clickPreviousQuestion();
        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(heartRelatedEventsOrConditionsPageOLS);

        //Q15
        HeartRelatedSurgeriesOrProceduresPageOLS heartRelatedSurgeriesOrProceduresPageOLS =
                heartRelatedEventsOrConditionsPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack",
                                "Stroke",
                                "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                                "Heart failure or congestive heart failure (CHF)")
                        .clickOnAnswers("None of the above") //Skip to Q16
                        .clickNextButton(new HeartRelatedSurgeriesOrProceduresPageOLS());

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();

        SubquestionHeartPageOLS subquestionHeartPageOLS = heartRelatedEventsOrConditionsPageOLS
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
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS);

        //Q16	Have you ever had any of the following heart-related surgeries or procedures?
        MostRecentHeartRelatedSurgeryProcedurePageOLSBlinx mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx =
                heartRelatedSurgeriesOrProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Stent placement in your heart, neck or legs")
                        .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLSBlinx());

        //Q17	When was your most recent heart-related surgery or procedure?
        mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx
                .waitForPageLoad()
                .clickPreviousQuestion();

        AdditionalHeartrelatedConditionsPageOLS additionalHeartrelatedConditionsPageOLS =
                heartRelatedSurgeriesOrProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new AdditionalHeartrelatedConditionsPageOLS());

        //Q18	Have you ever been diagnosed with any of the following additional heart-related conditions?
        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightWeightPageOLS());

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .clickOnQNumber("QS6736");

        heartRelatedEventsOrConditionsPageOLS
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
                .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS);

        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad();









//        confirmsHighCholesterolTriglyceridesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides");
//        if (site == Site.AUT_CV_5034S_site) {
//            confirmsHighCholesterolTriglyceridesPageOLS
//                    .clickOnAnswers("No");
//        }
//        confirmsHighCholesterolTriglyceridesPageOLS
//                        .clickNextButton(whatKindOfDiabetesPageOLS);
//
//        WithType2diabetesPageOLS withType2diabetesPageOLS = whatKindOfDiabetesPageOLS
//                        .waitForPageLoad()
//                        .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
//                        .clickNextButton(new WithType2diabetesPageOLS());
//
//        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = withType2diabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("3 - 6 months ago")
//                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());
//
//        HeartRelatedEventsOrConditionsPageOLS heartRelatedEventsOrConditionsPageOLS = cholesterolTriglyceridesLipidsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new HeartRelatedEventsOrConditionsPageOLS());
//
//        SubquestionHeartPageOLS subquestionHeartPageOLS = heartRelatedEventsOrConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Heart attack", "Stroke")
//                .clickNextButton(new SubquestionHeartPageOLS());
//
//        HeartRelatedSurgeriesOrProceduresPageOLS heartRelatedSurgeriesOrProceduresPageOLS = subquestionHeartPageOLS
//                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
//                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickNextButton(new HeartRelatedSurgeriesOrProceduresPageOLS());
//
//        AdditionalHeartrelatedConditionsPageOLS additionalHeartrelatedConditionsPageOLS =
//                heartRelatedSurgeriesOrProceduresPageOLS
//                        .waitForPageLoad()
//                        .clickOnAnswers("None of the above")
//                        .clickNextButton(new AdditionalHeartrelatedConditionsPageOLS());
//
//        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = additionalHeartrelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new ApproximateHeightWeightPageOLS());
//
//        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightWeightPageOLS
//                .waitForPageLoad()
//                .setAllFields("5", "5", "170")
//                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());
//
//        PersonalIdentificationPageOLS personalIdentificationPageOLS = healthcareDiagnosedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new PersonalIdentificationPageOLS());
//
//        SiteSelectionPageOLS siteSelectionPageOLS = personalIdentificationPageOLS
//                .waitForPageLoadPrequalified()
//                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
//                        "9999999999", site.zipCode, city, state)
//                .clickNextButton(new SiteSelectionPageOLS());
//
//        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
//                .waitForPageLoad5("a heart health study!")
//                .getPage(debugPageBlinxOLS)
//                .getPID()
//                .getPage(siteSelectionPageOLS)
//                .clickOnFacilityName(site.name)
//                .clickNextButton(new MedicalRecordsOptionPageOLS());
//
//        DoctorInformationCollectionPageOLSBlinx doctorInformationCollectionPageOLSBlinx = medicalRecordsOptionPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Continue with medical records")
//                .clickNextButton(new DoctorInformationCollectionPageOLSBlinx()); //trick
//        HS1PageOLSBlinx hs1PageOLSBlinx = doctorInformationCollectionPageOLSBlinx
//                .waitForPageLoad()
//                .clickNextButton(new HS1PageOLSBlinx());
//
//
//
//
////        ChatfillMedicalRecordReleaseFormPageOLS chatfillMedicalRecordReleaseFormPageOLS =
////                new ChatfillMedicalRecordReleaseFormPageOLS();
//
//        hs1PageOLSBlinx
//                .waitForPageLoad()
//                .clickOkInPopUp()
//                .setSignature();
////                .waitToClickNext()
////                .getPage(new AdobeSignMedAuthFormPageBlinx());
////                .setAllDataMedicalRecordReleaseForm("Acurian", "PA", "9999999999",
////                        "2 walnut grove dr.", "HORSHAM", "19901")
////                .clickSignForm(new AdobeSignMedAuthFormPageBlinx());
//
////        adobeSignMedAuthFormPageBlinx
////                .waitForPageLoad()
////                .setSignature("Acurian Trial")
////                .clickToSignButton(adobeSignMedAuthFormPageBlinx); //trick
//
//        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
//
//        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
//                .waitForPageLoad()
//                .clickNextButton(new AboutHealthPageOLS());
//
//        aboutHealthPageOLS
//                .waitForPageLoad()
//                .pidFromDbToLog(env)
//                .childPidFromDbToLog(env)
//                .dispoShouldMatch(site.dispo, site.dispo);
    }
}

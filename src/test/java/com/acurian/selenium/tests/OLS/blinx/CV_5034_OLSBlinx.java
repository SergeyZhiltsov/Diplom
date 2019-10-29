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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "data", enabled = false) //todo turn on after PDV
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

        ZipCodePageOLS zipCodePageOLS = letsGetStartedPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        DateOfBirthAndGenderPageOLS dateOfBirthAndGenderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new DateOfBirthAndGenderPageOLS());

        CardiovascularDiseasePageOLS cardiovascularDiseasePageOLS = dateOfBirthAndGenderPageOLS
                .waitForPageLoad()
                .setDate("01081970")
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseasePageOLS());

        ConfirmsHighCholesterolTriglyceridesPageOLS confirmsHighCholesterolTriglyceridesPageOLS = cardiovascularDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides")
                .clickNextButton(new ConfirmsHighCholesterolTriglyceridesPageOLS());

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = new WhatKindOfDiabetesPageOLS();
        confirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides");
        if (site == Site.AUT_CV_5034S_site) {
            confirmsHighCholesterolTriglyceridesPageOLS
                    .clickOnAnswers("No");
        }
        confirmsHighCholesterolTriglyceridesPageOLS
                        .clickNextButton(whatKindOfDiabetesPageOLS);

        WithType2diabetesPageOLS withType2diabetesPageOLS = whatKindOfDiabetesPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                        .clickNextButton(new WithType2diabetesPageOLS());

        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = withType2diabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());

        HeartRelatedEventsOrConditionsPageOLS heartRelatedEventsOrConditionsPageOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HeartRelatedEventsOrConditionsPageOLS());

        SubquestionHeartPageOLS subquestionHeartPageOLS = heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke")
                .clickNextButton(new SubquestionHeartPageOLS());

        HeartRelatedSurgeriesOrProceduresPageOLS heartRelatedSurgeriesOrProceduresPageOLS = subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickNextButton(new HeartRelatedSurgeriesOrProceduresPageOLS());

        AdditionalHeartrelatedConditionsPageOLS additionalHeartrelatedConditionsPageOLS =
                heartRelatedSurgeriesOrProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new AdditionalHeartrelatedConditionsPageOLS());

        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightWeightPageOLS());

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        PersonalIdentificationPageOLS personalIdentificationPageOLS = healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PersonalIdentificationPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = personalIdentificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode, city, state)
                .clickNextButton(new SiteSelectionPageOLS());

        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad("a heart health study!")
                .getPage(debugPageBlinxOLS)
                .getPID()
                .getPage(siteSelectionPageOLS)
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());

        medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(siteSelectionPageOLS); //trick

        ChatfillMedicalRecordReleaseFormPageOLS chatfillMedicalRecordReleaseFormPageOLS =
                new ChatfillMedicalRecordReleaseFormPageOLS();

        AdobeSignMedAuthFormPage adobeSignMedAuthFormPage = chatfillMedicalRecordReleaseFormPageOLS
                .waitForPageLoad()
                .confirmPatientInformation()
                .setAllDataMedicalRecordReleaseForm("Acurian", "PA", "9999999999",
                        "2 walnut grove dr.", "HORSHAM", "19901")
                .clickSignForm(new AdobeSignMedAuthFormPage());

        adobeSignMedAuthFormPage
                .waitForPageLoad()
                .setSignature("Acurian Trial")
                .clickToSignButton(adobeSignMedAuthFormPage); //trick

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

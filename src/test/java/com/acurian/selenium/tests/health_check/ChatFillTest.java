package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GBAN.LetsStartPageOLS;
import com.acurian.selenium.pages.OLS.RA.UndergoneGeneticTestingPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.cv_study.HealthcareDiagnosedConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ChatFillTest extends BaseTest {

    @Test()
    public void chatFillTest() {
        String phoneNumber = "GBAN100011";
        String testUrl = "https://test-screener.acurian.com/questionnaire_test_qa_chartfill/welcome?pn=" + phoneNumber;
        String siteZipCode = "19044";

        WebDriver driver = getDriver();
        driver.navigate().to(testUrl);

        LetsStartPageOLS letsStartPageOLS = new LetsStartPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = letsStartPageOLS
                .waitForPageLoad()
                .clickNextButton(new DateOfBirthPageOLS());

        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("01011950")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());
        PersonalDetails personalDetails = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new PersonalDetails());
        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        siteZipCode)
                .clickNextButton(new GenderPageOLS());
        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());
        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());
        UndergoneGeneticTestingPageOLS undergoneGeneticTestingPageOLS = healthcareDiagnosedConditionsPageOLS
                .waitForPageLoadGBAN()
                .clickOnAnswersGBAN("Alzheimer's disease")
                .clickNextButton(new UndergoneGeneticTestingPageOLS());
        undergoneGeneticTestingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have or can get the results")
                .clickNextButton(personalDetails);
        SiteSelectionPageOLS siteSelectionPageOLS = personalDetails
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());
        HSCrohns2PageOLS hsCrohns2PageOLS = siteSelectionPageOLS
                .waitForPageLoad("")
                //.clickOnDebugSiteName("QSC9004_AUT_GRAD2_3138")
                .clickOnFacilityName("AUT_GBAN1_2929")
                .clickNextButton(new HSCrohns2PageOLS());
        ChatfillMedicalRecordReleaseFormPageOLS chatfillMedicalRecordReleaseFormPageOLS = hsCrohns2PageOLS
                .waitForPageLoadGBAN()
                .clickNextButton(new ChatfillMedicalRecordReleaseFormPageOLS());
        AdobeSignMedAuthFormPage adobeSignMedAuthFormPage = chatfillMedicalRecordReleaseFormPageOLS
                .waitForPageLoad()
                .confirmPatientInformation()
                .setAllDataMedicalRecordReleaseForm("Acurian", "PA", "9999999999",
                        "2 walnut grove dr.", "HORSHAM", siteZipCode)
                .clickSignForm(new AdobeSignMedAuthFormPage());
        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = adobeSignMedAuthFormPage
                .waitForPageLoad()
                .setSignature("Acurian")
                .clickToSignButton(new ThankYouCloseGmegaOLS());
        thankYouCloseGmegaOLS
                .waitForPageLoadByTitle(thankYouCloseGmegaOLS.titleExpectedGBAN)
                .clickNextButton(new AboutHealthPageOLS());
    }
}
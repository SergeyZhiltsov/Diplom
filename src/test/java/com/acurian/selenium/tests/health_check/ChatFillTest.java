package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.AS.DashBoardPage;
import com.acurian.selenium.pages.AS.LoginPageAS;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GBAN.LetsStartPageOLS;
import com.acurian.selenium.pages.OLS.GBAN.ThanksPageOLS;
import com.acurian.selenium.pages.OLS.RA.UndergoneGeneticTestingPageOLS;
import com.acurian.selenium.pages.OLS.closes.AdobeSignMedAuthFormPage;
import com.acurian.selenium.pages.OLS.closes.ChatfillMedicalRecordReleaseFormPageOLS;
import com.acurian.selenium.pages.OLS.closes.HSCrohns2PageOLS;
import com.acurian.selenium.pages.OLS.cv_study.HealthcareDiagnosedConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChatFillTest extends BaseTest {

    String env = System.getProperty("acurian.env", "QA");

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    public void chatFillTestRun(String userName, String password) {
        if (env.equals("PRD")) {
            System.out.println("Skipped for PRD environment");
        } else {
            chatFillTest(userName, password);
        }
    }

    public void chatFillTest(String userName, String password) {
        String phoneNumber = "GBAN100001";
        //String testUrl = "https://test-screener.acurian.com/questionnaire_test_qa_chartfill/welcome?pn=" + phoneNumber;
        String siteZipCode = "19044";

        LetsStartPageOLS letsStartPageOLS = new LetsStartPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        letsStartPageOLS
                .getPage(dateOfBirthPageOLS)
                .openPage(env, phoneNumber);

        letsStartPageOLS
                    .waitForPageLoadByTitle(letsStartPageOLS.titleExpectedQA)
                    .clickNextButton(dateOfBirthPageOLS);

        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .waitForPageLoadGBAN()
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
                .waitForPageLoadByTitle(genderPageOLS.titleExpected)
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

        siteSelectionPageOLS
                .waitForPageLoadGBAN();
        String screenerPID = siteSelectionPageOLS.getPidNumber();
        HSCrohns2PageOLS hsCrohns2PageOLS = siteSelectionPageOLS
        .clickOnFacilityName("AUT_GBAN1_2929")
                .clickNextButton(new HSCrohns2PageOLS());

        ChatfillMedicalRecordReleaseFormPageOLS chatfillMedicalRecordReleaseFormPageOLS = hsCrohns2PageOLS
                .waitForPageLoadGBAN()
                .clickNextButton(new ChatfillMedicalRecordReleaseFormPageOLS());

        AdobeSignMedAuthFormPage adobeSignMedAuthFormPage = chatfillMedicalRecordReleaseFormPageOLS
                .waitForPageLoad()
                .confirmPatientInformation()
                .setAllDataMedicalRecordReleaseForm("Acurian", "PA", "9999999999",
                        "2 walnut grove dr.", env.equals("QA") ? "Horsham" : "HORSHAM", siteZipCode)
                .clickSignForm(new AdobeSignMedAuthFormPage());

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = adobeSignMedAuthFormPage
                .waitForPageLoad()
                .setSignature("Acurian")
                .clickToSignButton(new ThankYouCloseGmegaOLS());

        ThanksPageOLS thanksPageOLS = thankYouCloseGmegaOLS
                .waitForPageLoadByTitle(thankYouCloseGmegaOLS.titleExpectedGBAN)
                .clickNextButton(new ThanksPageOLS());

        thanksPageOLS.waitForPageLoad();

        LoginPageAS loginPageAS = new LoginPageAS();
        loginPageAS
                .openPage(env)
                .loginToAs(userName, password)
                .clickSideMenuLink("Audit Log")
                .setRequestedByFilter("chartfillAPI, chartfillAPI")
                .setSearchAppFilter("ChartFill")
                .clickSearchButtonAndWaitResults()
                .clickFirstViewButtonFomList();
        DashBoardPage dashBoardPage = new DashBoardPage();
        String auditLogPID = dashBoardPage.getPatientIdFromRequestBody();
        Assert.assertEquals(screenerPID, auditLogPID, "PIDs are different");
        Assert.assertEquals("200", dashBoardPage.getResponseCodeFromResponseBody(),
                "Response was not 200 OK");
    }
}
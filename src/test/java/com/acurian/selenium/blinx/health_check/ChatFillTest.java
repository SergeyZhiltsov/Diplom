package com.acurian.selenium.blinx.health_check;

import com.acurian.selenium.pages.AS.DashBoardPage;
import com.acurian.selenium.pages.AS.LoginPageAS;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.AdobeSignMedAuthFormPage;
import com.acurian.selenium.pages.blinx.ams.closes.ChatfillMedicalRecordReleaseFormPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.HSCrohns2PageOLS;
import com.acurian.selenium.pages.blinx.ams.cv_study.HealthcareDiagnosedConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.gban.LetsStartPageOLS;
import com.acurian.selenium.pages.blinx.ams.gban.ThanksPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.ra.UndergoneGeneticTestingPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.PersonalDetails;
import com.acurian.selenium.pages.blinx.gmega.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ThankYouCloseGmegaOLS;
import com.acurian.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChatFillTest extends BaseTest {

    String env = System.getProperty("acurian.env", "QA");

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
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
                .waitForPageLoad1()
                .setDate("01011950")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        PersonalDetails personalDetails = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999",
                        siteZipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpected)
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoadGMEGA()
                .setAll("5", "5", "160")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        UndergoneGeneticTestingPageOLS undergoneGeneticTestingPageOLS = healthcareDiagnosedConditionsPageOLS
                .waitForPageLoadGBAN()
                .clickOnAnswers("Alzheimer's disease")
                .clickNextButton(new UndergoneGeneticTestingPageOLS());

        undergoneGeneticTestingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have or can get the results")
                .clickNextButton(personalDetails);

        SiteSelectionPageOLS siteSelectionPageOLS = personalDetails
                .waitForPageLoadByTitle(personalDetails.titleExpected)
                .clickNextButton(new SiteSelectionPageOLS());

        siteSelectionPageOLS
                .waitForPageLoadGBAN()
                .getPID();
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
                        "2 walnut grove dr.", env.equals("STG") ? "Horsham" : "HORSHAM", siteZipCode)
                .clickSignForm(new AdobeSignMedAuthFormPage());

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = adobeSignMedAuthFormPage
                .waitForPageLoad()
                .setSignature("Acurian")
                .clickToSignButton(new ThankYouCloseGmegaOLS());

        ThanksPageOLS thanksPageOLS = thankYouCloseGmegaOLS
                .waitForPageLoadByTitle(thankYouCloseGmegaOLS.titleExpectedGBAN)
                .clickNextButton(new ThanksPageOLS());

        thanksPageOLS.waitForPageLoad();

        if (env.equals("STG")) {
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

}
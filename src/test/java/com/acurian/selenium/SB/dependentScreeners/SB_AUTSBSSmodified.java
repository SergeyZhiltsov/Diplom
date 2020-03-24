package com.acurian.selenium.SB.dependentScreeners;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega.HasAHealthcareDiagnosedWithAnyTypeOfArthOLS;
import com.acurian.selenium.pages.OLS.gmega.HaveYouExperiencedanyOftheFollowingConfOLS;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.GBAN.ThanksPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SB_AUTSBSSmodified extends BaseTest{

    @Test(enabled = true)
    @TestCaseId("001124")
    @Description("SB_Standalone test Screener")
    public void sb_AUTSBSSmodified() {
        String phoneNumber = "AUTSBSS001";
        String siteName = "AUT_SB_SS_site";
        String zipCode = "19901";
        String env = System.getProperty("acurian.env", "QA");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad1();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), "What is your date of birth? (some text modified)",
                "Question is diff");
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        zipCode)
                .clickNextButton(new GenderPageOLS());

        HasAHealthcareDiagnosedWithAnyTypeOfArthOLS hasAHealthcareDiagnosedWithAnyTypeOfArthOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female1")
                .clickNextButton(new HasAHealthcareDiagnosedWithAnyTypeOfArthOLS());

        HaveYouExperiencedanyOftheFollowingConfOLS haveYouExperiencedanyOftheFollowingConfOLS =
                hasAHealthcareDiagnosedWithAnyTypeOfArthOLS
                .waitForPageLoadSB()
                .clickOnAnswers_SB("Rheumatoid Arthritis, a serious disease caused by your immune system attacking your " +
                        "joints, which can cause fatigue with pain and swelling of multiple joints throughout your body")
                .clickNextButton(new HaveYouExperiencedanyOftheFollowingConfOLS());

        IdentificationPageOLS identificationPageOLS = haveYouExperiencedanyOftheFollowingConfOLS
                .waitForPageLoadSB()
                .clickOnAnswers_SB("None of the above")
                .clickNextButton(new IdentificationPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoadSB()
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .clickOnFacilityName(siteName)
                .getPID()
                .clickNextButton(new QualifiedClose2PageOLS());

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = qualifiedClose2PageOLS
                .waitForPageLoad_SB()
                .clickNextButton(new ThankYouCloseGmegaOLS());

        ThanksPageOLS thanksPageOLS = thankYouCloseGmegaOLS
                .waitForPageLoadByTitle(thankYouCloseGmegaOLS.titleExpectedSB)
                .clickNextButton(new ThanksPageOLS());

        thanksPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch("1R");
    }
}
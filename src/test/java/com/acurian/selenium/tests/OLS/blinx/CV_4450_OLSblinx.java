package com.acurian.selenium.tests.OLS.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.DebugPageBlinxOLS;
import com.acurian.selenium.pages.blinx.ams.*;
import com.acurian.selenium.pages.blinx.gmega.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ApproximateHeightWeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.QualifiedClosePageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.PersonalIdentificationPageOLS;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CV_4450_OLSblinx extends BaseTest {

    @DataProvider(name = "data")
    private Object[][] getTestData() {
        return new Object[][] {
                {Site.AUT_CV1_4450S_Syn, "Dover", "Delaware" }
        };
    }

    @Test(dataProvider = "data")
    public void cv4450olsBlinxTest(Site site, String city, String state) {
        DebugPageBlinxOLS debugPageBlinxOLS = new DebugPageBlinxOLS();
        LetsGetStartedPageOLS letsGetStartedPageOLS = new LetsGetStartedPageOLS();
        BaseTest.getDriver().navigate()
                .to("https://screener.acurianhealth.com/welcome.do?method=beginCall&phoneNumber=AUTAMS1CV1&up[]" +
                        "=CLIENT_BLINX&testing_key=51fa2780f2430b542923956ac1974bb7&show_debug=1#");

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

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        HeartRelatedEventsOrConditionsPageOLS heartRelatedEventsOrConditionsPageOLS =
        whatKindOfDiabetesPageOLS
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
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
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
                .waitForPageLoadPrequalified()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode, city, state)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClosePageOLS qualifiedClosePageOLS = siteSelectionPageOLS
                .waitForPageLoad5("a heart health study!")
                .getPage(debugPageBlinxOLS)
                .getPID()
                .getPage(siteSelectionPageOLS)
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClosePageOLS());

        ThankYouClosePageOLS thankYouClosePageOLS = qualifiedClosePageOLS
                .waitForPageLoad3()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouClosePageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog("PRD")
                .childPidFromDbToLog("PRD")
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
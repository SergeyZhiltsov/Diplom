package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.adg_4357.HowLongAgoDiagnosedDiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.adg_4357.WithType1DiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.cv_study.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.List;

public class CV_8983_OLSBlinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(CV_8983_OLSBlinx.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_CV_8983}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("S10560 (8983) 20170625 (Amgen CV & HC VESALIUS-CV). Added in release 97/98")
    public void cv8983BlinxTest(Site site) {

        String phoneNumber = "AUTAMS1CV1";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");
        String studyName = "a heart health study";
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA(studyName, "750")
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS);

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoadGMEGA(studyName, "750")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = new CholesterolTriglyceridesLipidsPageOLS();

        //DQ if <18, DQ if >81, DQ if Male <50, DQ if Female <55
        genderPageOLS
                .waitForPageLoad()
                .setDate("01011940")
                .clickOnAnswer("Female")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01011966")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01011971")
                .clickOnAnswer("Male")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("05051960")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6744", site.activeProtocols)
                .back(cholesterolTriglyceridesLipidsPageOLS);

        TakingFollowingStaticMedicationOLS takingFollowingStaticMedicationOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakingFollowingStaticMedicationOLS());

        takingFollowingStaticMedicationOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(diagnosedAnyTypeOfDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6732", site.activeProtocols)
                .back(takingFollowingStaticMedicationOLS)
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(diagnosedAnyTypeOfDiabetesPageOLS);

        SufferedFollowingHeartRelatedConditionsPageOLS sufferedFollowingHeartRelatedConditionsPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageOLS());

        HeartRelatedSurgeriesProceduresPageOLS heartRelatedSurgeriesProceduresPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageOLS());

        AdditionalHeartRelatedConditionsPageOLS additionalHeartRelatedConditionsPageOLS = heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        //move back to Q4
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .back(diagnosedAnyTypeOfDiabetesPageOLS);

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS);

        WithType1DiabetesPageOLS withType1DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageOLS());

        withType1DiabetesPageOLS
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS);

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes")
                .clickNextButton(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS);

        HowLongAgoDiagnosedDiabetesPageOLS howLongAgoDiagnosedDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HowLongAgoDiagnosedDiabetesPageOLS());

        StatementsApplyToYouOLS statementsApplyToYouOLS = howLongAgoDiagnosedDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new StatementsApplyToYouOLS());

        statementsApplyToYouOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(sufferedFollowingHeartRelatedConditionsPageOLS);

        SubquestionHeartPageOLS subquestionHeartPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionHeartPageOLS());

        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6736")
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);

        MajorStrokeCausedPermanentLossFunctionsOLS majorStrokeCausedPermanentLossFunctionsOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageOLS)
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickNextButton(new MajorStrokeCausedPermanentLossFunctionsOLS());

        majorStrokeCausedPermanentLossFunctionsOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6749", site.activeProtocols)
                .back(majorStrokeCausedPermanentLossFunctionsOLS)
                .waitForPageLoad()
                .back(subquestionHeartPageOLS)
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Stenosis (narrowing of the blood vessels or arteries)")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("7", "7", "500")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant",
                "Schizophrenia");
        for (String answer : disqualifyQ18) {
            Log.info("Select answer for Q18: " + answer);
            healthcareDiagnosedConditionsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back(healthcareDiagnosedConditionsPageOLS);
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

        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();

        (env.equals("STG") ? identificationPageOLS.waitForPageLoadSTG() : identificationPageOLS.waitForPageLoad2())
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad5(studyName + "!")
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);

    }
}

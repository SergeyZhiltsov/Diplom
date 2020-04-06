package com.acurian.selenium.CCBlinxTest;

import com.acurian.selenium.blinx.CV_4450_OLSBlinx;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.constants.Version;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CCBlinxTest.AcurianHealthResearchStudyLine;
import com.acurian.selenium.pages.CCBlinxTest.AdminPortalPage;
import com.acurian.selenium.pages.CCBlinxTest.DnisPage;
import com.acurian.selenium.pages.CCBlinxTest.LoginPage;
import com.acurian.selenium.pages.blinx.ams.adg_4357.HowLongAgoDiagnosedDiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.adg_4357.WithType1DiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.cv_study.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.lowt_3017.HasDoctorEverDiagnosedYouMedicalCond_OLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

public class blinxTestCC extends BaseTest {

    private static Logger Log = LogManager.getLogger(CV_4450_OLSBlinx.class.getName());

    @DataProvider
    private Object[][] sites() {
        return new Object[][] {
                { Site.AUT_CV1_4450S_Syn,  Version.CC},
                { Site.AUT_CV1_4450S_Syn,  Version.OLS}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    public void blinxTestCC(Site site, Version version) {
        String phoneNumber = "AUTAMS1CV1";
        String dnis = "22210.0";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");
        String studyName = "a heart health study";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        if(version == Version.CC) {
            LoginPage loginPage = new LoginPage();
            AdminPortalPage adminPortalPage = loginPage
                    .openPage(env)
                    .waitForPageLoad()
                    .setEmail()
                    .setPass()
                    .clickLogin(new AdminPortalPage());

            DnisPage dnisPage = adminPortalPage
                    .waitForPageLoad()
                    .clickScreener(new DnisPage());

            AcurianHealthResearchStudyLine acurianHealthResearchStudyLine = dnisPage
                    .waitForPageLoad()
                    .setDnis(dnis)
                    .clickBegin(new AcurianHealthResearchStudyLine());

            acurianHealthResearchStudyLine
                    .waitForPageLoad()
                    .clickOnAnswer("Learn more about matching to clinical trials");
        }

        if(version == Version.OLS) {
        dateOfBirthPageOLS
                .openPage(env, phoneNumber);
        }

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName, "750")
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS);

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName, "750")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

//        GenderPageOLS genderPageOLS = zipCodePageOLS
//                .waitForPageLoad()
//                .setZipCode(site.zipCode)
//                .clickNextButton(new GenderPageOLS());
//
//        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = new CholesterolTriglyceridesLipidsPageOLS();
//
//        genderPageOLS
//                .waitForPageLoad()
//                .setDate("01081976")//"Disqualify (“Age”) if < 45
//                .clickOnAnswer("Female")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
//                .back(genderPageOLS);
//        genderPageOLS
//                .waitForPageLoad()
//                .setDate("01081970")
//                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);
//
//        //-------------------------------------------Flow--------------------------------------------------
//
//        TakingFollowingStaticMedicationOLS takingFollowingStaticMedicationOLS = cholesterolTriglyceridesLipidsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new TakingFollowingStaticMedicationOLS());
//
//        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = takingFollowingStaticMedicationOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Atorvastatin")
//                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());
//
//        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new WhatKindOfDiabetesPageOLS());
//
//        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
//                .clickNextButton(new WithType2DiabetesPageOLS());
//
//        withType2DiabetesPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
//                .back(whatKindOfDiabetesPageOLS);
//
//        WithType1DiabetesPageOLS withType1DiabetesPageOLS = whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
//                .clickNextButton(new WithType1DiabetesPageOLS());
//
//        withType1DiabetesPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
//                .back(whatKindOfDiabetesPageOLS);
//
//        HowLongAgoDiagnosedDiabetesPageOLS howLongAgoDiagnosedDiabetesPageOLS = whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new HowLongAgoDiagnosedDiabetesPageOLS());
//
//        StatementsApplyToYouOLS statementsApplyToYouOLS = howLongAgoDiagnosedDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("7 - 11 months ago")
//                .clickNextButton(new StatementsApplyToYouOLS());
//
//        SufferedFollowingHeartRelatedConditionsPageOLS sufferedFollowingHeartRelatedConditionsPageOLS = statementsApplyToYouOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageOLS());
//
//        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Heart attack")
//                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
//
//        HeartrelatedMedicalProceduresPageOLS haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS = subquestionExperiencedHeartPageOLS
//                .waitForPageLoad()
//                .clickOnAnswerForAllSubQuestion("Less than 30 days ago")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
//        haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad()
//                .clickOnAnswerForAllSubQuestion("1 - 3 months ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad()
//                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
//
//        MajorStrokeCausedPermanentLossFunctionsOLS majorStrokeCausedPermanentLossFunctionsOLS = new MajorStrokeCausedPermanentLossFunctionsOLS();
//
//        sufferedFollowingHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Stroke")
//                .clickOnAnswers("Heart attack")
//                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
//                .clickNextButton(majorStrokeCausedPermanentLossFunctionsOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
//                .clickNextButton(majorStrokeCausedPermanentLossFunctionsOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
//
//        sufferedFollowingHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Mini-Stroke or TIA")
//                .clickOnAnswers("Stroke")
//                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
//
//        sufferedFollowingHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
//                .clickOnAnswers("Mini-Stroke or TIA")
//                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
//                .back(subquestionExperiencedHeartPageOLS);
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
//
//        HeartRelatedSurgeriesProceduresPageOLS heartRelatedSurgeriesProceduresPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HeartRelatedSurgeriesProceduresPageOLS());
//
//        MostRecentHeartRelatedSurgeryProcedurePageOLS mostRecentHeartRelatedSurgeryProcedurePageOLS = heartRelatedSurgeriesProceduresPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Stent placement in your heart, neck or legs")
//                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLS());
//
//
//        List<String> disqualifyQS49 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
//        for (String answer : disqualifyQS49) {
//            Log.info("Select answer for QS49: " + answer);
//            mostRecentHeartRelatedSurgeryProcedurePageOLS
//                    .waitForPageLoad()
//                    .clickOnAnswer(answer)
//                    .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS())
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS6739", site.activeProtocols)
//                    .back(mostRecentHeartRelatedSurgeryProcedurePageOLS);
//        }
//
//        mostRecentHeartRelatedSurgeryProcedurePageOLS
//                .waitForPageLoad()
//                .back(heartRelatedSurgeriesProceduresPageOLS)
//                .waitForPageLoad()
//                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
//
//        sufferedFollowingHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS);
//        AdditionalHeartRelatedConditionsPageOLS additionalHeartRelatedConditionsPageOLS = heartRelatedSurgeriesProceduresPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS());
//        ApproximateHeightPageOLS approximateHeightPageOLS = additionalHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new ApproximateHeightPageOLS());
//        HasDoctorEverDiagnosedYouMedicalCond_OLS hasDoctorEverDiagnosedYouMedicalCond_ols = approximateHeightPageOLS
//                .waitForPageLoad()
//                .setAll("7", "7", "500")
//                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
//
//        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = hasDoctorEverDiagnosedYouMedicalCond_ols
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
//                .back(approximateHeightPageOLS)
//                .waitForPageLoad()
//                .back(additionalHeartRelatedConditionsPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)")
//                .clickNextButton(approximateHeightPageOLS)
//                .waitForPageLoad()
//                .setAll("5","5","150")
//                .clickNextButton(hasDoctorEverDiagnosedYouMedicalCond_ols)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6743", site.activeProtocols)
//                .back(approximateHeightPageOLS)
//                .waitForPageLoad()
//                .setAll("7", "7", "500")
//                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());
//
//        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
//        List<String> disqualifyQ18 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
//                "Cirrhosis of the liver",
//                "Drug or alcohol abuse within the past year",
//                "Hepatitis B",
//                "Hepatitis C",
//                "HIV or AIDS",
//                "Kidney disease requiring dialysis or transplant");
//        for (String answer : disqualifyQ18) {
//            Log.info("Select answer for Q18: " + answer);
//            healthcareDiagnosedConditionsPageOLS
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(answer)
//                    .clickNextButton(hasDoctorEverDiagnosedYouMedicalCond_ols)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
//                    .back(healthcareDiagnosedConditionsPageOLS);
//        }
//
//        //----------------------------------------Closes------------------------------------------
//
//        IdentificationPageOLS identificationPageOLS = healthcareDiagnosedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new RequirePassDrugTestOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new IdentificationPageOLS());
//
//        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
//
//        (env.equals("STG") ? identificationPageOLS.waitForPageLoadSTG() : identificationPageOLS.waitForPageLoad2())
//                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
//                .clickNextButton(new SiteSelectionPageOLS());
//
//        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
//                .waitForPageLoad5(studyName + "!")
//                .clickOnFacilityName(site.name)
//                .clickNextButton(new QualifiedClose2PageOLS());
//        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
//                .waitForPageLoad3()
//                .clickNextButton(new ThankYouCloseSimplePageOLS());
//        com.acurian.selenium.pages.blinx.ams.closes.AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
//                .waitForPageLoad()
//                .clickNextButton(new AboutHealthPageOLS());
//        if(aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
//            aboutHealthPageOLS
//                    .waitForPageLoad()
//                    .pidFromDbToLog(env)
//                    .childPidFromDbToLog(env)
//                    .assertGeneratedFul(env, site)
//                    .dispoShouldMatch(site.dispo, site.dispo);
//        }
//
//
//
//

    }
}
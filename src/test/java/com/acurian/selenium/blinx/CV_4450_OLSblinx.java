package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.adg_4357.WithType1DiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.cv_study.*;
import com.acurian.selenium.pages.blinx.ams.diabetes.CurrentlyTreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.blinx.ams.lowt_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ApproximateHeightWeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CV_4450_OLSblinx extends BaseTest {

    @DataProvider
    public Object[][] sites() {
        return new Object[][] {
                {Site.AUT_CV1_4450S_Syn}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    public void CV_4450_Blinx(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");
        String studyName = "a heart health study";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
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

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = new CholesterolTriglyceridesLipidsPageOLS();

        genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
        genderPageOLS
                .waitForPageLoad()
                .setDate("01081975")//"Disqualify (“Age”) if < 45
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);
        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
        genderPageOLS
                .waitForPageLoad()
                .setDate("01081970")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);

        TakingFollowingStaticMedicationOLS takingFollowingStaticMedicationOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakingFollowingStaticMedicationOLS());

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = takingFollowingStaticMedicationOLS
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

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




        /*WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseasePageOLS
        SufferedFollowingHeartRelatedConditionsPageOLS sufferedFollowingHeartRelatedConditionsPageOLS
                = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension")
                .clickOnAnswers("None of the above")
                .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageOLS());
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS);

        ConfirmsHighCholesterolTriglyceridesPageOLS confirmsHighCholesterolTriglyceridesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new ConfirmsHighCholesterolTriglyceridesPageOLS());

        confirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);

        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .back(confirmsHighCholesterolTriglyceridesPageOLS);
        confirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS);

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        WithType1DiabetesPageOLS withType1DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageOLS());
        withType1DiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)") //Display for Females only
                .clickOnAnswer("Unsure")
                .clickNextButton(sufferedFollowingHeartRelatedConditionsPageOLS);

        HeartRelatedSurgeriesProceduresPageOLS heartRelatedSurgeriesProceduresPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                        "Heart failure or congestive heart failure (CHF)")
                .clickOnAnswers("None of the above") //Skip to Q16
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageOLS());

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
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionHeartPageOLS);

        List<String> disqualifyQ15 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.1: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.2	When was the last time that you experienced had a stroke?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.2: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected2())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected2())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionHeartPageOLS);

        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.3: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected3())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected3())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.4	When was the last time that you experienced suffered from angina or chest pain that required you to stay in a hospital overnight?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.4: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS);

        MostRecentHeartRelatedSurgeryProcedurePageOLS mostRecentHeartRelatedSurgeryProcedurePageOLS = heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLS());

        AdditionalHeartRelatedConditionsPageOLS additionalHeartRelatedConditionsPageOLS = new AdditionalHeartRelatedConditionsPageOLS();
        List<String> disqualifyQ17 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ17) {
            System.out.println("Select answer for Q17: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(additionalHeartRelatedConditionsPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6739", site.activeProtocols)
                    .back(mostRecentHeartRelatedSurgeryProcedurePageOLS);
        }
        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS);

        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightWeightPageOLS());

        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageOLS);
        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers()
                .back(mostRecentHeartRelatedSurgeryProcedurePageOLS);
        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS);
        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke") //Qualifying answer Ghost Question
                .clickNextButton(subquestionHeartPageOLS);
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
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
                .setAllFields("5","5", "170")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .back(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageOLS);
        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS);
        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .back(subquestionHeartPageOLS);
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS);
        sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesProceduresPageOLS);
        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Any other surgery on the arteries in your legs, neck or heart")
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageOLS);
        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS);
        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5","5", "170")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .back(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageOLS);
        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .back(mostRecentHeartRelatedSurgeryProcedurePageOLS);
        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS);
        heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageOLS);
        additionalHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)") //Qualifying answer Ghost Question
                .clickNextButton(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5","5", "170")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);
        //------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------
        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        List<String> disqualifyQ26 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
            healthcareDiagnosedConditionsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
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
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoadPrequalified()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad5("a heart health study!")
                .getPage(debugPageOLS)
                .getPID()
                .getPage(siteSelectionPageOLS)
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad3()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog("PRD")
                .childPidFromDbToLog("PRD")
                .dispoShouldMatch(site.dispo, site.dispo);*/
    }
}
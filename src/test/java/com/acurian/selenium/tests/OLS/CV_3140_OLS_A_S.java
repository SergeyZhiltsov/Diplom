package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.SubquestionStatinMedicationsHavePageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.StopTakingStatinPageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.WhileTakingStatinPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TriglyceridesOrLipidsPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusHealthyMindsPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.cv_study.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CV_3140_OLS_A_S extends BaseTest {

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_CV_3140_site},
                {Site.AUT_CV_3140A_site}
        };
    }

    @Test(enabled = true, dataProvider = "sites")
    @Description("CV 3140 OLS")
    public void cv3140olsTest(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String studyName = "a heart health";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText2Ver(), dateOfBirthPageOLS.titleCVExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091952")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();
        SubquestionStatinMedicationsHavePageOLS subquestionStatinMedicationsHavePageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new SubquestionStatinMedicationsHavePageOLS());

        TriglyceridesOrLipidsPageOLS triglyceridesOrLipidsPageOLS = subquestionStatinMedicationsHavePageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion("Atorvastatin", "Never taken")
                .clickOnAnswerForSubQuestion("Advicor (lovastatin and niacin)", "Never taken")
                .clickOnAnswerForSubQuestion("Altoprev (lovastatin)", "Never taken")
                .clickOnAnswerForSubQuestion("Caduet (atorvastatin and amlodipine)", "Never taken")
                .clickOnAnswerForSubQuestion("Crestor (rosuvastatin calcium)", "Never taken")
                .clickOnAnswerForSubQuestion("Fluvastatin", "Never taken")
                .clickOnAnswerForSubQuestion("Juvisync (simvastatin and sitagliptin)", "Never taken")
                .clickOnAnswerForSubQuestion("Lescol or Lescol XL (fluvastatin)", "Never taken")
                .clickOnAnswerForSubQuestion("Lipitor (atorvastatin)", "Never taken")
                .clickOnAnswerForSubQuestion("Liptruzet (atorvastatin and ezetimibe)", "Never taken")
                .clickOnAnswerForSubQuestion("Livalo (pitavastatin)", "Never taken")
                .clickOnAnswerForSubQuestion("Lovastatin", "Never taken")
                .clickOnAnswerForSubQuestion("Mevacor (lovastatin)", "Never taken")
                .clickOnAnswerForSubQuestion("Pravachol (pravastatin)", "Never taken")
                .clickOnAnswerForSubQuestion("Pravastatin", "Never taken")
                .clickOnAnswerForSubQuestion("Rosuvastatin", "Never taken")
                .clickOnAnswerForSubQuestion("Simcor (simvastatin and niacin)", "Never taken")
                .clickOnAnswerForSubQuestion("Simvastatin", "Never taken")
                .clickOnAnswerForSubQuestion("Vytorin (simvastatin and ezetimibe)", "Never taken")
                .clickOnAnswerForSubQuestion("Zocor (simvastatin)", "Never taken")
                .clickNextButton(new TriglyceridesOrLipidsPageOLS());
        triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6730", site.activeProtocols)
                .back();
        StopTakingStatinPageOLS stopTakingStatinPageOLS = subquestionStatinMedicationsHavePageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion("Atorvastatin", "Took in the past, but have stopped taking")
                .clickNextButton(new StopTakingStatinPageOLS());

        WhileTakingStatinPageOLS whileTakingStatinPageOLS = stopTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhileTakingStatinPageOLS());

        whileTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(triglyceridesOrLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6710", site.activeProtocols)
                .back();
        whileTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness")
                .clickNextButton(triglyceridesOrLipidsPageOLS);

        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartOrBloodVesselPageOLS());
//        heartOrBloodVesselPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6711", protocols)
//                .back();
//        triglyceridesOrLipidsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(heartOrBloodVesselPageOLS);

        HaveDoctorEverDiagnosedYou_OLS haveDoctorEverDiagnosedYou_ols = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_OLS());
        haveDoctorEverDiagnosedYou_ols
                .waitForPageLoad()
                .back();
        AnginaOrChestPainPageOLS anginaOrChestPainPageOLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital")
                .clickNextButton(new AnginaOrChestPainPageOLS());
        anginaOrChestPainPageOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "1 - 3 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "Less than 30 days ago")
                .clickNextButton(anginaOrChestPainPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageOLS);

        anginaOrChestPainPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6714", site.activeProtocols)
                .back();
        anginaOrChestPainPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6714", site.activeProtocols)
                .back();
        anginaOrChestPainPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .back();

        heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveDoctorEverDiagnosedYou_ols);

        HeartrelatedMedicalConditionsProceduresPageOLS heartrelatedMedicalConditionsProceduresPageOLS = haveDoctorEverDiagnosedYou_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageOLS());

        ReceivedHeartProcedurePageOLS receivedHeartProcedurePageOLS = heartrelatedMedicalConditionsProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty procedure")
                .clickNextButton(new ReceivedHeartProcedurePageOLS());

        RelativesHeartAttackPageOLS relativesHeartAttackPageOLS = receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new RelativesHeartAttackPageOLS());
        relativesHeartAttackPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6717", site.activeProtocols)
                .back();
        receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(relativesHeartAttackPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6717", site.activeProtocols)
                .back();
        receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .back();
        heartrelatedMedicalConditionsProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(relativesHeartAttackPageOLS);

        FirstHeartAttackPageOLS firstHeartAttackPageOLS = relativesHeartAttackPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Sister")
                .clickNextButton(new FirstHeartAttackPageOLS());

        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = firstHeartAttackPageOLS
                .waitForPageLoad()
                .setYears("30")
                .clickNextButton(new EverSmokedCigarettesPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageOLS());
        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new TransitionalStatementLowtPageOLS());
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .back();
        everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(approximateHeightPageOLS);
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .clickNextButton(new WeightLossSurgeryPageOLS());

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = new HealthcareDiagnosedConditionsPageOLS();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6724", site.activeProtocols)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6724", site.activeProtocols)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6724", site.activeProtocols)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6724", site.activeProtocols)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6724", site.activeProtocols)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

        HashMap<String, List<String>> options = new HashMap<>();
        options.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(site.activeProtocols));
        options.put("Cirrhosis of the liver", Arrays.asList(site.activeProtocols));
        options.put("Drug or alcohol abuse within the past year", Arrays.asList(site.activeProtocols));
        options.put("Hepatitis B", Arrays.asList(site.activeProtocols));
        options.put("Hepatitis C", Arrays.asList(site.activeProtocols));
        options.put("HIV or AIDS", Arrays.asList(site.activeProtocols));
        options.put("Kidney disease requiring dialysis or transplant", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            healthcareDiagnosedConditionsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(transitionalStatementLowtPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6725", (String[]) entry.getValue().toArray())
                    .back();
        }

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch(site.dispo);
    }
}

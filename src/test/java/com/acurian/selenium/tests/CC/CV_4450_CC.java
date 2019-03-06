package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.StatinMedicationsHavePageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.StopTakingStatinPageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.WhileTakingStatinPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.TriglyceridesOrLipidsPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusHealthyMindsPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CV_4450_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] sites() {
        return new Object[][] {
                {Site.AUT_CV1_4450S_Syn},
//                {"AUT_CV_3140A_site", "1R", "45205"}
        };
    }

    @Test(dataProvider = "sites")
    @Description("CV 4450 CC")
    public void cv4450ccTest(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String studyName = "a heart health study";
        String debugSiteName = "";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText2Ver(), dateOfBirthPageCC.titleCVExpected, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1952")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

        DebugPageCC debugPageCC = new DebugPageCC();


        StatinMedicationsHavePageCC statinMedicationsHavePageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new StatinMedicationsHavePageCC());
        statinMedicationsHavePageCC
                .waitForPageLoad()
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar", "High cholesterol or high triglycerides")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        MedicationsForYourDiabetesPageCC medicationsForYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", site.activeProtocols)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());
        withType2DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new WithType2DiabetesPageCC());

        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(statinMedicationsHavePageCC);

        TriglyceridesOrLipidsPageCC triglyceridesOrLipidsPageCC = statinMedicationsHavePageCC
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
                .clickNextButton(new TriglyceridesOrLipidsPageCC());
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .back();
        StopTakingStatinPageCC stopTakingStatinPageCC = statinMedicationsHavePageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion("Atorvastatin", "Currently taking")
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
                .clickNextButton(new StopTakingStatinPageCC());

        WhileTakingStatinPageCC whileTakingStatinPageCC = stopTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhileTakingStatinPageCC());

        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = whileTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness")
                .clickNextButton(new HeartOrBloodVesselPageCC());

        HaveDoctorEverDiagnosedYou_CC haveDoctorEverDiagnosedYou_cc = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        haveDoctorEverDiagnosedYou_cc
                .waitForPageLoad()
                .back();
        AnginaOrChestPainPageCC anginaOrChestPainPageCC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital")
                .clickNextButton(new AnginaOrChestPainPageCC());
        anginaOrChestPainPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "1 - 3 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "Less than 30 days ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC);

        anginaOrChestPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018790-QS6714-STUDYQUES", site.activeProtocols)
                .back();
        anginaOrChestPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018790-QS6714-STUDYQUES", site.activeProtocols)
                .back();
        anginaOrChestPainPageCC
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back();

        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveDoctorEverDiagnosedYou_cc);

        HeartrelatedMedicalConditionsProceduresPageCC heartrelatedMedicalConditionsProceduresPageCC = haveDoctorEverDiagnosedYou_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageCC());



        RelativesHeartAttackPageCC relativesHeartAttackPageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageCC());

        FirstHeartAttackPageCC firstHeartAttackPageCC = relativesHeartAttackPageCC
                .waitForPageLoad()
                .clickOnAnswers("Sister")
                .clickNextButton(new FirstHeartAttackPageCC());

        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = firstHeartAttackPageCC
                .waitForPageLoad()
                .setYears("30")
                .clickNextButton(new EverSmokedCigarettesPageCC());

        ApproximateHeightPageCC approximateHeightPageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageCC());
        TransitionalStatementLowtPageCC transitionalStatementLowtPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(new TransitionalStatementLowtPageCC());
        transitionalStatementLowtPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018795-QS6722-STUDYQUES", site.activeProtocols)
                .back();
        approximateHeightPageCC
                .waitForPageLoad()
                .back();
        everSmokedCigarettesPageCC
                .waitForPageLoad()
                .back();
        firstHeartAttackPageCC
                .waitForPageLoad()
                .back();
        relativesHeartAttackPageCC
                .waitForPageLoad()
                .back();

        heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Peripheral Artery Disease or PAD (narrowed or hardened blood vessels in your arms or legs)")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(firstHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC);

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004980-QS6721-STUDYQUES", site.activeProtocols)
                .back();
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(new WeightLossSurgeryPageCC());

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = new HealthcareDiagnosedConditionsPageCC();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(healthcareDiagnosedConditionsPageCC);

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
            healthcareDiagnosedConditionsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(transitionalStatementLowtPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0018797-QS6725-STUDYQUES", (String[]) entry.getValue().toArray())
                    .back();
        }

        IdentificationPageCC identificationPageCC = healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageCC());
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        switch (site.zipCode) {
            case "45205":
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusHealthyMindsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo);
                break;
            case "19901":
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "09/09/1952", "US", "Dover, DE",
                                site.zipCode, "qa.acurian@gmail.com", "999 -999-9999", "12345D", site.name, "NNDXXXCAR388")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo);
        }
    }
}

package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.AreYouCurrentlyTakingStatinMedsCC;
import com.acurian.selenium.pages.CC.DYS_4356C.StatinMedicationsHavePageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.StopTakingStatinPageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.WhileTakingStatinPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.AnginaOrChestPainPageCC;
import com.acurian.selenium.pages.CC.cv_study.FirstHeartAttackPageCC;
import com.acurian.selenium.pages.CC.cv_study.HealthcareDiagnosedConditionsPageCC;
import com.acurian.selenium.pages.CC.cv_study.HeartrelatedMedicalConditionsProceduresPageCC;
import com.acurian.selenium.pages.CC.cv_study.MedicationsForYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.cv_study.RelativesHeartAttackPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.CV_5034_OLS_A_S;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class CV_5034_CC_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "5034Sites", dataProviderClass = CV_5034_OLS_A_S.class)
    @Description("Diabetes_4356A_Synexus for CC")
    public void CV_5034_CC_Test(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String studyName = "a heart health study";

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

        //-------Date of Birth Page--------
        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleCVExpected, "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2005")
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC.waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad2Ver()
                .setYear("1952")
                .clickNextButton(new ZipCodePageCC());

        //-------ZIP_CODE Page--------
        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        //-------GENDER Page--------
        genderPageCC
                .waitForPageLoad();
        //DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", site.activeProtocols)
                .back();
        StatinMedicationsOnPageCC statinMedicationsOnPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new StatinMedicationsOnPageCC());
        statinMedicationsOnPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(statinMedicationsOnPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Chronic Kidney Disease")
                .clickNextButton(statinMedicationsOnPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(statinMedicationsOnPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        //-------Q4: What kind of diabetes do you have?----------
        MedicationsForYourDiabetesPageCC medicationsForYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad();
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        //-------Q5: WithType2DiabetesPageCC------------
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006179-QS6705-STUDYQUES", site.activeProtocols)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 to less than 5 years ago")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());

        //-------Q6: Do you currently take any of the following specific medications for your diabetes?------------
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Glyxambi (empagliflozin and linagliptin)", "Januvia (sitagliptin)", "Nesina (alogliptin)",
                        "Oseni (alogliptin and pioglitazone)", "Onglyza (saxagliptin)", "Tradjenta (linagliptin)",
                        "Bydureon or Byetta (exenatide)", "Saxenda or Victoza (liraglutide)", "Adlyxin (lixisenatide)",
                        "Tanzeum (albiglutide)", "Trulicity (dulaglutide)", "Ozempic (semaglutide)")
                .clickNextButton(new StatinMedicationsHavePageCC());

        //-------New Q7: Ask Q7 (Statins Ever) even if did not report "High cholesterol or high triglycerides?------------
        TriglyceridesOrLipidsPageCC triglyceridesOrLipidsPageCC = statinMedicationsOnPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Skip to Q12
                .clickNextButton(new TriglyceridesOrLipidsPageCC());
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .back();

        AreYouCurrentlyTakingStatinMedsCC areYouCurrentlyTakingStatinMedsCC = statinMedicationsOnPageCC
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickOnAnswers("Advicor (lovastatin and niacin)")
                .clickOnAnswers("Altoprev (lovastatin)")
                .clickOnAnswers("Caduet (atorvastatin and amlodipine)")
                .clickOnAnswers("Crestor (rosuvastatin calcium)")
                .clickOnAnswers("Fluvastatin")
                .clickOnAnswers("Juvisync (simvastatin and sitagliptin)")
                .clickOnAnswers("Lescol or Lescol XL (fluvastatin)")
                .clickOnAnswers("Lipitor (atorvastatin)")
                .clickOnAnswers("Liptruzet (atorvastatin and ezetimibe)")
                .clickOnAnswers("Livalo (pitavastatin)")
                .clickOnAnswers("Lovastatin")
                .clickOnAnswers("Mevacor (lovastatin)")
                .clickOnAnswers("Pravachol (pravastatin)")
                .clickOnAnswers("Pravastatin")
                .clickOnAnswers("Rosuvastatin")
                .clickOnAnswers("Simcor (simvastatin and niacin)")
                .clickOnAnswers("Simvastatin")
                .clickOnAnswers("Vytorin (simvastatin and ezetimibe)")
                .clickOnAnswers("Zocor (simvastatin)")
                .clickNextButton(new AreYouCurrentlyTakingStatinMedsCC());

        //-------Q7: Which of the following statin medications have you ever taken on a daily basis?
        //areYouCurrentlyTakingStatinMedsCC
        StopTakingStatinPageCC stopTakingStatinPageCC = areYouCurrentlyTakingStatinMedsCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion("Atorvastatin", "No")
                .clickOnAnswerForSubQuestion("Advicor (lovastatin and niacin)", "No")
                .clickOnAnswerForSubQuestion("Altoprev (lovastatin)", "No")
                .clickOnAnswerForSubQuestion("Caduet (atorvastatin and amlodipine)", "No")
                .clickOnAnswerForSubQuestion("Crestor (rosuvastatin calcium)", "No")
                .clickOnAnswerForSubQuestion("Fluvastatin", "No")
                .clickOnAnswerForSubQuestion("Juvisync (simvastatin and sitagliptin)", "No")
                .clickOnAnswerForSubQuestion("Lescol or Lescol XL (fluvastatin)", "No")
                .clickOnAnswerForSubQuestion("Lipitor (atorvastatin)", "No")
                .clickOnAnswerForSubQuestion("Liptruzet (atorvastatin and ezetimibe)", "No")
                .clickOnAnswerForSubQuestion("Livalo (pitavastatin)", "No")
                .clickOnAnswerForSubQuestion("Lovastatin", "No")
                .clickOnAnswerForSubQuestion("Mevacor (lovastatin)", "No")
                .clickOnAnswerForSubQuestion("Pravachol (pravastatin)", "No")
                .clickOnAnswerForSubQuestion("Pravastatin", "No")
                .clickOnAnswerForSubQuestion("Rosuvastatin", "No")
                .clickOnAnswerForSubQuestion("Simcor (simvastatin and niacin)", "No")
                .clickOnAnswerForSubQuestion("Simvastatin", "No")
                .clickOnAnswerForSubQuestion("Vytorin (simvastatin and ezetimibe)", "No")
                .clickOnAnswerForSubQuestion("Zocor (simvastatin)", "No")
                .clickNextButton(new StopTakingStatinPageCC());
                /*.clickOnAnswerForSubQuestion("Atorvastatin", "Never taken")
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
                .clickOnAnswerForSubQuestion("Zocor (simvastatin)", "Never taken")*/

        stopTakingStatinPageCC
                .waitForPageLoad()
                .back();
        areYouCurrentlyTakingStatinMedsCC
                .waitForPageLoad()
                .clickNextButton(new StopTakingStatinPageCC());

        //-------Q8: Has a doctor ever told you to stop taking a statin medication due to side effects or intolerance?
        WhileTakingStatinPageCC whileTakingStatinPageCC = stopTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhileTakingStatinPageCC());

        //-------Q9: Have you ever experienced any of the following while taking a statin medication?
        whileTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness")
                .clickNextButton(triglyceridesOrLipidsPageCC);

        //-------Q11: triglyceridesOrLipidsPageCC 
        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartOrBloodVesselPageCC());
        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019288-QS6731-STUDYQUES", site.activeProtocols)
                .back();
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(heartOrBloodVesselPageCC);

        //-----Q12:  Have you experienced any of the following heart or blood vessel related events?
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
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        //---Q13: When was the last time that you experienced a heart attack? 
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected4);
        HaveDoctorEverDiagnosedYou_CC haveDoctorEverDiagnosedYou_CC = subquestionExperiencedHeartPageCC
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        haveDoctorEverDiagnosedYou_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());

        //------Q15:  Have you experienced any of the following cardiovascular interventions or surgeries?
        HeartrelatedMedicalConditionsProceduresPageCC heartrelatedMedicalConditionsProceduresPageCC = haveDoctorEverDiagnosedYou_CC
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .back(heartOrBloodVesselPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_CC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageCC());

        RelativesHeartAttackPageCC relativesHeartAttackPageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageCC());

        FirstHeartAttackPageCC firstHeartAttackPageCC = relativesHeartAttackPageCC
                .waitForPageLoad()
                .clickOnAnswers("Brother")
                .clickNextButton(new FirstHeartAttackPageCC());

        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = firstHeartAttackPageCC
                .waitForPageLoad()
                .setYears("30")
                .clickNextButton(new EverSmokedCigarettesPageCC());

        ApproximateHeightPageCC approximateHeightPageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageCC());

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new WeightLossSurgeryPageCC());

        ReceivedHeartProcedurePageCC receivedHeartProcedurePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018795-QS6722-STUDYQUES", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .back(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .back(firstHeartAttackPageCC)
                .waitForPageLoad()
                .back(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .back(heartrelatedMedicalConditionsProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Procedure to clear plaque from blood vessels in the neck such as carotid endarterectomy")
                .clickNextButton(new ReceivedHeartProcedurePageCC());

        receivedHeartProcedurePageCC
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017037-QS6717-STUDYQUES", site.activeProtocols)
                .back(receivedHeartProcedurePageCC)
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(firstHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .clickNextButton(weightLossSurgeryPageCC);

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = new HealthcareDiagnosedConditionsPageCC();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC);

        HashMap<String, List<String>> options = new HashMap<>();
        TransitionalStatementLowtPageCC transitionalStatementLowtPageCC = new TransitionalStatementLowtPageCC();
        options.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(site.activeProtocols));
        options.put("Cirrhosis of the liver", Arrays.asList(site.activeProtocols));
        options.put("Drug or alcohol abuse within the past year", Arrays.asList(site.activeProtocols));
        options.put("Hepatitis B", Arrays.asList(site.activeProtocols));
        options.put("Hepatitis C", Arrays.asList(site.activeProtocols));
        options.put("HIV or AIDS", Arrays.asList(site.activeProtocols));
        options.put("Kidney disease requiring dialysis or transplant", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            healthcareDiagnosedConditionsPageCC
                    .waitForPageLoad();
            healthcareDiagnosedConditionsPageCC
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(transitionalStatementLowtPageCC);
            transitionalStatementLowtPageCC
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
        switch (site) {
            case AUT_CV_5034A_site: //1R
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
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_CV_5034S_site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .getRadiantDbToLog(env)
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
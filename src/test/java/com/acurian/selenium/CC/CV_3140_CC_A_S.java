package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.AreYouCurrentlyTakingStatinMedsCC;
import com.acurian.selenium.pages.CC.DYS_4356C.StopTakingStatinPageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.WhileTakingStatinPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.TriglyceridesOrLipidsPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
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
import com.acurian.selenium.OLS.CV_3140_OLS_A_S;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CV_3140_CC_A_S extends BaseTest {

    private static Logger Log = LogManager.getLogger(CV_3140_CC_A_S.class.getName());

    @Test(dataProvider = "sites", dataProviderClass = CV_3140_OLS_A_S.class, enabled = false)
    @Description("CV 3140 CC")
    public void cv3140ccTest(Site site) {
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

//        dateOfBirthPageCC
//                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleCVExpected, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1952")
                .clickOnAnswer("Yes")
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

        TriglyceridesOrLipidsPageCC triglyceridesOrLipidsPageCC = statinMedicationsOnPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Skip to Q12 //Disqualify ("Denies history of statin use")
                .clickNextButton(new TriglyceridesOrLipidsPageCC());
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018278-QS6732-STUDYQUES", site.activeProtocols)
                .back();
        //Disqualify ("Current statin use") if selected "Yes" for ANY medication displayed in Q8
        AreYouCurrentlyTakingStatinMedsCC areYouCurrentlyTakingStatinMedsCC = new AreYouCurrentlyTakingStatinMedsCC();
        StopTakingStatinPageCC stopTakingStatinPageCC = new StopTakingStatinPageCC();
        HashMap<String, List<String>> optionsQ8 = new HashMap<>();
        optionsQ8.put("Atorvastatin", Arrays.asList(site.activeProtocols));

        optionsQ8.put("Advicor (lovastatin and niacin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Altoprev (lovastatin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Caduet (atorvastatin and amlodipine)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Crestor (rosuvastatin calcium)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Fluvastatin", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Juvisync (simvastatin and sitagliptin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Lescol or Lescol XL (fluvastatin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Lipitor (atorvastatin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Liptruzet (atorvastatin and ezetimibe)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Livalo (pitavastatin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Lovastatin", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Mevacor (lovastatin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Pravachol (pravastatin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Pravastatin", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Rosuvastatin", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Simcor (simvastatin and niacin)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Simvastatin", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Vytorin (simvastatin and ezetimibe)", Arrays.asList(site.activeProtocols));
        optionsQ8.put("Zocor (simvastatin)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : optionsQ8.entrySet()) {
            Log.info(entry.getKey());
            statinMedicationsOnPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(areYouCurrentlyTakingStatinMedsCC);
            areYouCurrentlyTakingStatinMedsCC
                    .waitForPageLoad()
                    .clickOnAnswerForSubQuestion(entry.getKey(), "Yes")
                    .clickNextButton(stopTakingStatinPageCC);
            stopTakingStatinPageCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0019933-QS6733-STUDYQUES", (String[]) entry.getValue().toArray())
                    .back();
            areYouCurrentlyTakingStatinMedsCC
                    .waitForPageLoad()
                    .back();
        }

        statinMedicationsOnPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Atorvastatin")
                .clickOnAnswers("Advicor (lovastatin and niacin)")
                .clickNextButton(areYouCurrentlyTakingStatinMedsCC);

         areYouCurrentlyTakingStatinMedsCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion("Atorvastatin","No")
                .clickOnAnswerForSubQuestion("Advicor (lovastatin and niacin)","No")
                /*.clickOnAnswerForSubQuestion(3,"No")
                .clickOnAnswerForSubQuestion(4,"No")
                .clickOnAnswerForSubQuestion(5,"No")
                .clickOnAnswerForSubQuestion(6,"No")
                .clickOnAnswerForSubQuestion(7,"No")
                .clickOnAnswerForSubQuestion(8,"No")
                .clickOnAnswerForSubQuestion(9,"No")
                .clickOnAnswerForSubQuestion(10,"No")
                .clickOnAnswerForSubQuestion(11,"No")
                .clickOnAnswerForSubQuestion(12,"No")
                .clickOnAnswerForSubQuestion(13,"No")
                .clickOnAnswerForSubQuestion(14,"No")
                .clickOnAnswerForSubQuestion(15,"No")
                .clickOnAnswerForSubQuestion(16,"No")
                .clickOnAnswerForSubQuestion(17,"No")
                .clickOnAnswerForSubQuestion(18,"No")
                .clickOnAnswerForSubQuestion(19,"No")
                .clickOnAnswerForSubQuestion(20,"No")*/
                .clickNextButton(stopTakingStatinPageCC);
        //Q9

        WhileTakingStatinPageCC whileTakingStatinPageCC = stopTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No") //"Must select: "Yes" in Q9 ..."
                .clickNextButton(new WhileTakingStatinPageCC());

        whileTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Must select ... OR Any option except "None of the above" in Q10
                .clickNextButton(triglyceridesOrLipidsPageCC);
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018787-QS6710-STUDYQUES", site.activeProtocols)
                .back();
        whileTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness")
                .clickNextButton(triglyceridesOrLipidsPageCC);

        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HeartOrBloodVesselPageCC());

        CardiovascularInterventionsOrSurgeriesPageCC cardiovascularInterventionsOrSurgeriesPageCC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CardiovascularInterventionsOrSurgeriesPageCC());
        cardiovascularInterventionsOrSurgeriesPageCC
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
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "1 - 3 months ago")
                .clickNextButton(anginaOrChestPainPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageCC);

        anginaOrChestPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018790-QS6714-STUDYQUES", site.activeProtocols)
                .back();
        anginaOrChestPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
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
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC);

        HeartrelatedMedicalConditionsProceduresPageCC heartrelatedMedicalConditionsProceduresPageCC = cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageCC());

        ReceivedHeartProcedurePageCC receivedHeartProcedurePageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty procedure")
                .clickNextButton(new ReceivedHeartProcedurePageCC());

        RelativesHeartAttackPageCC relativesHeartAttackPageCC = receivedHeartProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new RelativesHeartAttackPageCC());
        relativesHeartAttackPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017037-QS6717-STUDYQUES", site.activeProtocols)
                .back();
        receivedHeartProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017037-QS6717-STUDYQUES", site.activeProtocols)
                .back();
        receivedHeartProcedurePageCC
                .waitForPageLoad()
                .back();
        heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(relativesHeartAttackPageCC);

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
                .setAll("5", "5", "160")
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
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(firstHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .clickNextButton(transitionalStatementLowtPageCC)
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
                .back();
        cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad()
                .back();
        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("TIA or \"Mini-Stroke\"")
                .clickNextButton(subquestionExperiencedHeartPageCC)
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .clickNextButton(heartrelatedMedicalConditionsProceduresPageCC)
                .waitForPageLoad()
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(firstHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .clickNextButton(transitionalStatementLowtPageCC)
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
                .back();
        everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(approximateHeightPageCC);
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .clickNextButton(new WeightLossSurgeryPageCC());

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = new HealthcareDiagnosedConditionsPageCC();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6724-STUDYQUES", site.activeProtocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6724-STUDYQUES", site.activeProtocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6724-STUDYQUES", site.activeProtocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6724-STUDYQUES", site.activeProtocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6724-STUDYQUES", site.activeProtocols)
                .back();
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
            Log.info(entry.getKey());
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
        switch (site) {
            case AUT_CV_3140A_site: //1R
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
            case AUT_CV_3140_site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

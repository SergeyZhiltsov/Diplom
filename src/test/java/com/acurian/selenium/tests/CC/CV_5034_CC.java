package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.StatinMedicationsHavePageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.StopTakingStatinPageCC;
import com.acurian.selenium.pages.CC.DYS_4356C.WhileTakingStatinPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.LOWT.EverSmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.LOWT.HaveDoctorEverDiagnosedYou_CC;
import com.acurian.selenium.pages.CC.LOWT.HeartOrBloodVesselPageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.cv_study.AnginaOrChestPainPageCC;
import com.acurian.selenium.pages.CC.cv_study.FirstHeartAttackPageCC;
import com.acurian.selenium.pages.CC.cv_study.HealthcareDiagnosedConditionsPageCC;
import com.acurian.selenium.pages.CC.cv_study.HeartrelatedMedicalConditionsProceduresPageCC;
import com.acurian.selenium.pages.CC.cv_study.MedicationsForYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.cv_study.RelativesHeartAttackPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.CC.shared.DIA.CurrentlyUseMetforminOrInsulinPageCC;
import com.acurian.selenium.pages.CC.shared.DIA.UseDietAndExercisePageCC;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveDoctorEverDiagnosedYou_OLS;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class CV_5034_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = true)
    @TestCaseId("00020")
    @Description("Diabetes_4356A_Synexus for CC")
    public void CV_5034_CC_Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1CV1";
        String protocol1 = "K_877_302_A";
        String studyName = "a heart health study";
        String studyName1 = "a heart health study";
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_DIA_4356A";
        String zipCode = "19901";
        
        
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
        Assert.assertEquals(dateOfBirthPageCC.getQuestionTextAKC(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText2Ver(), dateOfBirthPageCC.titleCVExpected, "Title is diff");    		
        		LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
        	       .setMonth("Mar")
        	       .setDay("2")
        	       .setYear("2005")
        	       .clickNextButton(new LessThan18YearsOldPageCC());
        	lessThan18YearsOldPageCC.waitForPageLoad();
        	DebugPageCC debugPageCC = new DebugPageCC();     
        	debugPageCC.checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", protocol1);
        	debugPageCC.back();
        	ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
        		   .waitForPageLoad2Ver()
        	       .setYear("1980")
        	       .clickNextButton(new ZipCodePageCC());
        	
        
        //-------ZIP_CODE Page--------
        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(zipCode)
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
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", protocol1)
                .back();
        StatinMedicationsHavePageCC statinMedicationsHavePageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new StatinMedicationsHavePageCC());
        statinMedicationsHavePageCC
		        .waitForPageLoad()
		        .getPage(debugPageCC)
		        .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", protocol1)
		        .back();
        cardiovascularDiseaseThanOthersPageCC
		        .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
		        .clickNextButton(new WhatKindOfDiabetesPageCC());


        //-------Q4: What kind of diabetes do you have?----------
        MedicationsForYourDiabetesPageCC medicationsForYourDiabetesPageCC = whatKindOfDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", protocol1)
                .back();
        whatKindOfDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
        		.clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", protocol1)
        		.back();
        whatKindOfDiabetesPageCC
				.waitForPageLoad()
				.clickOnAnswer("High blood sugar only")
				.clickNextButton(new MedicationsForYourDiabetesPageCC());
		medicationsForYourDiabetesPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", protocol1)
				.back();
        whatKindOfDiabetesPageCC
				.waitForPageLoad()
				.clickOnAnswer("Unsure")
				.clickNextButton(new MedicationsForYourDiabetesPageCC());
		medicationsForYourDiabetesPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", protocol1)
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
				.checkProtocolsContainsForQNumber("Q0006179-QS6705-STUDYQUES", protocol1)
				.back();
		withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 to less than 5 years ago")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        		
        
        //-------Q6: Do you currently take any of the following specific medications for your diabetes?------------
        medicationsForYourDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("Glyxambi (empagliflozin and linagliptin)", "Januvia (sitagliptin)","Nesina (alogliptin)",
        				"Oseni (alogliptin and pioglitazone)","Onglyza (saxagliptin)","Tradjenta (linagliptin)",
        				"Bydureon or Byetta (exenatide)","Saxenda or Victoza (liraglutide)","Adlyxin (lixisenatide)", 
        				"Tanzeum (albiglutide)","Trulicity (dulaglutide)","Ozempic (semaglutide)")
                .clickNextButton(new StatinMedicationsHavePageCC());
        
        
        
        //-------Q7: Which of the following statin medications have you ever taken on a daily basis?
        TriglyceridesOrLipidsPageCC triglyceridesOrLipidsPageCC = statinMedicationsHavePageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TriglyceridesOrLipidsPageCC());
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .back();
        StopTakingStatinPageCC stopTakingStatinPageCC = statinMedicationsHavePageCC
           		.waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(new StopTakingStatinPageCC());
        
        
        //-------Q8: Has a doctor ever told you to stop taking a statin medication due to side effects or intolerance?
        WhileTakingStatinPageCC whileTakingStatinPageCC = stopTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhileTakingStatinPageCC());
        

        //-------Q9: Have you ever experienced any of the following while taking a statin medication?
        whileTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness",
                		"Muscle pain, aches, or soreness",
                		"Muscle cramping",
                		"Muscle inflammation or myositis",
                		"Elevated levels of creatine kinase, a muscle enzyme",
                		"Rhabdomyolysis, which is extreme muscle inflammation and damage that can lead to kidney failure",
                		"My medication was changed or the dose was lowered because of the symptoms I experienced")
                .clickOnAnswers("None of the above")
                .clickNextButton(triglyceridesOrLipidsPageCC);        
        
        
        //-------Q11: triglyceridesOrLipidsPageCC 
        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartOrBloodVesselPageCC());
        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018142-QS6711-STUDYQUES", protocol1)
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
                .checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "1 - 3 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsContainsForQNumber("Q0017029-QS6713-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        

     /*   //------Q14:  When was the last time that you experienced angina or chest pain that required an overnight hospital stay?
        anginaOrChestPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsContainsForQNumber("QS6714", protocol1)
                .back();
        anginaOrChestPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsContainsForQNumber("QS6714", protocol1)
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
                .clickNextButton(haveDoctorEverDiagnosedYou_cc);*/
        

        //------Q15:  Have you experienced any of the following cardiovascular interventions or surgeries?
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
                .clickOnAnswers("Brother")
                .clickNextButton(new FirstHeartAttackPageCC());
        

        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = firstHeartAttackPageCC
                .waitForPageLoad()
                .setYear("30")
                .clickNextButton(new EverSmokedCigarettesPageCC());
        

        ApproximateHeightPageCC approximateHeightPageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageCC());
        TransitionStatementLowT_CC transitionStatementLowT_CC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new TransitionStatementLowT_CC());
        transitionStatementLowT_CC
        		.waitForPageLoad(studyName1)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6722", protocol1)
                .back();
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
                .checkProtocolsContainsForQNumber("QS6724", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6724", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6724", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6724", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(healthcareDiagnosedConditionsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6724", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .back();
        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(healthcareDiagnosedConditionsPageCC);

        
        
        
        
        
        
        
        
        
        
        

        
        
        
        
        

    }
}
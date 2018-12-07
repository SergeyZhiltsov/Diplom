package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusHealthyMindsPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.cv_study.AnginaOrChestPainPageOLS;
import com.acurian.selenium.pages.OLS.cv_study.FirstHeartAttackPageOLS;
import com.acurian.selenium.pages.OLS.cv_study.HealthcareDiagnosedConditionsPageOLS;
import com.acurian.selenium.pages.OLS.cv_study.HeartrelatedMedicalConditionsProceduresPageOLS;
import com.acurian.selenium.pages.OLS.cv_study.MedicationsForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.cv_study.RelativesHeartAttackPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.StatinMedicationsHavePageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.StopTakingStatinPageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.WhileTakingStatinPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.EverSmokedCigarettesPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveDoctorEverDiagnosedYou_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HeartOrBloodVesselPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.TransitionalStatementLowtPageOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.OLS.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.OLS.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.shared.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class CV_5034_OLS extends BaseTest {

    @Test
    @TestCaseId("00053")
    @Description("CV_5034_OLS")
    public void CV_5034_OLS_Test() {
        String phoneNumber = "AUTAMS1CV1";
        String protocol1 = "K_877_302_A";
        String studyName = "a heart health";
        String studyName1 = "a heart health";
        String siteName = "AUT_CV_5034_site";
        String zipCode = "19901";

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
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //-------GENDER Page--------
        genderPageOLS
                .waitForPageLoad();
        //DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());
        
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        
        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
        		.waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", protocol1)
                .back();
        StatinMedicationsHavePageOLS statinMedicationsHavePageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new StatinMedicationsHavePageOLS());
        statinMedicationsHavePageOLS
		        .waitForPageLoad()
		        .getPage(debugPageOLS)
		        .checkProtocolsContainsForQNumber("QS6703", protocol1)
		        .back();
        cardiovascularDiseaseThanOthersPageOLS
		        .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
		        .clickNextButton(new WhatKindOfDiabetesPageOLS());


        //-------Q4: What kind of diabetes do you have?----------
        MedicationsForYourDiabetesPageOLS medicationsForYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new MedicationsForYourDiabetesPageOLS());
        medicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", protocol1)
                .back();
        whatKindOfDiabetesPageOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
        		.clickNextButton(new MedicationsForYourDiabetesPageOLS());
        medicationsForYourDiabetesPageOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS6704", protocol1)
        		.back();
        whatKindOfDiabetesPageOLS
				.waitForPageLoad()
				.clickOnAnswer("High blood sugar only")
				.clickNextButton(new MedicationsForYourDiabetesPageOLS());
		medicationsForYourDiabetesPageOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS6704", protocol1)
				.back();
        whatKindOfDiabetesPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Unsure")
				.clickNextButton(new MedicationsForYourDiabetesPageOLS());
		medicationsForYourDiabetesPageOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS6704", protocol1)
				.back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());
        
        
        
       //-------Q5: WithType2DiabetesPageOLS------------
        withType2DiabetesPageOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Within the past 2 months")
				.clickNextButton(new MedicationsForYourDiabetesPageOLS());
		medicationsForYourDiabetesPageOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS6705", protocol1)
				.back();
		withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 to less than 5 years ago")
                .clickNextButton(new MedicationsForYourDiabetesPageOLS());
        		
        
        //-------Q6: Do you currently take any of the following specific medications for your diabetes?------------
        medicationsForYourDiabetesPageOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Glyxambi (empagliflozin and linagliptin)", "Januvia (sitagliptin)","Nesina (alogliptin)",
        				"Oseni (alogliptin and pioglitazone)","Onglyza (saxagliptin)","Tradjenta (linagliptin)",
        				"Bydureon or Byetta (exenatide)","Saxenda or Victoza (liraglutide)","Adlyxin (lixisenatide)", 
        				"Tanzeum (albiglutide)","Trulicity (dulaglutide)","Ozempic (semaglutide)")
                .clickNextButton(new StatinMedicationsHavePageOLS());
        
        
        
        //-------Q7: Which of the following statin medications have you ever taken on a daily basis?
        TriglyceridesOrLipidsPageOLS triglyceridesOrLipidsPageOLS = statinMedicationsHavePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TriglyceridesOrLipidsPageOLS());
        triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .back();
        StopTakingStatinPageOLS stopTakingStatinPageOLS = statinMedicationsHavePageOLS
           		.waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(new StopTakingStatinPageOLS());
        
        
        //-------Q8: Has a doctor ever told you to stop taking a statin medication due to side effects or intolerance?
        WhileTakingStatinPageOLS whileTakingStatinPageOLS = stopTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhileTakingStatinPageOLS());
        

        //-------Q9: Have you ever experienced any of the following while taking a statin medication?
        whileTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness",
                		"Muscle pain, aches, or soreness",
                		"Muscle cramping",
                		"Muscle inflammation or myositis",
                		"Elevated levels of creatine kinase, a muscle enzyme",
                		"Rhabdomyolysis, which is extreme muscle inflammation and damage that can lead to kidney failure",
                		"My medication was changed or the dose was lowered because of the symptoms I experienced")
                .clickOnAnswers("None of the above")
                .clickNextButton(triglyceridesOrLipidsPageOLS);        
        
        
        //-------Q11: triglyceridesOrLipidsPageOLS 
        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartOrBloodVesselPageOLS());
        heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6711", protocol1)
                .back();
        triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(heartOrBloodVesselPageOLS);
        
        

        //-----Q12:  Have you experienced any of the following heart or blood vessel related events?
        HaveDoctorEverDiagnosedYou_OLS haveDoctorEverDiagnosedYou_OLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_OLS());
        haveDoctorEverDiagnosedYou_OLS
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
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        

        //---Q13: When was the last time that you experienced a heart attack? 
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
        //HaveDoctorEverDiagnosedYou_OLS haveDoctorEverDiagnosedYou_OLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_OLS());
        haveDoctorEverDiagnosedYou_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "1 - 3 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 6 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_OLS());
        

        //------Q15:  Have you experienced any of the following cardiovascular interventions or surgeries?
        HeartrelatedMedicalConditionsProceduresPageOLS heartrelatedMedicalConditionsProceduresPageOLS = haveDoctorEverDiagnosedYou_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageOLS());
        

        RelativesHeartAttackPageOLS relativesHeartAttackPageOLS = heartrelatedMedicalConditionsProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageOLS());
        

        FirstHeartAttackPageOLS firstHeartAttackPageOLS = relativesHeartAttackPageOLS
        		.waitForPageLoad()
                .clickOnAnswers("Brother")
                .clickNextButton(new FirstHeartAttackPageOLS());
        

        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = firstHeartAttackPageOLS
                .waitForPageLoad()
                .setYears("30")
                .clickNextButton(new EverSmokedCigarettesPageOLS());
        

        ApproximateHeightPageOLS approximateHeightPageOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageOLS());
        
        
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new WeightLossSurgeryPageOLS());        
        

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Gastric bypass")
        		.clickNextButton(new ProcedureForWeightLossPageOLS());        
        

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = new HealthcareDiagnosedConditionsPageOLS();
        procedureForWeightLossPageOLS
		        .waitForPageLoad()
		        .clickOnAnswer("Less than 3 months ago")
		        .clickNextButton(healthcareDiagnosedConditionsPageOLS);

        HashMap<String, List<String>> options = new HashMap<>();
	        options.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(protocol1));
	        options.put("Cirrhosis of the liver", Arrays.asList(protocol1));
	        options.put("Drug or alcohol abuse within the past year", Arrays.asList(protocol1));
	        options.put("Hepatitis B", Arrays.asList(protocol1));
	        options.put("Hepatitis C", Arrays.asList(protocol1));
	        options.put("HIV or AIDS", Arrays.asList(protocol1));
	        options.put("Kidney disease requiring dialysis or transplant", Arrays.asList(protocol1));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
        	//System.out.println(entry.getKey());
        	healthcareDiagnosedConditionsPageOLS
	        	.waitForPageLoad();
        	TransitionalStatementLowtPageOLS transitionStatementLowT_OLS = healthcareDiagnosedConditionsPageOLS
	        	.clickOnAnswers("None of the above")
	        	.clickOnAnswers(entry.getKey())
	        	.clickNextButton(new TransitionalStatementLowtPageOLS());
        	transitionStatementLowT_OLS
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
		        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
		        .clickNextButton(new SiteSelectionPageOLS())
		        .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
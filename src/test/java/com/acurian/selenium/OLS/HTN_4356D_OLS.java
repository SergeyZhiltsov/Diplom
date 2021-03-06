package com.acurian.selenium.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class HTN_4356D_OLS extends BaseTest{

    @Test(enabled = false)
	@TestCaseId("00031")
	@Description("HTN_4356D_Synexus test OLS")
	public void htn_4356D_Synexus_OLS() {
		String phoneNumber = "AUTAMS1HTN";
		String protocol1 = "THR_1442_C_603";
		String protocol2 = "";
		List<String> protocols = Arrays.asList(protocol1,protocol2);
		String studyName = "a high blood pressure";
		String siteName = "AUT_HTN_4356D_Site";
		String zipCode = "19044";
		String facility_Code_STG = "625301";
		String facility_Code_PRD = "625869";

		String env = System.getProperty("acurian.env");
		if (env == null) env = "STG";

		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS
		.openPage(env, phoneNumber);
//		.waitForPageLoad();
//		Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
//		Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleHTNExpected, "Title is diff");
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
				.setDate("09091980")
				.clickNextButton(new ZipCodePageOLS());

		zipCodePageOLS
		.waitForPageLoad();
		Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
		GenderPageOLS genderPageOLS = zipCodePageOLS
				.typeZipCode(zipCode)
				.clickNextButton(new GenderPageOLS());

		genderPageOLS
		.waitForPageLoad();
		Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
				.clickOnAnswer("Female")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


		DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad()
				.getPage(new DebugPageOLS())
				.checkIsNoProtocolsForQuestion("Ghost Question - HTN_4356D_Synexus End of Module Logic")
				.getPage(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
				.clickOnAnswers("Alzheimer's disease")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		doAnyOftheFollowingAdditionalDiagnosesOLS
		.waitForPageLoad();
		Assert.assertEquals(doAnyOftheFollowingAdditionalDiagnosesOLS.getTitleText(),doAnyOftheFollowingAdditionalDiagnosesOLS.titleExpected, "Title is diff");
		DebugPageOLS debugPageOLS = new DebugPageOLS();
		doAnyOftheFollowingAdditionalDiagnosesOLS.getPage(debugPageOLS)
		.checkProtocolsContainsForQNumber("QS38", protocol1)
		.back();
		//-----------Select most of ALL options in Q2 to test the DQs logic------------
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
		.waitForPageLoad();
		//OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
		WhichOfFollowingHaveYouDiagnosedWith_BreathingOLS whichOfFollowingHaveYouDiagnosedWith_BreathingOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.clickOnAnswers("Alzheimer's disease","Cancer","Diabetes (type 1 or type 2)","Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
				"Headaches (migraine, cluster, tension)","Heart or circulation problems (heart attack, heart failure, stroke)",	"High blood pressure or hypertension",
				"High cholesterol, triglycerides, or lipids","Kidney disease","Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
				"Lupus","Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
				"Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
				"Skin problems (eczema or atopic dermatitis, psoriasis)",

				"Women's health issues (endometriosis, uterine fibroids, PCOS)")
				//.clickNextButton(new OtherThanSkinCancerPageOLS());
				.clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_BreathingOLS());
		whichOfFollowingHaveYouDiagnosedWith_BreathingOLS
		.waitForPageLoad();
		Assert.assertEquals(whichOfFollowingHaveYouDiagnosedWith_BreathingOLS.getTitleText(),whichOfFollowingHaveYouDiagnosedWith_BreathingOLS.titleExpected, "Title is diff");
		//DoYouTakeAnyMedicationsToControlHighBloodPressureOLS doYouTakeAnyMedicationsToControlHighBloodPressureOLS = otherThanSkinCancerPageOLS
		WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = whichOfFollowingHaveYouDiagnosedWith_BreathingOLS
		.clickOnAnswers("None of the above")
				.clickNextButton(new WhenDiagnosedWithCancerOLS());
		whenDiagnosedWithCancerOLS //TODO fix this (waitforpageload() is too early)
				.waitForPageLoad();
		WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = whenDiagnosedWithCancerOLS
		.clickOnAnswer("Within the past 5 years")
		.clickNextButton(new WhatKindOfDiabetesPageOLS());
		//----------------------------------------------------
		whatKindOfDiabetesPageOLS
		.waitForPageLoad()
		.getPage(debugPageOLS)
		.checkProtocolsContainsForQNumber("QS42", protocol1)
		.back();
		whenDiagnosedWithCancerOLS
		.waitForPageLoad()
		.clickOnAnswer("6 - 10 years ago")
		.clickNextButton(whatKindOfDiabetesPageOLS);
		
	//--------------whatKindOfDiabetesPageOLS----------------
		whatKindOfDiabetesPageOLS
		.waitForPageLoad();
		WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = whatKindOfDiabetesPageOLS
		.clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
		.clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
		whichOfFollowingDigestiveConditionPageOLS
			.waitForPageLoad()
			.getPage(debugPageOLS)
			.checkProtocolsContainsForQNumber("QS43", protocol1)
			.back();
			whatKindOfDiabetesPageOLS.waitForPageLoad()
			.clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
			.clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
	//----------------------------------------------------
			whichOfFollowingDigestiveConditionPageOLS
			.waitForPageLoad();
			//DoYouTakeAnyMedicationsToControlHighBloodPressureOLS doYouTakeAnyMedicationsToControlHighBloodPressureOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
			WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = whichOfFollowingDigestiveConditionPageOLS
					.clickOnAnswers("None of the above")
					.clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
	//----------------------------------------------------
		whichTypeOfHeadacheDoYouGetOLS
			.waitForPageLoad();
			HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whichTypeOfHeadacheDoYouGetOLS
			.clickOnAnswers("Unsure")
			.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
	//----------------------------------------------------
		haveYouEverExperiencedHeartRelatedMedicalCondOLS
				.waitForPageLoad();
		HeartrelatedMedicalProceduresPageOLS haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
				.clickOnAnswers("None of the above")
				.clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
	//---------------------------------------------------
		haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad();
				DoYouTakeAnyMedicationsToControlHighBloodPressureOLS doYouTakeAnyMedicationsToControlHighBloodPressureOLS = haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.clickOnAnswers("None of the above")
				.clickNextButton(new DoYouTakeAnyMedicationsToControlHighBloodPressureOLS());
	//----------------------------------------------------
		doYouTakeAnyMedicationsToControlHighBloodPressureOLS
		.waitForPageLoad();
		WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = doYouTakeAnyMedicationsToControlHighBloodPressureOLS
		.clickOnAnswer("No")
		.clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
		.waitForPageLoad()
		.getPage(debugPageOLS)
		.checkProtocolsContainsForQNumber("QS50",protocol1)
		.back();
		doYouTakeAnyMedicationsToControlHighBloodPressureOLS.waitForPageLoad()
		.clickOnAnswer("Yes")
		.clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
		
	//----------------------------------------------------
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
		.waitForPageLoad();
		WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
		.clickOnAnswers("Dialysis")
		.clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
		whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
		.waitForPageLoad()
		.getPage(debugPageOLS)
		.checkProtocolsContainsForQNumber("QS51",protocol1)
		.back();
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS.waitForPageLoad()
		.clickOnAnswers("Neither")
		.clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
		
	//----------------------------------------------------
		whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
		.waitForPageLoad();
		FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
		.clickOnAnswers("Cirrhosis")
		.clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
		following_MentalEmotionalHealthPageOLS
		.waitForPageLoad()
		.getPage(debugPageOLS)
		.checkProtocolsContainsForQNumber("QS52",protocol1)
		.back();
		whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS.waitForPageLoad()
		.clickOnAnswers("Unsure which type of liver disease")
		.clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
		
	//----------------------------------------------------
		following_MentalEmotionalHealthPageOLS
		.waitForPageLoad();
		WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS = following_MentalEmotionalHealthPageOLS
		.clickOnAnswers("Bipolar disorder")
		.clickOnAnswers("Schizophrenia")
		.clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
		whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
		.waitForPageLoad()
		.getPage(debugPageOLS)
		.checkProtocolsContainsForQNumber("QS53",protocol1)
		.back();
		following_MentalEmotionalHealthPageOLS.waitForPageLoad()
		.clickOnAnswers("None of the above")
		.clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
		
	//----------------------------------------------------
		whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
		.waitForPageLoad()
		.clickOnAnswers("Fibromyalgia")
		.clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS())
		
	//----------------------------------------------------
		.waitForPageLoad()
		.clickOnAnswers("None of the above")
		.clickNextButton(new WhichOfTheFollowingSleepRelatedConditionsDiagnosedOLS())
		
	//------------------WhichOfTheFollowingSleepRelatedConditionsDiagnosedOLS----------------------------------
		.waitForPageLoad()
		.clickOnAnswers("None of the above")
		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		
	//----------------------DoAnyOftheFollowingAdditionalDiagnosesOLS---------------------
		.waitForPageLoad()
		.clickOnAnswers("None of the above")
        .clickNextButton(new HormonalBirthControlOLS())
        
   //&&&&&&&&&&&&&&&& HormonalBirthControlOLS &&&&&&&&&&&&&&&&&&&&
        .waitForPageLoad()
        .clickOnAnswer("No")
		.clickNextButton(new ApproximateHeightPageOLS())
		
	//----------ProvideHeight-Weight Page--------------------
		.waitForPageLoad()
		.setFeat("5")
		.setInches("5")
		.setLbs("155")
		.clickNextButton(new ChildrenUnderPageOLS())

	//----------ChildrenUnderTheAge Page--------------------
		.waitForPageLoad()
		.clickOnAnswer("No")
		.clickNextButton(new TheStudySitePageOLS())


	//-------------------PEDIATRIC QUESTIONS-----------------------------                            
		//----"theStudySitePageOLS" page --  If you qualify for a study, how would you plan to travel to and from the study site?
		.waitForPageLoad()
		.clickOnAnswer("Public transportation")
		.clickNextButton(new WhatMedicalCoveragePageOLS())

		//-----"WhatMedicalCoveragePageOLS" -  What sort of medical coverage do you have for your doctor visits, medication, surgery, and/or testing?-
		.waitForPageLoad()
		.clickOnAnswers("No, I have no coverage")
		.clickNextButton(new EthnicBackgroundPageOLS())

		//----"EthnicBackgroundPageOLS" page --  Which of the following describes your ethnic background?
		.waitForPageLoad()
		.clickOnAnswers("Prefer not to answer")
		.clickNextButton(new IdentificationPageOLS())	

		//----------PII (IdentificationPageOLS) Page--------------------
		.waitForPageLoad()
		.setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
		.clickNextButton(new SiteSelectionPageOLS())

		//----------SiteSelection Page--------------------
		.waitForPageLoad(studyName)
		.getPID()
		.clickOnFacilityName(siteName)
		.clickNextButton(new SynexusQualifiedClose4356PageOLS())

		//----------GladLocationIsConvenient Page--------------------
		.waitForPageLoad(env.equals("STG")? facility_Code_STG : facility_Code_PRD)
		.clickNextButton(new ThankYouCloseSimplePageOLS())

		//----------ThankYouCloseSimplePageOLS Page--------------------
		.waitForSENRPageLoad()
		.clickNextButton(new AboutHealthPageOLS())
		.waitForPageLoad()
		.pidFromDbToLog(env)
		 //.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
		.getAnomalyDbToLog(env);
	}
}

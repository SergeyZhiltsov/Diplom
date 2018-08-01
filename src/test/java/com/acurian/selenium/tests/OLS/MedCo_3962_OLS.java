package com.acurian.selenium.tests.OLS;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.AreYouTakingMedications;
import com.acurian.selenium.pages.OLS.DY_4356.NonPrescriptionSupplements;
import com.acurian.selenium.pages.OLS.DY_4356.PregnancyAndFertilityPage;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.WhenWasYourMostRecentHeartProcedureOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.GladLocationIsConvenient;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSCrohnsPageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedCloseDYSPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungs;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolism;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolismPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditions;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.CancerPage;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditions;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DrugOrAlcoholAbuse;
import com.acurian.selenium.pages.OLS.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouSmokedCigarettes;
import com.acurian.selenium.pages.OLS.generalHealth.HeartRelatedMedicalProc;
import com.acurian.selenium.pages.OLS.generalHealth.HistoryOfDrugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.NeurologicalConditions;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SmokedCigarettesPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditions;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WomenHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.WomensHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.YouHaveCHF;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatSortPageOLS;
import com.acurian.selenium.pages.OLS.shared.ChildrenUnderTheAge;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DyslipidemiaHealthcarePage;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS;
import com.acurian.selenium.pages.OLS.shared.HowLongTakingStatin;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.ProvideHeightWeight;
import com.acurian.selenium.pages.OLS.shared.StatinMedicationsPage;
import com.acurian.selenium.pages.OLS.shared.WhenLastTimeYouHadHeartProceduresOLS;

public class MedCo_3962_OLS extends BaseTest {
	
	@Test
	public void medCo_3962_OLS() {
		String phoneNumber = "AUTAMS1MED";		
		String protocol1 = "MDCO_PCS_17_04";
	//	String env = "STG";
		List<String> protocols = Arrays.asList(protocol1);
		String studyName = "a high cholesterol and heart disease";
	    String siteName = "AUT_MEDCO_3962_site";
	    String zipCode = "19901";
	    String site_Indication = "Hypercholesterolemia, Cardiovascular Disease";
	    String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumber)		           
		           .waitForPageGHLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(),dateOfBirthPageOLS.titleMEDExpected, "Title is diff");
		
		PersonalDetails personalDetails = dateOfBirthPageOLS
		           .setDate("10/10/1980")
		           .clickNextButton(new PersonalDetails());
		
		GenderPageOLS genderPageOLS = personalDetails
				   .waitForPageLoad()
				   .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
				   .clickNextButton(new GenderPageOLS());
		
		DyslipidemiaHealthcarePage dyslipidemiaHealthcarePage = genderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new DyslipidemiaHealthcarePage());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =  dyslipidemiaHealthcarePage
				.waitForPageLoad()
				.clickOnAnswers("Unsure")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
		        .waitForPageLoad();
		
		DebugPageOLS debugPageOLS = new DebugPageOLS();		
		debugPageOLS.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);		
		debugPageOLS.back();		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 =  dyslipidemiaHealthcarePage
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
		        .waitForPageLoad();		
		debugPageOLS.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);		
		debugPageOLS.back();			
		StatinMedicationsPage statinMedicationsPage = dyslipidemiaHealthcarePage
				.waitForPageLoad()
				.clickOnAnswers("High fats or lipids, or hyperlipidemia")				
				.clickNextButton(new StatinMedicationsPage());
		
		AreYouTakingMedications areYouTakingMedications = statinMedicationsPage
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new AreYouTakingMedications());	
		areYouTakingMedications.waitForPageLoad();
		debugPageOLS.checkProtocolsEquals("One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is a ...", protocol1);		
		debugPageOLS.back();	
		HowLongTakingStatin howLongTakingStatin = statinMedicationsPage
				.waitForPageLoad()				
				.clickOnAnswers("Rosuvastatin")
				.clickNextButton(new HowLongTakingStatin());		
		
		AreYouTakingMedications areYouTakingMedications1 = howLongTakingStatin
				.waitForPageLoad()
				.clickOnAnswers("6 months - 11 months")				
				.clickNextButton(new AreYouTakingMedications());		
		
		NonPrescriptionSupplements nonPrescriptionSupplements1 = areYouTakingMedications1
				.waitForPageLoad()
				.clickOnAnswers("Repatha (evolocumab)")
				.clickNextButton(new NonPrescriptionSupplements());
		
		HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = nonPrescriptionSupplements1
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
		
		
//----------*******NEW GENERAL HEALTH Questions********----------     
		haveYouEverExperiencedHeartRelatedMedicalCondOLS
        	.waitForPageLoad()
        	.clickOnAnswers("None of the above")
        	.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS())
       	//-----------HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS-----------        	
        .waitForPageLoad()
        .clickOnAnswers("None of the above")

        .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS())
        //-----------HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS-----------	
        .waitForPageLoad()
        .clickOnAnswers("Angioplasty")
        .clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS())
        //-----------WhenWasYourMostRecentHeartProcedureOLS page-----------	
        .waitForPageLoad()
        .clickOnAnswer("7 - 12 months ago")
        .clickNextButton(new ChildrenUnderPageOLS())
		//----------ChildrenUnderTheAge Page--------------------
	        .waitForPageLoad()
	        .clickOnAnswer("Yes")
	        .clickNextButton(new HouseholdHavePageOLS())
	        .waitForPageLoad()
	        .clickOnAnswers("None of the above")
	        .clickNextButton(new TheStudySitePageOLS())
	        .waitForPageLoad()
		//-------------------PEDIATRIC QUESTIONS-----------------------------   
	        .clickOnAnswer("Public transportation")
	        .clickNextButton(new WhatMedicalCoveragePageOLS())
	        .waitForPageLoad()
	        .clickOnAnswers("No, I have no coverage")
	        .clickNextButton(new EthnicBackgroundPageOLS())
	        .waitForPageLoad()
	        .clickOnAnswers("Prefer not to answer")
	        .clickNextButton(new IdentificationPageOLS())
		//----------PII (IdentificationPageOLS) Page--------------------
			.waitForPageLoad()
	        .clickNextButton(new SiteSelectionPageOLS())
	        .waitForPageLoad(studyName)
	        .getPID()
	        .clickOnFacilityName(siteName)
            .clickNextButton(new HSGeneralPageOLS())
            .waitForPageLoad(site_Indication)
            .clickNextButton(new DoctorInformationCollectionPageOLS())
            .waitForPageLoad()
            .clickNextButton(new  HS1PageOLS())
            .waitForPageLoad()
            .clickOkInPopUp()
            .setSignature()
            .getPage(new ThankYouCloseSimplePageOLS())
            .waitForPageLoad()
    		.clickNextButton(new AboutHealthPageOLS())
    		.waitForPageLoad()
            .pidFromDbToLog(env);		
		
		
/*//-------------------OLD General Health-------------------
 HeartRelatedMedicalProc heartRelatedMedicalProc = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS2
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HeartRelatedMedicalProc());
		
		YouHaveCHF youHaveCHF = heartRelatedMedicalProc
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new YouHaveCHF());
		
		youHaveCHF.waitForPageLoad();
		debugPageOLS.checkProtocolsEquals("Ghost Question - Atherosclerotic Cardiovascular Disease Qualifying Logic", protocol1);		
		debugPageOLS.back();
		WhenLastTimeYouHadHeartProceduresOLS whenLastTimeYouHadHeartProceduresOLS = heartRelatedMedicalProc
				.waitForPageLoad()
				.clickOnAnswers("Stent placement")
				.clickNextButton(new WhenLastTimeYouHadHeartProceduresOLS());
		
		YouHaveCHF youHaveCHF1 = whenLastTimeYouHadHeartProceduresOLS
				.waitForPageLoad()
				.clickOnAnswer("1 - 3 months ago")
				.clickNextButton(new YouHaveCHF());
		youHaveCHF1.waitForPageLoad();
		debugPageOLS.checkProtocolsEqualsForQNumber("QS5210", protocol1);		
		debugPageOLS.back();
		//YouHaveCHF youHaveCHF2 = whenLastTimeYouHadHeartProceduresOLS
				whenLastTimeYouHadHeartProceduresOLS.waitForPageLoad()
				.clickOnAnswer("7 - 12 months ago")
                .clickNextButton(new ChildrenUnderPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HouseholdHavePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TheStudySitePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Other")
                .clickNextButton(new WhatSortPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()                
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                //Medical release Hello Sign CLose
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new  HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()
                .getPage(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
        		.clickNextButton(new AboutHealthPageOLS())
        		.waitForPageLoad()
                .pidFromDbToLog(env);  */
	}
}
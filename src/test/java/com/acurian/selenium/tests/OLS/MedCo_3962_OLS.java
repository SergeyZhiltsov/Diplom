package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.AreYouTakingMedications;
import com.acurian.selenium.pages.OLS.DY_4356.NonPrescriptionSupplements;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MedCo_3962_OLS extends BaseTest {
	
	@Test(enabled = false)
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
		
		DyslipidemiaHealthcarePageOLS dyslipidemiaHealthcarePageOLS = genderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new DyslipidemiaHealthcarePageOLS());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =  dyslipidemiaHealthcarePageOLS
				.waitForPageLoad()
				.clickOnAnswers("Unsure")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
		        .waitForPageLoad();
		
		DebugPageOLS debugPageOLS = new DebugPageOLS();		
		debugPageOLS.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);		
		debugPageOLS.back();		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 =  dyslipidemiaHealthcarePageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
		        .waitForPageLoad();		
		debugPageOLS.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);		
		debugPageOLS.back();			
		StatinMedicationsPage statinMedicationsPage = dyslipidemiaHealthcarePageOLS
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

        .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
        //-----------HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS-----------	
        .waitForPageLoad()
        .clickOnAnswers("Angioplasty")
        .clickNextButton(new MostRecentHeartProcedurePageOLS())
        //-----------MostRecentHeartProcedurePageOLS page-----------
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
            .setSignature();
            
/*            //------------HUMAN API Interface in HelloSign----------------
            .getPage(new HumanAPIOLS())
            .waitForPageLoad()		        
            .connectBTN()
            .switchToAPI()
            .waitForProvider()
            .clickANY()
            .waitSearchAll()
            .search("cleveland clinic")
            .waitProvider()
            .clickProvider()
            .typeUserName("democlinical@gmail.com")
            .typePWD("password")
            .clickConnect()
            
            .waitToClickNext()
	        .clickNextButton(new ThankYouCloseSimplePageOLS())*/

		ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
		thankYouCloseSimplePageOLS
			.waitForPageLoad()
	        .clickNextButton(new AboutHealthPageOLS())
	        .waitForPageLoad()
	        .pidFromDbToLog(env);
	}
}
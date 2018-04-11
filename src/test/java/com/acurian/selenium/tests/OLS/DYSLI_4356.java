package com.acurian.selenium.tests.OLS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.AreYouTakingMedications;
import com.acurian.selenium.pages.OLS.DY_4356.NonPrescriptionSupplements;
import com.acurian.selenium.pages.OLS.DY_4356.PregnancyAndFertilityPage;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedCloseDYSPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedCloseMIG4356Page;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungs;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolism;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditions;
import com.acurian.selenium.pages.OLS.generalHealth.CancerPage;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditions;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DrugOrAlcoholAbuse;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouSmokedCigarettes;
import com.acurian.selenium.pages.OLS.generalHealth.HeartRelatedMedicalProc;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.NeurologicalConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditions;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditions;
import com.acurian.selenium.pages.OLS.generalHealth.WomenHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.YouHaveCHF;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
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


public class DYSLI_4356 extends BaseTest {
	
	@Test
	public void dYSLI_4356_OLS() {
		String phoneNumberDY = "AUTAMS1DYS";
		String studyName = "a cholesterol or heart health";
	    String siteName = "AUT_4356C";
	    String zipCode = "19044";
        String facility_Code_STG = "625255";
        String facility_Code_PRD = "625639";
        
	    String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberDY)		           
		           .waitForPageLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleDYExpected, "Title is diff");
		
		IdentificationPageOLS identificationPageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1975")
		           .clickNextButton(new IdentificationPageOLS());
		
		identificationPageOLS.threadSleep(3000);
		
		GenderPageOLS genderPageOLS = identificationPageOLS				
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
		
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
		//System.out.println(hasHealthcareProfessionalPageOLS.getTitleText());
		Assert.assertEquals(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.getTitleText(),haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.titleExpected, "Title is diff");
		DebugPageOLS debugPageOLS = new DebugPageOLS();
		debugPageOLS.openDebugWindow();
		//debugPageOLS.threadSleep(2000);
		Assert.assertEquals(debugPageOLS.getProtocol201(), "20150230", "Protocol not displayed");
		Assert.assertEquals(debugPageOLS.getProtocolVK(), "VK2809_201", "Protocol not displayed");
		Assert.assertEquals(debugPageOLS.getProtocolR727(), "R727_CL_1532", "Protocol not displayed");
		debugPageOLS.closeDebugWindow();
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.back();
		//haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.threadSleep(2000);		
		
		StatinMedicationsPage statinMedicationsPage = dyslipidemiaHealthcarePage
				.waitForPageLoad()
				.clickOnAnswers("Unsure")
				.clickOnAnswers("High fats or lipids, or hyperlipidemia")				
				.clickNextButton(new StatinMedicationsPage());
		
		AreYouTakingMedications areYouTakingMedications = statinMedicationsPage
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new AreYouTakingMedications());
		
		NonPrescriptionSupplements nonPrescriptionSupplements = areYouTakingMedications
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new NonPrescriptionSupplements());
		
		HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = nonPrescriptionSupplements
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());		
		
		haveYouEverExperiencedHeartRelatedMedicalCondOLS.waitForPageLoad();
		debugPageOLS.openDebugWindow();
		//debugPageOLS.threadSleep(2000);
		Assert.assertEquals(debugPageOLS.getProtocol201(), "20150230", "Protocol not displayed");
		Assert.assertEquals(debugPageOLS.getProtocolVK(), "VK2809_201", "Protocol not displayed");
		//Assert.assertEquals(debugPageOLS.getProtocolR727(), "R727-CL-1532", "Protocol not displayed");
		debugPageOLS.closeDebugWindow()
		.back();
		nonPrescriptionSupplements.back();
		areYouTakingMedications.back();
	
		HowLongTakingStatin howLongTakingStatin = statinMedicationsPage
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Rosuvastatin")
				.clickNextButton(new HowLongTakingStatin());		
		
		howLongTakingStatin.waitForPageLoad();
		AreYouTakingMedications areYouTakingMedications1 = howLongTakingStatin
				.waitForPageLoad()
				.clickOnAnswers("6 months - 11 months")				
				.clickNextButton(new AreYouTakingMedications());
		
		areYouTakingMedications
				.waitForPageLoad();
				NonPrescriptionSupplements nonPrescriptionSupplements1 = areYouTakingMedications1
				.clickNextButton(new NonPrescriptionSupplements());
		
		nonPrescriptionSupplements1
				.waitForPageLoad()
				//HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = nonPrescriptionSupplements1
				.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
		
		haveYouEverExperiencedHeartRelatedMedicalCondOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above");
				 HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
				.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS());

		haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above");
				HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS = haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());

		haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above");
				PregnancyAndFertilityPage pregnancyAndFertilityPage = haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.clickNextButton(new PregnancyAndFertilityPage());	
				
		pregnancyAndFertilityPage
				.waitForPageLoad()
				.clickOnAnswers("I currently have my \"tubes tied\" (also called bilateral tubal ligation, a sterilization procedure)")
				//PregnancyAndFertilityPage pregnancyAndFertilityPage = haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());					
					 
		
		
        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
   //&&&&&&&&&&&&&&&& New for AMS1 Rel.51, when Gender = Female &&&&&&&&&&&&&&&&&&&&
        .clickNextButton(new HormonalBirthControlOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
   //&&&&&&&&&&&&&&&& END &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
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
				.waitForPageLoad();
				SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
		        //.setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
				siteSelectionPageOLS.clickNextButton(new SiteSelectionPageOLS());
		//----------SITE Selection Page--------------------		
		SynexusQualifiedCloseDYSPageOLS synexusQualifiedCloseDYSPageOLS = siteSelectionPageOLS
				.waitForPageLoad(studyName)
				.getPID()
				.clickOnFacilityName(siteName)
				.clickNextButton(new SynexusQualifiedCloseDYSPageOLS());		
		//----------Synexus Qualified Close (DYSPageOLS) Page--------------------			
		ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = synexusQualifiedCloseDYSPageOLS
		        .waitForPageLoad(env.equals("STG")? facility_Code_STG : facility_Code_PRD)
				.clickNextButton(new ThankYouCloseSimplePageOLS());
		//----------Thank you Close Page--------------------		
		AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
				.waitForPageLoad()
				.clickNextButton(new AboutHealthPageOLS());				
		//---------------ALL about Health page -----------
		aboutHealthPageOLS.waitForPageLoad()
		.pidFromDbToLog(env);
        
		
		
	/*	//---------OLD General Health-------------------
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS2 = nonPrescriptionSupplements1
				.waitForPageLoad()
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		HeartRelatedMedicalProc heartRelatedMedicalProc = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS2
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HeartRelatedMedicalProc());
		
		PregnancyAndFertilityPage pregnancyAndFertilityPage = heartRelatedMedicalProc
				.waitForPageLoad()
				.clickOnAnswers("Stent placement")
				.clickNextButton(new PregnancyAndFertilityPage());
		
		WhenLastTimeYouHadHeartProceduresOLS whenLastTimeYouHadHeartProceduresOLS = new WhenLastTimeYouHadHeartProceduresOLS();
		whenLastTimeYouHadHeartProceduresOLS.waitForPageLoad()
		                                    .clickOnAnswer("7 - 12 months ago")
		                                    .clickNextButton(new WhenLastTimeYouHadHeartProceduresOLS());
		
		YouHaveCHF youHaveCHF = pregnancyAndFertilityPage
				.waitForPageLoad()
				.clickOnAnswers("I currently have my \"tubes tied\" (also called bilateral tubal ligation, a sterilization procedure)")
				.clickNextButton(new YouHaveCHF());
		
		youHaveCHF.threadSleep(2000);
		System.out.println(youHaveCHF.getTitleText());
		AffectingYourMetabolism affectingYourMetabolism = youHaveCHF
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new AffectingYourMetabolism());
		
		NeurologicalConditions neurologicalConditions = affectingYourMetabolism
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new NeurologicalConditions());
		
		AffectYourLungs affectYourLungs = neurologicalConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new AffectYourLungs());
		
		DigestiveConditions digestiveConditions = affectYourLungs
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new DigestiveConditions());
		
		BoneOrJointConditions boneOrJointConditions = digestiveConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new BoneOrJointConditions());
		
		SleepRelatedConditions sleepRelatedConditions = boneOrJointConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SleepRelatedConditions());
		
		SkinConditions skinConditions = sleepRelatedConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SkinConditions());
		
		ViralConditions viralConditions = skinConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ViralConditions());
		
		MentalHealthConditions mentalHealthConditions = viralConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new MentalHealthConditions());
		
		
		WomenHealthConditions womenHealthConditions = mentalHealthConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new WomenHealthConditions());
		
		CancerPage cancerPage = womenHealthConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new CancerPage());
		
		HaveYouSmokedCigarettes haveYouSmokedCigarettes = cancerPage
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new HaveYouSmokedCigarettes());
		
		DrugOrAlcoholAbuse drugOrAlcoholAbuse = haveYouSmokedCigarettes
				.waitForPageLoad()
				.clickOnAnswers("No, I never smoked")
				.clickNextButton(new DrugOrAlcoholAbuse());
		
		
		ProvideHeightWeight provideHeightWeight = drugOrAlcoholAbuse
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new ProvideHeightWeight());
		
		ChildrenUnderTheAge childrenUnderTheAge = provideHeightWeight
				.waitForPageLoad()
				.setFT("5")
				.setIN("5")
				.setWeight("155")
				.clickNextButton(new ChildrenUnderTheAge());
		
		PersonalDetails personalDetails1 =  childrenUnderTheAge
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new PersonalDetails());

		SiteSelectionPageOLS siteSelectionPageOLS = personalDetails1
				.waitForPageLoad()							
				.clickNextButton(new SiteSelectionPageOLS());
		
		SynexusQualifiedCloseDYSPageOLS synexusQualifiedCloseDYSPageOLS = siteSelectionPageOLS
				.waitForPageLoad(studyName)
				.getPID()
				.clickOnFacilityName(siteName)
				.clickNextButton(new SynexusQualifiedCloseDYSPageOLS());
		
		ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = synexusQualifiedCloseDYSPageOLS
		        .waitForPageLoad(env.equals("STG")? facility_Code_STG : facility_Code_PRD)
				.clickNextButton(new ThankYouCloseSimplePageOLS());
		
		AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
				.waitForPageLoad()
				.clickNextButton(new AboutHealthPageOLS());
		
		
		aboutHealthPageOLS.waitForPageLoad()
		.pidFromDbToLog(env); */
	}
}
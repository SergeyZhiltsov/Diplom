package com.acurian.selenium.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.RA.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RA_4356F_OLS extends BaseTest {
	
    @Test(enabled = false)
	public void rA_4356F_OLS() {
		String phoneNumberRA = "AUTAMS1RA1";
	//	String env = "STG";
		//String protocol1 = "M13_545";
        String protocol2 = "M15_925";        
        String protocol3 = "CL04041023";
        //List<String> protocols = Arrays.asList(protocol2,protocol3);
        String studyName = "a rheumatoid arthritis (RA)";
        String indication = "an arthritis";
        String siteName = "AUT_RA_4356F_Site";
        String zipCode = "19044";
        String facility_Code_STG = "625317";
        String facility_Code_PRD = "625908";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberRA)
		          // .waitForPageLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText().contains("Let's get started to see if you qualify for a rheumatoid arthritis (RA) study!"), true);
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1980")
		           .clickNextButton(new ZipCodePageOLS());
				
		GenderPageOLS genderPageOLS = zipCodePageOLS
		          .waitForPageLoad()
		          .typeZipCode("19044")
		          .clickNextButton(new GenderPageOLS());		
		
		DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS	
		         .waitForPageLoad()
		         .clickOnAnswer("Female")
		         .clickNextButton(new DoYouSufferFromArthritis());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouSufferFromArthritis
				 .waitForPageLoad()
				 .clickOnAnswer("No")
				 .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(doYouSufferFromArthritis.titleExpected, protocol2);
        debugPageOLS.back();
                
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
				 .waitForPageLoad()
				 .clickOnAnswer("Yes")
				 .clickNextButton(new WhatKindOfArthritisPageOLS());
		
		
		WhenYouDiagnosedWithRaPageOLS whenYouDiagnosedWithRaPageOLS = whatKindOfArthritisPageOLS
				.waitForPageLoad()
				.clickOnAnswers("Rheumatoid arthritis")
				.clickNextButton(new WhenYouDiagnosedWithRaPageOLS());
		
		AgeWhenDiagnosedWithRA ageWhenDiagnosedWithRA = whenYouDiagnosedWithRaPageOLS
				.waitForPageLoad()
				.clickOnAnswer("7 - 11 months ago")
				.clickNextButton(new AgeWhenDiagnosedWithRA());
		
		HowYourRASymptomsStartedFirstTime howYourRASymptomsStartedFirstTime = ageWhenDiagnosedWithRA
				.waitForPageLoad()
				.setAge("28")
				.clickNextButton(new HowYourRASymptomsStartedFirstTime());
		
		WhatTestsDidYouHave whatTestsDidYouHave = howYourRASymptomsStartedFirstTime
				.waitForPageLoad()
				.clickOnAnswer("Symptoms took several months to develop; the pain built gradually over a period of time")
				.clickNextButton(new WhatTestsDidYouHave());
		
		AreYouCurrentlyExperiencing areYouCurrentlyExperiencing = whatTestsDidYouHave
				.waitForPageLoad()
				.clickOnAnswers("An x-ray of your affected joints, which included multiple joints such as your hands and feet")
				.clickNextButton(new AreYouCurrentlyExperiencing());
		
		FollowingJointSymptoms followingJointSymptoms = areYouCurrentlyExperiencing
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new FollowingJointSymptoms());
		
		DoYouCurrentlyUseSteroid doYouCurrentlyUseSteroid = followingJointSymptoms
				.waitForPageLoad()
				.clickOnAnswers("Pain or swelling in at least 3 separate joints")
				.clickNextButton(new DoYouCurrentlyUseSteroid());
		
		InPastDidYouTakeSteroids inPastDidYouTakeSteroids = doYouCurrentlyUseSteroid
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new InPastDidYouTakeSteroids());
		
		CurrentlyTakingMethotrexate currentlyTakingMethotrexate = inPastDidYouTakeSteroids
				.waitForPageLoad()
				.clickOnAnswer("No")				
				.clickNextButton(new CurrentlyTakingMethotrexate());
		
		HowLongTakingMethotrexate howLongTakingMethotrexate = currentlyTakingMethotrexate
				.waitForPageLoad()
				.clickOnAnswer("Yes, I am taking methotrexate tablets or pills")
				.clickNextButton(new HowLongTakingMethotrexate());
		
		MedicationsToTreatYourRA medicationsToTreatYourRA = howLongTakingMethotrexate
				.waitForPageLoad()
				.clickOnAnswer("4 - 6 months")
				.clickNextButton(new MedicationsToTreatYourRA());
		
		
		HowLongTakingPlaquenil HowLongTakingPlaquenil = medicationsToTreatYourRA
				.waitForPageLoad()
				.clickOnAnswers("Plaquenil (hydroxychloroquine)")
				.clickNextButton(new HowLongTakingPlaquenil());
		
		BiologicMedications biologicMedications = HowLongTakingPlaquenil
				.waitForPageLoad()
				.clickOnAnswer("4 - 6 months")
				.clickNextButton(new BiologicMedications());
		
		LastReceivedOrenciaOLS lastReceivedOrenciaOLS = biologicMedications
				.waitForPageLoad()
				.clickOnAnswers("Orencia")
				.clickNextButton(new LastReceivedOrenciaOLS());
		
		TakenXeljanz TakenXeljanz = lastReceivedOrenciaOLS
				.waitForPageLoad()
				.clickOnAnswer("Last received 7 to 11 months ago")
				.clickNextButton(new TakenXeljanz());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = TakenXeljanz
				.waitForPageLoad()
				.clickOnAnswer("No, I have never taken it")
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
        .setAll("5", "5", "160")
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
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env)
		 //.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
		.getAnomalyDbToLog(env);        
	}
}
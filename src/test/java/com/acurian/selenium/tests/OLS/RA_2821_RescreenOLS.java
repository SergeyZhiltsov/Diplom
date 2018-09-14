package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA_2821.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RA_2821_RescreenOLS extends BaseTest {

    @Test(enabled = true)
	public void ra_2821_OLS() {
		String phoneNumberRA = "AUTAMS1RA2";  //Referral Service Code = "Rescreen 2821" in GEMBA
        String protocol1 = "M15_925";
        String studyName = "a rheumatoid arthritis (RA)";
        //String siteName = "AUT_RA2821_Site";
        String siteName = "AUT_RA2821_HS_Site";
        String zipCode = "19044";
        String Siteindicator = "Rheumatoid Arthritis";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberRA)		           
		           .waitForPageLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText().contains("Let's get started to see if you qualify for a rheumatoid arthritis (RA) study!"), true);
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1980")
		           .clickNextButton(new ZipCodePageOLS());
				
		GenderPageOLS genderPageOLS = zipCodePageOLS
		          .waitForPageLoad()
		          .typeZipCode("19044")
		          .clickNextButton(new GenderPageOLS());		
		
		AreYouCurrentlyExperiencing areYouCurrentlyExperiencing = genderPageOLS	
		         .waitForPageLoad()
		         .clickOnAnswer("Female")
		         .clickNextButton(new AreYouCurrentlyExperiencing());
		

		
		//-----------------------AreYouCurrentlyExperiencing Page -----------
		FollowingJointSymptoms followingJointSymptoms = areYouCurrentlyExperiencing
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new FollowingJointSymptoms());
		DebugPageOLS debugPageOLS = new DebugPageOLS();
		debugPageOLS.checkProtocolsEquals(areYouCurrentlyExperiencing.titleExpected, protocol1); //protocol2
        debugPageOLS.back();
        areYouCurrentlyExperiencing
		        .waitForPageLoad();
        		CurrentlyTakingMethotrexate currentlyTakingMethotrexate = areYouCurrentlyExperiencing
		        .clickOnAnswer("Yes")
		        .clickNextButton(new CurrentlyTakingMethotrexate());

		
	//----------Are you currently taking methotrexate for your Rheumatoid Arthritis? --------------
		HowLongTakingMethotrexate howLongTakingMethotrexate = currentlyTakingMethotrexate
				.waitForPageLoad()
				.clickOnAnswer("Yes, I am taking methotrexate tablets or pills")
				.clickNextButton(new HowLongTakingMethotrexate());
		
		
		MedicationsToTreatYourRA medicationsToTreatYourRA = howLongTakingMethotrexate
				.waitForPageLoad()
				.clickOnAnswer("Less than 1 month")
				.clickNextButton(new MedicationsToTreatYourRA());		
		debugPageOLS.checkProtocolsEquals(howLongTakingMethotrexate.titleExpected, protocol1); //protocol2
        debugPageOLS.back();
        howLongTakingMethotrexate
		       .waitForPageLoad()
		       .clickOnAnswer("4 - 6 months")
		       .clickNextButton(new MedicationsToTreatYourRA());
        
		
        BiologicMedications biologicMedications = medicationsToTreatYourRA
				.waitForPageLoad()
				.clickOnAnswers("Leukeran (chlorambucil)")
				.clickNextButton(new BiologicMedications());
        debugPageOLS.checkProtocolsEquals("Are you currently taking any of the following medications to treat your RA?Agent Note: Read medicat...", protocol1); //protocol2
        debugPageOLS.back();
        medicationsToTreatYourRA
				.waitForPageLoad()
				.clickOnAnswers("Leukeran (chlorambucil)")
				.clickOnAnswers("Plaquenil (hydroxychloroquine)")
				.clickNextButton(new HowLongTakingPlaquenil());
        
        
        HowLongTakingPlaquenil howLongTakingPlaquenil = new HowLongTakingPlaquenil();		
		howLongTakingPlaquenil
				.waitForPageLoad()				
				.clickOnAnswer("Less than 1 month")
				.clickNextButton(new BiologicMedications());		
		debugPageOLS.checkProtocolsEqualsForQNumber("QS521", protocol1); //protocol2
        debugPageOLS.back();        
        howLongTakingPlaquenil
				.waitForPageLoad()
				.clickOnAnswer("4 - 6 months")
				.clickNextButton(new BiologicMedications());
        
		
		biologicMedications
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new TakenXeljanz());
		debugPageOLS.checkProtocolsEquals("Ghost Question - 2821 RA bDMARD protocol logic - (\"bDMARD Exposure\") for M14-465 and M13-549, (\"Biol...", protocol1); //protocol2
        debugPageOLS.back();
        LastReceivedTysabri lastReceivedTysabri = biologicMedications
				.waitForPageLoad()
				.clickOnAnswers("Tysabri")
				.clickNextButton(new LastReceivedTysabri());
        
        
        TakenXeljanz takenXeljanz = lastReceivedTysabri
				.waitForPageLoad()
				.clickOnAnswer("Last received 7 to 11 months ago")
				.clickNextButton(new TakenXeljanz());
        
        
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = takenXeljanz
				.waitForPageLoad()
				.clickOnAnswer("Yes, I am currently taking it")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		debugPageOLS.checkProtocolsEquals("Xeljanz is a pill that is taken for rheumatoid arthritis (RA). Xeljanz is also called tofacitinib.Ha...", protocol1); //protocol2
        debugPageOLS.back();
        takenXeljanz
				.waitForPageLoad();
        		ChildrenUnderPageOLS childrenUnderPageOLS = takenXeljanz
				.clickOnAnswer("No, I have never taken it")
				.clickNextButton(new ChildrenUnderPageOLS());

        
		//----------*******NEW GENERAL HEALTH Questions********----------
       /* haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        //-------------------New for AMS1 Rel.51, when Gender = Female----------------
        .clickNextButton(new HormonalBirthControlOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new ApproximateHeightPageOLS())
		//----------ProvideHeight-Weight Page--------------------
        .waitForPageLoad()
        .setAll("5", "5", "160")
        .clickNextButton(new ChildrenUnderPageOLS())*/
        childrenUnderPageOLS
        	.waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new HouseholdHavePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new TheStudySitePageOLS())
        .waitForPageLoad()
        .clickOnAnswer("Public transportation")        
        .clickNextButton(new WhatMedicalCoveragePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("No, I have no coverage")
        .clickNextButton(new EthnicBackgroundPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("Prefer not to answer")
        .clickNextButton(new IdentificationPageOLS())
        .waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new SiteSelectionPageOLS())
        .waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new HSGeneralPageOLS())
        .waitForPageLoad(Siteindicator)
        .clickNextButton(new DoctorInformationCollectionPageOLS())        
        .waitForPageLoad()
        .clickNextButton(new HS1PageOLS())
        .waitForPageLoad()        
        .clickOkInPopUp()
        .setSignature()
        
        //------------HUMAN API Interface in HelloSign----------------
        /*.getPage(new HumanAPIOLS())
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
        .clickConnect()*/
        
        .waitToClickNext()
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
	}
}
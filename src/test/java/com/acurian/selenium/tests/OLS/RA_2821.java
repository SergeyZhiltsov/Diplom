package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.RA_2821.AgeWhenDiagnosedWithRA;
import com.acurian.selenium.pages.OLS.RA_2821.AreYouCurrentlyExperiencing;
import com.acurian.selenium.pages.OLS.RA_2821.CurrentlyTakingMethotrexate;
import com.acurian.selenium.pages.OLS.RA_2821.DoYouCurrentlyUseSteroid;
import com.acurian.selenium.pages.OLS.RA_2821.FollowingJointSymptoms;
import com.acurian.selenium.pages.OLS.RA_2821.HowLongTakingMethotrexate;
import com.acurian.selenium.pages.OLS.RA_2821.HowLongTakingPlaquenil;
import com.acurian.selenium.pages.OLS.RA_2821.HowYourRASymptomsStartedFirstTime;
import com.acurian.selenium.pages.OLS.RA_2821.InPastDidYouTakeSteroids;
import com.acurian.selenium.pages.OLS.RA_2821.MedicationsToTreatYourRA;
import com.acurian.selenium.pages.OLS.RA_2821.WhatTestsDidYouHave;
import com.acurian.selenium.pages.OLS.RA_2821.WhenYouDiagnosedWithRA;
import com.acurian.selenium.pages.OLS.closes.ALotAbouthealth;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.GladLocationIsConvenient;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSCrohns2PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.SiteSelection;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouPage;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungs;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolism;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolismPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditions;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.CancerPage;
import com.acurian.selenium.pages.OLS.generalHealth.CongestiveHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditions;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DrugOrAlcoholAbuse;
import com.acurian.selenium.pages.OLS.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouSmokedCigarettes;
import com.acurian.selenium.pages.OLS.generalHealth.HeartRelatedMedicalProc;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HistoryOfDrugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.NeurologicalConditions;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
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
import com.acurian.selenium.pages.OLS.pediatric.WouldYouUsePageOLS;
import com.acurian.selenium.pages.OLS.shared.*;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RA_2821 extends BaseTest {

    @Test(enabled = true)
	public void rA_2821_OLS() {
		String phoneNumberRA = "AUTAMS1RA1";
//		String env = "STG";
//		String protocol2 = "M13_545";  Protocol Disabled
        String protocol1 = "M15_925";
        String studyName = "a rheumatoid arthritis (RA)";
        String siteName = "AUT_RA2821_Site";
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
		
		DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS	
		         .waitForPageLoad()
		         .clickOnAnswer("Female")
		         .clickNextButton(new DoYouSufferFromArthritis());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouSufferFromArthritis
				 .waitForPageLoad()
				 .clickOnAnswer("No")
				 .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(doYouSufferFromArthritis.titleExpected, protocol1);
        debugPageOLS.back();
                
        WhatKindOfArthritisPage whatKindOfArthritisPage = doYouSufferFromArthritis
				 .waitForPageLoad()
				 .clickOnAnswer("Yes")
				 .clickNextButton(new WhatKindOfArthritisPage());
		
		
		WhenYouDiagnosedWithRA whenYouDiagnosedWithRA = whatKindOfArthritisPage
				.waitForPageLoad()
				.clickOnAnswer("Rheumatoid arthritis")
				.clickNextButton(new WhenYouDiagnosedWithRA());
		
		AgeWhenDiagnosedWithRA ageWhenDiagnosedWithRA = whenYouDiagnosedWithRA
				.waitForPageLoad()
				.clickOnAnswer("3 - 6 months ago")
				.clickNextButton(new AgeWhenDiagnosedWithRA());
		
		HowYourRASymptomsStartedFirstTime howYourRASymptomsStartedFirstTime = ageWhenDiagnosedWithRA
				.waitForPageLoad()
				.setAge("16")
				.clickNextButton(new HowYourRASymptomsStartedFirstTime());
		
		debugPageOLS.checkProtocolsEquals("Approximately how old were you when you were diagnosed with RA?Agent Note: If patient is unsure, sa...", protocol1); //protocol2
        debugPageOLS.back();
        
        ageWhenDiagnosedWithRA
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
				.clickOnAnswer("No")
				.clickNextButton(new FollowingJointSymptoms());
		
		debugPageOLS.checkProtocolsEquals(areYouCurrentlyExperiencing.titleExpected, protocol1); //protocol2
        debugPageOLS.back();
        
        areYouCurrentlyExperiencing
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
        .getPage(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
        
        
        /*---------------OLD General Health-----------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new CongestiveHeartFailurePageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new AffectingYourMetabolismPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new FollowingNeurologicalConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new AffectYourLungsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new DigestiveConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new BoneOrJointConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new SleepRelatedConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new SkinConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new ViralConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new MentalHealthPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new WomensHealthPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new OtherThanSkinCancerPageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new SmokedCigarettesPageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No, I never smoked")
        .clickNextButton(new HistoryOfDrugPageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new ApproximateHeightPageOLS())
        .waitForPageLoad()
        .setAll("5", "5", "160")
        .clickNextButton(new ChildrenUnderPageOLS())
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
        .getPage(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);		*/
	}

}

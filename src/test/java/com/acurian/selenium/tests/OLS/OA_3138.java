package com.acurian.selenium.tests.OLS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.OA_3138.CurrentlyTakingFollowingNSAIDMedication;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;
import com.acurian.selenium.pages.OLS.OA_3138.TreatedPainWithMarijuanaOrCannabis;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolism;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolismPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HeartRelatedMedicalProc;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HistoryOfDrugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SmokedCigarettesPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WomensHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.YouHaveCHF;
import com.acurian.selenium.pages.OLS.shared.AnyMedicationForYourArthritis;
import com.acurian.selenium.pages.OLS.shared.CurrentlyTakinnFollowingNSAIDMedication;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DiagnosedwithCarpalTunnelSyndrome;
import com.acurian.selenium.pages.OLS.shared.DoYouSufferFromArthritis;
import com.acurian.selenium.pages.OLS.shared.FollowingDevicesInYourBody;
import com.acurian.selenium.pages.OLS.shared.FutureJointReplacementSurgery;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.LongTermSteroidPrescription;
import com.acurian.selenium.pages.OLS.shared.NSAIDMedication;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.PrescriptionPainMedicationsForArthritis;
import com.acurian.selenium.pages.OLS.shared.TreatedYourArthritisPainAcetaminophen;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.WhereYouHaveArthritis;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

public class OA_3138 extends BaseTest {
	
	@Test(enabled = false)
	public void OA_3138_OLS() {
		String phoneNumberDY = "AUTAMS1OA1";		
//		String env = "PRD";		
		String zipCode = "99546";
		String studyName = "an arthritis";
	    String siteName = "AUT_OA_3138_Site";
	    String protocol1 = "R475_PN_1523";
	    
	    String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
	    
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberDY)		           
		           .waitForPageLoad()
		           .maximizePage();
	//	Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleOA_Expected, "Title is diff");
		
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1975")
		           .clickNextButton(new ZipCodePageOLS());
		
		GenderPageOLS genderPageOLS = zipCodePageOLS
				.waitForPageLoad()
				.typeZipCode("99546")
				.clickNextButton(new GenderPageOLS());
		
		DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new DoYouSufferFromArthritis());
		
		WhatKindOfArthritisPage whatKindOfArthritisPage = doYouSufferFromArthritis
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new WhatKindOfArthritisPage());
		
		WhereYouHaveArthritis whereYouHaveArthritis = whatKindOfArthritisPage
				.waitForPageLoad()
				.clickOnAnswer("Osteoarthritis")
				.clickNextButton(new WhereYouHaveArthritis());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS hasHealthcareProfessionalPageOLS = whereYouHaveArthritis
				.waitForPageLoad()
				.clickOnAnswer("Spine or shoulders")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
		DebugPageOLS debugPageOLS = new DebugPageOLS();
		
		
		
		debugPageOLS.checkProtocolsEqualsForQNumber("QS1304", protocol1);
		debugPageOLS.back();
		
		/*debugPageOLS.openDebugWindow()
		            .threadSleep(2000);
		Assert.assertEquals(debugPageOLS.getProtocolOA(), "R475_PN_1523", "Protocol not displayed");		
		debugPageOLS.closeDebugWindow();		
		hasHealthcareProfessionalPageOLS.back();*/
		
		AnyMedicationForYourArthritis anyMedicationForYourArthritis = whereYouHaveArthritis
		         .waitForPageLoad()
		         .clickOnAnswer("Spine or shoulders")
		         .clickOnAnswer("Left Knee")
		         .clickNextButton(new AnyMedicationForYourArthritis());
		
		NSAIDMedication nSAIDMedication = anyMedicationForYourArthritis
				.waitForPageLoad()
				.clickOnAnswer("3 days per week")
				.clickNextButton(new NSAIDMedication());
		
		CurrentlyTakinnFollowingNSAIDMedication currentlyTakinnFollowingNSAIDMedication = nSAIDMedication
				.waitForPageLoad()
				.clickOnAnswer("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
				.clickNextButton(new CurrentlyTakinnFollowingNSAIDMedication());
		
		HowManyTotalDaysYouTakeFollowingNSAID howManyTotalDaysYouTakeFollowingNSAID = currentlyTakinnFollowingNSAIDMedication
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new HowManyTotalDaysYouTakeFollowingNSAID());
		
		TreatedYourArthritisPainAcetaminophen treatedYourArthritisPainAcetaminophen =  howManyTotalDaysYouTakeFollowingNSAID
				.waitForPageLoad()
				.clickOnAnswer("2 days")
				.clickNextButton(new TreatedYourArthritisPainAcetaminophen());
		
		PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophen
				.waitForPageLoad()
				.clickOnAnswer("I am unsure")
				.clickNextButton(new PrescriptionPainMedicationsForArthritis());
		
		LongTermSteroidPrescription longTermSteroidPrescription = prescriptionPainMedicationsForArthritis
				.waitForPageLoad()
				.clickOnAnswer("Tylenol #3 or Tylenol #4 (acetaminophen with codeine)")
				.clickNextButton(new LongTermSteroidPrescription());
		
		FollowingDevicesInYourBody followingDevicesInYourBody = longTermSteroidPrescription
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new FollowingDevicesInYourBody());
		
		DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome = followingDevicesInYourBody
				.waitForPageLoad()
				.clickOnAnswer("None of the above")
				.clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());
		
		TreatedPainWithMarijuanaOrCannabis treatedPainWithMarijuanaOrCannabis = diagnosedwithCarpalTunnelSyndrome
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new TreatedPainWithMarijuanaOrCannabis());
		
		FutureJointReplacementSurgery futureJointReplacementSurgery = treatedPainWithMarijuanaOrCannabis
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new FutureJointReplacementSurgery());
		
		ParticipatedInAnotherClinicalResearch participatedInAnotherClinicalResearch = futureJointReplacementSurgery
				.waitForPageLoad()
				.clickOnAnswer("Yes, my doctor and I have discussed it, but my doctor said I don't need joint replacement at this time")
				.clickNextButton(new ParticipatedInAnotherClinicalResearch());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = participatedInAnotherClinicalResearch
				.waitForPageLoad()
				.clickOnAnswer("No")
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
        .waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new QualifiedClosedPageOLS())
        .waitForPageLoad()
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForSENRPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
		
		/*-----------------OLD general health--------------------
		hasHealthcareProfessionalPageOLS1
		        .waitForPageLoad()
		        .clickOnAnswers("None of the above")
		        .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
		        .waitForPageLoad()
		        .clickOnAnswers("None of the above")
		        .clickNextButton(new YouHaveCHF())
		        .waitForPageLoad()
		        .clickOnAnswers("No")
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
		        .clickOnAnswer("No")
		        .clickNextButton(new TheStudySitePageOLS())
		        .waitForPageLoad()
		        .clickOnAnswer("No")        
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
                .clickNextButton(new QualifiedClosedPageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(5000);  */	
	}
}
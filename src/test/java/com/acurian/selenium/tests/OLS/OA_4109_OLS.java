package com.acurian.selenium.tests.OLS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;
import com.acurian.selenium.pages.OLS.OA_3138.TreatedPainWithMarijuanaOrCannabis;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolismPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
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
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WouldYouUsePageOLS;
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
import com.acurian.selenium.pages.OLS.shared.PrescriptionPainMedicationsForArthritis;
import com.acurian.selenium.pages.OLS.shared.TreatedYourArthritisPainAcetaminophen;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.WhereYouHaveArthritis;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

public class OA_4109_OLS extends BaseTest {
	
	@Test(enabled = true)
	public void oA_4109_OLS() {
		String phoneNumberDY = "AUTAMS1OA1";		
	//	String env = "PRD";		
		String zipCode = "99546";
		String studyName = "an osteoarthritis";
	    String siteName = "AUT_OA_4109_Site";
	    String protocol1 = "R475_OA_1611";
	    String protocol2 = "R475_OA_1688";
	    
	    String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
	    
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberDY)		           
		           .waitForPageLoad()
		           .maximizePage();
		//Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleOA4109_Expected, "Title is diff");
		
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1980")
		           .clickNextButton(new ZipCodePageOLS());
		
		GenderPageOLS genderPageOLS = zipCodePageOLS
				.waitForPageLoad()
				.typeZipCode(zipCode)
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
		
		AnyMedicationForYourArthritis anyMedicationForYourArthritis = whereYouHaveArthritis
		         .waitForPageLoad()		         
		         .clickOnAnswer("Right Knee")
		         .clickNextButton(new AnyMedicationForYourArthritis());
		
		NSAIDMedication nSAIDMedication = anyMedicationForYourArthritis
				.waitForPageLoad()
				.clickOnAnswer("1 - 2 days per week or less")
				.clickNextButton(new NSAIDMedication());
		
		/*CurrentlyTakinnFollowingNSAIDMedication currentlyTakinnFollowingNSAIDMedication = nSAIDMedication
				.waitForPageLoad()
				.clickOnAnswer("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
				.clickNextButton(new CurrentlyTakinnFollowingNSAIDMedication());		
		HowManyTotalDaysYouTakeFollowingNSAID howManyTotalDaysYouTakeFollowingNSAID = currentlyTakinnFollowingNSAIDMedication
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new HowManyTotalDaysYouTakeFollowingNSAID());*/
		
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
				.clickOnAnswer("5 days")
				.clickNextButton(new TreatedYourArthritisPainAcetaminophen());
		
		PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophen
				.waitForPageLoad()
				.clickOnAnswer("I am unsure")
				.clickNextButton(new PrescriptionPainMedicationsForArthritis());
		
		LongTermSteroidPrescription longTermSteroidPrescription = prescriptionPainMedicationsForArthritis
				.waitForPageLoad()
				.clickOnAnswers("Tylenol #3 or Tylenol #4 (acetaminophen with codeine)")
				.clickNextButton(new LongTermSteroidPrescription());
		
		FollowingDevicesInYourBody followingDevicesInYourBody = longTermSteroidPrescription
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new FollowingDevicesInYourBody());
		
		DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome = followingDevicesInYourBody
				.waitForPageLoad()
				.clickOnAnswer("None of the above")
				.clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());		
		
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedwithCarpalTunnelSyndrome
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
        .clickNextButton(new QualifiedClose2PageOLS())
        .waitForPageLoad()
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForSENRPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        //.waitForPageLoad()
        .pidFromDbToLog(env);
	}
}
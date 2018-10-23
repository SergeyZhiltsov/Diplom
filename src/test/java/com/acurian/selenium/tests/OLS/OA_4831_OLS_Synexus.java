package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;
import com.acurian.selenium.pages.OLS.OA_3138.TreatedPainWithMarijuanaOrCannabis;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.AgeUnqualifiedClose_OLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class OA_4831_OLS_Synexus extends BaseTest {

    @Test(enabled = true)
    public void OA_4831_OLS_Script() {
        String phoneNumberDY = "AUTAMS1OA1";
        String zipCode = "19901";
        String studyName = "an osteoarthritis";
        String siteName_Synexus = "AUT_OA_4831_Syn";
        String protocol1 = "R475_PN_1523_B";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumberDY)
                .waitForPageLoad()
                .maximizePage();

        //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
        		.setDate("09092002")
                .clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS
        	.waitForPageLoad();
			DebugPageOLS debugPageOLS = new DebugPageOLS();
			ageUnqualifiedClose_OLS.getPage(debugPageOLS)
			.checkProtocolsContainsForQNumber("QSI8004", protocol1)
			.back();
		 dateOfBirthPageOLS
			.waitForPageLoad();
	     ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
            .setDate("09091980")
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

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS hasHealthcareProfessionalPageOLS = whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4504", protocol1);
        debugPageOLS.back();
        AnyMedicationForYourArthritis anyMedicationForYourArthritis = whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickOnAnswer("Left Hip")
                .clickOnAnswer("Right Hip")
                .clickNextButton(new AnyMedicationForYourArthritis());

        
        NSAIDMedication nSAIDMedication = anyMedicationForYourArthritis
        		.waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain") 
                .clickOnAnswer("1 - 2 days per week or less")
                .clickNextButton(new NSAIDMedication());
        nSAIDMedication
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4520", protocol1);
        debugPageOLS.back();
        anyMedicationForYourArthritis
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
        

        TreatedYourArthritisPainAcetaminophen treatedYourArthritisPainAcetaminophen = howManyTotalDaysYouTakeFollowingNSAID
                .waitForPageLoad()
                .clickOnAnswer("2 days")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophen());
        

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophen
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());
        

        HasYourDoctorEverPrescribedOpioidNarcotic_OLS hasYourDoctorEverPrescribedOpioidNarcotic_OLS = prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_OLS());
        
        
        
        hasYourDoctorEverPrescribedOpioidNarcotic_OLS
        		.waitForPageLoad()
                .clickOnAnswer("No, my doctor never offered me a prescription for opioids or narcotics for pain")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        hasHealthcareProfessionalPageOLS
        		.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4511", protocol1);
        debugPageOLS.back();
        AreYouCurrentlyOnPageOLS areYouCurrentlyOnPageOLS = hasYourDoctorEverPrescribedOpioidNarcotic_OLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
        		.clickNextButton(new AreYouCurrentlyOnPageOLS());
        

        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4513", protocol1);
        		debugPageOLS.back();
        areYouCurrentlyOnPageOLS
                .waitForPageLoad();
        HaveYouEverHadKneeReplacementSurgery_OLS haveYouEverHadKneeReplacementSurgery_OLS = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgery_OLS());
        
        
        
        //-----------HaveYouEverHadKneeReplacementSurgery_OLS--------------------
        haveYouEverHadKneeReplacementSurgery_OLS
        		.waitForPageLoad();
        HaveYouEverReceivedInjectionIntoYourKnee_OLS haveYouEverReceivedInjectionIntoYourKnee_OLS = haveYouEverHadKneeReplacementSurgery_OLS
        		.clickOnAnswer("Yes, both knees have been replaced")
        		.clickOnAnswer("Yes, one knee has been replaced")
        		.clickOnAnswer("No")
        		.clickNextButton(new HaveYouEverReceivedInjectionIntoYourKnee_OLS());
                
              
        //-----------HaveYouEverReceivedInjectionIntoYourKnee_OLS--------------------
        haveYouEverReceivedInjectionIntoYourKnee_OLS
        		.waitForPageLoad();
        HaveYouReceivedKneeInjection_OLS haveYouReceivedKneeInjection_OLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
        		.clickOnAnswer("Yes, a corticosteroid or \"steroid\" injection")
        		.clickOnAnswer("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
        		.clickNextButton(new HaveYouReceivedKneeInjection_OLS());        
                
                
        //-------------------------HaveYouReceivedKneeInjection_OLS---------------
        haveYouReceivedKneeInjection_OLS
				.waitForPageLoad();
        FollowingDevicesInYourBody followingDevicesInYourBody = haveYouReceivedKneeInjection_OLS
        		.clickOnAnswer("No")
        		.clickNextButton(new FollowingDevicesInYourBody());  

        
        //---------------------------FollowingDevicesInYourBody--------------------
        followingDevicesInYourBody
                .waitForPageLoad();
        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome  = followingDevicesInYourBody
                .clickOnAnswer("None of the above")
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());
        
        
        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad();
        AreYouCurrentlyReceivingWorkersPage_OLS areYouCurrentlyReceivingWorkersPage_OLS = diagnosedwithCarpalTunnelSyndrome
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPage_OLS());
        
        
        //------------------AreYouCurrentlyReceivingWorkersPage_OLS-------------
        areYouCurrentlyReceivingWorkersPage_OLS
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = areYouCurrentlyReceivingWorkersPage_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        


        //----------*******NEW GENERAL HEALTH Questions**************************----------
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
                .clickOnFacilityName(siteName_Synexus)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        aboutHealthPageOLS
        		.clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(2000);
        aboutHealthPageOLS
                .pidFromDbToLog(env)
                //.getRadiantDbToLog(env)
                .getAnomalyDbToLog(env);
    }
}
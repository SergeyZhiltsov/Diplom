package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID_OLS;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;
import com.acurian.selenium.pages.OLS.OA_3138.TreatedPainWithMarijuanaOrCannabis;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class OA_3138_OLS extends BaseTest {

    @Test(enabled = false)
    public void OA_3138_OLS_Script() {
        String phoneNumberDY = "AUTAMS1OA1";
        String zipCode = "99546";
        String studyName = "an osteoarthritis";
        String siteName = "AUT_OA_3138_Site";
        String protocol1 = "R475_PN_1523";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumberDY)
                .waitForPageLoad()
                .maximizePage();

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

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhereYouHaveArthritis_OLS whereYouHaveArthritisOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis")
                .clickNextButton(new WhereYouHaveArthritis_OLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS hasHealthcareProfessionalPageOLS = whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEqualsForQNumber("QS1304", protocol1);
        debugPageOLS.back();
        AnyMedicationForYourArthritis_OLS anyMedicationForYourArthritisOLS = whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickOnAnswer("Left Knee")
                .clickNextButton(new AnyMedicationForYourArthritis_OLS());

        
        NSAIDMedication_OLS nSAIDMedicationOLS = anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedication_OLS());

        CurrentlyTakinnFollowingNSAIDMedication_OLS currentlyTakinnFollowingNSAIDMedicationOLS = nSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new CurrentlyTakinnFollowingNSAIDMedication_OLS());

        HowManyTotalDaysYouTakeFollowingNSAID_OLS howManyTotalDaysYouTakeFollowingNSAIDOLS = currentlyTakinnFollowingNSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyTotalDaysYouTakeFollowingNSAID_OLS());

        TreatedYourArthritisPainAcetaminophen_OLS treatedYourArthritisPainAcetaminophenOLS = howManyTotalDaysYouTakeFollowingNSAIDOLS
                .waitForPageLoad()
                .clickOnAnswer("2 days")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophen_OLS());

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());

        HasYourDoctorEverPrescribedOpioidNarcotic_OLS hasYourDoctorEverPrescribedOpioidNarcotic_OLS = prescriptionPainMedicationsForArthritis
        //AreYouCurrentlyOnPage_OLS areYouCurrentlyOnPageOLS= prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_OLS());
        
        
        AreYouCurrentlyOnPage_OLS areYouCurrentlyOnPageOLS = hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPage_OLS());

        areYouCurrentlyOnPageOLS
                .waitForPageLoad();
        //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = areYouCurrentlyOnPageOLS
        TreatedPainWithMarijuanaOrCannabis treatedPainWithMarijuanaOrCannabis = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(new TreatedPainWithMarijuanaOrCannabis());
        treatedPainWithMarijuanaOrCannabis
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = treatedPainWithMarijuanaOrCannabis
                .clickOnAnswer("Yes")
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
        		.waitForPageLoad();
        		debugPageOLS.checkProtocolsEqualsForQNumber("QS1308", protocol1);
        		debugPageOLS.back();
        treatedPainWithMarijuanaOrCannabis
        		.waitForPageLoad();
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
        HaveYouReceivedKneeInjectionWithinPast3Months_OLS haveYouReceivedKneeInjection_WithinPast3Months_OLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
        		.clickOnAnswer("Yes, a corticosteroid or \"steroid\" injection")
        		.clickOnAnswer("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
        		.clickNextButton(new HaveYouReceivedKneeInjectionWithinPast3Months_OLS());
                
                
        //-------------------------HaveYouReceivedKneeInjectionWithinPast3Months_OLS---------------
        haveYouReceivedKneeInjection_WithinPast3Months_OLS
				.waitForPageLoad();
        FollowingDevicesInYourBody_OLS followingDevicesInYourBodyOLS = haveYouReceivedKneeInjection_WithinPast3Months_OLS
        		.clickOnAnswer("No")
        		.clickNextButton(new FollowingDevicesInYourBody_OLS());

        
        //---------------------------FollowingDevicesInYourBody_OLS--------------------
        followingDevicesInYourBodyOLS
                .waitForPageLoad();
        //ParticipatedInAnotherClinicalResearch participatedInAnotherClinicalResearch = followingDevicesInYourBodyOLS
        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome  = followingDevicesInYourBodyOLS
                .clickOnAnswer("None of the above")
                //.clickNextButton(new ParticipatedInAnotherClinicalResearch());
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());
        
        
        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad();
        AreYouCurrentlyReceivingWorkersPage_OLS areYouCurrentlyReceivingWorkersPage_OLS = diagnosedwithCarpalTunnelSyndrome
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPage_OLS());
        
        
        //------------------AreYouCurrentlyReceivingWorkersPage_OLS-------------
        areYouCurrentlyReceivingWorkersPage_OLS
                .waitForPageLoad()        
                .clickOnAnswer("Yes")
                .clickNextButton(new TreatedPainWithMarijuanaOrCannabis());
        
        
        //------------------TreatedPainWithMarijuanaOrCannabis-------------
        treatedPainWithMarijuanaOrCannabis
                .waitForPageLoad();
        FutureJointReplacementSurgery futureJointReplacementSurgery = treatedPainWithMarijuanaOrCannabis
                .clickOnAnswer("No")
                .clickNextButton(new FutureJointReplacementSurgery());
        
        
        //------------------FutureJointReplacementSurgery-------------
        futureJointReplacementSurgery
                .waitForPageLoad();
        ParticipatedInAnotherClinicalResearch participatedInAnotherClinicalResearch = futureJointReplacementSurgery
                .clickOnAnswer("Unsure")
                .clickNextButton(new ParticipatedInAnotherClinicalResearch());
        
        
        //------------------ParticipatedInAnotherClinicalResearch-------------
        participatedInAnotherClinicalResearch
                .waitForPageLoad()
        //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = participatedInAnotherClinicalResearch
                .clickOnAnswer("No")
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
//        	.clickNextButton(new ChildrenUnderPageOLS())
//		//----------ChildrenUnderTheAge Page--------------------
//        	.waitForPageLoad()
//        	.clickOnAnswer("Yes")
//        	.clickNextButton(new HouseholdHavePageOLS())
//        	.waitForPageLoad()
//        	.clickOnAnswers("None of the above")
//        	.clickNextButton(new TheStudySitePageOLS())
//        	.waitForPageLoad()
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//        	.clickOnAnswer("Public transportation")
//        	.clickNextButton(new WhatMedicalCoveragePageOLS())
//        	.waitForPageLoad()
//        	.clickOnAnswers("No, I have no coverage")
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
                .waitForSENRPageLoad();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        aboutHealthPageOLS
        		.clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(8000);
        aboutHealthPageOLS
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .getAnomalyDbToLog(env);
    }
}
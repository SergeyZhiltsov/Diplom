package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAIDOLS;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;
import com.acurian.selenium.pages.OLS.OA_3138.TreatedPainWithMarijuanaOrCannabis;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class OA_4827_OLS extends BaseTest {

    @Test(enabled = false)
    public void OA_4827_OLS_Script() {
        String phoneNumberOA = "AUTAMS1OA1";
        String zipCode = "19044";
        String studyName = "an osteoarthritis";
        String siteName = "AUT_OA_4827_Site";
        String protocol1 = "HP_5000_US_05";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
//        dateOfBirthPageOLS.openPage(env, phoneNumberOA)
//                .waitForPageLoad();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("10/10/1975")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritis());
        

        doYouSufferFromArthritis
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouSufferFromArthritis
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        		.waitForPageLoad();
        		DebugPageOLS debugPageOLS = new DebugPageOLS();
        		debugPageOLS
        		//.checkProtocolsContainsForQNumber("QS4502", protocol1)
        		.back();
        doYouSufferFromArthritis
        		.waitForPageLoad();
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        

        WhereYouHaveArthritisOLS whereYouHaveArthritisOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritisOLS());

        
		whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4504", protocol1);
        debugPageOLS.back();
        AnyMedicationForYourArthritisOLS anyMedicationForYourArthritisOLS = whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickOnAnswer("Left Knee")
                .clickNextButton(new AnyMedicationForYourArthritisOLS());

        
        NSAIDMedicationOLS nSAIDMedicationOLS = anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain")
                .clickOnAnswer("1 - 2 days per week or less")
                .clickOnAnswer("4 - 7 days per week")
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedicationOLS());
        

        nSAIDMedicationOLS
                .waitForPageLoad()
        //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = nSAIDMedicationOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        		.waitForPageLoad();
                debugPageOLS.checkProtocolsContainsForQNumber("QS4505", protocol1);
                debugPageOLS.back();
        nSAIDMedicationOLS
        		.waitForPageLoad();
        CurrentlyTakinnFollowingNSAIDMedicationOLS currentlyTakinnFollowingNSAIDMedicationOLS = nSAIDMedicationOLS
                .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new CurrentlyTakinnFollowingNSAIDMedicationOLS());
        

        HowManyTotalDaysYouTakeFollowingNSAIDOLS howManyTotalDaysYouTakeFollowingNSAIDOLS = currentlyTakinnFollowingNSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyTotalDaysYouTakeFollowingNSAIDOLS());
        

        howManyTotalDaysYouTakeFollowingNSAIDOLS
                .waitForPageLoad();
        TreatedYourArthritisPainAcetaminophenOLS treatedYourArthritisPainAcetaminophenOLS = howManyTotalDaysYouTakeFollowingNSAIDOLS
                .clickOnAnswer("1 day per week or less")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophenOLS());
        treatedYourArthritisPainAcetaminophenOLS
        		.waitForPageLoad();
                debugPageOLS.checkProtocolsContainsForQNumber("QS4508", protocol1);
                debugPageOLS.back();
        howManyTotalDaysYouTakeFollowingNSAIDOLS
        		.waitForPageLoad()
                .clickOnAnswer("2 days")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophenOLS());
        

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());
        

        HasYourDoctorEverPrescribedOpioidNarcoticOLS hasYourDoctorEverPrescribedOpioidNarcotic_OLS = prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcoticOLS());
        
        
        AreYouCurrentlyOnPageOLS areYouCurrentlyOnPageOLS = hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPageOLS());


        areYouCurrentlyOnPageOLS
                .waitForPageLoad();
        TreatedPainWithMarijuanaOrCannabis treatedPainWithMarijuanaOrCannabis = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(new TreatedPainWithMarijuanaOrCannabis());
        treatedPainWithMarijuanaOrCannabis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
        		.waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4513", protocol1);
        		debugPageOLS.back();
        treatedPainWithMarijuanaOrCannabis
        		.waitForPageLoad();
        		debugPageOLS.back();
        areYouCurrentlyOnPageOLS
                .waitForPageLoad();
        HaveYouEverHadKneeReplacementSurgeryOLS haveYouEverHadKneeReplacementSurgery_OLS = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgeryOLS());
        
        
        
        //-----------HaveYouEverHadKneeReplacementSurgeryOLS--------------------
        haveYouEverHadKneeReplacementSurgery_OLS
        		.waitForPageLoad();
        HaveYouEverReceivedInjectionIntoYourKneeOLS haveYouEverReceivedInjectionIntoYourKnee_OLS = haveYouEverHadKneeReplacementSurgery_OLS
        		.clickOnAnswer("Yes, both knees have been replaced")
        		.clickNextButton(new HaveYouEverReceivedInjectionIntoYourKneeOLS())
        		.waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4523", protocol1);
        		debugPageOLS.back();
         haveYouEverHadKneeReplacementSurgery_OLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, one knee has been replaced")
        		.clickOnAnswer("No")
        		.clickNextButton(new HaveYouEverReceivedInjectionIntoYourKneeOLS());
                
              
        //-----------HaveYouEverReceivedInjectionIntoYourKneeOLS--------------------
        haveYouEverReceivedInjectionIntoYourKnee_OLS
        		.waitForPageLoad();
        HaveYouReceivedKneeInjectionWithinPast3MonthsOLS haveYouReceivedKneeInjection_WithinPast3Months_OLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
        		.clickOnAnswer("Yes, a corticosteroid or \"steroid\" injection")
        		.clickOnAnswer("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
        		.clickNextButton(new HaveYouReceivedKneeInjectionWithinPast3MonthsOLS());
                
                
        //-------------------------HaveYouReceivedKneeInjectionWithinPast3MonthsOLS---------------
        haveYouReceivedKneeInjection_WithinPast3Months_OLS
				.waitForPageLoad();
        FollowingDevicesInYourBodyOLS followingDevicesInYourBodyOLS = haveYouReceivedKneeInjection_WithinPast3Months_OLS
        		.clickOnAnswer("Yes")        		
        		.clickNextButton(new FollowingDevicesInYourBodyOLS())
        		.waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4525", protocol1);
        		debugPageOLS.back();
        haveYouReceivedKneeInjection_WithinPast3Months_OLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")        		
        		.clickNextButton(new FollowingDevicesInYourBodyOLS());
        

        
        //---------------------------FollowingDevicesInYourBodyOLS--------------------
        followingDevicesInYourBodyOLS
                .waitForPageLoad();
        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome  = followingDevicesInYourBodyOLS
                .clickOnAnswer("None of the above")
                //.clickNextButton(new ParticipatedInAnotherClinicalResearch());
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());
        
        
        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad();
        WithinThePast6MonthsHaveYouHadNumbnessOLS withinThePast6MonthsHaveYouHadNumbness_OLS = diagnosedwithCarpalTunnelSyndrome
        		.clickOnAnswer("Yes")
        		.clickNextButton(new WithinThePast6MonthsHaveYouHadNumbnessOLS());
        withinThePast6MonthsHaveYouHadNumbness_OLS
        		.waitForPageLoad()
        		.back();
        diagnosedwithCarpalTunnelSyndrome
        		.waitForPageLoad();
        AreYouCurrentlyReceivingWorkersPageOLS areYouCurrentlyReceivingWorkersPage_OLS = diagnosedwithCarpalTunnelSyndrome
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageOLS());
        
        
        
        //------------------AreYouCurrentlyReceivingWorkersPageOLS-------------
        areYouCurrentlyReceivingWorkersPage_OLS
                .waitForPageLoad()        
                .clickOnAnswer("Yes")
                .clickNextButton(new TreatedPainWithMarijuanaOrCannabis())
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4526", protocol1);
        		debugPageOLS.back();
        areYouCurrentlyReceivingWorkersPage_OLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")        		
        		.clickNextButton(new TreatedPainWithMarijuanaOrCannabis());
        
        
        //----------------TreatedPainWithMarijuanaOrCannabis-----------------
        treatedPainWithMarijuanaOrCannabis
        		.waitForPageLoad();
        FutureJointReplacementSurgery futureJointReplacementSurgery = treatedPainWithMarijuanaOrCannabis
        		.clickOnAnswer("No")        		
        		.clickNextButton(new FutureJointReplacementSurgery());
        
        
                
        //--------------FutureJointReplacementSurgery---------------
        futureJointReplacementSurgery
        		.waitForPageLoad();
        ParticipatedInAnotherClinicalResearch participatedInAnotherClinicalResearch = futureJointReplacementSurgery
        		.clickOnAnswer("Yes, and I have a joint replacement surgery scheduled (with an appointment set for a specific date and time)")
        		.clickOnAnswer("Yes, my doctor has told me that I may need to consider joint replacement in the next 6 months to 1 year")
        		.clickOnAnswer("Yes, my doctor has told me that I might need to consider joint replacement at a later date")
        		.clickOnAnswer("Yes, my doctor and I have discussed it, but my doctor said I don't need joint replacement at this time")
        		.clickOnAnswer("No, my doctor and I have not discussed joint replacement")
        		.clickOnAnswer("Unsure")
        		.clickNextButton(new ParticipatedInAnotherClinicalResearch());
        
        //---------------participatedInAnotherClinicalResearch-----------
        participatedInAnotherClinicalResearch
        		.waitForPageLoad()
        		.clickOnAnswer("Yes") //----------If you select "NO" you get qualify for OA 3138.
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
       
        		
        		
        		
        //----------*************NEW GENERAL HEALTH Questions******************----------
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
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .pidFromDbToLog(env);
    }
}
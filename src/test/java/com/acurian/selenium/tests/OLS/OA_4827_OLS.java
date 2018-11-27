package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;
import com.acurian.selenium.pages.OLS.OA_3138.TreatedPainWithMarijuanaOrCannabis;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
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
        dateOfBirthPageOLS.openPage(env, phoneNumberOA)
                .waitForPageLoad();

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
        WhatKindOfArthritisPage whatKindOfArthritisPage = doYouSufferFromArthritis
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPage());
        

        WhereYouHaveArthritis whereYouHaveArthritis = whatKindOfArthritisPage
                .waitForPageLoad()
                .clickOnAnswer("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritis());

        
		whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4504", protocol1);
        debugPageOLS.back();
        AnyMedicationForYourArthritis anyMedicationForYourArthritis = whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickOnAnswer("Left Knee")
                .clickNextButton(new AnyMedicationForYourArthritis());

        
        NSAIDMedication nSAIDMedication = anyMedicationForYourArthritis
                .waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain")
                .clickOnAnswer("1 - 2 days per week or less")
                .clickOnAnswer("4 - 7 days per week")
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedication());
        

        nSAIDMedication
                .waitForPageLoad()
        //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = nSAIDMedication
                .clickOnAnswer("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        		.waitForPageLoad();
                debugPageOLS.checkProtocolsContainsForQNumber("QS4505", protocol1);
                debugPageOLS.back();
        nSAIDMedication
        		.waitForPageLoad();
        CurrentlyTakinnFollowingNSAIDMedication currentlyTakinnFollowingNSAIDMedication = nSAIDMedication
                .clickOnAnswer("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new CurrentlyTakinnFollowingNSAIDMedication());
        

        HowManyTotalDaysYouTakeFollowingNSAID howManyTotalDaysYouTakeFollowingNSAID = currentlyTakinnFollowingNSAIDMedication
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyTotalDaysYouTakeFollowingNSAID());
        

        howManyTotalDaysYouTakeFollowingNSAID
                .waitForPageLoad();
        TreatedYourArthritisPainAcetaminophen treatedYourArthritisPainAcetaminophen = howManyTotalDaysYouTakeFollowingNSAID
                .clickOnAnswer("1 day per week or less")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophen());
        treatedYourArthritisPainAcetaminophen
        		.waitForPageLoad();
                debugPageOLS.checkProtocolsContainsForQNumber("QS4508", protocol1);
                debugPageOLS.back();
        howManyTotalDaysYouTakeFollowingNSAID
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
        HaveYouEverHadKneeReplacementSurgery_OLS haveYouEverHadKneeReplacementSurgery_OLS = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgery_OLS());
        
        
        
        //-----------HaveYouEverHadKneeReplacementSurgery_OLS--------------------
        haveYouEverHadKneeReplacementSurgery_OLS
        		.waitForPageLoad();
        HaveYouEverReceivedInjectionIntoYourKnee_OLS haveYouEverReceivedInjectionIntoYourKnee_OLS = haveYouEverHadKneeReplacementSurgery_OLS
        		.clickOnAnswer("Yes, both knees have been replaced")
        		.clickNextButton(new HaveYouEverReceivedInjectionIntoYourKnee_OLS())
        		.waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4523", protocol1);
        		debugPageOLS.back();
         haveYouEverHadKneeReplacementSurgery_OLS
        		.waitForPageLoad()
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
        		.clickOnAnswer("Yes")        		
        		.clickNextButton(new FollowingDevicesInYourBody())
        		.waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4525", protocol1);
        		debugPageOLS.back();
        haveYouReceivedKneeInjection_OLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")        		
        		.clickNextButton(new FollowingDevicesInYourBody());
        

        
        //---------------------------FollowingDevicesInYourBody--------------------
        followingDevicesInYourBody
                .waitForPageLoad();
        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome  = followingDevicesInYourBody
                .clickOnAnswer("None of the above")
                //.clickNextButton(new ParticipatedInAnotherClinicalResearch());
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());
        
        
        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad();
        WithinThePast6MonthsHaveYouHadNumbness_OLS withinThePast6MonthsHaveYouHadNumbness_OLS = diagnosedwithCarpalTunnelSyndrome
        		.clickOnAnswer("Yes")
        		.clickNextButton(new WithinThePast6MonthsHaveYouHadNumbness_OLS());
        withinThePast6MonthsHaveYouHadNumbness_OLS
        		.waitForPageLoad()
        		.back();
        diagnosedwithCarpalTunnelSyndrome
        		.waitForPageLoad();
        AreYouCurrentlyReceivingWorkersPage_OLS areYouCurrentlyReceivingWorkersPage_OLS = diagnosedwithCarpalTunnelSyndrome
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPage_OLS());
        
        
        
        //------------------AreYouCurrentlyReceivingWorkersPage_OLS-------------
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
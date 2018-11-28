package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID_OLS;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class OA_4109_OLS extends BaseTest {

    @Test(enabled = true)
    public void OA_4109_OLS_Script() {
        String phoneNumber = "AUTAMS1OA1";
        String zipCode = "60540";
        String studyName = "an osteoarthritis";
        String siteName = "AUT_OA_4109_Site";
        String protocol1 = "R475_OA_1611";
        String protocol2 = "R475_OA_1688";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad()
                .maximizePage();

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

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhereYouHaveArthritis_OLS whereYouHaveArthritisOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritis_OLS());

        AnyMedicationForYourArthritis_OLS anyMedicationForYourArthritisOLS = whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Right Knee")
                .clickNextButton(new AnyMedicationForYourArthritis_OLS());

        NSAIDMedication_OLS nSAIDMedicationOLS = anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days per week or less")
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
                .clickOnAnswer("5 days")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophen_OLS());

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());
                

        HasYourDoctorEverPrescribedOpioidNarcotic_OLS hasYourDoctorEverPrescribedOpioidNarcotic_OLS = prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_OLS());
        
        
        AreYouCurrentlyOnPage_OLS areYouCurrentlyOnPageOLS = hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPage_OLS());


        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
        //TreatedPainWithMarijuanaOrCannabis treatedPainWithMarijuanaOrCannabis = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
        		.waitForPageLoad();
		DebugPageOLS debugPageOLS = new DebugPageOLS();
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
        HaveYouReceivedKneeInjectionWithinPast3Months_OLS haveYouReceivedKneeInjection_WithinPast3Months_OLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
        		.clickOnAnswer("Yes, a corticosteroid or \"steroid\" injection")
        		.clickOnAnswer("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
        		.clickNextButton(new HaveYouReceivedKneeInjectionWithinPast3Months_OLS());
                
                
        //-------------------------HaveYouReceivedKneeInjectionWithinPast3Months_OLS---------------
        haveYouReceivedKneeInjection_WithinPast3Months_OLS
				.waitForPageLoad();
        FollowingDevicesInYourBody_OLS followingDevicesInYourBodyOLS = haveYouReceivedKneeInjection_WithinPast3Months_OLS
        		.clickOnAnswer("Yes")
        		.clickOnAnswer("No")        		
        		.clickNextButton(new FollowingDevicesInYourBody_OLS());

        //-------------------------FollowingDevicesInYourBody_OLS---------------
        followingDevicesInYourBodyOLS
        		.waitForPageLoad()
                .clickOnAnswer("Aneurysm clip")
                .clickOnAnswer("Artificial heart valve")
                .clickOnAnswer("Cochlear implant")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS4514", protocol1);
        		debugPageOLS.back();
        followingDevicesInYourBodyOLS
                .waitForPageLoad();
        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome = followingDevicesInYourBodyOLS
                .clickOnAnswer("None of the above")
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());


        AreYouCurrentlyReceivingWorkersPage_OLS areYouCurrentlyReceivingWorkersPage_OLS = diagnosedwithCarpalTunnelSyndrome
        		.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPage_OLS());
        
        
        areYouCurrentlyReceivingWorkersPage_OLS
        		.waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = areYouCurrentlyReceivingWorkersPage_OLS
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
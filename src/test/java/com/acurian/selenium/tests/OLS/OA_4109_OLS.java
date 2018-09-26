package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class OA_4109_OLS extends BaseTest {

    @Test(enabled = true)
    public void oa_4109_OLS() {
        String phoneNumber = "AUTAMS1OA1";
        //	String env = "PRD";
        String zipCode = "99546";
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

        TreatedYourArthritisPainAcetaminophen treatedYourArthritisPainAcetaminophen = howManyTotalDaysYouTakeFollowingNSAID
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
//        .clickNextButton(new ChildrenUnderPageOLS())
//		//----------ChildrenUnderTheAge Page--------------------
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
//        .clickNextButton(new EthnicBackgroundPageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("Prefer not to answer")
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
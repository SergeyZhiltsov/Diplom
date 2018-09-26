package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;
import com.acurian.selenium.pages.OLS.OA_3138.TreatedPainWithMarijuanaOrCannabis;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class OA_3138_OLS extends BaseTest {

    @Test(enabled = true)
    public void OA_3138_OLS() {
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

        TreatedYourArthritisPainAcetaminophen treatedYourArthritisPainAcetaminophen = howManyTotalDaysYouTakeFollowingNSAID
                .waitForPageLoad()
                .clickOnAnswer("2 days")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophen());

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophen
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());

        TreatedPainWithMarijuanaOrCannabis treatedPainWithMarijuanaOrCannabis = prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("Tylenol #3 or Tylenol #4 (acetaminophen with codeine)")
                .clickNextButton(new TreatedPainWithMarijuanaOrCannabis());

        treatedPainWithMarijuanaOrCannabis
                .waitForPageLoad();
        AreYouCurrentlyOnPageOLS areYouCurrentlyOnPageOLS = treatedPainWithMarijuanaOrCannabis
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyOnPageOLS());


        areYouCurrentlyOnPageOLS
                .waitForPageLoad();
        FutureJointReplacementSurgery futureJointReplacementSurgery = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new FutureJointReplacementSurgery());


        futureJointReplacementSurgery
                .waitForPageLoad();
        FollowingDevicesInYourBody followingDevicesInYourBody = futureJointReplacementSurgery
                //ParticipatedInAnotherClinicalResearch participatedInAnotherClinicalResearch = futureJointReplacementSurgery
                .clickOnAnswer("Yes, my doctor and I have discussed it, but my doctor said I don't need joint replacement at this time")
                .clickNextButton(new FollowingDevicesInYourBody());

        followingDevicesInYourBody
                .waitForPageLoad();
        ParticipatedInAnotherClinicalResearch participatedInAnotherClinicalResearch = followingDevicesInYourBody
                .clickOnAnswer("None of the above")
                .clickNextButton(new ParticipatedInAnotherClinicalResearch());

        participatedInAnotherClinicalResearch
                .waitForPageLoad();
        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome = participatedInAnotherClinicalResearch
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());

        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedwithCarpalTunnelSyndrome
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
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                //.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
                .getAnomalyDbToLog(env);
    }
}
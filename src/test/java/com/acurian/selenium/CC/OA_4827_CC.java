package com.acurian.selenium.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.OA_3138.AreYouCurrentlyTakingCC;
import com.acurian.selenium.pages.CC.OA_3138.HowManyTotalDaysCC;
import com.acurian.selenium.pages.CC.OA_3138.MarijuanaOrCannabisCC;
import com.acurian.selenium.pages.CC.OA_3138.ParticipatedInAnotherClinicalStudyCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OA_4827_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void OA_4827_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1OA1";
        String zipCode = "19044";
        String studyName = "osteoarthritis";
        String studyIndication = "an osteoarthritis study";
        String siteName = "AUT_OA_4827_Site";
        String protocol1 = "HP_5000_US_05";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumberOA)
                .clickPopupPhoneNumber(phoneNumberOA)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Call Back")
                .clickNextButton(new DateOfBirthPageCC());


        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad("Osteoarthritis", "850")
                .setMonth("Sep")
                .setDay("9")
                .setYear("1975")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritisCC());

        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageCC());

        WhereYouHaveArthritisCC whereYouHaveArthritisCC = whatKindOfArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritisCC());

        AnyTypeOfMedicationForYourArthritisCC anyTypeOfMedicationForYourArthritisCC = whereYouHaveArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Left Knee")
                .clickNextButton(new AnyTypeOfMedicationForYourArthritisCC());

        NSAIDMedicationsForArthritisPainCC nSAIDMedicationsForArthritisPainCC = anyTypeOfMedicationForYourArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedicationsForArthritisPainCC());

        AreYouCurrentlyTakingCC areYouCurrentlyTakingCC = nSAIDMedicationsForArthritisPainCC
                .waitForPageLoad()
                .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new AreYouCurrentlyTakingCC());

        HowManyTotalDaysCC howManyTotalDaysCC = areYouCurrentlyTakingCC
                .waitForPageLoad()
                .clickOnAnswers("Yes")
                .clickNextButton(new HowManyTotalDaysCC());

        MedicationsContainingAcetaminophenCC medicationsContainingAcetaminophenCC = howManyTotalDaysCC
                .waitForPageLoad()
                .clickOnAnswers("5 days")
                .clickNextButton(new MedicationsContainingAcetaminophenCC());

        HaveYouEverTakenPrescriptionPainCC haveYouEverTakenPrescriptionPainCC = medicationsContainingAcetaminophenCC
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new HaveYouEverTakenPrescriptionPainCC());
                

        HasYourDoctorEverPrescribedOpioidNarcotic_CC hasYourDoctorEverPrescribedOpioidNarcotic_CC = haveYouEverTakenPrescriptionPainCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_CC());
        
        
        AreYouCurrentlyOnPageCC areYouCurrentlyOnPageCC = hasYourDoctorEverPrescribedOpioidNarcotic_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPageCC());


        areYouCurrentlyOnPageCC
                .waitForPageLoad();
        MarijuanaOrCannabisCC marijuanaOrCannabisCC = areYouCurrentlyOnPageCC
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
        		.clickNextButton(new MarijuanaOrCannabisCC())
        		.waitForPageLoad();
		DebugPageCC debugPageCC = new DebugPageCC();
        		debugPageCC.checkProtocolsContainsForQNumber("Q0005281-QS4513-STUDYQUES", protocol1);
        		debugPageCC.back();
        areYouCurrentlyOnPageCC
                .waitForPageLoad();
        HaveYouEverHadKneeReplacementSurgery_CC haveYouEverHadKneeReplacementSurgery_CC = areYouCurrentlyOnPageCC
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgery_CC());
        
        
        
        //-----------HaveYouEverHadKneeReplacementSurgery_CC--------------------
        haveYouEverHadKneeReplacementSurgery_CC
        		.waitForPageLoad();
        HaveYouEverReceivedInjectionIntoYourKnee_CC haveYouEverReceivedInjectionIntoYourKnee_CC = haveYouEverHadKneeReplacementSurgery_CC
        		.clickOnAnswer("Yes, both knees have been replaced")
        		.clickOnAnswer("Yes, one knee has been replaced")
        		.clickOnAnswer("No")
        		.clickNextButton(new HaveYouEverReceivedInjectionIntoYourKnee_CC());
                
              
        //-----------HaveYouEverReceivedInjectionIntoYourKnee_CC--------------------
        haveYouEverReceivedInjectionIntoYourKnee_CC
        		.waitForPageLoad();
        HaveYouReceivedKneeInjection_CC haveYouReceivedKneeInjection_CC = haveYouEverReceivedInjectionIntoYourKnee_CC
        		.clickOnAnswers("Yes, a corticosteroid or \"steroid\" injection")
        		.clickOnAnswers("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
        		.clickNextButton(new HaveYouReceivedKneeInjection_CC());        
                
                
        //-------------------------HaveYouReceivedKneeInjection_CC---------------
        haveYouReceivedKneeInjection_CC
				.waitForPageLoad();
        DevicesInYourBodyCC devicesInYourBodyCC = haveYouReceivedKneeInjection_CC
        		.clickOnAnswer("Yes")
        		.clickOnAnswer("No")        		
        		.clickNextButton(new DevicesInYourBodyCC());

        //-------------------------FollowingDevicesInYourBody---------------
        devicesInYourBodyCC
        		.waitForPageLoad();
        CarpalTunnelSyndromeCC carpalTunnelSyndromeCC = devicesInYourBodyCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new CarpalTunnelSyndromeCC());
        

        carpalTunnelSyndromeCC
                .waitForPageLoad();
        AreYouCurrentlyReceivingWorkersPageCC areYouCurrentlyReceivingWorkersPageCC = carpalTunnelSyndromeCC
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageCC());
        
  
        areYouCurrentlyReceivingWorkersPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new MarijuanaOrCannabisCC());
        
        
        marijuanaOrCannabisCC
				.waitForPageLoad();
        JointReplacementCC jointReplacementCC = marijuanaOrCannabisCC
        		.clickOnAnswers("No")
        		.clickNextButton(new JointReplacementCC());        


        ParticipatedInAnotherClinicalStudyCC participatedInAnotherClinicalStudyCC = jointReplacementCC
                .waitForPageLoad()
                .clickOnAnswers("Yes, my doctor and I have discussed it, but my doctor said I don't need joint replacement at this time")
                .clickNextButton(new ParticipatedInAnotherClinicalStudyCC());

        TransitionStatementCC transitionStatementCC = participatedInAnotherClinicalStudyCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad("osteoarthritis")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        
        
        //-------------------New GENERAL HEALTH---------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                //----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                //----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
                //----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                //----------SITE Selection Page--------------------
                .waitForPageLoad(studyIndication)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.PregnancyAndFertilityCC;
import com.acurian.selenium.pages.CC.DYS_4356C.ThankYouForAnsweringCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.OA_3138.AreYouCurrentlyTakingCC;
import com.acurian.selenium.pages.CC.OA_3138.HowManyTotalDaysCC;
import com.acurian.selenium.pages.CC.OA_3138.MarijuanaOrCannabisCC;
import com.acurian.selenium.pages.CC.OA_3138.ParticipatedInAnotherClinicalStudyCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer4;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.generalHealth.FollowingDigestiveConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingNeurologicalConditions;
import com.acurian.selenium.pages.CC.generalHealth.FollowingSkinConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingViralConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingWomensHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouUndergoneAnyPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartFailureIsAlsoPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HistoryOfDrugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.OtherThanSkinCancerPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SleepRelatedConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.shared.AnyTypeOfMedicationForYourArthritisCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.CarpalTunnelSyndromeCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DevicesInYourBodyCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromArthritisCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HaveYouEverTakenPrescriptionPainCC;
import com.acurian.selenium.pages.CC.shared.JointReplacementCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.LongTermSteroidPrescriptionCC;
import com.acurian.selenium.pages.CC.shared.MedicationsContainingAcetaminophenCC;
import com.acurian.selenium.pages.CC.shared.NSAIDMedicationsForArthritisPainCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.WhereYouHaveArthritisCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.utils.DataProviderPool;

public class OA_3138_CC extends BaseTest{
	
	@Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void tc001Test(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1OA1";
        List<String> protocols = Arrays.asList("R475_PN_1523");
        String protocol1 = "R475_PN_1523";        
        String studyName = "osteoarthritis";
        String studyName1 = "an arthritis study";
    //    String env = "PRD";
        String siteName = "AUT_OA_3138_Site";
        String zipCode  = "99546";
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
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
        .clickOnAnswer("Learn more about matching to clinical trials")
        .clickNextButton(new DateOfBirthPageCC());
       
       dateOfBirthPageCC
       .waitForPageLoad();

       Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
      // Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedOA, "Title is diff");

       ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
               .setMonth("Sep")
               .setDay("9")
               .setYear("1980")
               .clickNextButton(new ZipCodePageCC());
       
       GenderPageCC genderPageCC = zipCodePageCC
    		   .waitForPageLoad()
    		   .typeZipCode("99546")
    		   .clickNextButton(new GenderPageCC());
       
       DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new DoYouSufferFromArthritisCC());
       
       WhatKindOfArthritisCC whatKindOfArthritisCC = doYouSufferFromArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new WhatKindOfArthritisCC());
       
       WhereYouHaveArthritisCC whereYouHaveArthritisCC = whatKindOfArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
    		   .clickNextButton(new WhereYouHaveArthritisCC());
       
       TransitionStatementCC transitionStatementCC = whereYouHaveArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Wrists or ankles")
    		   .clickNextButton(new TransitionStatementCC());
       
       DebugPageCC debugPageCC = new DebugPageCC();
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "R475_PN_1523", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       
       transitionStatementCC.back();
       
       AnyTypeOfMedicationForYourArthritisCC anyTypeOfMedicationForYourArthritisCC =  whereYouHaveArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Wrists or ankles")
    		   .clickOnAnswers("Left Hip")
    		   .clickNextButton(new AnyTypeOfMedicationForYourArthritisCC());
       
      /* anyTypeOfMedicationForYourArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("1 - 2 days per week or less")
    		   .clickNextButton(new TransitionStatementCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "R475_PN_1523", "Protocol not displayed");
       debugPageCC.closeDebugWindow();       
       transitionStatementCC.back();*/
       
       NSAIDMedicationsForArthritisPainCC nSAIDMedicationsForArthritisPainCC = anyTypeOfMedicationForYourArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("3 days per week")
    		   .clickNextButton(new NSAIDMedicationsForArthritisPainCC());
       
       nSAIDMedicationsForArthritisPainCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new TransitionStatementCC());       
       
       debugPageCC.checkProtocolsEquals("The following medications are called NSAIDs. They may be available over-the-counter or with a prescr...", protocol1);
       debugPageCC.back();
       
       AreYouCurrentlyTakingCC areYouCurrentlyTakingCC = nSAIDMedicationsForArthritisPainCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
    		   .clickNextButton(new AreYouCurrentlyTakingCC());
       
       HowManyTotalDaysCC howManyTotalDaysCC= areYouCurrentlyTakingCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Yes")
    		   .clickNextButton(new HowManyTotalDaysCC());
       
       MedicationsContainingAcetaminophenCC medicationsContainingAcetaminophenCC = howManyTotalDaysCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("2 days")
    		   .clickNextButton(new MedicationsContainingAcetaminophenCC());
       
       HaveYouEverTakenPrescriptionPainCC haveYouEverTakenPrescriptionPainCC = medicationsContainingAcetaminophenCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No, I have never taken a medication containing acetaminophen for my arthritis pain")
    		   .clickNextButton(new HaveYouEverTakenPrescriptionPainCC());       
       
       haveYouEverTakenPrescriptionPainCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Codeine")
    		   .clickNextButton(new TransitionStatementCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "R475_PN_1523", "Protocol not displayed");
       debugPageCC.closeDebugWindow();       
       transitionStatementCC.back();
       haveYouEverTakenPrescriptionPainCC.back();
       
       
       HaveYouEverTakenPrescriptionPainCC haveYouEverTakenPrescriptionPainCC1 = medicationsContainingAcetaminophenCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes, I have taken a medication containing acetaminophen for my arthritis pain")
    		   .clickNextButton(new HaveYouEverTakenPrescriptionPainCC());    		   
       
       MarijuanaOrCannabisCC marijuanaOrCannabisCC = haveYouEverTakenPrescriptionPainCC1
    		   .waitForPageLoad()
    		   .clickOnAnswers("Codeine")
    		   .clickOnAnswers("Tylenol #3 or Tylenol #4 (acetaminophen with codeine)")
    		   .clickNextButton(new MarijuanaOrCannabisCC());
       
       LongTermSteroidPrescriptionCC longTermSteroidPrescriptionCC = marijuanaOrCannabisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("No")
    		   .clickNextButton(new LongTermSteroidPrescriptionCC());
       
       JointReplacementCC jointReplacementCC = longTermSteroidPrescriptionCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Unsure")
    		   .clickNextButton(new JointReplacementCC());
       
       DevicesInYourBodyCC devicesInYourBodyCC = jointReplacementCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Yes, my doctor and I have discussed it, but my doctor said I don't need joint replacement at this time")
    		   .clickNextButton(new DevicesInYourBodyCC());
       
       ParticipatedInAnotherClinicalStudyCC participatedInAnotherClinicalStudyCC = devicesInYourBodyCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Unsure")
    		   .clickNextButton(new ParticipatedInAnotherClinicalStudyCC());
       
       CarpalTunnelSyndromeCC carpalTunnelSyndromeCC =  participatedInAnotherClinicalStudyCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new CarpalTunnelSyndromeCC());
       
       TransitionStatementCC transitionStatementCC1 = carpalTunnelSyndromeCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new TransitionStatementCC());
       
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =  transitionStatementCC1
    		   .waitForPageLoad(studyName)
    		   .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC()); 
       
       
       //-------------------New GENERAL HEALTH---------------------------
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
       		.waitForPageLoad()
       		.clickOnAnswers("None of the above")                	
       		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
       		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
       		.waitForPageLoad()
       		.clickOnAnswers("None of the above")
    		.clickNextButton(new HormonalBirthControlCC())
    		//----------------HormonalBirthControlCC----------------------
    		.waitForPageLoad()
       		.clickOnAnswer("No")
               .clickNextButton(new ApproximateHeightPageCC())
       		//----------Height and Weight Question Page--------------------
               .waitForPageLoad()
               .setAll("5", "5", "160")
               .clickNextButton(new LetMeSeePageCC())
       		//----------ChildrenUnderTheAge Page--------------------
               .waitForPageLoad()
               .clickNextButton(new ChildrenUnderPageCC())
               .waitForPageLoad()
               .clickOnAnswer("Yes")
               //----------PEDIATRIC HEALTH Questions----------
               .clickNextButton(new HouseholdHavePageCC())
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
       		//----------PII (IdentificationPageOLS) Page--------------------
               .clickNextButton(new IdentificationPageCC())
               .waitForPageLoad()
               .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
               .clickNextButton(new SiteSelectionPageCC())
               .waitForPageLoad(studyName1)
               .getPID()
               .clickOnAnswer(siteName)
               .clickNextButton(new SynexusRadiantDirectScheduleCC())
               .waitForPageLoadSyn()
               .clickOnAnswer("[Successful direct schedule in clinical conductor]")
               .clickNextButton(selectActionPageCC)
               .waitForPageLoad()
               .pidFromDbToLog(env);
       		   //.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
               //.getAnomalyDbToLog(env); //Not applicable for Call center
	}
}
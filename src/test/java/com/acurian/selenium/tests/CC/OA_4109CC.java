package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.OA_3138.AreYouCurrentlyTakingCC;
import com.acurian.selenium.pages.CC.OA_3138.HowManyTotalDaysCC;
import com.acurian.selenium.pages.CC.OA_3138.MarijuanaOrCannabisCC;
import com.acurian.selenium.pages.CC.OA_3138.ParticipatedInAnotherClinicalStudyCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer4;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.generalHealth.FollowingDigestiveConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingNeurologicalConditions;
import com.acurian.selenium.pages.CC.generalHealth.FollowingSkinConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingViralConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingWomensHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
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
import com.acurian.selenium.utils.DataProviderPool;

public class OA_4109CC extends BaseTest{
	
	@Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void tc001Test(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1OA1";
        List<String> protocols = Arrays.asList("R475_OA_1611","R475_OA_1688");
        String protocol1 = "R475_OA_1611";
        String protocol2 = "R475_OA_1688";
        String studyName = "osteoarthritis";
        String studyName1 = "arthritis";
    //    String env = "STG";
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
                .waitForPageLoad();
       Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
       DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
        .clickOnAnswer("Call Back")
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
       
       HowManyTotalDaysCC howManyTotalDaysCC= areYouCurrentlyTakingCC
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
       
       
       LongTermSteroidPrescriptionCC longTermSteroidPrescriptionCC = haveYouEverTakenPrescriptionPainCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Tylenol #3 or Tylenol #4 (acetaminophen with codeine)")
    		   .clickNextButton(new LongTermSteroidPrescriptionCC());
       
       DevicesInYourBodyCC devicesInYourBodyCC = longTermSteroidPrescriptionCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("No")
    		   .clickNextButton(new DevicesInYourBodyCC());
       
       CarpalTunnelSyndromeCC carpalTunnelSyndromeCC = devicesInYourBodyCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Unsure")
    		   .clickNextButton(new CarpalTunnelSyndromeCC());
       
       MarijuanaOrCannabisCC marijuanaOrCannabisCC = carpalTunnelSyndromeCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new MarijuanaOrCannabisCC());
       
       JointReplacementCC jointReplacementCC = marijuanaOrCannabisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("No")
    		   .clickNextButton(new JointReplacementCC());
       
       ParticipatedInAnotherClinicalStudyCC participatedInAnotherClinicalStudyCC = jointReplacementCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Yes, my doctor and I have discussed it, but my doctor said I don't need joint replacement at this time")
    		   .clickNextButton(new ParticipatedInAnotherClinicalStudyCC());
       
       TransitionStatementCC transitionStatementCC = participatedInAnotherClinicalStudyCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new TransitionStatementCC());       
       
       HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC =  transitionStatementCC
    		   .waitForPageLoad(studyName)
    		   .clickNextButton(new HasHealthcareProfessionalPageCC());       
       
       
       hasHealthcareProfessionalPageCC
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new HaveYouUndergoneAnyPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")        
       .clickNextButton(new HeartFailureIsAlsoPageCC())
       .waitForPageLoad()
       .clickOnAnswer("No")
       .clickNextButton(new AffectingYourMetabolismPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new FollowingNeurologicalConditions())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new AffectYourLungsPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new FollowingDigestiveConditionsPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new BoneOrJointConditionsPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new SleepRelatedConditionsPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new FollowingSkinConditionsPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new FollowingViralConditionsPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new FollowingMentalHealthPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new FollowingWomensHealthPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new OtherThanSkinCancerPageCC())
       .waitForPageLoad()
       .clickOnAnswer("No")
       .clickNextButton(new SmokedCigarettesPageCC())
       .waitForPageLoad()
       .clickOnAnswer("No, I never smoked")
       .clickNextButton(new HistoryOfDrugPageCC())
       .waitForPageLoad()
       .clickOnAnswer("No")
       .clickNextButton(new ApproximateHeightPageCC())
       .waitForPageLoad()
       .setAll("5", "5", "160")
       .clickNextButton(new LetMeSeePageCC())
       .waitForPageLoad()
       .clickNextButton(new ChildrenUnderPageCC())
       .waitForPageLoad()
       .clickOnAnswer("No")
       .clickNextButton(new TheStudySitePageCC())
       .waitForPageLoad()
       .clickOnAnswers("Other")
       .clickNextButton(new WhatSortPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above (no coverage at all)")
       .clickNextButton(new EthnicBackgroundPageCC())
       .waitForPageLoad()
       .clickOnAnswers("Other")
       .clickNextButton(new IdentificationPageCC())
       .waitForPageLoad()
       .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
       .clickNextButton(new SiteSelectionPageCC())
       .waitForPageLoad(studyName1)
       .getPID()
       .clickOnAnswer(siteName)
       .clickNextButton(new RadiantWarmTransferClose1PageCC())
       .waitForPageLoad()
       .clickOnAnswer("[direct schedule in clinical conductor]")
       .clickNextButton(new RadiantWarmTransfer4())
       .waitForPageLoad()
       .clickOnAnswer("Transferred for Scheduling")
       .clickNextButton(selectActionPageCC)
       .waitForPageLoad();       
       
       
	}

}

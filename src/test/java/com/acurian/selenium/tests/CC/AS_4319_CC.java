package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import com.acurian.selenium.pages.CC.pediatric.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.AS_4319.FollowingSymptomsMoreThanOnceAWeekCC;
import com.acurian.selenium.pages.CC.AS_4319.PermanentlyWheelchairBoundCC;
import com.acurian.selenium.pages.CC.AS_4319.ResultsOfYouXrayOrMRICC;
import com.acurian.selenium.pages.CC.AS_4319.SignsOfAnkylosingSpondylitisCC;
import com.acurian.selenium.pages.CC.AS_4319.YouBeenDiagnosedWithCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
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
import com.acurian.selenium.pages.CC.shared.BiologicMedicationsCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DevicesInYourBodyCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromLbpPageCC;
import com.acurian.selenium.pages.CC.shared.EverTakenXeljanzCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HowLongHaveLbpPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class AS_4319_CC extends BaseTest{
	
	@Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void AS_4319_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1AS1";
        List<String> protocols = Arrays.asList("M16_098");
        String protocol1 = "M16_098";        
        String studyName = "ankylosing spondylitis or AS";
        String studyName1 = "an ankylosing spondylitis (AS) study";
    //    String env = "STG";
        String siteName = "AUT_AS_4319";
        String site_indication = "Ankylosing Spondylitis";
        String zipCode  = "19044";
        
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
    		   .typeZipCode("19044")
    		   .clickNextButton(new GenderPageCC());
       
       YouBeenDiagnosedWithCC youBeenDiagnosedWithCC = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new YouBeenDiagnosedWithCC());
       
       NonQRtransitionPageCC nonQRtransitionPageCC = youBeenDiagnosedWithCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new NonQRtransitionPageCC());
       
       DebugPageCC debugPageCC = new DebugPageCC();
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), protocol1, "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       
       nonQRtransitionPageCC.back();
       DoYouSufferFromLbpPageCC doYouSufferFromLbpPageCC = youBeenDiagnosedWithCC
    		   .waitForPageLoad()
               .clickOnAnswers("Ankylosing spondylitis (AS)")
               .clickNextButton(new DoYouSufferFromLbpPageCC());
       
       NonQRtransitionPageCC nonQRtransitionPageCC1 = doYouSufferFromLbpPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new NonQRtransitionPageCC());       
      
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "M16_098", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       nonQRtransitionPageCC1.back();
       
       HowLongHaveLbpPageCC howLongHaveLbpPageCC = doYouSufferFromLbpPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new HowLongHaveLbpPageCC());
       
       SignsOfAnkylosingSpondylitisCC signsOfAnkylosingSpondylitisCC = howLongHaveLbpPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Less than 3 months")
    		   .clickNextButton(new SignsOfAnkylosingSpondylitisCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "M16_098", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       
       signsOfAnkylosingSpondylitisCC.back();
       howLongHaveLbpPageCC
	           .waitForPageLoad()
	           .clickOnAnswer("More than 1 year")
	           .clickNextButton(new SignsOfAnkylosingSpondylitisCC());
       
       FollowingSymptomsMoreThanOnceAWeekCC followingSymptomsMoreThanOnceAWeekCC =signsOfAnkylosingSpondylitisCC
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new FollowingSymptomsMoreThanOnceAWeekCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "M16_098", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       followingSymptomsMoreThanOnceAWeekCC.back();
       ResultsOfYouXrayOrMRICC resultsOfYouXrayOrMRICC = signsOfAnkylosingSpondylitisCC
               .waitForPageLoad()
               .clickOnAnswer("Yes")
               .clickNextButton(new ResultsOfYouXrayOrMRICC());
       
       FollowingSymptomsMoreThanOnceAWeekCC followingSymptomsMoreThanOnceAWeekCC1 = resultsOfYouXrayOrMRICC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Unsure")
    		   .clickNextButton(new FollowingSymptomsMoreThanOnceAWeekCC());
       
       BiologicMedicationsCC biologicMedicationsCC = followingSymptomsMoreThanOnceAWeekCC1
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new BiologicMedicationsCC());
       
       EverTakenXeljanzCC everTakenXeljanzCC = biologicMedicationsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Tysabri (Agent Note: tie-SAB-ree)")
    		   .clickNextButton(new EverTakenXeljanzCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "M16_098", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       everTakenXeljanzCC.back();
       
       EverTakenXeljanzCC everTakenXeljanzCC1 = biologicMedicationsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new EverTakenXeljanzCC());
       
       PermanentlyWheelchairBoundCC permanentlyWheelchairBoundCC = everTakenXeljanzCC1
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes, I am currently taking it")
    		   .clickNextButton(new PermanentlyWheelchairBoundCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "M16_098", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       permanentlyWheelchairBoundCC.back();
       
       PermanentlyWheelchairBoundCC permanentlyWheelchairBoundCC1 = everTakenXeljanzCC1
    		   .waitForPageLoad()
    		   .clickOnAnswer("No, I have never taken it")
    		   .clickNextButton(new PermanentlyWheelchairBoundCC());
       
       DevicesInYourBodyCC devicesInYourBodyCC = permanentlyWheelchairBoundCC1
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new DevicesInYourBodyCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "M16_098", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       devicesInYourBodyCC.back();
       
       DevicesInYourBodyCC devicesInYourBodyCC1 = permanentlyWheelchairBoundCC1
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new DevicesInYourBodyCC());
       
       TransitionStatementCC transitionStatementCC = devicesInYourBodyCC1
    		   .waitForPageLoad()
    		   .clickOnAnswers("A pacemaker")
    		   .clickNextButton(new TransitionStatementCC());
       
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "M16_098", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       transitionStatementCC.back();
       
       TransitionStatementCC transitionStatementCC1 = devicesInYourBodyCC1
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new TransitionStatementCC());
       
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =  transitionStatementCC1
    		   .waitForPageLoadWithCurves1(studyName)    		   
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
    		.waitForPageLoad()
       		.clickOnAnswer("No")
            .clickNextButton(new ApproximateHeightPageCC())
       		//----------Height and Weight Question Page--------------------
               .waitForPageLoad()
               .setAll("5", "5", "160")
               .clickNextButton(new LetMeSeePageCC())
               .waitForPageLoad()
               .clickNextButton(new ChildrenUnderPageCC())
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new TheStudySitePageCC())
               //----------PEDIATRIC HEALTH Questions----------
               //.clickNextButton(new HouseholdHavePageCC())
               //.waitForPageLoad()
               //.clickOnAnswers("None of the above")
               //.clickNextButton(new TheStudySitePageCC())
               //.waitForPageLoad()
               //.clickOnAnswers("Public transportation")
               //.clickNextButton(new WhatMedicalCoveragePageCC())
               //.waitForPageLoad()
               //.clickOnAnswers("No, I have no coverage")
               //.clickNextButton(new EthnicBackgroundPageCC())
               //.waitForPageLoad()
               //.clickOnAnswers("Prefer not to answer")
        //----------Resume GENERAL HEALTH Questions----------
               .clickNextButton(new IdentificationPageCC())
               .waitForPageLoad()
               .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
               .clickNextButton(new SiteSelectionPageCC())
               .waitForPageLoad(studyName1)
               .getPID()
               .clickOnAnswer(siteName)
               .clickNextButton(new HSGeneralCC())
               .waitForPageLoad(site_indication)
               .clickNextButton(new DoctorInformationCollectionPageCC())
               .waitForPageLoad()
               .clickNextButton(new HSMedicalRecordsPageCC())
               .waitForPageLoad()
               .clickNextButton(new ThankYouCloseSimplePageCC())
               .waitForPageLoad()
               .clickNextButton(selectActionPageCC)
               .waitForPageLoad()
               .pidFromDbToLog(env);
       
       
   /*//----------------------OLD General health ------------------
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
       //----------PEDIATRIC HEALTH Questions----------
       //.clickNextButton(new HouseholdHavePageCC())
       //.waitForPageLoad()
       //.clickOnAnswers("None of the above")
       //.clickNextButton(new TheStudySitePageCC())
       //.waitForPageLoad()
       //.clickOnAnswers("Public transportation")
       //.clickNextButton(new WhatMedicalCoveragePageCC())
       //.waitForPageLoad()
       //.clickOnAnswers("No, I have no coverage")
       //.clickNextButton(new EthnicBackgroundPageCC())
       //.waitForPageLoad()
       //.clickOnAnswers("Prefer not to answer")
//----------Resume GENERAL HEALTH Questions----------
       .clickNextButton(new IdentificationPageCC())
       .waitForPageLoad()
       .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
       .clickNextButton(new SiteSelectionPageCC())
       .waitForPageLoad(studyName1)
       .getPID()
       .selectAnswer(siteName)
       .clickNextButton(new RadiantWarmTransferClose1PageCC())
       .waitForPageLoad()
       .clickOnAnswer("[direct schedule in clinical conductor]")
       .clickNextButton(new RadiantWarmTransfer4())
       .waitForPageLoad()
       .clickOnAnswer("Transferred for Scheduling")
       .clickNextButton(selectActionPageCC)
       .waitForPageLoad()
       .pidFromDbToLog(env);*/      
	}
}
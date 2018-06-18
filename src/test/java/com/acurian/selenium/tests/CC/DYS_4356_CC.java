package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.AreYouTakingAnyOfMedicationsCC;
import com.acurian.selenium.pages.CC.DYS_4356C.NonPrescriptionSupplementsCC;
import com.acurian.selenium.pages.CC.DYS_4356C.PregnancyAndFertilityCC;
import com.acurian.selenium.pages.CC.DYS_4356C.ThankYouForAnsweringCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer1;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer2;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer3;
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
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingDigestiveConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingNeurologicalConditions;
import com.acurian.selenium.pages.CC.generalHealth.FollowingSkinConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingViralConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingWomensHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouUndergoneAnyPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartFailureIsAlsoPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HistoryOfDrugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.OtherThanSkinCancerPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SleepRelatedConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HasAHealthcareProfessionalDYS4356;
import com.acurian.selenium.pages.CC.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.StatinMedicationsCC;
import com.acurian.selenium.utils.DataProviderPool;

public class DYS_4356_CC extends BaseTest{
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void dYSLI_4356_CC(final String username, final String password) {
        String phoneNumberDYS = "AUTAMS1DYS";
        List<String> protocols = Arrays.asList("20150230","VK2809-201");
        String protocol1 = "VK2809-201";
        String protocol2 = "20150230";
        String studyName = "Dyslipidemia";
     //   String env = "STG";
        String siteName = "(QSC9004_4356C_AUT_DYSL)";
        String zipCode  = "19044";
        String studyName1 = "a cholesterol or heart health study";
        
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
                .typePhoneNumber(phoneNumberDYS)
                .clickPopupPhoneNumber(phoneNumberDYS)
                .clickBeginButton();
        
        callCenterIntroductionPageCC
        .waitForPageLoad()
        .activateDebugOnProd(env);
       Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
       DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
        .clickOnAnswer("Learn more about matching to clinical trials")
        .clickNextButton(new DateOfBirthPageCC());
       
       dateOfBirthPageCC
       .waitForPageLoad();

       Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
       Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedDYS, "Title is diff");

       IdentificationPageCC identificationPageCC = dateOfBirthPageCC
               .setMonth("Sep")
               .setDay("9")
               .setYear("1980")
               .clickNextButton(new IdentificationPageCC());
       
       GenderPageCC genderPageCC = identificationPageCC
    		   .waitForPageLoad1()
    		   .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
    		   .clickNextButton(new GenderPageCC());
       
       HasAHealthcareProfessionalDYS4356  hasAHealthcareProfessionalDYS4356 = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new HasAHealthcareProfessionalDYS4356());
       
       StatinMedicationsCC statinMedicationsCC =  hasAHealthcareProfessionalDYS4356
    		   .waitForPageLoad()
    		   .clickOnAnswers("High fats or lipids, or hyperlipidemia")
    		   .clickNextButton(new StatinMedicationsCC());
       
       AreYouTakingAnyOfMedicationsCC areYouTakingAnyOfMedicationsCC = statinMedicationsCC       
               .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new AreYouTakingAnyOfMedicationsCC());      
      
       NonPrescriptionSupplementsCC nonPrescriptionSupplementsCC = areYouTakingAnyOfMedicationsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new NonPrescriptionSupplementsCC());
       
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = nonPrescriptionSupplementsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
       DebugPageCC debugPageCC = new DebugPageCC();
       debugPageCC.openDebugWindow();
       Assert.assertEquals(debugPageCC.getProtocol(), "20150230\n" + "VK2809_201", "Protocol not displayed");
       debugPageCC.closeDebugWindow();
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC.back();
       nonPrescriptionSupplementsCC.back();
       
       areYouTakingAnyOfMedicationsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Praluent (alirocumab)")
    		   .clickNextButton(nonPrescriptionSupplementsCC);
       
       nonPrescriptionSupplementsCC
    		   .waitForPageLoad();
    		   HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = nonPrescriptionSupplementsCC
    		   .clickOnAnswers("Psyllium")
    		   .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());    
      
       haveYouEverExperiencedHeartRelatedMedicalCondCC
       		.waitForPageLoad();
       		HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC haveYouEverBeenDiagnosedAdditionalHeartRelatedCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
	   		.clickOnAnswers("None of the above")
	   		.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       		
       haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
       		.waitForPageLoad();
       		HaveYouUndergoneAnyPageCC haveYouUndergoneAnyPageCC = haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
	   		.clickOnAnswers("None of the above")
	   		.clickNextButton(new HaveYouUndergoneAnyPageCC());
       		
       haveYouUndergoneAnyPageCC
  			.waitForPageLoad();
       		PregnancyAndFertilityCC pregnancyAndFertilityCC = haveYouUndergoneAnyPageCC
	   		.clickOnAnswers("None of the above")
	   		.clickNextButton(new PregnancyAndFertilityCC());
       		
       pregnancyAndFertilityCC
       		.waitForPageLoad()
	   		.clickOnAnswer("None of the above")
	   		.clickNextButton(new ThankYouForAnsweringCC());
       		debugPageCC.openDebugWindow();
       		Assert.assertEquals(debugPageCC.getProtocol(), "VK2809_201", "Clinical trials often have requirements related to pregnancy and fertility. Please select the option...");
       		debugPageCC.closeDebugWindow()
       		.back();
            pregnancyAndFertilityCC
       		.waitForPageLoad()
	   		.clickOnAnswer("I currently have my \"tubes tied\" (also called bilateral tubal ligation, a sterilization procedure)")
	   		.clickNextButton(new ThankYouForAnsweringCC())
            
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
               .clickNextButton(new IdentificationPageCC())
               .waitForPageLoad()       
               .clickNextButton(new SiteSelectionPageCC())
               .waitForPageLoad(studyName1)
               .getPID()
               .selectAnswer(siteName)
               .clickNextButton(new RadiantWarmTransferClose1PageCC())
               .waitForPageLoad()
               .clickOnAnswer("[direct schedule in clinical conductor]")
               .clickNextButton(new SynexusRadiantDirectScheduleCC())
               .waitForPageLoad()
               .clickNextButton(new RadiantWarmTransfer4())
               .waitForPageLoad()
               .clickOnAnswer("Transferred for Scheduling")
               .clickNextButton(selectActionPageCC)
               .waitForPageLoad()
               .pidFromDbToLog(env)
               .getRadiantDbToLog(env);
               //.getAnomalyDbToLog(env);
       
       
    /*//----------------------OLD General Health--------------------
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new HaveYouUndergoneAnyPageCC())
       .waitForPageLoad()
       .clickOnAnswers("None of the above")
       .clickNextButton(new PregnancyAndFertilityCC())
       .waitForPageLoad()
       .clickOnAnswer("I currently have my \"tubes tied\" (also called bilateral tubal ligation, a sterilization procedure)")
       .clickNextButton(new ThankYouForAnsweringCC())
       .waitForPageLoad()
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
       .clickNextButton(new IdentificationPageCC())
       .waitForPageLoad()       
       .clickNextButton(new SiteSelectionPageCC())
       .waitForPageLoad(studyName1)
       .getPID()
       .selectAnswer(siteName)
       .clickNextButton(new RadiantWarmTransferClose1PageCC())
       .waitForPageLoad()
       .clickOnAnswer("[direct schedule in clinical conductor]")
       .clickNextButton(new SynexusRadiantDirectScheduleCC())
       .waitForPageLoad()
       .clickNextButton(new RadiantWarmTransfer4())
       .waitForPageLoad()
       .clickOnAnswer("Transferred for Scheduling")
       .clickNextButton(selectActionPageCC)
       .waitForPageLoad()
       .pidFromDbToLog(env); */
	}
}
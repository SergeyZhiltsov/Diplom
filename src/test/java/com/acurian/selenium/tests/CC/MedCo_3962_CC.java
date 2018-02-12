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
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
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
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatMedicalCoveragePageCC;
import com.acurian.selenium.pages.CC.pediatric.WouldYouUsePageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HasAHealthcareProfessionalDYS4356;
import com.acurian.selenium.pages.CC.shared.LastTimeYouHadHeartProceduresCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.StatinMedicationPreviousQuestionPageCC;
import com.acurian.selenium.pages.CC.shared.StatinMedicationsCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class MedCo_3962_CC extends BaseTest{
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void tc001Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1MED";
        List<String> protocols = Arrays.asList("MDCO_PCS_17_04");
        String protocol1 = "MDCO_PCS_17_04";        
        String studyName = "a high cholesterol and heart disease";
     //   String env = "STG";
        String siteName = "AUT_MEDCO_3962_site";
        String site_Indication = "Hypercholesterolemia, Cardiovascular Disease";
        String zipCode  = "19044";  //"45203" cincinnati, OH
        
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
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();
        
        callCenterIntroductionPageCC
                .waitForPageLoad();
       Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
       DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
        .activateDebugOnProd(env)
        .clickOnAnswer("Learn more about matching to clinical trials")
        .clickNextButton(new DateOfBirthPageCC());
       
       //dateOfBirthPageCC.waitForPageLoad();
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
       
       NonQRtransitionPageCC nonQRtransitionPageCC =  hasAHealthcareProfessionalDYS4356
    		   .waitForPageLoad()
    		   .clickOnAnswers("Unsure")
    		   .clickNextButton(new NonQRtransitionPageCC());
       
       nonQRtransitionPageCC.waitForPageLoad();
       
       DebugPageCC debugPageCC = new DebugPageCC();       
       debugPageCC.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);
       debugPageCC.back();
       
       NonQRtransitionPageCC nonQRtransitionPageCC1 =  hasAHealthcareProfessionalDYS4356
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new NonQRtransitionPageCC());       
       
       debugPageCC.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);
       debugPageCC.back();
       
       StatinMedicationsCC statinMedicationsCC = hasAHealthcareProfessionalDYS4356
    		   .waitForPageLoad()
    		   .clickOnAnswers("High cholesterol, or hypercholesterolemia")
    		   .clickNextButton(new StatinMedicationsCC());
       
       AreYouTakingAnyOfMedicationsCC areYouTakingAnyOfMedicationsCC = statinMedicationsCC       
               .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new AreYouTakingAnyOfMedicationsCC());       
       
       debugPageCC.checkProtocolsEquals("One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is a ...", protocol1);
       debugPageCC.back();
       
       StatinMedicationPreviousQuestionPageCC statinMedicationPreviousQuestionPageCC = statinMedicationsCC       
               .waitForPageLoad()
    		   .clickOnAnswers("Rosuvastatin")
    		   .clickNextButton(new StatinMedicationPreviousQuestionPageCC());
       
       AreYouTakingAnyOfMedicationsCC areYouTakingAnyOfMedicationsCC1 = statinMedicationPreviousQuestionPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("5 months")
    		   .clickNextButton(new AreYouTakingAnyOfMedicationsCC());
       
       NonPrescriptionSupplementsCC nonPrescriptionSupplementsCC = areYouTakingAnyOfMedicationsCC1
    		   .waitForPageLoad()
    		   .clickOnAnswers("Repatha (evolocumab)")
    		   .clickNextButton(new NonPrescriptionSupplementsCC());
       
       HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = nonPrescriptionSupplementsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new HasHealthcareProfessionalPageCC()); 
      
       
       HaveYouUndergoneAnyPageCC haveYouUndergoneAnyPageCC = hasHealthcareProfessionalPageCC
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new HaveYouUndergoneAnyPageCC());
       
       LastTimeYouHadHeartProceduresCC lastTimeYouHadHeartProceduresCC = haveYouUndergoneAnyPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Stent placement")
    		   .clickNextButton(new LastTimeYouHadHeartProceduresCC());
       
       ThankYouForAnsweringCC thankYouForAnsweringCC = lastTimeYouHadHeartProceduresCC
    		    .waitForPageLoad()
    		    .clickOnAnswer("Less than 30 days ago")
    		    .clickNextButton(new ThankYouForAnsweringCC());       
       
       debugPageCC.checkProtocolsEquals("When was the last time that you had one of the heart procedures from the last question?", protocol1);
       debugPageCC.back();
       
       lastTimeYouHadHeartProceduresCC
   	   .waitForPageLoad()
   	   .clickOnAnswer("7 - 12 months ago")
/*     .clickNextButton(new ThankYouForAnsweringCC())
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
       .clickNextButton(new PregnancyAndFertilityCC())
       .waitForPageLoad()
       .clickOnAnswer("None of the above")*/
   	   .clickNextButton(new ChildrenUnderPageCC())
   	   .waitForPageLoad()
       .clickOnAnswer("No")
       .clickNextButton(new IdentificationPageCC())
       .waitForPageLoad()       
       .clickNextButton(new SiteSelectionPageCC())
       .waitForPageLoad("a high cholesterol and heart disease study")
       .clickOnAnswer(siteName)
       .getPID()
       //Medical release Hello Sign CLose
       .clickNextButton(new HSGeneralCC())
       .waitForPageLoad(site_Indication)
       .clickNextButton(new DoctorInformationCollectionPageCC())
       .waitForPageLoad()
       .clickNextButton(new HSMedicalRecordsPageCC())
       .waitForPageLoad()
       .clickNextButton(new ThankYouCloseSimplePageCC())
       .waitForPageLoad()
       .clickNextButton(selectActionPageCC)
       .waitForPageLoad()
       .pidFromDbToLog(env);
	}
}

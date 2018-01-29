package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.END_4385.DescribesThePelvicPainCC;
import com.acurian.selenium.pages.CC.END_4385.DiagnoseYourEndometriosisCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.END_4385.LaparoscopyAndLaparotomyCC;
import com.acurian.selenium.pages.CC.END_4385.MostRecentSurgeryCC;
import com.acurian.selenium.pages.CC.END_4385.NonMenstrualPelvicPainCC;
import com.acurian.selenium.pages.CC.END_4385.PelvicPainDuringMenstrualCC;
import com.acurian.selenium.pages.CC.END_4385.PelvicPainOtherTimesCC;
import com.acurian.selenium.pages.CC.END_4385.SurgicalProceduresCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.SRDirectScheduleWTTCPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC3PageCC;
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
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
import com.acurian.selenium.pages.CC.shared.AreYouCurrentlyPregnantCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DoYouHaveRegularMenstrualCyclesUF_CC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HasHealthcareProfEverDiagnosedFollowingGynoUF_CC;
import com.acurian.selenium.pages.CC.shared.HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC;
import com.acurian.selenium.pages.CC.shared.HaveYouGoneThroughMenopauseUF_CC;
import com.acurian.selenium.pages.CC.shared.HaveYouHadHysterectomyUF_CC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class Endo_4356E_CC extends BaseTest{
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void tc001Test(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1END";
        List<String> protocols = Arrays.asList("MVT_601_3101", "MVT_601_3102","M14_702");
        String protocol1 = "MVT_601_3101";
        String protocol2 = "MVT_601_3102";
        String protocol3 = "M14_702";
        String studyName = "an endometriosis";
        String studyName1 = "arthritis";
        String env = "STG";
        String siteName = "AUT_END_4356E_Site";
        String zipCode  = "19044";
        
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

       ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
               .setMonth("Sep")
               .setDay("9")
               .setYear("1980")
               .clickNextButton(new ZipCodePageCC());
       
       GenderPageCC genderPageCC = zipCodePageCC
    		   .waitForPageLoad()
    		   .typeZipCode("19044")
    		   .clickNextButton(new GenderPageCC());
       
       HasHealthcareProfEverDiagnosedFollowingGynoUF_CC hasHealthcareProfEverDiagnosedFollowingGynoUF_CC = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new HasHealthcareProfEverDiagnosedFollowingGynoUF_CC());
       
       NonQRtransitionPageCC nonQRtransitionPageCC = hasHealthcareProfEverDiagnosedFollowingGynoUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new NonQRtransitionPageCC())
       		   .waitForPageLoad();
            
       DebugPageCC debugPageCC = new DebugPageCC();       
       debugPageCC.checkProtocolsEquals(hasHealthcareProfEverDiagnosedFollowingGynoUF_CC.titleExpected, protocol1, protocol2);
       debugPageCC.back(); 
       
       DiagnoseYourEndometriosisCC diagnoseYourEndometriosisCC = hasHealthcareProfEverDiagnosedFollowingGynoUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Endometriosis")    		   
    		   .clickNextButton(new DiagnoseYourEndometriosisCC());
       
       HaveYouGoneThroughMenopauseUF_CC haveYouGoneThroughMenopauseUF_CC = diagnoseYourEndometriosisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Unsure")
    		   .clickNextButton(new HaveYouGoneThroughMenopauseUF_CC());
       
       debugPageCC.checkProtocolsEquals("Did your doctor perform any of the following procedures to help diagnose your endometriosis? Please ...", protocol1, protocol2);
       debugPageCC.back();
       
       LaparoscopyAndLaparotomyCC laparoscopyAndLaparotomyCC = diagnoseYourEndometriosisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Laparotomy, a surgical procedure in which a large cut is made into the abdomen")
    		   .clickNextButton(new LaparoscopyAndLaparotomyCC());
            
       laparoscopyAndLaparotomyCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("4 - 6 years ago")
    		   .clickNextButton(new HaveYouGoneThroughMenopauseUF_CC());
       
       HaveYouHadHysterectomyUF_CC haveYouHadHysterectomyUF_CC = haveYouGoneThroughMenopauseUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
    		   .clickNextButton(new HaveYouHadHysterectomyUF_CC());
       
       debugPageCC.checkProtocolsEquals(haveYouGoneThroughMenopauseUF_CC.titleExpected, protocol1, protocol2);
       debugPageCC.back();
       
       haveYouGoneThroughMenopauseUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new HaveYouHadHysterectomyUF_CC());
       
       NonQRtransitionPageCC nonQRtransitionPageCC1 = haveYouHadHysterectomyUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new NonQRtransitionPageCC());

       debugPageCC.checkProtocolsEquals(haveYouHadHysterectomyUF_CC.titleExpected, protocol1, protocol2);
       debugPageCC.back();
     
       DoYouHaveRegularMenstrualCyclesUF_CC doYouHaveRegularMenstrualCyclesUF_CC = haveYouHadHysterectomyUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new DoYouHaveRegularMenstrualCyclesUF_CC());
       
       PelvicPainDuringMenstrualCC pelvicPainDuringMenstrualCC = doYouHaveRegularMenstrualCyclesUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new PelvicPainDuringMenstrualCC());
       
      
//       pelvicPainDuringMenstrualCC
//    		   .waitForPageLoad()
//    		   .clickOnAnswer("Yes")
//    		   .clickNextButton(new PelvicPainDuringMenstrualCC());
       
       DescribesThePelvicPainCC describesThePelvicPainCC = pelvicPainDuringMenstrualCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new DescribesThePelvicPainCC());
       
       PelvicPainOtherTimesCC pelvicPainOtherTimesCC = describesThePelvicPainCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Severe - the pain is so intense that I have great difficulty completing my daily activities")
    		   .clickNextButton(new PelvicPainOtherTimesCC());
       
       NonMenstrualPelvicPainCC nonMenstrualPelvicPainCC = pelvicPainOtherTimesCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new NonMenstrualPelvicPainCC());
       
       HormonalBirthControlCC hormonalBirthControlCC = nonMenstrualPelvicPainCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Moderate - the pain is strong enough that I have some difficulty completing my daily activities")
    		   .clickNextButton(new HormonalBirthControlCC());
       
       SurgicalProceduresCC surgicalProceduresCC = hormonalBirthControlCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new SurgicalProceduresCC());
       
       MostRecentSurgeryCC mostRecentSurgeryCC = surgicalProceduresCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("2")
    		   .clickNextButton(new  MostRecentSurgeryCC());
       
       
       mostRecentSurgeryCC
               .waitForPageLoad();
               HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC = mostRecentSurgeryCC
               .clickOnAnswer("7 - 11 months ago")
               .clickNextButton(new HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC());
       
       AreYouCurrentlyPregnantCC areYouCurrentlyPregnantCC = hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Endometrioma, also known as endometrial or endometrioid cyst or \"chocolate cyst\"")
    		   .clickNextButton(new AreYouCurrentlyPregnantCC());
       
       TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new TransitionStatementCC());
       
       HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = transitionStatementCC
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
    	                .waitForPageLoad("an endometriosis study")
    	                .getPID()
    	                .clickOnAnswer(siteName)
    	                .clickNextButton(new RadiantWarmTransferClose1PageCC())
    	                .waitForPageLoad()
    	                .clickOnAnswer("[patient agrees to be transferred]")
    	                .clickNextButton(new SynexusDirectScheduleWTC2PageCC())
    	                .waitForPageLoad()
    	                .clickOnAnswer("Yes")
    	                .clickNextButton(new SynexusDirectScheduleWTC3PageCC())
    	                .waitForPageLoad()
    	                .clickNextButton(new SRDirectScheduleWTTCPageCC())
    	                .waitForPageLoad()
    	                .clickOnAnswer("Transferred for Scheduling")
    	                .clickNextButton(selectActionPageCC)
    	                .waitForPageLoad()
    	                .pidFromDbToLog(env);
	}

}

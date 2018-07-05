package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.END_4385.ApproxHowManyDaysInYourMenstrualCycle_CC;
import com.acurian.selenium.pages.CC.END_4385.DescribesThePelvicPainCC;
import com.acurian.selenium.pages.CC.END_4385.DiagnoseYourEndometriosisCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.END_4385.HowManyTimesDidYouGetYourPeriodInThreeMons_CC;
import com.acurian.selenium.pages.CC.END_4385.LaparoscopyAndLaparotomyCC;
import com.acurian.selenium.pages.CC.END_4385.MostRecentSurgeryCC;
import com.acurian.selenium.pages.CC.END_4385.NonMenstrualPelvicPainCC;
import com.acurian.selenium.pages.CC.END_4385.PelvicPainDuringMenstrualCC;
import com.acurian.selenium.pages.CC.END_4385.PelvicPainOtherTimesCC;
import com.acurian.selenium.pages.CC.END_4385.PlzDescribeYourMenstrualCyclesCC;
import com.acurian.selenium.pages.CC.END_4385.SurgicalProceduresCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
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
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
	
	public void endo_4356E_CC(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1END";
        List<String> protocols = Arrays.asList("MVT_601_3101", "MVT_601_3102","M14_702");
        String protocol1 = "MVT_601_3101";
        String protocol2 = "MVT_601_3102";
        String protocol3 = "M14_702";
        String studyName = "an endometriosis";
        String studyName1 = "arthritis";
    //    String env = "STG";
        String siteName = "AUT_END_4356E_Site";
        String zipCode  = "19901";
        
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
    		   .clickOnAnswers("Endometriosis (Agent Note: end-oh-me-tree-OH-sis)")    		   
    		   .clickNextButton(new DiagnoseYourEndometriosisCC());
       
       HaveYouGoneThroughMenopauseUF_CC haveYouGoneThroughMenopauseUF_CC = diagnoseYourEndometriosisCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("11 or more years ago")
    		   .clickNextButton(new HaveYouGoneThroughMenopauseUF_CC());
       debugPageCC.checkProtocolsEquals("When was your most recent surgery to treat or diagnose your endometriosis performed?", protocol1, protocol2);
       debugPageCC.back();
       diagnoseYourEndometriosisCC.waitForPageLoad()
    		   .clickOnAnswer("2 - 3 months ago")
    		   .clickNextButton(new HaveYouGoneThroughMenopauseUF_CC());     
       
       haveYouGoneThroughMenopauseUF_CC
    		   .waitForPageLoad();
    		   HaveYouHadHysterectomyUF_CC haveYouHadHysterectomyUF_CC = haveYouGoneThroughMenopauseUF_CC
    		   .clickOnAnswer("No")
    		   .clickNextButton(new HaveYouHadHysterectomyUF_CC());
       
       NonQRtransitionPageCC nonQRtransitionPageCC1 = haveYouHadHysterectomyUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new NonQRtransitionPageCC());

       debugPageCC.checkProtocolsEquals(haveYouHadHysterectomyUF_CC.titleExpected, protocol1, protocol2);
       debugPageCC.back();
     
       PlzDescribeYourMenstrualCyclesCC plzDescribeYourMenstrualCyclesCC = haveYouHadHysterectomyUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new PlzDescribeYourMenstrualCyclesCC());
       
       ApproxHowManyDaysInYourMenstrualCycle_CC approxHowManyDaysInYourMenstrualCycle_CC = plzDescribeYourMenstrualCyclesCC
          		.waitForPageLoad()
          		.clickOnAnswer("Never regular")
          		.clickNextButton(new ApproxHowManyDaysInYourMenstrualCycle_CC());
       
       HowManyTimesDidYouGetYourPeriodInThreeMons_CC howManyTimesDidYouGetYourPeriodInThreeMons_CC = approxHowManyDaysInYourMenstrualCycle_CC
          		.waitForPageLoad()
          		.setDays("15")
          		.clickNextButton(new HowManyTimesDidYouGetYourPeriodInThreeMons_CC());
       
       PelvicPainDuringMenstrualCC pelvicPainDuringMenstrualCC = howManyTimesDidYouGetYourPeriodInThreeMons_CC
          		.waitForPageLoad()
          		.clickOnAnswer("Did not get period at all in the past 3 months")
          		.clickNextButton(new PelvicPainDuringMenstrualCC());
       
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
       
       //SurgicalProceduresCC surgicalProceduresCC = hormonalBirthControlCC
       hormonalBirthControlCC.waitForPageLoad();
    		   HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC = hormonalBirthControlCC
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC());    		   
    		   
/*    		   .clickNextButton(new SurgicalProceduresCC());
       surgicalProceduresCC
    		   .waitForPageLoad();
               HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC = surgicalProceduresCC
                .clickOnAnswer("1")
    		   .clickNextButton(new  HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC());  */    
       
       AreYouCurrentlyPregnantCC areYouCurrentlyPregnantCC = hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Endometrioma, (Agent Note: end-oh-me-tree-OH-ma) also known as endometrial (Agent Note: end-oh-ME-tree-ul) or endometrioid (Agent Note: endo-oh-ME-tree-oid) cyst or \"chocolate cyst\"")
    		   .clickNextButton(new AreYouCurrentlyPregnantCC());
       
       
       TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new TransitionStatementCC());
       
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
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
       		   //.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
               //.getAnomalyDbToLog(env); //Not applicable for Call center
	}

}

package com.acurian.selenium.tests.OLS;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.DescribesNonMenstrualPelvicPainOLS;
import com.acurian.selenium.pages.OLS.END_4385.DescribesPelvicPainOLS;
import com.acurian.selenium.pages.OLS.END_4385.DiagnoseYourEndometriosisOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.END_4385.LaparoscopyAndLaparotomyOLS;
import com.acurian.selenium.pages.OLS.END_4385.MostRecentSurgeryOLS;
import com.acurian.selenium.pages.OLS.END_4385.PelvicPainOLS;
import com.acurian.selenium.pages.OLS.END_4385.PelvicPainOtherTimesOLS;
import com.acurian.selenium.pages.OLS.END_4385.SurgicalProceduresOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolismPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.CongestiveHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HasHealthcareProfessionalPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HistoryOfDrugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SmokedCigarettesPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WomensHealthPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WouldYouUsePageOLS;
import com.acurian.selenium.pages.OLS.shared.AreYouCurrentlyPregnantOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DiagnosedWithGynecologicalConditionOLS;
import com.acurian.selenium.pages.OLS.shared.FollowingGynecologicalConditionOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveRegularMenstrualCyclesOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouGoneThroughMenopauseOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouHadHysterectomyOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

public class Endo_4356E_OLS extends BaseTest {
	
	@Test
	public void tc01() {
		String phoneNumberRA = "AUTAMS1END";
		String env = "STG";
		String protocol1 = "MVT_601_3101";
        String protocol2 = "MVT_601_3102";
        String protocol3 = "M14_702";
        List<String> protocols = Arrays.asList(protocol1,protocol2,protocol3);
        String studyName = "an endometriosis";
        String siteName = "AUT_END_4356E_Site";
        String zipCode = "19044";
        String idNumber = "625316"; 
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberRA)		           
		           .waitForPageLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText().contains("Let's get started to see if you qualify for an endometriosis study!"), true);
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1980")
		           .clickNextButton(new ZipCodePageOLS());
				
		GenderPageOLS genderPageOLS = zipCodePageOLS
		          .waitForPageLoad()
		          .typeZipCode("19044")
		          .clickNextButton(new GenderPageOLS());
		
		FollowingGynecologicalConditionOLS followingGynecologicalConditionOLS = genderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new FollowingGynecologicalConditionOLS());
		
		HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = followingGynecologicalConditionOLS
				    .waitForPageLoad()
	                .clickOnAnswers("None of the above")
	                .clickNextButton(new HasHealthcareProfessionalPageOLS());
	        hasHealthcareProfessionalPageOLS
	                .waitForPageLoad();
	        DebugPageOLS debugPageCC = new DebugPageOLS();
	        debugPageCC.back();
		
	        
		DiagnoseYourEndometriosisOLS diagnoseYourEndometriosisOLS = followingGynecologicalConditionOLS
				.waitForPageLoad()
				.clickOnAnswers("Endometriosis")
				.clickNextButton(new DiagnoseYourEndometriosisOLS());
		
		
		HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
		
/*		debugPageCC.checkProtocolsEquals("Did your doctor perform any of the following procedures to help diagnose your endometriosis? Please ...", protocol1,protocol2);
        debugPageCC.back();*/
//        
//        LaparoscopyAndLaparotomyOLS laparoscopyAndLaparotomyOLS = diagnoseYourEndometriosisOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Laparotomy, a surgical procedure in which a large cut is made into the abdomen")
//                .clickNextButton(new LaparoscopyAndLaparotomyOLS());
        
//        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS1 = laparoscopyAndLaparotomyOLS
//        		.waitForPageLoad()
//        		.clickOnAnswer("4 - 6 years ago")
//        		.clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        
        HaveYouHadHysterectomyOLS haveYouHadHysterectomyOLS = haveYouGoneThroughMenopauseOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new HaveYouHadHysterectomyOLS());
        		
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS1 = haveYouHadHysterectomyOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new HasHealthcareProfessionalPageOLS())
        .waitForPageLoad();
        debugPageCC.back();
        HaveRegularMenstrualCyclesOLS haveRegularMenstrualCyclesOLS = haveYouHadHysterectomyOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveRegularMenstrualCyclesOLS());
        
        PelvicPainOLS pelvicPainOLS = haveRegularMenstrualCyclesOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new PelvicPainOLS());
        
        
        PelvicPainOtherTimesOLS pelvicPainOtherTimesOLS = pelvicPainOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new  PelvicPainOtherTimesOLS());
                debugPageCC.back();
        DescribesPelvicPainOLS describesPelvicPainOLS = pelvicPainOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new  DescribesPelvicPainOLS());
        
        describesPelvicPainOLS
        		.waitForPageLoad();
        		HormonalBirthControlOLS hormonalBirthControlOLS = describesPelvicPainOLS
        		.clickOnAnswer("Severe - the pain is so intense that I have great difficulty completing my daily activities")
        		.clickNextButton(new HormonalBirthControlOLS());
        
        
        hormonalBirthControlOLS
        		.waitForPageLoad();
        		SurgicalProceduresOLS surgicalProceduresOLS = hormonalBirthControlOLS
        		.clickOnAnswer("Yes")
        		.clickNextButton(new SurgicalProceduresOLS());
              
        MostRecentSurgeryOLS mostRecentSurgeryOLS = surgicalProceduresOLS
        		.waitForPageLoad()
        		.clickOnAnswer("4 or more")
        		.clickNextButton(new MostRecentSurgeryOLS());
        
       mostRecentSurgeryOLS
        		.waitForPageLoad();
       			DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = mostRecentSurgeryOLS
        		.clickOnAnswer("7 - 11 months ago")
        		.clickNextButton(new DiagnosedWithGynecologicalConditionOLS());

       AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = diagnosedWithGynecologicalConditionOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Vaginismus")        		
        		.clickNextButton(new AreYouCurrentlyPregnantOLS());
        
        
        areYouCurrentlyPregnantOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new HasHealthcareProfessionalPageOLS());
        
        hasHealthcareProfessionalPageOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new CongestiveHeartFailurePageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new AffectingYourMetabolismPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new FollowingNeurologicalConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new AffectYourLungsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new DigestiveConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new BoneOrJointConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new SleepRelatedConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new SkinConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new ViralConditionsPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new MentalHealthPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new WomensHealthPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new OtherThanSkinCancerPageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new SmokedCigarettesPageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No, I never smoked")                
        .clickNextButton(new HistoryOfDrugPageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new ApproximateHeightPageOLS())
        .waitForPageLoad()
        .setAll("5", "5", "160")
        .clickNextButton(new ChildrenUnderPageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new TheStudySitePageOLS())
        .waitForPageLoad()
        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WouldYouUsePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("Neither")
        .clickNextButton(new WhatMedicalCoveragePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("No, I have no coverage")
        .clickNextButton(new EthnicBackgroundPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("Prefer not to answer")
        .clickNextButton(new IdentificationPageOLS())
        .waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new SiteSelectionPageOLS())
        .waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new SynexusQualifiedClose4356PageOLS())
        .waitForPageLoad(idNumber)
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()       
        .pidFromDbToLog(env);
	}
}
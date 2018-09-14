package com.acurian.selenium.tests.OLS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.ApproxHowManyDaysInYourMenstrualCycle_OLS;
import com.acurian.selenium.pages.OLS.END_4385.DescribesNonMenstrualPelvicPainOLS;
import com.acurian.selenium.pages.OLS.END_4385.DescribesPelvicPainOLS;
import com.acurian.selenium.pages.OLS.END_4385.DiagnoseYourEndometriosisOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.END_4385.HowManyTimesDidYouGetYourPeriodInThreeMons_OLS;
import com.acurian.selenium.pages.OLS.END_4385.LaparoscopyAndLaparotomyOLS;
import com.acurian.selenium.pages.OLS.END_4385.MostRecentSurgeryOLS;
import com.acurian.selenium.pages.OLS.END_4385.PelvicPainOLS;
import com.acurian.selenium.pages.OLS.END_4385.PelvicPainOtherTimesOLS;
import com.acurian.selenium.pages.OLS.END_4385.SurgicalProceduresOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.HumanAPIOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolismPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.CongestiveHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
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
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
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
import com.acurian.selenium.pages.OLS.shared.PlzDescribeYourMenstrualCyclesOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

public class END_4385_OLS extends BaseTest {
	
	@Test
	public void eND_4385_OLS() {
		String phoneNumberRA = "AUTAMS1END";
		String protocol1 = "MVT_601_3101";
        String protocol2 = "MVT_601_3102";
        String studyName = "an endometriosis";
        String siteName = "AUT_END_4385";
        String zipCode = "19901";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
		
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
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = followingGynecologicalConditionOLS
				    .waitForPageLoad()
	                .clickOnAnswers("None of the above")
	                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
			haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
	                .waitForPageLoad();
	        DebugPageOLS debugPageCC = new DebugPageOLS();
	        debugPageCC.checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of the following women's health conditions...", protocol1,protocol2);
	        debugPageCC.back();
		
		DiagnoseYourEndometriosisOLS diagnoseYourEndometriosisOLS = followingGynecologicalConditionOLS
				.waitForPageLoad()
				.clickOnAnswers("Endometriosis")
				.clickNextButton(new DiagnoseYourEndometriosisOLS());
		
        //-------------------------Q3-When was your most recent surgery to treat or diagnose your endometriosis performed?---------------------------------------------
		HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());		
		debugPageCC.checkProtocolsEquals("When was your most recent surgery to treat or diagnose your endometriosis performed?", protocol1,protocol2);
        debugPageCC.back();
        diagnoseYourEndometriosisOLS.waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());		
		debugPageCC.checkProtocolsEquals("When was your most recent surgery to treat or diagnose your endometriosis performed?", protocol1,protocol2);
        debugPageCC.back();
		diagnoseYourEndometriosisOLS.waitForPageLoad()
        		.clickOnAnswer("2 - 3 months ago")
        .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        
        //-------------------------Q4- Have you gone through menopause?---------------------------------------------
        HaveYouHadHysterectomyOLS haveYouHadHysterectomyOLS = haveYouGoneThroughMenopauseOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
        		.clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS.waitForPageLoad();
		debugPageCC.checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2);
        debugPageCC.back();
        haveYouGoneThroughMenopauseOLS.waitForPageLoad()
		.clickOnAnswer("No")
		.clickNextButton(new HaveYouHadHysterectomyOLS());
        
        
        //-------------------------Q5- Have you had a hysterectomy (surgical removal of the uterus)?----------------------------------------------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = haveYouHadHysterectomyOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        debugPageCC.checkProtocolsEquals("Have you had a hysterectomy (surgical removal of the uterus)?", protocol1,protocol2);
        debugPageCC.back();
        PlzDescribeYourMenstrualCyclesOLS plzDescribeYourMenstrualCyclesOLS = haveYouHadHysterectomyOLS
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesOLS());
       
      //-------------------------Q6- Please describe your menstrual cycles:-----------------------------
        ApproxHowManyDaysInYourMenstrualCycle_OLS approxHowManyDaysInYourMenstrualCycle_OLS = plzDescribeYourMenstrualCyclesOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Never regular")
        		.clickNextButton(new ApproxHowManyDaysInYourMenstrualCycle_OLS());
        
        
        //-------------------------new  Q7- Approximately how many days are in your menstrual cycle?-----------------------------
        HowManyTimesDidYouGetYourPeriodInThreeMons_OLS howManyTimesDidYouGetYourPeriodInThreeMons_OLS = approxHowManyDaysInYourMenstrualCycle_OLS
        		.waitForPageLoad()
        		.setDays("15")
        		.clickNextButton(new HowManyTimesDidYouGetYourPeriodInThreeMons_OLS());
        
        //-------------------------new Q8- How many times did you get your period in the past three months?-----------------------------
        PelvicPainOLS pelvicPainOLS = howManyTimesDidYouGetYourPeriodInThreeMons_OLS
        		.waitForPageLoad()
        		.clickOnAnswer("Did not get period at all in the past 3 months")
        		.clickNextButton(new PelvicPainOLS());
        
        
        //-------------Q9 - Do you experience pelvic pain during your menstrual period?-----------------
        PelvicPainOtherTimesOLS pelvicPainOtherTimesOLS = pelvicPainOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new  PelvicPainOtherTimesOLS());
        debugPageCC.checkProtocolsEquals("Do you ever experience pelvic pain during your menstrual period?", protocol1,protocol2);
        debugPageCC.back();
        DescribesPelvicPainOLS describesPelvicPainOLS = pelvicPainOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new  DescribesPelvicPainOLS());
        
        //---------------------"Q10 - Which of the following best describes the pelvic pain that you experience during your period, and how it affects your life?"---------
        describesPelvicPainOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
        		.clickNextButton(new PelvicPainOtherTimesOLS());

        //-----------------------Q11 - Do you experience pelvic pain at other times, when you do NOT have your period?------------
        DescribesNonMenstrualPelvicPainOLS describesNonMenstrualPelvicPainOLS = pelvicPainOtherTimesOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new DescribesNonMenstrualPelvicPainOLS());
        
        //---------------------------Q12 - Which of the following best describes your pelvic pain at times when you do NOT have your period, and how it affects your life?--------
        HormonalBirthControlOLS hormonalBirthControlOLS = describesNonMenstrualPelvicPainOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
        		.clickNextButton(new HormonalBirthControlOLS());

        //-------------------------Q13 - Are you currently taking a hormonal form of birth control?----------
        //SurgicalProceduresOLS surgicalProceduresOLS = hormonalBirthControlOLS
        DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = hormonalBirthControlOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new DiagnosedWithGynecologicalConditionOLS());
        //------------------R 50.1-----
        diagnosedWithGynecologicalConditionOLS.waitForPageLoad();
        debugPageCC.checkProtocolsEquals("Ghost Question - Irregular Menstrual Cycle DQ Logic", protocol1,protocol2);
        debugPageCC.back();
        hormonalBirthControlOLS.waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());        
       
        
        //---------Q12 - Has a healthcare professional ever diagnosed you with any of these other gynecological or women's health conditions? ---
        AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = diagnosedWithGynecologicalConditionOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Vaginismus")        		
        		.clickNextButton(new AreYouCurrentlyPregnantOLS());
        
        //-------------Q13 - Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?-------
        areYouCurrentlyPregnantOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        debugPageCC.checkProtocolsEquals("Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?", protocol1,protocol2);
        debugPageCC.back();
        areYouCurrentlyPregnantOLS
        		.waitForPageLoad()
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
        .clickNextButton(new ChildrenUnderPageOLS())
		//----------ChildrenUnderTheAge Page--------------------
        .waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new HouseholdHavePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new TheStudySitePageOLS())
        .waitForPageLoad()
		//-------------------PEDIATRIC QUESTIONS-----------------------------   
        .clickOnAnswer("Public transportation")
        .clickNextButton(new WhatMedicalCoveragePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("No, I have no coverage")
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
        .clickNextButton(new HSGeneralPageOLS())
        .waitForPageLoad("Endometriosis")
        .clickNextButton(new DoctorInformationCollectionPageOLS())
        .waitForPageLoad()
        .clickNextButton(new HS1PageOLS())
        .waitForPageLoad()
        .clickOkInPopUp()
        .setSignature()
        
        //------------HUMAN API Interface in HelloSign----------------
        .getPage(new HumanAPIOLS())
        .waitForPageLoad()		        
        .connectBTN()
        .switchToAPI()
        .waitForProvider()
        .clickANY()
        .waitSearchAll()
        .search("cleveland clinic")
        .waitProvider()
        .clickProvider()
        .typeUserName("democlinical@gmail.com")
        .typePWD("password")
        .clickConnect()
        
        .waitToClickNext()
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
	}
}
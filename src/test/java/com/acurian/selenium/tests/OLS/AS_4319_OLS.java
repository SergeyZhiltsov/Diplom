package com.acurian.selenium.tests.OLS;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AS_4319.AreYouWheelchairBoundOLS;
import com.acurian.selenium.pages.OLS.AS_4319.DiagnosedWithAnkylosingSpondylitisOLS;
import com.acurian.selenium.pages.OLS.AS_4319.FollowingSymptomsMoreThanOnceWeekOLS;
import com.acurian.selenium.pages.OLS.AS_4319.HaveYouEverHadXrayOrMRIOLS;
import com.acurian.selenium.pages.OLS.AS_4319.ResultsOfYourMostRecentXRayOrMRIOLS;
import com.acurian.selenium.pages.OLS.AS_4319.SacroiliitisPageOLS;
import com.acurian.selenium.pages.OLS.AS_4319.WhichOfFollowingHaveYouDiagnosedWithOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSCrohnsPageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.HumanAPIOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatSortPageOLS;
import com.acurian.selenium.pages.OLS.shared.BiologicMedications;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DoYouSufferFromArthritis;
import com.acurian.selenium.pages.OLS.shared.DoYouSufferFromLbpPageOLS;
import com.acurian.selenium.pages.OLS.shared.FollowingDevicesInYourBody;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HowLongHaveLbpPageOLS;
import com.acurian.selenium.pages.OLS.shared.TakenXeljanz;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

public class AS_4319_OLS extends BaseTest {
	
	@Test
	public void as_4319_OLS() {
		String phoneNumberRA = "AUTAMS1AS1";	
		String protocol1 = "M16_098";          
        List<String> protocols = Arrays.asList(protocol1);
        String studyName = "an ankylosing spondylitis (AS)";
        String siteName = "AUT_AS_4319";
        String zipCode = "19044";
        String Siteindicator = "Ankylosing Spondylitis";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberRA)           
		           .waitForPageLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText().contains("Let's get started to see if you qualify for an ankylosing spondylitis (AS) study!"), true);
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1980")
		           .clickNextButton(new ZipCodePageOLS());
				
		GenderPageOLS genderPageOLS = zipCodePageOLS
		          .waitForPageLoad()
		          .typeZipCode("19044")
		          .clickNextButton(new GenderPageOLS());
		
		DiagnosedWithAnkylosingSpondylitisOLS diagnosedWithAnkylosingSpondylitisOLS = genderPageOLS
		         .waitForPageLoad()
		         .clickOnAnswer("Female")
		         .clickNextButton(new DiagnosedWithAnkylosingSpondylitisOLS());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedWithAnkylosingSpondylitisOLS
				 .waitForPageLoad()
				 .clickOnAnswer("No")
				 .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		DebugPageOLS debugPageOLS = new DebugPageOLS();
		debugPageOLS.checkProtocolsContainsForQNumber("QS4715", protocol1);
        debugPageOLS.back();
        
        DoYouSufferFromLbpPageOLS doYouSufferFromLbpPageOLS = diagnosedWithAnkylosingSpondylitisOLS
               .waitForPageLoad()
               .clickOnAnswer("Yes")               
               .clickNextButton(new DoYouSufferFromLbpPageOLS());
        
        HowLongHaveLbpPageOLS howLongHaveLbpPageOLS = doYouSufferFromLbpPageOLS
               .waitForPageLoad()
               .clickOnAnswer("Yes")
               .clickNextButton(new HowLongHaveLbpPageOLS());
        
        HaveYouEverHadXrayOrMRIOLS haveYouEverHadXrayOrMRIOLS = howLongHaveLbpPageOLS
               .waitForPageLoad()
               .clickOnAnswer("7 months to 1 year")
               .clickNextButton(new HaveYouEverHadXrayOrMRIOLS());
        
        FollowingSymptomsMoreThanOnceWeekOLS followingSymptomsMoreThanOnceWeekOLS = haveYouEverHadXrayOrMRIOLS
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new FollowingSymptomsMoreThanOnceWeekOLS());
        
        debugPageOLS.checkProtocolsEquals("Have you ever had an x-ray or MRI of your back or pelvis, to look for signs of ankylosing spondyliti", protocol1);
        debugPageOLS.back();
        
        SacroiliitisPageOLS sacroiliitisPageOLS = haveYouEverHadXrayOrMRIOLS
               .waitForPageLoad()               
               .clickOnAnswer("Yes")
               .clickNextButton(new SacroiliitisPageOLS());
        
        FollowingSymptomsMoreThanOnceWeekOLS followingSymptomsMoreThanOnceWeekOLS1 = sacroiliitisPageOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Doctor did not explain the x-ray or MRI at all")
        		.clickNextButton(new FollowingSymptomsMoreThanOnceWeekOLS());
        
        BiologicMedications biologicMedications = followingSymptomsMoreThanOnceWeekOLS1
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new BiologicMedications());
        
        TakenXeljanz takenXeljanz = biologicMedications
        		.waitForPageLoad()
        		.clickOnAnswers("Actemra", "Benlysta", "Cimzia", "Cosentyx")
        		.clickNextButton(new TakenXeljanz());
        debugPageOLS.checkProtocolsContainsForQNumber("QS4708", protocol1);
        debugPageOLS.back();
        
        biologicMedications
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new TakenXeljanz());
        
        AreYouWheelchairBoundOLS areYouWheelchairBoundOLS = takenXeljanz
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, I am currently taking it")
        		.clickNextButton(new AreYouWheelchairBoundOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS4709", protocol1);
        debugPageOLS.back();
        
        takenXeljanz
				.waitForPageLoad()
				.clickOnAnswer("I took it in the past, but not now")
				.clickNextButton(new AreYouWheelchairBoundOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS4709", protocol1);
        debugPageOLS.back();
        
        takenXeljanz
				.waitForPageLoad()
				.clickOnAnswer("No, I have never taken it")
				.clickNextButton(new AreYouWheelchairBoundOLS());
        
        FollowingDevicesInYourBody followingDevicesInYourBody = areYouWheelchairBoundOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new FollowingDevicesInYourBody());        
        debugPageOLS.checkProtocolsContainsForQNumber("QS4710", protocol1);
        debugPageOLS.back();
        
        areYouWheelchairBoundOLS
                .waitForPageLoad()
                .clickOnAnswer("No")                
                .clickNextButton(new FollowingDevicesInYourBody());
        
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = followingDevicesInYourBody
        		.waitForPageLoad()
        		.clickOnAnswer("None of the above")
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        
        
        
        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1
        	.waitForPageLoad()
        	.clickOnAnswers("None of the above")
        	.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        	.waitForPageLoad()
        	.clickOnAnswers("None of the above")
        //------------ New for AMS1 Rel.51, when Gender = Female --------
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
		//-------------------PEDIATRIC QUESTIONS----------------------
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
	        .waitForPageLoad(Siteindicator)
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
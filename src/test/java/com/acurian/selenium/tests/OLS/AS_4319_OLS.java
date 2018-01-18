package com.acurian.selenium.tests.OLS;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AS_4319.AreYouWheelchairBoundOLS;
import com.acurian.selenium.pages.OLS.AS_4319.FollowingSymptomsMoreThanOnceWeekOLS;
import com.acurian.selenium.pages.OLS.AS_4319.HaveYouEverHadXrayOrMRIOLS;
import com.acurian.selenium.pages.OLS.AS_4319.ResultsOfYourMostRecentXRayOrMRIOLS;
import com.acurian.selenium.pages.OLS.AS_4319.WhichOfFollowingHaveYouDiagnosedWithOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSCrohnsPageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
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
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
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
	public void tc01() {
		String phoneNumberRA = "AUTAMS1AS1";
		String env = "STG";
		String protocol1 = "M16_098";               
        List<String> protocols = Arrays.asList(protocol1);
        String studyName = "an ankylosing spondylitis (AS)";
        String siteName = "AUT_AS_4319";
        String zipCode = "19044";
        String Siteindicator = "Ankylosing Spondylitis";
		
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
		
		WhichOfFollowingHaveYouDiagnosedWithOLS whichOfFollowingHaveYouDiagnosedWithOLS = genderPageOLS	
		         .waitForPageLoad()
		         .clickOnAnswer("Female")
		         .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWithOLS());
		
		HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = whichOfFollowingHaveYouDiagnosedWithOLS
				 .waitForPageLoad()
				 .clickOnAnswers("None of the above")
				 .clickNextButton(new HasHealthcareProfessionalPageOLS());
		
		DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals("Which of the following have you been diagnosed with?Agent Note: Select all that applyWhich of the fo", protocol1);
        debugPageOLS.back();
        
        DoYouSufferFromLbpPageOLS doYouSufferFromLbpPageOLS = whichOfFollowingHaveYouDiagnosedWithOLS
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickOnAnswers("Ankylosing spondylitis (AS)")
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
        
        ResultsOfYourMostRecentXRayOrMRIOLS resultsOfYourMostRecentXRayOrMRIOLS = haveYouEverHadXrayOrMRIOLS
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickOnAnswer("Yes")
               .clickNextButton(new ResultsOfYourMostRecentXRayOrMRIOLS());
        
        FollowingSymptomsMoreThanOnceWeekOLS followingSymptomsMoreThanOnceWeekOLS1 = resultsOfYourMostRecentXRayOrMRIOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Unsure")
        		.clickNextButton(new FollowingSymptomsMoreThanOnceWeekOLS());
        
        BiologicMedications biologicMedications = followingSymptomsMoreThanOnceWeekOLS1
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new BiologicMedications());
        
        TakenXeljanz takenXeljanz = biologicMedications
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new TakenXeljanz());
        
        AreYouWheelchairBoundOLS areYouWheelchairBoundOLS = takenXeljanz
        		.waitForPageLoad()
        		.clickOnAnswer("No, I have never taken it")
        		.clickNextButton(new AreYouWheelchairBoundOLS());
        
        FollowingDevicesInYourBody followingDevicesInYourBody = areYouWheelchairBoundOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new FollowingDevicesInYourBody());
        
        debugPageOLS.checkProtocolsEquals("Are you permanently wheelchair-bound, bedridden, or otherwise completely unable to walk due to your ...", protocol1);
        debugPageOLS.back();
        
        areYouWheelchairBoundOLS
                .waitForPageLoad()
                .clickOnAnswer("No")                
                .clickNextButton(new FollowingDevicesInYourBody());
        
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS1 = followingDevicesInYourBody
        		.waitForPageLoad()
        		.clickOnAnswer("None of the above")
        		.clickNextButton(new HasHealthcareProfessionalPageOLS());
        
        hasHealthcareProfessionalPageOLS1
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
        .clickOnAnswer("Yes")
        .clickNextButton(new HouseholdHavePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new TheStudySitePageOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new WhatSortPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("No, I have no coverage")
        .clickNextButton(new EthnicBackgroundPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("Other")
        .clickNextButton(new IdentificationPageOLS())
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
        .getPage(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad();	
      
	}

}

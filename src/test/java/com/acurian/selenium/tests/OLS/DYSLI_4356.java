package com.acurian.selenium.tests.OLS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.AreYouTakingMedications;
import com.acurian.selenium.pages.OLS.DY_4356.NonPrescriptionSupplements;
import com.acurian.selenium.pages.OLS.DY_4356.PregnancyAndFertilityPage;
import com.acurian.selenium.pages.OLS.closes.GladLocationIsConvenient;
import com.acurian.selenium.pages.OLS.closes.SiteSelection;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungs;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolism;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditions;
import com.acurian.selenium.pages.OLS.generalHealth.CancerPage;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditions;
import com.acurian.selenium.pages.OLS.generalHealth.DrugOrAlcoholAbuse;
import com.acurian.selenium.pages.OLS.generalHealth.HasHealthcareProfessionalPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouSmokedCigarettes;
import com.acurian.selenium.pages.OLS.generalHealth.HeartRelatedMedicalProc;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.NeurologicalConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditions;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditions;
import com.acurian.selenium.pages.OLS.generalHealth.WomenHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.YouHaveCHF;
import com.acurian.selenium.pages.OLS.shared.ChildrenUnderTheAge;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DyslipidemiaHealthcarePage;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HowLongTakingStatin;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.ProvideHeightWeight;
import com.acurian.selenium.pages.OLS.shared.StatinMedicationsPage;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

public class DYSLI_4356 extends BaseTest {
	
	@Test
	public void tc01() {
		String phoneNumberDY = "AUTAMS1DYS";
		String env = "STG";
		
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumberDY)		           
		           .waitForPageLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleDYExpected, "Title is diff");
		
		PersonalDetails personalDetails = dateOfBirthPageOLS
		           .setDate("10/10/1975")
		           .clickNextButton(new PersonalDetails());
		
		GenderPageOLS genderPageOLS = personalDetails
				.waitForPageLoad()
				.setZip("19044")
				.setFirstName("Test")
				.setLastName("Acurian")
				.setPhone("2564859854")								
				.clickNextButton(new GenderPageOLS());
		
		DyslipidemiaHealthcarePage dyslipidemiaHealthcarePage = genderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new DyslipidemiaHealthcarePage());
		
		HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS =  dyslipidemiaHealthcarePage
				.waitForPageLoad()
				.clickOnAnswers("Unsure")
				.clickNextButton(new HasHealthcareProfessionalPageOLS());
		
		Assert.assertEquals(hasHealthcareProfessionalPageOLS.getTitleText(),hasHealthcareProfessionalPageOLS.titleExpected, "Title is diff");
		DebugPageOLS debugPageOLS = new DebugPageOLS();
		debugPageOLS.openDebugWindow();
		Assert.assertEquals(debugPageOLS.getProtocol201(), "20150230", "Protocol not displayed");
		Assert.assertEquals(debugPageOLS.getProtocolVK(), "VK2809_201", "Protocol not displayed");
		debugPageOLS.closeDebugWindow();
		
		hasHealthcareProfessionalPageOLS.back();
		
		
		StatinMedicationsPage statinMedicationsPage = dyslipidemiaHealthcarePage
				.waitForPageLoad()				
				.clickOnAnswers("High fats or lipids, or hyperlipidemia")				
				.clickNextButton(new StatinMedicationsPage());
		
		AreYouTakingMedications areYouTakingMedications = statinMedicationsPage
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new AreYouTakingMedications());
		
		NonPrescriptionSupplements nonPrescriptionSupplements = areYouTakingMedications
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new NonPrescriptionSupplements());
		
		HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS1 = nonPrescriptionSupplements
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HasHealthcareProfessionalPageOLS());		
		
		
		debugPageOLS.openDebugWindow();
		Assert.assertEquals(debugPageOLS.getProtocol201(), "20150230", "Protocol not displayed");
		Assert.assertEquals(debugPageOLS.getProtocolVK(), "VK2809_201", "Protocol not displayed");
		debugPageOLS.closeDebugWindow();
				
		nonPrescriptionSupplements.back();
		areYouTakingMedications.back();
		
	
		HowLongTakingStatin howLongTakingStatin = statinMedicationsPage
				.waitForPageLoad()
				.clickOnAnswers("Rosuvastatin")
				.clickNextButton(new HowLongTakingStatin());
		
		AreYouTakingMedications areYouTakingMedications1 = howLongTakingStatin
				.waitForPageLoad()
				.clickOnAnswers("5 months")
				.clickNextButton(new AreYouTakingMedications());
		
		NonPrescriptionSupplements nonPrescriptionSupplements1 = areYouTakingMedications1
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new NonPrescriptionSupplements());
		
		HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS2 = nonPrescriptionSupplements1
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HasHealthcareProfessionalPageOLS());
		
		HeartRelatedMedicalProc heartRelatedMedicalProc = hasHealthcareProfessionalPageOLS2
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HeartRelatedMedicalProc());
		
		PregnancyAndFertilityPage pregnancyAndFertilityPage = heartRelatedMedicalProc
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new PregnancyAndFertilityPage());
		
		YouHaveCHF youHaveCHF = pregnancyAndFertilityPage
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new YouHaveCHF());
		
		AffectingYourMetabolism affectingYourMetabolism = youHaveCHF
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new AffectingYourMetabolism());
		
		NeurologicalConditions neurologicalConditions = affectingYourMetabolism
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new NeurologicalConditions());
		
		AffectYourLungs affectYourLungs = neurologicalConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new AffectYourLungs());
		
		DigestiveConditions digestiveConditions = affectYourLungs
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new DigestiveConditions());
		
		BoneOrJointConditions boneOrJointConditions = digestiveConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new BoneOrJointConditions());
		
		SleepRelatedConditions sleepRelatedConditions = boneOrJointConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SleepRelatedConditions());
		
		SkinConditions skinConditions = sleepRelatedConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SkinConditions());
		
		ViralConditions viralConditions = skinConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ViralConditions());
		
		MentalHealthConditions mentalHealthConditions = viralConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new MentalHealthConditions());
		
		
		WomenHealthConditions womenHealthConditions = mentalHealthConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new WomenHealthConditions());
		
		CancerPage cancerPage = womenHealthConditions
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new CancerPage());
		
		HaveYouSmokedCigarettes haveYouSmokedCigarettes = cancerPage
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new HaveYouSmokedCigarettes());
		
		DrugOrAlcoholAbuse drugOrAlcoholAbuse = haveYouSmokedCigarettes
				.waitForPageLoad()
				.clickOnAnswers("No, I never smoked")
				.clickNextButton(new DrugOrAlcoholAbuse());
		
		
		ProvideHeightWeight provideHeightWeight = drugOrAlcoholAbuse
				.waitForPageLoad()
				.clickOnAnswers("No, I never smoked")
				.clickNextButton(new ProvideHeightWeight());
		
		ChildrenUnderTheAge childrenUnderTheAge = provideHeightWeight
				.waitForPageLoad()
				.setFT("5")
				.setIN("5")
				.setWeight("155")
				.clickNextButton(new ChildrenUnderTheAge());
		
		PersonalDetails personalDetails1 =  childrenUnderTheAge
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new PersonalDetails());
		
		SiteSelection siteSelection = personalDetails1
				.waitForPageLoad()
				.clickConfirm()				
				.clickNextButton(new SiteSelection());
		
		GladLocationIsConvenient gladLocationIsConvenient = siteSelection
				.waitForPageLoad()
				.clickAdditional()
				.selectExton()
				.clickNextButton(new GladLocationIsConvenient());
		
		
		
		
	}

}

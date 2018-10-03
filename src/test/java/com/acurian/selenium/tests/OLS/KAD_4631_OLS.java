package com.acurian.selenium.tests.OLS;

import java.time.Instant;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.AgeUnqualifiedClose_OLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose_OLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.CancerPage;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.BiologicMedications;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DidYouReceiveAnyTherapiesPastYear_OLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouEverTreatedYourEczema_OLS;
import com.acurian.selenium.pages.OLS.shared.OverallHowWellDidTopicalMedicationYouTried_OLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class KAD_4631_OLS extends BaseTest{

    @Test(enabled = true)
    @TestCaseId("00002")
    @Description("MIG_4356B_Synexus_OLS module")
    public void kad_4631() {
        String phoneNumberMIG = "AUTAMS1KAD";
        String protocol1 = "KPL_716_C001";       
        String studyName =  "an eczema (atopic dermatitis)";
        String siteName = "AUT_DERM_4631_Site";
        String zipCode = "19901";
        String env = System.getProperty("acurian.env", "STG");

        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                	.openPage(env, phoneNumberMIG)
                	.waitForPageLoad();
        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                	.setDate("09092003")
                	.clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1);
		debugPageOLS.back();
		PersonalDetails personalDetails = dateOfBirthPageOLS
					.waitForPageLoad()
					.setDate("09091951")
					.clickNextButton(new PersonalDetails());
		personalDetails.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1);
		debugPageOLS.back();
		dateOfBirthPageOLS
					.waitForPageLoad()
        			.setDate("09091980")
        			.clickNextButton(new PersonalDetails());
		
		
		GenderPageOLS genderPageOLS = personalDetails
				    .waitForPageLoad()
				    .setAllFields("Acurian", "Trial", eMailId, "9999999999", zipCode)
				    .clickNextButton(new GenderPageOLS());
		
		HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS = genderPageOLS
				  	.waitForPageLoad()
				  	.clickOnAnswer("Female")				  
				  	.clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());
		
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
					.waitForPageLoad()
					.clickOnAnswer("No")
					.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5802", protocol1);
		debugPageOLS.back();		
		HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_OLS = hasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS
					.waitForPageLoad()
					.clickOnAnswer("Yes")
					.clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());
		
		
		WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS = howLongHaveYouBeenSufferingFromEczema_OLS
					.waitForPageLoad()
					.clickOnAnswer("Less than 3 months")
					.clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());
		whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5803", protocol1);
		debugPageOLS.back();
		howLongHaveYouBeenSufferingFromEczema_OLS
					.waitForPageLoad()
					.clickOnAnswer("3 to less than 6 months")
					.clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());
		whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5803", protocol1);
		debugPageOLS.back();
		howLongHaveYouBeenSufferingFromEczema_OLS
					.waitForPageLoad()
					.clickOnAnswer("6 to less than 12 months")
					.clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());
		whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5803", protocol1);
		debugPageOLS.back();
		howLongHaveYouBeenSufferingFromEczema_OLS
					.waitForPageLoad()
					.clickOnAnswer("1 year or more")
					.clickNextButton(new WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS());
		
		
		whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
					.waitForPageLoad()
					.clickOnAnswers("None of these")
					.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5805", protocol1);
		debugPageOLS.back();		
		WeWantToMakeSureTheImagesDisplayProperly_OLS weWantToMakeSureTheImagesDisplayProperly_OLS = whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
					.waitForPageLoad()
					.clickOnAnswers("Head, face, and neck", "Chest, stomach, and back", "Arms and hands", "Legs and feet")
					.clickNextButton(new WeWantToMakeSureTheImagesDisplayProperly_OLS());
		
		
		WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS = weWantToMakeSureTheImagesDisplayProperly_OLS
					.waitForPageLoad()
					.clickOnAnswer("Computer or tablet")
					.clickNextButton(new WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS());		
		whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS.threadSleep(2000);
		
		
		WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS = whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
			 		.waitForPageLoad()
			 		.clickOnAnswer("A")
			 		.clickNextButton(new WhichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS());
		whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS.threadSleep(2000);
		
		
		WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS = whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("A")
					.clickNextButton(new WhichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS());
		whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS.threadSleep(2000);
		
		
		WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS = whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("A")
					.clickNextButton(new WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS());
		whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS.threadSleep(2000);
		//BiologicMedications biologicMedications = whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
		HaveYouEverTreatedYourEczema_OLS haveYouEverTreatedYourEczema_OLS = whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("A")
					.clickNextButton(new HaveYouEverTreatedYourEczema_OLS());
		haveYouEverTreatedYourEczema_OLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5815", protocol1);
		debugPageOLS.back();
		whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("B")
					.clickNextButton(new HaveYouEverTreatedYourEczema_OLS());
		haveYouEverTreatedYourEczema_OLS
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5815", protocol1);
		debugPageOLS.back();		
		whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("C")
					.clickNextButton(new BiologicMedications());
		haveYouEverTreatedYourEczema_OLS.
					waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5815", protocol1);
		debugPageOLS.back();
		whichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS
					.waitForPageLoad()
					.back();
		whichOfThesePicsLooksSimilarOnYourArmsHands_Comp_OLS
					.waitForPageLoad()
					.back();
		whichOfThesePicsLooksSimilarOnYourChestStomachBack_Comp_OLS
					.waitForPageLoad()
					.back();
		whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
 					.waitForPageLoad()
 					.back();
		weWantToMakeSureTheImagesDisplayProperly_OLS
					.waitForPageLoad()
					.back();
		whichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS
					.waitForPageLoad()
					.clickOnAnswers("Chest, stomach, and back", "Arms and hands", "Legs and feet")
					.clickNextButton(new WeWantToMakeSureTheImagesDisplayProperly_OLS());
		
		
		weWantToMakeSureTheImagesDisplayProperly_OLS
					.waitForPageLoad()
					.clickOnAnswer("Computer or tablet")
					.clickNextButton(new WhichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS());
		
		
		
		whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
				 	.waitForPageLoad()
				 	.clickOnAnswer("A")
				 	.clickNextButton(new BiologicMedications());
		haveYouEverTreatedYourEczema_OLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5815", protocol1);
		debugPageOLS.back();
		whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
	 				.waitForPageLoad()
	 				.clickOnAnswer("B")
	 				.clickNextButton(new BiologicMedications());
		debugPageOLS.checkProtocolsContainsForQNumber("QS5815", protocol1);
		debugPageOLS.back();		
		whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("C")
					.clickNextButton(new BiologicMedications());
		haveYouEverTreatedYourEczema_OLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5815", protocol1);
		debugPageOLS.back();
		whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("D")
					.clickNextButton(new BiologicMedications());
		haveYouEverTreatedYourEczema_OLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5815", protocol1);
		debugPageOLS.back();
		whichOfThesePicsLooksSimilarOnYourHeadFaceNeck_Comp_OLS
					.waitForPageLoad()
					.clickOnAnswer("G")				
					.clickNextButton(new HaveYouEverTreatedYourEczema_OLS());
		
		
		//--------------Q17- HaveYouEverTreatedYourEczema_OLS ----------
		haveYouEverTreatedYourEczema_OLS
					.waitForPageLoad();
		//-----------select NO to skip to Q19, otherwise goto Q18
		WhichofthefollowingMedicationsTherapies_OLS whichofthefollowingMedicationsTherapies_OLS = haveYouEverTreatedYourEczema_OLS
					.clickOnAnswer("No")
					.clickNextButton(new WhichofthefollowingMedicationsTherapies_OLS())
					.waitForPageLoad();			
					whichofthefollowingMedicationsTherapies_OLS.back();
		haveYouEverTreatedYourEczema_OLS
					.waitForPageLoad();
					OverallHowWellDidTopicalMedicationYouTried_OLS overallHowWellDidTopicalMedicationYouTried_OLS = haveYouEverTreatedYourEczema_OLS
					.clickOnAnswer("Yes, but more than 1 year ago")
					.clickOnAnswer("Yes, within the past year")    //final selection
					.clickNextButton(new OverallHowWellDidTopicalMedicationYouTried_OLS());
				
				
		//--------------Q18- OverallHowWellDidTopicalMedicationYouTried_OLS ----------
		overallHowWellDidTopicalMedicationYouTried_OLS
					.waitForPageLoad()
					.clickOnAnswer("My symptoms did not change")
					.clickOnAnswer("My symptoms got a little bit better")
					.clickOnAnswer("My symptoms got a lot better")
					.clickOnAnswer("My symptoms went away completely")  //final selection
					.clickNextButton(new WhichofthefollowingMedicationsTherapies_OLS());


		//--------------Q19- whichofthefollowingMedicationsTherapies_OLS ----------
		whichofthefollowingMedicationsTherapies_OLS
					.waitForPageLoad()
					.clickOnAnswers("None of the above")
					.clickNextButton(new BiologicMedications())
					.waitForPageLoad()
					.back();
		whichofthefollowingMedicationsTherapies_OLS
					.waitForPageLoad();
		DidYouReceiveAnyTherapiesPastYear_OLS didYouReceiveAnyTherapiesPastYear_OLS = whichofthefollowingMedicationsTherapies_OLS
					.clickOnAnswers("Azasan or Imuran (azathioprine)")
					.clickOnAnswers("CellCept or Myfortic (mycophenolate)")
					.clickOnAnswers("Dupixent (dupilumab)")
					.clickOnAnswers("Neoral, Sandimmune, or Gengraf (cyclosporine)")
					.clickOnAnswers("Methotrexate (Brand names: Otrexup, Rasuvo, or Trexall)")
					.clickOnAnswers("Prednisone (Brand names: Deltasone, Prednisone Intensol, or Rayos)")
					.clickOnAnswers("Phototherapy (Ultraviolet or UV light)")
					.clickNextButton(new DidYouReceiveAnyTherapiesPastYear_OLS());

				
				
		//--------------Q20- DidYouReceiveAnyTherapiesPastYear_OLS ----------
		didYouReceiveAnyTherapiesPastYear_OLS
					.waitForPageLoad();
		BiologicMedications biologicMedications = didYouReceiveAnyTherapiesPastYear_OLS
					.clickOnAnswer("No")
					.clickNextButton(new BiologicMedications());
		biologicMedications
					.waitForPageLoad()
					.back();
		didYouReceiveAnyTherapiesPastYear_OLS
					.waitForPageLoad()				
					.clickOnAnswer("Yes")
					.clickNextButton(new BiologicMedications());
				
		
		//---------Q22:  BiologicMedications---------------
		biologicMedications
					.waitForPageLoadKAD()
					.clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)", "Benlysta", "Cimzia", "Cosentyx", "Enbrel", "Entyvio", "Humira",
							"Kineret", "Orencia", "Prolia or Xgeva", "Raptiva", "Remicade", "Rituxan", "Simponi", "Stelara", "Taltz", "Tysabri")
					.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS5821", protocol1);
		debugPageOLS.back();
		biologicMedications
					.waitForPageLoadKAD()
					.clickOnAnswers("None of the above")
					.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());		
		
		
		CancerPage cancerPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
					.waitForPageLoad()
					.clickOnAnswers("Cancer")
					.clickNextButton(new CancerPage());
		cancerPage.threadSleep(1000);
		
		
		DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = cancerPage
					.waitForPageLoad()
					.clickOnAnswer("Within the past 5 years")
					.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		doAnyOftheFollowingAdditionalDiagnosesOLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS42", protocol1);
		debugPageOLS.back();
		cancerPage
					.waitForPageLoad()
					.back();		
		HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
					.waitForPageLoad()
					.clickOnAnswers("Cancer")
					.clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
					.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
		
		
		SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
					.waitForPageLoad()
					.clickOnAnswers("Heart attack", "Stroke", "TIA or \"mini-stroke\"", "Angina (heart-related chest pain) that required an overnight hospital stay", "Heart failure or congestive heart failure (CHF)")
					.clickNextButton(new SubquestionExperiencedHeartPageOLS());
		subquestionExperiencedHeartPageOLS
        			.waitForPageLoad();
		Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1),subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
		Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2),subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
		Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(3),subquestionExperiencedHeartPageOLS.titleExpected3, "Title is diff");
		Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(4),subquestionExperiencedHeartPageOLS.titleExpected4, "Title is diff");
		HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"Less than 30 days ago")
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"Less than 30 days ago")
					.clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
		debugPageOLS.back();		
		subquestionExperiencedHeartPageOLS
					.waitForPageLoad()
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"1 - 3 months ago")
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"1 - 3 months ago")
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"1 - 3 months ago")
					.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"1 - 3 months ago")
					.clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
		debugPageOLS.back();
		subquestionExperiencedHeartPageOLS.threadSleep(1000);
		subquestionExperiencedHeartPageOLS
					.waitForPageLoad()
					.back();
		haveYouEverExperiencedHeartRelatedMedicalCondOLS
					.waitForPageLoad()
					.clickOnAnswers("None of the above")
					.clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
		
		
		heartrelatedMedicalProceduresPageOLS
					.waitForPageLoad()
					.clickOnAnswers("None of the above")
					.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		
		
		ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
					.waitForPageLoad()
					.clickOnAnswers("Kidney disease requiring dialysis")
					.clickNextButton(new ApproximateHeightPageOLS());
		approximateHeightPageOLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS61", protocol1);
		debugPageOLS.back();		
		doAnyOftheFollowingAdditionalDiagnosesOLS
					.waitForPageLoad()
					.clickOnAnswers("Kidney disease requiring dialysis")
					.clickOnAnswers("Cirrhosis")
					.clickNextButton(new ApproximateHeightPageOLS())
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();		
		doAnyOftheFollowingAdditionalDiagnosesOLS
					.waitForPageLoad()
					.clickOnAnswers("Bipolar disorder")
					.clickOnAnswers("Cirrhosis")
					.clickNextButton(new ApproximateHeightPageOLS())
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		doAnyOftheFollowingAdditionalDiagnosesOLS
					.waitForPageLoad()
					.clickOnAnswers("Schizophrenia")
					.clickOnAnswers("Bipolar disorder")
					.clickNextButton(new ApproximateHeightPageOLS())
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS61", protocol1);
		debugPageOLS.back();		
		doAnyOftheFollowingAdditionalDiagnosesOLS
					.waitForPageLoad()
					.clickOnAnswers("Schizophrenia")
					.clickOnAnswers("Drug or alcohol abuse within the past year")
					.clickNextButton(new ApproximateHeightPageOLS())
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		doAnyOftheFollowingAdditionalDiagnosesOLS
					.waitForPageLoad()
					.clickOnAnswers("Hepatitis B")
					.clickOnAnswers("Drug or alcohol abuse within the past year")
					.clickNextButton(new ApproximateHeightPageOLS())
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();		
		doAnyOftheFollowingAdditionalDiagnosesOLS
					.waitForPageLoad()
					.clickOnAnswers("Hepatitis B")
					.clickOnAnswers("Hepatitis C")
					.clickNextButton(new ApproximateHeightPageOLS())
					.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis C")
				.clickOnAnswers("HIV or AIDS")
				.clickNextButton(new ApproximateHeightPageOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")				
				.clickNextButton(new ApproximateHeightPageOLS());
		
		
		ChildrenUnderPageOLS childrenUnderPageOLS = approximateHeightPageOLS
    			.waitForPageLoad()
    			.setAll("5", "10", "120")
    			.clickNextButton(new ChildrenUnderPageOLS());
		childrenUnderPageOLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS60", protocol1);
		debugPageOLS.back();
		approximateHeightPageOLS
				.waitForPageLoad()
				.setFeatwithClear("4")
				.setIncheswithClear("5")
				.setLbs("188")				
				.clickNextButton(new ChildrenUnderPageOLS());
		childrenUnderPageOLS.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS60", protocol1);
		debugPageOLS.back();
		approximateHeightPageOLS
				.waitForPageLoad()
				.setFeatwithClear("5")				
				.setLbs("160")				
//				.clickNextButton(new ChildrenUnderPageOLS())
//				.waitForPageLoad()
//		        .clickOnAnswer("Yes")
//		        .clickNextButton(new HouseholdHavePageOLS())
//		        .waitForPageLoad()
//		        .clickOnAnswers("None of the above")
//		        .clickNextButton(new TheStudySitePageOLS())
//		        .waitForPageLoad()
//		        .clickOnAnswer("Public transportation")
//		        .clickNextButton(new WhatMedicalCoveragePageOLS())
//		        .waitForPageLoad()
//		        .clickOnAnswers("No, I have no coverage")
		        .clickNextButton(new EthnicBackgroundPageOLS())
		        .waitForPageLoad()
		        .clickOnAnswers("Prefer not to answer")
		        .clickNextButton(new IdentificationPageOLS())		
				.waitForPageLoad()
				.clickNextButton(new SiteSelectionPageOLS())
				.waitForPageLoad(studyName)
		        .getPID()
		        .clickOnFacilityName(siteName)
		        .clickNextButton(new QualifiedClose2PageOLS())
		        .waitForPageLoad()
		        .clickNextButton(new ThankYouCloseSimplePageOLS())
		        .waitForPageLoad()
		        .clickNextButton(new AboutHealthPageOLS())
		        .waitForPageLoad()		        
		        .pidFromDbToLog(env)	
		        .childPidFromDbToLog(env);        
    }
}
package com.acurian.selenium.tests.OLS;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.generalHealth.KidneyProblemsPage;
import com.acurian.selenium.pages.OLS.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.OLS.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.OLS.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.AUTI_3973.DoYouKnowSomeoneStudyPartner_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.HaveYouEverBeenToldByDoctorAutism_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.HaveYouEverHadAnIQtest_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.HaveYouHadSeizureInLast6Mon_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.HowDidYouScoreOnTheTest_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.InThePast3MonthsHaveYouExperienced_OLS;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.ApartFromMetforminPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CombinationWithEachOtherPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.DiabeticNephropathyPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.FollowingToLoseWeightPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.ForYourKidneysPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.InjectableMedicationsForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.InsulinForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LastTimeYouTookPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LiverRelatedConditionOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.MetforminMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.NoOfAlcoholicDrinkOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionsHumalogPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.AgeUnqualifiedClose_OLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingDiagnosedWithByDoctor_DigestivedisordersOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingDiagnosedWithByDoctor_MentalOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DiagnosedAnyTypeOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.ProcedureForWeightLossPageOLS;
import com.acurian.selenium.pages.OLS.shared.StatinMedicationsOnPageOLS;
import com.acurian.selenium.pages.OLS.shared.WeightLossSurgeryPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AUT_3973_OLS extends BaseTest {

	@Test(enabled = true)
	@TestCaseId("0001")
	@Description("Akcea_4691 OLS")

	public void AKC_4691_OLS_EmailAtPII() {

		String phoneNumber = "AUTAMS1ROC";
		String AUTISM = "WN39434";
		String studyName = "an autism spectrum disorder";
		String siteIndication = "Autism";
		String siteName = "AUT_3973";
		String zipCode = "08204";

		String env = System.getProperty("acurian.env");
		if (env == null)
			env = "STG";

		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumber).waitForPageLoad().maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titelAutism_Expected,
				"Title is diff");

		// --------------DOB Question------------
		AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
			// ------------Disqualify (“Age < 18 years old”) if <18
			// -----------------------------------------
				.waitForPageLoad()
				.setDate("09092000")
				.clickNextButton(new AgeUnqualifiedClose_OLS());
		ageUnqualifiedClose_OLS
				.waitForPageLoad();
		DebugPageOLS debugPageOLS = new DebugPageOLS();
		ageUnqualifiedClose_OLS
				.getPage(debugPageOLS).checkProtocolsContainsForQNumber("QSI8004", AUTISM).back();
		dateOfBirthPageOLS
				.waitForPageLoad();
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS.setDate("09091980").clickNextButton(new ZipCodePageOLS());

		
		// --------------ZIP_CODE Question------------
		zipCodePageOLS
				.waitForPageLoad();
		Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
		GenderPageOLS genderPageOLS = zipCodePageOLS.typeZipCode(zipCode).clickNextButton(new GenderPageOLS());

		
		// --------------GENDER Question------------
		genderPageOLS
				.waitForPageLoad();
		Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
		HaveYouEverBeenToldByDoctorAutism_OLS haveYouEverBeenToldByDoctorAutism_OLS = genderPageOLS
				.clickOnAnswer("Female")
				.clickNextButton(new HaveYouEverBeenToldByDoctorAutism_OLS());

		
		// --------------Q2: Have you ever been told by a doctor that you have
		// autism or an autism spectrum disorder?------------
		haveYouEverBeenToldByDoctorAutism_OLS
				.waitForPageLoad();
		Assert.assertEquals(haveYouEverBeenToldByDoctorAutism_OLS.getTitleText(),haveYouEverBeenToldByDoctorAutism_OLS.titleExpected, "Title is diff");
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouEverBeenToldByDoctorAutism_OLS
				.clickOnAnswer("No, my doctor has not told me that I have autism or an autism spectrum disorder")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
		debugPageOLS
				.checkProtocolsContainsForQNumber("QS5902", AUTISM)
				.back();
		InThePast3MonthsHaveYouExperienced_OLS inThePast3MonthsHaveYouExperienced_OLS = haveYouEverBeenToldByDoctorAutism_OLS
				.waitForPageLoad()
				.clickOnAnswer("Yes, my doctor has told me that I have autism or an autism spectrum disorder")
				.clickNextButton(new InThePast3MonthsHaveYouExperienced_OLS());

		
		
		// --------------Q3: In the past three months, have you experienced any
		// of the following?------------
		inThePast3MonthsHaveYouExperienced_OLS
				.waitForPageLoad();
		Assert.assertEquals(inThePast3MonthsHaveYouExperienced_OLS.getTitleText(),inThePast3MonthsHaveYouExperienced_OLS.titleExpected, "Title is diff");
		inThePast3MonthsHaveYouExperienced_OLS
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouHadSeizureInLast6Mon_OLS()).waitForPageLoad().getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS5903", AUTISM).back();
		inThePast3MonthsHaveYouExperienced_OLS
				.waitForPageLoad();
		HaveYouHadSeizureInLast6Mon_OLS haveYouHadSeizureInLast6Mon_OLS = inThePast3MonthsHaveYouExperienced_OLS
				.clickOnAnswers("Trouble understanding what other people are feeling",
						"Trouble understanding facial expressions or what other preople want",
						"Trouble communicating feelings to others, or being able to keep up with conversations",
						"Trouble starting conversations with other people, or wanting to be alone instead of being with other people",
						"Trouble with changes in routine, or preoccupation with certain topics or items")
				.clickNextButton(new HaveYouHadSeizureInLast6Mon_OLS());

		
		
		// --------------Q4: Have you had a seizure in the last 6
		// months?------------
		haveYouHadSeizureInLast6Mon_OLS
				.waitForPageLoad();
		Assert.assertEquals(haveYouHadSeizureInLast6Mon_OLS.getTitleText(),haveYouHadSeizureInLast6Mon_OLS.titleExpected, "Title is diff");
		haveYouHadSeizureInLast6Mon_OLS
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouEverHadAnIQtest_OLS())
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS5904", AUTISM)
				.back();
		haveYouHadSeizureInLast6Mon_OLS
				.waitForPageLoad();
		HaveYouEverHadAnIQtest_OLS haveYouEverHadAnIQtest_OLS = haveYouHadSeizureInLast6Mon_OLS.clickOnAnswer("No")
				.clickNextButton(new HaveYouEverHadAnIQtest_OLS());
		
		

		// --------------Q5: Have you ever had an IQ test? It is also called an
		// intelligence test.-----------
		haveYouEverHadAnIQtest_OLS
				.waitForPageLoad();
		Assert.assertEquals(haveYouEverHadAnIQtest_OLS.getTitleText(),haveYouEverHadAnIQtest_OLS.titleExpected, "Title is diff");
		// Skip to Q7 if selected other than "Yes", otherwise continue to Q6
		haveYouEverHadAnIQtest_OLS
				.clickOnAnswer("Unsure")
				.clickOnAnswer("No")
				.clickNextButton(new DoYouKnowSomeoneStudyPartner_OLS())
				.waitForPageLoad()
				.back();
		haveYouEverHadAnIQtest_OLS
				.waitForPageLoad();
		HowDidYouScoreOnTheTest_OLS howDidYouScoreOnTheTest_OLS = haveYouEverHadAnIQtest_OLS
				.clickOnAnswer("Yes")
				.clickNextButton(new HowDidYouScoreOnTheTest_OLS());

		
		
		// --------------Q6: How did you score on the test?---------
		howDidYouScoreOnTheTest_OLS
				.waitForPageLoad();
		Assert.assertEquals(howDidYouScoreOnTheTest_OLS.getTitleText(),howDidYouScoreOnTheTest_OLS.titleExpected,	"Title is diff");
		howDidYouScoreOnTheTest_OLS
				.clickOnAnswer("Below 70")
				.clickNextButton(new DoYouKnowSomeoneStudyPartner_OLS())
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS5906", AUTISM)
				.back();
		howDidYouScoreOnTheTest_OLS
				.waitForPageLoad();
		DoYouKnowSomeoneStudyPartner_OLS doYouKnowSomeoneStudyPartner1_OLS = haveYouEverHadAnIQtest_OLS
				.clickOnAnswer("I am not sure")
				.clickOnAnswer("90 to 109")
				.clickOnAnswer("70 to 89")
				.clickOnAnswer("110 or more")
				.clickNextButton(new DoYouKnowSomeoneStudyPartner_OLS());
		
		

		// ----------Q7: Do you know someone a person that you usually regularly
		// spend time with (for example, a parent or spouse) who can would be
		// able to attend visits with you as a study partner?
		doYouKnowSomeoneStudyPartner1_OLS
				.waitForPageLoad();
		Assert.assertEquals(doYouKnowSomeoneStudyPartner1_OLS.getTitleText(),doYouKnowSomeoneStudyPartner1_OLS.titleExpected, "Title is diff");
		doYouKnowSomeoneStudyPartner1_OLS
				.clickOnAnswer("No")
				.clickOnAnswer("Unsure")
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

		
		
		// ----------Q8: Ghost Question - Autism End of module logic----------
		// If in Call Center AND if General Health Module not answered ==> Go to
		// Transition Statement
		// If in OLS, Go to Decision Module Q1
		
		
		
		//----------------------GENERAL HEALTH Questions -----------------------------
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad();				
		OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad()
				.clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
								"Kidney disease",
								"Cancer")
				.clickNextButton(new OtherThanSkinCancerPageOLS());
		

		//----CANCER DQ Check----------
		otherThanSkinCancerPageOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS38", AUTISM)
				.back();
		WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad()
				.clickOnAnswers("Cancer") // Un-Check 'Cancer'
				.clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
		

		//----KIDNEY DQ Check----------
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				.waitForPageLoad();
		WhichOfFollowingDiagnosedWithByDoctor_MentalOLS whichOfFollowingDiagnosedWithByDoctor_MentalOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				// ---DQ if selected "Dialysis"-----
				.clickOnAnswers("Dialysis", "Kidney transplant")
				.clickNextButton(new WhichOfFollowingDiagnosedWithByDoctor_MentalOLS());
		whichOfFollowingDiagnosedWithByDoctor_MentalOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS51", AUTISM)
				.back();
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				.waitForPageLoad()		
				.clickOnAnswers("Neither")
				.clickNextButton(new WhichOfFollowingDiagnosedWithByDoctor_MentalOLS());
		
		
		
		//----Check mental or emotional health condition DQ check----
		whichOfFollowingDiagnosedWithByDoctor_MentalOLS
				.waitForPageLoad();
		DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfFollowingDiagnosedWithByDoctor_MentalOLS
		// ---DQ if selected "Dialysis"-----		
				.clickOnAnswers("Bipolar disorder", "Schizophrenia")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS53", AUTISM)
				.back();
		whichOfFollowingDiagnosedWithByDoctor_MentalOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());		
		
				
				
		//----Do any of the following additional diagnoses apply to you? ------------
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad();
		//HormonalBirthControlOLS hormonalBirthControlOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
		ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
		.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year", 
								"Hepatitis B",
								"Hepatitis C", 
								"HIV or AIDS")
				.clickNextButton(new ApproximateHeightPageOLS());
		approximateHeightPageOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS59", AUTISM)
				.back();
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ApproximateHeightPageOLS());

	
		//----HEIGHT and WEIGHT Question ------------
		approximateHeightPageOLS
				.waitForPageLoad();
		ChildrenUnderPageOLS childrenUnderPageOLS = approximateHeightPageOLS
				.waitForPageLoad()
				.setAll("5", "5", "160")
				.clickNextButton(new ChildrenUnderPageOLS());


		//----Do you have any children under the age of 18 in your household? ------------		
		childrenUnderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new TheStudySitePageOLS());
		TheStudySitePageOLS theStudySitePageOLS = new TheStudySitePageOLS();
		
		

		// -------------------PEDIATRIC QUESTIONS-----------------------------
		theStudySitePageOLS
				.waitForPageLoad()
				.clickOnAnswer("Public transportation")
				.clickNextButton(new WhatMedicalCoveragePageOLS())
				.waitForPageLoad()
				.clickOnAnswers("No, I have no coverage")
				.clickNextButton(new EthnicBackgroundPageOLS())
				.waitForPageLoad()
				.clickOnAnswers("Prefer not to answer")
				.clickNextButton(new IdentificationPageOLS())
				// ----------PII (IdentificationPageOLS)
				// Page--------------------
				.waitForPageLoad()
				.setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
				.clickNextButton(new SiteSelectionPageOLS())
				.waitForPageLoad(studyName)
				.getPID()
				// ----------SITE Selection Page--------------------
				.clickOnFacilityName(siteName)
				.clickNextButton(new HSGeneralPageOLS())
				// ----------HELLO SIGN Page (Email entered at PII)--------------------
				.waitForPageLoad(siteIndication)
				.clickNextButton(new DoctorInformationCollectionPageOLS())
				.waitForPageLoad()
				.clickNextButton(new HS1PageOLS())
				.waitForPageLoad()
				.clickOkInPopUp()
				.setSignature()
				.getPage(new ThankYouCloseSimplePageOLS())
				.waitForPageLoad()
				.clickNextButton(new AboutHealthPageOLS())
				.waitForPageLoad()
				.pidFromDbToLog(env);
	}
}
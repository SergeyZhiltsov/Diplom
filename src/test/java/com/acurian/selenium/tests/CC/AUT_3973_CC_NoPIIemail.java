package com.acurian.selenium.tests.CC;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.AUTI_3973.DoYouKnowSomeoneStudyPartner_CC;
import com.acurian.selenium.pages.CC.AUTI_3973.HaveYouEverBeenToldByDoctorAutism_CC;
import com.acurian.selenium.pages.CC.AUTI_3973.HaveYouEverHadAnIQtest_CC;
import com.acurian.selenium.pages.CC.AUTI_3973.HaveYouHadSeizureInLast6Mon_CC;
import com.acurian.selenium.pages.CC.AUTI_3973.HowDidYouScoreOnTheTest_CC;
import com.acurian.selenium.pages.CC.AUTI_3973.InThePast3MonthsHaveYouExperienced_CC;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.DoYouExperienceDPN_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.WhereDoYouExperienceDiabeticNervePain_CC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.ApartFromMetforminPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.CombinationWithEachOtherPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiabeticNephropathyPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.FollowingLiverRelatedConditionCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.FollowingToLoseWeightPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.ForYourKidneysPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.InjectableMedicationsForYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.InsulinForYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.LastTimeYouTookPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.MetforminMedicationsPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.NoOfAlcoholicDrinksCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionsHumalogPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.KidneyProblemsPage;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.OtherThanSkinCancerPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.WhenDiagnosedWithCancer;
import com.acurian.selenium.pages.CC.generalHealth.WhichFollowingMentalEmotionalHealth_CC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.HouseholdHavePageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC;
import com.acurian.selenium.pages.CC.shared.HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.ProcedureForWeightLossPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.StatinMedicationsOnPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementAUTISM_CC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WeightLossSurgeryPageCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.pages.CC.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.CC.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.CC.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.AUTI_3973.DoYouKnowSomeoneStudyPartner_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.HaveYouEverHadAnIQtest_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.HaveYouHadSeizureInLast6Mon_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.HowDidYouScoreOnTheTest_OLS;
import com.acurian.selenium.pages.OLS.AUTI_3973.InThePast3MonthsHaveYouExperienced_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LiverRelatedConditionOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingDiagnosedWithByDoctor_MentalOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS;
import com.acurian.selenium.utils.DataProviderPool;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AUT_3973_CC_NoPIIemail extends BaseTest{
	
	
    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)  
    @TestCaseId("00004")
    @Description("Diabetes_4356A_Synexus for CC")
    public void AUTO_3973_CC_NoPIIemail(final String username, final String password) {
        String phoneNumber = "AUTAMS1ROC";
        String AUTISM = "WN39434";        
		String studyName = "an autism spectrum disorder study";
		String siteIndication = "Autism";
        String siteName = "AUT_3973";             
        String zipCode = "08204";
        
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
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());
        
        
        //--------------DOB Question------------
        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleAUT3973, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());
        

        //--------------ZIP_CODE Question------------
        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());
        

        //--------------GENDER Question------------
        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        HaveYouEverBeenToldByDoctorAutism_CC haveYouEverBeenToldByDoctorAutism_CC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenToldByDoctorAutism_CC());
        

        
        
        
		// --------------Q2: Have you ever been told by a doctor that you have
		// autism or an autism spectrum disorder?------------
		haveYouEverBeenToldByDoctorAutism_CC
				.waitForPageLoad();
		Assert.assertEquals(haveYouEverBeenToldByDoctorAutism_CC.getTitleText(),haveYouEverBeenToldByDoctorAutism_CC.titleExpected, "Title is diff");		
		NonQRtransitionPageCC nonQRtransitionPageCC = haveYouEverBeenToldByDoctorAutism_CC
				.clickOnAnswer("No, my doctor has not told me that I have autism or an autism spectrum disorder")
				.clickNextButton(new NonQRtransitionPageCC());
		nonQRtransitionPageCC
				.waitForPageLoad();
		DebugPageCC debugPageCC = new DebugPageCC();
		debugPageCC
				.checkProtocolsContainsForQNumber("Q0017138-QS5902-STUDYQUES", AUTISM)
				.back();
		InThePast3MonthsHaveYouExperienced_CC inThePast3MonthsHaveYouExperienced_CC = haveYouEverBeenToldByDoctorAutism_CC
				.waitForPageLoad()
				.clickOnAnswer("Yes, my doctor has told me that I have autism or an autism spectrum disorder")
				.clickNextButton(new InThePast3MonthsHaveYouExperienced_CC());

		
		
		// --------------Q3: In the past three months, have you experienced any
		// of the following?------------
		inThePast3MonthsHaveYouExperienced_CC
				.waitForPageLoad();
		Assert.assertEquals(inThePast3MonthsHaveYouExperienced_CC.getTitleText(),inThePast3MonthsHaveYouExperienced_CC.titleExpected, "Title is diff");
		inThePast3MonthsHaveYouExperienced_CC
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouHadSeizureInLast6Mon_CC())
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0017141-QS5903-STUDYQUES", AUTISM).back();
		inThePast3MonthsHaveYouExperienced_CC
				.waitForPageLoad();
		HaveYouHadSeizureInLast6Mon_CC haveYouHadSeizureInLast6Mon_CC = inThePast3MonthsHaveYouExperienced_CC
				.clickOnAnswers("Trouble understanding what other people are feeling",
						"Trouble understanding facial expressions or what other preople want",
						"Trouble communicating feelings to others, or being able to keep up with conversations",
						"Trouble starting conversations with other people, or wanting to be alone instead of being with other people",
						"Trouble with changes in routine, or preoccupation with certain topics or items")
				.clickNextButton(new HaveYouHadSeizureInLast6Mon_CC());

		
		
		// --------------Q4: Have you had a seizure in the last 6
		// months?------------
		haveYouHadSeizureInLast6Mon_CC
				.waitForPageLoad();
		Assert.assertEquals(haveYouHadSeizureInLast6Mon_CC.getTitleText(),haveYouHadSeizureInLast6Mon_CC.titleExpected, "Title is diff");
		haveYouHadSeizureInLast6Mon_CC
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouEverHadAnIQtest_CC())
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0017142-QS5904-STUDYQUES", AUTISM)
				.back();
		haveYouHadSeizureInLast6Mon_CC
				.waitForPageLoad();
		HaveYouEverHadAnIQtest_CC haveYouEverHadAnIQtest_CC = haveYouHadSeizureInLast6Mon_CC.clickOnAnswer("No")
				.clickNextButton(new HaveYouEverHadAnIQtest_CC());
		
		

		// --------------Q5: Have you ever had an IQ test? It is also called an
		// intelligence test.-----------
		haveYouEverHadAnIQtest_CC
				.waitForPageLoad();
		Assert.assertEquals(haveYouEverHadAnIQtest_CC.getTitleText(),haveYouEverHadAnIQtest_CC.titleExpected, "Title is diff");
		// Skip to Q7 if selected other than "Yes", otherwise continue to Q6
		haveYouEverHadAnIQtest_CC
				.clickOnAnswer("Unsure")
				.clickOnAnswer("No")
				.clickNextButton(new DoYouKnowSomeoneStudyPartner_CC())
				.waitForPageLoad()
				.back();
		haveYouEverHadAnIQtest_CC
				.waitForPageLoad();
		HowDidYouScoreOnTheTest_CC howDidYouScoreOnTheTest_CC = haveYouEverHadAnIQtest_CC
				.clickOnAnswer("Yes")
				.clickNextButton(new HowDidYouScoreOnTheTest_CC());

		
		
		// --------------Q6: How did you score on the test?---------
		howDidYouScoreOnTheTest_CC
				.waitForPageLoad();
		Assert.assertEquals(howDidYouScoreOnTheTest_CC.getTitleText(),howDidYouScoreOnTheTest_CC.titleExpected,	"Title is diff");
		howDidYouScoreOnTheTest_CC
				.clickOnAnswer("Below 70")
				.clickNextButton(new DoYouKnowSomeoneStudyPartner_CC())
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0017143-QS5906-STUDYQUES", AUTISM)
				.back();
		howDidYouScoreOnTheTest_CC
				.waitForPageLoad();
		DoYouKnowSomeoneStudyPartner_CC doYouKnowSomeoneStudyPartner1_CC = haveYouEverHadAnIQtest_CC
				.clickOnAnswer("I am not sure")
				.clickOnAnswer("90 to 109")
				.clickOnAnswer("70 to 89")
				.clickOnAnswer("110 or more")
				.clickNextButton(new DoYouKnowSomeoneStudyPartner_CC());
		
		

		// ----------Q7: Do you know someone a person that you usually regularly
		// spend time with (for example, a parent or spouse) who can would be
		// able to attend visits with you as a study partner?
		doYouKnowSomeoneStudyPartner1_CC
				.waitForPageLoad();
		Assert.assertEquals(doYouKnowSomeoneStudyPartner1_CC.getTitleText(),doYouKnowSomeoneStudyPartner1_CC.titleExpected, "Title is diff");
		TransitionStatementAUTISM_CC transitionStatementAUTISM_CC = doYouKnowSomeoneStudyPartner1_CC
				.clickOnAnswer("No")
				.clickOnAnswer("Unsure")
				.clickOnAnswer("Yes")
				.clickNextButton(new TransitionStatementAUTISM_CC());

		
		//------transitionStatementAUTISM_CC---------
		transitionStatementAUTISM_CC
				.waitForPageLoad();
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementAUTISM_CC
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
		
		// ----------Q8: Ghost Question - Autism End of module logic----------
		// If in Call Center AND if General Health Module not answered ==> Go to
		// Transition Statement
		// If in OLS, Go to Decision Module Q1
		
		
		
		//----------------------GENERAL HEALTH Questions -----------------------------
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
				.waitForPageLoad();				
		OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
				.waitForPageLoad()
				.clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
								"Kidney disease",
								"Cancer")
				.clickNextButton(new OtherThanSkinCancerPageCC());
		//HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = haveYouEverBeenToldByDoctorAutism_CC

		//----CANCER DQ Check----------
		otherThanSkinCancerPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES", AUTISM)
				.back();		
		haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
				.waitForPageLoad();
		KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
				.clickOnAnswers("Cancer") // Un-Check 'Cancer'
				.clickNextButton(new KidneyProblemsPage());
		

		//----KIDNEY DQ Check----------
		kidneyProblemsPage
				.waitForPageLoad();
		WhichFollowingMentalEmotionalHealth_CC whichFollowingMentalEmotionalHealth_CC = kidneyProblemsPage
				// ---DQ if selected "Dialysis"-----
				.clickOnAnswers("Dialysis", "Kidney transplant")
				.clickNextButton(new WhichFollowingMentalEmotionalHealth_CC());
		whichFollowingMentalEmotionalHealth_CC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", AUTISM)
				.back();
		kidneyProblemsPage
				.waitForPageLoad()		
				.clickOnAnswers("Neither")
				.clickNextButton(new FollowingMentalHealthPageCC());
		
		
		
		//----Check mental or emotional health condition DQ check----
		whichFollowingMentalEmotionalHealth_CC
				.waitForPageLoad();
		DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whichFollowingMentalEmotionalHealth_CC
		// ---DQ if selected "Dialysis"-----		
				.clickOnAnswers("Bipolar disorder", "Schizophrenia")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
		doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", AUTISM)
				.back();
		whichFollowingMentalEmotionalHealth_CC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());		
		
				
				
		//----Do any of the following additional diagnoses apply to you? ------------
		doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad();
		//HormonalBirthControlCC hormonalBirthControlCC = doAnyOftheFollowingAdditionalDiagnosesCC
		ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
		.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year", 
								"Hepatitis B",
								"Hepatitis C", 
								"HIV or AIDS")
				.clickNextButton(new ApproximateHeightPageCC());
		approximateHeightPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", AUTISM)
				.back();
		doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ApproximateHeightPageCC());

	        
                
        		//----------Height and Weight Question Page--------------------
        new ApproximateHeightPageCC()
        		.waitForPageLoad()
                .setAll("5", "6", "170")
                .clickNextButton(new LetMeSeePageCC())                
                
        		//----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                
                //----------PEDIATRIC HEALTH Questions----------
                .clickNextButton(new HouseholdHavePageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                
        		//----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Auto", "Test", "", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                
        		//----------SITE Selection Page--------------------
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                
        		//----------Special Type 2 Diabetes HELLO SIGN Page (email at PII)--------------------
                .waitForPageLoadInd(siteIndication)
                .typeEmailAut("qa.acurian@gmail.com")
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
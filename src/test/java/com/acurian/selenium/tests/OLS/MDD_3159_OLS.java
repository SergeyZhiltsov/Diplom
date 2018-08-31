package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;

public class MDD_3159_OLS extends BaseTest{

    @Test
    @TestCaseId("00009")
    @Description("MDD_3159_OLS")
    public void mDD_3159_OLS() {
        String phoneNumberLBP = "AUTAMS1MDD";
        List<String> protocols = Arrays.asList("AXS_05_301");
        String protocol1 = "AXS_05_301";
        String studyName = "a depression";
        String site_Indication = "Major Depressive Disorder (MDD)";
        String siteName = "AUT_MDD_3159";
        String debugSiteName = "";
   //     String env = "STG";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleMDD_3159_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HasHealthcareProfDiagnosedMDDOLS hasHealthcareProfDiagnosedMDDOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfDiagnosedMDDOLS());

        //---------------Q2 hasHealthcareProfDiagnosedMDDOLS-------------------
        hasHealthcareProfDiagnosedMDDOLS
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfDiagnosedMDDOLS.getTitleText(),hasHealthcareProfDiagnosedMDDOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = hasHealthcareProfDiagnosedMDDOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(hasHealthcareProfDiagnosedMDDOLS.titleExpected, protocol1);
        debugPageOLS.back();
        
        AreYouCurrentlyFeelingSadDepressedOLS areYouCurrentlyFeelingSadDepressedOLS = hasHealthcareProfDiagnosedMDDOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyFeelingSadDepressedOLS());

        //---------------Q3 AreYouCurrentlyFeelingSadDepressedOLS-------------------
        areYouCurrentlyFeelingSadDepressedOLS
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyFeelingSadDepressedOLS.getTitleText(),areYouCurrentlyFeelingSadDepressedOLS.titleExpected, "Title is diff");
        //----Skip to Q9 page:HaveYouEverHadElectroconvulsiveTherapyOLS, if selected "NO" in this page 
        HaveYouEverHadElectroconvulsiveTherapyOLS haveYouEverHadElectroconvulsiveTherapyOLS = areYouCurrentlyFeelingSadDepressedOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        haveYouEverHadElectroconvulsiveTherapyOLS
                .waitForPageLoad();                
        debugPageOLS.checkProtocolsContainsForQNumber("QS4815", protocol1);
        debugPageOLS.back();
        areYouCurrentlyFeelingSadDepressedOLS
                .waitForPageLoad();
        
        CurrentEpisodeOfDepressionOLS currentEpisodeOfDepressionOLS = areYouCurrentlyFeelingSadDepressedOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new  CurrentEpisodeOfDepressionOLS());
        
        AnyPrescriptionMedicationOLS anyPrescriptionMedicationOLS = currentEpisodeOfDepressionOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new AnyPrescriptionMedicationOLS());
        
        WhenDidYourCurrentEpisodeDepressionStartOLS whenDidYourCurrentEpisodeDepressionStartOLS = anyPrescriptionMedicationOLS
        		.waitForPageLoad()
                .clickOnAnswer("Correct - Have not taken any prescription medication for current episode")
                .clickNextButton(new WhenDidYourCurrentEpisodeDepressionStartOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4817", protocol1);
        debugPageOLS.back();
        anyPrescriptionMedicationOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Not correct - Have taken prescription medication for current episode")
        		.clickNextButton(new WhenDidYourCurrentEpisodeDepressionStartOLS())
        		.waitForPageLoad();        
       
        HowManyDifferentPrescriptionAntidepresMedsOLS howManyDifferentPrescriptionAntidepresMedsOLS = whenDidYourCurrentEpisodeDepressionStartOLS
        		.waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());
        howManyDifferentPrescriptionAntidepresMedsOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4804", protocol1);
        debugPageOLS.back();
        whenDidYourCurrentEpisodeDepressionStartOLS.waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());
        howManyDifferentPrescriptionAntidepresMedsOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4804", protocol1);
        debugPageOLS.back();
		whenDidYourCurrentEpisodeDepressionStartOLS
				.waitForPageLoad()
				.clickOnAnswer("2 - 3 months ago")
				.clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());        

		//---------------Q5 HowManyDifferentPrescriptionAntidepresMedsOLS-------------------		
		howManyDifferentPrescriptionAntidepresMedsOLS
                .waitForPageLoad();
        Assert.assertEquals(howManyDifferentPrescriptionAntidepresMedsOLS.getTitleText(),howManyDifferentPrescriptionAntidepresMedsOLS.titleExpected, "Title is diff");
        //----Skip to Q9 page:HaveYouEverHadElectroconvulsiveTherapyOLS, if selected "I have not taken any prescription medications for my current episode of depression" in this page 
        		howManyDifferentPrescriptionAntidepresMedsOLS
        		.clickOnAnswer("I have not taken any prescription medications for my current episode of depression")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        haveYouEverHadElectroconvulsiveTherapyOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4805", protocol1);
        debugPageOLS.back();
        howManyDifferentPrescriptionAntidepresMedsOLS
                .waitForPageLoad();
        WhichFollowingAntidepressantMedsTakingOLS whichFollowingAntidepressantMedsTakingOLS = howManyDifferentPrescriptionAntidepresMedsOLS
                .clickOnAnswer("3")
                .clickNextButton(new WhichFollowingAntidepressantMedsTakingOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4805", protocol1);
        debugPageOLS.back();
        howManyDifferentPrescriptionAntidepresMedsOLS
        		.waitForPageLoad()
        		.clickOnAnswer("4 or more")
        		.clickNextButton(new WhichFollowingAntidepressantMedsTakingOLS())
        		.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4805", protocol1);
        debugPageOLS.back();
        howManyDifferentPrescriptionAntidepresMedsOLS
        		.waitForPageLoad()
				.clickOnAnswer("1")
				.clickNextButton(new WhichFollowingAntidepressantMedsTakingOLS());

        
		//---------------Q6 WhichFollowingAntidepressantMedsTakingOLS-------------------		        
        whichFollowingAntidepressantMedsTakingOLS
                .waitForPageLoad();
        Assert.assertEquals(whichFollowingAntidepressantMedsTakingOLS.getTitleText(),whichFollowingAntidepressantMedsTakingOLS.titleExpected, "Title is diff");
        WhichFollowingAntidepressantMedicationsYouTriedOLS whichFollowingAntidepressantMedicationsYouTriedOLS = whichFollowingAntidepressantMedsTakingOLS
                .clickOnAnswers("Wellbutrin (buproprion)")
                .clickNextButton(new WhichFollowingAntidepressantMedicationsYouTriedOLS());

		//---------------Q7 whichFollowingAntidepressantMedicationsYouTriedOLS-------------------		        
        whichFollowingAntidepressantMedicationsYouTriedOLS
                .waitForPageLoad();
        Assert.assertEquals(whichFollowingAntidepressantMedicationsYouTriedOLS.getTitleText(),whichFollowingAntidepressantMedicationsYouTriedOLS.titleExpected, "Title is diff");
        HaveYouEverHadElectroconvulsiveTherapyOLS haveYouEverHadElectroconvulsiveTherapyOLS1 = whichFollowingAntidepressantMedicationsYouTriedOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        haveYouEverHadElectroconvulsiveTherapyOLS
        		.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4808", protocol1);
        debugPageOLS.back();
        whichFollowingAntidepressantMedicationsYouTriedOLS
				.waitForPageLoad()
				.back();
        whichFollowingAntidepressantMedsTakingOLS
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new WhichFollowingAntidepressantMedicationsYouTriedOLS());
        whichFollowingAntidepressantMedicationsYouTriedOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Wellbutrin (buproprion)")
        		.clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS())
        		.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4808", protocol1);
        debugPageOLS.back();
        whichFollowingAntidepressantMedicationsYouTriedOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS())
				.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4808", protocol1);
        debugPageOLS.back();        
        
        whichFollowingAntidepressantMedicationsYouTriedOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Another antidepressant not listed here (such as Remeron, Trintellix, Elavil)")
        		.clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());        
        
		//---------------Q9 Have you ever had electroconvulsive therapy or ECT? "haveYouEverHadElectroconvulsiveTherapyOLS"-------------------	              
        haveYouEverHadElectroconvulsiveTherapyOLS1
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverHadElectroconvulsiveTherapyOLS1.getTitleText(), haveYouEverHadElectroconvulsiveTherapyOLS1.titleExpected, "Title is diff");
        HasHealthcareProfEverDiagnosedMntalHealthOLS hasHealthcareProfEverDiagnosedMntalHealthOLS = haveYouEverHadElectroconvulsiveTherapyOLS1
                .clickOnAnswer("Yes, in the past 6 months")
                .clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthOLS());
        		haveYouEverHadElectroconvulsiveTherapyOLS1.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(haveYouEverHadElectroconvulsiveTherapyOLS1.titleExpected, protocol1)
                .back();
        haveYouEverHadElectroconvulsiveTherapyOLS1
                .waitForPageLoad()
                .clickOnAnswer("Yes, more than 6 months ago")
                .clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthOLS());

		//---------------Q10 Has a healthcare professional ever diagnosed you with any of the following mental health conditions? "HasHealthcareProfEverDiagnosedMntalHealthOLS"-------------------	         
        hasHealthcareProfEverDiagnosedMntalHealthOLS
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfEverDiagnosedMntalHealthOLS.getTitleText(),hasHealthcareProfEverDiagnosedMntalHealthOLS.titleExpected, "Title is diff");
        HaveYouBeenHospitalizedForDepressionOLS haveYouBeenHospitalizedForDepressionOLS = hasHealthcareProfEverDiagnosedMntalHealthOLS
                .clickOnAnswers("Borderline personality disorder")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionOLS());
        haveYouBeenHospitalizedForDepressionOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(hasHealthcareProfEverDiagnosedMntalHealthOLS.titleExpected, protocol1)
                .back();
        hasHealthcareProfEverDiagnosedMntalHealthOLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionOLS());

		//---------------Q11 Have you been hospitalized for depression or any other mental health condition in the past year?-------------------	         
        haveYouBeenHospitalizedForDepressionOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouBeenHospitalizedForDepressionOLS.getTitleText(),haveYouBeenHospitalizedForDepressionOLS.titleExpected, "Title is diff");
        haveYouBeenHospitalizedForDepressionOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Have you been hospitalized for depression or any other mental health condition in the past year? By...", protocol1)
                .back();
        haveYouBeenHospitalizedForDepressionOLS.waitForPageLoad()
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
        //------------- New for AMS1 Rel.51, when Gender = Female-------------------------
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
		//----------SiteSelection Page--------------------
        .waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new HSGeneralPageOLS())
        .waitForPageLoad(site_Indication)
        .clickNextButton(new DoctorInformationCollectionPageOLS())
        .waitForPageLoad()
        .clickNextButton(new HS1PageOLS())
        .waitForPageLoad()
        .clickOkInPopUp()
        .setSignature()
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
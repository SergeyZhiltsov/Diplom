package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
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
    public void tc008Test() {
        String phoneNumberLBP = "AUTAMS1MDD";
        List<String> protocols = Arrays.asList("AXS_05_301");
        String protocol1 = "AXS_05_301";
        String studyName = "a depression";
        String site_Indication = "Major Depressive Disorder (MDD)";
        String siteName = "AUT_MDD_3159";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";
        
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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = hasHealthcareProfDiagnosedMDDOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        hasHealthcareProfessionalPageOLS
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
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Are you currently feeling sad or depressed, or do you currently need treatment for depression?Are yo...", protocol1)
                .back();
        areYouCurrentlyFeelingSadDepressedOLS
                .waitForPageLoad();
        WhenDidYourCurrentEpisodeDepressionStartOLS whenDidYourCurrentEpisodeDepressionStartOLS = areYouCurrentlyFeelingSadDepressedOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDidYourCurrentEpisodeDepressionStartOLS());

        //---------------Q4 WhenDidYourCurrentEpisodeDepressionStartOLS-------------------
        whenDidYourCurrentEpisodeDepressionStartOLS
                .waitForPageLoad();
        Assert.assertEquals(whenDidYourCurrentEpisodeDepressionStartOLS.getTitleText(),whenDidYourCurrentEpisodeDepressionStartOLS.titleExpected, "Title is diff");
        HowManyDifferentPrescriptionAntidepresMedsOLS howManyDifferentPrescriptionAntidepresMedsOLS = whenDidYourCurrentEpisodeDepressionStartOLS
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());
        howManyDifferentPrescriptionAntidepresMedsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whenDidYourCurrentEpisodeDepressionStartOLS.titleExpected, protocol1)
                .back();
        		whenDidYourCurrentEpisodeDepressionStartOLS.waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());
        howManyDifferentPrescriptionAntidepresMedsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whenDidYourCurrentEpisodeDepressionStartOLS.titleExpected, protocol1)
                .back();
				whenDidYourCurrentEpisodeDepressionStartOLS.waitForPageLoad()
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
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(howManyDifferentPrescriptionAntidepresMedsOLS.titleExpected, protocol1)
                .back();
        howManyDifferentPrescriptionAntidepresMedsOLS
                .waitForPageLoad();
        WhichFollowingAntidepressantMedsTakingOLS whichFollowingAntidepressantMedsTakingOLS = howManyDifferentPrescriptionAntidepresMedsOLS
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
        .waitForPageLoad()
        .getPage(debugPageOLS)
        .checkProtocolsEquals("Ghost Question - Buproprion Monotherapy for Current Episode", protocol1)
        .back();
        whichFollowingAntidepressantMedicationsYouTriedOLS
        .waitForPageLoad()
        .clickOnAnswers("Another antidepressant not listed here")
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
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        hasHealthcareProfessionalPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Have you been hospitalized for depression or any other mental health condition in the past year? By...", protocol1)
                .back();
        haveYouBeenHospitalizedForDepressionOLS.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
       

        //GENERAL HEALTH Questions----------------------
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
                .clickNextButton(new SmokedCigarettesPageOLS()) //additional question for MDD--
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
                .clickOnAnswer("No")
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
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(site_Indication)
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
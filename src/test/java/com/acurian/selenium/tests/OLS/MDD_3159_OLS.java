package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.PregnancyAndFertilityPage;
import com.acurian.selenium.pages.OLS.MDD_3159.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class MDD_3159_OLS extends BaseTest {

    @Test(enabled = false)
    @Description("MDD_3159_OLS")
    public void mdd_3159_OLS() {
        String phoneNumber = "AUTAMS1MDD";
        List<String> protocols = Arrays.asList("AXS_05_301");
        String protocol1 = "AXS_05_301";
        String studyName = "a depression";
        String site_Indication = "Major Depressive Disorder (MDD)";
        String siteName = "AUT_MDD_3159";
        String debugSiteName = "";
        String zipCode = "19044";

        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleMDD_3159_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
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
        Assert.assertEquals(hasHealthcareProfDiagnosedMDDOLS.getTitleText(), hasHealthcareProfDiagnosedMDDOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = hasHealthcareProfDiagnosedMDDOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4802", protocol1);
        debugPageOLS.back();
        AreYouCurrentlyFeelingSadDepressedOLS areYouCurrentlyFeelingSadDepressedOLS = hasHealthcareProfDiagnosedMDDOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyFeelingSadDepressedOLS());
        

        //---------------Q3 AreYouCurrentlyFeelingSadDepressedOLS-------------------
        areYouCurrentlyFeelingSadDepressedOLS
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyFeelingSadDepressedOLS.getTitleText(), areYouCurrentlyFeelingSadDepressedOLS.titleExpected, "Title is diff");
        //----Skip to Q9 page:HaveYouEverHadElectroconOLSvulsiveTherapyOLS, if selected "NO" in this page 
        HaveYouEverHadElectroconvulsiveTherapyOLS haveYouEverHadElectroconvulsiveTherapyOLS = areYouCurrentlyFeelingSadDepressedOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        haveYouEverHadElectroconvulsiveTherapyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4820", protocol1)
                .back();
        CurrentEpisodeOfDepressionOLS currentEpisodeOfDepressionOLS = areYouCurrentlyFeelingSadDepressedOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentEpisodeOfDepressionOLS());
        
        
        //-------------------Q4 -When did your current episode of depression start?----------------
        HowManyDifferentPrescriptionAntidepresMedsOLS howManyDifferentPrescriptionAntidepresMedsOLS= currentEpisodeOfDepressionOLS
                .waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());
        		howManyDifferentPrescriptionAntidepresMedsOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4804", protocol1)
        		.back();
        currentEpisodeOfDepressionOLS
        		.waitForPageLoad()
        		.clickOnAnswer("1 month ago or less")
        		.clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());
        		howManyDifferentPrescriptionAntidepresMedsOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4804", protocol1)
				.back();
        currentEpisodeOfDepressionOLS
        		.waitForPageLoad()
        		.clickOnAnswer("2 - 3 months ago")
        		.clickOnAnswer("4 - 6 months ago")       		
        		.clickOnAnswer("7 - 11 months ago")
        		.clickOnAnswer("1 1/2 - 2 years ago")
        		.clickOnAnswer("About 1 year ago")
        		.clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsOLS());
        
        
        //-------------------Q5-HowManyDifferentPrescriptionAntidepresMedsOLS----------------     
        howManyDifferentPrescriptionAntidepresMedsOLS
        		.waitForPageLoad()
                .clickOnAnswer("I have not taken any prescription medications for my current episode of depression")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        		haveYouEverHadElectroconvulsiveTherapyOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4805", protocol1)
        		.back();
        howManyDifferentPrescriptionAntidepresMedsOLS
        		.waitForPageLoad();
        WhichOfTheFollowingPrescriptionMedications_OLS whichOfTheFollowingPrescriptionMedications_OLS= howManyDifferentPrescriptionAntidepresMedsOLS
        		.clickOnAnswer("1")
        		.clickOnAnswer("3")
        		.clickOnAnswer("4 or more")
        		.clickNextButton(new WhichOfTheFollowingPrescriptionMedications_OLS());
        whichOfTheFollowingPrescriptionMedications_OLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4805", protocol1)
				.back();
        howManyDifferentPrescriptionAntidepresMedsOLS
        		.waitForPageLoad()
        		.clickOnAnswer("2")
        		.clickNextButton(new WhichOfTheFollowingPrescriptionMedications_OLS());        
        
        
        //--------------------Q6 - WhichOfTheFollowingPrescriptionMedications_OLS----------------     
        whichOfTheFollowingPrescriptionMedications_OLS
        		.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        		haveYouEverHadElectroconvulsiveTherapyOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4808", protocol1)
        		.back();
        whichOfTheFollowingPrescriptionMedications_OLS
        		.waitForPageLoad();
        		SubquestionWhenDidYouTakeFollowingMeds_OLS subquestionWhenDidYouTakeFollowingMeds_OLS= whichOfTheFollowingPrescriptionMedications_OLS
        		.clickOnAnswers("Celexa (citalopram)")
        		.clickOnAnswers("Cymbalta (duloxetine)") 
        		.clickOnAnswers("Effexor (venlafaxine)") 
        		.clickOnAnswers("Fetzima (levomilnacipran)")
        		.clickOnAnswers("Another antidepressant not listed")
        		.clickNextButton(new SubquestionWhenDidYouTakeFollowingMeds_OLS());
        
        
       //---------------------Q7 SubquestionWhenDidYouTakeFollowingMeds_OLS-------------------- 
        subquestionWhenDidYouTakeFollowingMeds_OLS
        		.waitForPageLoad(1, subquestionWhenDidYouTakeFollowingMeds_OLS.titleExpected1)
        		.waitForPageLoad(2, subquestionWhenDidYouTakeFollowingMeds_OLS.titleExpected2)
        		.waitForPageLoad(3, subquestionWhenDidYouTakeFollowingMeds_OLS.titleExpected3)
        		.waitForPageLoad(4, subquestionWhenDidYouTakeFollowingMeds_OLS.titleExpected4)
        		.waitForPageLoad(5, subquestionWhenDidYouTakeFollowingMeds_OLS.titleExpected5)
        		.clickOnAnswerForSubQuestion(1, "Took in the past for a different episode of depression")
        		.clickOnAnswerForSubQuestion(2, "Took in the past for a different episode of depression")        		
        		.clickOnAnswerForSubQuestion(3, "Took in the past for a different episode of depression")       		
        		.clickOnAnswerForSubQuestion(4, "Took in the past for a different episode of depression")
        		.clickOnAnswerForSubQuestion(5, "Took in the past for a different episode of depression")
        		.clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        haveYouEverHadElectroconvulsiveTherapyOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4808", protocol1)  //disqualifies both 3159, 4850 protocols
				.back();
        subquestionWhenDidYouTakeFollowingMeds_OLS
        		.waitForPageLoad(1, subquestionWhenDidYouTakeFollowingMeds_OLS.titleExpected1)		
        		.clickOnAnswerForSubQuestion(1, "Tried for current episode but stopped taking") //Select "Currently taking" to qualify for 4850
        		.clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyOLS());
        
        		
        		
        //-------------------Q9 HaveYouEverHadElectroconvulsiveTherapyOLS----------------     
        haveYouEverHadElectroconvulsiveTherapyOLS
        		.waitForPageLoad();
        HasHealthcareProfEverDiagnosedMntalHealthOLS hasHealthcareProfEverDiagnosedMntalHealthOLS = haveYouEverHadElectroconvulsiveTherapyOLS
                .clickOnAnswer("No")
        		.clickOnAnswer("Yes, in the past 6 months")
                .clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthOLS());
        		hasHealthcareProfEverDiagnosedMntalHealthOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4809", protocol1)
        		.back();
        haveYouEverHadElectroconvulsiveTherapyOLS
        		.waitForPageLoad()
                .clickOnAnswer("Yes, more than 6 months ago")   //Select "No" to qualify for 4840
        		.clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthOLS());
       
        

        //---------------Q10 Has a healthcare professional ever diagnosed you with any of the following mental health conditions? "HasHealthcareProfEverDiagnosedMntalHealthOLS"-------------------
        hasHealthcareProfEverDiagnosedMntalHealthOLS
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfEverDiagnosedMntalHealthOLS.getTitleText(), hasHealthcareProfEverDiagnosedMntalHealthOLS.titleExpected, "Title is diff");
        HaveYouBeenHospitalizedForDepressionOLS haveYouBeenHospitalizedForDepressionOLS = hasHealthcareProfEverDiagnosedMntalHealthOLS
                .clickOnAnswers("Anorexia") 
                .clickOnAnswers("Bulimia")
                .clickOnAnswers("Obsessive-compulsive disorder (OCD)")
                .clickOnAnswers("Panic disorder") 
                .clickOnAnswers("Psychosis")
                .clickOnAnswers("Antisocial personality disorder") 
                .clickOnAnswers("Borderline personality disorder")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionOLS());
        haveYouBeenHospitalizedForDepressionOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4810", protocol1)
                .back();
        hasHealthcareProfEverDiagnosedMntalHealthOLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionOLS());
        
        
        
        //---------------Q11 Have you been hospitalized for depression or any other mental health condition in the past year?-------------------
        haveYouBeenHospitalizedForDepressionOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouBeenHospitalizedForDepressionOLS.getTitleText(), haveYouBeenHospitalizedForDepressionOLS.titleExpected, "Title is diff");
        PregnancyAndFertilityPage pregnancyAndFertilityOLS = haveYouBeenHospitalizedForDepressionOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new PregnancyAndFertilityPage());
        debugPageOLS.checkProtocolsContainsForQNumber("QS4811", protocol1);
        debugPageOLS.back();
        haveYouBeenHospitalizedForDepressionOLS
        		.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PregnancyAndFertilityPage());
        

        //---------------Q12 PregnancyAndFertilityOLS-------------------
        pregnancyAndFertilityOLS
                .waitForPageLoad();
        Assert.assertEquals(pregnancyAndFertilityOLS.getTitleText(), pregnancyAndFertilityOLS.titleExpected, "Title is diff");
        pregnancyAndFertilityOLS
        		.clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionOLS());
        haveYouBeenHospitalizedForDepressionOLS
        		.waitForPageLoad()
        		//debugPageOLS.checkProtocolsContainsForQNumber("Q0013673-QS4823-STUDYQUES", protocol1); //DQ for 4840
        		.back();
        pregnancyAndFertilityOLS
        		.waitForPageLoad()
                .clickOnAnswers("I have gone through menopause - my last menstrual period was 1 year ago or longer") 
                .clickOnAnswers("I currently have my \"tubes tied\" (also called bilateral tubal ligation, a sterilization procedure)")
                .clickOnAnswers("I have had both ovaries surgically removed (bilateral oophorectomy) and/or my uterus surgically removed (hysterectomy)")
                .clickOnAnswers("I am unable to become pregnant due to another medical condition")
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
//        .clickNextButton(new ChildrenUnderPageOLS())
//		//----------ChildrenUnderTheAge Page--------------------
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
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
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
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
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/

		ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
		thankYouCloseSimplePageOLS
				.waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
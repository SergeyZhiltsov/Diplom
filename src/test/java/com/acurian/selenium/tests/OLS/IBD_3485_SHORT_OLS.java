package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.*;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.WhenWereYouDiagnosedWithUlcerativeColitisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class IBD_3485_SHORT_OLS extends BaseTest{

    @Test(enabled = false)//rel 60 disable
    @TestCaseId("00016")
    @Description("IBD_3485_SHORT_OLS")
    public void IBD_3485_SHORT_OLS_Screener() {
        String phoneNumber = "AUTAMSCRSH";  //This phone nubmer has Referral Service = '3485SHORT' set in GEMBA
        String protocol1 = "I6T_MC_AMAG";
        String protocol2 = "RF_I6T_MC_AMAG";
        String studyName = "a Crohn's";
        String indication = "a Crohn's Disease";
        String siteName = "AUT_CRN_3889_HS";
        String zipCode = "19044";   //19901 for IBD-UC modules
        
        String env = System.getProperty("acurian.env", "STG");
        
        //---------------Date of Birth Question-------------------
		DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumber)		           
		           .waitForPageLoad()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleCrohns_3485_Expected, "Title is diff");
        
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
        //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
        		.setDate("09092001")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
        	.waitForPageLoad();
			DebugPageOLS debugPageOLS = new DebugPageOLS();
			lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
			.checkProtocolsContainsForQNumber("QSI8004", protocol1,protocol2)
			.back();
	    //------------Disqualify (“Age”) if >= 76 years -----------------------------------------
	     dateOfBirthPageOLS
	     	.waitForPageLoad();
	     	PersonalDetails personalDetails = dateOfBirthPageOLS
    		.setDate("09091941")
            .clickNextButton(new PersonalDetails());
	     	personalDetails
	     	.waitForPageLoad()
	     	.getPage(debugPageOLS)
	     	.checkProtocolsContainsForQNumber("QSI8004", protocol1,protocol2)
	     	.back();
		 dateOfBirthPageOLS
			.waitForPageLoad()
            .setDate("09091980")
            .clickNextButton(new PersonalDetails());

	    //---------------PII Page Question-------------------
		GenderPageOLS genderPageOLS = personalDetails
					   .waitForPageLoad()
					   .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
					   .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS());
	        
	        
        //---------------Q2 Have you ever been officially diagnosed by a doctor with any of the following digestive conditions?  page-------------------
        haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS.getTitleText(),haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS.titleExpected, "Title is diff");
        WhenWereYouDiagnosedWithUlcerativeColitisPageOLS whenWereYouDiagnosedWithUlcerativeColitisPageOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
        .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenWereYouDiagnosedWithUlcerativeColitisPageOLS());
        whenWereYouDiagnosedWithUlcerativeColitisPageOLS
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS5702", protocol1,protocol2);
        		debugPageOLS.back();
        		haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS.waitForPageLoad();
        		WhenWereYouDiagnosedWithCrohnsPageOLS whenWereYouDiagnosedWithCrohnsPageOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
        		.clickOnAnswers("Ulcerative colitis","Crohn's disease") //UnCheck UC and Check Crohn's only
                .clickNextButton(new WhenWereYouDiagnosedWithCrohnsPageOLS());
        		

        //---------------Q3 When were you diagnosed with Crohn's disease? -------------------
        whenWereYouDiagnosedWithCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whenWereYouDiagnosedWithCrohnsPageOLS.getTitleText(), whenWereYouDiagnosedWithCrohnsPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = whenWereYouDiagnosedWithCrohnsPageOLS
                .clickOnAnswer("Not officially diagnosed with Crohn's by a doctor")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS5703", protocol1,protocol2);
        		debugPageOLS.back();
        		whenWereYouDiagnosedWithCrohnsPageOLS.waitForPageLoad();
        		ManageYourCrohnsPageOLS manageYourCrohnsPageOLS = whenWereYouDiagnosedWithCrohnsPageOLS
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(new ManageYourCrohnsPageOLS());

       
        //------------If Patient's tracking/phone # is on for this Referral Service Code: "3485 SHORT", Skip to Q6------------
		//---------------Q6 ManageYourCrohnsPageOLS page-------------------
        manageYourCrohnsPageOLS
        	.waitForPageLoad();
        Assert.assertEquals(manageYourCrohnsPageOLS.getTitleText(), manageYourCrohnsPageOLS.titleExpected, "Title is diff");
        //-------------If selected 'NO', disqualify and SKIP to Q14, otherwise goto Q7	
        AreYouCurrentlyExperiencingFlareUp_OLS areYouCurrentlyExperiencingFlareUp_OLS = manageYourCrohnsPageOLS
        		.clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());
        		areYouCurrentlyExperiencingFlareUp_OLS
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS5706", protocol1,protocol2);
        		debugPageOLS.back();
        		manageYourCrohnsPageOLS.waitForPageLoad();
        		SteroidMedicationsForCrohnsOLS steroidMedicationsForCrohnsOLS = manageYourCrohnsPageOLS
        		.clickOnAnswer("Yes")
        		.clickNextButton(new SteroidMedicationsForCrohnsOLS());

        
		//---------------Q7 Have you ever taken steroid medications for your Crohn's or colitis?--------------------------------------------
        steroidMedicationsForCrohnsOLS
                .waitForPageLoad();
        Assert.assertEquals(steroidMedicationsForCrohnsOLS.getTitleText(), steroidMedicationsForCrohnsOLS.titleExpected, "Title is diff");
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = steroidMedicationsForCrohnsOLS
        		//If Patient's tracking/phone # is on for this Referral Service Code: "3485 SHORT", skip to Q10 (biologics)
        		.clickOnAnswer("Yes")
                .clickNextButton(new BiologicMedicationsPageOLS());
		        

		
		//---------------Q10 Have you ever received any of the following "biologic" medications? page------------------
		biologicMedicationsPageOLS
				.waitForPageLoad();
		Assert.assertEquals(biologicMedicationsPageOLS.getTitleText(),biologicMedicationsPageOLS.titleExpected, "Title is diff");
		biologicMedicationsPageOLS.clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)",
				"Benlysta",
				"Cimzia",
				"Cosentyx",
				"Enbrel",
				"Entyvio",
				"Humira",
				"Kineret",
				"Orencia",
				"Prolia or Xgeva",
				"Raptiva",
				"Remicade",
				"Rituxan",
				"Simponi",
				"Stelara",
				"Taltz",
				"Tysabri")
        .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());
		areYouCurrentlyExperiencingFlareUp_OLS.waitForPageLoad()
        .getPage(debugPageOLS)
        .checkProtocolsContainsForQNumber("QS5710", protocol1, protocol2)
        .back();
		biologicMedicationsPageOLS
        .waitForPageLoad();
		HaveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS haveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS = biologicMedicationsPageOLS
        .clickOnAnswers("Tysabri")  //Dont Uncheck "Stelara (Agent Note: ste-LAHR-uh)" option to qualify
        .clickNextButton(new HaveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS());
		
		
		//------Q12	Have you ever taken any other prescription medicines to treat or manage your Crohn’s or colitis?
		haveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS
        .waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());

		
		//---------------Q14 Are you currently experiencing a flare-up? page------------------
		areYouCurrentlyExperiencingFlareUp_OLS
				.waitForPageLoad();
		Assert.assertEquals(areYouCurrentlyExperiencingFlareUp_OLS.getTitleText(),areYouCurrentlyExperiencingFlareUp_OLS.titleExpected, "Title is diff");
		areYouCurrentlyExperiencingFlareUp_OLS.clickOnAnswer("Yes, I am currently in a flare with my Crohn's or colitis")
//        .clickNextButton(new ChildrenUnderPageOLS())
//
//
//		//----------ChildrenUnderTheAge Page--------------------
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//
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
		.waitForPageLoad();
        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS()
		.clickNextButton(new SiteSelectionPageOLS());
        
		//----------SiteSelection Page--------------------
        siteSelectionPageOLS.waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new QualifiedClose_OLS())
        .waitForPageLoad(indication)
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
    }
}
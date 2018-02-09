package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.UF_4384.HaveYouHadSurgicalProcedurePast6MonthsUF_OLS;
import com.acurian.selenium.pages.OLS.UF_4384.HowWouldYouDescribeAvgPeriodUF_OLS;
import com.acurian.selenium.pages.OLS.UF_4384.WhichOfFollowingDoYouTypicallyExperienceUF_OLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class UF_4384_OLS extends BaseTest{

	@Test
    @TestCaseId("00022")
    @Description("UF_4384_OLS")
    public void uf4384olsTest() {
        String phoneNumber = "AUTAMS1UF1";
        String protocol1 = "MVT_601_3001";
		String protocol2 = "MVT_601_3002";
        String studyName = "a uterine fibroids";
        String studyName1 = "uterine fibroids"; 
        String site_Indication = "Uterine Fibroids";
        String siteName = "AUT_UF_4384";
    //    String env = "STG";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        
        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleUF_4384_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
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
        //DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = genderPageOLS
        FollowingGynecologicalConditionOLS followingGynecologicalConditionOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionOLS());

        //---------------Q2 Has a healthcare professional ever diagnosed you with any of the following gynecological or women's health conditions? -------------------
        followingGynecologicalConditionOLS
                .waitForPageLoad();
        Assert.assertEquals(followingGynecologicalConditionOLS.getTitleText(),followingGynecologicalConditionOLS.titleExpected, "Title is diff");
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = followingGynecologicalConditionOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageCC = new DebugPageOLS();
        debugPageCC.checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of the following gynecological or women's ...", protocol1,protocol2);
        debugPageCC.back();
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Uterine fibroids, also known as leiomyomas or myomas")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());

        //---------------Q3 Have you gone through menopause?-------------------
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouGoneThroughMenopauseOLS.getTitleText(),haveYouGoneThroughMenopauseOLS.titleExpected, "Title is diff");
        //----DQ if selected any option other than None of the above-----------
        HaveYouHadHysterectomyOLS haveYouHadHysterectomyOLS = haveYouGoneThroughMenopauseOLS
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
                .back();
        	haveYouGoneThroughMenopauseOLS
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
        		.clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
        		.back();        
        	haveYouGoneThroughMenopauseOLS
				.waitForPageLoad()
				.clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
				.clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouGoneThroughMenopauseOLS
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
				.back();          
        	haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouHadHysterectomyOLS());

        		
        //---------------Q4 Have you had a hysterectomy (surgical removal of the uterus)?-------------------
        haveYouHadHysterectomyOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouHadHysterectomyOLS.getTitleText(),haveYouHadHysterectomyOLS.titleExpected, "Title is diff");
        		haveYouHadHysterectomyOLS.clickOnAnswer("Yes")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
                hasHealthcareProfessionalPageOLS
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(haveYouHadHysterectomyOLS.titleExpected, protocol1, protocol2)
                .back();
        haveYouHadHysterectomyOLS.waitForPageLoad();
        HaveRegularMenstrualCyclesOLS haveRegularMenstrualCyclesOLS = haveYouHadHysterectomyOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveRegularMenstrualCyclesOLS());
        
        

		//---------------Q5 Do you have regular menstrual cycles, meaning that you get your period each month on a predictable schedule?-------------------		
        haveRegularMenstrualCyclesOLS
                .waitForPageLoad();
        Assert.assertEquals(haveRegularMenstrualCyclesOLS.getTitleText(),haveRegularMenstrualCyclesOLS.titleExpected, "Title is diff");
        		HowWouldYouDescribeAvgPeriodUF_OLS howWouldYouDescribeAvgPeriodUF_OLS = haveRegularMenstrualCyclesOLS
        		.clickOnAnswer("No")
                .clickNextButton(new HowWouldYouDescribeAvgPeriodUF_OLS());
        		howWouldYouDescribeAvgPeriodUF_OLS
                .waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals("Do you have regular menstrual cycles, meaning that you get your period each month on a predictable s...", protocol1, protocol2)
                .back();
        haveRegularMenstrualCyclesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowWouldYouDescribeAvgPeriodUF_OLS());

        
		//---------------Q6 How would you describe the average flow of your period?-------------------		        
        howWouldYouDescribeAvgPeriodUF_OLS
                .waitForPageLoad();
        Assert.assertEquals(howWouldYouDescribeAvgPeriodUF_OLS.getTitleText(),howWouldYouDescribeAvgPeriodUF_OLS.titleExpected, "Title is diff");
        WhichOfFollowingDoYouTypicallyExperienceUF_OLS whichOfFollowingDoYouTypicallyExperienceUF_OLS = howWouldYouDescribeAvgPeriodUF_OLS
                .clickOnAnswer("Very light")
                .clickNextButton(new WhichOfFollowingDoYouTypicallyExperienceUF_OLS());
        		whichOfFollowingDoYouTypicallyExperienceUF_OLS
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsEquals(howWouldYouDescribeAvgPeriodUF_OLS.titleExpected, protocol1, protocol2)
				.back();
        howWouldYouDescribeAvgPeriodUF_OLS
        .waitForPageLoad()
        .clickOnAnswer("Very heavy")
        .clickNextButton(new WhichOfFollowingDoYouTypicallyExperienceUF_OLS());       

		
		//---------------Q7 Which of the following do you typically experience during your period? -------------------		        
        whichOfFollowingDoYouTypicallyExperienceUF_OLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfFollowingDoYouTypicallyExperienceUF_OLS.getTitleText(),whichOfFollowingDoYouTypicallyExperienceUF_OLS.titleExpected, "Title is diff");
        HaveYouHadSurgicalProcedurePast6MonthsUF_OLS haveYouHadSurgicalProcedurePast6MonthsUF_OLS = whichOfFollowingDoYouTypicallyExperienceUF_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouHadSurgicalProcedurePast6MonthsUF_OLS());
        		haveYouHadSurgicalProcedurePast6MonthsUF_OLS
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsEquals("Heavy menstrual bleeding often affects a woman's quality of life.Which of the following do you typic...", protocol1,protocol2)
        		.back();
        whichOfFollowingDoYouTypicallyExperienceUF_OLS
        .waitForPageLoad()
        .clickOnAnswers("Missing work, school, or social activities")
        .clickNextButton(new HaveYouHadSurgicalProcedurePast6MonthsUF_OLS());        
        
        
		//---------------Q8 Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?-------------------	              
        haveYouHadSurgicalProcedurePast6MonthsUF_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouHadSurgicalProcedurePast6MonthsUF_OLS.getTitleText(), haveYouHadSurgicalProcedurePast6MonthsUF_OLS.titleExpected, "Title is diff");
        DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = haveYouHadSurgicalProcedurePast6MonthsUF_OLS
        		 .clickOnAnswer("Yes")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());
        diagnosedWithGynecologicalConditionOLS.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?This surgery m...", protocol1, protocol2)
                .back();
        haveYouHadSurgicalProcedurePast6MonthsUF_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());

        
		//---------------Q9 Has a healthcare professional ever diagnosed you with any of these other gynecological or women's health conditions? -------------------	         
        diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedWithGynecologicalConditionOLS.getTitleText(),diagnosedWithGynecologicalConditionOLS.titleExpected, "Title is diff");
        		AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = diagnosedWithGynecologicalConditionOLS
                .clickOnAnswers("Uterine polyps, also known as endometrial polyps",
                		        "Cervical polyps",
                		        "Ovarian cyst that is currently causing symptoms",
                		        "Endometrioma, also known as endometrial or endometrioid cyst or \"chocolate cyst\"")
                .clickNextButton(new AreYouCurrentlyPregnantOLS());
        		areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of these other gynecological or women's he...", protocol1, protocol2)
                .back();
        		diagnosedWithGynecologicalConditionOLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyPregnantOLS());

        
		//---------------Q10 Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?------------------	         
        areYouCurrentlyPregnantOLS
                .waitForPageLoad();
        		Assert.assertEquals(areYouCurrentlyPregnantOLS.getTitleText(),areYouCurrentlyPregnantOLS.titleExpected, "Title is diff");
        		//HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = areYouCurrentlyPregnantUF_CC
        		areYouCurrentlyPregnantOLS.clickOnAnswer("Yes")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        		debugPageCC.checkProtocolsEquals(areYouCurrentlyPregnantOLS.titleExpected, protocol1, protocol2);
        		debugPageCC.back();
        areYouCurrentlyPregnantOLS.waitForPageLoad()
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
                .clickOnAnswer("Public transportation")
//                .clickNextButton(new WouldYouUsePageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Neither")
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
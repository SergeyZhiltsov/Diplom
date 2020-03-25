package com.acurian.selenium.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.END_4385.PlzDescribeYourMenstrualCyclesCC;
import com.acurian.selenium.pages.CC.UF_4384.HaveYouHadSurgicalProcedurePast6MonthsUF_CC;
import com.acurian.selenium.pages.CC.UF_4384.HowWouldYouDescribeAvgPeriodUF_CC;
import com.acurian.selenium.pages.CC.UF_4384.WhichOfFollowingDoYouTypicallyExperienceUF_CC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.List;


public class UF_4384_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
    @Description("UF_4384_CC")
    public void uf_4384_CC(final String username, final String password) {
        String phoneNumber = "AUTAMS1UF1";
        List<String> protocols = Arrays.asList("MVT_601_3001","MVT_601_3002");
        String protocol1 = "MVT_601_3001";
		String protocol2 = "MVT_601_3002";
        String studyName = "a uterine fibroids study";
        String studyName1 = "uterine fibroids"; 
        String studyIndication = "Uterine Fibroids";
        String siteName = "AUT_UF_4384";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
 
//        dateOfBirthPageCC
//                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedUF_4384, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        FollowingGynecologicalConditionСС followingGynecologicalConditionСС = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionСС());

        //---------------Q2 Has a healthcare professional ever diagnosed you with any of the following gynecological or women's health conditions? -------------------
        followingGynecologicalConditionСС
                .waitForPageLoad();
        Assert.assertEquals(followingGynecologicalConditionСС.getTitleText(), followingGynecologicalConditionСС.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = followingGynecologicalConditionСС
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of the following women's health conditions...", protocol1,protocol2);
        debugPageCC.back();
        HaveYouGoneThroughMenopauseCC haveYouGoneThroughMenopause_CC = followingGynecologicalConditionСС
                .waitForPageLoad()
                .clickOnAnswers("Endometriosis (Agent Note: end-oh-me-tree-OH-sis)","None of the above") //Check this on screener
                .clickOnAnswers("Uterine fibroids, also known as leiomyomas or myomas (Agent Note: lie-oh-my-OH-muhs, my-OH-muhs)")
                .clickNextButton(new HaveYouGoneThroughMenopauseCC());

        //---------------Q3 Have you gone through menopause?-------------------
        haveYouGoneThroughMenopause_CC
                .waitForPageLoad();
        Assert.assertEquals(haveYouGoneThroughMenopause_CC.getTitleText(), haveYouGoneThroughMenopause_CC.titleExpected, "Title is diff");
        //----DQ if selected any option other than None of the above-----------
        HaveYouHadHysterectomyСС haveYouHadHysterectomyСС = haveYouGoneThroughMenopause_CC
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyСС());
        haveYouHadHysterectomyСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
                .back();
        		haveYouGoneThroughMenopause_CC
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
        		.clickNextButton(new HaveYouHadHysterectomyСС());
        haveYouHadHysterectomyСС
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
        		.back();        
				haveYouGoneThroughMenopause_CC
				.waitForPageLoad()
				.clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
				.clickNextButton(new HaveYouHadHysterectomyСС());
		haveYouHadHysterectomyСС
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
				.back();          
        		haveYouGoneThroughMenopause_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouHadHysterectomyСС());

        //---------------Q4 Have you had a hysterectomy (surgical removal of the uterus)?-------------------
        haveYouHadHysterectomyСС
                .waitForPageLoad();
        Assert.assertEquals(haveYouHadHysterectomyСС.getTitleText(), haveYouHadHysterectomyСС.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC1 = haveYouHadHysterectomyСС
                .clickOnAnswer("Yes")
                .clickNextButton(new NonQRtransitionPageCC());
        		nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(haveYouHadHysterectomyСС.titleExpected, protocol1, protocol2)
                .back();
        haveYouHadHysterectomyСС.waitForPageLoad();
        PlzDescribeYourMenstrualCyclesCC plzDescribeYourMenstrualCyclesCC = haveYouHadHysterectomyСС
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesCC());
        

		//---------------Q5 - Please describe your menstrual cycles: -------------------		
        plzDescribeYourMenstrualCyclesCC
                .waitForPageLoad();
        Assert.assertEquals(plzDescribeYourMenstrualCyclesCC.getTitleText(),plzDescribeYourMenstrualCyclesCC.titleExpected, "Title is diff");
        		HowWouldYouDescribeAvgPeriodUF_CC howWouldYouDescribeAvgPeriodUF_CC = plzDescribeYourMenstrualCyclesCC
        		.clickOnAnswer("Never regular")
                .clickNextButton(new HowWouldYouDescribeAvgPeriodUF_CC());
        		howWouldYouDescribeAvgPeriodUF_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Please describe your menstrual cycles:", protocol1, protocol2)
                .back();
        		plzDescribeYourMenstrualCyclesCC
                .waitForPageLoad()
                .clickOnAnswer("Always regular")
                .clickNextButton(new HowWouldYouDescribeAvgPeriodUF_CC());

        
		//---------------Q6 How would you describe the average flow of your period?-------------------		        
        howWouldYouDescribeAvgPeriodUF_CC
                .waitForPageLoad();
        Assert.assertEquals(howWouldYouDescribeAvgPeriodUF_CC.getTitleText(),howWouldYouDescribeAvgPeriodUF_CC.titleExpected, "Title is diff");
        WhichOfFollowingDoYouTypicallyExperienceUF_CC whichOfFollowingDoYouTypicallyExperienceUF_CC = howWouldYouDescribeAvgPeriodUF_CC
                .clickOnAnswer("Very light")
                .clickNextButton(new WhichOfFollowingDoYouTypicallyExperienceUF_CC());
        		whichOfFollowingDoYouTypicallyExperienceUF_CC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsEquals(howWouldYouDescribeAvgPeriodUF_CC.titleExpected, protocol1, protocol2)
				.back();
		howWouldYouDescribeAvgPeriodUF_CC
        .waitForPageLoad()
        .clickOnAnswer("Very heavy")
        .clickNextButton(new WhichOfFollowingDoYouTypicallyExperienceUF_CC());       

		//---------------Q7 Which of the following do you typically experience during your period? -------------------		        
		whichOfFollowingDoYouTypicallyExperienceUF_CC
                .waitForPageLoad();
        Assert.assertEquals(whichOfFollowingDoYouTypicallyExperienceUF_CC.getTitleText(),whichOfFollowingDoYouTypicallyExperienceUF_CC.titleExpected, "Title is diff");
        HaveYouHadSurgicalProcedurePast6MonthsUF_CC haveYouHadSurgicalProcedurePast6MonthsUF_CC = whichOfFollowingDoYouTypicallyExperienceUF_CC
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouHadSurgicalProcedurePast6MonthsUF_CC());
        		haveYouHadSurgicalProcedurePast6MonthsUF_CC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsEquals("Heavy menstrual bleeding often affects a woman's quality of life.Which of the following do you typic...", protocol1,protocol2)
        		.back();
        whichOfFollowingDoYouTypicallyExperienceUF_CC
        .waitForPageLoad()
        .clickOnAnswers("Missing work, school, or social activities")
        .clickNextButton(new HaveYouHadSurgicalProcedurePast6MonthsUF_CC());        
        
		//---------------Q8 Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?-------------------	              
        haveYouHadSurgicalProcedurePast6MonthsUF_CC
                .waitForPageLoad();
        Assert.assertEquals(haveYouHadSurgicalProcedurePast6MonthsUF_CC.getTitleText(), haveYouHadSurgicalProcedurePast6MonthsUF_CC.titleExpected, "Title is diff");
        DiagnosedWithGynecologicalConditionCC diagnosedWithGynecologicalConditionCC = haveYouHadSurgicalProcedurePast6MonthsUF_CC
                .clickOnAnswer("Yes")
                .clickNextButton(new DiagnosedWithGynecologicalConditionCC());
        diagnosedWithGynecologicalConditionCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?This surgery m...", protocol1, protocol2)
                .back();
        haveYouHadSurgicalProcedurePast6MonthsUF_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionCC());

		//---------------Q9 Has a healthcare professional ever diagnosed you with any of these other women's health conditions? -------------------	         
        diagnosedWithGynecologicalConditionCC
                .waitForPageLoad();
        Assert.assertEquals(diagnosedWithGynecologicalConditionCC.getTitleText(), diagnosedWithGynecologicalConditionCC.titleExpected, "Title is diff");
        		AreYouCurrentlyPregnantUF_CC areYouCurrentlyPregnantUF_CC = diagnosedWithGynecologicalConditionCC
                .clickOnAnswers("Uterine polyps, also known as endometrial polyps (Agent Note: end-oh-ME-tree-ul PAHL-ips)",
                		        "Cervical polyps (Agent Note: PAHL-ips)",
                		        "Ovarian cyst that is currently causing symptoms",
                		        "Endometrioma,(Agent Note: end-oh-me-tree-OH-ma) also known as endometrial(Agent Note: end-oh-ME-tree-ul) or endometrioid(Agent Note: endo-oh-ME-tree-oid) cyst or \"chocolate cyst\"",
                		        "Vaginismus  (Agent Note: vaj-ih-NISS-miss)")
                .clickNextButton(new AreYouCurrentlyPregnantUF_CC());
        		areYouCurrentlyPregnantUF_CC
                .waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of these other gynecological or women's he...", protocol1, protocol2)
                .back();
        diagnosedWithGynecologicalConditionCC.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyPregnantUF_CC());

		//---------------Q10 Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?------------------	         
        areYouCurrentlyPregnantUF_CC
                .waitForPageLoad();
        		Assert.assertEquals(areYouCurrentlyPregnantUF_CC.getTitleText(),areYouCurrentlyPregnantUF_CC.titleExpected, "Title is diff");
        		TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantUF_CC
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        		debugPageCC.checkProtocolsEquals(areYouCurrentlyPregnantUF_CC.titleExpected, protocol1, protocol2);
        		debugPageCC.back();
        areYouCurrentlyPregnantUF_CC.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());

        //----------Q12 -Transition Statement - Display for Call Center only-------------
        transitionStatementCC
        .getTitleExpected(studyName1);
        //Assert.assertEquals(transitionStatementCC.getTitleText(), transitionStatementCC.getTitleExpected(studyName1), "Title is difff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
       
        
        //-------------------New GENERAL HEALTH---------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")                	
        		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
        		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
        		//----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
//                .clickNextButton(new ChildrenUnderPageCC())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageCC())
                //----------PEDIATRIC HEALTH Questions----------
                //.clickNextButton(new HouseholdHavePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("None of the above")
                //.clickNextButton(new TheStudySitePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Public transportation")
                //.clickNextButton(new WhatMedicalCoveragePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("No, I have no coverage")
                //.clickNextButton(new EthnicBackgroundPageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Prefer not to answer")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)              
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(studyIndication)
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
package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.UF_4384.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;

public class UF_4384_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00011")
    @Description("UF_4384_CC")
    public void tc004Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1UF1";
        List<String> protocols = Arrays.asList("MVT_601_3001","MVT_601_3002");
        String protocol1 = "MVT_601_3001";
		String protocol2 = "MVT_601_3002";
        String studyName = "a uterine fibroids";
        String studyName1 = "uterine fibroids"; 
        String siteName = "AUT_UF_4384";
        String env = "STG";
        String zipCode = "19044";

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
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedUF_4384, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
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
        HasHealthcareProfEverDiagnosedFollowingGynoUF_CC hasHealthcareProfEverDiagnosedFollowingGynoUF_CC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfEverDiagnosedFollowingGynoUF_CC());

        //---------------Q2 Has a healthcare professional ever diagnosed you with any of the following gynecological or women's health conditions? -------------------
        hasHealthcareProfEverDiagnosedFollowingGynoUF_CC
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfEverDiagnosedFollowingGynoUF_CC.getTitleText(),hasHealthcareProfEverDiagnosedFollowingGynoUF_CC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = hasHealthcareProfEverDiagnosedFollowingGynoUF_CC
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of the following gynecological or women's ...", protocol1,protocol2);
        debugPageCC.back();
        HaveYouGoneThroughMenopauseUF_CC haveYouGoneThroughMenopauseUF_CC = hasHealthcareProfEverDiagnosedFollowingGynoUF_CC
                .waitForPageLoad()
                .clickOnAnswers("Uterine fibroids, also known as leiomyomas or myomas")
                .clickNextButton(new HaveYouGoneThroughMenopauseUF_CC());

        //---------------Q3 Have you gone through menopause?-------------------
        haveYouGoneThroughMenopauseUF_CC
                .waitForPageLoad();
        Assert.assertEquals(haveYouGoneThroughMenopauseUF_CC.getTitleText(),haveYouGoneThroughMenopauseUF_CC.titleExpected, "Title is diff");
        //----DQ if selected any option other than None of the above-----------
        HaveYouHadHysterectomyUF_CC haveYouHadHysterectomyUF_CC = haveYouGoneThroughMenopauseUF_CC
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyUF_CC());
        haveYouHadHysterectomyUF_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
                .back();
        		haveYouGoneThroughMenopauseUF_CC
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
        		.clickNextButton(new HaveYouHadHysterectomyUF_CC());
        haveYouHadHysterectomyUF_CC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
        		.back();        
				haveYouGoneThroughMenopauseUF_CC
				.waitForPageLoad()
				.clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
				.clickNextButton(new HaveYouHadHysterectomyUF_CC());
		haveYouHadHysterectomyUF_CC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1,protocol2)
				.back();          
        		haveYouGoneThroughMenopauseUF_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouHadHysterectomyUF_CC());

        //---------------Q4 Have you had a hysterectomy (surgical removal of the uterus)?-------------------
        haveYouHadHysterectomyUF_CC
                .waitForPageLoad();
        Assert.assertEquals(haveYouHadHysterectomyUF_CC.getTitleText(),haveYouHadHysterectomyUF_CC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC1 = haveYouHadHysterectomyUF_CC
                .clickOnAnswer("Yes")
                .clickNextButton(new NonQRtransitionPageCC());
        		nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(haveYouHadHysterectomyUF_CC.titleExpected, protocol1, protocol2)
                .back();
        haveYouHadHysterectomyUF_CC.waitForPageLoad();
        DoYouHaveRegularMenstrualCyclesUF_CC doYouHaveRegularMenstrualCyclesUF_CC = haveYouHadHysterectomyUF_CC
                .clickOnAnswer("No")
                .clickNextButton(new DoYouHaveRegularMenstrualCyclesUF_CC());
        

		//---------------Q5 Do you have regular menstrual cycles, meaning that you get your period each month on a predictable schedule?-------------------		
        doYouHaveRegularMenstrualCyclesUF_CC
                .waitForPageLoad();
        Assert.assertEquals(doYouHaveRegularMenstrualCyclesUF_CC.getTitleText(),doYouHaveRegularMenstrualCyclesUF_CC.titleExpected, "Title is diff");
        		HowWouldYouDescribeAvgPeriodUF_CC howWouldYouDescribeAvgPeriodUF_CC = doYouHaveRegularMenstrualCyclesUF_CC
        		.clickOnAnswer("No")
                .clickNextButton(new HowWouldYouDescribeAvgPeriodUF_CC());
        		howWouldYouDescribeAvgPeriodUF_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Do you have regular menstrual cycles, meaning that you get your period each month on a predictable s...", protocol1, protocol2)
                .back();
        doYouHaveRegularMenstrualCyclesUF_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
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
        HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC = haveYouHadSurgicalProcedurePast6MonthsUF_CC
                .clickOnAnswer("Yes")
                .clickNextButton(new HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC());
        hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?This surgery m...", protocol1, protocol2)
                .back();
        haveYouHadSurgicalProcedurePast6MonthsUF_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfEverDiagnosedYouOtherGynoUF_CC());

		//---------------Q9 Has a healthcare professional ever diagnosed you with any of these other gynecological or women's health conditions? -------------------	         
        hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC.getTitleText(),hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC.titleExpected, "Title is diff");
        		AreYouCurrentlyPregnantUF_CC areYouCurrentlyPregnantUF_CC = hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC
                .clickOnAnswers("Uterine polyps, also known as endometrial polyps",
                		        "Cervical polyps",
                		        "Ovarian cyst that is currently causing symptoms",
                		        "Endometrioma, also known as endometrial or endometrioid cyst or \"chocolate cyst\"")
                .clickNextButton(new AreYouCurrentlyPregnantUF_CC());
        		areYouCurrentlyPregnantUF_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of these other gynecological or women's he...", protocol1, protocol2)
                .back();
        hasHealthcareProfEverDiagnosedYouOtherGynoUF_CC.waitForPageLoad()
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
        HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = transitionStatementCC
        .clickNextButton(new HasHealthcareProfessionalPageCC());
       

        //----------GENERAL HEALTH Questions----------
        hasHealthcareProfessionalPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouUndergoneAnyPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartFailureIsAlsoPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditions())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingDigestiveConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingSkinConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingViralConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingMentalHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingWomensHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SmokedCigarettesPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageCC())
         //----------PEDIATRIC HEALTH Questions----------    
                .waitForPageLoad()
                .clickOnAnswer("Other")
                .clickNextButton(new WhatSortPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above (no coverage at all)")
                .clickNextButton(new EthnicBackgroundPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Other")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)              
                .clickNextButton(new SiteSelectionPageCC())
                .threadSleep(12000);  //wait 12  secs
                 new SiteSelectionPageCC()
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(new SelectActionPageCC())
                .waitForPageLoad();
    }
}

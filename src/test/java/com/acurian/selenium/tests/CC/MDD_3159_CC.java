package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.MDD_3159.*;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSCrohnsPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.HouseholdHavePageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatMedicalCoveragePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
import com.acurian.selenium.pages.CC.pediatric.WouldYouUsePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;


public class MDD_3159_CC extends BaseTest{

    @Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00011")
    @Description("MDD_3159_CC")
    public void mDD_3159_CC(final String username, final String password) {
        String phoneNumber = "AUTAMS1MDD";
        List<String> protocols = Arrays.asList("AXS_05_301");
        String protocol1 = "AXS_05_301";
        String studyName = "a depression";
        String studyName1 = "depression";
        String site_Indication = "Major Depressive Disorder (MDD)";
        String siteName = "AUT_MDD_3159";
     //   String env = "STG";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

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
                .waitForPageLoad();
               
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedMDD_3159, "Title is diff");
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
        HasHealthcareProfDiagnosedMDDCC hasHealthcareProfDiagnosedMDDCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfDiagnosedMDDCC());

        //---------------Q2 hasHealthcareProfDiagnosedMDDCC-------------------
        hasHealthcareProfDiagnosedMDDCC
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfDiagnosedMDDCC.getTitleText(),hasHealthcareProfDiagnosedMDDCC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = hasHealthcareProfDiagnosedMDDCC
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals(hasHealthcareProfDiagnosedMDDCC.titleExpected, protocol1);
        debugPageCC.back();
        AreYouCurrentlyFeelingSadDepressedCC areYouCurrentlyFeelingSadDepressedCC = hasHealthcareProfDiagnosedMDDCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyFeelingSadDepressedCC());

        //---------------Q3 AreYouCurrentlyFeelingSadDepressedOLS-------------------
        areYouCurrentlyFeelingSadDepressedCC
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyFeelingSadDepressedCC.getTitleText(),areYouCurrentlyFeelingSadDepressedCC.titleExpected, "Title is diff");
        //----Skip to Q9 page:HaveYouEverHadElectroconOLSvulsiveTherapyOLS, if selected "NO" in this page 
        HaveYouEverHadElectroconvulsiveTherapyCC haveYouEverHadElectroconvulsiveTherapyCC = areYouCurrentlyFeelingSadDepressedCC
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        haveYouEverHadElectroconvulsiveTherapyCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Are you currently feeling sad or depressed, or do you currently need treatment for depression?Are yo...", protocol1)
                .back();
        areYouCurrentlyFeelingSadDepressedCC
                .waitForPageLoad();
        WhenDidYourCurrentEpisodeDepressionStartCC whenDidYourCurrentEpisodeDepressionStartCC = areYouCurrentlyFeelingSadDepressedCC
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDidYourCurrentEpisodeDepressionStartCC());

        //---------------Q4 WhenDidYourCurrentEpisodeDepressionStartOLS-------------------
        whenDidYourCurrentEpisodeDepressionStartCC
                .waitForPageLoad();
        Assert.assertEquals(whenDidYourCurrentEpisodeDepressionStartCC.getTitleText(),whenDidYourCurrentEpisodeDepressionStartCC.titleExpected, "Title is diff");
        HowManyDifferentPrescriptionAntidepresMedsCC howManyDifferentPrescriptionAntidepresMedsCC = whenDidYourCurrentEpisodeDepressionStartCC
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsCC());
        howManyDifferentPrescriptionAntidepresMedsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whenDidYourCurrentEpisodeDepressionStartCC.titleExpected, protocol1)
                .back();
        		whenDidYourCurrentEpisodeDepressionStartCC.waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsCC());
        howManyDifferentPrescriptionAntidepresMedsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whenDidYourCurrentEpisodeDepressionStartCC.titleExpected, protocol1)
                .back();
				whenDidYourCurrentEpisodeDepressionStartCC.waitForPageLoad()
				.clickOnAnswer("2 - 3 months ago")
				.clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsCC());        

		//---------------Q5 HowManyDifferentPrescriptionAntidepresMedsOLS-------------------		
		howManyDifferentPrescriptionAntidepresMedsCC
                .waitForPageLoad();
        Assert.assertEquals(howManyDifferentPrescriptionAntidepresMedsCC.getTitleText(),howManyDifferentPrescriptionAntidepresMedsCC.titleExpected, "Title is diff");
        //----Skip to Q9 page:HaveYouEverHadElectroconvulsiveTherapyCC, if selected "I have not taken any prescription medications for my current episode of depression" in this page 
        		howManyDifferentPrescriptionAntidepresMedsCC
        		.clickOnAnswer("I have not taken any prescription medications for my current episode of depression")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        haveYouEverHadElectroconvulsiveTherapyCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(howManyDifferentPrescriptionAntidepresMedsCC.titleExpected, protocol1)
                .back();
        howManyDifferentPrescriptionAntidepresMedsCC
                .waitForPageLoad();
        WhichFollowingAntidepressantMedsTakingCC whichFollowingAntidepressantMedsTakingCC = howManyDifferentPrescriptionAntidepresMedsCC
                .clickOnAnswer("1")
                .clickNextButton(new WhichFollowingAntidepressantMedsTakingCC());

        
		//---------------Q6 WhichFollowingAntidepressantMedsTakingCC-------------------		        
        whichFollowingAntidepressantMedsTakingCC
                .waitForPageLoad();
        Assert.assertEquals(whichFollowingAntidepressantMedsTakingCC.getTitleText(),whichFollowingAntidepressantMedsTakingCC.titleExpected, "Title is diff");
        WhichFollowingAntidepressantMedicationsYouTriedCC whichFollowingAntidepressantMedicationsYouTriedCC = whichFollowingAntidepressantMedsTakingCC
                .clickOnAnswers("Wellbutrin (buproprion)")
                .clickNextButton(new WhichFollowingAntidepressantMedicationsYouTriedCC());

		//---------------Q7 whichFollowingAntidepressantMedicationsYouTriedCC-------------------		        
        whichFollowingAntidepressantMedicationsYouTriedCC
                .waitForPageLoad();
        Assert.assertEquals(whichFollowingAntidepressantMedicationsYouTriedCC.getTitleText(),whichFollowingAntidepressantMedicationsYouTriedCC.titleExpected, "Title is diff");
        HaveYouEverHadElectroconvulsiveTherapyCC haveYouEverHadElectroconvulsiveTherapyCC1 = whichFollowingAntidepressantMedicationsYouTriedCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        haveYouEverHadElectroconvulsiveTherapyCC
        .waitForPageLoad()
        .getPage(debugPageCC)
        .checkProtocolsEquals("Ghost Question - Buproprion Monotherapy for Current Episode", protocol1)
        .back();
        whichFollowingAntidepressantMedicationsYouTriedCC
        .waitForPageLoad()
        .clickOnAnswers("Another antidepressant not listed here")
        .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());        
        
		//---------------Q9 Have you ever had electroconvulsive therapy or ECT? "haveYouEverHadElectroconvulsiveTherapyCC"-------------------	              
        haveYouEverHadElectroconvulsiveTherapyCC1
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverHadElectroconvulsiveTherapyCC1.getTitleText(), haveYouEverHadElectroconvulsiveTherapyCC1.titleExpected, "Title is diff");
        HasHealthcareProfEverDiagnosedMntalHealthCC hasHealthcareProfEverDiagnosedMntalHealthCC = haveYouEverHadElectroconvulsiveTherapyCC1
                .clickOnAnswer("Yes, in the past 6 months")
                .clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthCC());
        hasHealthcareProfEverDiagnosedMntalHealthCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Electroconvulsive therapy (ECT), sometimes known as electroshock therapy or \"shock treatment,&q...", protocol1)
                .back();
        haveYouEverHadElectroconvulsiveTherapyCC1
                .waitForPageLoad()
                .clickOnAnswer("Yes, more than 6 months ago")
                .clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthCC());

		//---------------Q10 Has a healthcare professional ever diagnosed you with any of the following mental health conditions? "HasHealthcareProfEverDiagnosedMntalHealthCC"-------------------	         
        hasHealthcareProfEverDiagnosedMntalHealthCC
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfEverDiagnosedMntalHealthCC.getTitleText(),hasHealthcareProfEverDiagnosedMntalHealthCC.titleExpected, "Title is diff");
        HaveYouBeenHospitalizedForDepressionCC haveYouBeenHospitalizedForDepressionCC = hasHealthcareProfEverDiagnosedMntalHealthCC
                .clickOnAnswers("Borderline personality disorder")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionCC());
        haveYouBeenHospitalizedForDepressionCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(hasHealthcareProfEverDiagnosedMntalHealthCC.titleExpected, protocol1)
                .back();
        hasHealthcareProfEverDiagnosedMntalHealthCC.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionCC());

		//---------------Q11 Have you been hospitalized for depression or any other mental health condition in the past year?-------------------	         
        haveYouBeenHospitalizedForDepressionCC
                .waitForPageLoad();
        Assert.assertEquals(haveYouBeenHospitalizedForDepressionCC.getTitleText(),haveYouBeenHospitalizedForDepressionCC.titleExpected, "Title is diff");
        TransitionStatementCC transitionStatementCC = haveYouBeenHospitalizedForDepressionCC
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        		debugPageCC.checkProtocolsEquals("Have you been hospitalized for depression or any other mental health condition in the past year? By ...", protocol1);
        		debugPageCC.back();
        haveYouBeenHospitalizedForDepressionCC.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());

        //----------Q13 -Transition Statement - Display for Call Center only-------------
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
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageCC())
         //----------PEDIATRIC HEALTH Questions----------
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)              
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a depression study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(site_Indication)
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
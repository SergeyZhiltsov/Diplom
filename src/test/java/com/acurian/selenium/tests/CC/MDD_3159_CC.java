package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.PregnancyAndFertilityCC;
import com.acurian.selenium.pages.CC.MDD_3159.*;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.MDD_3159.WhichOfTheFollowingPrescriptionMedications_OLS;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;


public class MDD_3159_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00011")
    @Description("MDD_3159_CC")
    public void mDD_3159_CC(final String username, final String password) {
        String phoneNumber = "AUTAMS1MDD";
        List<String> protocols = Arrays.asList("AXS_05_301");
        String protocol1 = "AXS_05_301";
        String studyName = "a depression";
        String studyName1 = "depression history";
        String site_Indication = "Major Depressive Disorder (MDD)";
        String siteName = "AUT_MDD_3159";
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
        Assert.assertEquals(hasHealthcareProfDiagnosedMDDCC.getTitleText(), hasHealthcareProfDiagnosedMDDCC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = hasHealthcareProfDiagnosedMDDCC
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0014051-QS4802-STUDYQUES", protocol1);
        debugPageCC.back();
        AreYouCurrentlyFeelingSadDepressedCC areYouCurrentlyFeelingSadDepressedCC = hasHealthcareProfDiagnosedMDDCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyFeelingSadDepressedCC());
        

        //---------------Q3 -AreYouCurrentlyFeelingSadDepressedCC-------------------
        areYouCurrentlyFeelingSadDepressedCC
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyFeelingSadDepressedCC.getTitleText(), areYouCurrentlyFeelingSadDepressedCC.titleExpected, "Title is diff");
        //----Skip to Q9 page:HaveYouEverHadElectroconOLSvulsiveTherapyOLS, if selected "NO" in this page 
        HaveYouEverHadElectroconvulsiveTherapyCC haveYouEverHadElectroconvulsiveTherapyCC = areYouCurrentlyFeelingSadDepressedCC
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        haveYouEverHadElectroconvulsiveTherapyCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018168-QS4820-STUDYQUES", protocol1)
                .back();
        CurrentEpisodeOfDepressionCC currentEpisodeOfDepressionCC = areYouCurrentlyFeelingSadDepressedCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentEpisodeOfDepressionCC());
        
        
        //-------------------Q4 -When did your current episode of depression start?----------------
        HowManyDifferentPrescriptionAntidepresMedsCC howManyDifferentPrescriptionAntidepresMedsCC= currentEpisodeOfDepressionCC
                .waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsCC());
        		howManyDifferentPrescriptionAntidepresMedsCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0014055-QS4804-STUDYQUES", protocol1)
        		.back();
        currentEpisodeOfDepressionCC
        		.waitForPageLoad()
        		.clickOnAnswer("1 month ago or less")
        		.clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsCC());
        		howManyDifferentPrescriptionAntidepresMedsCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0014055-QS4804-STUDYQUES", protocol1)
				.back();
        currentEpisodeOfDepressionCC
        		.waitForPageLoad()
        		.clickOnAnswer("2 - 3 months ago")
        		.clickOnAnswer("4 - 6 months ago")       		
        		.clickOnAnswer("7 - 11 months ago")
        		.clickOnAnswer("1 1/2 - 2 years ago")
        		.clickOnAnswer("About 1 year ago")
        		.clickNextButton(new HowManyDifferentPrescriptionAntidepresMedsCC());
        
        
        //-------------------Q5-HowManyDifferentPrescriptionAntidepresMedsCC----------------     
        howManyDifferentPrescriptionAntidepresMedsCC
        		.waitForPageLoad()
                .clickOnAnswer("I have not taken any prescription medications for my current episode of depression")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        		haveYouEverHadElectroconvulsiveTherapyCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0014057-QS4805-STUDYQUES", protocol1)
        		.back();
        howManyDifferentPrescriptionAntidepresMedsCC
        		.waitForPageLoad();
        WhichOfTheFollowingPrescriptionMedications_CC whichOfTheFollowingPrescriptionMedications_CC= howManyDifferentPrescriptionAntidepresMedsCC
        		.clickOnAnswer("1")
        		.clickOnAnswer("3")
        		.clickOnAnswer("4 or more")
        		.clickNextButton(new WhichOfTheFollowingPrescriptionMedications_CC());
        whichOfTheFollowingPrescriptionMedications_CC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0014057-QS4805-STUDYQUES", protocol1)
				.back();
        howManyDifferentPrescriptionAntidepresMedsCC
        		.waitForPageLoad()
        		.clickOnAnswer("2")
        		.clickNextButton(new WhichOfTheFollowingPrescriptionMedications_CC());        
        
        
        //--------------------Q6 - WhichOfTheFollowingPrescriptionMedications_CC----------------     
        whichOfTheFollowingPrescriptionMedications_CC
        		.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        		haveYouEverHadElectroconvulsiveTherapyCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0014063-QS4808-STUDYQUES", protocol1)
        		.back();
        whichOfTheFollowingPrescriptionMedications_CC
        		.waitForPageLoad();
        		SubquestionWhenDidYouTakeFollowingMeds_CC subquestionWhenDidYouTakeFollowingMeds_CC= whichOfTheFollowingPrescriptionMedications_CC
        		.clickOnAnswers("Celexa (citalopram)")
        		.clickOnAnswers("Cymbalta (duloxetine)") 
        		.clickOnAnswers("Effexor (venlafaxine)") 
        		.clickOnAnswers("Fetzima (levomilnacipran)")
        		.clickOnAnswers("Another antidepressant not listed")
        		.clickNextButton(new SubquestionWhenDidYouTakeFollowingMeds_CC());
        
        
       //---------------------Q7 SubquestionWhenDidYouTakeFollowingMeds_CC-------------------- 
        subquestionWhenDidYouTakeFollowingMeds_CC
        		.waitForPageLoad(1, subquestionWhenDidYouTakeFollowingMeds_CC.titleExpected1)
        		.waitForPageLoad(2, subquestionWhenDidYouTakeFollowingMeds_CC.titleExpected2)
        		.waitForPageLoad(3, subquestionWhenDidYouTakeFollowingMeds_CC.titleExpected3)
        		.waitForPageLoad(4, subquestionWhenDidYouTakeFollowingMeds_CC.titleExpected4)
        		.waitForPageLoad(5, subquestionWhenDidYouTakeFollowingMeds_CC.titleExpected5)
        		.clickOnAnswerForSubQuestion(1, "Took in the past for a different episode of depression")
        		.clickOnAnswerForSubQuestion(2, "Took in the past for a different episode of depression")        		
        		.clickOnAnswerForSubQuestion(3, "Took in the past for a different episode of depression")       		
        		.clickOnAnswerForSubQuestion(4, "Took in the past for a different episode of depression")
        		.clickOnAnswerForSubQuestion(5, "Took in the past for a different episode of depression")
        		.clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        haveYouEverHadElectroconvulsiveTherapyCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0014063-QS4808-STUDYQUES", protocol1)  //disqualifies both 3159, 4850 protocols
				.back();
        subquestionWhenDidYouTakeFollowingMeds_CC
        		.waitForPageLoad(1, subquestionWhenDidYouTakeFollowingMeds_CC.titleExpected1)		
        		.clickOnAnswerForSubQuestion(1, "Tried for current episode but stopped taking") //Select "Currently taking" to qualify for 4850
        		.clickNextButton(new HaveYouEverHadElectroconvulsiveTherapyCC());
        
        		
        		
        //-------------------Q9 HaveYouEverHadElectroconvulsiveTherapyCC----------------     
        haveYouEverHadElectroconvulsiveTherapyCC
        		.waitForPageLoad();
        HasHealthcareProfEverDiagnosedMntalHealthCC hasHealthcareProfEverDiagnosedMntalHealthCC = haveYouEverHadElectroconvulsiveTherapyCC
                .clickOnAnswer("No")
        		.clickOnAnswer("Yes, in the past 6 months")
                .clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthCC());
        		hasHealthcareProfEverDiagnosedMntalHealthCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0014064-QS4809-STUDYQUES", protocol1)
        		.back();
        haveYouEverHadElectroconvulsiveTherapyCC
        		.waitForPageLoad()
                .clickOnAnswer("Yes, more than 6 months ago")   //Select "No" to qualify for 4850
        		.clickNextButton(new HasHealthcareProfEverDiagnosedMntalHealthCC());
       
        

        //---------------Q10 Has a healthcare professional ever diagnosed you with any of the following mental health conditions? "HasHealthcareProfEverDiagnosedMntalHealthCC"-------------------
        hasHealthcareProfEverDiagnosedMntalHealthCC
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfEverDiagnosedMntalHealthCC.getTitleText(), hasHealthcareProfEverDiagnosedMntalHealthCC.titleExpected, "Title is diff");
        HaveYouBeenHospitalizedForDepressionCC haveYouBeenHospitalizedForDepressionCC = hasHealthcareProfEverDiagnosedMntalHealthCC
                .clickOnAnswers("Anorexia") 
                .clickOnAnswers("Bulimia")
                .clickOnAnswers("Obsessive-compulsive disorder (OCD)")
                .clickOnAnswers("Panic disorder") 
                .clickOnAnswers("Psychosis")
                .clickOnAnswers("Antisocial personality disorder") 
                .clickOnAnswers("Borderline personality disorder")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionCC());
        haveYouBeenHospitalizedForDepressionCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0014066-QS4810-STUDYQUES", protocol1)
                .back();
        hasHealthcareProfEverDiagnosedMntalHealthCC.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouBeenHospitalizedForDepressionCC());
        
        
        
        //---------------Q11 Have you been hospitalized for depression or any other mental health condition in the past year?-------------------
        haveYouBeenHospitalizedForDepressionCC
                .waitForPageLoad();
        Assert.assertEquals(haveYouBeenHospitalizedForDepressionCC.getTitleText(), haveYouBeenHospitalizedForDepressionCC.titleExpected, "Title is diff");
        PregnancyAndFertilityCC pregnancyAndFertilityCC = haveYouBeenHospitalizedForDepressionCC
                .clickOnAnswer("Yes")
                .clickNextButton(new PregnancyAndFertilityCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0014068-QS4811-STUDYQUES", protocol1);
        debugPageCC.back();
        haveYouBeenHospitalizedForDepressionCC
        		.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PregnancyAndFertilityCC());
        

        //---------------Q12 PregnancyAndFertilityCC-------------------
        pregnancyAndFertilityCC
                .waitForPageLoad();
        Assert.assertEquals(pregnancyAndFertilityCC.getTitleText(), pregnancyAndFertilityCC.titleExpected, "Title is diff");
        TransitionStatementCC transitionStatementCC = pregnancyAndFertilityCC
                .clickOnAnswer("None of the above")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
        		.waitForPageLoadMDD(studyName1)
        		//debugPageCC.checkProtocolsContainsForQNumber("Q0013673-QS4823-STUDYQUES", protocol1); //DQ for 4850
        		.back();
        pregnancyAndFertilityCC
        		.waitForPageLoad()
                .clickOnAnswer("I have gone through menopause - my last menstrual period was 1 year ago or longer") 
                .clickOnAnswer("I currently have my \"tubes tied\" (also called bilateral tubal ligation, a sterilization procedure)")
                .clickOnAnswer("I have had both ovaries surgically removed (bilateral oophorectomy) and/or my uterus surgically removed (hysterectomy)")
                .clickOnAnswer("I am unable to become pregnant due to another medical condition")
                .clickNextButton(new TransitionStatementCC());
        

        //----------Q13 -Transition Statement - Display for Call Center only-------------
        transitionStatementCC
                .waitForPageLoadMDD(studyName1);
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
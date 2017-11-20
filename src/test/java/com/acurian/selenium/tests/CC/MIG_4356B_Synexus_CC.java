package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingDigestiveConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingNeurologicalConditions;
import com.acurian.selenium.pages.CC.generalHealth.FollowingSkinConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingViralConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingWomensHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouUndergoneAnyPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartFailureIsAlsoPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HistoryOfDrugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.OtherThanSkinCancerPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SleepRelatedConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class MIG_4356B_Synexus_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00001")
    @Description(" 1. Open the page, URL: " +
            " 2. Type login and correct password of registered user" +
            " 3. Click the Sign In button")
    public void tc001Test(final String username, final String password) {
        String phoneNumberMIG = "AUTAMS1MIG";
        //List<String> protocol = Arrays.asList("BHV3000_302\n"+"UBR_MD_01");
        String protocol1 = "20150133";
        String protocol2 = "BHV3000_301";
        String protocol3 = "BHV3000_302";
        String protocol4 = "CGP_MD_01";
        String protocol5 = "UBR_MD_01";
        String protocol6 = "UBR_MD_02";
        String studyName =  "a migraine";  //"Migraine 4356B Synexus";
        String env = "STG";  //Enter which CC environment to use for testing
        String siteName = "AUT_MIG_4356B_Site";
        String zip_Code = "19044";
        
        
        //------------LOGIN Page for CC---------------   
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)  //Launch URL as per environment 
                .waitForPageLoad();
         
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();

        //------------(SelectActionPage) Study and PhoneNumber Selection Page---------------      
        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumberMIG)
                .clickPopupPhoneNumber(phoneNumberMIG)
                .clickBeginButton();

        //------------Call Center Introduction Page---------------      
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC   // RUN below mentioned methods for Right side page and then create object for the NEXT page (on Left side) = [create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());
        
        //------------DOB Page---------------    
        dateOfBirthPageCC   	
        		.waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedMIG, "Title is diff");
       
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Aug")
                .setDay("1")
                .setYear("1982")
                .clickNextButton(new ZipCodePageCC());
                
        
        //------------ZIP_CODE question---------------
        GenderPageCC genderPageCC = zipCodePageCC  //[create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .typeZipCode(zip_Code)
                .clickNextButton(new GenderPageCC());
        

        //------------GENDER question---------------      
        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");

        DoYouSufferFromMigPageCC doYouSufferFromMigPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromMigPageCC());
        
        
        //------------Q2 DoYouSufferFromMigPageCC---------------   
        NonQRtransitionPageCC nonQRtransitionPageCC = doYouSufferFromMigPageCC  //[create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC()); 
        //------------NonQRtransitionPageCC --------------- 
        nonQRtransitionPageCC.
                waitForPageLoad();
        //********Check Question History for DQ and then click BACK button
        DebugPageCC debugPageCC = new DebugPageCC();
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(doYouSufferFromMigPageCC.titleExpected).contains(protocol1));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(doYouSufferFromMigPageCC.titleExpected).contains(protocol2));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(doYouSufferFromMigPageCC.titleExpected).contains(protocol3));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(doYouSufferFromMigPageCC.titleExpected).contains(protocol4));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(doYouSufferFromMigPageCC.titleExpected).contains(protocol5));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(doYouSufferFromMigPageCC.titleExpected).contains(protocol6));
        debugPageCC.back();   
        //------------ Change your answer to correct option in DoYouSufferFromMigPageCC---------------          
        HowOldWereYouMigHeadachePageCC howOldWereYouMigHeadachePageCC = doYouSufferFromMigPageCC  //[create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowOldWereYouMigHeadachePageCC());

        
        
        //-----------Q3 -How Old Were You when you were diagnosed with Migraine Headache Page ---------------   
        howOldWereYouMigHeadachePageCC
        		.waitForPageLoad();
        Assert.assertEquals(howOldWereYouMigHeadachePageCC.getTitleText(), howOldWereYouMigHeadachePageCC.titleExpected, "Title is diff");
      
        HowLongSufferingFromMigraineCC howLongSufferingFromMigraineCC = howOldWereYouMigHeadachePageCC  //[create NEXT PAGE Object = THIS page object] 
                .typeAge("50")
                .clickNextButton(new HowLongSufferingFromMigraineCC())
                .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        //System.out.println("see there="+debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected).contains(protocol1));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected).contains(protocol2));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected).contains(protocol3));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected).contains(protocol4));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected).contains(protocol5));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected).contains(protocol6));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageCC---------------   
        howOldWereYouMigHeadachePageCC        
        .typeAge("35")
        .clickNextButton(new HowLongSufferingFromMigraineCC())
        .waitForPageLoad();
        
        
        //----------Q4 For approximately how long have you been suffering from migraine headaches? -  Page ---------------   
        howLongSufferingFromMigraineCC
        		.waitForPageLoad();
        Assert.assertEquals(howLongSufferingFromMigraineCC.getTitleText(), howLongSufferingFromMigraineCC.titleExpected, "Title is diff");
        //System.out.println("see there="+debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected));       
        howLongSufferingFromMigraineCC
        .clickOnAnswer("5 months or less")
        .clickNextButton(new StudyQuestionMigPageCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button            
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongSufferingFromMigraineCC.titleExpected).contains(protocol1));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongSufferingFromMigraineCC.titleExpected).contains(protocol2));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongSufferingFromMigraineCC.titleExpected).contains(protocol3));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongSufferingFromMigraineCC.titleExpected).contains(protocol4));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongSufferingFromMigraineCC.titleExpected).contains(protocol5));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongSufferingFromMigraineCC.titleExpected).contains(protocol6));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in 'howOldWereYouMigHeadachePageCC'---------------   
        StudyQuestionMigPageCC studyQuestionMigPageCC = howLongSufferingFromMigraineCC //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswer("1 year or more")
        .clickNextButton(new StudyQuestionMigPageCC())
        .waitForPageLoad();
        
        //----------Q5 STUDY QUESTION - "The next few questions are about migraines, regular headaches, and how often you have them. If you don't remember the exact numbers, please take your best guess." Page ---------------   
        studyQuestionMigPageCC.waitForPageLoad();
        Assert.assertEquals(studyQuestionMigPageCC.getTitleText(),studyQuestionMigPageCC.titleExpected, "Title is diff");    
        studyQuestionMigPageCC
        .selectAttacks("10")
        .selectDays("8")
        .selectHeadaches("8")
        .clickNextButton(new CurrentlyTakeMedicationsForMigraineCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        /*Assert.assertTrue(debugPageCC.getProtocolForQuestion(studyQuestionMigPageCC.titleExpectedParagraphs).contains(protocol1));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(studyQuestionMigPageCC.titleExpectedParagraphs).contains(protocol2));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(studyQuestionMigPageCC.titleExpectedParagraphs).contains(protocol3));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(studyQuestionMigPageCC.titleExpectedParagraphs).contains(protocol4));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(studyQuestionMigPageCC.titleExpectedParagraphs).contains(protocol5));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(studyQuestionMigPageCC.titleExpectedParagraphs).contains(protocol6));*/
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        CurrentlyTakeMedicationsForMigraineCC currentlyTakeMedicationsForMigraineCC = studyQuestionMigPageCC //[create NEXT PAGE Object = THIS page object]      
        .selectAttacks("8")
        .selectDays("8")
        .selectHeadaches("8")
        .clickNextButton(new CurrentlyTakeMedicationsForMigraineCC());

        
        
        //----------Q6 CurrentlyTakeMedicationsForMigraineCC - "Do you currently take any medications to treat your migraine headaches? " Page ---------------   
        currentlyTakeMedicationsForMigraineCC.waitForPageLoad();     
        Assert.assertEquals(currentlyTakeMedicationsForMigraineCC.getTitleText(),currentlyTakeMedicationsForMigraineCC.titleExpected, "Title is diff");  
        HaveUeverHadBotoxMigCC haveUeverHadBotoxMigCC = currentlyTakeMedicationsForMigraineCC   //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("No")
        .clickNextButton(new HaveUeverHadBotoxMigCC()); // Click NEXT button and wait for the NEXT page
        //********Validate SMART-SKIP to page "HaveUeverHadBotox" instead of page "WhenUTakeMigraineMedicationsCC"***************
        haveUeverHadBotoxMigCC.waitForPageLoad();
        Assert.assertEquals(haveUeverHadBotoxMigCC.getTitleText(),haveUeverHadBotoxMigCC.titleExpected, "Title is diff");  
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        WhenUTakeMigraineMedicationsCC whenUTakeMigraineMedicationsCC = currentlyTakeMedicationsForMigraineCC //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswers("Yes, prescription medication")
        .clickNextButton(new WhenUTakeMigraineMedicationsCC());
 
        
        //----------Q7 CurrentlyTakeMedicationsForMigraineCC - "Do you currently take any medications to treat your migraine headaches? " Page ---------------   
        whenUTakeMigraineMedicationsCC.waitForPageLoad();     
        Assert.assertEquals(whenUTakeMigraineMedicationsCC.getTitleText(),whenUTakeMigraineMedicationsCC.titleExpected, "Title is diff");  
        HaveUeverHadBotoxMigCC haveUeverHadBotoxMigCC1 = whenUTakeMigraineMedicationsCC   //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("Daily or regularly, to prevent migraine headaches")
        .clickNextButton(new HaveUeverHadBotoxMigCC()); // Click NEXT button and wait for the NEXT page
        //********Validate SMART-SKIP to page "HaveUeverHadBotox" instead of page "MedicationToStopActiveMigraineCC" ***************
        //If selected ("Yes, prescription medication" OR "Yes, over-the-counter medication" in Q6) AND (“As needed” in Q7) continue to Q8 Otherwise, skip to Q9-----------
        haveUeverHadBotoxMigCC1.waitForPageLoad();
        Assert.assertEquals(haveUeverHadBotoxMigCC1.getTitleText(),haveUeverHadBotoxMigCC1.titleExpected, "Title is diff");    
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion("When do you take your migraine medications? Do you take themAgent Note: Select all that applyHow ").contains(protocol1));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        MedicationToStopActiveMigraineCC medicationToStopActiveMigraineCC = whenUTakeMigraineMedicationsCC //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswers("Daily or regularly, to prevent migraine headaches")//De-select 1st option by clicking on it.
        .clickOnAnswers("\"As needed\" - as your migraine starts or while you experience it")
        .clickNextButton(new MedicationToStopActiveMigraineCC());        
        
        
                
        //----------Q8 In the past 3 months, how many days per month have you used medication to stop an active migraine? -  Page ---------------   
        medicationToStopActiveMigraineCC
        		.waitForPageLoad();
        Assert.assertEquals(medicationToStopActiveMigraineCC.getTitleText(), medicationToStopActiveMigraineCC.titleExpected, "Title is diff");    
        medicationToStopActiveMigraineCC.clickOnAnswer("More than half the days in a month")
        .clickNextButton(new HaveUeverHadBotoxMigCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button            
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(medicationToStopActiveMigraineCC.titleExpected).contains(protocol2));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(medicationToStopActiveMigraineCC.titleExpected).contains(protocol3));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(medicationToStopActiveMigraineCC.titleExpected).contains(protocol4));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(medicationToStopActiveMigraineCC.titleExpected).contains(protocol5));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(medicationToStopActiveMigraineCC.titleExpected).contains(protocol6));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in 'MedicationToStopActiveMigraineCC'---------------   
        HaveUeverHadBotoxMigCC haveUeverHadBotoxMigCC3 = medicationToStopActiveMigraineCC //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswer("Less than half the days in a month")
        .clickNextButton(new HaveUeverHadBotoxMigCC());
        
        
        
        //----------Q9 -Have you ever had a Botox (botulinum toxin) injection?  -  Page ---------------   
        haveUeverHadBotoxMigCC3
        		.waitForPageLoad();
        Assert.assertEquals(haveUeverHadBotoxMigCC3.getTitleText(), haveUeverHadBotoxMigCC3.titleExpected, "Title is diff");    
        HaveUeverDiagnosedByHealthcareProfesionalCC haveUeverDiagnosedByHealthcareProfesionalCC = haveUeverHadBotoxMigCC3  //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("No")
        .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC()); // Click NEXT button and wait for the NEXT page
        //********Validate SMART-SKIP to page QS11 "HaveUeverDiagnosedByHealthcareProfesionalCC" instead of page QS10 "WhenYouLastHaveBotoxMigCC"***************
        haveUeverDiagnosedByHealthcareProfesionalCC.waitForPageLoad();
        Assert.assertEquals(haveUeverDiagnosedByHealthcareProfesionalCC.getTitleText(),haveUeverDiagnosedByHealthcareProfesionalCC.titleExpected, "Title is diff");  
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'HaveUeverHadBotoxMigCC'---------------  
        WhenYouLastHaveBotoxMigCC whenYouLastHaveBotoxMigCC = haveUeverHadBotoxMigCC3 //[create NEXT PAGE Object = THIS page object]     
        .clickOnAnswer("Yes, injected around my face, head or neck")
        .clickNextButton(new WhenYouLastHaveBotoxMigCC());
        
        
        
        //----------Q10 -When did you last have a Botox (botulinum toxin) injection? - Page ---------------   
        whenYouLastHaveBotoxMigCC
        		.waitForPageLoad();
        Assert.assertEquals(whenYouLastHaveBotoxMigCC.getTitleText(), whenYouLastHaveBotoxMigCC.titleExpected, "Title is diff");    
        HaveUeverDiagnosedByHealthcareProfesionalCC haveUeverDiagnosedByHealthcareProfesionalCC1 = whenYouLastHaveBotoxMigCC  //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("Within the last month")
        .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(whenYouLastHaveBotoxMigCC.titleExpected).contains(protocol4));
        debugPageCC.back();
        whenYouLastHaveBotoxMigCC.clickOnAnswer("1 - 3 months ago")
        .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(whenYouLastHaveBotoxMigCC.titleExpected).contains(protocol4));
        debugPageCC.back();
        whenYouLastHaveBotoxMigCC.clickOnAnswer("4 - 6 months ago")
        .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(whenYouLastHaveBotoxMigCC.titleExpected).contains(protocol4));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'whenYouLastHaveBotoxMigCC'---------------  
        haveUeverHadBotoxMigCC3.clickOnAnswer("More than 1 year ago")
        .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC());
        
        
        
        //----------Q11 Have you ever been diagnosed by a healthcare professional with any of the following pain conditions? " Page ---------------   
        haveUeverDiagnosedByHealthcareProfesionalCC1
        	.waitForPageLoad();     
        Assert.assertEquals(haveUeverDiagnosedByHealthcareProfesionalCC1.getTitleText(),haveUeverDiagnosedByHealthcareProfesionalCC1.titleExpected, "Title is diff"); 
        AreYouCurrentlyPregnantCC areYouCurrentlyPregnantCC = haveUeverDiagnosedByHealthcareProfesionalCC1  //[create NEXT PAGE Object = THIS page object] 
        .clickOnAnswers("Trigeminal Neuralgia - severe pain in the nerves of the face")
        .clickNextButton(new AreYouCurrentlyPregnantCC()); // Click NEXT button and wait for the NEXT page
                
        		
        //----------Q12 - Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?   -  Page ---------------   
        areYouCurrentlyPregnantCC
        		.waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyPregnantCC.getTitleText(), areYouCurrentlyPregnantCC.titleExpected, "Title is diff");    
        TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC //[create NEXT PAGE Object = THIS page object]   
        .clickOnAnswer("Yes")
        //TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new TransitionStatementCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(areYouCurrentlyPregnantCC.titleExpected).contains(protocol1));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(areYouCurrentlyPregnantCC.titleExpected).contains(protocol2));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(areYouCurrentlyPregnantCC.titleExpected).contains(protocol3));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(areYouCurrentlyPregnantCC.titleExpected).contains(protocol4));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(areYouCurrentlyPregnantCC.titleExpected).contains(protocol5));
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(areYouCurrentlyPregnantCC.titleExpected).contains(protocol6));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'areYouCurrentlyPregnantCC'---------------  
        //TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC //[create NEXT PAGE Object = THIS page object]    
        areYouCurrentlyPregnantCC.clickOnAnswer("Unsure")
        .clickNextButton(new TransitionStatementCC());
       
      //----------Q13 -Transition Statement - Display for Call Center only
        transitionStatementCC
                .waitForPageLoad(studyName);
        Assert.assertEquals(transitionStatementCC.getTitleText(), transitionStatementCC.getTitleExpected(studyName), "Title is difff");
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
                .clickOnAnswers("Other")
                .clickNextButton(new WhatSortPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above (no coverage at all)")
                .clickNextButton(new EthnicBackgroundPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Other")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)              
                .clickNextButton(new SiteSelectionPageCC())
                .threadSleep(15000);  //wait 15  secs
                 new SiteSelectionPageCC()
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new WarmTransfer1())
                 //Warm Transfer Questions ----- //Warm Transfer Page#2 
                .threadSleep(15000);  //wait 15  secs
                 new WarmTransfer1()
                //.waitForPageLoad() 
                .clickOnAnswer("[patient agrees to be transferred]")
                .clickNextButton(new WarmTransfer2())
                //Warm Transfer Page#2 
                .threadSleep(10000);  //wait 10  secs
                new WarmTransfer2()
                //.waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WarmTransfer3())
                //Warm Transfer Page#3
                .threadSleep(10000);  //wait 10  secs
                new WarmTransfer3()
                //.waitForPageLoad()
                .clickNextButton(new WarmTransfer4())
                //Warm Transfer Page#4 
                .threadSleep(10000);  //wait 10  secs
                new WarmTransfer4()
                //.waitForPageLoad()                
                .clickOnAnswer("Transferred for Scheduling")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();

    }
}
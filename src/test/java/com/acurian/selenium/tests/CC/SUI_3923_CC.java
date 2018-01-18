package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.SUI_3923.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
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


public class SUI_3923_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00015")
    @Description("Stress Urinary Incontinence (SUI) - 3923 CC")
    public void tc001Test(final String username, final String password) {
        String phoneNumberSUI = "AUTAMS1SUI";
        //List<String> protocol = Arrays.asList("BHV3000_302\n"+"UBR_MD_01");
        String protocol1 = "G201002";
        String studyName =  "a women's bladder control";  //"Stress Urinary Incontinence (SUI) - 3923";
        String env = "STG";  //Enter which CC environment to use for testing
        String siteName = "AUT_SUI_3923";
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
                .typePhoneNumber(phoneNumberSUI)
                .clickPopupPhoneNumber(phoneNumberSUI)
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedSUI_3923, "Title is diff");
       
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
        DoYouExperienceUrinaryIncontinenceCC doYouExperienceUrinaryIncontinenceCC = genderPageCC
                .clickOnAnswer("Male")
                .clickNextButton(new DoYouExperienceUrinaryIncontinenceCC());
        //********Check Question History for DQ and then click BACK button
        DebugPageCC debugPageCC = new DebugPageCC();
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(genderPageCC.titleExpected).contains(protocol1));
        debugPageCC.back();   
        //------------ Change your answer to correct option in DoYouSufferFromMigPageCC--------------- 
        genderPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("Female")
                .clickNextButton(new DoYouExperienceUrinaryIncontinenceCC());
        
        
        //------------Q2 Do you experience either of the following types of urinary leakage, sometimes called urinary incontinence?---------------   
        NonQRtransitionPageCC nonQRtransitionPageCC = doYouExperienceUrinaryIncontinenceCC  //[create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC()); 
        //------------NonQRtransitionPageCC --------------- 
        nonQRtransitionPageCC.
                waitForPageLoad();
        //********Check Question History for DQ and then click BACK button
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(doYouExperienceUrinaryIncontinenceCC.titleExpected).contains(protocol1));
        debugPageCC.back();   
        //------------ Change your answer to correct option in DoYouSufferFromMigPageCC---------------          
        WhichTypeOfUrinaryLeakageYouExperienceCC whichTypeOfUrinaryLeakageYouExperienceCC = doYouExperienceUrinaryIncontinenceCC  //[create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .clickOnAnswers("Stress urinary leakage - leaking of urine while coughing, sneezing, laughing, jumping, or performing other activities that put pressure on the bladder","Urge urinary leakage - strong, urgent need to urinate, accidents in which you are unable to reach a bathroom in time, and occasional bed-wetting")
                .clickNextButton(new WhichTypeOfUrinaryLeakageYouExperienceCC());

        
        
        //-----------Q3 -Which type of urinary leakage do you experience most often? ---------------   
        whichTypeOfUrinaryLeakageYouExperienceCC.waitForPageLoad();
        Assert.assertEquals(whichTypeOfUrinaryLeakageYouExperienceCC.getTitleText(), whichTypeOfUrinaryLeakageYouExperienceCC.titleExpected, "Title is diff");
      
        HowLongYouBeenExperiencingUrinaryLeakageCC howLongYouBeenExperiencingUrinaryLeakageCC = whichTypeOfUrinaryLeakageYouExperienceCC  //[create NEXT PAGE Object = THIS page object] 
                .clickOnAnswer("I experience urge leakage most often")
                .clickNextButton(new HowLongYouBeenExperiencingUrinaryLeakageCC())
                .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(whichTypeOfUrinaryLeakageYouExperienceCC.titleExpected).contains(protocol1));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageCC---------------   
        whichTypeOfUrinaryLeakageYouExperienceCC        
        .clickOnAnswer("I experience stress leakage most often")
        .clickNextButton(new HowLongYouBeenExperiencingUrinaryLeakageCC())
        .waitForPageLoad();
        
        
        //----------Q4 How long have you been experiencing urinary leakage? -  Page ---------------   
        howLongYouBeenExperiencingUrinaryLeakageCC
        		.waitForPageLoad();
        Assert.assertEquals(howLongYouBeenExperiencingUrinaryLeakageCC.getTitleText(), howLongYouBeenExperiencingUrinaryLeakageCC.titleExpected, "Title is diff");
        //System.out.println("see there="+debugPageCC.getProtocolForQuestion(howOldWereYouMigHeadachePageCC.titleExpected));       
        howLongYouBeenExperiencingUrinaryLeakageCC
        .clickOnAnswer("1 month or less")
        .clickNextButton(new HowFrequentlyYouExperienceUrinaryLeakageCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button            
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongYouBeenExperiencingUrinaryLeakageCC.titleExpected).contains(protocol1));
        debugPageCC.back();
        howLongYouBeenExperiencingUrinaryLeakageCC.waitForPageLoad();
        //HowFrequentlyYouExperienceUrinaryLeakageCC howFrequentlyYouExperienceUrinaryLeakageCC = howLongYouBeenExperiencingUrinaryLeakageCC //[create NEXT PAGE Object = THIS page object]      
        howLongYouBeenExperiencingUrinaryLeakageCC.clickOnAnswer("2 - 3 months")
        .clickNextButton(new HowFrequentlyYouExperienceUrinaryLeakageCC());
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howLongYouBeenExperiencingUrinaryLeakageCC.titleExpected).contains(protocol1));
        debugPageCC.back();
        howLongYouBeenExperiencingUrinaryLeakageCC.waitForPageLoad();
        //------------ Change your answer to correct QR age in 'howOldWereYouMigHeadachePageCC'---------------   
        HowFrequentlyYouExperienceUrinaryLeakageCC howFrequentlyYouExperienceUrinaryLeakageCC = howLongYouBeenExperiencingUrinaryLeakageCC //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswer("6 months or more")
        .clickNextButton(new HowFrequentlyYouExperienceUrinaryLeakageCC());
        
        //----------Q5 During a typical day, how frequently do you experience urinary leakage?" Page ---------------   
        howFrequentlyYouExperienceUrinaryLeakageCC.waitForPageLoad();
        Assert.assertEquals(howFrequentlyYouExperienceUrinaryLeakageCC.getTitleText(),howFrequentlyYouExperienceUrinaryLeakageCC.titleExpected, "Title is diff");    
        howFrequentlyYouExperienceUrinaryLeakageCC
        .clickOnAnswer("Less than once per day (some days I experience it, while other days I do not)")
        .clickNextButton(new HaveYouEverUsedTherapiesTreatCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(howFrequentlyYouExperienceUrinaryLeakageCC.titleExpected).contains(protocol1));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        HaveYouEverUsedTherapiesTreatCC haveYouEverUsedTherapiesTreatCC = howFrequentlyYouExperienceUrinaryLeakageCC //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswer("More than once per day")
        .clickNextButton(new HaveYouEverUsedTherapiesTreatCC());

        
        //----------Q6 Have you ever used any of the following therapies to treat urinary leakage? Page ---------------   
        haveYouEverUsedTherapiesTreatCC.waitForPageLoad();     
        Assert.assertEquals(haveYouEverUsedTherapiesTreatCC.getTitleText(),haveYouEverUsedTherapiesTreatCC.titleExpected, "Title is diff");  
        haveYouEverUsedTherapiesTreatCC
        .clickOnAnswers("Pelvic floor exercises - Kegel or other pelvic muscle exercises designed to improve bladder control and reduce or stop leakage of urine","Urethral bulking - material such as collagen or a water-based gel is injected around the urethra; this narrows the urethra so leakage is less likely to occur");
        HaveYouEverHadAnyPelvicSurgeriesCC haveYouEverHadAnyPelvicSurgeriesCC = haveYouEverUsedTherapiesTreatCC   //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new HaveYouEverHadAnyPelvicSurgeriesCC()); // Click NEXT button and wait for the NEXT page
 
        
        //----------Q7 "SUI_SubQuestions" page -   Have you ever had any of the following pelvic surgeries or procedures? ---------------   
        haveYouEverHadAnyPelvicSurgeriesCC.waitForPageLoad();     
        Assert.assertEquals(haveYouEverHadAnyPelvicSurgeriesCC.getTitleText(),haveYouEverHadAnyPelvicSurgeriesCC.titleExpected, "Title is diff");  
        SUI_SubQuestionsCC sUI_SubQuestions = haveYouEverHadAnyPelvicSurgeriesCC   //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("Urethral sling - a sling is placed around the urethra to lift it back into a normal position, and to exert pressure to aid in urine","Culposuspension - a surgical procedure that provides support for the bladder","Pelvic radiation - uses high-energy beams to treat certain pelvic conditions")
        .clickNextButton(new SUI_SubQuestionsCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(haveYouEverHadAnyPelvicSurgeriesCC.titleExpected).contains(protocol1));
        debugPageCC.back();
        haveYouEverHadAnyPelvicSurgeriesCC.waitForPageLoad();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        haveYouEverHadAnyPelvicSurgeriesCC.clickOnAnswers("None of the above")
        .clickOnAnswers("Vaginal rejuvenation or MonaLisa Touch - laser treatment for vaginal atrophy")
        .clickNextButton(new SUI_SubQuestionsCC());        
        
                
        //----------Q8.1 Have you had pelvic floor physical therapy (meaning that you worked with a physical therapist to improve functioning of the pelvic floor muscles) within the past 30 days? -  Page ---------------   
        //----------Q8.2 Have you had a urethral bulking injection within the past 6 months? -  Page ---------------   
        //----------Q8.3 Have you had a vaginal rejuvenation or MonaLisa Touch procedure within the past 6 months? page---------------   
        sUI_SubQuestions.waitForPageLoad();
        Assert.assertEquals(sUI_SubQuestions.getTitleText(1),sUI_SubQuestions.titleExpected1, "Title is diff");
        Assert.assertEquals(sUI_SubQuestions.getTitleText(2),sUI_SubQuestions.titleExpected2, "Title is diff");
        Assert.assertEquals(sUI_SubQuestions.getTitleText(3),sUI_SubQuestions.titleExpected3, "Title is diff");
        HaveYouGoneThroughMenopauseCC haveYouGoneThroughMenopauseCC  = sUI_SubQuestions
                .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected1,"Yes")
                .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected2,"Yes")
                .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected3,"Yes")
                .clickNextButton(new HaveYouGoneThroughMenopauseCC());
        haveYouGoneThroughMenopauseCC
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkProtocolsEquals("null", protocol1)
                        .back();
        sUI_SubQuestions
        				.waitForPageLoad()
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected1,"No")
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected2,"No")
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected3,"No")
                        .clickNextButton(haveYouGoneThroughMenopauseCC);
        
        
        //----------Q9 -Have you gone through menopause?  -  Page ---------------   
        haveYouGoneThroughMenopauseCC
        		.waitForPageLoad();  
        Assert.assertEquals(haveYouGoneThroughMenopauseCC.getTitleText(), haveYouGoneThroughMenopauseCC.titleExpected, "Title is diff");    
        TransitionStatementSUI_CC transitionStatementSUI_CC = haveYouGoneThroughMenopauseCC //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("No")
        .clickNextButton(new TransitionStatementSUI_CC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(haveYouGoneThroughMenopauseCC.titleExpected).contains(protocol1));
        debugPageCC.back();
        haveYouGoneThroughMenopauseCC.waitForPageLoad();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        haveYouGoneThroughMenopauseCC.clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
        .clickNextButton(new TransitionStatementSUI_CC());     
        
     		
      //----------Q11 -Transition Statement - Display for Call Center only-------------
        transitionStatementSUI_CC 
        .waitForPageLoad("urinary health");
        Assert.assertEquals(transitionStatementSUI_CC.getTitleText(), transitionStatementSUI_CC.getTitleExpected(studyName), "Title is difff");
        HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = transitionStatementSUI_CC
        .clickNextButton(new HasHealthcareProfessionalPageCC());

       
      //----------Q12 -Non-QR Transition Statement - Display for Call Center only-------------

        
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
                .clickOnAnswer("Yes")
         //----------PEDIATRIC HEALTH Questions----------
                .clickNextButton(new HouseholdHavePageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TheStudySitePageCC())
                .waitForPageLoad()
                .clickOnAnswer("Other")
//                .clickNextButton(new WouldYouUsePageCC())
//                .waitForPageLoad()
//                .clickOnAnswers("Neither")
                .clickNextButton(new WhatMedicalCoveragePageCC())
                .waitForPageLoad()
                .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)              
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a women's bladder control study")
                .getPID()
                .clickOnAnswer(siteName)
                 //QualifiedClose2PageCC
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

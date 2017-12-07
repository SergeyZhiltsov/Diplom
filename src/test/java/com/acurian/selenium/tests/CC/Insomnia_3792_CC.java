package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatSortPageOLS;
import com.acurian.selenium.pages.CC.Insomnia_3792.AreYouCurrentlyTakingAnyOverTheCounterMedications_CC;
import com.acurian.selenium.pages.CC.Insomnia_3792.AreYouCurrentlyTakingAnyPrescriptionNedications_CC;
import com.acurian.selenium.pages.CC.Insomnia_3792.HasAHealthcareProfessionalEverDiagnosedYou_CC;
import com.acurian.selenium.pages.CC.Insomnia_3792.HowLongHaveYouExperiencedSleepProblems_CC;
import com.acurian.selenium.pages.CC.Insomnia_3792.HowManyNightsPerWeekAreYouBothered_CC;
import com.acurian.selenium.pages.CC.Insomnia_3792.IfYouAreCurrentlyWorkingInvolveNightShift_CC;
import com.acurian.selenium.pages.CC.Insomnia_3792.InTotalHowLongAreYouUsuallyAwakeDuringNight_CC;
import com.acurian.selenium.pages.CC.Insomnia_3792.WhatTmeYouUsuallyGoToBed_CC;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
import com.acurian.selenium.pages.CC.LBP_2108.HasYourLbpPainCausedPageCC;
import com.acurian.selenium.pages.CC.LBP_2108.InPastYear;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Insomnia_3792.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.pediatric.*;
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
import com.acurian.selenium.pages.CC.generalHealth.HaveYouUndergoneAnyPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartFailureIsAlsoPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartrelatedMedicalProceduresPageCC;
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
import java.util.Arrays;
import java.util.List;


public class Insomnia_3792_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00001")
    @Description(" 1. Open the page, URL: " +
            	 " 2. Type login and correct password of registered user" +
    			 " 3. Click the Sign In button")
    public void tc001Test(final String username, final String password) {
        String phoneNumberINS = "AUTAMS1INS";
        String protocol1 = "E2006_G000_303";
        String protocol2 = "E2006_G000_304";
        String studyName = "an insomnia";  
        String studyName1 = "insomnia";  
        String env = "STG";  //Enter which CC environment to use for testing
        String siteName = "AUT_INSO_3792_Site";
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
                .typePhoneNumber(phoneNumberINS)
                .clickPopupPhoneNumber(phoneNumberINS)
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedInsomnia_3792, "Title is diff");
       
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Aug")
                .setDay("1")
                .setYear("1950")
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
        DoYouSufferFromInsomnia_CC doYouSufferFromInsomnia_CC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromInsomnia_CC());
        
        
        //------------Q2 - "DoYouSufferFromInsomnia_CC" ---------------   
        doYouSufferFromInsomnia_CC
        	.waitForPageLoad();
        Assert.assertEquals(doYouSufferFromInsomnia_CC.getTitleText(), doYouSufferFromInsomnia_CC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = doYouSufferFromInsomnia_CC    //[create NEXT PAGE Object = THIS page object] 
        	.clickOnAnswer("No")
        	.clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
        	.waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC
        	.checkProtocolsEquals(doYouSufferFromInsomnia_CC.titleExpected, protocol1, protocol2)
            .back();
        doYouSufferFromInsomnia_CC.waitForPageLoad()
        	.clickOnAnswer("Yes");
        DoYouCurrentlyHaveDifficulty_CC doYouCurrentlyHaveDifficulty_CC = doYouSufferFromInsomnia_CC   //[create NEXT PAGE Object = THIS page object] 
        .clickNextButton(new DoYouCurrentlyHaveDifficulty_CC());
 
        
        //-----------Q3 -Do you currently have difficulty with any of the following? ---------------   
        doYouCurrentlyHaveDifficulty_CC
        .waitForPageLoad();
        Assert.assertEquals(doYouCurrentlyHaveDifficulty_CC.getTitleText(), doYouCurrentlyHaveDifficulty_CC.titleExpected, "Title is diff");
      
        WhatTmeYouUsuallyGoToBed_CC whatTmeYouUsuallyGoToBed_CC = doYouCurrentlyHaveDifficulty_CC  //[create NEXT PAGE Object = THIS page object] 
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhatTmeYouUsuallyGoToBed_CC())
                .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageCC.checkProtocolsEquals("Do you currently have difficulty with any of the following?Agent Note: Select all that applyDo you c...", protocol2, protocol1);
        debugPageCC.back();
        //------------ Change your answer to correct QR ---------------   
        doYouCurrentlyHaveDifficulty_CC  
        .waitForPageLoad()     
        .clickOnAnswers("Staying asleep during the night","Awakening earlier in the morning than you want")
        .clickNextButton(new WhatTmeYouUsuallyGoToBed_CC());
        
        
        //----------Q4 What time do you usually go to bed to try to sleep? -  Page ---------------   
        whatTmeYouUsuallyGoToBed_CC
        		.waitForPageLoad();
        Assert.assertEquals(whatTmeYouUsuallyGoToBed_CC.getTitleText(), whatTmeYouUsuallyGoToBed_CC.titleExpected, "Title is diff");
        InTotalHowLongAreYouUsuallyAwakeDuringNight_CC inTotalHowLongAreYouUsuallyAwakeDuringNight_CC= whatTmeYouUsuallyGoToBed_CC
        .selectGo_to_bed("V") //Select 9:00PM
        .selectGet_out_of_bed("G")  //Select 6:00AM
        .clickNextButton(new InTotalHowLongAreYouUsuallyAwakeDuringNight_CC()); // Click NEXT button and wait for the NEXT page
        
        
        
        //----------Q5 "In total, after first falling asleep, how long are you usually awake during the night?" Page ---------------   
        inTotalHowLongAreYouUsuallyAwakeDuringNight_CC.waitForPageLoad();
        Assert.assertEquals(inTotalHowLongAreYouUsuallyAwakeDuringNight_CC.getTitleText(),inTotalHowLongAreYouUsuallyAwakeDuringNight_CC.titleExpected, "Title is diff");
        HowManyNightsPerWeekAreYouBothered_CC howManyNightsPerWeekAreYouBothered_CC = inTotalHowLongAreYouUsuallyAwakeDuringNight_CC
        .clickOnAnswer("Less than 1 hour")
        .clickNextButton(new HowManyNightsPerWeekAreYouBothered_CC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageCC.getProtocolForQuestion(inTotalHowLongAreYouUsuallyAwakeDuringNight_CC.titleExpected).contains(protocol2));
        debugPageCC.back();
        //------------ Change your answer to correct QR ---------------   
        inTotalHowLongAreYouUsuallyAwakeDuringNight_CC
        .waitForPageLoad()
        .clickOnAnswer("More than 2 hours")
        .clickNextButton(new HowManyNightsPerWeekAreYouBothered_CC());
           
        //----------Q6 How many nights per week are you usually bothered by these sleep problems? - Page ---------------   
        howManyNightsPerWeekAreYouBothered_CC.waitForPageLoad();     
        Assert.assertEquals(howManyNightsPerWeekAreYouBothered_CC.getTitleText(),howManyNightsPerWeekAreYouBothered_CC.titleExpected, "Title is diff");  
        howManyNightsPerWeekAreYouBothered_CC
        .clickOnAnswer("Less than 1 night per week");
        HowLongHaveYouExperiencedSleepProblems_CC howLongHaveYouExperiencedSleepProblems_CC = howManyNightsPerWeekAreYouBothered_CC   //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new HowLongHaveYouExperiencedSleepProblems_CC()) // Click NEXT button and wait for the NEXT page
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageCC.checkProtocolsEquals(howManyNightsPerWeekAreYouBothered_CC.titleExpected, protocol2, protocol1);
        debugPageCC.back(); 
        howManyNightsPerWeekAreYouBothered_CC  
        .waitForPageLoad()     
        .clickOnAnswer("1 - 2 nights per week")
        .clickNextButton(new HowLongHaveYouExperiencedSleepProblems_CC())
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageCC.checkProtocolsEquals(howManyNightsPerWeekAreYouBothered_CC.titleExpected, protocol2, protocol1);
        debugPageCC.back();
        //------------ Change your answer to correct QR ---------------   
        howManyNightsPerWeekAreYouBothered_CC  
        .waitForPageLoad()     
        .clickOnAnswer("3 - 4 nights per week")
        .clickNextButton(new HowLongHaveYouExperiencedSleepProblems_CC());
        
       
        //----------Q7 "How long have you experienced these sleep problems?" page ---------------   
        howLongHaveYouExperiencedSleepProblems_CC.waitForPageLoad();     
        Assert.assertEquals(howLongHaveYouExperiencedSleepProblems_CC.getTitleText(),howLongHaveYouExperiencedSleepProblems_CC.titleExpected, "Title is diff");  
        howLongHaveYouExperiencedSleepProblems_CC
        .clickOnAnswer("Less than 1 month");
        AreYouCurrentlyTakingAnyPrescriptionNedications_CC areYouCurrentlyTakingAnyPrescriptionNedications_CC = howLongHaveYouExperiencedSleepProblems_CC   //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new AreYouCurrentlyTakingAnyPrescriptionNedications_CC()) // Click NEXT button and wait for the NEXT page
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageCC.checkProtocolsEquals(howLongHaveYouExperiencedSleepProblems_CC.titleExpected, protocol2, protocol1);
        debugPageCC.back(); 
        howLongHaveYouExperiencedSleepProblems_CC  
        .waitForPageLoad()     
        .clickOnAnswer("1 - 2 months")
        .clickNextButton(new AreYouCurrentlyTakingAnyPrescriptionNedications_CC())
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageCC.checkProtocolsEquals(howLongHaveYouExperiencedSleepProblems_CC.titleExpected, protocol2, protocol1);
        debugPageCC.back();
        //------------ Change your answer to correct QR ---------------   
        howLongHaveYouExperiencedSleepProblems_CC  
        .waitForPageLoad()     
        .clickOnAnswer("3 - 4 months")
        .clickNextButton(new AreYouCurrentlyTakingAnyPrescriptionNedications_CC());                         
        
        
        //----------Q8 -"Are you currently taking any of the following prescription medications to help you sleep?" -  Page ---------------   
        areYouCurrentlyTakingAnyPrescriptionNedications_CC
        		.waitForPageLoad();  
        Assert.assertEquals(areYouCurrentlyTakingAnyPrescriptionNedications_CC.getTitleText(), areYouCurrentlyTakingAnyPrescriptionNedications_CC.titleExpected, "Title is diff");    
        AreYouCurrentlyTakingAnyOverTheCounterMedications_CC areYouCurrentlyTakingAnyOverTheCounterMedications_CC = areYouCurrentlyTakingAnyPrescriptionNedications_CC //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("None of the above")
        .clickNextButton(new AreYouCurrentlyTakingAnyOverTheCounterMedications_CC()); // Click NEXT button and wait for the NEXT page  
        
        
        //----------Q9 -"Are you currently taking any over-the-counter medications or herbal supplements to help you sleep?" -  Page ---------------   
        areYouCurrentlyTakingAnyOverTheCounterMedications_CC
		.waitForPageLoad();  
        Assert.assertEquals(areYouCurrentlyTakingAnyOverTheCounterMedications_CC.getTitleText(), areYouCurrentlyTakingAnyOverTheCounterMedications_CC.titleExpected, "Title is diff");    
        HasAHealthcareProfessionalEverDiagnosedYou_CC hasAHealthcareProfessionalEverDiagnosedYou_CC = areYouCurrentlyTakingAnyOverTheCounterMedications_CC //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("No")
       	.clickNextButton(new HasAHealthcareProfessionalEverDiagnosedYou_CC()); // Click NEXT button and wait for the NEXT page  
        
        
        //----------Q10 -"Has a healthcare professional ever diagnosed you with any of the following sleep related conditions?" -  Page ---------------   
        hasAHealthcareProfessionalEverDiagnosedYou_CC.waitForPageLoad();
        Assert.assertEquals(hasAHealthcareProfessionalEverDiagnosedYou_CC.getTitleText(),hasAHealthcareProfessionalEverDiagnosedYou_CC.titleExpected, "Title is diff");
        IfYouAreCurrentlyWorkingInvolveNightShift_CC ifYouAreCurrentlyWorkingInvolveNightShift_CC = hasAHealthcareProfessionalEverDiagnosedYou_CC
        .clickOnAnswers("Circadian rhythm sleep disorder","Restless leg syndrome","Periodic limb movement disorder")
        .clickNextButton(new IfYouAreCurrentlyWorkingInvolveNightShift_CC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        ifYouAreCurrentlyWorkingInvolveNightShift_CC.waitForPageLoad();
        debugPageCC.checkProtocolsEquals(hasAHealthcareProfessionalEverDiagnosedYou_CC.titleExpected, protocol2, protocol1);
        debugPageCC.back();
        //------------ Change your answer to correct QR ---------------   
        hasAHealthcareProfessionalEverDiagnosedYou_CC
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new IfYouAreCurrentlyWorkingInvolveNightShift_CC());        
             
        
        //----------Q11 -"If you are currently working, does your schedule involve a night shift, either permanent or rotating?" -  Page ---------------   
        ifYouAreCurrentlyWorkingInvolveNightShift_CC.waitForPageLoad();
        Assert.assertEquals(ifYouAreCurrentlyWorkingInvolveNightShift_CC.getTitleText(),ifYouAreCurrentlyWorkingInvolveNightShift_CC.titleExpected, "Title is diff");
        TransitionStatementCC transitionStatementCC = ifYouAreCurrentlyWorkingInvolveNightShift_CC
        .clickOnAnswer("Yes")
        .clickNextButton(new TransitionStatementCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        debugPageCC.checkProtocolsEquals(ifYouAreCurrentlyWorkingInvolveNightShift_CC.titleExpected, protocol2, protocol1);
        debugPageCC.back();
        //------------ Change your answer to correct QR ---------------   
        ifYouAreCurrentlyWorkingInvolveNightShift_CC
        .waitForPageLoad()
        .clickOnAnswer("This does not apply to me")
        .clickNextButton(new HasHealthcareProfessionalPageCC());
        
        
     		
      //----------Q11 -Transition Statement - Display for Call Center only-------------
        transitionStatementCC
        .getTitleExpectedWithCurves(studyName1);
        Assert.assertEquals(transitionStatementCC.getTitleText(), transitionStatementCC.getTitleExpectedWithCurves(studyName1), "Title is difff");
        HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = transitionStatementCC
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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)              
                .clickNextButton(new SiteSelectionPageCC())
                .threadSleep(6000);  //wait 15  secs
                 new SiteSelectionPageCC()
                .getPID()
                .clickOnAnswer(siteName)
                 //QualifiedClose2PageCC
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();
    }
}

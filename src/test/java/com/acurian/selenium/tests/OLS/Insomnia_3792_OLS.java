package com.acurian.selenium.tests.OLS;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.MainPage;
import com.acurian.selenium.pages.OLS.Insomnia_3792.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.OLS.closes.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import com.acurian.selenium.pages.OLS.SUI_3923.DoYouExperienceUrinaryIncontinenceOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;

public class Insomnia_3792_OLS extends BaseTest{

    @Test
    @TestCaseId("00003")
    @Description("Stress Urinary Incontinence (SUI) - 3923")
    public void tc002Test() {
        String phoneNumberINS = "AUTAMS1INS";
        String protocol1 = "E2006_G000_303";
        String protocol2 = "E2006_G000_304";
        String studyName =  "an insomnia";  
        String env = "STG";  //Enter which OLS environment to use for testing
        String siteName = "AUT_INSO_3792_Site";
        String zip_Code = "19044";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberINS)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleInsomnia_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091950")
                .clickNextButton(new ZipCodePageOLS());

        //------------ZIP_CODE question---------------      
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zip_Code)
                .clickNextButton(new GenderPageOLS());

        //------------GENDER question---------------      
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DoYouSufferFromInsomnia_OLS doYouSufferFromInsomnia_OLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromInsomnia_OLS());
             
       //------------Q2 Do you suffer from insomnia, or do you sometimes have difficulty falling or staying asleep?---------------      
        doYouSufferFromInsomnia_OLS
        .waitForPageLoad();
        Assert.assertEquals(doYouSufferFromInsomnia_OLS.getTitleText(),doYouSufferFromInsomnia_OLS.titleExpected, "Title is diff");
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = doYouSufferFromInsomnia_OLS
        .clickOnAnswer("No")
        .clickNextButton(new HasHealthcareProfessionalPageOLS()); 
        //------Validate protocol DQs in debug window----------
        hasHealthcareProfessionalPageOLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(doYouSufferFromInsomnia_OLS.titleExpected, protocol2, protocol1);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to correct option in DoYouSufferFromMigPageOLS---------------          
        DoYouCurrentlyHaveDifficulty_OLS doYouCurrentlyHaveDifficulty_OLS = doYouSufferFromInsomnia_OLS  //[create NEXT PAGE Object = THIS page object] 
        .waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new DoYouCurrentlyHaveDifficulty_OLS());    
       
        
        //-----------Q3 -Do you currently have difficulty with any of the following? ---------------   
        doYouCurrentlyHaveDifficulty_OLS
        .waitForPageLoad();
        Assert.assertEquals(doYouCurrentlyHaveDifficulty_OLS.getTitleText(), doYouCurrentlyHaveDifficulty_OLS.titleExpected, "Title is diff");
      
        WhatTmeYouUsuallyGoToBed_OLS whatTmeYouUsuallyGoToBed_OLS = doYouCurrentlyHaveDifficulty_OLS  //[create NEXT PAGE Object = THIS page object] 
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhatTmeYouUsuallyGoToBed_OLS())
                .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageOLS.checkProtocolsEquals("Do you currently have difficulty with any of the following?Agent Note: Select all that applyDo you c...", protocol2, protocol1);
        debugPageOLS.back();
        //------------ Change your answer to correct QR ---------------   
        doYouCurrentlyHaveDifficulty_OLS  
        .waitForPageLoad()     
        .clickOnAnswers("Staying asleep during the night","Awakening earlier in the morning than you want")
        .clickNextButton(new WhatTmeYouUsuallyGoToBed_OLS());
       
        
        //----------Q4 What time do you usually go to bed to try to sleep? -  Page ---------------   
        whatTmeYouUsuallyGoToBed_OLS
        		.waitForPageLoad();
        Assert.assertEquals(whatTmeYouUsuallyGoToBed_OLS.getTitleText(), whatTmeYouUsuallyGoToBed_OLS.titleExpected, "Title is diff");
        InTotalHowLongAreYouUsuallyAwakeDuringNight_OLS inTotalHowLongAreYouUsuallyAwakeDuringNight_OLS= whatTmeYouUsuallyGoToBed_OLS
        .selectGo_to_bed("string:V") //Select 9:00PM
        .selectGet_out_of_bed("string:G")  //Select 6:00AM
        .clickNextButton(new InTotalHowLongAreYouUsuallyAwakeDuringNight_OLS()); // Click NEXT button and wait for the NEXT page
        
        
        //----------Q5 "In total, after first falling asleep, how long are you usually awake during the night?" Page ---------------   
        inTotalHowLongAreYouUsuallyAwakeDuringNight_OLS.waitForPageLoad();
        Assert.assertEquals(inTotalHowLongAreYouUsuallyAwakeDuringNight_OLS.getTitleText(),inTotalHowLongAreYouUsuallyAwakeDuringNight_OLS.titleExpected, "Title is diff");
        HowManyNightsPerWeekAreYouBothered_OLS howManyNightsPerWeekAreYouBothered_OLS = inTotalHowLongAreYouUsuallyAwakeDuringNight_OLS
        .clickOnAnswer("Less than 1 hour")
        .clickNextButton(new HowManyNightsPerWeekAreYouBothered_OLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(inTotalHowLongAreYouUsuallyAwakeDuringNight_OLS.titleExpected).contains(protocol2));
        debugPageOLS.back();
        //------------ Change your answer to correct QR ---------------   
        inTotalHowLongAreYouUsuallyAwakeDuringNight_OLS
        .waitForPageLoad()
        .clickOnAnswer("More than 2 hours")
        .clickNextButton(new HowManyNightsPerWeekAreYouBothered_OLS());
           
        //----------Q6 How many nights per week are you usually bothered by these sleep problems? - Page ---------------   
        howManyNightsPerWeekAreYouBothered_OLS.waitForPageLoad();     
        Assert.assertEquals(howManyNightsPerWeekAreYouBothered_OLS.getTitleText(),howManyNightsPerWeekAreYouBothered_OLS.titleExpected, "Title is diff");  
        howManyNightsPerWeekAreYouBothered_OLS
        .clickOnAnswer("Less than 1 night per week");
        HowLongHaveYouExperiencedSleepProblems_OLS howLongHaveYouExperiencedSleepProblems_OLS = howManyNightsPerWeekAreYouBothered_OLS   //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new HowLongHaveYouExperiencedSleepProblems_OLS()) // Click NEXT button and wait for the NEXT page
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageOLS.checkProtocolsEquals(howManyNightsPerWeekAreYouBothered_OLS.titleExpected, protocol2, protocol1);
        debugPageOLS.back(); 
        howManyNightsPerWeekAreYouBothered_OLS  
        .waitForPageLoad()     
        .clickOnAnswer("1 - 2 nights per week")
        .clickNextButton(new HowLongHaveYouExperiencedSleepProblems_OLS())
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageOLS.checkProtocolsEquals(howManyNightsPerWeekAreYouBothered_OLS.titleExpected, protocol2, protocol1);
        debugPageOLS.back();
        //------------ Change your answer to correct QR ---------------   
        howManyNightsPerWeekAreYouBothered_OLS  
        .waitForPageLoad()     
        .clickOnAnswer("3 - 4 nights per week")
        .clickNextButton(new HowLongHaveYouExperiencedSleepProblems_OLS());
        
       
        //----------Q7 "How long have you experienced these sleep problems?" page ---------------   
        howLongHaveYouExperiencedSleepProblems_OLS.waitForPageLoad();     
        Assert.assertEquals(howLongHaveYouExperiencedSleepProblems_OLS.getTitleText(),howLongHaveYouExperiencedSleepProblems_OLS.titleExpected, "Title is diff");  
        howLongHaveYouExperiencedSleepProblems_OLS
        .clickOnAnswer("Less than 1 month");
        AreYouCurrentlyTakingAnyPrescriptionNedications_OLS areYouCurrentlyTakingAnyPrescriptionNedications_OLS = howLongHaveYouExperiencedSleepProblems_OLS   //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new AreYouCurrentlyTakingAnyPrescriptionNedications_OLS()) // Click NEXT button and wait for the NEXT page
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageOLS.checkProtocolsEquals(howLongHaveYouExperiencedSleepProblems_OLS.titleExpected, protocol2, protocol1);
        debugPageOLS.back(); 
        howLongHaveYouExperiencedSleepProblems_OLS  
        .waitForPageLoad()     
        .clickOnAnswer("1 - 2 months")
        .clickNextButton(new AreYouCurrentlyTakingAnyPrescriptionNedications_OLS())
        .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        debugPageOLS.checkProtocolsEquals(howLongHaveYouExperiencedSleepProblems_OLS.titleExpected, protocol2, protocol1);
        debugPageOLS.back();
        //------------ Change your answer to correct QR ---------------   
        howLongHaveYouExperiencedSleepProblems_OLS  
        .waitForPageLoad()     
        .clickOnAnswer("3 - 4 months")
        .clickNextButton(new AreYouCurrentlyTakingAnyPrescriptionNedications_OLS());                         
        
        
        //----------Q8 -"Are you currently taking any of the following prescription medications to help you sleep?" -  Page ---------------   
        areYouCurrentlyTakingAnyPrescriptionNedications_OLS
        		.waitForPageLoad();  
        Assert.assertEquals(areYouCurrentlyTakingAnyPrescriptionNedications_OLS.getTitleText(), areYouCurrentlyTakingAnyPrescriptionNedications_OLS.titleExpected, "Title is diff");    
        AreYouCurrentlyTakingAnyOverTheCounterMedications_OLS areYouCurrentlyTakingAnyOverTheCounterMedications_OLS = areYouCurrentlyTakingAnyPrescriptionNedications_OLS //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("None of the above")
        .clickNextButton(new AreYouCurrentlyTakingAnyOverTheCounterMedications_OLS()); // Click NEXT button and wait for the NEXT page  
        
        
        //----------Q9 -"Are you currently taking any over-the-counter medications or herbal supplements to help you sleep?" -  Page ---------------   
        areYouCurrentlyTakingAnyOverTheCounterMedications_OLS
		.waitForPageLoad();  
        Assert.assertEquals(areYouCurrentlyTakingAnyOverTheCounterMedications_OLS.getTitleText(), areYouCurrentlyTakingAnyOverTheCounterMedications_OLS.titleExpected, "Title is diff");    
        HasAHealthcareProfessionalEverDiagnosedYou_OLS hasAHealthcareProfessionalEverDiagnosedYou_OLS = areYouCurrentlyTakingAnyOverTheCounterMedications_OLS //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("No")
       	.clickNextButton(new HasAHealthcareProfessionalEverDiagnosedYou_OLS()); // Click NEXT button and wait for the NEXT page  
        
        
        //----------Q10 -"Has a healthcare professional ever diagnosed you with any of the following sleep related conditions?" -  Page ---------------   
        hasAHealthcareProfessionalEverDiagnosedYou_OLS.waitForPageLoad();
        Assert.assertEquals(hasAHealthcareProfessionalEverDiagnosedYou_OLS.getTitleText(),hasAHealthcareProfessionalEverDiagnosedYou_OLS.titleExpected, "Title is diff");
        IfYouAreCurrentlyWorkingInvolveNightShift_OLS ifYouAreCurrentlyWorkingInvolveNightShift_OLS = hasAHealthcareProfessionalEverDiagnosedYou_OLS
        .clickOnAnswers("Circadian rhythm sleep disorder","Restless leg syndrome","Periodic limb movement disorder")
        .clickNextButton(new IfYouAreCurrentlyWorkingInvolveNightShift_OLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        ifYouAreCurrentlyWorkingInvolveNightShift_OLS.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(hasAHealthcareProfessionalEverDiagnosedYou_OLS.titleExpected, protocol2, protocol1);
        debugPageOLS.back();
        //------------ Change your answer to correct QR ---------------   
        hasAHealthcareProfessionalEverDiagnosedYou_OLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new IfYouAreCurrentlyWorkingInvolveNightShift_OLS());        
             
        
        //----------Q11 -"If you are currently working, does your schedule involve a night shift, either permanent or rotating?" -  Page ---------------   
        ifYouAreCurrentlyWorkingInvolveNightShift_OLS.waitForPageLoad();
        Assert.assertEquals(ifYouAreCurrentlyWorkingInvolveNightShift_OLS.getTitleText(),ifYouAreCurrentlyWorkingInvolveNightShift_OLS.titleExpected, "Title is diff");
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS1 = ifYouAreCurrentlyWorkingInvolveNightShift_OLS
        .clickOnAnswer("Yes")
        .clickNextButton(new HasHealthcareProfessionalPageOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        debugPageOLS.checkProtocolsEquals(ifYouAreCurrentlyWorkingInvolveNightShift_OLS.titleExpected, protocol2, protocol1);
        debugPageOLS.back();
        //------------ Change your answer to correct QR ---------------   
        ifYouAreCurrentlyWorkingInvolveNightShift_OLS
        .waitForPageLoad()
        .clickOnAnswer("This does not apply to me")
        .clickNextButton(new HasHealthcareProfessionalPageOLS());
        
     
        
      //----------GENERAL HEALTH Questions----------     
		//----------HasHealthcareProfessionalPageOLS Page--------------------
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = hasHealthcareProfessionalPageOLS1
        		.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

		//----------HeartRelatedMedicalProc Page--------------------			
		CongestiveHeartFailurePageOLS congestiveHeartFailurePageOLS = heartrelatedMedicalProceduresPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new CongestiveHeartFailurePageOLS());
		
		//----------CongestiveHeartFailurePageOLS (CHF) Page--------------------		
		AffectingYourMetabolismPageOLS affectingYourMetabolismPageOLS = congestiveHeartFailurePageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new AffectingYourMetabolismPageOLS());
		
		//----------AffectingYourMetabolism Page--------------------
		FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = affectingYourMetabolismPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new FollowingNeurologicalConditionsPageOLS());		
		
		//----------NeurologicalConditions Page--------------------
		AffectYourLungsPageOLS affectYourLungsPageOLS = followingNeurologicalConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new AffectYourLungsPageOLS());

		//----------AffectYourL-ungs Page--------------------
		DigestiveConditionsPageOLS digestiveConditionsPageOLS = affectYourLungsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new DigestiveConditionsPageOLS());

		//----------DigestiveConditions Page--------------------
		BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = digestiveConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new BoneOrJointConditionsPageOLS());
		
/*		//----------BoneOrJointConditions Page--------------------		
		BoneOrJointConditions boneOrJointConditions = boneOrJointConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new BoneOrJointConditions());*/
			
		//----------BoneOrJointConditions Page--------------------
		SleepRelatedConditionsPageOLS sleepRelatedConditionsPageOLS = boneOrJointConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SleepRelatedConditionsPageOLS());

		//----------SleepRelatedConditions Page--------------------
		SkinConditionsPageOLS skinConditionsPageOLS = sleepRelatedConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SkinConditionsPageOLS());
		
		//----------SkinConditions Page--------------------
		ViralConditionsPageOLS viralConditionsPageOLS = skinConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ViralConditionsPageOLS());
		
		//----------ViralConditions Page--------------------
		MentalHealthPageOLS mentalHealthPageOLS = viralConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new MentalHealthPageOLS());
		
		//----------MentalHealthConditions Page--------------------
		WomensHealthPageOLS womensHealthPageOLS = mentalHealthPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new WomensHealthPageOLS());
		
		//----------WomenHealthConditions Page--------------------
		OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = womensHealthPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new OtherThanSkinCancerPageOLS());
		
		//----------Cancer Page--------------------
		SmokedCigarettesPageOLS smokedCigarettesPageOLS = otherThanSkinCancerPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new SmokedCigarettesPageOLS());
		
		//----------HaveYouSmokedCigarettes Page--------------------
		HistoryOfDrugPageOLS historyOfDrugPageOLS = smokedCigarettesPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No, I never smoked")
				.clickNextButton(new HistoryOfDrugPageOLS());


		//----------HistoryOfDrugPageOLS Page--------------------
		ProvideHeightWeight provideHeightWeight = historyOfDrugPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new ProvideHeightWeight());

		//----------ProvideHeight-Weight Page--------------------
		ChildrenUnderPageOLS childrenUnderPageOLS = provideHeightWeight
				.waitForPageLoad()
				.setFT("5")
				.setIN("5")
				.setWeight("155")
				.clickNextButton(new ChildrenUnderPageOLS());
		
		//----------ChildrenUnderTheAge Page--------------------
		TheStudySitePageOLS theStudySitePageOLS = childrenUnderPageOLS
				.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageOLS());
                              
        //----"theStudySitePageOLS" page --  If you qualify for a study, how would you plan to travel to and from the study site?
				theStudySitePageOLS.waitForPageLoad()
                .clickOnAnswer("Other")
                .clickNextButton(new WhatSortPageOLS())
                
		//-----"WhatSortPageOLS" -  What sort of medical coverage do you have for your doctor visits, medication, surgery, and/or testing?-
                .waitForPageLoad()
                .clickOnAnswers("None of the above (no coverage at all)")
                .clickNextButton(new EthnicBackgroundPageOLS())
                
       //----"EthnicBackgroundPageOLS" page --  Which of the following describes your ethnic background?
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new IdentificationPageOLS())
                
       //------------------PII Page-------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)
                .clickNextButton(new SiteSelectionPageOLS())
       
       //-----------------Site selection Page-------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName) //First checks if 'Additional Locations' link is displayed, if YES, click and then select the SITE 
                .clickNextButton(new GladLocationIsConvenient())
                
                //----------GladLocationIsConvenient Page--------------------
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                
        		//----------ThankYouCloseSimplePageOLS Page--------------------
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(5000);
    }
}
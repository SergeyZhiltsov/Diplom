package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.SUI_3923.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.GladLocationIsConvenient;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatSortPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ProvideHeightWeight;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SUI_3923_OLS extends BaseTest{

    @Test
    @TestCaseId("00016")
    @Description("Stress Urinary Incontinence (SUI) - 3923 OLS")
    public void tc002Test() {
        String phoneNumberLBP = "AUTAMS1SUI";
        String protocol1 = "G201002";
        String studyName = "a women's bladder control";  //"Stress Urinary Incontinence (SUI) - 3923";
        String env = "STG";  //Enter which OLS environment to use for testing
        String siteName = "AUT_SUI_3923";
        String zip_Code = "19044";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleSUI_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = genderPageOLS
                .clickOnAnswer("Male")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        //********Check Question History for DQ and then click BACK button
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion("This part of the questionnaire requires that we ask about your gender. To confirm, please tell me,...").contains(protocol1));
        debugPageOLS.back();   
        //------------ Change your answer to correct option in DoYouSufferFromMigPageOLS--------------- 
        genderPageOLS
        		.waitForPageLoad();
                DoYouExperienceUrinaryIncontinenceOLS doYouExperienceUrinaryIncontinenceOLS = genderPageOLS
        		.clickOnAnswer("Female")
                .clickNextButton(new DoYouExperienceUrinaryIncontinenceOLS());
        
        
       //------------Q2 Do you experience either of the following types of urinary leakage, sometimes called urinary incontinence?---------------      
        doYouExperienceUrinaryIncontinenceOLS
        .waitForPageLoad();
        Assert.assertEquals(doYouExperienceUrinaryIncontinenceOLS.getTitleText(),doYouExperienceUrinaryIncontinenceOLS.titleExpected, "Title is diff");
        doYouExperienceUrinaryIncontinenceOLS.clickOnAnswers("None of the above")
        .clickNextButton(new HasHealthcareProfessionalPageOLS()); 
        //------Validate protocol DQs in debug window----------
        hasHealthcareProfessionalPageOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(doYouExperienceUrinaryIncontinenceOLS.titleExpected, protocol1);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to correct option in DoYouSufferFromMigPageOLS---------------          
        WhichTypeOfUrinaryLeakageYouExperienceOLS whichTypeOfUrinaryLeakageYouExperienceOLS = doYouExperienceUrinaryIncontinenceOLS  //[create NEXT PAGE Object = THIS page object] 
        .waitForPageLoad()
        .clickOnAnswers("Stress urinary leakage - leaking of urine while coughing, sneezing, laughing, jumping, or performing other activities that put pressure on the bladder","Urge urinary leakage - strong, urgent need to urinate, accidents in which you are unable to reach a bathroom in time, and occasional bed-wetting")
        .clickNextButton(new WhichTypeOfUrinaryLeakageYouExperienceOLS());    

       
        
        //-----------Q3 -Which type of urinary leakage do you experience most often? ---------------   
        whichTypeOfUrinaryLeakageYouExperienceOLS.waitForPageLoad();
        Assert.assertEquals(whichTypeOfUrinaryLeakageYouExperienceOLS.getTitleText(), whichTypeOfUrinaryLeakageYouExperienceOLS.titleExpected, "Title is diff");
      
        HowLongYouBeenExperiencingUrinaryLeakageOLS howLongYouBeenExperiencingUrinaryLeakageOLS = whichTypeOfUrinaryLeakageYouExperienceOLS  //[create NEXT PAGE Object = THIS page object] 
                .clickOnAnswer("I experience urge leakage most often")
                .clickNextButton(new HowLongYouBeenExperiencingUrinaryLeakageOLS())
                .waitForPageLoad();
        //********Validate Question History for DQ and then click BACK button
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whichTypeOfUrinaryLeakageYouExperienceOLS.titleExpected).contains(protocol1));
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageOLS---------------   
        whichTypeOfUrinaryLeakageYouExperienceOLS        
        .clickOnAnswer("I experience stress leakage most often")
        .clickNextButton(new HowLongYouBeenExperiencingUrinaryLeakageOLS())
        .waitForPageLoad();
        
        
        //----------Q4 How long have you been experiencing urinary leakage? -  Page ---------------   
        howLongYouBeenExperiencingUrinaryLeakageOLS
        		.waitForPageLoad();
        Assert.assertEquals(howLongYouBeenExperiencingUrinaryLeakageOLS.getTitleText(), howLongYouBeenExperiencingUrinaryLeakageOLS.titleExpected, "Title is diff");
        //System.out.println("see there="+debugPageOLS.getProtocolForQuestion(howOldWereYouMigHeadachePageOLS.titleExpected));       
        howLongYouBeenExperiencingUrinaryLeakageOLS
        .clickOnAnswer("1 month or less")
        .clickNextButton(new HowFrequentlyYouExperienceUrinaryLeakageOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button            
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(howLongYouBeenExperiencingUrinaryLeakageOLS.titleExpected).contains(protocol1));
        debugPageOLS.back();
        howLongYouBeenExperiencingUrinaryLeakageOLS.waitForPageLoad();
        //HowFrequentlyYouExperienceUrinaryLeakageOLS howFrequentlyYouExperienceUrinaryLeakageOLS = howLongYouBeenExperiencingUrinaryLeakageOLS //[create NEXT PAGE Object = THIS page object]      
        howLongYouBeenExperiencingUrinaryLeakageOLS.clickOnAnswer("2 - 3 months")
        .clickNextButton(new HowFrequentlyYouExperienceUrinaryLeakageOLS());
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(howLongYouBeenExperiencingUrinaryLeakageOLS.titleExpected).contains(protocol1));
        debugPageOLS.back();
        howLongYouBeenExperiencingUrinaryLeakageOLS.waitForPageLoad();
        //------------ Change your answer to correct QR age in 'howOldWereYouMigHeadachePageOLS'---------------   
        HowFrequentlyYouExperienceUrinaryLeakageOLS howFrequentlyYouExperienceUrinaryLeakageOLS = howLongYouBeenExperiencingUrinaryLeakageOLS //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswer("6 months or more")
        .clickNextButton(new HowFrequentlyYouExperienceUrinaryLeakageOLS());
        
        //----------Q5 During a typical day, how frequently do you experience urinary leakage?" Page ---------------   
        howFrequentlyYouExperienceUrinaryLeakageOLS.waitForPageLoad();
        Assert.assertEquals(howFrequentlyYouExperienceUrinaryLeakageOLS.getTitleText(),howFrequentlyYouExperienceUrinaryLeakageOLS.titleExpected, "Title is diff");    
        howFrequentlyYouExperienceUrinaryLeakageOLS
        .clickOnAnswer("Less than once per day (some days I experience it, while other days I do not)")
        .clickNextButton(new HaveYouEverUsedTherapiesTreatOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(howFrequentlyYouExperienceUrinaryLeakageOLS.titleExpected).contains(protocol1));
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
        HaveYouEverUsedTherapiesTreatOLS haveYouEverUsedTherapiesTreatOLS = howFrequentlyYouExperienceUrinaryLeakageOLS //[create NEXT PAGE Object = THIS page object]
        .waitForPageLoad()
        .clickOnAnswer("More than once per day")
        .clickNextButton(new HaveYouEverUsedTherapiesTreatOLS());
        
         //----------Q6 Have you ever used any of the following therapies to treat urinary leakage? Page ---------------   
        haveYouEverUsedTherapiesTreatOLS.waitForPageLoad();     
        Assert.assertEquals(haveYouEverUsedTherapiesTreatOLS.getTitleText(),haveYouEverUsedTherapiesTreatOLS.titleExpected, "Title is diff");  
        haveYouEverUsedTherapiesTreatOLS
        .clickOnAnswers("Pelvic floor exercises - Kegel or other pelvic muscle exercises designed to improve bladder control and reduce or stop leakage of urine","Urethral bulking - material such as collagen or a water-based gel is injected around the urethra; this narrows the urethra so leakage is less likely to occur");
        HaveYouEverHadAnyPelvicSurgeriesOLS haveYouEverHadAnyPelvicSurgeriesOLS = haveYouEverUsedTherapiesTreatOLS   //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new HaveYouEverHadAnyPelvicSurgeriesOLS()); // Click NEXT button and wait for the NEXT page
        
        //----------Q7 "SUI_SubQuestions" page -   Have you ever had any of the following pelvic surgeries or procedures? ---------------   
        haveYouEverHadAnyPelvicSurgeriesOLS.waitForPageLoad();     
        Assert.assertEquals(haveYouEverHadAnyPelvicSurgeriesOLS.getTitleText(),haveYouEverHadAnyPelvicSurgeriesOLS.titleExpected, "Title is diff");  
        SUI_SubQuestionsOLS sUI_SubQuestions = haveYouEverHadAnyPelvicSurgeriesOLS   //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("Urethral sling - a sling is placed around the urethra to lift it back into a normal position, and to exert pressure to aid in urine","Culposuspension - a surgical procedure that provides support for the bladder","Pelvic radiation - uses high-energy beams to treat certain pelvic conditions")
        .clickNextButton(new SUI_SubQuestionsOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Have you ever had any of the following pelvic surgeries or procedures?Agent Note: Select all that ap...").contains(protocol1));
        debugPageOLS.back();
        haveYouEverHadAnyPelvicSurgeriesOLS.waitForPageLoad();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
        haveYouEverHadAnyPelvicSurgeriesOLS.clickOnAnswers("None of the above")
        .clickOnAnswers("Vaginal rejuvenation or MonaLisa Touch - laser treatment for vaginal atrophy")
        .clickNextButton(new SUI_SubQuestionsOLS());        
        
                
        //----------Q8.1 Have you had pelvic floor physical therapy (meaning that you worked with a physical therapist to improve functioning of the pelvic floor muscles) within the past 30 days? -  Page ---------------   
        //----------Q8.2 Have you had a urethral bulking injection within the past 6 months? -  Page ---------------   
        //----------Q8.3 Have you had a vaginal rejuvenation or MonaLisa Touch procedure within the past 6 months? page---------------   
        sUI_SubQuestions.waitForPageLoad();
        Assert.assertEquals(sUI_SubQuestions.getTitleText(1),sUI_SubQuestions.titleExpected1, "Title is diff");
        Assert.assertEquals(sUI_SubQuestions.getTitleText(2),sUI_SubQuestions.titleExpected2, "Title is diff");
        Assert.assertEquals(sUI_SubQuestions.getTitleText(3),sUI_SubQuestions.titleExpected3, "Title is diff");
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS  = sUI_SubQuestions
                .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected1,"Yes")
                .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected2,"Yes")
                .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected3,"Yes")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        haveYouGoneThroughMenopauseOLS
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsEquals("null", protocol1)
                        .back();
        sUI_SubQuestions
        				.waitForPageLoad()
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected1,"No")
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected2,"No")
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected3,"No")
                        .clickNextButton(haveYouGoneThroughMenopauseOLS);
        
        
        //----------Q9 -Have you gone through menopause?  -  Page ---------------   
        haveYouGoneThroughMenopauseOLS
        		.waitForPageLoad();  
        Assert.assertEquals(haveYouGoneThroughMenopauseOLS.getTitleText(), haveYouGoneThroughMenopauseOLS.titleExpected, "Title is diff");    
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS1 = haveYouGoneThroughMenopauseOLS //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("No")
        .clickNextButton(new HasHealthcareProfessionalPageOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(haveYouGoneThroughMenopauseOLS.titleExpected).contains(protocol1));
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
        haveYouGoneThroughMenopauseOLS.waitForPageLoad()
        .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
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
		
		/*//----------BoneOrJointConditions Page--------------------		
		BoneOrJointConditions boneOrJointConditions = affectYourLungs
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
                .clickOnAnswers("Other")
                .clickNextButton(new WhatSortPageOLS())
                
		//-----"WhatSortPageOLS" -  What sort of medical coverage do you have for your doctor visits, medication, surgery, and/or testing?-
                .waitForPageLoad()
                .clickOnAnswers("None of the above (no coverage at all)")
                .clickNextButton(new EthnicBackgroundPageOLS())
                
       //----"EthnicBackgroundPageOLS" page --  Which of the following describes your ethnic background?
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new IdentificationPageOLS())		
				
		//----------PII (IdentificationPageOLS) Page--------------------
		.waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)
        .clickNextButton(new SiteSelectionPageOLS())
        
		//----------SiteSelection Page--------------------
        .waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new GladLocationIsConvenient())
        
        //----------GladLocationIsConvenient Page--------------------
        .waitForPageLoad()
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        
		//----------ThankYouCloseSimplePageOLS Page--------------------
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad();

    }
}

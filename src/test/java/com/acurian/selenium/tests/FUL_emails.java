package com.acurian.selenium.tests;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.OLS.SUI_3923.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.GladLocationIsConvenient;
import com.acurian.selenium.pages.OLS.closes.SiteSelection;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatSortPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ProvideHeightWeight;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

public class FUL_emails extends BaseTest{

    @Test
    @TestCaseId("00026")
    @Description("Stress Urinary Incontinence (SUI) - 3923 OLS")
    public void fUL_emails() {
        String phoneNumber = "AUTAMS1SUI";
        String studyName = "a women's bladder control";  //"Stress Urinary Incontinence (SUI) - 3923";
        String siteName = "AUT_SUI_3923";
        String zip_Code = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

      DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
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
                DoYouExperienceUrinaryIncontinenceOLS doYouExperienceUrinaryIncontinenceOLS = genderPageOLS
        		.clickOnAnswer("Female")
                .clickNextButton(new DoYouExperienceUrinaryIncontinenceOLS());
        
        
       //------------Q2 Do you experience either of the following types of urinary leakage, sometimes called urinary incontinence?---------------      
        doYouExperienceUrinaryIncontinenceOLS
        .waitForPageLoad();
        //------------ Change your answer to correct option in DoYouSufferFromMigPageOLS---------------          
        WhichTypeOfUrinaryLeakageYouExperienceOLS whichTypeOfUrinaryLeakageYouExperienceOLS = doYouExperienceUrinaryIncontinenceOLS  //[create NEXT PAGE Object = THIS page object] 
        .clickOnAnswers("Stress urinary leakage - leaking of urine while coughing, sneezing, laughing, jumping, or performing other activities that put pressure on the bladder","Urge urinary leakage - strong, urgent need to urinate, accidents in which you are unable to reach a bathroom in time, and occasional bed-wetting")
        .clickNextButton(new WhichTypeOfUrinaryLeakageYouExperienceOLS());    

       
        
        //-----------Q3 -Which type of urinary leakage do you experience most often? ---------------   
        whichTypeOfUrinaryLeakageYouExperienceOLS.waitForPageLoad();
        HowLongYouBeenExperiencingUrinaryLeakageOLS howLongYouBeenExperiencingUrinaryLeakageOLS = whichTypeOfUrinaryLeakageYouExperienceOLS  //[create NEXT PAGE Object = THIS page object] 
        .clickOnAnswer("I experience stress leakage most often")
        .clickNextButton(new HowLongYouBeenExperiencingUrinaryLeakageOLS())
        .waitForPageLoad();
        
        
        //----------Q4 How long have you been experiencing urinary leakage? -  Page ---------------   
        howLongYouBeenExperiencingUrinaryLeakageOLS
        		.waitForPageLoad();
        HowFrequentlyYouExperienceUrinaryLeakageOLS howFrequentlyYouExperienceUrinaryLeakageOLS = howLongYouBeenExperiencingUrinaryLeakageOLS //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswer("6 months or more")
        .clickNextButton(new HowFrequentlyYouExperienceUrinaryLeakageOLS());
        
        //----------Q5 During a typical day, how frequently do you experience urinary leakage?" Page ---------------   
        howFrequentlyYouExperienceUrinaryLeakageOLS.waitForPageLoad();
        HaveYouEverUsedTherapiesTreatOLS haveYouEverUsedTherapiesTreatOLS = howFrequentlyYouExperienceUrinaryLeakageOLS //[create NEXT PAGE Object = THIS page object]
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
        SUI_SubQuestionsOLS sUI_SubQuestions = haveYouEverHadAnyPelvicSurgeriesOLS   //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("Vaginal rejuvenation or MonaLisa Touch - laser treatment for vaginal atrophy")
        .clickNextButton(new SUI_SubQuestionsOLS());        
        
                
        //----------Q8.1 Have you had pelvic floor physical therapy (meaning that you worked with a physical therapist to improve functioning of the pelvic floor muscles) within the past 30 days? -  Page ---------------   
        //----------Q8.2 Have you had a urethral bulking injection within the past 6 months? -  Page ---------------   
        //----------Q8.3 Have you had a vaginal rejuvenation or MonaLisa Touch procedure within the past 6 months? page---------------   
        sUI_SubQuestions.waitForPageLoad();
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS  = sUI_SubQuestions
        				.waitForPageLoad()
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected1,"No")
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected2,"No")
                        .clickOnAnswerForSubQuestion(sUI_SubQuestions.titleExpected3,"No")
                        .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        
        
        //----------Q9 -Have you gone through menopause?  -  Page ---------------   
        haveYouGoneThroughMenopauseOLS
        		.waitForPageLoad();  
        Assert.assertEquals(haveYouGoneThroughMenopauseOLS.getTitleText(), haveYouGoneThroughMenopauseOLS.titleExpected, "Title is diff");    
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = haveYouGoneThroughMenopauseOLS //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());     
        
       
                

      //----------GENERAL HEALTH Questions----------     
		//----------HasHealthcareProfessionalPageOLS Page--------------------
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1
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
                
		//-------------------PEDIATRIC QUESTIONS-----------------------------                            
        //----"theStudySitePageOLS" page --  If you qualify for a study, how would you plan to travel to and from the study site??
				String pidAfterScreening = theStudySitePageOLS.waitForPageLoad()
                .clickOnAnswer("Public transportation")
                .clickNextButton(new WhatMedicalCoveragePageOLS())
                
		//-----"WhatMedicalCoveragePageOLS" -  What sort of medical coverage do you have for your doctor visits, medication, surgery, and/or testing?-
                .waitForPageLoad()
                .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                
       //----"EthnicBackgroundPageOLS" page --  Which of the following describes your ethnic background?
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
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
        .waitForPageLoad()
        .pidFromDbToLog(env)
		.getPid();
				
		    	
//=====================================================================================
		//------Validate FUL emails in Gmail -----
		FollowupLetter followupLetter = new FollowupLetter();
		followupLetter.Gmail_FUL_Validate(pidAfterScreening);
//=====================================================================================
		
		
		//------Validate FUL emails in Gmail -----
		/*SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
		siteSelectionPageOLS.threadSleep(50000);
		String PID = siteSelectionPageOLS.pidNumber;
				//String PID = "63275790";
    	String email_content_expected_1R = "Dear Acurian,\n" +
    			"Thank you for your recent interest in participating in one of our Stress Urinary Incontinence clinical research studies.\n" +
    			"We have forwarded your information to the study doctor’s office that you selected. If the study doctor’s office has not already contacted you, they should be contacting you within the next few days to further discuss the study and to set up an in-person evaluation.\n" +
    			"If you are not contacted within the next 5 business days, please contact them directly.\n" +
    			"The study doctor’s office that you selected is:\n" +
    			"Dr. Test PI, MD\n" +
    			"AUT_SUI_3923\n" +
    			"32 Walnut Grove Dr\n" +
    			"Horsham, PA 19044\n" +
    			"(123) 456-7899\n" +
    			"Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.\n" + 
    			"\n" +
    			"The AcurianHealth Team";
    	
    	//-----------Enter URL---------------
        driver.manage().window().maximize();
        driver.get("https://mail.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        
    	//-----------Enter EmailID and Password---------------        
        WebElement email_id = driver.findElement(By.xpath("//input[@id='identifierId']"));
        email_id.sendKeys("qa.acurian@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("automation");
        driver.findElement(By.id("passwordNext")).click();
				
        //-------Search for email using PID------------
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gbqfq']"));
        searchBox.sendKeys(PID);
        
        //-------Open the email to view the contents--------------
        WebElement email = driver.findElement(By.xpath("//table[@class='F cf zt']/tbody/tr[1]/td[@class='xY a4W']"));
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.click();
        
        WebElement actual = driver.findElement(By.xpath("//div[contains(@class,'a3s')]/descendant::table[2]//tr[2]/td[1]/div"));
        String email_content_Actual = actual.getText();
        //System.out.println(email_content_Actual);
        //System.out.println(email_content_expected_1R);
        Assert.assertTrue(email_content_Actual.contains(email_content_expected_1R));*/
}

}
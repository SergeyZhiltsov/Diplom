package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.OLS.shared.MIGAttackFrequencyOLS;


public class MIG_4356B_Synexus_OLS extends BaseTest{

    @Test(enabled = false)
    @TestCaseId("00002")
    @Description("MIG_4356B_Synexus_OLS module")
    public void mIG_4356B_Synexus_OLS() {
        String phoneNumberMIG = "AUTAMS1MIG";
        String protocol1 = "20150133";
        String protocol2 = "BHV3000_301";
        String protocol3 = "BHV3000_302";
        String protocol4 = "CGP_MD_01";
        String protocol5 = "UBR_MD_01";
        String protocol6 = "UBR_MD_02";
        String protocol7 = "BHV3000_201";
        String studyName =  "a Migraine";  //"Migraine 4356B Synexus";
 //       String env = "STG";  //Enter which OLS environment to use for testing
        String siteName = "AUT_MIG_4356B_Site";
        String zip_Code = "19044";
        String facility_Code_STG = "625252";
        String facility_Code_PRD = "625641";
       
        String env = System.getProperty("acurian.env", "STG");

        
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG);
                //.waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleMIGExpected, "Title is diff");
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
        DoYouSufferFromMigHeadachesOLS doYouSufferFromMigHeadachesOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromMigHeadachesOLS());
        
        
        //------------Do you suffer from Migraine headaches? - question---------------     
        doYouSufferFromMigHeadachesOLS
        .waitForPageLoad();
        Assert.assertEquals(doYouSufferFromMigHeadachesOLS.getTitleText(),doYouSufferFromMigHeadachesOLS.titleExpected, "Title is diff");
        HasDoctorDiagnosedYouWithClusterHeadache_OLS hasDoctorDiagnosedYouWithClusterHeadache_OLS = doYouSufferFromMigHeadachesOLS //[create NEXT PAGE Object = THIS page object]
        .clickOnAnswer("No")
        .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_OLS()); 
        //------Validate protocol DQs in debug window----------
        hasDoctorDiagnosedYouWithClusterHeadache_OLS
        .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(doYouSufferFromMigHeadachesOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol5, protocol6,protocol7);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        doYouSufferFromMigHeadachesOLS
        .waitForPageLoad();
        AgeWhenDiagnosedWithMigOLS ageWhenDiagnosedWithMigOLS = doYouSufferFromMigHeadachesOLS    //[create NEXT PAGE Object = THIS page object] 
        .clickOnAnswer("Yes")
        .clickNextButton(new AgeWhenDiagnosedWithMigOLS());        
        
        
        //------------Approximately how old were you when you were diagnosed with Migraine headaches? - question---------------   
        ageWhenDiagnosedWithMigOLS.waitForPageLoad();
        //Assert.assertEquals(ageWhenDiagnosedWithMigOLS.getTitleText(),ageWhenDiagnosedWithMigOLS.titleExpected, "Title is diff");
        ApproxHowLongSufferingFromMIGOLS approxHowLongSufferingFromMIGOLS = ageWhenDiagnosedWithMigOLS  //[create NEXT PAGE Object = THIS page object]
        .setAge("50")
        .clickNextButton(new ApproxHowLongSufferingFromMIGOLS());
        //------Validate protocol DQs in debug window----------
        approxHowLongSufferingFromMIGOLS
        .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(ageWhenDiagnosedWithMigOLS.titleExpected, protocol5, protocol1, protocol2, protocol3, protocol4, protocol6,protocol7);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        ageWhenDiagnosedWithMigOLS.waitForPageLoad();
        ageWhenDiagnosedWithMigOLS.setAge("35")
        .clickNextButton(new ApproxHowLongSufferingFromMIGOLS());
        
        
        //------------For approximately how long have you been suffering from Migraine headaches? - question---------------   
        approxHowLongSufferingFromMIGOLS
        .waitForPageLoad();
        Assert.assertEquals(approxHowLongSufferingFromMIGOLS.getTitleText(), approxHowLongSufferingFromMIGOLS.titleExpected, "Title is diff");
        MIGAttackFrequencyOLS mIGAttackFrequencyOLS = approxHowLongSufferingFromMIGOLS  //[create NEXT PAGE Object = THIS page object]
        .clickOnAnswer("5 months or less")
        .clickNextButton(new MIGAttackFrequencyOLS());
        //------Validate protocol DQs in debug window----------
        mIGAttackFrequencyOLS
        .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(approxHowLongSufferingFromMIGOLS.titleExpected, protocol5, protocol1, protocol2, protocol3, protocol4, protocol6,protocol7);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        approxHowLongSufferingFromMIGOLS.waitForPageLoad();
        approxHowLongSufferingFromMIGOLS.clickOnAnswer("1 year or more")
        .clickNextButton(new MIGAttackFrequencyOLS());       
        

        
        //------------In a typical month, how many separate migraine attacks do you have? - question---------------   
        mIGAttackFrequencyOLS
        .waitForPageLoad();
        Assert.assertEquals(mIGAttackFrequencyOLS.getTitleText(),mIGAttackFrequencyOLS.titleExpected, "Title is diff");
        CurrentlyTakeAnyMedicationsTreatMIG currentlyTakeAnyMedicationsTreatMIG = mIGAttackFrequencyOLS  //[create NEXT PAGE Object = THIS page object] 
        .selectAttacks("15")
        .selectDays("8")
        .selectHeadaches("8")
        .clickNextButton(new CurrentlyTakeAnyMedicationsTreatMIG()); 
        //------Validate protocol DQs in debug window----------
        currentlyTakeAnyMedicationsTreatMIG.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("The next few questions are about migraines, regular headaches, and how often you have them. If you ...", protocol3, protocol5, protocol2, protocol6,protocol7);
        //debugPageOLS.checkProtocolsEquals(approxHowLongSufferingFromMIG.titleExpected, protocol2, protocol5, protocol6);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        mIGAttackFrequencyOLS.selectAttacks("9")
        .selectDays("8")
        .selectHeadaches("8")
        .clickNextButton(new CurrentlyTakeAnyMedicationsTreatMIG()); 

     
        
        //----------Q6 - "Do you currently take any medications to treat your migraine headaches? " Page ---------------   
        currentlyTakeAnyMedicationsTreatMIG.waitForPageLoad();     
        Assert.assertEquals(currentlyTakeAnyMedicationsTreatMIG.getTitleText(),currentlyTakeAnyMedicationsTreatMIG.titleExpected, "Title is diff");  
        HaveYouHadBotoxInjection haveYouHadBotoxInjection = currentlyTakeAnyMedicationsTreatMIG   //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("No")
        .clickNextButton(new HaveYouHadBotoxInjection());// Click NEXT button and wait for the NEXT page
        //********Validate SMART-SKIP to page "HaveUeverHadBotox" instead of page "WhenUTakeMigraineMedicationsCC"***************
        haveYouHadBotoxInjection.waitForPageLoad();
        Assert.assertEquals(haveYouHadBotoxInjection.getTitleText(),haveYouHadBotoxInjection.titleExpected, "Title is diff");  
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        HowDoYouTakeMigMedications howDoYouTakeMigMedications = currentlyTakeAnyMedicationsTreatMIG //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswers("Yes, prescription medication")
        .clickNextButton(new HowDoYouTakeMigMedications());
 
        
        
        //----------Q7 - "How do you take your migraine medications? " Page ---------------   
        howDoYouTakeMigMedications.waitForPageLoad();     
        Assert.assertEquals(howDoYouTakeMigMedications.getTitleText(),howDoYouTakeMigMedications.titleExpected, "Title is diff");  
        HaveYouHadBotoxInjection haveYouHadBotoxInjection1 = howDoYouTakeMigMedications   //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswers("Daily or regularly, to prevent migraine headaches")
        .clickNextButton(new HaveYouHadBotoxInjection()); // Click NEXT button and wait for the NEXT page
        //********Validate SMART-SKIP to page "HaveYouHadBotoxInjection" instead of page "inPast3MonthsMedicationToStopActiveMIG" ***************
        //If selected ("Yes, prescription medication" OR "Yes, over-the-counter medication" in Q6) AND (“As needed” in Q7) continue to Q8 Otherwise, skip to Q9-----------
        haveYouHadBotoxInjection1.waitForPageLoad();
        Assert.assertEquals(haveYouHadBotoxInjection1.getTitleText(),haveYouHadBotoxInjection1.titleExpected, "Title is diff");    
        //********Validate Question History for DQ and then click BACK button     
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------   
        InPast3MonthsMedicationToStopActiveMIG inPast3MonthsMedicationToStopActiveMIG = howDoYouTakeMigMedications //[create NEXT PAGE Object = THIS page object]      
        .clickOnAnswers("Daily or regularly, to prevent migraine headaches")//De-select 1st option by clicking on it.
        .clickOnAnswers("\"As needed\" - as my migraine starts or while I experience it")
        .clickNextButton(new InPast3MonthsMedicationToStopActiveMIG());        
        
        
                
        //----------Q8  In the past 3 months, how many days per month have you used medication to stop an active migraine?  -  Page ---------------   
        inPast3MonthsMedicationToStopActiveMIG.waitForPageLoad();
        Assert.assertEquals(inPast3MonthsMedicationToStopActiveMIG.getTitleText(), inPast3MonthsMedicationToStopActiveMIG.titleExpected, "Title is diff");    
        haveYouHadBotoxInjection1.clickOnAnswer("More than half the days in a month")
        .clickNextButton(new HaveYouHadBotoxInjection()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button            
        haveYouHadBotoxInjection1.waitForPageLoad();
        Assert.assertEquals(haveYouHadBotoxInjection1.getTitleText(),haveYouHadBotoxInjection1.titleExpected, "Title is diff");           
        debugPageOLS.checkProtocolsEquals(inPast3MonthsMedicationToStopActiveMIG.titleExpected, protocol2, protocol3, protocol4, protocol5, protocol6,protocol7);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in 'MedicationToStopActiveMigraineCC'---------------        
        inPast3MonthsMedicationToStopActiveMIG.clickOnAnswer("Less than half the days in a month")
        .clickNextButton(new HaveYouHadBotoxInjection());
        
        
        
        //----------Q9 -Have you ever had a Botox (botulinum toxin) injection? -  Page ---------------   
        haveYouHadBotoxInjection.waitForPageLoad();
        Assert.assertEquals(haveYouHadBotoxInjection1.getTitleText(), haveYouHadBotoxInjection1.titleExpected, "Title is diff");    
        HaveYouEverDiagnosedByHealthcareProfOLS haveYouEverDiagnosedByHealthcareProfOLS = haveYouHadBotoxInjection  //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("No")
        .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate SMART-SKIP to page QS11 "HaveUeverDiagnosedByHealthcareProfesionalOLSS" instead of page QS10 "WhenYouLastHaveBotoxMigCC"***************
        haveYouEverDiagnosedByHealthcareProfOLS.waitForPageLoad();
        Assert.assertEquals(haveYouEverDiagnosedByHealthcareProfOLS.getTitleText(),haveYouEverDiagnosedByHealthcareProfOLS.titleExpected, "Title is diff");  
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'HaveUeverHadBotoxMigCC'---------------  
        WhenDidYouLastHaveBotoxInjectionOLS whenDidYouLastHaveBotoxInjectionOLS = haveYouHadBotoxInjection //[create NEXT PAGE Object = THIS page object]     
        .clickOnAnswer("Yes, injected around my face, head or neck")
        .clickNextButton(new WhenDidYouLastHaveBotoxInjectionOLS());
        

        
        //----------Q10 -When did you last have a Botox (botulinum toxin) injection? - Page ---------------   
        whenDidYouLastHaveBotoxInjectionOLS.waitForPageLoad();
        Assert.assertEquals(whenDidYouLastHaveBotoxInjectionOLS.getTitleText(), whenDidYouLastHaveBotoxInjectionOLS.titleExpected, "Title is diff");    
        HaveYouEverDiagnosedByHealthcareProfOLS haveYouEverDiagnosedByHealthcareProfOLS1 = whenDidYouLastHaveBotoxInjectionOLS  //[create NEXT PAGE Object = THIS page object]    
        .clickOnAnswer("Within the last month")
        .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whenDidYouLastHaveBotoxInjectionOLS.titleExpected).contains(protocol4));
        debugPageOLS.back();
        whenDidYouLastHaveBotoxInjectionOLS.waitForPageLoad();
        whenDidYouLastHaveBotoxInjectionOLS.clickOnAnswer("1 - 3 months ago")
        .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whenDidYouLastHaveBotoxInjectionOLS.titleExpected).contains(protocol4));
        debugPageOLS.back();
        whenDidYouLastHaveBotoxInjectionOLS.waitForPageLoad();
        whenDidYouLastHaveBotoxInjectionOLS.clickOnAnswer("4 - 6 months ago")
        .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whenDidYouLastHaveBotoxInjectionOLS.titleExpected).contains(protocol4));
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'whenYouLastHaveBotoxMigCC'---------------  
        whenDidYouLastHaveBotoxInjectionOLS.waitForPageLoad();
        whenDidYouLastHaveBotoxInjectionOLS.clickOnAnswer("More than 1 year ago")
        .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS());
        
        
        
        //----------Q11 Have you ever been diagnosed by a healthcare professional with any of the following pain conditions? " Page ---------------   
        haveYouEverDiagnosedByHealthcareProfOLS1.waitForPageLoad();     
        Assert.assertEquals(haveYouEverDiagnosedByHealthcareProfOLS1.getTitleText(),haveYouEverDiagnosedByHealthcareProfOLS1.titleExpected, "Title is diff"); 
        AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = haveYouEverDiagnosedByHealthcareProfOLS1  //[create NEXT PAGE Object = THIS page object] 
        .clickOnAnswers("Trigeminal Neuralgia - severe pain in the nerves of the face")
        .clickNextButton(new AreYouCurrentlyPregnantOLS()); // Click NEXT button and wait for the NEXT page
                
        		
        //----------Q12 - Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?   -  Page ---------------   
        areYouCurrentlyPregnantOLS.waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyPregnantOLS.getTitleText(), areYouCurrentlyPregnantOLS.titleExpected, "Title is diff");    
        areYouCurrentlyPregnantOLS.clickOnAnswer("Yes")
        //TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC //[create NEXT PAGE Object = THIS page object]    
        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        debugPageOLS.checkProtocolsEquals(areYouCurrentlyPregnantOLS.titleExpected, protocol5, protocol1, protocol2, protocol3, protocol4, protocol6,protocol7);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'areYouCurrentlyPregnantCC'---------------  
        areYouCurrentlyPregnantOLS.waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = areYouCurrentlyPregnantOLS
        .clickOnAnswer("No")
        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
       

        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new HormonalBirthControlOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
        .clickNextButton(new ApproximateHeightPageOLS())
		//----------ProvideHeight-Weight Page--------------------
				.waitForPageLoad()
				.setFeat("5")
				.setInches("5")
				.setLbs("155")
				.clickNextButton(new ChildrenUnderPageOLS())
		
		//----------ChildrenUnderTheAge Page--------------------
				.waitForPageLoad()
				.clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageOLS())
                
			
		//-------------------PEDIATRIC QUESTIONS-----------------------------                            
		//----"theStudySitePageOLS" page --  If you qualify for a study, how would you plan to travel to and from the study site?
				.waitForPageLoad()
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
		        .clickNextButton(new SynexusQualifiedCloseMIG4356Page())
		        
		//----------GladLocationIsConvenient Page--------------------
		        .waitForPageLoad(env.equals("STG")? facility_Code_STG : facility_Code_PRD)
		        .clickNextButton(new ThankYouCloseSimplePageOLS())
		        
		//----------ThankYouCloseSimplePageOLS Page--------------------
		        .waitForPageLoad()
		        .clickNextButton(new AboutHealthPageOLS())
		        .waitForPageLoad()
                .pidFromDbToLog(env)
       		 	//.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
				.getAnomalyDbToLog(env);     
    }
}
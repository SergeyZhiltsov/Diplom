package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.MainPage;
import com.acurian.selenium.pages.CC.closes.WarmTransfer1;
import com.acurian.selenium.pages.CC.closes.WarmTransfer2;
import com.acurian.selenium.pages.CC.closes.WarmTransfer3;
import com.acurian.selenium.pages.CC.closes.WarmTransfer4;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ChildrenUnderPageCC;
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
import com.acurian.selenium.pages.CC.shared.AreYouCurrentlyPregnantCC;
import com.acurian.selenium.pages.CC.shared.CurrentlyTakeMedicationsForMigraineCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HaveUeverHadBotoxMigCC;
import com.acurian.selenium.pages.CC.shared.MedicationToStopActiveMigraineCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhenUTakeMigraineMedicationsCC;
import com.acurian.selenium.pages.CC.shared.WhenYouLastHaveBotoxMigCC;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HasHealthcareProfessionalPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.OLS.closes.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import com.acurian.selenium.pages.OLS.DY_4356.AreYouTakingMedications;
import com.acurian.selenium.pages.OLS.DY_4356.NonPrescriptionSupplements;
import com.acurian.selenium.pages.OLS.DY_4356.PregnancyAndFertilityPage;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungs;
import com.acurian.selenium.pages.OLS.generalHealth.AffectYourLungsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolism;
import com.acurian.selenium.pages.OLS.generalHealth.AffectingYourMetabolismPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditions;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.CancerPage;
import com.acurian.selenium.pages.OLS.generalHealth.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.CongestiveHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditions;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DrugOrAlcoholAbuse;
import com.acurian.selenium.pages.OLS.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouSmokedCigarettes;
import com.acurian.selenium.pages.OLS.generalHealth.HeartRelatedMedicalProc;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HistoryOfDrugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.MentalHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.NeurologicalConditions;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SkinConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditions;
import com.acurian.selenium.pages.OLS.generalHealth.SleepRelatedConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SmokedCigarettesPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditions;
import com.acurian.selenium.pages.OLS.generalHealth.ViralConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WomenHealthConditions;
import com.acurian.selenium.pages.OLS.generalHealth.WomensHealthPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.YouHaveCHF;
import com.acurian.selenium.pages.OLS.shared.ChildrenUnderTheAge;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DyslipidemiaHealthcarePage;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HowLongTakingStatin;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.ProvideHeightWeight;
import com.acurian.selenium.pages.OLS.shared.StatinMedicationsPage;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.OLS.shared.MIGAttackFrequencyOLS;
import java.util.Arrays;
import java.util.List;


public class SUI_3923_OLS extends BaseTest{

    @Test
    @TestCaseId("00003")
    @Description("Stress Urinary Incontinence (SUI) - 3923")
    public void tc002Test() {
        String phoneNumberLBP = "AUTAMS1SUI";
        String protocol1 = "G201002";
        String studyName =  "SUI";  //"Stress Urinary Incontinence (SUI) - 3923";
        String env = "STG";  //Enter which CC environment to use for testing
        String siteName = "AUT_SUI_3923";
        String zip_Code = "19044";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleMIGExpected, "Title is diff");
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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = doYouSufferFromMigHeadachesOLS   //[create NEXT PAGE Object = THIS page object] 
        .clickOnAnswer("No")
        .clickNextButton(new HasHealthcareProfessionalPageOLS()); 
        //------Validate protocol DQs in debug window----------
        hasHealthcareProfessionalPageOLS
        .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(doYouSufferFromMigHeadachesOLS.titleExpected, protocol1);
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
        ApproxHowLongSufferingFromMIG approxHowLongSufferingFromMIG = ageWhenDiagnosedWithMigOLS  //[create NEXT PAGE Object = THIS page object] 
        .setAge("50")
        .clickNextButton(new ApproxHowLongSufferingFromMIG());
        //------Validate protocol DQs in debug window----------
        approxHowLongSufferingFromMIG
        .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(ageWhenDiagnosedWithMigOLS.titleExpected, protocol1);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        ageWhenDiagnosedWithMigOLS.waitForPageLoad();
        ageWhenDiagnosedWithMigOLS.setAge("35")
        .clickNextButton(new ApproxHowLongSufferingFromMIG());
        
        
        //------------For approximately how long have you been suffering from Migraine headaches? - question---------------   
        approxHowLongSufferingFromMIG
        .waitForPageLoad();
        Assert.assertEquals(approxHowLongSufferingFromMIG.getTitleText(),approxHowLongSufferingFromMIG.titleExpected, "Title is diff");
        MIGAttackFrequencyOLS mIGAttackFrequencyOLS = approxHowLongSufferingFromMIG  //[create NEXT PAGE Object = THIS page object] 
        .clickOnAnswer("5 months or less")
        .clickNextButton(new MIGAttackFrequencyOLS());
        //------Validate protocol DQs in debug window----------
        mIGAttackFrequencyOLS
        .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(approxHowLongSufferingFromMIG.titleExpected, protocol1);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        approxHowLongSufferingFromMIG.waitForPageLoad();
        approxHowLongSufferingFromMIG.clickOnAnswer("1 year or more")
        .clickNextButton(new MIGAttackFrequencyOLS());       
        

        
        //------------In a typical month, how many separate migraine attacks do you have? - question---------------   
        mIGAttackFrequencyOLS
        .waitForPageLoad();
        Assert.assertEquals(mIGAttackFrequencyOLS.getTitleText(),mIGAttackFrequencyOLS.titleExpected, "Title is diff");
        CurrentlyTakeAnyMedicationsTreatMIG currentlyTakeAnyMedicationsTreatMIG = mIGAttackFrequencyOLS  //[create NEXT PAGE Object = THIS page object] 
        .selectAttacks("10")
        .selectDays("8")
        .selectHeadaches("8")
        .clickNextButton(new CurrentlyTakeAnyMedicationsTreatMIG()); 
        //------Validate protocol DQs in debug window----------
        currentlyTakeAnyMedicationsTreatMIG.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("The next few questions are about migraines, regular headaches, and how often you have them. If you ...", protocol1);
        //debugPageOLS.checkProtocolsEquals(approxHowLongSufferingFromMIG.titleExpected, protocol2, protocol5, protocol6);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        mIGAttackFrequencyOLS.selectAttacks("8")
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
        debugPageOLS.checkProtocolsEquals(inPast3MonthsMedicationToStopActiveMIG.titleExpected, protocol1);
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
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whenDidYouLastHaveBotoxInjectionOLS.titleExpected).contains(protocol1));
        debugPageOLS.back();
        whenDidYouLastHaveBotoxInjectionOLS.waitForPageLoad();
        whenDidYouLastHaveBotoxInjectionOLS.clickOnAnswer("1 - 3 months ago")
        .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whenDidYouLastHaveBotoxInjectionOLS.titleExpected).contains(protocol1));
        debugPageOLS.back();
        whenDidYouLastHaveBotoxInjectionOLS.waitForPageLoad();
        whenDidYouLastHaveBotoxInjectionOLS.clickOnAnswer("4 - 6 months ago")
        .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whenDidYouLastHaveBotoxInjectionOLS.titleExpected).contains(protocol1));
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
        .clickNextButton(new HasHealthcareProfessionalPageOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        debugPageOLS.checkProtocolsEquals(areYouCurrentlyPregnantOLS.titleExpected, protocol1);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'areYouCurrentlyPregnantCC'---------------  
        areYouCurrentlyPregnantOLS.waitForPageLoad();
        areYouCurrentlyPregnantOLS.clickOnAnswer("No")
        .clickNextButton(new HasHealthcareProfessionalPageOLS());
       

      //----------GENERAL HEALTH Questions----------     
		//----------HasHealthcareProfessionalPageOLS Page--------------------
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = hasHealthcareProfessionalPageOLS    //[create NEXT PAGE Object = THIS page object] 
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
		ChildrenUnderTheAge childrenUnderTheAge = provideHeightWeight
				.waitForPageLoad()
				.setFT("5")
				.setIN("5")
				.setWeight("155")
				.clickNextButton(new ChildrenUnderTheAge());
		
		//----------ChildrenUnderTheAge Page--------------------
		IdentificationPageOLS identificationPageOLS =  childrenUnderTheAge
				.waitForPageLoad()
				.clickOnAnswers("No")
				.clickNextButton(new IdentificationPageOLS());

		//----------PII (IdentificationPageOLS) Page--------------------
		identificationPageOLS.waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)
        .clickNextButton(new SiteSelectionPageOLS())
        
		//----------SiteSelection Page--------------------
        .waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new SynexusQualifiedCloseMIG4356Page())
        
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

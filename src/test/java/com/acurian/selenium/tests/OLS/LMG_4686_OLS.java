package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.*;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LMG_4686_OLS extends BaseTest {

    @Test(enabled = true)
    @TestCaseId("00056")
    @Description("MIG_4356B_Synexus_OLS module")
    public void lmg_4686_ols() {
        String phoneNumberMIG = "AUTAMS1MIG";
        String protocol1 = "I5Q_MC_CGAW";
        String studyName = "a migraine";
        String siteName = "AUT_LMG_3";
        String zip_Code = "19341";
        String site_Indication = "Migraines";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleLMGExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zip_Code)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DoYouSufferFromMigHeadachesOLS doYouSufferFromMigHeadachesOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromMigHeadachesOLS());

        doYouSufferFromMigHeadachesOLS
                .waitForPageLoad();
        Assert.assertEquals(doYouSufferFromMigHeadachesOLS.getTitleText(), doYouSufferFromMigHeadachesOLS.titleExpected, "Title is diff");
        HasDoctorDiagnosedYouWithClusterHeadache_OLS hasDoctorDiagnosedYouWithClusterHeadache_OLS = doYouSufferFromMigHeadachesOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_OLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6002", protocol1);
        debugPageOLS.back();

        AgeWhenDiagnosedWithMigOLS ageWhenDiagnosedWithMigOLS = doYouSufferFromMigHeadachesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigOLS());

        ApproxHowLongSufferingFromMIG approxHowLongSufferingFromMIG = ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("51")
                .clickNextButton(new ApproxHowLongSufferingFromMIG());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6003", protocol1);
        debugPageOLS.back();
        ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("37")
                .clickNextButton(new ApproxHowLongSufferingFromMIG());

        HowManyDaysYouSufferOLS howManyDaysYouSufferOLS = approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6004", protocol1);
        debugPageOLS.back();

        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months")
                .clickNextButton(new HowManyDaysYouSufferOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6004", protocol1);
        debugPageOLS.back();
        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new HowManyDaysYouSufferOLS());

        HowOftenDoYouTypicallyTakeMedicationOLS howOftenDoYouTypicallyTakeMedicationOLS = howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("5")
                .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationOLS());

        //---------------Q6: How often do you typically take medication to stop an active migraine, either as it starts or while you are experiencing it?-------------
        HowManyDifferentMedicationsOLS howManyDifferentMedicationsOLS = howOftenDoYouTypicallyTakeMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Half the days in a month or more")
                .clickNextButton(new HowManyDifferentMedicationsOLS())
                .waitForPageLoad();
        //debugPageOLS.checkProtocolsContainsForQNumber("QS6023", protocol1);
        debugPageOLS.back();
        howOftenDoYouTypicallyTakeMedicationOLS
        		.waitForPageLoad()
                .clickOnAnswer("Less than half the days in a month")
                .clickOnAnswer("I do not take any medication to stop active migraines – I wait for them to go away on their own")
                .clickNextButton(new HowManyDifferentMedicationsOLS());
        
        
      //---------------Q7: HowManyDifferentMedicationsOLS -----------
        FollowingMedicationsToPreventOLS followingMedicationsToPreventOLS = howManyDifferentMedicationsOLS
                .waitForPageLoad()
                .noOfMedications("4")
                .clickNextButton(new FollowingMedicationsToPreventOLS());
        
        
      //---------------Q8: FollowingMedicationsToPreventOLS -----------
        followingMedicationsToPreventOLS
        		.waitForPageLoad();
        HaveYouEverHadBotoxbotulinumtoxin_OLS haveYouEverHadBotoxbotulinumtoxin_OLS = followingMedicationsToPreventOLS
                .clickOnAnswers("Metoprolol, Lopressor, or Toprol",
                				"Propranolol, Hemangeol, Inderal, or Innopran",
                				"Topamax, Qudexy, Trokendi, or topiramate",
                				"Depacon or valproate",
                				"Depakote or divalproex",
                				"Elavil or amitriptyline",
                				"Sibelium or Flunarizine",
                				"Botox injections (botulinum toxin) – specifically for chronic migraines",
                				"Atacand or candesartan",
                				"Timolol")
                .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_OLS())
                .waitForPageLoad();
        		debugPageOLS.back();
        followingMedicationsToPreventOLS
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_OLS())
        		.waitForPageLoad();
        		//debugPageOLS.checkProtocolsContainsForQNumber("QS6024", protocol3);  //---4686 protocol
        		debugPageOLS.back();
        followingMedicationsToPreventOLS
				.waitForPageLoad()
                .clickOnAnswers("Metoprolol, Lopressor, or Toprol",
                		"Topamax, Qudexy, Trokendi, or topiramate")
				.clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_OLS());        		
        		
        
        
        //---------------SKIP to Q18: Have you ever had a Botox (botulinum toxin) injection to your face, head, or neck? -----------
        WhenDidYouLastHaveBotoxInjectionOLS whenDidYouLastHaveBotoxInjectionOLS = haveYouEverHadBotoxbotulinumtoxin_OLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, to treat migraines","Yes, as a cosmetic treatment for lines on the face")
                .clickNextButton(new WhenDidYouLastHaveBotoxInjectionOLS());
        
        
        //---------------Q19: When did you last have a Botox (botulinum toxin) injection?-----------
        HaveYouEverDiagnosedByHealthcareProfOLS haveYouEverDiagnosedByHealthcareProfOLS = whenDidYouLastHaveBotoxInjectionOLS
                .waitForPageLoad()
                .clickOnAnswer("3 months ago or less")
                .clickOnAnswer("More than 1 year ago")
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS())
                .waitForPageLoad();
        		//debugPageOLS.checkProtocolsContainsForQNumber("QS6026", protocol1);
        		debugPageOLS.back();
        whenDidYouLastHaveBotoxInjectionOLS
                .waitForPageLoad()       
                .clickOnAnswer("7 months - 1 year ago")
                .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS());
        

        
      //---------------Q20: HaveYouEverDiagnosedByHealthcareProfOLS-----
        haveYouEverDiagnosedByHealthcareProfOLS
                .waitForPageLoad();
        DoYouCurrentlyUseMarijuanaOLS doYouCurrentlyUseMarijuanaOLS = haveYouEverDiagnosedByHealthcareProfOLS
                .clickOnAnswers("Trigeminal Neuralgia - severe pain in the nerves of the face")
                .clickOnAnswers("Temporomandibular Joint Disorders also known as TMD or TMJ")
                .clickNextButton(new DoYouCurrentlyUseMarijuanaOLS())
                .waitForPageLoad();
                //debugPageOLS.checkProtocolsContainsForQNumber("QS6027", protocol1);
        		debugPageOLS.back();
        haveYouEverDiagnosedByHealthcareProfOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoYouCurrentlyUseMarijuanaOLS());
                
 
        
        //---------------Q21: DoYouCurrentlyUseMarijuanaOLS-----
        doYouCurrentlyUseMarijuanaOLS
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouCurrentlyUseMarijuanaOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        		debugPageOLS.back();
        doYouCurrentlyUseMarijuanaOLS
                .waitForPageLoad();
        IfYouQualifyForStudyWillingtoStopOLS ifYouQualifyForStudyWillingtoStopOLS = doYouCurrentlyUseMarijuanaOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new IfYouQualifyForStudyWillingtoStopOLS());
        

        //---------------Q22: IfYouQualifyForStudyWillingtoStopOLS-----
        ifYouQualifyForStudyWillingtoStopOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        		//debugPageOLS.checkProtocolsContainsForQNumber("QS6029", protocol1);
        		debugPageOLS.back();
        ifYouQualifyForStudyWillingtoStopOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
                
                
        
        
        //-----------------GENERAL HEALTH questions-------------------
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
                        "Headaches (migraine, cluster, tension)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
                        "Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        whatKindOfArthritisPageOLS.waitForPageLoad();
        whatKindOfArthritisPageOLS.back();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
                        "Headaches (migraine, cluster, tension)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids, PCOS, dense breasts)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoadTIA()
                .clickOnAnswers("More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        

        following_MentalEmotionalHealthPageOLS
        		.waitForPageLoad();
        WomenHealthConditions womenHealthConditions = following_MentalEmotionalHealthPageOLS
                .clickOnAnswers("Generalized anxiety disorder (GAD)",
                		"Major depressive disorder (MDD) or depression",
                		"None of the above")
                .clickOnAnswers("Bipolar disorder", "Schizophrenia")
                .clickNextButton(new WomenHealthConditions());
        womenHealthConditions
                .waitForPageLoad();
                debugPageOLS.checkProtocolsContainsForQNumber("QS53", protocol1);
                debugPageOLS.back();
        following_MentalEmotionalHealthPageOLS
        		.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WomenHealthConditions());
        
        
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = womenHealthConditions
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS()); 
        
        
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
        		.clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
        		.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);
        

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "7", "166")
                .clickNextButton(new EthnicBackgroundPageOLS())
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
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()

                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
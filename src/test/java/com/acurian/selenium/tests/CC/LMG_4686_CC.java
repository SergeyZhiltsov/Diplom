package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LMG_4686.DoYouCurrentlyUseMarijuanaCC;
import com.acurian.selenium.pages.CC.LMG_4686.FollowingMedicationsToPreventCC;
import com.acurian.selenium.pages.CC.LMG_4686.HaveYouEverHadBotoxbotulinumtoxin_CC;
import com.acurian.selenium.pages.CC.LMG_4686.HowManyDaysYouSufferCC;
import com.acurian.selenium.pages.CC.LMG_4686.HowManyDifferentMedicationsCC;
import com.acurian.selenium.pages.CC.LMG_4686.HowOftenDoYouTypicallyTakeMedicationCC;
import com.acurian.selenium.pages.CC.LMG_4686.IfYouQualifyForStudyWillingtoStopCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartrelatedMedicalProceduresPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromMigPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HasDoctorDiagnosedYouWithClusterHeadache_CC;
import com.acurian.selenium.pages.CC.shared.HaveUeverDiagnosedByHealthcareProfesionalCC;
import com.acurian.selenium.pages.CC.shared.HowLongSufferingFromMigraineCC;
import com.acurian.selenium.pages.CC.shared.HowOldWereYouMigHeadachePageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.WhenYouLastHaveBotoxMigCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class LMG_4686_CC extends BaseTest{
	
	@Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	public void LMG_4686_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1LMG";
        List<String> protocols = Arrays.asList("I5Q_MC_CGAW");
        String protocol1 = "I5Q_MC_CGAW";        
        String studyName = "migraine";
        String site_Indication = "Migraines";
    //    String env = "STG";
        String siteName = "AUT_LMG_3";
        String zipCode  = "19341";
        
        String env = System.getProperty("acurian.env", "STG");
        
        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad()
                .maximizePage();

        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();
        
        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumberOA)
                .clickPopupPhoneNumber(phoneNumberOA)
                .clickBeginButton();
        
        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
       Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
       DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
        .clickOnAnswer("Learn more about matching to clinical trials")
        .clickNextButton(new DateOfBirthPageCC());
       
       dateOfBirthPageCC
       			.waitForPageLoad();

       Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
      // Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedOA, "Title is diff");

       LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
               .setMonth("Mar")
               .setDay("2")
               .setYear("2003")
               .clickNextButton(new LessThan18YearsOldPageCC());
       
       lessThan18YearsOldPageCC.waitForPageLoad();
       DebugPageCC debugPageCC = new DebugPageCC();       
       debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES",  protocol1);
       debugPageCC.back();
       
       ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
    		   .waitForPageLoad()
               .setYear("1942")
               .clickNextButton(new ZipCodePageCC());
       
       zipCodePageCC.waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1);
       debugPageCC.back();
       dateOfBirthPageCC
       		.waitForPageLoad()
       		.setYear("1980")
       		.clickNextButton(new ZipCodePageCC());
       
       GenderPageCC genderPageCC = zipCodePageCC
    		.waitForPageLoad()
    		.typeZipCode("08204")
 		    .clickNextButton(new GenderPageCC());
       
       DoYouSufferFromMigPageCC doYouSufferFromMigPageCC = genderPageCC
    		   .waitForPageLoad()
               .clickOnAnswer("Female")
               .clickNextButton(new DoYouSufferFromMigPageCC());
       
       HasDoctorDiagnosedYouWithClusterHeadache_CC hasDoctorDiagnosedYouWithClusterHeadache_CC = doYouSufferFromMigPageCC
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_CC());
       
       hasDoctorDiagnosedYouWithClusterHeadache_CC.waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0005097-QS6002-STUDYQUES", protocol1);
       debugPageCC.back();
       
       HowOldWereYouMigHeadachePageCC howOldWereYouMigHeadachePageCC = doYouSufferFromMigPageCC
               .waitForPageLoad()
               .clickOnAnswer("Yes")
               .clickNextButton(new HowOldWereYouMigHeadachePageCC());
       
       HowLongSufferingFromMigraineCC howLongSufferingFromMigraineCC = howOldWereYouMigHeadachePageCC 
               .typeAge("50")
               .clickNextButton(new HowLongSufferingFromMigraineCC())
               .waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0005098-QS6003-STUDYQUES", protocol1);
       debugPageCC.back();       
       howOldWereYouMigHeadachePageCC 
       			.typeAge("37")
       			.clickNextButton(new HowLongSufferingFromMigraineCC())
       			.waitForPageLoad();
       
       HowManyDaysYouSufferCC howManyDaysYouSufferCC = howLongSufferingFromMigraineCC
       			.clickOnAnswer("5 months or less")
       			.clickNextButton(new HowManyDaysYouSufferCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0005099-QS6004-STUDYQUES", protocol1);
       debugPageCC.back();
       
       howLongSufferingFromMigraineCC
			     .clickOnAnswer("6 - 11 months")
			     .clickNextButton(new HowManyDaysYouSufferCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0005099-QS6004-STUDYQUES", protocol1);
       debugPageCC.back();
       howLongSufferingFromMigraineCC
				 .clickOnAnswer("1 year or more")
				 .clickNextButton(new HowManyDaysYouSufferCC());
       
     //---------------Q5: In a typical month, how many days do you suffer from migraines? 
       HowOftenDoYouTypicallyTakeMedicationCC howOftenDoYouTypicallyTakeMedicationCC = howManyDaysYouSufferCC
              .waitForPageLoad()
       		.selectDay("3")
              .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationCC())
       		.waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017149-QS6005-STUDYQUES", protocol1);
       debugPageCC.back();
       howManyDaysYouSufferCC
       		.waitForPageLoad()
       		.selectDay("15")
              .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationCC())
              .waitForPageLoad();
       //debugPageCC.checkProtocolsContainsForQNumber("Q0017149-QS6005-STUDYQUES", protocol1);
       debugPageCC.back();
       howManyDaysYouSufferCC
       		.waitForPageLoad()
       		.selectDay("4")
              .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationCC());		
       		
       		
       //---------------Q6: How often do you typically take medication to stop an active migraine, either as it starts or while you are experiencing it?-------------
       HowManyDifferentMedicationsCC howManyDifferentMedicationsCC = howOftenDoYouTypicallyTakeMedicationCC
              .waitForPageLoad()
              .clickOnAnswer("Half the days in a month or more")
              .clickNextButton(new HowManyDifferentMedicationsCC())
              .waitForPageLoad();
       //debugPageCC.checkProtocolsContainsForQNumber("Q0018412-QS6023-STUDYQUES", protocol1);
       debugPageCC.back();
       howOftenDoYouTypicallyTakeMedicationCC
       		.waitForPageLoad()
              .clickOnAnswer("Less than half the days in a month")
              .clickOnAnswer("I do not take any medication to stop active migraines – I wait for them to go away on their own")
              .clickNextButton(new HowManyDifferentMedicationsCC());


       //---------------Q7: HowManyDifferentMedicationsCC -----------
       FollowingMedicationsToPreventCC followingMedicationsToPreventCC = howManyDifferentMedicationsCC
              .waitForPageLoad()
              .diffMedication("4")
              .clickNextButton(new FollowingMedicationsToPreventCC());


       //---------------Q8: FollowingMedicationsToPreventCC -----------
       followingMedicationsToPreventCC
       		.waitForPageLoad();
       HaveYouEverHadBotoxbotulinumtoxin_CC haveYouEverHadBotoxbotulinumtoxin_CC = followingMedicationsToPreventCC
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
              .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_CC())
              .waitForPageLoad();
       		debugPageCC.back();
       followingMedicationsToPreventCC
       		.waitForPageLoad()
       		.clickOnAnswers("None of the above")
              .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_CC())
       		.waitForPageLoad();
       		//debugPageCC.checkProtocolsContainsForQNumber("QS6024", protocol3);  //---4686 protocol
       		debugPageCC.back();
       followingMedicationsToPreventCC
       		.waitForPageLoad()
              .clickOnAnswers("Metoprolol, Lopressor, or Toprol",
              		"Topamax, Qudexy, Trokendi, or topiramate")
              .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_CC());        		
       		


       //---------------SKIP to Q18: Have you ever had a Botox (botulinum toxin) injection to your face, head, or neck? -----------
       WhenYouLastHaveBotoxMigCC whenYouLastHaveBotoxMigCC = haveYouEverHadBotoxbotulinumtoxin_CC
              .waitForPageLoad()
              .clickOnAnswers("Yes, to treat migraines","Yes, as a cosmetic treatment for lines on the face")
              .clickNextButton(new WhenYouLastHaveBotoxMigCC());


       //---------------Q19: When did you last have a Botox (botulinum toxin) injection?-----------
       HaveUeverDiagnosedByHealthcareProfesionalCC haveUeverDiagnosedByHealthcareProfesionalCC = whenYouLastHaveBotoxMigCC
              .waitForPageLoad()
              .clickOnAnswer("3 months ago or less")
              .clickOnAnswer("More than 1 year ago")
              .clickOnAnswer("4 - 6 months ago")
              .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC())
              .waitForPageLoad();
       		//debugPageCC.checkProtocolsContainsForQNumber("Q0018421-QS6026-STUDYQUES", protocol1);
       		debugPageCC.back();
       whenYouLastHaveBotoxMigCC
              .waitForPageLoad()       
              .clickOnAnswer("7 months - 1 year ago")
              .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC());



       //---------------Q20: HaveYouEverDiagnosedByHealthcareProfCC-----
       haveUeverDiagnosedByHealthcareProfesionalCC
              .waitForPageLoad();
       DoYouCurrentlyUseMarijuanaCC doYouCurrentlyUseMarijuanaCC = haveUeverDiagnosedByHealthcareProfesionalCC
              .clickOnAnswers("Trigeminal Neuralgia - severe pain in the nerves of the face")
              .clickOnAnswers("Temporomandibular Joint Disorders also known as TMD or TMJ")
              .clickNextButton(new DoYouCurrentlyUseMarijuanaCC())
              .waitForPageLoad();
              //debugPageCC.checkProtocolsContainsForQNumber("Q0005117-QS6027-STUDYQUES", protocol1);
       		debugPageCC.back();
       haveUeverDiagnosedByHealthcareProfesionalCC
              .waitForPageLoad()
              .clickOnAnswers("None of the above")
              .clickNextButton(new DoYouCurrentlyUseMarijuanaCC());
              


       //---------------Q21: DoYouCurrentlyUseMarijuanaCC-----
       doYouCurrentlyUseMarijuanaCC
              .waitForPageLoad();
       TransitionStatementCC transitionStatementCC = doYouCurrentlyUseMarijuanaCC
       	   .clickOnAnswer("No")
              .clickNextButton(new TransitionStatementCC())
              .waitForPageLoad(studyName);
       		debugPageCC.back();
       doYouCurrentlyUseMarijuanaCC
              .waitForPageLoad();
       IfYouQualifyForStudyWillingtoStopCC ifYouQualifyForStudyWillingtoStopCC = doYouCurrentlyUseMarijuanaCC
              .clickOnAnswer("Yes")
              .clickNextButton(new IfYouQualifyForStudyWillingtoStopCC());


       //---------------Q22: IfYouQualifyForStudyWillingtoStopCC-----
       ifYouQualifyForStudyWillingtoStopCC
              .waitForPageLoad()
              .clickOnAnswer("No")
              .clickNextButton(new TransitionStatementCC())
              .waitForPageLoad(studyName);
       		//debugPageCC.checkProtocolsContainsForQNumber("Q0018426-QS6029-STUDYQUES", protocol1);
       		debugPageCC.back();
       ifYouQualifyForStudyWillingtoStopCC
              .waitForPageLoad()
              .clickOnAnswer("Yes")
              .clickNextButton(new TransitionStatementCC());
              
              

       //---------------Q24: Transition Statement - Display for Call Center onl-----
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
       		.waitForPageLoad(studyName)
       		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());



       //-----------------GENERAL HEALTH questions-------------------
       WhatKindOfArthritisCC whatKindOfArthritisPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                      "Heart or circulation problems (heart attack, heart failure, stroke)",
                      "High blood pressure or hypertension",
                      "High cholesterol, triglycerides, or lipids",
                      "Kidney disease",
                      "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                      "Lupus",
                      "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                      "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                      "Skin problems (eczema or atopic dermatitis, psoriasis)",
                      "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                      "Women's health issues (endometriosis, uterine fibroids)")
              .clickNextButton(new WhatKindOfArthritisCC());
       whatKindOfArthritisPage.waitForPageLoad();
       whatKindOfArthritisPage.back();
       HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                      "Heart or circulation problems (heart attack, heart failure, stroke)",
                      "High blood pressure or hypertension",
                      "High cholesterol, triglycerides, or lipids",
                      "Kidney disease",
                      "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                      "Lupus",
                      "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                      "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                      "Skin problems (eczema or atopic dermatitis, psoriasis)",
                      "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                      "Women's health issues (endometriosis, uterine fibroids)")
              .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
              .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

       SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
              .waitForPageLoad()
              .clickOnAnswers("Heart attack")
              .clickNextButton(new SubquestionExperiencedHeartPageCC());

       HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = subquestionExperiencedHeartPageCC
              .waitForPageLoad()
              .clickOnAnswer("Less than 30 days ago")
              .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC
              .waitForPageLoad()
              .clickOnAnswer("1 - 3 months ago")
              .clickNextButton(heartrelatedMedicalProceduresPageCC);
       debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1);
       debugPageCC.back();

       subquestionExperiencedHeartPageCC
              .waitForPageLoad()
              .clickOnAnswer("4 - 6 months ago")
              .clickNextButton(heartrelatedMedicalProceduresPageCC);
       debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC.back();

       haveYouEverExperiencedHeartRelatedMedicalCondCC
              .waitForPageLoad()
              .clickOnAnswers("None of the above")
              .clickOnAnswers("Stroke")
              .clickNextButton(new SubquestionExperiencedHeartPageCC());
       subquestionExperiencedHeartPageCC
              .waitForPageLoadStroke()
              .clickOnAnswer("Less than 30 days ago")
              .clickNextButton(heartrelatedMedicalProceduresPageCC);
       debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC
              .waitForPageLoadStroke()
              .clickOnAnswer("1 - 3 months ago")
              .clickNextButton(heartrelatedMedicalProceduresPageCC);
       debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC
              .waitForPageLoadStroke()
              .clickOnAnswer("4 - 6 months ago")
              .clickNextButton(heartrelatedMedicalProceduresPageCC);
       debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC.back();

       haveYouEverExperiencedHeartRelatedMedicalCondCC
              .waitForPageLoad()
              .clickOnAnswers("None of the above")
              .clickOnAnswers("TIA or \"mini-stroke\"")
              .clickNextButton(new SubquestionExperiencedHeartPageCC());

       subquestionExperiencedHeartPageCC
              .waitForPageLoadTIA()
              .clickOnAnswer("More than 1 year ago")
              .clickNextButton(heartrelatedMedicalProceduresPageCC);

       DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = heartrelatedMedicalProceduresPageCC
              .waitForPageLoad()
              .clickOnAnswers("None of the above")
              .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC()); 


       doAnyOftheFollowingAdditionalDiagnosesCC
              .waitForPageLoad();
       ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
       		.clickOnAnswers("Drug or alcohol abuse within the past year")
              .clickNextButton(new ApproximateHeightPageCC());
       approximateHeightPageCC
       		.waitForPageLoad()
              .getPage(debugPageCC)
              .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
              .back();
       doAnyOftheFollowingAdditionalDiagnosesCC
              .waitForPageLoad()
              .clickOnAnswers("Hepatitis B")
              .clickNextButton(approximateHeightPageCC)
              .waitForPageLoad()
              .getPage(debugPageCC)
              .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
              .back();
       doAnyOftheFollowingAdditionalDiagnosesCC
              .waitForPageLoad()
              .clickOnAnswers("Hepatitis C")
              .clickNextButton(approximateHeightPageCC)
              .waitForPageLoad()
              .getPage(debugPageCC)
              .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
              .back();
       doAnyOftheFollowingAdditionalDiagnosesCC
              .waitForPageLoad()
              .clickOnAnswers("HIV or AIDS")
              .clickNextButton(approximateHeightPageCC)
              .waitForPageLoad()
              .getPage(debugPageCC)
              .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
              .back();
       doAnyOftheFollowingAdditionalDiagnosesCC
              .waitForPageLoad()
              .clickOnAnswers("Kidney disease requiring dialysis")
              .clickNextButton(approximateHeightPageCC)
              .waitForPageLoad()
              .getPage(debugPageCC)
              .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
              .back();
       doAnyOftheFollowingAdditionalDiagnosesCC
              .waitForPageLoad()
              .clickOnAnswers("Schizophrenia")
              .clickNextButton(approximateHeightPageCC)
              .waitForPageLoad()
              .getPage(debugPageCC)
              .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
              .back();
       doAnyOftheFollowingAdditionalDiagnosesCC
              .waitForPageLoad()
              .clickOnAnswers("None of the above")
              .clickNextButton(approximateHeightPageCC);
              
       LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
              			.waitForPageLoad()
              			.setAll("5", "5", "160")
       			.clickNextButton(new LetMeSeePageCC());
       
       letMeSeePageCC
		.waitForPageLoad()
		.clickNextButton(new IdentificationPageCC())
		.waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
		.clickNextButton(new SiteSelectionPageCC())
		.waitForPageLoad("a migraine study")
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
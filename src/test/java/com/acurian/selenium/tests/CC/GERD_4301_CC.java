package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.GERD.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GERD_4301_CC extends BaseTest{
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void Gerd_4301_CC(final String username, final String password) {
        String phoneNumber = "AUTAMSGERD";
        String protocol1 = "C3718_301";
        String protocol2 = "C3718_302";
        String studyName = "heartburn, reflux, or GERD history";
        String site_Indication = "a heartburn or reflux study";
        String site_Indication1 = "Gastroesophageal Reflux Disease (GERD)";
        String siteName = "AUT_GER_4301_Site";
        String zipCode = "19901";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();
        
        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();
        
        callCenterIntroductionPageCC
                .waitForPageLoad();
       Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
       DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
        .activateDebugOnProd(env)
        .clickOnAnswer("Learn more about matching to clinical trials")
        .clickNextButton(new DateOfBirthPageCC());
       
       
       dateOfBirthPageCC
       			.waitForPageLoad();
       Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
       Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleGERD_4301_Expected, "Title is diff");
       LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
               .setMonth("Sep")
               .setDay("9")
               .setYear("2010")
               .clickNextButton(new LessThan18YearsOldPageCC());
       DebugPageCC debugPageCC = new DebugPageCC();
       debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       dateOfBirthPageCC
       		   .waitForPageLoad();
       ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
       		   .setYear("1960")
       		   .clickNextButton(new ZipCodePageCC());
       
       
       //-------------DOB Page----------------------------------
       GenderPageCC genderPageCC = zipCodePageCC
    		   .waitForPageLoad()
               .typeZipCode(zipCode)
               .clickNextButton(new GenderPageCC());
       

       //-------------GENDER Page--------------------------------
       DoYouExperienceAnyOfFollowingSymptoms_CC doYouExperienceAnyOfFollowingSymptoms_CC = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_CC());
  
	  
       //-------------DoYouExperienceAnyOfFollowingSymptoms_CC----------------------------------
       doYouExperienceAnyOfFollowingSymptoms_CC
       			.waitForPageLoad();
       			LetMeSeePageCC letMeSeePageCC = doYouExperienceAnyOfFollowingSymptoms_CC
    		   	.clickOnAnswers("None of the above")
    			.clickNextButton(new LetMeSeePageCC());
    	letMeSeePageCC
    			.waitForPageLoadNew();
    			debugPageCC.checkProtocolsContainsForQNumber("Q0017973-QS6302-STUDYQUES", protocol1, protocol2);
    			debugPageCC.back();
        doYouExperienceAnyOfFollowingSymptoms_CC
				.waitForPageLoad();
        WhichoOfFollowingMedicationsCurrentlyGERD_CC whichoOfFollowingMedicationsCurrentlyGERD_CC = doYouExperienceAnyOfFollowingSymptoms_CC
       			.clickOnAnswers("GERD which has been diagnosed by a medical professional",
       							"Heartburn, which can be felt as pain or a burning sensation behind the breastbone",
       							"Acid reflux or frequent regurgitation, which is a sensation of liquid or food coming back up into your throat without vomiting")
       			.clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_CC());
        
        
        
        //-------------WhichoOfFollowingMedicationsCurrentlyGERD_OLS----------------------------------
        whichoOfFollowingMedicationsCurrentlyGERD_CC
        		.waitForPageLoad();
        Assert.assertEquals(whichoOfFollowingMedicationsCurrentlyGERD_CC.getTitleText(),whichoOfFollowingMedicationsCurrentlyGERD_CC.titleExpected, "Title is diff");
        HaveYouEverHadSurgeryOnStomach_CC haveYouEverHadSurgeryOnStomach_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
        //----DQ if selected any of these options in Q3:  None of the above
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC());
        haveYouEverHadSurgeryOnStomach_CC
				.waitForPageLoad();
				debugPageCC.checkProtocolsContainsForQNumber("Q0017975-QS6303-STUDYQUES", protocol1, protocol2);
				debugPageCC.back();
		whichoOfFollowingMedicationsCurrentlyGERD_CC
				.waitForPageLoad(); 		
		//----SKIP to Q5 if selected any of these options in Q3:  Aciphex (rabeprazole), Dexilant (dexlansoprazole), Protonix (pantoprazole), None of the above
		HowLongHaveYouBeenTaking_CC howLongHaveYouBeenTaking_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC		
				.clickOnAnswers("Aciphex, also known as rabeprazole (Agent Note: AH-si-fex, ruh-BEP-ruh-zole)",
						"Dexilant, also known as dexlansoprazole (Agent Note: DEX-ih-lant, dex-lan-SOP-ruh-zole)",
						"Protonix, also known as pantoprazole (Agent Note: pro-TAHN-ix, pan-TOP-ruh-zole)")
				.clickNextButton(new HowLongHaveYouBeenTaking_CC());
		howLongHaveYouBeenTaking_CC
				.waitForPageLoad(1,howLongHaveYouBeenTaking_CC.titleExpected1)
				.waitForPageLoad(2,howLongHaveYouBeenTaking_CC.titleExpected2)
				.waitForPageLoad(3,howLongHaveYouBeenTaking_CC.titleExpected3)
				.back();
		whichoOfFollowingMedicationsCurrentlyGERD_CC
				.waitForPageLoad();
		HowDoYouBuyFollowingMedications_CC howDoYouBuyFollowingMedications_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Nexium, also known as esomeprazol (Agent Note: NEX-ee-um, eh-so-MEP-ruh-zole)",
						"Prevacid, also known as lansoprazole (Agent Note: PREV-uh-sid, lan-SOP-ruh-zole)",
						"Prilosec, also known as omeprazole (Agent Note: PRY-lo-sec, oh-MEP-ruh-zole)",
						"Zegerid, also known as omeprazole and sodium bicarbonate (Agent Note: ZEGG-er-rid, oh-MEP-ruh-zole, SO-dee-um bi-CAR-bo-nate)")
				.clickNextButton(new HowDoYouBuyFollowingMedications_CC());  
        
        
        
        //****************Q4 HowDoYouBuyFollowingMedications_CC --------------
		howDoYouBuyFollowingMedications_CC
			.waitForPageLoad(1,howDoYouBuyFollowingMedications_CC.titleExpected1)
			.waitForPageLoad(2,howDoYouBuyFollowingMedications_CC.titleExpected2)
			.waitForPageLoad(3,howDoYouBuyFollowingMedications_CC.titleExpected3)
			.waitForPageLoad(4,howDoYouBuyFollowingMedications_CC.titleExpected4);
	    Assert.assertEquals(howDoYouBuyFollowingMedications_CC.getTitleText(1),howDoYouBuyFollowingMedications_CC.titleExpected1, "Title is diff");
	    howDoYouBuyFollowingMedications_CC
	    		.clickOnAnswerForSubQuestion(1,"With a prescription from my doctor that I get filled at the pharmacy counter")
		        .clickOnAnswerForSubQuestion(2,"I get this medication off the shelf, or \"over-the-counter\"")
		        .clickOnAnswerForSubQuestion(3,"With a prescription from my doctor that I get filled at the pharmacy counter")
		        .clickOnAnswerForSubQuestion(4,"I get this medication off the shelf, or \"over-the-counter\"")
		        .clickNextButton(new HowLongHaveYouBeenTaking_CC());
	    
        

        //---------------Q5 HowLongHaveYouBeenTaking_CC-------------------
		howLongHaveYouBeenTaking_CC
				.waitForPageLoad(1,howLongHaveYouBeenTaking_CC.titleExpected4)
				.waitForPageLoad(2,howLongHaveYouBeenTaking_CC.titleExpected5)
				.waitForPageLoad(3,howLongHaveYouBeenTaking_CC.titleExpected6)
				.waitForPageLoad(4,howLongHaveYouBeenTaking_CC.titleExpected7);
        Assert.assertEquals(howLongHaveYouBeenTaking_CC.getTitleText(1),howLongHaveYouBeenTaking_CC.titleExpected4, "Title is diff");
        DespiteTakingMedicationDoYouStillExperienceSymptoms_CC despiteTakingMedicationDoYouStillExperienceSymptoms_CC = howLongHaveYouBeenTaking_CC
        		.clickOnAnswerForSubQuestion(1, "Less than 1 month")
		        .clickOnAnswerForSubQuestion(2, "1 month")
		        .clickOnAnswerForSubQuestion(3, "Less than 1 month")
		        .clickOnAnswerForSubQuestion(4, "1 month")
		        .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
				.waitForPageLoad();
		debugPageCC.checkProtocolsContainsForQNumber("Q0018004-QS6306-STUDYQUES", protocol1, protocol2);
		debugPageCC.back();
		howLongHaveYouBeenTaking_CC
				.waitForPageLoad(1,howLongHaveYouBeenTaking_CC.titleExpected4)
        		.clickOnAnswerForSubQuestion(1, "2 months")
		        .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
		
				
		
        //---------------Q7 DespiteTakingMedicationDoYouStillExperienceSymptoms_CC-------------------
		despiteTakingMedicationDoYouStillExperienceSymptoms_CC
        		.waitForPageLoad();
        Assert.assertEquals(despiteTakingMedicationDoYouStillExperienceSymptoms_CC.getTitleText(),despiteTakingMedicationDoYouStillExperienceSymptoms_CC.titleExpected, "Title is diff");
        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
				.clickOnAnswer("No, my symptoms are well-controlled")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC())
				.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0018005-QS6307-STUDYQUES", protocol1, protocol2);
		debugPageCC.back();
		despiteTakingMedicationDoYouStillExperienceSymptoms_CC
				.waitForPageLoad();
		ThinkingAboutThePast2Months_CC thinkingAboutThePast2Months_CC = despiteTakingMedicationDoYouStillExperienceSymptoms_CC
				.clickOnAnswer("Yes, I still have symptoms")
				.clickNextButton(new ThinkingAboutThePast2Months_CC());
        
        
        
		//--------------Q8 ThinkingAboutThePast2Months_CC ---------------------
		thinkingAboutThePast2Months_CC
				.waitForPageLoad();
        Assert.assertEquals(thinkingAboutThePast2Months_CC.getTitleText(),thinkingAboutThePast2Months_CC.titleExpected, "Title is diff");
        thinkingAboutThePast2Months_CC
        		.clickOnAnswer("1 day per week or less")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC())
        		.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0018001-QS6308-STUDYQUES", protocol1, protocol2);
		debugPageCC.back();
		thinkingAboutThePast2Months_CC
				.waitForPageLoad()
				.clickOnAnswer("2 - 3 days per week")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC())
				.waitForPageLoad();
		debugPageCC.checkProtocolsContainsForQNumber("Q0018001-QS6308-STUDYQUES", protocol1, protocol2);
		debugPageCC.back();
		thinkingAboutThePast2Months_CC
				.waitForPageLoad()
				.clickOnAnswer("4 - 5 days per week")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC());        
        
		
		
        //---------------Q9 HaveYouEverHadSurgeryOnStomach_CC-------------------
        haveYouEverHadSurgeryOnStomach_CC
        		.waitForPageLoad();
        Assert.assertEquals(haveYouEverHadSurgeryOnStomach_CC.getTitleText(),haveYouEverHadSurgeryOnStomach_CC.titleExpected, "Title is diff");
        AreYouCurrentlyAbleToSwallowTablets_CC areYouCurrentlyAbleToSwallowTablets_CC = haveYouEverHadSurgeryOnStomach_CC
               .clickOnAnswer("No")
               .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC())
               .waitForPageLoad();
        areYouCurrentlyAbleToSwallowTablets_CC
        		.back();
        haveYouEverHadSurgeryOnStomach_CC
				.waitForPageLoad();
        WhatTypeOfSurgeryDidYouHave_CC whatTypeOfSurgeryDidYouHave_CC = haveYouEverHadSurgeryOnStomach_CC
				.clickOnAnswer("Yes")
				.clickNextButton(new WhatTypeOfSurgeryDidYouHave_CC());
        
        
        
        //---------------Q10 WhatTypeOfSurgeryDidYouHave_CC-------------------
        whatTypeOfSurgeryDidYouHave_CC
        	.waitForPageLoad();
        Assert.assertEquals(whatTypeOfSurgeryDidYouHave_CC.getTitleText(),whatTypeOfSurgeryDidYouHave_CC.titleExpected, "Title is diff");
        //---------SKIP to Q12 if selected "Other surgery on my stomach, intestines, colon, or esophagus"  or go to Q11--------
        whatTypeOfSurgeryDidYouHave_CC
        	   .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
        	   .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC())
               .waitForPageLoad()
               .back();
        whatTypeOfSurgeryDidYouHave_CC
    			.waitForPageLoad();
        WhenDidYouHaveAppendixRemoved_CC whenDidYouHaveAppendixRemoved_CC = whatTypeOfSurgeryDidYouHave_CC
         	    .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
        		.clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)",
        				"Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)", 
        				"Biopsy (Agent Note: BY-op-see) – removal of a small piece of tissue for analysis",
        				"Tonsils removed - Tonsillectomy (Agent Note: tahn-sil-LECK-toe-mee)",
        				"Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)")
        		.clickNextButton(new WhenDidYouHaveAppendixRemoved_CC());
        
        
        
        //---------------Q11 WhenDidYouHaveAppendixRemoved_CC-------------------
        whenDidYouHaveAppendixRemoved_CC
				.waitForPageLoad(1,whenDidYouHaveAppendixRemoved_CC.titleExpected1)
				.waitForPageLoad(2,whenDidYouHaveAppendixRemoved_CC.titleExpected2);
				Assert.assertEquals(whenDidYouHaveAppendixRemoved_CC.getTitleText(1),whenDidYouHaveAppendixRemoved_CC.titleExpected1, "Title is diff");
        whenDidYouHaveAppendixRemoved_CC
				.clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
        		.clickOnAnswerForSubQuestion(2, "4 - 6 months ago")
        		.clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC())
        		.waitForPageLoad();
		debugPageCC.checkProtocolsContainsForQNumber("Q0017976-QS6311-STUDYQUES", protocol1, protocol2);
		debugPageCC.back();
		whenDidYouHaveAppendixRemoved_CC
				.waitForPageLoad(1,whenDidYouHaveAppendixRemoved_CC.titleExpected1)
				.clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
				.clickOnAnswerForSubQuestion(2, "More than 6 months ago")
				.clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC());
        
        
        //---------------Q12 AreYouCurrentlyAbleToSwallowTablets_CC-------------------
		areYouCurrentlyAbleToSwallowTablets_CC
        		.waitForPageLoad();
		TransitionStatementCC transitionStatementCC = areYouCurrentlyAbleToSwallowTablets_CC
        		.clickOnAnswer("No")
        	   .clickNextButton(new TransitionStatementCC())
        	   .waitForPageLoadGERD(studyName);
		debugPageCC.checkProtocolsContainsForQNumber("Q0018000-QS6312-STUDYQUES", protocol1, protocol2);
		debugPageCC.back();
		areYouCurrentlyAbleToSwallowTablets_CC
				.waitForPageLoad();
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = areYouCurrentlyAbleToSwallowTablets_CC
        		.clickOnAnswer("Yes")
         	    .clickNextButton(new TransitionStatementCC())
         	    .waitForPageLoadGERD(studyName)
         	    .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


		//------------------General Health--------------------------
        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Alzheimer's disease", "Anemia (low red blood cell count)", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, seasonal allergy, chronic cough)")
                .clickOnAnswers("Diabetes (type 1 or type 2)", "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)", "Eating disorders (anorexia, bulimia, binge eating disorder)", "Headaches (migraine, cluster, tension)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids", "Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)")
                .clickOnAnswers("Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis, acne, cellulite, actinic or solar keratosis)")
                .clickOnAnswers("Sleep problems (insomnia, sleep apnea, narcolepsy)", "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WhatKindOfArthritisCC());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC.back();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease", "Cirrhosis", "Bipolar disorder", "Cancer in the past 5 years, except skin cancer", "Drug or alcohol abuse within the past year")
                .clickOnAnswers("Hepatitis B", "Hepatitis C", "HIV or AIDS", "Kidney disease requiring dialysis", "Multiple sclerosis (MS)", "Neuropathy (nerve damage due to diabetes or another condition)")
                .clickOnAnswers("Seizure disorder such as epilepsy", "Schizophrenia", "Shingles or herpes zoster infection")
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());
                
        approximateHeightPageCC.waitForPageLoad()
                .setAll("5", "7", "166")
                .clickNextButton(new LetMeSeePageCC());
        

        letMeSeePageCC
                .waitForPageLoad()
//        		.clickNextButton(new ChildrenUnderPageCC())
//        		.waitForPageLoad()
//        		.clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(site_Indication)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(site_Indication1)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
	}
}
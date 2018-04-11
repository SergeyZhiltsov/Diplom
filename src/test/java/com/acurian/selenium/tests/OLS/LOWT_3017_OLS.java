package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.DoYouExperienceAnyOftheFollowing_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HasDoctorEverDiagnosedYouWithLowTestosterone_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.WhichOfTheFollowingMensHealthConditions_OLS;
import com.acurian.selenium.pages.OLS.MDD_3159.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;

public class LOWT_3017_OLS extends BaseTest{

    @Test
    @TestCaseId("00015")
    @Description("LOWT_3017_OLS")
    public void lOWT_3017_OLS() {
        String phoneNumber = "AUTAMSLOWT";
        List<String> protocols = Arrays.asList("M16_100");
        String protocol1 = "M16_100";
        String protocol2 = "R727_CL_1532";
        String studyName = "a men's low testosterone";
        String site_Indication = "Hypogonadism";
        String siteName = "AUT_LOWT_3017";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleLOWT_3017_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091990")
                .clickNextButton(new ZipCodePageOLS());
        zipCodePageOLS
        	.waitForPageLoad();
			DebugPageOLS debugPageOLS = new DebugPageOLS();
			zipCodePageOLS.getPage(debugPageOLS)
			.checkProtocolsContainsForQNumber("QSI8004", protocol1)
			.back();
			dateOfBirthPageOLS.waitForPageLoad()
            .setDate("09091936")
            .clickNextButton(new ZipCodePageOLS());
	    zipCodePageOLS
        	.waitForPageLoad();
			zipCodePageOLS.getPage(debugPageOLS)
			.checkProtocolsContainsForQNumber("QSI8004", protocol1)
			.back();
			dateOfBirthPageOLS.waitForPageLoad()
            .setDate("09091940")
            .clickNextButton(new ZipCodePageOLS());
			
			
        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
    		.waitForPageLoad();
			zipCodePageOLS.getPage(debugPageOLS)
			.checkProtocolsContainsForQNumber("QSI8009", protocol1)
			.back();
			genderPageOLS.waitForPageLoad();
	        DoYouExperienceAnyOftheFollowing_OLS doYouExperienceAnyOftheFollowing_OLS = genderPageOLS
            .clickOnAnswer("Male")
            .clickNextButton(new DoYouExperienceAnyOftheFollowing_OLS());
	        
	        
        //---------------Q2 DoYouExperienceAnyOftheFollowing_OLS page-------------------
	    doYouExperienceAnyOftheFollowing_OLS
                .waitForPageLoad();
        Assert.assertEquals(doYouExperienceAnyOftheFollowing_OLS.getTitleText(),doYouExperienceAnyOftheFollowing_OLS.titleExpected, "Title is diff");
        		doYouExperienceAnyOftheFollowing_OLS.clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS5602", protocol1);
        		debugPageOLS.back();
        		doYouExperienceAnyOftheFollowing_OLS.waitForPageLoad();
        		HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_OLS = doYouExperienceAnyOftheFollowing_OLS
                .clickOnAnswers("Decreased sexual desire or libido",
                		"Decreased spontaneous erections (e.g., morning erections)",
                		"Decreased energy or fatigue/feeling tired",
                		"Low mood or depressed mood",
                		"Loss of body (axillary and pubic) hair or reduced shaving",
                		"Hot flashes")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());

        //---------------Q3 hasDoctorEverDiagnosedYouWithLowTestosterone_OLS-------------------
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad();
        Assert.assertEquals(hasDoctorEverDiagnosedYouWithLowTestosterone_OLS.getTitleText(),hasDoctorEverDiagnosedYouWithLowTestosterone_OLS.titleExpected, "Title is diff");
        AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS());

        //---------------Q4 AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS-------------------
        areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
        	.waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.getTitleText(),areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.titleExpected, "Title is diff");
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
                .clickOnAnswers("Unsure")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();
        		areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();
        		areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.waitForPageLoad()
				.clickOnAnswers("AndroGel","Endoderm patch","Axiron gel","Fortesta gel",
						"Striant (testosterone buccal system)","Testim gel",
						"Testosterone injection (Depo-Testosterone, Testosterone enanthate, Testosterone Cypionate, Delatestryl)",
						"Clomiphene (brand name Serophene) or another anti-estrogen therapy",
						"Other testosterone medication not on this list")
				.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());        

		//---------------Q5 HaveYouEverExperiencedHeartRelatedMedicalCondOLS page-------------------		
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverExperiencedHeartRelatedMedicalCondOLS.getTitleText(),haveYouEverExperiencedHeartRelatedMedicalCondOLS.titleExpected, "Title is diff");		
        //-------------If selected exclusively "Heart failure" or "None of the above", Skip to Q7	
        HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
        		.clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS());
        		haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS());
				haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
				.waitForPageLoad()
				.back();
		haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad();
				SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
				.clickOnAnswers("Heart attack","Stroke",
						"TIA or \"mini-stroke\"",
						"Angina (heart-related chest pain) that required an overnight hospital stay")
				.clickNextButton(new SubquestionExperiencedHeartPageOLS());

        
		//---------------Q6 SubquestionExperiencedHeartPageOLS page------------------
		 subquestionExperiencedHeartPageOLS
		                .waitForPageLoad();
		        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1),subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
		        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2),subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
		        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(3),subquestionExperiencedHeartPageOLS.titleExpected3, "Title is diff");
		        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(4),subquestionExperiencedHeartPageOLS.titleExpected4, "Title is diff");
		        //HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS = subquestionExperiencedHeartPageOLS
		        subquestionExperiencedHeartPageOLS
		        		.clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
		                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
		                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"Less than 30 days ago")
		                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"Less than 30 days ago")
		                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS());
		        haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
		                .waitForPageLoad()
		                .getPage(debugPageOLS)
		                .checkProtocolsContainsForQNumber("QS5606", protocol1)
		                .back();
		        subquestionExperiencedHeartPageOLS
		                .waitForPageLoad()
		                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
		                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
		                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"More than 1 year ago")
		                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
		                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS);
		        
		//---------------Q7 haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS page------------------
		        haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
		                .waitForPageLoad();
		        Assert.assertEquals(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS.getTitleText(),haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS.titleExpected, "Title is diff");
		        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
		        		.clickOnAnswers("Peripheral Artery Disease or PAD (narrowed or hardened blood vessels in your arms or legs)",
		        				"Coronary heart disease or blocked arteries",
		        				"Hardening of the arteries",
		        				"Heart disease found by catheterization or stress test on a treadmill",
		        				"Intermittent claudication (pain in legs while walking, caused by blockage of blood vessels)",
		        				"Abdominal aortic aneurysm (an enlarged area in the lower part of the aorta, the major blood vessel in the stomach that supplies blood to the body)",
		        				"Carotid artery disease (narrowing or blockage of the major arteries in your neck)",
		        				"Stenosis (narrowing of the blood vessels or arteries)",
		        				"Atrial Fibrillation or Afib")
		                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
		        heartrelatedMedicalProceduresPageOLS
		        .waitForPageLoad();
		        heartrelatedMedicalProceduresPageOLS.back();
		        haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
		        

		//---------------Q8 heartrelatedMedicalProceduresPageOLS page------------------
		   heartrelatedMedicalProceduresPageOLS
		        .waitForPageLoad();
		        Assert.assertEquals(heartrelatedMedicalProceduresPageOLS.getTitleText(),heartrelatedMedicalProceduresPageOLS.titleExpected, "Title is diff");
		        //-----SKIP to Q10 if selected "None of the above" in Q8
		        SmokedCigarettesPageOLS smokedCigarettesPageOLS = heartrelatedMedicalProceduresPageOLS
		        .clickOnAnswers("None of the above")
		        .clickNextButton(new SmokedCigarettesPageOLS());
		        smokedCigarettesPageOLS.waitForPageLoad();
		        smokedCigarettesPageOLS.back();
		    heartrelatedMedicalProceduresPageOLS
		        .waitForPageLoad();
		        WhenWasYourMostRecentHeartProcedureOLS whenWasYourMostRecentHeartProcedureOLS = heartrelatedMedicalProceduresPageOLS
	        	.clickOnAnswers("Angioplasty")
	        	.clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS());
		
		//---------------Q9 whenWasYourMostRecentHeartProcedureOLS page------------------
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad();
		Assert.assertEquals(whenWasYourMostRecentHeartProcedureOLS.getTitleText(),whenWasYourMostRecentHeartProcedureOLS.titleExpected, "Title is diff");
		whenWasYourMostRecentHeartProcedureOLS.clickOnAnswer("Less than 30 days ago")
        .clickNextButton(new SmokedCigarettesPageOLS());
		smokedCigarettesPageOLS.waitForPageLoad()
        .getPage(debugPageOLS)
        .checkProtocolsContainsForQNumber("QS5609", protocol1)
        .back();
		whenWasYourMostRecentHeartProcedureOLS
        .waitForPageLoad()
        .clickOnAnswer("More than 1 year ago")
        .clickNextButton(new SmokedCigarettesPageOLS());
		
		
		//---------------Q10 SmokedCigarettesPageOLS page------------------
		smokedCigarettesPageOLS
				.waitForPageLoad();
		Assert.assertEquals(smokedCigarettesPageOLS.getTitleText(),smokedCigarettesPageOLS.titleExpected, "Title is diff");
		smokedCigarettesPageOLS.clickOnAnswer("No, I never smoked")
        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.back();
		smokedCigarettesPageOLS
		.waitForPageLoad();
		smokedCigarettesPageOLS.clickOnAnswer("Yes, I currently smoke")
        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

		
		
        //----------****************NEW GENERAL HEALTH Questions************************----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad();
        Assert.assertEquals(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.getTitleText(),haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.titleExpected, "Title is diff");
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        	.clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
        		"Alzheimer's disease",
        		"Anemia (low red blood cell count)",
        		"Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
        		"Autism spectrum",
        		"Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
        		"Breathing, respiratory, or lung problems (COPD, asthma, seasonal allergy, chronic cough)",
        		"Cancer",
        		"Diabetes (type 1 or type 2)",
        		"Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
        		"Eating disorders (anorexia, bulimia, binge eating disorder)",
        		"Headaches (migraine, cluster, tension)",
        		"Heart or circulation problems (heart attack, heart failure, stroke)",
        		"High blood pressure or hypertension",
        		"High cholesterol, triglycerides, or lipids",
        		"Kidney disease",
        		"Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
        		"Lung problems",
        		"Lupus",
        		"Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
        		"Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
        		"Skin problems (eczema or atopic dermatitis, psoriasis, acne, cellulite, actinic or solar keratosis)",
        		"Sleep problems (insomnia, sleep apnea, narcolepsy)",
        		"Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
        		"Men's health issues (prostate enlargement or BPH, low testosterone, erectile dysfunction or ED, male pattern balding)") 
        .clickNextButton(new WhatKindOfArthritisPage())
        .waitForPageLoad()
        .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad();
        WhichOfTheFollowingHaveYouBeenDiagnosed_OLS whichOfTheFollowingHaveYouBeenDiagnosed_OLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .clickOnAnswers("None of the above")
        .clickOnAnswers("Men's health issues (prostate enlargement or BPH, low testosterone, erectile dysfunction or ED, male pattern balding)","Eating disorders (anorexia, bulimia, binge eating disorder)")
        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosed_OLS())
        
        
		//----------Q9 - Which of the following have you been diagnosed with?--------   
    	.waitForPageLoad();
        Assert.assertEquals(whichOfTheFollowingHaveYouBeenDiagnosed_OLS.getTitleText(),whichOfTheFollowingHaveYouBeenDiagnosed_OLS.titleExpected, "Title is diff");
        WhichOfTheFollowingMensHealthConditions_OLS whichOfTheFollowingMensHealthConditions_OLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        		.clickOnAnswers("Anorexia","Bulimia","Binge eating disorder")
        .clickNextButton(new WhichOfTheFollowingMensHealthConditions_OLS());           


		//----------Q23 - Which of the following men's health conditions have you been diagnosed with?--------      
        whichOfTheFollowingMensHealthConditions_OLS
        	.waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfTheFollowingMensHealthConditions_OLS
        .clickOnAnswers("Enlarged prostate or BPH","Erectile dysfunction (ED)","Male pattern balding","Overactive bladder (OAB)")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        
        
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------      
        doAnyOftheFollowingAdditionalDiagnosesOLS
        	.waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
        .clickOnAnswers("Alzheimer's disease",
        		"Bipolar disorder",
        		"Cancer in the past 5 years, except skin cancer",
        		"Cirrhosis",
        		"Drug or alcohol abuse within the past year",
        		"Hepatitis B",
        		"Hepatitis C",
        		"HIV or AIDS",
        		"Kidney disease requiring dialysis",
        		"Multiple sclerosis (MS)",
        		"Neuropathy (nerve damage due to diabetes or another condition)",
        		"Seizure disorder such as epilepsy",
        		"Schizophrenia",
        		"Shingles or herpes zoster infection")
        .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
        	.waitForPageLoad()
        .setAll("5", "5", "160")
        .clickNextButton(new ChildrenUnderPageOLS())
        .waitForPageLoad()
        .getPage(debugPageOLS)
        .checkProtocolsContainsForQNumber("QS59", protocol1)
        .back();
        approximateHeightPageOLS.waitForPageLoad()
        .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new ApproximateHeightPageOLS())
        
		//----------ProvideHeight-Weight Page--------------------
        .waitForPageLoad()
        .setFeatwithClear("3")
        .clickNextButton(new ChildrenUnderPageOLS())
        .waitForPageLoad()
        .getPage(debugPageOLS)
        .checkProtocolsContainsForQNumber("QS60", protocol1)
        .back();
        approximateHeightPageOLS
        	.waitForPageLoad()
            .setFeatwithClear("5")
        .clickNextButton(new ChildrenUnderPageOLS())
        
        
		//----------ChildrenUnderTheAge Page--------------------
        .waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new HouseholdHavePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new TheStudySitePageOLS())
        .waitForPageLoad()
        
		//-------------------PEDIATRIC QUESTIONS-----------------------------   
        .clickOnAnswer("Public transportation")
        .clickNextButton(new WhatMedicalCoveragePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("No, I have no coverage")
        .clickNextButton(new EthnicBackgroundPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("Prefer not to answer")
        .clickNextButton(new IdentificationPageOLS())
		//----------PII (IdentificationPageOLS) Page--------------------
		.waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
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
        .getPage(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
    }
}
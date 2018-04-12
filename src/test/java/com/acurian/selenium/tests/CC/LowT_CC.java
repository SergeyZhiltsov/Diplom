package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.ThankYouForAnsweringCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LOWT.CurrentlyTakingFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.LOWT.DiagnosedYouWithLowTestosteroneCC;
import com.acurian.selenium.pages.CC.LOWT.ExperiencedAnyOfFollowingCC;
import com.acurian.selenium.pages.CC.MDD_3159.WhenWasYourMostRecentHeartProcedureCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMensHealthConditionsCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC;
import com.acurian.selenium.pages.CC.shared.HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class LowT_CC extends BaseTest{
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void lowT(final String username, final String password) {
        String phoneNumber = "AUTAMSLOWT";
        List<String> protocols = Arrays.asList("M16_100", "R727_CL_1532");
        String protocol1 = "M16_100";
        String protocol2 = "R727_CL_1532";
        String studyName = "a high cholesterol and heart disease";
     //   String env = "STG";
        String siteName = "AUT_LOWT_3017_Site";
        String site_Indication = "Hypogonadism";
        String zipCode  = "19044";  //"45203" cincinnati, OH
        
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
       
       //dateOfBirthPageCC.waitForPageLoad();
       ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
               .setMonth("Sep")
               .setDay("9")
               .setYear("1990")
               .clickNextButton(new ZipCodePageCC());
       DebugPageCC debugPageCC = new DebugPageCC();       
       debugPageCC.checkProtocolsEquals("If you qualify and participate in a men's low testosterone study, you may receive: Study medication...", protocol1, protocol2);
       debugPageCC.back();
       dateOfBirthPageCC
       		   .waitForPageLoad()
       		   .setYear("1960")
       		   .clickNextButton(new ZipCodePageCC());
       
       GenderPageCC genderPageCC = zipCodePageCC
    		   .waitForPageLoad()
               .typeZipCode("19044")
               .clickNextButton(new GenderPageCC());
       
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());       
       debugPageCC.checkProtocolsEquals("This part of the questionnaire requires that we ask about your gender. To confirm, please tell me, i...", protocol1);
       debugPageCC.back();
       ExperiencedAnyOfFollowingCC experiencedAnyOfFollowingCC = genderPageCC
	   		   .waitForPageLoad()
	   		   .clickOnAnswer("Male")
	   		   .clickNextButton(new ExperiencedAnyOfFollowingCC());
       
       NonQRtransitionPageCC nonQRtransitionPageCC = experiencedAnyOfFollowingCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new NonQRtransitionPageCC());
       debugPageCC.checkProtocolsEquals("The following are symptoms that men with low testosterone sometimes experience.Do you experience any...", protocol1);
       debugPageCC.back();
       DiagnosedYouWithLowTestosteroneCC diagnosedYouWithLowTestosteroneCC = experiencedAnyOfFollowingCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Decreased sexual desire or libido", "Decreased spontaneous erections (e.g., morning erections)", "Decreased energy or fatigue/feeling tired")
    		   .clickOnAnswers("Loss of body (axillary and pubic) hair or reduced shaving", "Hot flashes", "Low mood or depressed mood")    		   
    		   .clickNextButton(new DiagnosedYouWithLowTestosteroneCC());
       
       debugPageCC.checkProtocolsContainsForQNumber("Q0015802-QS5602-STUDYQUES", "false");
       debugPageCC.back();
       experiencedAnyOfFollowingCC
	           .waitForPageLoad()
	           .clickOnAnswers("None of the above")
	           .clickOnAnswers("Decreased sexual desire or libido")
	           .clickNextButton(new DiagnosedYouWithLowTestosteroneCC());
       
       CurrentlyTakingFollowingMedicationsCC currentlyTakingFollowingMedicationsCC = diagnosedYouWithLowTestosteroneCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new CurrentlyTakingFollowingMedicationsCC());
       
       HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = currentlyTakingFollowingMedicationsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("AndroGel", "Endoderm patch", "Fortesta gel", "Striant (testosterone buccal system)", "Testim gel", "Other testosterone medication not on this list", "Unsure")
    		   .clickOnAnswers("Testosterone injection (Depo-Testosterone, Testosterone enanthate, Testosterone Cypionate, Delatestryl)", "Clomiphene (brand name Serophene) or another anti-estrogen therapy", "None of the above")
    		   .clickOnAnswers("Axiron gel")
    		   .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
       
       SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Stroke", "TIA or \"mini-stroke\"", "Angina (heart-related chest pain) that required an overnight hospital stay", "Heart failure or congestive heart failure (CHF)", "None of the above")
    		   .clickOnAnswers("Heart attack")
    		   .clickNextButton(new SubquestionExperiencedHeartPageCC());
       
       HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC haveYouEverBeenDiagnosedAdditionalHeartRelatedCC = subquestionExperiencedHeartPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("1 - 3 months ago")
    		   .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       debugPageCC.checkProtocolsEquals(" ", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC
	   		  .waitForPageLoad()
	   		  .clickOnAnswer("Less than 30 days ago")
	   		  .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       debugPageCC.checkProtocolsEquals(" ", protocol1);
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
		      .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       debugPageCC.checkProtocolsEquals(" ", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC
	   		  .waitForPageLoadStroke()
	   		  .clickOnAnswer("1 - 3 months ago")
	   		  .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       debugPageCC.checkProtocolsEquals(" ", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC.back();
       
       haveYouEverExperiencedHeartRelatedMedicalCondCC
		  	 .waitForPageLoad()
		  	 .clickOnAnswers("None of the above")
		  	 .clickOnAnswers("TIA or \"mini-stroke\"")
		  	 .clickNextButton(new SubquestionExperiencedHeartPageCC());
       subquestionExperiencedHeartPageCC
	      	.waitForPageLoadTIA()
	      	.clickOnAnswer("Less than 30 days ago")
	      	.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       debugPageCC.checkProtocolsEquals(" ", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC
		  	.waitForPageLoadTIA()
		  	.clickOnAnswer("1 - 3 months ago")
		  	.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       debugPageCC.checkProtocolsEquals(" ", protocol1);
       debugPageCC.back();
       subquestionExperiencedHeartPageCC.back();
       haveYouEverExperiencedHeartRelatedMedicalCondCC
	  	 	.waitForPageLoad()	 
	  	 	.clickOnAnswers("None of the above")
	  	 	.clickOnAnswers("Stroke")
	  	 	.clickNextButton(new SubquestionExperiencedHeartPageCC());
       subquestionExperiencedHeartPageCC
    		.waitForPageLoadStroke()
    		.clickOnAnswer("7 - 12 months ago")
    		.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
       
       
       HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
    		   .waitForPageLoad()
               .clickOnAnswers("Peripheral Artery Disease or PAD (narrowed or hardened blood vessels in your arms or legs)", "Coronary heart disease or blocked arteries", "Hardening of the arteries")
               .clickOnAnswers("Heart disease found by catheterization or stress test on a treadmill", "Intermittent claudication (pain in legs while walking, caused by blockage of blood vessels)")
               .clickOnAnswers("Abdominal aortic aneurysm (an enlarged area in the lower part of the aorta, the major blood vessel in the stomach that supplies blood to the body)", "Carotid artery disease (narrowing or blockage of the major arteries in your neck)")
               .clickOnAnswers("Stenosis (narrowing of the blood vessels or arteries)", "Atrial Fibrillation or Afib", "None of the above")
               .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
       
       WhenWasYourMostRecentHeartProcedureCC whenWasYourMostRecentHeartProcedureCC = haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Angioplasty", "Stent placement", "Atherectomy", "Revascularization")
    		   .clickOnAnswers("Coronary artery bypass graft, also known as CABG, \"cabbage,\" or heart bypass surgery")
    		   .clickOnAnswers("None of the above")
    		   .clickOnAnswers("Procedure to clear plaque from blood vessels in the neck such as carotid endarterectomy")
    		   .clickNextButton(new WhenWasYourMostRecentHeartProcedureCC());
       
       SmokedCigarettesPageCC smokedCigarettesPageCC = whenWasYourMostRecentHeartProcedureCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Less than 30 days ago")
    		   .clickNextButton(new SmokedCigarettesPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015137-QS5609-STUDYQUES", protocol1);
       debugPageCC.back();
       whenWasYourMostRecentHeartProcedureCC
	   		   .waitForPageLoad()
	   		   .clickOnAnswer("1 - 3 months ago")
	   		   .clickNextButton(new SmokedCigarettesPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015137-QS5609-STUDYQUES", protocol1);
       debugPageCC.back();
       whenWasYourMostRecentHeartProcedureCC.back();
       
       haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
    		   .waitForPageLoad()    		  
    		   .clickOnAnswers("None of the above")
    		   .clickNextButton(new SmokedCigarettesPageCC());
       
       
       ThankYouForAnsweringCC thankYouForAnsweringCC = smokedCigarettesPageCC
    		   .waitForPageLoad()    		   
    		   .clickOnAnswer("No, I never smoked")
    		   .clickNextButton(new ThankYouForAnsweringCC());
    		   
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC1 = thankYouForAnsweringCC
    		   .waitForPageLoad()
    		   .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
       
       WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC1
    		   .waitForPageLoad()
    		   .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Alzheimer's disease", "Anemia (low red blood cell count)", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
    		   .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, seasonal allergy, chronic cough)")
    		   .clickOnAnswers("Diabetes (type 1 or type 2)", "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)", "Eating disorders (anorexia, bulimia, binge eating disorder)", "Headaches (migraine, cluster, tension)")
    		   .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids", "Kidney disease")
    		   .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)")
    		   .clickOnAnswers("Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis, acne, cellulite, actinic or solar keratosis)")
    		   .clickOnAnswers("Sleep problems (insomnia, sleep apnea, narcolepsy)", "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
    		   .clickNextButton(new WhatKindOfArthritisCC());
       
       whatKindOfArthritisCC.back();
       FollowingMensHealthConditionsCC followingMensHealthConditionsCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC1
	   .waitForPageLoad()
	   .clickOnAnswers("None of the above")
	   .clickOnAnswers("Men's health issues (prostate enlargement or BPH, low testosterone, erectile dysfunction or ED, male pattern balding)")
	   .clickNextButton(new FollowingMensHealthConditionsCC());
       
       DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = followingMensHealthConditionsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Enlarged prostate or BPH")
    		   .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
       
       ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Alzheimer's disease", "Bipolar disorder", "Cancer in the past 5 years, except skin cancer", "Cirrhosis", "Hepatitis B", "Hepatitis C", "HIV or AIDS", "Kidney disease requiring dialysis", "Multiple sclerosis (MS)")
    		   .clickOnAnswers("Drug or alcohol abuse within the past year", "Neuropathy (nerve damage due to diabetes or another condition)", "Seizure disorder such as epilepsy", "Schizophrenia", "Shingles or herpes zoster infection")
    		   .clickNextButton(new ApproximateHeightPageCC());
       
       ChildrenUnderPageCC childrenUnderPageCC = approximateHeightPageCC
    		   .waitForPageLoad()
               .setAll("5", "5", "160")
               .clickNextButton(new ChildrenUnderPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();
       approximateHeightPageCC.back();
       
       doAnyOftheFollowingAdditionalDiagnosesCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")
    		   .clickOnAnswers("Schizophrenia", "Shingles or herpes zoster infection")
    		   .clickNextButton(new ApproximateHeightPageCC());
       
       LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
    		   .waitForPageLoad()
               .setAll("5", "5", "160")
               .clickNextButton(new LetMeSeePageCC());
       
       letMeSeePageCC
              .waitForPageLoad()
              .clickNextButton(new ChildrenUnderPageCC())
              .waitForPageLoad()
              .clickOnAnswer("No")
              .clickNextButton(new IdentificationPageCC())
              .waitForPageLoad()
              .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)              
              .clickNextButton(new SiteSelectionPageCC())
              .waitForPageLoad("a men's low testosterone study")
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

package com.acurian.selenium.tests.OLS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.AbilityToAttendSchoolOrWorkOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.CurrentlyTakeFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.ExperiencingAMigraineOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.FollowingMedicationsToPreventOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.HowManyDaysYouSufferOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.HowManyDaysYouTakeMedicationsOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.HowManyDifferentMedicationsOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.ImpactHaveYourMigraineHeadachesOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.MigraineAffectedYourAbilityOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.MostRecentMigraineEndOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.PerformHouseholdChoresOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.TreatYourMigraineHeadachesOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.WhichOfTheFollowingSymptomsOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.WhenWasYourMostRecentHeartProcedureOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.EsignatureFormOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.AgeWhenDiagnosedWithMigOLS;
import com.acurian.selenium.pages.OLS.shared.ApproxHowLongSufferingFromMIG;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DoYouSufferFromMigHeadachesOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HasDoctorDiagnosedYouWithClusterHeadache_OLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LMG_4686_OLS extends BaseTest{

    @Test(enabled = true)
    @TestCaseId("00002")
    @Description("MIG_4356B_Synexus_OLS module")
    public void lmg_4686() {
        String phoneNumberMIG = "AUTAMS1MIG";
        String protocol1 = "I5Q_MC_CGAW";       
        String studyName =  "a migraine"; 
        String siteName = "AUT_LMG";
        String zip_Code = "19341";
        String site_Indication = "Migraines";
        
       
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleLMGExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
                .clickNextButton(new ZipCodePageOLS());
        
        zipCodePageOLS
        		.waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
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
        Assert.assertEquals(doYouSufferFromMigHeadachesOLS.getTitleText(),doYouSufferFromMigHeadachesOLS.titleExpected, "Title is diff");
        HasDoctorDiagnosedYouWithClusterHeadache_OLS hasDoctorDiagnosedYouWithClusterHeadache_OLS = doYouSufferFromMigHeadachesOLS
        		.clickOnAnswer("No")
        		.clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_OLS());
        
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6002", protocol1);
		debugPageOLS.back();
		
		AgeWhenDiagnosedWithMigOLS  ageWhenDiagnosedWithMigOLS = doYouSufferFromMigHeadachesOLS
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
		
		WhichOfTheFollowingSymptomsOLS whichOfTheFollowingSymptomsOLS = howManyDaysYouSufferOLS
				.waitForPageLoad()
				.selectDays("5")
				.clickNextButton(new WhichOfTheFollowingSymptomsOLS());
		
		HowManyDifferentMedicationsOLS howManyDifferentMedicationsOLS = whichOfTheFollowingSymptomsOLS
				.waitForPageLoad()
				.clickOnAnswers("Eye pain / blurred vision", "Constipation", "Hearing problems", "Lightheadedness and/or fainting")
				.clickOnAnswers("Nausea and/or vomiting", "Throbbing or pulsating pain on sides of head", "Problems with your speech")
				.clickNextButton(new HowManyDifferentMedicationsOLS());
		
		FollowingMedicationsToPreventOLS followingMedicationsToPreventOLS = howManyDifferentMedicationsOLS
				.waitForPageLoad()
				.noOfMedications("4")
				.clickNextButton(new FollowingMedicationsToPreventOLS());
		
		CurrentlyTakeFollowingMedicationsOLS CurrentlyTakeFollowingMedicationsOLS = followingMedicationsToPreventOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS6008", protocol1);
		debugPageOLS.back();
		
		followingMedicationsToPreventOLS
				.waitForPageLoad()
				.clickOnAnswers("Topamax, Qudexy, Trokendi, or topiramate")
				.clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS6008", protocol1);
		debugPageOLS.back();
		followingMedicationsToPreventOLS
				.waitForPageLoad()
				.clickOnAnswers("Depacon or valproate, Depakote or divalproex", "Elavil or amitriptyline", "Sibelium or Flunarizine", "Timolol")
				.clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS6008", protocol1);
		debugPageOLS.back();
		followingMedicationsToPreventOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Sibelium or Flunarizine", "Timolol")
				.clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());
		
		HowManyDaysYouTakeMedicationsOLS howManyDaysYouTakeMedicationsOLS = CurrentlyTakeFollowingMedicationsOLS
				.waitForPageLoad()
				.clickOnAnswers("Alagesic", "Ascomp", "Bupap", "Dolgic", "Esgic", "Fioricet", "Fiorinal", "Margesic", "Orviban", "Phrenilin", "Promacet", "Repan")
				.clickOnAnswers("Butalbital", "Zebutal")
				.clickNextButton(new HowManyDaysYouTakeMedicationsOLS());
		
		TreatYourMigraineHeadachesOLS treatYourMigraineHeadachesOLS = howManyDaysYouTakeMedicationsOLS
				.waitForPageLoad()
				.selectDays("4")
				.clickNextButton(new TreatYourMigraineHeadachesOLS());
		
		treatYourMigraineHeadachesOLS
				.waitForPageLoad()
				.clickOnAnswers("Percocet, Oxycontin, or oxycodone", "Vicodin, Lortab, or hydrocodone", "Ultram or tramadol", "Tylenol #3, Tylenol #4, or codeine")
				.clickNextButton(new HowManyDaysYouTakeMedicationsOLS());
		
		MigraineAffectedYourAbilityOLS migraineAffectedYourAbilityOLS = howManyDaysYouTakeMedicationsOLS
				.waitForPageLoad()
				.selectDays("1")
				.clickNextButton(new MigraineAffectedYourAbilityOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS6022", protocol1);
		debugPageOLS.back();
		
		howManyDaysYouTakeMedicationsOLS
				.waitForPageLoad()
				.selectDays("0")
				.clickNextButton(new MigraineAffectedYourAbilityOLS());
		
		AbilityToAttendSchoolOrWorkOLS abilityToAttendSchoolOrWorkOLS = migraineAffectedYourAbilityOLS
				.waitForPageLoad()
				.clickOnAnswers("Attend school or work - including completing assignments", "Attend social events or activities")
				.clickOnAnswers("Perform regular household chores such as cleaning, doing yardwork or running errands")
				.clickNextButton(new AbilityToAttendSchoolOrWorkOLS());
		
		PerformHouseholdChoresOLS performHouseholdChoresOLS = abilityToAttendSchoolOrWorkOLS
				.waitForPageLoad()
				.clickOnAnswer("You have not missed any school or work but you have been significantly less productive due to your migraines")
				.clickNextButton(new PerformHouseholdChoresOLS());
		
		ImpactHaveYourMigraineHeadachesOLS impactHaveYourMigraineHeadachesOLS = performHouseholdChoresOLS
				.waitForPageLoad()
				.clickOnAnswer("You are able to perform your household chores such as cleaning and running errands, but you are significantly less productive due to your migraines")
				.clickNextButton(new ImpactHaveYourMigraineHeadachesOLS());
		
		ExperiencingAMigraineOLS experiencingAMigraineOLS = impactHaveYourMigraineHeadachesOLS
				.waitForPageLoad()
				.clickOnAnswer("Moderate impact")
				.clickNextButton(new ExperiencingAMigraineOLS());
		
		MostRecentMigraineEndOLS mostRecentMigraineEndOLS = experiencingAMigraineOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new MostRecentMigraineEndOLS());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = mostRecentMigraineEndOLS
				.waitForPageLoad()
				.clickOnAnswer("1 to 2 weeks ago")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		WhatKindOfArthritisPage whatKindOfArthritisPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad()
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
	        		"Women's health issues (endometriosis, uterine fibroids, PCOS, dense breasts)") 
	            .clickNextButton(new WhatKindOfArthritisPage());
		whatKindOfArthritisPage.waitForPageLoad();
		whatKindOfArthritisPage.back();
		HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad()
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
		        		"Women's health issues (endometriosis, uterine fibroids, PCOS, dense breasts)")
				.clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
				.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
		
		SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
				.waitForPageLoad()
				.clickOnAnswers("Heart attack")
				.clickNextButton(new SubquestionExperiencedHeartPageOLS());
		
		HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS = subquestionExperiencedHeartPageOLS
				.waitForPageLoadHeartAttack()
				.clickOnAnswers("Less than 30 days ago")
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
		debugPageOLS.back();
		subquestionExperiencedHeartPageOLS
				.waitForPageLoadHeartAttack()
				.clickOnAnswers("1 - 3 months ago")
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
		debugPageOLS.back();
		
		subquestionExperiencedHeartPageOLS
				.waitForPageLoadHeartAttack()
				.clickOnAnswers("4 - 6 months ago")
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());
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
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
		debugPageOLS.back();
		subquestionExperiencedHeartPageOLS
				.waitForPageLoadStroke()				
				.clickOnAnswers("1 - 3 months ago")
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
		debugPageOLS.back();
		subquestionExperiencedHeartPageOLS
				.waitForPageLoadStroke()				
				.clickOnAnswers("4 - 6 months ago")
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());
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
				.clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS());
		
		WhenWasYourMostRecentHeartProcedureOLS whenWasYourMostRecentHeartProcedureOLS = haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad()
				.clickOnAnswers("Angioplasty")
				.clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS());
		
		DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("Less than 30 days ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("1 - 3 months ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("4 - 6 months ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS.back();
		
		haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad()
				.clickOnAnswers("Stent placement")
				.clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS());
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("Less than 30 days ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS.back();
		
		haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad()
				.clickOnAnswers("Atherectomy")
				.clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS());
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("Less than 30 days ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS.back();
		
		haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad()
				.clickOnAnswers("Procedure to clear plaque from blood vessels in the neck such as carotid endarterectomy")
				.clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS());
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("Less than 30 days ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS.back();
		
		haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad()
				.clickOnAnswers("Coronary artery bypass graft, also known as CABG, \"cabbage,\" or heart bypass surgery")
				.clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS());
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("Less than 30 days ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS.back();

		haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
				.waitForPageLoad()
				.clickOnAnswers("Revascularization")
				.clickNextButton(new WhenWasYourMostRecentHeartProcedureOLS());
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("Less than 30 days ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS49", protocol1);
		debugPageOLS.back();
		whenWasYourMostRecentHeartProcedureOLS
				.waitForPageLoad()
				.clickOnAnswer("More than 1 year ago")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		
		ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Cirrhosis")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis B")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis C")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("HIV or AIDS")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Kidney disease requiring dialysis")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Schizophrenia")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ApproximateHeightPageOLS());
		
		ChildrenUnderPageOLS childrenUnderPageOLS = approximateHeightPageOLS
				.waitForPageLoad()
				.setAll("5", "7", "166")
				.clickNextButton(new ChildrenUnderPageOLS());		
		 
		childrenUnderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
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
		        .getPage(new ThankYouCloseSimplePageOLS())
		        .waitForPageLoad()
		        .clickNextButton(new AboutHealthPageOLS())
		        .waitForPageLoad()
		        .pidFromDbToLog(env);
		
		
    }

}

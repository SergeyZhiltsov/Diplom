package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.LMG_4686.AbilityToAttendSchoolOrWorkCC;
import com.acurian.selenium.pages.CC.LMG_4686.ExperiencingMigraineRightNowCC;
import com.acurian.selenium.pages.CC.LMG_4686.FollowingSymptomsCC;
import com.acurian.selenium.pages.CC.LMG_4686.HowManyDaysCC;
import com.acurian.selenium.pages.CC.LMG_4686.HowManyDaysYouSufferCC;
import com.acurian.selenium.pages.CC.LMG_4686.HowManyDifferentMedicationsCC;
import com.acurian.selenium.pages.CC.LMG_4686.HowMuchOfImpactCC;
import com.acurian.selenium.pages.CC.LMG_4686.MedicationsToPreventMigrainesCC;
import com.acurian.selenium.pages.CC.LMG_4686.MedicationsToTreatYourMigraineCC;
import com.acurian.selenium.pages.CC.LMG_4686.MostRecentMigraineEndCC;
import com.acurian.selenium.pages.CC.LMG_4686.Past3MonthsCC;
import com.acurian.selenium.pages.CC.LMG_4686.PerformHouseholdChoresCC;
import com.acurian.selenium.pages.CC.LMG_4686.TreatYourMigraineHeadachesCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedFlareMonitoringAppClose_CC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.WhichTypeOfHeadacheCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromMigPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HasDoctorDiagnosedYouWithClusterHeadache_CC;
import com.acurian.selenium.pages.CC.shared.HowLongSufferingFromMigraineCC;
import com.acurian.selenium.pages.CC.shared.HowOldWereYouMigHeadachePageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.StudyQuestionMigPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class LMG_4686_CC extends BaseTest{
	
	@Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void LMG_4686_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1LMG";
        List<String> protocols = Arrays.asList("I5Q_MC_CGAW");
        String protocol1 = "I5Q_MC_CGAW";        
        String studyName = "migraine";
        String studyName1 = "migraine";
    //    String env = "STG";
        String siteName = "AUT_LMG";
        String site_indication = "Ankylosing Spondylitis";
        String zipCode  = "19341";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
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
       
       FollowingSymptomsCC followingSymptomsCC = howManyDaysYouSufferCC
       			 .waitForPageLoad()
       			 .selectDay("2")
       			 .clickNextButton(new FollowingSymptomsCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0017149-QS6005-STUDYQUES", protocol1);
       debugPageCC.back();
       
       howManyDaysYouSufferCC
			 	.waitForPageLoad()
			 	.selectDay("29")
			 	.clickNextButton(new FollowingSymptomsCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0017149-QS6005-STUDYQUES", protocol1);
       debugPageCC.back();
       howManyDaysYouSufferCC
	 			.waitForPageLoad()
	 			.selectDay("10")
	 			.clickNextButton(new FollowingSymptomsCC());
       
       HowManyDifferentMedicationsCC howManyDifferentMedicationsCC =  followingSymptomsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Throbbing or pulsating pain on sides of head")
    		   .clickNextButton(new HowManyDifferentMedicationsCC());
       
       MedicationsToPreventMigrainesCC medicationsToPreventMigrainesCC = howManyDifferentMedicationsCC
    		   .waitForPageLoad()
    		   .diffMedication("3")
    		   .clickNextButton(new MedicationsToPreventMigrainesCC());
       
       MedicationsToTreatYourMigraineCC medicationsToTreatYourMigraineCC = medicationsToPreventMigrainesCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Inderal, InnoPran, Hemangeol, Toprol, Lopressor, propranolol or metoprolol")
    		   .clickNextButton(new MedicationsToTreatYourMigraineCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0017154-QS6008-STUDYQUES", protocol1);
       debugPageCC.back();
       
       medicationsToPreventMigrainesCC
	   			.waitForPageLoad()
	   			.clickOnAnswers("Topamax, Qudexy, Trokendi, or topiramate", "Depacon or valproate, Depakote or divalproex", "Elavil or amitriptyline", "Sibelium or Flunarizine")
	   			.clickOnAnswers("Atacand or candesartan", "Timolol", "Botox injections (botulinum toxin) – specifically for chronic migraines")
	   			.clickNextButton(new MedicationsToTreatYourMigraineCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0017154-QS6008-STUDYQUES", protocol1);
       debugPageCC.back();
       medicationsToPreventMigrainesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Topamax, Qudexy, Trokendi, or topiramate", "Sibelium or Flunarizine")			
				.clickNextButton(new MedicationsToTreatYourMigraineCC());
       
       HowManyDaysCC howManyDaysCC = medicationsToTreatYourMigraineCC
       			.waitForPageLoad()
       			.clickOnAnswers("Alagesic", "Ascomp", "Bupap", "Dolgic", "Esgic", "Fioricet", "Fiorinal", "Margesic", "Orviban", "Phrenilin", "Promacet", "Repan")
       			.clickOnAnswers("Butalbital", "Zebutal")
       			.clickNextButton(new HowManyDaysCC());
       
       TreatYourMigraineHeadachesCC treatYourMigraineHeadachesCC = howManyDaysCC
    		   .waitForPageLoad()
    		   .selectDay("2")
    		   .clickNextButton(new TreatYourMigraineHeadachesCC());
       
       treatYourMigraineHeadachesCC
       			.waitForPageLoad()
       			.clickOnAnswers("Percocet, Oxycontin, or oxycodone", "Vicodin, Lortab, or hydrocodone", "Ultram or tramadol", "Tylenol #3, Tylenol #4, or codeine")
       			.clickNextButton(new HowManyDaysCC());
       
       Past3MonthsCC past3MonthsCC =  howManyDaysCC
	   			.waitForPageLoad()
	   			.selectDay("3")
	   			.clickNextButton(new Past3MonthsCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0017405-QS6022-STUDYQUES", protocol1);
       debugPageCC.back();
       howManyDaysCC
				.waitForPageLoad()
				.selectDay("2")
				.clickNextButton(new Past3MonthsCC());
       
       AbilityToAttendSchoolOrWorkCC abilityToAttendSchoolOrWorkCC = past3MonthsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Attend school or work - including completing assignments", "Perform regular household chores such as cleaning, doing yardwork or running errands")
    		   .clickNextButton(new AbilityToAttendSchoolOrWorkCC());
       
       PerformHouseholdChoresCC performHouseholdChoresCC = abilityToAttendSchoolOrWorkCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("You have missed school or work due to migraines")
    		   .clickNextButton(new PerformHouseholdChoresCC());
       
       HowMuchOfImpactCC howMuchOfImpactCC = performHouseholdChoresCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("You are able to perform your household chores such as cleaning and running errands, but you are significantly less productive due to your migraines")
    		   .clickNextButton(new HowMuchOfImpactCC());
       
       ExperiencingMigraineRightNowCC experiencingMigraineRightNowCC = howMuchOfImpactCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Moderate impact")
    		   .clickNextButton(new ExperiencingMigraineRightNowCC());
       
       MostRecentMigraineEndCC mostRecentMigraineEndCC = experiencingMigraineRightNowCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new MostRecentMigraineEndCC());
       
       TransitionStatementCC transitionStatementCC = mostRecentMigraineEndCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("2 to 3 days ago")
    		   .clickNextButton(new TransitionStatementCC());
       
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
    		   .waitForPageLoad(studyName1)
    	        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
       
       WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
     		   .waitForPageLoad()
     		   .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Alzheimer's disease", "Anemia (low red blood cell count)", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
     		   .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, seasonal allergy, chronic cough)")
     		   .clickOnAnswers("Diabetes (type 1 or type 2)", "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)", "Eating disorders (anorexia, bulimia, binge eating disorder)", "Headaches (migraine, cluster, tension)")
     		   .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids", "Kidney disease")
     		   .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)")
     		   .clickOnAnswers("Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis, acne, cellulite, actinic or solar keratosis)")
     		   .clickOnAnswers("Sleep problems (insomnia, sleep apnea, narcolepsy)", "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
     		   .clickOnAnswers("None of the above")     		   
     		   .clickNextButton(new WhatKindOfArthritisCC());       
       whatKindOfArthritisCC.back();
       
       WhichTypeOfHeadacheCC whichTypeOfHeadacheCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
		   		.waitForPageLoad()
		   		.clickOnAnswers("Headaches (migraine, cluster, tension)")
		   		.clickNextButton(new WhichTypeOfHeadacheCC());
       
       DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whichTypeOfHeadacheCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Cluster headache")
    		   .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015124-QS45-STUDYQUES", protocol1);
       debugPageCC.back();
       whichTypeOfHeadacheCC
	   		   .waitForPageLoad()
	   		   .clickOnAnswers("Cluster headache")
	   		   .clickOnAnswers("Tension headache")
	   		   .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
       
       ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Bipolar disorder")
    		   .clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();
       
       doAnyOftheFollowingAdditionalDiagnosesCC
	   			.waitForPageLoad()
	   			.clickOnAnswers("Cirrhosis")
	   			.clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();
       
       doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();

       doAnyOftheFollowingAdditionalDiagnosesCC
       			.waitForPageLoad()
       			.clickOnAnswers("Hepatitis B")
       			.clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();
       
       doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis C")
				.clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();

       doAnyOftheFollowingAdditionalDiagnosesCC
       			.waitForPageLoad()
       			.clickOnAnswers("HIV or AIDS")
       			.clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();

       doAnyOftheFollowingAdditionalDiagnosesCC
       			.waitForPageLoad()
       			.clickOnAnswers("Kidney disease requiring dialysis")
       			.clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();

       doAnyOftheFollowingAdditionalDiagnosesCC
       			.waitForPageLoad()
       			.clickOnAnswers("Schizophrenia")
       			.clickNextButton(new ApproximateHeightPageCC());
       debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
       debugPageCC.back();
       
       doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
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
		.setFirstName("Acurian")
		.setLastName("Trial")
		.setPhone("9999999999")
		.setZipCode(zipCode)		
		.clickNextButton(new SiteSelectionPageCC())
		.waitForPageLoad("a migraine study")
		.getPID()
		.clickOnAnswer(siteName)
		.clickNextButton(new QualifiedFlareMonitoringAppClose_CC())
		.waitForEmailPage()
		.provideEmail("qa.acurian@gmail.com")
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

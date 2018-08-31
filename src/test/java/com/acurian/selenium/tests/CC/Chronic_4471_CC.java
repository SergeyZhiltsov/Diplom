package com.acurian.selenium.tests.CC;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ChronicCough.ACEInhibitorsCC;
import com.acurian.selenium.pages.CC.ChronicCough.CurrentlySufferFromChronicCoughCC;
import com.acurian.selenium.pages.CC.ChronicCough.ExperienceWithYourChronicCoughCC;
import com.acurian.selenium.pages.CC.ChronicCough.FollowingConditionsCC;
import com.acurian.selenium.pages.CC.ChronicCough.HowLongYouHadChronicCoughCC;
import com.acurian.selenium.pages.CC.ChronicCough.HowManyYearsYouSmokeCC;
import com.acurian.selenium.pages.CC.ChronicCough.QuitSmokingCC;
import com.acurian.selenium.pages.CC.ChronicCough.StillHaveYourCoughCC;
import com.acurian.selenium.pages.CC.ChronicCough.SymptomsGetBetterCC;
import com.acurian.selenium.pages.CC.ChronicCough.TreatingYourChronicCoughCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.KidneyProblemsPage;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class Chronic_4471_CC extends BaseTest{
	
	@Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void chronic_4471_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1MCC";
      //  List<String> protocols = Arrays.asList("I5Q_MC_CGAW");
        String protocol1 = "MK_7264_027";
        String protocol2 = "MK_7264_030";
        String studyName = "a chronic cough study";          
        String siteName = "AUT_MCC";        
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

       LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
               .setMonth("Mar")
               .setDay("2")
               .setYear("2003")
               .clickNextButton(new LessThan18YearsOldPageCC());
       
       lessThan18YearsOldPageCC.waitForPageLoad();
       DebugPageCC debugPageCC = new DebugPageCC();       
       debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       
       ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
    		   .waitForPageLoad()
               .setYear("1980")
               .clickNextButton(new ZipCodePageCC());
       
       GenderPageCC genderPageCC = zipCodePageCC
    		.waitForPageLoad()
    		.typeZipCode("19341")
 		    .clickNextButton(new GenderPageCC());
       
       CurrentlySufferFromChronicCoughCC currentlySufferFromChronicCoughCC = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new CurrentlySufferFromChronicCoughCC());
       
       LetMeSeePageCC letMeSeePageCC = currentlySufferFromChronicCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new LetMeSeePageCC());
    	letMeSeePageCC.waitForPageLoadNew();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017638-QS6202-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       
       HowLongYouHadChronicCoughCC howLongYouHadChronicCoughCC = currentlySufferFromChronicCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new HowLongYouHadChronicCoughCC());
       
       TreatingYourChronicCoughCC treatingYourChronicCoughCC = howLongYouHadChronicCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Less than 6 months")
    		   .clickNextButton(new TreatingYourChronicCoughCC())
    		   .waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017639-QS6203-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       howLongYouHadChronicCoughCC
	   			.waitForPageLoad()
	   			.clickOnAnswer("6 to 11 months")
	   			.clickNextButton(new TreatingYourChronicCoughCC())
	   			.waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017639-QS6203-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       howLongYouHadChronicCoughCC
       			.waitForPageLoad()
       			.clickOnAnswer("1 year or longer")
       			.clickNextButton(new TreatingYourChronicCoughCC());       
      
       SmokedCigarettesPageCC smokedCigarettesPageCC = treatingYourChronicCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("(QS6217_C)") //No, have not treated
    		   .clickNextButton(new SmokedCigarettesPageCC())
    		   .waitForPageLoadNew();
       smokedCigarettesPageCC.back();
       
       StillHaveYourCoughCC stillHaveYourCoughCC = treatingYourChronicCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("(QS6217_B)", "(QS6217_A)")    //A. Yes, with prescription and B. Yes, with over the counter
    		   .clickNextButton(new StillHaveYourCoughCC());
       
       stillHaveYourCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No")
    		   .clickNextButton(new SmokedCigarettesPageCC());
       
       HowManyYearsYouSmokeCC howManyYearsYouSmokeCC = smokedCigarettesPageCC
    		   .waitForPageLoadNew()
    		   .clickOnAnswer("Yes, I currently smoke")
    		   .clickNextButton(new HowManyYearsYouSmokeCC())
    		   .waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017025-QS6206-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       
       QuitSmokingCC quitSmokingCC = smokedCigarettesPageCC
    		   .waitForPageLoadNew()
    		   .clickOnAnswer("I used to smoke, but have since quit")
    		   .clickNextButton(new QuitSmokingCC());
       
       quitSmokingCC
       			.waitForPageLoad()
       			.clickOnAnswer("I quit smoking within the past year")
       			.clickNextButton(new HowManyYearsYouSmokeCC())
       			.waitForPageLoad1();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017651-QS6207-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       quitSmokingCC
			.waitForPageLoad()
			.clickOnAnswer("I quit smoking more than a year ago")
			.clickNextButton(new HowManyYearsYouSmokeCC());
       
       FollowingConditionsCC followingConditionsCC = howManyYearsYouSmokeCC
    		   .waitForPageLoad1()
    		   .enterYears("20")
    		   .enterCigrettes("21")
    		   .clickNextButton(new FollowingConditionsCC())
    		   .waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017642-QS6209-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       howManyYearsYouSmokeCC
	   			.waitForPageLoad1()	   			
	   			.enterCigrettes("10")
	   			.clickNextButton(new FollowingConditionsCC());
       
       ACEInhibitorsCC aCEInhibitorsCC = followingConditionsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Post-Nasal Drip (Upper Airway Cough Syndrome)", "Lung Cancer", "Tuberculosis (TB) (Agent Note: too-ber-cue-LOW-sis)")
    		   .clickNextButton(new ACEInhibitorsCC())
    		   .waitForPageLoad();
       aCEInhibitorsCC.back();
       followingConditionsCC
	   			.waitForPageLoad()
	   			.clickOnAnswers("None of the above")
	   			.clickNextButton(new ACEInhibitorsCC());
       
       ExperienceWithYourChronicCoughCC experienceWithYourChronicCoughCC = aCEInhibitorsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Benazepril (Ben-az-uh-pril) - Brand name Lotensin (Low-ten-sin)", "Captopril (Cap-toe-pril) - Brand name Capoten (Cap-oh-ten)", "Cilazapril (Sil-az-uh-pril) - Brand name Inhibace (In-hib-ace)")
    		   .clickOnAnswers("Enalapril (Ee-nal-uh-pril) - Brand names Vasotec, Renitec, Berlipril, Enap, Enapren (Vay-zo-tech / Ren-eh-tech / Bur-lip-rell / Ee-Nap / Ee-nap-ren)", "Quinapril (Kwin-uh-pril) - Brand name Accupril (Ack-you-pril)")
    		   .clickOnAnswers("Fosinopril (Foe-sin-uh-pril) - Brand names Fositen, Monopril (Foe-sit-en / Mono-pril)", "Imidapril (Im-eh-di-prell) - Brand name Tanatril (Tan-eh-tril)")
    		   .clickNextButton(new ExperienceWithYourChronicCoughCC())
    		   .waitForPageLoad();
       debugPageCC.checkProtocolsContainsForQNumber("Q0017644-QS6211-STUDYQUES", protocol1, protocol2);
       debugPageCC.back();
       aCEInhibitorsCC
	   			.waitForPageLoad()
	   			.clickOnAnswers("None of the above")	   			
	   			.clickNextButton(new ExperienceWithYourChronicCoughCC());
       
       SymptomsGetBetterCC symptomsGetBetterCC = experienceWithYourChronicCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("A runny or stuffy nose", "A feeling of liquid running down the back of your throat (postnasal drip)", "Frequent throat clearing and sore throat", "Hoarseness")
    		   .clickOnAnswers("Wheezing and shortness of breath", "Heartburn or a sour taste in your mouth", "Coughing up blood")
    		   .clickNextButton(new SymptomsGetBetterCC())
    		   .waitForPageLoad();
       symptomsGetBetterCC.back();
       TransitionStatementCC transitionStatementCC = experienceWithYourChronicCoughCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("None of the above")	  
    		   .clickNextButton(new TransitionStatementCC())
    		   .waitForPageLoadMCC("chronic cough");
       transitionStatementCC.back();
       
       experienceWithYourChronicCoughCC
	   			.waitForPageLoad()
	   			.clickOnAnswers("A runny or stuffy nose")	   			
	   			.clickNextButton(new SymptomsGetBetterCC());
       
       symptomsGetBetterCC
       			.waitForPageLoad()
       			.clickOnAnswers("None of the above")
       			.clickNextButton(new TransitionStatementCC());
       
       HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
    		   .waitForPageLoadMCC("chronic cough")    		   
       		   .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
       
       KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        		.waitForPageLoad()
        		.clickOnAnswers("Kidney disease")        		
        		.clickNextButton(new KidneyProblemsPage());
        
       DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        kidneyProblemsPage
        		.waitForPageLoad()
        		.clickOnAnswers("Kidney transplant")
        		.clickOnAnswers("Dialysis")
        		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        kidneyProblemsPage
				.waitForPageLoad()				
				.clickOnAnswers("Neither")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
         		.waitForPageLoad()
         		.clickOnAnswers("Cirrhosis")
         		.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
 				.waitForPageLoad()
 				.clickOnAnswers("None of the above")
 				.clickOnAnswers("Hepatitis B")
 				.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
 				.waitForPageLoad()
 				.clickOnAnswers("None of the above")
 				.clickOnAnswers("Hepatitis C")
 				.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
         		.waitForPageLoad()
         		.clickOnAnswers("None of the above")
         		.clickOnAnswers("HIV or AIDS")
         		.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
 				.waitForPageLoad()
 				.clickOnAnswers("None of the above")
 				.clickOnAnswers("Schizophrenia")
 				.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES");
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
  				.waitForPageLoad()
  				.clickOnAnswers("None of the above")
  				.clickOnAnswers("Bipolar disorder")
  				.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Cancer in the past 5 years, except skin cancer")
				.clickNextButton(new ApproximateHeightPageCC());
         approximateHeightPageCC.waitForPageLoad();
         debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
         debugPageCC.back();
         doAnyOftheFollowingAdditionalDiagnosesCC
         		.waitForPageLoad()
         		.clickOnAnswers("None of the above")         		
         		.clickNextButton(new ApproximateHeightPageCC());
         
         approximateHeightPageCC
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
				.waitForPageLoadMCC(studyName)
				.getPID()
				.clickOnAnswer(siteName)
				.clickNextButton(new HSGeneralCC())        		
				.waitForPageLoad("Chronic Cough")
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
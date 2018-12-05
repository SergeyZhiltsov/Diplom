package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC;
import com.acurian.selenium.pages.CC.Derm_4631.HaveYouEverTakenEitherAnyOfFollowingMeds_CC;
import com.acurian.selenium.pages.CC.Derm_4631.HowLongHaveYouBeenSufferingFromEczema_CC;
import com.acurian.selenium.pages.CC.Derm_4631.IfYouUseYourHandToCoverAllOfTheEczema_CC;
import com.acurian.selenium.pages.CC.Derm_4631.OverallHowWellDidTopicalMedicationYouTried_CC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class DERM_4814_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class,enabled = true)
    @TestCaseId("Kiniksa Atopic Dermatitis")
    @Description("DERM_4814_CC_Test")
    
    public void DERM_4814_CC_Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1KAD";
        String protocol1 = "INCB 18424_303"; 
        String protocol2 = "INCB 18424_304";
        String studyName =  "eczema, or atopic dermatitis";
        String siteName = "AUT_AD4814_site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");//was in prod

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());
        

     //------------dateOfBirthPageCC----------------
        dateOfBirthPageCC.threadSleep(2000);
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleKAD4631, "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());
        
        
      //------------PII Question------------
        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoad1()
                .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());
        
        
      //-----------GenderPageCC-------------
        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        
     //------------Q2:  hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC----
        NonQRtransitionPageCC nonQRtransitionPageCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0009397-QS5802-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_CC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());

        
      //----------Q3:  HowLongHaveYouBeenSufferingFromEczema_CC---------------
        IfYouUseYourHandToCoverAllOfTheEczema_CC ifYouUseYourHandToCoverAllOfTheEczema_CC = howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_CC());
        ifYouUseYourHandToCoverAllOfTheEczema_CC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("3 to less than 6 months")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_CC());
        ifYouUseYourHandToCoverAllOfTheEczema_CC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("2 years or more")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_CC());
        
        
      //------------Q4:  IfYouUseYourHandToCoverAllOfTheEczema_CC -------------------  
        HaveYouEverTreatedYourEczema_CC haveYouEverTreatedYourEczema_CC = ifYouUseYourHandToCoverAllOfTheEczema_CC
        		.waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());
        haveYouEverTreatedYourEczema_CC.waitForPageLoad();
        		debugPageCC.checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1,protocol2);
        		debugPageCC.back();
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());
        haveYouEverTreatedYourEczema_CC.waitForPageLoad();
        		debugPageCC.checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1,protocol2);
        		debugPageCC.back();
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("10")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());

     
     //-----------------Q17: HaveYouEverTreatedYourEczema_CC -------------
        haveYouEverTreatedYourEczema_CC
        		.waitForPageLoad();
		//-----------select NO to skip to Q19, otherwise goto Q18
        WhichofthefollowingMedicationsTherapies_CC whichofthefollowingMedicationsTherapies_CC = haveYouEverTreatedYourEczema_CC
        		.clickOnAnswer("No")
        		.clickNextButton(new WhichofthefollowingMedicationsTherapies_CC())
        		.waitForPageLoad();			
		whichofthefollowingMedicationsTherapies_CC
				.back();
		haveYouEverTreatedYourEczema_CC
				.waitForPageLoad();
		OverallHowWellDidTopicalMedicationYouTried_CC overallHowWellDidTopicalMedicationYouTried_CC = haveYouEverTreatedYourEczema_CC
				.clickOnAnswer("Yes, but more than 1 year ago")
		.clickOnAnswer("Yes, within the past year")    //final selection
		.clickNextButton(new OverallHowWellDidTopicalMedicationYouTried_CC());


//--------------Q18- OverallHowWellDidTopicalMedicationYouTried_CC ----------
overallHowWellDidTopicalMedicationYouTried_CC
		.waitForPageLoad()
		.clickOnAnswer("My symptoms did not change")
		.clickOnAnswer("My symptoms got a little bit better")
		.clickOnAnswer("My symptoms got a lot better")
		.clickOnAnswer("My symptoms went away completely")  //final selection
		.clickNextButton(new WhichofthefollowingMedicationsTherapies_CC());


//--------------Q19- whichofthefollowingMedicationsTherapies_CC ----------
whichofthefollowingMedicationsTherapies_CC
			.waitForPageLoad();
DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_CC = whichofthefollowingMedicationsTherapies_CC
			.clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)")
			.clickOnAnswers("CellCept or Myfortic, also known as mycophenolate (Agent Note: my-co-FEN-o-late)")
			.clickOnAnswers("Dupixent, also known as dupilumab (Agent Note: du-PIX-ent, du-PILL-you-mab)")
			.clickOnAnswers("Fasenra, also known as benralizumab (Agent Note: fa-SEN-ra, BEN-ra-LIZ-oo-mab)")
			.clickOnAnswers("Neoral, Sandimmune, or Gengraf, also known as cyclosporine (Agent Note: NEE-oh-ral, GEN-graf, cy-clo-SPOR-in)")
			.clickOnAnswers("Nucala, also known as mepolizumab (Agent Note: new-CA-la, MEP-oh-LIZ-oo-mab)")
			.clickOnAnswers("Methotrexate - Brand names: Otrexup, Rasuvo, Trexall (Agent Note: oh-TREX-up, ruh-SOO-vo, TREX-all)")
			.clickOnAnswers("Otezla, also known as apremilast (Agent Note: oh-TEZ-la, a-PRE-mi-last)")
			.clickOnAnswers("Prednisone - Brand names: Deltasone, Prednisone Intensol, Rayos (Agent Note: PRED-nis-own)")
			.clickOnAnswers("Phototherapy, Ultraviolet, or UV light")
			.clickNextButton(new DidYouReceiveAnyTherapiesPastYear_CC())
			.waitForPageLoad();
			debugPageCC.checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", protocol1,protocol2);
			debugPageCC.back();
whichofthefollowingMedicationsTherapies_CC
			.waitForPageLoad();
             AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC = whichofthefollowingMedicationsTherapies_CC
			.clickOnAnswers("None of the above")
			.clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());      
        
        
        
     //-----------------Q22:  AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC--
        //TransitionStatementCC transitionStatementCC = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
		HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)", "Benlysta (Agent Note: ben-LIST-uh)", "Cimzia (Agent Note: SIM-zee-uh)", "Cosentyx (Agent Note: co-SEN-tix)")
                .clickOnAnswers("Enbrel (Agent Note: EN-brel)", "Entyvio (Agent Note: en-TIV-ee-oh)", "Humira (Agent Note: hue-MAIR-uh)", "Kineret (Agent Note: KIN-er-et)", "Orencia (Agent Note: oh-REN-see-uh)")
                .clickOnAnswers("Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)", "Raptiva (Agent Note: rap-TEE-vuh)", "Remicade (Agent Note: REM-ih-cade)", "Rituxan (Agent Note: rih-TUX-an)")
                .clickOnAnswers("Simponi (Agent Note: SIM-po-nee)", "Stelara (Agent Note: ste-LAHR-uh)", "Taltz (Agent Note: TALTS)", "Tysabri (Agent Note: tie-SAB-ree)")
                .clickNextButton(new HaveYouEverTakenEitherAnyOfFollowingMeds_CC())
        		.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverTakenEitherAnyOfFollowingMeds_CC());
        
        
		//------------Q23- HaveYouEverTakenEitherAnyOfFollowingMeds ----------------
        haveYouEverTakenEitherAnyOfFollowingMeds_CC
					.waitForPageLoad();
        			TransitionStatementCC transitionStatementCC = haveYouEverTakenEitherAnyOfFollowingMeds_CC
					.clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)", "Olumiant (Agent Note: oh-LOO-me-ant)","Xeljanz (Agent Note: ZEL-jans)")
					.clickNextButton(new TransitionStatementCC())
					.waitForPageLoadWithCurvesKAD(studyName);
			        debugPageCC.checkProtocolsContainsForQNumber("Q0017453-QS5830-STUDYQUES", protocol1,protocol2);
			        debugPageCC.back();
	    haveYouEverTakenEitherAnyOfFollowingMeds_CC
					.waitForPageLoad()
					.clickOnAnswers("None of the above")
					.clickNextButton(new TransitionStatementCC());        
        

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurvesKAD(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickOnAnswers("Diabetes (type 1 or type 2)", "Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",  "Headaches (migraine, cluster, tension)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids", "Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis)")
                .clickOnAnswers( "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhatKindOfArthritisCC());
        whatKindOfArthritisCC.back();
        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancer());

        
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancer
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        whenDiagnosedWithCancer.back();
        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Cancer")
                .clickNextButton(new KidneyProblemsPage());
        

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1,protocol2);
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
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1,protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1,protocol2);
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
                .clickNextButton(new ApproximateHeightPageCC());

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("an eczema (atopic dermatitis) study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
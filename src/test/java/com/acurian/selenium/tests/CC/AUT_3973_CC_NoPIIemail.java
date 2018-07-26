package com.acurian.selenium.tests.CC;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.DoYouExperienceDPN_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.WhereDoYouExperienceDiabeticNervePain_CC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.ApartFromMetforminPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.CombinationWithEachOtherPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiabeticNephropathyPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.FollowingLiverRelatedConditionCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.FollowingToLoseWeightPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.ForYourKidneysPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.InjectableMedicationsForYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.InsulinForYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.LastTimeYouTookPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.MetforminMedicationsPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.NoOfAlcoholicDrinksCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionsHumalogPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.WhenDiagnosedWithCancer;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.HouseholdHavePageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC;
import com.acurian.selenium.pages.CC.shared.HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.ProcedureForWeightLossPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.StatinMedicationsOnPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WeightLossSurgeryPageCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.pages.CC.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.CC.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.CC.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LiverRelatedConditionOLS;
import com.acurian.selenium.utils.DataProviderPool;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AUT_3973_CC_NoPIIemail extends BaseTest{
	
	
    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = true)  
    @TestCaseId("00004")
    @Description("Diabetes_4356A_Synexus for CC")
    public void Akc_4691_CC_NoPIIemail(final String username, final String password) {
        String phoneNumber = "AUTAMS1ROC";
        String AUTISM = "WN39434";        
        String studyName = "Autism";
        String siteName = "AUT_3973";             
        String zipCode = "08204";
        
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
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());
        
        
        //--------------DOB Question------------
        dateOfBirthPageCC
                .waitForPageLoadAKC();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionTextAKC(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedAkc_4691, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());
        

        //--------------ZIP_CODE Question------------
        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());
        

        //--------------GENDER Question------------
        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());
        

        //--------------Q2: Have you been diagnosed with any type of diabetes?------------
        diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageCC.getTitleText(), diagnosedAnyTypeOfDiabetesPageCC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC
                .checkProtocolsContainsForQNumber("Q0005996-QS4602-STUDYQUES", AUTISM)
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        
        
        //--------------Q3: What kind of diabetes do you have?------------
        whatKindOfDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageCC.getTitleText(), whatKindOfDiabetesPageCC.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", AUTISM)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", AUTISM)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", AUTISM)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad();
        		UseDietAndExercisePage useDietAndExercisePage = whatKindOfDiabetesPageCC
                .clickOnAnswer("Unsure")
                .clickNextButton(new UseDietAndExercisePage());
        useDietAndExercisePage
        		.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", AUTISM)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC =  whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());
        

        //--------------Q4: How long ago were you diagnosed with type 2 diabetes?------------
        withType2DiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageCC.getTitleText(),withType2DiabetesPageCC.titleExpected, "Title is diff");
        withType2DiabetesPageCC
        		.clickOnAnswer("3 - 6 months ago")
                .clickNextButton(useDietAndExercisePage);
        
        
      //--------------Q5: Do you currently use diet and exercise as a way to help treat your diabetes? -----------
        useDietAndExercisePage
                .waitForPageLoad();
        Assert.assertEquals(useDietAndExercisePage.getTitleText(),useDietAndExercisePage.titleExpected, "Title is diff");
        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage  = useDietAndExercisePage
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage());
       
        
        
        //--------------Q6: Do you currently use metformin or insulin or any other medication prescribed by your doctor to treat your diabetes? -----------        
        //---------If selected "Metformin" skip to Q8,  If selected "Medication other than Metformin or Insulin" skip to Q9, 
        //---------If selected "Insulin" skip to Q10, 
        //---------If selected ""Do not use any prescribed medication to treat diabetes"" goto Q7 and DQ 4691---------
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();
        Assert.assertEquals(currentlyUseMetforminOrInsulinPage.getTitleText(),currentlyUseMetforminOrInsulinPage.titleExpected, "Title is diff");
        ApartFromMetforminPageCC apartFromMetforminPageCC = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Medication other than Metformin or Insulin")
                .clickNextButton(new ApartFromMetforminPageCC());
        apartFromMetforminPageCC
        		.waitForPageLoad()
                .back();
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();  
        InsulinForYourDiabetesPageCC insulinForYourDiabetesPageCC = currentlyUseMetforminOrInsulinPage
        		.clickOnAnswers("Medication other than Metformin or Insulin") //Click to Uncheck this option
        		.clickOnAnswers("Insulin")
                .clickNextButton(new InsulinForYourDiabetesPageCC());
        		insulinForYourDiabetesPageCC.waitForPageLoad()
                .back();                
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();  
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());
        		anyPrescribedMedicationPage.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016801-QS4626-STUDYQUES", AUTISM)//***************
                .back();
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();	
                MetforminMedicationsPageCC metforminMedicationsPageCC = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Metformin")
                .clickNextButton(new MetforminMedicationsPageCC());
        
        
/*        //----------Q7: Have you taken any prescribed medication for your diabetes within the past 3 months? -----------    
        anyPrescribedMedicationPage
        		.waitForPageLoad();
        Assert.assertEquals(anyPrescribedMedicationPage.getTitleText(),anyPrescribedMedicationPage.titleExpected, "Title is diff");
        NoOfAlcoholicDrinkCC noOfAlcoholicDrinkCC = anyPrescribedMedicationPage
        //---------if selected "NO" Skip to Q15---
        		.clickOnAnswer("No")
                .clickNextButton(new NoOfAlcoholicDrinkCC());
        noOfAlcoholicDrinkCC.waitForPageLoad()
        		.back();
        anyPrescribedMedicationPage
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new MetforminMedicationsPageCC());*/
        
        
        
        //----------Q8: Do you currently take any of the following oral (taken by mouth) metformin medications?
        metforminMedicationsPageCC
        		.waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageCC.getTitleText(),metforminMedicationsPageCC.titleExpected, "Title is diff");
        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC	= metforminMedicationsPageCC
        		.clickOnAnswers("Actoplus Met (metformin and pioglitazone)")
				.clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());
        injectableMedicationsForYourDiabetesPageCC
        		.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006223-QS4607-STUDYQUES", AUTISM)
                .back();
        metforminMedicationsPageCC
				.waitForPageLoad()
				.clickOnAnswers("Avandamet (metformin and rosiglitazone)")
				.clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());
        injectableMedicationsForYourDiabetesPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0006223-QS4607-STUDYQUES", AUTISM)
				.back();
        metforminMedicationsPageCC
				.waitForPageLoad()
				.clickOnAnswers("Fortamet (metformin)",
								"Glucophage (metformin)",
								"Glucovance (metformin and glyburide)",
								"Glumetza (metformin)",
								"Invokamet (metformin and canagliflozin)",
								"Janumet (metformin and sitagliptin)" ,
								"Jentadueto (metformin and linagliptin)",
								"Kazano (metformin and alogliptin)",
								"Kombiglyze (metformin and saxagliptin)",
								"Metformin and glipizide",
								"PrandiMet (metformin and repaglinide)",
								"Synjardy (metformin and empagliflozin)",
								"Xigduo (metformin and dapagliflozin)",
								"None of the above")
				.clickNextButton(new InjectableMedicationsForYourDiabetesPageCC())
        		.waitForPageLoad()
        		.back();
        metforminMedicationsPageCC
				.waitForPageLoad()
				.back();
        currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.clickOnAnswers("Insulin","Medication other than Metformin or Insulin")
        		.clickNextButton(new MetforminMedicationsPageCC());
        metforminMedicationsPageCC
        		.waitForPageLoad()
				.clickNextButton(new ApartFromMetforminPageCC());
        		
        
        
        //----------Q9: Apart from metformin, what other oral (taken by mouth) medications do you currently take for your diabetes?  ----------
        apartFromMetforminPageCC
        		.waitForPageLoad();
        Assert.assertEquals(apartFromMetforminPageCC.getTitleText(),apartFromMetforminPageCC.titleExpected, "Title is diff");       
        apartFromMetforminPageCC
        		.clickOnAnswers("Actos (pioglitazone)",
        				"Avandia (rosiglitazone)",
        				"Duetact (pioglitazone and glimepiride)",
        				"Oseni (alogliptin and pioglitazone)")
        		.clickNextButton(new InsulinForYourDiabetesPageCC());
        insulinForYourDiabetesPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0007024-QS4608-STUDYQUES", AUTISM)
        		.back();
        apartFromMetforminPageCC
        		.waitForPageLoad()
				.clickOnAnswers("None of the above")
        		.clickOnAnswers("Tradjenta (linagliptin)")
				.threadSleep(3000);
        apartFromMetforminPageCC
				.clickNextButton(new InsulinForYourDiabetesPageCC());
        
        
        //--------Q10:  Do you currently take any of the following types of insulin for your diabetes?--
        insulinForYourDiabetesPageCC
        		.waitForPageLoad();
                Assert.assertEquals(insulinForYourDiabetesPageCC.getTitleText(),insulinForYourDiabetesPageCC.titleExpected, "Title is diff");
        insulinForYourDiabetesPageCC
        		.waitForPageLoad()
                .clickOnAnswers("Afrezza, which is inhaled insulin",
                				"Apidra (insulin glulisine)",
                				"Humalog",
                				"Humulin",
                				"Lantus or Toujeo (insulin glargine)", 
                				"Levemir (insulin detemir)", 
                				"Novolin", 
                				"Novolog")
                .clickNextButton(new SubquestionsHumalogPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0007026-QS4609-STUDYQUES", AUTISM)
                .back();
        insulinForYourDiabetesPageCC
        		.waitForPageLoad()
				.clickOnAnswers("I use insulin, but I am not sure what kind")
				.clickNextButton(new InjectableMedicationsForYourDiabetesPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0007026-QS4609-STUDYQUES", AUTISM)
                .back();
        insulinForYourDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());
        
        		
        		
        //-------Q12:  Do you currently take any of the following injectable medications for your diabetes?  --------
        injectableMedicationsForYourDiabetesPageCC
        		.waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageCC.getTitleText(),injectableMedicationsForYourDiabetesPageCC.titleExpected, "Title is diff");
        CombinationWithEachOtherPageCC combinationWithEachOtherPageCC = injectableMedicationsForYourDiabetesPageCC
        		.clickOnAnswers("Adlyxin (lixisenatide)",
        				"Bydureon or Byetta (exenatide)",
        				"Tanzeum (albiglutide)",
        				"Trulicity (dulaglutide)",
        				"Saxenda or Victoza (liraglutide)",
        				"SymlinPen (pramlintide)",
        				"Another injectable medication not listed above")
        		.clickNextButton(new CombinationWithEachOtherPageCC());
        combinationWithEachOtherPageCC
        		.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006227-QS4611-STUDYQUES", AUTISM)
                .back();
        injectableMedicationsForYourDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new CombinationWithEachOtherPageCC());
        
        
        		
        //-------Q13:  Overall, how long have you been taking your current diabetes medication(s), either by themselves, or in combination with each other?  --------
        combinationWithEachOtherPageCC
        		.waitForPageLoad();
        Assert.assertEquals(combinationWithEachOtherPageCC.getTitleText(),combinationWithEachOtherPageCC.titleExpected, "Title is diff");
        NoOfAlcoholicDrinksCC noOfAlcoholicDrinkCC = combinationWithEachOtherPageCC
        		.clickOnAnswer("1 month or less")
        		.clickNextButton(new NoOfAlcoholicDrinksCC());
        
        
        //-------Q15:  About how many alcoholic drinks do you have in a typical week? --------
        noOfAlcoholicDrinkCC
        		.waitForPageLoad();
        Assert.assertEquals(noOfAlcoholicDrinkCC.getTitleText(),noOfAlcoholicDrinkCC.titleExpected, "Title is diff");
        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinkCC
        		.enterNoOfDrinks("6")
        		.clickNextButton(new FollowingLiverRelatedConditionCC());
        
        
        
        //-------Q16:  Has a healthcare professional ever diagnosed you with any of the following liver-related conditions?--------
        followingLiverRelatedConditionCC
				.waitForPageLoad();
        Assert.assertEquals(followingLiverRelatedConditionCC.getTitleText(),followingLiverRelatedConditionCC.titleExpected, "Title is diff");
        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = followingLiverRelatedConditionCC
        		.clickOnAnswers("Alcoholic liver disease",
        						"Autoimmune hepatitis, which is not the same as hepatitis caused by a virus",
        						"Hemochromatosis or iron overload (Agent Note: he-mo-chrome-uh-TOE-sus)",
        						"Liver cancer or hepatocellular carcinoma (Agent Note: hih-pat-oh-CELL-u-lar car-sih-NO-ma)",
        						"Primary sclerosing cholangitis or primary biliary cirrhosis (Agent Note: scler-OH-sing, ko-lanj-EYE-tis, BILL-ee-air-ee)",
        						"Wilson's disease")
        		.clickNextButton(new FollowingToLoseWeightPageCC());
        followingToLoseWeightPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
		        .checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", AUTISM)
		        .back();
        followingLiverRelatedConditionCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new FollowingToLoseWeightPageCC());

        
        
        //-------Q17:  Are you currently using any of the following to lose weight?--------
        followingToLoseWeightPageCC
				.waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageCC.getTitleText(),followingToLoseWeightPageCC.titleExpected, "Title is diff");
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
        		.clickOnAnswers("Prescription weight loss medication", 
        						"Over-the-counter weight loss medication or supplements",
        						"Weight loss program such as Weight Watchers or Jenny Craig",
        						"No")
        		.clickNextButton(new WeightLossSurgeryPageCC());
        

        
        //-------Q18:  Have you ever had any of the following types of bariatric or weight loss surgery?--------
        weightLossSurgeryPageCC
				.waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageCC.getTitleText(),weightLossSurgeryPageCC.titleExpected, "Title is diff");
        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new PoundsOrMorePageCC())
        		.waitForPageLoad();
        		poundsOrMorePageCC.back();
        weightLossSurgeryPageCC
				.waitForPageLoad();
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
				.clickOnAnswers("Gastric bypass",
								"Gastric sleeve or sleeve gastrectomy",
								"Duodenal switch",
								"Lap band or gastric banding",
								"Gastric balloon")
				.clickNextButton(new ProcedureForWeightLossPageCC());
				
		
		
        //-------Q19:  When was the last time that you had a surgery or medical procedure for weight loss?--------
        procedureForWeightLossPageCC
				.waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageCC.getTitleText(),procedureForWeightLossPageCC.titleExpected, "Title is diff");
        PoundsOrMorePageCC PoundsOrMorePageCC = procedureForWeightLossPageCC
        		.clickOnAnswer("Less than 3 months ago")
        		.clickNextButton(new PoundsOrMorePageCC());
        PoundsOrMorePageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
		        .checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES", AUTISM)
		        .back();
        procedureForWeightLossPageCC
				.waitForPageLoad()
				.clickOnAnswer("3 - 6 months ago")
				.clickNextButton(new PoundsOrMorePageCC());
        
        
      //-------Q20:  Have you lost or gained 15 pounds or more in the past 3 months?--------
        poundsOrMorePageCC
                .waitForPageLoad();
        Assert.assertEquals(poundsOrMorePageCC.getTitleText(),poundsOrMorePageCC.titleExpected, "Title is diff");
        poundsOrMorePageCC
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouExperienceDPN_CC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0013992-QS4617-STUDYQUES", AUTISM)
                .back();
        poundsOrMorePageCC
        		.waitForPageLoad();
        		DoYouExperienceDPN_CC doYouExperienceDPN_CC = poundsOrMorePageCC
        		.clickOnAnswer("No")
        		.clickNextButton(new DoYouExperienceDPN_CC());        
                
                         
		// ---------------------------------------doYouExperienceDPN_CC-----------------------------------------------------
		doYouExperienceDPN_CC
				.waitForPageLoad();
				WhereDoYouExperienceDiabeticNervePain_CC whereDoYouExperienceDiabeticNervePain_CC = doYouExperienceDPN_CC
				.clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
				.clickNextButton(new WhereDoYouExperienceDiabeticNervePain_CC());

		// ---------------------------------------WhereDoYouExperienceDiabeticNervePain_OLS-----------------------------------------------------
		whereDoYouExperienceDiabeticNervePain_CC
				.waitForPageLoad();
				StatinMedicationsOnPageCC statinMedicationsOnPageCC = whereDoYouExperienceDiabeticNervePain_CC
				.clickOnAnswers("None of the above").clickNextButton(new StatinMedicationsOnPageCC());


        //---------------------------------------statinMedicationsOnPageCC-----------
        statinMedicationsOnPageCC
                .waitForPageLoad();
        Assert.assertEquals(statinMedicationsOnPageCC.getTitleText(),statinMedicationsOnPageCC.titleExpected, "Title is diff");
        DiabeticNephropathyPageCC diabeticNephropathyPageCC = statinMedicationsOnPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new DiabeticNephropathyPageCC());


      //---------------------------------------diabeticNephropathyPageOLS------------------------------------------------------ 
        diabeticNephropathyPageCC
                .waitForPageLoad();
        Assert.assertEquals(diabeticNephropathyPageCC.getTitleText(),diabeticNephropathyPageCC.titleExpected, "Title is diff");
        ForYourKidneysPageCC forYourKidneysPageCC = diabeticNephropathyPageCC
                .clickOnAnswer("No")
                .clickNextButton(new ForYourKidneysPageCC());
        
        //---------------------------------------forYourKidneysPageOLS------------------------------------------------------ 
        forYourKidneysPageCC
                .waitForPageLoad();
        Assert.assertEquals(forYourKidneysPageCC.getTitleText(),forYourKidneysPageCC.titleExpected, "Title is diff");
                        
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = forYourKidneysPageCC
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        
        //--------------------------------------Have you ever experienced or been diagnosed with any of the following specific heart-related medical conditions?------------------------------------------------------ 
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverExperiencedHeartRelatedMedicalCondCC.getTitleText(),haveYouEverExperiencedHeartRelatedMedicalCondCC.titleExpected, "Title is diff");        
        HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC haveYouEverBeenDiagnosedAdditionalHeartRelatedCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
        
        
        //-------------------------HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC----------------------------------------------------- 
        haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC.getTitleText(),haveYouEverBeenDiagnosedAdditionalHeartRelatedCC.titleExpected, "Title is diff");
        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
                .clickOnAnswers("None of the above")       
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());

        //-------------------------HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC----------------------------------------------------- 
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad();
        Assert.assertEquals(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC.getTitleText(),haveYouUndergoneAnyOfFollowingHeartRelatedProcCC.titleExpected, "Title is diff");
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC())
                
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        
        
        
        //-----------------------NEW GENERAL HEALTH------------------------------------------------------
        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        		.waitForPageLoad()
        		.clickOnAnswers("Cancer")                	
        		.clickNextButton(new WhenDiagnosedWithCancer());
        
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancer
        		.waitForPageLoad()
        		.clickOnAnswer("Within the past 5 years")
        		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        
        doAnyOftheFollowingAdditionalDiagnosesCC
        		.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", AUTISM)
                .back();
        whenDiagnosedWithCancer
				.waitForPageLoad()
				.clickOnAnswer("Diagnosed with skin cancer only")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        
        HormonalBirthControlCC hormonalBirthControlCC = doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("Cirrhosis")
				.clickNextButton(new HormonalBirthControlCC());
        hormonalBirthControlCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", AUTISM)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickOnAnswers("Cirrhosis")
				.clickNextButton(hormonalBirthControlCC)
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", AUTISM)
				.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Hepatitis B")
				.clickNextButton(hormonalBirthControlCC)        
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", AUTISM)
        		.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Hepatitis C")
        		.clickNextButton( hormonalBirthControlCC)       
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", AUTISM)
        		.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("HIV or AIDS")
				.clickNextButton( hormonalBirthControlCC)       
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", AUTISM)
				.back();     
        doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
        		.clickNextButton(new HormonalBirthControlCC())
        		.waitForPageLoad()
        		.clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageCC())                
                
        		//----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "6", "170")
                .clickNextButton(new LetMeSeePageCC())                
                
        		//----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                
                //----------PEDIATRIC HEALTH Questions----------
                .clickNextButton(new HouseholdHavePageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                
        		//----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Auto", "Test", "", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                
        		//----------SITE Selection Page--------------------
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                
        		//----------Special Type 2 Diabetes HELLO SIGN Page (email at PII)--------------------
                .waitForPageLoadT2DM()
                .typeEmail_T2Dia("qa.acurian@gmail.com")
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
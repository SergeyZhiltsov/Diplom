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
import com.acurian.selenium.pages.CC.Diabetes_4356A.TreatingYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
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
import com.acurian.selenium.utils.DataProviderPool;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AKC_4691_CC extends BaseTest{
	
	
    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)  
    @TestCaseId("00004")
    @Description("Diabetes_4356A_Synexus for CC")
    public void akc4691Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1AKC";
   //     List<String> protocols = Arrays.asList("ISIS 703802_CS2");
        String protocol1 = "ISIS 703802_CS2";        
   //     String studyName = "a Diabetes"; //Diabetes study
   //     String studyName1 = "Diabetes";
        String siteName = "AUT_4691";             
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

        dateOfBirthPageCC
                .waitForPageLoadAKC();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionTextAKC(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedAkc_4691, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

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
                //.checkProtocolsContainsForQNumber("Q0005996-QS4602-STUDYQUES", protocol1)
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

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
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", protocol1)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", protocol1)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", protocol1)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad();
                TreatingYourDiabetesPageCC treatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageCC());
        treatingYourDiabetesPageCC
        		.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", protocol1)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC =  whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageCC.getTitleText(),withType2DiabetesPageCC.titleExpected, "Title is diff");
        withType2DiabetesPageCC.clickOnAnswer("Within the past 2 months")
                .clickNextButton(new TreatingYourDiabetesPageCC());
        treatingYourDiabetesPageCC
                .waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol1)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(treatingYourDiabetesPageCC)
                .waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol4)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(treatingYourDiabetesPageCC)
                .waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol4)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(treatingYourDiabetesPageCC);

        treatingYourDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(treatingYourDiabetesPageCC.getTitleText(),treatingYourDiabetesPageCC.titleExpected, "Title is diff");
        FollowingToLoseWeightPageCC followingToLoseWeightPageCC  = treatingYourDiabetesPageCC
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new FollowingToLoseWeightPageCC());
        followingToLoseWeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)//for protocol check I manually copied text from the question debug because the issue with debug questions
                .checkProtocolsEqualsForQNumber("Q0006007-QS4605-STUDYQUES", protocol1)
                .back();
        treatingYourDiabetesPageCC
                .waitForPageLoad()                
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006007-QS4605-STUDYQUES", protocol1)
                .back();
        LastTimeYouTookPageCC lastTimeYouTookPageCC = treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageCC());

        //---------------------------------------lastTimeYouTookPageOLS------------------------------------------------------ 
        lastTimeYouTookPageCC
                .waitForPageLoad();
        Assert.assertEquals(lastTimeYouTookPageCC.getTitleText(),lastTimeYouTookPageCC.titleExpected, "Title is diff");
        
        lastTimeYouTookPageCC
				.clickOnAnswer("2 - 3 months ago")
                .clickNextButton(new FollowingToLoseWeightPageCC());
        followingToLoseWeightPageCC
        		.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0013988-QS4606-STUDYQUES", protocol1)
                .back();
        
        lastTimeYouTookPageCC
				.clickOnAnswer("4 - 5 months ago")
				.clickNextButton(new FollowingToLoseWeightPageCC());
        followingToLoseWeightPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0013988-QS4606-STUDYQUES", protocol1)
				.back();

        lastTimeYouTookPageCC
        		.clickOnAnswer("6 months ago or longer")
        		.clickNextButton(new FollowingToLoseWeightPageCC());
        followingToLoseWeightPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0013988-QS4606-STUDYQUES", protocol1)
        		.back();        
        
         MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
        		 .clickOnAnswer("Currently taking / have taken within the past month")
        		 .clickNextButton(new MetforminMedicationsPageCC());
       
        metforminMedicationsPageCC
                .waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageCC.getTitleText(),metforminMedicationsPageCC.titleExpected, "Title is diff");
        ApartFromMetforminPageCC apartFromMetforminPageCC = metforminMedicationsPageCC        		
                .clickOnAnswers("Avandamet (metformin and rosiglitazone)")
                .clickNextButton(new ApartFromMetforminPageCC());
   //     apartFromMetforminPageCC.threadSleep(2000);
   //     apartFromMetforminPageCC.back();
        apartFromMetforminPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006223-QS4607-STUDYQUES", protocol1)
                .back();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Actoplus Met (metformin and pioglitazone)")
                .clickNextButton(apartFromMetforminPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006223-QS4607-STUDYQUES", protocol1)
                .back();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageCC);

        apartFromMetforminPageCC
                .waitForPageLoad();
        Assert.assertEquals(apartFromMetforminPageCC.getTitleText(),apartFromMetforminPageCC.titleExpected, "Title is diff");
        InsulinForYourDiabetesPageCC insulinForYourDiabetesPageCC = apartFromMetforminPageCC
                .clickOnAnswers("Actos (pioglitazone)")
                .clickNextButton(new InsulinForYourDiabetesPageCC());
        insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0007024-QS4608-STUDYQUES", protocol1)                
                .back();
        apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Avandia (rosiglitazone)")
                .clickNextButton(insulinForYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0007024-QS4608-STUDYQUES", protocol1)
                .back();
        apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Duetact (pioglitazone and glimepiride)")
                .clickNextButton(insulinForYourDiabetesPageCC);

        insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0007024-QS4608-STUDYQUES", protocol1)
                .back();
        apartFromMetforminPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Oseni (alogliptin and pioglitazone)")
        		.clickNextButton(insulinForYourDiabetesPageCC)
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0007024-QS4608-STUDYQUES", protocol1)
        		.back();
        
        apartFromMetforminPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Precose (acarbose)")
        		.clickNextButton(insulinForYourDiabetesPageCC);
       
        Assert.assertEquals(insulinForYourDiabetesPageCC.getTitleText(),insulinForYourDiabetesPageCC.titleExpected, "Title is diff");
        SubquestionsHumalogPageCC subquestionsHumalogPageCC = insulinForYourDiabetesPageCC
                .clickOnAnswers("Humalog","Humulin","Novolin","Novolog")
                .clickNextButton(new SubquestionsHumalogPageCC());

        subquestionsHumalogPageCC
                .waitForPageLoad()        
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0007026-QS4609-STUDYQUES", protocol1)
                .back();
        
        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());

        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageCC.getTitleText(),injectableMedicationsForYourDiabetesPageCC.titleExpected, "Title is diff");
        CombinationWithEachOtherPageCC combinationWithEachOtherPageCC = injectableMedicationsForYourDiabetesPageCC
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(new CombinationWithEachOtherPageCC());
        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006227-QS4611-STUDYQUES", protocol1)
                .back();
        injectableMedicationsForYourDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Bydureon or Byetta (exenatide)")
        		.clickNextButton(combinationWithEachOtherPageCC);
        combinationWithEachOtherPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0006227-QS4611-STUDYQUES", protocol1)
        		.back();
        injectableMedicationsForYourDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Tanzeum (albiglutide)")
        		.clickNextButton(combinationWithEachOtherPageCC);
        combinationWithEachOtherPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0006227-QS4611-STUDYQUES", protocol1)
        		.back();
        injectableMedicationsForYourDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Trulicity (dulaglutide)")
        		.clickNextButton(combinationWithEachOtherPageCC);
        combinationWithEachOtherPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsEqualsForQNumber("Q0006227-QS4611-STUDYQUES", protocol1)
        		.back();
        injectableMedicationsForYourDiabetesPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Saxenda or Victoza (liraglutide)", "SymlinPen (pramlintide)", "Another injectable medication not listed above")
        		.clickNextButton(combinationWithEachOtherPageCC);
        combinationWithEachOtherPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0006227-QS4611-STUDYQUES", protocol1)
        		.back();
        
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageCC);

        combinationWithEachOtherPageCC
                .waitForPageLoad();
               // .getPage(debugPageCC);
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral and Injectable Medication Logic", protocol4);
        Assert.assertEquals(combinationWithEachOtherPageCC.getTitleText(),combinationWithEachOtherPageCC.titleExpected, "Title is diff");
        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = combinationWithEachOtherPageCC
                .clickOnAnswer("5 months")
                .clickNextButton(new NoOfAlcoholicDrinksCC());
        
        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .enterNoOfDrinks("5")
                .clickNextButton(new FollowingLiverRelatedConditionCC());
        
        followingLiverRelatedConditionCC
        		.waitForPageLoad()
        		.clickOnAnswers("Alcoholic liver disease")
        		.clickNextButton(followingToLoseWeightPageCC)
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", protocol1)
        		.back();
        followingLiverRelatedConditionCC
				.waitForPageLoad()
				.clickOnAnswers("Autoimmune hepatitis, which is not the same as hepatitis caused by a virus")
				.clickNextButton(followingToLoseWeightPageCC)
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", protocol1)
				.back();
        followingLiverRelatedConditionCC
				.waitForPageLoad()
				.clickOnAnswers("Hemochromatosis or iron overload (Agent Note: he-mo-chrome-uh-TOE-sus)")
				.clickNextButton(followingToLoseWeightPageCC)
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", protocol1)
				.back();
        followingLiverRelatedConditionCC
				.waitForPageLoad()
				.clickOnAnswers("Liver cancer or hepatocellular carcinoma (Agent Note: hih-pat-oh-CELL-u-lar car-sih-NO-ma)")
				.clickNextButton(followingToLoseWeightPageCC)
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", protocol1)
				.back();
        followingLiverRelatedConditionCC
				.waitForPageLoad()
				.clickOnAnswers("Primary sclerosing cholangitis or primary biliary cirrhosis (Agent Note: scler-OH-sing, ko-lanj-EYE-tis, BILL-ee-air-ee)")
				.clickNextButton(followingToLoseWeightPageCC)
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", protocol1)
				.back();
        followingLiverRelatedConditionCC
				.waitForPageLoad()
				.clickOnAnswers("Wilson's disease")
				.clickNextButton(followingToLoseWeightPageCC)
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", protocol1)
				.back();
        followingLiverRelatedConditionCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(followingToLoseWeightPageCC);
       

        followingToLoseWeightPageCC
                .waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageCC.getTitleText(),followingToLoseWeightPageCC.titleExpected, "Title is diff");
        WeightLossSurgeryPageCC weightLossSurgeryPageCC  = followingToLoseWeightPageCC
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());
       

        weightLossSurgeryPageCC
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageCC.getTitleText(),weightLossSurgeryPageCC.titleExpected, "Title is diff");
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        procedureForWeightLossPageCC
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageCC.getTitleText(),procedureForWeightLossPageCC.titleExpected, "Title is diff");
        PoundsOrMorePageCC poundsOrMorePageCC  = procedureForWeightLossPageCC
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageCC());
        poundsOrMorePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()                
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()               
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageCC);

        //---------------------------------------PoundsOrMorePageCC----------------------------------------------------- 
        poundsOrMorePageCC
                .waitForPageLoad();
        		DoYouExperienceDPN_CC doYouExperienceDPN_CC = poundsOrMorePageCC
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouExperienceDPN_CC());
        doYouExperienceDPN_CC		
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0013992-QS4617-STUDYQUES", protocol1)
                .back();
        poundsOrMorePageCC
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
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1)
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
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickOnAnswers("Cirrhosis")
				.clickNextButton(hormonalBirthControlCC)
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
				.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Hepatitis B")
				.clickNextButton(hormonalBirthControlCC)        
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
        		.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickOnAnswers("Hepatitis C")
        		.clickNextButton( hormonalBirthControlCC)       
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
        		.back();
        
        doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("HIV or AIDS")
				.clickNextButton( hormonalBirthControlCC)       
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
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
                .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a study for diabetics")
                .getPID()
        		//----------SITE Selection Page--------------------
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()                
                .clickNextButton(new ThankYouCloseSimplePageCC())                
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);                
        
    }

}

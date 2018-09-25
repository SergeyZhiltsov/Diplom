package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.DoYouExperienceDPN_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.WhereDoYouExperienceDiabeticNervePain_CC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.HouseholdHavePageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatMedicalCoveragePageCC;
import com.acurian.selenium.pages.CC.pediatric.WouldYouUsePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.CC.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.CC.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.utils.DataProviderPool;
import com.acurian.selenium.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;


public class Diabetes_4356A_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
    @TestCaseId("00004")
    @Description("Diabetes_4356A_Synexus for CC")
    public void dia4356AccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1DIA";
        List<String> protocols = Arrays.asList("EFC14835", "ITCA 650_CLP_203","K_877_302","17530","EFC13794","NN2211_4315","NN9535_4269");
        String protocol1 = "17530";
        String protocol2 = "NN9535_4269";
        String protocol3 = "NN2211_4315";
        String protocol4 = "EFC13794";
        String protocol5 = "EFC14835";
        String protocol6 = "ITCA 650_CLP_203";
        String protocol7 = "K_877_302";
        String protocol8 = "EFC14833";
        String protocol9 = "EFC14835";
        String protocol10 = "EFC15166";
        String protocol11 = "EFC14868";
        String protocol12 = "EFC14837";
        String DIA_4241 = "EFC14822";
        String AKC = "ISIS 703802_CS2";
        String protocol13 = "EFC14838";
        String studyName = "a Diabetes"; //Diabetes study
        String studyName1 = "Diabetes";
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_MIG_4356A";
       // String env = "QA";
        String zipCode = "19044";
        
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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedDiabetes_4356, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
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
                .checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageCC.titleExpected, DIA_4241,AKC)
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
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, DIA_4241,AKC)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, DIA_4241,AKC)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, DIA_4241,AKC)
                .back();
        UseDietAndExercisePage useDietAndExercisePage = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new UseDietAndExercisePage());
        useDietAndExercisePage
                .waitForPageLoad()
                .back();
        
        WithType2DiabetesPageCC withType2DiabetesPageCC =  whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageCC.getTitleText(),withType2DiabetesPageCC.titleExpected, "Title is diff");
        withType2DiabetesPageCC.clickOnAnswer("7 - 12 months ago")
                .clickNextButton(new UseDietAndExercisePage());
        
        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new CurrentlyUseMetforminOrInsulinPage());
        
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.clickOnAnswers("Do not use any prescribed medication to treat diabetes")
        		.clickNextButton(new AnyPrescribedMedicationPage());
        
        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = anyPrescribedMedicationPage
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new NoOfAlcoholicDrinksCC());        

        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
        		.enterNoOfDrinks("4")
        		.clickNextButton(new FollowingLiverRelatedConditionCC());
        
        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = followingLiverRelatedConditionCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new FollowingToLoseWeightPageCC());
        
        WeightLossSurgeryPageCC weightLossSurgeryPageCC  = followingToLoseWeightPageCC
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());
       
        weightLossSurgeryPageCC
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageCC.getTitleText(),weightLossSurgeryPageCC.titleExpected, "Title is diff");
        
        PoundsOrMorePageCC poundsOrMorePageCC  = weightLossSurgeryPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageCC());
     

        //---------------------------------------PoundsOrMorePageOLS----------------------------------------------------- 
        poundsOrMorePageCC
                .waitForPageLoad();
        		DoYouExperienceDPN_CC doYouExperienceDPN_CC = poundsOrMorePageCC
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouExperienceDPN_CC());
                
                         
		// ---------------------------------------doYouExperienceDPN_OLS-----------------------------------------------------
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


        //---------------------------------------statinMedicationsOnPageOLS-----------
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
        forYourKidneysPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0013664-QS4228-STUDYQUES", protocol10, protocol12)
                .back();
        
        diabeticNephropathyPageCC
        		.clickOnAnswer("Yes")
        		.clickNextButton(new ForYourKidneysPageCC());

        //---------------------------------------forYourKidneysPageOLS------------------------------------------------------ 
        forYourKidneysPageCC
                .waitForPageLoad();
        Assert.assertEquals(forYourKidneysPageCC.getTitleText(),forYourKidneysPageCC.titleExpected, "Title is diff");
        forYourKidneysPageCC
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC())
                .waitForPageLoad()
              /*  .getPage(debugPageCC)
                .checkProtocolsEquals("Do you take medication for high blood pressure or for your kidneys? Some of these medications are ca", protocol1)  */
                .back();
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = forYourKidneysPageCC
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        
        //--------------------------------------Have you ever experienced or been diagnosed with any of the following specific heart-related medical conditions?------------------------------------------------------ 
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverExperiencedHeartRelatedMedicalCondCC.getTitleText(),haveYouEverExperiencedHeartRelatedMedicalCondCC.titleExpected, "Title is diff");
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC())
                .waitForPageLoad()
                .back();
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
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")                	
        		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
        		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
        		//----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "6", "166")
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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a study for diabetics")
                .getPID()
        		//----------SITE Selection Page--------------------
                .clickOnAnswer(siteName)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")                
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
		   		//.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
        		//.getAnomalyDbToLog(env); //Not applicable for Call center
                


      /*//---------------------------------------OLD GENERAL HEALTH------------------------------------------------------ 
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouUndergoneAnyPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC())
                .clickNextButton(new CongestiveHeartFailurePageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ConditionsRelatedToYourDiabetesPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditions())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingDigestiveConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingSkinConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingViralConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingMentalHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingWomensHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SmokedCigarettesPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                //----------PEDIATRIC HEALTH Questions----------
                //.clickNextButton(new HouseholdHavePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("None of the above")
                //.clickNextButton(new TheStudySitePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Public transportation")
                //.clickNextButton(new WhatMedicalCoveragePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("No, I have no coverage")
                //.clickNextButton(new EthnicBackgroundPageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Prefer not to answer")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)              
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a Diabetes study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new RadiantWarmTransfer1())
                //Warm Transfer Questions ----- 
                .waitForPageLoad()
                .clickOnAnswer("[patient agrees to be transferred]")
                .clickNextButton(new RadiantWarmTransfer2())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new RadiantWarmTransfer3())
                .waitForPageLoad()
                .clickNextButton(new RadiantWarmTransfer4())
                .waitForPageLoad()
                .clickOnAnswer("Transferred for Scheduling")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);*/
    }
}
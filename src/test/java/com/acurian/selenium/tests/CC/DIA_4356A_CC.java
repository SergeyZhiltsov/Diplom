package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.MDD_3159.WhenWasYourMostRecentHeartProcedureCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.CC.shared.DIA.CurrentlyUseMetforminOrInsulinPageCC;
import com.acurian.selenium.pages.CC.shared.DIA.UseDietAndExercisePageCC;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class DIA_4356A_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = true)
    @TestCaseId("00004")
    @Description("Diabetes_4356A_Synexus for CC")
    public void dia4356AccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1DIA";
//        String protocol1 = "17530";
//        String protocol2 = "NN9535_4269";
//        String protocol3 = "NN2211_4315";
//        String protocol4 = "EFC13794";
//        String protocol5 = "EFC14835";
//        String protocol6 = "ITCA 650_CLP_203";
        String protocol7 = "K_877_302";
//        String protocol8 = "EFC14833";
//        String protocol9 = "EFC14835";
//        String protocol10 = "EFC15166";
//        String protocol11 = "EFC14868";
//        String protocol12 = "EFC14837";
//        String DIA_4241 = "EFC14822";
//        String AKC = "ISIS 703802_CS2";
//        String protocol13 = "EFC14838";
//        String[] protocols = {protocol1,protocol2,protocol3,protocol4,AKC};
        String studyName = "a Diabetes"; //Diabetes study
        String studyName1 = "Diabetes";
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_DIA_4356A";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env", "STG");

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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedDiabetes_4356, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());
        

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());
        

        genderPageCC
                .waitForPageLoad();
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());
        

        DebugPageCC debugPageCC = new DebugPageCC();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        

        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());
        

        UseDietAndExercisePageCC useDietAndExercisePageCC = withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new UseDietAndExercisePageCC());
        

        CurrentlyUseMetforminOrInsulinPageCC currentlyUseMetforminOrInsulinPageCC = useDietAndExercisePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPageCC());
        
        
        //----Q6--Do you currently use metformin or insulin or any other medication prescribed by your doctor to treat your diabetes?
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());
        
        
        //------Q7-Have you taken any prescribed medication for your diabetes within the past 3 months?
        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = anyPrescribedMedicationPage
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NoOfAlcoholicDrinksCC());
        
        
        //------Q15: About how many alcoholic drinks do you have in a typical week?
        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .setDrinks("4")
                .clickNextButton(new FollowingLiverRelatedConditionCC());
        

        //--------Q16 - Has a healthcare professional ever diagnosed you with any of the following liver-related conditions?
        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageCC());
        

        //--------Q17:  Are you currently using any of the following to lose weight?
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());
        

        //-----------Q18: Have you ever had any of the following types of bariatric or weight loss surgery?
        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageCC());
        

        //-----------Q20:  Have you lost or gained 15 pounds or more in the past 3 months?
        TransitionStatementCC transitionStatementCC  = poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        

        //------------- Transition Statement-----------------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad("diabetes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        
        //********************GENERAL HEALTH Questions -----------------
        DyslipidemiaHealthcarePageCC dyslipidemiaHealthcarePageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new DyslipidemiaHealthcarePageCC());
        

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0010983-QS4242-STUDYQUES", protocol7)
                .back();
        TriglyceridesOrLipidsPageCC triglyceridesOrLipidsPageCC = dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(new TriglyceridesOrLipidsPageCC());
        

        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0018142-QS4243-STUDYQUES", protocol7)
                .back();
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        
        HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC haveYouEverBeenDiagnosedAdditionalHeartRelatedCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
        haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5,"1 - 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS4232-STUDYQUES", protocol7)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS4232-STUDYQUES", protocol7)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"1 - 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC);
        

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        

        IdentificationPageCC identificationPageCC = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageCC());
        identificationPageCC
                .waitForPageLoad()
                .back();
        WhenWasYourMostRecentHeartProcedureCC whenWasYourMostRecentHeartProcedureCC = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
                .clickNextButton(new WhenWasYourMostRecentHeartProcedureCC());
        

        whenWasYourMostRecentHeartProcedureCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(identificationPageCC)
                .waitForPageLoadNotQ()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015137-QS4235-STUDYQUES", protocol7)
                .back();
        whenWasYourMostRecentHeartProcedureCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(identificationPageCC)
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a study for diabetics")
                .getPID()
                .clickOnDebugSiteName(debugSiteName)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")                
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
		   		//.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
        		//.getAnomalyDbToLog(env); //Not applicable for Call center
    }
}
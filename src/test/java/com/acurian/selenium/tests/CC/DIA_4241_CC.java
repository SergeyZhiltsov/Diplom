package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.DoYouExperienceDPN_CC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.CC.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.CC.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class DIA_4241_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00012")
    @Description("Diabetes_4241 CC")
    public void dia4241ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1DIA";
        List<String> protocols = Arrays.asList("EFC14822");
        String protocol1 = "EFC14822";
        String studyName = "a study for diabetics";
        String siteName = "AUT_DIA_4241";
        String debugSiteName = "";
    //    String env = "STG";
        String zipCode = "19901";
        
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleDIA4241Expected, "Title is diff");
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
        		.checkProtocolsContainsForQNumber("Q0005996-QS4602-STUDYQUES", protocol1)
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
        UseDietAndExercisePage useDietAndExercisePage = whatKindOfDiabetesPageCC //rel 47
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new UseDietAndExercisePage())
                .waitForPageLoad();
        
        useDietAndExercisePage
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC =  whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageCC.getTitleText(),withType2DiabetesPageCC.titleExpected, "Title is diff");
        withType2DiabetesPageCC
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(useDietAndExercisePage);

        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage());
        currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016800-QS4625-STUDYQUES", protocol1)
                .back();
        
        useDietAndExercisePage
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new CurrentlyUseMetforminOrInsulinPage());
        
        MetforminMedicationsPageCC metforminMedicationsPageCC = currentlyUseMetforminOrInsulinPage
				.waitForPageLoad()
				.clickOnAnswers("Metformin")
				.clickNextButton(new MetforminMedicationsPageCC());
        
        metforminMedicationsPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016801-QS4626-STUDYQUES", protocol1)
                .back();
        InsulinForYourDiabetesPageCC insulinForYourDiabetesPageCC = currentlyUseMetforminOrInsulinPage
				.waitForPageLoad()
				.clickOnAnswers("Metformin")
				.clickOnAnswers("Insulin")
				.clickNextButton(new InsulinForYourDiabetesPageCC());

        insulinForYourDiabetesPageCC
				.waitForPageLoad()
				.getPage(debugPageCC)
				.checkProtocolsContainsForQNumber("Q0016801-QS4626-STUDYQUES", protocol1)
				.back();
        ApartFromMetforminPageCC apartFromMetforminPageCC = currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.clickOnAnswers("Insulin")
        		.clickOnAnswers("Medication other than Metformin or Insulin")
        		.clickNextButton(new ApartFromMetforminPageCC());

        apartFromMetforminPageCC
        		.waitForPageLoad()
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0016801-QS4626-STUDYQUES", protocol1)
        		.back();
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
				.waitForPageLoad()
				.clickOnAnswers("Do not use any prescribed medication to treat diabetes")
				.clickNextButton(new AnyPrescribedMedicationPage());
        
        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = anyPrescribedMedicationPage
                .clickOnAnswer("Yes")
                .clickNextButton(new NoOfAlcoholicDrinksCC());
        noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0016802-QS4627-STUDYQUES", protocol1)
        		.back();
        
        anyPrescribedMedicationPage
        		.clickOnAnswer("No")
        		.clickNextButton(new NoOfAlcoholicDrinksCC());
        
        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .enterNoOfDrinks("8")
                .clickNextButton(new FollowingLiverRelatedConditionCC());
        
        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = followingLiverRelatedConditionCC
        		.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new FollowingToLoseWeightPageCC());
        
        WeightLossSurgeryPageCC weightLossSurgeryPageCC  = followingToLoseWeightPageCC
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());
        
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());
        
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
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES", protocol1)
        		.back();
        		
        procedureForWeightLossPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("7 - 11 months ago")
        		.clickNextButton(poundsOrMorePageCC)
        		.waitForPageLoad()               
        		.getPage(debugPageCC)
        		.checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES", protocol1)
        		.back();
        procedureForWeightLossPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("More than 2 years ago")
        		.clickNextButton(poundsOrMorePageCC);
        
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
		        .waitForPageLoad()
		        .clickOnAnswer("No")
		        .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
    
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
        		.getPID()
        		.clickOnAnswer(siteName)
        		.clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")                
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);    
    }
}

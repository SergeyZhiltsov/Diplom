package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.OLS.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.OLS.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.OLS.shared.DIA.UseDietAndExercisePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;

public class DIA_4241_OLS extends BaseTest{

    @Test
    @TestCaseId("00017")
    @Description("Diabetes_4241 OLS")
    public void dia4241olsTest() {
        String phoneNumberLBP = "AUTAMS1DIA";
        List<String> protocols = Arrays.asList("EFC14822");
        String protocol1 = "EFC14822";
        String AKC = "ISIS 703802_CS2";
        String studyName = "a diabetes";
        String siteName = "AUT_DIA_4241";   
        String zipCode = "19901";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleDiabetes_4356A_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageOLS.getTitleText(),diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, protocol1,AKC);
        debugPageOLS.back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageOLS.getTitleText(),whatKindOfDiabetesPageOLS.titleExpected, "Title is diff");
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1,AKC)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1,AKC)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1,AKC)
                .back();
        UseDietAndExercisePage useDietAndExercisePage = whatKindOfDiabetesPageOLS //rel 47
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new UseDietAndExercisePage());
        useDietAndExercisePage
                .waitForPageLoad()
                .back();
        
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageOLS.getTitleText(),withType2DiabetesPageOLS.titleExpected, "Title is diff");
        withType2DiabetesPageOLS
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new UseDietAndExercisePage());
        
        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage());        
        currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		//.getPage(debugPageOLS)
        		//.checkProtocolsContainsForQNumber("QS4625", protocol1)
        		.back();
        useDietAndExercisePage
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new CurrentlyUseMetforminOrInsulinPage());
        
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.clickOnAnswers("Metformin")
        		.clickNextButton(new MetforminMedicationsPageOLS());
        metforminMedicationsPageOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4626", protocol1)
        		.back();
        
        InsulinForYourDiabetesPageOLS insulinForYourDiabetesPageOLS = currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.clickOnAnswers("Metformin")
        		.clickOnAnswers("Insulin")
        		.clickNextButton(new InsulinForYourDiabetesPageOLS());
        insulinForYourDiabetesPageOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4626", protocol1)
        		.back();
        
        ApartFromMetforminPageOLS apartFromMetforminPageOLS = currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.clickOnAnswers("Insulin")
        		.clickOnAnswers("Medication other than Metformin or Insulin")
        		.clickNextButton(new ApartFromMetforminPageOLS());
        apartFromMetforminPageOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4626", protocol1)
        		.back();
        
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
        		.waitForPageLoad()
        		.clickOnAnswers("Do not use any prescribed medication to treat diabetes")
        		.clickNextButton(new AnyPrescribedMedicationPage());
        
        
        //FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = treatingYourDiabetesPageOLS
        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = anyPrescribedMedicationPage
        		.waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());
        noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4627", protocol1)        		
                .back();
        anyPrescribedMedicationPage
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new NoOfAlcoholicDrinkOLS());
        
     
      LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
    		    .waitForPageLoad()
      			.setDrinks("4")
      			.clickNextButton(new LiverRelatedConditionOLS());
      			        		
      	//---------------------------------------liverRelatedConditionOLS---------------
      	liverRelatedConditionOLS
      				.waitForPageLoad();
      			     Assert.assertEquals(liverRelatedConditionOLS.getTitleText(),liverRelatedConditionOLS.titleExpected, "Title is diff");
      			     FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
      			     .clickOnAnswers("None of the above")
      			     .clickNextButton(new FollowingToLoseWeightPageOLS());				
             
        followingToLoseWeightPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageOLS.getTitleText(),followingToLoseWeightPageOLS.titleExpected, "Title is diff");
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(),weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        procedureForWeightLossPageOLS
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageOLS.getTitleText(),procedureForWeightLossPageOLS.titleExpected, "Title is diff");
        PoundsOrMorePageOLS poundsOrMorePageOLS = procedureForWeightLossPageOLS
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
        poundsOrMorePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4616", protocol1)        		
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(poundsOrMorePageOLS);

        poundsOrMorePageOLS
                .waitForPageLoad();
        Assert.assertEquals(poundsOrMorePageOLS.getTitleText(),poundsOrMorePageOLS.titleExpected, "Title is diff");
        poundsOrMorePageOLS
                .clickOnAnswer("Yes")
                //.clickNextButton(new StatinMedicationsOnPageOLS())
                .clickNextButton(new DoYouExperienceDPN_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4617", protocol1)
                .back();
        ChildrenUnderPageOLS childrenUnderPageOLS = poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ChildrenUnderPageOLS());
        childrenUnderPageOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageOLS());
                TheStudySitePageOLS theStudySitePageOLS = new TheStudySitePageOLS();
  //----------*******NEW GENERAL HEALTH Questions********---------------------------     
		//-------------------PEDIATRIC QUESTIONS-----------------------------
         theStudySitePageOLS.waitForPageLoad()
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
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new SiteSelectionPageOLS())
        .waitForPageLoadAKC()
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new QualifiedClose2PageOLS())
        .waitForPageLoad()
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);		
    }
}
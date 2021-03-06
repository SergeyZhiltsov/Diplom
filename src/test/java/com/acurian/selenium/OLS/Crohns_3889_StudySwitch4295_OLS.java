package com.acurian.selenium.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.*;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.FollowingMedicationsCrohnsPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.ManageYourCrohnsPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.ConfigPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Crohns_3889_StudySwitch4295_OLS extends BaseTest{

    @Test(enabled = false)
    @TestCaseId("00033")
    @Description("Crohn's_3889 OLS with HS")
    public void Crohns3889StudySwitch4295OLS() {
        String phoneNumber = "AUTAMS1CRN";
        String protocol1 = "I6T_MC_AMAG";
        String protocol2 = "M15_991";
        String protocol3 = "M16_006";
        String protocol4 = "RF_I6T_MC_AMAG";
        List<String> protocols = Arrays.asList(protocol1,protocol2,protocol3,protocol4);
        String studyName = "a Crohn's";
        String siteName = "AUT_CRN_3889_HS";
        String debugSiteName = "";        
        String zipCode = "19044";
        String ExpStudySwich = "4295AMS1SS";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber);
                //.waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleCrohns_3485_Expected, "Title is diff");
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
        DiagnosedWithCrohnsPageOLS diagnosedWithCrohnsPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageOLS());

        diagnosedWithCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedWithCrohnsPageOLS.getTitleText(),diagnosedWithCrohnsPageOLS.titleExpected, "Title is diff");
        FollowingMedicalConditionsPageOLS followingMedicalConditionsPageOLS = diagnosedWithCrohnsPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new FollowingMedicalConditionsPageOLS());

        followingMedicalConditionsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingMedicalConditionsPageOLS.getTitleText(), followingMedicalConditionsPageOLS.titleExpected, "Title is diff");
        WhenDiagnosedCrohnsPageOLS whenDiagnosedCrohnsPageOLS = followingMedicalConditionsPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhenDiagnosedCrohnsPageOLS());

        whenDiagnosedCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whenDiagnosedCrohnsPageOLS.getTitleText(), whenDiagnosedCrohnsPageOLS.titleExpected, "Title is diff");
        TypeOfDoctorPageOLS typeOfDoctorPageOLS = whenDiagnosedCrohnsPageOLS
                .clickOnAnswer("7 or more years ago")
                .clickNextButton(new TypeOfDoctorPageOLS());

        typeOfDoctorPageOLS
                .waitForPageLoad();
        Assert.assertEquals(typeOfDoctorPageOLS.getTitleText(), typeOfDoctorPageOLS.titleExpected, "Title is diff");
        TypeOfTestsPageOLS typeOfTestsPageOLS = typeOfDoctorPageOLS
                .clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(new TypeOfTestsPageOLS());

        typeOfTestsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(typeOfTestsPageOLS.getTitleText(), typeOfTestsPageOLS.titleExpected, "Title is diff");
        ManageYourCrohnsPageOLS manageYourCrohnsPageOLS = typeOfTestsPageOLS
                .clickOnAnswers("Colonoscopy")
                .clickNextButton(new ManageYourCrohnsPageOLS());

        manageYourCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(manageYourCrohnsPageOLS.getTitleText(), manageYourCrohnsPageOLS.titleExpected, "Title is diff");
        //OnA0To10ScalePageOLS onA0To10ScalePageOLS = manageYourCrohnsPageOLS
        SteroidMedicationsPageOLS steroidMedicationsPageOLS = manageYourCrohnsPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsPageOLS());

        steroidMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(steroidMedicationsPageOLS.getTitleText(), steroidMedicationsPageOLS.titleExpected, "Title is diff");
        FollowingMedicationsCrohnsPageOLS followingMedicationsCrohnsPageOLS = steroidMedicationsPageOLS
                .clickOnAnswers("I have never treated my Crohn’s with steroids")
                .clickNextButton(new FollowingMedicationsCrohnsPageOLS());

        followingMedicationsCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingMedicationsCrohnsPageOLS.getTitleText(), followingMedicationsCrohnsPageOLS.titleExpected, "Title is diff");
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = followingMedicationsCrohnsPageOLS
                .clickOnAnswers("Xeljanz (tofacitinib)")
                .clickNextButton(new BiologicMedicationsPageOLS());

        biologicMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(biologicMedicationsPageOLS.getTitleText(), biologicMedicationsPageOLS.titleExpected, "Title is diff");
        SubquestionLastReceivedPageOLS subquestionLastReceivedPageOLS = biologicMedicationsPageOLS
                .clickOnAnswers("Stelara")
                .clickNextButton(new SubquestionLastReceivedPageOLS());

        subquestionLastReceivedPageOLS
                .waitForPageLoad(1,subquestionLastReceivedPageOLS.titleExpected13);
                OnA0To10ScalePageOLS onA0To10ScalePageOLS = subquestionLastReceivedPageOLS
                .clickOnAnswerForSubQuestion("Which of the following best describes when you last received Stelara? You….","Last received 1 year ago or more")
                .clickNextButton(new OnA0To10ScalePageOLS());

        onA0To10ScalePageOLS
                .waitForPageLoad();
        Assert.assertEquals(onA0To10ScalePageOLS.getTitleText(), onA0To10ScalePageOLS.titleExpected, "Title is diff");
        StatementsBestDescribesPageOLS statementsBestDescribesPageOLS = onA0To10ScalePageOLS
                .setRating("03")
                .clickNextButton(new StatementsBestDescribesPageOLS());
        
        statementsBestDescribesPageOLS
                .waitForPageLoad();
                HowManyLiquidPageOLS howManyLiquidPageOLS = statementsBestDescribesPageOLS
                .clickOnAnswer("Yes, I am currently in a flare with my Crohn’s")
                .clickNextButton(new HowManyLiquidPageOLS());
                
        howManyLiquidPageOLS
        		.waitForPageLoad();
                StoolAndIndicatePageOLS stoolAndIndicatePageOLS = howManyLiquidPageOLS
                .setHoursRating("06")
                .setDayRating("06")
                .clickNextButton(new StoolAndIndicatePageOLS());
                
        stoolAndIndicatePageOLS         
                .waitForPageLoad();
        		LevelOfPainPageOLS levelOfPainPageOLS = stoolAndIndicatePageOLS
        		.clickOnAnswer("Type 5")
                .clickNextButton(new LevelOfPainPageOLS());
                
        levelOfPainPageOLS        
                .waitForPageLoad();
                YouExperienceAbdominalPageOLS youExperienceAbdominalPageOLS = levelOfPainPageOLS
                .setRating("05")
                .clickNextButton(new YouExperienceAbdominalPageOLS());
                
        youExperienceAbdominalPageOLS
                .waitForPageLoad();
                WhenItOccursPageOLS whenItOccursPageOLS = youExperienceAbdominalPageOLS
                .clickOnAnswer("3 - Sometimes")
                .clickNextButton(new WhenItOccursPageOLS());
                
        whenItOccursPageOLS       
                .waitForPageLoad();
                AverageWeekPageOLS averageWeekPageOLS = whenItOccursPageOLS
                .setRating("5")
                .clickNextButton(new AverageWeekPageOLS());
                
        averageWeekPageOLS         
                .waitForPageLoad();
        		YourNormalBaselinePageOLS yourNormalBaselinePageOLS = averageWeekPageOLS
        		.clickOnAnswer("6 - 7 days")
                .clickNextButton(new YourNormalBaselinePageOLS());
        
        yourNormalBaselinePageOLS
        		.waitForPageLoad();
        		WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = yourNormalBaselinePageOLS
                .clickOnAnswer("Less severe")
                .clickNextButton(new WeightLossSurgeryPageOLS());
        		
        weightLossSurgeryPageOLS
        		.waitForPageLoad();
        CurrentlyHaveAnyOffFollowingPageOLS currentlyHaveAnyOffFollowingPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageOLS());
        
        currentlyHaveAnyOffFollowingPageOLS
        		.waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

       
        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
//&&&&&&&&&&&&&&&& New for AMS1 Rel.51, when Gender = Female &&&&&&&&&&&&&&&&&&&&
        .clickNextButton(new HormonalBirthControlOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
//&&&&&&&&&&&&&&&& END &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        .clickNextButton(new ApproximateHeightPageOLS())
	 //----------ProvideHeight-Weight Page--------------------
        .waitForPageLoad()
        .setAll("5", "5", "160")
        .clickNextButton(new ChildrenUnderPageOLS())
	 //----------ChildrenUnderTheAge Page--------------------
        .waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new HouseholdHavePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
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
        .clickNextButton(new PersonalDetails())
     //----------PII (IdentificationPageOLS) Page--------------------
		.waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new UnqualifiedCloseOLS())
        //.waitForPageLoad()
		//.clickOnAnswer("Yes")-----------?
		.clickNextButton(new StandAlone4295SwitchOLS())
		
		//--------------------Standalone study Switch- 4295-----------
		.waitForPageLoad();
		ConfigPageOLS configPageOLS = new ConfigPageOLS();
		configPageOLS.getPID();
		configPageOLS.openDebugWindow();
		Assert.assertEquals(configPageOLS.getTextfromStudySwitch(), ExpStudySwich,"studySwitch from AMS1 to Standalone 4295 failed");
   }
}
package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.OLS.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.OLS.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;


public class DIA_4356A_OLS extends BaseTest {

    @Test
    @TestCaseId("00053")
    @Description("Diabetes_4356A_Synexus")
    public void diabetes_4356A_ols() {
        String phoneNumber = "AUTAMS1DIA";
        List<String> protocols = Arrays.asList("EFC14835", "ITCA 650_CLP_203", "K_877_302", "17530", "EFC13794", "NN2211_4315", "NN9535_4269");
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
//        String protocol13 = "EFC14838";
        String DIA_4241 = "EFC14822";
        String AKC = "ISIS 703802_CS2";
        String studyName = "a study for diabetics";
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_DIA_4356A";
        //    String env = "STG";
        String zipCode = "19044";
        String facility_Code_STG = "625268";
        String facility_Code_PRD = "625640";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleDiabetes_4356A_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        UseDietAndExercisePage useDietAndExercisePage = withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new UseDietAndExercisePage());


        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage());

        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());

        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = anyPrescribedMedicationPage
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());

        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .setDrinks("4")
                .clickNextButton(new LiverRelatedConditionOLS());

        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageOLS());

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

//        //---------------------------------------doYouExperienceDPN_OLS-----------------------------------------------------
//        doYouExperienceDPN_OLS
//                .waitForPageLoad();
//        		 WhereDoYouExperienceDiabeticNervePain_OLS whereDoYouExperienceDiabeticNervePain_OLS = doYouExperienceDPN_OLS
//                 .clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
//                 .clickNextButton(new WhereDoYouExperienceDiabeticNervePain_OLS());
//
//
//        //---------------------------------------WhereDoYouExperienceDiabeticNervePain_OLS-----------------------------------------------------
//        whereDoYouExperienceDiabeticNervePain_OLS
//				.waitForPageLoad();
//				 StatinMedicationsOnPageOLS statinMedicationsOnPageOLS = whereDoYouExperienceDiabeticNervePain_OLS
//				.clickOnAnswers("None of the above")
//				.clickNextButton(new StatinMedicationsOnPageOLS());
//
//        //---------------------------------------statinMedicationsOnPageOLS-------------------------------------------------------
//        statinMedicationsOnPageOLS
//                .waitForPageLoad();
//        Assert.assertEquals(statinMedicationsOnPageOLS.getTitleText(),statinMedicationsOnPageOLS.titleExpected, "Title is diff");
//        DiabeticNephropathyPageOLS diabeticNephropathyPageOLS = statinMedicationsOnPageOLS
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new DiabeticNephropathyPageOLS());
//
//        //---------------------------------------diabeticNephropathyPageOLS------------------------------------------------------
//        diabeticNephropathyPageOLS
//                .waitForPageLoad();
//        Assert.assertEquals(diabeticNephropathyPageOLS.getTitleText(),diabeticNephropathyPageOLS.titleExpected, "Title is diff");
//        ForYourKidneysPageOLS forYourKidneysPageOLS = diabeticNephropathyPageOLS
//                .clickOnAnswer("No")
//                .clickNextButton(new ForYourKidneysPageOLS());
//        forYourKidneysPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4228", protocol7)
//                .back();
//        diabeticNephropathyPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new ForYourKidneysPageOLS());
//
//        //---------------------------------------forYourKidneysPageOLS------------------------------------------------------
//        forYourKidneysPageOLS
//                .waitForPageLoad();
//        Assert.assertEquals(forYourKidneysPageOLS.getTitleText(),forYourKidneysPageOLS.titleExpected, "Title is diff");
//
//        forYourKidneysPageOLS.clickOnAnswer("No")
//        		.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                //.checkProtocolsEquals("Do you take medication for high blood pressure or for your kidneys? Some of these medications are ca...", protocol1)
//                .back();
//        forYourKidneysPageOLS
//                .clickOnAnswer("Yes")
//                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());


        DyslipidemiaHealthcarePageOLS dyslipidemiaHealthcarePageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new DyslipidemiaHealthcarePageOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = dyslipidemiaHealthcarePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4242", protocol7)
                .back();
        TriglyceridesOrLipidsPageOLS triglyceridesOrLipidsPageOLS = dyslipidemiaHealthcarePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(new TriglyceridesOrLipidsPageOLS());

        triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4243", protocol7)
                .back();
        triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS());
        haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"1 - 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4232", protocol7)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4232", protocol7)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"1 - 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        IdentificationPageOLS identificationPageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS());
        identificationPageOLS
                .waitForPageLoad()
                .back();
        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());

        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoadNotQ()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4235", protocol7)
                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(identificationPageOLS);

        identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoadAKC()
                .getPID()
                .clickOnDebugSiteName(debugSiteName)
//                .clickOnFacilityName(siteName)
                .clickNextButton(new SynexusQualifiedClose4356PageOLS())
                .waitForPageLoad(env.equals("STG") ? facility_Code_STG : facility_Code_PRD)
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
        //.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
    }
}
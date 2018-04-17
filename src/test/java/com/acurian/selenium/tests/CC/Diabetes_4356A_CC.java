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
import com.acurian.selenium.utils.DataProviderPool;
import com.acurian.selenium.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;


public class Diabetes_4356A_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedDiabetes_4356, "Title is diff");
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
                .checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageCC.titleExpected, DIA_4241)
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
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad();
                TreatingYourDiabetesPageCC treatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageCC());
                treatingYourDiabetesPageCC.waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, DIA_4241)
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
                //.checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, DIA_4241)
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
                //.getPage(debugPageCC)//for protocol check I manually copied text from the question debug because the issue with debug questions
                //.checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol2, protocol3, protocol4, protocol6)
                .back();
        treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                //.getPage(debugPageCC)// copy text from previous question until "..."(white space should be include)
                //.checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol2, protocol3, protocol4, protocol6)
                .back();
        LastTimeYouTookPageCC lastTimeYouTookPageCC = treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Medication")
                .clickNextButton(new LastTimeYouTookPageCC());

        //---------------------------------------lastTimeYouTookPageOLS------------------------------------------------------ 
        lastTimeYouTookPageCC
                .waitForPageLoad();
        Assert.assertEquals(lastTimeYouTookPageCC.getTitleText(),lastTimeYouTookPageCC.titleExpected, "Title is diff");
                MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
		.clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageCC());
                 metforminMedicationsPageCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, DIA_4241)
                .back();
                lastTimeYouTookPageCC.waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new MetforminMedicationsPageCC());


        metforminMedicationsPageCC
                .waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageCC.getTitleText(),metforminMedicationsPageCC.titleExpected, "Title is diff");
        ApartFromMetforminPageCC apartFromMetforminPageCC = metforminMedicationsPageCC
                .clickOnAnswers("Janumet (metformin and sitagliptin)",
                        "Jentadueto (metformin and linagliptin)",
                        "Kazano (metformin and alogliptin)",
                        "Kombiglyze (metformin and saxagliptin)",
                        "PrandiMet (metformin and repaglinide)",
                        "Avandamet (metformin and rosiglitazone)")
//                .clickOnAnswers("None of the above")
                .clickNextButton(new ApartFromMetforminPageCC());
        apartFromMetforminPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsEquals(metforminMedicationsPageCC.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsEquals(metforminMedicationsPageCC.titleExpected, protocol6)
                .back();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Metformin")
                .clickNextButton(apartFromMetforminPageCC);

        apartFromMetforminPageCC
                .waitForPageLoad();
        Assert.assertEquals(apartFromMetforminPageCC.getTitleText(),apartFromMetforminPageCC.titleExpected, "Title is diff");
        InsulinForYourDiabetesPageCC insulinForYourDiabetesPageCC = apartFromMetforminPageCC
                .clickOnAnswers("Amaryl (glimepiride)",
                        "Avandia (rosiglitazone)",
                        "Chlorpropamide",
                        "Cycloset (bromocriptine)",
                        "Duetact (pioglitazone and glimepiride)")
                .clickNextButton(new InsulinForYourDiabetesPageCC());
        insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsEquals(apartFromMetforminPageCC.titleExpected, protocol2,protocol3,protocol4,protocol6,protocol8,protocol9,protocol10,protocol11)
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral Medication Logic", protocol2,protocol3)
                .back();
        apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(insulinForYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral Medication Logic", protocol2,protocol3)
                .back();
        apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("Farxiga (dapagliflozin)")
                .clickNextButton(insulinForYourDiabetesPageCC);

        insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC);
                //.checkProtocolsEquals(apartFromMetforminPageCC.titleExpected, protocol6);
        Assert.assertEquals(insulinForYourDiabetesPageCC.getTitleText(),insulinForYourDiabetesPageCC.titleExpected, "Title is diff");
        SubquestionsHumalogPageCC subquestionsHumalogPageCC = insulinForYourDiabetesPageCC
                .clickOnAnswers("Humalog","Humulin","Novolin","Novolog")
                .clickNextButton(new SubquestionsHumalogPageCC());

        subquestionsHumalogPageCC
                .waitForPageLoad();
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(1),subquestionsHumalogPageCC.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(2),subquestionsHumalogPageCC.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(3),subquestionsHumalogPageCC.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(4),subquestionsHumalogPageCC.titleExpected4, "Title is diff");
        //testing new SubQuestion answer feature
        subquestionsHumalogPageCC
                .clickOnAnswersForSubQuestion(1,"Humalog Mix 50/50","Humalog Mix 75/25")
                .clickOnAnswersForSubQuestion(2,"Humulin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolin do you currently use?","Novolin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolog do you currently use?","Novolog Mix 70/30")
                .back();

        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());

        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageCC.getTitleText(),injectableMedicationsForYourDiabetesPageCC.titleExpected, "Title is diff");
        CombinationWithEachOtherPageCC combinationWithEachOtherPageCC = injectableMedicationsForYourDiabetesPageCC
                .clickOnAnswers("Adlyxin (lixisenatide)", "Another injectable medication not listed above")
                .clickNextButton(new CombinationWithEachOtherPageCC());
        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                //.checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageCC);

        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .getPage(debugPageCC);
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral and Injectable Medication Logic", protocol4);
        Assert.assertEquals(combinationWithEachOtherPageCC.getTitleText(),combinationWithEachOtherPageCC.titleExpected, "Title is diff");
        combinationWithEachOtherPageCC
                .clickOnAnswer("1 month or less")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(followingToLoseWeightPageCC);

        followingToLoseWeightPageCC
                .waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageCC.getTitleText(),followingToLoseWeightPageCC.titleExpected, "Title is diff");
        WeightLossSurgeryPageCC weightLossSurgeryPageCC  = followingToLoseWeightPageCC
                .clickOnAnswers("Prescription weight loss medication")
                .clickNextButton(new WeightLossSurgeryPageCC());
        weightLossSurgeryPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        followingToLoseWeightPageCC
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(weightLossSurgeryPageCC);

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
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, DIA_4241)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, DIA_4241)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, DIA_4241)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageCC);

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
        diabeticNephropathyPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(statinMedicationsOnPageCC.titleExpected, protocol7)
                .back();
        StatinMedicationPreviousQuestionPageCC statinMedicationPreviousQuestionPageCC  = statinMedicationsOnPageCC
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin","Simcor (simvastatin and niacin)")
                .clickNextButton(new StatinMedicationPreviousQuestionPageCC());

      //---------------------------------------statinMedicationPreviousQuestionPageOLS------------------------------------------------------ 
        statinMedicationPreviousQuestionPageCC
                .waitForPageLoad();
        Assert.assertEquals(statinMedicationPreviousQuestionPageCC.getTitleText(),statinMedicationPreviousQuestionPageCC.titleExpected, "Title is diff");
        statinMedicationPreviousQuestionPageCC
                .clickOnAnswer("1 month or less")
                .clickNextButton(diabeticNephropathyPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(diabeticNephropathyPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 months")
                .clickNextButton(diabeticNephropathyPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 months - 11 months")
                .clickNextButton(diabeticNephropathyPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(diabeticNephropathyPageCC);

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
                .checkProtocolsEquals(diabeticNephropathyPageCC.titleExpected, protocol1, protocol12, protocol10)
                .back();
        diabeticNephropathyPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(forYourKidneysPageCC);

        //---------------------------------------forYourKidneysPageOLS------------------------------------------------------ 
        forYourKidneysPageCC
                .waitForPageLoad();
        Assert.assertEquals(forYourKidneysPageCC.getTitleText(),forYourKidneysPageCC.titleExpected, "Title is diff");
        forYourKidneysPageCC
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Do you take medication for high blood pressure or for your kidneys? Some of these medications are ca", protocol1)
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
        		.clickNextButton(new HormonalBirthControlCC())
        		.waitForPageLoad()
        		.clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageCC())
        		//----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
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
                .waitForPageLoad("a Diabetes study")
                .getPID()
        		//----------SITE Selection Page--------------------
                .clickOnAnswer(siteName)
                .clickNextButton(new RadiantWarmTransferClose1PageCC())
                .waitForPageLoad()
                .clickOnAnswer("[patient agrees to be transferred]")
                .clickNextButton(new SynexusDirectScheduleWTC2PageCC())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SynexusDirectScheduleWTC3PageCC())
                .waitForPageLoad()
                .clickNextButton(new SRDirectScheduleWTTCPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Transferred for Scheduling")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env);
                //.getAnomalyDbToLog(env);


      /*//---------------------------------------OLD GENERAL HEALTH------------------------------------------------------ 
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouUndergoneAnyPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC())
                .clickNextButton(new HeartFailureIsAlsoPageCC())
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
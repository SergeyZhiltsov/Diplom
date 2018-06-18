package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.WhereDoYouExperienceDiabeticNervePain_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;


public class Diabetes_4356A extends BaseTest{

	@Test
    @TestCaseId("00053")
    @Description("Diabetes_4356A_Synexus")
    public void diabetes_4356A() {
        String phoneNumberLBP = "AUTAMS1DIA";
        List<String> protocols = Arrays.asList("EFC14835", "ITCA 650_CLP_203","K_877_302","17530","EFC13794","NN2211_4315","NN9535_4269");       
        String protocol1 = "17530";
        String protocol2 = "NN9535_4269";
        String protocol3 = "NN2211_4315";
        String protocol4 = "EFC13794";
        String protocol5 = "EFC14835";
        String protocol6 = "ITCA 650_CLP_203";
        //String protocol7 = "K_877_302";
        String protocol8 = "EFC14833";
        String protocol9 = "EFC14835";
        String protocol10 = "EFC15166";
        String protocol11 = "EFC14868";
        String protocol12 = "EFC14837";
        String protocol13 = "EFC14838";
        String DIA_4241 = "EFC14822";
        String studyName = "a study for diabetics";
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_MIG_4356A";
    //    String env = "STG";
        String zipCode = "19044";
        String facility_Code_STG = "625263";
        String facility_Code_PRD = "625640";
        
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


        //-----------------------------------zipCodePageOLS---------------------------------------------------------- 
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //----------------------------------genderPageOLS----------------------------------------------------------- 
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        //----------------------------------diagnosedAnyTypeOfDiabetesPageOLS----------------------------------------------------------- 
        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageOLS.getTitleText(),diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();//deleted protocol5 spec 43
        //debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7,protocol8,protocol9,protocol10,protocol11);
        debugPageOLS.checkProtocolsContainsForQNumber("QS4602", DIA_4241);
        debugPageOLS.back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        //-------------------------------------whatKindOfDiabetesPageOLS--------------------------------------------------------         
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageOLS.getTitleText(),whatKindOfDiabetesPageOLS.titleExpected, "Title is diff");
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
                TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageOLS());
                treatingYourDiabetesPageOLS.waitForPageLoad()
                .back();
                WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        //------------------------------------withType2DiabetesPageOLS--------------------------------------------------------- 
        withType2DiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageOLS.getTitleText(),withType2DiabetesPageOLS.titleExpected, "Title is diff");
		withType2DiabetesPageOLS.clickOnAnswer("Within the past 2 months")
                .clickNextButton(new TreatingYourDiabetesPageOLS());
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(treatingYourDiabetesPageOLS);

       //---------------------------------------treatingYourDiabetesPageOLS------------------------------------------------------ 
        treatingYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(treatingYourDiabetesPageOLS.getTitleText(),treatingYourDiabetesPageOLS.titleExpected, "Title is diff");
        //FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = treatingYourDiabetesPageOLS
        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = treatingYourDiabetesPageOLS
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());
        noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .back();
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(new NoOfAlcoholicDrinkOLS())
                .waitForPageLoad()
                .back();
        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageOLS());

        //---------------------------------------lastTimeYouTookPageOLS------------------------------------------------------ 
        lastTimeYouTookPageOLS
                .waitForPageLoad();
        Assert.assertEquals(lastTimeYouTookPageOLS.getTitleText(),lastTimeYouTookPageOLS.titleExpected, "Title is diff");
                //MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
        	lastTimeYouTookPageOLS.clickOnAnswer("2 - 3 months ago")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());
        		noOfAlcoholicDrinkOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4606",DIA_4241)
                .back();
                lastTimeYouTookPageOLS.waitForPageLoad();
                MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());

        //---------------------------------------metforminMedicationsPageOLS------------------------------------------------------ 
        metforminMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageOLS.getTitleText(),metforminMedicationsPageOLS.titleExpected, "Title is diff");
        ApartFromMetforminPageOLS apartFromMetforminPageOLS = metforminMedicationsPageOLS
                .clickOnAnswers("Janumet (metformin and sitagliptin)",
                        "Jentadueto (metformin and linagliptin)",
                        "Kazano (metformin and alogliptin)",
                        "Kombiglyze (metformin and saxagliptin)",
                        "PrandiMet (metformin and repaglinide)",
                        "Avandamet (metformin and rosiglitazone)")
                .clickNextButton(new ApartFromMetforminPageOLS());

        //---------------------------------------apartFromMetforminPageOLS------------------------------------------------------         
        apartFromMetforminPageOLS
                .waitForPageLoad();
        Assert.assertEquals(apartFromMetforminPageOLS.getTitleText(),apartFromMetforminPageOLS.titleExpected, "Title is diff");
        InsulinForYourDiabetesPageOLS insulinForYourDiabetesPageOLS = apartFromMetforminPageOLS
                .clickOnAnswers("Amaryl (glimepiride)",
                        "Avandia (rosiglitazone)",
                        "Chlorpropamide",
                        "Cycloset (bromocriptine)",
                        "Duetact (pioglitazone and glimepiride)")
                .clickNextButton(new InsulinForYourDiabetesPageOLS());


        //---------------------------------------insulinForYourDiabetesPageOLS------------------------------------------------------  
        insulinForYourDiabetesPageOLS
                .waitForPageLoad();
                //.getPage(debugPageOLS)
                //.checkProtocolsEquals(apartFromMetforminPageOLS.titleExpected, protocol6);
        Assert.assertEquals(insulinForYourDiabetesPageOLS.getTitleText(),insulinForYourDiabetesPageOLS.titleExpected, "Title is diff");
        SubquestionsHumalogPageOLS subquestionsHumalogPageOLS = insulinForYourDiabetesPageOLS
                .clickOnAnswers("Humalog","Humulin","Novolin","Novolog")
                .clickNextButton(new SubquestionsHumalogPageOLS());

        //---------------------------------------subquestionsHumalogPageOLS------------------------------------------------------  
        subquestionsHumalogPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(1),subquestionsHumalogPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(2),subquestionsHumalogPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(3),subquestionsHumalogPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(4),subquestionsHumalogPageOLS.titleExpected4, "Title is diff");
        //testing new SubQuestion answer feature
        subquestionsHumalogPageOLS
                .clickOnAnswersForSubQuestion(1,"Humalog Mix 50/50","Humalog Mix 75/25")
                .clickOnAnswersForSubQuestion(2,"Humulin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolin do you currently use?","Novolin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolog do you currently use?","Novolog Mix 70/30")
                .back();
        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());


        //---------------------------------------injectableMedicationsForYourDiabetesPageOLS------------------------------------------------------          
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageOLS.getTitleText(),injectableMedicationsForYourDiabetesPageOLS.titleExpected, "Title is diff");
        CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = injectableMedicationsForYourDiabetesPageOLS
                .clickOnAnswers("Adlyxin (lixisenatide)", "Another injectable medication not listed above")
                .clickNextButton(new CombinationWithEachOtherPageOLS());
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageOLS);

        //---------------------------------------combinationWithEachOtherPageOLS------------------------------------------------------ 
        combinationWithEachOtherPageOLS
                .waitForPageLoad();
        Assert.assertEquals(combinationWithEachOtherPageOLS.getTitleText(),combinationWithEachOtherPageOLS.titleExpected, "Title is diff");
        combinationWithEachOtherPageOLS
                .clickOnAnswer("1 month or less")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(noOfAlcoholicDrinkOLS);
        
       //---------------------------------------noOfAlcoholicDrinkOLS---------------
        noOfAlcoholicDrinkOLS
        		.waitForPageLoad();
        Assert.assertEquals(noOfAlcoholicDrinkOLS.getTitleText(),noOfAlcoholicDrinkOLS.titleExpected, "Title is diff");
        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
        		.setDrinks("4")
        		.clickNextButton(new LiverRelatedConditionOLS());
        		
        //---------------------------------------liverRelatedConditionOLS---------------
        liverRelatedConditionOLS
			.waitForPageLoad();
        Assert.assertEquals(liverRelatedConditionOLS.getTitleText(),liverRelatedConditionOLS.titleExpected, "Title is diff");
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new FollowingToLoseWeightPageOLS());        		
        		

        //---------------------------------------followingToLoseWeightPageOLS------------------------------------------------------ 
        followingToLoseWeightPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageOLS.getTitleText(),followingToLoseWeightPageOLS.titleExpected, "Title is diff");
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .clickOnAnswers("Prescription weight loss medication")
                .clickNextButton(new WeightLossSurgeryPageOLS());
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        followingToLoseWeightPageOLS
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(weightLossSurgeryPageOLS);

        //---------------------------------------weightLossSurgeryPageOLS------------------------------------------------------ 
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(),weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        //---------------------------------------procedureForWeightLossPageOLS------------------------------------------------------ 
        procedureForWeightLossPageOLS
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageOLS.getTitleText(),procedureForWeightLossPageOLS.titleExpected, "Title is diff");
		PoundsOrMorePageOLS poundsOrMorePageOLS = procedureForWeightLossPageOLS
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
		        poundsOrMorePageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected,DIA_4241)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
		        poundsOrMorePageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected,DIA_4241)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
                 poundsOrMorePageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected,DIA_4241)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(new PoundsOrMorePageOLS());
                poundsOrMorePageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected,DIA_4241)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(new PoundsOrMorePageOLS());

        //---------------------------------------PoundsOrMorePageOLS----------------------------------------------------- 
        poundsOrMorePageOLS
                .waitForPageLoad();
        		DoYouExperienceDPN_OLS doYouExperienceDPN_OLS = poundsOrMorePageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouExperienceDPN_OLS());
                
        //---------------------------------------doYouExperienceDPN_OLS----------------------------------------------------- 
        doYouExperienceDPN_OLS
                .waitForPageLoad();
        		 WhereDoYouExperienceDiabeticNervePain_OLS whereDoYouExperienceDiabeticNervePain_OLS = doYouExperienceDPN_OLS
                 .clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
                 .clickNextButton(new WhereDoYouExperienceDiabeticNervePain_OLS());

        		 
        //---------------------------------------WhereDoYouExperienceDiabeticNervePain_OLS----------------------------------------------------- 
        whereDoYouExperienceDiabeticNervePain_OLS
				.waitForPageLoad();
				 StatinMedicationsOnPageOLS statinMedicationsOnPageOLS = whereDoYouExperienceDiabeticNervePain_OLS
				.clickOnAnswers("None of the above")
				.clickNextButton(new StatinMedicationsOnPageOLS());

        //---------------------------------------statinMedicationsOnPageOLS------------------------------------------------------- 
        statinMedicationsOnPageOLS
                .waitForPageLoad();
        Assert.assertEquals(statinMedicationsOnPageOLS.getTitleText(),statinMedicationsOnPageOLS.titleExpected, "Title is diff");
        DiabeticNephropathyPageOLS diabeticNephropathyPageOLS = statinMedicationsOnPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new DiabeticNephropathyPageOLS());
        diabeticNephropathyPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals("One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is a ...", protocol7)
                .back();
        StatinMedicationPreviousQuestionPageOLS statinMedicationPreviousQuestionPageOLS = statinMedicationsOnPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin","Simcor (simvastatin and niacin)")
                .clickNextButton(new StatinMedicationPreviousQuestionPageOLS());

        //---------------------------------------statinMedicationPreviousQuestionPageOLS------------------------------------------------------ 
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad();
        Assert.assertEquals(statinMedicationPreviousQuestionPageOLS.getTitleText(),statinMedicationPreviousQuestionPageOLS.titleExpected, "Title is diff");
        statinMedicationPreviousQuestionPageOLS
                .clickOnAnswer("1 month or less")
                .clickNextButton(diabeticNephropathyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(diabeticNephropathyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 months")
                .clickNextButton(diabeticNephropathyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months - 11 months")
                .clickNextButton(diabeticNephropathyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(diabeticNephropathyPageOLS);

        //---------------------------------------diabeticNephropathyPageOLS------------------------------------------------------ 
        diabeticNephropathyPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diabeticNephropathyPageOLS.getTitleText(),diabeticNephropathyPageOLS.titleExpected, "Title is diff");
        ForYourKidneysPageOLS forYourKidneysPageOLS = diabeticNephropathyPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new ForYourKidneysPageOLS());
        forYourKidneysPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(diabeticNephropathyPageOLS.titleExpected, protocol12, protocol10)
                .back();
        diabeticNephropathyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ForYourKidneysPageOLS());

        //---------------------------------------forYourKidneysPageOLS------------------------------------------------------ 
        forYourKidneysPageOLS
                .waitForPageLoad();
        Assert.assertEquals(forYourKidneysPageOLS.getTitleText(),forYourKidneysPageOLS.titleExpected, "Title is diff");
        
        forYourKidneysPageOLS.clickOnAnswer("No")
        		.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals("Do you take medication for high blood pressure or for your kidneys? Some of these medications are ca...", protocol1)
                .back();
        forYourKidneysPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());



        //---------------------------------------GENERAL HEALTH------------------------------------------------------ 
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = new HaveYouEverExperiencedHeartRelatedMedicalCondOLS();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverExperiencedHeartRelatedMedicalCondOLS.getTitleText(),haveYouEverExperiencedHeartRelatedMedicalCondOLS.titleExpected, "Title is diff");
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .clickOnAnswers("Heart attack","Stroke","TIA or \"mini-stroke\"","Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1),subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2),subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(3),subquestionExperiencedHeartPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(4),subquestionExperiencedHeartPageOLS.titleExpected4, "Title is diff");
        HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"Less than 30 days ago")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS());
        haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4232",protocol12, protocol10)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"More than 1 year ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS);

        haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS.getTitleText(),haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS.titleExpected, "Title is diff");
        //CongestiveHeartFailurePageOLS congestiveHeartFailurePageOLS = haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        //**************************************************************************
        heartrelatedMedicalProceduresPageOLS
        .waitForPageLoad();
        Assert.assertEquals(heartrelatedMedicalProceduresPageOLS.getTitleText(),heartrelatedMedicalProceduresPageOLS.titleExpected, "Title is diff");
        heartrelatedMedicalProceduresPageOLS.clickOnAnswers("None of the above")
        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        
        
        
    //----------*******NEW GENERAL HEALTH Questions********----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        //---------- New for AMS1 Rel.51, when Gender = Female------------
        .clickNextButton(new HormonalBirthControlOLS())
        .waitForPageLoad()
        .clickOnAnswer("No")
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
        .clickNextButton(new IdentificationPageOLS())
		//----------PII (IdentificationPageOLS) Page--------------------
		.waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new SiteSelectionPageOLS())    
		//----------SiteSelection Page--------------------
        .waitForPageLoadAKC()
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new SynexusQualifiedClose4356PageOLS())

     //----------GladLocationIsConvenient Page--------------------
        .waitForPageLoad(env.equals("STG")? facility_Code_STG : facility_Code_PRD)
        .clickNextButton(new ThankYouCloseSimplePageOLS())

      //----------ThankYouCloseSimplePageOLS Page--------------------
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env)
		.getRadiantDbToLog(env)
		.getAnomalyDbToLog(env);
    }
}
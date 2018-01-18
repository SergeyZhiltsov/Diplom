package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
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
    @TestCaseId("00003")
    @Description("Diabetes_4356A_Synexus")
    public void tc003Test() {
        String phoneNumberLBP = "AUTAMS1DIA";
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
        String studyName = "a Diabetes"; //Diabetes study
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_MIG_4356A";
        String env = "STG";
        String zipCode = "19044";

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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();//deleted protocol5 spec 43
        //debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7,protocol8,protocol9,protocol10,protocol11);
        debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, DIA_4241);
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
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7,protocol8,protocol9,protocol10,protocol11)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7,protocol8,protocol9,protocol10,protocol11)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //.checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7,protocol8,protocol9,protocol10,protocol11)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, DIA_4241)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
                TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageOLS());
                treatingYourDiabetesPageOLS.waitForPageLoad();
                //.getPage(debugPageOLS)
                //.checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7,protocol8,protocol9,protocol10,protocol11)
                treatingYourDiabetesPageOLS.back();
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
                //.getPage(debugPageOLS)
                //.checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol4,protocol6,protocol7,protocol8,protocol9,protocol10,protocol11)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol4)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol4)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(treatingYourDiabetesPageOLS);

       //---------------------------------------treatingYourDiabetesPageOLS------------------------------------------------------ 
        treatingYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(treatingYourDiabetesPageOLS.getTitleText(),treatingYourDiabetesPageOLS.titleExpected, "Title is diff");
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = treatingYourDiabetesPageOLS
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new FollowingToLoseWeightPageOLS());
        followingToLoseWeightPageOLS
                .waitForPageLoad()
                //.getPage(debugPageOLS)//for protocol check I manually copied text from the question debug because the issue with debug questions
                //.checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol2, protocol3, protocol4, protocol6)
                .back();
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)// copy text from previous question until "..."(white space should be include)
                //.checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol2, protocol3, protocol4, protocol6)
                .back();
        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication")
                .clickNextButton(new LastTimeYouTookPageOLS());

        //---------------------------------------lastTimeYouTookPageOLS------------------------------------------------------ 
        lastTimeYouTookPageOLS
                .waitForPageLoad();
        Assert.assertEquals(lastTimeYouTookPageOLS.getTitleText(),lastTimeYouTookPageOLS.titleExpected, "Title is diff");
                MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
		 .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());
                 metforminMedicationsPageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, DIA_4241)
                .back();
                lastTimeYouTookPageOLS.waitForPageLoad()
                .clickOnAnswer("Unsure")
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
//                .clickOnAnswers("None of the above")
                .clickNextButton(new ApartFromMetforminPageOLS());
        /*apartFromMetforminPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(metforminMedicationsPageOLS.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(metforminMedicationsPageOLS.titleExpected, protocol6)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Metformin")
                .clickNextButton(apartFromMetforminPageOLS);*/

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
        /*insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(apartFromMetforminPageOLS.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral Medication Logic", protocol2,protocol3)
                .back();
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(insulinForYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral Medication Logic", protocol2,protocol3)
                .back();
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Farxiga (dapagliflozin)")
                .clickNextButton(insulinForYourDiabetesPageOLS);*/


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
                //.getPage(debugPageOLS)
                //.checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageOLS);

        //---------------------------------------combinationWithEachOtherPageOLS------------------------------------------------------ 
        combinationWithEachOtherPageOLS
                .waitForPageLoad();
                //.getPage(debugPageOLS)
                //.checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral and Injectable Medication Logic", protocol4);
        Assert.assertEquals(combinationWithEachOtherPageOLS.getTitleText(),combinationWithEachOtherPageOLS.titleExpected, "Title is diff");
        combinationWithEachOtherPageOLS
                .clickOnAnswer("1 month or less")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic",DIA_4241)
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(followingToLoseWeightPageOLS);

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
                StatinMedicationsOnPageOLS statinMedicationsOnPageOLS = poundsOrMorePageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new StatinMedicationsOnPageOLS());


        //---------------------------------------statinMedicationsOnPageOLS-----------$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$-------------------------------------------- 
        statinMedicationsOnPageOLS
                .waitForPageLoad();
        Assert.assertEquals(statinMedicationsOnPageOLS.getTitleText(),statinMedicationsOnPageOLS.titleExpected, "Title is diff");
        DiabeticNephropathyPageOLS diabeticNephropathyPageOLS = statinMedicationsOnPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new DiabeticNephropathyPageOLS());
        diabeticNephropathyPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is a ...", protocol7)
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
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(diabeticNephropathyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 months")
                .clickNextButton(diabeticNephropathyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
                .back();
        statinMedicationPreviousQuestionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months - 11 months")
                .clickNextButton(diabeticNephropathyPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Statin Medication Logic", protocol7)
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
                .checkProtocolsEquals(diabeticNephropathyPageOLS.titleExpected, protocol1, protocol12, protocol10)
                .back();
        diabeticNephropathyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(forYourKidneysPageOLS);

        //---------------------------------------forYourKidneysPageOLS------------------------------------------------------ 
        forYourKidneysPageOLS
                .waitForPageLoad();
        Assert.assertEquals(forYourKidneysPageOLS.getTitleText(),forYourKidneysPageOLS.titleExpected, "Title is diff");
        forYourKidneysPageOLS
                .clickOnAnswer("No")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Do you take medication for high blood pressure or for your kidneys? Some of these medications are ca...", protocol1)
                .back();
        forYourKidneysPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(hasHealthcareProfessionalPageOLS);



        //---------------------------------------GENERAL HEALTH------------------------------------------------------ 
        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        Assert.assertEquals(hasHealthcareProfessionalPageOLS.getTitleText(),hasHealthcareProfessionalPageOLS.titleExpected, "Title is diff");
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = hasHealthcareProfessionalPageOLS
                .clickOnAnswers("Heart Attack",
                        "Stroke",
                        "TIA or \"Mini-Stroke\"",
                        "Angina (heart-related chest pain) that required an overnight stay in a hospital")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1),subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2),subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(3),subquestionExperiencedHeartPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(4),subquestionExperiencedHeartPageOLS.titleExpected4, "Title is diff");
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("null",protocol6,protocol7,protocol1,protocol4,protocol3,protocol2,protocol8,protocol12,protocol11,protocol10)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad();
        Assert.assertEquals(heartrelatedMedicalProceduresPageOLS.getTitleText(),heartrelatedMedicalProceduresPageOLS.titleExpected, "Title is diff");
        CongestiveHeartFailurePageOLS congestiveHeartFailurePageOLS = heartrelatedMedicalProceduresPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new CongestiveHeartFailurePageOLS());
        congestiveHeartFailurePageOLS
                .waitForPageLoad()
                .back();
        HeartProceduresFromLastPageOLS heartProceduresFromLastPageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement")
                .clickNextButton(new HeartProceduresFromLastPageOLS());

        heartProceduresFromLastPageOLS
                .waitForPageLoad();
        Assert.assertEquals(heartProceduresFromLastPageOLS.getTitleText(),heartProceduresFromLastPageOLS.titleExpected, "Title is diff");
        heartProceduresFromLastPageOLS
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(congestiveHeartFailurePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)// there checkProtocolsEqualsForQNumber is used because to same questions in debug window
                .checkProtocolsEqualsForQNumber("QS4220", protocol6,protocol7,protocol1,protocol4,protocol3,protocol2,protocol8,protocol12,protocol11,protocol10)
                .back();
        heartProceduresFromLastPageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(congestiveHeartFailurePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4220", protocol6,protocol4,protocol3,protocol2)
                .back();
        heartProceduresFromLastPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(congestiveHeartFailurePageOLS);

		//----------CongestiveHeartFailurePageOLS (CHF) Page--------------------
		AffectingYourMetabolismPageOLS affectingYourMetabolismPageOLS = congestiveHeartFailurePageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new AffectingYourMetabolismPageOLS());

		//----------AffectingYourMetabolism Page--------------------
		ConditionsRelatedToYourDiabetesPageOLS conditionsRelatedToYourDiabetesPageOLS = affectingYourMetabolismPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ConditionsRelatedToYourDiabetesPageOLS());	

		//----------ConditionsRelatedToYourDiabetesPageOLS Page--------------------
		FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = conditionsRelatedToYourDiabetesPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new FollowingNeurologicalConditionsPageOLS());

		//----------NeurologicalConditions 'followingNeurologicalConditionsPageOLS' Page--------------------
		AffectYourLungsPageOLS affectYourLungsPageOLS = followingNeurologicalConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new AffectYourLungsPageOLS());

		//----------AffectYourLungs Page--------------------
		DigestiveConditionsPageOLS digestiveConditionsPageOLS = affectYourLungsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new DigestiveConditionsPageOLS());

		//----------DigestiveConditions Page--------------------
		BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = digestiveConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new BoneOrJointConditionsPageOLS());

/*		//----------BoneOrJointConditions Page--------------------
		BoneOrJointConditions boneOrJointConditions = boneOrJointConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new BoneOrJointConditions());*/

		//----------BoneOrJointConditions Page--------------------
		SleepRelatedConditionsPageOLS sleepRelatedConditionsPageOLS = boneOrJointConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SleepRelatedConditionsPageOLS());

		//----------SleepRelatedConditions Page--------------------
		SkinConditionsPageOLS skinConditionsPageOLS = sleepRelatedConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new SkinConditionsPageOLS());

		//----------SkinConditions Page--------------------
		ViralConditionsPageOLS viralConditionsPageOLS = skinConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ViralConditionsPageOLS());

		//----------ViralConditions Page--------------------
		MentalHealthPageOLS mentalHealthPageOLS = viralConditionsPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new MentalHealthPageOLS());

		//----------MentalHealthConditions Page--------------------
		WomensHealthPageOLS womensHealthPageOLS = mentalHealthPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new WomensHealthPageOLS());

		//----------WomenHealthConditions Page--------------------
		OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = womensHealthPageOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new OtherThanSkinCancerPageOLS());

		//----------Cancer Page--------------------
		SmokedCigarettesPageOLS smokedCigarettesPageOLS = otherThanSkinCancerPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new SmokedCigarettesPageOLS());

		//----------HaveYouSmokedCigarettes Page--------------------
		HistoryOfDrugPageOLS historyOfDrugPageOLS = smokedCigarettesPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No, I never smoked")
				.clickNextButton(new HistoryOfDrugPageOLS());


		//----------HistoryOfDrugPageOLS Page--------------------
		ProvideHeightWeight provideHeightWeight = historyOfDrugPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new ProvideHeightWeight());

		//----------ProvideHeight-Weight Page--------------------
		ChildrenUnderPageOLS childrenUnderPageOLS = provideHeightWeight
				.waitForPageLoad()
				.setFT("5")
				.setIN("5")
				.setWeight("155")
				.clickNextButton(new ChildrenUnderPageOLS());

		//----------ChildrenUnderTheAge Page--------------------
		TheStudySitePageOLS theStudySitePageOLS = childrenUnderPageOLS
				.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageOLS());

		//-------------------PEDIATRIC QUESTIONS-----------------------------
                //----"theStudySitePageOLS" page --  If you qualify for a study, how would you plan to travel to and from the study site?
				theStudySitePageOLS.waitForPageLoad()
                  .clickOnAnswer("Other")
                  .clickNextButton(new WhatMedicalCoveragePageOLS())

		//-----"WhatMedicalCoveragePageOLS" -  What sort of medical coverage do you have for your doctor visits, medication, surgery, and/or testing?-
                        .waitForPageLoad()
                        .clickOnAnswers("No, I have no coverage")
                        .clickNextButton(new EthnicBackgroundPageOLS())

               //----"EthnicBackgroundPageOLS" page --  Which of the following describes your ethnic background?
                        .waitForPageLoad()
                        .clickOnAnswers("Prefer not to answer")
                        .clickNextButton(new IdentificationPageOLS())

              //------------------PII (IdentificationPageOLS) Page-------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())

	          //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new SynexusQualifiedClose4356PageOLS())

             //----------GladLocationIsConvenient Page--------------------
                .waitForPageLoad("625263")
                .clickNextButton(new ThankYouCloseSimplePageOLS())

	          //----------ThankYouCloseSimplePageOLS Page--------------------
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
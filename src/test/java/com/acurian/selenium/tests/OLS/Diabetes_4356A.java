package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
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
        String phoneNumberLBP = "AUTAMS1HFL";
        List<String> protocols = Arrays.asList("EFC14835", "ITCA 650_CLP_203","K_877_302","17530","EFC13794","NN2211_4315","NN9535_4269");
        String protocol1 = "17530";
        String protocol2 = "NN9535_4269";
        String protocol3 = "NN2211_4315";
        String protocol4 = "EFC13794";
        String protocol5 = "EFC14835";
        String protocol6 = "ITCA 650_CLP_203";
        String protocol7 = "K_877_302";
        String studyName = "Diabetes";//Diabetes study
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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();//deleted protocol5 spec 43
        debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7);
//        Assert.assertEqualsNoOrder(debugPageOLS.getProtocolsForQuestion(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected).toArray(),protocols.toArray(), "Protocol(s) is diff");
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
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageOLS.getTitleText(),withType2DiabetesPageOLS.titleExpected, "Title is diff");
        TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = withType2DiabetesPageOLS
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new TreatingYourDiabetesPageOLS());
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol4,protocol6,protocol7)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol4)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol4)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(treatingYourDiabetesPageOLS);

        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new FollowingToLoseWeightPageOLS());
        followingToLoseWeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)//for protocol check I manually copied text from the question debug because the issue with debug questions
                .checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol2, protocol3, protocol4, protocol6)
                .back();
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)// copy text from previous question until "..."(white space should be include)
                .checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol2, protocol3, protocol4, protocol6)
                .back();
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication")
                .clickNextButton(new MetforminMedicationsPageOLS());

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
        apartFromMetforminPageOLS
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
                .clickNextButton(apartFromMetforminPageOLS);

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
        insulinForYourDiabetesPageOLS
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
                .clickNextButton(insulinForYourDiabetesPageOLS);

        insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(apartFromMetforminPageOLS.titleExpected, protocol6);
        Assert.assertEquals(insulinForYourDiabetesPageOLS.getTitleText(),insulinForYourDiabetesPageOLS.titleExpected, "Title is diff");
        SubquestionsHumalogPageOLS subquestionsHumalogPageOLS = insulinForYourDiabetesPageOLS
                .clickOnAnswers("Humalog","Humulin","Novolin","Novolog")
                .clickNextButton(new SubquestionsHumalogPageOLS());

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

        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageOLS.getTitleText(),injectableMedicationsForYourDiabetesPageOLS.titleExpected, "Title is diff");
        CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = injectableMedicationsForYourDiabetesPageOLS
                .clickOnAnswers("Adlyxin (lixisenatide)", "Another injectable medication not listed above")
                .clickNextButton(new CombinationWithEachOtherPageOLS());
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageOLS);

        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_4356A_Synexus Combination Oral and Injectable Medication Logic", protocol4);
        Assert.assertEquals(combinationWithEachOtherPageOLS.getTitleText(),combinationWithEachOtherPageOLS.titleExpected, "Title is diff");
        ToLoseWeightPageOLS toLoseWeightPageOLS = combinationWithEachOtherPageOLS
                .clickOnAnswer("1 month or less")
                .clickNextButton(new ToLoseWeightPageOLS());
        toLoseWeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(combinationWithEachOtherPageOLS.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(toLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(combinationWithEachOtherPageOLS.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(toLoseWeightPageOLS);

        toLoseWeightPageOLS
                .waitForPageLoad();
        Assert.assertEquals(toLoseWeightPageOLS.getTitleText(),toLoseWeightPageOLS.titleExpected, "Title is diff");
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = toLoseWeightPageOLS
                .clickOnAnswers("Prescription weight loss medication")
                .clickNextButton(new WeightLossSurgeryPageOLS());
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(toLoseWeightPageOLS.titleExpected, protocol2,protocol3,protocol4,protocol6)
                .back();
        toLoseWeightPageOLS
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(weightLossSurgeryPageOLS);

        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(),weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        procedureForWeightLossPageOLS
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageOLS.getTitleText(),procedureForWeightLossPageOLS.titleExpected, "Title is diff");
        StatinMedicationsOnPageOLS statinMedicationsOnPageOLS = procedureForWeightLossPageOLS
                .clickOnAnswer("Within the past 3 months")
                .clickNextButton(new StatinMedicationsOnPageOLS());
        statinMedicationsOnPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol4,protocol6)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(statinMedicationsOnPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol4,protocol6)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(statinMedicationsOnPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol4,protocol6)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(statinMedicationsOnPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol4,protocol6)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(statinMedicationsOnPageOLS);

        statinMedicationsOnPageOLS
                .waitForPageLoad();
        Assert.assertEquals(statinMedicationsOnPageOLS.getTitleText(),statinMedicationsOnPageOLS.titleExpected, "Title is diff");
        DiabeticNephropathyPageOLS diabeticNephropathyPageOLS = statinMedicationsOnPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new DiabeticNephropathyPageOLS());
        diabeticNephropathyPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(statinMedicationsOnPageOLS.titleExpected, protocol7)
                .back();
        StatinMedicationPreviousQuestionPageOLS statinMedicationPreviousQuestionPageOLS = statinMedicationsOnPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin","Simcor (simvastatin and niacin)")
                .clickNextButton(new StatinMedicationPreviousQuestionPageOLS());

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

        diabeticNephropathyPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diabeticNephropathyPageOLS.getTitleText(),diabeticNephropathyPageOLS.titleExpected, "Title is diff");
        ForYourKidneysPageOLS forYourKidneysPageOLS = diabeticNephropathyPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new ForYourKidneysPageOLS());
        forYourKidneysPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(diabeticNephropathyPageOLS.titleExpected, protocol1)
                .back();
        diabeticNephropathyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(forYourKidneysPageOLS);

        forYourKidneysPageOLS
                .waitForPageLoad();
        Assert.assertEquals(forYourKidneysPageOLS.getTitleText(),forYourKidneysPageOLS.titleExpected, "Title is diff");
        forYourKidneysPageOLS
                .clickOnAnswer("No")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Do you take medication for high blood pressure or for your kidneys? Some of these medications are ca", protocol1)
                .back();
        forYourKidneysPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(hasHealthcareProfessionalPageOLS);

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
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(5),subquestionExperiencedHeartPageOLS.titleExpected5, "Title is diff");
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"Yes")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("null", protocol1,protocol2,protocol3,protocol4,protocol6,protocol7)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"Yes")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("null", protocol1,protocol2,protocol3,protocol4,protocol6)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5,"5 years ago")
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
                .checkProtocolsEqualsForQNumber("QS4220", protocol1,protocol2,protocol3,protocol4,protocol6,protocol7)
                .back();
        heartProceduresFromLastPageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(congestiveHeartFailurePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4220", protocol2,protocol3,protocol4,protocol6)
                .back();
        heartProceduresFromLastPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(congestiveHeartFailurePageOLS);


        congestiveHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ConditionsRelatedToYourDiabetesPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SkinConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ViralConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new MentalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WomensHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SmokedCigarettesPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new ChildrenUnderPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new SynexusQualifiedClose4356PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(5000);



    }
}

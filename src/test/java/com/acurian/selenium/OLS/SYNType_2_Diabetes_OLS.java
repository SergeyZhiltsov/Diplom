package com.acurian.selenium.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ADG_4357.WithType1DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.DIA_4241.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.Vaccine.DirectSheduleVaccOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.cv_study.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;


public class SYNType_2_Diabetes_OLS extends BaseTest {


    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_DIABS_site},
        };
    }

    @Test(enabled = false, dataProvider = "sites")
    @Description("SYNType_2_Diabetes_OLS")
    public void SYNType_2_Diabetes_OLS(Site site) {
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String phoneNumber = "AUTAMS1DIA";
        String studyName = "a study for diabetics!";//"a NASH";
        //String studyName1 = "a fatty liver study for diabetics, a study for diabetics!";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a study for diabetics", "600");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle("a fatty liver study for diabetics", "750"),
//                "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .setDate("09091968")
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .back();

//        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4602", site.activeProtocols)
//                .back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        WithType1DiabetesPageOLS withType1DiabetesPageOLS = new WithType1DiabetesPageOLS();


//        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
//                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());
//        withType1DiabetesPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back();
//        whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("High blood sugar only")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back();
//
//        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
//        currentlyTreatingYourDiabetesPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = new CardiovascularDiseaseThanOthersPageOLS();
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = new CurrentlyTreatingYourDiabetesPageOLS();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS);

//        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = currentlyTreatingYourDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Diet and exercise")
//                .clickNextButton(new NoOfAlcoholicDrinkOLS());
//        noOfAlcoholicDrinkOLS
//                .waitForPageLoad()
//                .back();
//        currentlyTreatingYourDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("I am not currently treating my diabetes")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .back();
        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageOLS());

//        List<String> disqualify = Arrays.asList("2 - 3 months ago", "4 - 5 months ago", "6 months ago or longer");
//        for (String answer : disqualify) {
//            Log.info("Select answer for Q6: " + answer);
//            lastTimeYouTookPageOLS
//                    .waitForPageLoad()
//                    .clickOnAnswer("2 - 3 months ago")
//                    .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                    .waitForPageLoad()
//                    .back();
//        }
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());

        ApartFromMetforminPageOLS apartFromMetforminPageOLS = metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Metformin",
                        "Actoplus Met (metformin and pioglitazone)",
                        "Avandamet (metformin and rosiglitazone)",
                        "Fortamet (metformin)",
                        "Glucophage (metformin)",
                        "Glucovance (metformin and glyburide)",
                        "Glumetza (metformin)",
                        "Invokamet (metformin and canagliflozin)",
                        "Janumet (metformin and sitagliptin)",
                        "Jentadueto (metformin and linagliptin)",
                        "Kazano (metformin and alogliptin)",
                        "Kombiglyze (metformin and saxagliptin)",
                        "Metformin and glipizide",
                        "PrandiMet (metformin and repaglinide)",
                        "Synjardy (metformin and empagliflozin)",
                        "Xigduo (metformin and dapagliflozin)")
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApartFromMetforminPageOLS());

        CurrentlyTakeInsulinPageOLS currentlyTakeInsulinPageOLS =
                apartFromMetforminPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Actos (pioglitazone)",
                                "Amaryl (glimepiride)",
                                "Avandia (rosiglitazone)",
                                "Chlorpropamide",
                                "Cycloset (bromocriptine)",
                                "Duetact (pioglitazone and glimepiride)",
                                "Farxiga (dapagliflozin)",
                                "Glipizide XL, Glucotrol, or Glucotrol XL (glipizide)",
                                "Glynase (glyburide)",
                                "Glyset (miglitol)",
                                "Glyxambi (empagliflozin and linagliptin)",
                                "Invokana (canagliflozin)",
                                "Januvia (sitagliptin)",
                                "Jardiance (empagliflozin)",
                                "Nesina (alogliptin)",
                                "Onglyza (saxagliptin)",
                                "Oseni (alogliptin and pioglitazone)",
                                "Prandin (repaglinide)",
                                "Precose (acarbose)",
                                "Starlix (nateglinide)",
                                "Tradjenta (linagliptin)")
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new CurrentlyTakeInsulinPageOLS());

        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = currentlyTakeInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());

        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)",
                        "Bydureon or Byetta (exenatide)",
                        "Tanzeum (albiglutide)",
                        "Trulicity (dulaglutide)",
                        "Saxenda or Victoza (liraglutide)",
                        "SymlinPen (pramlintide)")
                .clickOnAnswers("None of the above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new TakeYourInsulinPageOLS());
//
//        takeYourInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Inhaled insulin (Afrezza)")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS);
//        injectableMedicationsForYourDiabetesPageOLS
//                .waitForPageLoad()
//                .back();
//        BrandsOfInsulinPageOLS brandsOfInsulinPageOLS = takeYourInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
//                .clickNextButton(new BrandsOfInsulinPageOLS());
//
//        brandsOfInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Insulin NPH (Humulin N, Novolin N)",
//                        "Insulin glargine (Basaglar, Lantus)",
//                        "Toujeo (Insulin glargine)",
//                        "Insulin detemir (Levemir)",
//                        "Insulin degludec (Tresiba)",
//                        "Insulin regular (Humulin R, Novolin R)",
//                        "Insulin lispro (Admelog, Humalog)",
//                        "Insulin aspart (Fiasp, Novolog)",
//                        "Insulin glulisine (Apidra)",
//                        "Mixed or pre-mixed insulin (Humalog Mix 50/50 or 75/25, Humulin 70/30, Novolin 70/30, Novolog Mix 70/30)")
//                .clickOnAnswers("None of the above")
//                .back();
//
//        TakeYourInsulinInjectionsPageOLS takeYourInsulinInjectionsPageOLS = takeYourInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Daily injections")
//                .clickNextButton(new TakeYourInsulinInjectionsPageOLS());
//
//        takeYourInsulinInjectionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
//                .clickNextButton(brandsOfInsulinPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS);
//
//
//        injectableMedicationsForYourDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
//                .clickOnAnswers("High cholesterol or high triglycerides")
//                .clickNextButton(new NoOfAlcoholicDrinkOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4636", site.activeProtocols)
//                .back(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new NoOfAlcoholicDrinkOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4636", site.activeProtocols)
//                .back(cardiovascularDiseaseThanOthersPageOLS)
                .clickOnAnswers("High cholesterol or high triglycerides", "High blood pressure or hypertension")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());

        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
                .waitForPageLoad()
//                .setDrinks("15")
//                .clickNextButton(new LiverRelatedConditionOLS());
//        liverRelatedConditionOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4623", site.activeProtocols)
//                .back();
//        noOfAlcoholicDrinkOLS
//                .waitForPageLoad()
                .setDrinks("14")
                .clickNextButton(new LiverRelatedConditionOLS());

//        List<String> options = Arrays.asList("Alcoholic liver disease",
//                "Autoimmune hepatitis, which is not the same as hepatitis caused by a virus",
////                "Hemochromatosis or iron overload ", "Liver cancer or hepatocellular carcinoma ", //this answer sometimes gives another pages (think because of cash)
//                "Primary sclerosing cholangitis or primary biliary cirrhosis", "Wilson's disease");
//        for (String answer : options) {
//            Log.info("Select answer for Q17: QS4624 " + answer);
//            liverRelatedConditionOLS
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(answer)
//                    .clickNextButton(new ToLoseWeightPageOLS())
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
//                    .back();
//        }
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageOLS());

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Prescription weight loss medication",
                        "Over-the-counter weight loss medication or supplements",
                        "Weight loss program such as Weight Watchers or Jenny Craig")
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass",
                        "Gastric sleeve or sleeve gastrectomy",
                        "Duodenal switch",
                        "Lap band or gastric banding",
                        "Gastric balloon")
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageOLS());

//        poundsOrMorePageOLS
//                .waitForPageLoad()
//                .back();
//
//        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Gastric bypass")
//                .clickNextButton(new ProcedureForWeightLossPageOLS());
//
//        List<String> disqualifyQ20 = Arrays.asList("Less than 3 months ago", "3 - 6 months ago", "7 - 11 months ago",
//                "1 - 2 years ago", "More than 2 years ago");
//        for (String answer: disqualifyQ20) {
//            Log.info("Select answer for Q20: " + answer);
//            procedureForWeightLossPageOLS
//                    .waitForPageLoad()
//                    .clickOnAnswer("Less than 3 months ago")
//                    .clickNextButton(poundsOrMorePageOLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS4616", site.activeProtocols)
//                    .back();
//        }
//        procedureForWeightLossPageOLS
//                .waitForPageLoad()
//                .back();
//
//        weightLossSurgeryPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(poundsOrMorePageOLS);
//
//        poundsOrMorePageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4617", site.activeProtocols)
//                .back();
        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4,
//                        "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "1 - 3 months ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
//                .clickOnAnswer("Less than 30 days ago")
//                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
//                .back();
//        mostRecentHeartProcedurePageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("1 - 3 months ago")
//                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
//                .back();
//        mostRecentHeartProcedurePageOLS
//                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);

//        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
//                .clickOnAnswers("Bipolar disorder")
//                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
//        doAnyOftheFollowingAdditionalDiagnosesOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
//                .back();
//        following_mentalEmotionalHealthPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Schizophrenia")
//                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
//                .back();
//        following_mentalEmotionalHealthPageOLS
//                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();
//        doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//                .waitForPageLoad()
//                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();

        /*haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol, triglycerides, or lipids")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();*/
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                /*.clickOnAnswers("High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids")*/
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        /*doYouTakeAnyMedicationsToControlHighBloodPressureOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);*/

        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
//                doAnyOftheFollowingAdditionalDiagnosesOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Bipolar disorder")
//                .clickNextButton(new ApproximateHeightPageOLS());
//        approximateHeightPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
//                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Headaches (migraine, cluster, tension)", "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)", "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)", "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)", "Sleep problems (insomnia, sleep apnea, narcolepsy)", "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Men's health issues (prostate enlargement or BPH, low testosterone)")
                .clickNextButton(new WhatKindOfArthritisPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging",
                        "Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                        "Psoriatic Arthritis")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS())
                .waitForPageLoad()
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis","Gout","Low back pain","Osteoporosis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWithOLS())
                .waitForPageLoad()
                .clickOnAnswers("Asthma","Chronic cough","Chronic bronchitis","COPD","Emphysema")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Acid reflux, heartburn, or GERD (gastroesophageal reflux disease)", "Crohn's disease", "Ulcerative colitis", "Gastroparesis, or delayed gastric emptying",
                        "IBS, or irritable bowel syndrome")
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS())
                .waitForPageLoad()
                .clickOnAnswers("Migraine", "Cluster headache", "Tension headache")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS())
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA", "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                        "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs", "Heart bypass surgery or Coronary Artery Bypass Graft (CABG)",
                        "Any other surgery on the arteries in your legs, neck or heart")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Generalized anxiety disorder (GAD)","Major depressive disorder (MDD) or depression","Bipolar disorder","Schizophrenia")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS())
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease","Memory loss","Parkinson's disease","Multiple sclerosis (MS)","Seizure disorder, such as epilepsy","Fibromyalgia")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS())
                .waitForPageLoad()
                .clickOnAnswers("Eczema or atopic dermatitis")
                .clickOnAnswers("Psoriasis")
                .clickOnAnswers("Skin cancer")
                .clickNextButton(new WhichOfTheFollowingSleepRelatedConditionsDiagnosedOLS())
                .waitForPageLoad()
                .clickOnAnswers("Narcolepsy", "Sleep apnea", "Insomnia")
                .clickNextButton(new WhichOfTheFollowingMensHealthConditions_OLS())
                .waitForPageLoad()
                .clickOnAnswers("Enlarged prostate or BPH", "Low testosterone", "Overactive bladder (OAB)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
//        doAnyOftheFollowingAdditionalDiagnosesOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Schizophrenia")
//                .clickNextButton(approximateHeightPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
//                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


//        DigestiveConditionsAffectDiabetesPageOLS digestiveConditionsAffectDiabetesPageOLS = approximateHeightPageOLS
//                .waitForPageLoad()
//                .setAll("5", "5", "190") //BMI > 30
//                .clickNextButton(new DigestiveConditionsAffectDiabetesPageOLS());
//
//        SymptomsRegularlyOncePerWeekPageOLS symptomsRegularlyOncePerWeekPageOLS = digestiveConditionsAffectDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new SymptomsRegularlyOncePerWeekPageOLS());
//
//        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS = symptomsRegularlyOncePerWeekPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS());
//
//        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Unsure")
//                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());
//
//        cholesterolTriglyceridesLipidsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);
//
//        haveYouEverExperiencedHeartRelatedMedicalCondOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
//
//        AdditionalHeartRelatedConditionsPageOLS additionalHeartRelatedConditionsPageOLS =  heartrelatedMedicalProceduresPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS());
//
//        DoYouExperienceDPN_OLS doYouExperienceDPN_ols = additionalHeartRelatedConditionsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new DoYouExperienceDPN_OLS());
//
//        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_ols = doYouExperienceDPN_ols
//                .waitForPageLoad()
//                .clickOnAnswer("No, none of the above")
//                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());
//
//        TransitionStatementCVbeginPageOLS transitionStatementCVbeginPageOLS = doYouExperienceAnyOfFollowingSymptoms_ols
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new TransitionStatementCVbeginPageOLS());
//
//        ExperiencedAnyOfFollowingOLS experiencedAnyOfFollowingOLS = transitionStatementCVbeginPageOLS
//                .waitForPageLoad()
//                .clickNextButton(new ExperiencedAnyOfFollowingOLS());
//
//        HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_ols = experiencedAnyOfFollowingOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());
//
//        IdentificationPageOLS identificationPageOLS = hasDoctorEverDiagnosedYouWithLowTestosterone_ols
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new IdentificationPageOLS());


        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "190") //BMI > 30
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());


        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        siteSelectionPageOLS
                .waitForPageLoad1(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .waitForAnimation();

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();

        if (env.equals("PRD")) {
            siteSelectionPageOLS
//                .clickNextButton(new DirectSheduleVaccOLS())
//                .waitForPageLoad()

                    .clickNextButton(new QualifiedClose2PageOLS())
                    .waitForPageLoad()
//                .clickNextButton(new SynexusHealthyMindsPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No, I am not interested in receiving information");
//        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = identificationPageOLS
                    .clickNextButton(thankYouCloseSimplePageOLS);
        }

        if (env.equals("STG")) {

            siteSelectionPageOLS
                    .clickNextButton(new DirectSheduleVaccOLS())
                    .waitForPageLoadSTG()
                    .clickNextButton(new QualifiedClose2PageOLS())
                    .waitForPageLoad()
                    .clickNextButton(thankYouCloseSimplePageOLS);
        }

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo)
                .assertGeneratedFul(env, site)
                .queueSiteForFULCheck(site.name);
//        switch (site) {
//            case AUT_NASH4483_site: //1R
//                break;
//            case AUT_NASH4483S_site: //41C
//                aboutHealthPageOLS
//                        .getAnomalyDbToLog(env);
//                break;
//        }
    }
}


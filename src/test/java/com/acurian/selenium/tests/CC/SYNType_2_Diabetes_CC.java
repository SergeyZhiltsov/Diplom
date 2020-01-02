package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.DIA_4241.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.Vaccine.DirectSheduleVaccCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.MostRecentHeartRelatedSurgeryProcedurePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.tests.OLS.SYNType_2_Diabetes_OLS;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SYNType_2_Diabetes_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "sites", dataProviderClass = SYNType_2_Diabetes_OLS.class)
    public void SYNType_2_Diabetes_CC(Site site) {
        final String phoneNumber = "AUTAMS1DIA";
        final String studyName = "a study for diabetics"; //"a NASH study";
        final String indicationHistroyName = "diabetes";

        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a study for diabetics", "600");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle("a fatty liver study for diabetics", "750"), "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();


        GenderPageCC genderPageCC = dateOfBirthPageCC
                .waitForPageLoad("a study for diabetics", "600")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC())
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1960")
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = nonQRtransitionPageCC
                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4602", site.activeProtocols)
//                .back();
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .back();
        nonQRtransitionPageCC
                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        WithType1DiabetesPageCC withType1DiabetesPageCC = new WithType1DiabetesPageCC();
//        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = whatKindOfDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
//                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());
//        withType1DiabetesPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back(whatKindOfDiabetesPageCC)
//                .waitForPageLoad()
//                .clickOnAnswer("High blood sugar only")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back();
//
//        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());

        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = new CurrentlyTreatingYourDiabetesPageCC();
        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = new CardiovascularDiseaseThanOthersPageCC();
        WithType2DiabetesPageCC withType2DiabetesPageCC = new WithType2DiabetesPageCC();
//        WithType2DiabetesPageCC withType2DiabetesPageCC = currentlyTreatingYourDiabetesPageCC
//                .waitForPageLoad()
//                .back(whatKindOfDiabetesPageCC)
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC);
        LastTimeYouTookPageCC lastTimeYouTookPageCC = currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
//                .waitForPageLoad()
//                .clickOnAnswers("Diet and exercise")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);
//
//        LastTimeYouTookPageCC lastTimeYouTookPageCC = cardiovascularDiseaseThanOthersPageCC
//                .waitForPageLoad()
//                .back(currentlyTreatingYourDiabetesPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("I am not currently treating my diabetes")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .back(currentlyTreatingYourDiabetesPageCC)
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageCC());

//        List<String> disqualify = Arrays.asList("2 - 3 months ago", "4 - 5 months ago", "6 months ago or longer");
//        for (String answer : disqualify) {
//            System.out.println("Select answer for Q6: " + answer);
//            lastTimeYouTookPageCC
//                    .waitForPageLoad()
//                    .clickOnAnswer(answer)
//                    .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                    .waitForPageLoad()
//                    .back();
//        }
        MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageCC());

        ApartFromMetforminPageCC apartFromMetforminPageCC = metforminMedicationsPageCC
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
                .clickNextButton(new ApartFromMetforminPageCC());

        CurrentlyTakeInsulinPageCC currentlyTakeInsulinPageCC = apartFromMetforminPageCC
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
                .clickNextButton(new CurrentlyTakeInsulinPageCC());

        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = currentlyTakeInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());

        TakeYourInsulinPageCC takeYourInsulinPageCC = injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)",
                        "Bydureon or Byetta (exenatide)",
                        "Tanzeum (albiglutide)",
                        "Trulicity (dulaglutide)",
                        "Saxenda or Victoza (liraglutide)",
                        "SymlinPen (pramlintide)")
                .clickOnAnswers("None of the above")
                .back(currentlyTakeInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageCC());

        BrandsOfInsulinPageCC brandsOfInsulinPageCC = takeYourInsulinPageCC
                .waitForPageLoad()
//                .clickOnAnswers("Inhaled insulin (Afrezza)")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
//                .waitForPageLoad()
//                .back(takeYourInsulinPageCC)
//                .waitForPageLoad()
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickNextButton(new BrandsOfInsulinPageCC());

        TakeYourInsulinInjectionsPageCC takeYourInsulinInjectionsPageCC = brandsOfInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Insulin NPH, also known as Humulin N or Novolin N",
                        "Insulin glargine, Basaglar, or Lantus",
                        "Toujeo, aslo known as insulin glargine",
                        "Insulin detemir, also known as Levemir",
                        "Insulin degludec, also known as Tresiba",
                        "Insulin regular, also known as Humulin R or Novolin R",
                        "Insulin lispro, also known as Admelog or Humalog",
                        "Insulin aspart, also known as Fiasp or Novolog",
                        "Insulin glulisine, also known as Apidra",
                        "Mixed or pre-mixed insulin, which includes Humalog Mix 50/50 or 75/25, Humulin 70/30, " +
                                "Novolin 70/30, or Novolog Mix 70/30")
                .clickOnAnswers("None of the above")
                .back(takeYourInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickOnAnswers("Daily injections")
                .clickNextButton(new TakeYourInsulinInjectionsPageCC());

//        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = new CardiovascularDiseaseThanOthersPageCC();
        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = new NoOfAlcoholicDrinksCC();
        LiverRelatedConditionCC liverRelatedConditionCC = takeYourInsulinInjectionsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
                .clickNextButton(brandsOfInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .clickOnAnswers("High blood pressure or hypertension")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(noOfAlcoholicDrinksCC)
//                .setDrinks("11")
//                .clickNextButton(new FollowingLiverRelatedConditionCC())
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4623", site.activeProtocols)
//                .back(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .setDrinks("10")
                .clickNextButton(new LiverRelatedConditionCC());


        /*ArrayList<String> conditions = new ArrayList<>();
        conditions.add("Alcoholic liver disease");
        conditions.add("Autoimmune hepatitis, which is not the same as hepatitis caused by a virus");
        conditions.add("Hemochromatosis or iron overload (Agent Note: he-mo-chrome-uh-TOE-sus)");
        conditions.add("Liver cancer or hepatocellular carcinoma (Agent Note: hih-pat-oh-CELL-u-lar car-sih-NO-ma)");
        conditions.add("Primary sclerosing cholangitis or primary biliary cirrhosis (Agent Note: scler-OH-sing, ko-lanj-EYE-tis, BILL-ee-air-ee)");
        conditions.add("Wilson's disease");
        for (String condition : conditions) {
            System.out.println("Select answer for Q17:QS4624 " + condition);
            followingLiverRelatedConditionCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(condition)
                    .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
                    .back();
        }*/

        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = liverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageCC());
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
                .waitForPageLoad()
                .clickOnAnswers("Prescription weight loss medication",
                        "Over-the-counter weight loss medication or supplements",
                        "Weight loss program such as Weight Watchers or Jenny Craig")
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());

        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass",
                        "Gastric sleeve or sleeve gastrectomy",
                        "Duodenal switch",
                        "Lap band or gastric banding",
                        "Gastric balloon")
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageCC());

        TransitionStatementCC transitionStatementCC = poundsOrMorePageCC
//                .waitForPageLoad()
//                .back(weightLossSurgeryPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Gastric bypass")
//                .clickNextButton(new ProcedureForWeightLossPageCC());
//
//
//        List<String> disqualifyQ20 = Arrays.asList("Less than 3 months ago", "3 - 6 months ago", "7 - 11 months ago",
//                "1 - 2 years ago", "More than 2 years ago");
//        for (String answer: disqualifyQ20) {
//            System.out.println("Select answer for Q20: " + answer);
//            procedureForWeightLossPageCC
//                    .waitForPageLoad()
//                    .clickOnAnswer(answer)
//                    .clickNextButton(poundsOrMorePageCC)
//                    .waitForPageLoad()
//                    .getPage(debugPageCC)
//                    .checkProtocolsContainsForQNumber("QS4616", site.activeProtocols)
//                    .back();
//        }
//        procedureForWeightLossPageCC
//                .waitForPageLoad()
//                .back();
//
//        weightLossSurgeryPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(poundsOrMorePageCC);
//
//        TransitionStatementCC transitionStatementCC = poundsOrMorePageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new TransitionStatementCC());
//        transitionStatementCC
//                .waitForPageLoad(indicationHistroyName)
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4617", site.activeProtocols)
//                .back();
//        poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());

                transitionStatementCC
                        .waitForPageLoad(indicationHistroyName)
                        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "1 - 3 months ago")
//                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();

        MostRecentHeartProcedurePageСС mostRecentHeartProcedurePageСС = subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageСС());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC();
//        ArrayList<String> heartProcedurePeriods = new ArrayList<>();
//        heartProcedurePeriods.add("Less than 30 days ago");
//        heartProcedurePeriods.add("1 - 3 months ago");
//        for (String period : heartProcedurePeriods) {
//            mostRecentHeartProcedurePageСС
//                    .waitForPageLoad()
//                    .clickOnAnswer(period)
//                    .clickNextButton(kidneyProblemsPage)
//                    .waitForPageLoad()
//                    .getPage(debugPageCC)
//                    .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
//                    .back();
//        }

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
//                .clickOnAnswers("Bipolar disorder")
//                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
//
//        doAnyOftheFollowingAdditionalDiagnosesCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
//                .back(followingMentalEmotionalHealthPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Schizophrenia")
//                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
//                .back(followingMentalEmotionalHealthPageCC)
//                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();
//        doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//                .waitForPageLoad()
//                .back();
        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .back();

        /*haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(new DoYouTakeAnyMedicationsToControlHighBloodPressureCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol, triglycerides, or lipids")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        DoYouTakeAnyMedicationsToControlHighBloodPressureCC doYouTakeAnyMedicationsToControlHighBloodPressureCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids")
                .clickNextButton(new DoYouTakeAnyMedicationsToControlHighBloodPressureCC());
        doYouTakeAnyMedicationsToControlHighBloodPressureCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);*/
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
//                .waitForPageLoad()
//                .clickOnAnswers("Bipolar disorder")
//                .clickNextButton(new ApproximateHeightPageCC());
//        approximateHeightPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
//                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Headaches (migraine, cluster, tension)", "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)", "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)", "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)", "Sleep problems (insomnia, sleep apnea, narcolepsy)", "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Men's health issues (prostate enlargement or BPH, low testosterone)")
                .clickNextButton(new WhatKindOfArthritisPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging",
                        "Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                        "Psoriatic Arthritis")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC())
                .waitForPageLoad()
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis","Gout","Low back pain","Osteoporosis")
                .clickNextButton(new WhichOfTheFollowingBreathingLungPageСС())
                .waitForPageLoad()
                .clickOnAnswers("Asthma","Chronic cough","Chronic bronchitis","COPD","Emphysema")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Acid reflux, heartburn, or GERD (gastroesophageal reflux disease)", "Crohn's disease", "Ulcerative colitis", "Gastroparesis, or delayed gastric emptying",
                        "IBS, or irritable bowel syndrome")
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetCC())
                .waitForPageLoad()
                .clickOnAnswers("Migraine", "Cluster headache", "Tension headache")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC())
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA", "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                        "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs", "Heart bypass surgery or Coronary Artery Bypass Graft (CABG)",
                        "Any other surgery on the arteries in your legs, neck or heart")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageCC())
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Generalized anxiety disorder (GAD)","Major depressive disorder (MDD) or depression","Bipolar disorder","Schizophrenia")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC())
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease","Memory loss","Parkinson's disease","Multiple sclerosis (MS)","Seizure disorder, such as epilepsy","Fibromyalgia")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС())
                .waitForPageLoad()
                .clickOnAnswers("Eczema or atopic dermatitis")
                .clickOnAnswers("Psoriasis")
                .clickOnAnswers("Skin cancer")
                .clickNextButton(new WhichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Narcolepsy", "Sleep apnea", "Insomnia")
                .clickNextButton(new FollowingMensHealthConditionsCC())
                .waitForPageLoad()
                .clickOnAnswers("Enlarged prostate or BPH", "Low testosterone", "Overactive bladder (OAB)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Schizophrenia")
//                .clickNextButton(approximateHeightPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
//                .back();
//        doAnyOftheFollowingAdditionalDiagnosesCC
//                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
//                .setAll("4", "9", "138")
//                .clickNextButton(new LetMeSeePageCC());
//
//        letMeSeePageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
//                .back();
//
//        approximateHeightPageCC
//                .waitForPageLoad()
                .setAll("4", "10", "180")
                .clickNextButton(new LetMeSeePageCC());

//        DigestiveConditionsAffectDiabetesPageCC digestiveConditionsAffectDiabetesPageCC = letMeSeePageCC
//                .waitForPageLoad()
//                .clickNextButton(new DigestiveConditionsAffectDiabetesPageCC());
//
//        SymptomsRegularlyOncePerWeekPageCC symptomsRegularlyOncePerWeekPageCC = digestiveConditionsAffectDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new SymptomsRegularlyOncePerWeekPageCC());
//
//        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC = symptomsRegularlyOncePerWeekPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC());
//
//        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC = haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Unsure")
//                .clickNextButton(new CholesterolTriglyceridesLipidsPageCC());
//
//        cholesterolTriglyceridesLipidsPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);
//
//        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
//
//        AdditionalHeartRelatedConditionsPageCC additionalHeartRelatedConditionsPageCC =  heartrelatedMedicalProceduresPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AdditionalHeartRelatedConditionsPageCC());
//
//        IdentificationPageCC identificationPageCC = additionalHeartRelatedConditionsPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new IdentificationPageCC());

//        DoYouExperienceAnyOfFollowingSymptoms_CC doYouExperienceAnyOfFollowingSymptoms_CC = doYouExperienceDPN_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No, none of the above")
//                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_CC());
//
//        TransitionStatementCVbeginPageCC transitionStatementCVbeginPageCC = doYouExperienceAnyOfFollowingSymptoms_CC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new TransitionStatementCVbeginPageCC());
//
//        ExperiencedAnyOfFollowingCC experiencedAnyOfFollowingCC = transitionStatementCVbeginPageCC
//                .waitForPageLoad()
//                .clickNextButton(new ExperiencedAnyOfFollowingCC());
//
//        HasDoctorEverDiagnosedYouWithLowTestosterone_CC hasDoctorEverDiagnosedYouWithLowTestosterone_CC = experiencedAnyOfFollowingCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_CC());
//
//        IdentificationPageCC identificationPageCC = hasDoctorEverDiagnosedYouWithLowTestosterone_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new IdentificationPageCC());

        SiteSelectionPageCC siteSelectionPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS912", site.activeProtocols)
                .back(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS913", site.activeProtocols)
                .back(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());
        switch (site) {
//            case AUT_NASH4483_site: //1R
//                siteSelectionPageCC
//                        .waitForPageLoad(studyName)
//                        .getPID()
//                        .clickOnAnswer(site.name)
//                        .clickNextButton(new QualifiedClose1PageCC())
//                        .waitForPageLoad()
//                        // .clickOnAnswer("No")
////                    .clickNextButton(new SynexusHealthyMindsPageCC())
////                    .waitForPageLoad()
////                    .clickOnAnswer("No")
//                        .clickNextButton(new ThankYouCloseSimplePageCC())
//                        .waitForPageLoad3()
//                        .clickNextButton(new AlzheimerClosePageCC())
//                        .waitForPageLoad()
//                        .clickNextButton(selectActionPageCC)
//                        .waitForPageLoad()
//                        .pidFromDbToLog(env)
//                        .getRadiantDbToLog(env)
//                        .childPidFromDbToLog(env, "4483")
//                        .assertGeneratedFul(env, site)
//                        .dispoShouldMatch(site.dispo, site.dispo);
//                break;
            case AUT_AMS1_DIABS_site: //41C
                siteSelectionPageCC
                        .waitForPageLoad(studyName)
                        .getPID()
                        .clickOnAnswer(site.name)
                        .clickNextButton(new DirectSheduleVaccCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .assertVariablesNew("Acurian", "Trial", "09/09/1960", "US",
                                "Chandler, AZ", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", " 010110 : Synexus - 010110 ", " East Valley Family Physicians", "AESXXXDIA001 - SYNType_2_Diabetes (SYNT2DM)")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
    }

}

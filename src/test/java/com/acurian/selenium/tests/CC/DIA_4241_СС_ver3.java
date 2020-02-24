package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.EverDiagnosedGastroparesisOrStomachEmptyingCC;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.DIA_4241.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.closes.CurrentlyParticipatingInStudy;
import com.acurian.selenium.pages.CC.closes.RequirePassDrugTest;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIA_4241_СС_ver3 extends BaseTest{

    @Test()
    @Description("Diabetes_4241 CC")
    public void dia4241ccTest() {
        Site site = Site.AUT_DIA_4241;
        String phoneNumber = "AUTAMS1DIA";
//        String protocol1 = "EFC14822";
        String protocol2 = "EFC14829";
        String protocol3 = "EFC14893";
        String protocol4 = "EFC15337";
//        String AKC = "ISIS 703802_CS2";
        String[] protocols = {protocol2, protocol3, protocol4};
        String studyName = "a study for diabetics";
        
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a study for diabetics", "600");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a study for diabetics", "600"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        DebugPageCC debugPageCC = new DebugPageCC();

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4602", protocols)
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        WithType1DiabetesPageCC withType1DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new  WithType1DiabetesPageCC());
        withType1DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back();
        EverDiagnosedGastroparesisOrStomachEmptyingCC everDiagnosedGastroparesisOrStomachEmptyingCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes")
                .clickNextButton(new EverDiagnosedGastroparesisOrStomachEmptyingCC());
        everDiagnosedGastroparesisOrStomachEmptyingCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back();
//        whatKindOfDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("High blood sugar only")
//                .clickNextButton(сardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4603", protocols)
//                .back();
        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());
        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4603", AKC)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4604", protocol2, protocol3)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4604", protocol2, protocol3)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC);

        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = new CardiovascularDiseaseThanOthersPageCC();
        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingCC);
        everDiagnosedGastroparesisOrStomachEmptyingCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS4631", protocols)
                .back();
        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS4631", protocols)
                .back();
        MetforminMedicationsPageCC metforminMedicationsPageCC = currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new MetforminMedicationsPageCC());

//        lastTimeYouTookPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("2 - 3 months ago")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("Q0018436-QS4632-STUDYQUES", protocols)
//                .back();
//        lastTimeYouTookPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("4 - 5 months ago")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4632", protocols)
//                .back();
//        lastTimeYouTookPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("6 months ago or longer")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4632", protocols)
//                .back();
//        MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Currently taking / have taken within the past month")
//                .clickNextButton(new MetforminMedicationsPageCC());
//
        ApartFromMetforminPageCC apartFromMetforminPageCC = new ApartFromMetforminPageCC();
//        metforminMedicationsPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, protocol1);
        HashMap<String, List<String>> options = new HashMap<>();
        options.put("Actoplus Met (metformin and pioglitazone)", Arrays.asList(protocol2, protocol4));
        options.put("Avandamet (metformin and rosiglitazone)", Arrays.asList(protocol2, protocol4));
        options.put("Glucovance (metformin and glyburide)", Arrays.asList(protocol2));
        options.put("Invokamet (metformin and canagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Janumet (metformin and sitagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Jentadueto (metformin and linagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Kazano (metformin and alogliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Kombiglyze (metformin and saxagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Metformin and glipizide", Arrays.asList(protocol2));
        options.put("PrandiMet (metformin and repaglinide)", Arrays.asList(protocol2, protocol4));
        options.put("Synjardy (metformin and empagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Xigduo (metformin and dapagliflozin)", Arrays.asList(protocol2, protocol4));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println("Select answer: " + entry.getKey());
            metforminMedicationsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(apartFromMetforminPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS4607", (String[]) entry.getValue().toArray())
                    .back();
        }
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(metforminMedicationsPageCC.titleExpected, protocol2, protocol4)
                .back();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")// done for some issue with not checking Metformin
                .clickOnAnswers("Metformin")
                .clickNextButton(apartFromMetforminPageCC);

        CurrentlyTakeInsulinPageCC currentlyTakeInsulinPageCC = new CurrentlyTakeInsulinPageCC();
        options.clear();
        options.put("Actos (pioglitazone)", Arrays.asList(protocol2, protocol4));
        options.put("Avandia (rosiglitazone)", Arrays.asList(protocol2, protocol4));
        options.put("Cycloset (bromocriptine)", Arrays.asList(protocol2, protocol4));
        options.put("Duetact (pioglitazone and glimepiride)", Arrays.asList(protocol2, protocol4));
        options.put("Farxiga (dapagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Glyset (miglitol)", Arrays.asList(protocol2, protocol4));
        options.put("Glyxambi (empagliflozin and linagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Invokana (canagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Januvia (sitagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Jardiance (empagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Nesina (alogliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Onglyza (saxagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Oseni (alogliptin and pioglitazone)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Prandin (repaglinide)", Arrays.asList(protocol2, protocol4));
        options.put("Precose (acarbose)", Arrays.asList(protocol2, protocol4));
        options.put("Starlix (nateglinide)", Arrays.asList(protocol2, protocol4));
        options.put("Tradjenta (linagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            apartFromMetforminPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(currentlyTakeInsulinPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsEquals(apartFromMetforminPageCC.titleExpected, (String[]) entry.getValue().toArray())
                    .back();
        }
        apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTakeInsulinPageCC);

        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = currentlyTakeInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4633", protocol3)
                .back();
        TakeYourInsulinPageCC takeYourInsulinPageCC = currentlyTakeInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageCC());

        takeYourInsulinPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4633", protocol2, protocol4)
                .getPage(takeYourInsulinPageCC)
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC);
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .back();
        BrandsOfInsulinPageCC brandsOfInsulinPageCC = takeYourInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickNextButton(new BrandsOfInsulinPageCC());
//        brandsOfInsulinPageCC
//                .waitForPageLoad()
//                .back();
//        TakeYourInsulinInjectionsPageCC takeYourInsulinInjectionsPageCC = takeYourInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Daily injections")
//                .clickNextButton(new TakeYourInsulinInjectionsPageCC());
//
//        takeYourInsulinInjectionsPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
//                .clickNextButton(brandsOfInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageCC);
//
//        injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Adlyxin (lixisenatide)")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4611", protocols)
//                .back();
//        injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Bydureon or Byetta (exenatide)")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4611", protocols)
//                .back();
//        injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Tanzeum (albiglutide)")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4611", protocols)
//                .back();
//        injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Trulicity (dulaglutide)")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4611", protocols)
//                .back();
//        injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4611", protocols)
//                .back();
//
//        injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .back();
//        brandsOfInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Toujeo, aslo known as insulin glargine")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4630", site.activeProtocols[1])
//                .back(brandsOfInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Insulin glargine, Basaglar, or Lantus")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageCC);
//
//        injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("SymlinPen (pramlintide)")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);
//
//        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = cardiovascularDiseaseThanOthersPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new NoOfAlcoholicDrinksCC());
//
//        LiverRelatedConditionCC liverRelatedConditionCC = noOfAlcoholicDrinksCC
//                .waitForPageLoad()
//                .setDrinks("4")
//                .clickNextButton(new LiverRelatedConditionCC());
//
//        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = liverRelatedConditionCC
//                .waitForPageLoad()
//                .clickOnAnswers("Alcoholic liver disease")
//                .clickNextButton(new FollowingToLoseWeightPageCC());
//
////        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
////                .waitForPageLoad()
////                .getPage(debugPageCC)
////                .checkProtocolsContainsForQNumber("QS4624", AKC)
////                .getPage(followingToLoseWeightPageCC)
////                .clickOnAnswers("No")
////                .clickNextButton(new WeightLossSurgeryPageCC());
//
//        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new PoundsOrMorePageCC());
//        poundsOrMorePageCC
//                .waitForPageLoad()
//                .back();
//        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Gastric bypass")
//                .clickNextButton(new ProcedureForWeightLossPageCC());
//
//        procedureForWeightLossPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Less than 3 months ago")
//                .clickNextButton(poundsOrMorePageCC);
//        poundsOrMorePageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4616", protocols)
//                .back();
//        procedureForWeightLossPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("3 - 6 months ago")
//                .clickNextButton(poundsOrMorePageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4616", protocol2, protocol3, protocol4 )
//                .back();
//        procedureForWeightLossPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("7 - 11 months ago")
//                .clickNextButton(poundsOrMorePageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4616", protocol2, protocol3, protocol4)
//                .back();
//        procedureForWeightLossPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("1 - 2 years ago")
//                .clickNextButton(poundsOrMorePageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4616", protocol2, protocol3, protocol4)
//                .back();
//        procedureForWeightLossPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("More than 2 years ago")
//                .clickNextButton(poundsOrMorePageCC);
//
//
//        TransitionStatementCC transitionStatementCC = poundsOrMorePageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new TransitionStatementCC());
//        transitionStatementCC
//                .waitForPageLoadDYS()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4617", protocols)
//                .back();
//        poundsOrMorePageCC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(transitionStatementCC);

        //Q13:QS4630
        brandsOfInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Toujeo, aslo known as insulin glargine")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4630", site.activeProtocols[1])
                .back(brandsOfInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .back();
        TakeYourInsulinInjectionsPageCC takeYourInsulinInjectionsPageCC = takeYourInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Daily injections")
                .clickNextButton(new TakeYourInsulinInjectionsPageCC());

        takeYourInsulinInjectionsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
                .clickNextButton(brandsOfInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC);

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(new WeightLossSurgeryPageCC());
        weightLossSurgeryPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, protocol3, protocol2, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bydureon or Byetta (exenatide)")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, protocol3, protocol2, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tanzeum (albiglutide)")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, protocol3, protocol2, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulicity (dulaglutide)")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, protocol3, protocol2, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, protocol3, protocol2, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("SymlinPen (pramlintide)")
                .clickNextButton(weightLossSurgeryPageCC);

        weightLossSurgeryPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, protocol2, protocol4)
                .checkProtocolsEqualsForQNumber("QS4613", protocol3)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .back();
        brandsOfInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Insulin glargine, Basaglar, or Lantus")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
                .waitForPageLoad()
                .clickNextButton(weightLossSurgeryPageCC);

//        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = cardiovascularDiseaseThanOthersPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new NoOfAlcoholicDrinkOLS());
//
//        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
//                .waitForPageLoad()
//                .setDrinks("4")
//                .clickNextButton(new LiverRelatedConditionOLS());
//
//        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Alcoholic liver disease")
//                .clickNextButton(new FollowingToLoseWeightPageOLS());
//
//        followingToLoseWeightPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4624", protocols)
//                .getPage(followingToLoseWeightPageOLS)
//                .clickOnAnswers("No")
//                .clickNextButton(weightLossSurgeryPageOLS);

        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageCC());
        poundsOrMorePageCC
                .waitForPageLoad()
                .back();
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageCC());
        poundsOrMorePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageCC);


        poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4617", protocols)
                .back();

        TransitionStatementCC transitionStatementCC = poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
        transitionStatementCC
                .waitForPageLoad("diabetes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
//                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyCC())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new NonQRtransitionPageCC())
//                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
        		.getPID()
        		.clickOnAnswer(site.name)
        		.clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .assertVariablesNew("Acurian", "Trial", "09/09/1980", "US",
                        "Dover, DE", site.zipCode, "qa.acurian@gmail.com", "999-999-9999",
                        env.equals("STG") ? " 010151 " : "TA4722S", site.name, "SANPPDDIA893 - Sanofi type 2 diabetes")
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")                
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .childPidFromDbToLog(env,"4241")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
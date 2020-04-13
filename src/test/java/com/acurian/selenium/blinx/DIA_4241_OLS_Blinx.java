package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;

import com.acurian.selenium.pages.blinx.ams.adg_4357.EverDiagnosedGastroparesisOrStomachEmptyingOLS;
import com.acurian.selenium.pages.blinx.ams.adg_4357.WithType1DiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.*;
import com.acurian.selenium.pages.blinx.ams.dpn_5096.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.lowt_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// v.3
public class DIA_4241_OLS_Blinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(DIA_4241_OLS_Blinx.class.getName());

    @Test()
    @Description("Diabetes 4241 OLS")
    public void dia4241olsTest() {
        Site site = Site.AUT_DIA_4241;
        String dquedStudyName = "a heart health study";
        String matchedStudyName = "a men’s health study";
        String phoneNumber = "AUTAMS1DIA";
        String protocol2 = "EFC14829";
        String protocol3 = "EFC14893";
        String protocol4 = "EFC15337";
//        String AKC = "ISIS 703802_CS2";
//        String[] protocols = {protocol2, AKC, protocol3, protocol4};
        String[] protocols = {protocol2, protocol3, protocol4};
        String studyName = "a diabetes";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad0("a study for diabetics", "600");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle("a study for diabetics", "600"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .waitForPageLoad0("a study for diabetics", "600")
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());

        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad0("a study for diabetics", "600")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("09091980")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4602", protocols)
                .back(diagnosedAnyTypeOfDiabetesPageOLS);

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        WithType1DiabetesPageOLS withType1DiabetesPageOLS = new WithType1DiabetesPageOLS();

        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());
        withType1DiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back(whatKindOfDiabetesPageOLS);

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes")
                .clickNextButton(new EverDiagnosedGastroparesisOrStomachEmptyingOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back(whatKindOfDiabetesPageOLS);

//        whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("High blood sugar only")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4603", protocols)
//                .back();

        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back(whatKindOfDiabetesPageOLS);

        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4604", protocol2, protocol3)
                .back(withType2DiabetesPageOLS);

        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4604", protocol2, protocol3)
                .back(withType2DiabetesPageOLS);

        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS);

        EverDiagnosedGastroparesisOrStomachEmptyingOLS everDiagnosedGastroparesisOrStomachEmptyingOLS = new EverDiagnosedGastroparesisOrStomachEmptyingOLS();

        DoYouExperienceDPN_OLS doYouExperienceDPN_ols = currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new DoYouExperienceDPN_OLS());
        doYouExperienceDPN_ols
                .waitForPageLoadNew()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4631", protocol2, protocol3, protocol4)
                .back(currentlyTreatingYourDiabetesPageOLS);

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(doYouExperienceDPN_ols)
                .waitForPageLoadNew()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4631", protocol2, protocol3, protocol4)
                .back(currentlyTreatingYourDiabetesPageOLS);

        MetforminMedicationsPageOLS metforminMedicationsPageOLS = currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
//                .clickNextButton(new LastTimeYouTookPageOLS());
//
//        lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("2 - 3 months ago")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocols)
//                .back();
//        lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("4 - 5 months ago")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocol2, protocol3, protocol4)
//                .back();
//        lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("6 months ago or longer")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocol2, protocol3, protocol4)
//                .back();
//        MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());

        ApartFromMetforminPageOLS apartFromMetforminPageOLS = new ApartFromMetforminPageOLS();
//        metforminMedicationsPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocol2);

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
            Log.info(entry.getKey());
            metforminMedicationsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(apartFromMetforminPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS4607", (String[]) entry.getValue().toArray())
                    .back(metforminMedicationsPageOLS);
        }
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4607", protocol2, protocol4)
                .back(metforminMedicationsPageOLS);

        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")// done for some issue with not checking Metformin
                //.clickOnAnswers("Metformin")
                .clickOnAnswers("Xigduo (metformin and dapagliflozin)")
                .clickNextButton(apartFromMetforminPageOLS);

        CurrentlyTakeInsulinPageOLS currentlyTakeInsulinPageOLS = new CurrentlyTakeInsulinPageOLS();
        options.clear();
        options.put("Actos (pioglitazone)", Arrays.asList(protocol2, protocol4));
        options.put("Avandia (rosiglitazone)", Arrays.asList(protocol2, protocol4));
        options.put("Cycloset (bromocriptine)", Arrays.asList(protocol2, protocol4));
        options.put("Duetact (pioglitazone and glimepiride)", Arrays.asList(protocol2, protocol4));
        options.put("Farxiga (dapagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Glyset (miglitol)", Arrays.asList(protocol2, protocol4));
        options.put("Glyxambi (empagliflozin and linagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Invokana (canagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Januvia (sitagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Jardiance (empagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Nesina (alogliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Onglyza (saxagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Oseni (alogliptin and pioglitazone)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Prandin (repaglinide)", Arrays.asList(protocol2, protocol4));
        options.put("Precose (acarbose)", Arrays.asList(protocol2, protocol4));
        options.put("Starlix (nateglinide)", Arrays.asList(protocol2, protocol4));
        options.put("Tradjenta (linagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            Log.info(entry.getKey());
            apartFromMetforminPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(currentlyTakeInsulinPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS4608", (String[]) entry.getValue().toArray())
                    .back(apartFromMetforminPageOLS);
        }
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTakeInsulinPageOLS);

        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = currentlyTakeInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4633", protocol3)
                .back(currentlyTakeInsulinPageOLS);

        TakeYourInsulinPageOLS takeYourInsulinPageOLS = currentlyTakeInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageOLS());

        takeYourInsulinPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4633", protocol2, protocol4)
                .getPage(takeYourInsulinPageOLS)
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS);
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .back(takeYourInsulinPageOLS);
        BrandsOfInsulinPageOLS brandsOfInsulinPageOLS = takeYourInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickNextButton(new BrandsOfInsulinPageOLS());

        //Q13:QS4630
        brandsOfInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Toujeo (Insulin glargine)")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4630", protocol3)
                .back(brandsOfInsulinPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .back(takeYourInsulinPageOLS);
        TakeYourInsulinInjectionsPageOLS takeYourInsulinInjectionsPageOLS = takeYourInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Daily injections")
                .clickNextButton(new TakeYourInsulinInjectionsPageOLS());

        takeYourInsulinInjectionsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
                .clickNextButton(brandsOfInsulinPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS);

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(new WeightLossSurgeryPageOLS());
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", protocol3, protocol2, protocol4)
                .back(injectableMedicationsForYourDiabetesPageOLS);
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bydureon or Byetta (exenatide)")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", protocol3, protocol2, protocol4)
                .back(injectableMedicationsForYourDiabetesPageOLS);
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tanzeum (albiglutide)")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", protocol3, protocol2, protocol4)
                .back(injectableMedicationsForYourDiabetesPageOLS);
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulicity (dulaglutide)")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", protocol3, protocol2, protocol4)
                .back(injectableMedicationsForYourDiabetesPageOLS);
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", protocol3, protocol2, protocol4)
                .back(injectableMedicationsForYourDiabetesPageOLS);
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("SymlinPen (pramlintide)")
                .clickNextButton(weightLossSurgeryPageOLS);

        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", protocol2, protocol4);
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4613", protocol3)
                .back(injectableMedicationsForYourDiabetesPageOLS);
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .back(brandsOfInsulinPageOLS);
        brandsOfInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Insulin glargine (Basaglar, Lantus)")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(weightLossSurgeryPageOLS);

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

//        PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new PoundsOrMorePageOLS());
//        poundsOrMorePageOLS
//                .waitForPageLoad()
//                .back(weightLossSurgeryPageOLS);
        PoundsOrMorePageOLS poundsOrMorePageOLS = new PoundsOrMorePageOLS();

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
        poundsOrMorePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back(procedureForWeightLossPageOLS);
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back(procedureForWeightLossPageOLS);
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back(procedureForWeightLossPageOLS);
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocols)
                .back(procedureForWeightLossPageOLS);
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageOLS);


        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(doYouExperienceDPN_ols)
                .waitForPageLoadNew()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4617", protocols)
                .back(poundsOrMorePageOLS);
        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        AboutHealthPageOLS aboutHealthPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")

                //issue that not fixed
//                .clickNextButton(takeYourInsulinPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("Daily injections", "Insulin pump, which delivers insulin continuously","Inhaled insulin (Afrezza)")
//                .clickNextButton(takeYourInsulinInjectionsPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
//                .clickNextButton(brandsOfInsulinPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("Insulin glargine (Basaglar, Lantus)")
//                .clickNextButton(new DyslipidemiaHealthcarePageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")

//                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoadNewPRD()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
                .clickNextButton(new SiteSelectionPageOLS())
                //.clickNextButton(new IncongruentSiteSelectionClose_OLS())
                //.waitForPageLoad(matchedStudyName, dquedStudyName)
                .waitForPageLoad("a study for diabetics!") // none! change after update
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .getRadiantDbToLog(env)
                    .getAnomalyDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.BrandsOfInsulinPageOLS;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DIA_4241.TakeYourInsulinInjectionsPageOLS;
import com.acurian.selenium.pages.OLS.DIA_4241.TakeYourInsulinPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIA_4241_OLS extends BaseTest {

    @Test
    @TestCaseId("00017")
    @Description("Diabetes_4241 OLS")
    public void dia4241olsTest() {
        String phoneNumberLBP = "AUTAMS1DIA";
        String protocol1 = "EFC14822";
        String protocol2 = "EFC14829";
        String protocol3 = "EFC14893";
        String protocol4 = "EFC15337";
        String AKC = "ISIS 703802_CS2";
        String[] protocols = {protocol1,protocol2,protocol3,protocol4,AKC};
        String studyName = "a diabetes";
        String siteName = "AUT_DIA_4241";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
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

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4602", protocols)
                .back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocols)
                .back();
        UseDietAndExercisePage useDietAndExercisePage = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new UseDietAndExercisePage());
        useDietAndExercisePage
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, AKC)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(useDietAndExercisePage)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol2,protocol3,protocol4)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(useDietAndExercisePage)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(withType2DiabetesPageOLS.titleExpected, protocol2,protocol3,protocol4)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(useDietAndExercisePage);

        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage());


        ApartFromMetforminPageOLS apartFromMetforminPageOLS = currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Medication other than Metformin or Insulin")
                .clickNextButton(new ApartFromMetforminPageOLS());
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(currentlyUseMetforminOrInsulinPage.titleExpected, protocol1)
                .back();
        TakeYourInsulinPageOLS takeYourInsulinPageOLS = currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickOnAnswers("Insulin")
                .clickNextButton(new TakeYourInsulinPageOLS());
        takeYourInsulinPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(currentlyUseMetforminOrInsulinPage.titleExpected, protocol1,protocol2,protocol4,AKC)
                .back();
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());
        anyPrescribedMedicationPage
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(currentlyUseMetforminOrInsulinPage.titleExpected, protocol2, protocol3, protocol4,AKC)
                .back();
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Metformin","Insulin","Medication other than Metformin or Insulin")
                .clickNextButton(new MetforminMedicationsPageOLS());

        HashMap<String, List<String>> options = new HashMap<>();
        options.put("Actoplus Met (metformin and pioglitazone)", Arrays.asList(AKC, protocol2, protocol4));
        options.put("Avandamet (metformin and rosiglitazone)", Arrays.asList(AKC, protocol2, protocol4));
        options.put("Glucovance (metformin and glyburide)", Arrays.asList(protocol2));
        options.put("Invokamet (metformin and canagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Janumet (metformin and sitagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Jentadueto (metformin and linagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Kazano (metformin and alogliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Kombiglyze (metformin and saxagliptin)", Arrays.asList(protocol2, protocol3, protocol4));
        options.put("Metformin and glipizide", Arrays.asList(protocol2));
        options.put("PrandiMet (metformin and repaglinide)", Arrays.asList(protocol2,protocol4));
        options.put("Synjardy (metformin and empagliflozin)", Arrays.asList(protocol2, protocol4));
        options.put("Xigduo (metformin and dapagliflozin)", Arrays.asList(protocol2, protocol4));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            metforminMedicationsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(apartFromMetforminPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsEquals(metforminMedicationsPageOLS.titleExpected, (String[]) entry.getValue().toArray())
                    .back();
        }
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(metforminMedicationsPageOLS.titleExpected, protocol2, protocol4)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Metformin")
                .clickNextButton(apartFromMetforminPageOLS);

        options.clear();
        options.put("Actos (pioglitazone)", Arrays.asList(AKC,protocol2, protocol4));
        options.put("Avandia (rosiglitazone)", Arrays.asList(AKC,protocol2,protocol4));
        options.put("Cycloset (bromocriptine)", Arrays.asList(protocol2,protocol4));
        options.put("Duetact (pioglitazone and glimepiride)", Arrays.asList(AKC,protocol2, protocol4));
        options.put("Farxiga (dapagliflozin)", Arrays.asList(protocol2,protocol4));
        options.put("Glyset (miglitol)", Arrays.asList(protocol2,protocol4));
        options.put("Glyxambi (empagliflozin and linagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Invokana (canagliflozin)", Arrays.asList(protocol2,protocol4));
        options.put("Januvia (sitagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Jardiance (empagliflozin)", Arrays.asList(protocol2,protocol4));
        options.put("Nesina (alogliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Onglyza (saxagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        options.put("Oseni (alogliptin and pioglitazone)", Arrays.asList(protocol2,AKC, protocol3, protocol4));
        options.put("Prandin (repaglinide)", Arrays.asList(protocol2,protocol4));
        options.put("Precose (acarbose)", Arrays.asList(protocol2,protocol4));
        options.put("Starlix (nateglinide)", Arrays.asList(protocol2,protocol4));
        options.put("Tradjenta (linagliptin)", Arrays.asList(protocol2,protocol3, protocol4));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            apartFromMetforminPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(takeYourInsulinPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsEquals(apartFromMetforminPageOLS.titleExpected, (String[]) entry.getValue().toArray())
                    .back();
        }
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(takeYourInsulinPageOLS);

        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = takeYourInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .back();
        BrandsOfInsulinPageOLS brandsOfInsulinPageOLS = takeYourInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickNextButton(new BrandsOfInsulinPageOLS());
        brandsOfInsulinPageOLS
                .waitForPageLoad()
                .back();
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

        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = new NoOfAlcoholicDrinkOLS();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bydureon or Byetta (exenatide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tanzeum (albiglutide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulicity (dulaglutide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol4)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("SymlinPen (pramlintide)")
                .clickNextButton(noOfAlcoholicDrinkOLS);

        noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol4)
                .checkProtocolsEqualsForQNumber("QS4613", AKC, protocol3)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .back();
        brandsOfInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Insulin glargine (Basaglar, Lantus, Toujeo)")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS)
                .waitForPageLoad()
                .clickNextButton(noOfAlcoholicDrinkOLS);

        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .setDrinks("4")
                .clickNextButton(new LiverRelatedConditionOLS());

        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Alcoholic liver disease")
                .clickNextButton(new FollowingToLoseWeightPageOLS());

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(liverRelatedConditionOLS.titleExpected, AKC)
                .getPage(followingToLoseWeightPageOLS)
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageOLS());
        poundsOrMorePageOLS
                .waitForPageLoad()
                .back();
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
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocol1, protocol2, protocol3, protocol4)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616",  protocol1, protocol2, protocol3, protocol4)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616",  protocol1, protocol2, protocol3, protocol4)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageOLS);


        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4617", protocols)
                .back();
        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoadAKC()
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
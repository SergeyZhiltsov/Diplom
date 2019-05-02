package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ADG_4357.DigestiveConditionsAffectDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.ADG_4357.WithType1DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.DIA_4241.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIA_4241_OLS_ver3 extends BaseTest {

    @Test()
    @Description("Diabetes 4241 OLS")
    public void dia4241olsTest() {
        Site site = Site.AUT_DIA_4241;
        String dquedStudyName = "a heart health study";
        String matchedStudyName = "a men’s health study";
        String phoneNumber = "AUTAMS1DIA";
//        String protocol1 = "EFC14822";
        String protocol2 = "EFC14829";
        String protocol3 = "EFC14893";
//        String protocol4 = "EFC15337";
        String AKC = "ISIS 703802_CS2";
        String[] protocols = {protocol2, AKC, protocol3};
        String studyName = "a diabetes";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a study for diabetics", "750"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
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

        WithType1DiabetesPageOLS withType1DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageOLS());
        withType1DiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocols)
                .back();
        TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageOLS());
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", AKC)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4604", protocol2, protocol3)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4604", protocol2, protocol3)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(treatingYourDiabetesPageOLS);

        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());
        noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4631", AKC, protocol2, protocol3)
                .back();
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4631", AKC, protocol2, protocol3)
                .back();
        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageOLS());

        lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocols)
                .back();
        lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 months ago")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, AKC, protocol2, protocol3)
                .back();
        lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months ago or longer")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, AKC, protocol2, protocol3)
                .back();
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());

        ApartFromMetforminPageOLS apartFromMetforminPageOLS = new ApartFromMetforminPageOLS();
//        metforminMedicationsPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocol2);
        HashMap<String, List<String>> options = new HashMap<>();
        options.put("Actoplus Met (metformin and pioglitazone)", Arrays.asList(AKC, protocol2));
        options.put("Avandamet (metformin and rosiglitazone)", Arrays.asList(AKC, protocol2));
        options.put("Glucovance (metformin and glyburide)", Arrays.asList(protocol2));
        options.put("Invokamet (metformin and canagliflozin)", Arrays.asList(protocol2));
        options.put("Janumet (metformin and sitagliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Jentadueto (metformin and linagliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Kazano (metformin and alogliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Kombiglyze (metformin and saxagliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Metformin and glipizide", Arrays.asList(protocol2));
        options.put("PrandiMet (metformin and repaglinide)", Arrays.asList(protocol2));
        options.put("Synjardy (metformin and empagliflozin)", Arrays.asList(protocol2));
        options.put("Xigduo (metformin and dapagliflozin)", Arrays.asList(protocol2));
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
                .checkProtocolsEquals(metforminMedicationsPageOLS.titleExpected, protocol2)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")// done for some issue with not checking Metformin
                //.clickOnAnswers("Metformin")
                .clickOnAnswers("Xigduo (metformin and dapagliflozin)")
                .clickNextButton(apartFromMetforminPageOLS);

        CurrentlyTakeInsulinPageOLS currentlyTakeInsulinPageOLS = new CurrentlyTakeInsulinPageOLS();
        options.clear();
        options.put("Actos (pioglitazone)", Arrays.asList(AKC, protocol2));
        options.put("Avandia (rosiglitazone)", Arrays.asList(AKC, protocol2));
        options.put("Cycloset (bromocriptine)", Arrays.asList(protocol2));
        options.put("Duetact (pioglitazone and glimepiride)", Arrays.asList(AKC, protocol2));
        options.put("Farxiga (dapagliflozin)", Arrays.asList(protocol2));
        options.put("Glyset (miglitol)", Arrays.asList(protocol2));
        options.put("Glyxambi (empagliflozin and linagliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Invokana (canagliflozin)", Arrays.asList(protocol2));
        options.put("Januvia (sitagliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Jardiance (empagliflozin)", Arrays.asList(protocol2));
        options.put("Nesina (alogliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Onglyza (saxagliptin)", Arrays.asList(protocol2, protocol3));
        options.put("Oseni (alogliptin and pioglitazone)", Arrays.asList(protocol2, AKC, protocol3));
        options.put("Prandin (repaglinide)", Arrays.asList(protocol2));
        options.put("Precose (acarbose)", Arrays.asList(protocol2));
        options.put("Starlix (nateglinide)", Arrays.asList(protocol2));
        options.put("Tradjenta (linagliptin)", Arrays.asList(protocol2, protocol3));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            apartFromMetforminPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(currentlyTakeInsulinPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsEquals(apartFromMetforminPageOLS.titleExpected, (String[]) entry.getValue().toArray())
                    .back();
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
                .checkProtocolsEquals(currentlyTakeInsulinPageOLS.titleExpected, protocol3)
                .back();
        TakeYourInsulinPageOLS takeYourInsulinPageOLS = currentlyTakeInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageOLS());

        takeYourInsulinPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(currentlyTakeInsulinPageOLS.titleExpected, AKC, protocol2)
                .getPage(takeYourInsulinPageOLS)
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS);
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

        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bydureon or Byetta (exenatide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tanzeum (albiglutide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulicity (dulaglutide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
                .clickNextButton(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("SymlinPen (pramlintide)")
                .clickNextButton(noOfAlcoholicDrinkOLS);

        noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageOLS.titleExpected, AKC, protocol2)
                .checkProtocolsEqualsForQNumber("QS4613", protocol3)
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
                .checkProtocolsContainsForQNumber("QS4624", AKC)
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
                .checkProtocolsContainsForQNumber("QS4616", protocol2, protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocol2, protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocol2, protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageOLS);


        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DigestiveConditionsAffectDiabetesPageOLS())
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
//                .clickOnAnswers("Insulin glargine (Basaglar, Lantus, Toujeo)")
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
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                //.clickNextButton(new IncongruentSiteSelectionClose_OLS())
                //.waitForPageLoad(matchedStudyName, dquedStudyName)
                .waitForPageLoadAKC()
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .getAnomalyDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.*;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AKC_4691_OLS extends BaseTest {

    @Test
    @Description("Akcea 4691 OLS")
    public void Akc4691olsEmailAtPII() {
        Site site = Site.AUT_AKC4691_MR;
        String phoneNumber = "AUTAMS1AKC";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(),
                dateOfBirthPageOLS.getExpectedModifiedTitle("a study for people with diabetes and related health conditions", "750"), "Title is diff");

        //--------------DOB Question------------
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        //--------------ZIP_CODE Question------------
        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        //--------------GENDER Question------------
        genderPageOLS
                .waitForPageLoad();
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());


        //--------------Q2: Have you been diagnosed with any type of diabetes?------------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                diagnosedAnyTypeOfDiabetesPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4602", site.activeProtocols)
                .back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());


        //--------------Q3: What kind of diabetes do you have?------------
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());
        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
        currentlyTreatingYourDiabetesPageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());


        //--------------Q4: How long ago were you diagnosed with type 2 diabetes?------------
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new UseDietAndExercisePage());


        //--------------Q5: How are you currently treating your diabetes? -----------
        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinksOLS = currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());
        noOfAlcoholicDrinksOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4631", site.activeProtocols)
                .back();

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4631", site.activeProtocols)
                .back();

        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageOLS());

        //--------------Q6: When was the last time you took medication for your diabetes? -----------
        HashMap<String, List<String>> cases = new HashMap<>();
        cases.put("2 - 3 months ago", Arrays.asList(site.activeProtocols));
        cases.put("4 - 5 months ago", Arrays.asList(site.activeProtocols));
        cases.put("6 months ago or longer", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : cases.entrySet()) {
            lastTimeYouTookPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(noOfAlcoholicDrinksOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS4632", (String[]) entry.getValue().toArray())
                    .back();
        }
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());


        //--------------QX: Do you currently take any of the following oral (taken by mouth) metformin medications? -----------
//        currentlyUseMetforminOrInsulinPage
//                .waitForPageLoad();
//        Assert.assertEquals(currentlyUseMetforminOrInsulinPage.getTitleText(), currentlyUseMetforminOrInsulinPage.titleExpected, "Title is diff");
//        ApartFromMetforminPageOLS apartFromMetforminPageOLS = currentlyUseMetforminOrInsulinPage
//                .clickOnAnswers("Medication other than Metformin or Insulin")
//                .clickNextButton(new ApartFromMetforminPageOLS());
//        apartFromMetforminPageOLS.waitForPageLoad()
//                .back();
//        currentlyUseMetforminOrInsulinPage
//                .waitForPageLoad();
//        InsulinForYourDiabetesPageOLS currentlyTakeInsulinPageOLS = currentlyUseMetforminOrInsulinPage
//                .clickOnAnswers("Medication other than Metformin or Insulin") //Click to Uncheck this option
//                .clickOnAnswers("Insulin")
//                .clickNextButton(new InsulinForYourDiabetesPageOLS());
//        currentlyTakeInsulinPageOLS.waitForPageLoad()
//                .back();
//        currentlyUseMetforminOrInsulinPage
//                .waitForPageLoad();
//        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
//                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
//                .clickNextButton(new AnyPrescribedMedicationPage());
//        anyPrescribedMedicationPage.waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4626", protocol1)
//                .back();
//        currentlyUseMetforminOrInsulinPage
//                .waitForPageLoad();


        //----------Q7: Do you currently take any of the following oral (taken by mouth) metformin medications?
        metforminMedicationsPageOLS
                .waitForPageLoad();
        ApartFromMetforminPageOLS apartFromMetforminPageOLS = metforminMedicationsPageOLS
                .clickOnAnswers("Actoplus Met (metformin and pioglitazone)")
                .clickNextButton(new ApartFromMetforminPageOLS());
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4607", site.activeProtocols)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Avandamet (metformin and rosiglitazone)")
                .clickNextButton(apartFromMetforminPageOLS);
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4607", site.activeProtocols)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                //.clickOnAnswers("Metformin")
                .clickOnAnswers("Xigduo (metformin and dapagliflozin)")
                .clickNextButton(apartFromMetforminPageOLS);


        //----------Q8: Apart from metformin, what other oral (taken by mouth) medications do you currently take for your diabetes?  ----------
        CurrentlyTakeInsulinPageOLS currentlyTakeInsulinPageOLS = new CurrentlyTakeInsulinPageOLS();
        cases.clear();
        cases.put("Actos (pioglitazone)", Arrays.asList(site.activeProtocols));
        cases.put("Avandia (rosiglitazone)", Arrays.asList(site.activeProtocols));
        cases.put("Duetact (pioglitazone and glimepiride)", Arrays.asList(site.activeProtocols));
        cases.put("Oseni (alogliptin and pioglitazone)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : cases.entrySet()) {
            apartFromMetforminPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(currentlyTakeInsulinPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS4608", (String[]) entry.getValue().toArray())
                    .back();
        }
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Amaryl (glimepiride)")
                .clickNextButton(currentlyTakeInsulinPageOLS);

        //--------Q9:  Do you currently take insulin for your diabetes?
        TakeYourInsulinPageOLS takeYourInsulinPageOLS = currentlyTakeInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageOLS());

        //--------Q10:  How do you take your insulin?
        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = takeYourInsulinPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4633", site.activeProtocols)
                .getPage(takeYourInsulinPageOLS)
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());

        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .back();

        BrandsOfInsulinPageOLS brandsOfInsulinPageOLS = takeYourInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(new BrandsOfInsulinPageOLS());

        //--------Q12:  WWhich of the following types or brands of insulin do you currently take?
        brandsOfInsulinPageOLS
                .waitForPageLoad()
                .back();

        TakeYourInsulinInjectionsPageOLS takeYourInsulinInjectionsPageOLS = takeYourInsulinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Daily injections")
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickNextButton(new TakeYourInsulinInjectionsPageOLS());

        //--------Q11:  When do you take your insulin injections?
        takeYourInsulinInjectionsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
                .clickNextButton(brandsOfInsulinPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS)
                .waitForPageLoad()
                .back(brandsOfInsulinPageOLS)
                .waitForPageLoad()
                .back(takeYourInsulinInjectionsPageOLS)
                .waitForPageLoad()
                .back(takeYourInsulinPageOLS)
                .waitForPageLoad()
                .back(currentlyTakeInsulinPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(injectableMedicationsForYourDiabetesPageOLS);


//        //--------Q13:  Which of the following types or brands of insulin do you currently take?
//        currentlyTakeInsulinPageOLS
//                .waitForPageLoad();
//        Assert.assertEquals(currentlyTakeInsulinPageOLS.getTitleText(), currentlyTakeInsulinPageOLS.titleExpected, "Title is diff");
//        currentlyTakeInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Afrezza, which is inhaled insulin",
//                        "Apidra (insulin glulisine)",
//                        "Humalog",
//                        "Humulin",
//                        "Lantus or Toujeo (insulin glargine)",
//                        "Levemir (insulin detemir)",
//                        "Novolin",
//                        "Novolog")
//                .clickNextButton(new SubquestionsHumalogPageOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4609", protocol1)
//                .back();
//        currentlyTakeInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("I use insulin, but I am not sure what kind")
//                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4609", protocol1)
//                .back();
//        currentlyTakeInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());


        //-------Q12:  Do you currently take any of the following injectable medications for your diabetes?  --------
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bydureon or Byetta (exenatide)")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tanzeum (albiglutide)")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulicity (dulaglutide)")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("SymlinPen (pramlintide)")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Another injectable medication not listed above")
                .clickNextButton(noOfAlcoholicDrinksOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(noOfAlcoholicDrinksOLS);


//        //-------Q13:  Overall, how long have you been taking your current diabetes medication(s), either by themselves, or in combination with each other?  --------
//        combinationWithEachOtherPageOLS
//                .waitForPageLoad();
//        Assert.assertEquals(combinationWithEachOtherPageOLS.getTitleText(), combinationWithEachOtherPageOLS.titleExpected, "Title is diff");
//        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = combinationWithEachOtherPageOLS
//                .clickOnAnswer("1 month or less")
//                .clickNextButton(new NoOfAlcoholicDrinkOLS());


        //-------Q15:  About how many alcoholic drinks do you have in a typical week? --------
        noOfAlcoholicDrinksOLS
                .waitForPageLoad();
        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinksOLS
                .setDrinks("4")
                .clickNextButton(new LiverRelatedConditionOLS());


        //-------Q16:  Has a healthcare professional ever diagnosed you with any of the following liver-related conditions?--------
        liverRelatedConditionOLS
                .waitForPageLoad();
        liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Alcoholic liver disease")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);
        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
                .back();
        liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Autoimmune hepatitis, which is not the same as hepatitis caused by a virus")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
                .back();
        liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hemochromatosis or iron overload")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
                .back();
        liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Liver cancer or hepatocellular carcinoma")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
                .back();
        liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Primary sclerosing cholangitis or primary biliary cirrhosis")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
                .back();
        liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Wilson's disease")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4624", site.activeProtocols)
                .back();
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageOLS());


        //-------Q17:  Are you currently using any of the following to lose weight?--------
        followingToLoseWeightPageOLS
                .waitForPageLoad();
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageOLS());


        //-------Q18:  Have you ever had any of the following types of bariatric or weight loss surgery?--------
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageOLS());
        poundsOrMorePageOLS
                .waitForPageLoad()
                .back();
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());


        //-------Q19:  When was the last time that you had a surgery or medical procedure for weight loss?--------
        procedureForWeightLossPageOLS
                .waitForPageLoad();
        procedureForWeightLossPageOLS
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(poundsOrMorePageOLS);
        poundsOrMorePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", site.activeProtocols)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageOLS);


        //-------Q20:  Have you lost or gained 15 pounds or more in the past 3 months?--------
        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4617", site.activeProtocols)
                .back();
        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageOLS());
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
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
                .clickOnAnswers("Hepatitis C")
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
                .clickNextButton(approximateHeightPageOLS);

        DoYouExperienceDPN_OLS doYouExperienceDPN_OLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new DoYouExperienceDPN_OLS());
        doYouExperienceDPN_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .setIncheswithClear("9")
                .setLbs("240")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoadAKC()
                .getPID()
                //----------SITE Selection Page--------------------
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoadEmailNotProvided()
                .typeEmail("qa.acurian@gmail.com")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS());*/

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
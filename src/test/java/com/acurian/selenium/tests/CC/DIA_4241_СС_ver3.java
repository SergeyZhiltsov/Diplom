package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIA_4241_СС_ver3 extends BaseTest{

    @Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Diabetes_4241 CC")
    public void dia4241ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1DIA";
        String protocol1 = "EFC14822";
        String protocol2 = "EFC14829";
        String protocol3 = "EFC14893";
//        String protocol4 = "EFC15337";
        String AKC = "ISIS 703802_CS2";
        String[] protocols = {protocol1,protocol2,protocol3,AKC};
        String studyName = "a study for diabetics";
        String siteName = "AUT_DIA_4241";
        String debugSiteName = "";
        String zipCode = "19901";
        
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleDIA4241Expected, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
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
                .checkProtocolsContainsForQNumber("Q0005996-QS4602-STUDYQUES", protocols)
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocols)
                .back();
        TreatingYourDiabetesPageCC treatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageCC());
        treatingYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, AKC)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(treatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol2,protocol3)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(treatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol2,protocol3)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(treatingYourDiabetesPageCC);

        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new NoOfAlcoholicDrinksCC());
        noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0018438-QS4631-STUDYQUES", AKC, protocol2, protocol3)
                .back();
        treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0018438-QS4631-STUDYQUES", AKC, protocol2, protocol3)
                .back();
        LastTimeYouTookPageCC lastTimeYouTookPageCC = treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageCC());

        lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, protocols)
                .back();
        lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 months ago")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, AKC, protocol2, protocol3)
                .back();
        lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 months ago or longer")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, AKC, protocol2, protocol3)
                .back();
        MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageCC());

        ApartFromMetforminPageCC apartFromMetforminPageCC = new ApartFromMetforminPageCC();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, protocol1);
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
            metforminMedicationsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(apartFromMetforminPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsEquals(metforminMedicationsPageCC.titleExpected, (String[]) entry.getValue().toArray())
                    .back();
        }
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(metforminMedicationsPageCC.titleExpected, protocol2)
                .back();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")// done for some issue with not checking Metformin
                .clickOnAnswers("Metformin")
                .clickNextButton(apartFromMetforminPageCC);

        CurrentlyTakeInsulinPageCC currentlyTakeInsulinPageCC = new CurrentlyTakeInsulinPageCC();
        options.clear();
        options.put("Actos (pioglitazone)", Arrays.asList(AKC,protocol2));
        options.put("Avandia (rosiglitazone)", Arrays.asList(AKC,protocol2));
        options.put("Cycloset (bromocriptine)", Arrays.asList(protocol2));
        options.put("Duetact (pioglitazone and glimepiride)", Arrays.asList(AKC,protocol2));
        options.put("Farxiga (dapagliflozin)", Arrays.asList(protocol2));
        options.put("Glyset (miglitol)", Arrays.asList(protocol2));
        options.put("Glyxambi (empagliflozin and linagliptin)", Arrays.asList(protocol2,protocol3));
        options.put("Invokana (canagliflozin)", Arrays.asList(protocol2));
        options.put("Januvia (sitagliptin)", Arrays.asList(protocol2,protocol3));
        options.put("Jardiance (empagliflozin)", Arrays.asList(protocol2));
        options.put("Nesina (alogliptin)", Arrays.asList(protocol2,protocol3));
        options.put("Onglyza (saxagliptin)", Arrays.asList(protocol2,protocol3));
        options.put("Oseni (alogliptin and pioglitazone)", Arrays.asList(protocol2,AKC, protocol3));
        options.put("Prandin (repaglinide)", Arrays.asList(protocol2));
        options.put("Precose (acarbose)", Arrays.asList(protocol2));
        options.put("Starlix (nateglinide)", Arrays.asList(protocol2));
        options.put("Tradjenta (linagliptin)", Arrays.asList(protocol2,protocol3));
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
                .checkProtocolsEquals(currentlyTakeInsulinPageCC.titleExpected, protocol3)
                .back();
        TakeYourInsulinPageCC takeYourInsulinPageCC = currentlyTakeInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageCC());

        takeYourInsulinPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(currentlyTakeInsulinPageCC.titleExpected, AKC, protocol2)
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
        brandsOfInsulinPageCC
                .waitForPageLoad()
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

        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bydureon or Byetta (exenatide)")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tanzeum (albiglutide)")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulicity (dulaglutide)")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, AKC, protocol3, protocol2)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("SymlinPen (pramlintide)")
                .clickNextButton(noOfAlcoholicDrinksCC);

        noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(injectableMedicationsForYourDiabetesPageCC.titleExpected, AKC, protocol2)
                .checkProtocolsEqualsForQNumber("Q0013991-QS4613-STUDYQUES", protocol3)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .back();
        brandsOfInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Insulin glargine, also known as Basaglar, Lantus, or Toujeo")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
                .waitForPageLoad()
                .clickNextButton(noOfAlcoholicDrinksCC);

        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .setDrinks("4")
                .clickNextButton(new FollowingLiverRelatedConditionCC());

        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("Alcoholic liver disease")
                .clickNextButton(new FollowingToLoseWeightPageCC());

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(followingLiverRelatedConditionCC.titleExpected, AKC)
                .getPage(followingToLoseWeightPageCC)
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());

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
                .clickNextButton(poundsOrMorePageCC);
        poundsOrMorePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES", protocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES", protocol1, protocol2, protocol3)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES",  protocol1, protocol2, protocol3)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS4616-STUDYQUES",  protocol1, protocol2, protocol3)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageCC);


        TransitionStatementCC transitionStatementCC = poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad("diabetes")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0013992-QS4617-STUDYQUES", protocols)
                .back();
        poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);

        transitionStatementCC
                .waitForPageLoad("diabetes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
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


                //issue that not fixed

                .clickNextButton(new DyslipidemiaHealthcarePageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")

//issue that not fixed
//                .clickNextButton(takeYourInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Daily injections", "Insulin pump, which delivers insulin continuously","Inhaled insulin (Afrezza)")
//                .clickNextButton(takeYourInsulinInjectionsPageCC)
//                .waitForPageLoad()
//                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
//                .clickNextButton(brandsOfInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Insulin glargine, also known as Basaglar, Lantus, or Toujeo")
//                .clickNextButton(new DyslipidemiaHealthcarePageCC())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageCC())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")


                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
        		.getPID()
        		.clickOnAnswer(siteName)
        		.clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")                
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);    
    }
}

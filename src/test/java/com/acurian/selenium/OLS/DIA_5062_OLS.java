package com.acurian.selenium.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.utils.Properties;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIA_5062_OLS extends BaseTest {

    @Test(enabled = true)
    @Description("NASH study 5062 OLS")
    public void dia5062olsTest() {
        String phoneNumber = "AUTAMSNASH";
        Site site = Site.AUT_NASH5062_site; //Synexus Site
        String studyName = "a fatty liver study for diabetics!";//"a NASH";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a fatty liver study for diabetics", "750");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle("a fatty liver study for diabetics", "750"),
//                "Title is diff");
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
                .waitForPageLoad()
                .setDate("09091968")
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
//                diagnosedAnyTypeOfDiabetesPageOLS
//                        .waitForPageLoad()
//                        .clickOnAnswer("No")
//                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
//        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4602", site.activeProtocols)
//                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WithType2DiabetesPageOLS());
//        WithType1DiabetesPageOLS withType1DiabetesPageOLS = new WithType1DiabetesPageOLS();
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
//                .clickOnAnswer("Pre-diabetes")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back();
//        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());
//        currentlyTreatingYourDiabetesPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = new WhatKindOfDiabetesPageOLS();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(withType2DiabetesPageOLS);

        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickOnAnswer("3 - 6 months ago")
                .clickOnAnswer("7 - 11 months ago")
                .clickOnAnswer("1 to less than 5 years ago")
                .clickOnAnswer("5 to less than 10 years ago")
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

//        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = new NoOfAlcoholicDrinkOLS();
//        currentlyTreatingYourDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Diet and exercise")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);
//        cardiovascularDiseaseThanOthersPageOLS
//                .waitForPageLoad()
//                .back();
//        currentlyTreatingYourDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("I am not currently treating my diabetes")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .back();
//        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = currentlyTreatingYourDiabetesPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
//                .clickNextButton(new LastTimeYouTookPageOLS());
//
//        lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("2 - 3 months ago")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .back();
//        lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("4 - 5 months ago")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .back();
//        lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("6 months ago or longer")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                .waitForPageLoad()
//                .back();
//        MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Currently taking / have taken within the past month")
//                .clickNextButton(new MetforminMedicationsPageOLS());
//
//        ApartFromMetforminPageOLS apartFromMetforminPageOLS = metforminMedicationsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new ApartFromMetforminPageOLS());
//
//        CurrentlyTakeInsulinPageOLS currentlyTakeInsulinPageOLS = apartFromMetforminPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new CurrentlyTakeInsulinPageOLS());
//
//        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = currentlyTakeInsulinPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());
//        injectableMedicationsForYourDiabetesPageOLS
//                .waitForPageLoad()
//                .back();
//        TakeYourInsulinPageOLS takeYourInsulinPageOLS = currentlyTakeInsulinPageOLS
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
//        brandsOfInsulinPageOLS
//                .waitForPageLoad()
//                .back();
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
//                .clickNextButton(noOfAlcoholicDrinkOLS);

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides", "High blood pressure or hypertension")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());

        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8506", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS);

//        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = liverBiopsyConfirmsNASHDiagnosisOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new NoOfAlcoholicDrinkOLS());

        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = new NoOfAlcoholicDrinkOLS();
        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
                .waitForPageLoad()
                .setDrinks("26")
                .clickNextButton(new LiverRelatedConditionOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8509", site.activeProtocols)
                .back(noOfAlcoholicDrinkOLS)
                .waitForPageLoad()
                .setDrinks("15")
                .clickNextButton(new LiverRelatedConditionOLS());

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS =
                new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS();
        HashMap<String, List<String>> options = new HashMap<>();
        options.put("Alcoholic liver disease", Arrays.asList(site.activeProtocols));
        options.put("Autoimmune hepatitis, which is not the same as hepatitis caused by a virus", Arrays.asList(site.activeProtocols));
//        options.put("Hemochromatosis or iron overload ", Arrays.asList(protocol1));
//        options.put("Liver cancer or hepatocellular carcinoma ", Arrays.asList(protocol1));
        options.put("Primary sclerosing cholangitis or primary biliary cirrhosis", Arrays.asList(site.activeProtocols));
        options.put("Wilson's disease", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            liverRelatedConditionOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(currentlyTreatingYourDiabetesPageOLS);
            currentlyTreatingYourDiabetesPageOLS
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS8510", (String[]) entry.getValue().toArray())
                    .back();
        }
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WeightLossSurgeryPageOLS());

//        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("No")
//                .clickNextButton(new WeightLossSurgeryPageOLS());

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
                .clickNextButton(poundsOrMorePageOLS);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        //"Heart or circulation problems (heart attack, heart failure, stroke)",
                        //"Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
//        haveYouEverExperiencedHeartRelatedMedicalCondOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
//                .back();
//        whenDiagnosedWithCancerOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Diagnosed with skin cancer only")
//                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);
//
//        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
//        heartrelatedMedicalProceduresPageOLS
//                .waitForPageLoad()
//                .back();
//        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
//                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
//                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
//
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
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
//
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
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
//
//        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Stent placement in your heart, neck or legs")
//                .clickNextButton(new MostRecentHeartProcedurePageOLS());
//
//        DoYouTakeAnyMedicationsToControlHighBloodPressureOLS doYouTakeAnyMedicationsToControlHighBloodPressureOLS = new DoYouTakeAnyMedicationsToControlHighBloodPressureOLS();
//        mostRecentHeartProcedurePageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Less than 30 days ago")
//                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
//                .back();
//        mostRecentHeartProcedurePageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("1 - 3 months ago")
//                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
//                .back();
//
//        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = mostRecentHeartProcedurePageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("7 - 12 months ago")
//                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
//
//       /* WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());*/
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS();
        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(followingMentalEmotionalHealthPageOLS);
//
//        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Cirrhosis")
//                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
//        following_mentalEmotionalHealthPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
//                .back();
//        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Unsure which type of liver disease")
//                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
//                .clickOnAnswers("High blood pressure or hypertension",
//                        "High cholesterol, triglycerides, or lipids")
//                .clickNextButton(doYouTakeAnyMedicationsToControlHighBloodPressureOLS)
//                .waitForPageLoad()
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
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
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("4", "9", "140") //BMI > 30
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad1(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
//                .clickNextButton(new SynexusHealthyMindsPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AlzheimerClosePageOLS())
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
                    .dispoShouldMatch(site.dispo, site.dispo)
                    .assertGeneratedFul(env, site)
                    .queueSiteForFULCheck(site.name);
        }
    }
}
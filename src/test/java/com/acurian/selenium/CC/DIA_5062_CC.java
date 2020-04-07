package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.IBD.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.closes.CurrentlyParticipatingInStudy;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.RequirePassDrugTest;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.cv_study.CholesterolTriglyceridesLipidsPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DIA_5062_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(DIA_5062_CC.class.getName());

    @Test()
    public void dia5062ccTest() {
        final String phoneNumber = "AUTAMSNASH";
        final String studyName = "a fatty liver study for diabetics"; //"a NASH study";
        final String indicationHistroyName = "diabetes";
        Site site = Site.AUT_NASH5062_site; //Synexus Site
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:",
                "Title text is diff");
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
                .waitForPageLoad("a fatty liver study for diabetics", "750");
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

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1960")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

//        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new NonQRtransitionPageCC());

//        nonQRtransitionPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4602", site.activeProtocols)
//                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        WithType2DiabetesPageCC withType2DiabetesPageCC = new WithType2DiabetesPageCC();
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
//                .clickOnAnswer("Pre-diabetes")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
//                .back();
//
////        whatKindOfDiabetesPageCC
////                .waitForPageLoad()
////                .clickOnAnswer("High blood sugar only")
////                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
////                .waitForPageLoad()
////                .getPage(debugPageCC)
////                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
////                .back();
//
//        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());
//
//        WithType2DiabetesPageCC withType2DiabetesPageCC = currentlyTreatingYourDiabetesPageCC
//                .waitForPageLoad()
//                .back(whatKindOfDiabetesPageCC)
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());


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
//                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
//                .clickNextButton(new LastTimeYouTookPageCC());
//
//        ArrayList<String> lastTimes = new ArrayList<>();
//        lastTimes.add("2 - 3 months ago");
//        lastTimes.add("4 - 5 months ago");
//        lastTimes.add("6 months ago or longer");
//        for (String lastTime : lastTimes) {
//            lastTimeYouTookPageCC
//                    .waitForPageLoad()
//                    .clickOnAnswer(lastTime)
//                    .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
//                    .waitForPageLoad()
//                    .back();
//        }
//        MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Currently taking / have taken within the past month")
//                .clickNextButton(new MetforminMedicationsPageCC());
//
//        ApartFromMetforminPageCC apartFromMetforminPageCC = metforminMedicationsPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new ApartFromMetforminPageCC());
//
//        CurrentlyTakeInsulinPageCC currentlyTakeInsulinPageCC = apartFromMetforminPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new CurrentlyTakeInsulinPageCC());
//
//        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = currentlyTakeInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());
//
//        TakeYourInsulinPageCC takeYourInsulinPageCC = injectableMedicationsForYourDiabetesPageCC
//                .waitForPageLoad()
//                .back(currentlyTakeInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new TakeYourInsulinPageCC());
//
//        BrandsOfInsulinPageCC brandsOfInsulinPageCC = takeYourInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Inhaled insulin (Afrezza)")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
//                .waitForPageLoad()
//                .back(takeYourInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Inhaled insulin (Afrezza)")
//                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
//                .clickNextButton(new BrandsOfInsulinPageCC());
//
//        TakeYourInsulinInjectionsPageCC takeYourInsulinInjectionsPageCC = brandsOfInsulinPageCC
//                .waitForPageLoad()
//                .back(takeYourInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
//                .clickOnAnswers("Daily injections")
//                .clickNextButton(new TakeYourInsulinInjectionsPageCC());
//
//        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = new NoOfAlcoholicDrinksCC();
//        LiverRelatedConditionCC liverRelatedConditionCC = takeYourInsulinInjectionsPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
//                .clickNextButton(brandsOfInsulinPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWith_liverDiseaseCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("High blood pressure or hypertension")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageCC());


        cholesterolTriglyceridesLipidsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8506", site.activeProtocols)
                .back();

        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NoOfAlcoholicDrinksCC());

//        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = liverBiopsyConfirmsNASHDiagnosisCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new NoOfAlcoholicDrinksCC());

        LiverRelatedConditionCC liverRelatedConditionCC = noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .setDrinks("15")
                .clickNextButton(new LiverRelatedConditionCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8509", site.activeProtocols)
                .back(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .setDrinks("14")
                .clickNextButton(new LiverRelatedConditionCC());

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC =
                new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC();
        ArrayList<String> conditions = new ArrayList<>();
        conditions.add("Alcoholic liver disease");
        conditions.add("Autoimmune hepatitis, which is not the same as hepatitis caused by a virus");
        conditions.add("Hemochromatosis or iron overload (Agent Note: he-mo-chrome-uh-TOE-sus)");
        conditions.add("Liver cancer or hepatocellular carcinoma (Agent Note: hih-pat-oh-CELL-u-lar car-sih-NO-ma)");
        conditions.add("Primary sclerosing cholangitis or primary biliary cirrhosis(Agent Note: scler-OH-sing, ko-lanj-EYE-tis, BILL-ee-air-ee)");
        conditions.add("Wilson's disease");
        for (String condition : conditions) {
            Log.info("Select answer for Q17:QS4624 " + condition);
            liverRelatedConditionCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(condition)
                    .clickNextButton(cholesterolTriglyceridesLipidsPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS8510", site.activeProtocols)
                    .back();
        }
//        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = liverRelatedConditionCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new FollowingToLoseWeightPageCC());
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = liverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WeightLossSurgeryPageCC());

        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new PoundsOrMorePageCC());

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = poundsOrMorePageCC
                .waitForPageLoad()
                .back(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        TransitionStatementCC transitionStatementCC = procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                transitionStatementCC
                        .waitForPageLoadDYS()
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        //"Heart or circulation problems (heart attack, heart failure, stroke)",
                        //"Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

//        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
//                .back(whenDiagnosedWithCancerCC)
//                .waitForPageLoad()
//                .clickOnAnswer("Diagnosed with skin cancer only")
//                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
//
//        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartrelatedMedicalProceduresPageCC
//                .waitForPageLoad()
//                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
//                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
//                .clickNextButton(new SubquestionExperiencedHeartPageCC());
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
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
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
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
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
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
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
//                .back();
//
//        subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
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
//                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
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
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
//                .back();
//
//        MostRecentHeartProcedurePageСС mostRecentHeartProcedurePageCC = subquestionExperiencedHeartPageCC
//                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
//                .clickNextButton(heartrelatedMedicalProceduresPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Stent placement in your heart, neck or legs")
//                .clickNextButton(new MostRecentHeartProcedurePageСС());
//
//        DoYouTakeAnyMedicationsControlHypertension_CC doYouTakeAnyMedicationsControlHypertension_cc = new DoYouTakeAnyMedicationsControlHypertension_CC();
//        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC();
//        ArrayList<String> heartProcedurePeriods = new ArrayList<>();
//        heartProcedurePeriods.add("Less than 30 days ago");
//        heartProcedurePeriods.add("1 - 3 months ago");
//        for (String period : heartProcedurePeriods) {
//            mostRecentHeartProcedurePageCC
//                    .waitForPageLoad()
//                    .clickOnAnswer(period)
//                    .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC())
//                    .waitForPageLoad()
//                    .getPage(debugPageCC)
//                    .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
//                    .back();
//        }
//
//        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = mostRecentHeartProcedurePageCC
//                .waitForPageLoad()
//                .clickOnAnswer("More than 1 year ago")
//                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC();
        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC = new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

//        followingMentalEmotionalHealthPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Cirrhosis")
//                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

//        followingMentalEmotionalHealthPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS43", site.activeProtocols)
//                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Unsure which type of liver disease")
//                .clickNextButton(followingMentalEmotionalHealthPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ArrayList<String> additionalDiagnoses = new ArrayList<>();
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        additionalDiagnoses.add("Drug or alcohol abuse within the past year");
        additionalDiagnoses.add("Hepatitis B");
        additionalDiagnoses.add("HIV or AIDS");
        for (String diagnose : additionalDiagnoses) {
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }

        LetMeSeePageCC letMeSeePageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("4", "9", "138")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back();

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("4", "10", "180")
                .clickNextButton(letMeSeePageCC);

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoad()
                .assertVariablesNew("Acurian", "Trial", "09/09/1960", "US",
                        "Dover, DE", site.zipCode, "qa.acurian@gmail.com", "999-999-9999",
                        "12345a", site.name, "ALLSYHNAH002 - Allergan NASH")
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();
        if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .getRadiantDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo)
                    .queueSiteForFULCheck(site.name);
        }
    }
}

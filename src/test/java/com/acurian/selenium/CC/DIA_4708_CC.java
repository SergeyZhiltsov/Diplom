package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.DIA_4241.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DIA_4708_CC extends BaseTest {

    @Test(enabled = false) //Deactivate 4708 Enanta NASH (all protocols: EDP 305-101) R72	72.2	02-May-19
    public void dia4708cc() {
        Site site = Site.AUT_NASH4708_site;
        final String phoneNumber = "AUTAMSNASH";
        final String studyName = "a fatty liver study for diabetics";
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a fatty liver study for diabetics", "1,550");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a fatty liver study for diabetics", "1,550"), "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("2005")
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back();

        GenderPageCC genderPageCC = dateOfBirthPageCC
        //        .waitForPageLoad()
                .setYear("1960")
                .clickNextButton(zipCodePageCC)
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005996-QS4602-STUDYQUES", site.activeProtocols)
                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        WithType1DiabetesPageCC withType1DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageCC());

        withType1DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", site.activeProtocols)
                .back();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", site.activeProtocols)
                .back();

        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS4603-STUDYQUES", site.activeProtocols)
                .back();

        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());

        WithType2DiabetesPageCC withType2DiabetesPageCC = currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        ArrayList<String> timePeriods = new ArrayList<>();
        timePeriods.add("Within the past 2 months");
        timePeriods.add("3 - 6 months ago");
        timePeriods.add("7 - 11 months ago");
        timePeriods.add("1 to less than 5 years ago");
        timePeriods.add("5 to less than 10 years ago");
        for (String period : timePeriods) {
            withType2DiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(period)
                    .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    //.checkProtocolsContainsForQNumber("Q0006179-QS4604-STUDYQUES", site.activeProtocols)
                    .back();
        }

        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new NoOfAlcoholicDrinksCC());

        LastTimeYouTookPageCC lastTimeYouTookPageCC = noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .back(currentlyTreatingYourDiabetesPageCC)
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .back(currentlyTreatingYourDiabetesPageCC)
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageCC());

        ArrayList<String> lastTimes = new ArrayList<>();
        lastTimes.add("2 - 3 months ago");
        lastTimes.add("4 - 5 months ago");
        lastTimes.add("6 months ago or longer");
        for (String lastTime : lastTimes) {
            lastTimeYouTookPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(lastTime)
                    .clickNextButton(noOfAlcoholicDrinksCC)
                    .waitForPageLoad()
                    .back();
        }
        MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageCC());

        ApartFromMetforminPageCC apartFromMetforminPageCC = metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApartFromMetforminPageCC());

        CurrentlyTakeInsulinPageCC currentlyTakeInsulinPageCC = apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyTakeInsulinPageCC());

        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = currentlyTakeInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());

        TakeYourInsulinPageCC takeYourInsulinPageCC = injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .back(currentlyTakeInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageCC());

        BrandsOfInsulinPageCC brandsOfInsulinPageCC = takeYourInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
                .waitForPageLoad()
                .back(takeYourInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickNextButton(new BrandsOfInsulinPageCC());

        TakeYourInsulinInjectionsPageCC takeYourInsulinInjectionsPageCC = brandsOfInsulinPageCC
                .waitForPageLoad()
                .back(takeYourInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickOnAnswers("Daily injections")
                .clickNextButton(new TakeYourInsulinInjectionsPageCC());

        LiverRelatedConditionCC liverRelatedConditionCC = takeYourInsulinInjectionsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
                .clickNextButton(brandsOfInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .setDrinks("15")
                .clickNextButton(new LiverRelatedConditionCC());

        liverRelatedConditionCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016650-QS4623-STUDYQUES", site.activeProtocols)
                .back(noOfAlcoholicDrinksCC)
                .waitForPageLoad()
                .setDrinks("14")
                .clickNextButton(liverRelatedConditionCC);

        ArrayList<String> conditions = new ArrayList<>();
        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = new FollowingToLoseWeightPageCC();
        conditions.add("Alcoholic liver disease");
        conditions.add("Autoimmune hepatitis, which is not the same as hepatitis caused by a virus");
        conditions.add("Hemochromatosis or iron overload (Agent Note: he-mo-chrome-uh-TOE-sus)");
        conditions.add("Liver cancer or hepatocellular carcinoma (Agent Note: hih-pat-oh-CELL-u-lar car-sih-NO-ma)");
        conditions.add("Primary sclerosing cholangitis or primary biliary cirrhosis (Agent Note: scler-OH-sing, ko-lanj-EYE-tis, BILL-ee-air-ee)");
        conditions.add("Wilson's disease");
        for (String condition : conditions) {
            liverRelatedConditionCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(condition)
                    .clickNextButton(followingToLoseWeightPageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0016651-QS4624-STUDYQUES", site.activeProtocols)
                    .back();
        }
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = liverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());

        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
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

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = transitionStatementCC
                .waitForPageLoad(indicationHistroyName)
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", site.activeProtocols)
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

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                .back();

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

        DoYouTakeAnyMedicationsToControlHighBloodPressureCC doYouTakeAnyMedicationsToControlHighBloodPressureCC = new DoYouTakeAnyMedicationsToControlHighBloodPressureCC();
        ArrayList<String> heartProcedurePeriods = new ArrayList<>();
        heartProcedurePeriods.add("Less than 30 days ago");
        heartProcedurePeriods.add("1 - 3 months ago");
        heartProcedurePeriods.add("4 - 6 months ago");
        for (String period : heartProcedurePeriods) {
            mostRecentHeartProcedurePageСС
                    .waitForPageLoad()
                    .clickOnAnswer(period)
                    .clickNextButton(doYouTakeAnyMedicationsToControlHighBloodPressureCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015137-QS49-STUDYQUES", site.activeProtocols)
                    .back();
        }

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(doYouTakeAnyMedicationsToControlHighBloodPressureCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());
        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
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
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ArrayList<String> additionalDiagnoses = new ArrayList<>();
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        additionalDiagnoses.add("Drug or alcohol abuse within the past year");
        additionalDiagnoses.add("Hepatitis B");
        additionalDiagnoses.add("Hepatitis C");
        additionalDiagnoses.add("HIV or AIDS");
        for (String diagnose : additionalDiagnoses) {
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                    .back();
        }

        LetMeSeePageCC letMeSeePageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("5", "5", "180")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .childPidFromDbToLog(env, "4708")
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}

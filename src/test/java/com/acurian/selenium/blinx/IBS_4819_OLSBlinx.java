package com.acurian.selenium.blinx;


import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.gerd.CurrentlySufferOfAnyOfFollowingOLS;
import com.acurian.selenium.pages.blinx.ams.gerd.WhatTypeOfSurgeryDidYouHave_OLS;
import com.acurian.selenium.pages.blinx.ams.gerd.WhenDidYouHaveAppendixRemoved_OLS;
import com.acurian.selenium.pages.blinx.ams.ibs.*;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;

import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class IBS_4819_OLSBlinx extends BaseTest {


    private static Logger Log = LogManager.getLogger(IBS_4819_OLSBlinx.class.getName());

    @Test()
    @Description("IBS 4819 OLS Urovant IBS")
    public void ibs4819olsTest() {
        Site site = Site.AUT_IBS4819_site;
        String phoneNumber = "AUTAMS1IBS";
        String studyName = "an irritable bowel syndrome (IBS)";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadCrohnsNew("an irritable bowel syndrome (IBS) study", "300");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.
//                        getExpectedModifiedTitle("an irritable bowel syndrome (IBS) study", "300"),
//                "Title is diff");

        dateOfBirthPageOLS
                .clickOnAnswer("No");
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = new LessThan18YearsOldPageOLS();
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoadCrohnsNew("an irritable bowel syndrome (IBS) study", "300")
                .clickOnAnswer("Yes");

        ZipCodePageOLS zipCodePageOLS = new ZipCodePageOLS();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Female")
                        .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                        .clickNextButton(lessThan18YearsOldPageOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                        .back(genderPageOLS)
                        .waitForPageLoad()
                        .setDate("01081940")//Disqualify ("Age") if >= 71
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        SufferFromIrritablePageOLS sufferFromIrritablePageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01081990")
                .clickOnAnswer("Male") //Disqualify ("Male")
                .clickNextButton(new SufferFromIrritablePageOLS());
        sufferFromIrritablePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(sufferFromIrritablePageOLS);
        sufferFromIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not experience these symptoms of IBS")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6602", site.activeProtocols)
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        HowLongExperiencingIrritablePageOLS howLongExperiencingIrritablePageOLS = sufferFromIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I have been diagnosed with IBS by a healthcare professional")
                .clickNextButton(new HowLongExperiencingIrritablePageOLS());

        WhichOfTheFollowingExperienceIrritablePageOLS whichOfTheFollowingExperienceIrritablePageOLS =
                howLongExperiencingIrritablePageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Less than 1 month")
                        .clickNextButton(new WhichOfTheFollowingExperienceIrritablePageOLS());
        whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6603", site.activeProtocols)
                .back(whichOfTheFollowingExperienceIrritablePageOLS);
        howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 5 months")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6603", site.activeProtocols)
                .back(howLongExperiencingIrritablePageOLS);
        howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months to 1 year")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS);

        AbdominalPainWhenHavingIBSPageOLS abdominalPainWhenHavingIBSPageOLS =
                whichOfTheFollowingExperienceIrritablePageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Constipation only")
                        .clickNextButton(new AbdominalPainWhenHavingIBSPageOLS());
        abdominalPainWhenHavingIBSPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6604", site.activeProtocols)
                .back(abdominalPainWhenHavingIBSPageOLS);
        whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6604", site.activeProtocols)
                .back(whichOfTheFollowingExperienceIrritablePageOLS);
        WhichSymptomOccursPageOLS whichSymptomOccursPageOLS = whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Both constipation and diarrhea")
                .clickNextButton(new WhichSymptomOccursPageOLS());

        TypicalWeekBowelMovementsOLS typicalWeekBowelMovementsOLS = whichSymptomOccursPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new TypicalWeekBowelMovementsOLS());

        typicalWeekBowelMovementsOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the time")
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS)
                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6618", site.activeProtocols)
                .back(typicalWeekBowelMovementsOLS)
                .waitForPageLoad()
                .back(whichSymptomOccursPageOLS);

        whichSymptomOccursPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Constipation")
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS);

        CurrentlyTakeTreatIBSPageOLS currentlyTakeTreatIBSPageOLS = abdominalPainWhenHavingIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyTakeTreatIBSPageOLS());
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6606", site.activeProtocols)
                .back(currentlyTakeTreatIBSPageOLS);
        HowOftenAbdominalPainPageOLS howOftenAbdominalPainPageOLS = abdominalPainWhenHavingIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowOftenAbdominalPainPageOLS());

        AbdominalPainOverPastPageOLS abdominalPainOverPastPageOLS = howOftenAbdominalPainPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 day a week")
                .clickNextButton(new AbdominalPainOverPastPageOLS());
        abdominalPainOverPastPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6619", site.activeProtocols)
                .back(abdominalPainOverPastPageOLS);
        howOftenAbdominalPainPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Multiple days a week")
                .clickNextButton(abdominalPainOverPastPageOLS);

        abdominalPainOverPastPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTakeTreatIBSPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6608", site.activeProtocols)
                .back(abdominalPainOverPastPageOLS);
        abdominalPainOverPastPageOLS
                .waitForPageLoad()
                .clickOnAnswers("The pain got better after having a bowel movement")
                .clickNextButton(currentlyTakeTreatIBSPageOLS);

        CeliacDiseasePageOLS celiacDiseasePageOLS = new CeliacDiseasePageOLS();

        HaveYouTakenAnyLaxativesOLS haveYouTakenAnyLaxativesOLS = currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Neomycin")
                .clickNextButton(new HaveYouTakenAnyLaxativesOLS());

        haveYouTakenAnyLaxativesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back(haveYouTakenAnyLaxativesOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Viberzi (eluxadoline)")
                .clickNextButton(haveYouTakenAnyLaxativesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back(currentlyTakeTreatIBSPageOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xifaxan (rifaximin)")
                .clickNextButton(haveYouTakenAnyLaxativesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back(currentlyTakeTreatIBSPageOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouTakenAnyLaxativesOLS);

        InThePastDaysFollowingMedicationsOLS inThePastDaysFollowingMedicationsOLS = haveYouTakenAnyLaxativesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InThePastDaysFollowingMedicationsOLS());

        inThePastDaysFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(celiacDiseasePageOLS);

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = new WeightLossSurgeryPageOLS();

        celiacDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6610", site.activeProtocols)
                .back(celiacDiseasePageOLS);

        celiacDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(weightLossSurgeryPageOLS);

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        WhatTypeOfSurgeryDidYouHave_OLS whatTypeOfSurgeryDidYouHave_OLS = new WhatTypeOfSurgeryDidYouHave_OLS();
        List<String> disqualifyQ12 = Arrays.asList("Less than 3 months ago", "3 - 6 months ago", "7 - 11 months ago",
                "1 - 2 years ago", "More than 2 years ago");
        for (String answer : disqualifyQ12) {
            Log.info("Select answer for Q12: " + answer);
            procedureForWeightLossPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(whatTypeOfSurgeryDidYouHave_OLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6612", site.activeProtocols)
                    .back(procedureForWeightLossPageOLS);
        }
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whatTypeOfSurgeryDidYouHave_OLS);

        WhenDidYouHaveAppendixRemoved_OLS whenDidYouHaveAppendixRemoved_OLS =
                whatTypeOfSurgeryDidYouHave_OLS
                        .waitForPageLoad()
                        .clickOnAnswers("Appendix removed - Appendectomy",
                                "Gallbladder removed - Cholecystectomy",
                                "Biopsy – removal of a small piece of tissue for analysis",
                                "Tonsils removed - Tonsillectomy",
                                "Hemorrhoids removed - Hemorrhoidectomy",
                                "Other surgery on my stomach, intestines, colon, or esophagus")
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Appendix removed - Appendectomy",
                                "Gallbladder removed - Cholecystectomy",
                                "Hemorrhoids removed - Hemorrhoidectomy",
                                "Other surgery on my stomach, intestines, colon, or esophagus")
                        .clickNextButton(new WhenDidYouHaveAppendixRemoved_OLS());

        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_OLS.titleExpected2)
                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_OLS.titleExpected3)
                .waitForPageLoad(4, whenDidYouHaveAppendixRemoved_OLS.titleExpected4)
                .back(whatTypeOfSurgeryDidYouHave_OLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whichOfFollowingDigestiveConditionPageOLS);
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                whichOfFollowingDigestiveConditionPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Crohn's disease")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                .back(whichOfFollowingDigestiveConditionPageOLS);
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back(heartrelatedMedicalProceduresPageOLS);
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                // for unselected
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                //
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                //
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                //
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                //
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                //
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageOLS);
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                heartrelatedMedicalProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS =
                whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Dialysis")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS =
                whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Cirrhosis")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(following_mentalEmotionalHealthPageOLS);
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                following_mentalEmotionalHealthPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Bipolar disorder")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(following_mentalEmotionalHealthPageOLS);
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back(following_mentalEmotionalHealthPageOLS);
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .back(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back(heartrelatedMedicalProceduresPageOLS);
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back(whichOfFollowingDigestiveConditionPageOLS);
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back(whenDiagnosedWithCancerOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(approximateHeightPageOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        CurrentlySufferOfAnyOfFollowingOLS currentlySufferOfAnyOfFollowingOLS =
                approximateHeightPageOLS
                        .waitForPageLoad()
                        .setAll("5", "5", "270")
                        .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS());
        currentlySufferOfAnyOfFollowingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(currentlySufferOfAnyOfFollowingOLS);
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "260")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = identificationPageOLS
                .waitForPageLoadNewPRD()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName+" study!")
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
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

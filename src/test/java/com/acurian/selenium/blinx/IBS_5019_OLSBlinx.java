package com.acurian.selenium.blinx;

import com.acurian.selenium.CC.IBS_5019_CC;
import com.acurian.selenium.OLS.IBS_5019_OLS;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.gerd.CurrentlySufferOfAnyOfFollowingOLS;
import com.acurian.selenium.pages.blinx.ams.gerd.WhatTypeOfSurgeryDidYouHave_OLS;
import com.acurian.selenium.pages.blinx.ams.gerd.WhenDidYouHaveAppendixRemoved_OLS;
import com.acurian.selenium.pages.blinx.ams.ibs.*;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class IBS_5019_OLSBlinx extends BaseTest {


    private static Logger Log = LogManager.getLogger(IBS_5019_OLSBlinx.class.getName());

    @Test(dataProvider = "sites", dataProviderClass = IBS_5019_CC.class)
    @Description("IBS 5019 CC Boston Pharma IBS-D")
    public void ibs5019olsTest(Site site) {
        String phoneNumber = "AUTAMS1IBS";
        String studyName = "an irritable bowel syndrome (IBS) study";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadCrohnsNew(studyName, "300");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle(studyName, "300"), "Title is diff");

        dateOfBirthPageOLS
                .waitForPageLoadCrohnsNew(studyName, "300")
                .clickOnAnswer("No");

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = new LessThan18YearsOldPageOLS();

                lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoadCrohnsNew(studyName, "300")
                .clickOnAnswer("Yes");

        ZipCodePageOLS zipCodePageOLS = new ZipCodePageOLS();

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Male")
                        .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                        .clickNextButton(lessThan18YearsOldPageOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                        .back(genderPageOLS)
                        .waitForPageLoad()
                        .setDate("01081940")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        SufferFromIrritablePageOLS sufferFromIrritablePageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01081990")
                .clickNextButton(new SufferFromIrritablePageOLS());

        sufferFromIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not experience these symptoms of IBS")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        HowLongExperiencingIrritablePageOLS howLongExperiencingIrritablePageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS6602", site.activeProtocols)
                        .back(sufferFromIrritablePageOLS)
                        .waitForPageLoad()
                        .clickOnAnswer("I have been diagnosed with IBS by a healthcare professional")
                        .clickNextButton(new HowLongExperiencingIrritablePageOLS());

        WhichOfTheFollowingExperienceIrritablePageOLS whichOfTheFollowingExperienceIrritablePageOLS =
                new WhichOfTheFollowingExperienceIrritablePageOLS();
        List<String> disqualifyQ3 = Arrays.asList("Less than 1 month", "1 - 5 months");
        for (String answer : disqualifyQ3) {
            Log.info("Select answer for Q3: " + answer);
            howLongExperiencingIrritablePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6603", site.activeProtocols)
                    .back(howLongExperiencingIrritablePageOLS);
        }
        howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months to 1 year")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS);

        AbdominalPainWhenHavingIBSPageOLS abdominalPainWhenHavingIBSPageOLS = new AbdominalPainWhenHavingIBSPageOLS();
        List<String> disqualifyQ4 = Arrays.asList("Constipation only", "None of the above");
        for (String answer : disqualifyQ4) {
            Log.info("Select answer for Q4: " + answer);
            whichOfTheFollowingExperienceIrritablePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(abdominalPainWhenHavingIBSPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6604", site.activeProtocols)
                    .back(whichOfTheFollowingExperienceIrritablePageOLS);
        }
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
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6605", site.activeProtocols)
                .back(whichSymptomOccursPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Diarrhea")
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
        howOftenAbdominalPainPageOLS = new HowOftenAbdominalPainPageOLS();
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
                .clickOnAnswers("The pain got better after having a bowel movement",
                        "More frequent bowel movements than usual",
                        "Less frequent bowel movements than usual",
                        "Looser or more liquid bowel movements than usual",
                        "Harder or lumpier bowel movements than usual")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("The pain got better after having a bowel movement")
                .clickNextButton(currentlyTakeTreatIBSPageOLS);

        CeliacDiseasePageOLS celiacDiseasePageOLS = new CeliacDiseasePageOLS();
        HaveYouTakenAnyLaxativesOLS haveYouTakenAnyLaxativesOLS = currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Xifaxan (rifaximin)")
                .clickNextButton(new HaveYouTakenAnyLaxativesOLS());

        haveYouTakenAnyLaxativesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back(haveYouTakenAnyLaxativesOLS);

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

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = celiacDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WeightLossSurgeryPageOLS());
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6610", site.activeProtocols)
                .back(celiacDiseasePageOLS)
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

        WhenDidYouHaveAppendixRemoved_OLS whenDidYouHaveAppendixRemoved_OLS = whatTypeOfSurgeryDidYouHave_OLS
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
                .clickOnAnswers("Appendix removed - Appendectomy")
                .clickNextButton(whenDidYouHaveAppendixRemoved_OLS);

        List<String> disqualifyQ14 = Arrays.asList("Less than 1 month ago", "1 - 3 months ago");
        for (String answer : disqualifyQ14) {
            Log.info("Select answer for Q14.1: " + answer);
            whenDidYouHaveAppendixRemoved_OLS
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back(whenDidYouHaveAppendixRemoved_OLS);
        }
        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
                .back(whatTypeOfSurgeryDidYouHave_OLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Gallbladder removed - Cholecystectomy")
                .clickNextButton(whenDidYouHaveAppendixRemoved_OLS);

        for (String answer : disqualifyQ14) {
            Log.info("Select answer for Q14.2: " + answer);
            whenDidYouHaveAppendixRemoved_OLS
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back(whenDidYouHaveAppendixRemoved_OLS);
        }
        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected2)
                .back(whatTypeOfSurgeryDidYouHave_OLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hemorrhoids removed - Hemorrhoidectomy")
                .clickNextButton(whenDidYouHaveAppendixRemoved_OLS);

        for (String answer : disqualifyQ14) {
            Log.info("Select answer for Q14.3: " + answer);
            whenDidYouHaveAppendixRemoved_OLS
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back(whenDidYouHaveAppendixRemoved_OLS);
        }
        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected3)
                .back(whatTypeOfSurgeryDidYouHave_OLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(whenDidYouHaveAppendixRemoved_OLS);

        for (String answer : disqualifyQ14) {
            Log.info("Select answer for Q14.4: " + answer);
            whenDidYouHaveAppendixRemoved_OLS
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back(whenDidYouHaveAppendixRemoved_OLS);
        }
        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected4)
                .back(whatTypeOfSurgeryDidYouHave_OLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Men's health issues (prostate enlargement or BPH, low testosterone)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Kidney disease",
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
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = new
                HaveYouEverExperiencedHeartRelatedMedicalCondOLS();
        List<String> disqualifyQ8GH = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer : disqualifyQ8GH) {
            Log.info("Select answer for Q8GH: " + answer);
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back(whichOfFollowingDigestiveConditionPageOLS);
        }
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
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
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionExperiencedHeartPageOLS);

        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.1GH: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageOLS);
        }
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageOLS);

        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.2GH: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageOLS);
        }
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionExperiencedHeartPageOLS);

        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.3GH: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageOLS);
        }
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionExperiencedHeartPageOLS);

        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.4GH: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageOLS);
        }
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                heartrelatedMedicalProceduresPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS =
                new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS();
        List<String> disqualifyQ16GH = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ16GH) {
            Log.info("Select answer for Q16GH: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Cirrhosis",
                                "Fatty liver disease",
                                "NASH (non-alcoholic steatohepatitis)",
                                "NAFLD (non-alcoholic fatty liver disease)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                followingMentalEmotionalHealthPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Generalized anxiety disorder (GAD)",
                                "Major depressive disorder (MDD) or depression",
                                "Bipolar disorder",
                                "Schizophrenia")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back(followingMentalEmotionalHealthPageOLS);
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS);
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

        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ24GH = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Drug or alcohol abuse within the past year", "HIV or AIDS");
        for (String answer : disqualifyQ24GH) {
            Log.info("Select answer for Q24GH: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        CurrentlySufferOfAnyOfFollowingOLS currentlySufferOfAnyOfFollowingOLS =
                approximateHeightPageOLS
                        .waitForPageLoad()
                        .setAll("5", "5", "240") //Disqualify ("High BMI") if > 39
                        .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS());
        currentlySufferOfAnyOfFollowingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setPounds("95") //Disqualify (""Low BMI"") if < 16"
                .clickNextButton(currentlySufferOfAnyOfFollowingOLS);
        IdentificationPageOLS identificationPageOLS = currentlySufferOfAnyOfFollowingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setPounds("120")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = identificationPageOLS
                .waitForPageLoad2()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad("an irritable bowel syndrome (IBS) study!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
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

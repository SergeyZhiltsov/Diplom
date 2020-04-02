package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;

import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.gerd.WhatTypeOfSurgeryDidYouHave_OLS;
import com.acurian.selenium.pages.blinx.ams.gerd.WhenDidYouHaveAppendixRemoved_OLS;
import com.acurian.selenium.pages.blinx.ams.ibs.*;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class IBS_4684_OLSBlinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(IBS_4684_OLSBlinx.class.getName());

    @Test(enabled = true)
    @Description("IBS 4684 OLS")
    public void ibs46484olsTest() {
        String phoneNumber = "AUTAMS1IBS";
        String protocol1 = "OM_201";
//        String[] protocols = {protocol1, protocol2, AKC, protocol3};
        Site site = Site.AUT_IBS4684_site;
        String studyName = "an irritable bowel syndrome (IBS)";
        String siteName = "AUT_IBS4684_site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadCrohnsNew("an irritable bowel syndrome (IBS) study", "300");

        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("an irritable bowel syndrome (IBS) study", "300"), "Title is diff");
        // --------------DOB Question------------
        dateOfBirthPageOLS
                // ------------Disqualify (“Age < 18 years old”) if <18
                // -----------------------------------------
                .waitForPageLoadCrohnsNew("an irritable bowel syndrome (IBS) study", "300")
                .clickOnAnswer("No");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = new LessThan18YearsOldPageOLS();
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS
                .getPage(debugPageOLS).checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(lessThan18YearsOldPage_OLS);
        dateOfBirthPageOLS
                .waitForPageLoadCrohnsNew("an irritable bowel syndrome (IBS) study", "300")
                .clickOnAnswer("Yes");
        ZipCodePageOLS zipCodePageOLS = new ZipCodePageOLS();

        // --------------ZIP_CODE Question------------
        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        // --------------GENDER Question------------
        genderPageOLS
                .waitForPageLoad();
        SufferFromIrritablePageOLS sufferFromIrritablePageOLS = genderPageOLS
                .setDate("09091980")
                .clickOnAnswer("Male")
                .clickNextButton(new SufferFromIrritablePageOLS());

        //DebugPageOLS debugPageOLS = new DebugPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = sufferFromIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not experience these symptoms of IBS")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6602", protocol1)
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        HowLongExperiencingIrritablePageOLS howLongExperiencingIrritablePageOLS = sufferFromIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I have been diagnosed with IBS by a healthcare professional")
                .clickNextButton(new HowLongExperiencingIrritablePageOLS());

        WhichOfTheFollowingExperienceIrritablePageOLS whichOfTheFollowingExperienceIrritablePageOLS = howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new WhichOfTheFollowingExperienceIrritablePageOLS());

        whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6603", protocol1)
                .back(whichOfTheFollowingExperienceIrritablePageOLS);
        howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 5 months")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6603", protocol1)
                .back(howLongExperiencingIrritablePageOLS);
        howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months to 1 year")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS);

        AbdominalPainWhenHavingIBSPageOLS abdominalPainWhenHavingIBSPageOLS = whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Constipation only")
                .clickNextButton(new AbdominalPainWhenHavingIBSPageOLS());
        abdominalPainWhenHavingIBSPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6604", protocol1)
                .back(abdominalPainWhenHavingIBSPageOLS);
        whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6604", protocol1)
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
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6618", protocol1)
                .back(typicalWeekBowelMovementsOLS)
                .waitForPageLoad()
                .back(whichSymptomOccursPageOLS);

        whichSymptomOccursPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Constipation")
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6605", protocol1)
                .back(whichSymptomOccursPageOLS);
        whichSymptomOccursPageOLS
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
                .checkProtocolsContainsForQNumber("QS6606", protocol1)
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
                .checkProtocolsContainsForQNumber("QS6619", protocol1)
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
                .checkProtocolsContainsForQNumber("QS6608", protocol1)
                .back(abdominalPainOverPastPageOLS);
        abdominalPainOverPastPageOLS
                .waitForPageLoad()
                .clickOnAnswers("The pain got better after having a bowel movement")
                .clickNextButton(currentlyTakeTreatIBSPageOLS);

        CeliacDiseasePageOLS celiacDiseasePageOLS = new CeliacDiseasePageOLS();

        HaveYouTakenAnyLaxativesOLS haveYouTakenAnyLaxativesOLS = currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Amitiza (lubiprostone)")
                .clickNextButton(new HaveYouTakenAnyLaxativesOLS());
        haveYouTakenAnyLaxativesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", protocol1)
                .back(haveYouTakenAnyLaxativesOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Linzess (linaclotide)")
                .clickNextButton(haveYouTakenAnyLaxativesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", protocol1)
                .back(currentlyTakeTreatIBSPageOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Lotronex (alosetron)")
                .clickNextButton(haveYouTakenAnyLaxativesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", protocol1)
                .back(currentlyTakeTreatIBSPageOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulance (plecanatide)")
                .clickNextButton(haveYouTakenAnyLaxativesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", protocol1)
                .back(currentlyTakeTreatIBSPageOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Viberzi (eluxadoline)")
                .clickNextButton(haveYouTakenAnyLaxativesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", protocol1)
                .back(currentlyTakeTreatIBSPageOLS);
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xifaxan (rifaximin)")
                .clickNextButton(haveYouTakenAnyLaxativesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", protocol1)
                .back(currentlyTakeTreatIBSPageOLS);

        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouTakenAnyLaxativesOLS);

        InThePastDaysFollowingMedicationsOLS inThePastDaysFollowingMedicationsOLS = haveYouTakenAnyLaxativesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new InThePastDaysFollowingMedicationsOLS());

        inThePastDaysFollowingMedicationsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6620", protocol1)
                .back(inThePastDaysFollowingMedicationsOLS);

        haveYouTakenAnyLaxativesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(inThePastDaysFollowingMedicationsOLS);

        List<String> disqualifyQ12New = Arrays.asList("Xanax (alprazolam)", "Klonopin (clonazepam)", "Valium (diazepam)",
                "Ativan (lorazepam)", "Restoril (temazepam)", "Halcion (triazolam)");
        for (String answer : disqualifyQ12New) {
            Log.info("Select answer for Q12New: " + answer);
            inThePastDaysFollowingMedicationsOLS
                    .waitForPageLoad()
                    .clickOnAnswer("None of the above")
                    .clickOnAnswer(answer)
                    .clickNextButton(celiacDiseasePageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6621", site.activeProtocols)
                    .back(inThePastDaysFollowingMedicationsOLS);
        }

        inThePastDaysFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(celiacDiseasePageOLS);



//        weightLossSurgeryPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6610", protocol1)
//                .back();
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

        List<String> disqualifyQ14 = Arrays.asList("1 - 3 months ago");
        for (String answer : disqualifyQ14) {
            Log.info("Select answer for Q14.1: " + answer);
            whenDidYouHaveAppendixRemoved_OLS
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    //.checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
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
                    //.checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
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
                    //.checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
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
                    //.checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
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

        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "4 - 6 months ago");
        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.1GH: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
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
//                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
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
//                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
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
                    //.checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
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

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("6", "2", "350")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());


        AboutHealthPageOLS aboutHealthPageOLS = identificationPageOLS
                .waitForPageLoadNew()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
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
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

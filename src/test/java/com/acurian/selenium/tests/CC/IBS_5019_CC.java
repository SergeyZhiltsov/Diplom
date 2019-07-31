package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.GERD.WhatTypeOfSurgeryDidYouHave_CC;
import com.acurian.selenium.pages.CC.GERD.WhenDidYouHaveAppendixRemoved_CC;
import com.acurian.selenium.pages.CC.IBS.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class IBS_5019_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "sites")
    public Object[][] sites() {
        return new Object[][] {
                {Site.AUT_AMS1_5019_site},
 //               {Site.AUT_AMS1_5019S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("IBS 5019 CC Boston Pharma IBS-D")
    public void ibs5019ccTest(Site site) {
        String phoneNumber = "AUTAMS1IBS";
        String studyName = "an irritable bowel syndrome (IBS) study";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected,
                "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
        .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                .getExpectedModifiedTitle("an irritable bowel syndrome (IBS) study", "300"),
                "Title is diff");

        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        ZipCodePageCC zipCodePageCC = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        SufferFromIrritablePageCC sufferFromIrritablePageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDay("1")
                .setMonth("Aug")
                .setYear("2005")//Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1950")
                .clickNextButton(new SufferFromIrritablePageCC());
        sufferFromIrritablePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1990")
                .clickNextButton(sufferFromIrritablePageCC);

        NonQRtransitionPageCC nonQRtransitionPageCC = sufferFromIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("I do not experience these symptoms of IBS")
                .clickNextButton(new NonQRtransitionPageCC());
        HowLongExperiencingIrritablePageCC howLongExperiencingIrritablePageCC = nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6602", site.activeProtocols)
                .back(sufferFromIrritablePageCC)
                .waitForPageLoad()
                .clickOnAnswer("I have been diagnosed with IBS by a healthcare professional")
                .clickNextButton(new HowLongExperiencingIrritablePageCC());

        WhichOfTheFollowingExperienceIrritablePageCC whichOfTheFollowingExperienceIrritablePageCC =
                new WhichOfTheFollowingExperienceIrritablePageCC();
        List<String> disqualifyQ3 = Arrays.asList("Less than 1 month", "1 - 5 months");
        for (String answer: disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            howLongExperiencingIrritablePageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(whichOfTheFollowingExperienceIrritablePageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6603", site.activeProtocols)
                    .back();
        }
        howLongExperiencingIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("6 months to 1 year")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageCC);

        AbdominalPainWhenHavingIBSPageCC abdominalPainWhenHavingIBSPageCC = new AbdominalPainWhenHavingIBSPageCC();
        List<String> disqualifyQ4 = Arrays.asList("Constipation only", "None of the above");
        for (String answer: disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            whichOfTheFollowingExperienceIrritablePageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(abdominalPainWhenHavingIBSPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6604", site.activeProtocols)
                    .back();
        }
        WhichSymptomOccursPageCC whichSymptomOccursPageCC = whichOfTheFollowingExperienceIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("Both constipation and diarrhea")
                .clickNextButton(new WhichSymptomOccursPageCC());

        whichSymptomOccursPageCC
                .waitForPageLoad()
                .clickOnAnswer("Constipation")
                .clickNextButton(abdominalPainWhenHavingIBSPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6605", site.activeProtocols)
                .back(whichSymptomOccursPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Diarrhea")
                .clickNextButton(abdominalPainWhenHavingIBSPageCC);

        CurrentlyTakeTreatIBSPageCC currentlyTakeTreatIBSPageCC = abdominalPainWhenHavingIBSPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyTakeTreatIBSPageCC());
        currentlyTakeTreatIBSPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6606", site.activeProtocols)
                .back();
        HowOftenAbdominalPainPageCC howOftenAbdominalPainPageCC = abdominalPainWhenHavingIBSPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowOftenAbdominalPainPageCC());

        AbdominalPainOverPastPageCC abdominalPainOverPastPageCC = new AbdominalPainOverPastPageCC();
        List<String> disqualifyQ7 = Arrays.asList("1 day a month or less", "2 - 3 days a month");
        for (String answer: disqualifyQ7) {
            System.out.println("Select answer for Q7: " + answer);
            howOftenAbdominalPainPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(abdominalPainOverPastPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6607", site.activeProtocols)
                    .back();
        }
        howOftenAbdominalPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 day a week")
                .clickNextButton(abdominalPainOverPastPageCC);

        abdominalPainOverPastPageCC
                .waitForPageLoad()
                .clickOnAnswers("The pain got better after having a bowel movement",
                                "More frequent bowel movements than usual",
                                "Less frequent bowel movements than usual",
                                "Looser or more liquid bowel movements than usual",
                                "Harder or lumpier bowel movements than usual")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("The pain got better after having a bowel movement")
                .clickNextButton(currentlyTakeTreatIBSPageCC);

        CeliacDiseasePageCC celiacDiseasePageCC = currentlyTakeTreatIBSPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xifaxan, also known as rifaximin (Agent Note: zi-FAX-in, ri-FAX-i-min)")
                .clickNextButton(new CeliacDiseasePageCC());
        celiacDiseasePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back(currentlyTakeTreatIBSPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(celiacDiseasePageCC);

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = celiacDiseasePageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WeightLossSurgeryPageCC());
        weightLossSurgeryPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6610", site.activeProtocols)
                .back(celiacDiseasePageCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(weightLossSurgeryPageCC);

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        WhatTypeOfSurgeryDidYouHave_CC whatTypeOfSurgeryDidYouHave_CC = new WhatTypeOfSurgeryDidYouHave_CC();
        List<String> disqualifyQ12 = Arrays.asList("Less than 3 months ago", "3 - 6 months ago", "7 - 11 months ago",
                "1 - 2 years ago", "More than 2 years ago");
        for (String answer: disqualifyQ12) {
            System.out.println("Select answer for Q12: " + answer);
            procedureForWeightLossPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(whatTypeOfSurgeryDidYouHave_CC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6612", site.activeProtocols)
                    .back();
        }
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .back(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whatTypeOfSurgeryDidYouHave_CC);

        WhenDidYouHaveAppendixRemoved_CC whenDidYouHaveAppendixRemoved_CC =
                whatTypeOfSurgeryDidYouHave_CC
                .waitForPageLoad()
                .clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)",
                        "Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)",
                        "Biopsy (Agent Note: BY-op-see) – removal of a small piece of tissue for analysis",
                        "Tonsils removed - Tonsillectomy (Agent Note: tahn-sil-LECK-toe-mee)",
                        "Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)",
                        "Other surgery on my stomach, intestines, colon, or esophagus")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)",
                        "Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)",
                        "Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)",
                        "Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(new WhenDidYouHaveAppendixRemoved_CC());

        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_CC.titleExpected3)
                .waitForPageLoad(4, whenDidYouHaveAppendixRemoved_CC.titleExpected4)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);

        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        List<String> disqualifyQ14 = Arrays.asList("Less than 1 month ago", "1 - 3 months ago");
        for (String answer: disqualifyQ14) {
            System.out.println("Select answer for Q14.1: " + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back();
        }
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);

        for (String answer: disqualifyQ14) {
            System.out.println("Select answer for Q14.2: " + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back();
        }
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);

        for (String answer: disqualifyQ14) {
            System.out.println("Select answer for Q14.3: " + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back();
        }
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected3)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);

        for (String answer: disqualifyQ14) {
            System.out.println("Select answer for Q14.4:" + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back();
        }
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected4)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageCC());

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(otherThanSkinCancerPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageCC);

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = new
                HaveYouEverExperiencedHeartRelatedMedicalCondCC();
        List<String> disqualifyQ8GH = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer: disqualifyQ8GH) {
            System.out.println("Select answer for Q8GH: " + answer);
            whichOfFollowingDigestiveConditionPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back();
        }
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC =
                haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC =
                haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected5)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.1GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.2GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.3GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.4GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);

        KidneyProblemsPage kidneyProblemsPage = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new KidneyProblemsPage());

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС =
                new WhichOfTheFollowingLiverProblemsPageСС();
        List<String> disqualifyQ16GH = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer: disqualifyQ16GH) {
            System.out.println("Select answer for Q16GH: " + answer);
            kidneyProblemsPage
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis",
                        "Fatty liver disease",
                        "NASH (non-alcoholic steatohepatitis)",
                        "NAFLD (non-alcoholic fatty liver disease)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Generalized anxiety disorder (GAD)",
                        "Major depressive disorder (MDD) or depression",
                        "Bipolar disorder",
                        "Schizophrenia")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ24GH = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Drug or alcohol abuse within the past year", "HIV or AIDS");
        for (String answer: disqualifyQ24GH) {
            System.out.println("Select answer for Q24GH: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "240") //Disqualify ("High BMI") if > 39
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .setLbs("95") //Disqualify (""Low BMI"") if < 16"
                .clickNextButton(letMeSeePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .setLbs("120")
                .clickNextButton(letMeSeePageCC);

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());

        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name);
        switch (site) {
            case AUT_AMS1_5019_site:
                siteSelectionPageCC
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_AMS1_5019S_site:
                siteSelectionPageCC
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "08/01/1990", "US",
                                "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com",
                                "999 -999-9999", "%SYN_SITE_NUM%", site.name, "BOSPPDIBS201")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
    }
}
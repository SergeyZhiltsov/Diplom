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
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class IBS_4684_CC extends BaseTest {

    @Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("IBS 4684 CC")
    public void ibs4684ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1IBS";
        String protocol1 = "OM_201";
        Site site = Site.AUT_IBS4684_site;
        String studyName = "an irritable bowel syndrome (IBS) study";
        String siteName = "AUT_IBS4684_site";
        String debugSiteName = "";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        DebugPageCC debugPageCC = new DebugPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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

        //-------Date of Birth Page--------
        dateOfBirthPageCC
                .waitForPageLoad(studyName, "300");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle(studyName, "300"), "Title is diff");
        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad(studyName, "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad(studyName, "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        genderPageCC
                .waitForPageLoad()
                .setMonth("Jan")
                .setDay("1")
                .setYear("2003") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =genderPageCC
        SufferFromIrritablePageCC sufferFromIrritablePageCC = genderPageCC
                .waitForPageLoad()
                .setYear("1970")
                .clickNextButton(new SufferFromIrritablePageCC());


        NonQRtransitionPageCC nonQRtransitionPageCC = sufferFromIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("I do not experience these symptoms of IBS")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018595-QS6602-STUDYQUES", protocol1)
                .back();
        HowLongExperiencingIrritablePageCC howLongExperiencingIrritablePageCC = sufferFromIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("I have been diagnosed with IBS by a healthcare professional")
                .clickNextButton(new HowLongExperiencingIrritablePageCC());

        WhichOfTheFollowingExperienceIrritablePageCC whichOfTheFollowingExperienceIrritablePageCC = howLongExperiencingIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new WhichOfTheFollowingExperienceIrritablePageCC());
        whichOfTheFollowingExperienceIrritablePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018596-QS6603-STUDYQUES", protocol1)
                .back();
        howLongExperiencingIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 5 months")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018596-QS6603-STUDYQUES", protocol1)
                .back();
        howLongExperiencingIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("6 months to 1 year")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageCC);

        AbdominalPainWhenHavingIBSPageCC abdominalPainWhenHavingIBSPageCC = whichOfTheFollowingExperienceIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("Constipation only")
                .clickNextButton(new AbdominalPainWhenHavingIBSPageCC());
        abdominalPainWhenHavingIBSPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018597-QS6604-STUDYQUES", protocol1)
                .back();
        whichOfTheFollowingExperienceIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(abdominalPainWhenHavingIBSPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018597-QS6604-STUDYQUES", protocol1)
                .back();
        WhichSymptomOccursPageCC whichSymptomOccursPageCC = whichOfTheFollowingExperienceIrritablePageCC
                .waitForPageLoad()
                .clickOnAnswer("Both constipation and diarrhea")
                .clickNextButton(new WhichSymptomOccursPageCC());

        whichSymptomOccursPageCC
                .waitForPageLoad()
                .clickOnAnswer("Constipation")
                .clickNextButton(abdominalPainWhenHavingIBSPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018598-QS6605-STUDYQUES", protocol1)
                .back();
        whichSymptomOccursPageCC
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
                .checkProtocolsContainsForQNumber("Q0018599-QS6606-STUDYQUES", protocol1)
                .back();
        HowOftenAbdominalPainPageCC howOftenAbdominalPainPageCC = abdominalPainWhenHavingIBSPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowOftenAbdominalPainPageCC());

        AbdominalPainOverPastPageCC abdominalPainOverPastPageCC = howOftenAbdominalPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 day a month or less")
                .clickNextButton(new AbdominalPainOverPastPageCC());
        abdominalPainOverPastPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018600-QS6607-STUDYQUES", protocol1)
                .back();
        howOftenAbdominalPainPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days a month")
                .clickNextButton(abdominalPainOverPastPageCC);

        abdominalPainOverPastPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTakeTreatIBSPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018601-QS6608-STUDYQUES", protocol1)
                .back();
        abdominalPainOverPastPageCC
                .waitForPageLoad()
                .clickOnAnswers("The pain got better after having a bowel movement")
                .clickNextButton(currentlyTakeTreatIBSPageCC);

        CeliacDiseasePageCC celiacDiseasePageCC = currentlyTakeTreatIBSPageCC
                .waitForPageLoad()
                .clickOnAnswers("Amitiza, also known as lubiprostone (Agent Note: AM-i-tee-za, loo-bi-PRO-stone)")
                .clickNextButton(new CeliacDiseasePageCC());
        celiacDiseasePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018603-QS6609-STUDYQUES", protocol1)
                .back();
        currentlyTakeTreatIBSPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Linzess, also known as linaclotide (Agent Note: Lins-ESS, lin-AK-loe-tide)")
                .clickNextButton(celiacDiseasePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018603-QS6609-STUDYQUES", protocol1)
                .back();
        currentlyTakeTreatIBSPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Lotronex, also known as alosetron (Agent Note: LOE-tre-nex, a-LO-ze-tron)")
                .clickNextButton(celiacDiseasePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018603-QS6609-STUDYQUES", protocol1)
                .back();
        currentlyTakeTreatIBSPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulance, also known as plecanatide (Agent Note: TRUE-lans, ple-KAN-a-tide)")
                .clickNextButton(celiacDiseasePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018603-QS6609-STUDYQUES", protocol1)
                .back();
        currentlyTakeTreatIBSPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Viberzi, also known as eluxadoline (Agent Note: vie-BEER-zee, el-ux-AD-oh-leen)")
                .clickNextButton(celiacDiseasePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018603-QS6609-STUDYQUES", protocol1)
                .back();
        currentlyTakeTreatIBSPageCC
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
                .checkProtocolsContainsForQNumber("Q0018605-QS6610-STUDYQUES", protocol1)
                .back();
        celiacDiseasePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(weightLossSurgeryPageCC);

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());


        WhatTypeOfSurgeryDidYouHave_CC whatTypeOfSurgeryDidYouHave_CC = new WhatTypeOfSurgeryDidYouHave_CC();
        List<String> disqualifyQ12 = Arrays.asList("Less than 3 months ago", "3 - 6 months ago");
        for (String answer : disqualifyQ12) {
            System.out.println("Select answer for Q12: " + answer);
            procedureForWeightLossPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(whatTypeOfSurgeryDidYouHave_CC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    //.checkProtocolsContainsForQNumber("QS6612", site.activeProtocols)
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
        for (String answer : disqualifyQ14) {
            System.out.println("Select answer for Q14.1: " + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                   // .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back();
        }
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);

        for (String answer : disqualifyQ14) {
            System.out.println("Select answer for Q14.2: " + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                   // .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back();
        }
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);

        for (String answer : disqualifyQ14) {
            System.out.println("Select answer for Q14.3: " + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                   // .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
                    .back();
        }
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected3)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);

        for (String answer : disqualifyQ14) {
            System.out.println("Select answer for Q14.4:" + answer);
            whenDidYouHaveAppendixRemoved_CC
                    .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                    .getPage(debugPageCC)
                  //  .checkProtocolsContainsForQNumber("QS6617", site.activeProtocols)
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

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageCC);

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = new
                HaveYouEverExperiencedHeartRelatedMedicalCondCC();
        List<String> disqualifyQ8GH = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer : disqualifyQ8GH) {
            System.out.println("Select answer for Q8GH: " + answer);
            whichOfFollowingDigestiveConditionPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                 //   .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back();
        }
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC =
                haveYouEverExperiencedHeartRelatedMedicalCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC =
                haveYouEverExperiencedHeartRelatedMedicalCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                        .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.1GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                  //  .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.2GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                 //   .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.3GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                 //   .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionExperiencedHeartPageCC);

        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.4GH: " + answer);
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                 //   .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC =
                new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC();
        List<String> disqualifyQ16GH = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ16GH) {
            System.out.println("Select answer for Q16GH: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                 //   .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
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
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ24GH = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Drug or alcohol abuse within the past year", "HIV or AIDS");
        for (String answer : disqualifyQ24GH) {
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
                .setAll("5", "5", "170") //Disqualify ("High BMI") if > 39
                .clickNextButton(new LetMeSeePageCC());

        //Not Sinexus Close about drugs
        CurrentlyParticipatingInStudy currentlyParticipatingInStudy = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy());

        RequirePassDrugTest requirePassDrugTest = currentlyParticipatingInStudy
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new RequirePassDrugTest());
        requirePassDrugTest
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS912", site.activeProtocols)
                .back(currentlyParticipatingInStudy)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(requirePassDrugTest);
        IdentificationPageCC identificationPageCC = requirePassDrugTest
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC());
        identificationPageCC
                .waitForPageLoadNotQ()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS913", site.activeProtocols)
                .back(requirePassDrugTest);
        requirePassDrugTest
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(identificationPageCC);
        //end

        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name);

                siteSelectionPageCC
                        .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
                        //.clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad3()
                        .clickNextButton(new AlzheimerClosePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);


/*        TransitionStatementCC transitionStatementCC = procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6612-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6612-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6612-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6612-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005313-QS6612-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithTitle(transitionStatementCC.titleIBSExpected)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
                        "Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
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
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1)
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageCC);

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015126-QS44-STUDYQUES", protocol1)
                .back();
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015126-QS44-STUDYQUES", protocol1)
                .back();
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
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
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
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
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
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
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);

        KidneyProblemsPage kidneyProblemsPage = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new KidneyProblemsPage());

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocol1)
                .back();
        whichOfTheFollowingLiverProblemsPageСС
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
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1)
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1)
                .back();
        followingMentalEmotionalHealthPageCC
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

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        IdentificationPageCC identificationPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "270")
                .clickNextButton(new IdentificationPageCC());
//        identificationPageCC
//                .waitForPageLoadNotQ()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("Q0004980-QS60-STUDYQUES", protocol1)
//                .back();
//        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
//                .waitForPageLoad()
//                .setAll("5", "5", "260")
//                .clickNextButton(new LetMeSeePageCC());

        LetMeSeePageCC letMeSeePageCC = new LetMeSeePageCC();

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(identificationPageCC)
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);*/
        }
}

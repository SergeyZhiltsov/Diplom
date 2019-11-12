package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Gout.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.SubquestionHeartPageCC;
import com.acurian.selenium.pages.CC.cv_study.SufferedFollowingHeartRelatedConditionsPageCC;
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

public class CG_4960_CC extends BaseTest {
    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_4960_site},
                {Site.AUT_AMS1_4960S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("4960 LG-GDCL002 LG Chem Gout CC")
    public void cg4960CCTest(Site site) {

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();

        final String phoneNumber = "AUTAMSGOUT";
        final String studyName = "a gout study";
        final String transitionStudyName = "gout";
        final String env = System.getProperty("acurian.env", "STG");


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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());


        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                .getExpectedModifiedTitle(studyName, "450"), "Title is diff");
        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC =
                dateOfBirthPageCC
                        .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                        .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                        .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        ZipCodePageCC zipCodePageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("2002")
                .clickOnAnswer("Female")
                .clickNextButton(new LessThan18YearsOldPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                genderPageCC
                        .waitForPageLoad()
                        .setYear("1943")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        EverDiagnosedWithGoutCC everDiagnosedWithGoutCC = genderPageCC
                .waitForPageLoad()
                .setYear("1960")
                .clickNextButton(new EverDiagnosedWithGoutCC());


        //Q2
        HowManyGoutAttacksCC howManyGoutAttacksCC = everDiagnosedWithGoutCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7902", site.activeProtocols)
                .back(everDiagnosedWithGoutCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyGoutAttacksCC());

        //Q3
        EverTakenMedicationCC everTakenMedicationCC = new EverTakenMedicationCC();
        howManyGoutAttacksCC
                .waitForPageLoad()
                .clickOnAnswer("No gout attacks in the past year")
                .clickNextButton(everTakenMedicationCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksCC)
                .waitForPageLoad()
                .clickOnAnswer("1")
                .clickNextButton(everTakenMedicationCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksCC)
                .waitForPageLoad()
                .clickOnAnswer("2 or more")
                .clickNextButton(everTakenMedicationCC);

        //Q4
        EverTakenFollowingMedicationsCurrentlyOrPastCC everTakenFollowingMedicationsCurrentlyOrPastCC = everTakenMedicationCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadWithCurves("gout")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7904", site.activeProtocols)
                .back(everTakenMedicationCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenFollowingMedicationsCurrentlyOrPastCC());

        //Q5,6,7
        CurrentlyTakingUloricCC сurrentlyTakingUloricCC = everTakenFollowingMedicationsCurrentlyOrPastCC
                .waitForPageLoad()
                .clickOnAnswers("Uloric, also called febuxostat") //continue to Q6
                .clickNextButton(new CurrentlyTakingUloricCC());
        PastThreeMonthsTakenKrystexxaCC pastThreeMonthsTakenKrystexxaCC = сurrentlyTakingUloricCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Select “Yes” in Q6 (current febuxostat) Otherwise disqualify (“Does not meet medication requirements”)
                .clickNextButton(new PastThreeMonthsTakenKrystexxaCC());
        pastThreeMonthsTakenKrystexxaCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(сurrentlyTakingUloricCC)
                .clickOnAnswer("Unsure")
                .clickNextButton(pastThreeMonthsTakenKrystexxaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(сurrentlyTakingUloricCC)
                .waitForPageLoad()
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(pastThreeMonthsTakenKrystexxaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad()
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(pastThreeMonthsTakenKrystexxaCC);

        //Q8
        pastThreeMonthsTakenKrystexxaCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new NonQRtransitionPageCC())
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7908", site.activeProtocols)
                .back();
        TransitionStatementCC transitionStatementCC = pastThreeMonthsTakenKrystexxaCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithCurves(transitionStudyName)
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        //#############General_Health ###########################
        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(new WhatKindOfArthritisCC());


        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whatKindOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisCC)
                .waitForPageLoad()
                .back();
        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageCC());


        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(otherThanSkinCancerPageCC)
                .waitForPageLoad()
                .back();
        SufferedFollowingHeartRelatedConditionsPageCC sufferedFollowingHeartRelatedConditionsPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageCC());


        SubquestionHeartPageCC subquestionHeartPageCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionHeartPageCC());

        //Q15.1	When was the last time that you experienced had a heart attack?
        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC =
                new HeartrelatedMedicalProceduresPageCC();
        List<String> disqualifyQ15 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago",
                "7 - 12 months ago");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.1: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageCC);

        //Q15.2	When was the last time that you experienced had a stroke?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.2: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageCC);

        //Q15.4	When was the last time that you experienced suffered from angina or chest pain that required you to stay in a hospital overnight?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.4: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected4)
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .back();
        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage)
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());

        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .back();
        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            System.out.println(answer);
            followingMentalEmotionalHealthPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);


        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ24_QS59 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis", "Drug or alcohol abuse within the past year", "Hepatitis B",
                "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ24_QS59) {
            System.out.println("Select answer for Q24_QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ24_QS59p2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ24_QS59p2) {
            System.out.println("Select answer for Q24_QS59p2: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);


        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "252") //Disqualify ("High BMI") if > 42
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC)
                .setLbs("160")
                .clickNextButton(letMeSeePageCC);


        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());


        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());

        switch (site) {
            case AUT_AMS1_4960_site:
                siteSelectionPageCC
                        .waitForPageLoad(studyName)
                        .clickOnAnswer(site.name)
                        .getPID()
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new SynexusHealthyMindsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);

                break;
            case AUT_AMS1_4960S_site:
                SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = siteSelectionPageCC
                        .waitForPageLoad(studyName)
                        .clickOnAnswer(site.name)
                        .getPID()
                        .clickNextButton(new SynexusRadiantDirectScheduleCC());

                synexusRadiantDirectScheduleCC
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "03/02/1960", "US",
                                "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", "aut4960S", site.name,
                                "LGLPPDGOU002")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo)
                        .assertGeneratedFul(env, site)
                        .getRadiantDbToLog(env);
                break;
        }
    }
}

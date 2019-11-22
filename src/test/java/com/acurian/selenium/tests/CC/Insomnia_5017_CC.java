package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.insomnia_5017.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Insomnia_5017_CC extends BaseTest {

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
                {Site.AUT_INS_5017_site}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("Insomnia 5017 CC (Idorsia Insomnia)")
    public void insomnia5017ccTest(Site site) {
        String phoneNumber = "AUTAMS1INS";
        String studyName = "an insomnia study";
        String transitionStatement = "insomnia";
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle(studyName, "1,450"), "Title is diff");
        dateOfBirthPageCC
                .waitForPageLoad(studyName, "1,450")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")//If "No", go to Does Not Give Permission to Proceed Close
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad(studyName, "1,450")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());
//                .setMonth("Apr")
//                .setDay("18")
//                .setYear("1955")//Disqualify ("Age") if < 65
//                .clickOnAnswer("Yes")
//                .clickNextButton(new ZipCodePageCC());
//        zipCodePageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
//                .back(dateOfBirthPageCC);
//
//        dateOfBirthPageCC
//                .waitForPageLoad()
//                .setMonth("Apr")
//                .setDay("5")
//                .setYear("1953")
//                .clickNextButton(zipCodePageCC);

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromInsomniaPageCC doYouSufferFromInsomniaPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("5")
                .setYear("1953")
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromInsomniaPageCC());

        //Q2
        OftenSleepProblemsPageCC oftenSleepProblemsPageCC = doYouSufferFromInsomniaPageCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No Insomnia")
                .clickNextButton(new NonQRtransitionPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7302", site.activeProtocols)
                .back(doYouSufferFromInsomniaPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OftenSleepProblemsPageCC());
        //Q3
        LongSleepProblemsPageCC longSleepProblemsPageCC = oftenSleepProblemsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less often (a few times per month, etc.)") //Disqualify (“Frequency < 3 nights/week”)
                .clickNextButton(new LongSleepProblemsPageCC());
        longSleepProblemsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7303", site.activeProtocols)
                .back(oftenSleepProblemsPageCC)
                .clickOnAnswer("1 – 2 nights per week") //Disqualify (“Frequency < 3 nights/week”)
                .clickNextButton(longSleepProblemsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7303", site.activeProtocols)
                .back(oftenSleepProblemsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("3 – 4 nights per week")
                .clickNextButton(longSleepProblemsPageCC);
        //Q4
        HealthcareDiagnosedAnySleepPageCC healthcareDiagnosedAnySleepPageCC = longSleepProblemsPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 months or less") //Disqualify (“Insomnia duration < 3 months – Temp 3”)
                .clickNextButton(new HealthcareDiagnosedAnySleepPageCC());
        healthcareDiagnosedAnySleepPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7304", site.activeProtocols)
                .back(longSleepProblemsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months")
                .clickNextButton(healthcareDiagnosedAnySleepPageCC);
        //Q5
        HashMap<String, List<String>> disqualifyQ5 = new HashMap<>(); //Disqualify (“Exclusionary sleep disorder”)
        RotatingNightShiftPageCC rotatingNightShiftPageCC = new RotatingNightShiftPageCC();
        disqualifyQ5.put("Circadian rhythm sleep-wake disorder", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Sleep apnea", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Narcolepsy", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Hypersomnia", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Restless leg syndrome", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Periodic limb movement disorder", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("REM sleep behavior disorder", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Sleep terrors", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Sleepwalking disorder", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ5.entrySet()) {
            System.out.println(entry.getKey());
            healthcareDiagnosedAnySleepPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(rotatingNightShiftPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7305", site.activeProtocols)
                    .back(healthcareDiagnosedAnySleepPageCC);
        }

        healthcareDiagnosedAnySleepPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(rotatingNightShiftPageCC);
        //Q6
        DoYouHaveUpcomingOrRoutineTravelPlansPageCC doYouHaveUpcomingOrRoutineTravelPlansPageCC = rotatingNightShiftPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Disqualify (“Night shift or alternating sleep schedule”)
                .clickNextButton(new DoYouHaveUpcomingOrRoutineTravelPlansPageCC());
        doYouHaveUpcomingOrRoutineTravelPlansPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7306", site.activeProtocols)
                .back(rotatingNightShiftPageCC);
        //Q7
        rotatingNightShiftPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doYouHaveUpcomingOrRoutineTravelPlansPageCC);

        OvernightVisitsSleepCenterPageCC overnightVisitsSleepCenterPageCC = doYouHaveUpcomingOrRoutineTravelPlansPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OvernightVisitsSleepCenterPageCC());

        overnightVisitsSleepCenterPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7312", site.activeProtocols)
                .back(doYouHaveUpcomingOrRoutineTravelPlansPageCC);

        doYouHaveUpcomingOrRoutineTravelPlansPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(overnightVisitsSleepCenterPageCC);


        //Q8
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                overnightVisitsSleepCenterPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new TransitionStatementCC())
                        .waitForPageLoadWithCurves(transitionStatement)
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

//-------------------New GENERAL HEALTH---------------------------
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
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, " +
                                "schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisCC());
        whatKindOfArthritisCC
                .waitForPageLoad()
                .back();
        //Q2: QS38
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("ADHD or attention deficit hyperactivity disorder") //If exclusively selected, skip to Q24)
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        //Check flow logic for Q2
        //Q4: QS40
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();

        WhichFollowingBonesJoints_CC whichFollowingBonesJoints_CC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")//Select
                        .clickNextButton(new WhichFollowingBonesJoints_CC());

        whichFollowingBonesJoints_CC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC); //Back to Q2: QS38

        WhichOfTheFollowingBreathingLungPageСС whichOfTheFollowingBreathingLungPageСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                        .clickNextButton(new WhichOfTheFollowingBreathingLungPageСС());
        //Q5: QS41
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .clickOnAnswers("COPD")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS41", site.activeProtocols)
                .back(whichOfTheFollowingBreathingLungPageСС)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhenDiagnosedWithCancerCC otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        //Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        //Q6: QS42
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .back();

        WhichTypeOfHeadacheCC whichTypeOfHeadacheCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(new WhichTypeOfHeadacheCC());
        //Q10: QS45
        whichTypeOfHeadacheCC
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        //Q11: QS46
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC()); //Display Q12.1: QS47A
        //Q12.1 - 12.4:
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        //Q11: QS46
        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC =
                haveYouEverExperiencedHeartRelatedMedicalCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC()); //Skip to Q13
        //Q13: QS48
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        DoYouTakeAnyMedicationsControlHypertension_CC doYouTakeAnyMedicationsControlHypertension_CC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("High blood pressure or hypertension")
                        .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC());
        //Q15: QS50
        doYouTakeAnyMedicationsControlHypertension_CC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());
        //Q8: QS44
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back();

        //Q16: QS51
        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        //Q17: QS52
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfTheFollowingLiverProblemsPageСС);
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        //Q18: QS53
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Generalized anxiety disorder (GAD)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Major depressive disorder (MDD) or depression")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC());
        //Q19: QS54
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingSkinConditionsDoYouSufferСС whichOfTheFollowingSkinConditionsDoYouSufferСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                        .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WomenHealthConditionsCC womenHealthConditionsCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WomenHealthConditionsCC());
        //Q22: QS57
        womenHealthConditionsCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());

        womenHealthConditionsCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        //Flow for Q2: QS38 was checked

        //Q24: QS59
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis C",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS)",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia",
                        "None of the above")
                .clickNextButton(new ApproximateHeightPageCC());
        //Q28: QS60
        approximateHeightPageCC
                .waitForPageLoad()
                .back();
        //Q24: QS59
        HashMap<String, List<String>> disqualifyQ24 = new HashMap<>();
        disqualifyQ24.put("Bipolar disorder", Arrays.asList(site.activeProtocols)); //Disqualify ("Bipolar disorder")
        disqualifyQ24.put("Cirrhosis", Arrays.asList(site.activeProtocols)); //Disqualify ("Cirrhosis")
        disqualifyQ24.put("Drug or alcohol abuse within the past year", Arrays.asList(site.activeProtocols)); //Disqualify ("Substance abuse")
        disqualifyQ24.put("HIV or AIDS", Arrays.asList(site.activeProtocols)); //Disqualify ("HIV")
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            System.out.println(entry.getKey());
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "3", "100")
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC); //Disqualify ("Low BMI") if < 18
        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("3", "5", "100")
                .clickNextButton(letMeSeePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC); //Disqualify ("High BMI") if > 40
        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("3", "6", "100")
                .clickNextButton(letMeSeePageCC);

        IdentificationPageCC identificationPageCC =  letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();

        switch (site) {
            case AUT_INS_5017_site:
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        //.clickOnAnswer("No")
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
//            case AUT_INS_5017S_site:
//                selectionPageCC
//                        .clickOnAnswer(site.name)
//                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
//                        .waitForPageLoadSyn()
//                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
//                        .clickNextButton(selectActionPageCC)
//                        .waitForPageLoad()
//                        .pidFromDbToLog(env)
//                        .childPidFromDbToLog(env)
//                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
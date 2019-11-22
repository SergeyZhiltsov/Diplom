package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_OLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.insomnia_5017.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
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

public class Insomnia_5017_OLS extends BaseTest {

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
                //{Site.AUT_INS_5017S_site}, //Not required
                {Site.AUT_INS_5017_site}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("Insomnia 5017 OLS (Idorsia Insomnia)")
    public void insomnia5017olsTest(Site site) {
        String phoneNumber = "AUTAMS1INS";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("an insomnia study", "1,450");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle("an insomnia study", "1,450"), "Title is diff");
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
        DoYouSufferFromInsomniaPageOLS doYouSufferFromInsomniaPageOLS = genderPageOLS
                .setDate("09091940")
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromInsomniaPageOLS());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                doYouSufferFromInsomniaPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7302", site.activeProtocols)
                .back();

        //Q2
        OftenSleepProblemsPageOLS oftenSleepProblemsPageOLS = doYouSufferFromInsomniaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No Insomnia")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7302", site.activeProtocols)
                .back(doYouSufferFromInsomniaPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OftenSleepProblemsPageOLS());
        //Q3
        LongSleepProblemsPageOLS longSleepProblemsPageOLS = oftenSleepProblemsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less often (a few times per month, etc.)") //Disqualify (“Frequency < 3 nights/week”)
                .clickNextButton(new LongSleepProblemsPageOLS());
        longSleepProblemsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7303", site.activeProtocols)
                .back(oftenSleepProblemsPageOLS)
                .clickOnAnswer("1 – 2 nights per week") //Disqualify (“Frequency < 3 nights/week”)
                .clickNextButton(longSleepProblemsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7303", site.activeProtocols)
                .back(oftenSleepProblemsPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 – 4 nights per week")
                .clickNextButton(longSleepProblemsPageOLS);
        //Q4
        HealthcareDiagnosedAnySleepPageOLS healthcareDiagnosedAnySleepPageOLS = longSleepProblemsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months or less") //Disqualify (“Insomnia duration < 3 months – Temp 3”)
                .clickNextButton(new HealthcareDiagnosedAnySleepPageOLS());
        healthcareDiagnosedAnySleepPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7304", site.activeProtocols)
                .back(longSleepProblemsPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months")
                .clickNextButton(healthcareDiagnosedAnySleepPageOLS);
        //Q5
        HashMap<String, List<String>> disqualifyQ5 = new HashMap<>(); //Disqualify (“Exclusionary sleep disorder”)
        RotatingNightShiftPageOLS rotatingNightShiftPageOLS = new RotatingNightShiftPageOLS();
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
            healthcareDiagnosedAnySleepPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(rotatingNightShiftPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7305", site.activeProtocols)
                    .back(healthcareDiagnosedAnySleepPageOLS);
        }

        healthcareDiagnosedAnySleepPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(rotatingNightShiftPageOLS);
        //Q6
        DoYouHaveUpcomingOrRoutineTravelPlansPageOLS doYouHaveUpcomingOrRoutineTravelPlansPageOLS = rotatingNightShiftPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Disqualify (“Night shift or alternating sleep schedule”)
                .clickNextButton(new DoYouHaveUpcomingOrRoutineTravelPlansPageOLS());

        doYouHaveUpcomingOrRoutineTravelPlansPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7306", site.activeProtocols)
                .back(rotatingNightShiftPageOLS);
        //Q7
        rotatingNightShiftPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doYouHaveUpcomingOrRoutineTravelPlansPageOLS);

        OvernightVisitsSleepCenterPageOLS overnightVisitsSleepCenterPageOLS = doYouHaveUpcomingOrRoutineTravelPlansPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OvernightVisitsSleepCenterPageOLS());

        overnightVisitsSleepCenterPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7312", site.activeProtocols)//todo QS number
                .back(doYouHaveUpcomingOrRoutineTravelPlansPageOLS);

        doYouHaveUpcomingOrRoutineTravelPlansPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(overnightVisitsSleepCenterPageOLS);
        //Q8
        overnightVisitsSleepCenterPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

////-------------------New GENERAL HEALTH---------------------------
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .back();
        //Q2: QS38
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("ADHD or attention deficit hyperactivity disorder") //If exclusively selected, skip to Q24)
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        //Check flow logic for Q2
        //Q4: QS40
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")//Select
                        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());

        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS); //Back to Q2: QS38

        WhichOfTheFollowingBreathingLungPageOLS whichOfTheFollowingBreathingLungPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                        .clickNextButton(new WhichOfTheFollowingBreathingLungPageOLS());
        //Q5: QS41
        whichOfTheFollowingBreathingLungPageOLS
                .waitForPageLoad()
                .clickOnAnswers("COPD")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS41", site.activeProtocols)
                .back(whichOfTheFollowingBreathingLungPageOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        //Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .back();

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        //Q6: QS42
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .back();

        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
        //Q10: QS45
        whichTypeOfHeadacheDoYouGetOLS
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        //Q11: QS46
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack")
                        .clickOnAnswers("Stroke")
                        .clickOnAnswers("Mini-Stroke or TIA")
                        .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                        .clickNextButton(new SubquestionExperiencedHeartPageOLS()); //Display Q12.1: QS47A
        //Q12.1 - 12.4:
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        //Q11: QS46
        HeartrelatedMedicalProceduresPageOLS haveYouUndergoneAnyOfFollowingHeartRelatedProcCC =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HeartrelatedMedicalProceduresPageOLS()); //Skip to Q13
        //Q13: QS48
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        DoYouTakeAnyMedicationsControlHypertension_OLS doYouTakeAnyMedicationsControlHypertension_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("High blood pressure or hypertension")
                        .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_OLS());
        //Q15: QS50
        doYouTakeAnyMedicationsControlHypertension_OLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
        //Q8: QS44
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back();

        //Q16: QS51
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Kidney disease")
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS);
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        //Q18: QS53
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Generalized anxiety disorder (GAD)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageOLS);
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Major depressive disorder (MDD) or depression")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageOLS);
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageOLS);
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageOLS);

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
        //Q19: QS54
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                        .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WomenHealthConditions womenHealthConditions = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WomenHealthConditions());
        //Q22: QS57
        womenHealthConditions
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());

        womenHealthConditions
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        //Flow for Q2: QS38 was checked

        //Q24: QS59
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
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
                .clickNextButton(new ApproximateHeightPageOLS());
        //Q28: QS60
        approximateHeightPageOLS
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
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }

        //Q24: QS59
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

        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "3", "100")
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());
        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageOLS) //Disqualify ("Low BMI") if < 18
                .waitForPageLoad()
                .setAll("3", "5", "100")
                .clickNextButton(doYouExperienceAnyOfFollowingSymptoms_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageOLS); //Disqualify ("High BMI") if > 40
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("3", "6", "100")
                .clickNextButton(new IdentificationPageOLS());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad("an insomnia")
                .getPID();
        siteSelectionPageOLS
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClosedPageOLS())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "5017")
                .dispoShouldMatch(site.dispo, site.dispo)
                .assertGeneratedFul(env, site);
    }
}
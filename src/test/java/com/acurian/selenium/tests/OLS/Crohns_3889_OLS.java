package com.acurian.selenium.tests.OLS;


import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ADG_4357.EverDiagnosedGastroparesisOrStomachEmptyingOLS;
import com.acurian.selenium.pages.OLS.ADG_4357.FollowingAreCommonSymptomsOLS;
import com.acurian.selenium.pages.OLS.Crohns.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CurrentlyTreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.GERD.CurrentlySufferOfAnyOfFollowingOLS;
import com.acurian.selenium.pages.OLS.GERD.DuringPastThreeMonthsOLS;
import com.acurian.selenium.pages.OLS.GERD.UseMarijuanaOrCannabisOLS;
import com.acurian.selenium.pages.OLS.GERD.WhatTypeOfSurgeryDidYouHave_OLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crohns_3889_OLS extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] flare() {
        return new Object[][]{
                {true}
//                {false}
        };
    }

    @Test(dataProvider = "flare")
    @Description("Crohns_3889_OLS")
    public void Crohns_3889_OLS(boolean inFlare) {
        Site site = Site.AUT_CRN_3889_HS;
        String phoneNumber = "AUTAMS1IBD";
        String protocol1 = "M14_431";
        String protocol2 = "M14_433";
        String protocol3 = "M15_991";
        String protocol4 = "M16_006";
        //String studyName = "a Crohn's or colitis"; // For IBD-UC modules
        String studyName = "a Crohn's";
        String site_Indication = "a Crohn's or colitis";
        String indication = "a Crohn's Disease";
        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad("a Crohn's or colitis study", "700");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
//                dateOfBirthPageOLS.getExpectedModifiedTitle("a Crohn's or colitis study", "700"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoad("a Crohn's or colitis study", "700");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());
//        GenderPageOLS genderPageOLS = personalDetails
//                .waitForPageLoad()
//                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
//                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS = genderPageOLS
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS());
        EverDiagnosedWithFollowingConditionsOLS everDiagnosedWithFollowingConditionsOLS = new EverDiagnosedWithFollowingConditionsOLS();
        WhenDiagnosedWithCronsDiseaseOLS whenDiagnosedWithCronsDiseaseOLS = everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
//                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenDiagnosedWithCronsDiseaseOLS());
        AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS asPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS = whenDiagnosedWithCronsDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8103", site.activeProtocols)
                .back(whenDiagnosedWithCronsDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(new AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS());
        EverTakenAnyMedicationOLS everTakenAnyMedicationOLS = asPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTakenAnyMedicationOLS())
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8104", site.activeProtocols)
                .back(asPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new EverTakenAnyMedicationOLS());
        EverTakenSteroidsOLS everTakenSteroidsOLS = everTakenAnyMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PreviousDayGeneralWellBeingOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8105", site.activeProtocols)
                .back(everTakenAnyMedicationOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenSteroidsOLS());
        EverTakenAnyOfFollowingMedicationsOLS everTakenAnyOfFollowingMedicationsOLS = new EverTakenAnyOfFollowingMedicationsOLS();
        EverTreatedYourCronsOLS everTreatedYourCronsOLS = new EverTreatedYourCronsOLS();
        BiologicMedications biologicMedicationsOLS = new BiologicMedications();
        PreviousDayGeneralWellBeingOLS previousDayGeneralWellBeingOLS = new PreviousDayGeneralWellBeingOLS();
        everTakenSteroidsOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(everTakenAnyOfFollowingMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(biologicMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("Stelara")
                .clickNextButton(previousDayGeneralWellBeingOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8110", site.activeProtocols[1], site.activeProtocols[2], site.activeProtocols[3])
                .back(biologicMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(previousDayGeneralWellBeingOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8110", site.activeProtocols)
                .back(biologicMedicationsOLS)
                .waitForPageLoad()
                .back(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .back(everTakenAnyOfFollowingMedicationsOLS)
                .waitForPageLoad()
                .back(everTakenSteroidsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(everTakenAnyOfFollowingMedicationsOLS);
        everTakenAnyOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickNextButton(everTreatedYourCronsOLS);
        everTreatedYourCronsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Jakafi (ruxolitinib)")
                .clickNextButton(biologicMedicationsOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8108", site.activeProtocols[0], site.activeProtocols[1])
                .back(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xeljanz (tofacitinib)")
                .clickNextButton(biologicMedicationsOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8108", site.activeProtocols[0], site.activeProtocols[1])
                .back(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(biologicMedicationsOLS);
        PreviousDayAbdominalPainOLS previousDayAbdominalPainOLS = new PreviousDayAbdominalPainOLS();
        PreviousDayDiarrheaOrLiquidStoolOLS previousDayDiarrheaOrLiquidStoolOLS = new PreviousDayDiarrheaOrLiquidStoolOLS();
        ExperiensingAnyPainInJointsOLS experiensingAnyPainInJointsOLS = new ExperiensingAnyPainInJointsOLS();
        CurrentlyHaveUlcersOrSoresOLS currentlyHaveUlcersOrSoresOLS = new CurrentlyHaveUlcersOrSoresOLS();
        CurrentlyHaveAnyFollowingOLS currentlyHaveAnyFollowingOLS = new CurrentlyHaveAnyFollowingOLS();
        biologicMedicationsOLS
                .clickOnAnswers("Cimzia")
                .waitForPageLoad()
                .clickNextButton(previousDayGeneralWellBeingOLS);


        //not in flare
        previousDayGeneralWellBeingOLS
                .waitForPageLoad()
                .clickOnAnswer("Very well")
                .clickNextButton(previousDayAbdominalPainOLS)
                .waitForPageLoad()
                .clickOnAnswer("None")
                .clickNextButton(previousDayDiarrheaOrLiquidStoolOLS)
                .waitForPageLoad()
                .setStools("1")
                .clickNextButton(experiensingAnyPainInJointsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveUlcersOrSoresOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveAnyFollowingOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8116", site.activeProtocols);

        //        .flareCodeShouldMatch(env, "3");

        //backflareCodeShouldMatch
        currentlyHaveAnyFollowingOLS
                .waitForPageLoad()
                .back(currentlyHaveUlcersOrSoresOLS)
                .waitForPageLoad()
                .back(experiensingAnyPainInJointsOLS)
                .waitForPageLoad()
                .back(previousDayDiarrheaOrLiquidStoolOLS)
                .waitForPageLoad()
                .back(previousDayAbdominalPainOLS)
                .waitForPageLoad()
                .back(previousDayGeneralWellBeingOLS);

        //in flare
        previousDayGeneralWellBeingOLS
                .waitForPageLoad()
                .clickOnAnswer("Very poor")
                .clickNextButton(previousDayAbdominalPainOLS)
                .waitForPageLoad()
                .clickOnAnswer("Severe")
                .clickNextButton(previousDayDiarrheaOrLiquidStoolOLS)
                .waitForPageLoad()
                .setStools("3")
                .clickNextButton(experiensingAnyPainInJointsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveUlcersOrSoresOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveAnyFollowingOLS);
        //.waitForPageLoad()
        //.flareCodeShouldMatch(env, "11");





        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();

        HashMap<String, String[]> options = new HashMap<>();
        options.put("History of a bowel resection within the past 3 months", site.activeProtocols);
        options.put("Colostomy", site.activeProtocols);
        options.put("Ileostomy", site.activeProtocols);
        options.put("An abscess in your abdomen or pelvic region (an inflamed area with collection of pus)", site.activeProtocols);
        options.put("Feeding tube", site.activeProtocols);
        options.put("IV (parenteral) nutrition", site.activeProtocols);
        options.put("A planned or scheduled surgery for Crohn’s disease", site.activeProtocols);
        for (Map.Entry<String, String[]> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            currentlyHaveAnyFollowingOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS8117", entry.getValue())
                    .back();
        }
        currentlyHaveAnyFollowingOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        //----------****************NEW GENERAL HEALTH Questions************************----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
//        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
//////                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
//////                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
//////                        "Autism spectrum",
//////                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
//////                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
//////                        "Cancer",
//////                        "Diabetes (type 1 or type 2)",
//////
//////                        "Headaches (migraine, cluster, tension)",
//////                        "Heart or circulation problems (heart attack, heart failure, stroke)",
//////                        "High blood pressure or hypertension",
//////                        "High cholesterol, triglycerides, or lipids",
//////                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
//////                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
//////                        "Kidney disease",
//////                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
//////
//////                        "Lupus",
//////                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
//////                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
//////                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
//////
//////                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
//////                        "Women's health issues (endometriosis, uterine fibroids)",
//////                        "None of the above")
//////                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
//////
//////        //----------Q3 WhatKindOfArthritisPageOLS Page--------------------
//////        whatKindOfArthritisPageOLS.waitForPageLoad();
//////        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS = whatKindOfArthritisPageOLS
//////                .clickOnAnswers("Unsure")
//////                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());
//////
//////
//////        //----------Q4 - Which of the following have you been diagnosed with?--------
//////        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
//////                .waitForPageLoad();
//////        WhichOfFollowingHaveYouDiagnosedWithOLS whichOfFollowingHaveYouDiagnosedWithOLS = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
//////                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis",
//////                        "Gout",
//////                        "Low back pain",
//////                        "Osteoporosis")
//////                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWithOLS());
//////
//////
//////        //----------Q5 - whichOfFollowingHaveYouDiagnosedWithOLS --------------------
//////        whichOfFollowingHaveYouDiagnosedWithOLS
//////                .waitForPageLoad();
//////        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = whichOfFollowingHaveYouDiagnosedWithOLS
//////                .clickOnAnswers(
//////                        "Asthma",
//////                        "Chronic cough",
//////
//////                        "Chronic bronchitis",
//////                        "COPD",
//////
//////                        "Emphysema")
//////                .clickNextButton(new WhenDiagnosedWithCancerOLS());
//////
//////
//////        //----------Q6 - When were you diagnosed with cancer (other than skin cancer)? --------------------
//////        whenDiagnosedWithCancerOLS
//////                .waitForPageLoad();
//////        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = whenDiagnosedWithCancerOLS
//////                .clickOnAnswer("Within the past 5 years")
//////                .clickNextButton(new WhatKindOfDiabetesPageOLS());
//////        whatKindOfDiabetesPageOLS
//////                .waitForPageLoad()
//////                .getPage(debugPageOLS)
//////                .checkProtocolsContainsForQNumber("QS42", protocol1, protocol2, protocol3, protocol4)
//////                .back();
//////        whenDiagnosedWithCancerOLS
//////                .waitForPageLoad()
//////                .clickOnAnswer("Diagnosed with skin cancer only")
//////                .clickNextButton(new WhatKindOfDiabetesPageOLS());
//////
//////
//////        //----------Q7 - What kind of diabetes do you have? --------------------
//////        whatKindOfDiabetesPageOLS
//////                .waitForPageLoad();
//////        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = whatKindOfDiabetesPageOLS
//////                .clickOnAnswer("Unsure")
//////                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
//////
//////
//////        //----------Q8 - Which of the following have you been diagnosed with by a doctor? --------------------
//////        whichOfFollowingDigestiveConditionPageOLS
//////                .waitForPageLoad();
//////        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = whichOfFollowingDigestiveConditionPageOLS
//////                .clickOnAnswers("IBS, or irritable bowel syndrome")
//////                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
//////
//////
//////        //----------Q9 - Which of the following have you been diagnosed with? (eating disorder)--------------------
////////        whichOfTheFollowingHaveYouBeenDiagnosed_OLS
////////                .waitForPageLoad();
////////        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = whichOfTheFollowingHaveYouBeenDiagnosed_OLS
////////                .clickOnAnswers("Anorexia",
////////                        "Bulimia",
////////                        "Binge eating disorder")
////////                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
//////
//////
//////        //----------Q10 - Which type of headache do you typically get? --------------------
//////        whichTypeOfHeadacheDoYouGetOLS
//////                .waitForPageLoad();
//////        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whichTypeOfHeadacheDoYouGetOLS
//////                .clickOnAnswers("Migraine",
//////                        "Cluster headache",
//////                        "Tension headache")
//////                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
//////
//////
//////        //----------Q11 - Have you ever experienced or been diagnosed with any of the following specific heart-related medical conditions? --------------------
//////        haveYouEverExperiencedHeartRelatedMedicalCondOLS
//////                .waitForPageLoad();
//////        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
//////                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
//////                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
//////                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
//////        subquestionExperiencedHeartPageOLS
//////                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//////                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//////                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
//////                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4);
//////        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "4 - 6 months ago")
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "4 - 6 months ago")
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "4 - 6 months ago")
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "4 - 6 months ago")
//////                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
//////        heartrelatedMedicalProceduresPageOLS
//////                .waitForPageLoad()
//////                .getPage(debugPageOLS)
//////                .checkProtocolsContainsForQNumber("QS47", protocol1, protocol2, protocol3, protocol4)
//////                .back();
//////        subquestionExperiencedHeartPageOLS
//////                .waitForPageLoad()
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
//////                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
//////                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
//////
//////
//////        //--------------Q13:  Have you undergone any of the following heart-related medical procedures?--------------
//////        heartrelatedMedicalProceduresPageOLS
//////                .waitForPageLoad();
//////        DoYouTakeAnyMedicationsToControlHighBloodPressureOLS doYouTakeAnyMedicationsToControlHighBloodPressureOLS = heartrelatedMedicalProceduresPageOLS
//////                .clickOnAnswers("None of the above")
//////                .clickNextButton(new DoYouTakeAnyMedicationsToControlHighBloodPressureOLS());
//////
//////
//////        //--------------Q15:  Do you take any medications to control your high blood pressure or hypertension?---------
//////        doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//////                .waitForPageLoad();
//////        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//////                .clickOnAnswer("Unsure")
//////                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
//////
//////
//////        //--------------Q16: WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS ---------
//////        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
//////                .waitForPageLoad();
//////        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
//////                .clickOnAnswers("Dialysis", "Kidney transplant")
//////                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
//////        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//////                .waitForPageLoad()
//////                .getPage(debugPageOLS)
//////                .checkProtocolsContainsForQNumber("QS51", protocol1, protocol2, protocol3, protocol4)
//////                .back();
//////        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
//////                .waitForPageLoad()
//////                .clickOnAnswers("Neither")
//////                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
//////
//////
//////        //--------------Q17: Which of the following have you been diagnosed with? ---------
//////        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//////                .waitForPageLoad();
//////        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//////                .clickOnAnswers("Cirrhosis")
//////                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
//////        following_MentalEmotionalHealthPageOLS
//////                .waitForPageLoad()
//////                .getPage(debugPageOLS)
//////                .checkProtocolsContainsForQNumber("QS52", protocol1, protocol2, protocol3, protocol4)
//////                .back();
//////        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//////                .waitForPageLoad()
//////                .clickOnAnswers("Unsure which type of liver disease")
//////                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
//////
//////
//////        //--------------Q18--FollowingMentalEmotionalHealthPageOLS -----------
//////        following_MentalEmotionalHealthPageOLS
//////                .waitForPageLoad();
//////        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS = following_MentalEmotionalHealthPageOLS
//////                .clickOnAnswers("Bipolar disorder", "Schizophrenia")
//////                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
//////        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
//////                .waitForPageLoad()
//////                .getPage(debugPageOLS)
//////                .checkProtocolsContainsForQNumber("QS53", protocol1, protocol2, protocol3, protocol4)
//////                .back();
//////        following_MentalEmotionalHealthPageOLS
//////                .waitForPageLoad()
//////                .clickOnAnswers("None of the above")
//////                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
//////
//////
//////        //--------------Q19:  WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS-----------------------
//////        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
//////                .waitForPageLoad();
//////        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS = whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
//////                .clickOnAnswers("Memory loss",
//////                        "Parkinson's disease",
//////                        "Multiple sclerosis (MS)",
//////                        "Seizure disorder, such as epilepsy",
//////                        "Fibromyalgia",
//////                        "None of the above")
//////                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
//////
//////
//////        //--------------Q20:  WhichOfTheFollowingSkinConditionsDoYouSufferOLS-----------------------
//////        whichOfTheFollowingSkinConditionsDoYouSufferOLS
//////                .waitForPageLoad();
//////        WomenHealthConditionsOLS womenHealthConditionsOLS = whichOfTheFollowingSkinConditionsDoYouSufferOLS
//////                .clickOnAnswers("None of the above")
//////                .clickNextButton(new WomenHealthConditionsOLS());
//////
//////
//////        //--------------Q21:  Which of the following sleep-related conditions have you been diagnosed with?-----------------------
////////        whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS
////////                .waitForPageLoad();
////////        WomenHealthConditions womenHealthConditions = whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS
////////                .clickOnAnswers("Narcolepsy",
////////                        "Sleep apnea",
////////                        "Insomnia",
////////                        "None of the above")
////////                .clickNextButton(new WomenHealthConditions());
//////
//////
//////        //--------------Q22:  Which of the following sleep-related conditions have you been diagnosed with?-----------------------
//////        womenHealthConditionsOLS
//////                .waitForPageLoad();
//////        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = womenHealthConditionsOLS
//////                .clickOnAnswers("Uterine fibroids")
//////                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
//////
//////
//////        //----------Q23 - Do any of the following additional diagnoses apply to you?--------
//////        doAnyOftheFollowingAdditionalDiagnosesOLS
//////                .waitForPageLoad();
//////        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
//////                .clickOnAnswers("Drug or alcohol abuse within the past year",
//////                        "Hepatitis B",
//////                        "Hepatitis C",
//////                        "HIV or AIDS",
//////                        "Neuropathy (nerve damage due to diabetes or another condition)")
//////                .clickNextButton(new ApproximateHeightPageOLS());
//////        approximateHeightPageOLS
//////                .waitForPageLoad()
//////                .getPage(debugPageOLS)
//////                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
//////                .back();
//////        doAnyOftheFollowingAdditionalDiagnosesOLS
//////                .waitForPageLoad()
//////                .clickOnAnswers("None of the above")
//////                .clickNextButton(new HormonalBirthControlOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = new HaveYouEverExperiencedHeartRelatedMedicalCondOLS();
        SubquestionExperiencedHeartPageOLS subquestionHeartPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS())
                .waitForPageLoad();
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = new HeartrelatedMedicalProceduresPageOLS();
        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.1GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad()
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .waitForPageLoad(2, subquestionHeartPageOLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(2, answer)
                    .waitForPageLoad(3, subquestionHeartPageOLS.titleExpected3)
                    .clickOnAnswerForSubQuestion(3, answer)
                    .waitForPageLoad(4, subquestionHeartPageOLS.titleExpected4)
                    .clickOnAnswerForSubQuestion(4, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS kidneyProblemsPage = subquestionHeartPageOLS
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back();

        kidneyProblemsPage
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(new FollowingMentalEmotionalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(new FollowingMentalEmotionalHealthPageOLS())
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
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


        //--------------Q26:  Are you currently taking a hormonal form of birth control?-----------------------
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                //WhatTypeOfLupusOLS whatTypeOfLupusOLS = approximateHeightPageOLS
                .setAll("5", "5", "160")
//        		.clickNextButton(new ChildrenUnderPageOLS())
//		//----------ChildrenUnderTheAge Page--------------------
//		        .waitForPageLoad()
//		        .clickOnAnswer("Yes")
//		        .clickNextButton(new HouseholdHavePageOLS())
//		        .waitForPageLoad()
//		        .clickOnAnswers("None of the above")
//		        .clickNextButton(new TheStudySitePageOLS())
//		        .waitForPageLoad()
//
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//		        .clickOnAnswer("Public transportation")
//		        .clickNextButton(new WhatMedicalCoveragePageOLS())
//		        .waitForPageLoad()
//		        .clickOnAnswers("No, I have no coverage")
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new EverDiagnosedGastroparesisOrStomachEmptyingOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingAreCommonSymptomsOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DuringPastThreeMonthsOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new com.acurian.selenium.pages.OLS.ChronicCough.EverDiagnosedWithFollowingConditionsOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WeightLossSurgeryPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new UseMarijuanaOrCannabisOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedFlareMonitoringAppClosePageOLS qualifiedFlareMonitoringAppClosePageOLS = new QualifiedFlareMonitoringAppClosePageOLS();
        HS1PageOLS hs1PageOLS = new HS1PageOLS();

        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());

//                .clickNextButton(qualifiedFlareMonitoringAppClosePageOLS);
//                .clickNextButton(new QualifiedFlareMonitoringAppClosePageOLS())
//                .waitForPageLoadCrohns()
//                .getActivationCodeCrohns()
        medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoadIBD("Crohn's Disease")
                .clickNextButton(hs1PageOLS)
                .waitForPageLoad()
                .clickOkInPopUp()
                .waitForPageLoad()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();

        if(inFlare) {
//            qualifiedFlareMonitoringAppClosePageOLS
//                    .waitForPageLoadCrohns()
//                    .getActivationCode()
//                    .clickNextButton(thankYouCloseSimplePageOLS)
            thankYouCloseSimplePageOLS
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS())
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        } else {
            qualifiedFlareMonitoringAppClosePageOLS
                    .waitForPageLoadCrohns()
                    .getActivationCode()
                    .clickNextButton(thankYouCloseSimplePageOLS)
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS())
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

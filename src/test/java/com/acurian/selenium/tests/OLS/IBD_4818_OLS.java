package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.HaveAnyOfTheFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.*;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.HashMap;
import java.util.Map;

public class IBD_4818_OLS extends BaseTest {

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
                {true},
//                {false}
        };
    }

    @Test(dataProvider = "flare")
    @Description("IBD_3889_OLS")
    public void ibd4818OlsTest(boolean inFlare) {
        Site site = Site.AUT_IBD_4818_Site;
        String phoneNumber = "AUTAMS1IBD";
        String studyName = "a Crohn's";
        String site_Indication = "a Crohn's or colitis";
        String indication = "a Crohn's Disease";
        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(),
                dateOfBirthPageOLS.getExpectedModifiedTitle("a Crohn's or colitis study", "700"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoad2Ver();
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS = genderPageOLS
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5702", site.activeProtocols)
                .back();
        UlcerativeColitisDoctorOrNursePageOLS ulcerativeColitisDoctorOrNursePageOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new UlcerativeColitisDoctorOrNursePageOLS());
        ulcerativeColitisDoctorOrNursePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5702", site.activeProtocols[1])
                .back();
        CrohnsDiseaseDoctorOrNursePageOLS crohnsDiseaseDoctorOrNursePageOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new CrohnsDiseaseDoctorOrNursePageOLS());

        crohnsDiseaseDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5726", site.activeProtocols)
                .back();
        crohnsDiseaseDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5726", site.activeProtocols)
                .back();
        crohnsDiseaseDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(ulcerativeColitisDoctorOrNursePageOLS);

        WhenWereYouDiagnosedWithCrohnsPageOLS whenWereYouDiagnosedWithCrohnsPageOLS = ulcerativeColitisDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenWereYouDiagnosedWithCrohnsPageOLS());

        WhenWereYouDiagnosedWithUlcerativeColitisPageOLS whenWereYouDiagnosedWithUlcerativeColitisPageOLS = whenWereYouDiagnosedWithCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new WhenWereYouDiagnosedWithUlcerativeColitisPageOLS());
        whenWereYouDiagnosedWithUlcerativeColitisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5703", site.activeProtocols)
                .back();
        whenWereYouDiagnosedWithCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(whenWereYouDiagnosedWithUlcerativeColitisPageOLS);

        ReviewMedicalRecordsCrohnsDiagnosisPageOLS reviewMedicalRecordsCrohnsDiagnosisPageOLS = whenWereYouDiagnosedWithUlcerativeColitisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new ReviewMedicalRecordsCrohnsDiagnosisPageOLS());

        PartOfDiagnosisFollowingProceduresDonePageOLS partOfDiagnosisFollowingProceduresDonePageOLS = reviewMedicalRecordsCrohnsDiagnosisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new PartOfDiagnosisFollowingProceduresDonePageOLS());

        ManageYourCrohnsPageOLS manageYourCrohnsPageOLS = partOfDiagnosisFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ManageYourCrohnsPageOLS());
        manageYourCrohnsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5729", site.activeProtocols)
                .back();
        partOfDiagnosisFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Endoscopy – a thin, flexible, lighted tube is inserted through the mouth. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(manageYourCrohnsPageOLS);

        CrohnsDiseaseOrUlcerativeColitisFlarePageOLS crohnsDiseaseOrUlcerativeColitisFlarePageOLS = manageYourCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CrohnsDiseaseOrUlcerativeColitisFlarePageOLS());
        crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5706", site.activeProtocols)
                .back();
        SteroidMedicationsForCrohnsOLS steroidMedicationsForCrohnsOLS = manageYourCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsForCrohnsOLS());

        FollowingMedicationsCrohnsPageOLS followingMedicationsCrohnsPageOLS = steroidMedicationsForCrohnsOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingMedicationsCrohnsPageOLS());

        EverTreatedCrohnOrColitisOLS everTreatedCrohnOrColitisOLS = followingMedicationsCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTreatedCrohnOrColitisOLS());

        BiologicMedicationsPageOLS biologicMedicationsPageOLS = everTreatedCrohnOrColitisOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageOLS());

        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageOLS);

        crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols)
                .back();

        biologicMedicationsPageOLS
                .waitForPageLoad()
                .back();

        everTreatedCrohnOrColitisOLS
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (ruxolitinib)")
                .clickNextButton(biologicMedicationsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5709", site.activeProtocols[0], site.activeProtocols[1])
                .back();
        everTreatedCrohnOrColitisOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xeljanz (tofacitinib)")
                .clickNextButton(biologicMedicationsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5709", site.activeProtocols[0], site.activeProtocols[1])
                .back();
        everTreatedCrohnOrColitisOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Astagraf, Envarsus, or Prograf (tacrolimus)")
                .clickNextButton(biologicMedicationsPageOLS);

        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Cimzia")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageOLS);

        SubquestionsIbdPleaseThinkCrohnsPageOLS subquestionsIbdPleaseThinkCrohnsPageOLS = crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild symptoms, but tolerable")
                .clickNextButton(new SubquestionsIbdPleaseThinkCrohnsPageOLS());

        SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS subquestionsIbdPleaseThinkUlcerativeColitisPageOLS = subquestionsIbdPleaseThinkCrohnsPageOLS
                .waitForPageLoad()
                .setAvgDayBowelMovements("2")
                .clickOnAnswer("Mild (aware but tolerable)")// not in flare
                .clickNextButton(new SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS());
        if (inFlare) {
            subquestionsIbdPleaseThinkUlcerativeColitisPageOLS
                    .waitForPageLoad()
                    .back();
            subquestionsIbdPleaseThinkCrohnsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("Severe (intolerable)")// in flare
                    .clickNextButton(subquestionsIbdPleaseThinkUlcerativeColitisPageOLS);
        }

        SubquestionsIBD_OLS subquestionsIBD_ols = subquestionsIbdPleaseThinkUlcerativeColitisPageOLS
                .waitForPageLoad()
                .setTotalBowelMovements("20")
                .setTotalpast24hrBowelMovements("20")
                .clickOnAnswer("Yes")
                .clickNextButton(new SubquestionsIBD_OLS());

        HaveAnyOfTheFollowingPageOLS haveAnyOfTheFollowingPageOLS = subquestionsIBD_ols
                .waitForPageLoad(1,subquestionsIBD_ols.titleExpected3)
                .clickOnAnswersForSubQuestion(1,"Abdominal pain or cramps")
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());

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
            haveAnyOfTheFollowingPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5733", entry.getValue())
                    .back();
        }
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


//        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
//                .waitForPageLoad()
//                .clickNextButton(new )




        //----------****************NEW GENERAL HEALTH Questions************************----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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

                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        //----------Q3 WhatKindOfArthritisPageOLS Page--------------------
        whatKindOfArthritisPageOLS.waitForPageLoad();
        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS = whatKindOfArthritisPageOLS
                .clickOnAnswers("Unsure")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());


        //----------Q4 - Which of the following have you been diagnosed with?--------
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad();
        WhichOfFollowingHaveYouDiagnosedWithOLS whichOfFollowingHaveYouDiagnosedWithOLS = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis",
                        "Gout",
                        "Low back pain",
                        "Osteoporosis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWithOLS());


        //----------Q5 - whichOfFollowingHaveYouDiagnosedWithOLS --------------------
        whichOfFollowingHaveYouDiagnosedWithOLS
                .waitForPageLoad();
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = whichOfFollowingHaveYouDiagnosedWithOLS
                .clickOnAnswers(
                        "Asthma",
                        "Chronic cough",

                        "Chronic bronchitis",
                        "COPD",

                        "Emphysema")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

//
//        //----------Q6 - When were you diagnosed with cancer (other than skin cancer)? --------------------
//        otherThanSkinCancerPageOLS
//                .waitForPageLoad();
//        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = otherThanSkinCancerPageOLS
//                .clickOnAnswer("Within the past 5 years")
//                .clickNextButton(new WhatKindOfDiabetesPageOLS());
//        whatKindOfDiabetesPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS42", protocol1, protocol2, protocol3, protocol4)
//                .back();
//        otherThanSkinCancerPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Diagnosed with skin cancer only")
//                .clickNextButton(new WhatKindOfDiabetesPageOLS());
//
//
//        //----------Q7 - What kind of diabetes do you have? --------------------
//        whatKindOfDiabetesPageOLS
//                .waitForPageLoad();
//        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = whatKindOfDiabetesPageOLS
//                .clickOnAnswer("High blood sugar only")
//                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
//
//
//        //----------Q8 - Which of the following have you been diagnosed with by a doctor? --------------------
//        whichOfFollowingDigestiveConditionPageOLS
//                .waitForPageLoad();
//        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = whichOfFollowingDigestiveConditionPageOLS
//                .clickOnAnswers("IBS, or irritable bowel syndrome")
//                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
//
//
//        //----------Q9 - Which of the following have you been diagnosed with? (eating disorder)--------------------
////        whichOfTheFollowingHaveYouBeenDiagnosed_OLS
////                .waitForPageLoad();
////        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = whichOfTheFollowingHaveYouBeenDiagnosed_OLS
////                .clickOnAnswers("Anorexia",
////                        "Bulimia",
////                        "Binge eating disorder")
////                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
//
//
//        //----------Q10 - Which type of headache do you typically get? --------------------
//        whichTypeOfHeadacheDoYouGetOLS
//                .waitForPageLoad();
//        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whichTypeOfHeadacheDoYouGetOLS
//                .clickOnAnswers("Migraine",
//                        "Cluster headache",
//                        "Tension headache")
//                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
//
//
//        //----------Q11 - Have you ever experienced or been diagnosed with any of the following specific heart-related medical conditions? --------------------
//        haveYouEverExperiencedHeartRelatedMedicalCondOLS
//                .waitForPageLoad();
//        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
//                .clickOnAnswers("Heart attack", "Stroke",
//                        "Mini-Stroke or TIA",
//                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
//                        "Heart failure or congestive heart failure (CHF)")
//                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
//                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
//                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4)
//                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected5);
//        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "4 - 6 months ago")
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "4 - 6 months ago")
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "4 - 6 months ago")
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5, "4 - 6 months ago")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
//        heartrelatedMedicalProceduresPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS47", protocol1, protocol2, protocol3, protocol4)
//                .back();
//        subquestionExperiencedHeartPageOLS
//                .waitForPageLoad()
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
//                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected5, "More than 1 year ago")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
//
//
//        //--------------Q13:  Have you undergone any of the following heart-related medical procedures?--------------
//        heartrelatedMedicalProceduresPageOLS
//                .waitForPageLoad();
//        DoYouTakeAnyMedicationsToControlHighBloodPressureOLS doYouTakeAnyMedicationsToControlHighBloodPressureOLS = heartrelatedMedicalProceduresPageOLS
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new DoYouTakeAnyMedicationsToControlHighBloodPressureOLS());
//
//
//        //--------------Q15:  Do you take any medications to control your high blood pressure or hypertension?---------
//        doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//                .waitForPageLoad();
//        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = doYouTakeAnyMedicationsToControlHighBloodPressureOLS
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
//
//
//        //--------------Q16: WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS ---------
//        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
//                .waitForPageLoad();
//        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
//                .clickOnAnswers("Dialysis", "Kidney transplant")
//                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
//        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS51", protocol1, protocol2, protocol3, protocol4)
//                .back();
//        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Neither")
//                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
//
//
//        //--------------Q17: Which of the following have you been diagnosed with? ---------
//        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//                .waitForPageLoad();
//        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//                .clickOnAnswers("Cirrhosis")
//                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
//        following_MentalEmotionalHealthPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS52", protocol1, protocol2, protocol3, protocol4)
//                .back();
//        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Unsure which type of liver disease")
//                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
//
//
//        //--------------Q18--FollowingMentalEmotionalHealthPageOLS -----------
//        following_MentalEmotionalHealthPageOLS
//                .waitForPageLoad();
//        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS = following_MentalEmotionalHealthPageOLS
//                .clickOnAnswers("Bipolar disorder", "Schizophrenia")
//                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
//        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS53", protocol1, protocol2, protocol3, protocol4)
//                .back();
//        following_MentalEmotionalHealthPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
//
//
//        //--------------Q19:  WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS-----------------------
//        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
//                .waitForPageLoad();
//        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS = whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
//                .clickOnAnswers("Memory loss",
//                        "Parkinson's disease",
//                        "Multiple sclerosis (MS)",
//                        "Seizure disorder, such as epilepsy",
//                        "Fibromyalgia",
//                        "None of the above")
//                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
//
//
//        //--------------Q20:  WhichOfTheFollowingSkinConditionsDoYouSufferOLS-----------------------
//        whichOfTheFollowingSkinConditionsDoYouSufferOLS
//                .waitForPageLoad();
//        WomenHealthConditions womenHealthConditions = whichOfTheFollowingSkinConditionsDoYouSufferOLS
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new WomenHealthConditions());
//
//
//        //--------------Q21:  Which of the following sleep-related conditions have you been diagnosed with?-----------------------
////        whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS
////                .waitForPageLoad();
////        WomenHealthConditions womenHealthConditions = whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS
////                .clickOnAnswers("Narcolepsy",
////                        "Sleep apnea",
////                        "Insomnia",
////                        "None of the above")
////                .clickNextButton(new WomenHealthConditions());
//
//
//        //--------------Q22:  Which of the following sleep-related conditions have you been diagnosed with?-----------------------
//        womenHealthConditions
//                .waitForPageLoad();
//        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = womenHealthConditions
//                .clickOnAnswers("Uterine fibroids")
//                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
//
//
//        //----------Q23 - Do any of the following additional diagnoses apply to you?--------
//        doAnyOftheFollowingAdditionalDiagnosesOLS
//                .waitForPageLoad();
//        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
//                .clickOnAnswers("Drug or alcohol abuse within the past year",
//                        "Hepatitis B",
//                        "Hepatitis C",
//                        "HIV or AIDS",
//                        "Neuropathy (nerve damage due to diabetes or another condition)")
//                .clickNextButton(new ApproximateHeightPageOLS());
//        approximateHeightPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
//                .back();
//        doAnyOftheFollowingAdditionalDiagnosesOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HormonalBirthControlOLS());
//
//
//        //--------------Q26:  Are you currently taking a hormonal form of birth control?-----------------------
//        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
//                .waitForPageLoad()
//                //WhatTypeOfLupusOLS whatTypeOfLupusOLS = approximateHeightPageOLS
//                .setAll("5", "5", "160")
////        		.clickNextButton(new ChildrenUnderPageOLS())
////		//----------ChildrenUnderTheAge Page--------------------
////		        .waitForPageLoad()
////		        .clickOnAnswer("Yes")
////		        .clickNextButton(new HouseholdHavePageOLS())
////		        .waitForPageLoad()
////		        .clickOnAnswers("None of the above")
////		        .clickNextButton(new TheStudySitePageOLS())
////		        .waitForPageLoad()
////
////		//-------------------PEDIATRIC QUESTIONS-----------------------------
////		        .clickOnAnswer("Public transportation")
////		        .clickNextButton(new WhatMedicalCoveragePageOLS())
////		        .waitForPageLoad()
////		        .clickOnAnswers("No, I have no coverage")
////                .clickNextButton(new EthnicBackgroundPageOLS())
////                .waitForPageLoad()
////                .clickOnAnswers("Prefer not to answer")
//                .clickNextButton(new IdentificationPageOLS());
//        //----------PII (IdentificationPageOLS) Page--------------------
//        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
//                .waitForPageLoad()
//                .clickNextButton(new SiteSelectionPageOLS());
//
//        siteSelectionPageOLS
//                .waitForPageLoad(studyName)
//                .getPID()
//                .clickOnFacilityName(site.name)
//                .clickNextButton(new DoctorInformationCollectionPageOLS())
//                .waitForPageLoadIBD("Crohn's Disease")
//                .clickNextButton(new HS1PageOLS())
//                .waitForPageLoad()
//                .clickOkInPopUp()
//                .setSignature();
//
///*                //------------HUMAN API Interface in HelloSign----------------
//                .getPage(new HumanAPIOLS())
//                .waitForPageLoad()
//                .connectBTN()
//                .switchToAPI()
//                .waitForProvider()
//                .clickANY()
//                .waitSearchAll()
//                .search("cleveland clinic")
//                .waitProvider()
//                .clickProvider()
//                .typeUserName("democlinical@gmail.com")
//                .typePWD("password")
//                .clickConnect()
//
//                .waitToClickNext()
//                .clickNextButton(new ThankYouCloseSimplePageOLS())*/
//
//
//        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
//
//        if(inFlare) {
//            thankYouCloseSimplePageOLS
//                    .waitForPageLoad()
//                    .clickNextButton(new AboutHealthPageOLS())
//                    .waitForPageLoad()
//                    .pidFromDbToLog(env)
//                    .childPidFromDbToLog(env)
//                    .assertGeneratedFul(env, site)
//                    .dispoShouldMatch(site.dispo, site.dispo);
//        } else {
//            QualifiedFlareMonitoringAppClosePageOLS qualifiedFlareMonitoringAppClosePageOLS = new QualifiedFlareMonitoringAppClosePageOLS();
//            qualifiedFlareMonitoringAppClosePageOLS
//                    .waitForPageLoad()
//                    .getActivationCode()
//                    .clickNextButton(thankYouCloseSimplePageOLS)
//                    .waitForPageLoad()
//                    .clickNextButton(new AboutHealthPageOLS())
//                    .waitForPageLoad()
//                    .pidFromDbToLog(env)
//                    .childPidFromDbToLog(env)
//                    .assertGeneratedFul(env, site)
//                    .dispoShouldMatch(site.dispo, site.dispo);
//        }
    }
}
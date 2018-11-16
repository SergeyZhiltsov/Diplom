package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.HaveAnyOfTheFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.ProcedureForWeightLossPageOLS;
import com.acurian.selenium.pages.OLS.shared.WeightLossSurgeryPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class IBD_3839_OLS extends BaseTest {

    @Test
    @TestCaseId("00029")
    @Description("IBD_3839_OLS")
    public void IBD_3839_UC_OLS_Screener() {
        String phoneNumber = "AUTAMS1IBD";
        String protocol1 = "SHP647_301";
        String protocol2 = "SHP647_302";
        String studyName = "a colitis";
        String siteName = "AUT_IBD_3839_Site";
        String zipCode = "19901";
        String indication = "a Ulcerative Colitis";

        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoadGROUP()
                .maximizePage();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGROUP(), dateOfBirthPageOLS.titleIBD_Expected, "Title is diff");

        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
                .setDate("09092001")
                .clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        ageUnqualifiedClose_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoadGROUP();
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new PersonalDetails());

        //---------------PII Page Question-------------------
        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS());


        //---------------Q2 Have you ever been officially diagnosed by a doctor with any of the following digestive conditions?  page-------------------
        haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS.getTitleText(), haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS.titleExpected, "Title is diff");
        WhenWereYouDiagnosedWithUlcerativeColitis_OLS whenWereYouDiagnosedWithUlcerativeColitis_OLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenWereYouDiagnosedWithUlcerativeColitis_OLS());
        whenWereYouDiagnosedWithUlcerativeColitis_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5702", protocol1, protocol2);
        debugPageOLS.back();
        haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS.waitForPageLoad()
                //WhenWereYouDiagnosedWithUlcerativeColitis_OLS whenWereYouDiagnosedWithUlcerativeColitis_OLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .clickOnAnswers("Crohn's disease", "Ulcerative colitis") //UnCheck Crohn's and Check UC only
                .clickNextButton(new WhenWereYouDiagnosedWithUlcerativeColitis_OLS());


        //---------------Q3 When were you diagnosed with Crohn's disease? -------------------
        whenWereYouDiagnosedWithUlcerativeColitis_OLS
                .waitForPageLoad();
        Assert.assertEquals(whenWereYouDiagnosedWithUlcerativeColitis_OLS.getTitleText(), whenWereYouDiagnosedWithUlcerativeColitis_OLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = whenWereYouDiagnosedWithUlcerativeColitis_OLS
                .clickOnAnswer("Not officially diagnosed with ulcerative colitis by a doctor")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5704", protocol1, protocol2);
        debugPageOLS.back();
        whenWereYouDiagnosedWithUlcerativeColitis_OLS.waitForPageLoad();
        WhenWasYourMostRecentColonoscopy_OLS whenWasYourMostRecentColonoscopy_OLS = whenWereYouDiagnosedWithUlcerativeColitis_OLS
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new WhenWasYourMostRecentColonoscopy_OLS());


        //---------------Q5 whenWasYourMostRecentColonoscopy_OLS Page-----------
        whenWasYourMostRecentColonoscopy_OLS
                .waitForPageLoad();
        Assert.assertEquals(whenWasYourMostRecentColonoscopy_OLS.getTitleText(), whenWasYourMostRecentColonoscopy_OLS.titleExpected, "Title is diff");
        HaveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS = whenWasYourMostRecentColonoscopy_OLS
                .clickOnAnswer("I have never had a colonoscopy")
                .clickNextButton(new HaveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS());


        //---------------Q6 HaveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS page-------------------
        haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS.getTitleText(), haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS.titleExpected, "Title is diff");
        //-------------If selected 'NO', disqualify and SKIP to Q14, otherwise goto Q7	
        AreYouCurrentlyExperiencingFlareUp_OLS areYouCurrentlyExperiencingFlareUp_OLS = haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());
        areYouCurrentlyExperiencingFlareUp_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5706", protocol1, protocol2);
        debugPageOLS.back();
        haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS.waitForPageLoad();
        HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS = haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS());


        //---------------Q7 Have you ever taken steroid medications for your Crohn's or colitis?--------------------------------------------
        haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS.getTitleText(), haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS.titleExpected, "Title is diff");
        HaveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS = haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS());
        haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS
                .waitForPageLoad()
                .back();
        haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS());


        //---------------Q8 Have you ever taken any of the following medications for your Crohn's or colitis? page------------------
        haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS.getTitleText(), haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS.titleExpected, "Title is diff");
        HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS = haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS
                .clickOnAnswers("Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, or Rowasa (mesalamine)",
                        "Azulfidine (sulfasalazine)",
                        "Colazal or Giazo (balsalazide)",
                        "Dipentum (olsalazine)")
                .clickNextButton(new HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS());


        //---------------Q9 heartrelatedMedicalProceduresPageOLS page------------------
        haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS.getTitleText(), haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS.titleExpected, "Title is diff");
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS
                .clickOnAnswers("Astagraf, Envarsus, or Prograf (tacrolimus)",
                        "Azasan or Imuran (azathioprine)",
                        "CellCept or Myfortic (mycophenolate)",
                        "Jakafi (ruxolitinib)",
                        "Methotrexate pills or tablets (Rheumatrex, Trexall)",
                        "Methotrexate injections or shots (Otrexup, Rasuvo)",
                        "Purixan (6-MP or mercaptopurine)",
                        "Rapamune (sirolimus)",
                        "Sandimmune, Gengraf, or Neoral (cyclosporine)",
                        "Xeljanz (tofacitinib)")
                .clickNextButton(new BiologicMedicationsPageOLS());


        //---------------Q10 Have you ever received any of the following "biologic" medications? page------------------
        biologicMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(biologicMedicationsPageOLS.getTitleText(), biologicMedicationsPageOLS.titleExpected, "Title is diff");
        biologicMedicationsPageOLS.clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)",
                "Benlysta",
                "Cimzia",
                "Cosentyx",
                "Enbrel",
                "Entyvio",
                "Humira",
                "Kineret",
                "Orencia",
                "Prolia or Xgeva",
                "Raptiva",
                "Remicade",
                "Rituxan",
                "Simponi",
                "Stelara",
                "Taltz",
                "Tysabri")
                .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());
        areYouCurrentlyExperiencingFlareUp_OLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5710", protocol1, protocol2)
                .back();
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Entyvio", "Raptiva", "Tysabri")  //Uncheck "Entyvio","Raptiva","Tysabri" options to qualify
                .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());


        //---------------Q14 Are you currently experiencing a flare-up? page------------------
        areYouCurrentlyExperiencingFlareUp_OLS
                .waitForPageLoad();
        SubquestionsIBD_UlcerativeColitis_OLS subquestionsIBD_ulcerativeColitis_ols = areYouCurrentlyExperiencingFlareUp_OLS
                .clickOnAnswer("Yes, I am currently in a flare with my Crohn's or colitis")
                .clickNextButton(new SubquestionsIBD_UlcerativeColitis_OLS());


        //added after failed scripts

        subquestionsIBD_ulcerativeColitis_ols
                .waitForPageLoad(1,subquestionsIBD_ulcerativeColitis_ols.titleExpected1)
                .waitForPageLoad(2,subquestionsIBD_ulcerativeColitis_ols.titleExpected2)
                .waitForPageLoad(3,subquestionsIBD_ulcerativeColitis_ols.titleExpected3);
        //----------Select options for 15.1, 15.2 and 15.3 sub-questions---------
        //WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = subquestionsIBD_UlcerativeColitis_OLS
        SubquestionsIBD_OLS subquestionsIBD_OLS = subquestionsIBD_ulcerativeColitis_ols
                .totalBowelMovements("4")
                .totalpast24hrBowelMovements("4")
                .clickOnAnswer("Yes")
                .clickNextButton(new SubquestionsIBD_OLS());


        //-----------------------Q15 In general, how would you rate your health, living with Crohn's or colitis?----------------------
        subquestionsIBD_OLS
                .waitForPageLoad(1, subquestionsIBD_OLS.titleExpected1)
                .waitForPageLoad(2, subquestionsIBD_OLS.titleExpected2)
                .waitForPageLoad(3, subquestionsIBD_OLS.titleExpected3);
        //----------Select options for 15.1, 15.2 and 15.3 sub-questions---------
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = subquestionsIBD_OLS
                .clickOnAnswerForSubQuestion(subquestionsIBD_OLS.titleExpected1, "Good")
                .clickOnAnswersForSubQuestion(subquestionsIBD_OLS.titleExpected2, "Somewhat better now")
                .clickOnAnswerForSubQuestion(subquestionsIBD_OLS.titleExpected3, "Loss of bowel control")
                .clickNextButton(new WeightLossSurgeryPageOLS());


        //-----------------------Q16 - Have you ever had any of the following types of bariatric or weight loss surgery?  page----------------------
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(), weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        HaveAnyOfTheFollowingPageOLS haveAnyOfTheFollowingPageOLS = weightLossSurgeryPageOLS
                //-----SKIP to Q18 if selected "None of the above" in Q16, otherwise goto Q17
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .back();
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass",
                        "Gastric sleeve or sleeve gastrectomy",
                        "Duodenal switch",
                        "Lap band or gastric banding",
                        "Gastric balloon",
                        "I had a weight loss surgery, but I am unsure which type")
                .clickNextButton(new ProcedureForWeightLossPageOLS());


        //----------------Q17 - When was the last time that you had a surgery or medical procedure for weight loss?  page----------------------
        procedureForWeightLossPageOLS
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageOLS.getTitleText(), procedureForWeightLossPageOLS.titleExpected, "Title is diff");
        procedureForWeightLossPageOLS.clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());


        //----------------Q18 - Do you currently have any of the following? page----------------------
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad();
        Assert.assertEquals(haveAnyOfTheFollowingPageOLS.getTitleText(), haveAnyOfTheFollowingPageOLS.titleExpected, "Title is diff");
        //-----DQ if selected any/all of these options - "Colostomy and/or Colectomy","Ileostomy","Another type of stomach or colon surgery" in Q18 -------
        haveAnyOfTheFollowingPageOLS
                .clickOnAnswers("Colostomy and/or Colectomy",
                        "Ileostomy",
                        "Another type of stomach or colon surgery",
                        "IV (parenteral) nutrition")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5718", protocol1, protocol2)
                .back();
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        //----------****************NEW GENERAL HEALTH Questions************************----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.getTitleText(), haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.titleExpected, "Title is diff");
        WhatKindOfArthritisPage whatKindOfArthritisPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",

                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",

                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",

                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPage());


        //----------Q3 WhatKindOfArthritisPage Page--------------------
        whatKindOfArthritisPage.waitForPageLoad();
        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS = whatKindOfArthritisPage
                .clickOnAnswer("Unsure")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());


        //----------Q4 - Which of the following have you been diagnosed with?--------
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS.getTitleText(), whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS.titleExpected, "Title is diff");
        WhichOfFollowingHaveYouDiagnosedWithOLS whichOfFollowingHaveYouDiagnosedWithOLS = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis",
                        "Gout",
                        "Low back pain",
                        "Osteoporosis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWithOLS());


        //----------Q5 - whichOfFollowingHaveYouDiagnosedWithOLS --------------------
        whichOfFollowingHaveYouDiagnosedWithOLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfFollowingHaveYouDiagnosedWithOLS.getTitleText(), whichOfFollowingHaveYouDiagnosedWithOLS.titleExpected, "Title is diff");
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = whichOfFollowingHaveYouDiagnosedWithOLS
                .clickOnAnswers(
                        "Asthma",
                        "Chronic cough",
                        "Chronic bronchitis",
                        "COPD",
                        "Emphysema")
                .clickNextButton(new OtherThanSkinCancerPageOLS());


        //----------Q6 - When were you diagnosed with cancer (other than skin cancer)? --------------------
        otherThanSkinCancerPageOLS
                .waitForPageLoad();
        Assert.assertEquals(otherThanSkinCancerPageOLS.getTitleText(), otherThanSkinCancerPageOLS.titleExpected, "Title is diff");
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = otherThanSkinCancerPageOLS
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());


        //----------Q7 - What kind of diabetes do you have? --------------------
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageOLS.getTitleText(), whatKindOfDiabetesPageOLS.titleExpected, "Title is diff");
        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = whatKindOfDiabetesPageOLS
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());


        //----------Q8 - Which of the following have you been diagnosed with by a doctor? --------------------
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfFollowingDigestiveConditionPageOLS.getTitleText(), whichOfFollowingDigestiveConditionPageOLS.titleExpected, "Title is diff");
        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = whichOfFollowingDigestiveConditionPageOLS
                .clickOnAnswers("IBS, or irritable bowel syndrome")
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());


        //----------Q9 - Which of the following have you been diagnosed with? (eating disorder)--------------------
//        whichOfTheFollowingHaveYouBeenDiagnosed_OLS
//                .waitForPageLoad();
//        Assert.assertEquals(whichOfTheFollowingHaveYouBeenDiagnosed_OLS.getTitleText(), whichOfTheFollowingHaveYouBeenDiagnosed_OLS.titleExpected, "Title is diff");
//        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = whichOfTheFollowingHaveYouBeenDiagnosed_OLS
//                .clickOnAnswers("Anorexia",
//                        "Bulimia",
//                        "Binge eating disorder")
//                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());


        //----------Q10 - Which type of headache do you typically get? --------------------
        whichTypeOfHeadacheDoYouGetOLS
                .waitForPageLoad();
        Assert.assertEquals(whichTypeOfHeadacheDoYouGetOLS.getTitleText(), whichTypeOfHeadacheDoYouGetOLS.titleExpected, "Title is diff");
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whichTypeOfHeadacheDoYouGetOLS
                .clickOnAnswers("Migraine",
                        "Cluster headache",
                        "Tension headache")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());


        //----------Q11 - Have you ever experienced or been diagnosed with any of the following specific heart-related medical conditions? --------------------
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverExperiencedHeartRelatedMedicalCondOLS.getTitleText(), haveYouEverExperiencedHeartRelatedMedicalCondOLS.titleExpected, "Title is diff");
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .clickOnAnswers("Heart attack", "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay",
                        "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1), subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2), subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(3), subquestionExperiencedHeartPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(4), subquestionExperiencedHeartPageOLS.titleExpected4, "Title is diff");
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "4 - 6 months ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());


        //--------------Q13:  Have you undergone any of the following heart-related medical procedures?--------------
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad();
        Assert.assertEquals(heartrelatedMedicalProceduresPageOLS.getTitleText(), heartrelatedMedicalProceduresPageOLS.titleExpected, "Title is diff");
        DoYouTakeAnyMedicationsToControlHighBloodPressureOLS doYouTakeAnyMedicationsToControlHighBloodPressureOLS = heartrelatedMedicalProceduresPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoYouTakeAnyMedicationsToControlHighBloodPressureOLS());


        //--------------Q15:  Do you take any medications to control your high blood pressure or hypertension?---------
        doYouTakeAnyMedicationsToControlHighBloodPressureOLS
                .waitForPageLoad();
        Assert.assertEquals(doYouTakeAnyMedicationsToControlHighBloodPressureOLS.getTitleText(), doYouTakeAnyMedicationsToControlHighBloodPressureOLS.titleExpected, "Title is diff");
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = doYouTakeAnyMedicationsToControlHighBloodPressureOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());


        //--------------Q16: WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS ---------
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS.getTitleText(), whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS.titleExpected, "Title is diff");
        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .clickOnAnswers("Dialysis", "Kidney transplant")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());


        //--------------Q17: Which of the following have you been diagnosed with? ---------
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS.getTitleText(), whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS.titleExpected, "Title is diff");
        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        //--------------Q18--FollowingMentalEmotionalHealthPageOLS -----------
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad();
        Assert.assertEquals(following_MentalEmotionalHealthPageOLS.getTitleText(), following_MentalEmotionalHealthPageOLS.titleExpected, "Title is diff");
        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS = following_MentalEmotionalHealthPageOLS
                .clickOnAnswers("Bipolar disorder", "Schizophrenia")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());


        //--------------Q19:  WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS-----------------------
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS.getTitleText(), whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS.titleExpected, "Title is diff");
        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS = whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .clickOnAnswers("Memory loss",
                        "Parkinson's disease",
                        "Multiple sclerosis (MS)",
                        "Seizure disorder, such as epilepsy",
                        "Fibromyalgia",
                        "None of the above")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());


        //--------------Q20:  WhichOfTheFollowingSkinConditionsDoYouSufferOLS-----------------------
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfTheFollowingSkinConditionsDoYouSufferOLS.getTitleText(), whichOfTheFollowingSkinConditionsDoYouSufferOLS.titleExpected, "Title is diff");
        WomenHealthConditions womenHealthConditions = whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new WomenHealthConditions());


        //--------------Q21:  Which of the following sleep-related conditions have you been diagnosed with?-----------------------
//        whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS
//                .waitForPageLoad();
//        Assert.assertEquals(whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS.getTitleText(), whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS.titleExpected, "Title is diff");
//        WomenHealthConditions womenHealthConditions = whichOfTheFollowingSleepRelatedConditionsDiagnosedOLS
//                .clickOnAnswers("Narcolepsy",
//                        "Sleep apnea",
//                        "Insomnia",
//                        "None of the above")
//                .clickNextButton(new WomenHealthConditions());


        //--------------Q22:  Which of the following sleep-related conditions have you been diagnosed with?-----------------------
        womenHealthConditions
                .waitForPageLoad();
        Assert.assertEquals(womenHealthConditions.getTitleText(), womenHealthConditions.titleExpected, "Title is diff");
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = womenHealthConditions
                .clickOnAnswers("Uterine fibroids")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        //----------Q23 - Do any of the following additional diagnoses apply to you?--------
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .clickOnAnswers("Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis C",
                        "HIV or AIDS",
                        "Neuropathy (nerve damage due to diabetes or another condition)")
                .clickNextButton(new ApproximateHeightPageOLS());


        //--------------Q26:  Are you currently taking a hormonal form of birth control?-----------------------
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
//        .clickNextButton(new ChildrenUnderPageOLS())
//
//
//		//----------ChildrenUnderTheAge Page--------------------
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad();
        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS()
                //.setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        //----------SiteSelection Page--------------------
        siteSelectionPageOLS.waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose_OLS())
                .waitForPageLoad(indication)
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
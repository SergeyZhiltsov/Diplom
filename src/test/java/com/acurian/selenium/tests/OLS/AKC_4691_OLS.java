package com.acurian.selenium.tests.OLS;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.OLS.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.OLS.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.OLS.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.ApartFromMetforminPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CombinationWithEachOtherPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.DiabeticNephropathyPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.FollowingToLoseWeightPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.ForYourKidneysPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.InjectableMedicationsForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.InsulinForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LastTimeYouTookPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LiverRelatedConditionOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.MetforminMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.NoOfAlcoholicDrinkOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionsHumalogPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.HumanAPIOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DiagnosedAnyTypeOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.ProcedureForWeightLossPageOLS;
import com.acurian.selenium.pages.OLS.shared.StatinMedicationsOnPageOLS;
import com.acurian.selenium.pages.OLS.shared.WeightLossSurgeryPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AKC_4691_OLS extends BaseTest {

    @Test(enabled = true)
    @TestCaseId("0001")
    @Description("Akcea_4691 OLS")
    public void AKC_4691_OLS_EmailAtPII() {

        String phoneNumber = "AUTAMS1AKC";
        List<String> protocols = Arrays.asList("ISIS 703802_CS2");
        String protocol1 = "ISIS 703802_CS2";
        String studyName = "diabetics";
        String siteName = "AKC_4691";
        String zipCode = "19355";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoadGROUP()
                .maximizePage();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGROUP(), dateOfBirthPageOLS.titleAKC_4691_Expected, "Title is diff");

        //--------------DOB Question------------
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        //--------------ZIP_CODE Question------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //--------------GENDER Question------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());


        //--------------Q2: Have you been diagnosed with any type of diabetes?------------
        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageOLS.getTitleText(), diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4602", protocol1);
        debugPageOLS.back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());


        //--------------Q3: What kind of diabetes do you have?------------
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageOLS.getTitleText(), whatKindOfDiabetesPageOLS.titleExpected, "Title is diff");
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        UseDietAndExercisePage useDietAndExercisePage = whatKindOfDiabetesPageOLS
                .clickOnAnswer("Unsure")
                .clickNextButton(new UseDietAndExercisePage());
        useDietAndExercisePage.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());


        //--------------Q4: How long ago were you diagnosed with type 2 diabetes?------------
        withType2DiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageOLS.getTitleText(), withType2DiabetesPageOLS.titleExpected, "Title is diff");
        withType2DiabetesPageOLS
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new UseDietAndExercisePage());


        //--------------Q5: Do you currently use diet and exercise as a way to help treat your diabetes? -----------
        useDietAndExercisePage
                .waitForPageLoad();
        Assert.assertEquals(useDietAndExercisePage.getTitleText(), useDietAndExercisePage.titleExpected, "Title is diff");
        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage());


        //--------------Q6: Do you currently use metformin or insulin or any other medication prescribed by your doctor to treat your diabetes? -----------        
        //---------If selected "Metformin" skip to Q8,  If selected "Medication other than Metformin or Insulin" skip to Q9, 
        //---------If selected "Insulin" skip to Q10, 
        //---------If selected ""Do not use any prescribed medication to treat diabetes"" goto Q7 and DQ 4691---------
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();
        Assert.assertEquals(currentlyUseMetforminOrInsulinPage.getTitleText(), currentlyUseMetforminOrInsulinPage.titleExpected, "Title is diff");
        ApartFromMetforminPageOLS apartFromMetforminPageOLS = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Medication other than Metformin or Insulin")
                .clickNextButton(new ApartFromMetforminPageOLS());
        apartFromMetforminPageOLS.waitForPageLoad()
                .back();
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();
        InsulinForYourDiabetesPageOLS insulinForYourDiabetesPageOLS = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Medication other than Metformin or Insulin") //Click to Uncheck this option
                .clickOnAnswers("Insulin")
                .clickNextButton(new InsulinForYourDiabetesPageOLS());
        insulinForYourDiabetesPageOLS.waitForPageLoad()
                .back();
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());
        anyPrescribedMedicationPage.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4626", protocol1)
                .back();
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Metformin")
                .clickNextButton(new MetforminMedicationsPageOLS());


        //----------Q8: Do you currently take any of the following oral (taken by mouth) metformin medications?
        metforminMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageOLS.getTitleText(), metforminMedicationsPageOLS.titleExpected, "Title is diff");
        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = metforminMedicationsPageOLS
                .clickOnAnswers("Actoplus Met (metformin and pioglitazone)")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4607", protocol1)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Avandamet (metformin and rosiglitazone)")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                //	.checkProtocolsContainsForQNumber("QS4607", protocol1)
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Fortamet (metformin)",
                        "Glucophage (metformin)",
                        "Glucovance (metformin and glyburide)",
                        "Glumetza (metformin)",
                        "Invokamet (metformin and canagliflozin)",
                        "Janumet (metformin and sitagliptin)",
                        "Jentadueto (metformin and linagliptin)",
                        "Kazano (metformin and alogliptin)",
                        "Kombiglyze (metformin and saxagliptin)",
                        "Metformin and glipizide",
                        "PrandiMet (metformin and repaglinide)",
                        "Synjardy (metformin and empagliflozin)",
                        "Xigduo (metformin and dapagliflozin)",
                        "None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS())
                .waitForPageLoad()
                .back();
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .back();
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Insulin", "Medication other than Metformin or Insulin")
                .clickNextButton(new MetforminMedicationsPageOLS());
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickNextButton(new ApartFromMetforminPageOLS());


        //----------Q9: Apart from metformin, what other oral (taken by mouth) medications do you currently take for your diabetes?  ----------
        apartFromMetforminPageOLS
                .waitForPageLoad();
        Assert.assertEquals(apartFromMetforminPageOLS.getTitleText(), apartFromMetforminPageOLS.titleExpected, "Title is diff");
        apartFromMetforminPageOLS
                .clickOnAnswers("Actos (pioglitazone)",
                        "Avandia (rosiglitazone)",
                        "Duetact (pioglitazone and glimepiride)",
                        "Oseni (alogliptin and pioglitazone)")
                .clickNextButton(new InsulinForYourDiabetesPageOLS());
        insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4608", protocol1)
                .back();
        apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .threadSleep(2000);
        apartFromMetforminPageOLS
                .clickOnAnswers("Tradjenta (linagliptin)")
                .clickNextButton(new InsulinForYourDiabetesPageOLS());


        //--------Q10:  Do you currently take any of the following types of insulin for your diabetes?--
        insulinForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(insulinForYourDiabetesPageOLS.getTitleText(), insulinForYourDiabetesPageOLS.titleExpected, "Title is diff");
        insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Afrezza, which is inhaled insulin",
                        "Apidra (insulin glulisine)",
                        "Humalog",
                        "Humulin",
                        "Lantus or Toujeo (insulin glargine)",
                        "Levemir (insulin detemir)",
                        "Novolin",
                        "Novolog")
                .clickNextButton(new SubquestionsHumalogPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4609", protocol1)
                .back();
        insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I use insulin, but I am not sure what kind")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4609", protocol1)
                .back();
        insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());


        //-------Q12:  Do you currently take any of the following injectable medications for your diabetes?  --------
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageOLS.getTitleText(), injectableMedicationsForYourDiabetesPageOLS.titleExpected, "Title is diff");
        CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = injectableMedicationsForYourDiabetesPageOLS
                .clickOnAnswers("Adlyxin (lixisenatide)",
                        "Bydureon or Byetta (exenatide)",
                        "Tanzeum (albiglutide)",
                        "Trulicity (dulaglutide)",
                        "Saxenda or Victoza (liraglutide)",
                        "SymlinPen (pramlintide)",
                        "Another injectable medication not listed above")
                .clickNextButton(new CombinationWithEachOtherPageOLS());
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4611", protocol1)
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CombinationWithEachOtherPageOLS());


        //-------Q13:  Overall, how long have you been taking your current diabetes medication(s), either by themselves, or in combination with each other?  --------
        combinationWithEachOtherPageOLS
                .waitForPageLoad();
        Assert.assertEquals(combinationWithEachOtherPageOLS.getTitleText(), combinationWithEachOtherPageOLS.titleExpected, "Title is diff");
        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = combinationWithEachOtherPageOLS
                .clickOnAnswer("1 month or less")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());


        //-------Q15:  About how many alcoholic drinks do you have in a typical week? --------
        noOfAlcoholicDrinkOLS
                .waitForPageLoad();
        Assert.assertEquals(noOfAlcoholicDrinkOLS.getTitleText(), noOfAlcoholicDrinkOLS.titleExpected, "Title is diff");
        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
                .setDrinks("6")
                .clickNextButton(new LiverRelatedConditionOLS());


        //-------Q16:  Has a healthcare professional ever diagnosed you with any of the following liver-related conditions?--------
        liverRelatedConditionOLS
                .waitForPageLoad();
        Assert.assertEquals(liverRelatedConditionOLS.getTitleText(), liverRelatedConditionOLS.titleExpected, "Title is diff");
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
                .clickOnAnswers("Alcoholic liver disease",
                        "Autoimmune hepatitis, which is not the same as hepatitis caused by a virus",
                        "Hemochromatosis or iron overload",
                        "Liver cancer or hepatocellular carcinoma",
                        "Primary sclerosing cholangitis or primary biliary cirrhosis",
                        "Wilson's disease")
                .clickNextButton(new FollowingToLoseWeightPageOLS());
        followingToLoseWeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4624", protocol1)
                .back();
        liverRelatedConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageOLS());


        //-------Q17:  Are you currently using any of the following to lose weight?--------
        followingToLoseWeightPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageOLS.getTitleText(), followingToLoseWeightPageOLS.titleExpected, "Title is diff");
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .clickOnAnswers("Prescription weight loss medication",
                        "Over-the-counter weight loss medication or supplements",
                        "Weight loss program such as Weight Watchers or Jenny Craig",
                        "No")
                .clickNextButton(new WeightLossSurgeryPageOLS());


        //-------Q18:  Have you ever had any of the following types of bariatric or weight loss surgery?--------
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(), weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageOLS())
                .waitForPageLoad();
        poundsOrMorePageOLS.back();
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass",
                        "Gastric sleeve or sleeve gastrectomy",
                        "Duodenal switch",
                        "Lap band or gastric banding",
                        "Gastric balloon")
                .clickNextButton(new ProcedureForWeightLossPageOLS());


        //-------Q19:  When was the last time that you had a surgery or medical procedure for weight loss?--------
        procedureForWeightLossPageOLS
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageOLS.getTitleText(), procedureForWeightLossPageOLS.titleExpected, "Title is diff");
        PoundsOrMorePageOLS PoundsOrMorePageOLS = procedureForWeightLossPageOLS
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
        PoundsOrMorePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4616", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());


        //-------Q20:  Have you lost or gained 15 pounds or more in the past 3 months?--------
        poundsOrMorePageOLS
                .waitForPageLoad();
        Assert.assertEquals(poundsOrMorePageOLS.getTitleText(), poundsOrMorePageOLS.titleExpected, "Title is diff");
        poundsOrMorePageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouExperienceDPN_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4617", protocol1)
                .back();
        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DoYouExperienceDPN_OLS())
                .waitForPageLoad()
                .clickOnAnswer("No, none of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Alzheimer's disease",
                        "Anemia (low red blood cell count)",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, seasonal allergy, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
                        "Eating disorders (anorexia, bulimia, binge eating disorder)",
                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lung problems",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
                        "Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis, acne, cellulite, actinic or solar keratosis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids, PCOS, dense breasts)")
                .clickNextButton(new WhatKindOfArthritisPage())
                .waitForPageLoad()
                .back();
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageOLS());
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocol1)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS());


        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new HormonalBirthControlOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(new HormonalBirthControlOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new HormonalBirthControlOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new HormonalBirthControlOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")    //rel 60
//        childrenUnderPageOLS
//        		.waitForPageLoad()
//        		.getPage(debugPageOLS)
//        		.checkProtocolsContainsForQNumber("QS60", protocol1)
//        		.back();
//        approximateHeightPageOLS
//				.waitForPageLoad()
//				.setIncheswithClear("6")
//				.setLbs("170")
//				.clickNextButton(new ChildrenUnderPageOLS());
//
//        childrenUnderPageOLS
//				.waitForPageLoad()
//				.clickOnAnswer("No")
//                .clickNextButton(new TheStudySitePageOLS());
//                TheStudySitePageOLS theStudySitePageOLS = new TheStudySitePageOLS();
//
//
//
//  //----------*******NEW GENERAL HEALTH Questions********---------------------------
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//         theStudySitePageOLS.waitForPageLoad()
//         .clickOnAnswer("Public transportation")
//         .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
//        .clickNextButton(new EthnicBackgroundPageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoadAKC()
                .getPID()
                //----------SITE Selection Page--------------------
                .clickOnFacilityName(siteName)
                .clickNextButton(new HSGeneralPageOLS())
                //----------Special Type 2 Diabetes HELLO SIGN Page (Email entered at PII)--------------------
                .waitForPageLoadT2DM()
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()

                //------------HUMAN API Interface in HelloSign----------------
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
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.OLS.shared.DIA.CurrentlyUseMetforminOrInsulinPage;
import com.acurian.selenium.pages.OLS.shared.DIA.UseDietAndExercisePage;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class DPN_4557_OLS extends BaseTest {

    @Test(enabled = false)
    @TestCaseId("00016")
    @Description("Diabetic Peripheral Neuropath (DPN)- 4557 OLS")
    public void dPN_4557_OLS() {

        String phoneNumberDPN = "AUTAMS1DPN";
        String protocol1 = "VMDN_003";
        String DPN_4557 = "NYX_2925_2001";
        String studyName = "a diabetic nerve pain";
        String studyName1 = "a diabetes study, a diabetic nerve pain";
        //String env = "STG";  //Enter which OLS environment to use for testing
        String siteName = "AUT_DPN_4557_Site";
        String zipCode = "19422";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
//        dateOfBirthPageOLS
//                .openPage(env, phoneNumberDPN)
//                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleDPNExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
                .clickNextButton(new ZipCodePageOLS());

        //------------ZIP_CODE question---------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //------------GENDER question---------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());


        //------------Q2 Have you been diagnosed with any type of diabetes?---------------
        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageOLS.getTitleText(), diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        //------Validate protocol DQs in debug window----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, protocol1, DPN_4557);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to correct option in diagnosedAnyTypeOfDiabetesPageOLS---------------
        diagnosedAnyTypeOfDiabetesPageOLS.waitForPageLoad();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());


        //-----------Q3 -What kind of diabetes do you have?? ---------------
        whatKindOfDiabetesPageOLS.waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageOLS.getTitleText(), whatKindOfDiabetesPageOLS.titleExpected, "Title is diff");

        DoYouExperienceDPN_OLS doYouExperienceDPN_OLS = whatKindOfDiabetesPageOLS  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new DoYouExperienceDPN_OLS());
        //********Validate Question History for DQ and then click BACK button
        doYouExperienceDPN_OLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, DPN_4557);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageOLS---------------
        whatKindOfDiabetesPageOLS.waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new DoYouExperienceDPN_OLS())
                .waitForPageLoad();


        //----------Q4 - Do you experience diabetic peripheral neuropathy or diabetic nerve pain? -  Page ---------------
        doYouExperienceDPN_OLS
                .waitForPageLoad();
        Assert.assertEquals(doYouExperienceDPN_OLS.getTitleText(), doYouExperienceDPN_OLS.titleExpected, "Title is diff");
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = doYouExperienceDPN_OLS
                .clickOnAnswer("No, none of the above")
                .clickNextButton(new WithType2DiabetesPageOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        withType2DiabetesPageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...", protocol1, DPN_4557);
        //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...").contains(protocol1));
        debugPageOLS.back();
        doYouExperienceDPN_OLS.waitForPageLoad();
        WhereDoYouExperienceDiabeticNervePain_OLS whereDoYouExperienceDiabeticNervePain_OLS = doYouExperienceDPN_OLS
                .clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
                .clickNextButton(new WhereDoYouExperienceDiabeticNervePain_OLS());


        //----------Q5 - "Where do you experience diabetic nerve pain symptoms or sensations?" Page ---------------
        whereDoYouExperienceDiabeticNervePain_OLS.waitForPageLoad();
        Assert.assertEquals(whereDoYouExperienceDiabeticNervePain_OLS.getTitleText(), whereDoYouExperienceDiabeticNervePain_OLS.titleExpected, "Title is diff");
        whereDoYouExperienceDiabeticNervePain_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new WithType2DiabetesPageOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        withType2DiabetesPageOLS
                .waitForPageLoad();
        Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Where do you experience diabetic nerve pain symptoms or sensations?Agent Note: Select all that apply...").contains(protocol1));
        debugPageOLS
                .back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------
        HowWouldYouDescribeTheSymptoms_OLS howWouldYouDescribeTheSymptoms_OLS = whereDoYouExperienceDiabeticNervePain_OLS //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right foot", "Right leg", "Left foot", "Left leg")
                .clickNextButton(new HowWouldYouDescribeTheSymptoms_OLS());

        //----------Q6 - How would you describe the symptoms or sensations you feel in your feet, legs, hands, or arms? ---------
        howWouldYouDescribeTheSymptoms_OLS
                .waitForPageLoad();
        Assert.assertEquals(howWouldYouDescribeTheSymptoms_OLS.getTitleText(), howWouldYouDescribeTheSymptoms_OLS.titleExpected, "Title is diff");
        howWouldYouDescribeTheSymptoms_OLS
                .clickOnAnswers("None of the above");
        HaveYouNoticedAnyOfTheFollowing_OLS haveYouNoticedAnyOfTheFollowing_OLS = howWouldYouDescribeTheSymptoms_OLS   //[create NEXT PAGE Object = THIS page object]
                .clickNextButton(new HaveYouNoticedAnyOfTheFollowing_OLS()); // Click NEXT button and wait for the NEXT page

        //----------Q7 "Have you noticed any of the following in your feet, legs, hands, or arms?" ---------------
        haveYouNoticedAnyOfTheFollowing_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouNoticedAnyOfTheFollowing_OLS.getTitleText(), haveYouNoticedAnyOfTheFollowing_OLS.titleExpected, "Title is diff");
        ApproxHowlongYouBeenExpSymptomsOLS approxHowlongYouBeenExpSymptomsOLS = haveYouNoticedAnyOfTheFollowing_OLS   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproxHowlongYouBeenExpSymptomsOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        approxHowlongYouBeenExpSymptomsOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - DPN Symptoms Logic", protocol1, DPN_4557);
        //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(protocol1));
        //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(DPN_4557));
        //------------ Change your answer in page 'howWouldYouDescribeTheSymptoms_OLS'-----
        debugPageOLS
                .back();
        haveYouNoticedAnyOfTheFollowing_OLS
                .waitForPageLoad();
        debugPageOLS.back();
        howWouldYouDescribeTheSymptoms_OLS.waitForPageLoad()
                .clickOnAnswers("Burning", "Painful cold")
                .clickNextButton(new HaveYouNoticedAnyOfTheFollowing_OLS())
                .waitForPageLoad()
                .clickNextButton(new ApproxHowlongYouBeenExpSymptomsOLS());

        //----------Q8 "Ghost Question - DPN Symptoms Logic" ---------------


        //----------Q9 -Approximately how long have you been experiencing symptoms or sensations of diabetic nerve pain?-  Page ---------------
        approxHowlongYouBeenExpSymptomsOLS
                .waitForPageLoad();
        Assert.assertEquals(approxHowlongYouBeenExpSymptomsOLS.getTitleText(), approxHowlongYouBeenExpSymptomsOLS.titleExpected, "Title is diff");
        HowWouldYouRateYourPain_OLS howWouldYouRateYourPain_OLS = approxHowlongYouBeenExpSymptomsOLS //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowWouldYouRateYourPain_OLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        howWouldYouRateYourPain_OLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(approxHowlongYouBeenExpSymptomsOLS.titleExpected, protocol1, DPN_4557);
        debugPageOLS
                .back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------
        approxHowlongYouBeenExpSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 10 years")
                .clickNextButton(new HowWouldYouRateYourPain_OLS());


        //----------Q10 - How would you rate your pain or discomfort on a scale of 0 to 10? - page
        howWouldYouRateYourPain_OLS
                .waitForPageLoad();
        Assert.assertEquals(howWouldYouRateYourPain_OLS.getTitleText(), howWouldYouRateYourPain_OLS.titleExpected, "Title is diff");
        DoYouHaveAnyOfTheFollowingConditions_OLS doYouHaveAnyOfTheFollowingConditions_OLS = howWouldYouRateYourPain_OLS
                .selectPainRating("5")
                .clickNextButton(new DoYouHaveAnyOfTheFollowingConditions_OLS());


        //----------Q11 -Do you have any of the following conditions related to your diabetes?-  Page ---------------
        doYouHaveAnyOfTheFollowingConditions_OLS
                .waitForPageLoad();
        Assert.assertEquals(doYouHaveAnyOfTheFollowingConditions_OLS.getTitleText(), doYouHaveAnyOfTheFollowingConditions_OLS.titleExpected, "Title is diff");
        UseDietAndExercisePage useDietAndExercisePage = doYouHaveAnyOfTheFollowingConditions_OLS
                .clickOnAnswers("Retinopathy or diabetic eye disease", "Diabetic nephropathy or kidney damage caused by diabetes")
                .clickNextButton(new UseDietAndExercisePage()); // Click NEXT button and wait for the NEXT page

        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage());

        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());
        anyPrescribedMedicationPage
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5520", protocol1, DPN_4557)
                .back();

        CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = currentlyUseMetforminOrInsulinPage
                .waitForPageLoad()
                .clickOnAnswers("Metformin")
                .clickNextButton(new CombinationWithEachOtherPageOLS());

        //----------Q14 -Which of the following have you had amputated or surgically removed because of your diabetes?-  Page ---------------
        combinationWithEachOtherPageOLS
                .waitForPageLoad();
        Assert.assertEquals(combinationWithEachOtherPageOLS.getTitleText(), combinationWithEachOtherPageOLS.titleExpected, "Title is diff");
        combinationWithEachOtherPageOLS.clickOnAnswer("1 month or less")
                .clickNextButton(new WithType2DiabetesPageOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        withType2DiabetesPageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5514", protocol1)
                .back();

        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(new WithType2DiabetesPageOLS());
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5514", protocol1)
                .back();

        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new WithType2DiabetesPageOLS());

        MetforminMedicationsPageOLS metforminMedicationsPageOLS = withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(new MetforminMedicationsPageOLS());

        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());


        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());


        //---------------------------------------noOfAlcoholicDrinkOLS---------------
        noOfAlcoholicDrinkOLS
                .waitForPageLoad();
        Assert.assertEquals(noOfAlcoholicDrinkOLS.getTitleText(), noOfAlcoholicDrinkOLS.titleExpected, "Title is diff");
        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
                .setDrinks("4")
                .clickNextButton(new LiverRelatedConditionOLS());

        //---------------------------------------liverRelatedConditionOLS---------------
        liverRelatedConditionOLS
                .waitForPageLoad();
        Assert.assertEquals(liverRelatedConditionOLS.getTitleText(), liverRelatedConditionOLS.titleExpected, "Title is diff");
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = liverRelatedConditionOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageOLS());

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS //****************
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageOLS());


        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        //----------------------GENERAL HEALTH Questions -----------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        //----DoAnyOftheFollowingAdditionalDiagnosesOLS----------
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", DPN_4557)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        //----Do any of the following additional diagnoses apply to you? ------------
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", DPN_4557)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "160")
//        				.clickNextButton(new ChildrenUnderPageOLS());
//
//
//        		//----Do you have any children under the age of 18 in your household? ------------
//        		childrenUnderPageOLS
//        				.waitForPageLoad()
//        				.clickOnAnswer("No")
//        				.clickNextButton(new TheStudySitePageOLS())
//        				.waitForPageLoad()
//        				.clickOnAnswer("Public transportation")
//        				.clickNextButton(new WhatMedicalCoveragePageOLS())
//        				.waitForPageLoad()
//        				.clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                // ----------PII (IdentificationPageOLS)
                // Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())

                //----------SiteSelection Page--------------------
                .waitForPageLoadAKC()
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())

                //----------GladLocationIsConvenient Page--------------------
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())

                //----------ThankYouCloseSimplePageOLS Page--------------------
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
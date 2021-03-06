package com.acurian.selenium.OLS;

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
import io.qameta.allure.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class DPN_3769_OLS extends BaseTest {

    @Test(enabled = false)
    @TestCaseId("00016")
    @Description("Diabetic Peripheral Neuropath (DPN)- 3769 OLS")
    public void dpn_3769_OLS() {
        String phoneNumberDPN = "AUTAMS1DPN";
        String DPN_3769 = "VMDN_003";
        String protocol2 = "NYX_2925_2001";
        String studyName = "a diabetic nerve pain";
        String studyName1 = "a diabetes study, a diabetic nerve pain";
        //String env = "STG";  //Enter which OLS environment to use for testing
        String siteName = "AUT_DPN_3769_Site";
        String zipCode = "19044";

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
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, DPN_3769, protocol2);
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
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol2);
        //Assert.assertTrue(debugPageOLS.getProtocolForQuestion(whatKindOfDiabetesPageOLS.titleExpected).contains(protocol2));
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
                .checkProtocolsEquals("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...", DPN_3769, protocol2);
        //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...").contains(DPN_3769));
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
        debugPageOLS
                .checkProtocolsContainsForQNumber("QS5522", DPN_3769, protocol2)
                .back();
        whereDoYouExperienceDiabeticNervePain_OLS
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new HowWouldYouDescribeTheSymptoms_OLS())
                .waitForPageLoad();
        debugPageOLS
                .checkProtocolsContainsForQNumber("QS5522", DPN_3769, protocol2)
                .back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
        HowWouldYouDescribeTheSymptoms_OLS howWouldYouDescribeTheSymptoms_OLS = whereDoYouExperienceDiabeticNervePain_OLS //[create NEXT PAGE Object = THIS page object]
                .waitForPageLoad()
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
        haveYouNoticedAnyOfTheFollowing_OLS.waitForPageLoad();
        Assert.assertEquals(haveYouNoticedAnyOfTheFollowing_OLS.getTitleText(), haveYouNoticedAnyOfTheFollowing_OLS.titleExpected, "Title is diff");
        ApproxHowlongYouBeenExpSymptomsOLS approxHowlongYouBeenExpSymptomsOLS = haveYouNoticedAnyOfTheFollowing_OLS   //[create NEXT PAGE Object = THIS page object]    
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproxHowlongYouBeenExpSymptomsOLS()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        approxHowlongYouBeenExpSymptomsOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - DPN Symptoms Logic", DPN_3769, protocol2);
        //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(DPN_3769));
        //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(protocol2));
        //------------ Change your answer in page 'howWouldYouDescribeTheSymptoms_OLS'-----
        debugPageOLS.back();
        haveYouNoticedAnyOfTheFollowing_OLS.waitForPageLoad();
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
        howWouldYouRateYourPain_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(approxHowlongYouBeenExpSymptomsOLS.titleExpected, DPN_3769, protocol2);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
        approxHowlongYouBeenExpSymptomsOLS.waitForPageLoad()
                .clickOnAnswer("11 or more years")
                .clickNextButton(new HowWouldYouRateYourPain_OLS());


        //----------Q10 - How would you rate your pain or discomfort on a scale of 0 to 10? - page
        howWouldYouRateYourPain_OLS.waitForPageLoad();
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
        //********Test the SKIP logic to page 13 and then click BACK button     
        useDietAndExercisePage
                .waitForPageLoad()
                .back();
        doYouHaveAnyOfTheFollowingConditions_OLS
                .waitForPageLoad();
        WhichOfTheFollowingHadAmputatedSurgically_OLS whichOfTheFollowingHadAmputatedSurgically_OLS = doYouHaveAnyOfTheFollowingConditions_OLS
                .clickOnAnswers("Amputation or surgical removal of a leg, a foot, or toes")
                .clickNextButton(new WhichOfTheFollowingHadAmputatedSurgically_OLS());


        //----------Q12 -Which of the following have you had amputated or surgically removed because of your diabetes?-  Page ---------------   
        whichOfTheFollowingHadAmputatedSurgically_OLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfTheFollowingHadAmputatedSurgically_OLS.getTitleText(), whichOfTheFollowingHadAmputatedSurgically_OLS.titleExpected, "Title is diff");
        //TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = whichOfTheFollowingHadAmputatedSurgically_OLS //[create NEXT PAGE Object = THIS page object]    
        whichOfTheFollowingHadAmputatedSurgically_OLS.clickOnAnswers("Leg", "Foot", "Toe")
                .clickNextButton(new UseDietAndExercisePage()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button     
        useDietAndExercisePage
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Which of the following have you had amputated or surgically removed because of your diabetes?Agent N...", DPN_3769, protocol2);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
        whichOfTheFollowingHadAmputatedSurgically_OLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());


        //----------Q13 -"Do you currently use diet and exercise as a way to help treat your diabetes?"-  Page ---------------   
        useDietAndExercisePage
                .waitForPageLoad();
        Assert.assertEquals(useDietAndExercisePage.getTitleText(), useDietAndExercisePage.titleExpected, "Title is diff");
        CurrentlyUseMetforminOrInsulinPage currentlyUseMetforminOrInsulinPage = useDietAndExercisePage //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPage()); // Click NEXT button and wait for the NEXT page


        //----------Q14 -Do you currently use metformin or insulin or any other medication prescribed by your doctor to treat your diabetes?  Page ---------------
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();
        Assert.assertEquals(currentlyUseMetforminOrInsulinPage.getTitleText(), currentlyUseMetforminOrInsulinPage.titleExpected, "Title is diff");
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPage //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());
        anyPrescribedMedicationPage
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5520", DPN_3769, protocol2)
                .back();
        currentlyUseMetforminOrInsulinPage
                .waitForPageLoad();
        CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = currentlyUseMetforminOrInsulinPage
                .clickOnAnswers("Metformin", "Insulin")
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
                .checkProtocolsEquals("Overall, how long have you been taking your current diabetes medication(s), either by themselves, or...", DPN_3769);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
        combinationWithEachOtherPageOLS.waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new WithType2DiabetesPageOLS());


        //-----------------Diabetes 4356A Questions---------------------------
        //--------------------------------------------------------------------
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(new MetforminMedicationsPageOLS());

        //----MetforminMedicationsPageOLS--------
        InsulinForYourDiabetesPageOLS insulinForYourDiabetesPageOLS = metforminMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InsulinForYourDiabetesPageOLS());

        //----InsulinForYourDiabetesPageOLS--------
        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());

        //----InjectableMedicationsForYourDiabetesPageOLS--------
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
                .checkProtocolsContainsForQNumber("QS38", DPN_3769)
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
                .checkProtocolsContainsForQNumber("QS59", DPN_3769)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());


        //----HEIGHT and WEIGHT Question ------------
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
//				.clickNextButton(new ChildrenUnderPageOLS());
//
//
//		//----Do you have any children under the age of 18 in your household? ------------
//		childrenUnderPageOLS
//				.waitForPageLoad()
//				.clickOnAnswer("No")
//				.clickNextButton(new TheStudySitePageOLS())
//				.waitForPageLoad()
//				.clickOnAnswer("Public transportation")
//				.clickNextButton(new WhatMedicalCoveragePageOLS())
//				.waitForPageLoad()
//				.clickOnAnswers("No, I have no coverage")
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
package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.shared.DIA.AnyPrescribedMedicationPage;
import com.acurian.selenium.pages.CC.shared.DIA.CurrentlyUseMetforminOrInsulinPageCC;
import com.acurian.selenium.pages.CC.shared.DIA.UseDietAndExercisePageCC;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class DPN_3769_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
    @TestCaseId("00015")
    @Description("Diabetic Peripheral Neuropathy(DPN) - 3769 CC")
    public void dpn_3769_CC(final String username, final String password) {
        String phoneNumberDPN = "AUTAMS1DPN";
        String DPN_3769 = "VMDN_003";
        String protocol2 = "NYX_2925_2001";
        String studyName = "a diabetic nerve pain";
        String studyName1 = "a study for diabetics";
        //String env = "STG";  //Enter which OLS environment to use for testing
        String siteName = "AUT_DPN_3769_Site";
        String zip_Code = "19044";

        String env = System.getProperty("acurian.env", "STG");

        //------------LOGIN Page for CC---------------   
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)  //Launch URL as per environment 
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();

        //------------(SelectActionPage) Study and PhoneNumber Selection Page---------------      
        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumberDPN)
                .clickPopupPhoneNumber(phoneNumberDPN)
                .clickBeginButton();

        //------------Call Center Introduction Page---------------      
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC   // RUN below mentioned methods for Right side page and then create object for the NEXT page (on Left side) = [create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC.waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleDPNExpected, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Aug")
                .setDay("1")
                .setYear("1982")
                .clickNextButton(new ZipCodePageCC());


        //------------ZIP_CODE question---------------
        GenderPageCC genderPageCC = zipCodePageCC  //[create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .typeZipCode(zip_Code)
                .clickNextButton(new GenderPageCC());


        //------------GENDER question---------------      
        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());


        //------------Q2 Have you been diagnosed with any type of diabetes?---------------
        diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageCC.getTitleText(), diagnosedAnyTypeOfDiabetesPageCC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        //------Validate protocol DQs in debug window----------
        nonQRtransitionPageCC.waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageCC.titleExpected, DPN_3769, protocol2);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageCC.back();
        //------------ Change your answer to correct option in diagnosedAnyTypeOfDiabetesPageCC---------------
        diagnosedAnyTypeOfDiabetesPageCC.waitForPageLoad();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());


        //-----------Q3 -What kind of diabetes do you have?? ---------------
        whatKindOfDiabetesPageCC.waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageCC.getTitleText(), whatKindOfDiabetesPageCC.titleExpected, "Title is diff");

        DoYouExperienceDPN_CC doYouExperienceDPN_CC = whatKindOfDiabetesPageCC  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new DoYouExperienceDPN_CC());
        //********Validate Question History for DQ and then click BACK button
        doYouExperienceDPN_CC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol2);
        debugPageCC.back();
        //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageCC---------------
        whatKindOfDiabetesPageCC.waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new DoYouExperienceDPN_CC())
                .waitForPageLoad();


        //----------Q4 - Do you experience diabetic peripheral neuropathy or diabetic nerve pain? -  Page ---------------
        doYouExperienceDPN_CC
                .waitForPageLoad();
        Assert.assertEquals(doYouExperienceDPN_CC.getTitleText(), doYouExperienceDPN_CC.titleExpected, "Title is diff");
        WithType2DiabetesPageCC withType2DiabetesPageCC = doYouExperienceDPN_CC
                .clickOnAnswer("No, none of the above")
                .clickNextButton(new WithType2DiabetesPageCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        withType2DiabetesPageCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...", DPN_3769, protocol2);
        //Assert.assertTrue(debugPageCC.getProtocolForQuestion("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...").contains(DPN_3769));
        debugPageCC.back();
        doYouExperienceDPN_CC.waitForPageLoad();
        WhereDoYouExperienceDiabeticNervePain_CC whereDoYouExperienceDiabeticNervePain_CC = doYouExperienceDPN_CC
                .clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
                .clickNextButton(new WhereDoYouExperienceDiabeticNervePain_CC());


        //----------Q5 - "Where do you experience diabetic nerve pain symptoms or sensations?" Page ---------------
        whereDoYouExperienceDiabeticNervePain_CC.waitForPageLoad();
        Assert.assertEquals(whereDoYouExperienceDiabeticNervePain_CC.getTitleText(), whereDoYouExperienceDiabeticNervePain_CC.titleExpected, "Title is diff");
        whereDoYouExperienceDiabeticNervePain_CC
                .clickOnAnswers("None of the above")
                .clickNextButton(new WithType2DiabetesPageCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        withType2DiabetesPageCC.waitForPageLoad();
        Assert.assertTrue(debugPageCC.getProtocolForQuestion("Where do you experience diabetic nerve pain symptoms or sensations?Agent Note: Select all that apply...").contains(DPN_3769));
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------
        HowWouldYouDescribeTheSymptoms_CC howWouldYouDescribeTheSymptoms_CC = whereDoYouExperienceDiabeticNervePain_CC //[create NEXT PAGE Object = THIS page object]
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right foot", "Right leg", "Left foot", "Left leg")
                .clickNextButton(new HowWouldYouDescribeTheSymptoms_CC());

        //----------Q6 - How would you describe the symptoms or sensations you feel in your feet, legs, hands, or arms? ---------
        howWouldYouDescribeTheSymptoms_CC.waitForPageLoad();
        Assert.assertEquals(howWouldYouDescribeTheSymptoms_CC.getTitleText(), howWouldYouDescribeTheSymptoms_CC.titleExpected, "Title is diff");
        howWouldYouDescribeTheSymptoms_CC
                .clickOnAnswers("None of the above");
        HaveYouNoticedAnyOfTheFollowing_CC haveYouNoticedAnyOfTheFollowing_CC = howWouldYouDescribeTheSymptoms_CC   //[create NEXT PAGE Object = THIS page object]
                .clickNextButton(new HaveYouNoticedAnyOfTheFollowing_CC()); // Click NEXT button and wait for the NEXT page

        //----------Q7 "Have you noticed any of the following in your feet, legs, hands, or arms?" ---------------
        haveYouNoticedAnyOfTheFollowing_CC.waitForPageLoad();
        Assert.assertEquals(haveYouNoticedAnyOfTheFollowing_CC.getTitleText(), haveYouNoticedAnyOfTheFollowing_CC.titleExpected, "Title is diff");
        ApproxHowlongYouBeenExpSymptomsCC approxHowlongYouBeenExpSymptomsCC = haveYouNoticedAnyOfTheFollowing_CC   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproxHowlongYouBeenExpSymptomsCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        approxHowlongYouBeenExpSymptomsCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - DPN Symptoms Logic", DPN_3769, protocol2);
        //Assert.assertTrue(debugPageCC.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(DPN_3769));
        //Assert.assertTrue(debugPageCC.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(protocol2));
        //------------ Change your answer in page 'howWouldYouDescribeTheSymptoms_CC'-----
        debugPageCC.back();
        haveYouNoticedAnyOfTheFollowing_CC.waitForPageLoad();
        debugPageCC.back();
        howWouldYouDescribeTheSymptoms_CC.waitForPageLoad()
                .clickOnAnswers("Burning", "Painful cold")
                .clickNextButton(new HaveYouNoticedAnyOfTheFollowing_CC())
                .waitForPageLoad()
                .clickNextButton(new ApproxHowlongYouBeenExpSymptomsCC());

        //----------Q8 "Ghost Question - DPN Symptoms Logic" ---------------


        //----------Q9 -Approximately how long have you been experiencing symptoms or sensations of diabetic nerve pain?-  Page ---------------
        approxHowlongYouBeenExpSymptomsCC
                .waitForPageLoad();
        Assert.assertEquals(approxHowlongYouBeenExpSymptomsCC.getTitleText(), approxHowlongYouBeenExpSymptomsCC.titleExpected, "Title is diff");
        HowWouldYouRateYourPain_CC howWouldYouRateYourPain_CC = approxHowlongYouBeenExpSymptomsCC //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowWouldYouRateYourPain_CC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        howWouldYouRateYourPain_CC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(approxHowlongYouBeenExpSymptomsCC.titleExpected, DPN_3769, protocol2);
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------
        approxHowlongYouBeenExpSymptomsCC.waitForPageLoad()
                .clickOnAnswer("11 or more years")
                .clickNextButton(new HowWouldYouRateYourPain_CC());


        //----------Q10 - How would you rate your pain or discomfort on a scale of 0 to 10? - page
        howWouldYouRateYourPain_CC.waitForPageLoad();
        Assert.assertEquals(howWouldYouRateYourPain_CC.getTitleText(), howWouldYouRateYourPain_CC.titleExpected, "Title is diff");
        DoYouHaveAnyOfTheFollowingConditions_CC doYouHaveAnyOfTheFollowingConditions_CC = howWouldYouRateYourPain_CC
                .selectPainRating("5")
                .clickNextButton(new DoYouHaveAnyOfTheFollowingConditions_CC());


        //----------Q11 -Do you have any of the following conditions related to your diabetes?-  Page ---------------
        doYouHaveAnyOfTheFollowingConditions_CC
                .waitForPageLoad();
        Assert.assertEquals(doYouHaveAnyOfTheFollowingConditions_CC.getTitleText(), doYouHaveAnyOfTheFollowingConditions_CC.titleExpected, "Title is diff");
        UseDietAndExercisePageCC useDietAndExercisePageCC = doYouHaveAnyOfTheFollowingConditions_CC
                .clickOnAnswers("Retinopathy or diabetic eye disease", "Diabetic nephropathy or kidney damage caused by diabetes")
                .clickNextButton(new UseDietAndExercisePageCC()); // Click NEXT button and wait for the NEXT page
        //********Test the SKIP logic to page 13 and then click BACK button
        useDietAndExercisePageCC.waitForPageLoad()
                .back();
        doYouHaveAnyOfTheFollowingConditions_CC.waitForPageLoad();
        WhichOfTheFollowingHadAmputatedSurgically_CC whichOfTheFollowingHadAmputatedSurgically_CC = doYouHaveAnyOfTheFollowingConditions_CC
                .clickOnAnswers("Amputation or surgical removal of a leg, a foot, or toes")
                .clickNextButton(new WhichOfTheFollowingHadAmputatedSurgically_CC());


        //----------Q12 -Which of the following have you had amputated or surgically removed because of your diabetes?-  Page ---------------
        whichOfTheFollowingHadAmputatedSurgically_CC
                .waitForPageLoad();
        Assert.assertEquals(whichOfTheFollowingHadAmputatedSurgically_CC.getTitleText(), whichOfTheFollowingHadAmputatedSurgically_CC.titleExpected, "Title is diff");
        //TreatingYourDiabetesPageCC treatingYourDiabetesPageCC = whichOfTheFollowingHadAmputatedSurgically_CC //[create NEXT PAGE Object = THIS page object]
        whichOfTheFollowingHadAmputatedSurgically_CC.clickOnAnswers("Leg", "Foot", "Toe")
                .clickNextButton(new UseDietAndExercisePageCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        useDietAndExercisePageCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Which of the following have you had amputated or surgically removed because of your diabetes?Agent N...", DPN_3769, protocol2);
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------
        whichOfTheFollowingHadAmputatedSurgically_CC.waitForPageLoad()
                .clickOnAnswers("None of the above") //un-select Leg and Foot and keep only None-of-the-above selected to qualify for 3769 DPN
                .clickNextButton(new UseDietAndExercisePageCC());


        //----------Q13 -UseDietAndExercisePageCC-  Page ---------------
        useDietAndExercisePageCC
                .waitForPageLoad();
        Assert.assertEquals(useDietAndExercisePageCC.getTitleText(), useDietAndExercisePageCC.titleExpected, "Title is diff");
        CurrentlyUseMetforminOrInsulinPageCC currentlyUseMetforminOrInsulinPageCC = useDietAndExercisePageCC
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyUseMetforminOrInsulinPageCC());


        //----------Q14 -Do you currently use metformin or insulin or any other medication prescribed by your doctor to treat your diabetes?  Page ---------------
        currentlyUseMetforminOrInsulinPageCC
                .waitForPageLoad();
        Assert.assertEquals(currentlyUseMetforminOrInsulinPageCC.getTitleText(), currentlyUseMetforminOrInsulinPageCC.titleExpected, "Title is diff");
        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPageCC //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
                .clickNextButton(new AnyPrescribedMedicationPage());
        anyPrescribedMedicationPage
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016801-QS5520-STUDYQUES", DPN_3769)
                .back();
        currentlyUseMetforminOrInsulinPageCC
                .waitForPageLoad();
        CombinationWithEachOtherPageCC combinationWithEachOtherPageCC = currentlyUseMetforminOrInsulinPageCC
                .clickOnAnswers("Metformin", "Insulin")
                .clickNextButton(new CombinationWithEachOtherPageCC());


        //----------Q14 -Which of the following have you had amputated or surgically removed because of your diabetes?-  Page ---------------
        combinationWithEachOtherPageCC
                .waitForPageLoad();
        Assert.assertEquals(combinationWithEachOtherPageCC.getTitleText(), combinationWithEachOtherPageCC.titleExpected, "Title is diff");
        combinationWithEachOtherPageCC.clickOnAnswer("1 month or less")
                .clickNextButton(new WithType2DiabetesPageCC()); // Click NEXT button and wait for the NEXT page
        //********Validate Question History for DQ and then click BACK button
        withType2DiabetesPageCC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Overall, how long have you been taking your current diabetes medication(s), either by themselves, or...", DPN_3769);
        debugPageCC.back();
        //------------ Change your answer to correct QR age in page 'studyQuestionMigPageCC'---------------
        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new WithType2DiabetesPageCC());


        //-----------------Diabetes 4356A Questions---------------------------
        //--------------------------------------------------------------------
        MetforminMedicationsPageCC metforminMedicationsPageCC = withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(new MetforminMedicationsPageCC());

        //----MetforminMedicationsPageOLS--------
        InsulinForYourDiabetesPageCC insulinForYourDiabetesPageCC = metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InsulinForYourDiabetesPageCC());

        //----InsulinForYourDiabetesPageOLS--------
        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());

        //----InjectableMedicationsForYourDiabetesPageOLS--------
        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NoOfAlcoholicDrinksCC());


        //---------------------------------------noOfAlcoholicDrinkOLS---------------
        noOfAlcoholicDrinksCC
                .waitForPageLoad();
        Assert.assertEquals(noOfAlcoholicDrinksCC.getTitleText(), noOfAlcoholicDrinksCC.titleExpected, "Title is diff");
        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
                .setDrinks("4")
                .clickNextButton(new FollowingLiverRelatedConditionCC());
                
           /*     NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = lastTimeYouTookPageCC
                		.waitForPageLoad()
        				.clickOnAnswer("6 months ago or longer")
        				.clickNextButton(new NoOfAlcoholicDrinksCC());
                
                FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
                		.waitForPageLoad()
                		.enterNoOfDrinks("4")
                		.clickNextButton(new FollowingLiverRelatedConditionCC()); */

        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingToLoseWeightPageCC());

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());

        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageCC());

        poundsOrMorePageCC
                .waitForPageLoad();
        TransitionStatementCC transitionStatementCC = poundsOrMorePageCC
                .clickOnAnswer("Unsure")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoad("diabetes");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //----------------------GENERAL HEALTH Questions -----------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease", "Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        //----DoAnyOftheFollowingAdditionalDiagnosesOLS----------
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES", DPN_3769)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


        //----Do any of the following additional diagnoses apply to you? ------------
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad();
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .clickOnAnswers("Alzheimer's disease",
                        "Bipolar disorder",
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
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", DPN_3769)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());


        //----HEIGHT and WEIGHT Question ------------
        approximateHeightPageCC
                .waitForPageLoad();
        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                //----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
//                .clickNextButton(new ChildrenUnderPageCC());
//
//
//        //----Do you have any children under the age of 18 in your household? ------------
//        childrenUnderPageCC
//                .waitForPageLoad()
//                //TheStudySitePageCC theStudySitePageCC = childrenUnderPageCC()
//                .clickOnAnswer("No")
                /*		.clickNextButton(new TheStudySitePageCC());
                TheStudySitePageCC theStudySitePageCC = new TheStudySitePageCC();



                // -------------------PEDIATRIC QUESTIONS-----------------------------
                theStudySitePageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Public transportation")
                        .clickNextButton(new WhatMedicalCoveragePageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("No, I have no coverage")
                        .clickNextButton(new EthnicBackgroundPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("Prefer not to answer")*/
                .clickNextButton(new IdentificationPageCC())

                //----------PII (IdentificationPageCC) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)
                .clickNextButton(new SiteSelectionPageCC())

                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())

                //----------GladLocationIsConvenient Page--------------------
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())

                //----------ThankYouCloseSimplePageCC Page--------------------
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
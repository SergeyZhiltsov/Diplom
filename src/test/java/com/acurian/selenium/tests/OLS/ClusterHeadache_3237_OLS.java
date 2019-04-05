package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ClusterHeadache_3237.AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS;
import com.acurian.selenium.pages.OLS.ClusterHeadache_3237.WhenYouAreExperiencingCHattackIsTheLocationPain_OLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class ClusterHeadache_3237_OLS extends BaseTest {

    @Test
    @Description("a cluster headache study 3237 - OLS")
    public void clusterHeadache3237ols() {
        Site site = Site.AUT_CLH_3237_Site;
        String phoneNumber = "AUTAMS1CLH";
        String studyName = "a cluster headache";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a cluster headache study", "300"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
                .clickNextButton(new ZipCodePageOLS());

        //------------ZIP_CODE question---------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        //------------GENDER question---------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HasDoctorDiagnosedYouWithClusterHeadache_OLS hasDoctorDiagnosedYouWithClusterHeadache_OLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_OLS());


        //------------Q2 Has a doctor diagnosed you with cluster headache??---------------
        hasDoctorDiagnosedYouWithClusterHeadache_OLS
                .waitForPageLoad();
        Assert.assertEquals(hasDoctorDiagnosedYouWithClusterHeadache_OLS.getTitleText(), hasDoctorDiagnosedYouWithClusterHeadache_OLS.titleExpected, "Title is diff");
        DoYouSufferFromMigHeadachesOLS doYouSufferFromMigHeadachesOLS = hasDoctorDiagnosedYouWithClusterHeadache_OLS
                .clickOnAnswer("No, I have been diagnosed with another type of headache")
                .clickNextButton(new DoYouSufferFromMigHeadachesOLS());
        //------Validate protocol DQs in debug window----------
        doYouSufferFromMigHeadachesOLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to next DQ option---------------
        hasDoctorDiagnosedYouWithClusterHeadache_OLS.waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = hasDoctorDiagnosedYouWithClusterHeadache_OLS
                .clickOnAnswer("No, I get headaches regularly but I am unsure which type")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        //------Validate protocol DQs in debug window----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to next DQ option---------------
        hasDoctorDiagnosedYouWithClusterHeadache_OLS.waitForPageLoad()
                .clickOnAnswer("No, I do not get headaches regularly")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        //------Validate protocol DQs in debug window----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to CORRECT QR option---------------
        hasDoctorDiagnosedYouWithClusterHeadache_OLS.waitForPageLoad();
        WhatTypeOfDoctorDiagnosedCH_OLS whatTypeOfDoctorDiagnosedCH_OLS = hasDoctorDiagnosedYouWithClusterHeadache_OLS  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes, I have been diagnosed with cluster headache")
                .clickNextButton(new WhatTypeOfDoctorDiagnosedCH_OLS());


        //-----------Q3 - What type of doctor diagnosed you with cluster headache? ---------------
        whatTypeOfDoctorDiagnosedCH_OLS.waitForPageLoad();
        Assert.assertEquals(whatTypeOfDoctorDiagnosedCH_OLS.getTitleText(), whatTypeOfDoctorDiagnosedCH_OLS.titleExpected, "Title is diff");
        //DoYouExperienceDPN_OLS doYouExperienceDPN_OLS = whatTypeOfDoctorDiagnosedCH_OLS  //[create NEXT PAGE Object = THIS page object]
        whatTypeOfDoctorDiagnosedCH_OLS.clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        //********Validate Question History for DQ and then click BACK button
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("What type of doctor diagnosed you with cluster headache?Agent Note: If multiple doctors confirmed th...", site.activeProtocols);
        debugPageOLS.back();
        //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageOLS---------------
        whatTypeOfDoctorDiagnosedCH_OLS.waitForPageLoad();
        HowLongDoYourClusterPeriodsTypicallyLast_OLS howLongDoYourClusterPeriodsTypicallyLast_OLS = whatTypeOfDoctorDiagnosedCH_OLS
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Neurologist", "Headache specialist", "Pain specialist")
                .clickNextButton(new HowLongDoYourClusterPeriodsTypicallyLast_OLS());


        //----------Q4 - How long do your cluster periods typically last? Page ---------------
        howLongDoYourClusterPeriodsTypicallyLast_OLS
                .waitForPageLoad();
        Assert.assertEquals(howLongDoYourClusterPeriodsTypicallyLast_OLS.getTitleText(), howLongDoYourClusterPeriodsTypicallyLast_OLS.titleExpected, "Title is diff");
        WhenYouAreInClusterPeriodHowOften_OLS whenYouAreInClusterPeriodHowOften_OLS = howLongDoYourClusterPeriodsTypicallyLast_OLS
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(new WhenYouAreInClusterPeriodHowOften_OLS()); // Click NEXT button and wait for the NEXT page


        //----------Q5 - "When you are in a cluster period, how often do you have cluster headache attacks?" Page ---------------
        whenYouAreInClusterPeriodHowOften_OLS.waitForPageLoad();
        Assert.assertEquals(whenYouAreInClusterPeriodHowOften_OLS.getTitleText(), whenYouAreInClusterPeriodHowOften_OLS.titleExpected, "Title is diff");
        WhenYouAreHavingClusterHeadacheAttackDoYouExp_OLS whenYouAreHavingClusterHeadacheAttackDoYouExp_OLS = whenYouAreInClusterPeriodHowOften_OLS
                .clickOnAnswer("Once a day")
                .clickNextButton(new WhenYouAreHavingClusterHeadacheAttackDoYouExp_OLS()); // Click NEXT button and wait for the NEXT page


        //----------Q6 - When you are having a cluster headache attack, do you experience any of the following symptoms in your eye, nose, ear, or face? ---------
        whenYouAreHavingClusterHeadacheAttackDoYouExp_OLS.waitForPageLoad();
        Assert.assertEquals(whenYouAreHavingClusterHeadacheAttackDoYouExp_OLS.getTitleText(), whenYouAreHavingClusterHeadacheAttackDoYouExp_OLS.titleExpected, "Title is diff");
        whenYouAreHavingClusterHeadacheAttackDoYouExp_OLS.clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        //------Validate protocol DQs in debug window----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("When you are having a cluster headache attack, do you experience any of the following symptoms in yo...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to CORRECT QR option---------------
        whenYouAreHavingClusterHeadacheAttackDoYouExp_OLS.waitForPageLoad();
        DoYouExperienceAnyOfTheFollowingFeelings_OLS doYouExperienceAnyOfTheFollowingFeelings_OLS = whenYouAreHavingClusterHeadacheAttackDoYouExp_OLS   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("Flushing or redness of your face or forehead")
                .clickNextButton(new DoYouExperienceAnyOfTheFollowingFeelings_OLS());


        //----------Q7 "Do you experience any of the following feelings or behaviors when you are having a cluster headache attack?" ---------------
        doYouExperienceAnyOfTheFollowingFeelings_OLS.waitForPageLoad();
        Assert.assertEquals(doYouExperienceAnyOfTheFollowingFeelings_OLS.getTitleText(), doYouExperienceAnyOfTheFollowingFeelings_OLS.titleExpected, "Title is diff");
        WhenYouAreExperiencingCHattackIsTheLocationPain_OLS whenYouAreExperiencingCHattackIsTheLocationPain_OLS = doYouExperienceAnyOfTheFollowingFeelings_OLS   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhenYouAreExperiencingCHattackIsTheLocationPain_OLS());
        //------Validate protocol DQs in debug window----------
        whenYouAreExperiencingCHattackIsTheLocationPain_OLS.waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("Do you experience any of the following feelings or behaviors when you are having a cluster headache ...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageOLS.back();
        //------------ Change your answer to CORRECT QR option---------------
        doYouExperienceAnyOfTheFollowingFeelings_OLS.waitForPageLoad()
                .clickOnAnswers("Feeling restless, agitated, or irritated")
                .clickNextButton(new WhenYouAreExperiencingCHattackIsTheLocationPain_OLS());


        //----------Q8 -"When you are experiencing a cluster headache attack, is the location of your pain always on one side of the head or near your eye?"  Page ---------------
        whenYouAreExperiencingCHattackIsTheLocationPain_OLS
                .waitForPageLoad();
        Assert.assertEquals(whenYouAreExperiencingCHattackIsTheLocationPain_OLS.getTitleText(), whenYouAreExperiencingCHattackIsTheLocationPain_OLS.titleExpected, "Title is diff");
        AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS = whenYouAreExperiencingCHattackIsTheLocationPain_OLS //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS()); // Click NEXT button and wait for the NEXT page


        //----------Q9 - "Are you currently experiencing cluster headache attacks daily or frequently?" - page
        areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS.waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS.getTitleText(), areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS.titleExpected, "Title is diff");
        //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS
        areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_OLS.clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        //----------*******NEW GENERAL HEALTH Questions********----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
//                .clickNextButton(new ChildrenUnderPageOLS())
//                //----------ChildrenUnderTheAge Page--------------------
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new HouseholdHavePageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new TheStudySitePageOLS())
//                .waitForPageLoad()
//                //-------------------PEDIATRIC QUESTIONS-----------------------------
//                .clickOnAnswer("Public transportation")
//                .clickNextButton(new WhatMedicalCoveragePageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                //----------GladLocationIsConvenient Page--------------------
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                //----------ThankYouCloseSimplePageOLS Page--------------------
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
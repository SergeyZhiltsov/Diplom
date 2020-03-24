package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ClusterHeadache_3237.AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC;
import com.acurian.selenium.pages.CC.ClusterHeadache_3237.WhenYouAreExperiencingCHattackIsTheLocationPain_CC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class ClusterHeadache_3237_CC extends BaseTest {

    @Test(enabled = false) // Deactivate module: "Cluster_Headache_3237" R72 72.2 02-May-19
    @Description("a cluster headache study 3237 CC")
    public void clusterHeadache3237сс() {
        Site site = Site.AUT_CLH_3237_Site;
        String phoneNumber = "AUTAMS1CLH";
        String studyName = "a cluster headache";

        String env = System.getProperty("acurian.env", "STG");

        //------------LOGIN Page for CC---------------   
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)  //Launch URL as per environment 
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        //------------(SelectActionPage) Study and PhoneNumber Selection Page---------------      
        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        //------------Call Center Introduction Page---------------      
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC   // RUN below mentioned methods for Right side page and then create object for the NEXT page (on Left side) = [create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a cluster headache study", "300");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a cluster headache study", "300"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Aug")
                .setDay("1")
                .setYear("1982")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());


        //------------ZIP_CODE question---------------
        GenderPageCC genderPageCC = zipCodePageCC  //[create NEXT PAGE Object = THIS page object] 
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        //------------GENDER question---------------      
        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        HasDoctorDiagnosedYouWithClusterHeadache_CC hasDoctorDiagnosedYouWithClusterHeadache_CC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_CC());


        //------------Q2 Has a doctor diagnosed you with cluster headache??---------------
        hasDoctorDiagnosedYouWithClusterHeadache_CC
                .waitForPageLoad();
        Assert.assertEquals(hasDoctorDiagnosedYouWithClusterHeadache_CC.getTitleText(), hasDoctorDiagnosedYouWithClusterHeadache_CC.titleExpected, "Title is diff");
        hasDoctorDiagnosedYouWithClusterHeadache_CC
                .clickOnAnswer("No, I have been diagnosed with another type of headache")
                .clickNextButton(new DoYouSufferFromMigPageCC())
                .waitForPageLoad();


        //------Validate protocol DQs in debug window----------

        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageCC.back();
        //------------ Change your answer to next DQ option---------------
        hasDoctorDiagnosedYouWithClusterHeadache_CC.waitForPageLoad();
        NonQRtransitionPageCC nonQRtransitionPageCC = hasDoctorDiagnosedYouWithClusterHeadache_CC
                .clickOnAnswer("No, I get headaches regularly but I am unsure which type")
                .clickNextButton(new NonQRtransitionPageCC());
        //------Validate protocol DQs in debug window----------
        nonQRtransitionPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageCC.back();
        //------------ Change your answer to next DQ option---------------
        hasDoctorDiagnosedYouWithClusterHeadache_CC.waitForPageLoad()
                .clickOnAnswer("No, I do not get headaches regularly")
                .clickNextButton(new NonQRtransitionPageCC());
        //------Validate protocol DQs in debug window----------
        nonQRtransitionPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageCC.back();
        //------------ Change your answer to CORRECT QR option---------------
        hasDoctorDiagnosedYouWithClusterHeadache_CC.waitForPageLoad();
        WhatTypeOfDoctorDiagnosedCH_CC whatTypeOfDoctorDiagnosedCH_CC = hasDoctorDiagnosedYouWithClusterHeadache_CC  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes, I have been diagnosed with cluster headache")
                .clickNextButton(new WhatTypeOfDoctorDiagnosedCH_CC());


        //-----------Q3 - What type of doctor diagnosed you with cluster headache? ---------------
        whatTypeOfDoctorDiagnosedCH_CC.waitForPageLoad();
        Assert.assertEquals(whatTypeOfDoctorDiagnosedCH_CC.getTitleText(), whatTypeOfDoctorDiagnosedCH_CC.titleExpected, "Title is diff");
        TransitionStatementCC transitionStatementCC = whatTypeOfDoctorDiagnosedCH_CC  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(new TransitionStatementCC());
        //********Validate Question History for DQ and then click BACK button
        transitionStatementCC.waitForPageLoad("cluster headache")
                .getPage(debugPageCC)
                .checkProtocolsEquals("What type of doctor diagnosed you with cluster headache?Agent Note: If multiple doctors confirmed th...", site.activeProtocols);
        debugPageCC.back();
        //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageOLS---------------
        whatTypeOfDoctorDiagnosedCH_CC.waitForPageLoad();
        HowLongDoYourClusterPeriodsTypicallyLast_CC howLongDoYourClusterPeriodsTypicallyLast_CC = whatTypeOfDoctorDiagnosedCH_CC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Neurologist", "Headache specialist", "Pain specialist")
                .clickNextButton(new HowLongDoYourClusterPeriodsTypicallyLast_CC());


        //----------Q4 - How long do your cluster periods typically last? Page ---------------
        howLongDoYourClusterPeriodsTypicallyLast_CC
                .waitForPageLoad();
        Assert.assertEquals(howLongDoYourClusterPeriodsTypicallyLast_CC.getTitleText(), howLongDoYourClusterPeriodsTypicallyLast_CC.titleExpected, "Title is diff");
        WhenYouAreInClusterPeriodHowOften_CC whenYouAreInClusterPeriodHowOften_CC = howLongDoYourClusterPeriodsTypicallyLast_CC
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(new WhenYouAreInClusterPeriodHowOften_CC()); // Click NEXT button and wait for the NEXT page


        //----------Q5 - "When you are in a cluster period, how often do you have cluster headache attacks?" Page ---------------
        whenYouAreInClusterPeriodHowOften_CC.waitForPageLoad();
        Assert.assertEquals(whenYouAreInClusterPeriodHowOften_CC.getTitleText(), whenYouAreInClusterPeriodHowOften_CC.titleExpected, "Title is diff");
        WhenYouAreHavingClusterHeadacheAttackDoYouExp_CC whenYouAreHavingClusterHeadacheAttackDoYouExp_CC = whenYouAreInClusterPeriodHowOften_CC
                .clickOnAnswer("Once a day")
                .clickNextButton(new WhenYouAreHavingClusterHeadacheAttackDoYouExp_CC()); // Click NEXT button and wait for the NEXT page


        //----------Q6 - When you are having a cluster headache attack, do you experience any of the following symptoms in your eye, nose, ear, or face? ---------
        whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.waitForPageLoad();
        Assert.assertEquals(whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.getTitleText(), whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.titleExpected, "Title is diff");
        whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());
        //------Validate protocol DQs in debug window----------
        transitionStatementCC.waitForPageLoad("cluster headache");
        debugPageCC.checkProtocolsEquals("When you are having a cluster headache attack, do you experience any of the following symptoms in yo...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageCC.back();
        //------------ Change your answer to CORRECT QR option---------------
        whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.waitForPageLoad();
        DoYouExperienceAnyOfTheFollowingFeelings_CC doYouExperienceAnyOfTheFollowingFeelings_CC = whenYouAreHavingClusterHeadacheAttackDoYouExp_CC   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("Flushing or redness of your face or forehead")
                .clickNextButton(new DoYouExperienceAnyOfTheFollowingFeelings_CC());


        //----------Q7 "Do you experience any of the following feelings or behaviors when you are having a cluster headache attack?" ---------------
        doYouExperienceAnyOfTheFollowingFeelings_CC.waitForPageLoad();
        Assert.assertEquals(doYouExperienceAnyOfTheFollowingFeelings_CC.getTitleText(), doYouExperienceAnyOfTheFollowingFeelings_CC.titleExpected, "Title is diff");
        WhenYouAreExperiencingCHattackIsTheLocationPain_CC whenYouAreExperiencingCHattackIsTheLocationPain_CC = doYouExperienceAnyOfTheFollowingFeelings_CC   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhenYouAreExperiencingCHattackIsTheLocationPain_CC());
        //------Validate protocol DQs in debug window----------
        whenYouAreExperiencingCHattackIsTheLocationPain_CC.waitForPageLoad();
        debugPageCC.checkProtocolsEquals("Do you experience any of the following feelings or behaviors when you are having a cluster headache ...", site.activeProtocols);
        //------Go BACK and change your answer to QR answer - to qualify----------
        debugPageCC.back();
        //------------ Change your answer to CORRECT QR option---------------
        doYouExperienceAnyOfTheFollowingFeelings_CC.waitForPageLoad()
                .clickOnAnswers("Feeling restless, agitated, or irritated")
                .clickNextButton(new WhenYouAreExperiencingCHattackIsTheLocationPain_CC());


        //----------Q8 -"When you are experiencing a cluster headache attack, is the location of your pain always on one side of the head or near your eye?"  Page ---------------
        whenYouAreExperiencingCHattackIsTheLocationPain_CC
                .waitForPageLoad();
        Assert.assertEquals(whenYouAreExperiencingCHattackIsTheLocationPain_CC.getTitleText(), whenYouAreExperiencingCHattackIsTheLocationPain_CC.titleExpected, "Title is diff");
        AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC = whenYouAreExperiencingCHattackIsTheLocationPain_CC //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC()); // Click NEXT button and wait for the NEXT page


        //----------Q9 - "Are you currently experiencing cluster headache attacks daily or frequently?" - page
        areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC.waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC.getTitleText(), areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC.titleExpected, "Title is diff");
        areYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC.clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC.waitForPageLoad("cluster headache");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //----------*******NEW GENERAL HEALTH Questions********----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                //----------LetMeSeePageCC Page--------------------
                .waitForPageLoad()
//                .clickNextButton(new ChildrenUnderPageCC())
//        	 //----------ChildrenUnderTheAge Page--------------------
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                //----------PII Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a cluster headache study")
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "3237")
                .dispoShouldMatch(site.dispo, site.dispo);
                
                
   /*//--------------------OLD GENERAL HEALTH Questions----------
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HaveYouUndergoneAnyPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new CongestiveHeartFailurePageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new AffectingYourMetabolismPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new FollowingNeurologicalConditions())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new AffectYourLungsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new FollowingDigestiveConditionsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new BoneOrJointConditionsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new SleepRelatedConditionsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new FollowingSkinConditionsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new FollowingViralConditionsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new FollowingMentalHealthPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new FollowingWomensHealthPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new OtherThanSkinCancerPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new SmokedCigarettesPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No, I never smoked")
                        .clickNextButton(new HistoryOfDrugPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ApproximateHeightPageCC())
                        .waitForPageLoad()                
                        .setAll("5", "5", "160")
                        .clickNextButton(new LetMeSeePageCC())
                        .waitForPageLoad()
                        .clickNextButton(new ChildrenUnderPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new IdentificationPageCC())
                        .waitForPageLoad()
                        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)              
                        .clickNextButton(new SiteSelectionPageCC())
                        .waitForPageLoad("a cluster headache study")
                        .getPID()
                        .clickOnAnswer(siteName)
                         //QualifiedClose2PageCC
                        .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env); */
    }
}
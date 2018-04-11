package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.ApproxHowlongYouBeenExpSymptomsCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.DoYouExperienceDPN_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.DoYouHaveAnyOfTheFollowingConditions_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.HaveYouNoticedAnyOfTheFollowing_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.HowWouldYouDescribeTheSymptoms_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.HowWouldYouRateYourPain_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.WhereDoYouExperienceDiabeticNervePain_CC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.WhichOfTheFollowingHadAmputatedSurgically_CC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.CombinationWithEachOtherPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.LastTimeYouTookPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.TreatingYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatMedicalCoveragePageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.WeightLossSurgeryPageCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.pages.CC.ClusterHeadache_3237.AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC;
import com.acurian.selenium.pages.CC.ClusterHeadache_3237.WhenYouAreExperiencingCHattackIsTheLocationPain_CC;
import com.acurian.selenium.pages.CC.generalHealth.HeartrelatedMedicalProceduresPageCC;
import com.acurian.selenium.pages.CC.shared.DoYouExperienceAnyOfTheFollowingFeelings_CC;
import com.acurian.selenium.pages.CC.shared.HowLongDoYourClusterPeriodsTypicallyLast_CC;
import com.acurian.selenium.pages.CC.shared.WhatTypeOfDoctorDiagnosedCH_CC;
import com.acurian.selenium.pages.CC.shared.WhenYouAreHavingClusterHeadacheAttackDoYouExp_CC;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.GladLocationIsConvenient;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.HouseholdHavePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.CC.SUI_3923.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingDigestiveConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingNeurologicalConditions;
import com.acurian.selenium.pages.CC.generalHealth.FollowingSkinConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingViralConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingWomensHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouUndergoneAnyPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartFailureIsAlsoPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HistoryOfDrugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.OtherThanSkinCancerPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SleepRelatedConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class ClusterHeadache_3237_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00020")
    @Description("a cluster headache study 3237 CC")
    public void clusterHeadache_3237_CC(final String username, final String password) {
        String phoneNumber = "AUTAMS1CLH";
        String protocol1 = "TV48125_CNS_30056";
        String protocol2 = "TV48125_CNS_30057";
        String studyName = "a cluster headache";
       // String env = "STG";  //Enter which CC environment to use for testing
        String siteName = "AUT_CLH_3237_Site";
        String zip_Code = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        
        //------------LOGIN Page for CC---------------   
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)  //Launch URL as per environment 
                .waitForPageLoad();
         
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
        
        dateOfBirthPageCC.waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleCLHExpected, "Title is diff");
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
         		HasDoctorDiagnosedYouWithClusterHeadache_CC hasDoctorDiagnosedYouWithClusterHeadache_CC = genderPageCC
         		.clickOnAnswer("Female")
         		.clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_CC());
                
                
                //------------Q2 Has a doctor diagnosed you with cluster headache??---------------      
                hasDoctorDiagnosedYouWithClusterHeadache_CC
                .waitForPageLoad();
                Assert.assertEquals(hasDoctorDiagnosedYouWithClusterHeadache_CC.getTitleText(),hasDoctorDiagnosedYouWithClusterHeadache_CC.titleExpected, "Title is diff");
                DoYouSufferFromMigPageCC doYouSufferFromMigPageCC = hasDoctorDiagnosedYouWithClusterHeadache_CC
                .clickOnAnswer("No, I have been diagnosed with another type of headache")
                .clickNextButton(new DoYouSufferFromMigPageCC()); 
             //------Validate protocol DQs in debug window----------
                doYouSufferFromMigPageCC.waitForPageLoad();
                DebugPageCC debugPageCC = new DebugPageCC();
                debugPageCC.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", protocol1,protocol2);
                //------Go BACK and change your answer to QR answer - to qualify----------
                debugPageCC.back();
                //------------ Change your answer to next DQ option---------------          
                hasDoctorDiagnosedYouWithClusterHeadache_CC.waitForPageLoad();
                NonQRtransitionPageCC nonQRtransitionPageCC = hasDoctorDiagnosedYouWithClusterHeadache_CC
                .clickOnAnswer("No, I get headaches regularly but I am unsure which type")
                .clickNextButton(new NonQRtransitionPageCC());    
            //------Validate protocol DQs in debug window----------
                nonQRtransitionPageCC.waitForPageLoad();
                debugPageCC.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", protocol1,protocol2);
                //------Go BACK and change your answer to QR answer - to qualify----------
                debugPageCC.back();
                //------------ Change your answer to next DQ option---------------          
                hasDoctorDiagnosedYouWithClusterHeadache_CC.waitForPageLoad()
                .clickOnAnswer("No, I do not get headaches regularly")
                .clickNextButton(new NonQRtransitionPageCC());    
             //------Validate protocol DQs in debug window----------
                nonQRtransitionPageCC.waitForPageLoad();
                debugPageCC.checkProtocolsEquals("Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occur...", protocol1,protocol2);
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
                .checkProtocolsEquals("What type of doctor diagnosed you with cluster headache?Agent Note: If multiple doctors confirmed th...",protocol1,protocol2);
                debugPageCC.back();
                //------------ Change your answer to correct QR age in howOldWereYouMigHeadachePageOLS---------------   
                whatTypeOfDoctorDiagnosedCH_CC.waitForPageLoad();
                HowLongDoYourClusterPeriodsTypicallyLast_CC howLongDoYourClusterPeriodsTypicallyLast_CC = whatTypeOfDoctorDiagnosedCH_CC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Neurologist","Headache specialist","Pain specialist")
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
                Assert.assertEquals(whenYouAreInClusterPeriodHowOften_CC.getTitleText(),whenYouAreInClusterPeriodHowOften_CC.titleExpected, "Title is diff");    
                WhenYouAreHavingClusterHeadacheAttackDoYouExp_CC whenYouAreHavingClusterHeadacheAttackDoYouExp_CC = whenYouAreInClusterPeriodHowOften_CC
                .clickOnAnswer("Once a day") 
                .clickNextButton(new WhenYouAreHavingClusterHeadacheAttackDoYouExp_CC()); // Click NEXT button and wait for the NEXT page
                
                
                 //----------Q6 - When you are having a cluster headache attack, do you experience any of the following symptoms in your eye, nose, ear, or face? ---------   
                whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.waitForPageLoad();     
                Assert.assertEquals(whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.getTitleText(),whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.titleExpected, "Title is diff");
                whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());    
             //------Validate protocol DQs in debug window----------
                transitionStatementCC.waitForPageLoad("cluster headache");
                debugPageCC.checkProtocolsEquals("When you are having a cluster headache attack, do you experience any of the following symptoms in yo...", protocol1,protocol2);
                //------Go BACK and change your answer to QR answer - to qualify----------
                debugPageCC.back();
                //------------ Change your answer to CORRECT QR option---------------          
                whenYouAreHavingClusterHeadacheAttackDoYouExp_CC.waitForPageLoad();
                DoYouExperienceAnyOfTheFollowingFeelings_CC doYouExperienceAnyOfTheFollowingFeelings_CC = whenYouAreHavingClusterHeadacheAttackDoYouExp_CC   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("Flushing or redness of your face or forehead")
                .clickNextButton(new DoYouExperienceAnyOfTheFollowingFeelings_CC());    
                
                
                //----------Q7 "Do you experience any of the following feelings or behaviors when you are having a cluster headache attack?" ---------------   
                doYouExperienceAnyOfTheFollowingFeelings_CC.waitForPageLoad();     
                Assert.assertEquals(doYouExperienceAnyOfTheFollowingFeelings_CC.getTitleText(),doYouExperienceAnyOfTheFollowingFeelings_CC.titleExpected, "Title is diff");
                WhenYouAreExperiencingCHattackIsTheLocationPain_CC whenYouAreExperiencingCHattackIsTheLocationPain_CC = doYouExperienceAnyOfTheFollowingFeelings_CC   //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhenYouAreExperiencingCHattackIsTheLocationPain_CC());    
                //------Validate protocol DQs in debug window----------
                whenYouAreExperiencingCHattackIsTheLocationPain_CC.waitForPageLoad();
                debugPageCC.checkProtocolsEquals("Do you experience any of the following feelings or behaviors when you are having a cluster headache ...", protocol1,protocol2);
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
                .clickNextButton(new HormonalBirthControlCC())
        		.waitForPageLoad()
        		.clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageCC())
        	 //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
           	 //----------LetMeSeePageCC Page--------------------
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
        	 //----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
           	 //----------PII Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)              
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a cluster headache study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);        
                
                
   /*//--------------------OLD GENERAL HEALTH Questions----------
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HaveYouUndergoneAnyPageCC())
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HeartFailureIsAlsoPageCC())
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
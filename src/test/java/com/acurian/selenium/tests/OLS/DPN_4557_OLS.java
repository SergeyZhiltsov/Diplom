package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.ApproxHowlongYouBeenExpSymptomsOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouHaveAnyOfTheFollowingConditions_OLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.HaveYouNoticedAnyOfTheFollowing_OLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.HowWouldYouDescribeTheSymptoms_OLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.HowWouldYouRateYourPain_OLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.WhereDoYouExperienceDiabeticNervePain_OLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.WhichOfTheFollowingHadAmputatedSurgically_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CombinationWithEachOtherPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LastTimeYouTookPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.ToLoseWeightPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.GladLocationIsConvenient;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DiagnosedAnyTypeOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.WeightLossSurgeryPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class DPN_4557_OLS extends BaseTest{

    @Test
    @TestCaseId("00016")
    @Description("Diabetic Peripheral Neuropath (DPN)- 4557 OLS")
    public void dPN_4557_OLS() {
        String phoneNumberDPN = "AUTAMS1DPN";
        String protocol1 = "VMDN_003";
        String protocol2 = "NYX_2925_2001";
        String studyName = "a diabetic nerve pain";
        String studyName1 = "a diabetes study, a diabetic nerve pain";
        //String env = "STG";  //Enter which OLS environment to use for testing
        String siteName = "AUT_DPN_4557_Site";
        String zip_Code = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
           .openPage(env, phoneNumberDPN)
           .waitForPageLoad();
                //Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
                Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleDPNExpected, "Title is diff");
                ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                        .setDate("09091982")
                        .clickNextButton(new ZipCodePageOLS());

                //------------ZIP_CODE question---------------      
                zipCodePageOLS
                        .waitForPageLoad();
                Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
                GenderPageOLS genderPageOLS = zipCodePageOLS
                        .typeZipCode(zip_Code)
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
                Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageOLS.getTitleText(),diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, "Title is diff");
                HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS()); 
                //------Validate protocol DQs in debug window----------
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
                DebugPageOLS debugPageOLS = new DebugPageOLS();
                debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, protocol1,protocol2);
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
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected,protocol2);
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
                .checkProtocolsEquals("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...",protocol1,protocol2);
                //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Do you experience diabetic peripheral neuropathy or diabetic nerve pain? This condition can cause pa...").contains(protocol1));
                debugPageOLS.back();
                doYouExperienceDPN_OLS.waitForPageLoad();
                WhereDoYouExperienceDiabeticNervePain_OLS whereDoYouExperienceDiabeticNervePain_OLS = doYouExperienceDPN_OLS
                .clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
                .clickNextButton(new WhereDoYouExperienceDiabeticNervePain_OLS());

                
                //----------Q5 - "Where do you experience diabetic nerve pain symptoms or sensations?" Page ---------------   
                whereDoYouExperienceDiabeticNervePain_OLS.waitForPageLoad();
                Assert.assertEquals(whereDoYouExperienceDiabeticNervePain_OLS.getTitleText(),whereDoYouExperienceDiabeticNervePain_OLS.titleExpected, "Title is diff");    
                whereDoYouExperienceDiabeticNervePain_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new WithType2DiabetesPageOLS()); // Click NEXT button and wait for the NEXT page
                //********Validate Question History for DQ and then click BACK button     
                withType2DiabetesPageOLS.waitForPageLoad();
                Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Where do you experience diabetic nerve pain symptoms or sensations?Agent Note: Select all that apply...").contains(protocol1));
                debugPageOLS.back();
                //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
                HowWouldYouDescribeTheSymptoms_OLS howWouldYouDescribeTheSymptoms_OLS = whereDoYouExperienceDiabeticNervePain_OLS //[create NEXT PAGE Object = THIS page object]
                .waitForPageLoad()
                .clickOnAnswers("Right foot or leg","Left foot or leg")
                .clickNextButton(new HowWouldYouDescribeTheSymptoms_OLS());
                
                 //----------Q6 - How would you describe the symptoms or sensations you feel in your feet, legs, hands, or arms? ---------   
                howWouldYouDescribeTheSymptoms_OLS.waitForPageLoad();     
                Assert.assertEquals(howWouldYouDescribeTheSymptoms_OLS.getTitleText(),howWouldYouDescribeTheSymptoms_OLS.titleExpected, "Title is diff");  
                howWouldYouDescribeTheSymptoms_OLS
                .clickOnAnswers("None of the above");
                HaveYouNoticedAnyOfTheFollowing_OLS haveYouNoticedAnyOfTheFollowing_OLS = howWouldYouDescribeTheSymptoms_OLS   //[create NEXT PAGE Object = THIS page object]    
                .clickNextButton(new HaveYouNoticedAnyOfTheFollowing_OLS()); // Click NEXT button and wait for the NEXT page
                
                //----------Q7 "Have you noticed any of the following in your feet, legs, hands, or arms?" ---------------   
                haveYouNoticedAnyOfTheFollowing_OLS.waitForPageLoad();     
                Assert.assertEquals(haveYouNoticedAnyOfTheFollowing_OLS.getTitleText(),haveYouNoticedAnyOfTheFollowing_OLS.titleExpected, "Title is diff");  
                ApproxHowlongYouBeenExpSymptomsOLS approxHowlongYouBeenExpSymptomsOLS = haveYouNoticedAnyOfTheFollowing_OLS   //[create NEXT PAGE Object = THIS page object]    
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproxHowlongYouBeenExpSymptomsOLS()); // Click NEXT button and wait for the NEXT page
                //********Validate Question History for DQ and then click BACK button     
                approxHowlongYouBeenExpSymptomsOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - DPN Symptoms Logic",protocol1,protocol2);
                //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(protocol1));
                //Assert.assertTrue(debugPageOLS.getProtocolForQuestion("Ghost Question - DPN Symptoms Logic").contains(protocol2));
              //------------ Change your answer in page 'howWouldYouDescribeTheSymptoms_OLS'-----
                debugPageOLS.back();
                haveYouNoticedAnyOfTheFollowing_OLS.waitForPageLoad();
                debugPageOLS.back();
                howWouldYouDescribeTheSymptoms_OLS.waitForPageLoad()
                .clickOnAnswers("Burning","Painful cold")
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
                .checkProtocolsEquals(approxHowlongYouBeenExpSymptomsOLS.titleExpected, protocol1, protocol2);
                debugPageOLS.back();
                //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
                approxHowlongYouBeenExpSymptomsOLS.waitForPageLoad()
                .clickOnAnswer("7 - 10 years")
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
                TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = doYouHaveAnyOfTheFollowingConditions_OLS
                .clickOnAnswers("Retinopathy or diabetic eye disease","Diabetic nephropathy or kidney damage caused by diabetes")
                .clickNextButton(new TreatingYourDiabetesPageOLS()); // Click NEXT button and wait for the NEXT page
                //********Test the SKIP logic to page 13 and then click BACK button     
                treatingYourDiabetesPageOLS.waitForPageLoad();
                debugPageOLS.back();
                doYouHaveAnyOfTheFollowingConditions_OLS.waitForPageLoad();
                WhichOfTheFollowingHadAmputatedSurgically_OLS whichOfTheFollowingHadAmputatedSurgically_OLS = doYouHaveAnyOfTheFollowingConditions_OLS
                .clickOnAnswers("Amputation or surgical removal of a leg, a foot, or toes")
                .clickNextButton(new WhichOfTheFollowingHadAmputatedSurgically_OLS()); 
                
                
                //----------Q12 -Which of the following have you had amputated or surgically removed because of your diabetes?-  Page ---------------   
                whichOfTheFollowingHadAmputatedSurgically_OLS
                		.waitForPageLoad();  
                Assert.assertEquals(whichOfTheFollowingHadAmputatedSurgically_OLS.getTitleText(), whichOfTheFollowingHadAmputatedSurgically_OLS.titleExpected, "Title is diff");    
                //TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = whichOfTheFollowingHadAmputatedSurgically_OLS //[create NEXT PAGE Object = THIS page object]    
                whichOfTheFollowingHadAmputatedSurgically_OLS.clickOnAnswers("Leg","Foot","Toe")
                .clickNextButton(new TreatingYourDiabetesPageOLS()); // Click NEXT button and wait for the NEXT page
                //********Validate Question History for DQ and then click BACK button     
                treatingYourDiabetesPageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Which of the following have you had amputated or surgically removed because of your diabetes?Agent N...", protocol1, protocol2);
                debugPageOLS.back();
                //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
                whichOfTheFollowingHadAmputatedSurgically_OLS.waitForPageLoad()
                .clickOnAnswers("Leg","Foot") //un-select Leg and Foot and keep only TOE selected to qualify for 4557 DPN
                .clickNextButton(new TreatingYourDiabetesPageOLS());     
                
                
                //----------Q13 -"How are you currently treating your diabetes?"-  Page ---------------   
                treatingYourDiabetesPageOLS
                		.waitForPageLoad();  
                Assert.assertEquals(treatingYourDiabetesPageOLS.getTitleText(), treatingYourDiabetesPageOLS.titleExpected, "Title is diff");    
                //WithType2DiabetesPageOLS withType2DiabetesPageOLS = treatingYourDiabetesPageOLS //[create NEXT PAGE Object = THIS page object]    
                whichOfTheFollowingHadAmputatedSurgically_OLS.clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(new WithType2DiabetesPageOLS()); // Click NEXT button and wait for the NEXT page
                //********Validate Question History for DQ and then click BACK button     
                withType2DiabetesPageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ...", protocol1, protocol2);
                debugPageOLS.back();
                //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
                treatingYourDiabetesPageOLS.waitForPageLoad();
                CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = treatingYourDiabetesPageOLS
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
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
                .checkProtocolsEquals("Overall, how long have you been taking your current diabetes medication(s), either by themselves, or...",protocol1);
                debugPageOLS.back();
                //------------ Change your answer to correct QR age in page 'studyQuestionMigPageOLS'---------------   
                combinationWithEachOtherPageOLS.waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new WithType2DiabetesPageOLS());
                
                
                //-----------------Diabetes 4356A Questions---------------------------
                //--------------------------------------------------------------------
                LastTimeYouTookPageOLS lastTimeYouTookPageOLS = withType2DiabetesPageOLS
                		.waitForPageLoad()
        				.clickOnAnswer("More than 1 year ago")
        				.clickNextButton(new LastTimeYouTookPageOLS());
                
                ToLoseWeightPageOLS toLoseWeightPageOLS = lastTimeYouTookPageOLS
                		.waitForPageLoad()
        				.clickOnAnswer("6 months ago or longer")
        				.clickNextButton(new ToLoseWeightPageOLS());
                
                WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = toLoseWeightPageOLS
                		.waitForPageLoad()
        				.clickOnAnswers("No")
        				.clickNextButton(new WeightLossSurgeryPageOLS());
                
                PoundsOrMorePageOLS poundsOrMorePageOLS = weightLossSurgeryPageOLS
                		.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new PoundsOrMorePageOLS());
                
                ChildrenUnderPageOLS childrenUnderPageOLS = poundsOrMorePageOLS
                		.waitForPageLoad()
        				.clickOnAnswer("Unsure")
        				.clickNextButton(new ChildrenUnderPageOLS());
                
        /*      //----------GENERAL HEALTH Questions----------     
        		//----------HasHealthcareProfessionalPageOLS Page--------------------
                HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = hasHealthcareProfessionalPageOLS
                		.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        		//----------HeartRelatedMedicalProc Page--------------------			
        		CongestiveHeartFailurePageOLS congestiveHeartFailurePageOLS = heartrelatedMedicalProceduresPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new CongestiveHeartFailurePageOLS());
        		
        		//----------CongestiveHeartFailurePageOLS (CHF) Page--------------------		
        		AffectingYourMetabolismPageOLS affectingYourMetabolismPageOLS = congestiveHeartFailurePageOLS
        				.waitForPageLoad()
        				.clickOnAnswer("No")
        				.clickNextButton(new AffectingYourMetabolismPageOLS());
        		
        		//----------AffectingYourMetabolism Page--------------------
        		FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = affectingYourMetabolismPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new FollowingNeurologicalConditionsPageOLS());		
        		
        		//----------NeurologicalConditions Page--------------------
        		AffectYourLungsPageOLS affectYourLungsPageOLS = followingNeurologicalConditionsPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new AffectYourLungsPageOLS());

        		//----------AffectYourL-ungs Page--------------------
        		DigestiveConditionsPageOLS digestiveConditionsPageOLS = affectYourLungsPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new DigestiveConditionsPageOLS());

        		//----------DigestiveConditions Page--------------------
        		BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = digestiveConditionsPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new BoneOrJointConditionsPageOLS());
        		
        		//----------BoneOrJointConditions Page--------------------		
        		BoneOrJointConditions boneOrJointConditions = affectYourLungs
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new BoneOrJointConditions());
        			
        		//----------BoneOrJointConditions Page--------------------
        		SleepRelatedConditionsPageOLS sleepRelatedConditionsPageOLS = boneOrJointConditionsPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new SleepRelatedConditionsPageOLS());

        		//----------SleepRelatedConditions Page--------------------
        		SkinConditionsPageOLS skinConditionsPageOLS = sleepRelatedConditionsPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new SkinConditionsPageOLS());
        		
        		//----------SkinConditions Page--------------------
        		ViralConditionsPageOLS viralConditionsPageOLS = skinConditionsPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new ViralConditionsPageOLS());
        		
        		//----------ViralConditions Page--------------------
        		MentalHealthPageOLS mentalHealthPageOLS = viralConditionsPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new MentalHealthPageOLS());
        		
        		//----------MentalHealthConditions Page--------------------
        		WomensHealthPageOLS womensHealthPageOLS = mentalHealthPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new WomensHealthPageOLS());
        		
        		//----------WomenHealthConditions Page--------------------
        		OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = womensHealthPageOLS
        				.waitForPageLoad()
        				.clickOnAnswers("None of the above")
        				.clickNextButton(new OtherThanSkinCancerPageOLS());
        		
        		//----------Cancer Page--------------------
        		SmokedCigarettesPageOLS smokedCigarettesPageOLS = otherThanSkinCancerPageOLS
        				.waitForPageLoad()
        				.clickOnAnswer("No")
        				.clickNextButton(new SmokedCigarettesPageOLS());
        		
        		//----------HaveYouSmokedCigarettes Page--------------------
        		HistoryOfDrugPageOLS historyOfDrugPageOLS = smokedCigarettesPageOLS
        				.waitForPageLoad()
        				.clickOnAnswer("No, I never smoked")
        				.clickNextButton(new HistoryOfDrugPageOLS());


        		//----------HistoryOfDrugPageOLS Page--------------------
        		ProvideHeightWeight provideHeightWeight = historyOfDrugPageOLS
        				.waitForPageLoad()
        				.clickOnAnswer("No")
        				.clickNextButton(new ProvideHeightWeight());

        		//----------ProvideHeight-Weight Page--------------------
        		ChildrenUnderPageOLS childrenUnderPageOLS = provideHeightWeight
        				.waitForPageLoad()
        				.setFT("5")
        				.setIN("5")
        				.setWeight("155")
        				.clickNextButton(new ChildrenUnderPageOLS());*/
        		
        		//----------ChildrenUnderTheAge Page--------------------
        		TheStudySitePageOLS theStudySitePageOLS = childrenUnderPageOLS
        				.waitForPageLoad()
        				.clickOnAnswer("No")
                        .clickNextButton(new TheStudySitePageOLS());
                        
        		//-------------------PEDIATRIC QUESTIONS-----------------------------                            
                //----"theStudySitePageOLS" page --  If you qualify for a study, how would you plan to travel to and from the study site??
        				theStudySitePageOLS.waitForPageLoad()
                        .clickOnAnswer("Public transportation")
                        .clickNextButton(new WhatMedicalCoveragePageOLS())
                        
        		//-----"WhatMedicalCoveragePageOLS" -  What sort of medical coverage do you have for your doctor visits, medication, surgery, and/or testing?-
                        .waitForPageLoad()
                        .clickOnAnswers("No, I have no coverage")
                        .clickNextButton(new EthnicBackgroundPageOLS())
                        
               //----"EthnicBackgroundPageOLS" page --  Which of the following describes your ethnic background?
                        .waitForPageLoad()
                        .clickOnAnswers("Prefer not to answer")
                        .clickNextButton(new IdentificationPageOLS())	
        				
        		//----------PII (IdentificationPageOLS) Page--------------------
        		.waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)
                .clickNextButton(new SiteSelectionPageOLS())
                
        		//----------SiteSelection Page--------------------
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new GladLocationIsConvenient())
                
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
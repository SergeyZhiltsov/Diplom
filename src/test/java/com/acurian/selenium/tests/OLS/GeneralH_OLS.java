package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class GeneralH_OLS extends BaseTest{

    @Test(enabled = false)
    @TestCaseId("00030")
    @Description("General Health test OLS")
    public void generalHealthTest() {
        String phoneNumber = "AUTAMS1GEN";
        String protocol1 = "M16_006";
        String protocol2 = "RF_I6T_MC_AMAG";
        String protocol3 = "I6T_MC_AMAG";
        List<String> protocols = Arrays.asList(protocol1,protocol2,protocol3);
        String studyName = "a high blood pressure";
        String siteName = "AUT_HTN_4356D_Site";
        String debugSiteName = "";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageGHLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionTextGH(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), dateOfBirthPageOLS.titleGHExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart Attack",
                        "Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1),subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2),subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS29","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG","M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530",
                		"EFC13794","NN2211_4315","NN9535_4269","BHV3000_301","CGP_MD_01","UBR_MD_02","VK2809_201","G201002","R475_OA_1611",
                		"R475_OA_1688","EFC14822","M16_098","205715","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868",
                		"EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603","M15_991","M14_702","CL04041023","VMDN_003","NYX_2925_2001")
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS29", "R475_PN_1523","I6T_MC_AMAG",
                		"RF_I6T_MC_AMAG","M15_925","ITCA 650_CLP_203","BHV3000_302","UBR_MD_01",
                		"EFC13794","NN2211_4315","NN9535_4269","BHV3000_301","CGP_MD_01","UBR_MD_02",
                		"VK2809_201","G201002","R475_OA_1611","R475_OA_1688","M16_098","205715",
                		"M16_006","BHV3000_201","THR_1442_C_603","M15_991","M14_702","CL04041023","VMDN_003","NYX_2925_2001")
                .back();
        AffectingYourMetabolismPageOLS affectingYourMetabolismPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CongestiveHeartFailurePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageOLS());
        affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS29","M14_702");
                 affectingYourMetabolismPageOLS.clickOnAnswers("Diabetes or high blood sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4","20150230","VK2809_201","MDCO_PCS_17_04","R727_CL_1532","THR_1442_C_603")
                .back();
        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or high blood sugar","High cholesterol or high triglycerides")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());
        followingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4","ITCA 650_CLP_203","K_877_302","17530","EFC13794",
                        "NN2211_4315","NN9535_4269","EFC14822","EFC14833","EFC14837","EFC14868","EFC15166","THR_1442_C_603")
                .back();
        SubquestionMetabolismPageOLS subquestionMetabolismPageOLS = affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides","High blood pressure or hypertension","Cirrhosis of the liver")
                .clickNextButton(new SubquestionMetabolismPageOLS());
        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4","I6T_MC_AMAG","RF_I6T_MC_AMAG","ITCA 650_CLP_203","K_877_302",
                		"17530","EFC13794","NN2211_4315","NN9535_4269","20150230","VK2809_201","G201002",
                        "R475_OA_1611","R475_OA_1688","EFC14822","M16_098","205715","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833",
                        "EFC14837","EFC14868","EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603","M15_991","M14_702")
                .back();
        affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis of the liver","Kidney disease or currently on dialysis")
                .clickNextButton(subquestionMetabolismPageOLS);

        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4","ITCA 650_CLP_203","K_877_302","17530","EFC13794","NN2211_4315","NN9535_4269",
                		"20150230","VK2809_201","EFC14822","MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868","EFC15166","R727_CL_1532");
        //-----------------------------------Select "NO and "Medications"----------------------
        		subquestionMetabolismPageOLS.clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"No")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"Medications")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7","THR_1442_C_603")
                .back();
         //-----------------------------------Select "YES" and "Dialysis"----------------------
        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"Medications","Dialysis")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG","M15_925","ITCA 650_CLP_203",
                		"K_877_302","BHV3000_302","UBR_MD_01","17530","EFC13794","NN2211_4315","NN9535_4269","BHV3000_301","CGP_MD_01","UBR_MD_02",
                		"20150230","G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","205715","AXS_05_301","M16_006","MDCO_PCS_17_04",
                		"EFC14833","EFC14837","EFC14868","EFC15166","R727_CL_1532","THR_1442_C_603","M15_991","M14_702","CL04041023","VMDN_003","NYX_2925_2001")
                .back();
        //-----------------------------------Select "YES" and "Kidney transplant"----------------------
        subquestionMetabolismPageOLS
        .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
        .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"Yes")
        .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"Dialysis","Kidney transplant")
        .clickNextButton(followingNeurologicalConditionsPageOLS)
        .waitForPageLoad()
        .getPage(debugPageOLS)
        .checkProtocolsEqualsForQNumber("QS7","I6T_MC_AMAG","RF_I6T_MC_AMAG","ITCA 650_CLP_203","K_877_302","EFC13794","NN2211_4315","NN9535_4269",
        		"G201002","EFC14822","M16_098","205715","AXS_05_301","M16_006","EFC14833","EFC14837","EFC14868","EFC15166","R727_CL_1532",
        		"THR_1442_C_603","M15_991","M14_702")
        .back();
        //-----------------------------------Select "YES" and "None of the above"----------------------        
        //ViralConditionsPageOLS viralConditionsPageOLS = subquestionMetabolismPageOLS
        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS1 = subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"None of the above")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());    
                
       //-----------------followingNeurologicalConditionsPageOLS----------------------------        
        		followingNeurologicalConditionsPageOLS1.waitForPageLoad();
                AffectYourLungsPageOLS affectYourLungsPageOLS = followingNeurologicalConditionsPageOLS
        		.clickOnAnswers("Migraine headaches","Tension headaches","Cluster headaches","Alzheimer's disease",
                		"Memory loss","Parkinson's disease","Multiple sclerosis (MS)","Seizure disorder, such as epilepsy",
                		"Tourette's syndrome or tic disorder","Fibromyalgia")
                .clickNextButton(new AffectYourLungsPageOLS());
                affectYourLungsPageOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS8","R475_PN_1523","ITCA 650_CLP_203","BHV3000_302","UBR_MD_01",
                "20150133","BHV3000_301","CGP_MD_01","UBR_MD_02","G201002","R475_OA_1611","R475_OA_1688",
                "M16_098","205715","AXS_05_301","BHV3000_201","R727_CL_1532")
                .back();
        
        
        ViralConditionsPageOLS viralConditionsPageOLS = followingNeurologicalConditionsPageOLS
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		//----------------------------
        		.clickNextButton(new AffectYourLungsPageOLS())
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		//----------------------------
                .clickNextButton(new DigestiveConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
        		//----------------------------
                .clickNextButton(new BoneOrJointConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
        		//----------------------------
                .clickNextButton(new SleepRelatedConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
        		//----------------------------
                .clickNextButton(new SkinConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
        		//----------------------------
                .clickNextButton(new ViralConditionsPageOLS());

        viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C")
        		//----------------------------
                .clickNextButton(new InfectionClearedPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS15","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302",
                        "UBR_MD_01","EFC13794","BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","VK2809_201","G201002",
                        "R475_OA_1611","R475_OA_1688","M16_098","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837",
                        "EFC14868","EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603","M15_991","CL04041023","VMDN_003","NYX_2925_2001")
                .back();
        MentalHealthPageOLS mentalHealthPageOLS = viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C","HIV or AIDS")
                .clickNextButton(new MentalHealthPageOLS());
        mentalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS15","R475_PN_1523","I6T_MC_AMAG",
                        "RF_I6T_MC_AMAG","M15_925","ITCA 650_CLP_203","K_877_302",
                        "BHV3000_302","UBR_MD_01","EFC13794","BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","VK2809_201",
                        "G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","205715","AXS_05_301","M16_006",
                        "MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868","EFC15166","BHV3000_201","R727_CL_1532",
                        "THR_1442_C_603","M15_991","CL04041023","VMDN_003","NYX_2925_2001")
                              
                .back();
        viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(mentalHealthPageOLS);

        WomensHealthPageOLS womensHealthPageOLS = mentalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new WomensHealthPageOLS());
        womensHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS17","I6T_MC_AMAG","RF_I6T_MC_AMAG","EFC13794","20150230","VK2809_201","G201002",
                		"R475_OA_1611","R475_OA_1688","205715","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868",
                		"EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603","M15_991","M14_702")
                .back();
        mentalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder","Schizophrenia")
                .clickNextButton(womensHealthPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS17","I6T_MC_AMAG","RF_I6T_MC_AMAG","BHV3000_302",
                		"EFC13794","BHV3000_301","20150230","VK2809_201","G201002","205715","AXS_05_301","M16_006","MDCO_PCS_17_04",
                		"EFC14833","EFC14837","EFC14868","EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603","M15_991","M14_702")
                .back();

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = mentalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(womensHealthPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        SmokedCigarettesPageOLS smokedCigarettesPageOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, in the past 5 years")
                .clickNextButton(new SmokedCigarettesPageOLS());
        smokedCigarettesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS20","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG","M15_925",
                		"ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","EFC13794","NN2211_4315","NN9535_4269",
                		"BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","VK2809_201","G201002","R475_OA_1611","R475_OA_1688","EFC14822",
                		"M16_098","205715","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868","EFC15166",
                		"R727_CL_1532","THR_1442_C_603","M15_991","M14_702","CL04041023","VMDN_003","NYX_2925_2001")
                .back();

        HistoryOfDrugPageOLS historyOfDrugPageOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(smokedCigarettesPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, in the last 6 months")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS22","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG","M15_925",
                		"ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","EFC13794","NN2211_4315","20150133",
                		"BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","VK2809_201","R475_OA_1611","R475_OA_1688","EFC14822",
                		"M16_098","205715","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868","EFC15166",
                		"BHV3000_201","R727_CL_1532","THR_1442_C_603","M15_991","M14_702","CL04041023","VMDN_003","NYX_2925_2001")
                .back();
        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, 7 - 11 months ago")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS22","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG","ITCA 650_CLP_203","K_877_302",
                		"BHV3000_302","UBR_MD_01","NN2211_4315","20150133","BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","VK2809_201",
                		"R475_OA_1611","R475_OA_1688","205715","AXS_05_301","M16_006","MDCO_PCS_17_04","BHV3000_201","R727_CL_1532",
                		"THR_1442_C_603","M15_991","M14_702")
                              
                
                .back();
        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, 1 - 2 years ago")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS22","R475_PN_1523","K_877_302","NN2211_4315","R475_OA_1611","R475_OA_1688","205715","MDCO_PCS_17_04","THR_1442_C_603")
                .back();

        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new ChildrenUnderPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HouseholdHavePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TheStudySitePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Public transportation")
//                .clickNextButton(new WouldYouUsePageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Neither")
                .clickNextButton(new WhatMedicalCoveragePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new SynexusQualifiedClose4356PageOLS())
                .waitForPageLoad("625301")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

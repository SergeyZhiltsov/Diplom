package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
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

    @Test
    @TestCaseId("00030")
    @Description("General Health test OLS")
    public void generalHealthTest() {
        String phoneNumberLBP = "AUTAMS1GEN";
        String protocol1 = "M16_006";
        String protocol2 = "RF_I6T_MC_AMAG";
        String protocol3 = "I6T_MC_AMAG";
        List<String> protocols = Arrays.asList(protocol1,protocol2,protocol3);
        String studyName = "a Crohn's";
        String siteName = "AUT_HTN_4356D_Site";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";

        DateGHPageOLS dateGHPageOLS = new DateGHPageOLS();
        dateGHPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateGHPageOLS.getQuestionText(),dateGHPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateGHPageOLS.getTitleText(), dateGHPageOLS.titleGHExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateGHPageOLS
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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = hasHealthcareProfessionalPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart Attack","Stroke")
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
                .checkProtocolsEqualsForQNumber("QS29", "M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "E2006_G000_304","M15_925","E2006_G000_303","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530",
                        "EFC13794","NN2211_4315","NN9535_4269","BHV3000_301","CGP_MD_01","UBR_MD_02","VK2809_201","G201002","R475_OA_1611",
                        "R475_OA_1688","EFC14822","M16_098","MVT_601_3001","MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301",
                        "M16_006","MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868","EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603")
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS29", "M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","BHV3000_302","UBR_MD_01","EFC13794","NN2211_4315","NN9535_4269","BHV3000_301","CGP_MD_01",
                        "UBR_MD_02","VK2809_201","G201002","R475_OA_1611","R475_OA_1688","M16_098","MVT_601_3001","MVT_601_3002",
                        "MVT_601_3101","MVT_601_3102","M16_006","BHV3000_201","THR_1442_C_603")
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
                .clickOnAnswers("Diabetes or high blood sugar")
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
                .checkProtocolsEqualsForQNumber("QS4","I6T_MC_AMAG","RF_I6T_MC_AMAG","E2006_G000_304","E2006_G000_303",
                        "ITCA 650_CLP_203","K_877_302","17530","EFC13794","NN2211_4315","NN9535_4269","20150230","VK2809_201","G201002",
                        "R475_OA_1611","R475_OA_1688","EFC14822","M16_098","MVT_601_3001","MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301",
                        "M16_006","MDCO_PCS_17_04","EFC14833","EFC14837","EFC14868","EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603")
                .back();
        affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis of the liver","Kidney disease or currently on dialysis")
                .clickNextButton(subquestionMetabolismPageOLS);

        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"No")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"Medications")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7","THR_1442_C_603")
                .back();
        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"Medications","Dialysis")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7","M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530","EFC13794","NN2211_4315","NN9535_4269",
                        "BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837",
                        "EFC14868","EFC15166","R727_CL_1532","THR_1442_C_603")
                .back();

        ViralConditionsPageOLS viralConditionsPageOLS = subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"None of the above")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SkinConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ViralConditionsPageOLS());

        viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C")
                .clickNextButton(new InfectionClearedPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS15","M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530","EFC13794","NN2211_4315","NN9535_4269",
                        "BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837",
                        "EFC14868","EFC15166","R727_CL_1532","THR_1442_C_603")
                .back();
        MentalHealthPageOLS mentalHealthPageOLS = viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C","HIV or AIDS")
                .clickNextButton(new MentalHealthPageOLS());
        mentalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS15","M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530","EFC13794","NN2211_4315","NN9535_4269",
                        "BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837",
                        "EFC14868","EFC15166","R727_CL_1532","THR_1442_C_603")
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
                .checkProtocolsEqualsForQNumber("QS17","I6T_MC_AMAG","RF_I6T_MC_AMAG","E2006_G000_304",
                        "E2006_G000_303","EFC13794","20150230","VK2809_201","G201002","R475_OA_1611","R475_OA_1688","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833",
                        "EFC14837","EFC14868","EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603")
                .back();
        mentalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder","Schizophrenia")
                .clickNextButton(womensHealthPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS17","I6T_MC_AMAG","RF_I6T_MC_AMAG","E2006_G000_304",
                        "E2006_G000_303","EFC13794","20150230","VK2809_201","G201002","R475_OA_1611","R475_OA_1688","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833",
                        "EFC14837","EFC14868","EFC15166","BHV3000_201","R727_CL_1532","THR_1442_C_603")
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
                .checkProtocolsEqualsForQNumber("QS20","M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530","EFC13794","NN2211_4315","NN9535_4269",
                        "BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837",
                        "EFC14868","EFC15166","R727_CL_1532","THR_1442_C_603")
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
                .checkProtocolsEqualsForQNumber("QS22","M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530","EFC13794","NN2211_4315","NN9535_4269",
                        "BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837",
                        "EFC14868","EFC15166","R727_CL_1532","THR_1442_C_603")
                .back();
        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, 7 - 11 months ago")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS22","M13_545","R475_PN_1523","I6T_MC_AMAG","RF_I6T_MC_AMAG",
                        "M15_925","ITCA 650_CLP_203","K_877_302","BHV3000_302","UBR_MD_01","17530","EFC13794","NN2211_4315","NN9535_4269",
                        "BHV3000_301","CGP_MD_01","UBR_MD_02","20150230","G201002","R475_OA_1611","R475_OA_1688","EFC14822","M16_098","MVT_601_3001",
                        "MVT_601_3002","MVT_601_3101","MVT_601_3102","AXS_05_301","M16_006","MDCO_PCS_17_04","EFC14833","EFC14837",
                        "EFC14868","EFC15166","R727_CL_1532","THR_1442_C_603")
                .back();
        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, 1 - 2 years ago")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS22","R475_PN_1523","E2006_G000_304","E2006_G000_303",
                        "K_877_302","NN2211_4315","R475_OA_1611","R475_OA_1688","MDCO_PCS_17_04","THR_1442_C_603")
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
                .clickOnAnswer("Yes")
                .clickNextButton(new WouldYouUsePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Neither")
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
                .clickNextButton(new HSCrohns2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()
                .getPage(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();

    }
}

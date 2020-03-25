package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.CurrentlyParticipatingInStudy;
import com.acurian.selenium.pages.CC.closes.RequirePassDrugTest;
import com.acurian.selenium.pages.CC.cv_study.SubquestionHeartPageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouSufferFromOAB_CC;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.OAB_4867.HaveYouEverHadBotoxInjectionbladder_CC;
import com.acurian.selenium.pages.CC.OAB_4867.SubquestionOABandBPH_CC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class OAB_BPH_4867_CC extends BaseTest {

    @Description("OAB_BPH_4867_CC")
    @Test(enabled = false)
    public void OAB_BPH_4867_CC_Script() {
        Site site = Site.AUT_OAB_4867;
        String phoneNumber = "AUTAMS1OAB";
        String studyName = "an overactive bladder study";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageCC debugPageCC = new DebugPageCC();

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //------------dateOfBirthPageCC----------------
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("an overactive bladder study", "300"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .waitForPageLoad("an overactive bladder study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad("an overactive bladder study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

//        zipCodePageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
//                .back();
//
//        dateOfBirthPageCC
//                .waitForPageLoad()
//                .setYear("1930")
//                .clickNextButton(zipCodePageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
//                .back();
//
//        dateOfBirthPageCC
//                .waitForPageLoad()
//                .setYear("1978")
//                .clickNextButton(zipCodePageCC);

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        //-------------If 'Female' AND selected "No" in Q2.1, Disqualify OAB
        DoYouSufferFromOAB_CC doYouSufferFromOAB_CC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1978")
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromOAB_CC());
        //-------------Display Q2.1
        NonQRtransitionPageCC nonQRtransitionPageCC = doYouSufferFromOAB_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018406-QS6502-STUDYQUES", site.activeProtocols)
                .back();

        HaveYouEverHadBotoxInjectionbladder_CC haveYouEverHadBotoxInjectionbladder_CC = doYouSufferFromOAB_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverHadBotoxInjectionbladder_CC());

        haveYouEverHadBotoxInjectionbladder_CC
                .waitForPageLoad()
                .back(doYouSufferFromOAB_CC)
                .waitForPageLoad()
                .back();

        //-------------Display Q2.2 for MALEs only ------------------
        SubquestionOABandBPH_CC subquestionOABandBPH_CC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new SubquestionOABandBPH_CC());
        //-------------Display Q2.1
        subquestionOABandBPH_CC
                .waitForPageLoad(1, subquestionOABandBPH_CC.titleExpected1)
                .waitForPageLoad(2, subquestionOABandBPH_CC.titleExpected2)
                //----------Select options for Q2.2 sub-question---------
                .clickOnAnswerForSubQuestion(1, "No")
                .clickOnAnswerForSubQuestion(2, "No")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018406-QS6502-STUDYQUES", site.activeProtocols)
                .back();

        subquestionOABandBPH_CC
                .waitForPageLoad(1, subquestionOABandBPH_CC.titleExpected1)
                .waitForPageLoad(2, subquestionOABandBPH_CC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "Yes")
                .clickOnAnswerForSubQuestion(2, "Yes")
                .clickNextButton(haveYouEverHadBotoxInjectionbladder_CC);

        //-------------Q3:  Have you ever had a Botox injection into your bladder muscle?---

        DoYouTakeAnyMedicationsControlHypertension_CC doYouTakeAnyMedicationsControlHypertension_CC = haveYouEverHadBotoxInjectionbladder_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes, within the past 6 weeks")
                .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC());

        doYouTakeAnyMedicationsControlHypertension_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6503", site.activeProtocols)
                .back();

        haveYouEverHadBotoxInjectionbladder_CC
                .waitForPageLoad()
                .clickOnAnswer("No, never")
                .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC());

        //-------------Q4:  Do you take any medications to control high blood pressure or hypertension?---
        TransitionStatementCC transitionStatementCC = doYouTakeAnyMedicationsControlHypertension_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                //.checkProtocolsContainsForQNumber("QS6504", site.activeProtocols)
                .back();

        doYouTakeAnyMedicationsControlHypertension_CC
                .clickOnAnswer("Yes")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadDYS()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC heartrelatedMedicalConditionsProceduresPageCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(heartrelatedMedicalConditionsProceduresPageCC);

        SubquestionHeartPageCC subquestionHeartPageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                        "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionHeartPageCC());

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"1 - 3 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"4 - 6 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,"More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        MostRecentHeartProcedurePageСС mostRecentHeartProcedurePageСС = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageСС());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                .back();

        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                .back();

        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                .back(mostRecentHeartProcedurePageСС)
                .waitForPageLoad()
                .back();

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC);

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageCC());

        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
				.assertVariablesNew("Acurian", "Trial", "09/09/1978", "US",
                        "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com", "999-999-9999",
                        " 123456a ", " "+site.name, "UROPPDOAB001 - Urovant Overactive Bladder (OAB)")
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
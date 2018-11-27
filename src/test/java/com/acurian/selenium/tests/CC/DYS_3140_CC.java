package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.TriglyceridesOrLipidsPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.EverSmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class DYS_3140_CC extends BaseTest {

    @Description("Dyslipidemia 3140")
    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = true)
    public void dys_3140_CC(final String username, final String password) {
        String phoneNumber = "AUTAMS1DYS";
        String protocol1 = "1002_043";
//        String[] protocols = {protocol1};
        String studyName = "a high cholesterol and heart health study";
        String siteName = "AUT_DYS_3140_site";
//		String debugSiteName = "QSC9004_4356A_AUT_DIA_4356A";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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

        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText2Ver(), dateOfBirthPageCC.titleExpectedDYS, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1940")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        DyslipidemiaHealthcarePageCC dyslipidemiaHealthcarePageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DyslipidemiaHealthcarePageCC());

        DebugPageCC debugPageCC = new DebugPageCC();


        NonQRtransitionPageCC nonQRtransitionPageCC = dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0010983-QS5202-STUDYQUES", protocol1)
                .back();
        dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0010983-QS5202-STUDYQUES", protocol1)
                .back();
        StatinMedicationsHavePageCC statinMedicationsHavePageCC = dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol, or hypercholesterolemia")
                .clickNextButton(new StatinMedicationsHavePageCC());

        TriglyceridesOrLipidsPageCC triglyceridesOrLipidsPageCC = statinMedicationsHavePageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TriglyceridesOrLipidsPageCC());
        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0018278-QS5222-STUDYQUES", protocol1)
                .back();
        StopTakingStatinPageCC stopTakingStatinPageCC = statinMedicationsHavePageCC
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(new StopTakingStatinPageCC());

        WhileTakingStatinPageCC whileTakingStatinPageCC = stopTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhileTakingStatinPageCC());

        whileTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(triglyceridesOrLipidsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0018282-QS5225-STUDYQUES", protocol1)
                .back();
        whileTakingStatinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness")
                .clickNextButton(triglyceridesOrLipidsPageCC);

        triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0018142-QS5226-STUDYQUES", protocol1)
                .back();
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = triglyceridesOrLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC haveYouEverBeenDiagnosedAdditionalHeartRelatedCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC());
        haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5,"1 - 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015129-QS5218-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedCC);

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverBeenDiagnosedAdditionalHeartRelatedCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());

        BeforeAge60PageСС beforeAge60PageСС = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BeforeAge60PageСС());
        beforeAge60PageСС
                .waitForPageLoad()
                .back();
        MostRecentHeartProcedurePageСС mostRecentHeartProcedurePageСС = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
                .clickNextButton(new MostRecentHeartProcedurePageСС());

        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(beforeAge60PageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015137-QS5221-STUDYQUES", protocol1)
                .back();
        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(beforeAge60PageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015137-QS5221-STUDYQUES", protocol1)
                .back();
        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(beforeAge60PageСС);

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = beforeAge60PageСС
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        PressureOrHypertensionPageСС pressureOrHypertensionPageСС = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PressureOrHypertensionPageСС());
        pressureOrHypertensionPageСС
                .waitForPageLoad()
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(pressureOrHypertensionPageСС);

        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = pressureOrHypertensionPageСС
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new EverSmokedCigarettesPageCC());

        TransitionStatementCC transitionStatementCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0014298-QS5211-STUDYQUES", protocol1)
                .back();
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new WeightLossSurgeryPageCC());

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0005313-QS5233-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0005313-QS5233-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0005313-QS5233-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0005313-QS5233-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0005313-QS5233-STUDYQUES", protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadDYS()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Kidney disease", "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickNextButton(new OtherThanSkinCancerPageCC());

        KidneyProblemsPage kidneyProblemsPage = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new KidneyProblemsPage());
        kidneyProblemsPage
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1)
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(kidneyProblemsPage);

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocol1)
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
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
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
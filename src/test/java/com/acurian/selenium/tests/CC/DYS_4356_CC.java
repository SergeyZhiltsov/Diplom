package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.TriglyceridesOrLipidsPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.HaveYouEverSmokedCigarettes_CC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer4;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.DY_4356.StatinMedicationsHavePageOLS;
import com.acurian.selenium.pages.OLS.shared.DyslipidemiaHealthcarePageOLS;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DYS_4356_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = true)
    public void dys_4356_CC(final String username, final String password) {
        String phoneNumber = "AUTAMS1DYS";
        String protocol1 = "1002_043";
//        String[] protocols = {protocol1};
        String studyName = "a high cholesterol and heart health";
        String siteName = "AUT_DYS_3140_site ";
//		String debugSiteName = "QSC9004_4356A_AUT_DIA_4356A";
        String zipCode = "19044";

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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedDYS, "Title is diff");
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
                .clickOnAnswers("None of the above ")
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

        HaveYouEverSmokedCigarettes_CC haveYouEverSmokedCigarettes_cc = pressureOrHypertensionPageСС
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverSmokedCigarettes_CC());

        haveYouEverSmokedCigarettes_cc
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCond)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS5211", protocol1)
                .back();
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = haveYouEverSmokedCigarettes_ols
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber(" QS5233", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber(" QS5233", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber(" QS5233", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber(" QS5233", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber(" QS5233", protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Kidney disease", "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocol1)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocol1)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocol1)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", protocol1)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
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
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);























    }
}
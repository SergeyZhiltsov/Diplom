package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TriglyceridesOrLipidsPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveYouEverSmokedCigarettes_OLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusHealthyMindsPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class DYSLI_4356_OLS extends BaseTest {

    @Test(enabled = true)
    @Description("Dyslipidemia 3140")
    public void dys_4356_ols() {
        String phoneNumber = "AUTAMS1DYS";
        String protocol1 = "1002_043";
//        String[] protocols = {protocol1};
        String studyName = "a high cholesterol and heart health";
        String siteName = "AUT_DYS_3140_site ";
//        String debugSiteName = "QSC9004_4356A_AUT_DIA_4356A";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleDYExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091940")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        DyslipidemiaHealthcarePageOLS dyslipidemiaHealthcarePageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DyslipidemiaHealthcarePageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = dyslipidemiaHealthcarePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5202", protocol1)
                .back();
        dyslipidemiaHealthcarePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5202", protocol1)
                .back();
        StatinMedicationsHavePageOLS statinMedicationsHavePageOLS = dyslipidemiaHealthcarePageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol, or hypercholesterolemia")
                .clickNextButton(new StatinMedicationsHavePageOLS());

        TriglyceridesOrLipidsPageOLS triglyceridesOrLipidsPageOLS = statinMedicationsHavePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TriglyceridesOrLipidsPageOLS());
        triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5222", protocol1)
                .back();
        StopTakingStatinPageOLS stopTakingStatinPageOLS = statinMedicationsHavePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(new StopTakingStatinPageOLS());

        WhileTakingStatinPageOLS whileTakingStatinPageOLS = stopTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhileTakingStatinPageOLS());

        whileTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(triglyceridesOrLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5225", protocol1)
                .back();
        whileTakingStatinPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Muscle weakness")
                .clickNextButton(triglyceridesOrLipidsPageOLS);

        triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5226", protocol1)
                .back();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = triglyceridesOrLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS());
        haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above ")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"Less than 30 days ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"1 - 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"4 - 6 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5218", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverBeenDiagnosedAdditionalHeartRelatedOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        BeforeAge60PageOLS beforeAge60PageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BeforeAge60PageOLS());
        beforeAge60PageOLS
                .waitForPageLoad()
                .back();
        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());

        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(beforeAge60PageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5221", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(beforeAge60PageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS5221", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(beforeAge60PageOLS);

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = beforeAge60PageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        PressureOrHypertensionPageOLS pressureOrHypertensionPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PressureOrHypertensionPageOLS());
        pressureOrHypertensionPageOLS
                .waitForPageLoad()
                .back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(pressureOrHypertensionPageOLS);

        HaveYouEverSmokedCigarettes_OLS haveYouEverSmokedCigarettes_ols = pressureOrHypertensionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverSmokedCigarettes_OLS());

        haveYouEverSmokedCigarettes_ols
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
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
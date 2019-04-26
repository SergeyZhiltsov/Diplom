package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.LOWT_3017_FROM_CV_OLS_A_S;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class LOWT_3017_FROM_CV_CC_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "sites", dataProviderClass = LOWT_3017_FROM_CV_OLS_A_S.class)
    @Description("LowT_3017_From_Cv_Cc")
    public void lowt3017FromCvCc(Site site) {
        final String phoneNumber = "AUTAMS1CV1";
        final String protocol1 = "M16_100";
        final String protocol2 = "M16_100_S";
        final String esperionProtocol = "1002_043";
        final String esperionProtocolA = "1002_043_A";
        final String kowaProtocolA = "K_877_302_A";
        final String kowaProtocolS = "K_877_302_S";
        final String novoProtocol = "EX9536_4388";
        final String[] cvModuleProtocols = {esperionProtocol, esperionProtocolA, kowaProtocolA, kowaProtocolS, novoProtocol};
        final String dqedStudyName = "a heart health study";
        final String studyName = "a men's health study";
        final String siteIndication = "low testosterone or hypogonadism";
        DebugPageCC debugPageCC = new DebugPageCC();

        String env = System.getProperty("acurian.env", "STG");

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
                .waitForPageLoad();
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleCVExpected, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad2Ver()
                .setMonth("Jun")
                .setDay("5")
                .setYear("1960")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        PersonaQuestionsCC personaQuestionsCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", esperionProtocol, esperionProtocolA, kowaProtocolA, kowaProtocolS)
                .getPage(whatKindOfDiabetesPageCC)
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new PersonaQuestionsCC());

        personaQuestionsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004943-QS6704-STUDYQUES", kowaProtocolA, kowaProtocolS, novoProtocol);

        ExperiencedAnyOfFollowingCC experiencedAnyOfFollowingCC = personaQuestionsCC
                .clickNextButton(new ExperiencedAnyOfFollowingCC());

        DiagnosedYouWithLowTestosteroneCC diagnosedYouWithLowTestosteroneCC = experiencedAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("Decreased sexual desire or libido", "Decreased spontaneous erections (e.g., morning erections)", "Decreased energy or fatigue/feeling tired")
                .clickOnAnswers("Loss of body (axillary and pubic) hair or reduced shaving", "Hot flashes", "Low mood or depressed mood")
                .clickNextButton(new DiagnosedYouWithLowTestosteroneCC());

        LevelOrHypogonadismPageСС levelOrHypogonadismPageСС = diagnosedYouWithLowTestosteroneCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new LevelOrHypogonadismPageСС());

        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = levelOrHypogonadismPageСС
                .waitForPageLoad()
                .clickOnAnswers("AndroGel", "Endoderm patch", "Fortesta gel", "Striant (testosterone buccal system)", "Testim gel", "Other testosterone medication not on this list", "Unsure")
                .clickOnAnswers("Testosterone injection (Depo-Testosterone, Testosterone enanthate, Testosterone Cypionate, Delatestryl)", "Clomiphene (brand name Serophene) or another anti-estrogen therapy")
                .clickOnAnswers("Axiron gel")
                .clickNextButton(new EverSmokedCigarettesPageCC());

        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HeartOrBloodVesselPageCC());


        HaveDoctorEverDiagnosedYou_CC haveDoctorEverDiagnosedYou_cc = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital",
                        "Coronary Artery Disease (blockage in a heart vessel)",
                        "Peripheral Vascular Disease (for example a blockage in your leg vessel)",
                        "Amputation of a digit or limb due to Peripheral Vascular Disease")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        haveDoctorEverDiagnosedYou_cc.back();
        heartOrBloodVesselPageCC
                .waitForPageLoad();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartOrBloodVesselPageCC
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();
        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());


        HasDoctorEverDiagnosedMedicalCondDiseases_CC hasDoctorEverDiagnosedMedicalCondDiseases_CC = haveDoctorEverDiagnosedYou_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC())
                .waitForPageLoad();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC.back();
        haveDoctorEverDiagnosedYou_cc
                .waitForPageLoad();
        ReceivedHeartProcedurePageCC receivedHeartProcedurePageCC = haveDoctorEverDiagnosedYou_cc
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                        "Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
                        "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                        "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                .clickNextButton(new ReceivedHeartProcedurePageCC());

        receivedHeartProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017037-QS5624-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        receivedHeartProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC());


        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad();
        ApproximateHeightPageCC approximateHeightPageCC = hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("History of Prostate or Breast Cancer")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Other cancer within the past 2 years (except skin cancer)")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad()
                .clickOnAnswers("Sleep apnea that is not currently being treated")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        TransitionalStatementLowtPageCC transitionalStatementLowtPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("4", "0", "166")
                .clickNextButton(new TransitionalStatementLowtPageCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004980-QS5627-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        IdentificationPageCC identificationPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "6", "166")
                .clickNextButton(new IdentificationPageCC());
        IncongruentSiteSelectionCloseCC incongruentSiteSelectionCloseCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new IncongruentSiteSelectionCloseCC());
        incongruentSiteSelectionCloseCC
                .waitForPageLoad(studyName, dqedStudyName)
                .getPID();
        switch (site) {
            case AUT_LOWT_3017S_Site: //41C
                incongruentSiteSelectionCloseCC
                        .clickOnAnswer(site.name)
//                        .clickNextButton(new HSGeneralCC())
//                        .waitForPageLoad(siteIndication)
                        .clickNextButton(new DoctorInformationCollectionPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_LOWT_3017_Site: //1R
                incongruentSiteSelectionCloseCC
                        .clickOnAnswer(site.name)
//                        .clickNextButton(new HSGeneralCC())
//                        .waitForPageLoad(siteIndication)
                        .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
//                        .clickNextButton(new HSMedicalRecordsPageCC())
//                        .waitForPageLoad()
                        .clickNextButton(new SynexusHealthyMindsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env, "3017")
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

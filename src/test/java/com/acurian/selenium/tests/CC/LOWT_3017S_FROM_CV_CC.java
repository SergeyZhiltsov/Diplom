package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class LOWT_3017S_FROM_CV_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("LowT_3017S_From_Cv_Cc")
    public void lowt3017sFromCvCc(final String username, final String password) {
        final String phoneNumber = "AUTAMS1CV1";
        final String protocol1 = "M16_100";
        final String protocol2 = "M16_100_S";
        final String esperionProtocol = "1002_043";
        final String kowaProtocol = "K_877_302_A";
        final String sanofiT2DMCV = "EFC14828";
        final String[] cvModuleProtocols = {esperionProtocol, kowaProtocol, sanofiT2DMCV};
        final String dqedStudyName = "a high cholesterol and heart health";
        final String studyName = "a men's low testosterone";
        final String site_Indication = "low testosterone or hypogonadism";
        final String siteName = "AUT_LOWT_3017S_Site";
        final String zipCode = "19901";
        DebugPageCC debugPageCC = new DebugPageCC();

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
                .waitForPageLoad();
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText2Ver(), dateOfBirthPageCC.titleCVExpected, "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Jun")
                .setDay("5")
                .setYear("2005")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", cvModuleProtocols)
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad2Ver()
                .setYear("1960")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());

        HasDoctorEverDiagnosedMedicalCondDiseases_CC hasDoctorEverDiagnosedMedicalCondDiseases_cc = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC());

        PersonaQuestionsCC personaQuestionsCC = hasDoctorEverDiagnosedMedicalCondDiseases_cc
                .waitForPageLoadСVModule()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PersonaQuestionsCC());

        personaQuestionsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017021-QS6703-STUDYQUES", cvModuleProtocols);

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
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new HeartOrBloodVesselPageCC());

        HaveDoctorEverDiagnosedYou_CC haveDoctorEverDiagnosedYou_CC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital",
                        "Coronary Artery Disease (blockage in a heart vessel)",
                        "Peripheral Vascular Disease (for example a blockage in your leg vessel)",
                        "Amputation of a digit or limb due to Peripheral Vascular Disease")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC())
                .waitForPageLoad();
        haveDoctorEverDiagnosedYou_CC.back();
        heartOrBloodVesselPageCC
                .waitForPageLoad();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartOrBloodVesselPageCC
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoadTIA()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoadTIA()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017029-QS5622-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();
        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveDoctorEverDiagnosedYou_CC());

        HasDoctorEverDiagnosedMedicalCondDiseases_CC hasDoctorEverDiagnosedMedicalCondDiseases_CC = haveDoctorEverDiagnosedYou_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC())
                .waitForPageLoad();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC.back();
        haveDoctorEverDiagnosedYou_CC
                .waitForPageLoad();
        ReceivedHeartProcedurePageCC receivedHeartProcedurePageCC = haveDoctorEverDiagnosedYou_CC
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                        "Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
                        "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                        "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                .clickNextButton(new ReceivedHeartProcedurePageCC());

        receivedHeartProcedurePageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedMedicalCondDiseases_CC());
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
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Other cancer within the past 2 years (except skin cancer)")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Sleep apnea that is not currently being treated")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .clickOnAnswers("Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0017042-QS5626-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        hasDoctorEverDiagnosedMedicalCondDiseases_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        TransitionStatementLowT_CC transitionStatementLowT_CC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("4", "0", "166")
                .clickNextButton(new TransitionStatementLowT_CC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0004980-QS5627-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "6", "166")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new IncongruentSiteSelectionCloseCC())
                .waitForPageLoad(studyName, dqedStudyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

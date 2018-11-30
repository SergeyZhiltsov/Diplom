package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class LOWT_3017S_FROM_CV_OLS extends BaseTest {

    @Test
    @Description("LOWT_3017S_FROM_CV_OLS")
    public void lowt3017sFromCvOls() {
        String phoneNumber = "AUTAMS1CV1";
        String protocol1 = "M16_100";
        String protocol2 = "M16_100_S";
        String esperionProtocol = "1002_043";
        String kowaProtocol = "K_877_302_A";
        String sanofiT2DMCV = "EFC14828";
        String[] cvModuleProtocols = {esperionProtocol, kowaProtocol, sanofiT2DMCV};
        String dqedStudyName = "a high cholesterol and heart health";
        String studyName = "a men's low testosterone";
        String site_Indication = "low testosterone or hypogonadism";
        String siteName = "AUT_LOWT_3017_Site";
        String zipCode = "19901";
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGROUP();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGROUP(), dateOfBirthPageOLS.titleCVExpected, "Title is diff");

        AgeUnqualifiedClose_OLS ageUnqualifiedClose_ols = dateOfBirthPageOLS
                .setDate("09092005")
                .clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", cvModuleProtocols)
                .back();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoadGROUP()
                .setDate("09091960")
                .clickNextButton(new ZipCodePageOLS());

        //---------------ZIP-CODE Question-------------------
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        HasDoctorEverDiagnosedYouMedicalCond_OLS hasDoctorEverDiagnosedYouMedicalCond_ols = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());

        //---------------Q3 Has a doctor ever diagnosed you with any of the following medical conditions or diseases? -------------------
        // Selecting "None of the above" answer to be DQ for CV module protocols
        PersonalQuestionsOLS personalQuestionsOLS = hasDoctorEverDiagnosedYouMedicalCond_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PersonalQuestionsOLS());

        personalQuestionsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", cvModuleProtocols);

        ExperiencedAnyOfFollowingOLS experiencedAnyOfFollowing_OLS = personalQuestionsOLS
                .waitForPageLoad()
                .clickNextButton(new ExperiencedAnyOfFollowingOLS());

        HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_OLS = experiencedAnyOfFollowing_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5616", protocol1, protocol2)
                .back();

        experiencedAnyOfFollowing_OLS
                .waitForPageLoad()
                .clickOnAnswers("Decreased sexual desire or libido",
                        "Decreased spontaneous erections (e.g., morning erections)",
                        "Decreased energy or fatigue/feeling tired",
                        "Low mood or depressed mood",
                        "Loss of body (axillary and pubic) hair or reduced shaving",
                        "Hot flashes")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());

        LevelOrHypogonadismPageOLS levelOrHypogonadismPageOLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new LevelOrHypogonadismPageOLS());

        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = levelOrHypogonadismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("AndroGel",
                        "Endoderm patch",
                        "Axiron gel",
                        "Fortesta gel",
                        "Striant (testosterone buccal system)",
                        "Testim gel",
                        "Testosterone injection (Depo-Testosterone, Testosterone enanthate, Testosterone Cypionate, Delatestryl)",
                        "Clomiphene (brand name Serophene) or another anti-estrogen therapy",
                        "Other testosterone medication not on this list",
                        "Unsure")
                .clickNextButton(new EverSmokedCigarettesPageOLS());

        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HeartOrBloodVesselPageOLS());

        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS haveYouExperiencedAnyFollowingCardiovascularInterventionsOLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());
        haveYouExperiencedAnyFollowingCardiovascularInterventionsOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack();
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5622", protocol1, protocol2)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());

        HasDoctorEverDiagnosedYouMedicalCond_OLS hasDoctorEverDiagnosedYouMedicalCond_OLS = haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad()
                .back();
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .waitForPageLoad();
        ReceivedHeartProcedurePageOLS receivedHeartProcedurePageOLS = haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                        "Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
                        "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                        "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                .clickNextButton(new ReceivedHeartProcedurePageOLS());

        receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2)
                .back();
        receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2)
                .back();
        receivedHeartProcedurePageOLS.waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad()
                .clickOnAnswers("History of Prostate or Breast Cancer",
                        "Other cancer within the past 2 years (except skin cancer)",
                        "Sleep apnea that is not currently being treated",
                        "Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5626", protocol1, protocol2)
                .back();
        hasDoctorEverDiagnosedYouMedicalCond_OLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "0", "256")//------Disqualify ("High BMI") if > 50
                .clickNextButton(new TransitionalStatementLowtPageOLS());
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5627", protocol1, protocol2)
                .back();
        approximateHeightPageOLS.waitForPageLoad()
                .waitForPageLoad()
                .setIncheswithClear("5")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new IncongruentSiteSelectionClose_OLS())
                .waitForPageLoad(studyName, dqedStudyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()

                .waitToClickNext()
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

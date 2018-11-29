package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class LOWTS_3017S_OLS extends BaseTest {

    @Test
    @Description("LOWT 3017S_OLS")
    public void lowts3017ols() {
        String phoneNumber = "AUTAMSLOWT";
        List<String> protocols = Arrays.asList("M16_100");
        String protocol1 = "M16_100";
        String protocol2 = "M16_100_S";
        String esperionProtocol = "1002_043";
        String kowaProtocol = "K_877_302_A";
        String sanofiT2DMCV = "EFC14828";
        String studyName = "a men's low testosterone";
        String siteIndication = "low testosterone or hypogonadism";
        String siteName = "AUT_LOWT_3017S";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGROUP(), dateOfBirthPageOLS.titleLOWT_3017_Expected, "Title is diff");

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091990")
                .clickNextButton(new ZipCodePageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        zipCodePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
                .back();
        dateOfBirthPageOLS.waitForPageLoadGROUP()
                .setDate("09091936")
                .clickNextButton(new ZipCodePageOLS());
        zipCodePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoadGROUP()
                .setDate("09091960")
                .clickNextButton(new ZipCodePageOLS());
        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        zipCodePageOLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8009", protocol1, protocol2)
                .back();

        PersonalQuestionsOLS personalQuestionsOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new PersonalQuestionsOLS());

        ExperiencedAnyOfFollowingOLS experiencedAnyOfFollowingOLS = personalQuestionsOLS
                .waitForPageLoad()
                .clickNextButton(new ExperiencedAnyOfFollowingOLS());

        HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_OLS = experiencedAnyOfFollowingOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5616", protocol1, protocol2);

        //-----------New Switching to CV module logic-----------------------
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        StatinMedicationsOnPageOLS statinMedicationsOnPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5632", esperionProtocol, kowaProtocol)
                .back(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new StatinMedicationsOnPageOLS());

        statinMedicationsOnPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5632", kowaProtocol, sanofiT2DMCV)
                .back(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .back(hasDoctorEverDiagnosedYouWithLowTestosterone_OLS)
                .waitForPageLoad()
                .back();

        experiencedAnyOfFollowingOLS
                .waitForPageLoad()
                .clickOnAnswers("Decreased sexual desire or libido",
                        "Decreased spontaneous erections (e.g., morning erections)",
                        "Decreased energy or fatigue/feeling tired",
                        "Low mood or depressed mood",
                        "Loss of body (axillary and pubic) hair or reduced shaving",
                        "Hot flashes")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());

        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        LevelOrHypogonadismPageOLS levelOrHypogonadismPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension",
                        "Chronic Kidney Disease")
                .clickNextButton(new LevelOrHypogonadismPageOLS());
        levelOrHypogonadismPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .back();
        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
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
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(siteIndication)
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
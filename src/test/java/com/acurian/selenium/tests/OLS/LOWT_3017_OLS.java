package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.StopTakingStatinPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
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
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class LOWT_3017_OLS extends BaseTest {

    @Test
    @TestCaseId("00015")
    @Description("LOWT_3017_OLS")
    public void lowt_3017_OLS() {
        String phoneNumber = "AUTAMSLOWT";
        String protocol1 = "M16_100";
        String protocol2 = "M16_100_S";
        String esperionProtocol = "1002_043";
        String esperionProtocolA = "1002_043_A";
        String kowaProtocolA = "K_877_302_A";
        String kowaProtocolS = "K_877_302_S";
        String studyName = "a men's low testosterone";
        String site_Indication = "low testosterone or hypogonadism";
        String siteName = "AUT_LOWT_3017_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGROUP();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionTextGROUP(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGROUP(), dateOfBirthPageOLS.titleLOWT_3017_Expected, "Title is diff");

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091990")
                .clickNextButton(new ZipCodePageOLS());
        zipCodePageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        zipCodePageOLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
                .back();
        dateOfBirthPageOLS.waitForPageLoadGROUP()
                .setDate("09091936")
                .clickNextButton(new ZipCodePageOLS());
        zipCodePageOLS
                .waitForPageLoad();
        zipCodePageOLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
                .back();
        dateOfBirthPageOLS.waitForPageLoadGROUP()
                .setDate("09091960")
                .clickNextButton(new ZipCodePageOLS());


        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        zipCodePageOLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8009", protocol1, protocol2)
                .back();
        genderPageOLS.waitForPageLoad();

        PersonalQuestionsOLS personalQuestionsOLS = genderPageOLS
                .clickOnAnswer("Male")
                .clickNextButton(new PersonalQuestionsOLS());

        ExperiencedAnyOfFollowingOLS experiencedAnyOfFollowing_OLS = personalQuestionsOLS
                .waitForPageLoad()
                .clickNextButton(new ExperiencedAnyOfFollowingOLS());

        //---------------Q3 ExperiencedAnyOfFollowingOLS page-------------------
        experiencedAnyOfFollowing_OLS
                .waitForPageLoad();
        Assert.assertEquals(experiencedAnyOfFollowing_OLS.getTitleText(), experiencedAnyOfFollowing_OLS.titleExpected, "Title is diff");
        HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_OLS = experiencedAnyOfFollowing_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5616", protocol1, protocol2);

        //-----------New Switching to CV module logic-----------------------
        //Check if possible to switch to to CV module logic
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionalStatementLowtPageOLS());

        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5632", esperionProtocol, esperionProtocolA, kowaProtocolA, kowaProtocolS)
                .back();

        StatinMedicationsOnPageOLS statinMedicationsOnPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new StatinMedicationsOnPageOLS());

        statinMedicationsOnPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5632", kowaProtocolA, kowaProtocolS)
                .checkProtocolsContainsForQNumber("QS6703", kowaProtocolA, kowaProtocolS)
                .back();

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5632", esperionProtocol, esperionProtocolA, kowaProtocolA, kowaProtocolS)
                .back();

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS)
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .back(hasDoctorEverDiagnosedYouWithLowTestosterone_OLS)
                .waitForPageLoad()
                .back(experiencedAnyOfFollowing_OLS)
                .waitForPageLoad()
                .clickOnAnswers("Decreased sexual desire or libido",
                        "Decreased spontaneous erections (e.g., morning erections)",
                        "Decreased energy or fatigue/feeling tired",
                        "Low mood or depressed mood",
                        "Loss of body (axillary and pubic) hair or reduced shaving",
                        "Hot flashes")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());

        //---------------Q4 hasDoctorEverDiagnosedYouWithLowTestosterone_OLS-------------------
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad();
        Assert.assertEquals(hasDoctorEverDiagnosedYouWithLowTestosterone_OLS.getTitleText(), hasDoctorEverDiagnosedYouWithLowTestosterone_OLS.titleExpected, "Title is diff");
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        //****************Q5 Has a doctor ever diagnosed you with any of the following medical conditions or diseases?------
        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad();
        Assert.assertEquals(cardiovascularDiseaseThanOthersPageOLS.getTitleText(), cardiovascularDiseaseThanOthersPageOLS.titleExpected, "Title is diff");
        //TransitionalStatementLowtPageOLS _TransitionalStatement_LowtPage_OLS = cardiovascularDiseaseThanOthersPageOLS
        LevelOrHypogonadismPageOLS levelOrHypogonadismPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension",
                        "Chronic Kidney Disease")
                .clickNextButton(new LevelOrHypogonadismPageOLS());
        levelOrHypogonadismPageOLS
                .waitForPageLoad();
        debugPageOLS.back();
        cardiovascularDiseaseThanOthersPageOLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new LevelOrHypogonadismPageOLS());


        //---------------Q6 LevelOrHypogonadismPageOLS-------------------
        levelOrHypogonadismPageOLS
                .waitForPageLoad();
        Assert.assertEquals(levelOrHypogonadismPageOLS.getTitleText(), levelOrHypogonadismPageOLS.titleExpected, "Title is diff");
        //HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = levelOrHypogonadismPageOLS
        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = levelOrHypogonadismPageOLS
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


        //---------------Q7 EverSmokedCigarettesPageOLS-------------------
        everSmokedCigarettesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(everSmokedCigarettesPageOLS.getTitleText(), everSmokedCigarettesPageOLS.titleExpected, "Title is diff");
        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = everSmokedCigarettesPageOLS
                .clickOnAnswer("Yes, I currently smoke")
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HeartOrBloodVesselPageOLS());


        //---------------Q8 HeartOrBloodVesselPageOLS-------------------
        heartOrBloodVesselPageOLS
                .waitForPageLoad();
        Assert.assertEquals(heartOrBloodVesselPageOLS.getTitleText(), heartOrBloodVesselPageOLS.titleExpected, "Title is diff");
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS = heartOrBloodVesselPageOLS
                //---------SKIP to Q11 if selected "None of the above"  or go to Q10--------
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS())
                .waitForPageLoad();
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS.back();
        heartOrBloodVesselPageOLS
                .waitForPageLoad();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = heartOrBloodVesselPageOLS
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());


        //---------------Q9 SubquestionExperiencedHeartPageOLS-------------------
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack();
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5622", protocol1, protocol2);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS.waitForPageLoad()
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());


        //---------------Q10 HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS-------------------
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS.getTitleText(), haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS.titleExpected, "Title is diff");
        HasDoctorEverDiagnosedYouMedicalCond_OLS hasDoctorEverDiagnosedYouMedicalCond_OLS = haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                //---------SKIP to Q12 if selected "None of the above"  or go to Q11--------
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS())
                .waitForPageLoad();
        hasDoctorEverDiagnosedYouMedicalCond_OLS.back();
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .waitForPageLoad();
        ReceivedHeartProcedurePageOLS receivedHeartProcedurePageOLS = haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                        "Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
                        "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                        "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                .clickNextButton(new ReceivedHeartProcedurePageOLS());


        //---------------Q11 ReceivedHeartProcedurePageOLS-------------------
        receivedHeartProcedurePageOLS
                .waitForPageLoad();
        Assert.assertEquals(receivedHeartProcedurePageOLS.getTitleText(), receivedHeartProcedurePageOLS.titleExpected, "Title is diff");
        receivedHeartProcedurePageOLS
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2);
        debugPageOLS.back();
        receivedHeartProcedurePageOLS.waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2);
        debugPageOLS.back();
        receivedHeartProcedurePageOLS.waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());


        //---------------Q13 HasDoctorEverDiagnosedYouMedicalCond_OLS-------------------
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad();
        Assert.assertEquals(hasDoctorEverDiagnosedYouMedicalCond_OLS.getTitleText(), hasDoctorEverDiagnosedYouMedicalCond_OLS.titleExpected, "Title is diff");
        ApproximateHeightPageOLS approximateHeightPageOLS = hasDoctorEverDiagnosedYouMedicalCond_OLS
                .clickOnAnswers("History of Prostate or Breast Cancer",
                        "Other cancer within the past 2 years (except skin cancer)",
                        "Sleep apnea that is not currently being treated",
                        "Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5626", protocol1, protocol2);
        debugPageOLS.back();
        hasDoctorEverDiagnosedYouMedicalCond_OLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());


        //----------****************NEW GENERAL HEALTH Questions************************----------  
        //------------Q14 What is your approximate height?  What is your approximate weight?------
        approximateHeightPageOLS
                .waitForPageLoad();
        //------Disqualify ("High BMI") if > 50  ---  Calculate BMI as (X lbs/2.2)/[(X inches/39.37) x (X inches/39.37)]----
        approximateHeightPageOLS
                .setAll("5", "0", "256")
                //.clickNextButton(new ChildrenUnderPageOLS())
                .clickNextButton(transitionalStatementLowtPageOLS);
        transitionalStatementLowtPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5627", protocol1, protocol2);
        transitionalStatementLowtPageOLS.back();
        approximateHeightPageOLS.waitForPageLoad()
                //----------Change inches to maje BMI to <50--------------------
                .waitForPageLoad()
                .setIncheswithClear("5")
//        .clickNextButton(new ChildrenUnderPageOLS())
//
//
//		//----------ChildrenUnderTheAge Page--------------------
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
//        .clickNextButton(new EthnicBackgroundPageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())

                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
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

                //------------HUMAN API Interface in HelloSign----------------
                /*.getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()*/

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
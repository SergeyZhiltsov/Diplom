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
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class LOWTS_3017S_OLS extends BaseTest {

    @Test
    @TestCaseId("00015")
    @Description("LOWT_3017S_OLS")
    public void lOWTS_3017S_OLS() {
        String phoneNumber = "AUTAMSLOWT";
        List<String> protocols = Arrays.asList("M16_100");
        String protocol1 = "M16_100";
        String protocol2 = "M16_100_S";
        String studyName = "a men's low testosterone";
        String siteIndication = "low testosterone or hypogonadism";
        String siteName = "AUT_LOWT_3017S";
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

        HaveYouExperienceAnyOftheFollowing_OLS haveYouExperienceAnyOftheFollowing_OLS = personalQuestionsOLS
                .waitForPageLoad()
                .clickNextButton(new HaveYouExperienceAnyOftheFollowing_OLS());

        //---------------Q3 HaveYouExperienceAnyOftheFollowing_OLS page-------------------
        haveYouExperienceAnyOftheFollowing_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouExperienceAnyOftheFollowing_OLS.getTitleText(), haveYouExperienceAnyOftheFollowing_OLS.titleExpected, "Title is diff");
        HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_OLS = haveYouExperienceAnyOftheFollowing_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5616", protocol1, protocol2);
        debugPageOLS.back();
        haveYouExperienceAnyOftheFollowing_OLS.waitForPageLoad()
                //HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_OLS = haveYouExperienceAnyOftheFollowing_OLS
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
        HasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS hasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS());


        //****************Q5 Has a doctor ever diagnosed you with any of the following medical conditions or diseases?------
        hasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS
                .waitForPageLoad();
        Assert.assertEquals(hasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS.getTitleText(), hasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS.titleExpected, "Title is diff");
        //LowT_TransitionalStatement_OLS lowT_TransitionalStatement_OLS = hasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS
        AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS = hasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension",
                        "Chronic Kidney Disease")
                .clickNextButton(new AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS());
        areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
                .waitForPageLoad();
        debugPageOLS.back();
        hasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS());


        //---------------Q6 AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS-------------------
        areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.getTitleText(), areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.titleExpected, "Title is diff");
        //HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
        HaveYouEverSmokedCigarettes_OLS haveYouEverSmokedCigarettes_OLS = areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
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
                .clickNextButton(new HaveYouEverSmokedCigarettes_OLS());


        //---------------Q7 HaveYouEverSmokedCigarettes_OLS-------------------
        haveYouEverSmokedCigarettes_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverSmokedCigarettes_OLS.getTitleText(), haveYouEverSmokedCigarettes_OLS.titleExpected, "Title is diff");
        HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS = haveYouEverSmokedCigarettes_OLS
                .clickOnAnswer("Yes, I currently smoke")
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS());


        //---------------Q8 HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS-------------------
        haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS.getTitleText(), haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS.titleExpected, "Title is diff");
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS = haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
                //---------SKIP to Q10 if selected "None of the above"  or go to Q9--------
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS())
                .waitForPageLoad();
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS.back();
        haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
                .waitForPageLoad();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
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
        WhenWasTheLastTimeThatYouReceivedHeartProc_OLS whenWasTheLastTimeThatYouReceivedHeartProc_OLS = haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                        "Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
                        "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                        "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                .clickNextButton(new WhenWasTheLastTimeThatYouReceivedHeartProc_OLS());


        //---------------Q11 WhenWasTheLastTimeThatYouReceivedHeartProc_OLS-------------------
        whenWasTheLastTimeThatYouReceivedHeartProc_OLS
                .waitForPageLoad();
        Assert.assertEquals(whenWasTheLastTimeThatYouReceivedHeartProc_OLS.getTitleText(), whenWasTheLastTimeThatYouReceivedHeartProc_OLS.titleExpected, "Title is diff");
        whenWasTheLastTimeThatYouReceivedHeartProc_OLS
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2);
        debugPageOLS.back();
        whenWasTheLastTimeThatYouReceivedHeartProc_OLS.waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2);
        debugPageOLS.back();
        whenWasTheLastTimeThatYouReceivedHeartProc_OLS.waitForPageLoad()
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
        LowT_TransitionalStatement_OLS lowT_TransitionalStatement_OLS = approximateHeightPageOLS
                .setAll("5", "0", "256")
                //.clickNextButton(new ChildrenUnderPageOLS())
                .clickNextButton(new LowT_TransitionalStatement_OLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5627", protocol1, protocol2);
        lowT_TransitionalStatement_OLS.back();
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
                .waitForPageLoad(siteIndication)
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
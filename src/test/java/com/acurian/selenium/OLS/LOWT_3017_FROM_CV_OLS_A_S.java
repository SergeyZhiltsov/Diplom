package com.acurian.selenium.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class LOWT_3017_FROM_CV_OLS_A_S extends BaseTest {


    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_LOWT_3017S_Site},
                {Site.AUT_LOWT_3017_Site}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("LowT_3017_FromCv_Ols")
    public void lowt3017FromCvOls(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String protocol1 = "M16_100";
        String protocol2 = "M16_100_S";
//        String esperionProtocol = "1002_043";
//        String esperionProtocolA = "1002_043_A";
        String kowaProtocolA = "K_877_302_A";
        String kowaProtocolS = "K_877_302_S";
        final String novoProtocol = "EX9536_4388";
        String[] cvModuleProtocols = {kowaProtocolA, kowaProtocolS};
        String dqedStudyName = "a heart health study";
        String studyName = "a men's health study";
        String site_Indication = "low testosterone or hypogonadism";
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a heart health study", "750");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
//                dateOfBirthPageOLS.getExpectedModifiedTitle("a heart health study", "750"), "Title is diff");

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        //---------------ZIP-CODE Question-------------------
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        HasDoctorEverDiagnosedYouMedicalCond_OLS hasDoctorEverDiagnosedYouMedicalCond_ols = genderPageOLS
                .waitForPageLoad()
                .setDate("09091960")
                .clickOnAnswer("Male")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());

        //---------------Q3 Has a doctor ever diagnosed you with any of the following medical conditions or diseases? -------------------
        // Selecting "None of the above" answer to be DQ for CV module protocols
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = hasDoctorEverDiagnosedYouMedicalCond_ols
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        PersonalQuestionsOLS personalQuestionsOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", kowaProtocolA, kowaProtocolS)
                .getPage(whatKindOfDiabetesPageOLS)
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new PersonalQuestionsOLS());

        personalQuestionsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", kowaProtocolA, kowaProtocolS, novoProtocol);

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

        //---------------Q4 hasDoctorEverDiagnosedYouWithLowTestosterone_OLS-------------------
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad();
        Assert.assertEquals(hasDoctorEverDiagnosedYouWithLowTestosterone_OLS.getTitleText(), hasDoctorEverDiagnosedYouWithLowTestosterone_OLS.titleExpected, "Title is diff");
        LevelOrHypogonadismPageOLS levelOrHypogonadismPageOLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new LevelOrHypogonadismPageOLS());

        //---------------Q6 LevelOrHypogonadismPageOLS-------------------
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
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1);
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
        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = approximateHeightPageOLS
                .setAll("5", "0", "256")
                //.clickNextButton(new ChildrenUnderPageOLS())
                .clickNextButton(new TransitionalStatementLowtPageOLS());
        transitionalStatementLowtPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5627", protocol1, protocol2);
        transitionalStatementLowtPageOLS.back();
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS.waitForPageLoad()
                //----------Change inches to maje BMI to <50--------------------
                .waitForPageLoad()
                .setIncheswithClear("5")
                .clickNextButton(new IdentificationPageOLS());
        //----------PII (IdentificationPageOLS) Page--------------------
        IncongruentSiteSelectionClose_OLS incongruentSiteSelectionClose_ols = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new IncongruentSiteSelectionClose_OLS());
        //----------SiteSelection Page--------------------
        incongruentSiteSelectionClose_ols
                .waitForPageLoad(studyName, dqedStudyName)
                .getPID();
        switch(site) {
            case AUT_LOWT_3017_Site: //1R
                incongruentSiteSelectionClose_ols
                        .clickNextButton(new QualifiedClosedPageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusHealthyMindsPageOLS())
                        .waitForPageLoad()
                        .clickOnAnswer("No, I am not interested in receiving information")
                        .clickNextButton(new ThankYouCloseSimplePageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new AboutHealthPageOLS())
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_LOWT_3017S_Site: //41C
                incongruentSiteSelectionClose_ols
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
                        .clickNextButton(new AlzheimerClosePageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new AboutHealthPageOLS())
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
    }
}
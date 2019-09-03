package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DY_4356.SubquestionStatinMedicationsHavePageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.cv_study.CholesterolTriglyceridesLipidsPageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class LOWT_3017_OLS_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] sites() {
        return new Object[][] {
                {Site.AUT_LOWT_3017S_Site},
                //{Site.AUT_LOWT_3017_Site}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("LOWT_3017_OLS_A_S")
    public void lowt3017ols(Site site) {
        String phoneNumber = "AUTAMSLOWT";
      /*  String protocol1 = "M16_100";*/ //only 3107s is reactivated
        String protocol2 = "M16_100_S";
        //String esperionProtocol = "1002_043"; //Deactivate 3140 Esperion HC & CVD (all protocols: 1002-043_A & 1002-043)
        //String esperionProtocolA = "1002_043_A"; //R74	74.0	6/21/2019 & 6/24/2019
        String kowaProtocolA = "K_877_302_A";
        String kowaProtocolS = "K_877_302_S";
        String studyName = "a men's health";
        String site_Indication = "low testosterone or hypogonadism";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a study", "600"), "Title is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(), dateOfBirthPageOLS.getExpectedModifiedTitle("a study", "600"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", protocol2)
                .back();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad2Ver()
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                .waitForPageLoad()
                .setDate("09091941")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", protocol2)
                .back();

        genderPageOLS
                .setDate("09091981")
                .clickOnAnswer("Male")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", protocol2)
                .back();

        PersonalQuestionsOLS personalQuestionsOLS = genderPageOLS
                .setDate("09091941")
                .clickOnAnswer("Male")
                .clickNextButton(new PersonalQuestionsOLS());





        //---------------Date of Birth Question-------------------
//        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
//        dateOfBirthPageOLS
//                .openPage(env, phoneNumber)
//                .waitForPageLoad2Ver();
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(),
//                dateOfBirthPageOLS.getExpectedModifiedTitle("a study", "600"), "Title is diff");
//
//        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
//                .setDate("09091990")
//                .clickNextButton(new ZipCodePageOLS());
//        zipCodePageOLS
//                .waitForPageLoad();
//        DebugPageOLS debugPageOLS = new DebugPageOLS();
//        zipCodePageOLS.getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
//                .back();
//        dateOfBirthPageOLS.waitForPageLoad2Ver()
//                .setDate("09091936")
//                .clickNextButton(new ZipCodePageOLS());
//        zipCodePageOLS
//                .waitForPageLoad();
//        zipCodePageOLS.getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QSI8005", protocol1, protocol2)
//                .back();
//        dateOfBirthPageOLS
//                .waitForPageLoad2Ver()
//                .setDate("09091960")
//                .clickNextButton(new ZipCodePageOLS());
//
//        //---------------ZIP-CODE Question-------------------
//        zipCodePageOLS
//                .waitForPageLoad();
//        GenderPageOLS genderPageOLS = zipCodePageOLS
//                .typeZipCode(site.zipCode)
//                .clickNextButton(new GenderPageOLS());

//        //---------------GENDER Question-------------------
//        genderPageOLS
//                .waitForPageLoad();
//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
//                genderPageOLS
//                .clickOnAnswer("Female")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

//        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QSI8009", protocol1, protocol2)
//                .back();
//
//        PersonalQuestionsOLS personalQuestionsOLS = genderPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Male")
//                .clickNextButton(new PersonalQuestionsOLS());

        ExperiencedAnyOfFollowingOLS experiencedAnyOfFollowing_OLS = personalQuestionsOLS
                .waitForPageLoad()
                .clickNextButton(new ExperiencedAnyOfFollowingOLS());

        HasDoctorEverDiagnosedYouWithLowTestosterone_OLS hasDoctorEverDiagnosedYouWithLowTestosterone_OLS =
                experiencedAnyOfFollowing_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS());
        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5616", /*protocol1,*/ protocol2);

        //-----------NO SWITCH to CV module logic-----------------------
        //Check if NOT possible to switch to to CV module logic
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS =
                hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(new TransitionalStatementLowtPageOLS());
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(approximateHeightPageOLS);
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(transitionalStatementLowtPageOLS);
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(approximateHeightPageOLS);
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(transitionalStatementLowtPageOLS);
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(approximateHeightPageOLS);
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(transitionalStatementLowtPageOLS);
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS);


        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Chronic Kidney Disease")
                .clickNextButton(approximateHeightPageOLS);
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(transitionalStatementLowtPageOLS);
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .back(hasDoctorEverDiagnosedYouWithLowTestosterone_OLS)
                .waitForPageLoad()
                .back(experiencedAnyOfFollowing_OLS);

        //module started
        experiencedAnyOfFollowing_OLS
                .waitForPageLoad()
                .clickOnAnswers("Decreased sexual desire or libido",
                        "Decreased spontaneous erections (e.g., morning erections)",
                        "Decreased energy or fatigue/feeling tired",
                        "Low mood or depressed mood",
                        "Loss of body (axillary and pubic) hair or reduced shaving",
                        "Hot flashes")
                .clickNextButton(hasDoctorEverDiagnosedYouWithLowTestosterone_OLS);

        hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad();
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

        levelOrHypogonadismPageOLS
                .waitForPageLoad();
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

        everSmokedCigarettesPageOLS
                .waitForPageLoad();
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
        debugPageOLS.checkProtocolsContainsForQNumber("QS5622", /*protocol1,*/ protocol2);
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
        debugPageOLS.checkProtocolsContainsForQNumber("QS5624", /*protocol1,*/ protocol2);
        debugPageOLS.back();
        receivedHeartProcedurePageOLS.waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5624", /*protocol1,*/ protocol2);
        debugPageOLS.back();
        receivedHeartProcedurePageOLS.waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());


        //---------------Q13 HasDoctorEverDiagnosedYouMedicalCond_OLS-------------------
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad()
                .clickOnAnswers("History of Prostate or Breast Cancer",
                        "Other cancer within the past 2 years (except skin cancer)",
                        "Sleep apnea that is not currently being treated",
                        "Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5626", /*protocol1,*/ protocol2);
        debugPageOLS.back();
        hasDoctorEverDiagnosedYouMedicalCond_OLS.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()//---Disqualify ("High BMI") if > 50 - Calculate BMI as (X lbs/2.2)/[(X inches/39.37) x (X inches/39.37)]
                .setAll("5", "0", "256")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5627", /*protocol1,*/ protocol2)
                .back();
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad() //----------Change inches to maje BMI to <50--------------------
                .setIncheswithClear("5")
                .clickNextButton(new IdentificationPageOLS());
                //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());
        siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_LOWT_3017_Site: //1R
                siteSelectionPageOLS
                        .clickOnFacilityName(site.name)
                        .clickNextButton(new QualifiedClose1PageOLS())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
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
                siteSelectionPageOLS
                        .clickOnFacilityName(site.name)
                        .clickNextButton(new DoctorInformationCollectionPageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new HS1PageOLS())
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
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.lowt_3017.*;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LOWT_3017_OLSBlinx extends BaseTest {


    @Test()
    @Description("LOWT_3017_OLS_A_S")
    public void lowt3017ols() {
        Site site = Site.AUT_LOWT_3017S_Site;
        String phoneNumber = "AUTAMSLOWT";
        String protocol2 = "M16_100_S";
        String studyName = "a men's health";
        String site_Indication = "low testosterone or hypogonadism";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a study", "600");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a study", "600"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", protocol2)
                .back(dateOfBirthPageOLS);
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a study", "600")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
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
                .back(genderPageOLS);

        genderPageOLS
                .waitForPageLoad()
                .setDate("09091981")
                .clickOnAnswer("Male")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", protocol2)
                .back(genderPageOLS);

        PersonalQuestionsOLS personalQuestionsOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091960")
//                .clickOnAnswer("Male")
                .clickNextButton(new PersonalQuestionsOLS());

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

        ApproximateHeightPageOLS approximateHeightPageOLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
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

        LevelOrHypogonadismPageOLS levelOrHypogonadismPageOLS = hasDoctorEverDiagnosedYouWithLowTestosterone_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new LevelOrHypogonadismPageOLS());

        levelOrHypogonadismPageOLS
                .waitForPageLoad();
        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = levelOrHypogonadismPageOLS
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
                .clickNextButton(new HeartOrBloodVesselPageOLS());
//                .clickNextButton(new EverSmokedCigarettesPageOLS());
//
//        everSmokedCigarettesPageOLS
//                .waitForPageLoad();
//        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = everSmokedCigarettesPageOLS
//                .clickOnAnswer("Yes, I currently smoke")
//                .clickOnAnswer("I used to smoke, but have since quit")
//                .clickOnAnswer("No, I never smoked")
//                .clickNextButton(new HeartOrBloodVesselPageOLS());


        //---------------Q8 HeartOrBloodVesselPageOLS-------------------
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS =
                heartOrBloodVesselPageOLS
                        .waitForPageLoad()
                        //---------SKIP to Q11 if selected "None of the above"  or go to Q10--------
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS())
                        .waitForPageLoad();
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .back(heartOrBloodVesselPageOLS);
        WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS whenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS =
                heartOrBloodVesselPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack",
                                "Stroke",
                                "TIA or \"Mini-Stroke\"")
                        .clickNextButton(new WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS());


        //---------------Q9 SubquestionExperiencedHeartPageOLS-------------------
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS =
                whenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS
                        .waitForPageLoad()
                        .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                        .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                        .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                        .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5622", /*protocol1,*/ protocol2)
                .back(whenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS);
        whenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());


        //---------------Q10 HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS-------------------
        HasDoctorEverDiagnosedYouMedicalCond_OLS hasDoctorEverDiagnosedYouMedicalCond_OLS =
                haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                        .waitForPageLoad()
                        //---------SKIP to Q12 if selected "None of the above"  or go to Q11--------
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad2()
                .back(haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS);
        ReceivedHeartProcedurePageOLS receivedHeartProcedurePageOLS =
                haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
                        .waitForPageLoad()
                        .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)",
                                "Coronary Artery Bypass Graft, also known as CABG, “cabbage”, or heart bypass surgery",
                                "Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain",
                                "Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
                        .clickNextButton(new ReceivedHeartProcedurePageOLS());


        //---------------Q11 ReceivedHeartProcedurePageOLS-------------------
        receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(hasDoctorEverDiagnosedYouMedicalCond_OLS);
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad2()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5624", /*protocol1,*/ protocol2)
                .back(receivedHeartProcedurePageOLS);
        receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(hasDoctorEverDiagnosedYouMedicalCond_OLS);
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad2()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5624", /*protocol1,*/ protocol2)
                .back(receivedHeartProcedurePageOLS);
        receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(hasDoctorEverDiagnosedYouMedicalCond_OLS);


        //---------------Q13 HasDoctorEverDiagnosedYouMedicalCond_OLS-------------------
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad2()
                .clickOnAnswers("History of Prostate or Breast Cancer",
                        "Other cancer within the past 2 years (except skin cancer)",
                        "Sleep apnea that is not currently being treated",
                        "Drug, alcohol or steroid abuse in the past 12 months")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5626", /*protocol1,*/ protocol2)
                .back(hasDoctorEverDiagnosedYouMedicalCond_OLS);
        hasDoctorEverDiagnosedYouMedicalCond_OLS
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = approximateHeightPageOLS
                .waitForPageLoad()//---Disqualify ("High BMI") if > 50 - Calculate BMI as (X lbs/2.2)/[(X inches/39.37) x (X inches/39.37)]
                .setAll("5", "0", "256")
                .clickNextButton(new TransitionalStatementLowtPageOLS());
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5633", /*protocol1,*/ protocol2)
                .back(approximateHeightPageOLS);
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad() //----------Change inches to maje BMI to <50--------------------
                .setAll("5", "5", "256")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad2()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
                .clickNextButton(new SiteSelectionPageOLS());
        siteSelectionPageOLS
                .waitForPageLoad(studyName + " study!")
                .getPID();

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        switch (site) {
            case AUT_LOWT_3017_Site: //1R
                siteSelectionPageOLS
                        .clickOnFacilityName(site.name)
                        .clickNextButton(new QualifiedClose2PageOLS())
                        .waitForPageLoad3()
//                        .clickNextButton(new SynexusHealthyMindsPageOLS())
//                        .waitForPageLoad()
//                        .clickOnAnswer("No, I am not interested in receiving information")
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
                SiteSelectionPageOLS siteSelectionPageOLS1 = new SiteSelectionPageOLS();
                siteSelectionPageOLS1
                        .clickOnFacilityName(site.name)
                        .clickNextButton(new QualifiedClose2PageOLS())
                        .waitForPageLoad3()
                        .clickNextButton(thankYouCloseSimplePageOLS);
//                        .clickOnAnswer("Continue with medical records")
//                        .clickNextButton(new DoctorInformationCollectionPageOLS())пф
//                        .waitForPageLoad()
//                        .clickNextButton(new HS1PageOLS())
//                        .waitForPageLoad()
//                        .clickOkInPopUp()
//                        .setSignature();

                AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                        .waitForPageLoad()
//                        .waitToClickNext()
                        .clickNextButton(new AlzheimerClosePageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new AboutHealthPageOLS())
                        .waitForPageLoad();
                if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
                    aboutHealthPageOLS
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .getRadiantDbToLog(env)
                            // .getAnomalyDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo);
                }
        }
    }
}

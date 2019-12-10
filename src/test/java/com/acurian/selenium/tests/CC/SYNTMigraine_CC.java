package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.DIA_4241.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LMG_4686.HowManyDaysYouSufferCC;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.Migraine.HaveYouBeenDiagnosedWithMigrainesPageCC;
import com.acurian.selenium.pages.CC.Migraine.HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС;
import com.acurian.selenium.pages.CC.Vaccine.DirectSheduleVaccCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.cv_study.MostRecentHeartRelatedSurgeryProcedurePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.tests.OLS.SYNTMigraine_OLS;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SYNTMigraine_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(enabled = true, dataProvider = "sites", dataProviderClass = SYNTMigraine_OLS.class)
    public void SYNTMigraine_CC(Site site) {
        final String phoneNumber = "AUTAMS1MIG";
        final String studyName = "a migraine study!"; //"a NASH study";
        final String indicationHistroyName = "migraines";

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
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a migraine study", "400");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle("a fatty liver study for diabetics", "750"), "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();


        GenderPageCC genderPageCC = dateOfBirthPageCC
                .waitForPageLoad("a migraine study", "400")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC())
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        HaveYouBeenDiagnosedWithMigrainesPageCC haveYouBeenDiagnosedWithMigrainesPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1960")
                .clickOnAnswer("Male")
                .clickNextButton(new HaveYouBeenDiagnosedWithMigrainesPageCC());


//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = haveYouBeenDiagnosedWithMigrainesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();

        WhichTypeOfHeadacheCC whichTypeOfHeadacheCC = new WhichTypeOfHeadacheCC();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesCC();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(whichTypeOfHeadacheCC)
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS45", site.activeProtocols)
                .back(whichTypeOfHeadacheCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .back();
        ApproximateHeightPageCC approximateHeightPageCC = haveYouBeenDiagnosedWithMigrainesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowOldWereYouMigHeadachePageCC())
                .waitForPageLoad()
                .typeAge("60")
                .clickNextButton(new HowLongSufferingFromMigraineCC())
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferCC())
                .waitForPageLoad()
                .selectDay("5")
                .clickNextButton(new HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС())
                .waitForPageLoad()
                .clickOnAnswer("No, never any daily medications that my doctor prescribed")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        IdentificationPageCC identificationPageOLS = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "190") //BMI > 30
                .clickNextButton(new IdentificationPageCC());
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new TransitionalStatementLowtPageOLS())
//                .waitForPageLoad()
//                .clickNextButton(new ExperiencedAnyOfFollowingOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new IdentificationPageOLS());

        SiteSelectionPageCC siteSelectionPageCC = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
//                .setAll("4", "9", "138")
//                .clickNextButton(new LetMeSeePageCC());
//
//        letMeSeePageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
//                .back();
//
//        approximateHeightPageCC
//                .waitForPageLoad()
                .setAll("4", "10", "180")
                .clickNextButton(new LetMeSeePageCC());

//        DigestiveConditionsAffectDiabetesPageCC digestiveConditionsAffectDiabetesPageCC = letMeSeePageCC
//                .waitForPageLoad()
//                .clickNextButton(new DigestiveConditionsAffectDiabetesPageCC());
//
//        SymptomsRegularlyOncePerWeekPageCC symptomsRegularlyOncePerWeekPageCC = digestiveConditionsAffectDiabetesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new SymptomsRegularlyOncePerWeekPageCC());
//
//        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC = symptomsRegularlyOncePerWeekPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC());
//
//        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC = haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Unsure")
//                .clickNextButton(new CholesterolTriglyceridesLipidsPageCC());
//
//        cholesterolTriglyceridesLipidsPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);
//
//        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
//
//        AdditionalHeartRelatedConditionsPageCC additionalHeartRelatedConditionsPageCC =  heartrelatedMedicalProceduresPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AdditionalHeartRelatedConditionsPageCC());
//
//        IdentificationPageCC identificationPageCC = additionalHeartRelatedConditionsPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new IdentificationPageCC());

//        DoYouExperienceAnyOfFollowingSymptoms_CC doYouExperienceAnyOfFollowingSymptoms_CC = doYouExperienceDPN_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No, none of the above")
//                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_CC());
//
//        TransitionStatementCVbeginPageCC transitionStatementCVbeginPageCC = doYouExperienceAnyOfFollowingSymptoms_CC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new TransitionStatementCVbeginPageCC());
//
//        ExperiencedAnyOfFollowingCC experiencedAnyOfFollowingCC = transitionStatementCVbeginPageCC
//                .waitForPageLoad()
//                .clickNextButton(new ExperiencedAnyOfFollowingCC());
//
//        HasDoctorEverDiagnosedYouWithLowTestosterone_CC hasDoctorEverDiagnosedYouWithLowTestosterone_CC = experiencedAnyOfFollowingCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_CC());
//
//        IdentificationPageCC identificationPageCC = hasDoctorEverDiagnosedYouWithLowTestosterone_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new IdentificationPageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(siteSelectionPageCC);
        switch (site) {
//            case AUT_NASH4483_site: //1R
//                siteSelectionPageCC
//                        .waitForPageLoad(studyName)
//                        .getPID()
//                        .clickOnAnswer(site.name)
//                        .clickNextButton(new QualifiedClose1PageCC())
//                        .waitForPageLoad()
//                        // .clickOnAnswer("No")
////                    .clickNextButton(new SynexusHealthyMindsPageCC())
////                    .waitForPageLoad()
////                    .clickOnAnswer("No")
//                        .clickNextButton(new ThankYouCloseSimplePageCC())
//                        .waitForPageLoad3()
//                        .clickNextButton(new AlzheimerClosePageCC())
//                        .waitForPageLoad()
//                        .clickNextButton(selectActionPageCC)
//                        .waitForPageLoad()
//                        .pidFromDbToLog(env)
//                        .getRadiantDbToLog(env)
//                        .childPidFromDbToLog(env, "4483")
//                        .assertGeneratedFul(env, site)
//                        .dispoShouldMatch(site.dispo, site.dispo);
//                break;
            case AUT_AMS1_DIABS_site: //41C
                siteSelectionPageCC
                        .waitForPageLoad(studyName)
                        .getPID()
                        .clickOnAnswer(site.name)
                        .clickNextButton(new DirectSheduleVaccCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .assertVariablesNew("Acurian", "Trial", "09/09/1960", "US",
                                "Chandler, AZ", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", " 010110 : Synexus - 010110 ", " East Valley Family Physicians", "AESXXXDIA001 - SYNType_2_Diabetes (SYNT2DM)")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env, "4483")
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
    }

}

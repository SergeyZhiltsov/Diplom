package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LMG_4686.HowManyDaysYouSufferCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.Migraine.HaveYouBeenDiagnosedWithMigrainesPageCC;
import com.acurian.selenium.pages.CC.Migraine.HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
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
        final String studyName = "a migraine study"; //"a NASH study";
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
        NonQRtransitionPageCC nonQRtransitionPageCC = haveYouBeenDiagnosedWithMigrainesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = nonQRtransitionPageCC
                .waitForPageLoad()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();

        WhichTypeOfHeadacheDoYouGetCC whichTypeOfHeadacheDoYouGetCC = new WhichTypeOfHeadacheDoYouGetCC();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesCC();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(whichTypeOfHeadacheDoYouGetCC)
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS45", site.activeProtocols)
                .back(whichTypeOfHeadacheDoYouGetCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .back(nonQRtransitionPageCC)
                .waitForPageLoad()
                .back();


        haveYouBeenDiagnosedWithMigrainesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigСС())
                .waitForPageLoad()
                .typeAge("60")
                .clickNextButton(new ApproxHowLongSufferingFromMIGСС())
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferCC())
                .waitForPageLoad()
                .selectDay("5")
                .clickNextButton(new HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС())
                .waitForPageLoad()
                .clickOnAnswer("No, never any daily medications that my doctor prescribed")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoad("migraine")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(whichTypeOfHeadacheDoYouGetCC);
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = new HaveYouEverExperiencedHeartRelatedMedicalCondCC();

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = whichTypeOfHeadacheDoYouGetCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichTypeOfHeadacheDoYouGetCC)
                .waitForPageLoad()
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        MostRecentHeartProcedurePageСС mostRecentHeartProcedurePageСС = subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageСС());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = new DoAnyOftheFollowingAdditionalDiagnosesCC();

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();
        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();
        whichTypeOfHeadacheDoYouGetCC
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);


//        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
//                .waitForPageLoad()
//                .setAll("5", "5", "190") //BMI > 30
//                .clickNextButton(new LetMeSeePageCC());
//        IdentificationPageOLS identificationPageOLS = letMeSeePageCC
//                .waitForPageLoad()
//                .clickNextButton(new IdentificationPageOLS());
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
//
//        SiteSelectionPageCC siteSelectionPageCC = identificationPageOLS
//                .waitForPageLoad()
//                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
//                .clickNextButton(new SiteSelectionPageCC());
//
//        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
//                .waitForPageLoad()
//                .setAll("4", "9", "138")
//                .clickNextButton(new LetMeSeePageCC());
//
//        letMeSeePageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
//                .back();
//
        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
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

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());
        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());
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
            case AUT_AMS1_MIGRS_site: //41C
                siteSelectionPageCC
                        .waitForPageLoad(studyName)
                        .getPID()
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad3()
                        .clickNextButton(new AlzheimerClosePageCC())
                        .waitForPageLoad()
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

package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.MostRecentHeartRelatedSurgeryProcedurePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.glaucoma.*;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class GLA_9184_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(GLA_9184_CC.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_S10503}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("S10503(9184) 192024-093 (Allergan Glaucoma and Ocular Hypertension R99")
    public void gla9184ccTest(Site site) {

        String phoneNumber = "AUTAMS1HTN";
        String studyName = "a study for people with glaucoma or ocular hypertension";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageCC debugPageCC = new DebugPageCC();

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle(site_Indication, "500"), "Title is diff");
        dateOfBirthPageCC
                .waitForPageLoad(studyName, "1,000")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")//If "No", go to Does Not Give Permission to Proceed Close
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad(studyName, "1,000")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DoctorDiagnosedFollowingEyeConditionsCC doctorDiagnosedFollowingEyeConditionsCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Aug")
                .setDay("9")
                .setYear("1990")
                .clickOnAnswer("Female")
                .clickNextButton(new DoctorDiagnosedFollowingEyeConditionsCC());

        //-------------------------------FLOW LOGIC---------------------------------------------

        NonQRtransitionPageCC nonQRtransitionPageCC =
                doctorDiagnosedFollowingEyeConditionsCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8602", site.activeProtocols)
                .back(doctorDiagnosedFollowingEyeConditionsCC);

        TypeOfGlaucomaCC typeOfGlaucomaCC = doctorDiagnosedFollowingEyeConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("Glaucoma – damage to the optic nerve caused by high eye pressure")
                .clickNextButton(new TypeOfGlaucomaCC());

        WhichEyeGlaucomaOrOcularHypertensionCC whichEyeGlaucomaOrOcularHypertensionCC = typeOfGlaucomaCC
                .waitForPageLoad()
                .clickOnAnswer("Closed or narrow angle – less common, caused by rapid blockage of the angle between your iris and cornea")
                .clickNextButton(new WhichEyeGlaucomaOrOcularHypertensionCC());

        PrescribedMedicationForGlaucomaCC prescribedMedicationForGlaucomaCC = whichEyeGlaucomaOrOcularHypertensionCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8603", site.activeProtocols)
                .back(typeOfGlaucomaCC)
                .waitForPageLoad()
                .clickOnAnswer("Open angle – the most common type, caused by slow clogging of the angle between your iris and cornea")
                .clickNextButton(whichEyeGlaucomaOrOcularHypertensionCC)
                .waitForPageLoad()
                .clickOnAnswer("Right eye only")
                .clickNextButton(new PrescribedMedicationForGlaucomaCC());

        EverBeenDiagnosedFollowingEyeConditionsCC everBeenDiagnosedFollowingEyeConditionsCC = prescribedMedicationForGlaucomaCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8604", site.activeProtocols)
                .back(whichEyeGlaucomaOrOcularHypertensionCC)
                .waitForPageLoad()
                .clickOnAnswer("Left eye only")
                .clickNextButton(prescribedMedicationForGlaucomaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8604", site.activeProtocols)
                .back(whichEyeGlaucomaOrOcularHypertensionCC)
                .waitForPageLoad()
                .clickOnAnswer("Both eyes")
                .clickNextButton(prescribedMedicationForGlaucomaCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new EverBeenDiagnosedFollowingEyeConditionsCC());

        SurgeryOrImplantToTreatGlaucomaCC surgeryOrImplantToTreatGlaucomaCC = everBeenDiagnosedFollowingEyeConditionsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8605", site.activeProtocols)
                .back(prescribedMedicationForGlaucomaCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(everBeenDiagnosedFollowingEyeConditionsCC)
                .waitForPageLoad()
                .clickOnAnswers("Macular edema – excess fluid in the back of the eye",
                        "Neovascular or \"wet\" age related macular degeneration – leaky blood vessels in the back of your eye",
                        "Cancer of the eye",
                        "Herpes affecting the eye",
                        "Shingles affecting the eye")
                .clickNextButton(new SurgeryOrImplantToTreatGlaucomaCC());

        SurgeryOrImplantOnOrAroundEyePastSixMonthsCC surgeryOrImplantOnOrAroundEyePastSixMonthsCC = surgeryOrImplantToTreatGlaucomaCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8606", site.activeProtocols)
                .back(everBeenDiagnosedFollowingEyeConditionsCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(surgeryOrImplantToTreatGlaucomaCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SurgeryOrImplantOnOrAroundEyePastSixMonthsCC());

        InjectionIntoYourEyeCC injectionIntoYourEyeCC = surgeryOrImplantOnOrAroundEyePastSixMonthsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8607", site.activeProtocols)
                .back(surgeryOrImplantToTreatGlaucomaCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(surgeryOrImplantOnOrAroundEyePastSixMonthsCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new InjectionIntoYourEyeCC());

        TransitionStatementCC transitionStatementCC = injectionIntoYourEyeCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8608", site.activeProtocols)
                .back(surgeryOrImplantOnOrAroundEyePastSixMonthsCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(injectionIntoYourEyeCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadGLAUCOMA(studyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8609", site.activeProtocols)
                .back(injectionIntoYourEyeCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                = transitionStatementCC
                .waitForPageLoadGLAUCOMA(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        //--------------------------------------GENERAL HEALTH QUESTIONS----------------------------------------------

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartrelatedMedicalProceduresPageCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Stroke") //deselect
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());

        MostRecentHeartRelatedSurgeryProcedurePageCC mostRecentHeartRelatedSurgeryProcedurePageCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageCC());


        List<String> disqualifyQS49 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQS49) {
            Log.info("Select answer for QS49: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                    .back(mostRecentHeartRelatedSurgeryProcedurePageCC);
        }

        mostRecentHeartRelatedSurgeryProcedurePageCC
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC
                = new DoAnyOftheFollowingAdditionalDiagnosesCC();

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC);
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Seizure disorder such as epilepsy")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "180")
                .clickNextButton(new LetMeSeePageCC());

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());

        siteSelectionPageCC
                .waitForPageLoad(studyName)
                .getPID();

        siteSelectionPageCC
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(selectActionPageCC);

        if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    //.assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

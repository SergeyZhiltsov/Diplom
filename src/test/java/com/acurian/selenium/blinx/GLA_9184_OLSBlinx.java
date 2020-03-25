package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.cv_study.HeartRelatedSurgeriesProceduresPageOLS;
import com.acurian.selenium.pages.blinx.ams.cv_study.MostRecentHeartRelatedSurgeryProcedurePageOLS;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.glaucoma.*;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class GLA_9184_OLSBlinx extends BaseTest {

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_GLA9184}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("S10503(9184) 192024-093 (Allergan Glaucoma and Ocular Hypertension R99")
    public void gla9184olsBlinxTest(Site site) {

        String phoneNumber = "";
        String studyName = "";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        //----------------------------------INTRO----------------------------------------------

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA(studyName, "");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle(studyName, ""), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DoctorDiagnosedFollowingEyeConditionsOLS doctorDiagnosedFollowingEyeConditionsOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091990")
                .clickOnAnswer("Female")
                .clickNextButton(new DoctorDiagnosedFollowingEyeConditionsOLS());

        //-------------------------------FLOW LOGIC---------------------------------------------

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                doctorDiagnosedFollowingEyeConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(doctorDiagnosedFollowingEyeConditionsOLS);

        TypeOfGlaucomaOLS typeOfGlaucomaOLS = doctorDiagnosedFollowingEyeConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("Glaucoma – damage to the optic nerve caused by high eye pressure ")
                .clickNextButton(new TypeOfGlaucomaOLS());

        WhichEyeGlaucomaOrOcularHypertensionOLS whichEyeGlaucomaOrOcularHypertensionOLS = typeOfGlaucomaOLS
                .waitForPageLoad()
                .clickOnAnswer("Closed or narrow angle – less common, caused by rapid blockage of the angle between your iris and cornea")
                .clickNextButton(new WhichEyeGlaucomaOrOcularHypertensionOLS());

        PrescribedMedicationForGlaucomaOLS prescribedMedicationForGlaucomaOLS = whichEyeGlaucomaOrOcularHypertensionOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(typeOfGlaucomaOLS)
                .waitForPageLoad()
                .clickOnAnswer("Open angle – the most common type, caused by slow clogging of the angle between your iris and cornea")
                .clickNextButton(whichEyeGlaucomaOrOcularHypertensionOLS)
                .waitForPageLoad()
                .clickOnAnswer("Right eye only")
                .clickNextButton(new PrescribedMedicationForGlaucomaOLS());

        EverBeenDiagnosedFollowingEyeConditionsOLS everBeenDiagnosedFollowingEyeConditionsOLS = prescribedMedicationForGlaucomaOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(whichEyeGlaucomaOrOcularHypertensionOLS)
                .waitForPageLoad()
                .clickOnAnswer("Left eye only")
                .clickNextButton(prescribedMedicationForGlaucomaOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(whichEyeGlaucomaOrOcularHypertensionOLS)
                .waitForPageLoad()
                .clickOnAnswer("Both eyes")
                .clickNextButton(prescribedMedicationForGlaucomaOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new EverBeenDiagnosedFollowingEyeConditionsOLS());

        SurgeryOrImplantToTreatGlaucomaOLS surgeryOrImplantToTreatGlaucomaOLS = everBeenDiagnosedFollowingEyeConditionsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(prescribedMedicationForGlaucomaOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(everBeenDiagnosedFollowingEyeConditionsOLS)
                .waitForPageLoad()
                .clickOnAnswers("Macular edema – excess fluid in the back of the eye",
                        "Neovascular or “wet” age related macular degeneration – leaky blood vessels in the back of your eye",
                        "Cancer of the eye",
                        "Herpes affecting the eye",
                        "Shingles affecting the eye")
                .clickNextButton(new SurgeryOrImplantToTreatGlaucomaOLS());

        SurgeryOrImplantOnOrAroundEyePastSixMonthsOLS surgeryOrImplantOnOrAroundEyePastSixMonthsOLS = surgeryOrImplantToTreatGlaucomaOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(everBeenDiagnosedFollowingEyeConditionsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(surgeryOrImplantToTreatGlaucomaOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SurgeryOrImplantOnOrAroundEyePastSixMonthsOLS());

        InjectionIntoYourEyeOLS injectionIntoYourEyeOLS = surgeryOrImplantOnOrAroundEyePastSixMonthsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(surgeryOrImplantToTreatGlaucomaOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(surgeryOrImplantOnOrAroundEyePastSixMonthsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new InjectionIntoYourEyeOLS());

        injectionIntoYourEyeOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(surgeryOrImplantOnOrAroundEyePastSixMonthsOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(injectionIntoYourEyeOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS", site.activeProtocols)
                .back(injectionIntoYourEyeOLS)
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //--------------------------------------GENERAL HEALTH QUESTIONS----------------------------------------------

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Stroke") //deselect
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartRelatedSurgeriesProceduresPageOLS heartRelatedSurgeriesProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageOLS());

        MostRecentHeartRelatedSurgeryProcedurePageOLS mostRecentHeartRelatedSurgeryProcedurePageOLS = heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLS());


        List<String> disqualifyQS49 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQS49) {
            System.out.println("Select answer for QS49: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                    .back(mostRecentHeartRelatedSurgeryProcedurePageOLS);
        }

        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS
                = new DoAnyOftheFollowingAdditionalDiagnosesOLS();

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Seizure disorder such as epilepsy")
                .clickNextButton(approximateHeightPageOLS);

        //--------------------------------CLOSES-------------------------------------------------

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "190")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();

        (env.equals("STG") ? identificationPageOLS.waitForPageLoadSTG() : identificationPageOLS.waitForPageLoad2())
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad5(studyName + "!")
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        if(aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

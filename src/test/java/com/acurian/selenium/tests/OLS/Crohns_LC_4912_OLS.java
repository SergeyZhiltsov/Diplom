package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.UC.WhenWereYouDiagnosedWithUCPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.BiologicMedications;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crohns_LC_4912_OLS extends BaseTest {
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
        return new Object[][]{
                {Site.AUT_AMS1_4912_site},
                {Site.AUT_AMS1_4912S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("Crohns 4912 for OLS Allergan UC")
    public void Crohns_LC_4912_OLS(Site site) {
        String phoneNumber = "AUTAMS1CRN";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad("a Crohn's study", "700");
      //  Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(),
       //        dateOfBirthPageOLS.getExpectedModifiedTitle("Crohn's study", "700"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoad("a Crohn's study", "700");
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new PersonalDetails());
        IdentificationPageOLS identificationPageOLS = new IdentificationPageOLS();
        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad()
                .setDate("07012003")
                .clickOnAnswer("Male")
                .clickNextButton(new LessThan18YearsOldPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        genderPageOLS
                .waitForPageLoad()
                .setDate("07011937")
                .clickOnAnswer("Male")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        EverDiagnosedWithFollowingConditionsOLS everDiagnosedWithFollowingConditionsOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("07011990")
                .clickOnAnswer("Male")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8102", site.activeProtocols)
                .back();

        WhenWereYouDiagnosedWithUCPageOLS whenWereYouDiagnosedWithUCPageOLS = everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenWereYouDiagnosedWithUCPageOLS());

        whenWereYouDiagnosedWithUCPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8102", site.activeProtocols)
                .back();

        WhenDiagnosedWithCronsDiseaseOLS whenDiagnosedWithCronsDiseaseOLS = everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenDiagnosedWithCronsDiseaseOLS());
        AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS asPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS = whenDiagnosedWithCronsDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8103", site.activeProtocols)
                .back(whenDiagnosedWithCronsDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(new AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS());
        EverTakenAnyMedicationOLS everTakenAnyMedicationOLS = asPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTakenAnyMedicationOLS())
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8104", site.activeProtocols)
                .back(asPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new EverTakenAnyMedicationOLS());
        EverTakenSteroidsOLS everTakenSteroidsOLS = everTakenAnyMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PreviousDayGeneralWellBeingOLS())
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8105", site.activeProtocols)
                .back(everTakenAnyMedicationOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenSteroidsOLS());
        EverTakenAnyOfFollowingMedicationsOLS everTakenAnyOfFollowingMedicationsOLS = new EverTakenAnyOfFollowingMedicationsOLS();
        EverTreatedYourCronsOLS everTreatedYourCronsOLS = new EverTreatedYourCronsOLS();
        BiologicMedications biologicMedications = new BiologicMedications();
        everTakenSteroidsOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(everTakenAnyOfFollowingMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(biologicMedications)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PreviousDayGeneralWellBeingOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8110", site.activeProtocols)
                .back(biologicMedications)
                .waitForPageLoad()
                .back(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .back(everTakenAnyOfFollowingMedicationsOLS)
                .waitForPageLoad()
                .back(everTakenSteroidsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(everTakenAnyOfFollowingMedicationsOLS);
        everTakenAnyOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickNextButton(everTreatedYourCronsOLS);
        everTreatedYourCronsOLS
                .waitForPageLoad()
                .clickNextButton(biologicMedications);
        PreviousDayGeneralWellBeingOLS previousDayGeneralWellBeingOLS = new PreviousDayGeneralWellBeingOLS();
        PreviousDayAbdominalPainOLS previousDayAbdominalPainOLS = new PreviousDayAbdominalPainOLS();
        PreviousDayDiarrheaOrLiquidStoolOLS previousDayDiarrheaOrLiquidStoolOLS = new PreviousDayDiarrheaOrLiquidStoolOLS();
        ExperiensingAnyPainInJointsOLS experiensingAnyPainInJointsOLS = new ExperiensingAnyPainInJointsOLS();
        CurrentlyHaveUlcersOrSoresOLS currentlyHaveUlcersOrSoresOLS = new CurrentlyHaveUlcersOrSoresOLS();
        CurrentlyHaveAnyFollowingOLS currentlyHaveAnyFollowingOLS = new CurrentlyHaveAnyFollowingOLS();

        biologicMedications
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stelara")
                .clickNextButton(previousDayGeneralWellBeingOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8109", site.activeProtocols)
                .back(biologicMedications)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(previousDayGeneralWellBeingOLS);

        //in flare
        previousDayGeneralWellBeingOLS
                .waitForPageLoad()
                .clickOnAnswer("Very poor")
                .clickNextButton(previousDayAbdominalPainOLS)
                .waitForPageLoad()
                .clickOnAnswer("Severe")
                .clickNextButton(previousDayDiarrheaOrLiquidStoolOLS)
                .waitForPageLoad()
                .setStools("3")
                .clickNextButton(experiensingAnyPainInJointsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveUlcersOrSoresOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveAnyFollowingOLS)
                .waitForPageLoad()
                .getPID()
                .pidFromDbToLog(env)
                .flareCodeShouldMatch(env, "3");

        //back
        currentlyHaveAnyFollowingOLS
                .waitForPageLoad()
                .back(currentlyHaveUlcersOrSoresOLS)
                .waitForPageLoad()
                .back(experiensingAnyPainInJointsOLS)
                .waitForPageLoad()
                .back(previousDayDiarrheaOrLiquidStoolOLS)
                .waitForPageLoad()
                .back(previousDayAbdominalPainOLS)
                .waitForPageLoad()
                .back(previousDayGeneralWellBeingOLS);

        //not in flare
        previousDayGeneralWellBeingOLS
                .waitForPageLoad()
                .clickOnAnswer("Very well")
                .clickNextButton(previousDayAbdominalPainOLS)
                .waitForPageLoad()
                .clickOnAnswer("None")
                .clickNextButton(previousDayDiarrheaOrLiquidStoolOLS)
                .waitForPageLoad()
                .setStools("1")
                .clickNextButton(experiensingAnyPainInJointsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveUlcersOrSoresOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveAnyFollowingOLS)
                .waitForPageLoad()
                .getPID()
                .pidFromDbToLog(env)
                .flareCodeShouldMatch(env, "4");

        HashMap<String, List<String>> disqualify = new HashMap<>();
        disqualify.put("History of a bowel resection within the past 3 months", Arrays.asList(site.activeProtocols));
        disqualify.put("Colostomy", Arrays.asList(site.activeProtocols));
        disqualify.put("Ileostomy", Arrays.asList(site.activeProtocols));
        disqualify.put("An abscess in your abdomen or pelvic region (an inflamed area with collection of pus)", Arrays.asList(site.activeProtocols));
        disqualify.put("Feeding tube", Arrays.asList(site.activeProtocols));
        disqualify.put("IV (parenteral) nutrition", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualify.entrySet()) {
            System.out.println(entry.getKey());
            currentlyHaveAnyFollowingOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS8117", site.activeProtocols)
                    .back();
        }
        currentlyHaveAnyFollowingOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = new HaveYouEverExperiencedHeartRelatedMedicalCondOLS();
        SubquestionExperiencedHeartPageOLS subquestionHeartPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS())
                .waitForPageLoad();
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = new HeartrelatedMedicalProceduresPageOLS();
        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.1GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad()
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .waitForPageLoad(2, subquestionHeartPageOLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(2, answer)
                    .waitForPageLoad(3, subquestionHeartPageOLS.titleExpected3)
                    .clickOnAnswerForSubQuestion(3, answer)
                    .waitForPageLoad(4, subquestionHeartPageOLS.titleExpected4)
                    .clickOnAnswerForSubQuestion(4, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS kidneyProblemsPage = subquestionHeartPageOLS
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
               // .getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back();

        kidneyProblemsPage
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(new FollowingMentalEmotionalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(new FollowingMentalEmotionalHealthPageOLS())
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "7", "170")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS912", site.activeProtocols)
                .back(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS913", site.activeProtocols)
                .back(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(identificationPageOLS);

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());
        QualifiedFlareMonitoringAppClosePageOLS qualifiedFlareMonitoringAppClosePageOLS = new QualifiedFlareMonitoringAppClosePageOLS();
        switch (site) {
            case AUT_AMS1_4912S_site:
                siteSelectionPageOLS
                        .waitForPageLoad("a Crohn's")
                        .getPID()
                        .clickOnFacilityName(site.name)
                        .clickNextButton(new MedicalRecordsOptionPageOLS())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue with medical records")
                        .clickNextButton(new DoctorInformationCollectionPageOLS())
                        .waitForPageLoadIBD("Crohn's Disease")
                        .clickNextButton(new HS1PageOLS())
                        .waitForPageLoad()
                        .clickOkInPopUp()
                        .setSignature();
                qualifiedFlareMonitoringAppClosePageOLS
                        .waitForPageLoadCrohns()
                        .getActivationCodeCrohns()
                        .clickNextButton(new ThankYouCloseSimplePageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new AboutHealthPageOLS())
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_AMS1_4912_site:
                siteSelectionPageOLS
                        .waitForPageLoad("a Crohn's")
                        .getPID()
                        .clickOnFacilityName(site.name)
                        .clickNextButton(new MedicalRecordsOptionPageOLS())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue without medical records")
                        .clickNextButton(new QualifiedFlareMonitoringAppClosePageOLS())
                        .waitForPageLoadCrohns()
                        .getActivationCode()
                        .waitForPageLoadCrohns()
                        .clickNextButton(new ThankYouCloseSimplePageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new AboutHealthPageOLS())
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFulDERM(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
    }
}

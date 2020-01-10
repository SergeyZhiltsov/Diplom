package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns.*;
import com.acurian.selenium.pages.CC.UC.WhenWereYouDiagnosedWithUCPageCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.SubquestionHeartPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crohns_LC_4912_CC extends BaseTest {
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
//                {Site.AUT_AMS1_4912_site},
                {Site.AUT_AMS1_4912S_site}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("Crohns 4912 for CC Allergan UC")
    public void Crohns_LC_4912_CC(Site site) {
        String phoneNumber = "AUTAMS1CRN";

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a Crohn's study", "700");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
//                ("a Crohn's study", "700"), "Title is diff");
        // Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleCrons, "Title is diff");

        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());
        doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                // .waitForPageLoad2Ver()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                // .waitForPageLoad2Ver()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQCrohn()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad()
                .setMonth("Jul")
                .setDay("1")
                .setYear("2003") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                genderPageCC
                        .waitForPageLoad()
                        .setYear("1937") //Disqualify ("Age") if >= 81
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC);
        EverDiagnosedWithFollowingConditionsСС everDiagnosedWithFollowingConditionsСС = genderPageCC
                .waitForPageLoad()
                .setYear("1990")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsСС());


        NonQRtransitionPageCC nonQRtransitionPageCC = everDiagnosedWithFollowingConditionsСС
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8102", site.activeProtocols)
                .back();

        WhenWereYouDiagnosedWithUCPageCC whenWereYouDiagnosedWithUCPageCC = everDiagnosedWithFollowingConditionsСС
                .waitForPageLoad2()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenWereYouDiagnosedWithUCPageCC());

        whenWereYouDiagnosedWithUCPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8102", site.activeProtocols)
                .back();


        WhenDiagnosedWithCronsDiseaseCC whenDiagnosedWithCronsDiseaseCC = everDiagnosedWithFollowingConditionsСС
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenDiagnosedWithCronsDiseaseCC());
        AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC asPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC = whenDiagnosedWithCronsDiseaseCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8103", site.activeProtocols)
                .back(whenDiagnosedWithCronsDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(new AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC());
        EverTakenAnyMedicationCC everTakenAnyMedicationCC = asPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTakenAnyMedicationCC())
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8104", site.activeProtocols)
                .back(asPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new EverTakenAnyMedicationCC());
        EverTakenSteroidsCC everTakenSteroidsCC = everTakenAnyMedicationCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PreviousDayGeneralWellBeingCC())
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8105", site.activeProtocols)
                .back(everTakenAnyMedicationCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenSteroidsCC());
        EverTakenAnyOfFollowingMedicationsCC everTakenAnyOfFollowingMedicationsCC = new EverTakenAnyOfFollowingMedicationsCC();
        EverTreatedYourCronsCC everTreatedYourCronsCC = new EverTreatedYourCronsCC();
        BiologicMedicationsCC biologicMedicationsCC = new BiologicMedicationsCC();
        everTakenSteroidsCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(everTakenAnyOfFollowingMedicationsCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(everTreatedYourCronsCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(biologicMedicationsCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PreviousDayGeneralWellBeingCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8110", site.activeProtocols)
                .back(biologicMedicationsCC)
                .waitForPageLoad()
                .back(everTreatedYourCronsCC)
                .waitForPageLoad()
                .back(everTakenAnyOfFollowingMedicationsCC)
                .waitForPageLoad()
                .back(everTakenSteroidsCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(everTakenAnyOfFollowingMedicationsCC);
        everTakenAnyOfFollowingMedicationsCC
                .waitForPageLoad()
                .clickNextButton(everTreatedYourCronsCC);
        everTreatedYourCronsCC
                .waitForPageLoad()
                .clickNextButton(new BiologicMedicationsCC());
        PreviousDayGeneralWellBeingCC previousDayGeneralWellBeingCC = new PreviousDayGeneralWellBeingCC();
        PreviousDayAbdominalPainCC previousDayAbdominalPainCC = new PreviousDayAbdominalPainCC();
        PreviousDayDiarrheaOrLiquidStoolCC previousDayDiarrheaOrLiquidStoolCC = new PreviousDayDiarrheaOrLiquidStoolCC();
        ExperiensingAnyPainInJointsCC experiensingAnyPainInJointsCC = new ExperiensingAnyPainInJointsCC();
        CurrentlyHaveUlcersOrSoresCC currentlyHaveUlcersOrSoresCC = new CurrentlyHaveUlcersOrSoresCC();
        CurrentlyHaveAnyFollowingCC currentlyHaveAnyFollowingCC = new CurrentlyHaveAnyFollowingCC();
        biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stelara (Agent Note: ste-LAHR-uh)")
                .clickNextButton(previousDayGeneralWellBeingCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8109", site.activeProtocols)
                .back(biologicMedicationsCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(previousDayGeneralWellBeingCC);

        //in flare
        previousDayGeneralWellBeingCC
                .waitForPageLoad()
                .clickOnAnswer("Very poor")
                .clickNextButton(previousDayAbdominalPainCC)
                .waitForPageLoad()
                .clickOnAnswer("Severe")
                .clickNextButton(previousDayDiarrheaOrLiquidStoolCC)
                .waitForPageLoad()
                .setStools("3")
                .clickNextButton(experiensingAnyPainInJointsCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveUlcersOrSoresCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveAnyFollowingCC)
                .waitForPageLoad()
                .getPID()
                .pidFromDbToLog(env)
                .flareCodeShouldMatch(env, "3");

        //backflareCodeShouldMatch
        currentlyHaveAnyFollowingCC
                .waitForPageLoad()
                .back(currentlyHaveUlcersOrSoresCC)
                .waitForPageLoad()
                .back(experiensingAnyPainInJointsCC)
                .waitForPageLoad()
                .back(previousDayDiarrheaOrLiquidStoolCC)
                .waitForPageLoad()
                .back(previousDayAbdominalPainCC)
                .waitForPageLoad()
                .back(previousDayGeneralWellBeingCC);

        //not in flare
        previousDayGeneralWellBeingCC
                .waitForPageLoad()
                .clickOnAnswer("Very well")
                .clickNextButton(previousDayAbdominalPainCC)
                .waitForPageLoad()
                .clickOnAnswer("None")
                .clickNextButton(previousDayDiarrheaOrLiquidStoolCC)
                .waitForPageLoad()
                .setStools("1")
                .clickNextButton(experiensingAnyPainInJointsCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveUlcersOrSoresCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveAnyFollowingCC)
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
        disqualify.put("IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualify.entrySet()) {
            System.out.println(entry.getKey());
            currentlyHaveAnyFollowingCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(new TransitionStatementCC())
                    .waitForPageLoadWithCurves("Crohn's")
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS8117", site.activeProtocols)
                    .back();
        }
        TransitionStatementCC transitionStatementCC = currentlyHaveAnyFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoadWithCurves("Crohn's")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = new DoAnyOftheFollowingAdditionalDiagnosesCC();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = new HaveYouEverExperiencedHeartRelatedMedicalCondCC();
        SubquestionHeartPageCC subquestionHeartPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionHeartPageCC())
                .waitForPageLoad();
        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = new HeartRelatedSurgeriesProceduresPageCC();
        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.1GH: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad()
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                    .clickOnAnswerForSubQuestion(2, answer)
                    .waitForPageLoad(3, subquestionHeartPageCC.titleExpected3)
                    .clickOnAnswerForSubQuestion(3, answer)
                    .waitForPageLoad(4, subquestionHeartPageCC.titleExpected4)
                    .clickOnAnswerForSubQuestion(4, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = subquestionHeartPageCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                //     .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                //    .getPage(debugPageCC)
                //    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(new FollowingMentalEmotionalHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(new FollowingMentalEmotionalHealthPageCC())
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
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
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
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
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "7", "170")
                .clickNextButton(new LetMeSeePageCC());
        HSMedicalRecordsPageCC hsMedicalRecordsPageCC = new HSMedicalRecordsPageCC();
        SiteSelectionPageCC siteSelectionPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(identificationPageCC)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC());
        QualifiedFlareMonitoringAppClosePageCC qualifiedFlareMonitoringAppClosePageCC = new QualifiedFlareMonitoringAppClosePageCC();
        switch (site) {
            case AUT_AMS1_4912S_site:
                siteSelectionPageCC
                        .waitForPageLoad("a Crohn's study")
                        .clickOnAnswer(site.name)
                        .getPID()
                        .clickNextButton(new MedicalRecordsOptionPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue with medical records")
                        .clickNextButton(new DoctorInformationCollectionPageCC())
                        .waitForPageLoadIBD("Crohn's Disease")
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new QualifiedFlareMonitoringAppClosePageCC());

                qualifiedFlareMonitoringAppClosePageCC
                        .waitForPageLoadCrohns()
                        .getActivationCode()
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad3()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFulDERM(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_AMS1_4912_site:
                siteSelectionPageCC
                        .waitForPageLoad("a Crohn's study")
                        .clickOnAnswer(site.name)
                        .getPID()
                        .clickNextButton(new MedicalRecordsOptionPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue without medical records")
                        .clickNextButton(new QualifiedFlareMonitoringAppClosePageCC())
                        .waitForPageLoadCrohns()
                        .getActivationCode()
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad3()
                        .clickNextButton(new SelectActionPageCC())
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

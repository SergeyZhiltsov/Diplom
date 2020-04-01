package com.acurian.selenium.blinx;

import com.acurian.selenium.OLS.Crohns_3889_OLS;
import com.acurian.selenium.constants.Site;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.crohns.*;
import com.acurian.selenium.pages.blinx.ams.ibd_crohns_uc.HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.crohns.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.uc.WhenWereYouDiagnosedWithUCPageOLS;;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crohns_3889_OLSBlinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(Crohns_3889_OLSBlinx.class.getName());

    @DataProvider
    public Object[][] flare() {
        return new Object[][]{
                {true}
//                {false}
        };
    }

    @Test(dataProvider = "flare")
    @Description("Crohns_3889_OLSBlinx")
    public void Crohns_3889_OLSTest(boolean inFlare) {
        Site site = Site.AUT_CRN_3889_HS;
        String phoneNumber = "AUTAMS1IBD";
        String protocol1 = "M14_431";
        String protocol2 = "M14_433";
        String protocol3 = "M15_991";
        String protocol4 = "M16_006";
        //String studyName = "a Crohn's or colitis"; // For IBD-UC modules
        String studyName = "a Crohn's";
        String site_Indication = "a Crohn's or colitis";
        String indication = "a Crohn's Disease";
        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoadGMEGA("a Crohn's or colitis study", "700")
                .clickOnAnswer("No");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = new LessThan18YearsOldPageOLS();
                //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------

//        lessThan18YearsOldPage_OLS
//                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS);
        dateOfBirthPageOLS
                .waitForPageLoadGMEGA("a Crohn's or colitis study", "700")
                .clickOnAnswer("Yes");
        ZipCodePageOLS zipCodePageOLS = new ZipCodePageOLS();

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS = genderPageOLS
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS());
        EverDiagnosedWithFollowingConditionsOLS everDiagnosedWithFollowingConditionsOLS = new EverDiagnosedWithFollowingConditionsOLS();
        WhenDiagnosedWithCronsDiseaseOLS whenDiagnosedWithCronsDiseaseOLS = everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
//                .clickOnAnswers("Ulcerative colitis")
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
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8105", site.activeProtocols)
                .back(everTakenAnyMedicationOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenSteroidsOLS());
        EverTakenAnyOfFollowingMedicationsOLS everTakenAnyOfFollowingMedicationsOLS = new EverTakenAnyOfFollowingMedicationsOLS();
        EverTreatedYourCronsOLS everTreatedYourCronsOLS = new EverTreatedYourCronsOLS();
        BiologicMedications biologicMedicationsOLS = new BiologicMedications();
        PreviousDayGeneralWellBeingOLS previousDayGeneralWellBeingOLS = new PreviousDayGeneralWellBeingOLS();
        everTakenSteroidsOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(everTakenAnyOfFollowingMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(biologicMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("Stelara")
                .clickNextButton(previousDayGeneralWellBeingOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8110", site.activeProtocols[1], site.activeProtocols[2], site.activeProtocols[3])
                .back(biologicMedicationsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(previousDayGeneralWellBeingOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8110", site.activeProtocols)
                .back(biologicMedicationsOLS)
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
                .clickOnAnswers("None of the above")
                .clickNextButton(everTreatedYourCronsOLS);
        everTreatedYourCronsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Jakafi (ruxolitinib)")
                .clickNextButton(biologicMedicationsOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8108", site.activeProtocols[0], site.activeProtocols[1])
                .back(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xeljanz (tofacitinib)")
                .clickNextButton(biologicMedicationsOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8108", site.activeProtocols[0], site.activeProtocols[1])
                .back(everTreatedYourCronsOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(biologicMedicationsOLS);
        PreviousDayAbdominalPainOLS previousDayAbdominalPainOLS = new PreviousDayAbdominalPainOLS();
        PreviousDayDiarrheaOrLiquidStoolOLS previousDayDiarrheaOrLiquidStoolOLS = new PreviousDayDiarrheaOrLiquidStoolOLS();
        ExperiensingAnyPainInJointsOLS experiensingAnyPainInJointsOLS = new ExperiensingAnyPainInJointsOLS();
        CurrentlyHaveUlcersOrSoresOLS currentlyHaveUlcersOrSoresOLS = new CurrentlyHaveUlcersOrSoresOLS();
        CurrentlyHaveAnyFollowingOLS currentlyHaveAnyFollowingOLS = new CurrentlyHaveAnyFollowingOLS();
        biologicMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Cimzia")
                .waitForPageLoad()
                .clickNextButton(previousDayGeneralWellBeingOLS);


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
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8116", site.activeProtocols);

        //        .flareCodeShouldMatch(env, "3");

        //backflareCodeShouldMatch
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
                .clickNextButton(currentlyHaveAnyFollowingOLS);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();

        HashMap<String, String[]> options = new HashMap<>();
        options.put("History of a bowel resection within the past 3 months", site.activeProtocols);
        options.put("Colostomy", site.activeProtocols);
        options.put("Ileostomy", site.activeProtocols);
        options.put("An abscess in your abdomen or pelvic region (an inflamed area with collection of pus)", site.activeProtocols);
        options.put("Feeding tube", site.activeProtocols);
        options.put("IV (parenteral) nutrition", site.activeProtocols);
        options.put("A planned or scheduled surgery for Crohn’s disease", site.activeProtocols);
        for (Map.Entry<String, String[]> entry : options.entrySet()) {
            Log.info(entry.getKey());
            currentlyHaveAnyFollowingOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS8117", entry.getValue())
                    .back(currentlyHaveAnyFollowingOLS);
        }
        currentlyHaveAnyFollowingOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        //----------****************NEW GENERAL HEALTH Questions************************----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();

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
            Log.info("Select answer for Q12.1GH: " + answer);
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
                    .back(subquestionHeartPageOLS);
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
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back(kidneyProblemsPage);

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
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Cancer")
//                .clickNextButton(new WhenDiagnosedWithCancerOLS());
//        whenDiagnosedWithCancerOLS
//                .waitForPageLoad()
//                .clickOnAnswer("6 - 10 years ago")
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
                .back(approximateHeightPageOLS);
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
                .clickOnAnswers("Bipolar disorder")
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
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickOnAnswers("Seizure disorder such as epilepsy")
                .clickNextButton(approximateHeightPageOLS);


        //--------------Q26:  Are you currently taking a hormonal form of birth control?-----------------------
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                //WhatTypeOfLupusOLS whatTypeOfLupusOLS = approximateHeightPageOLS
                .setAll("3", "3", "39")
//                .clickNextButton(new EverDiagnosedGastroparesisOrStomachEmptyingOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new FollowingAreCommonSymptomsOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new DuringPastThreeMonthsOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new com.acurian.selenium.pages.OLS.ChronicCough.EverDiagnosedWithFollowingConditionsOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new WeightLossSurgeryPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new UseMarijuanaOrCannabisOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
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
                .setCity("Jersey City")
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedFlareMonitoringAppClosePageOLS qualifiedFlareMonitoringAppClosePageOLS = new QualifiedFlareMonitoringAppClosePageOLS();
        HS1PageOLS hs1PageOLS = new HS1PageOLS();

        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());

//                .clickNextButton(qualifiedFlareMonitoringAppClosePageOLS);
//                .clickNextButton(new QualifiedFlareMonitoringAppClosePageOLS())
//                .waitForPageLoadCrohns()
//                .getActivationCodeCrohns()
        medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoadIBD("Crohn's Disease")
                .clickNextButton(hs1PageOLS)
                .waitForPageLoad()
                .clickOkInPopUp()
                .waitForPageLoad()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
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
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        if(inFlare) {
//            qualifiedFlareMonitoringAppClosePageOLS
//                    .waitForPageLoadCrohns()
//                    .getActivationCode()
//                    .clickNextButton(thankYouCloseSimplePageOLS)
            thankYouCloseSimplePageOLS
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS())
                    .waitForPageLoad();

            if(aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
                aboutHealthPageOLS
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env);
                aboutHealthPageOLS
                        //.assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
            }
        } else {
            qualifiedFlareMonitoringAppClosePageOLS
                    .waitForPageLoadCrohns()
                    .getActivationCode()
                    .clickNextButton(thankYouCloseSimplePageOLS)
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS())
                    .waitForPageLoad();
            if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
                aboutHealthPageOLS
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        //.assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
            }
        }
    }

}

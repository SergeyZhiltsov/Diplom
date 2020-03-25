package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.*;
import com.acurian.selenium.pages.CC.IBD.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IBD_3264_CC_HS extends BaseTest {

    private static Logger Log = LogManager.getLogger(IBD_3264_CC_HS.class.getName());

    @Test(enabled = false)
    @Description("IBD 3264 for CC")
    public void IBD3264ccHS() {
        Site site = Site.AUT_IBD_3264_Site;
        String phoneNumber = "AUTAMS1IBD";
        String studyName = "Crohn's or colitis";
        String studyIndication = "Ulcerative Colitis";

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
//        dateOfBirthPageCC
//                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleIBD3264, "Title is diff"); //because upper coma

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
            //    .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back();

        IdentificationPageCC identificationPageCC =
        dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new IdentificationPageCC());
//        identificationPageCC
//                .waitForPageLoadNotQ()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
//                .back();
//        dateOfBirthPageCC
//                .setYear("1980")
//                .clickNextButton(identificationPageCC);


        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoad1()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());

        //Q2
        CrohnsDiseaseDoctorOrNursePageСС crohnsDiseaseDoctorOrNursePageСС = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new CrohnsDiseaseDoctorOrNursePageСС());
        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = crohnsDiseaseDoctorOrNursePageСС
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5702", site.activeProtocols)
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());//Check flow to Q7 and back
        whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .back(crohnsDiseaseDoctorOrNursePageСС)
                .waitForPageLoad()
                .back(diagnosedWithCrohnsPageCC);
        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis") //If selected both "Crohn's disease" AND "Ulcerative colitis", Disqualify ("Referral Priority")
                .clickNextButton(crohnsDiseaseDoctorOrNursePageСС)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5702", site.activeProtocols)
                .back(diagnosedWithCrohnsPageCC);

        //Q2
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //CC: go to Non-QR Transition Statement
                .clickNextButton(new NonQRtransitionPageCC());

        //Q29
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5702", site.activeProtocols)
                .back();

        //Q2
        UlcerativeColitisDoctorOrNursePageСС ulcerativeColitisDoctorOrNursePageСС = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis") //Skip to Q4
                .clickNextButton(new UlcerativeColitisDoctorOrNursePageСС());
        //Q4
        ulcerativeColitisDoctorOrNursePageСС
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(nonQRtransitionPageCC);
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5727", site.activeProtocols)
                .back(ulcerativeColitisDoctorOrNursePageСС)
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5727", site.activeProtocols)
                .back(ulcerativeColitisDoctorOrNursePageСС)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(whenDiagnosedCrohnsPageCC);

        PartOfDiagnosisFollowingProceduresDonePageCC partOfDiagnosisFollowingProceduresDonePageCC = whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PartOfDiagnosisFollowingProceduresDonePageCC());
        partOfDiagnosisFollowingProceduresDonePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5704", site.activeProtocols)
                .back(whenDiagnosedCrohnsPageCC)
                .waitForPageLoadULC()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(partOfDiagnosisFollowingProceduresDonePageCC);
        //Q8
        ManageYourCrohnsPageCC manageYourCrohnsPageCC = partOfDiagnosisFollowingProceduresDonePageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Disqualify ("No history of biopsy")
                .clickNextButton(new ManageYourCrohnsPageCC());
        manageYourCrohnsPageCC //Q9
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5729", site.activeProtocols)
                .back(partOfDiagnosisFollowingProceduresDonePageCC);
        partOfDiagnosisFollowingProceduresDonePageCC
                .waitForPageLoad()
                .clickOnAnswers("Endoscopy – a thin, flexible, lighted tube is inserted through the mouth. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Colonoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the entire colon (large intestine). This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(manageYourCrohnsPageCC);
        //Q9
        CrohnsDiseaseOrUlcerativeColitisFlarePageCC crohnsDiseaseOrUlcerativeColitisFlarePageCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CrohnsDiseaseOrUlcerativeColitisFlarePageCC());
        SteroidMedicationsForCrohnsCC steroidMedicationsForCrohnsCC = crohnsDiseaseOrUlcerativeColitisFlarePageCC
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5706", site.activeProtocols)
                .back(manageYourCrohnsPageCC)
                .clickOnAnswer("Yes") //Q10
                .clickNextButton(new SteroidMedicationsForCrohnsCC());
        //Q10
        FollowingMedicationsCrohnsPageCC followingMedicationsCrohnsPageCC = steroidMedicationsForCrohnsCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Choice connected with Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic

                .clickNextButton(new FollowingMedicationsCrohnsPageCC());
        //Q11
        EverTreatedCrohnOrColitisCC everTreatedCrohnOrColitisCC = followingMedicationsCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Mesalamine (Agent Note: MEZ-uh-luh-meen) medications, which include Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, and Rowasa",
                        "Azulfidine, also known as sulfasalazine (Agent Note: ay-ZULF-i-deen, sulf-uh-SAL-uh-zeen)",
                        "Colazal or Giazo, also known as balsalazide (Agent Note: COLE-uh-zal, gee-AH-zo, bal-SAL-uh-zide)",
                        "Dipentum, also known as olsalazine (Agent Note: di-PENT-um, ol-SAL-uh-zeen)",
                        "Unsure")
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTreatedCrohnOrColitisCC());
        //Q12
        BiologicMedicationsPageCC biologicMedicationsPageCC = everTreatedCrohnOrColitisCC
                .waitForPageLoad()
                .clickOnAnswers("Astagraf, Envarsus, or Prograf, also known as tacrolimus (Agent Note: tah-CRO-li-mus)",
                        "Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)",
                        "CellCept or Myfortic, also known as mycophenolate (Agent Note: my-co-FEN-o-late)",
                        "Jakafi (Agent Note: JAK-uh-fie)",
                        "Methotrexate pills or tablets, also known as Rheumatrex or Trexall (Agent Note: ROOM-uh-trex)",
                        "Methotrexate injections or shots, also known as Otrexup or Rasuvo (Agent Note: oh-TREX-up, ruh-SOO-vo)",
                        "Purixan, also known as 6-MP or mercaptopurine (Agent Note: pure-RIX-an, mer-capt-oh-PURE-een)",
                        "Rapamune, also known as sirolimus (Agent Note: RAP-uh-mune, sir-OH-li-mus)",
                        "Sandimmune, Gengraf, or Neoral, also known as cyclosporine (Agent Note: GEN-graf, NEE-oh-ral, cy-clo-SPOR-in)",
                        "Xeljanz (Agent Note: ZEL-jans)",
                        "Unsure")
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageCC());
        //Q13
        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)",
                        "Benlysta (Agent Note: ben-LIST-uh)",
                        "Cimzia (Agent Note: SIM-zee-uh)",
                        "Cosentyx (Agent Note: co-SEN-tix)",
                        "Enbrel (Agent Note: EN-brel)",
                        "Entyvio (Agent Note: en-TIV-ee-oh)",
                        "Humira (Agent Note: hue-MAIR-uh)",
                        "Kineret (Agent Note: KIN-er-et)",
                        "Orencia (Agent Note: oh-REN-see-uh)",
                        "Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)",
                        "Raptiva (Agent Note: rap-TEE-vuh)",
                        "Remicade (Agent Note: REM-ih-cade)",
                        "Rituxan (Agent Note: rih-TUX-an)",
                        "Simponi (Agent Note: SIM-po-nee)",
                        "Stelara (Agent Note: ste-LAHR-uh)",
                        "Taltz (Agent Note: TALTS)",
                        "Tysabri (Agent Note: tie-SAB-ree)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stelara (Agent Note: ste-LAHR-uh)")
                .clickNextButton(biologicMedicationsPageCC)
                .waitForPageLoadNew()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5710", site.activeProtocols)
                .back(biologicMedicationsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Remicade (Agent Note: REM-ih-cade)")
                .clickNextButton(biologicMedicationsPageCC);

//Q14	Are you currently receiving regular doses of any of the following "biologic" medications?
        biologicMedicationsPageCC
                .waitForPageLoadNew()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)",
                        "Benlysta (Agent Note: ben-LIST-uh)",
                        "Cimzia (Agent Note: SIM-zee-uh)",
                        "Cosentyx (Agent Note: co-SEN-tix)",
                        "Enbrel (Agent Note: EN-brel)",
                        "Entyvio (Agent Note: en-TIV-ee-oh)",
                        "Humira (Agent Note: hue-MAIR-uh)",
                        "Kineret (Agent Note: KIN-er-et)",
                        "Orencia (Agent Note: oh-REN-see-uh)",
                        "Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)",
                        "Raptiva (Agent Note: rap-TEE-vuh)",
                        "Remicade (Agent Note: REM-ih-cade)",
                        "Rituxan (Agent Note: rih-TUX-an)",
                        "Simponi (Agent Note: SIM-po-nee)",
                        "Stelara (Agent Note: ste-LAHR-uh)",
                        "Taltz (Agent Note: TALTS)",
                        "Tysabri (Agent Note: tie-SAB-ree)")
                .clickOnAnswers("None of the above")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC);

        //Q17
        SubquestionsIBDUlcerativeColitisPageCC subquestionsIBDUlcerativeColitisPageCC = new SubquestionsIBDUlcerativeColitisPageCC();
        HashMap<String, List<String>> flareQ17 = new HashMap<>();
        flareQ17.put("Mild symptoms, but tolerable", Arrays.asList(site.activeProtocols)); //Flare Status: "INITIAL_ACTIVE" (In Flare)
        flareQ17.put("Moderate symptoms, but managing", Arrays.asList(site.activeProtocols));
        flareQ17.put("Severe symptoms that make life difficult", Arrays.asList(site.activeProtocols));
        flareQ17.put("Unsure", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : flareQ17.entrySet()) {
            Log.info(entry.getKey());
            crohnsDiseaseOrUlcerativeColitisFlarePageCC
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(subquestionsIBDUlcerativeColitisPageCC)
                    .waitForPageLoad(1, subquestionsIBDUlcerativeColitisPageCC.titleExpected1)
                    .waitForPageLoad(2, subquestionsIBDUlcerativeColitisPageCC.titleExpected2)
                    .waitForPageLoad(3, subquestionsIBDUlcerativeColitisPageCC.titleExpected3)
                    .getPage(debugPageCC)
                    .checkStudyStatusContainsForQNumber("QS5730", "2-3")
                    .back();
        }
        crohnsDiseaseOrUlcerativeColitisFlarePageCC
                .waitForPageLoad()
                .clickOnAnswer("In remission (no symptoms, or symptoms do not interfere with daily activities)")
                .clickNextButton(subquestionsIBDUlcerativeColitisPageCC)
                .getPage(debugPageCC)
                .checkStudyStatusContainsForQNumber("QS5730", "2-4"); //Flare Status: "INITIAL_INACTIVE" (Not in Flare)

        //Q18
        HowWouldYouRateCC howWouldYouRateCC = subquestionsIBDUlcerativeColitisPageCC
                .waitForPageLoad(1, subquestionsIBDUlcerativeColitisPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionsIBDUlcerativeColitisPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionsIBDUlcerativeColitisPageCC.titleExpected3)
                .totalBowelMovements("2")
                .totalpast24hrBowelMovements("2")
                .clickOnAnswer("Yes")
                .clickNextButton(new HowWouldYouRateCC());

       //Q21.3
        HaveAnyOfTheFollowingPageCC haveAnyOfTheFollowingPageCC = howWouldYouRateCC
                .clickOnAnswers("Abdominal pain or cramps",
                        "The sensation of increased urgency for bowel movements",
                        "Loss of bowel control",
                        "More frequent loose bowel movements or diarrhea compared to the recent past",
                        "Presence of blood in your stools")
                .clickNextButton(new HaveAnyOfTheFollowingPageCC());
        //Q24
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        HashMap<String, List<String>> disqualifyQ24 = new HashMap<>();
        disqualifyQ24.put("History of a bowel resection within the past 3 months", Arrays.asList(site.activeProtocols)); //Disqualify (“Crohn’s complication or surgery”)
        disqualifyQ24.put("Colostomy", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("Ileostomy", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            Log.info(entry.getKey());
            haveAnyOfTheFollowingPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithCurves(studyName)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5733", site.activeProtocols)
                    .back();
        }
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurves(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQS59 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS"); //Kidney disease requiring dialysis is not displayed
        for (String answer: disqualifyQS59) {
            Log.info("Select answer for QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a colitis study")
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoadIBD("Ulcerative Colitis")
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "3264")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
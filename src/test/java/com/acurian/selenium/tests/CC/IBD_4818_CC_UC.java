package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.IBD.*;
import com.acurian.selenium.pages.CC.closes.*;
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

public class IBD_4818_CC_UC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] flare() {
        return new Object[][]{
                {true},
                {false}
        };
    }

    @Test(dataProvider = "flare")
    @Description("IBD 4818 for CC Allergan UC")
    public void IBD_4818_CCTest(boolean flare) {
        Site site = Site.AUT_IBD_4818_Site;
        String phoneNumber = "AUTAMS1IBD";

        String studyName = "Crohn's or colitis";
        String studyIndication = "a Ulcerative Colitis";

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
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleIBD3264, "Title is diff");

        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());
        doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back();
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .waitForPageLoad2Ver()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back();
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .waitForPageLoad2Ver()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoad1()
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
        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .waitForPageLoad()
                .setYear("1990")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());
//Q2	Have you ever been officially diagnosed by a doctor with any of the following digestive conditions?
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5702", site.activeProtocols)
                .back();
        UlcerativeColitisDoctorOrNursePageСС ulcerativeColitisDoctorOrNursePageСС = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new UlcerativeColitisDoctorOrNursePageСС());
//Q4	Was your diagnosis of ulcerative colitis made by a doctor or nurse?
        List<String> disqualifyQ4 = Arrays.asList("No", "I am unsure");
        for (String answer: disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            ulcerativeColitisDoctorOrNursePageСС
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(nonQRtransitionPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5727", site.activeProtocols[0])
                    .back();
        }
        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = ulcerativeColitisDoctorOrNursePageСС
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());
//Q6	When were you diagnosed with ulcerative colitis?
        PartOfDiagnosisFollowingProceduresDonePageCC partOfDiagnosisFollowingProceduresDonePageCC =
                whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PartOfDiagnosisFollowingProceduresDonePageCC());
        partOfDiagnosisFollowingProceduresDonePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5704", site.activeProtocols[0])
                .back(whenDiagnosedCrohnsPageCC)
                .waitForPageLoadULC()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(partOfDiagnosisFollowingProceduresDonePageCC);

        ManageYourCrohnsPageCC manageYourCrohnsPageCC = partOfDiagnosisFollowingProceduresDonePageCC
                .waitForPageLoad()
                .clickOnAnswers("Endoscopy – a thin, flexible, lighted tube is inserted through the mouth. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Colonoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the entire colon (large intestine). This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new ManageYourCrohnsPageCC());
//Q9	Have you ever taken any medications to treat or manage your Crohn's or colitis?
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
//Q10	Have you ever taken steroid medications for your Crohn's or colitis?
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

        //Q13	"Biologics" are medications that affect the body's immune system. They are usually given as an infusion (into a vein) or a shot (injection).
        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)")
                .clickNextButton(biologicMedicationsPageCC);

//Q14	Are you currently receiving regular doses of any of the following "biologic" medications?
        List<String> disqualifyQ14 = Arrays.asList("Actemra (Agent Note: ac-TEM-ruh)",
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
                "Tysabri (Agent Note: tie-SAB-ree)");
        for (String answer: disqualifyQ14) {
            System.out.println("Select answer for Q14: " + answer);
            biologicMedicationsPageCC
                    .waitForPageLoadNew()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols)
                    .back();
        }
        biologicMedicationsPageCC
                .waitForPageLoadNew()
                .clickOnAnswers("None of the above")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)//Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic
                .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols[0])
                .back(biologicMedicationsPageCC)
                .waitForPageLoadNew()
                .back(biologicMedicationsPageCC)
                .waitForPageLoad()
                .back(everTreatedCrohnOrColitisCC)
                .waitForPageLoad()
                .back(followingMedicationsCrohnsPageCC);

    //    Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic check //TODO Ghost
        followingMedicationsCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Mesalamine (Agent Note: MEZ-uh-luh-meen) medications, which include Apriso, Asacol, " +
                        "Canasa, Delzicol, Lialda, Pentasa, and Rowasa")
                .clickNextButton(everTreatedCrohnOrColitisCC)
                .waitForPageLoad()
                .clickNextButton(biologicMedicationsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC);
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkIsNoSelectedProtocolsForQuestion("QS5711", site.activeProtocols)
//                .back(biologicMedicationsPageCC)
//                .waitForPageLoadNew()
//                .back(everTreatedCrohnOrColitisCC)
//                .waitForPageLoad()
//                .back(followingMedicationsCrohnsPageCC);



//                .back(biologicMedicationsPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Tysabri")
//                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols[0],
//                        site.activeProtocols[1])
//                .back(biologicMedicationsPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .back(everTreatedCrohnOrColitisCC)
//                .clickOnAnswers("Astagraf, Envarsus, or Prograf, also known as tacrolimus (Agent Note: tah-CRO-li-mus)")
//                .clickNextButton(biologicMedicationsPageCC)
//                .clickOnAnswers("None of the above")
//                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols[0],
//                        site.activeProtocols[2], site.activeProtocols[3])
//                .back(biologicMedicationsPageCC)
//                .waitForPageLoad()
//                .back(everTreatedCrohnOrColitisCC)
//                .waitForPageLoad()
//                .back(followingMedicationsCrohnsPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Mesalamine (Agent Note: MEZ-uh-luh-meen) medications, which include Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, and Rowasa")
//                .clickNextButton(everTreatedCrohnOrColitisCC)
//                .waitForPageLoad()
//                .clickNextButton(biologicMedicationsPageCC)
//                .waitForPageLoad()
//                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols[0],
//                        site.activeProtocols[2])
//                .back(biologicMedicationsPageCC)
//                .waitForPageLoad()
//                .back(everTreatedCrohnOrColitisCC)
//                .waitForPageLoad()
//                .back(followingMedicationsCrohnsPageCC)
//                .waitForPageLoad()
//                .back(steroidMedicationsForCrohnsCC)
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(followingMedicationsCrohnsPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(everTreatedCrohnOrColitisCC)
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(biologicMedicationsPageCC)
//                .waitForPageLoad()
//                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC)
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols[0],
//                        site.activeProtocols[2])
//                .back(biologicMedicationsPageCC)
//                .waitForPageLoad()
//                .clickOnAnswers("Cimzia (Agent Note: SIM-zee-uh)")
//                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC);

        //Q17
        SubquestionsIBDShireCrohnsPageCC subquestionsIBDShireCrohnsPageCC = crohnsDiseaseOrUlcerativeColitisFlarePageCC
                .waitForPageLoad()
                .clickOnAnswer("In remission (no symptoms, or symptoms do not interfere with daily activities)")
                .clickNextButton(new SubquestionsIBDShireCrohnsPageCC());

        //Q18
        HowWouldYouRateCC howWouldYouRateCC = new HowWouldYouRateCC();
        if (flare) {
            subquestionsIBDShireCrohnsPageCC
                    .waitForPageLoad(1, subquestionsIBDShireCrohnsPageCC.titleExpected4)
                    .waitForPageLoad(2, subquestionsIBDShireCrohnsPageCC.titleExpected5)
                    .overPastWeekAvgDayBowel("1")
                    .clickOnAnswerForSubQuestion(2, "No pain or cramping")
                    .clickNextButton(howWouldYouRateCC)
                    .getPage(debugPageCC)
                    .checkStudyStatusContainsForQNumber("QS5732", "2-4");
        } else {
            subquestionsIBDShireCrohnsPageCC
                    .waitForPageLoad(1, subquestionsIBDShireCrohnsPageCC.titleExpected4)
                    .waitForPageLoad(2, subquestionsIBDShireCrohnsPageCC.titleExpected5)
                    .overPastWeekAvgDayBowel("3")
                    .clickOnAnswerForSubQuestion(2, "Moderate (interferes with my usual activity)")
                    .clickNextButton(howWouldYouRateCC)
                    .getPage(debugPageCC)
                    .checkStudyStatusContainsForQNumber("QS5732", "2-3");
        }
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
        disqualifyQ24.put("An abscess in your abdomen or pelvic region (an inflamed area with collection of pus)", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("Feeding tube", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("A planned or scheduled surgery for Crohn’s disease", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            System.out.println(entry.getKey());
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

        transitionStatementCC
                .waitForPageLoadWithCurves(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickOnAnswers("None of the above")
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
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .back();
        //debugPageCC.checkProtocolsContainsForQNumber("QS42", site.activeProtocols);
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerCC
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC.back();

        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols[0], site.activeProtocols[1])
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
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
        HSMedicalRecordsPageCC hsMedicalRecordsPageCC  = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(identificationPageCC)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a Crohn's study")
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoadIBD("Crohn's Disease")
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad();
//        if(flareStatus.equals("Not in Flare")) {
//            hsMedicalRecordsPageCC
//                    .clickNextButton(new QualifiedFlareMonitoringAppClosePageCC())
//                    .waitForPageLoad()
//                    .getActivationCode();
//        }
        hsMedicalRecordsPageCC
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }

}

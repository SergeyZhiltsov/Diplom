package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.CurrentlyHaveAnyOffFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.WhenDiagnosedCrohnsPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
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

public class IBD_4818_OLS extends BaseTest {

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
//                {false}
        };
    }

    @Test(dataProvider = "flare")
    @Description("IBD_3889_OLS")
    public void ibd4818OlsTest(boolean flare) {
        Site site = Site.AUT_AMS1_4818_Site;
        String phoneNumber = "AUTAMS1IBD";
        String studyName = "a Crohn's";
        String site_Indication = "a Crohn's or colitis";
        String indication = "a Crohn's Disease";
        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(),
                dateOfBirthPageOLS.
                getExpectedModifiedTitle("a Crohn's or colitis study", "700"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoad2Ver();
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                .setDate("09091937")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);

        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS = genderPageOLS
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS());

//Q2	Have you ever been officially diagnosed by a doctor with any of the following digestive conditions?
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5702", site.activeProtocols)
                .back();
        UlcerativeColitisDoctorOrNursePageOLS ulcerativeColitisDoctorOrNursePageOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new UlcerativeColitisDoctorOrNursePageOLS());

//Q4	Was your diagnosis of ulcerative colitis made by a doctor or nurse?
        List<String> disqualifyQ4 = Arrays.asList("No", "I am unsure");
        for (String answer: disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            ulcerativeColitisDoctorOrNursePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5727", site.activeProtocols[0])
                    .back();
        }
        WhenDiagnosedCrohnsPageOLS whenDiagnosedCrohnsPageOLS = ulcerativeColitisDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedCrohnsPageOLS());

//Q6	When were you diagnosed with ulcerative colitis?
        PartOfDiagnosisFollowingProceduresDonePageOLS partOfDiagnosisFollowingProceduresDonePageOLS =
                whenDiagnosedCrohnsPageOLS
                        .waitForPageLoadULC()
                        .clickOnAnswer("Less than 3 months ago")
                        .clickNextButton(new PartOfDiagnosisFollowingProceduresDonePageOLS());
        partOfDiagnosisFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5704", site.activeProtocols[0])
                .back(whenDiagnosedCrohnsPageOLS)
                .waitForPageLoadULC()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(partOfDiagnosisFollowingProceduresDonePageOLS);

        ManageYourCrohnsPageOLS manageYourCrohnsPageOLS = partOfDiagnosisFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Endoscopy – a thin, flexible, lighted tube is inserted through the mouth. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Colonoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the entire colon (large intestine). This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new ManageYourCrohnsPageOLS());

//Q9	Have you ever taken any medications to treat or manage your Crohn's or colitis?
        CrohnsDiseaseOrUlcerativeColitisFlarePageOLS crohnsDiseaseOrUlcerativeColitisFlarePageOLS = manageYourCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CrohnsDiseaseOrUlcerativeColitisFlarePageOLS());
        SteroidMedicationsForCrohnsOLS steroidMedicationsForCrohnsOLS = crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5706", site.activeProtocols)
                .back(manageYourCrohnsPageOLS)
                .clickOnAnswer("Yes") //Q10
                .clickNextButton(new SteroidMedicationsForCrohnsOLS());

//Q10	Have you ever taken steroid medications for your Crohn's or colitis?
        FollowingMedicationsCrohnsPageOLS followingMedicationsCrohnsPageOLS = steroidMedicationsForCrohnsOLS
                .waitForPageLoad()
                .clickOnAnswer("No") //Choice connected with Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic
                .clickNextButton(new FollowingMedicationsCrohnsPageOLS());

        //Q11
        EverTreatedCrohnOrColitisOLS everTreatedCrohnOrColitisOLS = followingMedicationsCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Mesalamine medications, which include Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, and Rowasa",
                        "Azulfidine, also known as sulfasalazine",
                        "Colazal or Giazo, also known as balsalazide",
                        "Dipentum, also known as olsalazine",
                        "Unsure")
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTreatedCrohnOrColitisOLS());

        //Q12
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = everTreatedCrohnOrColitisOLS
                .waitForPageLoad()
                .clickOnAnswers("Astagraf, Envarsus, or Prograf, also known as tacrolimus",
                        "Azasan or Imuran, also known as azathioprine",
                        "CellCept or Myfortic, also known as mycophenolate",
                        "Jakafi",
                        "Methotrexate pills or tablets, also known as Rheumatrex or Trexall",
                        "Methotrexate injections or shots, also known as Otrexup or Rasuvo",
                        "Purixan, also known as 6-MP or mercaptopurine",
                        "Rapamune, also known as sirolimus",
                        "Sandimmune, Gengraf, or Neoral, also known as cyclosporine",
                        "Xeljanz",
                        "Unsure")
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageOLS());

        //Q13	"Biologics" are medications that affect the body's immune system. They are usually given as an infusion (into a vein) or a shot (injection).
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Actemra")
                .clickNextButton(biologicMedicationsPageOLS);

         //Q14	Are you currently receiving regular doses of any of the following "biologic" medications?
        List<String> disqualifyQ14 = Arrays.asList("Actemra",
                "Benlysta",
                "Cimzia",
                "Cosentyx",
                "Enbrel",
                "Entyvio",
                "Humira",
                "Kineret",
                "Orencia",
                "Prolia or Xgeva",
                "Raptiva",
                "Remicade",
                "Rituxan",
                "Simponi",
                "Stelara",
                "Taltz",
                "Tysabri");
        for (String answer: disqualifyQ14) {
            System.out.println("Select answer for Q14: " + answer);
            biologicMedicationsPageOLS
                    .waitForPageLoadNew()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageOLS)
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols)
                    .back();
        }
        biologicMedicationsPageOLS
                .waitForPageLoadNew()
                .clickOnAnswers("None of the above")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)//Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic
                .checkProtocolsContainsForQNumber("QS5711", site.activeProtocols[0])
                .back(biologicMedicationsPageOLS)
                .waitForPageLoadNew()
                .back(biologicMedicationsPageOLS)
                .waitForPageLoad()
                .back(everTreatedCrohnOrColitisOLS)
                .waitForPageLoad()
                .back(followingMedicationsCrohnsPageOLS);

        //    Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic check //TODO Ghost
        followingMedicationsCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, or Rowasa (mesalamine)")
                .clickNextButton(everTreatedCrohnOrColitisOLS)
                .waitForPageLoad()
                .clickNextButton(biologicMedicationsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageOLS);

        //Q17
        crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .waitForPageLoad();
        SubquestionsIBDShireCrohnsPageOLS subquestionsIBDShireCrohnsPageOLS = new SubquestionsIBDShireCrohnsPageOLS();
        HowWouldYouRateOLS howWouldYouRateOLS = new HowWouldYouRateOLS();
        if (flare) {
            crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                    .clickOnAnswer("Mild symptoms, but tolerable")
                    .clickNextButton(subquestionsIBDShireCrohnsPageOLS)
                    .waitForPageLoad(1, subquestionsIBDShireCrohnsPageOLS.titleExpected6)
                    .waitForPageLoad(2, subquestionsIBDShireCrohnsPageOLS.titleExpected7)
                    .setAverageDayTotalBowelMovements("3")
                    .setPast24HoursTotalBowelMovements("10")
                    .clickOnAnswerForSubQuestion(3, "Yes")
                    .clickNextButton(howWouldYouRateOLS)
                    .waitForPageLoadSymptoms()
                    .getPage(debugPageOLS);
                    //.checkStudyStatusContainsForQNumber("QS5730", "2-3"); TODO
        } else {
            crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                    .clickOnAnswer("In remission (no symptoms, or symptoms do not interfere with daily activities)")
                    .clickNextButton(subquestionsIBDShireCrohnsPageOLS)
                    .waitForPageLoad(1, subquestionsIBDShireCrohnsPageOLS.titleExpected6)
                    .waitForPageLoad(2, subquestionsIBDShireCrohnsPageOLS.titleExpected7)
                    .setAverageDayTotalBowelMovements("1")
                    .setPast24HoursTotalBowelMovements("1")
                    .clickOnAnswerForSubQuestion(3, "Yes")
                    .clickNextButton(howWouldYouRateOLS)
                    .waitForPageLoad()
                   // .waitForPageLoadSymptoms()
                    .getPage(debugPageOLS);
                  // .checkStudyStatusContainsForQNumber("QS5730", "2-4"); //TODO
        }
        //Q21.3
        CurrentlyHaveAnyOffFollowingPageOLS currentlyHaveAnyOffFollowingPageOLS = howWouldYouRateOLS
                .clickOnAnswers("Abdominal pain or cramps",
                        "The sensation of increased urgency for bowel movements",
                        "Loss of bowel control",
                        "More frequent loose bowel movements or diarrhea compared to the recent past",
                        "Presence of blood in your stools")
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageOLS());

        //Q24
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        HashMap<String, List<String>> disqualifyQ24 = new HashMap<>();
        disqualifyQ24.put("History of a bowel resection within the past 3 months", Arrays.asList(site.activeProtocols)); //Disqualify (“Crohn’s complication or surgery”)
        disqualifyQ24.put("Colostomy", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("Ileostomy", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("Feeding tube", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("IV (parenteral) nutrition", Arrays.asList(site.activeProtocols));
        disqualifyQ24.put("A planned or scheduled surgery for Crohn’s disease", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            System.out.println(entry.getKey());
            currentlyHaveAnyOffFollowingPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS) //TODO
                   // .waitForPageLoadWithCurves(studyName) //todo
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                  //  .checkProtocolsContainsForQNumber("QS5733", site.activeProtocols)//todo
                    .back();
        }
        currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        CancerPage whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                .clickNextButton(new CancerPage());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .back();

        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .back();

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
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS.back();

       haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswerForSubQuestion(1,"Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS.back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS.back();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);



        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQS59 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS"); //Kidney disease requiring dialysis is not displayed
        for (String answer: disqualifyQS59) {
            System.out.println("Select answer for QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "7", "170")
                .clickNextButton(new IdentificationPageOLS());
        identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad("a colitis")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoadIBD4818()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}



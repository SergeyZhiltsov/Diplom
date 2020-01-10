package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.CurrentlyHaveAnyOffFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.*;
import com.acurian.selenium.pages.OLS.UC.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.*;

public class UC_4818_OLS extends BaseTest {

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
        //        {false}
        };
    }

    @Test(dataProvider = "flare")
    @Description("4818UC")
    public void uc4818OlsTest(boolean flare) {
        Site site = Site.AUT_AMS1_4818UC_Site;
        String phoneNumber = "AUTAMS1UC1";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a colitis study", "300");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
//                dateOfBirthPageOLS.
//                        getExpectedModifiedTitle("a colitis study", "300"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        dateOfBirthPageOLS
                .waitForPageLoad("a colitis study", "300");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
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
                .checkProtocolsContainsForQNumber("QS8202", site.activeProtocols)
                .back(haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS);

        WhenWereYouDiagnosedWithCrohnsPageOLS whenWereYouDiagnosedWithCrohnsPageOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenWereYouDiagnosedWithCrohnsPageOLS());

        whenWereYouDiagnosedWithCrohnsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8202", site.activeProtocols)
                .back(haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS);

        WhenWereYouDiagnosedWithUCPageOLS whenWereYouDiagnosedWithUCPageOLS = haveYouEverBeenOfficiallyDiagnosedByDoctor_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenWereYouDiagnosedWithUCPageOLS());

//Q3	When were you diagnosed with ulcerative colitis?
        AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS =
                whenWereYouDiagnosedWithUCPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Less than 3 months ago")
                        .clickNextButton(new AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS());

        asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8203", site.activeProtocols)
                .back(whenWereYouDiagnosedWithUCPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS);

//Q4	As part of your ulcerative colitis diagnosis, have you ever had any of the following procedures done?
        HaveYouEverTakenAnyMedicationsToTreatYourUCPageOLS haveYouEverTakenAnyMedicationsToTreatYourUCPageOLS =
                asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverTakenAnyMedicationsToTreatYourUCPageOLS());

        haveYouEverTakenAnyMedicationsToTreatYourUCPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8204", site.activeProtocols)
                .back(asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS);

        asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Endoscopy – a thin, flexible, lighted tube is inserted through the mouth. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Colonoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the entire colon (large intestine). This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new HaveYouEverTakenAnyMedicationsToTreatYourUCPageOLS());

//Q5	Have you ever taken any medications to treat or manage your colitis?
        HowManyBowelMovementsDidYouHaveDuringTheDayPageOLS howManyBowelMovementsDidYouHaveDuringTheDayPageOLS =
                haveYouEverTakenAnyMedicationsToTreatYourUCPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HowManyBowelMovementsDidYouHaveDuringTheDayPageOLS());

        HaveYourEverTakenSteroidMedicationsForYourUCPageOLS haveYourEverTakenSteroidMedicationsForYourUCPageOLS =
                howManyBowelMovementsDidYouHaveDuringTheDayPageOLS
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS8205", site.activeProtocols)
                .back(haveYouEverTakenAnyMedicationsToTreatYourUCPageOLS)
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYourEverTakenSteroidMedicationsForYourUCPageOLS());

//Q6	Have you ever taken steroid medications for your ulcerative colitis?
        HaveYourEverTakenFollowingMedicationsUCPageOLS haveYourEverTakenFollowingMedicationsUCPageOLS =
                haveYourEverTakenSteroidMedicationsForYourUCPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYourEverTakenFollowingMedicationsUCPageOLS());

        haveYourEverTakenFollowingMedicationsUCPageOLS
                .waitForPageLoad()
                .back(haveYourEverTakenSteroidMedicationsForYourUCPageOLS);

        haveYourEverTakenSteroidMedicationsForYourUCPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No") //Choice connected with Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic
                .clickNextButton(haveYourEverTakenFollowingMedicationsUCPageOLS);

//Q7    Have you ever taken any of the following medications for your ulcerative colitis?
        HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS =
                haveYourEverTakenFollowingMedicationsUCPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, or Rowasa (mesalamine)",
                        "Azulfidine (sulfasalazine)",
                        "Colazal or Giazo (balsalazide)",
                        "Dipentum (olsalazine)",
                        "Unsure")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS());

//Q8    Have you ever treated your ulcerative colitis with any of the following medications that suppress your immune system?
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS
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

//Q9	"Biologics" are medications that affect the body's immune system. They are usually given as an infusion (into a vein) or a shot (injection)..
        List<String> disqualifyQ9 = Arrays.asList("Actemra",
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

        for (String answer : disqualifyQ9) {
            System.out.println("Select answer for Q9: " + answer);
            biologicMedicationsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(howManyBowelMovementsDidYouHaveDuringTheDayPageOLS)
                    .waitForPageLoad()
                    .back();
        }

        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(howManyBowelMovementsDidYouHaveDuringTheDayPageOLS);

 //QS10  Ghost Question -  UC Treatment History Requirements Logic

        //DQ
        howManyBowelMovementsDidYouHaveDuringTheDayPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)//Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic
                .checkProtocolsContainsForQNumber("QS8210", site.activeProtocols)
                .back(biologicMedicationsPageOLS)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS);

        //Q - QS8 one of the listed medications
        haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran (azathioprine)")
                .clickNextButton(biologicMedicationsPageOLS)
                .waitForPageLoad()
                .clickNextButton(howManyBowelMovementsDidYouHaveDuringTheDayPageOLS);

        //QS11-QS16 + QS17 Ghost Question - UC Flare Logic
        CurrentlyHaveAnyOffFollowingPageOLS currentlyHaveAnyOffFollowingPageOLS = new CurrentlyHaveAnyOffFollowingPageOLS();
        if (flare) {
            howManyBowelMovementsDidYouHaveDuringTheDayPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("4 to 6")
                    .clickNextButton(new HowManyBowelMovementsDidYouHaveAtNightPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("4 or more")
                    .clickNextButton(new HowMuchUrgencyDidYouFeelToHaveABowelMovementPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("I had to hurry to the bathroom")
                    .clickNextButton(new DidYouHaveBloodInYourStoolPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No blood")
                    .clickNextButton(new HowWouldYouRateYourGeneralWellBeingPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Poor")
                    .clickNextButton(new AreYouExperiencingAnyPainInYourJointsPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(currentlyHaveAnyOffFollowingPageOLS);

            currentlyHaveAnyOffFollowingPageOLS
                    .getPage(debugPageOLS);
            // .checkStudyStatusContainsForQNumber("2-3"); //todo
        } else {
           howManyBowelMovementsDidYouHaveDuringTheDayPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("4 to 6")
                    .clickNextButton(new HowManyBowelMovementsDidYouHaveAtNightPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("4 or more")
                    .clickNextButton(new HowMuchUrgencyDidYouFeelToHaveABowelMovementPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("I had to hurry to the bathroom")
                    .clickNextButton(new DidYouHaveBloodInYourStoolPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No blood")
                    .clickNextButton(new HowWouldYouRateYourGeneralWellBeingPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Poor")
                    .clickNextButton(new AreYouExperiencingAnyPainInYourJointsPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(currentlyHaveAnyOffFollowingPageOLS);

            currentlyHaveAnyOffFollowingPageOLS
                    .getPage(debugPageOLS);
                  // .checkStudyStatusContainsForQNumber("QS5730", "2-4"); //TODO*/
        }

//Q18 - Do you currently have any of the following?
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        HashMap<String, List<String>> disqualifyQ18 = new HashMap<>();
        disqualifyQ18.put("History of a bowel resection within the past 3 months", Arrays.asList(site.activeProtocols)); //Disqualify (“Crohn’s complication or surgery”)
        disqualifyQ18.put("Colostomy", Arrays.asList(site.activeProtocols));
        disqualifyQ18.put("Ileostomy", Arrays.asList(site.activeProtocols));
        disqualifyQ18.put("Feeding tube", Arrays.asList(site.activeProtocols));
        disqualifyQ18.put("IV (parenteral) nutrition", Arrays.asList(site.activeProtocols));

        HashSet<String> disqualify7191 = new HashSet<>(); //options that cause DQ 7191->skip to end of module
    //    disqualify7191.add("Partial or Total colectomy"); //todo after 7191 activation
    //    disqualify7191.add("Colostomy");
    //    disqualify7191.add("Ileostomy");

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = new WeightLossSurgeryPageOLS();

        for (Map.Entry<String, List<String>> entry : disqualifyQ18.entrySet()) {
            System.out.println(entry.getKey());
            currentlyHaveAnyOffFollowingPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey());
            if (/*disqualify7191.contains(entry.getKey())*/true) {
                currentlyHaveAnyOffFollowingPageOLS
                        .waitForPageLoad()
                        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS8218", site.activeProtocols)
                        .back();
            } else {
                currentlyHaveAnyOffFollowingPageOLS
                        .waitForPageLoad()
                        .clickNextButton(weightLossSurgeryPageOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS8218", site.activeProtocols)
                        .back();
            }
        }

 /*               currentlyHaveAnyOffFollowingPageOLS //todo after 7191 activation
                currentlyHaveAnyOffFollowingPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(weightLossSurgeryPageOLS);
//QS19 - Have you ever had any of the following types of bariatric or weight loss surgery?
                ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                        .clickOnAnswers("Gastric bypass", "Gastric sleeve or sleeve gastrectomy", "Duodenal switch",
                                "Lap band or gastric banding", "Gastric balloon")
                        .clickNextButton(new ProcedureForWeightLossPageOLS());

//QS20 - When was the last time that you had a surgery or medical procedure for weight loss?
                procedureForWeightLossPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Less than 3 months ago")
                        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                        .waitForPageLoad()
                        .back(procedureForWeightLossPageOLS)
                        .waitForPageLoad()
                        .back(weightLossSurgeryPageOLS);

                weightLossSurgeryPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                        .waitForPageLoad();*/


        currentlyHaveAnyOffFollowingPageOLS //todo delete after 7191 activation
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


//GH
            WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                    .clickNextButton(new WhenDiagnosedWithCancerOLS());

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
                    .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
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
                    .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
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
            for (String answer : disqualifyQS59) {
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
                    .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new RequirePassDrugTestOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new IdentificationPageOLS());

            SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                    .waitForPageLoad()
                    .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                            "9999999999", site.zipCode)
                    .clickNextButton(new SiteSelectionPageOLS());
        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                    .waitForPageLoad("a colitis")
                    .getPID()
                    .clickOnFacilityName(site.name)
//                    .clickNextButton(new QualifiedClose2PageOLS())
//                    .waitForPageLoadCrohns4818()
//                    .clickNextButton(new ThankYouCloseSimplePageOLS())
//                    .waitForPageLoad()
//                    .clickNextButton(new AboutHealthPageOLS());
                    .clickNextButton(new MedicalRecordsOptionPageOLS());
            DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = medicalRecordsOptionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("Continue with medical records")
                    .clickNextButton(new DoctorInformationCollectionPageOLS());
            HS1PageOLS hs1PageOLS = doctorInformationCollectionPageOLS
                    .waitForPageLoadIBD("Ulcerative Colitis")
                    .clickNextButton(new HS1PageOLS());
            ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = hs1PageOLS
                    .waitForPageLoad()
                    .clickOkInPopUp()
                    .waitForPageLoad()
                    .setSignature()
                    .waitToClickNext()
                    .getPage(new ThankYouCloseSimplePageOLS());
            AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS());
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo, "4818");
        }
    }




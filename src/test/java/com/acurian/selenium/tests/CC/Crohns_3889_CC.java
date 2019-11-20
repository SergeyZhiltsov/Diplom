package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
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

public class Crohns_3889_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "Flare status")
    public Object[][] flareStatus() {
        return new Object[][]{
                //  {"Not in Flare"},
                {"In Flare"}
        };
    }

    @Test(dataProvider = "Flare status")
    @Description("Crohns 3485 for CC")
    public void Crohns_3889_CC(String flareStatus) {
        Site site = Site.AUT_CRN_3889_HS;
        String phoneNumber = "AUTAMS1CRN";

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
                .waitForPageLoad("a Crohn's study", "700");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
//                ("a Crohn's study", "700"), "Title is diff");

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
//                .clickNextButton(new LessThan18YearsOldPageCC());
//        lessThan18YearsOldPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
//                .back();
//        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
//                .waitForPageLoad("a Crohn's study", "700")
//                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        EverDiagnosedWithFollowingConditionsСС everDiagnosedWithFollowingConditionsСС = genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsСС());

        WhenDiagnosedWithCronsDiseaseCC whenDiagnosedWithCronsDiseaseCC = everDiagnosedWithFollowingConditionsСС
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickOnAnswers("Ulcerative colitis")
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
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(biologicMedicationsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8108", site.activeProtocols[0], site.activeProtocols[1])
                .back(everTreatedYourCronsCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xeljanz (Agent Note: ZEL-jans)")
                .clickNextButton(biologicMedicationsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8108", site.activeProtocols[0], site.activeProtocols[1])
                .back(everTreatedYourCronsCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(biologicMedicationsCC);
        PreviousDayGeneralWellBeingCC previousDayGeneralWellBeingCC = new PreviousDayGeneralWellBeingCC();
        PreviousDayAbdominalPainCC previousDayAbdominalPainCC = new PreviousDayAbdominalPainCC();
        PreviousDayDiarrheaOrLiquidStoolCC previousDayDiarrheaOrLiquidStoolCC = new PreviousDayDiarrheaOrLiquidStoolCC();
        ExperiensingAnyPainInJointsCC experiensingAnyPainInJointsCC = new ExperiensingAnyPainInJointsCC();
        CurrentlyHaveUlcersOrSoresCC currentlyHaveUlcersOrSoresCC = new CurrentlyHaveUlcersOrSoresCC();
        CurrentlyHaveAnyFollowingCC currentlyHaveAnyFollowingCC = new CurrentlyHaveAnyFollowingCC();
        biologicMedicationsCC
                .clickOnAnswers("Cimzia (Agent Note: SIM-zee-uh)")
                .waitForPageLoad()
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
                .clickNextButton(currentlyHaveAnyFollowingCC);
        //.waitForPageLoad()
        //.flareCodeShouldMatch(env, "11");

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
                .clickNextButton(currentlyHaveAnyFollowingCC);
        //.waitForPageLoad()
        //        .flareCodeShouldMatch(env, "3");





        HashMap<String, List<String>> disqualify = new HashMap<>();
        disqualify.put("History of a bowel resection within the past 3 months", Arrays.asList(site.activeProtocols));
        disqualify.put("Colostomy", Arrays.asList(site.activeProtocols));
        disqualify.put("Ileostomy", Arrays.asList(site.activeProtocols));
        disqualify.put("An abscess in your abdomen or pelvic region (an inflamed area with collection of pus)", Arrays.asList(site.activeProtocols));
        disqualify.put("Feeding tube", Arrays.asList(site.activeProtocols));
        disqualify.put("IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)", Arrays.asList(site.activeProtocols));
        disqualify.put("A planned or scheduled surgery for Crohn’s disease", Arrays.asList(site.activeProtocols));
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

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = currentlyHaveAnyFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ThankYouCrohnsPage_CC())
                .waitForPageLoad()
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
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickOnAnswers("Mini-Stroke or TIA")
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
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoadIBD("Crohn's Disease")
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad();
        if(flareStatus.equals("Not in Flare")) {
            hsMedicalRecordsPageCC
                    .clickNextButton(new QualifiedFlareMonitoringAppClosePageCC())
                    .waitForPageLoad()
                    .getActivationCode();
        }
        hsMedicalRecordsPageCC
                .clickNextButton(new QualifiedFlareMonitoringAppClosePageCC())
                .waitForPageLoadCrohns()
                .getActivationCode()
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
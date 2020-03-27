package com.acurian.selenium.OLS;

import com.acurian.selenium.CC.PSA_5071_CC;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ADG_4357.*;
import com.acurian.selenium.pages.OLS.Crohns_3485.CurrentlyHaveAnyOffFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CurrentlyTreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_OLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.Vaccine.DRSOLS;
import com.acurian.selenium.pages.OLS.Vaccine.DirectSheduleVaccOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.blinx.ams.shared.DRSBlinx;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.*;

public class GAST_4357_OLS extends BaseTest {

    private static Logger Log = LogManager.getLogger(GAST_4357_OLS.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_GAS4357ds, true},
                {Site.AUT_GAST4357_site, false},
                {Site.AUT_GAST4357_site, true},
                {Site.AUT_GAST4357S_site, true}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("GAST 4357 OLS (Allergan Diabetic Gastroparesis)")
    public void gast4357olsTest(final Site site, boolean inFlare) {
        final String phoneNumber = "AUTAMSGAST";
        String studyName = "a gastroparesis study for people with digestion problems";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName, "500");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle(studyName, "500"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName, "500")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

//            GenderPageOLS genderPageOLS = personalDetails
//                    .waitForPageLoad()
//                    .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
//                    .clickNextButton(new GenderPageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        EverDiagnosedGastroparesisOrStomachEmptyingOLS everDiagnosedGastroparesisOrStomachEmptyingOLS = new EverDiagnosedGastroparesisOrStomachEmptyingOLS();

        //Q2
        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No diabetes")
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS);
        everDiagnosedGastroparesisOrStomachEmptyingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7202", site.activeProtocols)
                .back(diagnosedAnyTypeOfDiabetesPageOLS);
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Continue to Q3
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        //Q3
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes") //Disqualify ("No diagnosis of diabetes")
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS);
        everDiagnosedGastroparesisOrStomachEmptyingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7203", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);
//                    .clickOnAnswer("High blood sugar only")
//                    .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS7203", site.activeProtocols)
//                    .back(whatKindOfDiabetesPageOLS);
        //Q4
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)") //If selected "Type 2 diabetes", go to Q4
                .clickNextButton(new WithType2DiabetesPageOLS());

        //Q4
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS =
                new CurrentlyTreatingYourDiabetesPageOLS();
        List<String> disqualify = Arrays.asList("Within the past 2 months", "3 - 6 months ago", "7 - 11 months ago",
                "1 to less than 5 years ago");
        for (String answer : disqualify) {
            Log.info("Select answer for Q4: " + answer);
            withType2DiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer) //skip to Q7
                    .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7204", site.activeProtocols)
                    .back(withType2DiabetesPageOLS);
        }
        WithType1DiabetesPageOLS withType1DiabetesPageOLS = withType2DiabetesPageOLS
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS)
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)") //If selected "Type 1 diabetes", go to Q5
                .clickNextButton(new WithType1DiabetesPageOLS());

        //Q5

        for (String answer : disqualify) {
            Log.info("Select answer for Q5: " + answer);
            withType1DiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer) //skip to Q7
                    .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS)
                    //        .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS())
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7205", site.activeProtocols)
                    .back(withType1DiabetesPageOLS);
        }
        HowLongAgoDiagnosedDiabetesPageOLS howLongAgoDiagnosedDiabetesPageOLS = withType1DiabetesPageOLS
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS)
                .clickOnAnswer("Unsure") //If selected "Unsure", go to Q6
                .clickNextButton(new HowLongAgoDiagnosedDiabetesPageOLS());
        //Q6
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS1 = new CurrentlyTreatingYourDiabetesPageOLS();
        for (String answer : disqualify) {
            Log.info("Select answer for Q6: " + answer);
            howLongAgoDiagnosedDiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer) //skip to Q7
                    .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7206", site.activeProtocols)
                    .back(howLongAgoDiagnosedDiabetesPageOLS);
        }
        //Q6
        howLongAgoDiagnosedDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS);
        //Q7
// ---- START Q9 Ghost Question - Gastroparesis Logic check ----
        FollowingAreCommonSymptomsOLS followingAreCommonSymptomsOLS = everDiagnosedGastroparesisOrStomachEmptyingOLS
                .waitForPageLoad()
                .clickOnAnswer("No") //Will DQ in Q9
                .clickNextButton(new FollowingAreCommonSymptomsOLS());
        //Q8
        followingAreCommonSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Will DQ in Q9 //Skip to Q11
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS1)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7209", site.activeProtocols)
                .back();


//        followingAreCommonSymptomsOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Nausea or feeling sick to your stomach",
//                        "Bloating")
//                .clickNextButton(new HowLongBeenHavingThoseSymptomsPageOLS())
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS7209", site.activeProtocols)
//                .back(followingAreCommonSymptomsOLS);

        HowLongBeenHavingThoseSymptomsPageOLS howLongBeenHavingThoseSymptomsPageOLS = followingAreCommonSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswers("Vomiting or throwing up",
                        "Bloating") //Deselect Bloating
                .clickNextButton(new HowLongBeenHavingThoseSymptomsPageOLS());

//Q10
        howLongBeenHavingThoseSymptomsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months or less")
                //.clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7222", site.activeProtocols)
                .back();
        ThrownUpVomitedPastMonthPageOLS thrownUpVomitedPastMonthPageOLS = howLongBeenHavingThoseSymptomsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 to 5 months")
                .clickNextButton(new ThrownUpVomitedPastMonthPageOLS());

        //Q11
        KindOfTestsOrEvaluationHaveYouHadPageOLS kindOfTestsOrEvaluationHaveYouHadPageOLS = thrownUpVomitedPastMonthPageOLS
                .waitForPageLoad()
                .clickOnAnswer("None, I have not vomited in the past month")// not in flare
                .clickNextButton(new KindOfTestsOrEvaluationHaveYouHadPageOLS());
        if (inFlare) {
            kindOfTestsOrEvaluationHaveYouHadPageOLS
                    .waitForPageLoad()
                    .back();
            thrownUpVomitedPastMonthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("1 time")// in flare
                    .clickNextButton(kindOfTestsOrEvaluationHaveYouHadPageOLS);
        }

        GastroparesisSymptomsCausedByFollowingPageOLS gastroparesisSymptomsCausedByFollowingPageOLS = kindOfTestsOrEvaluationHaveYouHadPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new GastroparesisSymptomsCausedByFollowingPageOLS());

        OpioidOrNarcoticMedicationPageOLS opioidOrNarcoticMedicationPageOLS = gastroparesisSymptomsCausedByFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OpioidOrNarcoticMedicationPageOLS());

        CurrentlyHaveAnyOffFollowingPageOLS currentlyHaveAnyOffFollowingPageOLS = opioidOrNarcoticMedicationPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, every day")
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageOLS());


        //Q15
        SurgeriesPerformedPageOLS surgeriesPerformedPageOLS = new SurgeriesPerformedPageOLS();
        List<String> disqualifyQ12 = Arrays.asList("IV nutrition or Parenteral feeding – liquid food provided through a tube into your veins",
                "Nasogastric tube – a tube that goes in your nose and then enters your stomach to give you food or help with symptoms",
                "Enterostomy tube – a tube that goes through your skin directly into your stomach to provide you food or help with symptoms");
        for (String answer : disqualifyQ12) {
            Log.info("Select answer for Q12: " + answer);
            currentlyHaveAnyOffFollowingPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7212", site.activeProtocols)
                    .back();
        }
        currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(surgeriesPerformedPageOLS);
        //Q13
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = new WeightLossSurgeryPageOLS();
        List<String> disqualifyQ13 = Arrays.asList("Gastric pacemaker placement",
                "Gastrectomy or removal of part of the stomach", "Fundoplication", "Vagotomy");
        for (String answer : disqualifyQ13) {
            Log.info("Select answer for Q13: " + answer);
            surgeriesPerformedPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7213", site.activeProtocols)
                    .back(surgeriesPerformedPageOLS);
        }
        surgeriesPerformedPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(weightLossSurgeryPageOLS);
        //Q14
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = new ProcedureForWeightLossPageOLS();
        List<String> disqualifyQ14 = Arrays.asList("Gastric bypass", "Gastric sleeve or sleeve gastrectomy",
                "Duodenal switch", "Lap band or gastric banding", "Gastric balloon",
                "I had a weight loss surgery, but I am unsure which type");
        for (String answer : disqualifyQ14) {
            Log.info("Select answer for Q14: " + answer);
            weightLossSurgeryPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(procedureForWeightLossPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7214", site.activeProtocols)
                    .back(weightLossSurgeryPageOLS);
        }

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad();

//-------------------New GENERAL HEALTH---------------------------
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
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
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .back();
        //Q2: QS38
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("ADHD or attention deficit hyperactivity disorder") //If exclusively selected, skip to Q24)
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        //Check flow logic for Q2
        //Q4: QS40
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());

        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS); //Back to Q2: QS38

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        //Q6: QS42
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
        //Q10: QS45
        whichTypeOfHeadacheDoYouGetOLS
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        //Q11: QS46
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS()); //Display Q12.1: QS47A
        //Q12.1 - 12.4:
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionExperiencedHeartPageOLS);

        //Q12.1
        HashMap<String, List<String>> dqQ121 = new HashMap<>();
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = new HeartrelatedMedicalProceduresPageOLS();
        dqQ121.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 3")
        dqQ121.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : dqQ121.entrySet()) {
            Log.info(entry.getKey());
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, entry.getKey())
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageOLS);
        }
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageOLS);

        //Q12.2
        HashMap<String, List<String>> dqQ122 = new HashMap<>();
        dqQ122.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 3")
        dqQ122.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : dqQ122.entrySet()) {
            Log.info(entry.getKey());
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, entry.getKey())
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageOLS);
        }
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        //Q48
        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());

        //QS49
        HashMap<String, List<String>> dqQ14 = new HashMap<>();
        dqQ14.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent CV procedure - Temp 3")
        dqQ14.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : dqQ14.entrySet()) {
            Log.info(entry.getKey());
            mostRecentHeartProcedurePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                    .back(mostRecentHeartProcedurePageOLS);
        }
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .back(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        DoYouTakeAnyMedicationsControlHypertension_OLS doYouTakeAnyMedicationsControlHypertension_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("High blood pressure or hypertension")
                        .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_OLS());
        //Q15: QS50
        doYouTakeAnyMedicationsControlHypertension_OLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());

        //Q8: QS44
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Acid reflux, heartburn, or GERD (gastroesophageal reflux disease)",
                        "Crohn's disease",
                        "Ulcerative colitis",
                        "Gastroparesis, or delayed gastric emptying",
                        "IBS, or irritable bowel syndrome")
                .clickOnAnswers("None of the above");
        //Q5: QS41
        HashMap<String, List<String>> dqQ8 = new HashMap<>();
        dqQ8.put("Crohn's disease", Arrays.asList(site.activeProtocols)); //Disqualify ("Crohn's") if selected "Crohn's disease" here OR in IBD Q2
        dqQ8.put("Ulcerative colitis", Arrays.asList(site.activeProtocols)); //Disqualify ("Ulcerative colitis") if selected "Ulcerative colitis" here OR in IBD Q2
        for (Map.Entry<String, List<String>> entry : dqQ8.entrySet()) {
            Log.info(entry.getKey());
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back(whichOfFollowingDigestiveConditionPageOLS);
        }
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //Q16: QS51
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS);
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        //Q18: QS53
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
        //Q19: QS54
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("Seizure disorder, such as epilepsy")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                        .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WomenHealthConditionsOLS womenHealthConditionsOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WomenHealthConditionsOLS());
        //Q22: QS57
        womenHealthConditionsOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        //Flow for Q2: QS38 was checked

        //Q24: QS59
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis C",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS)",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia",
                        "None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());
        //Q28: QS60
        approximateHeightPageOLS
                .waitForPageLoad()
                .back();
        //Q24: QS59
        HashMap<String, List<String>> disqualifyQ24 = new HashMap<>();
        disqualifyQ24.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(site.activeProtocols)); //Disqualify ("Cancer <= 5 years")
        disqualifyQ24.put("Cirrhosis", Arrays.asList(site.activeProtocols)); //Disqualify ("Cirrhosis")
        disqualifyQ24.put("Hepatitis B", Arrays.asList(site.activeProtocols)); //Disqualify ("HBV")
        disqualifyQ24.put("Hepatitis C", Arrays.asList(site.activeProtocols)); //Disqualify ("HCV")
        disqualifyQ24.put("HIV or AIDS", Arrays.asList(site.activeProtocols)); //Disqualify ("HIV")
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            Log.info(entry.getKey());
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Seizure disorder such as epilepsy") //Disqualify ("Seizure disorder")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        IdentificationPageOLS identificationPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("3", "6", "100")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());
        siteSelectionPageOLS
                .waitForPageLoad1("a gastroparesis study for people with digestion problems!")
                .getPID();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        if (inFlare) {
            siteSelectionPageOLS
                    .clickOnFacilityName(site.name);
            switch (site) {
                case AUT_GAST4357_site: //1R
                    QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                            .clickNextButton(new QualifiedClose2PageOLS());
                    ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                            .waitForPageLoad()
                            .clickNextButton(new ThankYouCloseSimplePageOLS());
                    thankYouCloseSimplePageOLS
                            .waitForPageLoad()
                            .clickNextButton(aboutHealthPageOLS).waitForPageLoad();
                    if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
                        aboutHealthPageOLS
                                .waitForPageLoad()
                                .pidFromDbToLog(env)
                                .childPidFromDbToLog(env)
                                .dispoShouldMatch(site.dispo, site.dispo);
                    }
                    break;
                case AUT_GAST4357S_site: //41C
                    QualifiedClose2PageOLS qualifiedClose2PageOLS2 = siteSelectionPageOLS
                            .clickNextButton(new QualifiedClose2PageOLS());
                    ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS2 = qualifiedClose2PageOLS2
                            .waitForPageLoad()
                            .clickNextButton(new ThankYouCloseSimplePageOLS());
                    thankYouCloseSimplePageOLS2
                            .waitForPageLoad()
                            .clickNextButton(aboutHealthPageOLS)
                            .waitForPageLoad();
                    if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
                        aboutHealthPageOLS
                                .waitForPageLoad()
                                .pidFromDbToLog(env)
                                .getRadiantDbToLog(env)
                                .getAnomalyDbToLog(env)
                                .childPidFromDbToLog(env)
                                .dispoShouldMatch(site.dispo, site.dispo);
                    }
                    break;


                case AUT_GAS4357ds: {
                    try {
                        QualifiedClose2PageOLS qualifiedClose2PageOLS3 = new QualifiedClose2PageOLS();
                        DRSBlinx dRSBlinx = new DRSBlinx();
                        DirectSheduleVaccOLS directSheduleVaccOLS = new DirectSheduleVaccOLS();
                        DRSOLS scedulerOLS = new DRSOLS();
                        siteSelectionPageOLS
                                .clickNextButton(directSheduleVaccOLS);
                        if (env.equals("PRD")) {
                            directSheduleVaccOLS
                                    .waitForPageLoad();
                        }
                        if (env.equals("STG")) {
                            qualifiedClose2PageOLS3
                                    .waitForPageLoad();
                        }
                        directSheduleVaccOLS
                                .clickSheduleBtnBlinx(dRSBlinx);
                        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
                        getDriver().switchTo().window(tabs.get(1));
                        dRSBlinx
                                .waitForPageLoadBlinx()
                                .clickOnDay()
                                .clickOnTime()
                                .clickOnNext()
                                .waitForPageLoadClientDetails()
                                .dateCheck()
                                .startsAtCheck()
                                .serviceProviderCheck();
                        getDriver().switchTo().window(tabs.get(0));
                        if (env.equals("PRD")) {
                            directSheduleVaccOLS
                                    .waitForPageLoad();
                        }
                        if (env.equals("STG")) {
                            directSheduleVaccOLS
                                    .waitForPageLoadSTG();
                        }
                        directSheduleVaccOLS
                                .clickNextButton(new QualifiedClose2PageOLS())
                                .waitForPageLoad()
                                .clickNextButton(new ThankYouCloseSimplePageOLS())
                                .waitForPageLoad()
                                .clickNextButton(aboutHealthPageOLS)
                                .waitForPageLoad();
                        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
                            aboutHealthPageOLS
                                    .waitForPageLoad()
                                    .pidFromDbToLog(env)
                                    .childPidFromDbToLog(env)
                                    .dispoShouldMatch(site.dispo, site.dispo);
                        }
                }catch(TimeoutException e){
                    siteSelectionPageOLS.textToAttachment("No appointpments");
                }
            }
        }
        }else {


            siteSelectionPageOLS
                    .clickNextButton(new QualifiedCloseGastroPageOLS())
                    .waitForPageLoad()
                    .clickNextButton(new ThankYouCloseSimplePageOLS())
                    .waitForPageLoad()
                    .clickNextButton(aboutHealthPageOLS)
                    .waitForPageLoad();
            if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo)
                        .flareCodeShouldMatch(env, inFlare ? "3" : "4");
            }
        }
    }
}
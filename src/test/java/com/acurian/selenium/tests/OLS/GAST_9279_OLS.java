package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ADG_4357.*;
import com.acurian.selenium.pages.OLS.ChronicCough.EverDiagnosedWithFollowingConditionsOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.CurrentlyHaveAnyOffFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CurrentlyTreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.GERD.CurrentlySufferOfAnyOfFollowingOLS;
import com.acurian.selenium.pages.OLS.GERD.DuringPastThreeMonthsOLS;
import com.acurian.selenium.pages.OLS.GERD.UseMarijuanaOrCannabisOLS;
import com.acurian.selenium.pages.OLS.GERD.WhatTypeOfSurgeryDidYouHave_OLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_OLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GAST_9279_OLS extends BaseTest {


    @Test
    @Description("GAST 9279 OLS (Takeda Gastroparesis - Diagnosed)")
    public void gast9279OLSTest(){

        String phoneNumber = "AUTAMSGAST";
        String studyName = "a gastroparesis study for people with digestion problems";
        Site site = Site.AUT_G_9279;
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

//        GenderPageOLS genderPageOLS = personalDetails
//                .waitForPageLoad()
//                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
//                .clickNextButton(new GenderPageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("01011934")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("09091980")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        EverDiagnosedGastroparesisOrStomachEmptyingOLS everDiagnosedGastroparesisOrStomachEmptyingOLS = new EverDiagnosedGastroparesisOrStomachEmptyingOLS();

        //Q2
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Continue to Q3
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes") //Disqualify ("No diagnosis of diabetes")
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS);
        everDiagnosedGastroparesisOrStomachEmptyingOLS
                .waitForPageLoad()
                .back();

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)") //If selected "Type 2 diabetes", go to Q4
                .clickNextButton(new WithType2DiabetesPageOLS())
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)") //If selected "Type 1 diabetes", go to Q5
                .clickNextButton(new WithType1DiabetesPageOLS())
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageOLS);

        HowLongAgoDiagnosedDiabetesPageOLS howLongAgoDiagnosedDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure") //If selected "Unsure", go to Q6
                .clickNextButton(new HowLongAgoDiagnosedDiabetesPageOLS());

        howLongAgoDiagnosedDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 to less than 5 years ago") //in this place we DQ for RLM_MD_01/02 protocols
                .clickNextButton(everDiagnosedGastroparesisOrStomachEmptyingOLS);

        //Q7
// ---- START Q9 Ghost Question - Gastroparesis Logic check ----
        FollowingAreCommonSymptomsOLS followingAreCommonSymptomsOLS = everDiagnosedGastroparesisOrStomachEmptyingOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingAreCommonSymptomsOLS());

        followingAreCommonSymptomsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7221", site.activeProtocols)
                .back();

        everDiagnosedGastroparesisOrStomachEmptyingOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(followingAreCommonSymptomsOLS);

        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = new CurrentlyTreatingYourDiabetesPageOLS();

        followingAreCommonSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7208", site.activeProtocols)
                .back();

        HowLongBeenHavingThoseSymptomsPageOLS howLongBeenHavingThoseSymptomsPageOLS = followingAreCommonSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswers("Vomiting or throwing up")
                .clickNextButton(new HowLongBeenHavingThoseSymptomsPageOLS());

        //Q10
        howLongBeenHavingThoseSymptomsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 months or less")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
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
                .clickOnAnswer("None, I have not vomited in the past month")
                .clickNextButton(new KindOfTestsOrEvaluationHaveYouHadPageOLS());

        GastroparesisSymptomsCausedByFollowingPageOLS gastroparesisSymptomsCausedByFollowingPageOLS = kindOfTestsOrEvaluationHaveYouHadPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new GastroparesisSymptomsCausedByFollowingPageOLS());

        OpioidOrNarcoticMedicationPageOLS opioidOrNarcoticMedicationPageOLS = new OpioidOrNarcoticMedicationPageOLS();

        List<String> DQ13 = Arrays.asList("Surgery", "Parkinson’s disease", "Radiation therapy",
                "Crohn’s disease", "Chagas disease", "Cannabinoid hyperemesis syndrome", "Cyclic vomiting syndrome",
                "Rumination syndrome");
        for (String answer: DQ13) {
            System.out.println("Select answer for Q13: " + answer);
            gastroparesisSymptomsCausedByFollowingPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(opioidOrNarcoticMedicationPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7224", site.activeProtocols)
                    .back();
        }

        gastroparesisSymptomsCausedByFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(opioidOrNarcoticMedicationPageOLS);

        CurrentlyHaveAnyOffFollowingPageOLS currentlyHaveAnyOffFollowingPageOLS = opioidOrNarcoticMedicationPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, every day")
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageOLS());

        currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7225", site.activeProtocols)
                .back();

        opioidOrNarcoticMedicationPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, but not every day")
                .clickNextButton(currentlyHaveAnyOffFollowingPageOLS);

        //Q15
        SurgeriesPerformedPageOLS surgeriesPerformedPageOLS = new SurgeriesPerformedPageOLS();
        List<String> disqualifyQ15 = Arrays.asList("IV nutrition or Parenteral feeding – liquid food provided through a tube into your veins",
                "Nasogastric tube – a tube that goes in your nose and then enters your stomach to give you food or help with symptoms",
                "Enterostomy tube – a tube that goes through your skin directly into your stomach to provide you food or help with symptoms");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15: " + answer);
            currentlyHaveAnyOffFollowingPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7212", site.activeProtocols)
                    .back(currentlyHaveAnyOffFollowingPageOLS);
        }
        currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(surgeriesPerformedPageOLS);

        //Q16
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = new WeightLossSurgeryPageOLS();
        List<String> disqualifyQ16 = Arrays.asList(
                "Gastrectomy or removal of part of the stomach",
                "Fundoplication", "Vagotomy");
        for (String answer : disqualifyQ16) {
            System.out.println("Select answer for Q16: " + answer);
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

        //Q17
        HashMap<String, List<String>> disqualifyQ14 = new HashMap<>();
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = new ProcedureForWeightLossPageOLS(); //Disqualify ("GI surgery")
        disqualifyQ14.put("Gastric bypass", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Gastric sleeve or sleeve gastrectomy", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Duodenal switch", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Lap band or gastric banding", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Gastric balloon", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("I had a weight loss surgery, but I am unsure which type", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ14.entrySet()) {
            System.out.println(entry.getKey());
            weightLossSurgeryPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(procedureForWeightLossPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7214", site.activeProtocols)
                    .back(weightLossSurgeryPageOLS);
        }

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

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
            System.out.println(entry.getKey());
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
            System.out.println(entry.getKey());
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
            System.out.println(entry.getKey());
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
            System.out.println(entry.getKey());
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS44" , site.activeProtocols)
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

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWithLiverDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseOLS);
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseOLS
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
                .clickOnAnswers("Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());

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
            System.out.println(entry.getKey());
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59" , site.activeProtocols)
                    .back();
        }

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Seizure disorder such as epilepsy") //Disqualify ("Seizure disorder")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61" , site.activeProtocols)
                .back();

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        IdentificationPageOLS identificationPageOLS = new IdentificationPageOLS();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("3", "3", "39")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5","5","250")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5","5","235");
                if(env.equals("STG")) {
                    approximateHeightPageOLS
                            .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS())
                            .waitForPageLoad()
                            .clickOnAnswers("I am not currently treating my diabetes")
                            .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS())
                            .waitForPageLoad()
                            .clickOnAnswers("None of the above")
                            .clickNextButton(new DuringPastThreeMonthsOLS())
                            .waitForPageLoad()
                            .clickOnAnswer("No")
                            .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS())
                            .waitForPageLoad()
                            .clickOnAnswers("None of the above")
                            .clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS())
                            .waitForPageLoad()
                            .clickOnAnswers("None of the above")
                            .clickNextButton(new UseMarijuanaOrCannabisOLS())
                            .waitForPageLoad()
                            .clickOnAnswer("No");
                }
        approximateHeightPageOLS
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(identificationPageOLS);

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = siteSelectionPageOLS
                .waitForPageLoad1("a gastroparesis study for people with digestion problems!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {

            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .getRadiantDbToLog(env)
          //;          .getAnomalyDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo);

        }
    }
}

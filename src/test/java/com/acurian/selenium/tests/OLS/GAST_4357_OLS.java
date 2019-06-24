package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ADG_4357.*;
import com.acurian.selenium.pages.OLS.Crohns_3485.HaveAnyOfTheFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_OLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
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

public class GAST_4357_OLS extends BaseTest {

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
                {Site.AUT_GAST4357_site, false},
                {Site.AUT_GAST4357_site, true},
                {Site.AUT_GAST4357S_site, true}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("GAST 4357 OLS (Allergan Diabetic Gastroparesis)")
    public void gast4357olsTest(final Site site, boolean inFlare) {
        final String phoneNumber = "AUTAMSGAST";
        String studyName = "a study for diabetics with digestion problems";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle(studyName, "500"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .setDate("09092003")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("09091942")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        //Q2
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                diagnosedAnyTypeOfDiabetesPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No") //Disqualify ("No diabetes")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)") //Disqualify ("No diagnosis of diabetes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7203", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS)
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7203", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS);
        //Q4
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)") //If selected "Type 2 diabetes", go to Q4
                .clickNextButton(new WithType2DiabetesPageOLS());

        //Q4
        HashMap<String, List<String>> disqualifyQ4 = new HashMap<>();
        DigestiveConditionsAffectDiabetesPageOLS digestiveConditionsAffectDiabetesPageOLS = new DigestiveConditionsAffectDiabetesPageOLS();
        disqualifyQ4.put("Within the past 2 months", Arrays.asList(site.activeProtocols)); //Disqualify ("Diabetes < 5 years")
        disqualifyQ4.put("3 - 6 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ4.put("7 - 11 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ4.put("1 to less than 5 years ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ4.entrySet()) {
            System.out.println(entry.getKey());
            withType2DiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey()) //skip to Q7
                    .clickNextButton(digestiveConditionsAffectDiabetesPageOLS)
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
        HashMap<String, List<String>> disqualifyQ5 = new HashMap<>();
        disqualifyQ5.put("Within the past 2 months", Arrays.asList(site.activeProtocols)); //Disqualify ("Diabetes < 5 years")
        disqualifyQ5.put("3 - 6 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("7 - 11 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("1 to less than 5 years ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ5.entrySet()) {
            System.out.println(entry.getKey());
            withType1DiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey()) //skip to Q7
                    .clickNextButton(digestiveConditionsAffectDiabetesPageOLS)
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
        HashMap<String, List<String>> disqualifyQ6 = new HashMap<>();
        disqualifyQ6.put("Within the past 2 months", Arrays.asList(site.activeProtocols)); //Disqualify ("Diabetes < 5 years")
        disqualifyQ6.put("3 - 6 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ6.put("7 - 11 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ6.put("1 to less than 5 years ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ6.entrySet()) {
            System.out.println(entry.getKey());
            howLongAgoDiagnosedDiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey()) //skip to Q7
                    .clickNextButton(digestiveConditionsAffectDiabetesPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7206", site.activeProtocols)
                    .back(howLongAgoDiagnosedDiabetesPageOLS);
        }
        //Q6
        howLongAgoDiagnosedDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(digestiveConditionsAffectDiabetesPageOLS);
        //Q7
// ---- START Q9 Ghost Question - Gastroparesis Logic check ----
        SymptomsRegularlyOncePerWeekPageOLS symptomsRegularlyOncePerWeekPageOLS = digestiveConditionsAffectDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Will DQ in Q9
                .clickNextButton(new SymptomsRegularlyOncePerWeekPageOLS());
        //Q8
        ThrownUpVomitedPast2weeksPageOLS thrownUpVomitedPast2weeksPageOLS = symptomsRegularlyOncePerWeekPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Will DQ in Q9 //Skip to Q11
                .clickNextButton(new ThrownUpVomitedPast2weeksPageOLS());
        thrownUpVomitedPast2weeksPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7209", site.activeProtocols)
                .back(symptomsRegularlyOncePerWeekPageOLS);
        SymptomsFirstStartPageOLS symptomsFirstStartPageOLS = symptomsRegularlyOncePerWeekPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Nausea or feeling sick to your stomach",
                        "Bloating")
                .clickNextButton(new SymptomsFirstStartPageOLS());
        //Q10
        symptomsFirstStartPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7209", site.activeProtocols)
                .back(symptomsRegularlyOncePerWeekPageOLS)
                .clickOnAnswers("Vomiting or throwing up",
                        "Bloating") //Deselect Bloating
                .clickNextButton(symptomsFirstStartPageOLS)
                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkIsNoProtocolsForQuestion("Ghost Question - Gastroparesis Logic")
                .back(symptomsRegularlyOncePerWeekPageOLS)
                .waitForPageLoad()
                .back(digestiveConditionsAffectDiabetesPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Gastroparesis")
                .clickNextButton(symptomsRegularlyOncePerWeekPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(thrownUpVomitedPast2weeksPageOLS);
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkIsNoProtocolsForQuestion("Ghost Question - Gastroparesis Logic");
//---- END of Q9 Ghost Question - Gastroparesis Logic check ----
        //Q11
        HaveAnyOfTheFollowingPageOLS currentlyHaveAnyOffFollowingPageCC = thrownUpVomitedPast2weeksPageOLS
                .waitForPageLoad()
                .clickOnAnswer("None, I have not vomited in the past month")// not in flare
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());
        if (inFlare){
            currentlyHaveAnyOffFollowingPageCC
                    .waitForPageLoad()
                    .back();
            thrownUpVomitedPast2weeksPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("1 time")// in flare
                    .clickNextButton(currentlyHaveAnyOffFollowingPageCC)
                    .waitForPageLoad()
                    .back();
            thrownUpVomitedPast2weeksPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("2 times")// in flare
                    .clickNextButton(currentlyHaveAnyOffFollowingPageCC)
                    .waitForPageLoad()
                    .back();
            thrownUpVomitedPast2weeksPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("3 times")// in flare
                    .clickNextButton(currentlyHaveAnyOffFollowingPageCC)
                    .waitForPageLoad()
                    .back();
            thrownUpVomitedPast2weeksPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer("4 or more times")// in flare
                    .clickNextButton(currentlyHaveAnyOffFollowingPageCC);
        }
//        currentlyHaveAnyOffFollowingPageCC
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS7211", site.activeProtocols)
//                .back(thrownUpVomitedPast2weeksPageOLS)
//                .clickOnAnswer("4 or more times")
//                .clickNextButton(currentlyHaveAnyOffFollowingPageCC);
        //Q12
        HashMap<String, List<String>> disqualifyQ12 = new HashMap<>();
        SurgeriesPerformedPageOLS surgeriesPerformedPageOLS = new SurgeriesPerformedPageOLS(); //Disqualify ("Parenteral feeding or tube")
        disqualifyQ12.put("IV nutrition or Parenteral feeding – liquid food provided through a tube into your veins", Arrays.asList(site.activeProtocols));
        disqualifyQ12.put("Nasogastric tube – a tube that goes in your nose and then enters your stomach to give you food or help with symptoms", Arrays.asList(site.activeProtocols));
        disqualifyQ12.put("Enterostomy tube – a tube that goes through your skin directly into your stomach to provide you food or help with symptoms", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ12.entrySet()) {
            System.out.println(entry.getKey());
            currentlyHaveAnyOffFollowingPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(surgeriesPerformedPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7212", site.activeProtocols)
                    .back(currentlyHaveAnyOffFollowingPageCC);
        }
        currentlyHaveAnyOffFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(surgeriesPerformedPageOLS);
        //Q13
        HashMap<String, List<String>> disqualifyQ13 = new HashMap<>();
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = new WeightLossSurgeryPageOLS(); //Disqualify ("GI surgery")
        disqualifyQ13.put("Gastric pacemaker placement", Arrays.asList(site.activeProtocols));
        disqualifyQ13.put("Gastrectomy or removal of part of the stomach", Arrays.asList(site.activeProtocols));
        disqualifyQ13.put("Fundoplication", Arrays.asList(site.activeProtocols));
        disqualifyQ13.put("Vagotomy", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ13.entrySet()) {
            System.out.println(entry.getKey());
            surgeriesPerformedPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(weightLossSurgeryPageOLS)
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
                        "Men's health issues (prostate enlargement or BPH, low testosterone)")
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

//        WhichOfTheFollowingBreathingLungPageOLS whichOfTheFollowingBreathingLungPageOLS =
//                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
//                        .waitForPageLoad()
//                        .clickOnAnswers("None of the above")
//                        .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
//                        .clickNextButton(new WhichOfTheFollowingBreathingLungPageOLS());
//        //Q5: QS41
//        HashMap<String, List<String>> dqQ5 = new HashMap<>();
//        dqQ5.put("COPD", Arrays.asList(site.activeProtocols)); //Disqualify ("COPD")
//        dqQ5.put("Emphysema", Arrays.asList(site.activeProtocols)); //Disqualify ("Emphysema")
//        for (Map.Entry<String, List<String>> entry : dqQ5.entrySet()) {
//            System.out.println(entry.getKey());
//            whichOfTheFollowingBreathingLungPageOLS
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(entry.getKey())
//                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS41", site.activeProtocols)
//                    .back(whichOfTheFollowingBreathingLungPageOLS);
//        }
//        whichOfTheFollowingBreathingLungPageOLS
//                .waitForPageLoad()
//                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        //Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(otherThanSkinCancerPageOLS)
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
                .clickOnAnswers("Heart attack")
                .clickOnAnswers("Stroke")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS()); //Display Q12.1: QS47A
        //Q12.1 - 12.4:
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected5)
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
                .clickOnAnswers("Angioplasty")
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

        WhichOfTheFollowingMensHealthConditions_OLS whichOfTheFollowingMensHealthConditions_OLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WhichOfTheFollowingMensHealthConditions_OLS());
        //Q22: QS57
        whichOfTheFollowingMensHealthConditions_OLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Men's health issues (prostate enlargement or BPH, low testosterone)")
                .clickNextButton(whichOfTheFollowingMensHealthConditions_OLS);

        whichOfTheFollowingMensHealthConditions_OLS
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
                .clickNextButton(new IdentificationPageOLS());
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());
        siteSelectionPageOLS
                .waitForPageLoad1("a study for diabetics with digestion problems!")
                .getPID();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        if (inFlare) {
            siteSelectionPageOLS
                    .clickOnFacilityName(site.name)
                    .clickNextButton(new QualifiedClose2PageOLS())
                    .waitForPageLoad()
                    .clickNextButton(new SynexusHealthyMindsPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No, I am not interested in receiving information")
                    .clickNextButton(new ThankYouCloseSimplePageOLS())
                    .waitForPageLoad()
                    .clickNextButton(aboutHealthPageOLS);
        } else {
            siteSelectionPageOLS
                    .clickOnFacilityName(site.name)
                    .clickNextButton(new QualifiedCloseGastroPageOLS())
                    .waitForPageLoad()
                    .clickNextButton(new SynexusHealthyMindsPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No, I am not interested in receiving information")
                    .clickNextButton(new ThankYouCloseSimplePageOLS())
                    .waitForPageLoad()
                    .clickNextButton(aboutHealthPageOLS);
        }

        switch (site) {
            case AUT_GAST4357_site: //1R
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_GAST4357S_site: //41C
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
        aboutHealthPageOLS.flareCodeShouldMatch(env, inFlare ? "3" : "4");
    }
}
package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.Vaccine.DirectSheduleVaccCC;
import com.acurian.selenium.pages.CC.Vaccine.ScedulerCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.pages.blinx.ams.shared.DRSBlinx;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.*;

public class GAST_4357_CC extends BaseTest {

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
                {Site.AUT_GAS4357ds, true},
                {Site.AUT_GAST4357S_site, true},
                {Site.AUT_GAST4357_site, false}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("GAST 4357 CC (Allergan Diabetic Gastroparesis)")
    public void gast4357ccTest(Site site, boolean inFlare) {
        String phoneNumber = "AUTAMSGAST";
        String studyName = "a study for diabetics with digestion problems";

        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:",
                "Title text is diff");
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS,
                "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad(studyName, "500");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle(studyName, "500"), "Title is diff");

        dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .waitForPageLoad(studyName, "500")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad(studyName, "500")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("19")
                .setYear("2001")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());
        //Q2
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No diabetes")
                .clickNextButton(new NonQRtransitionPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7202", site.activeProtocols)
                .back(diagnosedAnyTypeOfDiabetesPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Continue to Q3
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        //Q3
        CardiovascularDiseaseThanOthersPageCC сardiovascularDiseaseThanOthersPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)") //Disqualify ("No diagnosis of diabetes")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());
        сardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7203", site.activeProtocols)
                .back(whatKindOfDiabetesPageCC)
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(сardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7203", site.activeProtocols)
                .back(whatKindOfDiabetesPageCC);
        //Q4
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)") //If selected "Type 2 diabetes", go to Q4
                .clickNextButton(new WithType2DiabetesPageCC());

        //Q4
        List<String> disqualifyQ4 = Arrays.asList("Within the past 2 months",
                "3 - 6 months ago", "7 - 11 months ago", "1 to less than 5 years ago");

        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = new CurrentlyTreatingYourDiabetesPageCC();

        for (String answer: disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            withType2DiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer) //skip to Q7
                    .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());
            currentlyTreatingYourDiabetesPageCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7204", site.activeProtocols)
                    .back(withType2DiabetesPageCC)
            ;
        }
        WithType1DiabetesPageCC withType1DiabetesPageCC = withType2DiabetesPageCC
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageCC)
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)") //If selected "Type 1 diabetes", go to Q5
                .clickNextButton(new WithType1DiabetesPageCC());

        //Q5
        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC =
                new CardiovascularDiseaseThanOthersPageCC();
        List<String> disqualifyQ5 = Arrays.asList("Within the past 2 months", "3 - 6 months ago", "7 - 11 months ago",
        "1 to less than 5 years ago");
        for (String answer: disqualifyQ5) {
            System.out.println("Select answer for Q5: " + answer);
            withType1DiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer) //skip to Q7
                    .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7205", site.activeProtocols)
                    .back(withType1DiabetesPageCC);
        }

        HowLongAgoDiagnosedDiabetesPageCC howLongAgoDiagnosedDiabetesPageCC = withType1DiabetesPageCC
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageCC)
                .clickOnAnswer("Unsure") //If selected "Unsure", go to Q6
                .clickNextButton(new HowLongAgoDiagnosedDiabetesPageCC());
        //Q6
        List<String> disqualifyQ6 = Arrays.asList("Within the past 2 months", "3 - 6 months ago", "7 - 11 months ago",
                "1 to less than 5 years ago");
        for (String answer : disqualifyQ6) {
            System.out.println("Select answer for Q6: " + answer);
            howLongAgoDiagnosedDiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer) //skip to Q7
                    .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC())
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7206", site.activeProtocols)
                    .back(howLongAgoDiagnosedDiabetesPageCC);
        }
        //Q6
        DigestiveConditionsAffectDiabetesPageCC digestiveConditionsAffectDiabetesPageCC = howLongAgoDiagnosedDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("10 years ago or more")
                .clickNextButton(new DigestiveConditionsAffectDiabetesPageCC());
        //Q7
// ---- START Q9 Ghost Question - Gastroparesis Logic check ----
        SymptomsRegularlyOncePerWeekPageCC symptomsRegularlyOncePerWeekPageCC = digestiveConditionsAffectDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SymptomsRegularlyOncePerWeekPageCC());
        //Q8
        symptomsRegularlyOncePerWeekPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7209", site.activeProtocols)
                .back();
        symptomsRegularlyOncePerWeekPageCC
                .waitForPageLoad()
                .clickOnAnswers("Nausea or feeling sick to your stomach",
                                "Bloating")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7209", site.activeProtocols)
                .back();

        SymptomsFirstStartPageCC symptomsFirstStartPageCC = symptomsRegularlyOncePerWeekPageCC
                .waitForPageLoad()
                .clickOnAnswers("Vomiting or throwing up",
                                "Bloating") //Deselect Bloating
                .clickNextButton(new SymptomsFirstStartPageCC());

        //Q10
        symptomsFirstStartPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 months ago or less")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7210", site.activeProtocols)
                .back();
        ThrownUpVomitedPastMonthPageCC thrownUpVomitedPastMonthPageCC = symptomsFirstStartPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 to 5 months ago")
                .clickNextButton(new ThrownUpVomitedPastMonthPageCC());
        //Q11
        CurrentlyHaveAnyOffFollowingPageCC currentlyHaveAnyOffFollowingPageCC = thrownUpVomitedPastMonthPageCC
                .waitForPageLoad()
                .clickOnAnswer("None, I have not vomited in the past month")
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageCC());// not in flare
        if (inFlare) {
            currentlyHaveAnyOffFollowingPageCC
                    .waitForPageLoad()
                    .back();
            List<String> inFlareAnswer = Arrays.asList("1 time", "2 times", "3 times", "4 or more times");
            for (String answer: inFlareAnswer) {
                System.out.println("Select answer for Q11: " + answer);
                thrownUpVomitedPastMonthPageCC
                        .waitForPageLoad()
                        .clickOnAnswer(answer)
                        .clickNextButton(currentlyHaveAnyOffFollowingPageCC)
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkStudyStatusContainsForQNumber("QS7211", "2-3")
                        .back();
            }
            thrownUpVomitedPastMonthPageCC
                    .waitForPageLoad()
                    .clickNextButton(currentlyHaveAnyOffFollowingPageCC);
        } else {
            currentlyHaveAnyOffFollowingPageCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkStudyStatusContainsForQNumber("QS7211", "2-4");
        }

        //Q12
        SurgeriesPerformedPageCC surgeriesPerformedPageCC = new SurgeriesPerformedPageCC();
        List<String> disqualifyQ12 = Arrays.asList("IV nutrition or Parenteral feeding – liquid food provided through a tube into your veins (Agent Note: puh-REN-ter-ul)",
        "Nasogastric tube – a tube that goes in your nose and then enters your stomach to give you food or help with symptoms (Agent Note: ney-zoh-gas-trik)",
        "Enterostomy tube – a tube that goes through your skin directly into your stomach to provide you food or help with symptoms (Agent Note: en-tuh-ros-tuh-mee)");
        for (String answer : disqualifyQ12) {
            System.out.println("Select answer for Q12: " + answer);
            currentlyHaveAnyOffFollowingPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(surgeriesPerformedPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7212", site.activeProtocols)
                    .back(currentlyHaveAnyOffFollowingPageCC);
        }
        currentlyHaveAnyOffFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(surgeriesPerformedPageCC);
        //Q13
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = new WeightLossSurgeryPageCC();
        List<String> disqualifyQ13 = Arrays.asList("Gastric pacemaker placement (Agent Note: gas-trik)",
                "Gastrectomy or removal of part of the stomach (Agent Note: ga-strek-tuh-mee)",
                "Fundoplication (Agent Note: fun-do-pli-kae-tion)", "Vagotomy (Agent Note: vey-got-uh-mee)");
        for (String answer : disqualifyQ13) {
            System.out.println("Select answer for Q13: " + answer);
            surgeriesPerformedPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(weightLossSurgeryPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7213", site.activeProtocols)
                    .back(surgeriesPerformedPageCC);
        }
        surgeriesPerformedPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(weightLossSurgeryPageCC);
        //Q14
        HashMap<String, List<String>> disqualifyQ14 = new HashMap<>();
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = new ProcedureForWeightLossPageCC(); //Disqualify ("GI surgery")
        disqualifyQ14.put("Gastric bypass", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Gastric sleeve or sleeve gastrectomy", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Duodenal switch", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Lap band or gastric banding", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Gastric balloon", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("I had a weight loss surgery, but I am unsure which type", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ14.entrySet()) {
            System.out.println(entry.getKey());
            weightLossSurgeryPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(procedureForWeightLossPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7214", site.activeProtocols)
                    .back(weightLossSurgeryPageCC);
        }
        TransitionStatementCC transitionStatementCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC()); //Q19

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
        transitionStatementCC
                .waitForPageLoadWithTitle("Thank you for answering these questions about your stomach problems.\n" +
                        "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
                        "Agent Note: If \"no\" to all items in a question, select \"None of the above\"")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

//-------------------New GENERAL HEALTH---------------------------
        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                .clickNextButton(new WhatKindOfArthritisPageCC());
        whatKindOfArthritisPageCC
                .waitForPageLoad()
                .back();
        //Q2: QS38
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("ADHD or attention deficit hyperactivity disorder") //If exclusively selected, skip to Q24)
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        //Check flow logic for Q2
        //Q4: QS40
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")//Select
                        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC());

        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC); //Back to Q2: QS38


        WhenDiagnosedWithCancerCC otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        //Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(otherThanSkinCancerPageOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichTypeOfHeadacheDoYouGetCC whichTypeOfHeadacheDoYouGetCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetCC());
        //Q10: QS45
        whichTypeOfHeadacheDoYouGetCC
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        //Q11: QS46
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC()); //Display Q12.1: QS47A
        //Q12.1 - 12.4:
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForAllSubQuestion("More than 1 year ago");
        //Q12.1
        HashMap<String, List<String>> dqQ121 = new HashMap<>();
        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = new HeartRelatedSurgeriesProceduresPageCC();
        dqQ121.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 3")
        dqQ121.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : dqQ121.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, entry.getKey())
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47" , site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago");
        //Q12.2
        HashMap<String, List<String>> dqQ122 = new HashMap<>();
        dqQ122.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 3")
        dqQ122.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : dqQ122.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                    .clickOnAnswerForSubQuestion(2, entry.getKey())
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC);
            heartRelatedSurgeriesProceduresPageCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47" , site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);
        //Q48
        MostRecentHeartProcedurePageСС mostRecentHeartProcedurePageСС = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageСС());

        //QS49
        HashMap<String, List<String>> dqQ14 = new HashMap<>();
        dqQ14.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent CV procedure - Temp 3")
        dqQ14.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : dqQ14.entrySet()) {
            System.out.println(entry.getKey());
            mostRecentHeartProcedurePageСС
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS49" , site.activeProtocols)
                    .back(mostRecentHeartProcedurePageСС);
        }
        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        DoYouTakeAnyMedicationsControlHypertension_CC doYouTakeAnyMedicationsControlHypertension_CC =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                 .waitForPageLoad()
                 .clickOnAnswers("None of the above")
                 .clickOnAnswers("High blood pressure or hypertension")
                 .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC());
        //Q15: QS50
        doYouTakeAnyMedicationsControlHypertension_CC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());

        //Q8: QS44
        whichOfFollowingDigestiveConditionPageCC
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
            whichOfFollowingDigestiveConditionPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS44" , site.activeProtocols)
                    .back(whichOfFollowingDigestiveConditionPageCC);
        }
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        //Q16: QS51
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());
        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        //Q18: QS53
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC());
        //Q19: QS54
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC
                .waitForPageLoad()
                .clickOnAnswers("Seizure disorder, such as epilepsy")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfTheFollowingSkinConditionsDoYouSufferСС whichOfTheFollowingSkinConditionsDoYouSufferСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                        .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WomenHealthConditionsCC womenHealthConditionsCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WomenHealthConditionsCC());
        //Q22: QS57
        womenHealthConditionsCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());

        womenHealthConditionsCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        //Flow for Q2: QS38 was checked

        //Q24: QS59
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
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
                .clickNextButton(new ApproximateHeightPageCC());
        //Q28: QS60
        approximateHeightPageCC
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
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59" , site.activeProtocols)
                    .back();
        }

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Seizure disorder such as epilepsy") //Disqualify ("Seizure disorder")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61" , site.activeProtocols)
                .back();

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("3", "6", "100")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(identificationPageCC);
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_GAST4357_site: //1R
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedCloseGastroPageCC())
                        .waitForPageLoad()
//                        .clickNextButton(new SynexusHealthyMindsPageCC())
//                        .waitForPageLoad()
//                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad3()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
                case AUT_GAS4357ds:
                    DRSBlinx dRSBlinx = new DRSBlinx();
                    ScedulerCC scedulerCC = new ScedulerCC();
                    DirectSheduleVaccCC directSheduleVaccCC = new DirectSheduleVaccCC();
                    selectionPageCC
                            .clickOnAnswer(site.name)
                            .clickNextButton(directSheduleVaccCC);
                    if (env.equals("PRD")) {
                        directSheduleVaccCC
                                .waitForPageLoad();
                    }
                    if (env.equals("STG")) {
                        directSheduleVaccCC
                                .waitForPageLoadSTG();
                    }
                    directSheduleVaccCC
                            .clickSheduleBtnBlinx(dRSBlinx);
                    ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
                    getDriver().switchTo().window(tabs.get(1));
                    dRSBlinx
                            .waitForPageLoadBlinx()
                            .clickOnBtnNoApp()
                            .waitForUnf()
                            .clickOnBtnPrev()
                            .waitForPageLoadBlinx()
                            .waitForPageLoadBlinx()
                            .clickOnDay()
                            .clickOnTime()
                            .clickOnNext()
                            .waitForPageLoadClientDetails()
                            .dateCheck()
                            .startsAtCheck()
                            .serviceProviderCheck()
                            .clickOnAgree()
                            .clickOnSendSMS();
                    getDriver().switchTo().window(tabs.get(0));
                    QualifiedClose1PageCC qualifiedClose1PageCC = new QualifiedClose1PageCC();
                    SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = new SynexusRadiantDirectScheduleCC();
                    if (env.equals("PRD")) {
                        directSheduleVaccCC
                                .waitForPageLoad();
                    }
                    if (env.equals("STG")) {
                        directSheduleVaccCC
                                .waitForPageLoadSTG();
                    }
                    directSheduleVaccCC
                            .clickNextButton(synexusRadiantDirectScheduleCC);
                    /*SynexusHealthyMindsPageCC synexusHealthyMindsPageCC*/
//                    SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = qualifiedClose1PageCC
//                            .waitForPageLoad()
//                            .clickNextButton(new SynexusRadiantDirectScheduleCC()/*SynexusHealthyMindsPageCC()*/);

//                    ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = synexusHealthyMindsPageCC
//                            .waitForPageLoad()
//                            .clickOnAnswer("No")
//                            .clickNextButton(new ThankYouCloseSimplePageCC());
                    synexusRadiantDirectScheduleCC
                            .waitForPageLoadSyn()
                            .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                            .clickNextButton(selectActionPageCC);
//                    thankYouCloseSimplePageCC
//                            .waitForPageLoad()
//                            .clickNextButton(selectActionPageCC);

                    selectActionPageCC
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo);


                    break;
            case AUT_GAST4357S_site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariablesNew("Acurian", "Trial", "04/19/2001", "US",
                                "Dover, DE", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", env.equals("STG") ? " 4357synexus " : " 4357S ",
                                " "+site.name, env.equals("STG") ? "ALLXXXDGP01,ALLXXXDGP02 - Allergan Gastroparesis" : "ALLXXXDGPD01,ALLXXXDGPD02 - Allergan Gastroparesis")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
        selectActionPageCC.flareCodeShouldMatch(env, inFlare ? "3" : "4");
    }
}
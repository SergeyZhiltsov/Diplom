package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.CurrentlyTakingFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.PSO_456.DiagnosedWithPsoriasisCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.*;

public class DERM_4825_CC extends BaseTest {

    @Test(enabled = false) //Deactivated in R79.2
    @Description("DERM 4825 Genentech Atopic Derm")
    public void derm4825ccGADTest() {
        Site site = Site.AUT_AMS1_4825_site;
        final String phoneNumber = "AUTAMSDERM";
        String studyName = "an eczema (atopic dermatitis) study";
        String studyNameForTrans = "eczema, or atopic dermatitis";
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected,
                "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                        .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"),
                "Title is diff");

        dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = genderPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("5")
                .setYear("2001")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        DiagnosedWithPsoriasisCC diagnosedWithPsoriasisCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No atopic dermatitis")
                .clickNextButton(new DiagnosedWithPsoriasisCC());

        diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back();

        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_cc = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());

        HowWouldYouDescribeTheEczemaCurrentlyPageCC howWouldYouDescribeTheEczemaCurrentlyPageCC =
                new HowWouldYouDescribeTheEczemaCurrentlyPageCC();
        List<String> disqualifyQ3 = Arrays.asList("2 months or less",
                "3 - 6 months",
                "7 - 11 months",
                "1 year",
                "2 year");
        for (String answer : disqualifyQ3) {
            System.out.println(answer);
            howLongHaveYouBeenSufferingFromEczema_cc
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
                    .back();
        }
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
                .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageCC);

        //Q24
        HaveYouEverHadAnyOfTheFollowingSymptomsPageСС haveYouEverHadAnyOfTheFollowingSymptomsPageСС =
                new HaveYouEverHadAnyOfTheFollowingSymptomsPageСС();
        List<String> disqualifyQ24 = Arrays.asList("Minor: Mostly or almost clear",
                "Mild: Covers a small amount of total skin on my body");
        for (String answer : disqualifyQ24) {
            System.out.println("Select answer for Q24: " + answer);
            howWouldYouDescribeTheEczemaCurrentlyPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(haveYouEverHadAnyOfTheFollowingSymptomsPageСС)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5848", site.activeProtocols)
                    .back();
        }
        howWouldYouDescribeTheEczemaCurrentlyPageCC
                .waitForPageLoad()
                .clickNextButton(haveYouEverHadAnyOfTheFollowingSymptomsPageСС);
        HowManyDaysHasSkinBeenItchyCC howManyDaysHasSkinBeenItchyCC = haveYouEverHadAnyOfTheFollowingSymptomsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Eczema that covers a medium to large amount of total skin on my body",
                        "Eczema that looks red or dark red",
                        "Eczema that feels very or intensely itchy and scratchy")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyCC());
        howManyDaysHasSkinBeenItchyCC         //Q26
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5849", site.activeProtocols)
                .back(haveYouEverHadAnyOfTheFollowingSymptomsPageСС)
                .waitForPageLoad()
                .back(howWouldYouDescribeTheEczemaCurrentlyPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Severe: Covers a large amount of total skin on my body")
                .clickNextButton(howManyDaysHasSkinBeenItchyCC);

        //Q26
        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy") //Disqualify ("No pruritus")
                .clickNextButton(new EczemaSymptomsExperienceCC());
        RateAverageItchinessEczemaPageCC rateAverageItchinessEczemaPageCC = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5837", site.activeProtocols)
                .back(howManyDaysHasSkinBeenItchyCC)
                .waitForPageLoad()
                .clickOnAnswer("My skin is itchy every day")
                .clickNextButton(new RateAverageItchinessEczemaPageCC());
        //Q27
        rateAverageItchinessEczemaPageCC
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(eczemaSymptomsExperienceCC);
        //Q28
        HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC haveYouTriedAnyFollowingTreatmentsForEczemaPageCC =
                eczemaSymptomsExperienceCC
                        .waitForPageLoad()
                        .clickOnAnswers("Redness",
                                "Swelling",
                                "Oozing/Crusting",
                                "Dryness",
                                "Scratch marks",
                                "Skin thickening")
                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC());
        //Q27
        TransitionStatementCC transitionStatementCC = haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                .waitForPageLoad()
                .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
                        "Medications taken by mouth (oral medications)",
                        "Shots or IV infusions (injectable medications)",
                        "Self-treatment with tanning beds or sunbathing",
                        "Phototherapy (Ultraviolet or UV light treatment)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Self-treatment with tanning beds or sunbathing",
                        "Phototherapy (Ultraviolet or UV light treatment)")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5845", site.activeProtocols)
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC);
        haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC);
        CurrentlyTakingFollowingMedicationsCC currentlyTakingFollowingMedicationsCC =
                haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Medications taken by mouth (oral medications)")
                        .clickNextButton(new CurrentlyTakingFollowingMedicationsCC());
        currentlyTakingFollowingMedicationsCC
                .waitForPageLoad()
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC);
        AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC =
                haveYouTriedAnyFollowingTreatmentsForEczemaPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Shots or IV infusions (injectable medications)")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC());
        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC
                .waitForPageLoad()
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Medications taken by mouth (oral medications)") //Added to display Q35
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC);
        //Q31
        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Disqualify (“Current biologic use”)
                .clickNextButton(currentlyTakingFollowingMedicationsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5850", site.activeProtocols)
                .back(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(currentlyTakingFollowingMedicationsCC);

        //Q32
        DupixentInjectionPageCC dupixentInjectionPageCC = currentlyTakingFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Cosentyx (Agent Note: co-SEN-tix)", "Fasenra (Agent Note: fa-SEN-ra)",
                        "Nucala (Agent Note: new-CA-la)", "Otezla (Agent Note: oh-TEZ-la)")
                .clickNextButton(new DupixentInjectionPageCC());

        //Q33
        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC = dupixentInjectionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, currently taking")
                .clickNextButton(new HaveYouEverTakenEitherAnyOfFollowingMeds_CC());
        haveYouEverTakenEitherAnyOfFollowingMeds_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5847", site.activeProtocols)
                .back(dupixentInjectionPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No, never took")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC);

        //Q34
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                haveYouEverTakenEitherAnyOfFollowingMeds_CC
                        .waitForPageLoad()
                        .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)",
                                "Olumiant (Agent Note: oh-LOO-me-ant)",
                                "Xeljanz (Agent Note: ZEL-jans)")
                        .clickNextButton(transitionStatementCC)
                        .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        //-------------------New GENERAL HEALTH---------------------------
        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
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
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, " +
                                "schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisCC());
        whatKindOfArthritisCC
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

        WhichFollowingBonesJoints_CC whichFollowingBonesJoints_CC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")//Select
                        .clickNextButton(new WhichFollowingBonesJoints_CC());

        whichFollowingBonesJoints_CC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC); //Back to Q2: QS38

        WhichOfTheFollowingBreathingLungPageСС whichOfTheFollowingBreathingLungPageСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                        .clickNextButton(new WhichOfTheFollowingBreathingLungPageСС());
        //Q5: QS41
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .back();

        WhenDiagnosedWithCancerCC otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")//Select
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        //Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(otherThanSkinCancerPageOLS);
        //Back to haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")//Deselect
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        //Q6: QS42
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .back();

        WhichTypeOfHeadacheCC whichTypeOfHeadacheCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Headaches (migraine, cluster, tension)") //Select
                .clickNextButton(new WhichTypeOfHeadacheCC());
        //Q10: QS45
        whichTypeOfHeadacheCC
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)") //Select
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        //Q11: QS46
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC()); //Display Q12.1: QS47A
        //Q12.1: QS47A
        HashMap<String, List<String>> disqualifyQ121 = new HashMap<>();
        disqualifyQ121.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ121.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ121.put("4 - 6 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 9")
        disqualifyQ121.put("7 - 12 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 6")
        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC =
                new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC();
        for (Map.Entry<String, List<String>> entry : disqualifyQ121.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);
        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.2: QS47B
        //Q12.2: QS47B
        HashMap<String, List<String>> disqualifyQ122 = new HashMap<>();
        disqualifyQ122.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ122.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ122.put("4 - 6 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 9")
        disqualifyQ122.put("7 - 12 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 6")
        for (Map.Entry<String, List<String>> entry : disqualifyQ122.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.3: QS47C
        //Q12.3: QS47C
        HashMap<String, List<String>> disqualifyQ123 = new HashMap<>();
        disqualifyQ123.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ123.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ123.put("4 - 6 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 9")
        disqualifyQ123.put("7 - 12 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 6")
        for (Map.Entry<String, List<String>> entry : disqualifyQ123.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.4: QS47D
        //Q12.4: QS47D
        HashMap<String, List<String>> disqualifyQ124 = new HashMap<>();
        disqualifyQ124.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ124.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 12")
        disqualifyQ124.put("4 - 6 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 9")
        disqualifyQ124.put("7 - 12 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 6")
        for (Map.Entry<String, List<String>> entry : disqualifyQ124.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);
        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC); //Skip to Q13
        //Q13: QS48
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);
        haveYouEverExperiencedHeartRelatedMedicalCondCC
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

        //Q16: QS51
        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        //Q17: QS52
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfTheFollowingLiverProblemsPageСС);
        whichOfTheFollowingLiverProblemsPageСС
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
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
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
                .back();
        WhichOfTheFollowingSkinConditionsDoYouSufferСС whichOfTheFollowingSkinConditionsDoYouSufferСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)") //Select
                        .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS55", site.activeProtocols)
                .back(whichOfTheFollowingSkinConditionsDoYouSufferСС);
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WomenHealthConditionsCC womenHealthConditionsCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                        .clickNextButton(new WomenHealthConditionsCC());
        //Q22: QS57
        womenHealthConditionsCC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        //Flow for Q2: QS38 was checked

        //Q24: QS59
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers( //Select all to check quantity
                        "Bipolar disorder",
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
        List<String> disqualifyQ24GH = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS");
        for (String answer : disqualifyQ24GH) {
            System.out.println(answer);
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
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        LetMeSeePageCC letMeSeePageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("3", "2", "86")// Disqualify (“Underweight”) if < 88 lbs (40 kg)
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC);
        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "3", "100")
                .clickNextButton(letMeSeePageCC);
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC); //Disqualify ("Low BMI") if < 18
        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("3", "5", "100")
                .clickNextButton(letMeSeePageCC);
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageCC); //Disqualify ("High BMI") if > 40
        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("3", "6", "100")
                .clickNextButton(letMeSeePageCC);

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        selectionPageCC
                .clickOnAnswer(site.name)
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4825")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.BiologicMedicationsPageCC;
import com.acurian.selenium.pages.CC.LPS_4442.EitherOfTheFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.PSO_456.*;
import com.acurian.selenium.pages.CC.PsoriaticArthritis.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class PSA_5071_CC extends BaseTest {


    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_5071_site},
                //{Site.AUT_AMS1_5071S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("PsA 5071 OLS Gilead Psoriatic Arthritis(PsA)")
    public void psar5071cc(Site site) {
        final String phoneNumber = "AUTAMS1PSA";
        final String transitionStudyName = "psoriatic arthritis";
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a psoriatic arthritis study", "300");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle("a psoriatic arthritis study", "300"),
//                "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageCC = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad("a psoriatic arthritis study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad()
                .setDay("9")
                .setMonth("Aug")
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
                .setYear("1943") //Disqualify ("Age") if >= 76
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        PsoriaticArthritisConditionPageCC psoriaticArthritisConditionPageCC = genderPageCC
                .waitForPageLoad()
                .setYear("1980")
                .clickNextButton(new PsoriaticArthritisConditionPageCC());

        //Module Psoriatic Arthritis (PsA) started
        //Q2
        NonQRtransitionPageCC nonQRtransitionPageCC = psoriaticArthritisConditionPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7502", site.activeProtocols)
                .back();

        FirstDiagnosedPsoriaticArthritisPageCC firstDiagnosedPsoriaticArthritisPageCC =
                psoriaticArthritisConditionPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new FirstDiagnosedPsoriaticArthritisPageCC());

        //Q3
        SwollenJointsOfPsoriaticArthritisPageCC swollenJointsOfPsoriaticArthritisPageCC =
                new SwollenJointsOfPsoriaticArthritisPageCC();
        List<String> disqualifyQ3 = Arrays.asList("Less than 1 month ago", "1 - 5 months ago");
        for (String answer : disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            firstDiagnosedPsoriaticArthritisPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(swollenJointsOfPsoriaticArthritisPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7503", site.activeProtocols)
                    .back();
        }
        firstDiagnosedPsoriaticArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months ago")
                .clickNextButton(swollenJointsOfPsoriaticArthritisPageCC);

        //Q4
        CurrentlyHaveSoreTenderPainfulPsoriaticArthritisPageCC currentlyHaveSoreTenderPainfulPsoriaticArthritisPageCC =
                swollenJointsOfPsoriaticArthritisPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("No") //skip to Q6
                        .clickNextButton(new CurrentlyHaveSoreTenderPainfulPsoriaticArthritisPageCC());
        currentlyHaveSoreTenderPainfulPsoriaticArthritisPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7504", site.activeProtocols)
                .back();
        HowManyJointsSwollenPageCC howManyJointsSwollenPageCC = swollenJointsOfPsoriaticArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes") //continue to Q5
                .clickNextButton(new HowManyJointsSwollenPageCC());

        //Q5
        howManyJointsSwollenPageCC
                .waitForPageLoad()
                .setJointsAreSwollen("1")
                .clickNextButton(currentlyHaveSoreTenderPainfulPsoriaticArthritisPageCC);

        //Q6
        HasHealthCareProfessionalDiagnosedPsoriasisCC hasHealthCareProfessionalDiagnosedPsoriasisCC = currentlyHaveSoreTenderPainfulPsoriaticArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswer("No") //skip to Q8
                .clickNextButton(new HasHealthCareProfessionalDiagnosedPsoriasisCC());
        hasHealthCareProfessionalDiagnosedPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7506", site.activeProtocols)
                .back();
        HowManyJointsAreSoreTenderPainfulPageCC howManyJointsAreSoreTenderPainfulPageCC =
                currentlyHaveSoreTenderPainfulPsoriaticArthritisPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes") //continue to Q7
                        .clickNextButton(new HowManyJointsAreSoreTenderPainfulPageCC());

        //Q7
        howManyJointsAreSoreTenderPainfulPageCC
                .waitForPageLoad()
                .setJointsPainful("1")
                .clickNextButton(hasHealthCareProfessionalDiagnosedPsoriasisCC);

        //Q8
        TransitionStatementCC transitionStatementCC = hasHealthCareProfessionalDiagnosedPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithCurves7518(transitionStudyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7508", site.activeProtocols)
                .back();
        WhichTypeOfPsoriasisDoYouHaveCC whichTypeOfPsoriasisDoYouHaveCC = hasHealthCareProfessionalDiagnosedPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes") //continue to Q9
                .clickNextButton(new WhichTypeOfPsoriasisDoYouHaveCC());

        //Q9 //check Q11 Ghost Question - Psoriasis Logic
        CurrentlyHaveAnyOffFollowingPageCC currentlyHaveAnyOffFollowingPageCC = whichTypeOfPsoriasisDoYouHaveCC
                .waitForPageLoad()
                .clickOnAnswers("Another type of psoriasis (Guttate, Pustular, Erythtodermic, Inverse)") //Otherwise disqualify
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageCC());
//        //Q10
        currentlyHaveAnyOffFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Otherwise disqualify
                .clickNextButton(transitionStatementCC);
        transitionStatementCC
                .waitForPageLoadWithCurves7518(transitionStudyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7511", site.activeProtocols)
                .back(currentlyHaveAnyOffFollowingPageCC)
                .waitForPageLoad()
                .back(whichTypeOfPsoriasisDoYouHaveCC)
                .waitForPageLoad()
                .clickOnAnswers("Plaque - Thick, red patches of skin are covered by flaky, silver-white scales. " +
                        "This is the most common type of psoriasis")
                .clickNextButton(currentlyHaveAnyOffFollowingPageCC);
        PrescriptionMedicationPsoriaticArthritisPageCC prescriptionMedicationPsoriaticArthritisPageCC =
                currentlyHaveAnyOffFollowingPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Patches of psoriasis on your skin", "Psoriasis on your fingernails or toenails")
                        .clickNextButton(new PrescriptionMedicationPsoriaticArthritisPageCC());

        //Q12
        EitherOfTheFollowingMedicationsCC eitherOfTheFollowingMedicationsCC =
                prescriptionMedicationPsoriaticArthritisPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("No") //skip to Q15 (JAK inhibitors question)
                        .clickNextButton(new EitherOfTheFollowingMedicationsCC());
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7512", site.activeProtocols)
                .back();
        EverReceivedAnyBiologicMedicationsPageCC everReceivedAnyBiologicMedicationsPageCC =
                prescriptionMedicationPsoriaticArthritisPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes") //continue to Q13 (biologics Y/N question)
                        .clickNextButton(new EverReceivedAnyBiologicMedicationsPageCC());

        //Q13
        BiologicMedicationsPageCC biologicMedicationsPageCC = everReceivedAnyBiologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BiologicMedicationsPageCC());

        //Q14
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
        for (String answer : disqualifyQ14) {
            System.out.println("Select answer for Q14: " + answer);
            biologicMedicationsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(eitherOfTheFollowingMedicationsCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7514", site.activeProtocols[0])
                    .back();
        }
        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(eitherOfTheFollowingMedicationsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7514", site.activeProtocols[1]);

        //Q15
        WhenDiagnosedWithPsoriasisCC whenDiagnosedWithPsoriasisCC = new WhenDiagnosedWithPsoriasisCC();
        List<String> disqualifyQ15 = Arrays.asList("Jakafi (Agent Note: JAK-uh-fie)",
                "Olumiant (Agent Note: oh-LOO-me-ant)", "Xeljanz (Agent Note: ZEL-jans)");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15: " + answer);
            eitherOfTheFollowingMedicationsCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(whenDiagnosedWithPsoriasisCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7515", site.activeProtocols)
                    .back();
        }
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

                transitionStatementCC
                        .waitForPageLoadWithCurves7518(transitionStudyName)
                        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);


        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)", "Cancer",
                        "Diabetes (type 1 or type 2)", "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Kidney disease", "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(new WhatKindOfArthritisPageCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whatKindOfArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisPageCC)
                .waitForPageLoad()
                .back();

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .back();

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                                "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());

        List<String> disqualifyQS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer : disqualifyQS44) {
            System.out.println("Select answer for QS44: " + answer);
            whichOfFollowingDigestiveConditionPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back();
        }
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        List<String> disqualifyQS51 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQS51) {
            System.out.println("Select answer for QS51: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .back();


        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        List<String> disqualifyQS53 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQS53) {
            System.out.println("Select answer for Q53: " + answer);
            followingMentalEmotionalHealthPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC());

        whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC)
                .waitForPageLoad()
                .back();


        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        //Q24: QS59
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ26 = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "HIV or AIDS");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
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
        List<String> disqualifyQ26pt2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ26pt2) {
            System.out.println("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "144")
                .clickNextButton(new LetMeSeePageCC());

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());
        siteSelectionPageCC
                .waitForPageLoad("a psoriatic arthritis study")
                .getPID()
                .clickOnAnswer(site.name);
        switch (site) {
            case AUT_AMS1_5071_site:
                siteSelectionPageCC
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        //.clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad3()
                        .clickNextButton(selectActionPageCC);
                break;
            case AUT_AMS1_5071S_site:
                SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = siteSelectionPageCC
                        .clickNextButton(new SynexusRadiantDirectScheduleCC());
                synexusRadiantDirectScheduleCC
                        .waitForPageLoadSyn()
                        .assertVariablesNew("Acurian", "Trial", "08/09/1980", "US",
                                "Blue Bell, PA", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", " aut5071s ", " "+site.name,
                                "GILPPDPSA566 - Gilead Psoriatic Arthritis")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC);
                break;
        }
        selectActionPageCC.waitForPageLoad();
        if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env, "5071")
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
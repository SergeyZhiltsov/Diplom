package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DERM_4600_CC extends BaseTest {

    @Test()
    @Description("DERM 4600 CC Pfizer Atopic Derm")
    public void derm4600ccPadTest() {
        Site site = Site.AUT_AMS1_4600_site;
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "400"), "Title is diff");

        dateOfBirthPageCC
                .setMonth("Apr")
                .setDay("5")
                .setYear("2003")
                .clickOnAnswer("No") //If "No", go to Does Not Give Permission to Proceed Close
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("5")
                .setYear("2001")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        DiagnosedWithPsoriasisCC diagnosedWithPsoriasisCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No atopic dermatitis")
                .clickNextButton(new DiagnosedWithPsoriasisCC());

        diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0009397-QS5802-STUDYQUES", site.activeProtocols)
                .back();

        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_cc = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());

        HowMuchEczemaYouHaveOnYOurBody_CC howMuchEczemaYouHaveOnYOurBody_cc = howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("2 months or less") //Disqualify ("Atopic Derm < 1 year")
                .clickNextButton(new HowMuchEczemaYouHaveOnYOurBody_CC());
        howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", site.activeProtocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months") //Disqualify ("Atopic Derm < 1 year")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", site.activeProtocols)
                .back();

        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months") //Disqualify ("Atopic Derm < 1 year")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", site.activeProtocols)
                .back();

        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("1 year")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc);

        DollarBillsToCoverEczemaCC dollarBillsToCoverEczemaCC = howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .selectFromDropDown("6")
                .clickNextButton(new DollarBillsToCoverEczemaCC());

        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("6")
                .clickNextButton(new EczemaSymptomsExperienceCC());

        eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019076-QS5834-STUDYQUES", site.activeProtocols)
                .back();

        dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("7")
                .clickNextButton(eczemaSymptomsExperienceCC);

        LevelOfITCHWithEczemaCC levelOfITCHWithEczemaCC = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .clickOnAnswers("None")
                .clickNextButton(new LevelOfITCHWithEczemaCC());

        HowManyDaysHasSkinBeenItchyCC howManyDaysHasSkinBeenItchyCC = levelOfITCHWithEczemaCC
                .waitForPageLoad()
                .clickOnAnswer("Mildly itchy (Mildly irritating/Some scratching)")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyCC());

        HaveYouEverTreatedYourEczema_CC haveYouEverTreatedYourEczema_cc = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());

        haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019079-QS5837-STUDYQUES", site.activeProtocols)
                .back();

        WhichofthefollowingMedicationsTherapies_CC whichofthefollowingMedicationsTherapies_cc = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days")
                .clickNextButton(haveYouEverTreatedYourEczema_cc)
                .waitForPageLoad()
                .clickOnAnswer("Yes, within the past year")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_CC());

        DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_cc = whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickOnAnswers("Dupixent, also known as dupilumab (Agent Note: du-PIX-ent, du-PILL-you-mab)") //Disqualify (“Current biologic use”)
                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_CC());
        didYouReceiveAnyTherapiesPastYear_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", site.activeProtocols)
                .back(whichofthefollowingMedicationsTherapies_cc);
        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC =
                whichofthefollowingMedicationsTherapies_cc
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic") //Must ... in Q22 selected "Yes, within the past year"
                .back(whichofthefollowingMedicationsTherapies_cc)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_cc)
                .waitForPageLoad()
                .clickOnAnswer("Yes, but more than 1 year ago")
                .clickNextButton(whichofthefollowingMedicationsTherapies_cc)
                .waitForPageLoad()
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC)
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic")
                .back(whichofthefollowingMedicationsTherapies_cc)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_cc)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(whichofthefollowingMedicationsTherapies_cc);
        whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC)
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017871-QS5829-STUDYQUES", site.activeProtocols)
                .back(whichofthefollowingMedicationsTherapies_cc)
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_cc);

        didYouReceiveAnyTherapiesPastYear_cc
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC);

        List<String> medications = Arrays.asList(
                "Actemra (Agent Note: ac-TEM-ruh)",
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
                "Tysabri (Agent Note: tie-SAB-ree)"
        );
        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC = new HaveYouEverTakenEitherAnyOfFollowingMeds_CC();
        for (String medication : medications) {
            areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                    .waitForPageLoadKAD()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(medication)
                    .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", site.activeProtocols)
                    .back();
        }
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC);
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        HashMap<String, List<String>> disqualifyQ27 = new HashMap<>();
        disqualifyQ27.put("Jakafi (Agent Note: JAK-uh-fie)", Arrays.asList(site.activeProtocols)); //Disqualify (“History of JAK inhibitor use”)
        disqualifyQ27.put("Olumiant (Agent Note: oh-LOO-me-ant)", Arrays.asList(site.activeProtocols)); //Disqualify (“History of JAK inhibitor use”)
        disqualifyQ27.put("Xeljanz (Agent Note: ZEL-jans)", Arrays.asList(site.activeProtocols)); //Disqualify (“History of JAK inhibitor use”)
        for (Map.Entry<String, List<String>> entry : disqualifyQ27.entrySet()) {
            System.out.println(entry.getKey());
            haveYouEverTakenEitherAnyOfFollowingMeds_CC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0017453-QS5830-STUDYQUES", site.activeProtocols)
                    .back();
        }

        haveYouEverTakenEitherAnyOfFollowingMeds_CC
                .waitForPageLoad();
        haveYouEverTakenEitherAnyOfFollowingMeds_CC
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                transitionStatementCC
                        .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        //-------------------New GENERAL HEALTH---------------------------
        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder")
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Autism spectrum")
                .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickOnAnswers("High cholesterol, triglycerides, or lipids")
                .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)")
                .clickOnAnswers("Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickOnAnswers("Lupus")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, " +
                        "schizophrenia)")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                        "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickOnAnswers("Men's health issues (prostate enlargement or BPH, low testosterone)")
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
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        //Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", site.activeProtocols)
                .back(otherThanSkinCancerPageOLS);
        //Back to haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
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
        disqualifyQ121.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 3")
        disqualifyQ121.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent MI - Temp 3")
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
                    .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
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
        disqualifyQ122.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent stroke - Temp 3")
        disqualifyQ122.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent stroke - Temp 3")
        for (Map.Entry<String, List<String>> entry : disqualifyQ122.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.3: QS47C
        //Q12.3: QS47C
        HashMap<String, List<String>> disqualifyQ123 = new HashMap<>();
        disqualifyQ123.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent TIA - Temp 3")
        disqualifyQ123.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent TIA - Temp 3")
        for (Map.Entry<String, List<String>> entry : disqualifyQ123.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.4: QS47D
        //Q12.4: QS47D
        HashMap<String, List<String>> disqualifyQ124 = new HashMap<>();
        disqualifyQ124.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent angina - Temp 3")
        disqualifyQ124.put("1 - 3 months ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Recent angina - Temp 3")
        for (Map.Entry<String, List<String>> entry : disqualifyQ124.entrySet()) {
            System.out.println(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
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
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
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
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", site.activeProtocols)
                .back(whichOfTheFollowingLiverProblemsPageСС);
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Lupus") //Disqualify ("Lupus")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES", site.activeProtocols)
                .back();

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
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
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
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                        .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015145-QS55-STUDYQUES", site.activeProtocols)
                .back(whichOfTheFollowingSkinConditionsDoYouSufferСС);
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        FollowingMensHealthConditionsCC followingMensHealthConditionsCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                        .clickNextButton(new FollowingMensHealthConditionsCC());
        //Q22: QS57
        followingMensHealthConditionsCC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Men's health issues (prostate enlargement or BPH, low testosterone)")
                .clickNextButton(followingMensHealthConditionsCC);
        //Q22: QS57
        followingMensHealthConditionsCC
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
        HashMap<String, List<String>> disqualifyQ24 = new HashMap<>();
        disqualifyQ24.put("Bipolar disorder", Arrays.asList(site.activeProtocols)); //Disqualify ("Bipolar disorder")
        disqualifyQ24.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(site.activeProtocols)); //Cancer in the past 5 years, except skin cancer
        disqualifyQ24.put("Cirrhosis", Arrays.asList(site.activeProtocols)); //Disqualify ("Cirrhosis")
        disqualifyQ24.put("Drug or alcohol abuse within the past year", Arrays.asList(site.activeProtocols)); //Disqualify ("Substance abuse")
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
                    .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                    .back();
        }

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", site.activeProtocols)
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
                .checkProtocolsContainsForQNumber("Q0004980-QS60-STUDYQUES", site.activeProtocols)
                .back(approximateHeightPageCC);
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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        selectionPageCC
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}

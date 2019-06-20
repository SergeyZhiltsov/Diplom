package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.PSO_456.DiagnosedWithPsoriasisCC;
import com.acurian.selenium.pages.CC.closes.DoesNotGivePermissionToProceedClosePageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.*;

public class DERM_7036_CC extends BaseTest {

    @Test()
    @Description("DERM 7036 CC Kyowa Atopic Derm")
    public void derm7036ccTest() {
        Site site = Site.AUT_AMS1_7036_site;
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
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
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

        //Q3
        HowMuchEczemaYouHaveOnYOurBody_CC howMuchEczemaYouHaveOnYOurBody_cc = new HowMuchEczemaYouHaveOnYOurBody_CC();
        List<String> disqualifyQ3 = new LinkedList();
        disqualifyQ3.add("2 months or less"); //Disqualify ("Atopic Derm < 1 year")
        disqualifyQ3.add("3 - 6 months");
        disqualifyQ3.add("7 - 11 months");
        for (String answer : disqualifyQ3) {
            System.out.println(answer);
            howLongHaveYouBeenSufferingFromEczema_cc
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", site.activeProtocols)
                    .back();
        }
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("1 year")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc);

        //Q4
        DollarBillsToCoverEczemaCC dollarBillsToCoverEczemaCC = howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .selectFromDropDown("6")
                .clickNextButton(new DollarBillsToCoverEczemaCC());

        HowManyDaysHasSkinBeenItchyCC howManyDaysHasSkinBeenItchyCC = dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("6")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyCC());

        howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019076-QS5834-STUDYQUES", site.activeProtocols)
                .back(dollarBillsToCoverEczemaCC)
                .waitForPageLoad()
                .selectFromDropDown("7")
                .clickNextButton(howManyDaysHasSkinBeenItchyCC);

        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy") //Skip to Q21
                .clickNextButton(new EczemaSymptomsExperienceCC());
        RateAverageItchinessEczemaPageCC rateAverageItchinessEczemaPageCC = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .back(howManyDaysHasSkinBeenItchyCC)
                .waitForPageLoad()
                .clickOnAnswer("My skin is itchy every day")
                .clickNextButton(new RateAverageItchinessEczemaPageCC());

        rateAverageItchinessEczemaPageCC
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(eczemaSymptomsExperienceCC);

        //Q21
        HaveYouEverTreatedYourEczema_CC haveYouEverTreatedYourEczema_cc = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .clickOnAnswers("Redness",
                        "Swelling",
                        "Oozing/Crusting",
                        "Dryness",
                        "Scratch marks",
                        "Skin thickening")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());

        //Q22
        WhichofthefollowingMedicationsTherapies_CC whichofthefollowingMedicationsTherapies_CC = haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No") //Influence on Q25 Ghost Question - Atopic Derm Treatment History Logic
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_CC());
        //23
        DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_CC = whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)",
                        "CellCept or Myfortic, also known as mycophenolate (Agent Note: my-co-FEN-o-late)",
                        "Dupixent, also known as dupilumab (Agent Note: du-PIX-ent, du-PILL-you-mab)",
                        "Fasenra, also known as benralizumab (Agent Note: fa-SEN-ra, BEN-ra-LIZ-oo-mab)",
                        "Neoral, Sandimmune, or Gengraf, also known as cyclosporine (Agent Note: NEE-oh-ral, GEN-graf, cy-clo-SPOR-in)",
                        "Nucala, also known as mepolizumab (Agent Note: new-CA-la, MEP-oh-LIZ-oo-mab)",
                        "Methotrexate - Brand names: Otrexup, Rasuvo, Trexall (Agent Note: oh-TREX-up, ruh-SOO-vo, TREX-all)",
                        "Otezla, also known as apremilast (Agent Note: oh-TEZ-la, a-PRE-mi-last)",
                        "Prednisone - Brand names: Deltasone, Prednisone Intensol, Rayos (Agent Note: PRED-nis-own)",
                        "Phototherapy, Ultraviolet, or UV light")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Dupixent, also known as dupilumab (Agent Note: du-PIX-ent, du-PILL-you-mab)") //Disqualify (“Current biologic use”)
                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_CC());
        didYouReceiveAnyTherapiesPastYear_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", site.activeProtocols)
                .back(whichofthefollowingMedicationsTherapies_CC);

        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC =
        whichofthefollowingMedicationsTherapies_CC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above") //if selected "None of the above", skip to Q21 Q25 Ghost - Atopic Derm Treatment History Logic
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017871-QS5829-STUDYQUES", site.activeProtocols)
                .back();

        List<String> disqualifyQ25 = Arrays.asList(
                "Fasenra, also known as benralizumab (Agent Note: fa-SEN-ra, BEN-ra-LIZ-oo-mab)",
                "Nucala, also known as mepolizumab (Agent Note: new-CA-la, MEP-oh-LIZ-oo-mab)",
                "Otezla, also known as apremilast (Agent Note: oh-TEZ-la, a-PRE-mi-last)"
        );
        for(String disqualify: disqualifyQ25) {
            whichofthefollowingMedicationsTherapies_CC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(disqualify)
                    .clickNextButton(didYouReceiveAnyTherapiesPastYear_CC)
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC)
                    .waitForPageLoadKAD()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0017871-QS5829-STUDYQUES", site.activeProtocols)
                    .back(didYouReceiveAnyTherapiesPastYear_CC)
                    .waitForPageLoad()
                    .back(whichofthefollowingMedicationsTherapies_CC);
        }

        whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, " +
                        "ay-zuh-THI-o-prin)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_CC);

        didYouReceiveAnyTherapiesPastYear_CC
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
        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC =
                new HaveYouEverTakenEitherAnyOfFollowingMeds_CC();
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
        List<String> disqualifyQ27 = Arrays.asList("Jakafi (Agent Note: JAK-uh-fie)",
                "Olumiant (Agent Note: oh-LOO-me-ant)",
                "Xeljanz (Agent Note: ZEL-jans)");
        for (String disqualify: disqualifyQ27) {
            System.out.println(disqualify);
            haveYouEverTakenEitherAnyOfFollowingMeds_CC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(disqualify)
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
                "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                        "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                "Skin problems (eczema or atopic dermatitis, psoriasis)",
                "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                "Men's health issues (prostate enlargement or BPH, low testosterone)")
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
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay",
                        "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageCC()); //Display Q12.1: QS47A
        //Q12.1: QS47A
        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC =
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(4, "7 - 12 months ago")
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Skip to Q13
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());

        //Q13: QS48
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty",
                        "Stent placement",
                        "Atherectomy",
                        "Procedure to clear plaque from blood vessels in the neck such as carotid endarterectomy",
                        "Coronary artery bypass graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
                        "Revascularization")
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
                .clickOnAnswers("Lupus")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
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


        WhichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC whichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Sleep problems (insomnia, sleep apnea, narcolepsy)")
                        .clickNextButton(new WhichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC());

        //Q21: QS56
        whichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC
                .waitForPageLoad()
                .clickOnAnswers("Narcolepsy",
                        "Sleep apnea",
                        "Insomnia")
                .back();

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
        List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS");
        for (String disqualify: disqualifyQ24) {
            System.out.println(disqualify);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(disqualify)
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
                .setAll("3", "6", "100")
                .clickNextButton(new LetMeSeePageCC());

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

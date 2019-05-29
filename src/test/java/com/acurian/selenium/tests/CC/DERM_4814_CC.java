package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LPS_4442.EitherOfTheFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.PSO_456.DiagnosedWithPsoriasisCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.DERM_4814_OLS;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.*;

public class DERM_4814_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }


    @Test(enabled = true, dataProvider = "sites", dataProviderClass = DERM_4814_OLS.class)
    @Description("DERM_4814_CC_Test")
    public void derm4814ccTest(final Site site) {
        String phoneNumber = "AUTAMSDERM";
        String[] protocols = site.activeProtocols;
        String studyName = "an eczema (atopic dermatitis) study";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(),dateOfBirthPageCC.getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "400"), "Title is diff");

        dateOfBirthPageCC
                .setMonth("Apr")
                .setDay("5")
                .setYear("2003")
                .clickOnAnswer("No") //If "No", go to Does Not Give Permission to Proceed Close
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        dateOfBirthPageCC //Disqualify (“Age < 18 years old”) if <18
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        ZipCodePageCC zipCodePageCC  = dateOfBirthPageCC
                .waitForPageLoad()
                .setYear("2000")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        DebugPageCC debugPageCC = new DebugPageCC();

        //Q2 Atopic Derm
        DiagnosedWithPsoriasisCC diagnosedWithPsoriasisCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithPsoriasisCC());
        diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0009397-QS5802-STUDYQUES", protocols)
                .back();
        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_cc = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());
        //Q3
        HowMuchEczemaYouHaveOnYOurBody_CC howMuchEczemaYouHaveOnYOurBody_cc = new HowMuchEczemaYouHaveOnYOurBody_CC();
        List<String> disqualifyQ3 = new LinkedList();
        disqualifyQ3.add("2 months or less"); //Disqualify (“Atopic Derm < 2 years”)
        disqualifyQ3.add("3 - 6 months");
        disqualifyQ3.add("7 - 11 months");
        disqualifyQ3.add("1 year");
        for(String answer: disqualifyQ3)
        {
            System.out.println(answer);
            howLongHaveYouBeenSufferingFromEczema_cc
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", protocols)
                    .back();
        }
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("2 years")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc);
        //Q4
        DollarBillsToCoverEczemaCC dollarBillsToCoverEczemaCC = howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(new DollarBillsToCoverEczemaCC()); //If in CC, Skip to Q17
        //Q17
        HowManyDaysHasSkinBeenItchyCC howManyDaysHasSkinBeenItchyCC = dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyCC());
        //Q19
        howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019076-QS5834-STUDYQUES", protocols)
                .back(dollarBillsToCoverEczemaCC)
                .waitForPageLoad()
                .back(howMuchEczemaYouHaveOnYOurBody_cc);

        howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .selectFromDropDown("21+")
                .clickNextButton(dollarBillsToCoverEczemaCC)
                .waitForPageLoad()
                .selectFromDropDown("21+")
                .clickNextButton(howManyDaysHasSkinBeenItchyCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019076-QS5834-STUDYQUES", protocols)
                .back(dollarBillsToCoverEczemaCC)
                .waitForPageLoad()
                .selectFromDropDown("4")
                .clickNextButton(howManyDaysHasSkinBeenItchyCC);
        //Q19
        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy") //Disqualify ("No pruritus")
                .clickNextButton(new EczemaSymptomsExperienceCC());
        RateAaverageItchinessEczemaPageCC rateAaverageItchinessEczemaPageCC = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019079-QS5837-STUDYQUES", protocols)
                .back(howManyDaysHasSkinBeenItchyCC)
                .waitForPageLoad()
                .clickOnAnswer("My skin is itchy every day")
                .clickNextButton(new RateAaverageItchinessEczemaPageCC());
        //Q20
        rateAaverageItchinessEczemaPageCC
                .waitForPageLoad()
                .selectFromDropDown("0 - No itch")
                .clickNextButton(eczemaSymptomsExperienceCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020569-QS5838-STUDYQUES", protocols)
                .back(rateAaverageItchinessEczemaPageCC)
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(eczemaSymptomsExperienceCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020569-QS5838-STUDYQUES", protocols)
                .back(rateAaverageItchinessEczemaPageCC)
                .waitForPageLoad()
                .selectFromDropDown("2")
                .clickNextButton(eczemaSymptomsExperienceCC);

        //Q21
        HaveYouEverTreatedYourEczema_CC haveYouEverTreatedYourEczema_cc = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .clickOnAnswers("None")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());
        haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019077-QS5835-STUDYQUES", protocols)
                .back(eczemaSymptomsExperienceCC);

        eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .clickOnAnswers("Redness",
                        "Swelling",
                        "Oozing/Crusting",
                        "Dryness",
                        "Scratch marks",
                        "Skin thickening")
                .clickNextButton(haveYouEverTreatedYourEczema_cc);

        //Q23
        WhichofthefollowingMedicationsTherapies_CC whichofthefollowingMedicationsTherapies_CC = haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes, within the past year")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_CC());

        //Q23
        DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_CC = new DidYouReceiveAnyTherapiesPastYear_CC();
        List<String> disqualifyQ23 = new LinkedList();
        disqualifyQ23.add("Dupixent, also known as dupilumab (Agent Note: du-PIX-ent, du-PILL-you-mab)"); //Disqualify (“Current biologic use”)
        disqualifyQ23.add("Fasenra, also known as benralizumab (Agent Note: fa-SEN-ra, BEN-ra-LIZ-oo-mab)");
        disqualifyQ23.add("Nucala, also known as mepolizumab (Agent Note: new-CA-la, MEP-oh-LIZ-oo-mab)");
        disqualifyQ23.add("Otezla, also known as apremilast (Agent Note: oh-TEZ-la, a-PRE-mi-last)");
        for(String answer: disqualifyQ23)
        {
            System.out.println(answer);
            whichofthefollowingMedicationsTherapies_CC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(didYouReceiveAnyTherapiesPastYear_CC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", protocols)
                    .back();
        }
        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc =
        whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)",
                        "CellCept or Myfortic, also known as mycophenolate (Agent Note: my-co-FEN-o-late)",
                        "Neoral, Sandimmune, or Gengraf, also known as cyclosporine (Agent Note: NEE-oh-ral, GEN-graf, cy-clo-SPOR-in)",
                        "Methotrexate - Brand names: Otrexup, Rasuvo, Trexall (Agent Note: oh-TREX-up, ruh-SOO-vo, TREX-all)",
                        "Prednisone - Brand names: Deltasone, Prednisone Intensol, Rayos (Agent Note: PRED-nis-own)",
                        "Phototherapy, Ultraviolet, or UV light")
                .clickOnAnswers("None of the above") //if selected "None of the above", skip to Q25 Ghost - Atopic Derm Treatment History Logic
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());

        EitherOfTheFollowingMedicationsCC eitherOfTheFollowingMedicationsCC = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .clickOnAnswers("Cosentyx (Agent Note: co-SEN-tix)")
                .clickNextButton(new EitherOfTheFollowingMedicationsCC());
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", protocols)
                .back();
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .clickOnAnswers("Actemra  (Agent Note: ac-TEM-ruh)",
                        "Benlysta  (Agent Note: ben-LIST-uh)",
                        "Cimzia (Agent Note: SIM-zee-uh)",
                        "Cosentyx  (Agent Note: co-SEN-tix)",
                        "Enbrel (Agent Note: EN-brel)",
                        "Entyvio (Agent Note: en-TIV-ee-oh)",
                        "Humira (Agent Note: hue-MAIR-uh)",
                        "Kineret (Agent Note: KIN-er-et)",
                        "Orencia  (Agent Note: oh-REN-see-uh)",
                        "Prolia or Xgeva  (Agent Note: PRO-lee-uh, ex-GEE-vuh)",
                        "Raptiva (Agent Note: rap-TEE-vuh)",
                        "Remicade (Agent Note: REM-ih-cade)",
                        "Rituxan  (Agent Note: rih-TUX-an)",
                        "Simponi (Agent Note: SIM-po-nee)",
                        "Stelara (Agent Note: ste-LAHR-uh)",
                        "Taltz  (Agent Note: TALTS)",
                        "Tysabri  (Agent Note: tie-SAB-ree)")
                .clickOnAnswers("None of the above")
                .clickNextButton(eitherOfTheFollowingMedicationsCC);
        //Q27
        //DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_CC = new DidYouReceiveAnyTherapiesPastYear_CC();
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        List<String> disqualifyQ27 = new LinkedList();
        disqualifyQ27.add("Jakafi (Agent Note: JAK-uh-fie)"); //Disqualify (“History of JAK inhibitor use”)
        disqualifyQ27.add("Olumiant (Agent Note: oh-LOO-me-ant)");
        disqualifyQ27.add("Xeljanz (Agent Note: ZEL-jans)");
        for(String answer: disqualifyQ27)
        {
            System.out.println(answer);
            eitherOfTheFollowingMedicationsCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadWithCurvesKAD("eczema, or atopic dermatitis")
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0017453-QS5830-STUDYQUES", protocols)
                    .back();
        }
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurvesKAD("eczema, or atopic dermatitis")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
//General_Health
        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocols)
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5,"More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);

        KidneyProblemsPage kidneyProblemsPage = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new KidneyProblemsPage());

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocols)
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        WhichOfTheFollowingSkinConditionsDoYouSufferСС whichOfTheFollowingSkinConditionsDoYouSufferСС = followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocols)
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocols)
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferСС);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015145-QS55-STUDYQUES", protocols)
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        //Q24: QS59
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ24QS59 = new LinkedList();
        disqualifyQ24QS59.add("Bipolar disorder");
        disqualifyQ24QS59.add("Cancer in the past 5 years, except skin cancer");
        disqualifyQ24QS59.add("Cirrhosis");
        disqualifyQ24QS59.add("Drug or alcohol abuse within the past year");
        disqualifyQ24QS59.add("Hepatitis B");
        disqualifyQ24QS59.add("Hepatitis C");
        disqualifyQ24QS59.add("HIV or AIDS");
        for(String answer: disqualifyQ24QS59)
        {
            System.out.println(answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                    .back();
        }
        List<String> disqualifyQ24QS61 = new LinkedList();
        disqualifyQ24QS61.add("Kidney disease requiring dialysis");
        disqualifyQ24QS61.add("Schizophrenia");
        for(String answer: disqualifyQ24QS61)
        {
            System.out.println(answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        SiteSelectionPageCC siteSelectionPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();

        switch (site) {
            case AUT_AD4814_site: //1R
                siteSelectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .assertChildDOBIsNull(env, "4814");
                break;
            case AUT_AD4814S_site: //41C
                siteSelectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "04/05/2000", "US",
                                "Cincinnati, OH", site.zipCode, "qa.acurian@gmail.com",
                                "999 -999-9999", "123456a", site.name, "INCPPDATO303")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .assertChildDOBIsNull(env, "4814");
        }
    }
}
package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.SubquestionLastReceivedPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.GERD.HowLongHaveYouBeenTaking_CC;
import com.acurian.selenium.pages.CC.LPS_4442.EitherOfTheFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.RA.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class RA_4835_CC extends BaseTest {

    @Test(enabled = false)
    public void ra_4835_CC() {
        Site site = Site.AUT_RA_4835_Site;
        String compensation = "180";
        String indication = "a rheumatoid arthritis (RA) study";
        String phoneNumberOA = "AUTAMS1RA1";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        DebugPageCC debugPageCC = new DebugPageCC();

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
                .typePhoneNumber(phoneNumberOA)
                .clickPopupPhoneNumber(phoneNumberOA)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

//        dateOfBirthPageCC
//                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.getExpectedModifiedTitle(indication, compensation), "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
              //  .waitForPageLoad()
                .setMonth("Mar")
                .setDay("21")
                .setYear("2002") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
               // .waitForPageLoad()
                .setMonth("Mar")
                .setDay("21")
                .setYear("2001")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritisCC());
        //Module RA
        //Q2
        NonQRtransitionPageCC nonQRtransitionPageCC = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No arthritis")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005578-QS7102-STUDYQUES", site.activeProtocols)
                .back();

        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageCC());

        //Q3 Check if all checkbox option are available
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                whatKindOfArthritisPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging",
                                "Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                                "Psoriatic Arthritis",
                                "Unsure")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004962-QS7103-STUDYQUES", site.activeProtocols)
                .back();

        WhereYouHaveArthritisCC whereYouHaveArthritisCC = whatKindOfArthritisPageCC
                .waitForPageLoad()
                // Disqualify (“Psoriatic arthritis”)
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                        "Psoriatic Arthritis",
                        "Unsure")
                .clickNextButton(new WhereYouHaveArthritisCC());
        whereYouHaveArthritisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004962-QS7103-STUDYQUES", site.activeProtocols)
                .back();

        WhenYouDiagnosedWithRaPageCC whenYouDiagnosedWithRaPageCC = whatKindOfArthritisPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging",
                                "Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints") //Check QR //If selected "RA", continue to Q4
                        .clickNextButton(new WhenYouDiagnosedWithRaPageCC()); //If selected "RA", continue to Q4

        //Q4
        HowOldWereUWhenDiagnosedWithRACC howOldWereUWhenDiagnosedWithRACC = whenYouDiagnosedWithRaPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months") //Disqualify ("Recent RA diagnosis")
                .clickNextButton(new HowOldWereUWhenDiagnosedWithRACC());
        howOldWereUWhenDiagnosedWithRACC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019882-QS7104-STUDYQUES", site.activeProtocols)
                .back();

        whenYouDiagnosedWithRaPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(howOldWereUWhenDiagnosedWithRACC);
        //Q5
        TenderPainfulOrSwollenJointsCC tenderPainfulOrSwollenJointsCC = howOldWereUWhenDiagnosedWithRACC
                .waitForPageLoad()
                .typeAge("16") //If age of onset is < 17, disqualify (“Juvenile RA”)
                .clickNextButton(new TenderPainfulOrSwollenJointsCC());

        tenderPainfulOrSwollenJointsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(howOldWereUWhenDiagnosedWithRACC.titleExpected, site.activeProtocols)
                .back();

        howOldWereUWhenDiagnosedWithRACC
                .waitForPageLoad()
                .typeAge("18")
                .clickNextButton(tenderPainfulOrSwollenJointsCC);

        //Q6
        AreYouCurrentlyTakingMethotrexateCC areYouCurrentlyTakingMethotrexateCC = tenderPainfulOrSwollenJointsCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No swollen/tender joints")
                .clickNextButton(new AreYouCurrentlyTakingMethotrexateCC());
        areYouCurrentlyTakingMethotrexateCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(tenderPainfulOrSwollenJointsCC.titleExpected, site.activeProtocols)
                .back();

        tenderPainfulOrSwollenJointsCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(areYouCurrentlyTakingMethotrexateCC);
        //Q7
        FollowingMedicationsToTreatYourRACC followingMedicationsToTreatYourRACC = areYouCurrentlyTakingMethotrexateCC
                .waitForPageLoad()
                .clickOnAnswer("I am not taking methotrexate") //Skip to Q9
                .clickNextButton(new FollowingMedicationsToTreatYourRACC());
        //Q9
        followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .back(); //Back to Q7

        //Q7
        HowLongTakingMethotrexateCC howLongTakingMethotrexateCC = areYouCurrentlyTakingMethotrexateCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am taking methotrexate tablets or pills") //Continue to Q8
                .clickNextButton(new HowLongTakingMethotrexateCC());

        //Q8
        howLongTakingMethotrexateCC
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(followingMedicationsToTreatYourRACC);

        //Q9
        //Disqualify ("Excluded csDMARD")
        BiologicMedicationsCC biologicMedicationsCC = new BiologicMedicationsCC();
        HashMap<String, List<String>> disqualifyQ9 = new HashMap<>();
        disqualifyQ9.put("CellCept or Myfortic (mycophenolate mofetil)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Cuprimine or Depen (penicillamine)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Cytoxan (cyclophosphamide)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Imuran or Azasan (azathioprine)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Leukeran (chlorambucil)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Neoral, Gengraf, or Sandimmune (cyclosporine)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Gold salts such as Myochrysine, Solganal, or Ridaura (auranofin)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ9.entrySet()) {
            System.out.println(entry.getKey());
            followingMedicationsToTreatYourRACC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(biologicMedicationsCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0019900-QS7109-STUDYQUES", site.activeProtocols)
                    .back();
        }

        //Continue to Q10
        HowLongHaveYouBeenTaking_CC howLongHaveYouBeenTaking_CC = followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Aralen (chloroquine)", "Arava (leflunomide)",
                        "Azulfidine or Sulfazine (sulfasalazine)", "Plaquenil (hydroxychloroquine)") //Continue to Q10
                .clickNextButton(new HowLongHaveYouBeenTaking_CC());
        //Q10 Check that all Q10.1 - 10.4 displayed on the same page
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected8)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected9)
                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected10)
                .waitForPageLoad(4, howLongHaveYouBeenTaking_CC.titleExpected11)
        .back();

        //Q9
        followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arava (leflunomide)")
        //Disqualify in Q11	Ghost Question - RA csDMARD Protocol Logic:
        // ("Excluded csDMARD combo") if selected ["Yes, I am taking methotrexate tablets or pills" OR "Yes, I am taking methotrexate as injections or shots" in Q7] AND ["Arava (leflunomide)" in Q9]
                .clickNextButton(howLongHaveYouBeenTaking_CC);
       //Q10.2
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected9)
                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
                .clickNextButton(biologicMedicationsCC);
        biologicMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019930-QS7111-STUDYQUES", site.activeProtocols)
                .back();
        //Back to Q9
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected9)
                .back();
        //Q9
        followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Aralen (chloroquine)",
                        "Azulfidine or Sulfazine (sulfasalazine)")
                //Disqualify in Q11	Ghost Question - RA csDMARD Protocol Logic:
                //Disqualify ... OR 2 medications in Q9 AND ("Yes, I am taking methotrexate tablets or pills" OR "Yes, I am taking methotrexate as injections or shots" in Q7)"
                .clickNextButton(howLongHaveYouBeenTaking_CC);
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected8)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected10)
                .clickOnAnswerForSubQuestion(1, "1 month")
                .clickOnAnswerForSubQuestion(2, "1 month")
                .clickNextButton(biologicMedicationsCC);
        biologicMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
            .checkProtocolsEqualsForQNumber("Q0019930-QS7111-STUDYQUES", site.activeProtocols);

        //Back to Q7 to set "I am not taking methotrexate"
        biologicMedicationsCC
                .waitForPageLoad()
                .back();
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected8)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected10)
                .back();
        followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .back();
        howLongTakingMethotrexateCC
                .waitForPageLoad()
                .back();

        //Q7
        areYouCurrentlyTakingMethotrexateCC
                .waitForPageLoad()
                .clickOnAnswer("I am not taking methotrexate") //Skip to Q9
                .clickNextButton(followingMedicationsToTreatYourRACC);
        followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
        //Disqualify in Q11	Ghost Question - RA csDMARD Protocol Logic:
        //("3+ current csDMARDs") if selected: More than 2 medications in Q9 (3 or more csDMARDs)
                .clickOnAnswers("Aralen (chloroquine)",
                        "Azulfidine or Sulfazine (sulfasalazine)",
                        "Plaquenil (hydroxychloroquine)")
                .clickNextButton(howLongHaveYouBeenTaking_CC);
        //Q10 Check that all Q10.1, Q10.3 and Q10.4 displayed on the same page
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected8)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected10)
                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected11)
                .clickOnAnswerForSubQuestion(1, "1 month")
                .clickOnAnswerForSubQuestion(2, "1 month")
                .clickOnAnswerForSubQuestion(3, "1 month")
                .clickNextButton(biologicMedicationsCC);
        biologicMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0019930-QS7111-STUDYQUES", site.activeProtocols)
                .back();
        //Back to Q9
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected8)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected10)
                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected11)
                .back();

        //Q9
        followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                //Q From Q9: "Aralen (chloroquine)" OR "Arava (leflunomide)" OR "Azulfidine or Sulfazine (sulfasalazine)"
                // OR "Plaquenil (hydroxychloroquine)"
                //AND
                //From Q10.1 or Q10.2 or Q10.3 or Q10.4:
                //"1 month" OR "2 months" OR "3 months" OR "4 - 6 months" OR "7 months or longer"]"
                .clickOnAnswers("Azulfidine or Sulfazine (sulfasalazine)")
                .clickNextButton(howLongHaveYouBeenTaking_CC);
        //Q10.3
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected10)
                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
                .clickNextButton(biologicMedicationsCC);
        biologicMedicationsCC
            .waitForPageLoad()
            .getPage(debugPageCC)
            .checkProtocolsEqualsForQNumber("Q0019930-QS7111-STUDYQUES", site.activeProtocols)
            .back();
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected10)
                .clickOnAnswerForSubQuestion(1, "2 months")
                .clickNextButton(biologicMedicationsCC);

        //Q12
        SubquestionLastReceivedPageCC subquestionLastReceivedPageCC = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers( //Select all values to check it presence in the page
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
                        "Rituxan (Agent Note: rih-TUX-an)", //Continue to Q13
                        "Simponi (Agent Note: SIM-po-nee)",
                        "Stelara (Agent Note: ste-LAHR-uh)",
                        "Taltz (Agent Note: TALTS)",
                        "Tysabri (Agent Note: tie-SAB-ree)")
                .clickNextButton(new SubquestionLastReceivedPageCC());
        subquestionLastReceivedPageCC
                .waitForPageLoad(1, subquestionLastReceivedPageCC.titleExpected16) //Q13
                .back();
        EitherOfTheFollowingMedicationsCC eitherOfTheFollowingMedicationsCC = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Disqualify ("No qualifying biologic therapy”)
                .clickNextButton(new EitherOfTheFollowingMedicationsCC());
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad() //Q14
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005225-QS7112-STUDYQUES", site.activeProtocols)
                .back();
        //Q12
        //EitherOfTheFollowingMedicationsCC eitherOfTheFollowingMedicationsCC = biologicMedicationsCC
        biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)") //Skip to Q14
                .clickNextButton(eitherOfTheFollowingMedicationsCC);

        //Q14
        //Disqualify ("History of JAK inhibitor")
        HashMap<String, List<String>> disqualifyQ14 = new HashMap<>();
        disqualifyQ14.put("Jakafi (Agent Note: JAK-uh-fie)", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Olumiant (Agent Note: oh-LOO-me-ant)", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Xeljanz (Agent Note: ZEL-jans)", Arrays.asList(site.activeProtocols));
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        for (Map.Entry<String, List<String>> entry : disqualifyQ14.entrySet()) {
            System.out.println(entry.getKey());
            eitherOfTheFollowingMedicationsCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoad("RA")
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0017453-QS7114-STUDYQUES", site.activeProtocols)
                    .back();
        }
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);
        transitionStatementCC
                .waitForPageLoad("RA")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

//-------------------New GENERAL HEALTH---------------------------
        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers(//Select all values to check it presence in the page
                        "ADHD or attention deficit hyperactivity disorder",
                        "ADHD or attention deficit hyperactivity disorder",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis," +
                                " heartburn or GERD)",
                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's " +
                                "disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC());
        //Check flow logic for Q2
        //Q4: QS40
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingBreathingLungPageСС whichOfTheFollowingBreathingLungPageСС =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Lupus", //Deselect to remove DQ? Is checked bellow
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")  //Deselect
                .clickNextButton(new WhichOfTheFollowingBreathingLungPageСС());
        //Q5: QS41
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .back();

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        //Q6: QS42
        HashMap<String, List<String>> disqualifyQ6 = new HashMap<>();
        disqualifyQ6.put("Within the past 5 years", Arrays.asList(site.activeProtocols)); //Disqualify ("Cancer <= 5 years")
        disqualifyQ6.put("6 - 10 years ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Cancer > 5 years")
        disqualifyQ6.put("11 or more years ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Cancer > 5 years")
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = new WhatKindOfDiabetesPageCC();
        for (Map.Entry<String, List<String>> entry : disqualifyQ6.entrySet()) {
            System.out.println(entry.getKey());
            whenDiagnosedWithCancerCC
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(whatKindOfDiabetesPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", site.activeProtocols)
                    .back();
        }
        //Back to haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer") //Deselect
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        //Q6: QS42
                whatKindOfDiabetesPageCC
                        .waitForPageLoad()
                        .back();

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes (type 1 or type 2)") //Deselect
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());
        //Q8: QS44
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back();

        WhichTypeOfHeadacheDoYouGetCC whichTypeOfHeadacheDoYouGetCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("Digestive disorders (IBS or irritable bowel syndrome, IBD," +
                                " Crohn's disease, ulcerative colitis, heartburn or GERD)") //Deselect
                        .clickNextButton(new WhichTypeOfHeadacheDoYouGetCC());
        //Q10: QS45
        whichTypeOfHeadacheDoYouGetCC
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Headaches (migraine, cluster, tension)") //Deselect
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();

        DoYouTakeAnyMedicationsControlHypertension_CC doYouTakeAnyMedicationsControlHypertension_CC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)") //Deselect
                        .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC());
        //Q15: QS50
        doYouTakeAnyMedicationsControlHypertension_CC
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("High blood pressure or hypertension") //Deselect
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());
        //Q16: QS51
        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease") //Deselect
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());
        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .back();

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)") //Deselect
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());
        //Q18: QS53
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC whichOfFollowingHaveYouDiagnosedWith_neurologicalCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, " +
                                "depression, schizophrenia)") //Deselect
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC());
        //Q19: QS54
        WhichOfTheFollowingSkinConditionsDoYouSufferСС whichOfTheFollowingSkinConditionsDoYouSufferСС =
        whichOfFollowingHaveYouDiagnosedWith_neurologicalCC
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(new  WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015147-QS54-STUDYQUES", site.activeProtocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_neurologicalCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Fibromyalgia")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferСС);
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015147-QS54-STUDYQUES", site.activeProtocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_neurologicalCC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                        "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)") //Deselect
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());

        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .back();

        WomenHealthConditionsCC womenHealthConditionsCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)") //Deselect
                        .clickNextButton(new WomenHealthConditionsCC());
        //Q22: QS57
        womenHealthConditionsCC
                .waitForPageLoad()
                .back();
        //Flow for Q2: QS38 was checked

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Lupus") //Disqualify ("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES", site.activeProtocols)
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                .clickNextButton(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC);

        //Q4: QS40
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis") //Disqualify ("Ankylosing spondylitis") if selected this option OR "Yes" in AS Q2
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015115-QS40-STUDYQUES", site.activeProtocols)
                .back();

        //Q4: QS40
                whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Gout") //Disqualify ("Gout")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015115-QS40-STUDYQUES", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Deselect
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

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
        disqualifyQ24.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(site.activeProtocols)); //Cancer in the past 5 years, except skin cancer
        disqualifyQ24.put("Drug or alcohol abuse within the past year", Arrays.asList(site.activeProtocols)); //Disqualify ("Substance abuse")
        disqualifyQ24.put("Hepatitis B", Arrays.asList(site.activeProtocols)); //Disqualify ("HBV")
        disqualifyQ24.put("Hepatitis C", Arrays.asList(site.activeProtocols)); //Disqualify ("HCV")
        disqualifyQ24.put("HIV or AIDS", Arrays.asList(site.activeProtocols)); //Disqualify ("HIV")
        //disqualifyQ24.put("Kidney disease requiring dialysis", Arrays.asList((site.activeProtocols))); //Disqualify ("Dialysis")
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            System.out.println(entry.getKey());
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES" , site.activeProtocols)
                    .back();
        }

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(indication)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
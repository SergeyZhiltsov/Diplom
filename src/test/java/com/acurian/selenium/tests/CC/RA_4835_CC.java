package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.SubquestionLastReceivedPageCC;
import com.acurian.selenium.pages.CC.GERD.HowLongHaveYouBeenTaking_CC;
import com.acurian.selenium.pages.CC.LPS_4442.EitherOfTheFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.RA.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class RA_4835_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void ra_4835_CC(final String username, final String password) {
        Site site = Site.AUT_RA_4835_Site;
        String phoneNumberOA = "AUTAMS1RA1";
        String studyName = "Rheumatoid Arthritis";
        String studyName1 = "a rheumatoid arthritis (RA) study";
        String studyName2 = "RA";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        DebugPageCC debugPageCC = new DebugPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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

        dateOfBirthPageCC
                .waitForPageLoad();

        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedRA2821, "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("21")
                .setYear("2002") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad()
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
                .checkProtocolsEquals(doYouSufferFromArthritisCC.titleExpected, site.activeProtocols)
                .back();

        WhatKindOfArthritisCC whatKindOfArthritisCC = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisCC());

        //Q3 Check if all checkbox option are available
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                whatKindOfArthritisCC
                        .waitForPageLoad()
                        .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging",
                                "Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                                "Psoriatic Arthritis",
                                "Unsure")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Q0004962-QS7103-STUDYQUES", site.activeProtocols)
                .back();

        WhereYouHaveArthritisCC whereYouHaveArthritisCC = whatKindOfArthritisCC
                .waitForPageLoad()
                // Disqualify (“Psoriatic arthritis”)
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                        "Psoriatic Arthritis",
                        "Unsure")
                .clickNextButton(new WhereYouHaveArthritisCC());
        whereYouHaveArthritisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Q0004962-QS7103-STUDYQUES", site.activeProtocols)
                .back();

        WhenYouDiagnosedWithRaPageCC whenYouDiagnosedWithRaPageCC = whatKindOfArthritisCC
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
        disqualifyQ9.put("Cuprimine or Depen (penicillamine)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Cytoxan (cyclophosphamide)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Imuran or Azasan (azathioprine)", Arrays.asList(site.activeProtocols));
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
        followingMedicationsToTreatYourRACC
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
                .clickOnAnswerForSubQuestion(1, "1 month")
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
                .waitForPageLoad(1, subquestionLastReceivedPageCC.titleExpected11) //Q13
                .back();
        biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Disqualify ("No qualifying biologic therapy”)
                .clickNextButton(subquestionLastReceivedPageCC);
        subquestionLastReceivedPageCC
                .waitForPageLoad(1, subquestionLastReceivedPageCC.titleExpected11) //Q13
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber(biologicMedicationsCC.titleExpected, site.activeProtocols)
                .back();
        //Q12
        EitherOfTheFollowingMedicationsCC eitherOfTheFollowingMedicationsCC = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)") //Skip to Q14
                .clickNextButton(new EitherOfTheFollowingMedicationsCC());

        //Q14
        //Disqualify ("History of JAK inhibitor")
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        HashMap<String, List<String>> disqualifyQ14 = new HashMap<>();
        disqualifyQ14.put("Jakafi (Agent Note: JAK-uh-fie)", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Olumiant (Agent Note: oh-LOO-me-ant)", Arrays.asList(site.activeProtocols));
        disqualifyQ14.put("Xeljanz (Agent Note: ZEL-jans)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ14.entrySet()) {
            System.out.println(entry.getKey());
            eitherOfTheFollowingMedicationsCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoad(studyName2)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber(eitherOfTheFollowingMedicationsCC.titleExpected, site.activeProtocols)
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
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                //----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                //----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
//        .clickNextButton(new ChildrenUnderPageCC())
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        //----------PEDIATRIC HEALTH Questions----------
//        .clickNextButton(new HouseholdHavePageCC())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
                //----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(studyName)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.CurrentlyHaveAnyOffFollowingPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.BiologicMedicationsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.DiagnosedWithCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.WhenDiagnosedCrohnsPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.UC.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.*;

public class UC_4818_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(UC_4818_CC.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_4818UC_Site},
                {Site.AUT_AMS1_4818UCS_Site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("4818UC")
    public void uc4818CCTest(Site site) {
//        Site site = Site.AUT_AMS1_4818UC_Site;
        String phoneNumber = "AUTAMS1UC1";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
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
                .waitForPageLoad("a colitis study", "300");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(),
//                dateOfBirthPageCC.getExpectedModifiedTitle("a colitis study","300"),
        //              "Title is diff");
//
        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());
        doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .waitForPageLoad("a colitis study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad("a colitis study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad()
                .setMonth("Jul")
                .setDay("1")
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
                        .setYear("1937") //Disqualify ("Age") if >= 81
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC);
        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .waitForPageLoad()
                .setYear("1990")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());
//Q2	Have you ever been officially diagnosed by a doctor with any of the following digestive conditions?
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8202", site.activeProtocols)
                .back();
        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());

        whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8202", site.activeProtocols)
                .back(diagnosedWithCrohnsPageCC);

        WhenWereYouDiagnosedWithUCPageCC whenWereYouDiagnosedWithUCPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenWereYouDiagnosedWithUCPageCC());

//Q3	When were you diagnosed with ulcerative colitis?
        AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC =
                whenWereYouDiagnosedWithUCPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Less than 3 months ago")
                        .clickNextButton(new AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC());

        asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8203", site.activeProtocols)
                .back(whenWereYouDiagnosedWithUCPageCC)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC);

//Q4	As part of your ulcerative colitis diagnosis, have you ever had any of the following procedures done?
        HaveYouEverTakenAnyMedicationsToTreatYourUCPageCC haveYouEverTakenAnyMedicationsToTreatYourUCPageCC =
                asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HaveYouEverTakenAnyMedicationsToTreatYourUCPageCC());

        haveYouEverTakenAnyMedicationsToTreatYourUCPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS8204", site.activeProtocols)
                .back(asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC);

        asPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC
                .waitForPageLoad()
                .clickOnAnswers("Endoscopy – a thin, flexible, lighted tube is inserted through the mouth. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Colonoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the entire colon (large intestine). This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.",
                        "Sigmoidoscopy – a thin, flexible, lighted tube is inserted through the rectum and into the section of the colon (large intestine) closest to the rectum. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new HaveYouEverTakenAnyMedicationsToTreatYourUCPageCC());

//Q5	Have you ever taken any medications to treat or manage your colitis?
        HowManyBowelMovementsDidYouHaveDuringTheDayPageCC howManyBowelMovementsDidYouHaveDuringTheDayPageCC =
                haveYouEverTakenAnyMedicationsToTreatYourUCPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HowManyBowelMovementsDidYouHaveDuringTheDayPageCC());

        HaveYourEverTakenSteroidMedicationsForYourUCPageCC haveYourEverTakenSteroidMedicationsForYourUCPageCC =
                howManyBowelMovementsDidYouHaveDuringTheDayPageCC
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("QS8205", site.activeProtocols)
                        .back(haveYouEverTakenAnyMedicationsToTreatYourUCPageCC)
                        .clickOnAnswer("Yes")
                        .clickNextButton(new HaveYourEverTakenSteroidMedicationsForYourUCPageCC());

//Q6	Have you ever taken steroid medications for your ulcerative colitis?
        HaveYourEverTakenFollowingMedicationsUCPageCC haveYourEverTakenFollowingMedicationsUCPageCC =
                haveYourEverTakenSteroidMedicationsForYourUCPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new HaveYourEverTakenFollowingMedicationsUCPageCC());

        haveYourEverTakenFollowingMedicationsUCPageCC
                .waitForPageLoad()
                .back(haveYourEverTakenSteroidMedicationsForYourUCPageCC);

        haveYourEverTakenSteroidMedicationsForYourUCPageCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Choice connected with Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic
                .clickNextButton(haveYourEverTakenFollowingMedicationsUCPageCC);

//Q7    Have you ever taken any of the following medications for your ulcerative colitis?
        HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageCC haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageCC =
                haveYourEverTakenFollowingMedicationsUCPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("Mesalamine (Agent Note: MEZ-uh-luh-meen) medications, which include Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, and Rowasa",
                                "Azulfidine, also known as sulfasalazine (Agent Note: ay-ZULF-i-deen, sulf-uh-SAL-uh-zeen)",
                                "Colazal or Giazo, also known as balsalazide (Agent Note: COLE-uh-zal, gee-AH-zo, bal-SAL-uh-zide)",
                                "Dipentum, also known as olsalazine (Agent Note: di-PENT-um, ol-SAL-uh-zeen)",
                                "Unsure")
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageCC());

//Q8    Have you ever treated your ulcerative colitis with any of the following medications that suppress your immune system?
        BiologicMedicationsPageCC biologicMedicationsPageCC = haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageCC
                .waitForPageLoad()
                .clickOnAnswers("Astagraf, Envarsus, or Prograf, also known as tacrolimus (Agent Note: tah-CRO-li-mus)",
                        "Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)",
                        "CellCept or Myfortic, also known as mycophenolate (Agent Note: my-co-FEN-o-late)",
                        "Jakafi (Agent Note: JAK-uh-fie)",
                        "Methotrexate pills or tablets, also known as Rheumatrex or Trexall (Agent Note: ROOM-uh-trex)",
                        "Methotrexate injections or shots, also known as Otrexup or Rasuvo (Agent Note: oh-TREX-up, ruh-SOO-vo)",
                        "Purixan, also known as 6-MP or mercaptopurine (Agent Note: pure-RIX-an, mer-capt-oh-PURE-een)",
                        "Rapamune, also known as sirolimus (Agent Note: RAP-uh-mune, sir-OH-li-mus)",
                        "Sandimmune, Gengraf, or Neoral, also known as cyclosporine (Agent Note: GEN-graf, NEE-oh-ral, cy-clo-SPOR-in)",
                        "Xeljanz (Agent Note: ZEL-jans)",
                        "Unsure")
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageCC());

//Q9	"Biologics" are medications that affect the body's immune system. They are usually given as an infusion (into a vein) or a shot (injection)..
        List<String> disqualifyQ9 = Arrays.asList("Actemra",
                "Benlysta",
                "Cimzia",
                "Cosentyx",
                "Enbrel",
                "Entyvio",
                "Humira",
                "Kineret",
                "Orencia",
                "Prolia or Xgeva",
                "Raptiva",
                "Remicade",
                "Rituxan",
                "Simponi",
                "Stelara",
                "Taltz",
                "Tysabri");

        for (String answer : disqualifyQ9) {
            Log.info("Select answer for Q9: " + answer);
            biologicMedicationsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(howManyBowelMovementsDidYouHaveDuringTheDayPageCC)
                    .waitForPageLoad()
                    .back();
        }

        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(howManyBowelMovementsDidYouHaveDuringTheDayPageCC);

        //QS10  Ghost Question -  UC Treatment History Requirements Logic

        //DQ
        howManyBowelMovementsDidYouHaveDuringTheDayPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)//Ghost Question -  IBD Module Full Flow Treatment History Requirement Logic
                .checkProtocolsContainsForQNumber("QS8210", site.activeProtocols)
                .back(biologicMedicationsPageCC)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageCC);

        //Q - QS8 one of the listed medications
        haveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageCC
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)")
                .clickNextButton(biologicMedicationsPageCC)
                .waitForPageLoad()
                .clickNextButton(howManyBowelMovementsDidYouHaveDuringTheDayPageCC);

        //QS11-QS16 + QS17 Ghost Question - UC Flare Logic
        CurrentlyHaveAnyOffFollowingPageCC currentlyHaveAnyOffFollowingPageCC = new CurrentlyHaveAnyOffFollowingPageCC();

        HowManyBowelMovementsDidYouHaveAtNightPageCC howManyBowelMovementsDidYouHaveAtNightPageCC = new HowManyBowelMovementsDidYouHaveAtNightPageCC();
        HowMuchUrgencyDidYouFeelToHaveABowelMovementPageCC howMuchUrgencyDidYouFeelToHaveABowelMovementPageCC = new HowMuchUrgencyDidYouFeelToHaveABowelMovementPageCC();
        DidYouHaveBloodInYourStoolPageCC didYouHaveBloodInYourStoolPageCC = new DidYouHaveBloodInYourStoolPageCC();
        HowWouldYouRateYourGeneralWellBeingPageCC howWouldYouRateYourGeneralWellBeingPageCC = new HowWouldYouRateYourGeneralWellBeingPageCC();
        AreYouExperiencingAnyPainInYourJointsPageCC areYouExperiencingAnyPainInYourJointsPageCC = new AreYouExperiencingAnyPainInYourJointsPageCC();
        //in flare
        howManyBowelMovementsDidYouHaveDuringTheDayPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 to 6")
                .clickNextButton(howManyBowelMovementsDidYouHaveAtNightPageCC)
                .waitForPageLoad()
                .clickOnAnswer("4 or more")
                .clickNextButton(howMuchUrgencyDidYouFeelToHaveABowelMovementPageCC)
                .waitForPageLoad()
                .clickOnAnswer("I had to hurry to the bathroom")
                .clickNextButton(didYouHaveBloodInYourStoolPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No blood")
                .clickNextButton(howWouldYouRateYourGeneralWellBeingPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Poor")
                .clickNextButton(areYouExperiencingAnyPainInYourJointsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyHaveAnyOffFollowingPageCC);
        currentlyHaveAnyOffFollowingPageCC
                .waitForPageLoad()
                .getPage(debugPageCC);
//                    .checkStudyStatusContainsForQNumber("2-3"); //todo

        //back
        currentlyHaveAnyOffFollowingPageCC
                .waitForPageLoad()
                .back(areYouExperiencingAnyPainInYourJointsPageCC)
                .waitForPageLoad()
                .back(howWouldYouRateYourGeneralWellBeingPageCC)
                .waitForPageLoad()
                .back(didYouHaveBloodInYourStoolPageCC)
                .waitForPageLoad()
                .back(howMuchUrgencyDidYouFeelToHaveABowelMovementPageCC)
                .waitForPageLoad()
                .back(howManyBowelMovementsDidYouHaveAtNightPageCC)
                .waitForPageLoad()
                .back(howManyBowelMovementsDidYouHaveDuringTheDayPageCC);

        //not in flare
            howManyBowelMovementsDidYouHaveDuringTheDayPageCC
                    .waitForPageLoad()
                    .clickOnAnswer("4 to 6")
                    .clickNextButton(new HowManyBowelMovementsDidYouHaveAtNightPageCC())
                    .waitForPageLoad()
                    .clickOnAnswer("4 or more")
                    .clickNextButton(new HowMuchUrgencyDidYouFeelToHaveABowelMovementPageCC())
                    .waitForPageLoad()
                    .clickOnAnswer("I had to hurry to the bathroom")
                    .clickNextButton(new DidYouHaveBloodInYourStoolPageCC())
                    .waitForPageLoad()
                    .clickOnAnswer("No blood")
                    .clickNextButton(new HowWouldYouRateYourGeneralWellBeingPageCC())
                    .waitForPageLoad()
                    .clickOnAnswer("Poor")
                    .clickNextButton(new AreYouExperiencingAnyPainInYourJointsPageCC())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(currentlyHaveAnyOffFollowingPageCC);

            currentlyHaveAnyOffFollowingPageCC
                    .getPage(debugPageCC);
            // .checkStudyStatusContainsForQNumber("QS5730", "2-4"); //TODO*/


//Q18 - Do you currently have any of the following?
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC();
        HashMap<String, List<String>> disqualifyQ18 = new HashMap<>();
        disqualifyQ18.put("History of a bowel resection within the past 3 months", Arrays.asList(site.activeProtocols)); //Disqualify (“Crohn’s complication or surgery”)
        disqualifyQ18.put("Ileostomy", Arrays.asList(site.activeProtocols));
        disqualifyQ18.put("Feeding tube", Arrays.asList(site.activeProtocols));
        disqualifyQ18.put("IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)", Arrays.asList(site.activeProtocols));

        HashSet<String> disqualify7191 = new HashSet<>(); //options that cause DQ 7191->skip to end of module
        disqualify7191.add("Partial or Total colectomy");
        disqualify7191.add("Colostomy");
        disqualify7191.add("Ileostomy");

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = new WeightLossSurgeryPageCC();

        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();

        for (Map.Entry<String, List<String>> entry : disqualifyQ18.entrySet()) {
            Log.info(entry.getKey());
            currentlyHaveAnyOffFollowingPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey());
            if (/*disqualify7191.contains(entry.getKey())**/true) { //todo after 7191 activation

                currentlyHaveAnyOffFollowingPageCC
                        .clickNextButton(transitionStatementCC)
                        .waitForPageLoadWithCurves93("colitis")
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("Q0020441-QS8218-STUDYQUES", site.activeProtocols)
                        .back();
            } else {
                currentlyHaveAnyOffFollowingPageCC
                        .clickNextButton(weightLossSurgeryPageCC)
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("Q0020441-QS8218-STUDYQUES", site.activeProtocols)
                        .back();
            }
        }

 /*               currentlyHaveAnyOffFollowingPageCC //todo after 7191 activation
                currentlyHaveAnyOffFollowingPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(weightLossSurgeryPageCC);
//QS19 - Have you ever had any of the following types of bariatric or weight loss surgery?
                ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                        .clickOnAnswers("Gastric bypass", "Gastric sleeve or sleeve gastrectomy", "Duodenal switch",
                                "Lap band or gastric banding", "Gastric balloon")
                        .clickNextButton(new ProcedureForWeightLossPageCC());

//QS20 - When was the last time that you had a surgery or medical procedure for weight loss?
                        .waitForPageLoadWithCurves("colitis")
                        .back(procedureForWeightLossPageCC)
                        .waitForPageLoad()
                        .back(weightLossSurgeryPageCC);

                weightLossSurgeryPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(transitionStatementCC)
                        .waitForPageLoadWithCurves("colitis");
*/

 /*     currentlyHaveAnyOffFollowingPageCC //todo after 7191 activation
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(weightLossSurgeryPageCC);
//QS19 - Have you ever had any of the following types of bariatric or weight loss surgery?
                ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                        .clickOnAnswers("Gastric bypass", "Gastric sleeve or sleeve gastrectomy", "Duodenal switch",
                                "Lap band or gastric banding", "Gastric balloon")
                        .clickNextButton(new ProcedureForWeightLossPageCC());

//QS20 - When was the last time that you had a surgery or medical procedure for weight loss?
                procedureForWeightLossPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Less than 3 months ago")
                        .clickNextButton(transitionStatementCC)
                        .waitForPageLoadWithCurves("colitis")
                        .back(procedureForWeightLossPageCC)
                        .waitForPageLoad()
                        .back(weightLossSurgeryPageCC);

                weightLossSurgeryPageCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(transitionStatementCC)
                        .waitForPageLoadWithCurves("colitis");

*/

        currentlyHaveAnyOffFollowingPageCC //todo after 7191 activation
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        transitionStatementCC
                .waitForPageLoadWithCurves93("colitis")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

//GH            
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough",
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
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .back();
        //debugPageCC.checkProtocolsContainsForQNumber("QS42", site.activeProtocols);
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerCC
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC.back();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQS59 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS"); //Kidney disease requiring dialysis is not displayed
        for (String answer : disqualifyQS59) {
            Log.info("Select answer for QS59: " + answer);
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
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        IdentificationPageCC identificationPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "7", "170")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());

        switch (site) {

            case AUT_AMS1_4818UC_Site:

                MedicalRecordsOptionPageCC medicalRecordsOptionPageCC = identificationPageCC
                    .waitForPageLoad()
                    .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                            "9999999999", site.zipCode)
                    .clickNextButton(new SiteSelectionPageCC())
                    .waitForPageLoad("a colitis study")
                    .getPID()
                    .clickOnAnswer(site.name)
                    .clickNextButton(new MedicalRecordsOptionPageCC());


                medicalRecordsOptionPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Continue with medical records")
                        .clickNextButton(new DoctorInformationCollectionPageCC())
                        .waitForPageLoadIBD("Ulcerative Colitis")
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
//                .clickNextButton(new QualifiedClose1PageCC())
//                .waitForPageLoad()
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad3()

                    .clickNextButton(selectActionPageCC)
                        .waitForPageLoad();
                if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
                    selectActionPageCC
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            //.assertGeneratedFul(env, site)
                            .dispoShouldMatch(site.dispo, site.dispo, "4818");
                }
            break;

            case AUT_AMS1_4818UCS_Site:

                identificationPageCC
                        .waitForPageLoad()
                        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                                "9999999999", site.zipCode)
                        .clickNextButton(new SiteSelectionPageCC())
                        .waitForPageLoad("a colitis study")
                        .getPID()
                        .clickOnAnswer(site.name)
//                .clickNextButton(new QualifiedClose2PageCC())
//                .waitForPageLoadCrohns4818()
                        .clickNextButton(new MedicalRecordsOptionPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue with medical records")
                        .clickNextButton(new DoctorInformationCollectionPageCC())
                        .waitForPageLoadIBD("Ulcerative Colitis")
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariablesNew("Acurian", "Trial", "07/01/1990", "US", // maybe need to use another method
                                "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", "%SYN_SITE_NUM%", site.name,
                                "ALLXXXULC151 - Allergan Ulcerative Colitis (UC) Expedition")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
//                .clickNextButton(new AlzheimerClosePageCC())
//                .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad();
                if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
                    selectActionPageCC
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            //.assertGeneratedFul(env, site)
                            .dispoShouldMatch(site.dispo, site.dispo, "4818");
                }
                break;



        }
    }
}
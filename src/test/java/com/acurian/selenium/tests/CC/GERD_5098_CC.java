package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns.EverDiagnosedWithFollowingConditionsСС;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.GERD.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class GERD_5098_CC extends BaseTest {


    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_5098_site},
                {Site.AUT_AMS1_5098S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("Phathom EE & HP OLS")
    public void gerd5098cc(Site site) {
        final String phoneNumber = "AUTAMSGER1";
        final String studyName = "an indigestion, heartburn, or stomach ulcers study";

        String env = System.getProperty("acurian.env", "STG");
        DebugPageCC debugPageCC = new DebugPageCC();
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
                .waitForPageLoad2("an indigestion, heartburn, or stomach ulcers study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No") //If "No", go to Does Not Give Permission to Proceed Close
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad2("an indigestion, heartburn, or stomach ulcers study", "300")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        EverDiagnosedWithFollowingConditionsСС everDiagnosedWithFollowingConditionsCC = new EverDiagnosedWithFollowingConditionsСС();

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .setDay("1")
                .setMonth("Jan")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        CurrentlySufferOfAnyOfFollowingCC currentlySufferOfAnyOfFollowingCC = genderPageCC
                .waitForPageLoad()
                .setYear("1990")
                .clickNextButton(new CurrentlySufferOfAnyOfFollowingCC());

        //---------------Q2 DoYouExperienceAnyOfFollowingSymptoms_OLS page-------------------
        DuringPastThreeMonthsCC duringPastThreeMonthsCC = currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DuringPastThreeMonthsCC());
        duringPastThreeMonthsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6333", site.activeProtocols[0])
                .back();

        currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("Stomach ulcer or peptic ulcer")
                .clickNextButton(duringPastThreeMonthsCC);
        duringPastThreeMonthsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6333", site.activeProtocols[0])
                .back();

        //Q2
        HowLongHavingSymptomsCC howLongHavingSymptomsCC = currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Acid reflux")
                .clickNextButton(new HowLongHavingSymptomsCC());

        howLongHavingSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(duringPastThreeMonthsCC);
        HowManyDaysPerWeekHaveSymptomsCC howManyDaysPerWeekHaveSymptomsCC = duringPastThreeMonthsCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HowManyDaysPerWeekHaveSymptomsCC());
        howManyDaysPerWeekHaveSymptomsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6339", site.activeProtocols[1])
                .back(duringPastThreeMonthsCC)
                .waitForPageLoad()
                .back(howLongHavingSymptomsCC)
                .waitForPageLoad()
                .back(currentlySufferOfAnyOfFollowingCC);

        currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("GERD that is still causing symptoms",
                        "Heartburn or indigestion",
                        "Acid reflux",
                        "Pain in the top of the stomach, or upper stomach pain")
                .clickNextButton(howLongHavingSymptomsCC);

        //Q3
        howLongHavingSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(duringPastThreeMonthsCC);

        duringPastThreeMonthsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6334", site.activeProtocols[0])
                .back(howLongHavingSymptomsCC);
        howLongHavingSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("1 month")
                .clickNextButton(duringPastThreeMonthsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6334", site.activeProtocols[0])
                .back(howLongHavingSymptomsCC)
                .waitForPageLoad()
                .clickOnAnswer("I used to have these symptoms but they are not troubling me right now")
                .clickNextButton(duringPastThreeMonthsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6334", site.activeProtocols[0])
                .back(howLongHavingSymptomsCC);

        howLongHavingSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(duringPastThreeMonthsCC);

        duringPastThreeMonthsCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(howManyDaysPerWeekHaveSymptomsCC);

        howManyDaysPerWeekHaveSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("1 day per week or less")
                .clickNextButton(everDiagnosedWithFollowingConditionsCC);

        everDiagnosedWithFollowingConditionsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6337", site.activeProtocols[0])
                .back(howManyDaysPerWeekHaveSymptomsCC)
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days per week")
                .clickNextButton(everDiagnosedWithFollowingConditionsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6337", site.activeProtocols[0])
                .back(howManyDaysPerWeekHaveSymptomsCC)
                .waitForPageLoad()
                .clickOnAnswer("Not currently experiencing symptoms")
                .clickNextButton(everDiagnosedWithFollowingConditionsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6337", site.activeProtocols[0])
                .back(howManyDaysPerWeekHaveSymptomsCC);

        CurrentlyTakeMedicationPrescribedByHealthcareProvider_CC
                currentlyTakeMedicationPrescribedByHealthcareProvider_CC = howManyDaysPerWeekHaveSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 days per week")
                .clickNextButton(new CurrentlyTakeMedicationPrescribedByHealthcareProvider_CC());

        DoYouRegularlyTakeCC doYouRegularlyTakeCC = currentlyTakeMedicationPrescribedByHealthcareProvider_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DoYouRegularlyTakeCC());

        doYouRegularlyTakeCC
                .waitForPageLoad()
                .clickOnAnswer("No") //----DQ
                .clickNextButton(everDiagnosedWithFollowingConditionsCC);
        everDiagnosedWithFollowingConditionsCC
                .waitForPageLoad()
                .back(doYouRegularlyTakeCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(everDiagnosedWithFollowingConditionsCC);
//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC();
//
//        WhichoOfFollowingMedicationsCurrentlyGERD_CC whichoOfFollowingMedicationsCurrentlyGERD_CC =  currentlyTakeMedicationPrescribedByHealthcareProvider_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_CC());
//        whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .waitForPageLoad2()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Nexium (Agent Note: NEX-ee-um)",
//                        "Prevacid (Agent Note: PREV-uh-sid)",
//                        "Prilosec (Agent Note: PRY-lo-sec)",
//                        "Zegerid (Agent Note: ZEGG-er-rid)")
//                .clickNextButton(everDiagnosedWithFollowingConditionsCC);
//        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad2()
//                .clickOnAnswer("4 - 5 days per week")
//                .clickNextButton(everDiagnosedWithFollowingConditionsCC);
        WhatTypeOfSurgeryDidYouHave_CC whatTypeOfSurgeryDidYouHave_CC = everDiagnosedWithFollowingConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("Erosive esophagitis or esophageal erosions, sores or breaks in the lining of the esophagus")
                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_CC());

        WhenDidYouHaveAppendixRemoved_CC whenDidYouHaveAppendixRemoved_CC = whatTypeOfSurgeryDidYouHave_CC
                .waitForPageLoad()
                .clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)",
                        "Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)",
                        "Biopsy (Agent Note: BY-op-see) – removal of a small piece of tissue for analysis",
                        "Tonsils removed - Tonsillectomy (Agent Note: tahn-sil-LECK-toe-mee)",
                        "Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)")
                .clickNextButton(new WhenDidYouHaveAppendixRemoved_CC());
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_CC.titleExpected3);

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(new WeightLossSurgeryPageCC());

        UseMarijuanaOrCannabisCC useMarijuanaOrCannabisCC = new UseMarijuanaOrCannabisCC();

        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(useMarijuanaOrCannabisCC);
        useMarijuanaOrCannabisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
//                .back(transitionStatementCC)
//                .waitForPageLoadDYS()
                .back(useMarijuanaOrCannabisCC)
                .waitForPageLoad()
                .back(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .back(whenDidYouHaveAppendixRemoved_CC)
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_CC.titleExpected3)
                .back(whatTypeOfSurgeryDidYouHave_CC);

        whatTypeOfSurgeryDidYouHave_CC
                .waitForPageLoad()
                .back();

        everDiagnosedWithFollowingConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Zollinger-Ellison syndrome, a condition that causes the stomach to produce too much acid")
                .clickNextButton(whatTypeOfSurgeryDidYouHave_CC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6332", site.activeProtocols)
                .back();

        DidTakeMedicationToTreatPyloriCC didTakeMedicationToTreatPyloriCC = everDiagnosedWithFollowingConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Helicobacter pylori or H. pylori infection")
                .clickNextButton(new DidTakeMedicationToTreatPyloriCC());
        didTakeMedicationToTreatPyloriCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(whatTypeOfSurgeryDidYouHave_CC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6323", site.activeProtocols[1])
                .back();

        didTakeMedicationToTreatPyloriCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(whatTypeOfSurgeryDidYouHave_CC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC)
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected4)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6310", site.activeProtocols)
                .back(whatTypeOfSurgeryDidYouHave_CC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(weightLossSurgeryPageCC);

        List<String> disqualifyQ26pt2 = Arrays.asList("Gastric bypass", "Gastric sleeve or sleeve gastrectomy",
                "Duodenal switch", "Lap band or gastric banding",
                "Gastric balloon", "I had a weight loss surgery, but I am unsure which type");
        for (String answer : disqualifyQ26pt2) {
            System.out.println("Select answer for Q26: " + answer);
            weightLossSurgeryPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(new ProcedureForWeightLossPageCC())
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6327", site.activeProtocols)
                    .back();
        }

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC();

        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(useMarijuanaOrCannabisCC);

        useMarijuanaOrCannabisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6338", site.activeProtocols)
                .back(useMarijuanaOrCannabisCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadDYS()
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);


//        WhichoOfFollowingMedicationsCurrentlyGERD_CC whichoOfFollowingMedicationsCurrentlyGERD_CC =
//                doYouExperienceAnyOfFollowingSymptoms_CC
//                        .waitForPageLoad()
//                        .clickOnAnswers("GERD which has been diagnosed by a medical professional",
//                                "Dyspepsia which has been diagnosed by a medical professional",
//                                "Heartburn, which can be felt as pain or a burning sensation behind the breastbone",
//                                "Acid reflux or frequent regurgitation, which is a sensation of liquid or food coming back up into your throat without vomiting",
//                                "Frequent indigestion", "Upper abdomen pain or discomfort",
//                                "Stomach ulcer or peptic ulcer")
//                        .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_CC());
//
//
//        //---------------Q3 WhichoOfFollowingMedicationsCurrentlyGERD_OLS-------------------
//        HasYourDoctorToldYouThatYouHaveErosion_CC hasYourDoctorToldYouThatYouHaveErosion_CC =
//                whichoOfFollowingMedicationsCurrentlyGERD_CC
//                        .waitForPageLoad()
//                        .clickOnAnswers("None of the above")
//                        .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC());
//        hasYourDoctorToldYouThatYouHaveErosion_CC
//                .waitForPageLoad()
//                .back();
//        whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .waitForPageLoad()
//                .clickOnAnswers("Other")
//                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_CC);
//        hasYourDoctorToldYouThatYouHaveErosion_CC
//                .waitForPageLoad()
//                .back();
//        HowLongHaveYouBeenTaking_CC howLongHaveYouBeenTaking_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .waitForPageLoad()
//                //----SKIP to Q5 if selected any of these options in Q3:  Aciphex (rabeprazole), Dexilant (dexlansoprazole), Protonix (pantoprazole), None of the above
//                .clickOnAnswers("Aciphex, also known as rabeprazole (Agent Note: AH-si-fex, ruh-BEP-ruh-zole)",
//                        "Dexilant, also known as dexlansoprazole (Agent Note: DEX-ih-lant, dex-lan-SOP-ruh-zole)",
//                        "Protonix, also known as pantoprazole (Agent Note: pro-TAHN-ix, pan-TOP-ruh-zole)")
//                .clickNextButton(new HowLongHaveYouBeenTaking_CC());
//        howLongHaveYouBeenTaking_CC
//                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected5)
//                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected6)
//                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected7)
//                .back();
//        HowDoYouBuyFollowingMedications_CC howDoYouBuyFollowingMedications_CC =
//                whichoOfFollowingMedicationsCurrentlyGERD_CC
//                        .waitForPageLoad()
//                        .clickOnAnswers("None of the above")
//                        .clickOnAnswers("Nexium, also known as esomeprazol (Agent Note: NEX-ee-um, eh-so-MEP-ruh-zole)",
//                                "Prevacid, also known as lansoprazole (Agent Note: PREV-uh-sid, lan-SOP-ruh-zole)",
//                                "Prilosec, also known as omeprazole (Agent Note: PRY-lo-sec, oh-MEP-ruh-zole)",
//                                "Zegerid, also known as omeprazole and sodium bicarbonate (Agent Note: ZEGG-er-rid, oh-MEP-ruh-zole, SO-dee-um bi-CAR-bo-nate)")
//                        .clickNextButton(new HowDoYouBuyFollowingMedications_CC());
//
//
//        //----------------Q4 HowDoYouBuyFollowingMedications_OLS --------------
//        howDoYouBuyFollowingMedications_CC
//                .waitForPageLoad(1, howDoYouBuyFollowingMedications_CC.titleExpected1)
//                .waitForPageLoad(2, howDoYouBuyFollowingMedications_CC.titleExpected2)
//                .waitForPageLoad(3, howDoYouBuyFollowingMedications_CC.titleExpected3)
//                .waitForPageLoad(4, howDoYouBuyFollowingMedications_CC.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "With a prescription from my doctor that I get filled at the pharmacy counter")
//                .clickOnAnswerForSubQuestion(2, "I get this medication off the shelf, or \"over-the-counter\"")
//                .clickOnAnswerForSubQuestion(3, "With a prescription from my doctor that I get filled at the pharmacy counter")
//                .clickOnAnswerForSubQuestion(4, "I get this medication off the shelf, or \"over-the-counter\"")
//                .clickNextButton(howLongHaveYouBeenTaking_CC);
//
//
//        //---------------Q5 HowLongHaveYouBeenTaking_OLS-------------------
//        HowOftenDoYouTake_CC howOftenDoYouTake_CC = howLongHaveYouBeenTaking_CC
//                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected1)
//                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected2)
//                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected3)
//                .waitForPageLoad(4, howLongHaveYouBeenTaking_CC.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
//                .clickOnAnswerForSubQuestion(2, "1 month")
//                .clickOnAnswerForSubQuestion(3, "2 months")
//                .clickOnAnswerForSubQuestion(4, "3 - 5 months")
//                .clickOnAnswerForSubQuestion(4, "6 or more months")
//                .clickNextButton(new HowOftenDoYouTake_CC());
//
//
//        //---------------Q7 HowOftenDoYouTake_OLS-------------------
//        DespiteTakingMedicationDoYouStillExperienceSymptoms_CC despiteTakingMedicationDoYouStillExperienceSymptoms_CC =
//                howOftenDoYouTake_CC
//                        .waitForPageLoad(1, howOftenDoYouTake_CC.titleExpected1)
//                        .waitForPageLoad(2, howOftenDoYouTake_CC.titleExpected2)
//                        .waitForPageLoad(3, howOftenDoYouTake_CC.titleExpected3)
//                        .waitForPageLoad(4, howOftenDoYouTake_CC.titleExpected4)
//                        .clickOnAnswerForSubQuestion(1, "Only as needed (not regularly)")
//                        .clickOnAnswerForSubQuestion(2, "Once a day")
//                        .clickOnAnswerForSubQuestion(3, "Only as needed (not regularly)")
//                        .clickOnAnswerForSubQuestion(4, "Once a day")
//                        .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
//
//
//        //---------------Q10 DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS-------------------
//        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No, my symptoms are well-controlled")
//                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_CC)
//                .waitForPageLoad()
//                .back();
//        ThinkingAboutThePast2Months_CC thinkingAboutThePast2Months_OLS =
//                despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                        .waitForPageLoad()
//                        .clickOnAnswer("Yes, I still have symptoms")
//                        .clickNextButton(new ThinkingAboutThePast2Months_CC());
//
//
//        //--------------Q11 ThinkingAboutThePast2Months_OLS ---------------------
//        thinkingAboutThePast2Months_OLS
//                .waitForPageLoad()
//                .clickOnAnswer("1 day per week or less")
//                .clickOnAnswer("2 - 3 days per week")
//                .clickOnAnswer("4 - 5 days per week")
//                .clickOnAnswer("6 - 7 days per week")
//                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_CC);
//
//
//        //--------------Q12 HasYourDoctorToldYouThatYouHaveErosion_OLS---------------------
//        TestedForStomachInfectionHelicobacterCC testedForStomachInfectionHelicobacterCC =
//                hasYourDoctorToldYouThatYouHaveErosion_CC
//                        .waitForPageLoad()
//                        .clickOnAnswer("Yes")
//                        .clickOnAnswer("No")
//                        .clickOnAnswer("Unsure")
//                        .clickNextButton(new TestedForStomachInfectionHelicobacterCC());
//
//
//        DidTestPositivePyloriCC didTestPositivePyloriCC = testedForStomachInfectionHelicobacterCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes") //Continue to Q14
//                .clickNextButton(new DidTestPositivePyloriCC());
//        DidTakeMedicationToTreatPyloriCC didTakeMedicationToTreatPyloriCC = didTestPositivePyloriCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes") //Continue to Q15
//                .clickNextButton(new DidTakeMedicationToTreatPyloriCC());
//        MembersOfHouseholdBeenDiagnosedPyloriCC membersOfHouseholdBeenDiagnosedPyloriCC = didTakeMedicationToTreatPyloriCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new MembersOfHouseholdBeenDiagnosedPyloriCC());
//        membersOfHouseholdBeenDiagnosedPyloriCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6323", site.activeProtocols[1])
//                .back(didTakeMedicationToTreatPyloriCC)
//                .clickOnAnswer("No")
//                .clickOnAnswer("Unsure")
//                .back();
//        didTestPositivePyloriCC
//                .waitForPageLoad()
//                .clickOnAnswer("No, I tested negative")
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new MembersOfHouseholdBeenDiagnosedPyloriCC());
//        membersOfHouseholdBeenDiagnosedPyloriCC
//                .waitForPageLoad()
//                .back(didTestPositivePyloriCC)
//                .waitForPageLoad()
//                .back(testedForStomachInfectionHelicobacterCC)
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickOnAnswer("Unsure")
//                .clickNextButton(membersOfHouseholdBeenDiagnosedPyloriCC);
//
//        DoYouHaveZollingerEllisonSyndrome_CC doYouHaveZollingerEllisonSyndrome_CC = membersOfHouseholdBeenDiagnosedPyloriCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickOnAnswer("No")
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new DoYouHaveZollingerEllisonSyndrome_CC());
//
//        WhatTypeOfSurgeryDidYouHave_CC whatTypeOfSurgeryDidYouHave_CC = doYouHaveZollingerEllisonSyndrome_CC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_CC())
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6326", site.activeProtocols)
//                .back(doYouHaveZollingerEllisonSyndrome_CC)
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_CC());
//        //---------------Q14 WhatTypeOfSurgeryDidYouHave_OLS-------------------
//        WeightLossSurgeryPageCC weightLossSurgeryPageCC = whatTypeOfSurgeryDidYouHave_CC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above") //Skip to Q20
//                .clickNextButton(new WeightLossSurgeryPageCC());
//
//        List<String> disqualify = Arrays.asList("Gastric bypass",
//                "Gastric sleeve or sleeve gastrectomy",
//                "Duodenal switch",
//                "Lap band or gastric banding",
//                "Gastric balloon", "I had a weight loss surgery, but I am unsure which type");
//        for (String answer : disqualify) {
//            System.out.println(answer);
//            weightLossSurgeryPageCC
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(answer)
//                    .clickNextButton(new ProcedureForWeightLossPageCC())
//                    .waitForPageLoad()
//                    .getPage(debugPageCC)
//                    .checkProtocolsContainsForQNumber("QS6327", site.activeProtocols)
//                    .back();
//        }
//
//        AreYouCurrentlyAbleToSwallowTablets_CC areYouCurrentlyAbleToSwallowTablets_CC = weightLossSurgeryPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC());
//
//
////        areYouCurrentlyAbleToSwallowTablets_CC
////                .waitForPageLoad()
////                .clickOnAnswer("Yes")
////                .clickNextButton()
////                .back(haveYouEverHadAnyOfBatriatic_CC)
////                .waitForPageLoad()
////                .clickOnAnswers("Biopsy (Agent Note: BY-op-see) – removal of a small piece of tissue for analysis",
////                        "Tonsils removed - Tonsillectomy (Agent Note: tahn-sil-LECK-toe-mee)")
////                .clickNextButton(areYouCurrentlyAbleToSwallowTablets_CC)
////                .waitForPageLoad()
////                .back();
////        WhenDidYouHaveAppendixRemoved_CC whenDidYouHaveAppendixRemoved_OLS = whatTypeOfSurgeryDidYouHave_CC
////                .waitForPageLoad()
////                .clickOnAnswers("None of the above")
////                .clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)",
////                        "Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)",
////                        "Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)",
////                        "Other surgery on my stomach, intestines, colon, or esophagus")
////                .clickNextButton(new WhenDidYouHaveAppendixRemoved_CC());
////
////
////        whenDidYouHaveAppendixRemoved_OLS
////                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
////                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_OLS.titleExpected2)
////                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_OLS.titleExpected3)
////                .waitForPageLoad(4, whenDidYouHaveAppendixRemoved_OLS.titleExpected4)
////                .clickOnAnswerForSubQuestion(1, "Less than 1 month ago")
////                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
////                .clickOnAnswerForSubQuestion(3, "4 - 6 months ago")
////                .clickOnAnswerForSubQuestion(4, "More than 6 months ago")
////                .clickNextButton(areYouCurrentlyAbleToSwallowTablets_CC);
//
//
//        //---------------Q16 AreYouCurrentlyAbleToSwallowTablets_OLS-------------------
//        TransitionStatementCC transitionStatementCC = areYouCurrentlyAbleToSwallowTablets_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickOnAnswer("Yes")
//                .clickNextButton(new TransitionStatementCC());
//
//
//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
//                transitionStatementCC
//                        .waitForPageLoadDYS()
//                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //------------------General Health--------------------------
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Cancer",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Diabetes (type 1 or type 2)",
                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids",
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
                        "Men's health issues (prostate enlargement or BPH, low testosterone)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
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
                .back(whenDiagnosedWithCancerCC)
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

        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
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


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            System.out.println("Select answer for Q18QS53: " + answer);
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
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);


        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS");
        for (String answer : disqualifyQ24) {
            System.out.println("Select answer for Q24QS59: " + answer);
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
        List<String> disqualifyQ24pt2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ24pt2) {
            System.out.println("Select answer for Q24QS59: " + answer);
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
                .setAll("5", "5", "160")
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


        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());

                siteSelectionPageCC
                        .waitForPageLoad("an indigestion, heartburn, or stomach ulcers study")
                        .getPID()
                        .clickOnAnswer(site.name);

        switch (site) {
            case AUT_AMS1_5098_site:
                QualifiedClose1PageCC qualifiedClose1PageCC = siteSelectionPageCC
                        .clickNextButton(new QualifiedClose1PageCC());


                qualifiedClose1PageCC
                        .waitForPageLoad()
                        //.clickOnAnswer("No")
                        .clickNextButton(new Regular_WarmTransfer1())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new Regular_WarmTransfer4())
                        .waitForPageLoad()
                        .clickOnAnswer("Successful transfer made to site")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad();
                if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
                    selectActionPageCC
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo);
                }
                        //.assertGeneratedFul(env, site);
                break;
            case AUT_AMS1_5098S_site:
                SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = siteSelectionPageCC
                        .clickNextButton(new SynexusRadiantDirectScheduleCC());


                synexusRadiantDirectScheduleCC
                        .waitForPageLoadSyn()
                        .assertVariablesNew("Acurian", "Trial", "01/01/1990", "US",
                                "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", "aut5098S", site.name,
                                "PHMPPDEOE301,PHMPPDPYL301 - Phathom Phalcon")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad();
                if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
                    selectActionPageCC
                            .waitForPageLoad()
                            .getRadiantDbToLog(env)
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo)
                            .getRadiantDbToLog(env, "5098");
                }
                break;
        }
    }
}

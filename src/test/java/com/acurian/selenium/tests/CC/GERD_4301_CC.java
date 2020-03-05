package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns.EverDiagnosedWithFollowingConditionsСС;
import com.acurian.selenium.pages.CC.GERD.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.GERD.UseMarijuanaOrCannabisOLS;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GERD_4301_CC extends BaseTest {

    @Test
    public void Gerd_4301_CC() {
        Site site = Site.AUT_GER_4301_Site;
        String phoneNumber = "AUTAMSGERD";
        String site_Indication = "a heartburn or reflux study";
        String site_Indication1 = "Gastroesophageal Reflux Disease (GERD)";
        String studyName = "heartburn, reflux, or GERD history";

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
                .waitForPageLoad(site_Indication, "500");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle(site_Indication, "500"), "Title is diff");
        dateOfBirthPageCC
                .waitForPageLoad(site_Indication, "500")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")//If "No", go to Does Not Give Permission to Proceed Close
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad(site_Indication, "500")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CurrentlySufferOfAnyOfFollowingCC currentlySufferOfAnyOfFollowingCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("5")
                .setYear("1953")
                .clickOnAnswer("Female")
                .clickNextButton(new CurrentlySufferOfAnyOfFollowingCC());

//        loginPageCC
//                .openPage(env)
//                .waitForPageLoad();
//
//        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
//        SelectActionPageCC selectActionPageCC = loginPageCC
//                .typeUsername(Properties.getUsername())
//                .typePassword(Properties.getPassword())
//                .clickLoginButton();
//
//        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
//                .waitForPageLoad()
//                .typeStudyName("AMS1")
//                .clickPopupStudy("AMS1")
//                .typePhoneNumber(phoneNumber)
//                .clickPopupPhoneNumber(phoneNumber)
//                .clickBeginButton();
//
//        callCenterIntroductionPageCC
//                .waitForPageLoad();
//        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
//        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
//                .activateDebugOnProd(env)
//                .clickOnAnswer("Learn more about matching to clinical trials")
//                .clickNextButton(new DateOfBirthPageCC());
//
//
//        dateOfBirthPageCC
//                .waitForPageLoad();
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle(site_Indication, "500"), "Title is diff");
//        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
//                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
//                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
//                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());
//
//        debugPageCC.checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols);
//        debugPageCC.back();
//        dateOfBirthPageCC
//                .waitForPageLoad();
//        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
//                .setYear("1960")
//                .clickNextButton(new ZipCodePageCC());
//
//
//        //-------------DOB Page----------------------------------
//        GenderPageCC genderPageCC = zipCodePageCC
//                .waitForPageLoad()
//                .typeZipCode(site.zipCode)
//                .clickNextButton(new GenderPageCC());
//
//
//        //-------------GENDER Page--------------------------------
//        DoYouExperienceAnyOfFollowingSymptoms_CC doYouExperienceAnyOfFollowingSymptoms_CC = genderPageCC
//                .waitForPageLoad()
//                .clickOnAnswer("Female")
//                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_CC());


        //-------------DoYouExperienceAnyOfFollowingSymptoms_CC----------------------------------
        NonQRtransitionPageCC nonQRtransitionPageCC = currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6333", site.activeProtocols)
                .back(currentlySufferOfAnyOfFollowingCC);
        currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad();

        EverDiagnosedWithFollowingConditionsСС everDiagnosedWithFollowingConditionsCC = currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("Stomach ulcer or peptic ulcer")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsСС());
        everDiagnosedWithFollowingConditionsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6333", site.activeProtocols)
                .back();

        //Q2
        HowLongHavingSymptomsCC howLongHavingSymptomsCC = currentlySufferOfAnyOfFollowingCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("GERD that is still causing symptoms",
                        "Heartburn or indigestion",
                        "Acid reflux",
                        "Pain in the top of the stomach, or upper stomach pain")
                .clickNextButton(new HowLongHavingSymptomsCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC();


        //Q3
        DuringPastThreeMounthCC duringPastThreeMounthCC = howLongHavingSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new DuringPastThreeMounthCC());

        duringPastThreeMounthCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6334", site.activeProtocols)
                .back(howLongHavingSymptomsCC);
        howLongHavingSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("1 month")
                .clickNextButton(duringPastThreeMounthCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6334", site.activeProtocols)
                .back(howLongHavingSymptomsCC)
                .waitForPageLoad()
                .clickOnAnswer("I used to have these symptoms but they are not troubling me right now")
                .clickNextButton(duringPastThreeMounthCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6334", site.activeProtocols)
                .back(howLongHavingSymptomsCC);

        howLongHavingSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(duringPastThreeMounthCC);

        HowManyDaysPerWeekHaveSymptomsCC howManyDaysPerWeekHaveSymptomsOLS = duringPastThreeMounthCC
                .waitForPageLoad()
                .clickOnAnswer("2 months")
                .clickNextButton(new HowManyDaysPerWeekHaveSymptomsCC());

        howManyDaysPerWeekHaveSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswer("1 day per week or less")
                .clickNextButton(everDiagnosedWithFollowingConditionsCC);

        everDiagnosedWithFollowingConditionsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6337", site.activeProtocols)
                .back(howManyDaysPerWeekHaveSymptomsOLS)
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days per week")
                .clickNextButton(everDiagnosedWithFollowingConditionsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6337", site.activeProtocols)
                .back(howManyDaysPerWeekHaveSymptomsOLS)
                .waitForPageLoad()
                .clickOnAnswer("Not currently experiencing symptoms")
                .clickNextButton(everDiagnosedWithFollowingConditionsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6337", site.activeProtocols)
                .back(howManyDaysPerWeekHaveSymptomsOLS);
        CurrentlyTakeMedicationPrescribedByHealthcareProvider_CC сurrentlyTakeMedicationPrescribedByHealthcareProvider_CC = howManyDaysPerWeekHaveSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 days per week")
                .clickNextButton(new CurrentlyTakeMedicationPrescribedByHealthcareProvider_CC());






        WhichoOfFollowingMedicationsCurrentlyGERD_CC whichoOfFollowingMedicationsCurrentlyGERD_CC = сurrentlyTakeMedicationPrescribedByHealthcareProvider_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_CC());

        EverDiagnosedWithFollowingConditionsСС everDiagnosedWithFollowingConditionsСС = whichoOfFollowingMedicationsCurrentlyGERD_CC
                .waitForPageLoad2()
                .clickOnAnswers("None of the above") //----DQ if selected any of these options in Q3:  None of the above
                .clickNextButton(new EverDiagnosedWithFollowingConditionsСС());
        everDiagnosedWithFollowingConditionsСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6330", site.activeProtocols)
                .back();
        whichoOfFollowingMedicationsCurrentlyGERD_CC
                .waitForPageLoad2()
                .clickOnAnswers("Other \"over-the-counter\" or non-prescription medication not listed")
                .clickNextButton(everDiagnosedWithFollowingConditionsСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6330", site.activeProtocols)
                .back();

        whichoOfFollowingMedicationsCurrentlyGERD_CC
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Nexium (Agent Note: NEX-ee-um)",
                        "Prevacid (Agent Note: PREV-uh-sid)",
                        "Prilosec (Agent Note: PRY-lo-sec)",
                        "Zegerid (Agent Note: ZEGG-er-rid)")
//                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
//
//        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad2()
//                .clickOnAnswer("1 day per week or less")
//                .clickNextButton(everDiagnosedWithFollowingConditionsСС)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6331", site.activeProtocols)
//                .back();
//        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad2()
//                .clickOnAnswer("2 - 3 days per week")
//                .clickNextButton(everDiagnosedWithFollowingConditionsСС)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6331", site.activeProtocols)
//                .back();
//        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad2()
//                .clickOnAnswer("Not currently experiencing symptoms")
//                .clickNextButton(everDiagnosedWithFollowingConditionsСС)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6331", site.activeProtocols)
//                .back();
//        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad2()
//                .clickOnAnswer("4 - 5 days per week")
                .clickNextButton(everDiagnosedWithFollowingConditionsСС);

        WhatTypeOfSurgeryDidYouHave_CC whatTypeOfSurgeryDidYouHave_CC = everDiagnosedWithFollowingConditionsСС
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

        UseMarijuanaOrCannabisCC useMarijuanaOrCannabisCC = new UseMarijuanaOrCannabisCC();

        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_CC.titleExpected3);
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = whenDidYouHaveAppendixRemoved_CC
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(3, "Less than 1 month ago")
                .clickNextButton(new WeightLossSurgeryPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6311", site.activeProtocols)
                .back(new WeightLossSurgeryPageCC());
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(weightLossSurgeryPageCC);

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
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .back(transitionStatementCC)
                .waitForPageLoadDYS()
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
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(whenDidYouHaveAppendixRemoved_CC)
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected4)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6310", site.activeProtocols)
                .back();
        whatTypeOfSurgeryDidYouHave_CC
                .back();

        DidTakeMedicationToTreatPyloriCC didTakeMedicationToTreatPyloriCC = everDiagnosedWithFollowingConditionsСС
                .waitForPageLoad()
                .clickOnAnswers("Helicobacter pylori or H. pylori infection")
                .clickNextButton(new DidTakeMedicationToTreatPyloriCC());

        didTakeMedicationToTreatPyloriCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(whatTypeOfSurgeryDidYouHave_CC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(weightLossSurgeryPageCC);
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass",
                        "Gastric sleeve or sleeve gastrectomy",
                        "Duodenal switch",
                        "Lap band or gastric banding",
                        "Gastric balloon")
                .clickOnAnswers("I had a weight loss surgery, but I am unsure which type")
                .clickNextButton(new ProcedureForWeightLossPageCC());
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
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


//        WhichoOfFollowingMedicationsCurrentlyGERD_CC whichoOfFollowingMedicationsCurrentlyGERD_CC = doYouExperienceAnyOfFollowingSymptoms_CC
//                .clickOnAnswers("GERD which has been diagnosed by a medical professional",
//                        "Heartburn, which can be felt as pain or a burning sensation behind the breastbone",
//                        "Acid reflux or frequent regurgitation, which is a sensation of liquid or food coming back up into your throat without vomiting")
//                .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_CC());
//
//
//        //-------------WhichoOfFollowingMedicationsCurrentlyGERD_CC----------------------------------
//        whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .waitForPageLoad();
//        Assert.assertEquals(whichoOfFollowingMedicationsCurrentlyGERD_CC.getTitleText(), whichoOfFollowingMedicationsCurrentlyGERD_CC.titleExpected, "Title is diff");
//        //HaveYouEverHadSurgeryOnStomach_CC haveYouEverHadSurgeryOnStomach_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
//        HasYourDoctorToldYouThatYouHaveErosion_CC hasYourDoctorToldYouThatYouHaveErosion_cc = whichoOfFollowingMedicationsCurrentlyGERD_CC
//                //----DQ if selected any of these options in Q3:  None of the above
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC());
//        hasYourDoctorToldYouThatYouHaveErosion_cc
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6303", site.activeProtocols)
//                .back();
//        whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .waitForPageLoad()
//                .clickOnAnswers("Other")
//                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_cc);
//        hasYourDoctorToldYouThatYouHaveErosion_cc
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6303", site.activeProtocols)
//                .back();
//        whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .waitForPageLoad();
//        //----SKIP to Q5 if selected any of these options in Q3:  Aciphex (rabeprazole), Dexilant (dexlansoprazole), Protonix (pantoprazole), None of the above
//        HowLongHaveYouBeenTaking_CC howLongHaveYouBeenTaking_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .clickOnAnswers("Aciphex, also known as rabeprazole (Agent Note: AH-si-fex, ruh-BEP-ruh-zole)",
//                        "Dexilant, also known as dexlansoprazole (Agent Note: DEX-ih-lant, dex-lan-SOP-ruh-zole)",
//                        "Protonix, also known as pantoprazole (Agent Note: pro-TAHN-ix, pan-TOP-ruh-zole)")
//                .clickNextButton(new HowLongHaveYouBeenTaking_CC());
//        howLongHaveYouBeenTaking_CC
//                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected5)
//                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected6)
//                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected7)
//                .back();
//        whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .waitForPageLoad();
//        HowDoYouBuyFollowingMedications_CC howDoYouBuyFollowingMedications_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Nexium, also known as esomeprazol (Agent Note: NEX-ee-um, eh-so-MEP-ruh-zole)",
//                        "Prevacid, also known as lansoprazole (Agent Note: PREV-uh-sid, lan-SOP-ruh-zole)",
//                        "Prilosec, also known as omeprazole (Agent Note: PRY-lo-sec, oh-MEP-ruh-zole)",
//                        "Zegerid, also known as omeprazole and sodium bicarbonate (Agent Note: ZEGG-er-rid, oh-MEP-ruh-zole, SO-dee-um bi-CAR-bo-nate)")
//                .clickNextButton(new HowDoYouBuyFollowingMedications_CC());
//
//
//        //----------------Q4 HowDoYouBuyFollowingMedications_CC --------------
//        howDoYouBuyFollowingMedications_CC
//                .waitForPageLoad(1, howDoYouBuyFollowingMedications_CC.titleExpected1)
//                .waitForPageLoad(2, howDoYouBuyFollowingMedications_CC.titleExpected2)
//                .waitForPageLoad(3, howDoYouBuyFollowingMedications_CC.titleExpected3)
//                .waitForPageLoad(4, howDoYouBuyFollowingMedications_CC.titleExpected4);
//        Assert.assertEquals(howDoYouBuyFollowingMedications_CC.getTitleText(1), howDoYouBuyFollowingMedications_CC.titleExpected1, "Title is diff");
//        howDoYouBuyFollowingMedications_CC
//                .clickOnAnswerForSubQuestion(1, "With a prescription from my doctor that I get filled at the pharmacy counter")
//                .clickOnAnswerForSubQuestion(2, "I get this medication off the shelf, or \"over-the-counter\"")
//                .clickOnAnswerForSubQuestion(3, "With a prescription from my doctor that I get filled at the pharmacy counter")
//                .clickOnAnswerForSubQuestion(4, "I get this medication off the shelf, or \"over-the-counter\"")
//                .clickNextButton(new HowLongHaveYouBeenTaking_CC());
//
//
//        //---------------Q5 HowLongHaveYouBeenTaking_CC-------------------
//        howLongHaveYouBeenTaking_CC
//                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected1)
//                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected2)
//                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected3)
//                .waitForPageLoad(4, howLongHaveYouBeenTaking_CC.titleExpected4);
//        Assert.assertEquals(howLongHaveYouBeenTaking_CC.getTitleText(1), howLongHaveYouBeenTaking_CC.titleExpected1, "Title is diff");
//        HowOftenDoYouTake_CC howOftenDoYouTake_CC = howLongHaveYouBeenTaking_CC
//                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
//                .clickOnAnswerForSubQuestion(2, "1 month")
//                .clickOnAnswerForSubQuestion(3, "Less than 1 month")
//                .clickOnAnswerForSubQuestion(4, "1 month")
//                .clickNextButton(new HowOftenDoYouTake_CC());
//        howOftenDoYouTake_CC
//                .waitForPageLoad(1, howOftenDoYouTake_CC.titleExpected1)
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6306", site.activeProtocols)
//                .back();
//        howLongHaveYouBeenTaking_CC
//                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "2 months")
//                .clickNextButton(new HowOftenDoYouTake_CC());
//
//
//        //---------------Q7 HowOftenDoYouTake_CC-------------------
//        howOftenDoYouTake_CC
//                .waitForPageLoad(1, howOftenDoYouTake_CC.titleExpected1)
//                .waitForPageLoad(2, howOftenDoYouTake_CC.titleExpected2)
//                .waitForPageLoad(3, howOftenDoYouTake_CC.titleExpected3)
//                .waitForPageLoad(4, howOftenDoYouTake_CC.titleExpected4);
//        //.waitForPageLoad(5,howOftenDoYouTake_CC.titleExpected5)
//        //.waitForPageLoad(6,howOftenDoYouTake_CC.titleExpected6)
//        //.waitForPageLoad(7,howOftenDoYouTake_CC.titleExpected7);
//        Assert.assertEquals(howOftenDoYouTake_CC.getTitleText(1), howOftenDoYouTake_CC.titleExpected1, "Title is diff");
//        DespiteTakingMedicationDoYouStillExperienceSymptoms_CC despiteTakingMedicationDoYouStillExperienceSymptoms_CC = howOftenDoYouTake_CC
//                .clickOnAnswerForSubQuestion(1, "Twice a day")
//                .clickOnAnswerForSubQuestion(2, "Twice a day")
//                .clickOnAnswerForSubQuestion(3, "Other")
//                .clickOnAnswerForSubQuestion(4, "Other")
//                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
//        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                //.checkProtocolsContainsForQNumber("QS6316", site.activeProtocols)
//                .back();
//        howOftenDoYouTake_CC
//                .waitForPageLoad(1, howOftenDoYouTake_CC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "Only as needed (not regularly)")
//                .clickOnAnswerForSubQuestion(2, "Only as needed (not regularly)")
//                .clickOnAnswerForSubQuestion(3, "Once a day")
//                .clickOnAnswerForSubQuestion(4, "Once a day")
//                .clickNextButton(despiteTakingMedicationDoYouStillExperienceSymptoms_CC);
//
//
////        //---------------Q9 OnaTypicalDayWhenDoYouUsually_CC-------------------
////        onaTypicalDayWhenDoYouUsually_CC
////                .waitForPageLoad(1, onaTypicalDayWhenDoYouUsually_CC.titleExpected1)
////                .waitForPageLoad(2, onaTypicalDayWhenDoYouUsually_CC.titleExpected2)
////                .waitForPageLoad(3, onaTypicalDayWhenDoYouUsually_CC.titleExpected3)
////                .waitForPageLoad(4, onaTypicalDayWhenDoYouUsually_CC.titleExpected4);
////        Assert.assertEquals(howLongHaveYouBeenTaking_CC.getTitleText(1), onaTypicalDayWhenDoYouUsually_CC.titleExpected1, "Title is diff");
////        DespiteTakingMedicationDoYouStillExperienceSymptoms_CC despiteTakingMedicationDoYouStillExperienceSymptoms_CC = onaTypicalDayWhenDoYouUsually_CC
////                .clickOnAnswerForSubQuestion(1, "Morning")
////                .clickOnAnswerForSubQuestion(2, "Afternoon")
////                .clickOnAnswerForSubQuestion(3, "Evening")
////                .clickOnAnswerForSubQuestion(4, "Night")
////                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
////        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
////                .waitForPageLoad()
////                .getPage(debugPageCC)
////                //debugPageCC.checkProtocolsContainsForQNumber("Q0018004-QS6306-STUDYQUES", site.activeProtocols);
////                .back();
////        onaTypicalDayWhenDoYouUsually_CC
////                .waitForPageLoad(1, onaTypicalDayWhenDoYouUsually_CC.titleExpected1)
////                .clickOnAnswerForSubQuestion(4, "Morning")
////                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
//
//
//        //---------------Q10 DespiteTakingMedicationDoYouStillExperienceSymptoms_CC-------------------
//        HasYourDoctorToldYouThatYouHaveErosion_CC hasYourDoctorToldYouThatYouHaveErosion_CC =
//                despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                        .waitForPageLoad()
//                        .clickOnAnswer("No, my symptoms are well-controlled")
//                        .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC());
//        hasYourDoctorToldYouThatYouHaveErosion_CC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6307", site.activeProtocols)
//                .back();
//        ThinkingAboutThePast2Months_CC thinkingAboutThePast2Months_CC = despiteTakingMedicationDoYouStillExperienceSymptoms_CC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes, I still have symptoms")
//                .clickNextButton(new ThinkingAboutThePast2Months_CC());
//
//
//        //--------------Q11 ThinkingAboutThePast2Months_CC ---------------------
//        thinkingAboutThePast2Months_CC
//                .waitForPageLoad()
//                .clickOnAnswer("1 day per week or less")
//                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_CC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6308", site.activeProtocols)
//                .back(thinkingAboutThePast2Months_CC)
//                .waitForPageLoad()
//                .clickOnAnswer("2 - 3 days per week")
//                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_CC)
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6308", site.activeProtocols)
//                .back(thinkingAboutThePast2Months_CC)
//                .waitForPageLoad()
//                .clickOnAnswer("4 - 5 days per week")
//                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_CC);
//
//
//        //--------------Q12 HasYourDoctorToldYouThatYouHaveErosion_CC---------------------
//        TestedForStomachInfectionHelicobacterCC testedForStomachInfectionHelicobacterCC =
//                hasYourDoctorToldYouThatYouHaveErosion_CC
//                        .waitForPageLoad()
//                        .clickOnAnswer("Yes")
//                        .clickNextButton(new TestedForStomachInfectionHelicobacterCC());
//
//        MembersOfHouseholdBeenDiagnosedPyloriCC membersOfHouseholdBeenDiagnosedPyloriCC = testedForStomachInfectionHelicobacterCC
//                .waitForPageLoad()
//                .clickOnAnswer("Unsure")
//                .clickNextButton(new MembersOfHouseholdBeenDiagnosedPyloriCC());
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
//                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_CC());
//
//
//        //---------------Q14 WhatTypeOfSurgeryDidYouHave_CC-------------------
//        WhenDidYouHaveAppendixRemoved_CC whenDidYouHaveAppendixRemoved_CC = whatTypeOfSurgeryDidYouHave_CC
//                .waitForPageLoad()
//                //---------SKIP to Q12 if selected "Other surgery on my stomach, intestines, colon, or esophagus"  or go to Q11--------
//                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
//                .clickNextButton(new WhenDidYouHaveAppendixRemoved_CC());
//        whenDidYouHaveAppendixRemoved_CC
//                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected4)
//                .getPage(debugPageCC).checkProtocolsContainsForQNumber("QS6310", site.activeProtocols)
//                .back();
//        whatTypeOfSurgeryDidYouHave_CC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)",
//                        "Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)",
//                        "Biopsy (Agent Note: BY-op-see) – removal of a small piece of tissue for analysis",
//                        "Tonsils removed - Tonsillectomy (Agent Note: tahn-sil-LECK-toe-mee)",
//                        "Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)")
//                .clickNextButton(whenDidYouHaveAppendixRemoved_CC);
//
//
//        //---------------Q15 WhenDidYouHaveAppendixRemoved_CC-------------------
//        whenDidYouHaveAppendixRemoved_CC
//                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
//                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_CC.titleExpected2)
//                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_CC.titleExpected3);
//        Assert.assertEquals(whenDidYouHaveAppendixRemoved_CC
//                .getTitleText(1), whenDidYouHaveAppendixRemoved_CC.titleExpected1, "Title is diff");
//        WeightLossSurgeryPageCC weightLossSurgeryPageCC = whenDidYouHaveAppendixRemoved_CC
//                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(2, "4 - 6 months ago")
//                .clickOnAnswerForSubQuestion(3, "4 - 6 months ago")
//                .clickNextButton(new WeightLossSurgeryPageCC());
//        weightLossSurgeryPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6311", site.activeProtocols)
//                .back();
//        whenDidYouHaveAppendixRemoved_CC
//                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_CC.titleExpected1)
//                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
//                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
//                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
//                .clickNextButton(weightLossSurgeryPageCC);
//
//        AreYouCurrentlyAbleToSwallowTablets_CC areYouCurrentlyAbleToSwallowTablets_CC = weightLossSurgeryPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC());
//
//
//        //---------------Q16 AreYouCurrentlyAbleToSwallowTablets_CC-------------------
//        TransitionStatementCC transitionStatementCC = areYouCurrentlyAbleToSwallowTablets_CC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new TransitionStatementCC());
//        transitionStatementCC
//                .waitForPageLoadDYS()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6312", site.activeProtocols)
//                .back();
//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
//                areYouCurrentlyAbleToSwallowTablets_CC
//                        .waitForPageLoad()
//                        .clickOnAnswer("Yes")
//                        .clickNextButton(transitionStatementCC)
//                        .waitForPageLoadDYS()
//                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
//


        //------------------General Health--------------------------
        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WhatKindOfArthritisPageCC());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC.back();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis",
                        "Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis C",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS)",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia")
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "7", "166")
                .clickNextButton(new LetMeSeePageCC());


        letMeSeePageCC
                .waitForPageLoad()
//        		.clickNextButton(new ChildrenUnderPageCC())
//        		.waitForPageLoad()
//        		.clickOnAnswer("No")
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a heartburn or reflux study") //could not DQ with (Phathom EE & HP) to avoid combined indication
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
//                .clickNextButton(new SynexusHealthyMindsPageCC())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(new AlzheimerClosePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4301")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
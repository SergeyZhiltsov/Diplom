package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.IBD.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class IBD_4533_CC extends BaseTest {

    @Test(enabled = false)
    @Description("IBD 4533 for CC")
    public void IBD_4533_CCTest() {
        Site site = Site.AUT_SHIRE_4533_site;
        String phoneNumber = "AUTAMS1CRN";
        String protocol1 = "M14_431";
        String protocol2 = "M14_433";
        String protocol3 = "M15_991";
        String protocol4 = "M16_006";
        String protocol5 = "SHP647_305";
        String protocol6 = "SHP647_306";
        List<String> protocols = Arrays.asList(protocol1, protocol2, protocol3, protocol4);
        String studyName = "Crohn's";
        String studyIndication = "Crohn's or colitis";

        String env = System.getProperty("acurian.env", "STG");

        String time = String.valueOf(Instant.now().getEpochSecond());
        time = time.substring(time.length() - 4);
//        String eMailId = "qa.acurian_" + time + "3@gmail.com";
        String eMailId = "qa.acurian@gmail.com";

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a Crohn's study", "700"), "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol5, protocol6);
        debugPageCC.back();

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());

        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());

        whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Not officially diagnosed with Crohn's by a doctor")
                .clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015880-QS5703-STUDYQUES", protocol5, protocol6);
        debugPageCC.back();
        MostRecentColonoscopyCC mostRecentColonoscopyCC = whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new MostRecentColonoscopyCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015880-QS5703-STUDYQUES", protocol5, protocol6);
        debugPageCC.back();
        whenDiagnosedCrohnsPageCC.waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new MostRecentColonoscopyCC());

        ManageYourCrohnsPageCC manageYourCrohnsPageCC = mostRecentColonoscopyCC
                .waitForPageLoad()
                .clickOnAnswer("I have never had a colonoscopy")
                .clickNextButton(new ManageYourCrohnsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015882-QS5705-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        mostRecentColonoscopyCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(new ManageYourCrohnsPageCC());

        CurrentlyExperiencingFlareUpCC currentlyExperiencingFlareUpCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015883-QS5706-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();

        SteroidMedicationsForCrohnsCC steroidMedicationsForCrohnsCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsForCrohnsCC());

        FollowingMedicationsCrohnsPageCC followingMedicationsCrohnsPageCC = steroidMedicationsForCrohnsCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingMedicationsCrohnsPageCC());

        EverTreatedCrohnOrColitisCC everTreatedCrohnOrColitisCC = followingMedicationsCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTreatedCrohnOrColitisCC());

        everTreatedCrohnOrColitisCC.threadSleep(2000);
        BiologicMedicationsPageCC biologicMedicationsPageCC = everTreatedCrohnOrColitisCC
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new BiologicMedicationsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015890-QS5709-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        everTreatedCrohnOrColitisCC
                .clickOnAnswers("Xeljanz (Agent Note: ZEL-jans)")
                .clickNextButton(new BiologicMedicationsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015890-QS5709-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        everTreatedCrohnOrColitisCC
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new BiologicMedicationsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015890-QS5709-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        everTreatedCrohnOrColitisCC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)")
                .clickNextButton(new BiologicMedicationsPageCC());

        biologicMedicationsPageCC
                .clickOnAnswers("Stelara (Agent Note: ste-LAHR-uh)")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", protocol3, protocol4);
        debugPageCC.back();
        biologicMedicationsPageCC
                .clickOnAnswers("Benlysta (Agent Note: ben-LIST-uh)", "Actemra (Agent Note: ac-TEM-ruh)", "Enbrel (Agent Note: EN-brel)", "Cosentyx (Agent Note: co-SEN-tix)", "Kineret (Agent Note: KIN-er-et)", "Taltz (Agent Note: TALTS)")
                .clickOnAnswers("Orencia (Agent Note: oh-REN-see-uh)", "Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)", "Rituxan (Agent Note: rih-TUX-an)", "Simponi (Agent Note: SIM-po-nee)", "Raptiva (Agent Note: rap-TEE-vuh)")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", protocol3, protocol4);
        debugPageCC.back();
        biologicMedicationsPageCC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Entyvio (Agent Note: en-TIV-ee-oh)", "Stelara (Agent Note: ste-LAHR-uh)")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", protocol5, protocol6);
        debugPageCC.back();
        biologicMedicationsPageCC.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());


        //HowWouldYouRateCC howWouldYouRateCC = currentlyExperiencingFlareUpCC
        SubquestionsIBDShireCrohnsPageCC subquestionsIBDShireCrohnsPageCC = currentlyExperiencingFlareUpCC
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn's or colitis")
                .clickNextButton(new SubquestionsIBDShireCrohnsPageCC());


        //-----------------------Q15 Please think about your Crohn's disease symptoms when answering the questions below.----------------------
        subquestionsIBDShireCrohnsPageCC
                .waitForPageLoad(1, subquestionsIBDShireCrohnsPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionsIBDShireCrohnsPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionsIBDShireCrohnsPageCC.titleExpected3);
        //----------Select options for 15.1, 15.2 and 15.3 sub-questions---------
        //WeightLossSurgeryPageCC weightLossSurgeryPageOLS = subquestionsIBD_CC
        HowWouldYouRateCC howWouldYouRateCC = subquestionsIBDShireCrohnsPageCC
                .avgDayBowelMovements("2")
                .past24hrBowelMovements("2")
                .abdominalpainOnaScale("2")
                .clickNextButton(new HowWouldYouRateCC());


        //----------Select options for 15.1, 15.2 and 15.3 sub-questions---------
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = howWouldYouRateCC
                .waitForPageLoadIBD()
                .clickOnAnswer("Fair")
                .clickOnAnswer("About the same")
                .clickOnAnswers("None of the above")
                .clickNextButton(new WeightLossSurgeryPageCC());


        HaveAnyOfTheFollowingPageCC haveAnyOfTheFollowingPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveAnyOfTheFollowingPageCC());


        TransitionStatementCC transitionStatementCC = haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Colostomy and/or Colectomy")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ileostomy")
                .clickOnAnswers("Colostomy and/or Colectomy")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Another type of stomach or colon surgery")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();


        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Feeding tube", "IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                //.waitForPageLoadWithCurves(studyName)
                .waitForPageLoadWithCurves(studyIndication)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());


        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        //debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        whenDiagnosedWithCancerCC.back();


        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());


        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();


        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();


        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();


        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC.back();

        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());


        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1, protocol2, protocol3, protocol4);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());


        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "7", "170")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
//                .clickNextButton(new ChildrenUnderPageCC())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a Crohn's study")
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedFlareMonitoringAppClosePageCC())
                .threadSleep(5000);
        //.waitForPageLoad()
        QualifiedFlareMonitoringAppClosePageCC qualified = new QualifiedFlareMonitoringAppClosePageCC();
        qualified.getActivationCode()
                .enterEmail(eMailId)
                //------------Warm Transfer----------
                .clickNextButton(new Regular_WarmTransfer1())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                //--------Regualr Warm Transfer Page#2
                .clickNextButton(new Regular_WarmTransfer2())
                .waitForPageLoad()
                .clickOnAnswer("Yes: Great, I'll connect them now.")
                .clickOnAnswer("[site did not answer]")
                //--------Regualr Warm Transfer Page#3
                .clickNextButton(new Regular_WarmTransfer3())
                .waitForPageLoad(env.equals("STG") ? "Test SiteCC" : "Ramya Avunuri")
                //--------Regualr Warm Transfer Page#4
                .clickNextButton(new Regular_WarmTransfer4())
                .waitForPageLoad()
                .clickOnAnswer("Successful transfer made to site")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4533")
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
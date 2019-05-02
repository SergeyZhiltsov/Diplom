package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.CC.IBD.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.BiologicMedicationsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.DiagnosedWithCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.FollowingMedicationsCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.HaveAnyOfTheFollowingPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.ManageYourCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.WhenDiagnosedCrohnsPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WeightLossSurgeryPageCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.utils.DataProviderPool;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class IBD_3839_CC extends BaseTest {

    @Test()
    @Description("IBD 3839 for CC")
    public void ibd3839ccTest() {
        Site site = Site.AUT_IBD_3839_Site;
        String phoneNumber = "AUTAMS1IBD";
        String studyName = "Crohn's or colitis";
        String studyIndication = "a colitis study";

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleIBD3264, "Title is diff"); //because upper coma

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", site.activeProtocols);
        debugPageCC.back();

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1937")
                .clickNextButton(new IdentificationPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());


        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoad1()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());

        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());

        whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015881-QS5704-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("Not officially diagnosed with ulcerative colitis by a doctor")
                .clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015881-QS5704-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        MostRecentColonoscopyCC mostRecentColonoscopyCC = whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(new MostRecentColonoscopyCC());

        ManageYourCrohnsPageCC manageYourCrohnsPageCC = mostRecentColonoscopyCC
                .waitForPageLoad()
                .clickOnAnswer("I have never had a colonoscopy")
                .clickNextButton(new ManageYourCrohnsPageCC());

        CurrentlyExperiencingFlareUpCC currentlyExperiencingFlareUpCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015883-QS5706-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        SteroidMedicationsForCrohnsCC steroidMedicationsForCrohnsCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsForCrohnsCC());

        FollowingMedicationsCrohnsPageCC followingMedicationsCrohnsPageCC = steroidMedicationsForCrohnsCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new FollowingMedicationsCrohnsPageCC());

        EverTreatedCrohnOrColitisCC everTreatedCrohnOrColitisCC = followingMedicationsCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTreatedCrohnOrColitisCC());

        everTreatedCrohnOrColitisCC.threadSleep(2000);
        BiologicMedicationsPageCC biologicMedicationsPageCC = everTreatedCrohnOrColitisCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageCC());

        biologicMedicationsPageCC
                .clickOnAnswers("Entyvio (Agent Note: en-TIV-ee-oh)")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        biologicMedicationsPageCC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Raptiva (Agent Note: rap-TEE-vuh)")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        biologicMedicationsPageCC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tysabri (Agent Note: tie-SAB-ree)")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        biologicMedicationsPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());

        SubquestionsIBD_UlcerativeColitis_CC subquestionsIBD_ulcerativeColitis_cc = currentlyExperiencingFlareUpCC
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn's or colitis")
                .clickNextButton(new SubquestionsIBD_UlcerativeColitis_CC());

        //added after failing

        HowWouldYouRateCC howWouldYouRateCC = subquestionsIBD_ulcerativeColitis_cc
                .waitForPageLoad(1, subquestionsIBD_ulcerativeColitis_cc.titleExpected1)
                .waitForPageLoad(2, subquestionsIBD_ulcerativeColitis_cc.titleExpected2)
                .waitForPageLoad(3, subquestionsIBD_ulcerativeColitis_cc.titleExpected3)
                .totalBowelMovements("4")
                .totalpast24hrBowelMovements("4")
                .clickOnAnswer("Yes")
                .clickNextButton(new HowWouldYouRateCC());

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
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ileostomy")
                .clickOnAnswers("Colostomy and/or Colectomy")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", site.activeProtocols);
        debugPageCC.back();

        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurves(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickOnAnswers("Diabetes (type 1 or type 2)", "Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids")
                .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)", "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)", "Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis)")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WhatKindOfArthritisCC());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC.back();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis", "Bipolar disorder", "Cancer in the past 5 years, except skin cancer", "Drug or alcohol abuse within the past year")
                .clickOnAnswers("Hepatitis B", "Hepatitis C", "HIV or AIDS", "Kidney disease requiring dialysis", "Multiple sclerosis (MS)", "Neuropathy (nerve damage due to diabetes or another condition)")
                .clickOnAnswers("Seizure disorder such as epilepsy", "Schizophrenia")
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
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyIndication)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                //		.waitForPageLoadIBD(studyIndication)
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }

}

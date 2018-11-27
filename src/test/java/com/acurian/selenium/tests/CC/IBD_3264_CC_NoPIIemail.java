package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.*;
import com.acurian.selenium.pages.CC.IBD.*;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.HSCrohns2PageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IBD_3264_CC_NoPIIemail extends BaseTest {

    @Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("IBD")
    @Description("IBD 3264 for CC")
    public void ibd_3264_CC_HS_NoEmailAtPII(final String username, final String password) {
        String phoneNumber = "AUTAMS1IBD";
        //String protocol1 = "M14_234";
        String protocol2 = "M16_067";
        List<String> protocols = Arrays.asList(protocol2);
        String studyName = "Crohn's or colitis";
        String siteName = "AUT_IBD_3264_Site";
        String studyIndication = "Ulcerative Colitis";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
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
                .waitForPageLoadIBD();
//        dateOfBirthPageCC.threadSleep(2000);
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextIBD(), "May I have your date of birth?", "Question text is diff");
        DebugPageCC debugPageCC = new DebugPageCC();

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", protocol2)
                .back();

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1920")
                .clickNextButton(new IdentificationPageCC());
        identificationPageCC
                .waitForPageLoadNotQ()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", protocol2);
        debugPageCC.back();
        dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(identificationPageCC);

        identificationPageCC
                .waitForPageLoad1();
        Assert.assertEquals(identificationPageCC.getEarlyCaptureTitleText(), "Personal details (*required fields)");
        GenderPageCC genderPageCC = identificationPageCC
                .setAllFields("Auto", "Test", "", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());

        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());

        whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol2)
                .back();

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol2)
                .back();

        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(whenDiagnosedCrohnsPageCC);

        whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015881-QS5704-STUDYQUES", protocol2)
                .back();

        whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("Not officially diagnosed with ulcerative colitis by a doctor")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015881-QS5704-STUDYQUES", protocol2)
                .back();

        MostRecentColonoscopyCC mostRecentColonoscopyCC = whenDiagnosedCrohnsPageCC
                .waitForPageLoadULC()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(new MostRecentColonoscopyCC());

        ManageYourCrohnsPageCC manageYourCrohnsPageCC = mostRecentColonoscopyCC
                .waitForPageLoad()
                .clickOnAnswer("I have never had a colonoscopy")
                .clickNextButton(new ManageYourCrohnsPageCC());

        manageYourCrohnsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015882-QS5705-STUDYQUES", protocol2)
                .back(mostRecentColonoscopyCC)
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(manageYourCrohnsPageCC);

        CurrentlyExperiencingFlareUpCC currentlyExperiencingFlareUpCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyExperiencingFlareUpCC());

        currentlyExperiencingFlareUpCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015883-QS5706-STUDYQUES", protocol2)
                .back();

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

        BiologicMedicationsPageCC biologicMedicationsPageCC = everTreatedCrohnOrColitisCC
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new BiologicMedicationsPageCC());

        LinkedHashMap<String, String> medications = new LinkedHashMap<>();
        medications.put("Actemra (Agent Note: ac-TEM-ruh)", protocol2);
        medications.put("Benlysta (Agent Note: ben-LIST-uh)", protocol2);
        medications.put("Cimzia (Agent Note: SIM-zee-uh)", protocol2);
        medications.put("Cosentyx (Agent Note: co-SEN-tix)", protocol2);
        medications.put("Enbrel (Agent Note: EN-brel)", protocol2);
        medications.put("Kineret (Agent Note: KIN-er-et)", protocol2);
        medications.put("Orencia (Agent Note: oh-REN-see-uh)", protocol2);
        medications.put("Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)", protocol2);
        medications.put("Raptiva (Agent Note: rap-TEE-vuh)", protocol2);
        medications.put("Rituxan (Agent Note: rih-TUX-an)", protocol2);
        medications.put("Stelara (Agent Note: ste-LAHR-uh)", protocol2);
        medications.put("Taltz (Agent Note: TALTS)", protocol2);
        medications.put("Tysabri (Agent Note: tie-SAB-ree)", protocol2);

        for (Map.Entry<String, String> entry : medications.entrySet()){
            biologicMedicationsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(currentlyExperiencingFlareUpCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015899-QS5711-STUDYQUES", entry.getValue())
                    .back();
        }
        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyExperiencingFlareUpCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015899-QS5711-STUDYQUES", protocol2)
                .back();

        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Remicade (Agent Note: REM-ih-cade)")
                .clickNextButton(currentlyExperiencingFlareUpCC);

        SubquestionsIBD_UlcerativeColitis_CC subquestionsIBD_UlcerativeColitis_CC = currentlyExperiencingFlareUpCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am currently in a flare with my Crohn's or colitis")
                .clickNextButton(new SubquestionsIBD_UlcerativeColitis_CC());


        //-------------changes as per R59-------
        //-----------Q16 Please think about your Ulcerative Colitis symptoms when answering the questions below.----------------------
        //------------------------On an average day, how many total bowel movements do you have?------
        subquestionsIBD_UlcerativeColitis_CC
                .waitForPageLoad(1, subquestionsIBD_UlcerativeColitis_CC.titleExpected1)
                .waitForPageLoad(2, subquestionsIBD_UlcerativeColitis_CC.titleExpected2)
                .waitForPageLoad(3, subquestionsIBD_UlcerativeColitis_CC.titleExpected3);
        //----------Select options for 15.1, 15.2 and 15.3 sub-questions---------
        //WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = subquestionsIBD_UlcerativeColitis_OLS
        HowWouldYouRateCC howWouldYouRateCC = subquestionsIBD_UlcerativeColitis_CC
                .totalBowelMovements("4")
                .totalpast24hrBowelMovements("4")
                .clickOnAnswer("Yes")
                .clickNextButton(new HowWouldYouRateCC());


        //-----------Q17 Please think about your Ulcerative Colitis symptoms when answering the questions below.----------------------
        //------------------------On an average day, how many total bowel movements do you have?------
        howWouldYouRateCC
                .waitForPageLoadIBD();
        //----------Select options for 17.1, 17.2 and 17.3 sub-questions---------
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = howWouldYouRateCC
                .clickOnAnswer("Good")
                .clickOnAnswer("Somewhat better now")
                .clickOnAnswers("Loss of bowel control")
                .clickNextButton(new WeightLossSurgeryPageCC());


        HaveAnyOfTheFollowingPageCC haveAnyOfTheFollowingPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveAnyOfTheFollowingPageCC());

         ProcedureForWeightLossPageCC lastTimeWeightLossSurgeryOrProcedureСС = haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .back(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        lastTimeWeightLossSurgeryOrProcedureСС
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(haveAnyOfTheFollowingPageCC);

        TransitionStatementCC transitionStatementCC = haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Colostomy and/or Colectomy")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol2);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ileostomy")
                .clickOnAnswers("Colostomy and/or Colectomy")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol2);
        debugPageCC.back();

        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Another type of stomach or colon surgery")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol2);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol2);
        debugPageCC.back();

        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Ileostomy")
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurves(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickOnAnswers("Diabetes (type 1 or type 2)", "Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)", "Headaches (migraine, cluster, tension)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids", "Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis)")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhatKindOfArthritisCC());

        whatKindOfArthritisCC.back();
        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancer());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancer
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol2);
        debugPageCC.back();
        whenDiagnosedWithCancer.back();

        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Cancer")
                .clickNextButton(new KidneyProblemsPage());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol2);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol2);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
//        		.clickNextButton(new ChildrenUnderPageCC())
//        		.waitForPageLoad()
//        		.clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a colitis study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSCrohns2PageCC())
                .waitForPageLoad1()
                .setEmailID("qa.acurian@gmail.com")
                //.waitForPageLoadIBD(studyIndication)
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
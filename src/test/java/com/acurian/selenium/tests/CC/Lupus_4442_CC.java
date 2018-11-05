package com.acurian.selenium.tests.CC;


import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.AS_4319.PermanentlyWheelchairBoundCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LPS_4442.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lupus_4442_CC extends BaseTest {

    @Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void lupus_4442_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1LPS";
        //  List<String> protocols = Arrays.asList("I5Q_MC_CGAW");
        String protocol1 = "I4V_MC_JAHZ";
        String protocol2 = "I4V_MC_JAIA";
        String studyName = "migraine";
        String siteName = "LPS_4442";
        String site_indication = "Ankylosing Spondylitis";
        String zipCode = "08204";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad()
                .maximizePage();

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

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC.waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("08204")
                .clickNextButton(new GenderPageCC());

        DiagnosedWithLupusCC diagnosedWithLupusCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithLupusCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017447-QS6102-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        WhatTypeOfLupusCC whatTypeOfLupusCC = diagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatTypeOfLupusCC());

        TransitionStatementCC transitionStatementCC = whatTypeOfLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Drug-induced lupus - a form of lupus caused by certain prescription medications")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC.waitForPageLoadNew("lupus");
        debugPageCC.checkProtocolsContainsForQNumber("Q0017448-QS6103-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whatTypeOfLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Neonatal lupus (Agent Note: nee-oh-NAY-tal LOOP-us) - a form of lupus that affects newborn infants")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadNew("lupus");
        debugPageCC.checkProtocolsContainsForQNumber("Q0017448-QS6103-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        WhenDiagnosedWithLupusCC whenDiagnosedWithLupusCC = whatTypeOfLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Cutaneous lupus (Agent Note: cu-TAY-nee-uhs LOOP-us) - a form of lupus which affects the skin only")
                .clickNextButton(new WhenDiagnosedWithLupusCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017448-QS6103-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whatTypeOfLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new WhenDiagnosedWithLupusCC())
                .waitForPageLoad()
                .back();

        whatTypeOfLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Systemic lupus (SLE) (Agent Note: sis-STEM-ic LOOP-us) - the most common form of lupus, which may affect multiple organs and tissues in the body")
                .clickNextButton(new WhenDiagnosedWithLupusCC());

        MedicationsCurrentlyTakingToTreatLupusCC medicationsCurrentlyTakingToTreatLupusCC = whenDiagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 6 months ago")
                .clickNextButton(new MedicationsCurrentlyTakingToTreatLupusCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017449-QS6104-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whenDiagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(new MedicationsCurrentlyTakingToTreatLupusCC());

        BiologicMedicationsCC biologicMedicationsCC = medicationsCurrentlyTakingToTreatLupusCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsCC())
                .waitForPageLoadNew();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017452-QS6106-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        medicationsCurrentlyTakingToTreatLupusCC
                .waitForPageLoad()
                .clickOnAnswers("Chloroquine (Agent Note: KLOR-oh-quinn)", "Plaquenil, also known as hydroxychloroquine (Agent Note: PLACK-kwuh-nil, hi-droxy-KLOR-oh-quinn)")
                .clickNextButton(new BiologicMedicationsCC())
                .waitForPageLoadNew();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017452-QS6106-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        medicationsCurrentlyTakingToTreatLupusCC
                .waitForPageLoad()
                .clickOnAnswers("Chloroquine (Agent Note: KLOR-oh-quinn)", "Plaquenil, also known as hydroxychloroquine (Agent Note: PLACK-kwuh-nil, hi-droxy-KLOR-oh-quinn)")
                .clickOnAnswers("Arava, also known as leflunomide (Agent Note: uh-RAHV-uh, leh-FLOO-no-myde)")
                .clickNextButton(new BiologicMedicationsCC());

        EitherOfTheFollowingMedicationsCC eitherOfTheFollowingMedicationsCC = biologicMedicationsCC
                .waitForPageLoadNew()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)", "Benlysta (Agent Note: ben-LIST-uh)", "Cimzia (Agent Note: SIM-zee-uh)", "Cosentyx (Agent Note: co-SEN-tix)", "Enbrel (Agent Note: EN-brel)")
                .clickOnAnswers("Entyvio (Agent Note: en-TIV-ee-oh)", "Humira (Agent Note: hue-MAIR-uh)", "Kineret (Agent Note: KIN-er-et)", "Orencia (Agent Note: oh-REN-see-uh)", "Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)")
                .clickOnAnswers("Raptiva (Agent Note: rap-TEE-vuh)", "Remicade (Agent Note: REM-ih-cade)", "Rituxan (Agent Note: rih-TUX-an)", "Simponi (Agent Note: SIM-po-nee)")
                .clickOnAnswers("Stelara (Agent Note: ste-LAHR-uh)", "Taltz (Agent Note: TALTS)", "Tysabri (Agent Note: tie-SAB-ree)")
                .clickNextButton(new EitherOfTheFollowingMedicationsCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016383-QS6107-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        biologicMedicationsCC
                .waitForPageLoadNew()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EitherOfTheFollowingMedicationsCC());

        PermanentlyWheelchairBoundCC permanentlyWheelchairBoundCC = eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new PermanentlyWheelchairBoundCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017453-QS6108-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickOnAnswers("Xeljanz (Agent Note: ZEL-jans)")
                .clickNextButton(new PermanentlyWheelchairBoundCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017453-QS6108-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PermanentlyWheelchairBoundCC());

        ExperienceWithYourLupusCC experienceWithYourLupusCC = permanentlyWheelchairBoundCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ExperienceWithYourLupusCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0014045-QS6113-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        permanentlyWheelchairBoundCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ExperienceWithYourLupusCC());

        experienceWithYourLupusCC
                .waitForPageLoad()
                .clickOnAnswers("Fatigue", "Fever", "Joint pain, stiffness and swelling", "Butterfly-shaped rash on the face that covers the cheeks and bridge of the nose or rashes elsewhere on the body")
                .clickOnAnswers("Skin lesions that appear or worsen with sun exposure", "Fingers and toes that turn white or blue when exposed to cold or during stressful periods")
                .clickOnAnswers("Shortness of breath", "Chest pain", "Dry eyes", "Headaches, confusion, or memory loss")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadNew("lupus")
                .back();

        experienceWithYourLupusCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadNew("lupus")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancer());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancer
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad();
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
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol2);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5, "Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected5, "1 - 3 months ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());

        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol2);
        debugPageCC.back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol2);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol2);
        debugPageCC.back();

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());


        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
// 					.clickNextButton(new ChildrenUnderPageCC())
// 					.waitForPageLoad()
// 					.clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a lupus study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad("Lupus (SLE)")
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

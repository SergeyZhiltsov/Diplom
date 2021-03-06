package com.acurian.selenium.CC;


import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LPS_4442.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lupus_4442_CC extends BaseTest {

    @Test(enabled = true)
    public void lupus_4442_cc() {
        Site site = Site.LPS_4442;
        String phoneNumberOA = "AUTAMS1LPS";
        String protocol1 = "I4V_MC_JAHZ";
        String protocol2 = "I4V_MC_JAIA";
        String studyName = "migraine";
        String site_indication = "Ankylosing Spondylitis";

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

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .waitForPageLoad("a lupus study", "500")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1, protocol2)
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad("a lupus study", "500")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedWithLupusCC diagnosedWithLupusCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithLupusCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithLupusCC
                .waitForPageLoad2()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017447-QS6102-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        WhatTypeOfLupusCC whatTypeOfLupusCC = diagnosedWithLupusCC
                .waitForPageLoad2()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatTypeOfLupusCC());

        TransitionStatementCC transitionStatementCC = whatTypeOfLupusCC
                .waitForPageLoad2()
                .clickOnAnswer("Drug-induced lupus - a form of lupus caused by certain prescription medications")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC.waitForPageLoadNew("lupus");
        debugPageCC.checkProtocolsContainsForQNumber("Q0022611-QS6116-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
//        whatTypeOfLupusCC
//                .waitForPageLoad2()
//                .clickOnAnswer("Neonatal lupus (Agent Note: nee-oh-NAY-tal LOOP-us) - a form of lupus that affects newborn infants")
//                .clickNextButton(new TransitionStatementCC())
//                .waitForPageLoadNew("lupus");
//        debugPageCC.checkProtocolsContainsForQNumber("Q0017448-QS6103-STUDYQUES", protocol1, protocol2);
//        debugPageCC.back();
        WhenDiagnosedWithLupusCC whenDiagnosedWithLupusCC = whatTypeOfLupusCC
                .waitForPageLoad2()
                .clickOnAnswer("Cutaneous lupus (Agent Note: cu-TAY-nee-uhs LOOP-us) - a form of lupus which affects the skin only")
                .clickNextButton(new WhenDiagnosedWithLupusCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0022611-QS6116-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whatTypeOfLupusCC
                .waitForPageLoad2()
                .clickOnAnswer("Unsure")
                .clickNextButton(new WhenDiagnosedWithLupusCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0022611-QS6116-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whatTypeOfLupusCC
                .waitForPageLoad2()
                .clickOnAnswer("Systemic lupus (SLE) (Agent Note: sis-STEM-ic LOOP-us) - the most common form of lupus, which may affect multiple organs and tissues in the body")
                .clickNextButton(new WhenDiagnosedWithLupusCC());


        TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC typeOfDoctorCurrentlySeeToHelpManageYourLupusСС = whenDiagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC())
                .waitForPageLoad2();
        debugPageCC.checkProtocolsContainsForQNumber("Q0022612-QS6117-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whenDiagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 months ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC())
                .waitForPageLoad2();
        debugPageCC.checkProtocolsContainsForQNumber("Q0022612-QS6117-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whenDiagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 4 months ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC())
                .waitForPageLoad2();
        debugPageCC.checkProtocolsContainsForQNumber("Q0022612-QS6117-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whenDiagnosedWithLupusCC
                .waitForPageLoad()
                .clickOnAnswer("5 - 6 months ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC())
                .waitForPageLoad2();


        CurrentlyTakingPrescriptionMedicationsCC currentlyTakingPrescriptionMedicationsCC = typeOfDoctorCurrentlySeeToHelpManageYourLupusСС
                .waitForPageLoad2()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyTakingPrescriptionMedicationsCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0022613-QS6118-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        typeOfDoctorCurrentlySeeToHelpManageYourLupusСС
                .waitForPageLoad2()
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyTakingPrescriptionMedicationsCC());

        NewOrWorseningLupusSymptomsCC newOrWorseningLupusSymptomsCC = currentlyTakingPrescriptionMedicationsCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NewOrWorseningLupusSymptomsCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0022614-QS6119-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        MedicationsCurrentlyTakingToTreatLupusCC medicationsCurrentlyTakingToTreatLupusCC = currentlyTakingPrescriptionMedicationsCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new MedicationsCurrentlyTakingToTreatLupusCC());

//                .clickOnAnswers("None of the above")
//                .clickNextButton(new BiologicMedications())
//                .waitForPageLoadKAD();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS6106", protocol1, protocol2);
//        debugPageOLS.back();
//        medicationsCurrentlyTakingToTreatLupusOLS
//                .waitForPageLoad()


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

        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(newOrWorseningLupusSymptomsCC)
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017453-QS6108-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xeljanz (Agent Note: ZEL-jans)")
                .clickNextButton(newOrWorseningLupusSymptomsCC)
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017453-QS6108-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(newOrWorseningLupusSymptomsCC);

        ExperienceWithYourLupusCC experienceWithYourLupusCC = newOrWorseningLupusSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ExperienceWithYourLupusCC());

        experienceWithYourLupusCC
                .waitForPageLoad()
                .clickOnAnswers("Prolonged or extreme fatigue", "Unexplained fever", "Joint pain, stiffness and swelling", "Butterfly-shaped rash on the face that covers the cheeks and bridge of the nose or rashes elsewhere on the body")
                .clickOnAnswers("Skin lesions that appear or worsen with sun exposure", "Sensitivity to sun and/or other light", "Mouth sores or ulcers", "Difficulty swallowing")
                .clickOnAnswers("Pale or purple fingers or toes from cold or stress", "Shortness of breath", "Chest pain", "Dry eyes", "Headaches, confusion, or memory loss", "Hair loss")
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

//--------------------
        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(new WhatKindOfArthritisPageCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whatKindOfArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004962-QS39-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        whatKindOfArthritisPageCC.back();


        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol2);
        debugPageCC.back();
        whenDiagnosedWithCancerCC.back();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol2);
        debugPageCC.back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "Less than 30 days ago")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "1 - 3 months ago")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol2);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());

        heartRelatedSurgeriesProceduresPageCC
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
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a lupus study")
                .getPID()
                .clickOnAnswer(site.name)
//                .clickNextButton(new HSGeneralCC())
//                .waitForPageLoad("Lupus (SLE)")
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
//                .clickNextButton(new HSMedicalRecordsPageCC())
//                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();
        if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env, "4442")
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}

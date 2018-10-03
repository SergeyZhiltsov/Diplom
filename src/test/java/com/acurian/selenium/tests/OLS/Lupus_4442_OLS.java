package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AS_4319.AreYouWheelchairBoundOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LPS_4442.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.BiologicMedications;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.time.Instant;

public class Lupus_4442_OLS extends BaseTest {

    @Test(enabled = true)
    @TestCaseId("00019")
    @Description("4442 Lilly Lupus")
    public void lupus_4442() {
        String phoneNumberMIG = "AUTAMS1LPS";
        String protocol1 = "I4V_MC_JAHZ";
        String protocol2 = "I4V_MC_JAIA";
        String studyName = "a lupus";
        String siteName = "LPS_4442";
        String zipCode = "08204";
        String site_Indication = "Lupus (SLE)";
        String env = System.getProperty("acurian.env", "STG");

        String time = String.valueOf(Instant.now().getEpochSecond());
        time = time.substring(time.length() - 4);
        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleLPSExpected, "Title is diff");
        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                .setDate("09092003")
                .clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1, protocol2);
        debugPageOLS.back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("10/10/1980")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode("08204")
                .clickNextButton(new GenderPageOLS());

        DiagnosedYouWithLupusOLS diagnosedYouWithLupusOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedYouWithLupusOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedYouWithLupusOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6102", protocol1, protocol2);
        debugPageOLS.back();

        WhatTypeOfLupusOLS whatTypeOfLupusOLS = diagnosedYouWithLupusOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatTypeOfLupusOLS());

        whatTypeOfLupusOLS
                .waitForPageLoad()
                .clickOnAnswer("Cutaneous lupus - a form of lupus which affects the skin only")
                .clickNextButton(new WhenWereYouDiagnosedOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6103", protocol1, protocol2);
        debugPageOLS.back();
        whatTypeOfLupusOLS
                .waitForPageLoad()
                .clickOnAnswer("Drug-induced lupus - a form of lupus caused by certain prescription medications")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6103", protocol1, protocol2);
        debugPageOLS.back();
        whatTypeOfLupusOLS
                .waitForPageLoad()
                .clickOnAnswer("Neonatal lupus - a form of lupus that affects newborn infants")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6103", protocol1, protocol2);
        debugPageOLS.back();

        WhenWereYouDiagnosedOLS whenWereYouDiagnosedOLS = whatTypeOfLupusOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new WhenWereYouDiagnosedOLS());

        MedicationsCurrentlyTakingToTreatLupusOLS medicationsCurrentlyTakingToTreatLupusOLS = whenWereYouDiagnosedOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 6 months ago")
                .clickNextButton(new MedicationsCurrentlyTakingToTreatLupusOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6104", protocol1, protocol2);
        debugPageOLS.back();
        whenWereYouDiagnosedOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(new MedicationsCurrentlyTakingToTreatLupusOLS())
                .waitForPageLoad();

        BiologicMedications biologicMedications = medicationsCurrentlyTakingToTreatLupusOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedications())
                .waitForPageLoadKAD();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6106", protocol1, protocol2);
        debugPageOLS.back();
        medicationsCurrentlyTakingToTreatLupusOLS
                .waitForPageLoad()
                .clickOnAnswers("Arava (leflunomide)", "Astagraf, Envarsus, or Prograf (tacrolimus)", "Azasan or Imuran (azathioprine)", "Azulfidine (sulfasalazine)")
                .clickOnAnswers("CellCept or Myfortic (mycophenolate)", "Chloroquine", "Corticosteroid taken by mouth, such as prednisone")
                .clickOnAnswers("Methotrexate (Otrexup, Rasuvo, or Trexall)", "Plaquenil (hydroxychloroquine)")
                .clickNextButton(new BiologicMedications())
                .waitForPageLoadKAD();
        biologicMedications.back();

        medicationsCurrentlyTakingToTreatLupusOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arava (leflunomide)")
                .clickNextButton(new BiologicMedications());

        EitherOfFollowingMedicationsOLS eitherOfFollowingMedicationsOLS = biologicMedications
                .waitForPageLoadKAD()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)", "Benlysta", "Cimzia", "Cosentyx", "Enbrel", "Entyvio", "Humira",
                        "Kineret", "Orencia", "Prolia or Xgeva", "Raptiva", "Remicade", "Rituxan", "Simponi", "Stelara", "Taltz", "Tysabri")
                .clickNextButton(new EitherOfFollowingMedicationsOLS())
                .waitForPageLoad();
        eitherOfFollowingMedicationsOLS.back();
        biologicMedications
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EitherOfFollowingMedicationsOLS());

        AreYouWheelchairBoundOLS areYouWheelchairBoundOLS = eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Jakafi")
                .clickNextButton(new AreYouWheelchairBoundOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6108", protocol1, protocol2);
        debugPageOLS.back();
        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Xeljanz")
                .clickNextButton(new AreYouWheelchairBoundOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6108", protocol1, protocol2);
        debugPageOLS.back();
        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouWheelchairBoundOLS());

        ExperienceWithYourLupusOLS experienceWithYourLupusOLS = areYouWheelchairBoundOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ExperienceWithYourLupusOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6113", protocol1, protocol2);
        debugPageOLS.back();
        areYouWheelchairBoundOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ExperienceWithYourLupusOLS());

        experienceWithYourLupusOLS
                .waitForPageLoad()
                .clickOnAnswers("Fatigue", "Fever", "Joint pain, stiffness and swelling", "Skin lesions that appear or worsen with sun exposure", "Shortness of breath")
                .clickOnAnswers("Butterfly-shaped rash on the face that covers the cheeks and bridge of the nose or rashes elsewhere on the body", "Headaches, confusion, or memory loss")
                .clickOnAnswers("Fingers and toes that turn white or blue when exposed to cold or during stressful periods", "Chest pain", "Dry eyes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.back();
        experienceWithYourLupusOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        CancerPage cancerPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new CancerPage());
        cancerPage.threadSleep(1000);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = cancerPage
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS42", protocol1);
        debugPageOLS.back();
        cancerPage
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"mini-stroke\"", "Angina (heart-related chest pain) that required an overnight hospital stay", "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1), subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2), subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(3), subquestionExperiencedHeartPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(4), subquestionExperiencedHeartPageOLS.titleExpected4, "Title is diff");
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "1 - 3 months ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS.threadSleep(1000);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS61", protocol1);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
//		.clickNextButton(new ChildrenUnderPageOLS())
//		.waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", eMailId, "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()

                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
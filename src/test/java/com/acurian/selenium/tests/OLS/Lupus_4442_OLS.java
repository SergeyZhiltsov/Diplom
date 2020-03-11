package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LPS_4442.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.BiologicMedications;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import com.acurian.selenium.utils.Properties;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.time.Instant;

public class Lupus_4442_OLS extends BaseTest {

    @Test()
    @Description("4442 Lilly Lupus OLS")
    public void lupus4442olsTest() {
        Site site = Site.LPS_4442;
        String phoneNumber = "AUTAMS1LPS";
        String protocol1 = "I4V_MC_JAHZ";
        String protocol2 = "I4V_MC_JAIA";
        String studyName = "a lupus";
        String site_Indication = "Lupus (SLE)";
        String env = System.getProperty("acurian.env", "STG");

        String time = String.valueOf(Instant.now().getEpochSecond());
        time = time.substring(time.length() - 4);
        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a lupus study", "500");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a lupus study", "500"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1, protocol2);
        debugPageOLS.back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a lupus study", "500")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DiagnosedYouWithLupusOLS diagnosedYouWithLupusOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("10/10/1980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedYouWithLupusOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedYouWithLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6102", protocol1, protocol2);
        debugPageOLS.back();

        WhatTypeOfLupusOLS whatTypeOfLupusOLS = diagnosedYouWithLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatTypeOfLupusOLS());

        whatTypeOfLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("Cutaneous lupus - a form of lupus which affects the skin only")
                .clickNextButton(new WhenWereYouDiagnosedOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6116", protocol1, protocol2);
        debugPageOLS.back();
        whatTypeOfLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("Drug-induced lupus - a form of lupus caused by certain prescription medications")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6116", protocol1, protocol2);
        debugPageOLS.back();
//        whatTypeOfLupusOLS
//                .waitForPageLoad2()
//                .clickOnAnswer("Neonatal lupus - a form of lupus that affects newborn infants")
//                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
//                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS6103", protocol1, protocol2);
//        debugPageOLS.back();
        whatTypeOfLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("Unsure")
                .clickNextButton(new WhenWereYouDiagnosedOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6116", protocol1, protocol2);
        debugPageOLS.back();
        WhenWereYouDiagnosedOLS whenWereYouDiagnosedOLS = whatTypeOfLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("Systemic lupus (SLE) - the most common form of lupus, which may affect multiple organs and tissues in the body")
                .clickNextButton(new WhenWereYouDiagnosedOLS());


        TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS typeOfDoctorCurrentlySeeToHelpManageYourLupusOLS = whenWereYouDiagnosedOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS())
                .waitForPageLoad2();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6117", protocol1, protocol2);
        debugPageOLS.back();
        whenWereYouDiagnosedOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 months ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS())
                .waitForPageLoad2();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6117", protocol1, protocol2);
        debugPageOLS.back();
        whenWereYouDiagnosedOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 4 months ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS())
                .waitForPageLoad2();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6117", protocol1, protocol2);
        debugPageOLS.back();
        whenWereYouDiagnosedOLS
                .waitForPageLoad()
                .clickOnAnswer("5 - 6 months ago")
                .clickNextButton(new TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS())
                .waitForPageLoad2();


        CurrentlyTakingPrescriptionMedicationsOLS currentlyTakingPrescriptionMedicationsOLS = typeOfDoctorCurrentlySeeToHelpManageYourLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyTakingPrescriptionMedicationsOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6118", protocol1, protocol2);
        debugPageOLS.back();
        typeOfDoctorCurrentlySeeToHelpManageYourLupusOLS
                .waitForPageLoad2()
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyTakingPrescriptionMedicationsOLS());

        NewOrWorseningLupusSymptomsOLS newOrWorseningLupusSymptomsOLS = currentlyTakingPrescriptionMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NewOrWorseningLupusSymptomsOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6119", protocol1, protocol2);
        debugPageOLS.back();
        MedicationsCurrentlyTakingToTreatLupusOLS medicationsCurrentlyTakingToTreatLupusOLS = currentlyTakingPrescriptionMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new MedicationsCurrentlyTakingToTreatLupusOLS());

        BiologicMedications biologicMedications = medicationsCurrentlyTakingToTreatLupusOLS
                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new BiologicMedications())
//                .waitForPageLoadKAD();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS6106", protocol1, protocol2);
//        debugPageOLS.back();
//        medicationsCurrentlyTakingToTreatLupusOLS
//                .waitForPageLoad()
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

        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Jakafi")
                .clickNextButton(newOrWorseningLupusSymptomsOLS)
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6108", protocol1, protocol2);
        debugPageOLS.back();
        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Xeljanz")
                .clickNextButton(newOrWorseningLupusSymptomsOLS)
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6108", protocol1, protocol2);
        debugPageOLS.back();
        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(newOrWorseningLupusSymptomsOLS);

        ExperienceWithYourLupusOLS experienceWithYourLupusOLS = newOrWorseningLupusSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ExperienceWithYourLupusOLS());
//                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS6113", protocol1, protocol2);
//        debugPageOLS.back();
//        permanentlyUnableWalkDueToMedicalConditionPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new ExperienceWithYourLupusOLS());

        experienceWithYourLupusOLS
                .waitForPageLoad()
                .clickOnAnswers("Prolonged or extreme fatigue", "Unexplained fever", "Joint pain, stiffness and swelling", "Skin lesions that appear or worsen with sun exposure", "Shortness of breath")
                .clickOnAnswers("Butterfly-shaped rash on the face that covers the cheeks and bridge of the nose or rashes elsewhere on the body", "Headaches, confusion, or memory loss")
                .clickOnAnswers("Sensitivity to sun and/or other light", "Mouth sores or ulcers", "Chest pain", "Dry eyes")
                .clickOnAnswers("Difficulty swallowing", "Pale or purple fingers or toes from cold or stress", "Hair loss")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.back();
        experienceWithYourLupusOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS42", protocol1);
        debugPageOLS.back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight", "Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4);
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS61", protocol1);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", eMailId, "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
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
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
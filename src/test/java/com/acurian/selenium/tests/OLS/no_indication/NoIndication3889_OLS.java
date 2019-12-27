package com.acurian.selenium.tests.OLS.no_indication;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.CurrentlyHaveAnyOffFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.HashMap;
import java.util.Map;

public class NoIndication3889_OLS extends BaseTest {

    @Test(enabled = false)
    @Description("No Indication 3889 OLS")
    public void ibd_3889_OLS_NI() {
        Site site = Site.AUT_CRN_3889_HS;
        String phoneNumber = "AUTAMS1GEN";
        String studyName = "a Crohn's";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a study", "1,000");
       // Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(), dateOfBirthPageOLS.getExpectedModifiedTitle("a study", "1,000"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Autism spectrum",
                        "High cholesterol, triglycerides, or lipids",
                        "Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                                "Kidney disease",
                                "Heart or circulation problems (heart attack, heart failure, stroke)",
                                "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                                "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                                "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                                "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                .back();
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4,
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());

        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .clickOnQNumber("QS38");
//        approximateHeightPageOLS
//                .waitForPageLoad()
//                .back();
//
//        doAnyOftheFollowingAdditionalDiagnosesOLS
//                .waitForPageLoad()
//                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers(
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS)
                .waitForPageLoad()
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .clickNextButton(doYouExperienceAnyOfFollowingSymptoms_OLS);


        CrohnsDiseaseDoctorOrNursePageOLS crohnsDiseaseDoctorOrNursePageOLS = doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CrohnsDiseaseDoctorOrNursePageOLS());
        UnqualifiedCloseOLS unqualifiedCloseOLS = crohnsDiseaseDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new UnqualifiedCloseOLS());

        unqualifiedCloseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5726", site.activeProtocols)
                .clickOnQNumber("QS5726");
        crohnsDiseaseDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(unqualifiedCloseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5726", site.activeProtocols)
                .clickOnQNumber("QS5726");
        WhenWereYouDiagnosedWithCrohnsPageOLS whenWereYouDiagnosedWithCrohnsPageOLS = crohnsDiseaseDoctorOrNursePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenWereYouDiagnosedWithCrohnsPageOLS());

        ReviewMedicalRecordsCrohnsDiagnosisPageOLS reviewMedicalRecordsCrohnsDiagnosisPageOLS = whenWereYouDiagnosedWithCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new ReviewMedicalRecordsCrohnsDiagnosisPageOLS());
        reviewMedicalRecordsCrohnsDiagnosisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5703", site.activeProtocols)
                .back(whenWereYouDiagnosedWithCrohnsPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months ago")
                .clickNextButton(reviewMedicalRecordsCrohnsDiagnosisPageOLS);

        PartOfDiagnosisFollowingProceduresDonePageOLS partOfDiagnosisFollowingProceduresDonePageOLS =
        reviewMedicalRecordsCrohnsDiagnosisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PartOfDiagnosisFollowingProceduresDonePageOLS());

        ManageYourCrohnsPageOLS manageYourCrohnsPageOLS = partOfDiagnosisFollowingProceduresDonePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Endoscopy – a thin, flexible, lighted tube is inserted through the mouth. This allows the doctor to look for abnormal areas. A biopsy is sometimes taken during this test.")
                .clickNextButton(new ManageYourCrohnsPageOLS());

        CrohnsDiseaseOrUlcerativeColitisFlarePageOLS crohnsDiseaseOrUlcerativeColitisFlarePageOLS = manageYourCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CrohnsDiseaseOrUlcerativeColitisFlarePageOLS());
        crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5706", site.activeProtocols)
                .back(manageYourCrohnsPageOLS);
        SteroidMedicationsForCrohnsOLS steroidMedicationsForCrohnsOLS = manageYourCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsForCrohnsOLS());

        //---------------Q7 Have you ever taken steroid medications for your Crohn's or colitis?--------------------------------------------
        FollowingMedicationsCrohnsPageOLS followingMedicationsCrohnsPageOLS = steroidMedicationsForCrohnsOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new FollowingMedicationsCrohnsPageOLS());
        followingMedicationsCrohnsPageOLS
                .waitForPageLoad()
                .back();
        steroidMedicationsForCrohnsOLS.
                waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingMedicationsCrohnsPageOLS());


        //---------------Q8 Have you ever taken any of the following medications for your Crohn's or colitis? page------------------
        followingMedicationsCrohnsPageOLS
                .waitForPageLoad();
        EverTreatedCrohnOrColitisOLS everTreatedCrohnOrColitisOLS = followingMedicationsCrohnsPageOLS
                .clickOnAnswers("Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, or Rowasa (mesalamine)",
                        "Azulfidine (sulfasalazine)",
                        "Colazal or Giazo (balsalazide)",
                        "Dipentum (olsalazine)")
                .clickNextButton(new EverTreatedCrohnOrColitisOLS());


        //---------------Q9 heartrelatedMedicalProceduresPageOLS page------------------
        everTreatedCrohnOrColitisOLS
                .waitForPageLoad();
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = everTreatedCrohnOrColitisOLS
                .clickOnAnswers("Astagraf, Envarsus, or Prograf (tacrolimus)",
                        "Azasan or Imuran (azathioprine)",
                        "CellCept or Myfortic (mycophenolate)",
                        "Jakafi (ruxolitinib)",
                        "Methotrexate pills or tablets (Rheumatrex, Trexall)",
                        "Methotrexate injections or shots (Otrexup, Rasuvo)",
                        "Purixan (6-MP or mercaptopurine)",
                        "Rapamune (sirolimus)",
                        "Sandimmune, Gengraf, or Neoral (cyclosporine)",
                        "Xeljanz (tofacitinib)")
                .clickNextButton(new BiologicMedicationsPageOLS());
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5709", site.activeProtocols[0], site.activeProtocols[1])
                .back();
        everTreatedCrohnOrColitisOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageOLS());


        //---------------Q10 Have you ever received any of the following "biologic" medications? page------------------
        biologicMedicationsPageOLS
                .waitForPageLoad();
        biologicMedicationsPageOLS.clickOnAnswers("Actemra",
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
                "Tysabri")
                .clickOnAnswers("Tysabri")  //DOn't Uncheck "Stelara (Agent Note: ste-LAHR-uh)" option to qualify
                .clickNextButton(biologicMedicationsPageOLS);

        biologicMedicationsPageOLS
                .waitForPageLoadNew()
                .clickOnAnswers("None of the above")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageOLS);

        //---------------Q14 Are you currently experiencing a flare-up? page------------------
        crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .waitForPageLoad();
        SubquestionsIbdPleaseThinkCrohnsPageOLS subquestionsIbdPleaseThinkCrohnsPageOLS = crohnsDiseaseOrUlcerativeColitisFlarePageOLS
                .clickOnAnswer("Severe symptoms that make life difficult")
                .clickNextButton(new SubquestionsIbdPleaseThinkCrohnsPageOLS());

        SubquestionsIBD_OLS subquestionsIBD_OLS = subquestionsIbdPleaseThinkCrohnsPageOLS
                .waitForPageLoad()
                .setAvgDayBowelMovements("3")
                .clickOnAnswer("Moderate (interferes with my usual activity)")
                .clickNextButton(new SubquestionsIBD_OLS());

        CurrentlyHaveAnyOffFollowingPageOLS currentlyHaveAnyOffFollowingPageOLS = subquestionsIBD_OLS
                .waitForPageLoad(1, subquestionsIBD_OLS.titleExpected3)
                .clickOnAnswersForSubQuestion(1,"Abdominal pain or cramps")
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageOLS());

        HashMap<String, String[]> options = new HashMap<>();
        options.put("History of a bowel resection within the past 3 months", site.activeProtocols);
        options.put("Colostomy", site.activeProtocols);
        options.put("Ileostomy", site.activeProtocols);
      //  options.put("An abscess in your abdomen or pelvic region (an inflamed area with collection of pus)", site.activeProtocols); //*not DQed 4818 and 3264 protocols
        options.put("Feeding tube", site.activeProtocols);
        options.put("IV (parenteral) nutrition", site.activeProtocols);
        options.put("A planned or scheduled surgery for Crohn’s disease", site.activeProtocols);
        for (Map.Entry<String, String[]> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            currentlyHaveAnyOffFollowingPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(unqualifiedCloseOLS)
                    //.waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5733", entry.getValue())
                    .clickOnQNumber("QS5733");
        }

        IdentificationPageOLS identificationPageOLS = currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("An abscess in your abdomen or pelvic region (an inflamed area with collection of pus)")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5733", site.activeProtocols)
                .back();

        currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
//                .clickNextButton(new HSCrohns2PageOLS())
//                .waitForPageLoad()
                .clickNextButton(new MedicalRecordsOptionPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoadIBD("Crohn's Disease")
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
            thankYouCloseSimplePageOLS
                    .waitForSENRPageLoad()
                    .clickNextButton(new AboutHealthPageOLS())
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo);

    }
}

package com.acurian.selenium.tests.OLS.no_indication;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Crohns_3485.HaveAnyOfTheFollowingPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.*;
import com.acurian.selenium.pages.OLS.Vaccine_4556.AreYouInterestedInPneumoniaVaccineStudyOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class NoIndication3889_OLS extends BaseTest {

    @Test(enabled = true)
    @Description("No Indication 3889 OLS")
    public void ibd_3889_OLS_NI() {
        String phoneNumber = "AUTAMS1GEN";
        String protocol1 = "M14_431";
        String protocol2 = "M14_433";
        String protocol3 = "M15_991";
        String protocol4 = "M16_006";
//        List<String> protocols = Arrays.asList(protocol1, protocol2);
        String studyName = "a Crohn's";
        String siteName = "AUT_CRN_3889_HS";
        String debugSiteName = "";
        String zipCode = "19044";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(), dateOfBirthPageOLS.getExpectedModifiedTitle("a study", "1,000", true), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Autism spectrum",
                        "High cholesterol, triglycerides, or lipids",
                        "Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", protocol1, protocol2, protocol3, protocol4)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", protocol1, protocol2, protocol3, protocol4)
                .back();
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                                "Kidney disease",
                                "Heart or circulation problems (heart attack, heart failure, stroke)",
                                "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                                "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                                "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                                "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocol1, protocol2, protocol3, protocol4)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocol1, protocol2, protocol3, protocol4)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocol1, protocol2, protocol3, protocol4)
                .back();
        otherThanSkinCancerPageOLS
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
                .checkProtocolsContainsForQNumber("QS44", protocol1, protocol2, protocol3, protocol4)
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
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected5)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
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
                .checkProtocolsContainsForQNumber("QS51", protocol1, protocol2, protocol3, protocol4)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocol1, protocol2, protocol3, protocol4)
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
                .checkProtocolsContainsForQNumber("QS52", protocol1, protocol2, protocol3, protocol4)
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
                .checkProtocolsContainsForQNumber("QS53", protocol1, protocol2, protocol3, protocol4)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocol1, protocol2, protocol3, protocol4)
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
        otherThanSkinCancerPageOLS
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
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocol1, protocol2, protocol3, protocol4)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        UnqualifiedCloseOLS unqualifiedCloseOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new UnqualifiedCloseOLS());

        unqualifiedCloseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", protocol1, protocol2, protocol3, protocol4)
                .clickOnQNumber("QS38");
//        approximateHeightPageOLS
//                .waitForPageLoad()
//                .back();
//
//        doAnyOftheFollowingAdditionalDiagnosesOLS
//                .waitForPageLoad()
//                .back();

        WhenWereYouDiagnosedWithCrohnsDisease_OLS whenWereYouDiagnosedWithCrohnsDisease_ols = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                .clickNextButton(new WhenWereYouDiagnosedWithCrohnsDisease_OLS());

        WhenWasYourMostRecentColonoscopy_OLS whenWasYourMostRecentColonoscopy_OLS = whenWereYouDiagnosedWithCrohnsDisease_ols
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new WhenWasYourMostRecentColonoscopy_OLS());

        //---------------Q5 whenWasYourMostRecentColonoscopy_OLS Page-----------
        HaveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS = whenWasYourMostRecentColonoscopy_OLS
                .waitForPageLoad()
                .clickOnAnswer("I have never had a colonoscopy")
                .clickNextButton(new HaveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS());
        haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5705", protocol1, protocol2, protocol3, protocol4);
        debugPageOLS.back();
        whenWasYourMostRecentColonoscopy_OLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(new HaveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS());


        //---------------Q6 HaveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS page-------------------
        haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS
                .waitForPageLoad();
        //-------------If selected 'NO', disqualify and SKIP to Q14, otherwise goto Q7
        AreYouCurrentlyExperiencingFlareUp_OLS areYouCurrentlyExperiencingFlareUp_OLS = haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());
        areYouCurrentlyExperiencingFlareUp_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5706", protocol1, protocol2, protocol3, protocol4);
        debugPageOLS.back();
        haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS.waitForPageLoad();
        HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS = haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS());


        //---------------Q7 Have you ever taken steroid medications for your Crohn's or colitis?--------------------------------------------
        haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS
                .waitForPageLoad();
        HaveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS = haveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS());
        haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS
                .waitForPageLoad()
                .back();
        haveYouEverTakenAnyMedicationsToTreatManageCrohns_OLS.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS());


        //---------------Q8 Have you ever taken any of the following medications for your Crohn's or colitis? page------------------
        haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS
                .waitForPageLoad();
        HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS = haveYouEverTakenAnyOfFollowingMedicationsForCrohnsColitis_OLS
                .clickOnAnswers("Apriso, Asacol, Canasa, Delzicol, Lialda, Pentasa, or Rowasa (mesalamine)",
                        "Azulfidine (sulfasalazine)",
                        "Colazal or Giazo (balsalazide)",
                        "Dipentum (olsalazine)")
                .clickNextButton(new HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS());


        //---------------Q9 heartrelatedMedicalProceduresPageOLS page------------------
        haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS
                .waitForPageLoad();
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS
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
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS5709", protocol1, protocol2);
        debugPageOLS.back();
        haveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageOLS());


        //---------------Q10 Have you ever received any of the following "biologic" medications? page------------------
        biologicMedicationsPageOLS
                .waitForPageLoad();
        biologicMedicationsPageOLS.clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)",
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
                .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());
        areYouCurrentlyExperiencingFlareUp_OLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5710", protocol3, protocol4)
                .back();
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Tysabri")  //DOn't Uncheck "Stelara (Agent Note: ste-LAHR-uh)" option to qualify
                .clickNextButton(new AreYouCurrentlyExperiencingFlareUp_OLS());


        //---------------Q14 Are you currently experiencing a flare-up? page------------------
        areYouCurrentlyExperiencingFlareUp_OLS
                .waitForPageLoad();
        SubquestionsIBD_ShireCrohns_OLS subquestionsIBD_ShireCrohns_OLS = areYouCurrentlyExperiencingFlareUp_OLS
                .clickOnAnswer("No, I am not currently in a flare with my Crohn's or colitis")
                .clickNextButton(new SubquestionsIBD_ShireCrohns_OLS());


        //-----------------------Q15 Please think about your Crohn's disease symptoms when answering the questions below.----------------------
        subquestionsIBD_ShireCrohns_OLS
                .waitForPageLoad(1, subquestionsIBD_ShireCrohns_OLS.titleExpected1)
                .waitForPageLoad(2, subquestionsIBD_ShireCrohns_OLS.titleExpected2)
                .waitForPageLoad(3, subquestionsIBD_ShireCrohns_OLS.titleExpected3);
        //----------Select options for 15.1, 15.2 and 15.3 sub-questions---------
        //WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = subquestionsIBD_OLS
        SubquestionsIBD_OLS subquestionsIBD_OLS = subquestionsIBD_ShireCrohns_OLS
                .avgDayBowelMovements("2")
                .past24hrBowelMovements("2")
                .abdominalpainOnaScale("2")
                .clickNextButton(new SubquestionsIBD_OLS());


        //-----------------------Q17 In general, how would you rate your health, living with Crohn's or colitis?----------------------
        subquestionsIBD_OLS
                .waitForPageLoad(1, subquestionsIBD_OLS.titleExpected1)
                .waitForPageLoad(2, subquestionsIBD_OLS.titleExpected2)
                .waitForPageLoad(3, subquestionsIBD_OLS.titleExpected3)
                .getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS5714", protocol2)
                .back();
        subquestionsIBD_ShireCrohns_OLS.back();
        areYouCurrentlyExperiencingFlareUp_OLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure as to whether I am in a flare with my Crohn's or colitis")
                .clickNextButton(new SubquestionsIBD_OLS());
        subquestionsIBD_ShireCrohns_OLS
                .waitForPageLoad(1, subquestionsIBD_ShireCrohns_OLS.titleExpected1)
                .waitForPageLoad(2, subquestionsIBD_ShireCrohns_OLS.titleExpected2)
                .waitForPageLoad(3, subquestionsIBD_ShireCrohns_OLS.titleExpected3)
                .getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS5714", protocol1)
                .clickNextButton(new SubquestionsIBD_OLS());
        subquestionsIBD_OLS.waitForPageLoad(1, subquestionsIBD_OLS.titleExpected1);
        //----------Select options for 15.1, 15.2 and 15.3 sub-questions---------
        subquestionsIBD_OLS.waitForPageLoad(1, subquestionsIBD_OLS.titleExpected1);
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = subquestionsIBD_OLS
                .clickOnAnswerForSubQuestion(subquestionsIBD_OLS.titleExpected1, "Good")
                .clickOnAnswersForSubQuestion(subquestionsIBD_OLS.titleExpected2, "Somewhat better now")
                .clickOnAnswerForSubQuestion(subquestionsIBD_OLS.titleExpected3, "Loss of bowel control")
                .clickNextButton(new WeightLossSurgeryPageOLS());


        //-----------------------Q16 - Have you ever had any of the following types of bariatric or weight loss surgery?  page----------------------
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(), weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        HaveAnyOfTheFollowingPageOLS haveAnyOfTheFollowingPageOLS = weightLossSurgeryPageOLS
                //-----SKIP to Q18 if selected "None of the above" in Q16, otherwise goto Q17
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .back();
        weightLossSurgeryPageOLS
                .waitForPageLoad();
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass",
                        "Gastric sleeve or sleeve gastrectomy",
                        "Duodenal switch",
                        "Lap band or gastric banding",
                        "Gastric balloon",
                        "I had a weight loss surgery, but I am unsure which type")
                .clickNextButton(new ProcedureForWeightLossPageOLS());


        //----------------Q17 - When was the last time that you had a surgery or medical procedure for weight loss?  page----------------------
        procedureForWeightLossPageOLS
                .waitForPageLoad();
        procedureForWeightLossPageOLS.clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back();
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                //------------------Change Answer in Q16 to "None of the Above"  to qualify and goto Q18
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());


        //----------------Q18 - Do you currently have any of the following? page----------------------
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad();
        //-----DQ if selected any/all of these options - "Colostomy and/or Colectomy","Ileostomy","Another type of stomach or colon surgery" in Q18 -------
        haveAnyOfTheFollowingPageOLS
                .clickOnAnswers("Colostomy and/or Colectomy",
                        "Ileostomy",
                        "Another type of stomach or colon surgery")
                .clickNextButton(unqualifiedCloseOLS);
        unqualifiedCloseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5718", protocol1, protocol2, protocol3, protocol4)
                .clickOnQNumber("QS5718");
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
//                .clickNextButton(new HSCrohns2PageOLS())
//                .waitForPageLoad()
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
                .pidFromDbToLog(env);
    }
}

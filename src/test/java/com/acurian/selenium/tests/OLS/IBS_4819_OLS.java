package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.GERD.WhenDidYouHaveAppendixRemoved_OLS;
import com.acurian.selenium.pages.OLS.IBS.*;
import com.acurian.selenium.pages.OLS.Obesity_4605.ExperienceExcessiveHungerOrIncreasedAppetiteOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class IBS_4819_OLS extends BaseTest {

    @Test()
    @Description("IBS 4819 OLS Urovant IBS")
    public void ibs4819olsTest() {
        Site site = Site.AUT_IBS4819_site;
        String phoneNumber = "AUTAMS1IBS";
        String studyName = "an irritable bowel syndrome (IBS)";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.
                getExpectedModifiedTitle("an irritable bowel syndrome (IBS) study", "300"),
                "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
        genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01081947")//Disqualify ("Age") if >= 71
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        SufferFromIrritablePageOLS sufferFromIrritablePageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01081990")
                .clickOnAnswer("Male") //Disqualify ("Male")
                .clickNextButton(new SufferFromIrritablePageOLS());
        sufferFromIrritablePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(sufferFromIrritablePageOLS);
        sufferFromIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not experience these symptoms of IBS")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6602", site.activeProtocols)
                .back();
        HowLongExperiencingIrritablePageOLS howLongExperiencingIrritablePageOLS = sufferFromIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I have been diagnosed with IBS by a healthcare professional")
                .clickNextButton(new HowLongExperiencingIrritablePageOLS());

        WhichOfTheFollowingExperienceIrritablePageOLS whichOfTheFollowingExperienceIrritablePageOLS =
                howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new WhichOfTheFollowingExperienceIrritablePageOLS());
        whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6603", site.activeProtocols)
                .back();
        howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 5 months")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6603", site.activeProtocols)
                .back();
        howLongExperiencingIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months to 1 year")
                .clickNextButton(whichOfTheFollowingExperienceIrritablePageOLS);

        AbdominalPainWhenHavingIBSPageOLS abdominalPainWhenHavingIBSPageOLS =
                whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Constipation only")
                .clickNextButton(new AbdominalPainWhenHavingIBSPageOLS());
        abdominalPainWhenHavingIBSPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6604", site.activeProtocols)
                .back();
        whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6604", site.activeProtocols)
                .back();
        WhichSymptomOccursPageOLS whichSymptomOccursPageOLS = whichOfTheFollowingExperienceIrritablePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Both constipation and diarrhea")
                .clickNextButton(new WhichSymptomOccursPageOLS());

        whichSymptomOccursPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Constipation")
                .clickNextButton(abdominalPainWhenHavingIBSPageOLS);

        CurrentlyTakeTreatIBSPageOLS currentlyTakeTreatIBSPageOLS = abdominalPainWhenHavingIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyTakeTreatIBSPageOLS());
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6606", site.activeProtocols)
                .back();
        HowOftenAbdominalPainPageOLS howOftenAbdominalPainPageOLS = abdominalPainWhenHavingIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowOftenAbdominalPainPageOLS());

        AbdominalPainOverPastPageOLS abdominalPainOverPastPageOLS = howOftenAbdominalPainPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 day a month or less")
                .clickNextButton(new AbdominalPainOverPastPageOLS());
        abdominalPainOverPastPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6607", site.activeProtocols)
                .back();
        howOftenAbdominalPainPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days a month")
                .clickNextButton(abdominalPainOverPastPageOLS);

        abdominalPainOverPastPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTakeTreatIBSPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6608", site.activeProtocols)
                .back();
        abdominalPainOverPastPageOLS
                .waitForPageLoad()
                .clickOnAnswers("The pain got better after having a bowel movement")
                .clickNextButton(currentlyTakeTreatIBSPageOLS);

        CeliacDiseasePageOLS celiacDiseasePageOLS = currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Neomycin")
                .clickNextButton(new CeliacDiseasePageOLS());
        celiacDiseasePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back();
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Viberzi (eluxadoline)")
                .clickNextButton(celiacDiseasePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back();
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xifaxan (rifaximin)")
                .clickNextButton(celiacDiseasePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6609", site.activeProtocols)
                .back();
        currentlyTakeTreatIBSPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(celiacDiseasePageOLS);

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = celiacDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WeightLossSurgeryPageOLS());
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6610", site.activeProtocols)
                .back();
        celiacDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(weightLossSurgeryPageOLS);

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        HaveYouEverHadAnyOfFollowingTypesSurgeryPageOLS haveYouEverHadAnyOfFollowingTypesSurgeryPageOLS =
                new HaveYouEverHadAnyOfFollowingTypesSurgeryPageOLS();
        List<String> disqualifyQ12 = Arrays.asList("Less than 3 months ago", "3 - 6 months ago", "7 - 11 months ago",
                "1 - 2 years ago", "More than 2 years ago");
        for (String answer: disqualifyQ12) {
            System.out.println("Select answer for Q12: " + answer);
            procedureForWeightLossPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(haveYouEverHadAnyOfFollowingTypesSurgeryPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6612", site.activeProtocols)
                    .back();
        }
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverHadAnyOfFollowingTypesSurgeryPageOLS);

        WhenDidYouHaveAppendixRemoved_OLS whenDidYouHaveAppendixRemoved_OLS =
                haveYouEverHadAnyOfFollowingTypesSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Appendix removed - Appendectomy",
                        "Gallbladder removed - Cholecystectomy",
                        "Biopsy – removal of a small piece of tissue for analysis",
                        "Tonsils removed - Tonsillectomy",
                        "Hemorrhoids removed - Hemorrhoidectomy",
                        "Other surgery on my stomach, intestines, colon, or esophagus")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Appendix removed - Appendectomy",
                        "Gallbladder removed - Cholecystectomy",
                        "Hemorrhoids removed - Hemorrhoidectomy",
                        "Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(new WhenDidYouHaveAppendixRemoved_OLS());

        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_OLS.titleExpected2)
                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_OLS.titleExpected3)
                .waitForPageLoad(4, whenDidYouHaveAppendixRemoved_OLS.titleExpected4)
                .back(haveYouEverHadAnyOfFollowingTypesSurgeryPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                                "Kidney disease",
                                "Heart or circulation problems (heart attack, heart failure, stroke)",
                                "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                                "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                                "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                                "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                .back();
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Ulcerative colitis")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                .back();
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
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
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
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
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
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
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
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
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS =
                whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
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

        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS =
                whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
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

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
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

        ExperienceExcessiveHungerOrIncreasedAppetiteOLS experienceExcessiveHungerOrIncreasedAppetiteOLS =
                approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "270")
                .clickNextButton(new ExperienceExcessiveHungerOrIncreasedAppetiteOLS());
        experienceExcessiveHungerOrIncreasedAppetiteOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "260")
                .clickNextButton(new IdentificationPageOLS());
        identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .clickOnAnswer("No")
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
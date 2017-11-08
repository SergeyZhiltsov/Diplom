package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Crohns_3485_OLS extends BaseTest{

    @Test
    @TestCaseId("00005")
    @Description("Crohn's_3485")
    public void tc005Test() {
        String phoneNumberLBP = "AUTAMS1CRN";
        String protocol1 = "APD371_004";
        String protocol2 = "RF_I6T_MC_AMAG";
        String protocol3 = "I6T_MC_AMAG";
        List<String> protocols = Arrays.asList(protocol1,protocol2,protocol3);
        String studyName = "Crohn's";
        String siteName = "AUT_CRN_3638C_Site";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleCrohns_3485_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DiagnosedWithCrohnsPageOLS diagnosedWithCrohnsPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageOLS());

        diagnosedWithCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedWithCrohnsPageOLS.getTitleText(),diagnosedWithCrohnsPageOLS.titleExpected, "Title is diff");
        FollowingMedicalConditionsPageOLS followingMedicalConditionsPageOLS = diagnosedWithCrohnsPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new FollowingMedicalConditionsPageOLS());
        followingMedicalConditionsPageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(diagnosedWithCrohnsPageOLS.titleExpected, protocol1, protocol2, protocol3);
        debugPageOLS.back();
        diagnosedWithCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(followingMedicalConditionsPageOLS);

        followingMedicalConditionsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingMedicalConditionsPageOLS.getTitleText(), followingMedicalConditionsPageOLS.titleExpected, "Title is diff");
        WhenDiagnosedCrohnsPageOLS whenDiagnosedCrohnsPageOLS = followingMedicalConditionsPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhenDiagnosedCrohnsPageOLS());

        whenDiagnosedCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whenDiagnosedCrohnsPageOLS.getTitleText(), whenDiagnosedCrohnsPageOLS.titleExpected, "Title is diff");
        TypeOfDoctorPageOLS typeOfDoctorPageOLS = whenDiagnosedCrohnsPageOLS
                .clickOnAnswer("Not officially diagnosed with Crohn’s by a doctor")
                .clickNextButton(new TypeOfDoctorPageOLS());
        typeOfDoctorPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Next, please tell me, when were you diagnosed with Crohn’s disease by a doctor at a hospital or doct", protocol1, protocol2, protocol3)
                .back();
        whenDiagnosedCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 or more years ago")
                .clickNextButton(typeOfDoctorPageOLS);

        typeOfDoctorPageOLS
                .waitForPageLoad();
        Assert.assertEquals(typeOfDoctorPageOLS.getTitleText(), typeOfDoctorPageOLS.titleExpected, "Title is diff");
        TypeOfTestsPageOLS typeOfTestsPageOLS = typeOfDoctorPageOLS
                .clickOnAnswers("I do not see a doctor regularly")
                .clickNextButton(new TypeOfTestsPageOLS());
        typeOfTestsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(typeOfDoctorPageOLS.titleExpected, protocol2, protocol3)
                .back();
        typeOfDoctorPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(typeOfTestsPageOLS);

        typeOfTestsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(typeOfTestsPageOLS.getTitleText(), typeOfTestsPageOLS.titleExpected, "Title is diff");
        ManageYourCrohnsPageOLS manageYourCrohnsPageOLS = typeOfTestsPageOLS
                .clickOnAnswers("Blood test","CT","MRI","XRay")
                .clickNextButton(new ManageYourCrohnsPageOLS());
        manageYourCrohnsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Next, please tell me which of the following types of tests/procedures have you ever had to diagnose ", protocol1)
                .back();
        typeOfTestsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Colonoscopy")
                .clickNextButton(manageYourCrohnsPageOLS);

        manageYourCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(manageYourCrohnsPageOLS.getTitleText(), manageYourCrohnsPageOLS.titleExpected, "Title is diff");
        OnA0To10ScalePageOLS onA0To10ScalePageOLS = manageYourCrohnsPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new OnA0To10ScalePageOLS());
        onA0To10ScalePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(manageYourCrohnsPageOLS.titleExpected, protocol2,protocol3)
                .back();
        SteroidMedicationsPageOLS steroidMedicationsPageOLS = manageYourCrohnsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsPageOLS());

        steroidMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(steroidMedicationsPageOLS.getTitleText(), steroidMedicationsPageOLS.titleExpected, "Title is diff");
        FollowingMedicationsCrohnsPageOLS followingMedicationsCrohnsPageOLS = steroidMedicationsPageOLS
                .clickOnAnswers("I have never treated my Crohn’s with steroids")
                .clickNextButton(new FollowingMedicationsCrohnsPageOLS());

        followingMedicationsCrohnsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingMedicationsCrohnsPageOLS.getTitleText(), followingMedicationsCrohnsPageOLS.titleExpected, "Title is diff");
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = followingMedicationsCrohnsPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageOLS());

        biologicMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(biologicMedicationsPageOLS.getTitleText(), biologicMedicationsPageOLS.titleExpected, "Title is diff");
        biologicMedicationsPageOLS
                .clickOnAnswers("Cosentyx","Prolia or Xgeva")
                .clickNextButton(onA0To10ScalePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Treatment History Requirements Logic", protocol2,protocol3)
                .back();
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(onA0To10ScalePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Treatment History Requirements Logic", protocol2,protocol3)
                .back();
        SubquestionLastReceivedPageOLS subquestionLastReceivedPageOLS = biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stelara")
                .clickNextButton(new SubquestionLastReceivedPageOLS());
        subquestionLastReceivedPageOLS
                .waitForPageLoad(1, subquestionLastReceivedPageOLS.titleExpected13)
                .getPage(debugPageOLS)
                .checkProtocolsEquals(biologicMedicationsPageOLS.titleExpected, protocol2,protocol3)
                .back();
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Actemra",
                        "Benlysta",
                        "Cimzia",
                        "Enbrel",
                        "Entyvio",
                        "Humira",
                        "Kineret",
                        "Orencia",
                        "Raptiva",
                        "Remicade",
                        "Rituxan",
                        "Simponi",
                        "Stelara",
                        "Taltz",
                        "Tysabri")
                .clickNextButton(subquestionLastReceivedPageOLS);

        subquestionLastReceivedPageOLS
                .waitForPageLoad(1,subquestionLastReceivedPageOLS.titleExpected1);
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(1),subquestionLastReceivedPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(2),subquestionLastReceivedPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(3),subquestionLastReceivedPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(4),subquestionLastReceivedPageOLS.titleExpected4, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(5),subquestionLastReceivedPageOLS.titleExpected5, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(6),subquestionLastReceivedPageOLS.titleExpected6, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(7),subquestionLastReceivedPageOLS.titleExpected7, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(8),subquestionLastReceivedPageOLS.titleExpected8, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(9),subquestionLastReceivedPageOLS.titleExpected9, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(10),subquestionLastReceivedPageOLS.titleExpected10, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(11),subquestionLastReceivedPageOLS.titleExpected11, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(12),subquestionLastReceivedPageOLS.titleExpected12, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(13),subquestionLastReceivedPageOLS.titleExpected14, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageOLS.getTitleText(14),subquestionLastReceivedPageOLS.titleExpected15, "Title is diff");
        subquestionLastReceivedPageOLS
                .back();

        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Entyvio")
                .clickNextButton(subquestionLastReceivedPageOLS);

        subquestionLastReceivedPageOLS
                .waitForPageLoad(1,subquestionLastReceivedPageOLS.titleExpected5)
                .clickOnAnswerForSubQuestion("Which of the following best describes when you last received Entyvio? You….","Last received 1 year ago or more")
                .clickNextButton(onA0To10ScalePageOLS);

        onA0To10ScalePageOLS
                .waitForPageLoad();
        Assert.assertEquals(onA0To10ScalePageOLS.getTitleText(), onA0To10ScalePageOLS.titleExpected, "Title is diff");
        StatementsBestDescribesPageOLS statementsBestDescribesPageOLS = onA0To10ScalePageOLS
                .setRating("03")
                .clickNextButton(new StatementsBestDescribesPageOLS());
        statementsBestDescribesPageOLS
                .waitForPageLoad()
                .back();
        YouIndicatedThatPageOLS youIndicatedThatPageOLS = onA0To10ScalePageOLS
                .waitForPageLoad()
                .setRating("00")
                .clickNextButton(new YouIndicatedThatPageOLS());
        youIndicatedThatPageOLS
                .waitForPageLoad(youIndicatedThatPageOLS.titleExpected1)
                .clickOnAnswer("Yes - I am in remission")
                .clickNextButton(statementsBestDescribesPageOLS);
        HowManyLiquidPageOLS howManyLiquidPageOLS = statementsBestDescribesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn’s")
                .clickNextButton(new HowManyLiquidPageOLS());
        howManyLiquidPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(statementsBestDescribesPageOLS.titleExpected, protocol2,protocol3)
                .back();
        statementsBestDescribesPageOLS
                .waitForPageLoad()
                .back();
        youIndicatedThatPageOLS
                .waitForPageLoad(youIndicatedThatPageOLS.titleExpected1)
                .back();

        onA0To10ScalePageOLS
                .waitForPageLoad()
                .setRating("01")
                .clickNextButton(youIndicatedThatPageOLS)
                .waitForPageLoad(youIndicatedThatPageOLS.titleExpected2)
                .clickOnAnswer("Yes - I am in remission")
                .clickNextButton(statementsBestDescribesPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn’s")
                .clickNextButton(howManyLiquidPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(statementsBestDescribesPageOLS.titleExpected, protocol2,protocol3)
                .back();
        statementsBestDescribesPageOLS
                .waitForPageLoad()
                .back();
        youIndicatedThatPageOLS
                .waitForPageLoad(youIndicatedThatPageOLS.titleExpected2)
                .back();

        onA0To10ScalePageOLS
                .waitForPageLoad()
                .setRating("02")
                .clickNextButton(youIndicatedThatPageOLS)
                .waitForPageLoad(youIndicatedThatPageOLS.titleExpected3)
                .clickOnAnswer("Yes - I am in remission")
                .clickNextButton(statementsBestDescribesPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn’s")
                .clickNextButton(howManyLiquidPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(statementsBestDescribesPageOLS.titleExpected, protocol2,protocol3)
                .back();
        statementsBestDescribesPageOLS
                .waitForPageLoad()
                .back();

        youIndicatedThatPageOLS
                .waitForPageLoad(youIndicatedThatPageOLS.titleExpected3)
                .clickOnAnswer("No - Even though I gave my symptoms a low rating, I am NOT in remission")
                .clickNextButton(statementsBestDescribesPageOLS)
                .waitForPageLoad()
                .clickNextButton(howManyLiquidPageOLS);

        StoolAndIndicatePageOLS stoolAndIndicatePageOLS = howManyLiquidPageOLS
                .waitForPageLoad()
                .setDayRating("03")
                .setHoursRating("03")
                .clickNextButton(new StoolAndIndicatePageOLS());

        stoolAndIndicatePageOLS
                .waitForPageLoad();
        Assert.assertEquals(stoolAndIndicatePageOLS.getTitleText(), stoolAndIndicatePageOLS.titleExpected, "Title is diff");
        LevelOfPainPageOLS levelOfPainPageOLS = stoolAndIndicatePageOLS
                .clickOnAnswer("Type 1")
                .clickNextButton(new LevelOfPainPageOLS());

        FollowingImagesMostPageOLS followingImagesMostPageOLS = levelOfPainPageOLS
                .waitForPageLoad()
                .setRating("04")
                .clickNextButton(new FollowingImagesMostPageOLS());
        YouExperienceAbdominalPageOLS youExperienceAbdominalPageOLS = followingImagesMostPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1")
                .clickNextButton(new YouExperienceAbdominalPageOLS());
        WhenItOccursPageOLS whenItOccursPageOLS = youExperienceAbdominalPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - Never")
                .clickNextButton(new WhenItOccursPageOLS());
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = whenItOccursPageOLS
                .waitForPageLoad()
                .setRating("01")
                .clickNextButton(new WeightLossSurgeryPageOLS());
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol2)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Qualifying Logic", protocol2,protocol3)
                .back();
        whenItOccursPageOLS
                .waitForPageLoad()
                .back();
        youExperienceAbdominalPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2 - Rarely")
                .clickNextButton(whenItOccursPageOLS);
        AverageWeekPageOLS averageWeekPageOLS = whenItOccursPageOLS
                .waitForPageLoad()
                .clickNextButton(new AverageWeekPageOLS());
        YourNormalBaselinePageOLS yourNormalBaselinePageOLS = averageWeekPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Only 1 day or less")
                .clickNextButton(new YourNormalBaselinePageOLS());
        yourNormalBaselinePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Much less severe")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol2)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Qualifying Logic", protocol2,protocol3)
                .back();

        yourNormalBaselinePageOLS
                .waitForPageLoad()
                .back();
        averageWeekPageOLS
                .waitForPageLoad()
                .back();
        whenItOccursPageOLS
                .waitForPageLoad()
                .back();
        youExperienceAbdominalPageOLS
                .waitForPageLoad()
                .back();
        followingImagesMostPageOLS
                .waitForPageLoad()
                .back();
        levelOfPainPageOLS
                .waitForPageLoad()
                .back();
        stoolAndIndicatePageOLS
                .waitForPageLoad()
                .back();
        howManyLiquidPageOLS
                .waitForPageLoad()
                .back();

        statementsBestDescribesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am currently in a flare with my Crohn’s")
                .clickNextButton(howManyLiquidPageOLS)
                .waitForPageLoad()
                .setHoursRating("04")
                .clickNextButton(stoolAndIndicatePageOLS)
                .waitForPageLoad()
                .clickNextButton(levelOfPainPageOLS)
                .waitForPageLoad()
                .setRating("01")
                .clickNextButton(youExperienceAbdominalPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 - Sometimes")
                .clickNextButton(whenItOccursPageOLS)
                .waitForPageLoad()
                .clickNextButton(averageWeekPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days")
                .clickNextButton(yourNormalBaselinePageOLS)
                .waitForPageLoad()
                .clickOnAnswer("About the same")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Non-Flare Logic - \"I6T-MC-AMAG\"", protocol3)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol1)
                .back();

        yourNormalBaselinePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less severe")
                .clickNextButton(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol2)
                .getPage(weightLossSurgeryPageOLS);

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());
        HaveAnyOfTheFollowingPageOLS haveAnyOfTheFollowingPageOLS = procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new HaveAnyOfTheFollowingPageOLS());
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol2,protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(haveAnyOfTheFollowingPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol2,protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(haveAnyOfTheFollowingPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol2,protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(haveAnyOfTheFollowingPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol2,protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(haveAnyOfTheFollowingPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol2,protocol3)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back();
        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveAnyOfTheFollowingPageOLS);

        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Colostomy and/or Colectomy","Ileostomy","Another type of stomach or colon surgery")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        hasHealthcareProfessionalPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS3759",protocol1,protocol2,protocol3)
                .back();
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Colostomy and/or Colectomy","Ileostomy")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS3759", protocol2,protocol3)
                .back();
        haveAnyOfTheFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(hasHealthcareProfessionalPageOLS);

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CongestiveHeartFailurePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SkinConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ViralConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new MentalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WomensHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SmokedCigarettesPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new ChildrenUnderPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new WhatSortPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above (no coverage at all)")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new HSCrohnsPageOLS())
                .waitForPageLoad()
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()
                .getPage(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();



    }
}

package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.*;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Crohns_3889_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00012")
    @Description("Crohn's 3889 for CC with HS")
    public void crohns3889ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1CRN";
        String protocol1 = "I6T_MC_AMAG";
        String protocol2 = "M15_991";
        String protocol3 = "M16_006";
        String protocol4 = "RF_I6T_MC_AMAG";
        List<String> protocols = Arrays.asList(protocol1,protocol2,protocol3,protocol4);
        String studyName = "Crohn's disease";
        String siteName = "AUT_CRN_3889_HS";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedCrohns_3485, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());

        diagnosedWithCrohnsPageCC
                .waitForPageLoad();
        Assert.assertEquals(diagnosedWithCrohnsPageCC.getTitleText(),diagnosedWithCrohnsPageCC.titleExpected, "Title is diff");
        FollowingMedicalConditionsPageCC followingMedicalConditionsPageCC = diagnosedWithCrohnsPageCC
                .clickOnAnswer("No")
                .clickNextButton(new FollowingMedicalConditionsPageCC());
        followingMedicalConditionsPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals(diagnosedWithCrohnsPageCC.titleExpected, protocol1, protocol2, protocol3,protocol4);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(followingMedicalConditionsPageCC);

        followingMedicalConditionsPageCC
                .waitForPageLoad();
        Assert.assertEquals(followingMedicalConditionsPageCC.getTitleText(), followingMedicalConditionsPageCC.titleExpected, "Title is diff");
        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = followingMedicalConditionsPageCC
                .clickOnAnswers("None of the above Agent Note: DO NOT READ")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());

        whenDiagnosedCrohnsPageCC
                .waitForPageLoad();
        Assert.assertEquals(whenDiagnosedCrohnsPageCC.getTitleText(), whenDiagnosedCrohnsPageCC.titleExpected, "Title is diff");
        TypeOfDoctorPageCC typeOfDoctorPageCC = whenDiagnosedCrohnsPageCC
                .clickOnAnswer("Not officially diagnosed with Crohn’s by a doctor")
                .clickNextButton(new TypeOfDoctorPageCC());
        typeOfDoctorPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Next, please tell me, when were you diagnosed with Crohn’s disease by a doctor at a hospital or doct", protocol1, protocol2, protocol3,protocol4)
                .back();
        whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 or more years ago")
                .clickNextButton(typeOfDoctorPageCC);

        typeOfDoctorPageCC
                .waitForPageLoad();
        Assert.assertEquals(typeOfDoctorPageCC.getTitleText(), typeOfDoctorPageCC.titleExpected, "Title is diff");
        TypeOfTestsPageCC typeOfTestsPageCC = typeOfDoctorPageCC
                .clickOnAnswers("I do not see a doctor regularly")
                .clickNextButton(new TypeOfTestsPageCC());
        typeOfTestsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(typeOfDoctorPageCC.titleExpected, protocol1, protocol4)
                .back();
        typeOfDoctorPageCC
                .waitForPageLoad()
                .clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(typeOfTestsPageCC);

        typeOfTestsPageCC
                .waitForPageLoad();
        Assert.assertEquals(typeOfTestsPageCC.getTitleText(), typeOfTestsPageCC.titleExpected, "Title is diff");
        ManageYourCrohnsPageCC manageYourCrohnsPageCC = typeOfTestsPageCC
                .clickOnAnswers("Blood test","CT","MRI","XRay")
                .clickNextButton(new ManageYourCrohnsPageCC());
        manageYourCrohnsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Next, please tell me which of the following types of tests/procedures have you ever had to diagnose ", protocol2,protocol3)
                .back();
        typeOfTestsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Colonoscopy")
                .clickNextButton(manageYourCrohnsPageCC);

        manageYourCrohnsPageCC
                .waitForPageLoad();
        Assert.assertEquals(manageYourCrohnsPageCC.getTitleText(), manageYourCrohnsPageCC.titleExpected, "Title is diff");
        OnA0To10ScalePageCC onA0To10ScalePageCC = manageYourCrohnsPageCC
                .clickOnAnswer("No")
                .clickNextButton(new OnA0To10ScalePageCC());
        onA0To10ScalePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(manageYourCrohnsPageCC.titleExpected, protocol1, protocol2,protocol3,protocol4)
                .back();
        SteroidMedicationsPageCC steroidMedicationsPageCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsPageCC());

        steroidMedicationsPageCC
                .waitForPageLoad();
        Assert.assertEquals(steroidMedicationsPageCC.getTitleText(), steroidMedicationsPageCC.titleExpected, "Title is diff");
        FollowingMedicationsCrohnsPageCC followingMedicationsCrohnsPageCC = steroidMedicationsPageCC
                .clickOnAnswers("I have never treated my Crohn’s with steroids")
                .clickNextButton(new FollowingMedicationsCrohnsPageCC());

        followingMedicationsCrohnsPageCC
                .waitForPageLoad();
        Assert.assertEquals(followingMedicationsCrohnsPageCC.getTitleText(), followingMedicationsCrohnsPageCC.titleExpected, "Title is diff");
        BiologicMedicationsPageCC biologicMedicationsPageCC = followingMedicationsCrohnsPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsPageCC());

        biologicMedicationsPageCC
                .waitForPageLoad();
        Assert.assertEquals(biologicMedicationsPageCC.getTitleText(), biologicMedicationsPageCC.titleExpected, "Title is diff");
        biologicMedicationsPageCC
                .clickOnAnswers("Cosentyx","Prolia or Xgeva")
                .clickNextButton(onA0To10ScalePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Treatment History Requirements Logic", protocol1, protocol2,protocol3,protocol4)
                .back();
        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(onA0To10ScalePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Treatment History Requirements Logic", protocol1, protocol2,protocol3,protocol4)
                .back();
        SubquestionLastReceivedPageCC subquestionLastReceivedPageCC = biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stelara")
                .clickNextButton(new SubquestionLastReceivedPageCC());
        subquestionLastReceivedPageCC
                .waitForPageLoad(1, subquestionLastReceivedPageCC.titleExpected13)
                .getPage(debugPageCC)
                .checkProtocolsEquals(biologicMedicationsPageCC.titleExpected, protocol1, protocol2,protocol3,protocol4)
                .back();
        biologicMedicationsPageCC
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
                .clickNextButton(subquestionLastReceivedPageCC);

        subquestionLastReceivedPageCC
                .waitForPageLoad(1,subquestionLastReceivedPageCC.titleExpected1);
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(1),subquestionLastReceivedPageCC.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(2),subquestionLastReceivedPageCC.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(3),subquestionLastReceivedPageCC.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(4),subquestionLastReceivedPageCC.titleExpected4, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(5),subquestionLastReceivedPageCC.titleExpected5, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(6),subquestionLastReceivedPageCC.titleExpected6, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(7),subquestionLastReceivedPageCC.titleExpected7, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(8),subquestionLastReceivedPageCC.titleExpected8, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(9),subquestionLastReceivedPageCC.titleExpected9, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(10),subquestionLastReceivedPageCC.titleExpected10, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(11),subquestionLastReceivedPageCC.titleExpected11, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(12),subquestionLastReceivedPageCC.titleExpected12, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(13),subquestionLastReceivedPageCC.titleExpected14, "Title is diff");
        Assert.assertEquals(subquestionLastReceivedPageCC.getTitleText(14),subquestionLastReceivedPageCC.titleExpected15, "Title is diff");
        subquestionLastReceivedPageCC
                .back();

        biologicMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Entyvio")
                .clickNextButton(subquestionLastReceivedPageCC);

        subquestionLastReceivedPageCC
                .waitForPageLoad(1,subquestionLastReceivedPageCC.titleExpected5)
                .clickOnAnswerForSubQuestion("Which of the following best describes when you last received Entyvio? You….","Last received 1 year ago or more")
                .clickNextButton(onA0To10ScalePageCC);

        onA0To10ScalePageCC
                .waitForPageLoad();
        Assert.assertEquals(onA0To10ScalePageCC.getTitleText(), onA0To10ScalePageCC.titleExpected, "Title is diff");
        StatementsBestDescribesPageCC statementsBestDescribesPageCC = onA0To10ScalePageCC
                .setRating("03")
                .clickNextButton(new StatementsBestDescribesPageCC());
        statementsBestDescribesPageCC
                .waitForPageLoad()
                .back();
        YouIndicatedThatPageCC youIndicatedThatPageCC = onA0To10ScalePageCC
                .waitForPageLoad()
                .setRating("00")
                .clickNextButton(new YouIndicatedThatPageCC());
        youIndicatedThatPageCC
                .waitForPageLoad(youIndicatedThatPageCC.titleExpected1)
                .clickOnAnswer("Yes - I am in remission")
                .clickNextButton(statementsBestDescribesPageCC);
        HowManyLiquidPageCC howManyLiquidPageCC = statementsBestDescribesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn’s")
                .clickNextButton(new HowManyLiquidPageCC());
        howManyLiquidPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(statementsBestDescribesPageCC.titleExpected, protocol1,protocol4)
                .back();
        statementsBestDescribesPageCC
                .waitForPageLoad()
                .back();
        youIndicatedThatPageCC
                .waitForPageLoad(youIndicatedThatPageCC.titleExpected1)
                .back();

        onA0To10ScalePageCC
                .waitForPageLoad()
                .setRating("01")
                .clickNextButton(youIndicatedThatPageCC)
                .waitForPageLoad(youIndicatedThatPageCC.titleExpected2)
                .clickOnAnswer("Yes - I am in remission")
                .clickNextButton(statementsBestDescribesPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn’s")
                .clickNextButton(howManyLiquidPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(statementsBestDescribesPageCC.titleExpected, protocol1,protocol4)
                .back();
        statementsBestDescribesPageCC
                .waitForPageLoad()
                .back();
        youIndicatedThatPageCC
                .waitForPageLoad(youIndicatedThatPageCC.titleExpected2)
                .back();

        onA0To10ScalePageCC
                .waitForPageLoad()
                .setRating("02")
                .clickNextButton(youIndicatedThatPageCC)
                .waitForPageLoad(youIndicatedThatPageCC.titleExpected3)
                .clickOnAnswer("Yes - I am in remission")
                .clickNextButton(statementsBestDescribesPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn’s")
                .clickNextButton(howManyLiquidPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(statementsBestDescribesPageCC.titleExpected, protocol1,protocol4)
                .back();
        statementsBestDescribesPageCC
                .waitForPageLoad()
                .back();

        youIndicatedThatPageCC
                .waitForPageLoad(youIndicatedThatPageCC.titleExpected3)
                .clickOnAnswer("No - Even though I gave my symptoms a low rating, I am NOT in remission")
                .clickNextButton(statementsBestDescribesPageCC)
                .waitForPageLoad()
                .clickNextButton(howManyLiquidPageCC);

        LevelOfPainPageCC levelOfPainPageCC = howManyLiquidPageCC
                .waitForPageLoad()
                .setDayRating("03")
                .setHoursRating("03")
                .clickNextButton(new LevelOfPainPageCC());

        YouExperienceAbdominalPageCC youExperienceAbdominalPageCC = levelOfPainPageCC
                .waitForPageLoad()
                .setRating("04")
                .clickNextButton(new YouExperienceAbdominalPageCC());
        WhenItOccursPageCC whenItOccursPageCC = youExperienceAbdominalPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - Never")
                .clickNextButton(new WhenItOccursPageCC());
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = whenItOccursPageCC
                .waitForPageLoad()
                .setRating("01")
                .clickNextButton(new WeightLossSurgeryPageCC());
        weightLossSurgeryPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
//                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol2)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Qualifying Logic", protocol1,protocol4)
                .back();
        whenItOccursPageCC
                .waitForPageLoad()
                .back();
        youExperienceAbdominalPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 - Rarely")
                .clickNextButton(whenItOccursPageCC);
        AverageWeekPageCC averageWeekPageCC = whenItOccursPageCC
                .waitForPageLoad()
                .clickNextButton(new AverageWeekPageCC());
        YourNormalBaselinePageCC yourNormalBaselinePageCC = averageWeekPageCC
                .waitForPageLoad()
                .clickOnAnswer("Only 1 day or less")
                .clickNextButton(new YourNormalBaselinePageCC());
        yourNormalBaselinePageCC
                .waitForPageLoad()
                .clickOnAnswer("Much less severe")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
//                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol2)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Qualifying Logic", protocol1,protocol4)
                .back();
        yourNormalBaselinePageCC//rel 48
                .waitForPageLoad()
                .clickOnAnswer("More severe")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol4)
                .back();

        yourNormalBaselinePageCC
                .waitForPageLoad()
                .back();
        averageWeekPageCC
                .waitForPageLoad()
                .back();
        whenItOccursPageCC
                .waitForPageLoad()
                .back();
        youExperienceAbdominalPageCC
                .waitForPageLoad()
                .back();
        levelOfPainPageCC
                .waitForPageLoad()
                .back();
        howManyLiquidPageCC
                .waitForPageLoad()
                .back();

        statementsBestDescribesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am currently in a flare with my Crohn’s")
                .clickNextButton(howManyLiquidPageCC)
                .waitForPageLoad()
                .setHoursRating("04")
                .clickNextButton(levelOfPainPageCC)
                .waitForPageLoad()
                .setRating("01")
                .clickNextButton(youExperienceAbdominalPageCC)
                .waitForPageLoad()
                .clickOnAnswer("3 - Sometimes")
                .clickNextButton(whenItOccursPageCC)
                .waitForPageLoad()
                .clickNextButton(averageWeekPageCC)
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days")
                .clickNextButton(yourNormalBaselinePageCC)
                .waitForPageLoad()
                .clickOnAnswer("About the same")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Non-Flare Logic - \"I6T-MC-AMAG\"", protocol1)
//                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol1)
                .back();

        yourNormalBaselinePageCC
                .waitForPageLoad()
                .clickOnAnswer("Less severe")
                .clickNextButton(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Crohn's_3485 Flare Requirements Logic - \"RF_I6T-MC-AMAG\"", protocol4)
                .getPage(weightLossSurgeryPageCC);

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());
        HaveAnyOfTheFollowingPageCC haveAnyOfTheFollowingPageCC = procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new HaveAnyOfTheFollowingPageCC());
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1,protocol4)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(haveAnyOfTheFollowingPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1,protocol4)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(haveAnyOfTheFollowingPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1,protocol4)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(haveAnyOfTheFollowingPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1,protocol4)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(haveAnyOfTheFollowingPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1,protocol4)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .back();
        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveAnyOfTheFollowingPageCC);

        TransitionStatementCC transitionStatementCC = haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Colostomy and/or Colectomy","Ileostomy","Another type of stomach or colon surgery")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithCurves(studyName)
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0012938-QS3759-STUDYQUES",protocol1,protocol2,protocol3,protocol4)
                .back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("Colostomy and/or Colectomy","Ileostomy")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithCurves(studyName)
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0012938-QS3759-STUDYQUES", protocol1,protocol2,protocol3,protocol4)
                .back();
        haveAnyOfTheFollowingPageCC// rel 48
                .waitForPageLoad()
                .clickOnAnswers("Another type of stomach or colon surgery", "Feeding tube", "IV (parenteral) nutrition")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithCurves(studyName)
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0012938-QS3759-STUDYQUES", protocol2,protocol3)
                .back();
        haveAnyOfTheFollowingPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        transitionStatementCC
                .waitForPageLoadWithCurves(studyName);
        Assert.assertEquals(transitionStatementCC.getTitleText(), transitionStatementCC.getTitleExpectedWithCurves(studyName), "Title is diff");
        HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = transitionStatementCC
                .clickNextButton(new HasHealthcareProfessionalPageCC());

        hasHealthcareProfessionalPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouUndergoneAnyPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartFailureIsAlsoPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditions())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingDigestiveConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingSkinConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingViralConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingMentalHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingWomensHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SmokedCigarettesPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                //----------PEDIATRIC HEALTH Questions----------
                .clickNextButton(new HouseholdHavePageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                //.clickNextButton(new TheStudySitePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Public transportation")
                //.clickNextButton(new WhatMedicalCoveragePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("No, I have no coverage")
                //.clickNextButton(new EthnicBackgroundPageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Prefer not to answer")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a Crohn's study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSCrohns2PageCC())
                .waitForPageLoad()
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

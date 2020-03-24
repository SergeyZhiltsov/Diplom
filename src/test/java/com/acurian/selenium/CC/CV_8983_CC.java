package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.HowLongAgoDiagnosedDiabetesPageCC;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartRelatedSurgeriesProceduresPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CV_8983_CC extends BaseTest {



    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_CV_8983}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("CV 4450 CC")
    public void cv8983ccTest(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String studyName = "a heart health study";

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
                .waitForPageLoad2(studyName, "750");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
//                ("Cardiovascular Disease", "750"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC = new CholesterolTriglyceridesLipidsPageCC();

        //DQ if <18, DQ if >81, DQ if Male <50, DQ if Female <55
        genderPageCC
                .waitForPageLoad()
                .setDay("01")
                .setMonth("01")
                .setYear("1940")
                .clickOnAnswer("Female")
                .clickNextButton(cholesterolTriglyceridesLipidsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1966")
                .clickNextButton(cholesterolTriglyceridesLipidsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1971")
                .clickOnAnswer("Male")
                .clickNextButton(cholesterolTriglyceridesLipidsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1960")
                .clickNextButton(cholesterolTriglyceridesLipidsPageCC);

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = cholesterolTriglyceridesLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6744", site.activeProtocols)
                .back(cholesterolTriglyceridesLipidsPageCC);

        TakingFollowingStaticMedicationCC takingFollowingStaticMedicationCC = cholesterolTriglyceridesLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakingFollowingStaticMedicationCC());

        takingFollowingStaticMedicationCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(diagnosedAnyTypeOfDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6732", site.activeProtocols)
                .back(takingFollowingStaticMedicationCC)
                .waitForPageLoad()
                .clickOnAnswers("Atorvastatin")
                .clickNextButton(diagnosedAnyTypeOfDiabetesPageCC);

        SufferedFollowingHeartRelatedConditionsPageCC sufferedFollowingHeartRelatedConditionsPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageCC());

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());

        AdditionalHeartRelatedConditionsPageCC additionalHeartRelatedConditionsPageCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AdditionalHeartRelatedConditionsPageCC());

        ApproximateHeightPageCC approximateHeightPageCC = additionalHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        //move back to Q4
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .back(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .back(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .back(diagnosedAnyTypeOfDiabetesPageCC);

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageCC);

        WithType1DiabetesPageCC withType1DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageCC());

        withType1DiabetesPageCC
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageCC);

        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Pre-diabetes")
                .clickNextButton(sufferedFollowingHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .back(whatKindOfDiabetesPageCC);

        HowLongAgoDiagnosedDiabetesPageCC howLongAgoDiagnosedDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HowLongAgoDiagnosedDiabetesPageCC());

        StatementsApplyToYouCC statementsApplyToYouCC = howLongAgoDiagnosedDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new StatementsApplyToYouCC());

        statementsApplyToYouCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(sufferedFollowingHeartRelatedConditionsPageCC);

        SubquestionHeartPageCC subquestionHeartPageCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionHeartPageCC());

        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6736")
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        MajorStrokeCausedPermanentLossFunctionsCC majorStrokeCausedPermanentLossFunctionsCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageCC)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickNextButton(new MajorStrokeCausedPermanentLossFunctionsCC());

        majorStrokeCausedPermanentLossFunctionsCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6749", site.activeProtocols)
                .back(majorStrokeCausedPermanentLossFunctionsCC)
                .waitForPageLoad()
                .back(subquestionHeartPageCC)
                .waitForPageLoad(2, subquestionHeartPageCC.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Stenosis (narrowing of the blood vessels or arteries)")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("7", "7", "500")
                .clickNextButton(new HealthcareDiagnosedConditionsPageCC());

        healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(healthcareDiagnosedConditionsPageCC);

        //TODO

    }
}

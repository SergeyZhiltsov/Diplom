package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.HowLongAgoDiagnosedDiabetesPageCC;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.HasDoctorEverDiagnosedYouMedicalCondCC;
import com.acurian.selenium.pages.CC.LOWT.HealthcareDiagnosedConditionsPageСС;
import com.acurian.selenium.pages.CC.closes.CurrentlyParticipatingInStudy;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.RequirePassDrugTest;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CV_8983_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(CV_8983_CC.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_CV_8983},
//                {Site.AUT_CV_8983S}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
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
                .setDay("1")
                .setMonth("Jan")
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

        TransitionStatementCC transitionStatementCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new TransitionStatementCC());

        //move back to Q4
        transitionStatementCC
                .waitForPageLoadDYS(studyName)
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
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
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
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageCC);

        HasDoctorEverDiagnosedYouMedicalCondCC hasDoctorEverDiagnosedYouMedicalCondCC = sufferedFollowingHeartRelatedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartRelatedConditionsPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Stenosis (narrowing of the blood vessels or arteries)")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("7", "7", "500")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCondCC());

        hasDoctorEverDiagnosedYouMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6743", site.activeProtocols)
                .back(approximateHeightPageCC);
        HealthcareDiagnosedConditionsPageСС healthcareDiagnosedConditionsPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new HealthcareDiagnosedConditionsPageСС());

        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant",
                "Schizophrenia");
        for (String answer : disqualifyQ18) {
            Log.info("Select answer for Q18: " + answer);
            healthcareDiagnosedConditionsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(hasDoctorEverDiagnosedYouMedicalCondCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back(healthcareDiagnosedConditionsPageCC);
        }

        IdentificationPageCC identificationPageCC = healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());

        siteSelectionPageCC
                .waitForPageLoad(studyName)
                .getPID();

        siteSelectionPageCC
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(selectActionPageCC);

        if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    //.assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }

    }
}

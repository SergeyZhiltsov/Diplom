package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.IBD.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.CV_5034_OLS_A_S;

import java.util.Arrays;
import java.util.List;

import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class CV_5034_CC_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "5034Sites", dataProviderClass = CV_5034_OLS_A_S.class)
    @Description("Diabetes_5034_Synexus for CC")
    public void CV_5034_CC_Test(Site site) {
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //-------Date of Birth Page--------
        dateOfBirthPageCC
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextVer3(), dateOfBirthPageCC.titleCVExpected, "Title is diff");

        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad2Ver()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageCC = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDay("1")
                .setMonth("Aug")
                .setYear("2005")//Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1992")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();
        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC =
                cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC());
        haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        TransitionalStatementLowtPageCC transitionalStatementLowtPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(new TransitionalStatementLowtPageCC());
        transitionalStatementLowtPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Chronic Kidney Disease")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC);

        haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(whatKindOfDiabetesPageCC);
        switch (site) {
            case AUT_CV_5034A_site:
                whatKindOfDiabetesPageCC
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("QS6735", site.activeProtocols)
                        .back();
                break;
            case AUT_CV_5034S_site:
                whatKindOfDiabetesPageCC
                        .waitForPageLoad()
                        .back();
                break;
        }

        haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                .clickNextButton(whatKindOfDiabetesPageCC);

        //-------Q5: What kind of diabetes do you have?----------
        List<String> disqualifyQ5 = Arrays.asList("Type 1 diabetes (sometimes called Juvenile diabetes)",
                "Gestational diabetes (diabetes only during pregnancy)", "High blood sugar only");
        for (String answer: disqualifyQ5) {
            System.out.println("Select answer for Q5: " + answer);
            whatKindOfDiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(transitionalStatementLowtPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                    .back();
        }
        MedicationsForYourDiabetesPageCC medicationsForYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());
        medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        //-------Q5: WithType2DiabetesPageCC------------
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(medicationsForYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6705", site.activeProtocols)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 to less than 5 years ago")
                .clickNextButton(medicationsForYourDiabetesPageCC);

        //-------Q6: Do you currently take any of the following specific medications for your diabetes?------------
        CholesterolTriglyceridesLipidsPageCC сholesterolTriglyceridesLipidsPageCC = medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Glyxambi (empagliflozin and linagliptin)",
                        "Januvia (sitagliptin)",
                        "Nesina (alogliptin)",
                        "Oseni (alogliptin and pioglitazone)",
                        "Onglyza (saxagliptin)",
                        "Tradjenta (linagliptin)",
                        "Bydureon or Byetta (exenatide)",
                        "Saxenda or Victoza (liraglutide)",
                        "Adlyxin (lixisenatide)",
                        "Tanzeum (albiglutide)",
                        "Trulicity (dulaglutide)",
                        "Ozempic (semaglutide)")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageCC());

        //-------New Q13: Ask Q13 (current non-statin use) even if did not report "High cholesterol or high triglycerides"------------
        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = сholesterolTriglyceridesLipidsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartOrBloodVesselPageCC());
        heartOrBloodVesselPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6734", site.activeProtocols)
                .back(сholesterolTriglyceridesLipidsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(heartOrBloodVesselPageCC);

        //-----Q14:  Have you experienced any of the following heart or blood vessel related events?
        CardiovascularInterventionsOrSurgeriesPageCC cardiovascularInterventionsOrSurgeriesPageCC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CardiovascularInterventionsOrSurgeriesPageCC());
        cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad()
                .back();
        AnginaOrChestPainPageCC anginaOrChestPainPageCC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital")
                .clickNextButton(new AnginaOrChestPainPageCC());
        anginaOrChestPainPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartOrBloodVesselPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        //---Q13: When was the last time that you experienced a heart attack? 
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC);

        //------Q15:  Have you experienced any of the following cardiovascular interventions or surgeries?
        HeartrelatedMedicalConditionsProceduresPageCC heartrelatedMedicalConditionsProceduresPageCC = cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .back(heartOrBloodVesselPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageCC());

        RelativesHeartAttackPageCC relativesHeartAttackPageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageCC());

        FirstHeartAttackPageCC firstHeartAttackPageCC = relativesHeartAttackPageCC
                .waitForPageLoad()
                .clickOnAnswers("Brother")
                .clickNextButton(new FirstHeartAttackPageCC());

        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = firstHeartAttackPageCC
                .waitForPageLoad()
                .setYears("30")
                .clickNextButton(new EverSmokedCigarettesPageCC());

        ApproximateHeightPageCC approximateHeightPageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageCC());

        ReceivedHeartProcedurePageCC receivedHeartProcedurePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .back(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .back(firstHeartAttackPageCC)
                .waitForPageLoad()
                .back(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .back(heartrelatedMedicalConditionsProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Procedure to clear plaque from blood vessels in the neck such as carotid endarterectomy")
                .clickNextButton(new ReceivedHeartProcedurePageCC());

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = receivedHeartProcedurePageCC
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6717", site.activeProtocols)
                .back(receivedHeartProcedurePageCC)
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(firstHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .clickNextButton(new HealthcareDiagnosedConditionsPageCC());

        List<String> options = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String entry: options) {
            System.out.println(entry);
            healthcareDiagnosedConditionsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry)
                    .clickNextButton(transitionalStatementLowtPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back();
        }
        IdentificationPageCC identificationPageCC = healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageCC());
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_CV_5034A_site: //1R
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose1PageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_CV_5034S_site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "08/01/1992", "US",
                                "Dover, DE", site.zipCode, "qa.acurian@gmail.com",
                                "999 -999-9999", "5034SAUT", "AUT_CV_5034S_site",
                                "KOWQUICAR302")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .getRadiantDbToLog(env)
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
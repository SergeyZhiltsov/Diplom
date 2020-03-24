package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.IBD.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.OLS.CV_4241_OLS;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class CV_4241_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "sites", dataProviderClass = CV_4241_OLS.class)
    @Description("CV_4241S_CC")
    public void cv4241cc(Site site) {
        final String phoneNumber = "AUTAMS1CV1";
        final String dquedStudyName = "a heart health study";
        final String matchedStudyName = "a study for diabetics";

        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:",
                "Title text is diff");
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

//        dateOfBirthPageCC
//                .waitForPageLoad();
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText2Ver(), dateOfBirthPageCC.titleCVExpected,
//                "Title is diff");

        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
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
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setMonth("Aug")
                .setDay("1")
                .setYear("2005")
                .clickNextButton(lessThan18YearsOldPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1980")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC =
                cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
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

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickOnAnswers("Chronic Kidney Disease")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        MedicationsForYourDiabetesPageCC medicationsForYourDiabetesPageCC = withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new MedicationsForYourDiabetesPageCC());

        List<String> disqualify = Arrays.asList("Glyxambi (empagliflozin and linagliptin)",
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
        "Ozempic (semaglutide)");

        CholesterolTriglyceridesLipidsPageCC cholesterolTriglyceridesLipidsPageCC =
                new CholesterolTriglyceridesLipidsPageCC();
        for (String answer: disqualify) {
            System.out.println("Select answer for Q7: " + answer);
            medicationsForYourDiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(cholesterolTriglyceridesLipidsPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6706", site.activeProtocols)
                    .back();
        }
        HeartOrBloodVesselPageCC heartOrBloodVesselPageCC = medicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(cholesterolTriglyceridesLipidsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartOrBloodVesselPageCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = heartOrBloodVesselPageCC
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        CardiovascularInterventionsOrSurgeriesPageCC cardiovascularInterventionsOrSurgeriesPageCC =
                subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .back(heartOrBloodVesselPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CardiovascularInterventionsOrSurgeriesPageCC());

        HeartrelatedMedicalConditionsProceduresPageCC heartrelatedMedicalConditionsProceduresPageCC =
                cardiovascularInterventionsOrSurgeriesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageCC());

        RelativesHeartAttackPageCC relativesHeartAttackPageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageCC());

        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = relativesHeartAttackPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of these relatives")
                .clickNextButton(new EverSmokedCigarettesPageCC());

        ApproximateHeightPageCC approximateHeightPageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new ApproximateHeightPageCC());

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "190")
                .clickNextButton(transitionalStatementLowtPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back();

        approximateHeightPageCC
                .waitForPageLoad()
                .back(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .back(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .back(heartrelatedMedicalConditionsProceduresPageCC)
                .waitForPageLoad()
                .back(cardiovascularInterventionsOrSurgeriesPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to " +
                        "open up blockages in the arteries in your heart)")
                .clickNextButton(heartrelatedMedicalConditionsProceduresPageCC);

        ReceivedHeartProcedurePageCC receivedHeartProcedurePageCC = heartrelatedMedicalConditionsProceduresPageCC
                .waitForPageLoad()
                .clickNextButton(new ReceivedHeartProcedurePageCC());
        receivedHeartProcedurePageCC
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(relativesHeartAttackPageCC)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageCC)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageCC);

        HealthcareDiagnosedConditionsPageCC healthcareDiagnosedConditionsPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .clickNextButton(new HealthcareDiagnosedConditionsPageCC());

        healthcareDiagnosedConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new IncongruentSiteSelectionCloseCC())
                .waitForPageLoad(matchedStudyName, dquedStudyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
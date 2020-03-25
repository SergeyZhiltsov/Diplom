package com.acurian.selenium.OLS;

import com.acurian.selenium.blinx.Crohns_4818_OLSBlinx;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.cv_study.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.List;

public class CV_4241_OLS extends BaseTest {

    private static Logger Log = LogManager.getLogger(CV_4241_OLS.class.getName());


    @DataProvider(name = "sites")
    public Object[][] sites() {
        return new Object[][] {
                {Site.AUT_CV1_4241_site},
                {Site.AUT_CV1_4241_NonSynexus_site}
        };
    }

    @Test(enabled = false, dataProvider = "sites")
    @Description("CV_4241_OLS Sanofi T2DM + CV")
    public void cv4241Ols(Site site) {
        final String phoneNumber = "AUTAMS1CV1";
        final String dquedStudyName = "a heart health study";
        final String matchedStudyName = "a study for diabetics";
        final String siteName = "AUT_CV1_4241";
        final String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a heart health study", "600");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.
//                getExpectedModifiedTitle("a heart health study", "600"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a heart health study", "600")
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad("a heart health study", "600")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS =
                cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS());

        haveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(new TransitionalStatementLowtPageOLS());

        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Chronic Kidney Disease")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickOnAnswers("Chronic Kidney Disease")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();

        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        MedicationsForYourDiabetesPageOLS medicationsForYourDiabetesPageOLS = withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new MedicationsForYourDiabetesPageOLS());

        CholesterolTriglyceridesLipidsPageOLS сholesterolTriglyceridesLipidsPageOLS
                = new CholesterolTriglyceridesLipidsPageOLS();
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

        for (String answer: disqualify) {
            Log.info("Select answer for Q7: " + answer);
            medicationsForYourDiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(сholesterolTriglyceridesLipidsPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6706", site.activeProtocols)
                    .back();
        }
        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = medicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());

        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HeartOrBloodVesselPageOLS());

        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS haveYouExperiencedAnyFollowingCardiovascularInterventionsOLS =
                heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());

        HeartrelatedMedicalConditionsProceduresPageOLS heartrelatedMedicalConditionsProceduresPageOLS =
                haveYouExperiencedAnyFollowingCardiovascularInterventionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageOLS());

        RelativesHeartAttackPageOLS relativesHeartAttackPageOLS = heartrelatedMedicalConditionsProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageOLS());

        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = relativesHeartAttackPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of these relatives")
                .clickNextButton(new EverSmokedCigarettesPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "165")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS) //"CV Risk Criteria:
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back();

        //back to select Q14 and remove DQ in Q24 Ghost Question - Cardiovascular Disease / Risk Qualifying Logic
        approximateHeightPageOLS
                .waitForPageLoad()
                .back(everSmokedCigarettesPageOLS)
                .waitForPageLoad()
                .back(relativesHeartAttackPageOLS)
                .waitForPageLoad()
                .back(heartrelatedMedicalConditionsProceduresPageOLS)
                .waitForPageLoad()
                .back(haveYouExperiencedAnyFollowingCardiovascularInterventionsOLS)
                .waitForPageLoad()
                .back(heartOrBloodVesselPageOLS);
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        //go to Q24
        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouExperiencedAnyFollowingCardiovascularInterventionsOLS)
                .waitForPageLoad()
                .clickNextButton(heartrelatedMedicalConditionsProceduresPageOLS)
                .waitForPageLoad()
                .clickNextButton(relativesHeartAttackPageOLS)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis of the liver", "Drug or alcohol abuse within the past year", "Hepatitis B",
                        "Hepatitis C", "HIV or AIDS", "Kidney disease requiring dialysis or transplant",
                        "Schizophrenia")
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        zipCode)
                .clickNextButton(new IncongruentSiteSelectionClose_OLS())
                .waitForPageLoad(matchedStudyName, dquedStudyName)
                .getPID()
                .clickOnFacilityName(siteName)
//                .clickNextButton(new QualifiedClose1PageOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

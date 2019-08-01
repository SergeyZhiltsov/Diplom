package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.IBS.SufferFromIrritablePageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.cv_study.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class CV_4450_OLS extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "sites")
    public Object[][] sites() {
        return new Object[][] {
                {Site.AUT_CV1_4450S_Syn},
        };
    }

    @Test(dataProvider = "sites")
    @Description("CV 4450 OLS Novo Nordisk CV")
    public void cv4450olsTest(Site site) {
        String phoneNumber = "AUTAMS1CV1";
        String studyName = "a heart health";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(),
                dateOfBirthPageOLS.getExpectedModifiedTitle("a heart health study", "750"),
                "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .waitForPageLoad2Ver()
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad2Ver()
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
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
                        .setDate("01081975")//"Disqualify (“Age”) if < 45
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01081970")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension",
                        "Chronic Kidney Disease")
                .clickOnAnswers("None of the above")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());
//Q12
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .back(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new TransitionalStatementLowtPageOLS());
        transitionalStatementLowtPageOLS
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
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new MedicationsForYourDiabetesPageOLS());

        medicationsForYourDiabetesPageOLS
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
                .clickOnAnswers("None of the above")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);

        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HeartOrBloodVesselPageOLS());

        HaveDoctorEverDiagnosedYou_OLS haveDoctorEverDiagnosedYou_OLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"Mini-Stroke\"",
                        "Angina (heart-related chest pain) that required an overnight stay in a hospital",
                        "Coronary Artery Disease (blockage in a heart vessel)",
                        "Peripheral Vascular Disease (for example a blockage in your leg vessel)",
                        "Amputation of a digit or limb due to Peripheral Vascular Disease")
                .clickOnAnswers("None of the above")//Skip to Q16
                .clickNextButton(new HaveDoctorEverDiagnosedYou_OLS());
        haveDoctorEverDiagnosedYou_OLS
                .waitForPageLoad()
                .back();
        AnginaOrChestPainPageOLS anginaOrChestPainPageOLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight stay in a hospital")
                .clickNextButton(new AnginaOrChestPainPageOLS());
        anginaOrChestPainPageOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
                .clickNextButton(anginaOrChestPainPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(anginaOrChestPainPageOLS);

        List<String> disqulifyQ15 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer: disqulifyQ15) {
            System.out.println(answer);
            anginaOrChestPainPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(haveDoctorEverDiagnosedYou_OLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6714", site.activeProtocols)
                    .back();
        }
        anginaOrChestPainPageOLS
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .back();

        heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveDoctorEverDiagnosedYou_OLS);

        HeartrelatedMedicalConditionsProceduresPageOLS heartrelatedMedicalConditionsProceduresPageOLS = haveDoctorEverDiagnosedYou_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageOLS());

        RelativesHeartAttackPageOLS relativesHeartAttackPageOLS = heartrelatedMedicalConditionsProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageOLS());

        FirstHeartAttackPageOLS firstHeartAttackPageOLS = relativesHeartAttackPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Sister")
                .clickNextButton(new FirstHeartAttackPageOLS());

        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = firstHeartAttackPageOLS
                .waitForPageLoad()
                .setYears("30")
                .clickNextButton(new EverSmokedCigarettesPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back();
        approximateHeightPageOLS
                .waitForPageLoad()
                .back();
        everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .back();
        firstHeartAttackPageOLS
                .waitForPageLoad()
                .back();
        relativesHeartAttackPageOLS
                .waitForPageLoad()
                .back();

        heartrelatedMedicalConditionsProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Peripheral Artery Disease or PAD (narrowed or hardened blood vessels in your arms or legs)")
                .clickNextButton(relativesHeartAttackPageOLS)
                .waitForPageLoad()
                .clickNextButton(firstHeartAttackPageOLS)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAllWithClear("5", "5", "160") //Disqualify ("BMI") if BMI < 27 kg/m2
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6721", site.activeProtocols)
                .back();
        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAllWithClear("5", "5", "170")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        List<String> options = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String entry: options) {
            System.out.println(entry);
            healthcareDiagnosedConditionsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry)
                    .clickNextButton(transitionalStatementLowtPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .back();
        }

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
//                .clickNextButton(new SynexusHealthyMindsPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No, I am not interested in receiving information")
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
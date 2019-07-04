package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusHealthyMindsPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.cv_study.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
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


public class CV_5034_OLS_A_S extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "5034Sites")
    public static Object[][] getData() {
        return new Object[][] {
                {Site.AUT_CV_5034A_site},
                {Site.AUT_CV_5034S_site}
        };
    }

    @Test(dataProvider = "5034Sites")
    @Description("CV_5034_OLS_A_S")
    public void CV_5034_OLS_Test(Site site) {
        final String phoneNumber = "AUTAMS1CV1";
        final String studyName = "a heart health";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(),
                dateOfBirthPageOLS.getExpectedModifiedTitle("a heart health study", "750"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091952")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        //-------GENDER Page--------
        genderPageOLS
                .waitForPageLoad();
        //DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());

        //-------Q3:  Has a doctor ever diagnosed you with any of the following medical conditions or diseases?----------
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();
        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());
        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Chronic Kidney Disease")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6703", site.activeProtocols)
                .back();

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        //-------Q4: What kind of diabetes do you have?----------
        TransitionalStatementLowtPageOLS transitionalStatementLowtPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new TransitionalStatementLowtPageOLS());
        transitionalStatementLowtPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        MedicationsForYourDiabetesPageOLS medicationsForYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(new MedicationsForYourDiabetesPageOLS());
        medicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(medicationsForYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(medicationsForYourDiabetesPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .back();         
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        //-------Q5: WithType2DiabetesPageOLS------------
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new MedicationsForYourDiabetesPageOLS());
        medicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6705", site.activeProtocols)
                .back();
        withType2DiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 to less than 5 years ago")
                .clickNextButton(medicationsForYourDiabetesPageOLS);

        //-------Q6: Do you currently take any of the following specific medications for your diabetes?------------
        medicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Glyxambi (empagliflozin and linagliptin)",
                        "Januvia (sitagliptin)",
                        "Nesina (alogliptin)",
                        "Oseni (alogliptin and pioglitazone)", 
                        "Onglyza (saxagliptin)", "Tradjenta (linagliptin)",
                        "Bydureon or Byetta (exenatide)",
                        "Saxenda or Victoza (liraglutide)", 
                        "Adlyxin (lixisenatide)",
                        "Tanzeum (albiglutide)",
                        "Trulicity (dulaglutide)",
                        "Ozempic (semaglutide)")
                .clickNextButton(cholesterolTriglyceridesLipidsPageOLS);


        //-------New Q12: Ask Q12 (current non-statin use) even if did not report "High cholesterol or high triglycerides"
        HeartOrBloodVesselPageOLS heartOrBloodVesselPageOLS = cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartOrBloodVesselPageOLS());
        heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6734", site.activeProtocols)
                .back(cholesterolTriglyceridesLipidsPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(heartOrBloodVesselPageOLS);

        //-----Q12:  Have you experienced any of the following heart or blood vessel related events?
        HaveDoctorEverDiagnosedYou_OLS haveDoctorEverDiagnosedYou_OLS = heartOrBloodVesselPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
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
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "TIA or \"Mini-Stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        //---Q13: When was the last time that you experienced a heart attack? 
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6713", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickOnAnswerForSubQuestion(3, "More than 6 months ago")
                .clickNextButton(haveDoctorEverDiagnosedYou_OLS);

        //------Q15:  Have you experienced any of the following cardiovascular interventions or surgeries?
        HeartrelatedMedicalConditionsProceduresPageOLS heartrelatedMedicalConditionsProceduresPageOLS = haveDoctorEverDiagnosedYou_OLS
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .back(heartOrBloodVesselPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveDoctorEverDiagnosedYou_OLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalConditionsProceduresPageOLS());

        RelativesHeartAttackPageOLS relativesHeartAttackPageOLS = heartrelatedMedicalConditionsProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new RelativesHeartAttackPageOLS());

        FirstHeartAttackPageOLS firstHeartAttackPageOLS = relativesHeartAttackPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Brother")
                .clickNextButton(new FirstHeartAttackPageOLS());

        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = firstHeartAttackPageOLS
                .waitForPageLoad()
                .setYears("30")
                .clickNextButton(new EverSmokedCigarettesPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new ApproximateHeightPageOLS());

        ReceivedHeartProcedurePageOLS receivedHeartProcedurePageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(transitionalStatementLowtPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .back(everSmokedCigarettesPageOLS)
                .waitForPageLoad()
                .back(firstHeartAttackPageOLS)
                .waitForPageLoad()
                .back(relativesHeartAttackPageOLS)
                .waitForPageLoad()
                .back(heartrelatedMedicalConditionsProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Procedure to clear plaque from blood vessels in the neck such as carotid endarterectomy")
                .clickNextButton(new ReceivedHeartProcedurePageOLS());

        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = receivedHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(relativesHeartAttackPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6717", site.activeProtocols)
                .back(receivedHeartProcedurePageOLS)
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(relativesHeartAttackPageOLS)
                .waitForPageLoad()
                .clickNextButton(firstHeartAttackPageOLS)
                .waitForPageLoad()
                .clickNextButton(everSmokedCigarettesPageOLS)
                .waitForPageLoad()
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
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

        AboutHealthPageOLS aboutHealthPageOLS = healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        switch (site) {
            case AUT_CV_5034A_site: //1R
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_CV_5034S_site: //41C
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
    }
}
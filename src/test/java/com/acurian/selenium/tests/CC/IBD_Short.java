package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.DiagnosedWithCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.ManageYourCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.WhenDiagnosedCrohnsPageCC;
import com.acurian.selenium.pages.CC.IBD.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class IBD_Short extends BaseTest{

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] flareStatus() {
        return new Object[][]{
                {"Not in Flare"},
                {"In Flare"}
        };
    }

    @Test(dataProvider = "flareStatus")
    @Description("IBD 3485 SHORT CC")
    public void IBD3264ccTest_Short(String flareStatus) {
        String phoneNumber = "AUTAMSCRSH";
        String protocol1 = "M16_006";
        String siteName = "AUT_CRN_3889_HS";//"AUT_IBD_3839_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a Crohn's study", "700"), "Title is diff");

        dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1)
                .back(dateOfBirthPageCC);
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
        		.setYear("1937") //Disqualify (“Age”) if >= 81 years
                .clickNextButton(new IdentificationPageCC());
        identificationPageCC
                .waitForPageLoadNotQ()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1)
                .back();

        dateOfBirthPageCC
		   		.setYear("1980")
		   		.clickNextButton(identificationPageCC);


        GenderPageCC genderPageCC = identificationPageCC
     		   .waitForPageLoad1()
     		   .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
     		   .clickNextButton(new GenderPageCC());

        DiagnosedWithCrohnsPageCC  diagnosedWithCrohnsPageCC = genderPageCC
     		   .waitForPageLoad()
     		   .clickOnAnswer("Female")
     		   .clickNextButton(new DiagnosedWithCrohnsPageCC());
        //Q2
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol1)
                .back();

        CrohnsDiseaseDoctorOrNursePageСС crohnsDiseaseDoctorOrNursePageСС = diagnosedWithCrohnsPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("Crohn's disease")
        		.clickNextButton(new CrohnsDiseaseDoctorOrNursePageСС());

        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = crohnsDiseaseDoctorOrNursePageСС
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020425-QS5726-STUDYQUES", protocol1)
                .back(crohnsDiseaseDoctorOrNursePageСС)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020425-QS5726-STUDYQUES", protocol1)
                .back(crohnsDiseaseDoctorOrNursePageСС)
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());

        ManageYourCrohnsPageCC manageYourCrohnsPageCC = whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago") //Disqualify ("Crohn's < 3 months - Temp 3")
                .clickNextButton(new ManageYourCrohnsPageCC()); //If Patient's tracking/phone # is on for this Referral Service Code: "3485 SHORT", Skip to Q6 Q9
        manageYourCrohnsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015880-QS5703-STUDYQUES", protocol1)
                .back(whenDiagnosedCrohnsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("More than 6 months ago")
                .clickNextButton(manageYourCrohnsPageCC);
        //Q9
        CrohnsDiseaseOrUlcerativeColitisFlarePageCC crohnsDiseaseOrUlcerativeColitisFlarePageCC = manageYourCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CrohnsDiseaseOrUlcerativeColitisFlarePageCC());
        SteroidMedicationsForCrohnsCC steroidMedicationsForCrohnsCC = crohnsDiseaseOrUlcerativeColitisFlarePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015883-QS5706-STUDYQUES", protocol1)
                .back(manageYourCrohnsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SteroidMedicationsForCrohnsCC());
        //Q10
        BiologicMedicationsCC biologicMedicationsCC = steroidMedicationsForCrohnsCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new BiologicMedicationsCC());

        OtherPrescriptionMedicinesIBDShort otherPrescriptionMedicinesIBDShort = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Patient's tracking/phone # is on for this Referral Service Code: "3485 SHORT", skip to Q15
                .clickNextButton(new OtherPrescriptionMedicinesIBDShort());

        otherPrescriptionMedicinesIBDShort
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015901-QS5713-STUDYQUES", protocol1)
                .back(otherPrescriptionMedicinesIBDShort)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(crohnsDiseaseOrUlcerativeColitisFlarePageCC);

        HSMedicalRecordsPageCC hsMedicalRecordsPageCC = new HSMedicalRecordsPageCC();
        crohnsDiseaseOrUlcerativeColitisFlarePageCC
                .waitForPageLoad();
        switch (flareStatus) {
            case "Not in Flare":
                crohnsDiseaseOrUlcerativeColitisFlarePageCC
                        .clickOnAnswer("In remission (no symptoms, or symptoms do not interfere with daily activities)")
                        .clickNextButton(identificationPageCC)
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkStudyStatusContainsForQNumber("Q0020429-QS5730-STUDYQUES","2-4");
                break;
            case "In Flare":
                crohnsDiseaseOrUlcerativeColitisFlarePageCC
                        .clickOnAnswer("Moderate symptoms, but managing")
                        .clickNextButton(identificationPageCC)
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkStudyStatusContainsForQNumber("Q0020429-QS5730-STUDYQUES","2-3");
                break;
        }
        DoctorInformationCollectionPageCC doctorInformationCollectionPageCC = identificationPageCC
        		.clickNextButton(new SiteSelectionPageCC())
        		.waitForPageLoad("a Crohn's study")
        		.getPID()
        		.clickOnAnswer(siteName)
                .clickNextButton(new DoctorInformationCollectionPageCC());
        ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = new ThankYouCloseSimplePageCC();
        switch (flareStatus) {
            case "Not in Flare":
                doctorInformationCollectionPageCC
                        .waitForPageLoadIBD("Crohn's Disease")
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new QualifiedFlareMonitoringAppClosePageCC())
                        .waitForPageLoad()
                        .getActivationCode()
                        .clickNextButton(new ThankYouCloseSimplePageCC());

                break;
            case "In Flare":
                doctorInformationCollectionPageCC
                        .waitForPageLoadIBD("Crohn's Disease")
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new ThankYouCloseSimplePageCC());
                break;
        }
        thankYouCloseSimplePageCC
                .waitForPageLoad()
                .clickNextButton(loginPageCC)
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch("1R", "1R");
    }
}
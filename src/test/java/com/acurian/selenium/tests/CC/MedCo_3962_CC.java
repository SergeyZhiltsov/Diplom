package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DYS_4356C.AreYouTakingAnyOfMedicationsCC;
import com.acurian.selenium.pages.CC.DYS_4356C.NonPrescriptionSupplementsCC;
import com.acurian.selenium.pages.CC.DYS_4356C.StatinMedicationsHavePageCC;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.HouseholdHavePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MedCo_3962_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
    public void medCo_3962_OLS(final String username, final String password) {
        String phoneNumber = "AUTAMS1MED";
        List<String> protocols = Arrays.asList("MDCO_PCS_17_04");
        String protocol1 = "MDCO_PCS_17_04";
        String studyName = "a high cholesterol and heart disease";
        //   String env = "STG";
        String siteName = "AUT_MEDCO_3962_site";
        String site_Indication = "Hypercholesterolemia, Cardiovascular Disease";
        String zipCode = "19901";  //"45203" cincinnati, OH

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
                .waitForPageLoad();
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //dateOfBirthPageCC.waitForPageLoad();
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoad1()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        DyslipidemiaHealthcarePageCC dyslipidemiaHealthcarePageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DyslipidemiaHealthcarePageCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);
        debugPageCC.back();
        dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        debugPageCC.checkProtocolsEquals("Has a healthcare professional ever told you that you have any of the following?Agent Note: Select al...", protocol1);
        debugPageCC.back();
        StatinMedicationsHavePageCC statinMedicationsHavePageCC = dyslipidemiaHealthcarePageCC
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol, or hypercholesterolemia")
                .clickNextButton(new StatinMedicationsHavePageCC());
        //---------------statinMedicationsCC---------------
        AreYouTakingAnyOfMedicationsCC areYouTakingAnyOfMedicationsCC = statinMedicationsHavePageCC
                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouTakingAnyOfMedicationsCC());
        debugPageCC.checkProtocolsEquals("One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is a ...", protocol1);
        debugPageCC.back();
        StatinMedicationPreviousQuestionPageCC statinMedicationPreviousQuestionPageCC = statinMedicationsHavePageCC
                .waitForPageLoad()
//                .clickOnAnswers("Rosuvastatin")
                .clickNextButton(new StatinMedicationPreviousQuestionPageCC());
        //---------------statinMedicationPreviousQuestionPageCC---------------
        statinMedicationPreviousQuestionPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 months")
                .clickNextButton(new AreYouTakingAnyOfMedicationsCC());
        //--------------areYouTakingAnyOfMedicationsCC---------------
        areYouTakingAnyOfMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonPrescriptionSupplementsCC())
                //--------------NonPrescriptionSupplementsCC---------------
                .waitForPageLoad()
                .clickOnAnswers("None of the above");
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = areYouTakingAnyOfMedicationsCC
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());


        //----------*******NEW GENERAL HEALTH Questions********----------
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedCC())
                //-----------HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS-----------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC())
                //-----------HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS-----------
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
                .clickNextButton(new MostRecentHeartProcedurePageСС())
                //-----------MostRecentHeartProcedurePageOLS page-----------
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(new ChildrenUnderPageCC())
                //----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HouseholdHavePageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new IdentificationPageCC())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a high cholesterol and heart disease study")
                .clickOnAnswer(siteName)
                .getPID()
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(site_Indication)
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

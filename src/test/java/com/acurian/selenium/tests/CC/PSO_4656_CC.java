package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.PSO_456.*;
import com.acurian.selenium.pages.CC.VACC_4556_CC.AreYouInterestedInPneumoniaVaccineStudyCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusHealthyMindsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PSO_4656_CC extends BaseTest {

    @Test
    @Description("PSO_4656_CC")
    public void psor4656CC() {
        Site site = Site.AUT_PSO4656;
        final String phoneNumber = "AUTAMS1PSO";
        final String studyName = "a psoriasis study";
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a psoriasis study", "350"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("15")
                .setYear("2005")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageOLS = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedWithPsoriasisCC diagnosedWithPsoriasisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithPsoriasisCC());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019299-QS7002-STUDYQUES", site.activeProtocols)
                .back();

        WhenDiagnosedWithPsoriasisCC whenDiagnosedWithPsoriasisCC = diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedWithPsoriasisCC());

        WhichTypeOfPsoriasisCC whichTypeOfPsoriasisCC = whenDiagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("5 months ago or less")
                .clickNextButton(new WhichTypeOfPsoriasisCC());

        whichTypeOfPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019300-QS7003-STUDYQUES", site.activeProtocols)
                .back();

        whenDiagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("6 to 11 months ago")
                .clickNextButton(whichTypeOfPsoriasisCC);

        HowMuchPsoriasisOnYourBodyCC howMuchPsoriasisOnYourBodyCC = new HowMuchPsoriasisOnYourBodyCC();
        ArrayList<String> types = new ArrayList<>();
        types.add("Guttate - Small, pink-red spots appear on your skin");
        types.add("Pustular - White blisters surrounded by red, irritated skin");
        types.add("Erythrodermic - Redness that covers large areas of your skin");
        types.add("Inverse - Skin redness and irritation occurs in the armpits, groin, and in areas of overlapping skin");
        for (String type : types) {
            whichTypeOfPsoriasisCC
                    .waitForPageLoad()
                    .clickOnAnswers("I am not sure")
                    .clickOnAnswers(type)
                    .clickNextButton(howMuchPsoriasisOnYourBodyCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0019301-QS7004-STUDYQUES", site.activeProtocols)
                    .back();
        }

        TreatYourPsoriasisCC treatYourPsoriasisCC = whichTypeOfPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswers("I am not sure")
                .clickNextButton(howMuchPsoriasisOnYourBodyCC)
                .waitForPageLoad()
                .selectFromDropDown("0")
                .clickNextButton(new TreatYourPsoriasisCC());

        treatYourPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019303-QS7005-STUDYQUES", site.activeProtocols)
                .back();

        howMuchPsoriasisOnYourBodyCC
                .waitForPageLoad()
                .selectFromDropDown("21 +")
                .clickNextButton(treatYourPsoriasisCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019303-QS7005-STUDYQUES", site.activeProtocols)
                .back();

        howMuchPsoriasisOnYourBodyCC
                .waitForPageLoad()
                .selectFromDropDown("4")
                .clickNextButton(treatYourPsoriasisCC);

        HaveYouEverTakenOtezlaCC haveYouEverTakenOtezlaCC = treatYourPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverTakenOtezlaCC());

        haveYouEverTakenOtezlaCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019310-QS7014-STUDYQUES", site.activeProtocols)
                .back();

        TopicalsMedicationsForPsoriasisCC topicalsMedicationsForPsoriasisCC = treatYourPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswers("Medications taken by mouth (oral medications)")
                .clickNextButton(new TopicalsMedicationsForPsoriasisCC());

        topicalsMedicationsForPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("7 months to 1 year ago")
                .clickNextButton(haveYouEverTakenOtezlaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019310-QS7014-STUDYQUES", site.activeProtocols)
                .back();

        topicalsMedicationsForPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(haveYouEverTakenOtezlaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019310-QS7014-STUDYQUES", site.activeProtocols)
                .back();

        BiologicMedicationsCC biologicMedicationsCC = topicalsMedicationsForPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("In the last 6 months")
                .clickNextButton(haveYouEverTakenOtezlaCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BiologicMedicationsCC());

        biologicMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019311-QS7015-STUDYQUES", site.activeProtocols)
                .back();

        haveYouEverTakenOtezlaCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(biologicMedicationsCC);

        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        List<String> medications = Arrays.asList(
//                "Actemra (Agent Note: ac-TEM-ruh)",
//                "Benlysta (Agent Note: ben-LIST-uh)",
//                "Cimzia (Agent Note: SIM-zee-uh)",
//                "Cosentyx (Agent Note: co-SEN-tix)",
//                "Enbrel (Agent Note: EN-brel)",
//                "Entyvio (Agent Note: en-TIV-ee-oh)",
//                "Humira (Agent Note: hue-MAIR-uh)",
//                "Kineret (Agent Note: KIN-er-et)",
//                "Orencia (Agent Note: oh-REN-see-uh)",
//                "Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)",
//                "Raptiva (Agent Note: rap-TEE-vuh)",
//                "Remicade (Agent Note: REM-ih-cade)",
//                "Rituxan (Agent Note: rih-TUX-an)",
//                "Simponi (Agent Note: SIM-po-nee)",
//                "Stelara (Agent Note: ste-LAHR-uh)",
                "Taltz (Agent Note: TALTS)",
                "Tysabri (Agent Note: tie-SAB-ree)"
        );
        for (String medication : medications) {
            biologicMedicationsCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(medication)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoadPsoriasis()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0005225-QS7016-STUDYQUES", site.activeProtocols)
                    .back();
        }

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadPsoriasis()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", site.activeProtocols)
                .back();

         whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        List<String> diagnoses = Arrays.asList(
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS"
        );
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        for (String diagnose : diagnoses) {
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                    .back();
        }

        LetMeSeePageCC letMeSeePageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("5", "5", "180")
                .clickNextButton(new LetMeSeePageCC());

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch(site.dispo);
    }
}

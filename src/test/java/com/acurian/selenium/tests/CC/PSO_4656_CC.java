package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.PSO_456.*;
import com.acurian.selenium.pages.CC.PsoriaticArthritis.PsoriaticArthritisConditionPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose1PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.PS_4656_OLS;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class PSO_4656_CC extends BaseTest {

    @Test(dataProvider = "sites", dataProviderClass = PS_4656_OLS.class)
    @Description("PSO_4656_CC")
    public void psor4656cc(Site site) {
        final String phoneNumber = "AUTAMS1PSO";
        final String studyName = "a psoriasis study";
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a psoriasis study", "350");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle("a psoriasis study", "350"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageOLS = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad("a psoriasis study", "350")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DiagnosedWithPsoriasisCC diagnosedWithPsoriasisCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("15")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithPsoriasisCC());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc =
                diagnosedWithPsoriasisCC
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7002", site.activeProtocols)
                .back();

        WhenDiagnosedWithPsoriasisCC whenDiagnosedWithPsoriasisCC = diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedWithPsoriasisCC());

        TypePsoriasisPageCC typePsoriasisPageCC = whenDiagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("5 months ago or less")
                .clickNextButton(new TypePsoriasisPageCC());
        typePsoriasisPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7003", site.activeProtocols)
                .back();

        whenDiagnosedWithPsoriasisCC
                .waitForPageLoad()
                .clickOnAnswer("6 to 11 months ago")
                .clickNextButton(typePsoriasisPageCC);

        TransitionStatementCC transitionStatementCC = typePsoriasisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Another type of psoriasis (Guttate, Pustular, Erythtodermic, Inverse)")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoadPsoriasis()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7020", site.activeProtocols)
                .back();
        HowMuchPsoriasisOnYourBodyCC howMuchPsoriasisOnYourBodyCC = typePsoriasisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Plaque - Thick, red patches of skin are covered by flaky, silver-white scales. This is the most common type of psoriasis")
                .clickNextButton(new HowMuchPsoriasisOnYourBodyCC());


        TreatYourPsoriasisPageCC treatYourPsoriasisPageCC = new TreatYourPsoriasisPageCC();
        List<String> disqualifyQ5 = Arrays.asList("0", "1", "21 +");
        for (String answer : disqualifyQ5) {
            System.out.println("Select answer from dropdown for Q5: " + answer);
            howMuchPsoriasisOnYourBodyCC
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(treatYourPsoriasisPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7005", site.activeProtocols)
                    .back();

        }
        howMuchPsoriasisOnYourBodyCC
                .waitForPageLoad()
                .selectFromDropDown("4")
                .clickNextButton(treatYourPsoriasisPageCC);

        PsoriaticArthritisConditionPageCC psoriaticArthritisConditionPageCC = treatYourPsoriasisPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PsoriaticArthritisConditionPageCC());
        psoriaticArthritisConditionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7014", site.activeProtocols)
                .back();

        MedicationsForPsoriasisPageCC medicationsForPsoriasisPageCC = treatYourPsoriasisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Medications taken by mouth (oral medications)")
                .clickNextButton(new MedicationsForPsoriasisPageCC());

        medicationsForPsoriasisPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 months to 1 year ago")
                .clickNextButton(psoriaticArthritisConditionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7014", site.activeProtocols)
                .back(medicationsForPsoriasisPageCC)
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(psoriaticArthritisConditionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7014", site.activeProtocols)
                .back();

        HaveYouEverTakenOtezlaPageCC haveYouEverTakenOtezlaPageCC = medicationsForPsoriasisPageCC
                .waitForPageLoad()
                .clickOnAnswer("In the last 6 months")
                .clickNextButton(new HaveYouEverTakenOtezlaPageCC());

        BiologicMedicationsCC biologicMedicationsCC = haveYouEverTakenOtezlaPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BiologicMedicationsCC());

        biologicMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7015", site.activeProtocols)
                .back();

        haveYouEverTakenOtezlaPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(biologicMedicationsCC);

        List<String> medications = Arrays.asList(
                "Actemra (Agent Note: ac-TEM-ruh)",
                "Benlysta (Agent Note: ben-LIST-uh)",
                "Cimzia (Agent Note: SIM-zee-uh)",
                "Cosentyx (Agent Note: co-SEN-tix)",
                "Enbrel (Agent Note: EN-brel)",
                "Entyvio (Agent Note: en-TIV-ee-oh)",
                "Humira (Agent Note: hue-MAIR-uh)",
                "Kineret (Agent Note: KIN-er-et)",
                "Orencia (Agent Note: oh-REN-see-uh)",
                "Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)",
                "Raptiva (Agent Note: rap-TEE-vuh)",
                "Remicade (Agent Note: REM-ih-cade)",
                "Rituxan (Agent Note: rih-TUX-an)",
                "Simponi (Agent Note: SIM-po-nee)",
                "Stelara (Agent Note: ste-LAHR-uh)",
                "Taltz (Agent Note: TALTS)",
                "Tysabri (Agent Note: tie-SAB-ree)"
        );
        for (String medication : medications) {
            biologicMedicationsCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(medication)
                    .clickNextButton(psoriaticArthritisConditionPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7016", site.activeProtocols)
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

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                new DoAnyOftheFollowingAdditionalDiagnosesCC();
        List<String> disqualifyQ6QS42 = Arrays.asList("Within the past 5 years", "6 - 10 years ago",
                "11 or more years ago");
        for (String answer : disqualifyQ6QS42) {
            System.out.println("Select answer for Q6QS42: " + answer);
            whenDiagnosedWithCancerCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                    .back();
        }
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        List<String> diagnoses = Arrays.asList("Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS");
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        for (String diagnose : diagnoses) {
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4656")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
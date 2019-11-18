package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.PS_4656.*;
import com.acurian.selenium.pages.OLS.PsoriaticArthritis.PsoriaticArthritisConditionPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose1PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class PS_4656_OLS extends BaseTest {

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_PSO4656},
        };
    }

    @Test(enabled = true, dataProvider = "sites")
    @Description("PS 4556 OLS")
    public void ps4556olsTest(Site site) {
        final String phoneNumber = "AUTAMS1PSO";
        final String studyName = "a psoriasis";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a psoriasis study", "350");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle("a psoriasis study", "350"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols =
                healthcareDiagnosedPsoriasisPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());
        hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7002", site.activeProtocols)
                .back();
        HowLongPsoriasisPageOLS howLongPsoriasisPageOLS = healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongPsoriasisPageOLS());

        TypePsoriasisPageOLS typePsoriasisPageOLS = howLongPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("5 months ago or less")
                .clickNextButton(new TypePsoriasisPageOLS());
        typePsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7003", site.activeProtocols)
                .back();
        howLongPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 to 11 months ago")
                .clickNextButton(typePsoriasisPageOLS);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                typePsoriasisPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Another type of psoriasis (Guttate, Pustular, Erythtodermic, Inverse)")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7020", site.activeProtocols)
                .back();
        //PartsBodyCurrentlyAffectedByPsoriasisPageOLS partsBodyCurrentlyAffectedByPsoriasisPageOLS = typePsoriasisPageOLS
        HowMuchPsoriasisOnYourBodyOLS howMuchPsoriasisOnYourBodyOLS = typePsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Plaque - Thick, red patches of skin are covered by flaky, silver-white scales. This is the most common type of psoriasis")
                .clickNextButton(new HowMuchPsoriasisOnYourBodyOLS());

        TreatYourPsoriasisPageOLS treatYourPsoriasisPageOLS = new TreatYourPsoriasisPageOLS();
        List<String> disqualifyQ5 = Arrays.asList("0", "1", "21 +");
        for (String answer : disqualifyQ5) {
            System.out.println("Select answer from dropdown for Q5: " + answer);
            howMuchPsoriasisOnYourBodyOLS
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(treatYourPsoriasisPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7005", site.activeProtocols)
                    .back();

        }
        howMuchPsoriasisOnYourBodyOLS
                .waitForPageLoad()
                .selectFromDropDown("4")
                .clickNextButton(treatYourPsoriasisPageOLS);
//-----Deactivated BSA images questions in spec R78.3
//        partsBodyCurrentlyAffectedByPsoriasisPageOLS
//                .waitForPageLoad()
//                .back(typePsoriasisPageOLS)
//                .waitForPageLoad()
//                .clickOnAnswers("I am not sure")
//                .clickNextButton(partsBodyCurrentlyAffectedByPsoriasisPageOLS);
//
//
//        TreatYourPsoriasisPageOLS treatYourPsoriasisPageOLS = partsBodyCurrentlyAffectedByPsoriasisPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of these")
//                .clickNextButton(new TreatYourPsoriasisPageOLS());
//        treatYourPsoriasisPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS7006", site.activeProtocols)
//                .back();
//        HeadFaceNeckPsoriasisPageOLS headFaceNeckPsoriasisPageOLS = partsBodyCurrentlyAffectedByPsoriasisPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Head, scalp, face, and neck",
//                        "Chest, stomach, and back",
//                        "Arms and hands",
//                        "Legs and feet")
//                .clickNextButton(new HeadFaceNeckPsoriasisPageOLS());
//
//        ChestStomachBackPsoriasisPageOLS chestStomachBackPsoriasisPageOLS = headFaceNeckPsoriasisPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("B")
//                .clickNextButton(new ChestStomachBackPsoriasisPageOLS());
//
//        ArmsHandsPsoriasisPageOLS armsHandsPsoriasisPageOLS = chestStomachBackPsoriasisPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("A")
//                .clickNextButton(new ArmsHandsPsoriasisPageOLS());
//
//        LegsFeetPsoriasisPageOLS legsFeetPsoriasisPageOLS = armsHandsPsoriasisPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("B")
//                .clickNextButton(new LegsFeetPsoriasisPageOLS());
//
//        legsFeetPsoriasisPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("E")
//                .clickNextButton(treatYourPsoriasisPageOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS7011", site.activeProtocols)
//                .back();
//        legsFeetPsoriasisPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("D")
//                .clickNextButton(treatYourPsoriasisPageOLS);

        PsoriaticArthritisConditionPageOLS psoriaticArthritisConditionPageOLS = treatYourPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PsoriaticArthritisConditionPageOLS());
        psoriaticArthritisConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7014", site.activeProtocols)
                .back();
        MedicationsForPsoriasisPageOLS medicationsForPsoriasisPageOLS = treatYourPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medications taken by mouth (oral medications)")
                .clickNextButton(new MedicationsForPsoriasisPageOLS());

        medicationsForPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 months to 1 year ago")
                .clickNextButton(psoriaticArthritisConditionPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7014", site.activeProtocols)
                .back(medicationsForPsoriasisPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(psoriaticArthritisConditionPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7014", site.activeProtocols)
                .back();
        HaveYouEverTakenOtezlaPageOLS haveYouEverTakenOtezlaPageOLS = medicationsForPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("In the last 6 months")
                .clickNextButton(new HaveYouEverTakenOtezlaPageOLS());

        BiologicMedicationsPageOLS biologicMedicationsPageOLS = haveYouEverTakenOtezlaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BiologicMedicationsPageOLS());
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7015", site.activeProtocols)
                .back();
        haveYouEverTakenOtezlaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(biologicMedicationsPageOLS);


        List<String> disqualifyQ16 = Arrays.asList("Actemra", "Benlysta", "Cimzia", "Enbrel", "Entyvio", "Humira",
                "Kineret", "Orencia", "Prolia or Xgeva", "Raptiva", "Remicade", "Rituxan", "Simponi", "Stelara",
                "Taltz", "Tysabri");
        for (String answer : disqualifyQ16) {
            System.out.println("Select answer for Q16: " + answer);
            biologicMedicationsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(psoriaticArthritisConditionPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7016", site.activeProtocols)
                    .back();
        }
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        List<String> disqualifyQ6QS42 = Arrays.asList("Within the past 5 years", "6 - 10 years ago",
                "11 or more years ago");
        for (String answer : disqualifyQ6QS42) {
            System.out.println("Select answer for Q6QS42: " + answer);
            otherThanSkinCancerPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                    .back();
        }
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        //Q24: QS59
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ26 = Arrays.asList("Drug or alcohol abuse within the past year", "Hepatitis B",
                "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
//                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyOLS());
//        areYouInterestedInPneumoniaVaccineStudyOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS())
//                .waitForPageLoad()
//                .back();
//        areYouInterestedInPneumoniaVaccineStudyOLS
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4656")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}

package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.BiologicMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.StopTakingStatinPageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.SubquestionStatinMedicationsHavePageOLS;
import com.acurian.selenium.pages.OLS.DY_4356.WhileTakingStatinPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TriglyceridesOrLipidsPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.*;
import com.acurian.selenium.pages.OLS.PS_4656.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusHealthyMindsPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.cv_study.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PS_4656_OLS extends BaseTest {

    @DataProvider
    public Object[][] sites() {
        return new Object[][] {
                {Site.AUT_PSO4656},
        };
    }

    @Test(enabled = true, dataProvider = "sites")
    @Description("PS 4556 OLS")
    public void ps4556olsTest(Site site) {
        String phoneNumber = "AUTAMS1PSO";
        final String[] protocols = site.activeProtocols;
        String studyName = "a psoriasis study";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText2Ver(), dateOfBirthPageOLS.title4656Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols = healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());
        hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7002", protocols)
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
                .checkProtocolsContainsForQNumber("QS7003", protocols)
                .back();
        howLongPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 to 11 months ago")
                .clickNextButton(typePsoriasisPageOLS);



        HashMap<String, List<String>> options = new HashMap<>();
        BodyAffectedPsoriasisPageOLS bodyAffectedPsoriasisPageOLS = new BodyAffectedPsoriasisPageOLS();
        options.put("Guttate - Small, pink-red spots appear on your skin", Arrays.asList(site.activeProtocols));
        options.put("Pustular - White blisters surrounded by red, irritated skin", Arrays.asList(site.activeProtocols));
        options.put("Erythrodermic - Redness that covers large areas of your skin", Arrays.asList(site.activeProtocols));
        options.put("Inverse - Skin redness and irritation occurs in the armpits, groin, and in areas of overlapping skin", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            typePsoriasisPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("I am not sure")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(bodyAffectedPsoriasisPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7004", (String[]) entry.getValue().toArray())
                    .back();
        }
        typePsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not sure")
                .clickNextButton(bodyAffectedPsoriasisPageOLS);

        TreatYourPsoriasisPageOLS treatYourPsoriasisPageOLS = bodyAffectedPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of these")
                .clickNextButton(new TreatYourPsoriasisPageOLS());
        treatYourPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7006", protocols)
                .back();
        HeadFaceNeckPsoriasisPageOLS headFaceNeckPsoriasisPageOLS = bodyAffectedPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Head, scalp, face, and neck",
                        "Chest, stomach, and back",
                        "Arms and hands",
                        "Legs and feet")
                .clickNextButton(new HeadFaceNeckPsoriasisPageOLS());

        ChestStomachBackPsoriasisPageOLS chestStomachBackPsoriasisPageOLS = headFaceNeckPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("B")
                .clickNextButton(new ChestStomachBackPsoriasisPageOLS());

        ArmsHandsPsoriasisPageOLS armsHandsPsoriasisPageOLS = chestStomachBackPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new ArmsHandsPsoriasisPageOLS());

        LegsFeetPsoriasisPageOLS legsFeetPsoriasisPageOLS = armsHandsPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(new LegsFeetPsoriasisPageOLS());

        legsFeetPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("A")
                .clickNextButton(treatYourPsoriasisPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7011", protocols)
                .back();
        legsFeetPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("E")
                .clickNextButton(treatYourPsoriasisPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7011", protocols)
                .back();
        legsFeetPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("D")
                .clickNextButton(treatYourPsoriasisPageOLS);

        EverTakenOteziaPageOLS everTakenOteziaPageOLS = treatYourPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTakenOteziaPageOLS());
        everTakenOteziaPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7014", protocols)
                .back();
        LastInjectibleForPsoriasisPageOLS lastInjectibleForPsoriasisPageOLS = treatYourPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medications taken by mouth (oral medications)")
                .clickNextButton(new LastInjectibleForPsoriasisPageOLS());

        lastInjectibleForPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 months to 1 year ago")
                .clickNextButton(everTakenOteziaPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7014", protocols)
                .back();
        lastInjectibleForPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(everTakenOteziaPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7014", protocols)
                .back();
        lastInjectibleForPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("In the last 6 months")
                .clickNextButton(everTakenOteziaPageOLS);

        BiologicMedicationsPageOLS biologicMedicationsPageOLS = everTakenOteziaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BiologicMedicationsPageOLS());
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7015", protocols)
                .back();
        everTakenOteziaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(biologicMedicationsPageOLS);



        HashMap<String, List<String>> options2 = new HashMap<>();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        options2.put("Actemra", Arrays.asList(protocols));
        options2.put("Benlysta", Arrays.asList(protocols));
        options2.put("Cimzia", Arrays.asList(protocols));
        options2.put("Enbrel", Arrays.asList(protocols));
        options2.put("Entyvio", Arrays.asList(protocols));
        options2.put("Humira", Arrays.asList(protocols));
        options2.put("Kineret", Arrays.asList(protocols));
        options2.put("Orencia", Arrays.asList(protocols));
        options2.put("Prolia or Xgeva", Arrays.asList(protocols));
        options2.put("Raptiva", Arrays.asList(protocols));
        options2.put("Remicade", Arrays.asList(protocols));
        options2.put("Rituxan", Arrays.asList(protocols));
        options2.put("Simponi", Arrays.asList(protocols));
        options2.put("Stelara", Arrays.asList(protocols));
        options2.put("Taltz", Arrays.asList(protocols));
        options2.put("Tysabri", Arrays.asList(protocols));
        for (Map.Entry<String, List<String>> entry : options2.entrySet()) {
            System.out.println(entry.getKey());
            biologicMedicationsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7016", (String[]) entry.getValue().toArray())
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

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch(site.dispo);
    }
}

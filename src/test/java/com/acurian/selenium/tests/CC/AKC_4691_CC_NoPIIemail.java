package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ADG_4357.WithType1DiabetesPageCC;
import com.acurian.selenium.pages.CC.DIA_4241.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AKC_4691_CC_NoPIIemail extends BaseTest {

    @Test()
    @Description("Akcea_4691 for CC")
    public void akc_4691_CC_NoPIIemail() {
        Site site = Site.AUT_AKC4691_MR;
        String phoneNumber = "AUTAMS1AKC";
        String studyName = "a study for diabetics";

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
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText2Ver(), dateOfBirthPageCC.titleExpectedAkc_4691, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        DebugPageCC debugPageCC = new DebugPageCC();

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4602", site.activeProtocols)
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        WithType1DiabetesPageCC withType1DiabetesPageCC = new WithType1DiabetesPageCC();
        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());
        withType1DiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);
        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());
        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4603", site.activeProtocols)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC);

         cardiovascularDiseaseThanOthersPageCC = currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new CardiovascularDiseaseThanOthersPageCC());

//        noOfAlcoholicDrinksCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS4631", site.activeProtocols)
//                .back();

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4631", site.activeProtocols)
                .back();

        NoOfAlcoholicDrinksCC noOfAlcoholicDrinksCC = new NoOfAlcoholicDrinksCC();
        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4631", site.activeProtocols)
                .back();

        LastTimeYouTookPageCC lastTimeYouTookPageCC = currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageCC());

        lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(lastTimeYouTookPageCC.titleExpected, site.activeProtocols)
                .back();

        lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 months ago")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(lastTimeYouTookPageCC.titleExpected, site.activeProtocols)
                .back();

        lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 months ago or longer")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(lastTimeYouTookPageCC.titleExpected, site.activeProtocols)
                .back();

        MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageCC());

//        ApartFromMetforminPageCC apartFromMetforminPageCC = currentlyUseMetforminOrInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Medication other than Metformin or Insulin")
//                .clickNextButton(new ApartFromMetforminPageCC());
//        apartFromMetforminPageCC
//                .waitForPageLoad()
//                .back();
//        TakeYourInsulinPageCC takeYourInsulinPageCC = currentlyUseMetforminOrInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
//                .clickOnAnswers("Insulin")
//                .clickNextButton(new TakeYourInsulinPageCC());
//        takeYourInsulinPageCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContains(currentlyUseMetforminOrInsulinPageCC.titleExpected, protocol1)
//                .back();
//        AnyPrescribedMedicationPage anyPrescribedMedicationPage = currentlyUseMetforminOrInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Do not use any prescribed medication to treat diabetes")
//                .clickNextButton(new AnyPrescribedMedicationPage());
//        anyPrescribedMedicationPage
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContains(currentlyUseMetforminOrInsulinPageCC.titleExpected, protocol1)
//                .back();
//        MetforminMedicationsPageCC metforminMedicationsPageCC = currentlyUseMetforminOrInsulinPageCC
//                .waitForPageLoad()
//                .clickOnAnswers("Metformin", "Insulin", "Medication other than Metformin or Insulin")
//                .clickNextButton(new MetforminMedicationsPageCC());
        ApartFromMetforminPageCC apartFromMetforminPageCC = new ApartFromMetforminPageCC();

        HashMap<String, List<String>> options = new HashMap<>();
        options.put("Actoplus Met (metformin and pioglitazone)", Arrays.asList(site.activeProtocols));
        options.put("Avandamet (metformin and rosiglitazone)", Arrays.asList(site.activeProtocols));

        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println("Select answer: " + entry.getKey());
            metforminMedicationsPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(apartFromMetforminPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContains(metforminMedicationsPageCC.titleExpected, (String[]) entry.getValue().toArray())
                    .back();
        }
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(apartFromMetforminPageCC)
                .waitForPageLoad()
                .back();
        metforminMedicationsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")// done for some issue with not checking Metformin
                .clickOnAnswers("Metformin")
                .clickNextButton(apartFromMetforminPageCC);

        CurrentlyTakeInsulinPageCC currentlyTakeInsulinPageCC = new CurrentlyTakeInsulinPageCC();
        options.clear();
        options.put("Actos (pioglitazone)", Arrays.asList(site.activeProtocols));
        options.put("Avandia (rosiglitazone)", Arrays.asList(site.activeProtocols));
        options.put("Duetact (pioglitazone and glimepiride)", Arrays.asList(site.activeProtocols));
        options.put("Oseni (alogliptin and pioglitazone)", Arrays.asList(site.activeProtocols));

        for (Map.Entry<String, List<String>> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            apartFromMetforminPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(currentlyTakeInsulinPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContains(apartFromMetforminPageCC.titleExpected, (String[]) entry.getValue().toArray())
                    .back();
        }
        apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Amaryl (glimepiride)")//changed
                .clickNextButton(currentlyTakeInsulinPageCC);

        TakeYourInsulinPageCC takeYourInsulinPageCC = currentlyTakeInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TakeYourInsulinPageCC());

        takeYourInsulinPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(currentlyTakeInsulinPageCC.titleExpected, site.activeProtocols);

        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = takeYourInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .back();
        BrandsOfInsulinPageCC brandsOfInsulinPageCC = takeYourInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickOnAnswers("Inhaled insulin (Afrezza)")
                .clickNextButton(new BrandsOfInsulinPageCC());
        brandsOfInsulinPageCC
                .waitForPageLoad()
                .back();
        TakeYourInsulinInjectionsPageCC takeYourInsulinInjectionsPageCC = takeYourInsulinPageCC
                .waitForPageLoad()
                .clickOnAnswers("Daily injections")
                .clickOnAnswers("Insulin pump, which delivers insulin continuously")
                .clickNextButton(new TakeYourInsulinInjectionsPageCC());

        takeYourInsulinInjectionsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Only at meal times (this is called bolus insulin)")
                .clickNextButton(brandsOfInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC);

        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .back(brandsOfInsulinPageCC)
                .waitForPageLoad()
                .back(takeYourInsulinInjectionsPageCC)
                .waitForPageLoad()
                .back(takeYourInsulinPageCC)
                .waitForPageLoad()
                .back(currentlyTakeInsulinPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(injectableMedicationsForYourDiabetesPageCC);

        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Adlyxin (lixisenatide)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(injectableMedicationsForYourDiabetesPageCC.titleExpected, site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bydureon or Byetta (exenatide)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(injectableMedicationsForYourDiabetesPageCC.titleExpected, site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Tanzeum (albiglutide)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(injectableMedicationsForYourDiabetesPageCC.titleExpected, site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Trulicity (dulaglutide)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(injectableMedicationsForYourDiabetesPageCC.titleExpected, site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(injectableMedicationsForYourDiabetesPageCC.titleExpected, site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("SymlinPen (pramlintide)")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(injectableMedicationsForYourDiabetesPageCC.titleExpected, site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Another injectable medication not listed above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(injectableMedicationsForYourDiabetesPageCC.titleExpected, site.activeProtocols)
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(noOfAlcoholicDrinksCC);

        FollowingLiverRelatedConditionCC followingLiverRelatedConditionCC = noOfAlcoholicDrinksCC
                .waitForPageLoad()
                .setDrinks("4")
                .clickNextButton(new FollowingLiverRelatedConditionCC());

        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("Alcoholic liver disease")
                .clickNextButton(new FollowingToLoseWeightPageCC());
        followingToLoseWeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(followingLiverRelatedConditionCC.titleExpected, site.activeProtocols)
                .back();
        followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Autoimmune hepatitis, which is not the same as hepatitis caused by a virus")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(followingLiverRelatedConditionCC.titleExpected, site.activeProtocols)
                .back();
        followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hemochromatosis or iron overload (Agent Note: he-mo-chrome-uh-TOE-sus)")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(followingLiverRelatedConditionCC.titleExpected, site.activeProtocols)
                .back();
        followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Liver cancer or hepatocellular carcinoma (Agent Note: hih-pat-oh-CELL-u-lar car-sih-NO-ma)")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(followingLiverRelatedConditionCC.titleExpected, site.activeProtocols)
                .back();
        followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Primary sclerosing cholangitis or primary biliary cirrhosis (Agent Note: scler-OH-sing, ko-lanj-EYE-tis, BILL-ee-air-ee)")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(followingLiverRelatedConditionCC.titleExpected, site.activeProtocols)
                .back();
        followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Wilson's disease")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContains(followingLiverRelatedConditionCC.titleExpected, site.activeProtocols)
                .back();
        followingLiverRelatedConditionCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(followingToLoseWeightPageCC);

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new WeightLossSurgeryPageCC());

        PoundsOrMorePageCC poundsOrMorePageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PoundsOrMorePageCC());
        poundsOrMorePageCC
                .waitForPageLoad()
                .back();
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4616", site.activeProtocols)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")
                .clickNextButton(poundsOrMorePageCC);

        TransitionStatementCC transitionStatementCC = poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoadDYS()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4617", site.activeProtocols)
                .back();

        poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
        transitionStatementCC
                .waitForPageLoad("diabetes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "6", "240")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoadEmailNotProvided()
                .typeEmail("qa.acurian@gmail.com")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
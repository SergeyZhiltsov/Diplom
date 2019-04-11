package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LPS_4442.EitherOfTheFollowingMedicationsCC;
import com.acurian.selenium.pages.CC.PSO_456.DiagnosedWithPsoriasisCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.DERM_4814_OLS;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class DERM_4814_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }


    @Test(enabled = true, dataProvider = "sites", dataProviderClass = DERM_4814_OLS.class)
    @Description("DERM_4814_CC_Test")
    public void derm4814ccTest(final Site site) {
        String phoneNumber = "AUTAMSDERM";
        String[] protocols = site.activeProtocols;
        String studyName = "an eczema (atopic dermatitis) study";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(),dateOfBirthPageCC.getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "400"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        DebugPageCC debugPageCC = new DebugPageCC();

        DiagnosedWithPsoriasisCC diagnosedWithPsoriasisCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithPsoriasisCC());
        diagnosedWithPsoriasisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0009397-QS5802-STUDYQUES", protocols)
                .back();
        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_cc = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());

        HowMuchEczemaYouHaveOnYOurBody_CC howMuchEczemaYouHaveOnYOurBody_cc = howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("2 months or less")
                .clickNextButton(new HowMuchEczemaYouHaveOnYOurBody_CC());
        howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", protocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", protocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", protocols)
                .back();
        howLongHaveYouBeenSufferingFromEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("2 years")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc);

        DollarBillsToCoverEczemaCC dollarBillsToCoverEczemaCC = howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(new DollarBillsToCoverEczemaCC());

        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("0")
                .clickNextButton(new EczemaSymptomsExperienceCC());
        eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019076-QS5834-STUDYQUES", protocols)
                .back();
        dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .back();

        howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .selectFromDropDown("21+")
                .clickNextButton(dollarBillsToCoverEczemaCC)
                .waitForPageLoad()
                .selectFromDropDown("21+")
                .clickNextButton(eczemaSymptomsExperienceCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019076-QS5834-STUDYQUES", protocols)
                .back();
        dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("4")
                .clickNextButton(eczemaSymptomsExperienceCC);

        LevelOfITCHWithEczemaCC levelOfITCHWithEczemaCC = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .clickOnAnswers("Redness")
                .clickNextButton(new LevelOfITCHWithEczemaCC());

        HowManyDaysHasSkinBeenItchyCC howManyDaysHasSkinBeenItchyCC = levelOfITCHWithEczemaCC
                .waitForPageLoad()
                .clickOnAnswer("Mildly itchy (Mildly irritating/Some scratching)")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyCC());

        HaveYouEverTreatedYourEczema_CC haveYouEverTreatedYourEczema_cc = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());

        WhichofthefollowingMedicationsTherapies_CC whichofthefollowingMedicationsTherapies_cc = haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes, within the past year")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_CC());

        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc = whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .back();
        DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_cc = whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickOnAnswers("Dupixent, also known as dupilumab (Agent Note: du-PIX-ent, du-PILL-you-mab)")
                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_CC());
        didYouReceiveAnyTherapiesPastYear_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", protocols)
                .back();
        whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Fasenra, also known as benralizumab (Agent Note: fa-SEN-ra, BEN-ra-LIZ-oo-mab)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", protocols)
                .back();
        whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Nucala, also known as mepolizumab (Agent Note: new-CA-la, MEP-oh-LIZ-oo-mab)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", protocols)
                .back();
        whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Otezla, also known as apremilast (Agent Note: oh-TEZ-la, a-PRE-mi-last)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_cc)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017868-QS5827-STUDYQUES", protocols)
                .back();
        whichofthefollowingMedicationsTherapies_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_cc);

        didYouReceiveAnyTherapiesPastYear_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc);

        EitherOfTheFollowingMedicationsCC eitherOfTheFollowingMedicationsCC = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .clickOnAnswers("Cosentyx (Agent Note: co-SEN-tix)")
                .clickNextButton(new EitherOfTheFollowingMedicationsCC());
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", protocols)
                .back();
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(eitherOfTheFollowingMedicationsCC);

        TransitionStatementCC transitionStatementCC = eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithCurvesKAD("eczema, or atopic dermatitis")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017453-QS5830-STUDYQUES", protocols)
                .back();
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Olumiant (Agent Note: oh-LOO-me-ant)")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithCurvesKAD("eczema, or atopic dermatitis")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017453-QS5830-STUDYQUES", protocols)
                .back();
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Xeljanz (Agent Note: ZEL-jans)")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithCurvesKAD("eczema, or atopic dermatitis")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017453-QS5830-STUDYQUES", protocols)
                .back();
        eitherOfTheFollowingMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurvesKAD("eczema, or atopic dermatitis")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocols)
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "TIA or \"mini-stroke\"",
                        "Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected4)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected5)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "Less than 30 days ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "1 - 3 months ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a heart attack?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced a TIA or mini-stroke?", "More than 1 year ago")
                .clickOnAnswerForSubQuestion("When was the last time that you experienced angina or chest pain that required an overnight hospital stay?",
                        "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);

        KidneyProblemsPage kidneyProblemsPage = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new KidneyProblemsPage());

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocols)
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        WhichOfTheFollowingSkinConditionsDoYouSufferСС whichOfTheFollowingSkinConditionsDoYouSufferСС = followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocols)
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocols)
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferСС);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015145-QS55-STUDYQUES", protocols)
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        SiteSelectionPageCC siteSelectionPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();

        switch (site.dispo) {
            case "1R":
                siteSelectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .assertChildDOBIsNull(env, "4814");
                break;
            case "41C":
                siteSelectionPageCC
                        .clickOnAnswer(site.name)
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "09/09/1980", "US", "Cincinnati, OH",
                                site.zipCode, "qa.acurian@gmail.com", "999 -999-9999", "123456a", site.name, "INCPPDATO303")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .assertChildDOBIsNull(env, "4814");
        }
    }
}
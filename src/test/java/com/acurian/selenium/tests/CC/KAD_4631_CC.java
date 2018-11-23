package com.acurian.selenium.tests.CC;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acurian.selenium.pages.CC.LOWT.WhenWasTheLastTimeYouReceivedHeartProcedure_CC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.GERD.WhichoOfFollowingMedicationsCurrentlyGERD_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.WhichOfTheFollowingMensHealthConditions_OLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC;
import com.acurian.selenium.pages.CC.Derm_4631.HaveYouEverTakenEitherAnyOfFollowingMeds_CC;
import com.acurian.selenium.pages.CC.Derm_4631.HowLongHaveYouBeenSufferingFromEczema_CC;
import com.acurian.selenium.pages.CC.Derm_4631.IfYouUseYourHandToCoverAllOfTheEczema_CC;
import com.acurian.selenium.pages.CC.Derm_4631.OverallHowWellDidTopicalMedicationYouTried_CC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.utils.DataProviderPool;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class KAD_4631_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("Kiniksa Atopic Dermatitis")
    @Description("KAD 4631 for CC")
    public void kad4631_CCTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1KAD";
        String protocol1 = "KPL_716_C001";
//        List<String> protocols = Arrays.asList(protocol1);
        String studyName = "eczema, or atopic dermatitis";
//        String studyIndication = "a Ulcerative Colitis";
        String siteName = "AUT_DERM_4631_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");//was in prod

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
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());


//------------dateOfBirthPageCC----------------
        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleKAD4631, "Title is diff");
        dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC())
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1);
        debugPageCC.back();
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1942")
                .clickNextButton(new IdentificationPageCC());
        identificationPageCC.waitForPageLoad1();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1);
        debugPageCC.back();
        dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(identificationPageCC);


        //------------PII Question------------
        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoad1()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());


        //-----------GenderPageCC-------------
        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());


        //------------Q2:  hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC----
        NonQRtransitionPageCC nonQRtransitionPageCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0009397-QS5802-STUDYQUES", protocol1)
                .back();
        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_CC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());


        //----------Q3:  HowLongHaveYouBeenSufferingFromEczema_CC---------------
        IfYouUseYourHandToCoverAllOfTheEczema_CC ifYouUseYourHandToCoverAllOfTheEczema_CC = howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_CC());
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1)
                .back();
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("3 to less than 6 months")
                .clickNextButton(ifYouUseYourHandToCoverAllOfTheEczema_CC);
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1)
                .back();
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("6 to less than 12 months")
                .clickNextButton(ifYouUseYourHandToCoverAllOfTheEczema_CC);
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1)
                .back();
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("2 years or more")
                .clickNextButton(ifYouUseYourHandToCoverAllOfTheEczema_CC);


        //------------Q4:  IfYouUseYourHandToCoverAllOfTheEczema_CC -------------------  
        HaveYouEverTreatedYourEczema_CC haveYouEverTreatedYourEczema_CC = ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());
        haveYouEverTreatedYourEczema_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1)
                .back();
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("7")
                .clickNextButton(haveYouEverTreatedYourEczema_CC);
        haveYouEverTreatedYourEczema_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1)
                .back();
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("9")
                .clickNextButton(haveYouEverTreatedYourEczema_CC);


        //-----------------Q17: HaveYouEverTreatedYourEczema_CC -------------
        haveYouEverTreatedYourEczema_CC
                .waitForPageLoad();
        //-----------select NO to skip to Q19, otherwise goto Q18
        WhichofthefollowingMedicationsTherapies_CC whichofthefollowingMedicationsTherapies_CC = haveYouEverTreatedYourEczema_CC
                .clickOnAnswer("No")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_CC());
        whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .back();
        OverallHowWellDidTopicalMedicationYouTried_CC overallHowWellDidTopicalMedicationYouTried_CC = haveYouEverTreatedYourEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes, but more than 1 year ago")
                .clickNextButton(new OverallHowWellDidTopicalMedicationYouTried_CC());
        overallHowWellDidTopicalMedicationYouTried_CC
                .waitForPageLoad()
                .back();
        haveYouEverTreatedYourEczema_CC
                .clickOnAnswer("Yes, within the past year")    //final selection
                .clickNextButton(overallHowWellDidTopicalMedicationYouTried_CC);


        //--------------Q18- OverallHowWellDidTopicalMedicationYouTried_CC ----------
        overallHowWellDidTopicalMedicationYouTried_CC
                .waitForPageLoad()
                .clickOnAnswer("My symptoms got a little bit better")
                .clickNextButton(whichofthefollowingMedicationsTherapies_CC);

        //--------------Q19- whichofthefollowingMedicationsTherapies_CC ----------
        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc = whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .back();
        DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_CC = whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)")
                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_CC());

        //--------------Q20- DidYouReceiveAnyTherapiesPastYear_CC ----------
        didYouReceiveAnyTherapiesPastYear_CC
                .waitForPageLoad();
        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC = didYouReceiveAnyTherapiesPastYear_CC
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());

        //-----------------Q22:  AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC--
        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_cc = new HaveYouEverTakenEitherAnyOfFollowingMeds_CC();
        HashMap<String, List<String>> cases = new HashMap<>();
        cases.put("Actemra (Agent Note: ac-TEM-ruh)", Arrays.asList(protocol1));
        cases.put("Benlysta (Agent Note: ben-LIST-uh)", Arrays.asList(protocol1));
        cases.put("Cimzia (Agent Note: SIM-zee-uh)", Arrays.asList(protocol1));
        cases.put("Cosentyx (Agent Note: co-SEN-tix)", Arrays.asList(protocol1));
        cases.put("Enbrel (Agent Note: EN-brel)", Arrays.asList(protocol1));
        cases.put("Entyvio (Agent Note: en-TIV-ee-oh)", Arrays.asList(protocol1));
        cases.put("Humira (Agent Note: hue-MAIR-uh)", Arrays.asList(protocol1));
        cases.put("Kineret (Agent Note: KIN-er-et)", Arrays.asList(protocol1));
        cases.put("Orencia (Agent Note: oh-REN-see-uh)", Arrays.asList(protocol1));
        cases.put("Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)", Arrays.asList(protocol1));
        cases.put("Raptiva (Agent Note: rap-TEE-vuh)", Arrays.asList(protocol1));
        cases.put("Remicade (Agent Note: REM-ih-cade)", Arrays.asList(protocol1));
        cases.put("Rituxan (Agent Note: rih-TUX-an)", Arrays.asList(protocol1));
        cases.put("Simponi (Agent Note: SIM-po-nee)", Arrays.asList(protocol1));
        cases.put("Stelara (Agent Note: ste-LAHR-uh)", Arrays.asList(protocol1));
        cases.put("Taltz (Agent Note: TALTS)", Arrays.asList(protocol1));
        cases.put("Tysabri (Agent Note: tie-SAB-ree)", Arrays.asList(protocol1));
        for (Map.Entry<String, List<String>> entry : cases.entrySet()) {
            areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                    .waitForPageLoadKAD()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_cc)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", (String[]) entry.getValue().toArray())
                    .back();
        }

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_cc);


        //------------Q23- HaveYouEverTakenEitherAnyOfFollowingMeds ----------------
        TransitionStatementCC transitionStatementCC = haveYouEverTakenEitherAnyOfFollowingMeds_cc
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurvesKAD(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancer());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancer
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1)
                .back();
        whenDiagnosedWithCancer
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        LastTimeYouExperiencedHeartAttack lastTimeYouExperiencedHeartAttack = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new LastTimeYouExperiencedHeartAttack());

        HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC haveYouUndergoneAnyOfFollowingHeartRelatedProcCC = lastTimeYouExperiencedHeartAttack
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HaveYouUndergoneAnyOfFollowingHeartRelatedProcCC());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back();

        lastTimeYouExperiencedHeartAttack
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back(lastTimeYouExperiencedHeartAttack)
                .waitForPageLoad()
                .back();

        LastTimeYouExperiencedStroke lastTimeYouExperiencedStroke = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new LastTimeYouExperiencedStroke());

        lastTimeYouExperiencedStroke
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back();

        lastTimeYouExperiencedStroke
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back(lastTimeYouExperiencedStroke)
                .waitForPageLoad()
                .back();

        LastTimeYouExperiencedTIAorMinistroke lastTimeYouExperiencedTIAorMinistroke = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(new LastTimeYouExperiencedTIAorMinistroke());

        lastTimeYouExperiencedTIAorMinistroke
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back();

        lastTimeYouExperiencedTIAorMinistroke
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back(lastTimeYouExperiencedTIAorMinistroke)
                .waitForPageLoad()
                .back();

        LastTimeYouExperiencedAngina lastTimeYouExperiencedAngina = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina (heart-related chest pain) that required an overnight hospital stay")
                .clickNextButton(new LastTimeYouExperiencedAngina());

        lastTimeYouExperiencedAngina
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back();

        lastTimeYouExperiencedAngina
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1)
                .back();

        KidneyProblemsPage kidneyProblemsPage = lastTimeYouExperiencedAngina
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
                .clickNextButton(new WhenWasTheLastTimeYouReceivedHeartProcedure_CC())
                .waitForPageLoad()
                .back(haveYouUndergoneAnyOfFollowingHeartRelatedProcCC)
                .waitForPageLoad()
                .back(lastTimeYouExperiencedAngina)
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back(kidneyProblemsPage)
                .waitForPageLoad()
                .back();

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());

        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocol1)
                .back(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .back();

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1)
                .back();

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1)
                .back();

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageCC());

        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("an eczema (atopic dermatitis) study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}

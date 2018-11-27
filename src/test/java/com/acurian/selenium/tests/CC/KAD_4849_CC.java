package com.acurian.selenium.tests.CC;

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
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.LPS_4442.WhenWereYouDiagnosedOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.*;

public class KAD_4849_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = true)
    @TestCaseId("Kiniksa Atopic Dermatitis")
    @Description("KAD 4849 for CC")

    public void kad4849_CC_Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1KAD";
        String protocol1 = "ANB020_005";
        String studyName = "eczema, or atopic dermatitis";
        String siteName = "AUT_DERM_4849_Site";
        String zipCode = "19901";
        DebugPageCC debugPageCC = new DebugPageCC();

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
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1)
                .back();
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1942")
                .clickNextButton(new IdentificationPageCC());

        identificationPageCC
                .waitForPageLoad1()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1)
                .back();
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
                .clickNextButton(ifYouUseYourHandToCoverAllOfTheEczema_CC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1)
                .back();

        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("6 to less than 12 months")
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
                .selectFromDropDown("5")
                .clickNextButton(haveYouEverTreatedYourEczema_CC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1)
                .back();

        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("9")
                .clickNextButton(haveYouEverTreatedYourEczema_CC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1)
                .back();

        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("10")
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
                .clickOnAnswer("Yes, within the past year")    //final selection
                .clickNextButton(new OverallHowWellDidTopicalMedicationYouTried_CC());


//--------------Q18- OverallHowWellDidTopicalMedicationYouTried_CC ----------
        overallHowWellDidTopicalMedicationYouTried_CC
                .waitForPageLoad()
                .clickOnAnswer("My symptoms went away completely")
                .clickNextButton(whichofthefollowingMedicationsTherapies_CC);


//--------------Q19- whichofthefollowingMedicationsTherapies_CC ----------
        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMedsCc = whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());
        areYouCurrentlyReceivingRegularDosesOfBiologicMedsCc
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017871-QS5829-STUDYQUES", protocol1)
                .back();

        DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_CC = whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("Azasan or Imuran, also known as azathioprine (Agent Note: AY-zuh-san, IM-you-ran, ay-zuh-THI-o-prin)")
                .clickNextButton(new DidYouReceiveAnyTherapiesPastYear_CC());


//--------------Q20- DidYouReceiveAnyTherapiesPastYear_CC ----------
        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC = didYouReceiveAnyTherapiesPastYear_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017871-QS5829-STUDYQUES", protocol1)
                .back();

        didYouReceiveAnyTherapiesPastYear_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC);


        //-----------------Q22:  AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC--
        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC = new HaveYouEverTakenEitherAnyOfFollowingMeds_CC();
        //add more protocols if needed
        LinkedHashMap<String, List<String>> medications = new LinkedHashMap<>();
        medications.put("Actemra (Agent Note: ac-TEM-ruh)", Arrays.asList(protocol1));
        medications.put("Benlysta (Agent Note: ben-LIST-uh)", Arrays.asList(protocol1));
        medications.put("Cimzia (Agent Note: SIM-zee-uh)", Arrays.asList(protocol1));
        medications.put("Cosentyx (Agent Note: co-SEN-tix)", Arrays.asList(protocol1));
        medications.put("Enbrel (Agent Note: EN-brel)", Arrays.asList(protocol1));
        medications.put("Entyvio (Agent Note: en-TIV-ee-oh)", Arrays.asList(protocol1));
        medications.put("Humira (Agent Note: hue-MAIR-uh)", Arrays.asList(protocol1));
        medications.put("Kineret (Agent Note: KIN-er-et)", Arrays.asList(protocol1));
        medications.put("Orencia (Agent Note: oh-REN-see-uh)", Arrays.asList(protocol1));
        medications.put("Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)", Arrays.asList(protocol1));
        medications.put("Raptiva (Agent Note: rap-TEE-vuh)", Arrays.asList(protocol1));
        medications.put("Remicade (Agent Note: REM-ih-cade)", Arrays.asList(protocol1));
        medications.put("Rituxan (Agent Note: rih-TUX-an)", Arrays.asList(protocol1));
        medications.put("Simponi (Agent Note: SIM-po-nee)", Arrays.asList(protocol1));
        medications.put("Stelara (Agent Note: ste-LAHR-uh)", Arrays.asList(protocol1));
        medications.put("Taltz (Agent Note: TALTS)", Arrays.asList(protocol1));
        medications.put("Tysabri (Agent Note: tie-SAB-ree)", Arrays.asList(protocol1));
        for (Map.Entry<String, List<String>> entry : medications.entrySet()) {
            areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                    .waitForPageLoadKAD()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", (String[]) entry.getValue().toArray())
                    .back();
        }

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC);

        //------------Q23- HaveYouEverTakenEitherAnyOfFollowingMeds ----------------
        TransitionStatementCC transitionStatementCC = haveYouEverTakenEitherAnyOfFollowingMeds_CC
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurvesKAD(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancer());

        KidneyProblemsPage kidneyProblemsPage = whenDiagnosedWithCancer
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new KidneyProblemsPage());

        kidneyProblemsPage
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1)
                .back();

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = whenDiagnosedWithCancer
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(kidneyProblemsPage)
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());

        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
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
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocol1)
                .back();

        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
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
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageCC());

        approximateHeightPageCC
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
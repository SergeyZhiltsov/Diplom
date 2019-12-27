package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.*;
import com.acurian.selenium.pages.CC.PSO_456.HealthcareDiagnosedPsoriasisPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.*;

public class KAD_4849_CC extends BaseTest {

    @Test(enabled = false)
    @Description("KAD 4849 for CC")
    public void kad4849_CC_Test() {
        Site site = Site.AUT_DERM_4849_Site;
        String phoneNumber = "AUTAMS1KAD";
        String studyName = "eczema, or atopic dermatitis";
        String studyNameForTrans = "eczema, or atopic dermatitis";
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //------------dateOfBirthPageCC----------------
        dateOfBirthPageCC
                .waitForPageLoad("an eczema (atopic dermatitis) study", "400");
       // Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "400"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back();
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1942")
                .clickNextButton(new IdentificationPageCC());

        identificationPageCC
                .waitForPageLoad1()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back();
        dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(identificationPageCC);

        //------------PII Question------------
        GenderPageCC genderPageCC = identificationPageCC
                //.waitForPageLoad1()
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        //-----------GenderPageCC-------------
        //HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC = genderPageCC
        genderPageCC
                .waitForPageLoad();
        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        //------------Q2:  hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC----
        //NonQRtransitionPageCC nonQRtransitionPageCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
        HealthcareDiagnosedPsoriasisPageCC healthcareDiagnosedPsoriasisPageCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HealthcareDiagnosedPsoriasisPageCC());

        healthcareDiagnosedPsoriasisPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0009397-QS5802-STUDYQUES", site.activeProtocols)
                .back();

        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_CC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());


        //----------Q3:  HowLongHaveYouBeenSufferingFromEczema_CC---------------
        HowMuchEczemaYouHaveOnYOurBody_CC howMuchEczemaYouHaveOnYOurBody_cc = new HowMuchEczemaYouHaveOnYOurBody_CC();
        List<String> disqualifyQ3 = new LinkedList();
        disqualifyQ3.add("2 months or less"); //Disqualify (“Atopic Derm < 3 years”)
        disqualifyQ3.add("3 - 6 months");
        for(String answer: disqualifyQ3)
        {
            System.out.println(answer);
            howLongHaveYouBeenSufferingFromEczema_CC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0019081-QS5831-STUDYQUES", site.activeProtocols)
                    .back();
        }
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("1 year")
                .clickNextButton(howMuchEczemaYouHaveOnYOurBody_cc);

        DollarBillsToCoverEczemaCC dollarBillsToCoverEczemaCC = howMuchEczemaYouHaveOnYOurBody_cc
                .waitForPageLoad()
                .selectFromDropDown("6")
                .clickNextButton(new DollarBillsToCoverEczemaCC());

        HowManyDaysHasSkinBeenItchyCC howManyDaysHasSkinBeenItchyCC = dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("6")
                .clickNextButton(new HowManyDaysHasSkinBeenItchyCC());

        howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019076-QS5834-STUDYQUES", site.activeProtocols)
                .back();

        dollarBillsToCoverEczemaCC
                .waitForPageLoad()
                .selectFromDropDown("11")
                .clickNextButton(howManyDaysHasSkinBeenItchyCC);

        EczemaSymptomsExperienceCC eczemaSymptomsExperienceCC = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("My skin is never itchy")
                .clickNextButton(new EczemaSymptomsExperienceCC());

        eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .back();

        RateAverageItchinessEczemaPageCC rateAverageItchinessEczemaPageCC = howManyDaysHasSkinBeenItchyCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days")
                .clickNextButton(new RateAverageItchinessEczemaPageCC());
        rateAverageItchinessEczemaPageCC
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(eczemaSymptomsExperienceCC);

        //Q21
        HaveYouEverTreatedYourEczema_CC haveYouEverTreatedYourEczema_cc = eczemaSymptomsExperienceCC
                .waitForPageLoad()
                .clickOnAnswers("Redness",
                        "Swelling",
                        "Oozing/Crusting",
                        "Dryness",
                        "Scratch marks",
                        "Skin thickening")
                .clickNextButton(new HaveYouEverTreatedYourEczema_CC());
        //Q22
        WhichofthefollowingMedicationsTherapies_CC whichofthefollowingMedicationsTherapies_CC = haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes, within the past year")
                .clickNextButton(new WhichofthefollowingMedicationsTherapies_CC());

        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc = whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic")
                .back(whichofthefollowingMedicationsTherapies_CC)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_cc);
        haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("Yes, but more than 1 year ago")
                .clickNextButton(whichofthefollowingMedicationsTherapies_CC)
                .waitForPageLoad()
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc)
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkIsNoProtocolsForQuestion("Ghost Question - Atopic Derm Treatment History Logic")
                .back(whichofthefollowingMedicationsTherapies_CC)
                .waitForPageLoad()
                .back(haveYouEverTreatedYourEczema_cc);
        haveYouEverTreatedYourEczema_cc
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(whichofthefollowingMedicationsTherapies_CC)
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc)
                .waitForPageLoadKAD()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017871-QS5829-STUDYQUES", site.activeProtocols)
                .back(whichofthefollowingMedicationsTherapies_CC);

        DidYouReceiveAnyTherapiesPastYear_CC didYouReceiveAnyTherapiesPastYear_CC = new DidYouReceiveAnyTherapiesPastYear_CC();
        HashMap<String, List<String>> disqualifyQ23 = new HashMap<>();
        disqualifyQ23.put("Fasenra, also known as benralizumab (Agent Note: fa-SEN-ra, BEN-ra-LIZ-oo-mab)", Arrays.asList(site.activeProtocols));
        disqualifyQ23.put("Nucala, also known as mepolizumab (Agent Note: new-CA-la, MEP-oh-LIZ-oo-mab)", Arrays.asList(site.activeProtocols));
        disqualifyQ23.put("Otezla, also known as apremilast (Agent Note: oh-TEZ-la, a-PRE-mi-last)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ23.entrySet()) {
            System.out.println(entry.getKey());
            whichofthefollowingMedicationsTherapies_CC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(didYouReceiveAnyTherapiesPastYear_CC)
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc)
                    .waitForPageLoadKAD()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0017871-QS5829-STUDYQUES", site.activeProtocols)
                    .back(didYouReceiveAnyTherapiesPastYear_CC)
                    .waitForPageLoad()
                    .back(whichofthefollowingMedicationsTherapies_CC);
        }

        whichofthefollowingMedicationsTherapies_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Dupixent, also known as dupilumab (Agent Note: du-PIX-ent, du-PILL-you-mab)")
                .clickNextButton(didYouReceiveAnyTherapiesPastYear_CC);

        didYouReceiveAnyTherapiesPastYear_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc);

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

        HaveYouEverTakenEitherAnyOfFollowingMeds_CC haveYouEverTakenEitherAnyOfFollowingMeds_CC = new HaveYouEverTakenEitherAnyOfFollowingMeds_CC();
        for (String medication : medications) {
            areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                    .waitForPageLoadKAD()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(medication)
                    .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", site.activeProtocols)
                    .back();
        }

        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_cc
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_CC);

        //------------Q23- HaveYouEverTakenEitherAnyOfFollowingMeds ----------------
        TransitionStatementCC transitionStatementCC = haveYouEverTakenEitherAnyOfFollowingMeds_CC
                .waitForPageLoad()
                .clickOnAnswers("Jakafi (Agent Note: JAK-uh-fie)")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurvesKAD(studyNameForTrans)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", site.activeProtocols)
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
                .back();

        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
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
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
                .back();

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
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
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
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
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
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
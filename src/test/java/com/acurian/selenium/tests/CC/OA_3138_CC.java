package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.OA_3138.AreYouCurrentlyTakingCC;
import com.acurian.selenium.pages.CC.OA_3138.HowManyTotalDaysCC;
import com.acurian.selenium.pages.CC.OA_3138.MarijuanaOrCannabisCC;
import com.acurian.selenium.pages.CC.OA_3138.ParticipatedInAnotherClinicalStudyCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class OA_3138_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("OA_3138_OLS test CC")
    public void OA_3138_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1OA1";
        String protocol1 = "R475_PN_1523";
        String studyName = "osteoarthritis";
        String studyName1 = "an osteoarthritis study";
        String siteName = "AUT_OA_3138_Site";
        String zipCode = "99546";

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
                .typePhoneNumber(phoneNumberOA)
                .clickPopupPhoneNumber(phoneNumberOA)
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedOA3138, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Yes")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("99546")
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritisCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisCC());

        WhereYouHaveArthritisCC whereYouHaveArthritisCC = whatKindOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritisCC());

        TransitionStatementCC transitionStatementCC = whereYouHaveArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Wrists or ankles")
                .clickNextButton(new TransitionStatementCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        transitionStatementCC
                .waitForPageLoad(studyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004964-QS1304-STUDYQUES", protocol1)
                .back();
        AnyTypeOfMedicationForYourArthritisCC anyTypeOfMedicationForYourArthritisCC = whereYouHaveArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Wrists or ankles")
                .clickOnAnswers("Left Hip")
                .clickNextButton(new AnyTypeOfMedicationForYourArthritisCC());
       

        NSAIDMedicationsForArthritisPainCC nSAIDMedicationsForArthritisPainCC = anyTypeOfMedicationForYourArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedicationsForArthritisPainCC());

        nSAIDMedicationsForArthritisPainCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsEquals("The following medications are called NSAIDs. They may be available over-the-counter or with a prescr...", protocol1);
        debugPageCC.back();
        AreYouCurrentlyTakingCC areYouCurrentlyTakingCC = nSAIDMedicationsForArthritisPainCC
                .waitForPageLoad()
                .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new AreYouCurrentlyTakingCC());

        HowManyTotalDaysCC howManyTotalDaysCC = areYouCurrentlyTakingCC
                .waitForPageLoad()
                .clickOnAnswers("Yes")
                .clickNextButton(new HowManyTotalDaysCC());

        MedicationsContainingAcetaminophenCC medicationsContainingAcetaminophenCC = howManyTotalDaysCC
                .waitForPageLoad()
                .clickOnAnswers("2 days")
                .clickNextButton(new MedicationsContainingAcetaminophenCC());

        HaveYouEverTakenPrescriptionPainCC haveYouEverTakenPrescriptionPainCC = medicationsContainingAcetaminophenCC
                .waitForPageLoad()
                .clickOnAnswer("No, I have never taken a medication containing acetaminophen for my arthritis pain")
                .clickNextButton(new HaveYouEverTakenPrescriptionPainCC());

        haveYouEverTakenPrescriptionPainCC
                .waitForPageLoad()
                .clickOnAnswers("Codeine")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad(studyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0006674-QS1323-STUDYQUES", protocol1)
                .back();
        MarijuanaOrCannabisCC marijuanaOrCannabisCC = haveYouEverTakenPrescriptionPainCC
                .waitForPageLoad()
                .clickOnAnswers("Codeine")
                .clickOnAnswers("Tylenol #3 or Tylenol #4 (acetaminophen with codeine)")
                .clickNextButton(new MarijuanaOrCannabisCC());
        

        LongTermSteroidPrescriptionCC longTermSteroidPrescriptionCC = marijuanaOrCannabisCC
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new LongTermSteroidPrescriptionCC());
        

        JointReplacementCC jointReplacementCC = longTermSteroidPrescriptionCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(new JointReplacementCC());

        DevicesInYourBodyCC devicesInYourBodyCC = jointReplacementCC
                .waitForPageLoad()
                .clickOnAnswers("Yes, my doctor and I have discussed it, but my doctor said I don't need joint replacement at this time")
                .clickNextButton(new DevicesInYourBodyCC());

        ParticipatedInAnotherClinicalStudyCC participatedInAnotherClinicalStudyCC = devicesInYourBodyCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(new ParticipatedInAnotherClinicalStudyCC());

        CarpalTunnelSyndromeCC carpalTunnelSyndromeCC = participatedInAnotherClinicalStudyCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CarpalTunnelSyndromeCC());

        carpalTunnelSyndromeCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //-------------------New GENERAL HEALTH---------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                //----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                //----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
                //----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env); //In CC, it generates 1R dispo. and Radiant accepts CC with 1R dispo (child_pid)
                //.getAnomalyDbToLog(env); //Anomoly NOT applicable for Call center
    }
}
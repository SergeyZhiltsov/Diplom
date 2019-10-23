package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.OA_3138.AreYouCurrentlyTakingCC;
import com.acurian.selenium.pages.CC.OA_3138.HowManyTotalDaysCC;
import com.acurian.selenium.pages.CC.closes.DoesNotGivePermissionToProceedClosePageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose1PageCC;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer1;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer4;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class OA_4109CC extends BaseTest {

    @Test()
    public void OA_4109_cc() {
        Site site = Site.AUT_OA_4109_Site;
        String phoneNumber = "AUTAMS1OA1";
        List<String> protocols = Arrays.asList("R475_OA_1611", "R475_OA_1688");
        String protocol1 = "R475_OA_1611";
        String protocol2 = "R475_OA_1688";
        String studyName = "osteoarthritis";
        String studyName1 = "an osteoarthritis study";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
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
                .clickOnAnswer("Call Back")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                .getExpectedModifiedTitle("an osteoarthritis study", "850"), "Title is diff");


        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());
        ZipCodePageCC zipCodePageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("99546")
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
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

        AnyTypeOfMedicationForYourArthritisCC anyTypeOfMedicationForYourArthritisCC = whereYouHaveArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Left Knee")
                .clickNextButton(new AnyTypeOfMedicationForYourArthritisCC());

        NSAIDMedicationsForArthritisPainCC nSAIDMedicationsForArthritisPainCC = anyTypeOfMedicationForYourArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedicationsForArthritisPainCC());

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
                .clickOnAnswers("5 days")
                .clickNextButton(new MedicationsContainingAcetaminophenCC());

        HaveYouEverTakenPrescriptionPainCC haveYouEverTakenPrescriptionPainCC = medicationsContainingAcetaminophenCC
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new HaveYouEverTakenPrescriptionPainCC());


        HasYourDoctorEverPrescribedOpioidNarcotic_CC hasYourDoctorEverPrescribedOpioidNarcotic_CC = haveYouEverTakenPrescriptionPainCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_CC());


        AreYouCurrentlyOnPageCC areYouCurrentlyOnPageCC = hasYourDoctorEverPrescribedOpioidNarcotic_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPageCC());


        areYouCurrentlyOnPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoad(studyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4513", protocol1)
                .back();
        HaveYouEverHadKneeReplacementSurgery_CC haveYouEverHadKneeReplacementSurgery_CC = areYouCurrentlyOnPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgery_CC());


        //-----------HaveYouEverHadKneeReplacementSurgery_CC--------------------
        haveYouEverHadKneeReplacementSurgery_CC
                .waitForPageLoad();
        HaveYouEverReceivedInjectionIntoYourKnee_CC haveYouEverReceivedInjectionIntoYourKnee_CC = haveYouEverHadKneeReplacementSurgery_CC
                .clickOnAnswer("Yes, both knees have been replaced")
                .clickOnAnswer("Yes, one knee has been replaced")
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverReceivedInjectionIntoYourKnee_CC());


        //-----------HaveYouEverReceivedInjectionIntoYourKnee_CC--------------------
        haveYouEverReceivedInjectionIntoYourKnee_CC
                .waitForPageLoad();
        HaveYouReceivedKneeInjection_CC haveYouReceivedKneeInjection_CC = haveYouEverReceivedInjectionIntoYourKnee_CC
                .clickOnAnswers("Yes, a corticosteroid or \"steroid\" injection")
                .clickOnAnswers("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
                .clickNextButton(new HaveYouReceivedKneeInjection_CC());


        //-------------------------HaveYouReceivedKneeInjection_CC---------------
        haveYouReceivedKneeInjection_CC
                .waitForPageLoad();
        DevicesInYourBodyCC devicesInYourBodyCC = haveYouReceivedKneeInjection_CC
                .clickOnAnswer("Yes")
                .clickOnAnswer("No")
                .clickNextButton(new DevicesInYourBodyCC());

        //-------------------------FollowingDevicesInYourBody---------------
        devicesInYourBodyCC
                .waitForPageLoad()
                .clickOnAnswers("Aneurysm clip")
                .clickOnAnswers("Artificial heart valve")
                .clickOnAnswers("Cochlear implant")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoad(studyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4514", protocol1)
                .back();
        CarpalTunnelSyndromeCC carpalTunnelSyndromeCC = devicesInYourBodyCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CarpalTunnelSyndromeCC());


        AreYouCurrentlyReceivingWorkersPageCC areYouCurrentlyReceivingWorkersPageCC = carpalTunnelSyndromeCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageCC());


        TransitionStatementCC transitionStatementCC = areYouCurrentlyReceivingWorkersPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //-------------------New GENERAL HEALTH---------------------------
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        //----------Q23 - Do any of the following additional diagnoses apply to you?--------
        //Q24: QS59
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ26 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis", "Drug or alcohol abuse within the past year", "Hepatitis B", "Hepatitis C",
                "HIV or AIDS");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ26pt2 = Arrays.asList("Kidney disease requiring dialysis", "Multiple sclerosis (MS)",
                "Neuropathy (nerve damage due to diabetes or another condition)", "Seizure disorder such as epilepsy");
        for (String answer : disqualifyQ26pt2) {
            System.out.println("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                //----------SITE Selection Page--------------------
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new Regular_WarmTransfer1())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new Regular_WarmTransfer4())
                .waitForPageLoad()
                .clickOnAnswer("Successful transfer made to site")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
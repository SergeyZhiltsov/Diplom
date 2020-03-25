package com.acurian.selenium.OLS;

import com.acurian.selenium.blinx.Crohns_4818_OLSBlinx;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAIDOLS;
import com.acurian.selenium.pages.OLS.Obesity_4605.ExperienceExcessiveHungerOrIncreasedAppetiteOLS;
import com.acurian.selenium.pages.OLS.PsoriaticArthritis.PsoriaticArthritisConditionPageOLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.List;

public class OA_5044_OLS_S extends BaseTest {

    private static Logger Log = LogManager.getLogger(OA_5044_OLS_S.class.getName());

    @Test(enabled = false)
    @Description("OA_5044_OLS_S")
    public void oA_5044_OLS_S() {
        Site site = Site.AUT_OA_5044_S;
        final String phoneNumber = "AUTAMS1OA1";
        final String studyName = "an osteoarthritis";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad("an osteoarthritis study", "850");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                        .getExpectedModifiedTitle("an osteoarthritis study", "850"),
//                "Title is diff");

        //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("an osteoarthritis study", "850")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritis());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                doYouSufferFromArthritis
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4502", site.activeProtocols)
                .back();

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4503", site.activeProtocols)
                .back();

        PsoriaticArthritisConditionPageOLS psoriaticArthritisConditionPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickOnAnswers("Psoriatic Arthritis")
                .clickNextButton(new PsoriaticArthritisConditionPageOLS());
        psoriaticArthritisConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4503", site.activeProtocols)
                .back();

        WhereYouHaveArthritisOLS whereYouHaveArthritisOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriatic Arthritis")
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritisOLS());

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Hands or feet")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", site.activeProtocols)
                .back();

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Hands or feet")
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", site.activeProtocols)
                .back();

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickOnAnswer("Wrists or ankles")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", site.activeProtocols)
                .back();

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Wrists or ankles")
                .clickOnAnswer("Other")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", site.activeProtocols)
                .back();

        AnyMedicationForYourArthritisOLS anyMedicationForYourArthritisOLS = whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Other")
                .clickOnAnswer("Left Hip")
                .clickOnAnswer("Right Hip")
                .clickNextButton(new AnyMedicationForYourArthritisOLS());

        NSAIDMedicationOLS nSAIDMedicationOLS = anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain")
                .clickNextButton(new NSAIDMedicationOLS());

        nSAIDMedicationOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4520", site.activeProtocols)
                .back();

        anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days per week or less")
                .clickNextButton(nSAIDMedicationOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4520", site.activeProtocols)
                .back();

        anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(nSAIDMedicationOLS);

        nSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4505", site.activeProtocols)
                .back();

        CurrentlyTakinnFollowingNSAIDMedicationOLS currentlyTakinnFollowingNSAIDMedicationOLS = nSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new CurrentlyTakinnFollowingNSAIDMedicationOLS());

        TreatedYourArthritisPainAcetaminophenOLS treatedYourArthritisPainAcetaminophenOLS = currentlyTakinnFollowingNSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophenOLS());

        treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .back();

        HowManyTotalDaysYouTakeFollowingNSAIDOLS howManyTotalDaysYouTakeFollowingNSAIDOLS = currentlyTakinnFollowingNSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyTotalDaysYouTakeFollowingNSAIDOLS());

        howManyTotalDaysYouTakeFollowingNSAIDOLS
                .waitForPageLoad()
                .clickOnAnswer("2 days")
                .clickNextButton(treatedYourArthritisPainAcetaminophenOLS);

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());


        HasYourDoctorEverPrescribedOpioidNarcoticOLS hasYourDoctorEverPrescribedOpioidNarcotic_OLS = prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcoticOLS());


        hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("No, my doctor never offered me a prescription for opioids or narcotics for pain")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4511", site.activeProtocols)
                .back();

        AreYouCurrentlyOnPageOLS areYouCurrentlyOnPageOLS = hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPageOLS());

        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for arthritis")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4513", site.activeProtocols)
                .back();

        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for another chronic condition")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4513", site.activeProtocols)
                .back();

        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4513", site.activeProtocols)
                .back();

        HaveYouEverHadKneeReplacementSurgeryOLS haveYouEverHadKneeReplacementSurgery_OLS = areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgeryOLS());


        //-----------HaveYouEverHadKneeReplacementSurgeryOLS--------------------
        HaveYouEverReceivedInjectionIntoYourKneeOLS haveYouEverReceivedInjectionIntoYourKnee_OLS = haveYouEverHadKneeReplacementSurgery_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverReceivedInjectionIntoYourKneeOLS());


        //-----------HaveYouEverReceivedInjectionIntoYourKneeOLS--------------------
        FollowingDevicesInYourBodyOLS followingDevicesInYourBodyOLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
                .waitForPageLoad()
                .clickOnAnswer("I have never received a knee injection for my arthritis pain")
                .clickNextButton(new FollowingDevicesInYourBodyOLS());

        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .back();

        HaveYouReceivedKneeInjectionWithinPast3MonthsOLS haveYouReceivedKneeInjection_WithinPast3Months_OLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, a corticosteroid or \"steroid\" injection")
                .clickNextButton(new HaveYouReceivedKneeInjectionWithinPast3MonthsOLS());


        //-------------------------HaveYouReceivedKneeInjectionWithinPast3MonthsOLS---------------
        haveYouReceivedKneeInjection_WithinPast3Months_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(followingDevicesInYourBodyOLS);


        //---------------------------FollowingDevicesInYourBodyOLS--------------------
        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("A pacemaker")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4514", site.activeProtocols)
                .back();

        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickOnAnswer("Aneurysm clip")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4514", site.activeProtocols)
                .back();

        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickOnAnswer("Artificial heart valve")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4514", site.activeProtocols)
                .back();

        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome = followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());


        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        WithinThePast6MonthsHaveYouHadNumbnessOLS withinThePast6MonthsHaveYouHadNumbness_ols = diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WithinThePast6MonthsHaveYouHadNumbnessOLS());

        AreYouCurrentlyReceivingWorkersPageOLS areYouCurrentlyReceivingWorkersPage_OLS = withinThePast6MonthsHaveYouHadNumbness_ols
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageOLS());

        areYouCurrentlyReceivingWorkersPage_OLS
                .waitForPageLoad2()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4516", site.activeProtocols)
                .back(withinThePast6MonthsHaveYouHadNumbness_ols)
                .waitForPageLoad()
                .back();

        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(areYouCurrentlyReceivingWorkersPage_OLS);


        //------------------AreYouCurrentlyReceivingWorkersPageOLS-------------
        areYouCurrentlyReceivingWorkersPage_OLS
                .waitForPageLoad2()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        //----------*******NEW GENERAL HEALTH Questions**************************----------
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols
                .waitForPageLoad()
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected4);
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "7 - 12 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());

        whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS);

        whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Fibromyalgia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ26 = Arrays.asList("Drug or alcohol abuse within the past year", "Hepatitis B",
                "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ26) {
            Log.info("Select answer for Q26: " + answer);
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
                    .clickOnAnswers("Neuropathy (nerve damage due to diabetes or another condition)")
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        //----------ProvideHeight-Weight Page--------------------
        ExperienceExcessiveHungerOrIncreasedAppetiteOLS experienceExcessiveHungerOrIncreasedAppetiteOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new ExperienceExcessiveHungerOrIncreasedAppetiteOLS());
        experienceExcessiveHungerOrIncreasedAppetiteOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setLbs("150")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
//                .clickNextButton(new IdentificationPageOLS())
        //----------PII (IdentificationPageOLS) Page--------------------
        AboutHealthPageOLS aboutHealthPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad2()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .getAnomalyDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}

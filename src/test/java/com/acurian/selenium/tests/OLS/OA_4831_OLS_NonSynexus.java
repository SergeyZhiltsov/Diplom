package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.HowManyTotalDaysYouTakeFollowingNSAID_OLS;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.RA_2821.WhenYouDiagnosedWithRaPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.AgeUnqualifiedClose_OLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class OA_4831_OLS_NonSynexus extends BaseTest {

    @Test()
    public void OA_4831_OLS_NonSynexus_Script() {
        String phoneNumberDY = "AUTAMS1OA1";
        String zipCode = "19901";
        String studyName = "an osteoarthritis";
        String siteName = "AUT_OA_4831_site"; //Synexus Site - AUT_OA_4831_Syn
        String protocol1 = "R475_PN_1523_B";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumberDY)
                .waitForPageLoad();

        //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                .setDate("09092002")
                .clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", protocol1)
                .back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritis());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4502", protocol1)
                .back();

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhenYouDiagnosedWithRaPageOLS whenYouDiagnosedWithRaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageOLS());

        whenYouDiagnosedWithRaPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4503", protocol1)
                .back();

        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickOnAnswers("Psoriatic Arthritis")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4503", protocol1)
                .back();

        WhereYouHaveArthritis_OLS whereYouHaveArthritisOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriatic Arthritis")
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritis_OLS());

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Hands or feet")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", protocol1)
                .back();

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Hands or feet")
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", protocol1)
                .back();

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickOnAnswer("Wrists or ankles")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", protocol1)
                .back();

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Wrists or ankles")
                .clickOnAnswer("Other")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", protocol1)
                .back();

        AnyMedicationForYourArthritis_OLS anyMedicationForYourArthritisOLS = whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Other")
                .clickOnAnswer("Left Hip")
                .clickOnAnswer("Right Hip")
                .clickNextButton(new AnyMedicationForYourArthritis_OLS());

        NSAIDMedication_OLS nSAIDMedicationOLS = anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain")
                .clickNextButton(new NSAIDMedication_OLS());

        nSAIDMedicationOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4520", protocol1)
                .back();

        anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days per week or less")
                .clickNextButton(nSAIDMedicationOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4520", protocol1)
                .back();

        anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(nSAIDMedicationOLS);

        nSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4505", protocol1)
                .back();

        CurrentlyTakinnFollowingNSAIDMedication_OLS currentlyTakinnFollowingNSAIDMedicationOLS = nSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new CurrentlyTakinnFollowingNSAIDMedication_OLS());

        TreatedYourArthritisPainAcetaminophen_OLS treatedYourArthritisPainAcetaminophenOLS = currentlyTakinnFollowingNSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TreatedYourArthritisPainAcetaminophen_OLS());

        treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .back();

        HowManyTotalDaysYouTakeFollowingNSAID_OLS howManyTotalDaysYouTakeFollowingNSAIDOLS = currentlyTakinnFollowingNSAIDMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyTotalDaysYouTakeFollowingNSAID_OLS());

        howManyTotalDaysYouTakeFollowingNSAIDOLS
                .waitForPageLoad()
                .clickOnAnswer("2 days")
                .clickNextButton(treatedYourArthritisPainAcetaminophenOLS);

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());


        HasYourDoctorEverPrescribedOpioidNarcotic_OLS hasYourDoctorEverPrescribedOpioidNarcotic_OLS = prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_OLS());


        hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("No, my doctor never offered me a prescription for opioids or narcotics for pain")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4511", protocol1)
                .back();

        AreYouCurrentlyOnPage_OLS areYouCurrentlyOnPageOLS = hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPage_OLS());

        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for arthritis")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4513", protocol1)
                .back();

        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for another chronic condition")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4513", protocol1)
                .back();

        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4513", protocol1)
                .back();

        HaveYouEverHadKneeReplacementSurgery_OLS haveYouEverHadKneeReplacementSurgery_OLS = areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgery_OLS());


        //-----------HaveYouEverHadKneeReplacementSurgery_OLS--------------------
        HaveYouEverReceivedInjectionIntoYourKnee_OLS haveYouEverReceivedInjectionIntoYourKnee_OLS = haveYouEverHadKneeReplacementSurgery_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverReceivedInjectionIntoYourKnee_OLS());


        //-----------HaveYouEverReceivedInjectionIntoYourKnee_OLS--------------------
        FollowingDevicesInYourBody_OLS followingDevicesInYourBodyOLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
                .waitForPageLoad()
                .clickOnAnswer("I have never received a knee injection for my arthritis pain")
                .clickNextButton(new FollowingDevicesInYourBody_OLS());

        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .back();

        HaveYouReceivedKneeInjectionWithinPast3Months_OLS haveYouReceivedKneeInjection_WithinPast3Months_OLS = haveYouEverReceivedInjectionIntoYourKnee_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, a corticosteroid or \"steroid\" injection")
                .clickNextButton(new HaveYouReceivedKneeInjectionWithinPast3Months_OLS());


        //-------------------------HaveYouReceivedKneeInjectionWithinPast3Months_OLS---------------
        haveYouReceivedKneeInjection_WithinPast3Months_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(followingDevicesInYourBodyOLS);


        //---------------------------FollowingDevicesInYourBody_OLS--------------------
        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("A pacemaker")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4514", protocol1)
                .back();

        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickOnAnswer("Aneurysm clip")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4514", protocol1)
                .back();

        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickOnAnswer("Artificial heart valve")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4514", protocol1)
                .back();

        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome = followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());


        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        WithinThePast6MonthsHaveYouHadNumbness_OLS withinThePast6MonthsHaveYouHadNumbness_ols = diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WithinThePast6MonthsHaveYouHadNumbness_OLS());

        AreYouCurrentlyReceivingWorkersPage_OLS areYouCurrentlyReceivingWorkersPage_OLS = withinThePast6MonthsHaveYouHadNumbness_ols
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPage_OLS());

        areYouCurrentlyReceivingWorkersPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4516", protocol1)
                .back(withinThePast6MonthsHaveYouHadNumbness_ols)
                .waitForPageLoad()
                .back();

        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(areYouCurrentlyReceivingWorkersPage_OLS);


        //------------------AreYouCurrentlyReceivingWorkersPage_OLS-------------
        areYouCurrentlyReceivingWorkersPage_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        //----------*******NEW GENERAL HEALTH Questions**************************----------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        aboutHealthPageOLS
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(2000);
        aboutHealthPageOLS
                .pidFromDbToLog(env);
    }
}
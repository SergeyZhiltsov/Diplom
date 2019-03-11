package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA_2821.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RA_2821_OLS extends BaseTest {

    @Test()
    public void ra_2821_OLS() {
        Site site = Site.AUT_RA2821_Site;
        String phoneNumberRA = "AUTAMS1RA1";
        String studyName = "a rheumatoid arthritis (RA)";
        String Siteindicator = "Rheumatoid Arthritis";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumberRA)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText().contains("Let's get started to see if you qualify for a rheumatoid arthritis (RA) study!"), true);
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("10/10/1980")
                .clickNextButton(new ZipCodePageOLS());


        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageOLS());

        DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritis());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(doYouSufferFromArthritis.titleExpected, site.activeProtocols);
        debugPageOLS.back();
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());


        WhenYouDiagnosedWithRaPageOLS whenYouDiagnosedWithRaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageOLS());


        AgeWhenDiagnosedWithRA ageWhenDiagnosedWithRA = whenYouDiagnosedWithRaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(new AgeWhenDiagnosedWithRA());


        HowYourRASymptomsStartedFirstTime howYourRASymptomsStartedFirstTime = ageWhenDiagnosedWithRA
                .waitForPageLoad()
                .setAge("16")
                .clickNextButton(new HowYourRASymptomsStartedFirstTime())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("Approximately how old were you when you were diagnosed with RA?Agent Note: If patient is unsure, sa...", site.activeProtocols); //protocol2
        debugPageOLS.back();
        ageWhenDiagnosedWithRA
                .waitForPageLoad()
                .setAge("28")
                .clickNextButton(new HowYourRASymptomsStartedFirstTime());


        WhatTestsDidYouHave whatTestsDidYouHave = howYourRASymptomsStartedFirstTime
                .waitForPageLoad()
                .clickOnAnswer("Symptoms took several months to develop; the pain built gradually over a period of time")
                .clickNextButton(new WhatTestsDidYouHave());


        AreYouCurrentlyExperiencing areYouCurrentlyExperiencing = whatTestsDidYouHave
                .waitForPageLoad()
                .clickOnAnswers("An x-ray of your affected joints, which included multiple joints such as your hands and feet")
                .clickNextButton(new AreYouCurrentlyExperiencing());


        FollowingJointSymptoms followingJointSymptoms = areYouCurrentlyExperiencing
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingJointSymptoms())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(areYouCurrentlyExperiencing.titleExpected, site.activeProtocols); //protocol2
        debugPageOLS.back();
        areYouCurrentlyExperiencing
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new FollowingJointSymptoms());


        DoYouCurrentlyUseSteroid doYouCurrentlyUseSteroid = followingJointSymptoms
                .waitForPageLoad()
                .clickOnAnswers("Pain or swelling in at least 3 separate joints")
                .clickNextButton(new DoYouCurrentlyUseSteroid());


        InPastDidYouTakeSteroids inPastDidYouTakeSteroids = doYouCurrentlyUseSteroid
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InPastDidYouTakeSteroids());


        CurrentlyTakingMethotrexate currentlyTakingMethotrexate = inPastDidYouTakeSteroids
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyTakingMethotrexate());


        HowLongTakingMethotrexate howLongTakingMethotrexate = currentlyTakingMethotrexate
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am taking methotrexate tablets or pills")
                .clickNextButton(new HowLongTakingMethotrexate());


        MedicationsToTreatYourRA medicationsToTreatYourRA = howLongTakingMethotrexate
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new MedicationsToTreatYourRA())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals(howLongTakingMethotrexate.titleExpected, site.activeProtocols); //protocol2
        debugPageOLS.back();
        howLongTakingMethotrexate
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months")
                .clickNextButton(new MedicationsToTreatYourRA());


        BiologicMedications biologicMedications = medicationsToTreatYourRA
                .waitForPageLoad()
                .clickOnAnswers("Leukeran (chlorambucil)")
                .clickNextButton(new BiologicMedications())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("Are you currently taking any of the following medications to treat your RA?Agent Note: Read medicat...", site.activeProtocols); //protocol2
        debugPageOLS.back();
        medicationsToTreatYourRA
                .waitForPageLoad()
                .clickOnAnswers("Leukeran (chlorambucil)")
                .clickOnAnswers("Plaquenil (hydroxychloroquine)")
                .clickNextButton(new HowLongTakingPlaquenil());


        HowLongTakingPlaquenil howLongTakingPlaquenil = new HowLongTakingPlaquenil();
        howLongTakingPlaquenil
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new BiologicMedications())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsEqualsForQNumber("QS521", site.activeProtocols); //protocol2
        debugPageOLS.back();
        howLongTakingPlaquenil
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months")
                .clickNextButton(new BiologicMedications());


        biologicMedications
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TakenXeljanz())
                .waitForPageLoad()
                .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("Ghost Question - 2821 RA bDMARD protocol logic - (\"bDMARD Exposure\") for M14-465 and M13-549, (\"Biol...", site.activeProtocols); //protocol2
        debugPageOLS.back();
        LastReceivedTysabri lastReceivedTysabri = biologicMedications
                .waitForPageLoad()
                .clickOnAnswers("Tysabri")
                .clickNextButton(new LastReceivedTysabri());


        TakenXeljanz takenXeljanz = lastReceivedTysabri
                .waitForPageLoad()
                .clickOnAnswer("Last received 7 to 11 months ago")
                .clickNextButton(new TakenXeljanz());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = takenXeljanz
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am currently taking it")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsEquals("Xeljanz is a pill that is taken for rheumatoid arthritis (RA). Xeljanz is also called tofacitinib.Ha...", site.activeProtocols); //protocol2
        debugPageOLS.back();
        takenXeljanz
                .waitForPageLoad()
                .clickOnAnswer("No, I have never taken it")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        //----------*******NEW GENERAL HEALTH Questions********----------
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
//        .clickNextButton(new ChildrenUnderPageOLS())
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
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
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(Siteindicator)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
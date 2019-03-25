package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.RA.*;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RA_2821_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void ra_2821_CC(final String username, final String password) {
        Site site = Site.AUT_RA2821_Site;
        String phoneNumberOA = "AUTAMS1RA1";
        String studyName = "Rheumatoid Arthritis";
        String studyName1 = "a rheumatoid arthritis (RA) study";

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

        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedRA2821, "Title is diff");

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritisCC());

        doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());


        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals(doYouSufferFromArthritisCC.titleExpected, site.activeProtocols);
        debugPageCC.back();

        WhatKindOfArthritisCC whatKindOfArthritisCC = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisCC());

        WhenYouDiagnosedWithRaPageCC whenYouDiagnosedWithRaPageCC = whatKindOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageCC());


        whenYouDiagnosedWithRaPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new HowOldWereUWhenDiagnosedWithRACC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0005177-QS503-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        HowOldWereUWhenDiagnosedWithRACC howOldWereUWhenDiagnosedWithRACC = whenYouDiagnosedWithRaPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new HowOldWereUWhenDiagnosedWithRACC());


        howOldWereUWhenDiagnosedWithRACC
                .waitForPageLoad()
                .typeAge("16")
                .clickNextButton(new FollowingDescribesYourRASymptomsStartedCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsEquals("Approximately how old were you when you were diagnosed with RA?Agent Note: If patient is unsure, say...", site.activeProtocols);
        debugPageCC.back();
        FollowingDescribesYourRASymptomsStartedCC followingDescribesYourRASymptomsStartedCC = howOldWereUWhenDiagnosedWithRACC
                .waitForPageLoad()
                .typeAge("28")
                .clickNextButton(new FollowingDescribesYourRASymptomsStartedCC());


        WhatTestsDoctorLedToDiagnosingRACC whatTestsDoctorLedToDiagnosingRACC = followingDescribesYourRASymptomsStartedCC
                .waitForPageLoad()
                .clickOnAnswer("Symptoms took several months to develop; the pain built gradually over a period of time")
                .clickNextButton(new WhatTestsDoctorLedToDiagnosingRACC());


        TenderPainfulOrSwollenJointsCC tenderPainfulOrSwollenJointsCC = whatTestsDoctorLedToDiagnosingRACC
                .waitForPageLoad()
                .clickOnAnswers("An x-ray of your affected joints, which included multiple joints such as your hands and feet")
                .clickNextButton(new TenderPainfulOrSwollenJointsCC());


        tenderPainfulOrSwollenJointsCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new CurrentlyExperiencingJointSymptomsYourRACC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsEquals(tenderPainfulOrSwollenJointsCC.titleExpected, site.activeProtocols);
        debugPageCC.back();
        CurrentlyExperiencingJointSymptomsYourRACC currentlyExperiencingJointSymptomsYourRACC = tenderPainfulOrSwollenJointsCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyExperiencingJointSymptomsYourRACC());


        DoYouUseAnyOralSteroidCC doYouUseAnyOralSteroidCC = currentlyExperiencingJointSymptomsYourRACC
                .waitForPageLoad()
                .clickOnAnswers("Pain or swelling in at least 3 separate joints")
                .clickNextButton(new DoYouUseAnyOralSteroidCC());


        AnySteroidsForYourRACC anySteroidsForYourRACC = doYouUseAnyOralSteroidCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AnySteroidsForYourRACC());


        AreYouCurrentlyTakingMethotrexateCC areYouCurrentlyTakingMethotrexateCC = anySteroidsForYourRACC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyTakingMethotrexateCC());


        HowLongTakingMethotrexateCC howLongTakingMethotrexateCC = areYouCurrentlyTakingMethotrexateCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am taking methotrexate tablets or pills")
                .clickNextButton(new HowLongTakingMethotrexateCC());


        howLongTakingMethotrexateCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new FollowingMedicationsToTreatYourRACC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsEquals(howLongTakingMethotrexateCC.titleExpected, site.activeProtocols);
        debugPageCC.back();
        FollowingMedicationsToTreatYourRACC followingMedicationsToTreatYourRACC = howLongTakingMethotrexateCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months")
                .clickNextButton(new FollowingMedicationsToTreatYourRACC());


        followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .clickOnAnswers("Leukeran (chlorambucil)")
                .clickNextButton(new BiologicMedicationsCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsEquals("Are you currently taking any of the following medications to treat your RA?Agent Note: Read medicati...", site.activeProtocols);
        debugPageCC.back();
        HowLongTakingPlaquenilCC howLongTakingPlaquenilCC = followingMedicationsToTreatYourRACC
                .waitForPageLoad()
                .clickOnAnswers("Leukeran (chlorambucil)")
                .clickOnAnswers("Plaquenil (hydroxychloroquine)")
                .clickNextButton(new HowLongTakingPlaquenilCC());


        howLongTakingPlaquenilCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(new BiologicMedicationsCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsEqualsForQNumber("Q0005220-QS521-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        BiologicMedicationsCC biologicMedicationsCC = howLongTakingPlaquenilCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months")
                .clickNextButton(new BiologicMedicationsCC());


        EverTakenXeljanzCC everTakenXeljanzCC = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTakenXeljanzCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsEquals("Ghost Question - 2821 RA bDMARD protocol logic - (\"bDMARD Exposure\") for M14-465 and M13-5...", site.activeProtocols);
        debugPageCC.back();
        WhenLastReceivedTysabriCC whenLastReceivedTysabriCC = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Tysabri (Agent Note: tie-SAB-ree)")
                .clickNextButton(new WhenLastReceivedTysabriCC());


        whenLastReceivedTysabriCC
                .waitForPageLoad()
                .clickOnAnswer("Last received 7 to 11 months ago")
                .clickNextButton(new EverTakenXeljanzCC());


        everTakenXeljanzCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am currently taking it")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsEquals("Xeljanz is a pill that is taken for rheumatoid arthritis (RA). Xeljanz is also called tofacitinib.Ha...", site.activeProtocols);
        debugPageCC.back();
        TransitionStatementCC transitionStatementCC = everTakenXeljanzCC
                .waitForPageLoad()
                .clickOnAnswer("No, I have never taken it")
                .clickNextButton(new TransitionStatementCC());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad("RA")
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
//        .clickNextButton(new ChildrenUnderPageCC())
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        //----------PEDIATRIC HEALTH Questions----------
//        .clickNextButton(new HouseholdHavePageCC())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
                //----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(studyName)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
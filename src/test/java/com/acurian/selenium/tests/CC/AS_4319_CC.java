package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import com.acurian.selenium.pages.CC.pediatric.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.AS_4319.DiagnosedWithAnkylosingSpondylitisCC;
import com.acurian.selenium.pages.CC.AS_4319.FollowingSymptomsMoreThanOnceAWeekCC;
import com.acurian.selenium.pages.CC.AS_4319.PermanentlyWheelchairBoundCC;
import com.acurian.selenium.pages.CC.AS_4319.SacroiliitisPageCC;
import com.acurian.selenium.pages.CC.AS_4319.SignsOfAnkylosingSpondylitisCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.shared.BiologicMedicationsCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DevicesInYourBodyCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromLbpPageCC;
import com.acurian.selenium.pages.CC.shared.EverTakenXeljanzCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HowLongHaveLbpPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class AS_4319_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void AS_4319_cc(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1AS1";
        List<String> protocols = Arrays.asList("M16_098");
        String protocol1 = "M16_098";
        String studyName = "ankylosing spondylitis or AS";
        String studyName1 = "an ankylosing spondylitis (AS) study";
        //    String env = "STG";
        String siteName = "AUT_AS_4319";
        String site_indication = "Ankylosing Spondylitis";
        String zipCode = "19044";

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
        // Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedOA, "Title is diff");

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        DiagnosedWithAnkylosingSpondylitisCC diagnosedWithAnkylosingSpondylitisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithAnkylosingSpondylitisCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithAnkylosingSpondylitisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017176-QS4715-STUDYQUES", protocol1);
        debugPageCC.back();

        DoYouSufferFromLbpPageCC doYouSufferFromLbpPageCC = diagnosedWithAnkylosingSpondylitisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouSufferFromLbpPageCC());

        NonQRtransitionPageCC nonQRtransitionPageCC1 = doYouSufferFromLbpPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005287-QS4703-STUDYQUES", protocol1);
        debugPageCC.back();

        HowLongHaveLbpPageCC howLongHaveLbpPageCC = doYouSufferFromLbpPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveLbpPageCC());

        SignsOfAnkylosingSpondylitisCC signsOfAnkylosingSpondylitisCC = howLongHaveLbpPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months")
                .clickNextButton(new SignsOfAnkylosingSpondylitisCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005288-QS4704-STUDYQUES", protocol1);
        debugPageCC.back();

        howLongHaveLbpPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year")
                .clickNextButton(new SignsOfAnkylosingSpondylitisCC());

        FollowingSymptomsMoreThanOnceAWeekCC followingSymptomsMoreThanOnceAWeekCC = signsOfAnkylosingSpondylitisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingSymptomsMoreThanOnceAWeekCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0014040-QS4705-STUDYQUES", protocol1);
        debugPageCC.back();


        SacroiliitisPageCC sacroiliitisPageCC = signsOfAnkylosingSpondylitisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SacroiliitisPageCC());

        FollowingSymptomsMoreThanOnceAWeekCC followingSymptomsMoreThanOnceAWeekCC1 = sacroiliitisPageCC
                .waitForPageLoad()
                .clickOnAnswer("Doctor did not explain the x-ray or MRI at all")
                .clickNextButton(new FollowingSymptomsMoreThanOnceAWeekCC());

        BiologicMedicationsCC biologicMedicationsCC = followingSymptomsMoreThanOnceAWeekCC1
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedicationsCC());

        EverTakenXeljanzCC everTakenXeljanzCC = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("Tysabri (Agent Note: tie-SAB-ree)")
                .clickNextButton(new EverTakenXeljanzCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS4708-STUDYQUES", protocol1);
        debugPageCC.back();

        EverTakenXeljanzCC everTakenXeljanzCC1 = biologicMedicationsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EverTakenXeljanzCC());

        PermanentlyWheelchairBoundCC permanentlyWheelchairBoundCC = everTakenXeljanzCC1
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am currently taking it")
                .clickNextButton(new PermanentlyWheelchairBoundCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005244-QS4709-STUDYQUES", protocol1);
        debugPageCC.back();

        everTakenXeljanzCC1
                .waitForPageLoad()
                .clickOnAnswer("No, I have never taken it")
                .clickNextButton(new PermanentlyWheelchairBoundCC());

        DevicesInYourBodyCC devicesInYourBodyCC = permanentlyWheelchairBoundCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DevicesInYourBodyCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0014045-QS4710-STUDYQUES", protocol1);
        debugPageCC.back();

        DevicesInYourBodyCC devicesInYourBodyCC1 = permanentlyWheelchairBoundCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DevicesInYourBodyCC());

        TransitionStatementCC transitionStatementCC = devicesInYourBodyCC1
                .waitForPageLoad()
                .clickOnAnswers("A pacemaker")
                .clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005282-QS4711-STUDYQUES", protocol1);
        debugPageCC.back();

        devicesInYourBodyCC1
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurves1(studyName)
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
                .waitForPageLoad()
//               .clickNextButton(new ChildrenUnderPageCC())
//               .waitForPageLoad()
//               .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageCC())
                //----------PEDIATRIC HEALTH Questions----------
                //.clickNextButton(new HouseholdHavePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("None of the above")
                //.clickNextButton(new TheStudySitePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Public transportation")
                //.clickNextButton(new WhatMedicalCoveragePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("No, I have no coverage")
                //.clickNextButton(new EthnicBackgroundPageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Prefer not to answer")
                //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(site_indication)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch("1R", "1R");
    }
}
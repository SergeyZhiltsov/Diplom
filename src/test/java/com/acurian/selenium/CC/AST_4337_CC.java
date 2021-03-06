package com.acurian.selenium.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.AST_4337.*;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class AST_4337_CC extends BaseTest{

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00011")
    @Description("Asthma_4337 for CC")
    public void ast4337ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1AST";
        List<String> protocols = Arrays.asList("205715");
        String protocol1 = "205715";
        String studyName = "an asthma study";
        String siteName = "AUT_AST_4337_Site";
        String debugSiteName = "";
     //   String env = "STG";
        String zipCode = "19044";
        String studyIndication = "Asthma";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

//        dateOfBirthPageCC
//                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedAST_4337, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        EverDiagnosedAsthmaPageCC everDiagnosedAsthmaPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new EverDiagnosedAsthmaPageCC());

        everDiagnosedAsthmaPageCC
                .waitForPageLoad();
        Assert.assertEquals(everDiagnosedAsthmaPageCC.getTitleText(),everDiagnosedAsthmaPageCC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = everDiagnosedAsthmaPageCC
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals(everDiagnosedAsthmaPageCC.titleExpected, protocol1);
        debugPageCC.back();
        WhenDiagnosedAsthmaPageCC whenDiagnosedAsthmaPageCC = everDiagnosedAsthmaPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedAsthmaPageCC());

        whenDiagnosedAsthmaPageCC
                .waitForPageLoad();
        Assert.assertEquals(whenDiagnosedAsthmaPageCC.getTitleText(),whenDiagnosedAsthmaPageCC.titleExpected, "Title is diff");
        RescueInhalersPageCC rescueInhalersPageCC = whenDiagnosedAsthmaPageCC
                .clickOnAnswer("Less than 1 year ago")
                .clickNextButton(new RescueInhalersPageCC());
        rescueInhalersPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whenDiagnosedAsthmaPageCC.titleExpected, protocol1)
                .back();
        whenDiagnosedAsthmaPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(rescueInhalersPageCC);

        rescueInhalersPageCC
                .waitForPageLoad();
        Assert.assertEquals(rescueInhalersPageCC.getTitleText(),rescueInhalersPageCC.titleExpected, "Title is diff");
        InhalersOrNebulizersPageCC inhalersOrNebulizersPageCC = rescueInhalersPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new InhalersOrNebulizersPageCC());
        inhalersOrNebulizersPageCC
                .waitForPageLoad()
                .back();
        RescueOrShortactingPageCC rescueOrShortactingPageCC = rescueInhalersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Metaproterenol")
                .clickNextButton(new RescueOrShortactingPageCC());

        rescueOrShortactingPageCC
                .waitForPageLoad();
        Assert.assertEquals(rescueOrShortactingPageCC.getTitleText(),rescueOrShortactingPageCC.titleExpected, "Title is diff");
        rescueOrShortactingPageCC
                .clickOnAnswer("Every day")
                .clickNextButton(inhalersOrNebulizersPageCC);

        inhalersOrNebulizersPageCC
                .waitForPageLoad();
        Assert.assertEquals(inhalersOrNebulizersPageCC.getTitleText(),inhalersOrNebulizersPageCC.titleExpected, "Title is diff");
        CurrentlyTakingPillPageCC currentlyTakingPillPageCC = inhalersOrNebulizersPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyTakingPillPageCC());
        currentlyTakingPillPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(inhalersOrNebulizersPageCC.titleExpected, protocol1)
                .back();
        HowLongUsingInhalerPageCC howLongUsingInhalerPageCC = inhalersOrNebulizersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Aerospan (flunisolide)")
                .clickNextButton(new HowLongUsingInhalerPageCC());
        howLongUsingInhalerPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(inhalersOrNebulizersPageCC.titleExpected, protocol1)
                .back();
        inhalersOrNebulizersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Tudorza Pressair (aclidinium)")
                .clickNextButton(howLongUsingInhalerPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(inhalersOrNebulizersPageCC.titleExpected, protocol1)
                .back();
        inhalersOrNebulizersPageCC
                .waitForPageLoad()
                .clickOnAnswers("Advair Diskus or Advair HFA (fluticasone and salmeterol)")
                .clickNextButton(howLongUsingInhalerPageCC);

        howLongUsingInhalerPageCC
                .waitForPageLoad();
        Assert.assertEquals(howLongUsingInhalerPageCC.getTitleText(), howLongUsingInhalerPageCC.titleExpected, "Title is diff");
        howLongUsingInhalerPageCC
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(currentlyTakingPillPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(howLongUsingInhalerPageCC.titleExpected, protocol1)
                .back();
        howLongUsingInhalerPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 months")
                .clickNextButton(currentlyTakingPillPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(howLongUsingInhalerPageCC.titleExpected, protocol1)
                .back();
        howLongUsingInhalerPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(currentlyTakingPillPageCC);

        currentlyTakingPillPageCC
                .waitForPageLoad();
        Assert.assertEquals(currentlyTakingPillPageCC.getTitleText(),currentlyTakingPillPageCC.titleExpected, "Title is diff");
        RespiratorySymptomsPageCC respiratorySymptomsPageCC = currentlyTakingPillPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new RespiratorySymptomsPageCC());
        respiratorySymptomsPageCC
                .waitForPageLoad()
                .back();
        HowLongTakingPillPageCC howLongTakingPillPageCC = currentlyTakingPillPageCC
                .waitForPageLoad()
                .clickOnAnswers("Singulair (montelukast)")
                .clickNextButton(new HowLongTakingPillPageCC());

        howLongTakingPillPageCC
                .waitForPageLoad();
        Assert.assertEquals(howLongTakingPillPageCC.getTitleText(),howLongTakingPillPageCC.titleExpected, "Title is diff");
        howLongTakingPillPageCC
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(respiratorySymptomsPageCC);

        InThePastYearHowManyTimesDidYouSeekMedicalCC inThePastYearHowManyTimesDidYouSeekMedicalCC = respiratorySymptomsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Xolair (omalizumab)")
                .clickNextButton(new InThePastYearHowManyTimesDidYouSeekMedicalCC());

        inThePastYearHowManyTimesDidYouSeekMedicalCC
                .waitForPageLoad();
        Assert.assertEquals(inThePastYearHowManyTimesDidYouSeekMedicalCC.getTitleText(),inThePastYearHowManyTimesDidYouSeekMedicalCC.titleExpected, "Title is diff");
        TheseSymptomsPageCC theseSymptomsPageCC = inThePastYearHowManyTimesDidYouSeekMedicalCC
                .clickOnAnswer("None")
                .clickNextButton(new TheseSymptomsPageCC());
        theseSymptomsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("In the past year, how many times did you have to seek any medical attention (at a hospital, ER, urge...", protocol1)
                .back();
        inThePastYearHowManyTimesDidYouSeekMedicalCC
        .waitForPageLoad()
        .clickOnAnswer("Once")
        .clickNextButton(new TheseSymptomsPageCC());

        theseSymptomsPageCC
                .waitForPageLoad();
        Assert.assertEquals(theseSymptomsPageCC.getTitleText(),theseSymptomsPageCC.titleExpected, "Title is diff");
        HaveYouSmokedCigarettesCC haveYouSmokedCigarettesCC = theseSymptomsPageCC
                .clickOnAnswer("Less than once a week")
                .clickNextButton(new HaveYouSmokedCigarettesCC());
        haveYouSmokedCigarettesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(theseSymptomsPageCC.titleExpected, protocol1)
                .back();
        theseSymptomsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Every day")
                .clickNextButton(haveYouSmokedCigarettesCC);

        haveYouSmokedCigarettesCC
                .waitForPageLoad();
        Assert.assertEquals(haveYouSmokedCigarettesCC.getTitleText(), haveYouSmokedCigarettesCC.titleExpected, "Title is diff");
        TransitionStatementCC transitionStatementCC = haveYouSmokedCigarettesCC
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad("asthma")
                .back();
        SubquestionSmokedCigarettePageCC subquestionSmokedCigarettePageCC = haveYouSmokedCigarettesCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new SubquestionSmokedCigarettePageCC());
        subquestionSmokedCigarettePageCC
                .waitForPageLoad(1,subquestionSmokedCigarettePageCC.titleExpected1)
                .getPage(debugPageCC)
                .checkProtocolsEquals(haveYouSmokedCigarettesCC.titleExpected, protocol1)
                .back();
        haveYouSmokedCigarettesCC
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(subquestionSmokedCigarettePageCC);

        subquestionSmokedCigarettePageCC
                .waitForPageLoad(1,subquestionSmokedCigarettePageCC.titleExpected2);
        Assert.assertEquals(subquestionSmokedCigarettePageCC.getTitleText(1),subquestionSmokedCigarettePageCC.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionSmokedCigarettePageCC.getTitleText(2),subquestionSmokedCigarettePageCC.titleExpected4, "Title is diff");
        subquestionSmokedCigarettePageCC
                .setFirst("10")
                .setSecond("20")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad("asthma")
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Asthma Smoking History Logic", protocol1)
                .back();
        subquestionSmokedCigarettePageCC
                .waitForPageLoad(1,subquestionSmokedCigarettePageCC.titleExpected2)
                .setFirst("9")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad("asthma")
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
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
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
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(studyIndication)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);

       /*//---------OLD general Health ----------------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouUndergoneAnyPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CongestiveHeartFailurePageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditions())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingDigestiveConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingSkinConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingViralConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingMentalHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingWomensHealthPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HistoryOfDrugPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
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
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad(studyIndication)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);  */
    }
}
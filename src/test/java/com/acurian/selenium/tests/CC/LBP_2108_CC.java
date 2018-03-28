package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.LBP_2108.InTotalHowMany;
import com.acurian.selenium.pages.CC.LBP_2108.WhatTypeOfHealthcare;
import com.acurian.selenium.pages.CC.LBP_2108.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;

public class LBP_2108_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00001")
    @Description(" 1. Open the page, URL: " +
            " 2. Type login and correct password of registered user" +
            " 3. Click the Sign In button")
    public void tc001Test(final String username, final String password) {
        String phoneNumberLBP = "AUTAMS1LBP";
        List<String> protocols = Arrays.asList("A4091059");
        String protocol = "A4091059";
        String studyName = "low back pain";
//        String env = "STG";
        String siteName = "hfghfgh";
        String zipCode  = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";


        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumberLBP)
                .clickPopupPhoneNumber(phoneNumberLBP)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad();
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Call Back")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();

        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedLBP, "Title is diff");

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");

        DoYouSufferFromLbpPageCC doYouSufferFromLbpPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromLbpPageCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = doYouSufferFromLbpPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC.
                waitForPageLoad();
        Assert.assertEquals(nonQRtransitionPageCC.getTitleText(), nonQRtransitionPageCC.titleExpected, "Title is diff");

        DebugPageCC debugPageCC = new DebugPageCC();
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(doYouSufferFromLbpPageCC.titleExpected), protocol, "Protocols are diff");
        debugPageCC.back();

        HowLongHaveLbpPageCC howLongHaveLbpPageCC = doYouSufferFromLbpPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveLbpPageCC());

        howLongHaveLbpPageCC
                .waitForPageLoad();
        Assert.assertEquals(howLongHaveLbpPageCC.getTitleText(), howLongHaveLbpPageCC.titleExpected, "Title is diff");
        TransitionStatementCC transitionStatementCC = howLongHaveLbpPageCC
                .clickOnAnswer("Less than 3 months ")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoad(studyName);
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(howLongHaveLbpPageCC.titleExpected), protocol, "Protocol is diff");
        debugPageCC.back();

        WhatTypeOfHealthcare whatTypeOfHealthcare = howLongHaveLbpPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(new WhatTypeOfHealthcare());

        whatTypeOfHealthcare
                .waitForPageLoad();
        Assert.assertEquals(whatTypeOfHealthcare.getTitleText(), whatTypeOfHealthcare.titleExpected, "Title is diff");
        InTotalHowMany inTotalHowMany = whatTypeOfHealthcare
                .clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(new InTotalHowMany());

        inTotalHowMany
                .waitForPageLoad();
        Assert.assertEquals(inTotalHowMany.getTitleText(), inTotalHowMany.titleExpected, "Title is diff");
        inTotalHowMany
                .clickOnAnswer("0")
                .clickNextButton(transitionStatementCC);

        transitionStatementCC
                .waitForPageLoad(studyName);
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(inTotalHowMany.titleExpected), protocol, "Protocol is diff");
        debugPageCC.back();


        inTotalHowMany
                .waitForPageLoad()
                .clickOnAnswer("2")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad(studyName);
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(inTotalHowMany.titleExpected), protocol, "Protocol is diff");
        transitionStatementCC.back();

        OfMedicationsYou ofMedicationsYou = inTotalHowMany
                .waitForPageLoad()
                .clickOnAnswer("3")
                .clickNextButton(new OfMedicationsYou());

        ofMedicationsYou
                .waitForPageLoad();
        Assert.assertEquals(ofMedicationsYou.getTitleText(), ofMedicationsYou.titleExpected, "Title is diff");
        AreYouCurrentlyOnPageCC areYouCurrentlyOn = ofMedicationsYou
                .clickOnAnswer("0")
                .clickNextButton(new AreYouCurrentlyOnPageCC());

        areYouCurrentlyOn
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyOn.getTitleText(), areYouCurrentlyOn.titleExpected, "Title is diff");
        areYouCurrentlyOn
                .clickOnAnswer("Yes, for another chronic condition")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad(studyName);
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(areYouCurrentlyOn.titleExpected), protocol, "Protocol is diff");
        transitionStatementCC.back();

        InPastYear inPastYear = areYouCurrentlyOn
                .waitForPageLoad()
                .clickOnAnswer("Yes, for low back pain")
                .clickNextButton(new InPastYear());

        inPastYear
                .waitForPageLoad();
        Assert.assertEquals(inPastYear.getTitleText(), inPastYear.titleExpected, "Title is diff");
        InPast6MonthsPageCC inPast6MonthsPageCC = inPastYear
                .clickOnAnswers("An unplanned visit to your doctor")
                .clickNextButton(new InPast6MonthsPageCC());

        inPast6MonthsPageCC
                .waitForPageLoad();
        Assert.assertEquals(inPast6MonthsPageCC.getTitleText(), inPast6MonthsPageCC.titleExpected, "Title is diff");
        inPast6MonthsPageCC
                .clickOnAnswers("Back surgery")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad(studyName);
        //in this case text is used because bug of debug text window
        Assert.assertEquals(debugPageCC.getProtocolForQuestion("In the past 6 months, did you have any of the following?Agent Note: Select all that applyIn the past..."), protocol, "Protocol is diff");
        transitionStatementCC.back();

        HasYourLbpPainCausedPageCC hasYourLbpPainCausedPageCC = inPast6MonthsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Knee surgery", "Back surgery")
                .clickNextButton(new HasYourLbpPainCausedPageCC());

        hasYourLbpPainCausedPageCC
                .waitForPageLoad();
        Assert.assertEquals(hasYourLbpPainCausedPageCC.getTitleText(), hasYourLbpPainCausedPageCC.titleExpected, "Title is diff");
        AreYouCurrentlyReceivingWorkersPageCC areYouCurrentlyReceivingWorkersPageCC = hasYourLbpPainCausedPageCC
                .clickOnAnswers("Inability to lift heavy objects (suitcase, grocery bags, etc.) without help")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageCC());

        areYouCurrentlyReceivingWorkersPageCC
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyReceivingWorkersPageCC.getTitleText(), areYouCurrentlyReceivingWorkersPageCC.titleExpected, "Title is diff");
        areYouCurrentlyReceivingWorkersPageCC
                .clickOnAnswer("Yes")
                .clickNextButton(transitionStatementCC);

        transitionStatementCC
                .waitForPageLoad(studyName);
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(areYouCurrentlyReceivingWorkersPageCC.titleExpected), protocol, "Protocol is diff");
        transitionStatementCC.back();

        areYouCurrentlyReceivingWorkersPageCC
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);

        transitionStatementCC
                .waitForPageLoad(studyName);
        Assert.assertEquals(transitionStatementCC.getTitleText(), transitionStatementCC.getTitleExpected(studyName), "Title is difff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouUndergoneAnyPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartFailureIsAlsoPageCC())
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
                .clickNextButton(new SmokedCigarettesPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
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
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();



    }
}

package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.AST_4337.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class AST_4337_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00011")
    @Description("Asthma_4337 for CC")
    public void ast4337ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1AST";
        List<String> protocols = Arrays.asList("205715");
        String protocol1 = "205715";
        String studyName = "an asthma study";
        String siteName = "AUT_AST_4337_Site";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";

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

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(), "May I have your date of birth?", "Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedAST_4337, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
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

        SubquestionHospitalizedOvernightPageCC subquestionHospitalizedOvernightPageCC = respiratorySymptomsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Xolair (omalizumab)")
                .clickNextButton(new SubquestionHospitalizedOvernightPageCC());

        subquestionHospitalizedOvernightPageCC
                .waitForPageLoad(1,subquestionHospitalizedOvernightPageCC.titleExpected1);
        Assert.assertEquals(subquestionHospitalizedOvernightPageCC.getTitleText(1),subquestionHospitalizedOvernightPageCC.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionHospitalizedOvernightPageCC.getTitleText(2),subquestionHospitalizedOvernightPageCC.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionHospitalizedOvernightPageCC.getTitleText(3),subquestionHospitalizedOvernightPageCC.titleExpected3, "Title is diff");
        TheseSymptomsPageCC theseSymptomsPageCC = subquestionHospitalizedOvernightPageCC
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageCC.titleExpected1,"No")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageCC.titleExpected2,"No")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageCC.titleExpected3,"No")
                .clickNextButton(new TheseSymptomsPageCC());
        theseSymptomsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Asthma Exacerbation Logic", protocol1)
                .back();
        SubquestionTheHospitalPageCC subquestionTheHospitalPageCC = subquestionHospitalizedOvernightPageCC
                .waitForPageLoad(1,subquestionHospitalizedOvernightPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageCC.titleExpected1,"Yes")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageCC.titleExpected2,"Yes")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageCC.titleExpected3,"Yes")
                .clickNextButton(new SubquestionTheHospitalPageCC());

        subquestionTheHospitalPageCC
                .waitForPageLoad(1,subquestionTheHospitalPageCC.titleExpected1);
        Assert.assertEquals(subquestionTheHospitalPageCC.getTitleText(1),subquestionTheHospitalPageCC.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionTheHospitalPageCC.getTitleText(2),subquestionTheHospitalPageCC.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionTheHospitalPageCC.getTitleText(3),subquestionTheHospitalPageCC.titleExpected3, "Title is diff");
        SeekMedicalPageCC seekMedicalPageCC = subquestionTheHospitalPageCC
                .clickOnAnswersForSubQuestion(subquestionTheHospitalPageCC.titleExpected1,"Inhaled nebulizer treatment")
                .clickOnAnswersForSubQuestion(subquestionTheHospitalPageCC.titleExpected2,"Injection or shot")
                .clickOnAnswersForSubQuestion(subquestionTheHospitalPageCC.titleExpected3,"Unsure")
                .clickNextButton(new SeekMedicalPageCC());

        seekMedicalPageCC
                .waitForPageLoad();
        Assert.assertEquals(seekMedicalPageCC.getTitleText(),seekMedicalPageCC.titleExpected, "Title is diff");
        seekMedicalPageCC
                .clickOnAnswer("Once")
                .clickNextButton(theseSymptomsPageCC);

        theseSymptomsPageCC
                .waitForPageLoad();
        Assert.assertEquals(theseSymptomsPageCC.getTitleText(),theseSymptomsPageCC.titleExpected, "Title is diff");
        SmokedCigarettesPageCC smokedCigarettesPageCC = theseSymptomsPageCC
                .clickOnAnswer("Less than once a week")
                .clickNextButton(new SmokedCigarettesPageCC());
        smokedCigarettesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(theseSymptomsPageCC.titleExpected, protocol1)
                .back();
        theseSymptomsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Every day")
                .clickNextButton(smokedCigarettesPageCC);

        smokedCigarettesPageCC
                .waitForPageLoad();
        Assert.assertEquals(smokedCigarettesPageCC.getTitleText(),smokedCigarettesPageCC.titleExpected, "Title is diff");
        TransitionStatementCC transitionStatementCC = smokedCigarettesPageCC
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad("asthma")
                .back();
        SubquestionSmokedCigarettePageCC subquestionSmokedCigarettePageCC = smokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new SubquestionSmokedCigarettePageCC());
        subquestionSmokedCigarettePageCC
                .waitForPageLoad(1,subquestionSmokedCigarettePageCC.titleExpected1)
                .getPage(debugPageCC)
                .checkProtocolsEquals(smokedCigarettesPageCC.titleExpected, protocol1)
                .back();
        smokedCigarettesPageCC
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

        HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = transitionStatementCC
                .waitForPageLoad("asthma")
                .clickNextButton(new HasHealthcareProfessionalPageCC());


        hasHealthcareProfessionalPageCC
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
                .clickNextButton(new TheStudySitePageCC())
                .waitForPageLoad()
                .clickOnAnswer("Other")
                .clickNextButton(new WhatSortPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above (no coverage at all)")
                .clickNextButton(new EthnicBackgroundPageCC())
                .waitForPageLoad()
                .clickOnAnswers("Other")
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

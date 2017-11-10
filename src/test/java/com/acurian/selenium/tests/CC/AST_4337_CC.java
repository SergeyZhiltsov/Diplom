package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.CC.AST_4337.*;
import com.acurian.selenium.pages.CC.Crohns_3485.DiagnosedWithCrohnsPageCC;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class AST_4337_CC extends MainPageCC{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00011")
    @Description("Crohn's_3485 for CC")
    public void tc004Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1HFL";
        List<String> protocols = Arrays.asList("205715");
        String protocol1 = "205715";
        String studyName = "an asthma";
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



    }
}

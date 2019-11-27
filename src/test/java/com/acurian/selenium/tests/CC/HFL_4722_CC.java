package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.HFL_4722.HeartTransplantPageCC;
import com.acurian.selenium.pages.CC.HFL_4722.SymptomsOfHeartFailurePageCC;
import com.acurian.selenium.pages.CC.HFL_4722.TreatYourHeartFailurePageCC;
import com.acurian.selenium.pages.CC.closes.AlzheimerClosePageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose1PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusHealthyMindsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class HFL_4722_CC extends BaseTest {

    @Test(enabled = true)
    @Description("HFL_4722 test CC")
    public void hfl_4722_CC() {
        Site site = Site.AUT_HFL_4722_Site;
        String phoneNumber = "AUTAMS1HFL";
        String studyName = "a heart failure study";
        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a heart failure study", "500");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.
//                getExpectedModifiedTitle("a heart failure study", "500"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CongestiveHeartFailurePageCC congestiveHeartFailurePageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1940")
                .clickOnAnswer("Female")
                .clickNextButton(new CongestiveHeartFailurePageCC());


        NonQRtransitionPageCC nonQRtransitionPageCC = congestiveHeartFailurePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS6402", site.activeProtocols)
                .back();
        congestiveHeartFailurePageCC
                .waitForPageLoad()
                .clickOnAnswer("I have experienced other heart problems, but not CHF")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS6402", site.activeProtocols)
                .back();
        SymptomsOfHeartFailurePageCC symptomsOfHeartFailurePageCC = congestiveHeartFailurePageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SymptomsOfHeartFailurePageCC());

        TreatYourHeartFailurePageCC treatYourHeartFailurePageCC = symptomsOfHeartFailurePageCC
                .waitForPageLoad()
                .clickOnAnswer("I do not have any symptoms when going about my normal daily activities")
                .clickNextButton(new TreatYourHeartFailurePageCC());
        treatYourHeartFailurePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS6403", site.activeProtocols)
                .back();
        symptomsOfHeartFailurePageCC
                .waitForPageLoad()
                .clickOnAnswer("I have some mild symptoms when going about my normal daily activities")
                .clickNextButton(treatYourHeartFailurePageCC);

        HeartTransplantPageCC heartTransplantPageCC = treatYourHeartFailurePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartTransplantPageCC());

        TransitionStatementCC transitionStatementCC = heartTransplantPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad("heart failure")
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS6405", site.activeProtocols)
                .back();
        heartTransplantPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                transitionStatementCC
                .waitForPageLoad("heart failure")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                .waitForPageLoad()
                .setAll("5", "5", "170") //BMI > 30 in Q28
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("QS66", site.activeProtocols)
                .back(new ApproximateHeightPageCC())
                .setLbs("190")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                //.clickOnAnswer("No")
//                .clickNextButton(new SynexusHealthyMindsPageCC())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(new AlzheimerClosePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
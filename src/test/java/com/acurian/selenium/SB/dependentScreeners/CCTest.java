package com.acurian.selenium.SB.dependentScreeners;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.RA.standalone.ExperiencedAnyOfTheFollowingConditionsInPast6Months;
import com.acurian.selenium.pages.CC.RA.standalone.HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC;
import com.acurian.selenium.pages.CC.closes.standalone.UnqualifiedStudySwitchCloseOldCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class CCTest extends BaseTest {

    @Test(enabled = true)
    @TestCaseId("001124")
    @Description("SB_Standalone test Screener")
    public void sb_AUTSBSSmodified() {
        String phoneNumber = "AUTSBSS001";
        String studyName = "AUTSBSS - Rheumatoid Arthritis (RA)";
        String env = System.getProperty("acurian.env", "QA");
        final Site site = Site.AUT_SB_SS_site;

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
                .typeStudyName(studyName)
                .clickPopupStudy(studyName)
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedStandAloneTest, "Title is diff");
        GenderPageCC genderPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new GenderPageCC());

        UnqualifiedStudySwitchCloseOldCC unqualifiedStudySwitchCloseOldCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("01")
                .setYear("2005")
                .clickNextButton(new UnqualifiedStudySwitchCloseOldCC());

        unqualifiedStudySwitchCloseOldCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8008", site.activeProtocols)
                .back(genderPageCC);

        IdentificationPageCC identificationPageCC =  genderPageCC
                .waitForPageLoad()
                .setYear("1985")
                .clickNextButton(new IdentificationPageCC());

        HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC hasAHealtcareDiagnosedWithAnyTypeOfArthritisCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
        "9999999999", site.zipCode)
                .clickNextButton(genderPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC());

        ExperiencedAnyOfTheFollowingConditionsInPast6Months experiencedAnyOfTheFollowingConditionsInPast6Months = hasAHealtcareDiagnosedWithAnyTypeOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("I do not have arthritis")
                .clickNextButton(unqualifiedStudySwitchCloseOldCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4", site.activeProtocols)
                .back(hasAHealtcareDiagnosedWithAnyTypeOfArthritisCC)
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid Arthritis, a serious disease caused by your immune system " +
                        "attacking your joints, which can cause fatigue with pain and swelling of multiple joints throughout your body")
                .clickNextButton(new ExperiencedAnyOfTheFollowingConditionsInPast6Months());

        experiencedAnyOfTheFollowingConditionsInPast6Months
                .waitForPageLoad()
                .clickOnAnswers("Heart Attack" +
                        "Stroke" +
                        "TIA or \"Mini-Stroke\"" +
                        "Angina (heart-related chest pain) that required an overnight stay in a hospital" +
                        "Angioplasty, which is a \"balloon procedure\" to open blood vessels" +
                        "Atherectomy, which is plaque \"shaving\" to remove build-up of plaque from blood vessels" +
                        "Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery" +
                        "Heart failure or Congestive Heart Failure (CHF) that required an overnight stay in a hospital")
                .clickNextButton(unqualifiedStudySwitchCloseOldCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6")
                .back(experiencedAnyOfTheFollowingConditionsInPast6Months)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(identificationPageCC)
                .waitForPageLoadStandAloneQ();
        //TODO finish this test






        System.out.println("Hello");

    }
}

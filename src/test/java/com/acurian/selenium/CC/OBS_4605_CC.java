package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Obesity_4605.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class OBS_4605_CC extends BaseTest {

    @Test(enabled = false)
    @Description("OBS_4605_CC")
    public void obs4605cc() {
        Site site = Site.AUT_OBS_4605_Site;
        final String phoneNumber = "AUTAMS1OBS";
        final String studyName = "a genetic obesity study";
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle("a genetic obesity study", "25 per visit"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .waitForPageLoad("a genetic obesity study", "25 per visit")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back();

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageCC());

        ApproximateHeightPageCC approximateHeightPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("15")
                .setYear("1990")
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new NonQRtransitionPageCC());

        ExperienceExcessiveHungerOrIncreasedAppetiteCC experienceExcessiveHunGerOrIncreasedAppetiteCC = nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004980-QS6802-STUDYQUES", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .setLbs("300")
                .clickNextButton(new ExperienceExcessiveHungerOrIncreasedAppetiteCC());

        WhenYouBecomeConcernedAboutWeightCC whenYouBecomeConcernedAboutWeightCC = experienceExcessiveHunGerOrIncreasedAppetiteCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhenYouBecomeConcernedAboutWeightCC());

        whenYouBecomeConcernedAboutWeightCC
                .waitForPageLoad()
                .back(experienceExcessiveHunGerOrIncreasedAppetiteCC)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(whenYouBecomeConcernedAboutWeightCC)
                .waitForPageLoad()
                .back();

        WhenFirstNoticeHungerOrAbnormalFoodSeekingCC whenFirstNoticeHungerOrAbnormalFoodSeekingCC = experienceExcessiveHunGerOrIncreasedAppetiteCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenFirstNoticeHungerOrAbnormalFoodSeekingCC());

        DiagnosedWithPraderWilliSyndromeCC diagnosedWithPraderWilliSyndromeCC = whenFirstNoticeHungerOrAbnormalFoodSeekingCC
                .waitForPageLoad()
                .clickOnAnswer("12 - 17 years old")
                .clickNextButton(whenYouBecomeConcernedAboutWeightCC)
                .waitForPageLoad()
                .clickOnAnswer("18 years or older")
                .clickNextButton(new DiagnosedWithPraderWilliSyndromeCC());

        WeightLossSurgeryPageCC weightLossSurgeryPageCC = diagnosedWithPraderWilliSyndromeCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WeightLossSurgeryPageCC());

        weightLossSurgeryPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018840-QS6806-STUDYQUES", site.activeProtocols)
                .back(diagnosedWithPraderWilliSyndromeCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(weightLossSurgeryPageCC);

        PlanningBiatricOrWeightLossSurgeryCC planningBiatricOrWeightLossSurgeryOLS = weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PlanningBiatricOrWeightLossSurgeryCC());

        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = planningBiatricOrWeightLossSurgeryOLS
                .waitForPageLoad()
                .back(weightLossSurgeryPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        TransitionStatementCC transitionStatementCC = procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithInitialQuestions()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        LetMeSeePageCC letMeSeePageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(identificationPageCC)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                //.clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad3()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);

    }
}
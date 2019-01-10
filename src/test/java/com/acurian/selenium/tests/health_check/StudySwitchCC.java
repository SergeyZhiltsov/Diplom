package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.RA_2821.standalone.ExperiencedAnyOfTheFollowingConditionsInPast6Months;
import com.acurian.selenium.pages.CC.RA_2821.standalone.HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC;
import com.acurian.selenium.pages.CC.RA_2821.WhenYouDiagnosedWithRaPageCC;
import com.acurian.selenium.pages.CC.RA_2821.standalone.OtherStudiesThatAreCurrentlyEnrollingCC;
import com.acurian.selenium.pages.CC.RA_2821.standalone.StudySwitchPageCC;
import com.acurian.selenium.pages.CC.closes.standalone.UnqualifiedStudySwitchCloseOldCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class StudySwitchCC extends BaseTest {

    @Test
    @Description("StudySwitchCC")
    public void studySwitchCC() {
        final String phoneNumber = "AUTGRA1UAP";
        String zipCode = "19044";
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
                .typeStudyName("GRA1")
                .clickPopupStudy("GRA1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC hasAHealtcareDiagnosedWithAnyTypeOfArthritisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC());

        WhenYouDiagnosedWithRaPageCC whenYouDiagnosedWithRaPageCC = hasAHealtcareDiagnosedWithAnyTypeOfArthritisCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid Arthritis, a serious disease caused by your immune system attacking your joints, " +
                        "which can cause fatigue with pain and swelling of multiple joints throughout your body ")
                .clickNextButton(new WhenYouDiagnosedWithRaPageCC());

        ExperiencedAnyOfTheFollowingConditionsInPast6Months experiencedAnyOfTheFollowingConditionsInPast6Months = whenYouDiagnosedWithRaPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months ")
                .clickNextButton(new ExperiencedAnyOfTheFollowingConditionsInPast6Months());

        UnqualifiedStudySwitchCloseOldCC unqualifiedStudySwitchCloseOldCC = experiencedAnyOfTheFollowingConditionsInPast6Months
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new UnqualifiedStudySwitchCloseOldCC());

        OtherStudiesThatAreCurrentlyEnrollingCC otherStudiesThatAreCurrentlyEnrollingCC = unqualifiedStudySwitchCloseOldCC
                .waitForPageLoad()
                .clickNextButton(new OtherStudiesThatAreCurrentlyEnrollingCC());

        StudySwitchPageCC studySwitchPageCC = otherStudiesThatAreCurrentlyEnrollingCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new StudySwitchPageCC());

        studySwitchPageCC
                .waitForPageLoad()
                .clickNextButton(dateOfBirthPageCC)
                .getPage(debugPageCC)
                .projectCodeShouldMatch("GMEGA");
    }
}
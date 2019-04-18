package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.DoesNotGivePermissionToProceedClosePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.CongestiveHeartFailurePageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.insomnia_5017.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Insomnia_5017_CC extends BaseTest{

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_INS_5017S_site},
                {Site.AUT_INS_5017_Site}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("Insomnia 5017")
    public void insomnia5017ccTest(Site site) {
        String phoneNumber = "AUTAMS1INS";
        String studyName = "an insomnia study";
        String transitionStatement = "insomnia";
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle(studyName, "1,250"), "Title is diff");
        dateOfBirthPageCC
                .setMonth("Apr")
                .setDay("5")
                .setYear("2003")
                .clickOnAnswer("No") //If "No", go to Does Not Give Permission to Proceed Close
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Apr")
                .setDay("18")
                .setYear("1955")//Disqualify ("Age") if < 65
                .clickNextButton(new ZipCodePageCC());
        zipCodePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols)
                .back(dateOfBirthPageCC);

        dateOfBirthPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("5")
                .setYear("1953")
                .clickNextButton(zipCodePageCC);

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromInsomniaPageCC doYouSufferFromInsomniaPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromInsomniaPageCC());

        //Q2
        OftenSleepProblemsPageCC oftenSleepProblemsPageCC = doYouSufferFromInsomniaPageCC
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No Insomnia")
                .clickNextButton(new NonQRtransitionPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols) //TODO
                .back(doYouSufferFromInsomniaPageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OftenSleepProblemsPageCC());
        //Q3
        LongSleepProblemsPageCC longSleepProblemsPageCC = oftenSleepProblemsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less often (a few times per month, etc.)") //Disqualify (“Frequency < 3 nights/week”)
                .clickNextButton(new LongSleepProblemsPageCC());
        longSleepProblemsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(oftenSleepProblemsPageCC)
                .clickOnAnswer("1 – 2 nights per week") //Disqualify (“Frequency < 3 nights/week”)
                .clickNextButton(longSleepProblemsPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(oftenSleepProblemsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("3 – 4 nights per week")
                .clickNextButton(longSleepProblemsPageCC);
        //Q4
        HealthcareDiagnosedAnySleepPageCC healthcareDiagnosedAnySleepPageCC = longSleepProblemsPageCC
                .waitForPageLoad()
                .clickOnAnswer("2 months or less") //Disqualify (“Insomnia duration < 3 months – Temp 3”)
                .clickNextButton(new HealthcareDiagnosedAnySleepPageCC());
        healthcareDiagnosedAnySleepPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(longSleepProblemsPageCC)
                .waitForPageLoad()
                .clickOnAnswer("3 – 6 months")
                .clickNextButton(healthcareDiagnosedAnySleepPageCC);
        //Q5
        HashMap<String, List<String>> disqualifyQ5 = new HashMap<>(); //Disqualify (“Exclusionary sleep disorder”)
        RotatingNightShiftPageCC rotatingNightShiftPageCC = new RotatingNightShiftPageCC();
        disqualifyQ5.put("Circadian rhythm sleep-wake disorder", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Sleep apnea", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Narcolepsy", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Hypersomnia", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Restless leg syndrome", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Periodic limb movement disorder", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("REM sleep behavior disorder", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Sleep terrors", Arrays.asList(site.activeProtocols));
        disqualifyQ5.put("Sleepwalking disorder", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ5.entrySet()) {
            System.out.println(entry.getKey());
            healthcareDiagnosedAnySleepPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(rotatingNightShiftPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("", site.activeProtocols)
                    .back(healthcareDiagnosedAnySleepPageCC);
        }

        healthcareDiagnosedAnySleepPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(rotatingNightShiftPageCC);
        //Q6
        TransitionStatementCC transitionStatementCC = rotatingNightShiftPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Disqualify (“Night shift or alternating sleep schedule”)
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad(transitionStatement)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(rotatingNightShiftPageCC);
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
        rotatingNightShiftPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
    }
}
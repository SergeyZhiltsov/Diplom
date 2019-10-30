package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.listeners.TestListener;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.LetsGetStartedPageOLS;
import com.acurian.selenium.pages.blinx.ams.ZipCodePageOLS;
import com.acurian.selenium.pages.outer.AcurianHealthPage;
import com.acurian.selenium.pages.outer.OlsLegacyDateOfBirthPage;
import com.acurian.selenium.pages.outer.OlsLegacyNumberPage;
import com.acurian.selenium.pages.outer.TheStudyPage;
import com.acurian.selenium.tests.OLS.ABRandomnessTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class WLPvalidation extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }


    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Description("WLP URL Validation & Re-direct Validation, only for PROD")
    public void wlpOlsTest() {
        String phoneNumber = "AUTGMEGA01";

        TheStudyPage theStudyPage = new TheStudyPage();
        theStudyPage
                .openPage()
                .waitForPageLoad();
        Assert.assertEquals(theStudyPage.getTitleText(), "Have MIGRAINES?", "Title text is diff");
        theStudyPage
                .clickGetStartedButton();

        OlsLegacyNumberPage olsLegacyNumberPage = new OlsLegacyNumberPage();
        OlsLegacyDateOfBirthPage olsLegacyDateOfBirthPage = olsLegacyNumberPage
                .waitForPageLoad()
                .typePhone(phoneNumber)
                .clickGoButton();

        olsLegacyDateOfBirthPage
                .waitForPageLoad();
    }


    @Test
    @Description("WLP URL Validation & Re-direct Validation, only for PROD")
    public void wlpOlsWsTest() {

        AcurianHealthPage acurianHealthPage = new AcurianHealthPage();

        acurianHealthPage
                .openPage()
                .waitForPageLoad()
                .clickSeeIfYouQualifyButton();

        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());

        getDriver().switchTo().window(tabs2.get(1));

        String title = getDriver().getTitle();

        if (title.equals("Acurian Clinical Screener")) { //OLS-WS
            DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
            dateOfBirthPageOLS.logTextToAllureAndConsole("OLS-WS");
            dateOfBirthPageOLS.waitForPageLoad2Ver();
            Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(), dateOfBirthPageOLS.
                    getExpectedModifiedTitle("a study", "1,000"), "Title is diff");
        } else if (title.equals("Screener")) { //BLINX
            LetsGetStartedPageOLS letsGetStartedPageOLS = new LetsGetStartedPageOLS();
            letsGetStartedPageOLS.logTextToAllureAndConsole("BLINX");
            letsGetStartedPageOLS.waitForPageLoad("a study", "1,000");
        } else {
            Assert.assertTrue(false, "Nor OLS-WS, nor BLINX");
        }
    }
}




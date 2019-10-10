package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.listeners.TestListener;
import com.acurian.selenium.pages.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import java.net.URISyntaxException;

public class ABRandomnessTest extends BaseTest {
    private int countA = 0;
    private int countB = 0;
    private int totalCount = 0;

    @Override
    public void setUp() {
        System.out.println("Skip standard driver load.");
    }

    @Override
    public void tearDown() {
        System.out.println("Skip standard driver quit.");
    }

    @Test(invocationCount = 10, skipFailedInvocations = true, enabled = true)
    public void abRandomnes() {
        //String testURL = "https://test-screener.acurian.com/questionnaire_test_staging_redirector/welcome?pn=800AMS1TST&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7";
        String testURL = "https://acurianhealth.com/questionnaire/welcome?pn=800AMS1TST";
        //&show_debug=1&testing_key=51fa2780f2430b542923956ac1974bb7
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            System.setProperty("webdriver.chrome.driver", ABRandomnessTest.class.getResource("/chromedriver.exe").toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().setSize(new Dimension(1400, 1050));
        webDriver.navigate().to(testURL);
        String title = webDriver.getTitle();

        checkPage(title);
        TestListener.attachScreenshot(new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(webDriver));

        webDriver.quit();
    }

    @Step()
    public void checkPage(String title) {
        logTextToAllureAndConsole("Page title was received: " + title);
        if (title.equals("Acurian Clinical Screener")) {
            countA++;
            Assert.assertEquals(title, "Acurian Clinical Screener");
        } else {
            countB++;
            Assert.assertEquals(title, "Screener");
        }
        totalCount++;
    }

    @Step()
    public void logTextToAllureAndConsole(String text) {
        System.out.println(text);
    }

    @AfterClass
    @Step()
    public void showResults() {
        logTextToAllureAndConsole("Total count of test run: " + totalCount);
        logTextToAllureAndConsole("Count for Acurian: " + countA);
        logTextToAllureAndConsole("Count for Blinx: " + countB);
    }
}

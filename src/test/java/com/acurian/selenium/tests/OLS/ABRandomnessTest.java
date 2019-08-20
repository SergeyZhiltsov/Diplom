package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.listeners.TestListener;
import com.acurian.selenium.pages.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

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

    @Test(invocationCount = 100, skipFailedInvocations = true)
    public void abRandomnes() {
        String testURL = "https://test-screener.acurian.com/questionnaire_test_staging_redirector/welcome?pn=800AMS1TST";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", ABRandomnessTest.class.getResource("/chromedriver.exe").getPath());
        WebDriver webDriver = new ChromeDriver(options);

        webDriver.navigate().to(testURL);
        String title = webDriver.getTitle();
        System.out.println(title);
        if (title.equals("Acurian Clinical Screener")) {
            countA++;
        } else {
            countB++;
        }
        totalCount++;
        TestListener.attachScreenshot(new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(webDriver));
        webDriver.quit();
    }

    @AfterClass
    public void showResults() {
        System.out.println("Total count of test run: " + totalCount);
        System.out.println("Count for Acurian: " + countA);
        System.out.println("Count for Blinx: " + countB);
    }
}

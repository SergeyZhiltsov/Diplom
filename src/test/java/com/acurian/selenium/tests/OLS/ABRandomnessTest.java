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

    @Test(invocationCount = 100, skipFailedInvocations = true)
    @Step("{0}")
    public void abRandomnes() {
        String testURL = "https://test-screener.acurian.com/questionnaire_test_staging_redirector/welcome?pn=800AMS1TST";

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
        System.out.println(title);
        if (title.equals("Acurian Clinical Screener")) {
            countA++;
            Assert.assertEquals(title, "Acurian Clinical Screener");
        } else {
            countB++;
            Assert.assertEquals(title, "Screener");
        }
        totalCount++;
        TestListener.attachScreenshot(new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(webDriver));
        webDriver.quit();
    }

    @AfterClass
    @Step("{0}")
    public void showResults() {
        System.out.println("Total count of test run: " + totalCount);
        System.out.println("Count for Acurian: " + countA);
        System.out.println("Count for Blinx: " + countB);
    }
}

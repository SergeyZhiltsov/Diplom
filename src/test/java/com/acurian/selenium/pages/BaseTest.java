package com.acurian.selenium.pages;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.listeners.EventHandler;
import com.acurian.selenium.utils.DriverFactory;
import com.acurian.selenium.utils.Properties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseTest {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private EventFiringWebDriver driver;

    public static WebDriver getDriver() {
//        return driver;
        return DRIVER.get();
    }

    @BeforeClass
    public void setUp() {
        driver = Properties.getGridURL().isEmpty()
                ? new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser()))
                : new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser(), Properties.getGridURL()));
//        driver = new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser()));
        driver.register(new EventHandler());
//        driverch.register(new EventHandler());
//        driver =  new StaleTolerantWebDriver(driverch);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                driver.manage().window().setSize(new Dimension(1400, 1050));
                break;
            case Platforms.TABLET:
                driver.manage().window().setSize(new Dimension(900, 1050));
                break;
            case Platforms.MOBILE:
                driver.manage().window().setSize(new Dimension(700, 1000));
                break;
        }
//        System.setProperty(ESCAPE_PROPERTY, "false");
        DRIVER.set(driver);
    }

    @AfterClass
    public void tearDown() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }

    /**
     *
     * @return Whether required browser displays content in mobile mode.
     */
    private boolean isMobileTesting(String browser) {
        switch (browser) {
            case "android":
                return true;
            case "firefox":
            case "ie":
            case "internet explorer":
            case "chrome":
            case "phantomjs":
            default:
                return false;
        }
    }

}

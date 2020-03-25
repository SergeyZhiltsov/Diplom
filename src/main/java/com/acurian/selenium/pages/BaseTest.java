package com.acurian.selenium.pages;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.listeners.EventHandler;
import com.acurian.selenium.listeners.TestListener;
import com.acurian.utils.DriverFactory;
import com.acurian.utils.Properties;
import com.acurian.utils.allure.AllureUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {

    private Logger Log = LogManager.getLogger(BaseTest.class.getName());

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private EventFiringWebDriver driver;

    public static WebDriver getDriver() {
//        return driver;
        return DRIVER.get();
    }

    public static boolean allureCounterRun = false;

    @BeforeMethod
    public void setUp() {

//        try {
//            driver = getHostName().equals(Properties.getHostNameSergey()) ? new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser(), Properties.getGridURL())) :
//                    (getHostName().equals(Properties.getHostNameIvan())) ? new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser(), Properties.getGridURLNew())) :
//                            (getHostName().equals(Properties.getHostName())) ? new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser())) : null;
//        }catch(Exception e){
        driver = new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser()));
//        }
        driver.register(new EventHandler());
        driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);

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
        if (!allureCounterRun) {
            AllureUtils.createProperties(getDriver());
            allureCounterRun = true;
        }
        Log.info("Browser version " + ((RemoteWebDriver) (((EventFiringWebDriver) getDriver()).getWrappedDriver())).getCapabilities().getVersion());
    }

    @AfterMethod
    public void tearDown() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }

    public String getHostName() {
        String hostname = null;
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException ex) {
            Log.info("Hostname can not be resolved");
        }
        return hostname;
    }

    /**
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

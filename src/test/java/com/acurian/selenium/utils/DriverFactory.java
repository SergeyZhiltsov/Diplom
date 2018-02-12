package com.acurian.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver initDriver(String browser) {
        DesiredCapabilities capabilities;
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getResourceByName("/geckodriver"));
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty(
                        "webdriver.ie.driver",
                        new File(DriverFactory.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                return new InternetExplorerDriver(capabilities);
            case "edge":
            case "MicrosoftEdge":
                System.setProperty(
                        "webdriver.edge.driver",
                        new File(DriverFactory.class.getResource("/MicrosoftWebDriver.exe").getFile()).getPath());
                return new EdgeDriver();
            case "phantomjs":
                System.setProperty("phantomjs.binary.path", getResourceByName("/phantomjs"));
                return new PhantomJSDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", getResourceByName("/chromedriver"));
                return new ChromeDriver();
        }
    }

    /**
     * @param resourceName The name of the resource ex /chromedriver
     * @return Path to resource
     */
    private static String getResourceByName(String resourceName){
        try {
            return new File(DriverFactory.class.getResource(resourceName + getExecutableExtension()).toURI()).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static WebDriver initDriver(String browser, String gridUrl) {
        // prepare capabilities for required browser
        DesiredCapabilities capabilities;
        switch (browser) {
            case "android":
                capabilities = DesiredCapabilities.android();
                break;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "ie":
            case "internet explorer":
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                break;
            case "edge":
            case "MicrosoftEdge":
                capabilities = DesiredCapabilities.edge();
                break;
            case "phantomjs":
                capabilities = DesiredCapabilities.phantomjs();
                break;
            case "chrome":
            default:
                capabilities = DesiredCapabilities.chrome();
//                capabilities.setCapability("applicationName", "node1");
                break;
        }

        // create instance of WebDriver
        try {
            return new RemoteWebDriver(new URL(gridUrl), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Unable to create RemoteWebDriver instance!");
        }
    }

    private static String getExecutableExtension() {
        return OSValidator.isWindows()
                ? ".exe"
                : OSValidator.isMac()
                ? "_mac"
                : "_linux";
    }

}

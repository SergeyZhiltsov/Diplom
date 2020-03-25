package com.acurian.utils.allure;


import com.acurian.selenium.pages.OLS.debug.ConfigPageOLS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class AllureUtils {

    private static Logger Log = LogManager.getLogger(AllureUtils.class.getName());

    public static void createProperties(WebDriver driver) {
        String patchToAllureDir = "target/allure-results";
        Properties props = new Properties();
        OutputStream output = null;
        Capabilities caps = ((RemoteWebDriver) (((EventFiringWebDriver) driver).getWrappedDriver())).getCapabilities();

        File dir = new File(patchToAllureDir);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                Log.info("Allure directory is created!");
            } else {
                Log.info("Failed to create allure directory!");
            }
        }

        try {
            output = new FileOutputStream(new File(patchToAllureDir + "/environment.properties"));
            props.setProperty("browser", caps.getBrowserName());
            props.setProperty("browserVersion", caps.getVersion());
            props.setProperty("environment", System.getProperty("acurian.env"));
            props.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

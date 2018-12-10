package com.acurian.selenium.utils.allure;


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

    public static void createProperties(WebDriver driver) {
        Properties props = new Properties();
        OutputStream output = null;
        Capabilities caps = ((RemoteWebDriver) (((EventFiringWebDriver) driver).getWrappedDriver())).getCapabilities();

        try {
            output = new FileOutputStream(new File("target/allure-results/environment.properties"));
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

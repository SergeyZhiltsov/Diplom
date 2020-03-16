package com.acurian.selenium.utils;

import org.openqa.selenium.remote.BrowserType;

public class Properties {

    private static final String DEFAULT_BASE_URL = "https://google.com";
    private static final String DEFAULT_BROWSER = BrowserType.CHROME;
    private static final String DEFAULT_USERNAME = "aautotest";
    private static final String DEFAULT_PASSWORD = "aautotest";
    private static final String DEFAULT_GRID_URL = "http://10.6.0.26:55555/wd/hub2";
    private static final String DEFAULT_GRID_URL_NEW = "http://10.6.0.26:66666/wd/hub2";
    private static final String DEFAULT_HOSTNAME = "QA-Selenium";
    private static final String DEFAULT_HOSTNAME_IVAN = "i-lipskyi-pc";
    private static final String DEFAULT_HOSTNAME_SERGEY = "s-zhyltsov-pc";

    private Properties() {
    }

    /**
     *
     * @return Website frontend.
     */
    public static String getBaseURL() {
        return System.getProperty(EnvironmentVariable.BASE_URL.toString(), DEFAULT_BASE_URL);
    }

    public static String getBrowser() {
        return System.getProperty(EnvironmentVariable.BROWSER.toString(), DEFAULT_BROWSER);
    }

    public static String getGridURL() {
        return DEFAULT_GRID_URL;
    }

    public static String getGridURLNew() {
        return DEFAULT_GRID_URL_NEW;
    }

    public static String getUsername() {
        return DEFAULT_USERNAME;
    }

    public static String getPassword() {
        return DEFAULT_PASSWORD;
    }

    public static String getHostName() {
        return DEFAULT_HOSTNAME;
    }

    public static String getHostNameIvan() {
        return DEFAULT_HOSTNAME_IVAN;
    }

    public static String getHostNameSergey() {
        return DEFAULT_HOSTNAME_SERGEY;
    }

    enum EnvironmentVariable {
        BASE_URL("env.url"),
        BROWSER("browser"),
        GRID("selenium.grid");

        private String value;

        EnvironmentVariable(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

}

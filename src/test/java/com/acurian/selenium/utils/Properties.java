package com.acurian.selenium.utils;

import org.openqa.selenium.remote.BrowserType;

public class Properties {

    private static final String DEFAULT_BASE_URL = "https://google.com";
    private static final String DEFAULT_BROWSER = BrowserType.CHROME;
    private static final String DEFAULT_USERNAME = "aautotest";
    private static final String DEFAULT_PASSWORD = "aautotest";

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
        return System.getProperty(EnvironmentVariable.GRID.toString(), "");
    }

    public static String getUsername() {
        return DEFAULT_USERNAME;
    }

    public static String getPassword() {
        return DEFAULT_PASSWORD;
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

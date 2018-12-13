package com.acurian.selenium.utils;

import org.testng.annotations.DataProvider;

public class DataProviderPool {

    @DataProvider(name = "UserCredentials")
    public static Object[][] getLoginData() {
        return new Object[][] {
                {"aautotest", "aautotest"}
        };
    }
}

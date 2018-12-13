package com.acurian.selenium.utils;

import org.testng.annotations.DataProvider;

public class DataProviderPool {

    @DataProvider(name = "UserCredentials")
    public static Object[][] getLoginData() {
        return new Object[][] {
                {"aautotest", "aautotest"}
        };
    }

    @DataProvider(name = "5034SitesWithDispo")
    public static Object[][] get5034SitesAndDispoData() {
        return new Object[][] {
                {"AUT_CV_5034A_site", "1R", "19001"},
                {"AUT_CV_5034S_site", "41C"}
        };
    }
}

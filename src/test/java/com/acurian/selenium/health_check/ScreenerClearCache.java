package com.acurian.selenium.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.clearCache.ClearCacheApp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class ScreenerClearCache extends BaseTest {

    @DataProvider(name = "logins")
    public Object[][] getData() {
        return new Object[][]{
                {"sysctrl", "headl3ss"},
        };
    }

    @Test(dataProvider = "logins")
    @Description("Screener Clear Cache verification")
    public void clearCacheCheck(String username, String password) {
        String env = System.getProperty("acurian.env", "QA");
        ClearCacheApp clearCacheApp = new ClearCacheApp();

        clearCacheApp.openSecuredPage(env, username, password);
        clearCacheApp.clearCacheFor("AMS1");
    }
}

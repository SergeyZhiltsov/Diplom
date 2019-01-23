package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.ScreenBuilderApp;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class SBClearCache extends BaseTest {

    @DataProvider(name = "logins")
    public Object[][] getData() {
        return new Object[][]{
                {"tanywhere02", "Automation2015"},
        };
    }

    @Test(dataProvider = "logins")
    @Description("SBClear Cache check")
    public void checkSbClearCache(String username, String password) {
        String env = System.getProperty("acurian.env", "QA");
        ScreenBuilderApp screenBuilder = new ScreenBuilderApp();

        if (!env.equals("QA") && !env.equals("PRD"))
            throw new IllegalArgumentException("SB available only on QA or PRD env");

        screenBuilder.openPage(env);

        screenBuilder.loginAs(username, password);
        screenBuilder.searchStudy("GRA1");
        screenBuilder.clearStudyCacheOf("GRA1 - Rheumatoid Arthritis (RA)", ScreenBuilderApp.CachEnv.QA);

        Assert.assertEquals(screenBuilder.cacheClearedSuccessAlert.getText(), "×\nCleared Cache for Study 6697 successfully on QA.", "Success alert is diff or absent");


    }

}
package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.ScreenBuilderApp;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

public class SBClearCachePublish extends BaseTest {

    @DataProvider(name = "logins")
    public Object[][] getData() {
        return new Object[][]{
                {"tanywhere02@acurian.com", "Automation2015"}
        };
    }

    @Test(dataProvider = "logins")
    @Description("SBClear Cache check")
    public void checkSbClearCache(String username, String password) {
        String env = System.getProperty("acurian.env", "QA");
        ScreenBuilderApp screenBuilder = new ScreenBuilderApp();

        if (env.equals("STG")) {
            throw new IllegalArgumentException("SB available only on QA or PRD env");
        }

        screenBuilder.openPage(env);

        ImageDiff diff = screenBuilder.getDiff(screenBuilder.getExpectedLogoImage(), screenBuilder.getActualLogoImage());
        Assert.assertFalse(diff.hasDiff(), "Logos are differs!");

        screenBuilder.loginAs(username, password);
        screenBuilder.searchStudy("GRA1");

        screenBuilder.publishStudySetup("GRA1 - Rheumatoid Arthritis (RA)", ScreenBuilderApp.SetupEnv.valueOf(env), env);
        Assert.assertEquals(screenBuilder.cacheClearedSuccessAlert.getText(), "×\nGRA1 published to "
                + (env.equals("QA") ? env : "PROD") + " Successfully. Cleared Cache for Study 6697 successfully.", "Success alert is diff or absent");

        screenBuilder.clearStudyCacheOf("GRA1 - Rheumatoid Arthritis (RA)", ScreenBuilderApp.SetupEnv.valueOf(env));
        Assert.assertEquals(screenBuilder.cacheClearedSuccessAlert.getText(), "×\nCleared Cache for Study 6697 " +
                "successfully on " + (env.equals("QA") ? env : "PROD") + ".", "Success alert is diff or absent");
    }
}
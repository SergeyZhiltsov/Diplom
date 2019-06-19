package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.LoginSBPage;
import com.acurian.selenium.pages.SB.ScreenBuilderApp;
import com.acurian.selenium.pages.SB.StudyProjectsListPage;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class SBClearCachePublish extends BaseTest {

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("SBClear Cache check")
    public void checkSbClearCache(String username, String password) {
        String env = System.getProperty("acurian.env", "QA");
        LoginSBPage loginSBPage = new LoginSBPage();
        ScreenBuilderApp screenBuilder = new ScreenBuilderApp();
        StudyProjectsListPage studyProjectsListPage = new StudyProjectsListPage();

        loginSBPage.openPage(env);

        Assert.assertFalse(loginSBPage.checkLogoImage().hasDiff(), "Logos are differs!");

        loginSBPage.loginAs(username, password)
                .searchForStudy("GRA1");

        studyProjectsListPage.clickPublishStudySetup("GRA1 - Rheumatoid Arthritis (RA)", StudyProjectsListPage.SetupEnv.valueOf(env));
        Assert.assertEquals(screenBuilder.cacheClearedSuccessAlert.getText(), "×\nGRA1 published to "
                + (env.equals("QA") ? env : "PROD") + " Successfully. Cleared Cache for Study 6697 successfully.", "Success alert is diff or absent");

        studyProjectsListPage.clearStudyCacheOf("GRA1 - Rheumatoid Arthritis (RA)", StudyProjectsListPage.SetupEnv.valueOf(env));
        Assert.assertEquals(screenBuilder.cacheClearedSuccessAlert.getText(), "×\nCleared Cache for Study 6697 " +
                "successfully on " + (env.equals("QA") ? env : "PROD") + ".", "Success alert is diff or absent");
    }
}
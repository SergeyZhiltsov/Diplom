package com.acurian.selenium.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.LoginSBPage;
import com.acurian.selenium.pages.SB.SaveStudyDiffSummaryPage;
import com.acurian.selenium.pages.SB.ScreenBuilderApp;
import com.acurian.selenium.pages.SB.StudyProjectsListPage;
import com.acurian.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;


public class SBClearCachePublish extends BaseTest {
    String env = System.getProperty("acurian.env", "QA");
    final String studyName = "GRA1 - Rheumatoid Arthritis (RA)";
    final String projectCode = "GRA1";
    String studyId = null;
    String alertMessage = null;

    public SBClearCachePublish() {
        setEnvData(env);
    }

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("SBClear Cache check")
    public void checkSbClearCache(String username, String password) {

        LoginSBPage loginSBPage = new LoginSBPage();
        ScreenBuilderApp screenBuilder = new ScreenBuilderApp();
        StudyProjectsListPage studyProjectsListPage = new StudyProjectsListPage();

        loginSBPage
                .openPage(env)
                .waitForPageLoad();

        Assert.assertFalse(loginSBPage.checkLogoImage().hasDiff(), "Logos are differs!");

        loginSBPage.loginAs(username, password)
                .searchForStudy(studyName);

        studyProjectsListPage.clickPublishStudySetup(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp();
        SaveStudyDiffSummaryPage saveStudyDiffSummaryPage = new SaveStudyDiffSummaryPage();
        if (env.equals("QA")) {
            saveStudyDiffSummaryPage.clickPublishToEnvironment();
        }
        Assert.assertEquals(screenBuilder.cacheClearedSuccessAlert.getText(),
                String.format("×\n%s published to %s Successfully. Cleared Cache for Study %s successfully.",
                        projectCode, alertMessage, studyId), "Success alert is diff or absent");

        studyProjectsListPage.clearStudyCacheOf(studyName, StudyProjectsListPage.SetupEnv.valueOf(env));
        Assert.assertEquals(screenBuilder.cacheClearedSuccessAlert.getText(),
                String.format("×\nCleared Cache for Study %s successfully on %s.", studyId, alertMessage),
                "Success alert is diff or absent");
    }

    private void setEnvData(String env) {
        switch (env) {
            case "PRD":
                studyId = "6697";
                alertMessage = "PROD";
                break;
            case "STG":
                studyId = "6697";
                alertMessage = "STAGING";
                break;
            case "QA":
            default:
                studyId = "6697";
                alertMessage = "QA";
        }
    }
}
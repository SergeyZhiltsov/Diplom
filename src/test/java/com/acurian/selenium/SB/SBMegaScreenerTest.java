package com.acurian.selenium.SB;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.*;
import com.acurian.selenium.SB.dependentScreeners.SB_AUTSBMGmodified;
import com.acurian.utils.DataProviderPool;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class SBMegaScreenerTest extends BaseTest {
    String env = System.getProperty("acurian.env", "QA");
    final String studyName = "AUTSBMG - Research Study (Copy)";
    final String projectCode = "AUTSBMG";
    String studyId = null;
    String alertMessage = null;
    final String therapeuticName = "Gastrointestinal";
    final String indicationName = "Low Back Pain";

    private SBMegaScreenerTest() {
        setEnvData(env);
    }



    @Test(enabled = false, priority = -1, dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic MS project changes test (deletion data)")
    public void initialProjectChanges(String username, String password) {
        final String env = System.getProperty("acurian.env", "QA");
        final String questionText = "Are you providing information for yourself or on behalf of someone else? (some changes in text)";

        LoginSBPage loginSBPage = new LoginSBPage();
        StudyEditPage studyEditPage = new StudyEditPage();

        loginSBPage
                .openPage(env)
                .loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
                .deleteIndication(indicationName)
                .addTherapeutic(therapeuticName)
                .clickSave()
                .checkSaveAlertMessage(String.format("%s saved Successfully", projectCode))
        //Question changes
                .clickQuestionBuilderLink()
                .clickIntroLink("5")
                .typeQuestionTextInVisibleField(questionText, 1)
                .clickSaveQuestion()
                .clickSave()
                .checkStudyAlertMessage(String.format("×\nQuestions for study %s saved Successfully", projectCode));
        //Logic changes
        studyEditPage
                .clickLogicBuilderLink()
                .clickCoreLink()
                .clickSubCoreLink(1)
                .clickFlowLogicOption(1)
                .selectActionForCoreAndRule(1, 1, "Core-QS3")
                .clickSaveLogic()
                .checkAlertMessage("Saved all modified logic Successfully !!!");
        //Public study
        studyEditPage
                .clickDashboard()
                .clickPublishStudySetup(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .checkAddedTherapeutic(therapeuticName)
                .checkDeletedIndication(indicationName)
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp();
        SaveStudyDiffSummaryPage saveStudyDiffSummaryPage = new SaveStudyDiffSummaryPage();
        StudyProjectsListPage studyProjectsListPage = new StudyProjectsListPage();
        if (env.equals("QA")) {
            saveStudyDiffSummaryPage.clickPublishToEnvironment();
        }
        studyProjectsListPage
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. " +
                        "Cleared Cache for Study %s successfully.", projectCode, alertMessage, studyId))
                //Public questions
                .clickPublishQuestions(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp();
        QuestionnaireDiffSummaryPage questionnaireDiffSummaryPage = new QuestionnaireDiffSummaryPage();
        if (env.equals("QA")) {
            questionnaireDiffSummaryPage.clickPublishToEnvironment();
        }
        studyProjectsListPage
                .checkAlertMessage(String.format("×\nScreener for project %s published to %s Successfully. " +
                        "Cleared Cache for Study %s successfully.", projectCode, alertMessage, studyId))
        //Public logic
                .clickPublishLogic(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp();
        LogicDiffSummaryPage logicDiffSummaryPage = new LogicDiffSummaryPage();
        if (env.equals("QA")) {
            logicDiffSummaryPage.clickPublishToEnvironment();
        }
        studyProjectsListPage
                .checkAlertMessage(String.format("×\nScreener Logic for project %s published to %s Successfully. " +
                        "Cleared Cache for Study %s successfully.", projectCode, alertMessage, studyId));
    }

    @Test(enabled = false, priority = 0, dependsOnMethods = "initialProjectChanges")
    @Description("Run_MegaScreener_AUTSBMG")
    public void run_AUTSBMG() {
        SB_AUTSBMGmodified autsbmGmodified = new SB_AUTSBMGmodified();
        autsbmGmodified.sb_AUTSBMGmodified();
    }

    @Test(enabled = false, priority = 1, dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic MS project changes test (addition data)")
    public void revertProjectChanges(String username, String password) {
        final String env = System.getProperty("acurian.env", "QA");
        final String oldQuestionText = "Are you providing information for yourself or on behalf of someone else?";

        StudyEditPage studyEditPage = new StudyEditPage();
        LoginSBPage loginSBPage = new LoginSBPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
                .addIndication(indicationName)
                .deleteTherapeutic(therapeuticName)
                .clickSave()
                .checkSaveAlertMessage(String.format("%s saved Successfully", projectCode))
        //Question changes
                .clickQuestionBuilderLink()
                .clickIntroLink("5")
                .typeQuestionTextInVisibleField(oldQuestionText, 1)
                .clickSaveQuestion()
                .clickSave()
                .checkStudyAlertMessage(String.format("×\nQuestions for study %s saved Successfully", projectCode));
        //Logic changes
        studyEditPage
                .clickLogicBuilderLink()
                .clickCoreLink()
                .clickSubCoreLink(1)
                .clickFlowLogicOption(1)
                .selectActionForCoreAndRule(1, 1, "Core-QS2")
                .clickSaveLogic()
                .checkAlertMessage("Saved all modified logic Successfully !!!");
        //Public study
        studyEditPage
                .clickDashboard()
                .clickPublishStudySetup(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .checkDeletedTherapeutic(therapeuticName)
                .checkAddedIndication(indicationName)
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp();
        SaveStudyDiffSummaryPage saveStudyDiffSummaryPage = new SaveStudyDiffSummaryPage();
        StudyProjectsListPage studyProjectsListPage = new StudyProjectsListPage();
        if (env.equals("QA")) {
            saveStudyDiffSummaryPage.clickPublishToEnvironment();
        }
        studyProjectsListPage
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. " +
                        "Cleared Cache for Study %s successfully.", projectCode, alertMessage, studyId))
        //Public questions
                .clickPublishQuestions(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp();
        QuestionnaireDiffSummaryPage questionnaireDiffSummaryPage = new QuestionnaireDiffSummaryPage();
        if (env.equals("QA")) {
            questionnaireDiffSummaryPage.clickPublishToEnvironment();
        }
        studyProjectsListPage
                .checkAlertMessage(String.format("×\nScreener for project %s published to %s Successfully. " +
                        "Cleared Cache for Study %s successfully.", projectCode, alertMessage, studyId))
        //Public logic
                .clickPublishLogic(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp();
        LogicDiffSummaryPage logicDiffSummaryPage = new LogicDiffSummaryPage();
        if (env.equals("QA")) {
            logicDiffSummaryPage.clickPublishToEnvironment();
        }
        studyProjectsListPage
                .checkAlertMessage(String.format("×\nScreener Logic for project %s published to %s Successfully. " +
                        "Cleared Cache for Study %s successfully.", projectCode, alertMessage, studyId));
    }

    private void setEnvData(String env) {
        switch (env) {
            case "PRD":
                studyId = "";
                alertMessage = "PROD";
                break;
            case "STG":
                studyId = "";
                alertMessage = "STAGING";
                break;
            case "QA":
            default:
                studyId = "8103";
                alertMessage = "QA";
        }
    }
}
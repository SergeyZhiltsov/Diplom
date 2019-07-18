package com.acurian.selenium.tests.SB;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.*;
import com.acurian.selenium.tests.SB.dependentScreeners.SB_AUTSBSSmodified;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class SBStandAloneTest extends BaseTest {
    String env = System.getProperty("acurian.env", "QA");
    final String studyName = "AUTSBSS - Rheumatoid Arthritis (RA)";
    final String projectCode = "AUTSBSS";
    String studyId = null;
    String alertMessage = null;
    final String therapeuticName = "Neurology";
    final String indicationName = "Low Back Pain";

    public SBStandAloneTest() {
        setEnvData(env);
    }

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(priority = -1, dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic project changes test (deletion/addition data)")
    public void initialProjectChanges(String username, String password) {
        final String modifiedQuestionText = "What is your date of birth? (some text modified)";

        LoginSBPage loginSBPage = new LoginSBPage();
        StudyEditPage studyEditPage = new StudyEditPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
                .deleteIndication(indicationName)
                .addTherapeutic(therapeuticName)
                .clickSave()
                .checkSaveAlertMessage(String.format("%s saved Successfully", projectCode))
        //Question changes
                .clickQuestionBuilderLink()
                .clickIntroLink("2")
                .clickIntroSubQuestionTab("OLS")
                .clickIntroSubQuestionOLS("2.1")
                .typeQuestionTextInVisibleField(modifiedQuestionText, 2)
                .clickSaveChildQuestion()
                //.checkQuestionSaveAlertMessage("Question saved successfully!!!, Make sure to save parent question!!") //TODO
                .clickSaveQuestion()
                //.checkQuestionSaveAlertMessage("Question saved successfully!!!") //TODO
                .clickSave()
                .checkStudyAlertMessage(String.format("×\nQuestions for study %s saved Successfully", projectCode));
        //Logic changes
        studyEditPage
                .clickLogicBuilderLink()
                .clickCoreLink()
                .clickSubCoreLink(1)
                .clickFlowLogicOption(1)
                .selectActionForCoreAndRule(1, 2, "Core-QS3")
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

    @Test(priority = 1, dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic SA project changes test (deletion/addition data)")
    public void revertProjectChanges(String username, String password) {
        final String oldQuestionText = "What is your date of birth?";

        LoginSBPage loginSBPage = new LoginSBPage();
        StudyEditPage studyEditPage = new StudyEditPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
                .addIndication(indicationName)
                .deleteTherapeutic(therapeuticName)
                .clickSave()
                .checkSaveAlertMessage(String.format("%s saved Successfully", projectCode))
        //Question changes
                .clickQuestionBuilderLink()
                .clickIntroLink("2")
                .clickIntroSubQuestionTab("OLS")
                .clickIntroSubQuestionOLS("2.1")
                .typeQuestionTextInVisibleField(oldQuestionText, 2)
                .clickSaveChildQuestion()
                //.checkQuestionSaveAlertMessage("Question saved successfully!!!, Make sure to save parent question!!") //TODO
                .clickSaveQuestion()
                //.checkQuestionSaveAlertMessage("Question saved successfully!!!") //TODO
                .clickSave()
                .checkStudyAlertMessage(String.format("×\nQuestions for study %s saved Successfully", projectCode));
        //Logic changes
        studyEditPage
                .clickLogicBuilderLink()
                .clickCoreLink()
                .clickSubCoreLink(1)
                .clickFlowLogicOption(1)
                .selectActionForCoreAndRule(1, 2, "Core-QS2")
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

    @Test(priority = 0, dependsOnMethods = "initialProjectChanges")
    @Description("Run Standalone Screener AUTSBSS after SB changes is published")
    public void run_AUTSBSS() {
        SB_AUTSBSSmodified autsbsSmodified = new SB_AUTSBSSmodified();
        autsbsSmodified.sb_AUTSBSSmodified();
    }

    private void setEnvData(String env) {
        switch (env) {
            case "PRD":
                studyId = "";
                alertMessage = "PROD";
                break;
            case "STG":
                studyId = "8002";
                alertMessage = "STAGING";
                break;
            case "QA":
            default:
                studyId = "8104";
                alertMessage = "QA";
        }
    }
}
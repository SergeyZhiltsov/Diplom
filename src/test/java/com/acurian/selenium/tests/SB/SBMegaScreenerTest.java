package com.acurian.selenium.tests.SB;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.LoginSBPage;
import com.acurian.selenium.pages.SB.StudyEditPage;
import com.acurian.selenium.pages.SB.StudyProjectsListPage;
import com.acurian.selenium.tests.SB.dependentScreeners.SB_AUTSBMG;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class SBMegaScreenerTest extends BaseTest {
    String env = System.getProperty("acurian.env", "QA");
    final String studyName = "AUTSBMG - Research Study (Copy)";
    final String projectCode = "AUTSBMG";
    String studyId = null;
    String alertMessage = null;
    final String therapeuticName = "Gastrointestinal";
    final String indicationName = "Arthritis";

    private SBMegaScreenerTest() {
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

    @Test(enabled = false, priority = -1, dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic MS project changes test (deletion data)")
    public void initialProjectChanges(String username, String password) {
        final String env = System.getProperty("acurian.env", "QA");
        final String questionText = "Are you providing information for yourself or on behalf of someone else? (some changes in text)";

        LoginSBPage loginSBPage = new LoginSBPage();
        StudyEditPage studyEditPage = new StudyEditPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
//                .deleteIndication(indicationName)
//                .deleteTherapeutic(therapeuticName)
//                .clickSave()
//                .checkSaveAlertMessage(String.format("%s saved Successfully", projectCode))
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
                .clickSubCoreLink(2)
                .clickFlowLogicOption(1)
                .selectActionForCoreAndRule(1, 2, "Core-QS3")
                .clickSaveLogic()
                .checkAlertMessage("Saved all modified logic Successfully !!!");
        //Public study
        studyEditPage
                .clickDashboard()
                .clickPublishStudySetup(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .checkDeletedTherapeutic(therapeuticName)
                .checkDeletedIndication(indicationName)
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp()
                .clickPublishToEnvironment()
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. Cleared Cache for Study %s successfully.",
                        projectCode, alertMessage, studyId));
    }

    @Test(enabled = false, priority = 1, dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic MS project changes test (addition data)")
    public void revertProjectChanges(String username, String password) {
        final String env = System.getProperty("acurian.env", "QA");
        final String oldQuestionText = "Let's check if you are eligible for a clinical research study!";

        LoginSBPage loginSBPage = new LoginSBPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
                .addIndication(indicationName)
                .addTherapeutic(therapeuticName)
                .clickSave()
                .checkSaveAlertMessage(String.format("%s saved Successfully", projectCode))
        //Question changes
                .clickQuestionBuilderLink()
                .clickIntroLink("1")
                .typeQuestionTextInVisibleField(oldQuestionText, 2)
                .clickSaveQuestion()
                .clickSave()
                .checkStudyAlertMessage(String.format("×\nQuestions for study %s saved Successfully", projectCode));
        //Public study
        StudyEditPage studyEditPage = new StudyEditPage();
        studyEditPage
                .clickDashboard()
                .clickPublishStudySetup(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .checkAddedTherapeutic(therapeuticName)
                .checkAddedIndication(indicationName)
                .clickSaveAndPublish()
                .clickConfirmPublishOnPopUp()
                .clickPublishToEnvironment()
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. Cleared Cache for Study %s successfully.",
                        projectCode, alertMessage, studyId));
    }

    @Test(enabled = false, priority = 0, dependsOnMethods = "initialProjectChanges")
    @Description("Run_MegaScreener_AUTSBMG")
    public void run_AUTSBMG() {
        SB_AUTSBMG sb_MG = new SB_AUTSBMG();
        sb_MG.sb_AUTSBMG();
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
package com.acurian.selenium.tests.SB;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.StudyEditPage;
import com.acurian.selenium.pages.SB.StudyProjectsListPage;
import com.acurian.selenium.pages.SB.LoginSBPage;
import com.acurian.selenium.tests.OLS.SB_AUTSBSS;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class SBStandAloneTest extends BaseTest {
    final String studyName = "AUTSBSS - Rheumatoid Arthritis (RA)";
    final String projectCode = "AUTSBSS";
    final String studyId = "8104";
    final String therapeuticName = "Neurology";
    final String indicationName = "Diabetes";

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic project changes test (deletion/addition data)")
    public void initialProjectChanges(String username, String password) {
        final String env = System.getProperty("acurian.env", "QA");
        final String questionText = "Thank you for calling Acurian's rheumatoid (some changes in text) arthritis research line. " +
                "My name is %OPERATOR_NAME% and I'll be able to help you. Are you calling about a research study today?";

        LoginSBPage loginSBPage = new LoginSBPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
                .deleteIndication(indicationName)
                .addTherapeutic(therapeuticName)
                .clickSave()
                .checkSaveAlertMessage(String.format("%s saved Successfully", projectCode))
         //Question changes
                .clickQuestionBuilderLink()
                .clickOnIntroQuestion(1)
                .typeQuestionTextToFirstIntro(questionText)
                .clickSaveFirstQuestion()
                .clickSave()
                .checkStudyAlertMessage(String.format("×\nQuestions for study %s saved Successfully", projectCode));
        //Public study
        StudyEditPage studyEditPage = new StudyEditPage();
        studyEditPage
                .clickDashboard()
                .clickPublishStudySetup(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .checkAddedTherapeutic(therapeuticName)
                .checkDeletedIndication(indicationName)
                .clickOnSaveAndPublish()
                .clickConfirmPublishOnPopUp()
                .clickPublishToEnvironment()
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. Cleared Cache for Study %s successfully.",
                projectCode, (env.equals("QA") ? env : "PROD"), studyId));
    }

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class,
            dependsOnMethods = "initialProjectChanges")
    @Description("Basic SA project changes test (deletion/addition data)")
    public void revertProjectChanges(String username, String password) {
        final String env = System.getProperty("acurian.env", "QA");
        final String oldQuestionText = "Thank you for calling Acurian's rheumatoid arthritis research line. " +
                "My name is %OPERATOR_NAME% and I'll be able to help you. Are you calling about a research study today?";

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
                .clickOnIntroQuestion(1)
                .typeQuestionTextToFirstIntro(oldQuestionText)
                .clickSaveFirstQuestion()
                .clickSave()
                .checkStudyAlertMessage(String.format("×\nQuestions for study %s saved Successfully", projectCode));
        //Public study
        StudyEditPage studyEditPage = new StudyEditPage();
        studyEditPage
                .clickDashboard()
                .clickPublishStudySetup(studyName, StudyProjectsListPage.SetupEnv.valueOf(env))
                .checkDeletedTherapeutic(therapeuticName)
                .checkAddedIndication(indicationName)
                .clickOnSaveAndPublish()
                .clickConfirmPublishOnPopUp()
                .clickPublishToEnvironment()
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. Cleared Cache for Study %s successfully.",
                        projectCode, (env.equals("QA") ? env : "PROD"), studyId));
    }

    @Test()
    @Description("Run_StandaloneScreener_AUTSBSS")
    public void run_AUTSBSS()
    {
        SB_AUTSBSS sb_SS = new SB_AUTSBSS();
        sb_SS.sb_AUTSBSS();
    }
}
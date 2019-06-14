package com.acurian.selenium.tests.SB;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.LoginSBPage;
import com.acurian.selenium.pages.SB.StudyEditPage;
import com.acurian.selenium.pages.SB.StudyProjectsListPage;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class SBMegaScreenerTest extends BaseTest {
    final String studyName = "AUTSBMG - Research Study (Copy)";
    final String projectCode = "AUTSBMG";
    final String studyId = "8103";
    final String therapeuticName = "Gastrointestinal";
    final String indicationName = "Arthritis";

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("Basic MS project changes test (deletion data)")
    public void initialProjectChanges(String username, String password) {
        final String env = System.getProperty("acurian.env", "QA");
        final String questionText = "Let's check (some changes in text) if you are eligible for a clinical research study!";

        LoginSBPage loginSBPage = new LoginSBPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(studyName)
                .clickOnStudyName(studyName)
                .deleteIndication(indicationName)
                .deleteTherapeutic(therapeuticName)
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
                .checkDeletedTherapeutic(therapeuticName)
                .checkDeletedIndication(indicationName)
                .clickOnSaveAndPublish()
                .clickConfirmPublishOnPopUp()
                .clickPublishToEnvironment()
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. Cleared Cache for Study %s successfully.",
                        projectCode, (env.equals("QA") ? env : "PROD"), studyId));
    }

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class,
             dependsOnMethods = "initialProjectChanges")
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
                .checkAddedTherapeutic(therapeuticName)
                .checkAddedIndication(indicationName)
                .clickOnSaveAndPublish()
                .clickConfirmPublishOnPopUp()
                .clickPublishToEnvironment()
                .checkAlertMessage(String.format("×\n%s published to %s Successfully. Cleared Cache for Study %s successfully.",
                        projectCode, (env.equals("QA") ? env : "PROD"), studyId));
    }
}
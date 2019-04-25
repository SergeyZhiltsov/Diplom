package com.acurian.selenium.pages.CC;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.selenium.utils.PassPID;
import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.ChildResult;
import com.acurian.selenium.utils.db.RadiantResults;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageCC extends BasePage {

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;

    String pid;
    String dispoParent;
    String dispoChild;

    public MainPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForAnimation() {
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) getDriver()).executeScript(
                "return document.readyState"
        ).equals("complete"));
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> (boolean) ((JavascriptExecutor) getDriver()).executeScript(
                "return jQuery.active == 0"
        ));
    }

    @Step
    public MainPageCC assertChildDOBIsNull(String env, String studyId) {
        String childDOBCell = getDbConnection().dbReadChildDOB(env, pid, studyId);
        Assert.assertNull(childDOBCell,"Child DOB is not NULL");
        logTextToAllure("Child DOB cell: " + childDOBCell);
        return this;
    }

    //should use only once cause PassPID.getInstance() after second get will be null
    @Step
    public MainPageCC pidFromDbToLog(String env) {
        pid = PassPID.getInstance().getPidNumber();
        getDbConnection().dbReadPID(env, pid);
        dispoParent = getDbConnection().getDispo();
        logTextToAllure("Parent dispo = " + dispoParent + " for PID " + pid);
        return this;
    }

    @Step
    public MainPageCC childPidFromDbToLog(String env, String ...firstPartOfChildPhoneNumber) {
        ChildResult childResult = getDbConnection().dbReadChildPID(env, pid, firstPartOfChildPhoneNumber);
        dispoChild = childResult.getDispoCd() + childResult.getApplicantStatus();
        logTextToAllure("Child dispo =" + childResult.getDispoCd() + childResult.getApplicantStatus() + " for PID " + pid +
                " with child pid = "+ childResult.getChildPid());
        return this;
    }

    @Step
    public MainPageCC getRadiantDbToLog(String env, String ... assertStudyReference) {
        if(env.equals("QA")) {
            RadiantResults radiantResults = getDbConnection().dbReadRadiant(env, pid);
            logTextToAllure("Radiant : current status = " + radiantResults.getCurrentStatus() +
                    ", response message = " + radiantResults.getResponseMessage() +
                    ", study reference = " + radiantResults.getStudyReference() +
                    " for PID " + pid);
            Assert.assertEquals(radiantResults.getCurrentStatus(), "SENT", "Current status is not SENT");
            Assert.assertEquals(radiantResults.getResponseMessage(), "Success", "Response message is not Success");
            Assert.assertNotNull(radiantResults.getStudyReference(), "Study reference is NULL");
            List<String> studyReference = Arrays.asList(radiantResults.getStudyReference().split(":"));
            Assert.assertFalse(studyReference.size() < 2, "Study reference response is not full");
            Assert.assertFalse(studyReference.get(0).isEmpty() || studyReference.get(0).contentEquals("null"),
                    "First part is empty or null");
            Assert.assertFalse(studyReference.get(1).isEmpty() || studyReference.get(1).contentEquals("null"),
                    "Second part is empty or null");
            if (assertStudyReference.length == 1) {
                Assert.assertNotNull(radiantResults.getStudyReference(), "Study reference is NULL");
                Assert.assertEquals(radiantResults.getStudyReference(), assertStudyReference[0], "Study reference is not matched!");
            }
        }
        return this;
    }

//    @Step
//    public MainPageCC getAnomalyDbToLog(String env) {
//        AnomalyResults anomalyResults = getDbConnection().dbReadAnomaly(env, pid);
//        logTextToAllure("Anomaly : Current Status=" + anomalyResults.getCurrentStatus() + " Request Status id=" + anomalyResults.getRequestStatus() + " for pid " + pid);
//        return this;
//    }

    /**
     Save site name to temp file for further validation

     @param siteName to queue for validation
     */
    @Step
    public synchronized void queueSiteForFULCheck(String siteName) {
        FollowupLetter ful = new FollowupLetter();
        String stringQuery = pid + "," + siteName;
        StringBuilder sb = new StringBuilder();
        String line;

        if(ful.getFulsToBeVerifiedFile().exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(ful.getFulsToBeVerifiedFile()))) {
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                System.out.println("Rewriting existing data from file:");
                System.out.println(sb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ful.getFulsToBeVerifiedFile()))) {
            bw.write(sb.toString());
            System.out.println("Queued new site for FUL validation to file: " + stringQuery);
            bw.write(stringQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step
    public <T extends MainPageCC> T clickNextButton(T page) {
        nextButton.click();
        return (T) page;
    }


    public String getParentDispo() {
        return dispoParent;
    }

    public String getChildDispo() {
        return dispoChild;
    }

    @Step
    public MainPageCC dispoShouldMatch(String expectedParentDispo, String ...expectedChildDispo) {
        Assert.assertEquals(getParentDispo(), expectedParentDispo, "Dispo for Parent is different");
        if (expectedChildDispo.length == 1){
            Assert.assertEquals(getChildDispo(), expectedChildDispo[0], "Dispo for Child is different");
        }
        return this;
    }

    @Override
    public String toString() {
        Class aClass = this.getClass();
        return aClass.getSimpleName() + " - " + aClass.getPackage().toString();
    }

    @Step
    public <T extends MainPageCC> T getPage(T page) {
        return (T) page;
    }

    @Step
    public <T extends MainPageCC> T back(T page) {
        back();
        return (T) page;
    }

    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        logTextToAllure(this.getClass().getSimpleName() + " class with:");
        textToAttachment(titleExpected, "Title text");
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        try {
            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        } catch (TimeoutException ex) {
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
    }

    protected void clickOnRadioButton(List<WebElement> radioButtonList, String answerText) {
        radioButtonList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String... answerText) {
        List<String> answerTextList = Arrays.asList(answerText);

        List<String> elementsTextActual = checkBoxList.stream().map(el -> el.getText()).collect(Collectors.toList());
        List<String> answersNotIncluded = answerTextList.stream().filter(el -> elementsTextActual.parallelStream()
                .noneMatch(el2 -> el2.contains(el))).collect(Collectors.toList());
        Assert.assertFalse(answersNotIncluded.size() > 0, "Some answers are not correct " +
                answersNotIncluded + "\n" +
                "expected to click are " + answerTextList + "\n" +
                "actual on page are " + elementsTextActual);

        checkBoxList.stream().filter(el -> answerTextList.parallelStream().anyMatch(el.getText()::startsWith))//answerTextList.contains(el.getText())
                .forEach(el -> el.click());
        waitForAnimation();
    }
}

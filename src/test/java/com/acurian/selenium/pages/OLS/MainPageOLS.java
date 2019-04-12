package com.acurian.selenium.pages.OLS;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.utils.PassPID;
import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.ChildResult;
import com.acurian.selenium.utils.db.RadiantResults;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
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

public class MainPageOLS extends BasePage {

    @FindBy(xpath = "//button[@id='submit']")
    WebElement nextButton;

    @FindBy(xpath = "//img[starts-with(@src,'http')]")
    private List<WebElement> images;

    String pid;
    String cpid;
    String dispoParent;
    String dispoChild;


    public MainPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForAnimation() {
        ngDriver.waitForAngularRequestsToFinish();
    }

    @Step
    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        logTextToAllure(this.getClass().getSimpleName() + " class with:");
        textToAttachment(titleExpected, "Title text expected");
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        try {
            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        } catch (TimeoutException ex) {
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
//        try {
//            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
//        }
//        catch (NullPointerException ex){
//            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
//        }
        waitForAnimation();
    }

    /*
    Wait for images from third party resources to load both on mobile and desktop
    Use it when you need to wait until all external images are loaded
     */
    @Step
    protected void waitForImagesToLoad() {
        try {
            for (WebElement image : images) {
                driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) webDriver -> (Boolean) ((JavascriptExecutor) webDriver).executeScript("return arguments[0].complete", image));
            }
        } catch (TimeoutException e) {
            Assert.fail("Failed to load images");
            throw e;
        }
    }

    @Step
    public <T extends MainPageOLS> T clickNextButton(T page) {
        nextButton.click();
        return (T) page;
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
        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                .forEach(el -> getActions().moveToElement(el.findElement(By.xpath("ancestor::label/span[contains(@class,'debug-question-helper')]")), 5, 5).click().build().perform());
//            for (WebElement el : checkBoxList) {
//                if (answerTextList.contains(el.getText())) {
////                scrollToElement(el, true);
//                    threadSleep(1000);
//                    getActions().moveToElement(el.findElement(By.xpath("ancestor::label")), 5, 5).click().perform();
//                    threadSleep(5000);
//                }
//            }
        waitForAnimation();
    }

    @Step
    public <T extends MainPageOLS> T getPage(T page) {
        return (T) page;
    }

    public MainPageOLS assertChildDOBIsNull(String env, String studyId) {
        String childDOBCell = getDbConnection().dbReadChildDOB(env, pid, studyId);
        Assert.assertNull(childDOBCell, "Child DOB is not NULL");
        logTextToAllure("Child DOB cell: " + childDOBCell);
        return this;
    }

    @Step
    public MainPageOLS pidFromDbToLog(String env) {
        pid = PassPID.getInstance().getPidNumber();
        getDbConnection().dbReadPID(env, pid);
        dispoParent = getDbConnection().getDispo();
        logTextToAllure("Parent dispo = " + dispoParent + " for PID " + pid);
        System.out.println("Parent PID = " + pid);
        System.out.println("Parent dispo = " + dispoParent);
        return this;
    }

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
    public MainPageOLS childPidFromDbToLog(String env) {
//        cpid = PassPID.getInstance().getPidNumber();
        ChildResult childResult = getDbConnection().dbReadChildPID(env, pid);
        logTextToAllure("Child dispo =" + childResult.getDispoCd() + childResult.getApplicantStatus() + " for PID " + pid);
        return this;
    }

    @Step
    public MainPageOLS convert54Cto1R(String env) {
        getDbConnection().convert54Cto1R(env, pid);
        logTextToAllure("54 to 1R conversion completed");
        threadSleep(2000);
        getDbConnection().dbReadPID(env, pid);
        dispoParent = getDbConnection().getDispo();
        logTextToAllure("Dispo = " + dispoParent + " for PID " + pid + "  after conversion");
        return this;
    }

    @Step
    public MainPageOLS getRadiantDbToLog(String env) {
        RadiantResults radiantResults = getDbConnection().dbReadRadiant(env, pid);
        logTextToAllure("Radiant : current status = " + radiantResults.getCurrentStatus() +
                        ", response message = " + radiantResults.getResponseMessage() +
                        ", study reference = " + radiantResults.getStudyReference() +
                        " for PID " + pid);
        Assert.assertEquals(radiantResults.getCurrentStatus(), "SENT", "Current status is not SENT");
        return this;
    }

    @Step
    public MainPageOLS getAnomalyDbToLog(String env) {
        AnomalyResults anomalyResults = getDbConnection().dbReadAnomaly(env, pid);
        logTextToAllure("Anomaly : current status = " + anomalyResults.getCurrentStatus() +
                        ", request status id = " + anomalyResults.getRequestStatus() + " for PID " + pid);
        Assert.assertEquals(anomalyResults.getCurrentStatus(), "SENT", "Current status is not SENT");
        if (env.equals("PRD")) {
            Assert.assertEquals(anomalyResults.getRequestStatus(), "3", "Request status is not 3");
        } else {
            Assert.assertEquals(anomalyResults.getRequestStatus(), "2", "Request status is not 2");
        }
        return this;
    }

    public String getPid() {
        return pid;
    }

    public String getParentDispo() {
        return dispoParent;
    }

    @Step
    public MainPageOLS dispoShouldMatch(String expectedParentDispo) {
        Assert.assertEquals(getParentDispo(), expectedParentDispo, "Dispo ID different");
        return this;
    }

    @Override
    public String toString() {
        Class aClass = this.getClass();
        return aClass.getSimpleName() + " - " + aClass.getPackage().toString();
    }

    @Step
    public <T extends MainPageOLS> T back(T page) {
        back();
        return (T) page;
    }

//MainPageOLS<Z> and DateOfBirthPageOLS extends MainPageOLS<DateOfBirthPageOLS>
//    public Z assertSome(){
//        return (Z)this;
//    }
}

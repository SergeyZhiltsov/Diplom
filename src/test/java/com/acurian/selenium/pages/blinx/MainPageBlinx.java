package com.acurian.selenium.pages.blinx;

import com.acurian.selenium.constants.FULType;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.utils.PassPID;
import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.ChildResult;
import com.acurian.selenium.utils.db.RadiantResults;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageBlinx extends BasePage {

    String pid;
    String childPid;
    String dispoParent;
    String dispoChild;

    @FindBy(id = "submit")
    WebElement nextButton;
    @FindBy(id = "footerLinksContainer")
    WebElement footerLinksContainer;
    @FindBy(id = "previous")
    WebElement previousQuestion;

    public MainPageBlinx() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        waitForAbsence(By.xpath("//*[@id='questions-form'][contains(@class, 'animated fadeOutUp fast')]"));
        waitForAbsence(By.xpath("//*[@id='questions-form'][contains(@class, 'animated fadeInUp fast')]"));
        logTextToAllure(this.getClass().getSimpleName() + " class with: ");
        textToAttachment(titleExpected, "Title text expected");
        driverWait.waitforVisibility(titleText);
        try {
            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        } catch (TimeoutException ex) {
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
    }

    protected void clickOnRadioButton(List<WebElement> radioButtonList, String answerText) {
        radioButtonList.stream().filter(el -> el.getText().equals(answerText))
                .forEach(el -> {
                    try {
                        el.click();
                    } catch (WebDriverException ex) {
                        scrollToElement(el, true).click();
                    }
                });
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

        checkBoxList.stream().filter(el -> answerTextList.stream().anyMatch(el.getText()::startsWith))
                .forEach(el -> {
                    try {
                        waitForAnimation();
                        el.click();
                    } catch (WebDriverException ex) {
                        scrollToElement(el, true).click();
                    }
                });
        waitForAnimation();
    }

    /**
     * Use this method only for pages    HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS    and    DoAnyOftheFollowingAdditionalDiagnosesOLS
     * @param checkBoxList
     * @param answerText
     */
    protected void clickOnCheckBoxesBlinx(List<WebElement> checkBoxList, String... answerText) {
        List<String> answerTextList = Arrays.asList(answerText);
        List<String> elementsTextActual = checkBoxList.stream().map(el -> el.getText()).collect(Collectors.toList());
        List<String> answersNotIncluded = answerTextList.stream().filter(el -> elementsTextActual.parallelStream()
                .noneMatch(el2 -> el2.contains(el))).collect(Collectors.toList());
        Assert.assertFalse(answersNotIncluded.size() > 0, "Some answers are not correct " +
                answersNotIncluded + "\n" +
                "expected to click are " + answerTextList + "\n" +
                "actual on page are " + elementsTextActual);

        checkBoxList.stream().filter(el -> answerTextList.stream().anyMatch(el.getText()::startsWith))
                .forEach(el -> {
                    try {
                        waitForAnimation();
                        el.click();
                    } catch (WebDriverException ex) {
                        try {
                            scrollToElement(el, true).click();
                        }catch (WebDriverException ex1){
                            scrollToTop();
                            el.click();
                        }
                    }
                });
        waitForAnimation();
    }


    @Step
    public void clickPreviousQuestion() {
        waitAndClickWebElement(previousQuestion);
    }
    @Step
    public <T extends MainPageBlinx> T back(T page) {
        waitAndClickWebElement(previousQuestion);
        return (T) page;
    }

    @Step
    public MainPageBlinx getAnomalyDbToLog(String env) {
        AnomalyResults anomalyResults = getDbConnection().dbReadAnomaly(env, pid);
        logTextToAllure("Anomaly : current status = " + anomalyResults.getCurrentStatus() +
                ", request status id = " + anomalyResults.getRequestStatus() + " for PID " + pid);
        Assert.assertEquals(anomalyResults.getCurrentStatus(), "SENT", "Current status is not SENT");
        if (env.equals("STG")) {
            Assert.assertEquals(anomalyResults.getRequestStatus(), "2", "Request status is not 2");
        } else {
            Assert.assertEquals(anomalyResults.getRequestStatus(), "3", "Request status is not 3");
        }
        return this;
    }

    @Step
    public <T extends MainPageBlinx> T clickNextButton(T page) {
        try {
            waitAndClickWebElement(nextButton);
        } catch (WebDriverException ex) {
            scrollToElement(nextButton, true);
            waitAndClickWebElement(nextButton);
        }
        return (T) page;
    }

    protected WebElement waitToBeClickable(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitToBeClickable(By locator) {
        return driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitAndClickWebElement(WebElement element) {
        waitToBeClickable(element).click();
        return element;
    }

    protected WebElement waitAndClickWebElement(By locator) {
        WebElement element = waitToBeClickable(locator);
        element.click();
        return element;
    }

    public void waitForAbsence(WebElement element) {
        driverWait.getWaitDriver().until(driver -> !isElementPresent(element));
    }

    public void waitForAbsence(By locator) {
        driverWait.getWaitDriver().until(driver -> !isElementPresent(locator));
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (WebDriverException ignored) {
            return false;
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            WebElement element = getDriver().findElement(locator);
            element.getTagName();
            return true;
        } catch (WebDriverException ignored) {
            return false;
        }
    }

    @Step
    public <T extends MainPageBlinx> T getPage(T page) {
        return (T) page;
    }

    @Step
    public MainPageBlinx pidFromDbToLog(String env) {
        pid = PassPID.getInstance().getPidNumber();
        getDbConnection().dbReadPID(env, pid);
        dispoParent = getDbConnection().getDispo();
        logTextToAllure("Parent dispo = " + dispoParent + " for PID " + pid);
        return this;
    }

    @Step
    public MainPageBlinx childPidFromDbToLog(String env, String... firstPartOfChildPhoneNumber) {
        ChildResult childResult = getDbConnection().dbReadChildPID(env, pid, firstPartOfChildPhoneNumber);
        dispoChild = childResult.getDispoCd() + childResult.getApplicantStatus();
        childPid = childResult.getChildPid();
        logTextToAllure("Child dispo = " + childResult.getDispoCd() + childResult.getApplicantStatus() + " for PID " + pid +
                " with child pid = " + childResult.getChildPid());
        return this;
    }

    @Step
    public MainPageBlinx dispoShouldMatch(String expectedParentDispo, String... expectedChildDispo) {
        Assert.assertEquals(getDispoParent(), expectedParentDispo, "Dispo for Parent is different");
        if (expectedChildDispo.length == 1) {
            Assert.assertEquals(getDispoChild(), expectedChildDispo[0], "Dispo for Child is different");
        }
        return this;
    }

    @Step
    public MainPageBlinx assertGeneratedFul(String env, Site site) {
        if (site.hasFul) {
            String fulValueField = getDbConnection().dbReadFulValue(env, pid);
            logTextToAllureAndConsole("Fetched DB value of FUL cell: " + fulValueField);
            Assert.assertNotEquals(fulValueField, "", "FUL VALUE is empty string!");
            Assert.assertNotEquals(fulValueField.toLowerCase(), "null", "FUL VALUE is null string!");
            if (site.withMedicalRecords) {
                Assert.assertTrue(fulValueField.contains(FULType.MEDICAL_RECORD.toString()),
                        String.format("FUL VALUE contains different string. Expected [%s] but found [%s]",
                                FULType.MEDICAL_RECORD.toString(), fulValueField));
            }
        }
        return this;
    }

    @Step
    public MainPageBlinx assertRmgOrderPriority(String env, String projectCode) {
        String studyId = getDbConnection().getStudyIdByProjectCode(env, projectCode);
        List<String> priorityList = getDbConnection().getRmgOrderPriorityList(env);
        Assert.assertTrue(priorityList.contains(studyId), String.format("The STUDY_RMG_PRIORITY_CONFIG not contains " +
                "expected study id. Expected [%s] but found [%s].", studyId, priorityList));
        return this;
    }

    @Step
    public MainPageBlinx getRadiantDbToLog(String env, String ... assertStudyReference) {
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



    public String getDispoParent() {
        return dispoParent;
    }

    public String getDispoChild() {
        return dispoChild;
    }
}

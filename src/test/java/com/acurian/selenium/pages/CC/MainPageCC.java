package com.acurian.selenium.pages.CC;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.utils.DBConnection;
import com.acurian.selenium.utils.PassPID;
import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.RadiantResults;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageCC extends BasePage {

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;

    String pid;
    String dispoParent;

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

    public MainPageCC assertChildDOBIsNull(String env) {
        DBConnection dbCon = new DBConnection();
        String childDOBCell = dbCon.dbReadChildDOB(env, pid);
        Assert.assertNull(childDOBCell,"Child DOB is not NULL");
        logTextToAllure("Child DOB cell: " + childDOBCell);
        return this;
    }

    public MainPageCC pidFromDbToLog(String env) {
        DBConnection dbCon = new DBConnection();
        pid = PassPID.getInstance().getPidNumber();
        dbCon.dbRead(env, pid);
        dispoParent = dbCon.getDispo();
        logTextToAllure("Dispo="+dispoParent+" for pid "+pid);
        return this;
    }

    public MainPageCC getRadiantDbToLog(String env) {
        DBConnection dbCon = new DBConnection();
//        pid = PassPID.getInstance().getPidNumber();
        RadiantResults radiantResults = dbCon.dbReadRadiant(env, pid);
        logTextToAllure("Radiant::: Current Status=" + radiantResults.getCurrentStatus() + " for pid " + pid);
        return this;
    }

    public MainPageCC getAnomalyDbToLog(String env) {
        DBConnection dbCon = new DBConnection();
//        pid = PassPID.getInstance().getPidNumber();
        AnomalyResults anomalyResults = dbCon.dbReadAnomaly(env, pid);
        logTextToAllure("Anomaly : Current Status=" + anomalyResults.getCurrentStatus() + " Request Status id=" + anomalyResults.getRequestStatus() + " for pid " + pid);
        return this;
    }

    @Step
    public <T extends MainPageCC> T clickNextButton(T page) {
        nextButton.click();
        return (T) page;
    }


    public String getParentDispo() {
        return dispoParent;
    }

    @Step
    public MainPageCC dispoShouldMatch(String expectedParentDispo){
        Assert.assertEquals(getParentDispo(), expectedParentDispo, "Dispo id different");
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

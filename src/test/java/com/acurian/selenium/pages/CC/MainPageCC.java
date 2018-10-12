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

public class MainPageCC extends BasePage{

    @FindBy(xpath = "//button[text()='Next']")
    WebElement nextButton;

    String pid;

    public MainPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForAnimation(){
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) getDriver()).executeScript(
                "return document.readyState"
        ).equals("complete"));
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> (boolean)((JavascriptExecutor) getDriver()).executeScript(
                "return jQuery.active == 0"
        ));
    }

    protected void waitForPageLoadMain(WebElement titleText, String titleExpected){
        logTextToAllure(this.getClass().getSimpleName() + " class with:");
        textToAttachment(titleExpected,"Title text");
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        try {
            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        }
        catch (TimeoutException ex){
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
    }

    protected void clickOnRadioButton(List<WebElement> radioButtonList, String answerText){
        radioButtonList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
    }
    public MainPageCC pidFromDbToLog(String env){
        DBConnection dbCon = new DBConnection();
        pid = PassPID.getInstance().getPidNumber();
        dbCon.dbRead(env, pid);
        logTextToAllure("Dispo="+dbCon.getDispo()+"for pid "+pid);
        return this;
    }

    public MainPageCC getRadiantDbToLog(String env){
        DBConnection dbCon = new DBConnection();
//        pid = PassPID.getInstance().getPidNumber();
        RadiantResults radiantResults = dbCon.dbReadRadiant(env, pid);
        logTextToAllure("Radiant::: Current Status="+radiantResults.getCurrentStatus()+" for pid "+pid);
        return this;
    }

    public MainPageCC getAnomalyDbToLog(String env){
        DBConnection dbCon = new DBConnection();
//        pid = PassPID.getInstance().getPidNumber();
        AnomalyResults anomalyResults = dbCon.dbReadAnomaly(env, pid);
        logTextToAllure("Anomaly : Current Status="+anomalyResults.getCurrentStatus()+" Request Status id="+anomalyResults.getRequestStatus()+" for pid "+pid);
        return this;
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String ...answerText){
        List<String> answerTextList = Arrays.asList(answerText);

//        List<String> elementsTextActual = checkBoxList.stream().map(el -> el.getText()).collect(Collectors.toList());
//        Assert.assertTrue(elementsTextActual.containsAll(answerTextList), "Some answers are not correct "
//                + answerTextList+" are not included in actual "+elementsTextActual);

        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                .forEach(el -> el.click());
        waitForAnimation();
    }

    @Step
    public <T extends MainPageCC> T clickNextButton(T page) {
        nextButton.click();
        return (T)page;
    }

    @Override
    public String toString() {
        Class aClass = this.getClass();
        return aClass.getSimpleName() + " - " + aClass.getPackage().toString();
    }

    @Step
    public <T extends MainPageCC> T getPage(T page) {
        return (T)page;
    }

    @Step
    public <T extends MainPageCC> T back(T page){
        back();
        return (T)page;
    }
}

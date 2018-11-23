package com.acurian.selenium.pages.OLS;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.utils.DBConnection;
import com.acurian.selenium.utils.PassPID;
import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.RadiantResults;
import org.openqa.selenium.By;
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

public class MainPageOLS extends BasePage{

    @FindBy(xpath = "//button[@id='submit']")
    WebElement nextButton;

    @FindBy(xpath = "//img[starts-with(@src,'http')]")
    private List<WebElement> images;

    String pid;


    public MainPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForAnimation(){
        ngDriver.waitForAngularRequestsToFinish();
    }

    @Step
    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        logTextToAllure(this.getClass().getSimpleName() + " class with:");
        textToAttachment(titleExpected,"Title text expected");
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        try {
            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        }
        catch (TimeoutException ex){
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
        return (T)page;
    }

    protected void clickOnRadioButton(List<WebElement> radioButtonList, String answerText){
        radioButtonList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String ...answerText){
        List<String> answerTextList = Arrays.asList(answerText);
        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                .forEach(el -> getActions().moveToElement(el.findElement(By.xpath("ancestor::label/span[contains(@class,'debug-question-helper')]")),5,5).click().build().perform());
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
        return (T)page;
    }

    @Step
    public MainPageOLS pidFromDbToLog(String env){
        DBConnection dbCon = new DBConnection();
        pid = PassPID.getInstance().getPidNumber();
        dbCon.dbRead(env, pid);
        logTextToAllure("Dispo="+dbCon.getDispo()+"for pid "+pid);
        return this;
    }
    
    public MainPageOLS childPidFromDbToLog(String env){
        DBConnection dbCon = new DBConnection();
        pid = PassPID.getInstance().getPidNumber();
        dbCon.dbReadChilPID(env, pid);
        logTextToAllure("Dispo="+dbCon.getDispo()+"for pid "+pid);
        return this;
    }

    @Step
    public MainPageOLS getRadiantDbToLog(String env){
        DBConnection dbCon = new DBConnection();
//        pid = PassPID.getInstance().getPidNumber();
        RadiantResults radiantResults = dbCon.dbReadRadiant(env, pid);
        logTextToAllure("Radiant::: Current Status="+radiantResults.getCurrentStatus()+" for pid "+pid);
        return this;
    }

    @Step
    public MainPageOLS getAnomalyDbToLog(String env){
        DBConnection dbCon = new DBConnection();
//        pid = PassPID.getInstance().getPidNumber();
        AnomalyResults anomalyResults = dbCon.dbReadAnomaly(env, pid);
        logTextToAllure("Anomaly : Current Status="+anomalyResults.getCurrentStatus()+" Request Status id="+anomalyResults.getRequestStatus()+" for pid "+pid);
        return this;
    }

    public String getPid() {
        return pid;
    }

    @Override
    public String toString() {
        Class aClass = this.getClass();
        return aClass.getSimpleName() + " - " + aClass.getPackage().toString();
    }

    @Step
    public <T extends MainPageOLS> T back(T page){
        back();
        return (T)page;
    }


//MainPageOLS<Z> and DateOfBirthPageOLS extends MainPageOLS<DateOfBirthPageOLS>
//    public Z assertSome(){
//        return (Z)this;
//    }

}

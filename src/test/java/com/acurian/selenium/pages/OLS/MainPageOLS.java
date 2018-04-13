package com.acurian.selenium.pages.OLS;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.utils.DBConnection;
import com.acurian.selenium.utils.PassPID;
import com.acurian.selenium.utils.db.AnomalyResults;
import com.acurian.selenium.utils.db.RadiantResults;
import org.openqa.selenium.By;
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

    String pid;


    public MainPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForAnimation(){
        ngDriver.waitForAngularRequestsToFinish();
    }

    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
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
                .forEach(el -> getActions().moveToElement(el.findElement(By.xpath("ancestor::label")),5,5).click().build().perform());
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

    public MainPageOLS pidFromDbToLog(String env){
        DBConnection dbCon = new DBConnection();
        pid = PassPID.getInstance().getPidNumber();
        dbCon.dbRead(env, pid);
        logTextToAllure("Dispo="+dbCon.getDispo()+"for pid "+pid);
        return this;
    }

    public MainPageOLS getRadiantDbToLog(String env){
        DBConnection dbCon = new DBConnection();
//        pid = PassPID.getInstance().getPidNumber();
        RadiantResults radiantResults = dbCon.dbReadRadiant(env, pid);
        logTextToAllure("Radiant : Current Status="+radiantResults.getCurrentStatus()+" for pid "+pid);
        return this;
    }

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


//MainPageOLS<Z> and DateOfBirthPageOLS extends MainPageOLS<DateOfBirthPageOLS>
//    public Z assertSome(){
//        return (Z)this;
//    }

}

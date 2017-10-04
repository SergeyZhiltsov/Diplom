package com.acurian.selenium.pages.OLS;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class MainPageOLS extends BasePage{

    @FindBy(xpath = "//button[@id='submit']")
    WebElement nextButton;


    public MainPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForAnimation(){
        ngDriver.waitForAngularRequestsToFinish();
    }
    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
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


//MainPageOLS<Z> and DateOfBirthPageOLS extends MainPageOLS<DateOfBirthPageOLS>
//    public Z assertSome(){
//        return (Z)this;
//    }


}

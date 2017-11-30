package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WarmTransfer1 extends MainPageCC{

    public final String titleExpected ="We're glad the location is convenient for you. \n\nAgent Note: \nIf CSR has ability to direct schedule in clinical conductor, then Follow the Scheduling Script \n\nIf CSR does NOT have ability to direct schedule in clinical conductor, then Continue with the Warm Transfer\n\nI would like to transfer you to the doctor's scheduling center.\nPlease hold for just a minute while I try to reach the scheduling center.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public WarmTransfer1() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WarmTransfer1 waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WarmTransfer1 clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}

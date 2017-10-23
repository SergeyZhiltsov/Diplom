package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WarmTransfer2 extends MainPageCC{
	
    public final String titleExpected ="Great, please hold for a moment. Your patience is greatly appreciated. If we should get disconnected for any reason, please do not worry, we will pass your information on to the scheduling center and they will just get in contact with you directly. \n"+
    "[Attempt to call site] Verify that patient is hearing hold music\n"+
    "\n"+
    "Dial the displayed phone number: 844-438-6151\n"+
    "\n"+
    "If site does not answer: Do not leave a message.\n"+
    "\n"+
    "If site answers:\n"+
    "Hello, this is AUTOTEST AUTOTEST calling from the Acurian Call Center. We have a patient on the line who would like to schedule their first office visit. I\'m going to bring the patient on the line.";
    
    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public WarmTransfer2() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WarmTransfer2 waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WarmTransfer2 clickOnAnswer(String answerText) {
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

package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class Regular_WarmTransfer2 extends MainPageCC{

    public final String titleExpected ="Great, please hold for just a moment. If we should get disconnected for any reason, please do not worry; we will pass your information on to the study doctor's office and they will just get in contact with you directly.";
    		
    		/*"Great, please hold for just a moment. If we should get disconnected for any reason, please do not worry; we will pass your information on to the study doctor's office and they will just get in contact with you directly. [Attempt to call site]\r\n" +
    		"\r\n" +
    		"Dial the displayed phone number: 123-456-7899\r\n" +
    		"\r\n" +
    		"The agent should give the site phone number to the caller, if the caller is requesting it.\r\n" +
    		"\r\n" +
    		"If site answers: Hello, this is AUTOTEST AUTOTEST calling from Acurian. May I please speak to the person in your office who is responsible for scheduling initial patient appointments for the Sanofi type 2 diabetes study? [If the site is unsure which study you are calling about, refer to protocol name and number EFC14822 (EFC14822).]";*/

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public Regular_WarmTransfer2() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public Regular_WarmTransfer2 waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public Regular_WarmTransfer2 clickOnAnswer(String answerText) {
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


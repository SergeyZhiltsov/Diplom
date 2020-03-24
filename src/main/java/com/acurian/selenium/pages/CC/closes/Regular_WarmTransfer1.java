package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class Regular_WarmTransfer1 extends MainPageCC {

    public final String titleExpected = "While I have you on the phone, I would like to try to transfer you to the study doctor's office so that they can confirm your qualifications and see if they can schedule an office visit. Can you please hold for just a minute while I try to reach the office?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public Regular_WarmTransfer1() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public Regular_WarmTransfer1 waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public Regular_WarmTransfer1 clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}


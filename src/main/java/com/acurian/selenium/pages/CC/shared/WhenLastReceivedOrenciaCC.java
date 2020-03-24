package com.acurian.selenium.pages.CC.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class WhenLastReceivedOrenciaCC extends MainPageCC{

    public final String titleExpected = "Which of the following best describes when you last received Orencia? You….";

    @FindBy(xpath = "//div[@class='subquestion']/span[1]")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public WhenLastReceivedOrenciaCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenLastReceivedOrenciaCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenLastReceivedOrenciaCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

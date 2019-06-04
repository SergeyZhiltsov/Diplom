package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class GenderPageCC extends MainPageCC {

    public final String titleExpected = "This part of the questionnaire requires that we ask about your gender. To confirm, please tell me, is your gender male or female?";

    public final String titleExpectedGmega = "Please confirm your gender:";


    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleTextGmega;

    @FindBy(xpath = "//div[@class='radio_btns_container']//span")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsListGmega;

    public GenderPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public GenderPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public GenderPageCC waitForPageLoadGmega() {
        waitForPageLoadMain(titleTextGmega, titleExpectedGmega);
        return this;
    }

    @Step
    public GenderPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public GenderPageCC clickOnAnswerGmega(String answerText) {
        clickOnRadioButton(radioButtonsListGmega, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}

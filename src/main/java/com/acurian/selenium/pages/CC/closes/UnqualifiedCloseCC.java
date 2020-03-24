package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnqualifiedCloseCC extends MainPageCC {
    public final String titleExpected = "We appreciate your interest in participating.\n" +
            "\n" +
            "Unfortunately, from the information you have provided, you would not be a candidate at this time.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public UnqualifiedCloseCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public UnqualifiedCloseCC waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public UnqualifiedCloseCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

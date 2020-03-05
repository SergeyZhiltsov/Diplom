package com.acurian.selenium.pages.OLS.GERD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DuringPastThreeMounthOLS extends MainPageOLS {
    public final String titleExpected = "During the past 3 months, have you had stomach pain or discomfort that lasted 2 weeks or more?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public DuringPastThreeMounthOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DuringPastThreeMounthOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

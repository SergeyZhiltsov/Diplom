package com.acurian.selenium.pages.blinx.ams.ra;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class StudiesThatAreCurrentlyEnrollingPageOLS extends MainPageBlinx {

    public final String titleExpected = "We may have other research studies that are currently enrolling patients in your area. Would you like to see if we have another study that you are interested in?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='answer-text']")
    List<WebElement> radioButtonsList;

    public StudiesThatAreCurrentlyEnrollingPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StudiesThatAreCurrentlyEnrollingPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public StudiesThatAreCurrentlyEnrollingPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

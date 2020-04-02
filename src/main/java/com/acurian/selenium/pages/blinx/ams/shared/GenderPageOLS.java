package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GenderPageOLS extends MainPageBlinx {

    public final String titleExpectedPart1 = "What is your date of birth?";
    private final String titleExpectedPart2 = "Please select your gender:";
    public final String titleExpectedGmega = "Please confirm your gender:";

    @FindBy(xpath = "(//div[@class='question-text']/span)[1]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/span)[2]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    WebElement dateField;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> singleChoiceButtonsList;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText4;

    @Step
    public GenderPageOLS waitForPageLoadGMEGAConfirm() {
        waitForAnimation();
        waitForPageLoadMain(titleText4, titleExpectedGmega);
        return this;
    }

    @Step
    public GenderPageOLS waitForPageLoadGMEGASelect() {
        waitForAnimation();
        waitForPageLoadMain(titleText4, titleExpectedPart2);
        return this;
    }

    @Step
    public GenderPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart1, titleExpectedPart1);
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public GenderPageOLS waitForPageLoadByTitle(String titleExpected) {
        waitForAnimation();
        waitForPageLoadMain(titleText4, titleExpected);
        return this;
    }

    @Step
    public GenderPageOLS setDate(String date) {
        typeText(dateField, date);
        return this;
    }

    @Step
    public GenderPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleTextPart1);
    }

}

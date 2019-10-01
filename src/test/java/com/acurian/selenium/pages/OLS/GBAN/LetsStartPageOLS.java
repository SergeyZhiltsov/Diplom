package com.acurian.selenium.pages.OLS.GBAN;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetsStartPageOLS extends MainPageOLS {

    public final String titleExpected = "The Generation Study is enrolling now.";
    public final String titleExpectedQA = "Let's start!";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @Step
    public LetsStartPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LetsStartPageOLS waitForPageLoadByTitle(String titleExpected) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
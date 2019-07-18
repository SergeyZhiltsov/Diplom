package com.acurian.selenium.pages.OLS.GBAN;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetsStartPageOLS extends MainPageOLS {
    public final String titleExpected = "Let's start!";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    public LetsStartPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LetsStartPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
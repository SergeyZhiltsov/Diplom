package com.acurian.selenium.pages.OLS.GBAN;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThanksPageOLS extends MainPageOLS {

    public final String titleExpected = "Thanks";

    @FindBy(css = "div.main-question-holder.ng-scope h4")

    WebElement titleText;

    public ThanksPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThanksPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
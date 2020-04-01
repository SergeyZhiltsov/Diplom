package com.acurian.selenium.pages.blinx.ams.gban;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThanksPageOLS extends MainPageBlinx {

    public final String titleExpected = "Thanks";

    @FindBy(css = "div.main-question-holder.ng-scope h4")

    WebElement titleText;

    public ThanksPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThanksPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

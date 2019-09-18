package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouClosePageOLS extends MainPageBlinx {

    private final String titleExpected = "Thank you. Clinical research studies greatly contribute to the overall " +
            "progress in understanding and finding future treatments for diseases and we appreciate your interest in " +
            "participation.";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;

    @Step
    public ThankYouClosePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
}

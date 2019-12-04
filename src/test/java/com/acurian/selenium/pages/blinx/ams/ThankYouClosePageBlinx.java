package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouClosePageBlinx extends MainPageBlinx {

    private final String titleExpected = "Thank you. Clinical research studies greatly contribute to the overall " +
            "progress in understanding and finding future treatments for diseases and we appreciate your interest in " +
            "participation.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @Step
    public ThankYouClosePageBlinx waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
}

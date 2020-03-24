package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouCloseSimplePageOLS extends MainPageBlinx {

    private final String titleExpected = "Thank you. Clinical research studies greatly contribute to the overall" +
            " progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.";

    private final String titleExpected2 = "Thank you again for contacting Acurian's Research Information Center. To further allow us to assist you, please register with www.acurian.com and we will keep you informed of important treatment options for your condition.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @Step
    public ThankYouCloseSimplePageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ThankYouCloseSimplePageOLS waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }
}

package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouClosePageOLS extends MainPageBlinx {

    private final String titleExpected = "Thank you again for contacting Acurian's Research Information Center. " +
            "To further allow us to assist you, please register with www.acurian.com and we will keep you informed " +
            "of important treatment options for your condition.";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;

    @Step
    public ThankYouClosePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
}

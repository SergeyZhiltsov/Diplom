package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualifiedClosePageOLS extends MainPageBlinx {

    private final String titleExpected = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you about your condition Low Back Pain, Arthritis, Rheumatoid Arthritis, Diabetes";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;

    @Step
    public QualifiedClosePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
}

package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZipCodePageOLS extends MainPageBlinx {

    private final String titleExpected = "Zip Code";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = "//div[@data-question-basis='ZIP']//input")
    WebElement zipCodeField;

    @Step
    public ZipCodePageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ZipCodePageOLS setZipCode(String zipCode) {
        typeTextWithoutClear(zipCodeField, zipCode);
        return this;
    }
}

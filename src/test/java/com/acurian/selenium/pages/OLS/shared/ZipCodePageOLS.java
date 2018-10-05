package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ZipCodePageOLS extends MainPageOLS{

    public final String titleExpected = "Zip Code";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//input")
    WebElement zipField;

    public ZipCodePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ZipCodePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ZipCodePageOLS typeZipCode(String text) {
        typeTextWithoutClear(zipField, text);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

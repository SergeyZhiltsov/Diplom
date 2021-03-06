package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ZipCodePageCC extends MainPageCC {

    public final String titleExpected = "Zip Code";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement zipField;

    public ZipCodePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ZipCodePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ZipCodePageCC typeZipCode(String text) {
        typeTextWithoutClear(zipField, text);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

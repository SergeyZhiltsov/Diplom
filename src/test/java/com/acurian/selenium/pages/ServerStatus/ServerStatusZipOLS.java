package com.acurian.selenium.pages.ServerStatus;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ServerStatusZipOLS extends MainPageOLS {
    public final String titleExpected = "Zip Code";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//input")
    WebElement zipField;

    public ServerStatusZipOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ServerStatusZipOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ServerStatusZipOLS typeZipCode(String text) {
        typeTextWithoutClear(zipField, text);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

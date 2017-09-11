package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ZipCodePageCC extends BasePage{

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement zipField;

    public ZipCodePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ZipCodePageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public ZipCodePageCC typeZipCode(String text) {
        typeTextWithoutClear(zipField, text);
        return this;
    }


}

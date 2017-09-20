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

    public ZipCodePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ZipCodePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
//        waitForAnimation();
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

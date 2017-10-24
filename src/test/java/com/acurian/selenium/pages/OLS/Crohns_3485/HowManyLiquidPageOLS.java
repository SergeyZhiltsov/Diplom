package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyLiquidPageOLS extends MainPageOLS{

    public final String titleExpected = "What is your approximate height?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'text-height-input-feet')]")
    WebElement featField;

    @FindBy(xpath = "//input[contains(@class,'text-height-input-inches')]")
    WebElement inchesField;

    public HowManyLiquidPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyLiquidPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyLiquidPageOLS setFeat(String number) {
        typeTextWithoutClear(featField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public HowManyLiquidPageOLS setInches(String number) {
        typeTextWithoutClear(inchesField, number);
        waitForAnimation();
        return this;
    }
}

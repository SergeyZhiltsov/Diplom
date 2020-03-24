package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class RateAverageItchinessEczemaPageOLS extends MainPageOLS {

    public final String titleExpected = "On a scale from 0 (no itch) to 10 (severe itch), how would you rate your average itchiness due to eczema?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'dropdown')]/select")
    WebElement dropDownList;

    public RateAverageItchinessEczemaPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RateAverageItchinessEczemaPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public RateAverageItchinessEczemaPageOLS selectFromDropDown(String answerText) {
        selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
package com.acurian.selenium.pages.OLS.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class FirstHeartAttackPageOLS extends MainPageOLS{

    public final String titleExpected = "Out of the relatives from the last question who have had a heart attack, what is the youngest age that they had a heart attack?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'form-control')]")
    WebElement yearField;

    public FirstHeartAttackPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FirstHeartAttackPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FirstHeartAttackPageOLS setYears(String number) {
        typeText(yearField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

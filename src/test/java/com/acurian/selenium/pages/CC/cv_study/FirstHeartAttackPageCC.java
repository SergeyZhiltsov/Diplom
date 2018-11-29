package com.acurian.selenium.pages.CC.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FirstHeartAttackPageCC extends MainPageCC{

    public final String titleExpected = "How old were they when they had their first heart attack?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement yearField;

    public FirstHeartAttackPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FirstHeartAttackPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FirstHeartAttackPageCC setYear(String number) {
        typeText(yearField, number);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

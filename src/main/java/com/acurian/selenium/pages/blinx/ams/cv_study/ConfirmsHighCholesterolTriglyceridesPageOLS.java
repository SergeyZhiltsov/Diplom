package com.acurian.selenium.pages.blinx.ams.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConfirmsHighCholesterolTriglyceridesPageOLS extends MainPageBlinx {

    private final String titleExpected = "Have you had a blood test that confirms you have high cholesterol or high triglycerides?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> multipleChoiceButtonsList;

    @Step
    public ConfirmsHighCholesterolTriglyceridesPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ConfirmsHighCholesterolTriglyceridesPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

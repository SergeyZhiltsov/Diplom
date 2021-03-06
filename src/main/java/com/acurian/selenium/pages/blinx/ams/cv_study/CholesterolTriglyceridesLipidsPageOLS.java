package com.acurian.selenium.pages.blinx.ams.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CholesterolTriglyceridesLipidsPageOLS extends MainPageBlinx {

    private final String titleExpected = "Are you currently taking any medication to manage high cholesterol, triglycerides, or lipids?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> singleChoiceButtonsList;

    @Step
    public CholesterolTriglyceridesLipidsPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CholesterolTriglyceridesLipidsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}

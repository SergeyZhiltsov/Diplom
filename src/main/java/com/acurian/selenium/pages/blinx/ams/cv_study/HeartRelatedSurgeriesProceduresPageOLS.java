package com.acurian.selenium.pages.blinx.ams.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeartRelatedSurgeriesProceduresPageOLS extends MainPageBlinx {

    private final String titleExpected = "Have you ever had any of the following heart-related surgeries or procedures?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> multipleChoiceButtonsList;

    @Step
    public HeartRelatedSurgeriesProceduresPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HeartRelatedSurgeriesProceduresPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WhatKindOfArthritisDoYouHavePageOLS extends MainPageBlinx {

    private final String titleExpected = "What kind of arthritis do you have?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='multiple-choice-answers-container']/button")
    List<WebElement> multipleChoiceButtonsList;


    @Step
    public WhatKindOfArthritisDoYouHavePageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhatKindOfArthritisDoYouHavePageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

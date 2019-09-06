package com.acurian.selenium.pages.blinx.intro;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WhatYourDateOfBirthPageOLS extends MainPageBlinx {

    private final String titleExpectedPart1 = "What is your date of birth?";
    private final String titleExpectedPart2 = "Please select your gender:";

    @FindBy(xpath = "(//div[@class='question-text']/div)[2]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/div)[3]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//input[@class='fallbackDate']")
    WebElement dateField;
    @FindBy(xpath = "//div[@class='single-choice-answers-container']/button")
    List<WebElement> singleChoiceButtonsList;

    @Step
    public WhatYourDateOfBirthPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleTextPart1, titleExpectedPart1);
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public WhatYourDateOfBirthPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }

    @Step
    public WhatYourDateOfBirthPageOLS setDate(String date) {
        typeText(dateField, date);
        return this;
    }
}

package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConfirmsHighCholesterolTriglyceridesPageOLS extends MainPageBlinx {

    private final String titleExpected = "Have you had a blood test that confirms you have high cholesterol or high triglycerides?\n" +
            "Please select all that apply:";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='multiple-choice-answers-container']/button")
    List<WebElement> multipleChoiceButtonsList;

    @Step
    public ConfirmsHighCholesterolTriglyceridesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ConfirmsHighCholesterolTriglyceridesPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

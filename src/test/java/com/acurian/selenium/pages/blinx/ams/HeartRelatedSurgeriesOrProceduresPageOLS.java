package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeartRelatedSurgeriesOrProceduresPageOLS extends MainPageBlinx {

    private final String titleExpected = "Have you ever had any of the following heart-related surgeries or procedures?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='multiple-choice-answers-container']/button")
    List<WebElement> multipleChoiceButtonsList;

    @Step
    public HeartRelatedSurgeriesOrProceduresPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HeartRelatedSurgeriesOrProceduresPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

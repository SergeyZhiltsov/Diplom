package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HealthcareDiagnosedConditionsPageOLS extends MainPageBlinx {

    private final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following medical conditions?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='multiple-choice-answers-container']/button")
    List<WebElement> multipleChoiceButtonsList;

    @Step
    public HealthcareDiagnosedConditionsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HealthcareDiagnosedConditionsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

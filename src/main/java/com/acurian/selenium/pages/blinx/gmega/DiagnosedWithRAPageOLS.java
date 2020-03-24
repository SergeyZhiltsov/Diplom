package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiagnosedWithRAPageOLS extends MainPageBlinx {

    private final String titleExpected = "When were you diagnosed with RA?";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='single-choice-answers-container']/button | //div[@class='answer-text']")
    List<WebElement> singleChoiceButtonsList;


    @Step
    public DiagnosedWithRAPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithRAPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}

package com.acurian.selenium.pages.blinx.gmega.intro;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PleaseConfirmYourGenderPageOLS extends MainPageBlinx {

    private final String titleExpected = "Please confirm your gender:";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='single-choice-answers-container']/button")
    List<WebElement> singleChoiceButtonsList;

    @Step
    public PleaseConfirmYourGenderPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PleaseConfirmYourGenderPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}

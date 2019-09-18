package com.acurian.selenium.pages.blinx.gmega.intro;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProvidingInformationPageOLS extends MainPageBlinx {

    private final String titleExpected = "Are you providing information for yourself or on behalf of someone else?";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='single-choice-answers-container']/button")
    List<WebElement> singleChoiceButtonsList;

    @Step
    public ProvidingInformationPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step()
    public ProvidingInformationPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}

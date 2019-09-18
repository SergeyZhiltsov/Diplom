package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CardiovascularDiseasePageOLS extends MainPageBlinx {

    private final String titleExpected = "Certain conditions are more closely linked to cardiovascular disease than others.\n" +
            "Has a doctor ever diagnosed you with any of the following medical conditions or diseases?\n" +
            "Please select all that apply:";

    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='multiple-choice-answers-container']/button")
    List<WebElement> multipleChoiceButtonsList;

    @Step
    public CardiovascularDiseasePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CardiovascularDiseasePageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

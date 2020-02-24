package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EverDiagnosedFollowingNeurologicalConditionsPageOLS extends MainPageBlinx {

    private final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following neurological conditions?N\n" +
            "Please select all that apply.";

//    @FindBy(xpath = "(//div[@class='question-text']/div)[1]")
//    WebElement titleText;
    @FindBy(xpath = "(//div[@class='question-text']/span)[1]")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='multiple-choice-answers-container']/button")
    List<WebElement> multipleChoiceButtonsList;


    @Step
    public EverDiagnosedFollowingNeurologicalConditionsPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverDiagnosedFollowingNeurologicalConditionsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

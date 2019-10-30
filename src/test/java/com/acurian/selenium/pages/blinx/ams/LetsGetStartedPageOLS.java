package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LetsGetStartedPageOLS extends MainPageBlinx {

    private final String titleExpectedPart1 = "Let's get started to see if there is %s that's right for you!\n\n" +
            "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor's office.\n" +
            "If you attend all required study visits, you may receive*:\n" +
            "Payment up to $%s, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    private final String titleExpectedPart2 = "Are you age 18 or older?";

    @FindBy(xpath = "(//div[@class='question-text']/div)[2]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/div)[3]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//div[@class='single-choice-answers-container']/button")
    List<WebElement> singleChoiceButtonsList;

    @Step
    public LetsGetStartedPageOLS waitForPageLoad(String indication, String compensation) {
        waitForPageLoadMain(titleTextPart1, String.format(titleExpectedPart1, indication, compensation));
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public LetsGetStartedPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}

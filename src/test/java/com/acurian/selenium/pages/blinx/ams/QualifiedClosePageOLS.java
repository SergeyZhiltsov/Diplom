package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QualifiedClosePageOLS extends MainPageBlinx {

    private final String titleExpectedPart1 = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you.";
    private final String titleExpectedPart2 = "We also have eczema studies for children and teens between the ages of 12-17.\n" +
            "Would you like to see if there is study that's right for your child?";

    @FindBy(xpath = "(//div[@class='question-text'])[1]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text'])[2]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//div[@class='single-choice-answers-container']/button")
    List<WebElement> singleChoiceButtonsList;

    @Step
    public QualifiedClosePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleTextPart1, titleExpectedPart1);
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public QualifiedClosePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}

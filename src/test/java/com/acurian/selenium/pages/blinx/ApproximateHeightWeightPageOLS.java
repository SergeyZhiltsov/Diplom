package com.acurian.selenium.pages.blinx;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ApproximateHeightWeightPageOLS extends MainPageBlinx {

    private final String titleExpectedPart1 = "What is your approximate height?";
    private final String titleExpectedPart2 = "What is your approximate weight?";

    @FindBy(xpath = "(//div[@class='question-text']/div)[2]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/div)[3]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//div[@data-question-basis='HEIGHT']//label[contains(., 'feet')]/following-sibling::input")
    WebElement feetField;
    @FindBy(xpath = "//div[@data-question-basis='HEIGHT']//label[contains(., 'inches')]/following-sibling::input")
    WebElement inchesField;
    @FindBy(xpath = "//div[@data-question-basis='WEIGHT']//input")
    WebElement poundsField;

    @Step
    public ApproximateHeightWeightPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleTextPart1, titleExpectedPart1);
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public ApproximateHeightWeightPageOLS setFeet(String feet) {
        typeText(feetField, feet);
        return this;
    }

    @Step
    public ApproximateHeightWeightPageOLS setInches(String inches) {
        typeText(inchesField, inches);
        return this;
    }

    @Step
    public ApproximateHeightWeightPageOLS setPounds(String pounds) {
        typeText(poundsField, pounds);
        return this;
    }

    @Step
    public ApproximateHeightWeightPageOLS setAllFields(String feet, String inches, String pounds) {
        setFeet(feet);
        setInches(inches);
        setPounds(pounds);
        return this;
    }
}

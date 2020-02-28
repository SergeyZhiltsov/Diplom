package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApproximateHeightPageOLS extends MainPageBlinx {

    public final String titleExpectedPart1 = "What is your approximate height?";
    private final String titleExpectedPart2 = "What is your approximate weight?";


    @FindBy(xpath = "(//div[@class='question-text']/span)[1]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/span)[2]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//div[@data-question-basis='HEIGHT']//label[contains(., 'feet')]/following-sibling::input")
    WebElement feetField;
    @FindBy(xpath = "//div[@data-question-basis='HEIGHT']//label[contains(., 'inches')]/following-sibling::input")
    WebElement inchesField;
    @FindBy(xpath = "//div[@data-question-basis='WEIGHT']//input")
    WebElement poundsField;

    public ApproximateHeightPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApproximateHeightPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleTextPart1, titleExpectedPart1);
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public ApproximateHeightPageOLS setFeet(String feet) {
        typeText(feetField, feet);
        return this;
    }

    @Step
    public ApproximateHeightPageOLS setInches(String inches) {
        typeText(inchesField, inches);
        return this;
    }

    @Step
    public ApproximateHeightPageOLS setPounds(String pounds) {
        typeText(poundsField, pounds);
        return this;
    }

    @Step
    public ApproximateHeightPageOLS setAll(String feet, String inches, String pounds) {
        setFeet(feet);
        setInches(inches);
        setPounds(pounds);
        return this;
    }

}


package com.acurian.selenium.pages.blinx.gmega.intro;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LetsGetStartedPageOLS extends MainPageBlinx {

    private final String titleExpectedPart1 = "Let's get started to see if you qualify for %s\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $%s\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    private final String titleExpectedPart2 = "What is your date of birth?";

    @FindBy(xpath = "(//div[@class='question-text']/div)[1]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/div)[2]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//input[@class='fallbackDate']")
    WebElement dateField;

    @Step
    public LetsGetStartedPageOLS waitForPageLoad(String indication, String compensation) {
        waitForPageLoadMain(titleTextPart1, String.format(titleExpectedPart1, indication, compensation));
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public LetsGetStartedPageOLS setDate(String date) {
        typeText(dateField, date);
        return this;
    }
}

package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LevelOfPainPageOLS extends MainPageOLS{

    public final String titleExpected = "Thinking about the last 24 hours, what would you say is your level of pain on a 0 to 10 scale, where 0 means there has been no pain at all and 10 means it is the worst pain imaginable?\n" +
            "\n" +
            "Please note that you can pick any number from 0 to 10.\n" +
            "\n" +
            "Please enter your Pain Rating:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//input")
    WebElement ratingField;

    public LevelOfPainPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LevelOfPainPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LevelOfPainPageOLS setRating(String number) {
        typeText(ratingField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

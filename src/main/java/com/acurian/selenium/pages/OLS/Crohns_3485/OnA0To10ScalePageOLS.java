package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OnA0To10ScalePageOLS extends MainPageOLS{

    public final String titleExpected = "As you probably know, people with Crohn’s disease usually go through periods when the disease is quiet and few or no symptoms are present, alternating with times when it is active and causing symptoms for an extended period.\n" +
            "\n" +
            "When symptoms such as strong abdominal cramps, bloody diarrhea, fever, unusual gas and weight loss occur, we call this a flare-up.\n" +
            "\n" +
            "On a 0 to 10 scale where 0 means your Crohn’s is in full remission and 10 means your Crohn’s is currently full-scale and extremely severe, how would you rate your Crohn’s as it is right now?\n" +
            "\n" +
            "Please note that you can pick any number from 0 to 10.\n" +
            "\n" +
            "\n" +
            "\n" +
            "Please enter your Crohn’s Rating:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//input")
    WebElement ratingField;

    public OnA0To10ScalePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OnA0To10ScalePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OnA0To10ScalePageOLS setRating(String number) {
        typeText(ratingField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

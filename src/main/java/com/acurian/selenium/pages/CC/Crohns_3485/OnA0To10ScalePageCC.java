package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OnA0To10ScalePageCC extends MainPageCC{

    public final String titleExpected = "As you probably know, people with Crohn’s disease usually go through periods when the disease is quiet and few or no symptoms are present, alternating with times when it is active and causing symptoms for an extended period.\n" +
            "\n" +
            "When symptoms such as strong abdominal cramps, bloody diarrhea, fever, unusual gas and weight loss occur, we call this a flare-up.\n" +
            "\n" +
            "On a 0 to 10 scale where 0 means your Crohn’s is in full remission and you have absolutely no symptoms at all and 10 means your Crohn’s is currently full-scale and extremely severe where symptoms are interfering with your life and you cannot function at all, how would you rate your Crohn’s as it is right now?\n" +
            "\n" +
            "Note that 5 means you have more than just a few symptoms which interfere, but you are managing. Please note that you can pick any number from 0 to 10.\n" +
            "\n" +
            "Please enter your Crohn’s Rating:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement ratingField;

    public OnA0To10ScalePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OnA0To10ScalePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OnA0To10ScalePageCC setRating(String number) {
        typeText(ratingField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

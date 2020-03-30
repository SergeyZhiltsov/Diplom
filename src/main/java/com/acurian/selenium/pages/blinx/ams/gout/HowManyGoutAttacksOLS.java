package com.acurian.selenium.pages.blinx.ams.gout;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowManyGoutAttacksOLS extends MainPageBlinx {

    public final String titleExpected = "A gout attack or flare is when you suddenly experience severe pain, swelling, heat, redness, or tenderness in a joint, often the joint at the base of your big toe. Attacks often occur at night, and the pain wakes you up.\n" +
            "How many gout attacks, or gout flares, have you had in the past year?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public HowManyGoutAttacksOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyGoutAttacksOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

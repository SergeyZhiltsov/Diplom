package com.acurian.selenium.pages.CC.PSO_456;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EnoughPsoriasisToEqualAtLeastOneHandprintCC extends MainPageCC {

    public final String titleExpected = "We need to begin to understand how much of your body is affected by psoriasis.\n" +
            "\n" +
            "Plaques can appear anywhere. Small patches may add up to at least one handprint, or a large patch may equal at least one handprint.\n" +
            "\n" +
            "Please tell us if you have enough psoriasis on your body to equal at least one handprint.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonList;

    @Step
    public EnoughPsoriasisToEqualAtLeastOneHandprintCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EnoughPsoriasisToEqualAtLeastOneHandprintCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

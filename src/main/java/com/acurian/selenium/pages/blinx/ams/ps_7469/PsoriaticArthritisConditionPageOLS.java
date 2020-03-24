package com.acurian.selenium.pages.blinx.ams.ps_7469;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PsoriaticArthritisConditionPageOLS extends MainPageBlinx {

    public final String titleExpected = "Psoriatic arthritis is a condition that affects some people with psoriasis, and can cause pain, stiffness, and swelling in your joints.\n" +
            "It is different from other types of arthritis such as Osteoarthritis and Rheumatoid arthritis.\n" +
            "Has a doctor ever diagnosed you with psoriatic arthritis?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public PsoriaticArthritisConditionPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PsoriaticArthritisConditionPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

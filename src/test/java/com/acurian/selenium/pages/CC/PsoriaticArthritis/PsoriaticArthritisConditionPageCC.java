package com.acurian.selenium.pages.CC.PsoriaticArthritis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PsoriaticArthritisConditionPageCC extends MainPageCC {

    public final String titleExpected = "Psoriatic arthritis is a condition that affects some people with psoriasis, and can cause pain, stiffness, and swelling in your joints.\n" +
            "It is different from other types of arthritis such as Osteoarthritis and Rheumatoid arthritis.\n" +
            "Has a doctor ever diagnosed you with psoriatic arthritis?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public PsoriaticArthritisConditionPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PsoriaticArthritisConditionPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

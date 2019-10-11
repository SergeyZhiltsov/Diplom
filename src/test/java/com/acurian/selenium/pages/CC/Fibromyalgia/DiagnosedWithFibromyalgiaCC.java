package com.acurian.selenium.pages.CC.Fibromyalgia;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedWithFibromyalgiaCC extends MainPageCC {

    public final String titleExpected = "Fibromyalgia is a common condition causing:\n" +
            "•Widespread pain in multiple areas of the body\n" +
            "•Moderate to severe problems with sleep or fatigue\n" +
            "•Difficulty thinking or paying attention, often described as \"fibro fog\"\n" +
            "Has a doctor ever diagnosed you with fibromyalgia?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public DiagnosedWithFibromyalgiaCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithFibromyalgiaCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

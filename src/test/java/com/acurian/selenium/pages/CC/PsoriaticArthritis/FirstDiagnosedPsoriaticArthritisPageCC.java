package com.acurian.selenium.pages.CC.PsoriaticArthritis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FirstDiagnosedPsoriaticArthritisPageCC extends MainPageCC {

    public final String titleExpected = "When were you first diagnosed with psoriatic arthritis?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public FirstDiagnosedPsoriaticArthritisPageCC waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FirstDiagnosedPsoriaticArthritisPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

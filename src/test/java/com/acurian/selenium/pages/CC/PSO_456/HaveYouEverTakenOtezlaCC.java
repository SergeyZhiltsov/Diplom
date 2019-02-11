package com.acurian.selenium.pages.CC.PSO_456;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverTakenOtezlaCC extends MainPageCC {
    public final String titleExpected = "Have you ever taken Otezla, also called apremilast?\n" +
            "Otezla is an oral medication (taken by mouth) for treatment of psoriasis and psoriatic arthritis, but may also be taken for other conditions.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonList;

    public HaveYouEverTakenOtezlaCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTakenOtezlaCC waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverTakenOtezlaCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

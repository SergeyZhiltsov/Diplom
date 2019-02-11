package com.acurian.selenium.pages.OLS.PS_4656;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverTakenOteziaPageOLS extends MainPageOLS {

    public final String titleExpected = "Have you ever taken Otezla, also called apremilast?\n" +
            "Otezla is an oral medication (taken by mouth) for treatment of psoriasis and psoriatic arthritis, but may also be taken for other conditions.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public EverTakenOteziaPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EverTakenOteziaPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverTakenOteziaPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

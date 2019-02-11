package com.acurian.selenium.pages.OLS.PS_4656;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HealthcareDiagnosedPsoriasisPageOLS extends MainPageOLS {

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with psoriasis?\n" +
            "Psoriasis is an autoimmune condition that causes too many skin cells. Your skin forms raised, red plaques covered with silvery scales, which may be painful or itch.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HealthcareDiagnosedPsoriasisPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HealthcareDiagnosedPsoriasisPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HealthcareDiagnosedPsoriasisPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

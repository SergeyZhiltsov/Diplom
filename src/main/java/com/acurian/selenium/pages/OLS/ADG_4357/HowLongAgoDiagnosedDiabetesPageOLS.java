package com.acurian.selenium.pages.OLS.ADG_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowLongAgoDiagnosedDiabetesPageOLS extends MainPageOLS {

    public final String titleExpected = "How long ago were you diagnosed with diabetes?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HowLongAgoDiagnosedDiabetesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongAgoDiagnosedDiabetesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowLongAgoDiagnosedDiabetesPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

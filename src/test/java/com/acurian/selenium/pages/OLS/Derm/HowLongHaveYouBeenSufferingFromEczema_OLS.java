package com.acurian.selenium.pages.OLS.Derm;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowLongHaveYouBeenSufferingFromEczema_OLS extends MainPageOLS {

	public final String titleExpected = "How long have you been suffering from eczema (atopic dermatitis)?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HowLongHaveYouBeenSufferingFromEczema_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongHaveYouBeenSufferingFromEczema_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowLongHaveYouBeenSufferingFromEczema_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.OLS.gmega1;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TakingAcetaminophenTylenolPageOLS extends MainPageOLS{

    public final String titleExpected = "Are you currently taking Acetaminophen (Tylenol)?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText1;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_MOBILE)
    WebElement titleText2;

    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public TakingAcetaminophenTylenolPageOLS() {
            PageFactory.initElements(getDriver(), this);
        if (Locators.isEnvWeb) {
            titleText = titleText1;
        }
        else {
            titleText = titleText2;
        }
    }

    @Step
    public TakingAcetaminophenTylenolPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TakingAcetaminophenTylenolPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

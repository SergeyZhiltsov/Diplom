package com.acurian.selenium.pages.OLS.gmega;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BasedOnInformationGmegaPageOLS extends MainPageOLS {

    public final String titleExpected = "Based on the information you have provided, you have prequalified for this study. Unfortunately, study sites in your area are not accepting patients at this time. We will contact you as soon as a study site near you accepts new patients.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public BasedOnInformationGmegaPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public BasedOnInformationGmegaPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public BasedOnInformationGmegaPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class YouIndicatedThatPageOLS extends MainPageOLS{

    public final String titleExpected1 = "You indicated that you would rate your current Crohn’s as 0. Based on this, do you feel your Crohn’s is currently in remission?";
    public final String titleExpected2 = "You indicated that you would rate your current Crohn’s as 1. Based on this, do you feel your Crohn’s is currently in remission?";
    public final String titleExpected3 = "You indicated that you would rate your current Crohn’s as 2. Based on this, do you feel your Crohn’s is currently in remission?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public YouIndicatedThatPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public YouIndicatedThatPageOLS waitForPageLoad(String titleExpected) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public YouIndicatedThatPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

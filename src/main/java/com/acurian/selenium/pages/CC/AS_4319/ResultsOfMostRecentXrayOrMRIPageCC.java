package com.acurian.selenium.pages.CC.AS_4319;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class ResultsOfMostRecentXrayOrMRIPageCC extends MainPageCC {

    public final String titleExpected = "What did your doctor tell you about the results of your most recent x-ray or MRI?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public ResultsOfMostRecentXrayOrMRIPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ResultsOfMostRecentXrayOrMRIPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ResultsOfMostRecentXrayOrMRIPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

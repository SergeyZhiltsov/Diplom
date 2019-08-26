package com.acurian.selenium.pages.OLS.AS_4319;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultsOfMostRecentXrayOrMRIPageOLS extends MainPageOLS {

    public final String titleExpected = "What did your doctor tell you about the results of your most recent x-ray or MRI?";
    

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public ResultsOfMostRecentXrayOrMRIPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ResultsOfMostRecentXrayOrMRIPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ResultsOfMostRecentXrayOrMRIPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

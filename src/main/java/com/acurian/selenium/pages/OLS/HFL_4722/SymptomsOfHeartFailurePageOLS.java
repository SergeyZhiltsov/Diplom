package com.acurian.selenium.pages.OLS.HFL_4722;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SymptomsOfHeartFailurePageOLS extends MainPageOLS {

    public final String titleExpected = "Symptoms of heart failure include fatigue or feeling tired, rapid heartbeat, shortness of breath or difficulty breathing, frequent coughing, and swelling of feet, ankles or legs.\n" +
            "Which of the following best describes how often you have symptoms of heart failure?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public SymptomsOfHeartFailurePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SymptomsOfHeartFailurePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SymptomsOfHeartFailurePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

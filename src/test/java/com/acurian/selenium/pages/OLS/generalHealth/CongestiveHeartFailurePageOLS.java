package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CongestiveHeartFailurePageOLS extends MainPageOLS{

    public final String titleExpected = "Heart failure is also called congestive heart failure or CHF. It is an ongoing health problem. It happens when your heart cannot pump as well as it should.\n" +
            "\n" +
            "Many people with heart failure have a history of other heart problems, like a heart attack or blocked arteries. However, heart failure is a different, specific medical condition. Not everyone who has had a heart attack will develop heart failure.\n" +
            "Has a healthcare professional told you that you have heart failure, congestive heart failure, or CHF?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public CongestiveHeartFailurePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CongestiveHeartFailurePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CongestiveHeartFailurePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

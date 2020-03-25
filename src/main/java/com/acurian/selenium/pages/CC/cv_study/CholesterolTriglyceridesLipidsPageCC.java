package com.acurian.selenium.pages.CC.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CholesterolTriglyceridesLipidsPageCC extends MainPageCC {

    public final String titleExpected = "Are you currently taking medication to manage high cholesterol, triglycerides, or lipids?\n" +
            "This may include statins like Lipitor or Zocor, injectable drugs like Praluent or Repatha, or other options such as niacin, fibrates, Prevalite, or Zetia.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public CholesterolTriglyceridesLipidsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CholesterolTriglyceridesLipidsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CholesterolTriglyceridesLipidsPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
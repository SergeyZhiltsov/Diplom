package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TriglyceridesOrLipidsPageOLS extends MainPageOLS{

    public final String titleExpected = "Are you currently taking medication to manage high cholesterol, triglycerides, or lipids?\n" +
            "A common example of this type of medicine is called a \"statin,\" such as atorvastatin (Lipitor) or simvastatin (Zocor). Other types of medication may be prescribed, too.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public TriglyceridesOrLipidsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TriglyceridesOrLipidsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TriglyceridesOrLipidsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

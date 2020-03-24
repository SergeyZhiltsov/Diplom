package com.acurian.selenium.pages.CC.shared.DIA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class AnyPrescribedMedicationPage extends MainPageCC{

    public final String titleExpected = "Have you taken any prescribed medication for your diabetes within the past 3 months?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public AnyPrescribedMedicationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AnyPrescribedMedicationPage waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AnyPrescribedMedicationPage clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

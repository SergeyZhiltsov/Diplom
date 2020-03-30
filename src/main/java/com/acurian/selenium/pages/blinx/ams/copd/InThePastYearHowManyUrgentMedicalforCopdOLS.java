package com.acurian.selenium.pages.blinx.ams.copd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InThePastYearHowManyUrgentMedicalforCopdOLS extends MainPageBlinx {

    public final String titleExpected = "In the past year, how many times did you have to seek urgent medical attention (at a hospital, ER, urgent care, or your doctor's office) for your COPD symptoms?\n" +
            "Please do not count any routine medical appointments for your COPD.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public InThePastYearHowManyUrgentMedicalforCopdOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InThePastYearHowManyUrgentMedicalforCopdOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InThePastYearHowManyUrgentMedicalforCopdOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

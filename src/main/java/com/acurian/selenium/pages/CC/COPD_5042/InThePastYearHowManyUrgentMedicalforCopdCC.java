package com.acurian.selenium.pages.CC.COPD_5042;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InThePastYearHowManyUrgentMedicalforCopdCC extends MainPageCC {

    public final String titleExpected = "In the past year, how many times did you have to seek urgent medical attention (at a hospital, ER, urgent care, or your doctor's office) for your COPD symptoms?\n" +
            "Please do not count any routine medical appointments for your COPD.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public InThePastYearHowManyUrgentMedicalforCopdCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InThePastYearHowManyUrgentMedicalforCopdCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InThePastYearHowManyUrgentMedicalforCopdCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
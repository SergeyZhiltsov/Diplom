package com.acurian.selenium.pages.OLS.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HealthcareDiagnosedConditionsPageOLS extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following medical conditions?\n" +
            "Please select all that apply.";
    public final String titleExpectedGBAN = "Has a healthcare professional ever diagnosed you with any of the following medical conditions? Select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleTextGBAN;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_OLS)
    List<WebElement> checkBoxListGBAN;


    public HealthcareDiagnosedConditionsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HealthcareDiagnosedConditionsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HealthcareDiagnosedConditionsPageOLS waitForPageLoadGBAN() {
        waitForPageLoadMain(titleTextGBAN, titleExpectedGBAN);
        return this;
    }

    @Step
    public HealthcareDiagnosedConditionsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public HealthcareDiagnosedConditionsPageOLS clickOnAnswersGBAN(String ...answerText) {
        clickOnCheckBoxes(checkBoxListGBAN, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.Diabetes_4356A.DiabeticNephropathyPageOLS;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class StatinMedicationPreviousQuestionPageOLS extends MainPageOLS{

    public final String titleExpected = "How long have you been taking your statin medication(s) from the previous question?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public StatinMedicationPreviousQuestionPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StatinMedicationPreviousQuestionPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public StatinMedicationPreviousQuestionPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

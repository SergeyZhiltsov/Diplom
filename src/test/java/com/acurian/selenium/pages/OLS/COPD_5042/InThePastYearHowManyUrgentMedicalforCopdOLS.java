package com.acurian.selenium.pages.OLS.COPD_5042;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InThePastYearHowManyUrgentMedicalforCopdOLS extends MainPageOLS {

    public final String titleExpected = "In the past year, how many times did you have to seek urgent medical attention (at a hospital, ER, urgent care, or your doctor's office) for your COPD symptoms?\n" +
	"Please do not count any routine medical appointments for your COPD.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public InThePastYearHowManyUrgentMedicalforCopdOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InThePastYearHowManyUrgentMedicalforCopdOLS waitForPageLoad() {
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

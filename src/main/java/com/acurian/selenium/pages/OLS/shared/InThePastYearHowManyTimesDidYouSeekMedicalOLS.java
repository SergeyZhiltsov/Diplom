package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InThePastYearHowManyTimesDidYouSeekMedicalOLS extends MainPageOLS{

    public final String titleExpected = "In the past year, how many times did you have to seek any medical attention (at a hospital, ER, urgent care, or your family doctor) for your asthma symptoms?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public InThePastYearHowManyTimesDidYouSeekMedicalOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InThePastYearHowManyTimesDidYouSeekMedicalOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InThePastYearHowManyTimesDidYouSeekMedicalOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class UnqualifiedCloseOLS extends MainPageOLS{

    //Pediatric module
    public final String titleExpected = "We certainly appreciate your interest in this study. Unfortunately, from the information you have provided, you would not be a candidate for this study.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText1;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]")
    WebElement titleText2;

    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public UnqualifiedCloseOLS() {
        PageFactory.initElements(getDriver(), this);
        if (Locators.isEnvWeb) {
            titleText = titleText1;
        }
        else {
            titleText = titleText2;
        }
    }

    @Step
    public UnqualifiedCloseOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public UnqualifiedCloseOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

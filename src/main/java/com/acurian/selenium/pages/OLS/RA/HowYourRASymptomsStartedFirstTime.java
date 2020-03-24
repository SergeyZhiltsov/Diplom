package com.acurian.selenium.pages.OLS.RA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowYourRASymptomsStartedFirstTime extends MainPageOLS {
	public final String titleExpected = "Which of the following best describes how your RA symptoms started for the very first time?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public HowYourRASymptomsStartedFirstTime() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowYourRASymptomsStartedFirstTime waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowYourRASymptomsStartedFirstTime clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

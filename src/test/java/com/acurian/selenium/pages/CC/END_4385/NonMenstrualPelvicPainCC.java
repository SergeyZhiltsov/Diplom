package com.acurian.selenium.pages.CC.END_4385;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class NonMenstrualPelvicPainCC extends MainPageCC{

    public final String titleExpected = "Which of the following best describes your pelvic pain at times when you do NOT have your period, and how it affects your life?";
            
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public NonMenstrualPelvicPainCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NonMenstrualPelvicPainCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public NonMenstrualPelvicPainCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

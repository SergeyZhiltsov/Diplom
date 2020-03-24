package com.acurian.selenium.pages.CC.ChronicCough;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class HowLongYouHadChronicCoughCC extends MainPageCC{

    public final String titleExpected = "How long have you had your chronic cough?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;    

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    
    public HowLongYouHadChronicCoughCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongYouHadChronicCoughCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowLongYouHadChronicCoughCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

package com.acurian.selenium.pages.CC.DPN_3769_4557;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;


public class HowWouldYouRateYourPain_CC<Just> extends MainPageCC {

    public final String titleExpected ="How would you rate your pain or discomfort on a scale of 0 to 10?\n" +
    		"0 means no pain or discomfort at all, and 10 is the worst pain or discomfort you can imagine.";

    
    @FindBy(xpath = "//div[@class='question_text']")
    WebElement questionText;
    


    @FindBy(xpath = "//select[@id='QS5510']")
    WebElement painSelect;



    public HowWouldYouRateYourPain_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowWouldYouRateYourPain_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> questionText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public String getQuestionText1() {
        return getText(questionText);
    }

    
    @Step
    public String getTitleText() {
        return getText(questionText);
    }

    @Step
    public HowWouldYouRateYourPain_CC selectPainRating(String rating) {
        selectDropDownListOptionByText(painSelect, rating);
        return this;
    }

}
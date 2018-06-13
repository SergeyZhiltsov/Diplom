package com.acurian.selenium.pages.CC.END_4385;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.END_4385.ApproxHowManyDaysInYourMenstrualCycle_OLS;

import ru.yandex.qatools.allure.annotations.Step;

public class ApproxHowManyDaysInYourMenstrualCycle_CC extends MainPageCC{

    public final String titleExpected = "Approximately how many days are in your menstrual cycle?\n" +
    		"Please count from the first day of one period to the first day of the next period in your estimate.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement ageMig;
    
    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement enterDays;
    
    public ApproxHowManyDaysInYourMenstrualCycle_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApproxHowManyDaysInYourMenstrualCycle_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public ApproxHowManyDaysInYourMenstrualCycle_CC typeAge(String text) {
        //typeTextWithoutClear(ageMig, text);
        typeText(ageMig, text);
        return this;
    }
    
    @Step
    public ApproxHowManyDaysInYourMenstrualCycle_CC setDays(String days) {
       typeText(enterDays,days);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

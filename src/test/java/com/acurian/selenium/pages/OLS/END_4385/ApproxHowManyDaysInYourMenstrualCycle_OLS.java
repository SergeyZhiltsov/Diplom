package com.acurian.selenium.pages.OLS.END_4385;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class ApproxHowManyDaysInYourMenstrualCycle_OLS extends MainPageOLS {
	public final String titleExpected = "Approximately how many days are in your menstrual cycle?\n" +
			"Please count from the first day of one period to the first day of the next period in your estimate.";

    @FindBy(xpath = "//div[contains(@class,'visible-md-block visible-lg-block ng')]")
    WebElement titleText;
    
    @FindBy(xpath = "//div[contains(@class,'center-block')]//input")
    WebElement enterDays;		
    
    public ApproxHowManyDaysInYourMenstrualCycle_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApproxHowManyDaysInYourMenstrualCycle_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public ApproxHowManyDaysInYourMenstrualCycle_OLS setDays(String days) {
       typeText(enterDays,days);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}

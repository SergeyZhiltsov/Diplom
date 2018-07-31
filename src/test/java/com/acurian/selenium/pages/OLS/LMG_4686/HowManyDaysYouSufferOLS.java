package com.acurian.selenium.pages.OLS.LMG_4686;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDaysYouSufferOLS extends MainPageOLS {

	   public final String titleExpected ="A migraine attack could last from a few hours to a few days.\n" +
			   "In a typical month, how many days do you suffer from migraines?\n" +
			   "If you have a migraine that starts on a Monday and ends on a Tuesday, that counts as two separate days.";
	
	    
	    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
	    WebElement titleText;	    

	    @FindBy(xpath = "//select[@id='QS6005']")
	    WebElement daysSelect;
	    

	    public HowManyDaysYouSufferOLS() {
	        PageFactory.initElements(getDriver(), this);
	    }

	    
	    @Step
	    public HowManyDaysYouSufferOLS waitForPageLoad() {
	        waitForPageLoadMain(titleText, titleExpected);
	        return this;
	    }	
	    
	    @Step
	    public String getTitleText() {
	        return getText(titleText);
	    }
	    
	    @Step
	    public HowManyDaysYouSufferOLS selectDays(String days) {
	        selectDropDownListOptionByText(daysSelect, days);
	        return this;
	    }

}

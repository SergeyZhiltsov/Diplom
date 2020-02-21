package com.acurian.selenium.pages.OLS.LMG_4686;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDaysYouTakeMedicationsOLS extends MainPageOLS {

	   public final String titleExpected ="In the past month, how many days did you take any of the medications you just indicated in the previous question?";
	
	    
	    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
	    WebElement titleText;	    

	    @FindBy(xpath = "//select[@ng-model='currentquestion.dropdownAnswer']")
	    WebElement daysSelect;
	    

	    public HowManyDaysYouTakeMedicationsOLS() {
	        PageFactory.initElements(getDriver(), this);
	    }

	    
	    @Step
	    public HowManyDaysYouTakeMedicationsOLS waitForPageLoad() {
	        waitForPageLoadMain(titleText, titleExpected);
	        return this;
	    }	
	    
	    @Step
	    public String getTitleText() {
	        return getText(titleText);
	    }
	    
	    @Step
	    public HowManyDaysYouTakeMedicationsOLS selectDays(String days) {
	        selectDropDownListOptionByText(daysSelect, days);
	        return this;
	    }

}

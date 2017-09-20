package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ZipCodePage extends BasePage {
	
	 @FindBy(xpath = "//div[(@class='clearfix ng-scope')]//div[contains(@class,'visible-md-block')]")
	    WebElement titleText;

	    @FindBy(xpath = "//input[contains(@id,'QSI8008')]")
	    WebElement zipField;

	    public ZipCodePage() {
	        PageFactory.initElements(getDriver(), this);
	    }

	    @Step
	    public ZipCodePage waitForPageLoad() {
	        waitForAnimation();
	        driverWait.waitforVisibility(titleText);
	        return this;
	    }

	    @Step
	    public ZipCodePage typeZipCode(String text) {
	        typeText(zipField, text);
	        return this;
	    }
	    
	    @Step
	    public String getTitleText(){
	        return getText(titleText);
	    }

	}

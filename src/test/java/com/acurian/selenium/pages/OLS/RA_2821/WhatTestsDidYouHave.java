package com.acurian.selenium.pages.OLS.RA_2821;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhatTestsDidYouHave extends MainPageOLS {
	public final String titleExpected = "What tests did you have that led to your doctor diagnosing your Rheumatoid Arthritis?";

    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
    
    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    WebElement enterAge;		
    
    public WhatTestsDidYouHave() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhatTestsDidYouHave waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhatTestsDidYouHave clickOnAnswer(String answerText) {
       
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}

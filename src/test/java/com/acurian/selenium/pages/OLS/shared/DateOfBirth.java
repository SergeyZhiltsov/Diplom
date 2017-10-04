package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DateOfBirth extends BasePage{
	
	@FindBy(xpath = "//div[contains(@class,'question-holder-two')]/div[contains(@class,'ng-scope')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement questionText;

    @FindBy(xpath = "//div[contains(@class,'question-holder-two')]/div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//input[@id='QSI8004A']")
    WebElement enterDOB;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement nextButton;

    public DateOfBirth() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DateOfBirth waitForPageLoad() {
        //waitForAnimation();
        driverWait.waitforVisibility(questionText);
        return this;
    }

    @Step
    public String getQuestionText() {
        return getText(questionText);
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
    
    @Step
    public DateOfBirth setDOB(String DOB) {
    	typeText(enterDOB,DOB);
    	return this;
    }
    
    @Step
    public DateOfBirth nextButton() {
        nextButton.click();
        return this;
    }
    
    @Step
    public DateOfBirth openPage(){
//    openURL(URLs.OLS_QA_RA);
    return this;
    }   
     

  }

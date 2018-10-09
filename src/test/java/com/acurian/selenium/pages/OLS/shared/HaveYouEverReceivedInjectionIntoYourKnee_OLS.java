package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverReceivedInjectionIntoYourKnee_OLS extends MainPageOLS {
	
	public final String titleExpected = "Have you ever received an injection into your knee to treat your arthritis pain?\n" +
			"Please select all that apply.";         
      

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HaveYouEverReceivedInjectionIntoYourKnee_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverReceivedInjectionIntoYourKnee_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HaveYouEverReceivedInjectionIntoYourKnee_OLS clickOnAnswer(String answerText) {
    	 clickOnCheckBoxes(checkBoxList, answerText);
         return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

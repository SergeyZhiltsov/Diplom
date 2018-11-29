package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowingDevicesInYourBodyOLS extends MainPageOLS {
	
	public final String titleExpected = "Do you have any of the following devices in your body?\n" +
            "Please select all that apply.";         
      

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public FollowingDevicesInYourBodyOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingDevicesInYourBodyOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public FollowingDevicesInYourBodyOLS clickOnAnswer(String answerText) {
    	 clickOnCheckBoxes(checkBoxList, answerText);
         return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

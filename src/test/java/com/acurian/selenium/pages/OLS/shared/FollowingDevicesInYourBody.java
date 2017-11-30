package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowingDevicesInYourBody extends MainPageOLS {
	
	public final String titleExpected = "Do you have any of the following devices in your body?\n" +
            "Please select all that apply.";         
      

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS4514_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public FollowingDevicesInYourBody() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingDevicesInYourBody waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public FollowingDevicesInYourBody clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
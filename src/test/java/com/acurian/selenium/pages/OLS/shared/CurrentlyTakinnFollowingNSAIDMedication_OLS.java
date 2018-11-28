package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class CurrentlyTakinnFollowingNSAIDMedication_OLS extends MainPageOLS {
	
	public final String titleExpected = "Are you currently taking the following NSAID medication(s)?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> radioButtonsList;

    public CurrentlyTakinnFollowingNSAIDMedication_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyTakinnFollowingNSAIDMedication_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public CurrentlyTakinnFollowingNSAIDMedication_OLS clickOnAnswer(String answerText) {
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

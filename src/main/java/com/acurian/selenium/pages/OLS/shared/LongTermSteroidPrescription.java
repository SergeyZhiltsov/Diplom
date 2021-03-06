package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class LongTermSteroidPrescription extends MainPageOLS {
	
	public final String titleExpected = "Are you currently on a long term steroid prescription medication for more than 10 days?\n" +
	     "Commonly used types of steroids include prednisone, prednisolone, dexamethasone, methylprednisolone, and Medrol.";
      

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS4513_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public LongTermSteroidPrescription() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LongTermSteroidPrescription waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public LongTermSteroidPrescription clickOnAnswer(String answerText) {
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

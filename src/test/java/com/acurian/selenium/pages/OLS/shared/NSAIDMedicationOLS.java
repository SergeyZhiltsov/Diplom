package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class NSAIDMedicationOLS extends MainPageOLS {
	public final String titleExpected = "The following medications are called NSAIDs. They may be available over-the-counter or with a prescription.\n" + 
            "Have you ever taken any of the following medications for your pain?\n" +
			"Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> radioButtonsList;

    public NSAIDMedicationOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NSAIDMedicationOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public NSAIDMedicationOLS clickOnAnswer(String answerText) {
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

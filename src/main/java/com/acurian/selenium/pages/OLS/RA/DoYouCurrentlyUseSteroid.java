package com.acurian.selenium.pages.OLS.RA;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class DoYouCurrentlyUseSteroid extends MainPageOLS {
	public final String titleExpected = "Do you currently use any oral (taken by mouth) steroid medications every day or every other day to treat or manage your RA?\n" +
             "Commonly used types of steroids include prednisone, prednisolone, dexamethasone, methylprednisolone, and Medrol.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,' choice')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public DoYouCurrentlyUseSteroid() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouCurrentlyUseSteroid waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public DoYouCurrentlyUseSteroid clickOnAnswer(String answerText) {
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

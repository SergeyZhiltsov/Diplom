package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class InPast3MonthsMedicationToStopActiveMIG extends MainPageOLS {
	public final String titleExpected = "In the past 3 months, how many days per month have you used medication to stop an active migraine?\n" +
			"Please do not include medication you use to prevent migraines from starting.";
	
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public InPast3MonthsMedicationToStopActiveMIG() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InPast3MonthsMedicationToStopActiveMIG waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public InPast3MonthsMedicationToStopActiveMIG clickOnAnswer(String answerText) {
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

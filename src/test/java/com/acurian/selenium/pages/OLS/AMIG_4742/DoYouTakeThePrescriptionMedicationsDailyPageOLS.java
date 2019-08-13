package com.acurian.selenium.pages.OLS.AMIG_4742;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouTakeThePrescriptionMedicationsDailyPageOLS extends MainPageOLS {
	public final String titleExpected =
      "Do you take the prescription medications daily to keep migraines from starting?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public DoYouTakeThePrescriptionMedicationsDailyPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouTakeThePrescriptionMedicationsDailyPageOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public DoYouTakeThePrescriptionMedicationsDailyPageOLS clickOnAnswer(String answerText) {
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

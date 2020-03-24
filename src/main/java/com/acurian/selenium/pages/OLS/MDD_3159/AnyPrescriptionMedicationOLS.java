package com.acurian.selenium.pages.OLS.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class AnyPrescriptionMedicationOLS extends MainPageOLS {
	public final String titleExpected = "To confirm, you have indicated that you have not taken ANY prescription medication for your current episode of depression.\n" +
			"\n" +
			"Is this correct?";			
    
    
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public AnyPrescriptionMedicationOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AnyPrescriptionMedicationOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public AnyPrescriptionMedicationOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class PrescriptionPainMedicationsForArthritis extends MainPageOLS {
	
	public final String titleExpected = "Have you ever taken any of the following prescription pain medications for your arthritis?\n" + "\n" + 
            "Please select all that apply.";         
      

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS4510_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public PrescriptionPainMedicationsForArthritis() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PrescriptionPainMedicationsForArthritis waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public PrescriptionPainMedicationsForArthritis clickOnAnswer(String answerText) {
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

package com.acurian.selenium.pages.OLS.LMG_4686;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDifferentMedicationsOLS extends MainPageOLS {
	public final String titleExpected = "Medications to prevent migraine headaches are taken daily or regularly, not just when a migraine headache is occurring.\n" +
			"Over the past 10 years, how many different medications to prevent migraines have you tried?\n" +
			"Please include any medications you are currently taking to prevent migraines.";

    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]") //"//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
    
    @FindBy(xpath = "//input[@id='QS6007']")
    WebElement medicationNo;    
    
    
    public HowManyDifferentMedicationsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyDifferentMedicationsOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowManyDifferentMedicationsOLS noOfMedications(String medNo) {
       typeText(medicationNo, medNo);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

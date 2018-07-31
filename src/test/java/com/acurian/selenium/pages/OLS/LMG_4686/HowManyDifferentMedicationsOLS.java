package com.acurian.selenium.pages.OLS.LMG_4686;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDifferentMedicationsOLS extends MainPageOLS {
	public final String titleExpected = "Approximately how old were you when you were diagnosed with migraine headaches?";

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

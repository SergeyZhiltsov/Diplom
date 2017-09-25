package com.acurian.selenium.pages.OLS.RA_2821;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicationsToTreatYourRA extends MainPageOLS {
	public final String titleExpected = "How long have you been taking methotrexate?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    
    @FindBy(xpath = "//label[contains(@for,'QS517_')]/span[@class='copy']")
    WebElement enterAge;		
    
    public MedicationsToTreatYourRA () {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MedicationsToTreatYourRA waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public MedicationsToTreatYourRA clickOnAnswer(String answerText) {
       
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

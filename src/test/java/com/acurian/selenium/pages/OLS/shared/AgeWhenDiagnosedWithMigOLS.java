package com.acurian.selenium.pages.OLS.shared;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class AgeWhenDiagnosedWithMigOLS extends MainPageOLS {
	public final String titleExpected = "Approximately how old were you when you were diagnosed with migraine headaches?";

    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]") //"//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
    
    @FindBy(xpath = "//div[contains(@class,'center-block')]//input")
    WebElement enterAge;		
    
    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement ageMig;
    
    public AgeWhenDiagnosedWithMigOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AgeWhenDiagnosedWithMigOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public AgeWhenDiagnosedWithMigOLS setAge(String age) {
       typeText(enterAge,age);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

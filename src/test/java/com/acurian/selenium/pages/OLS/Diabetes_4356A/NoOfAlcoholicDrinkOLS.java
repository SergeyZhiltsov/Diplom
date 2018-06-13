package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class NoOfAlcoholicDrinkOLS extends MainPageOLS {
	
	public final String titleExpected = "Alcohol consumption can affect your liver health over time.";

    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]/div[1]")
    WebElement titleText;
    
    @FindBy(xpath = "//input[@type='tel']")
    WebElement enterDrinks;		
    
    public NoOfAlcoholicDrinkOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NoOfAlcoholicDrinkOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public NoOfAlcoholicDrinkOLS setDrinks(String drinks) {
       typeText(enterDrinks,drinks);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}

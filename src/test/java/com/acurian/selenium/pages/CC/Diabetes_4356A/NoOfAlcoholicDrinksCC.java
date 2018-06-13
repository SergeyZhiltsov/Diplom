package com.acurian.selenium.pages.CC.Diabetes_4356A;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class NoOfAlcoholicDrinksCC extends MainPageCC{

    public final String titleExpected = "Alcohol consumption can affect your liver health over time.\n" +
    		"About how many alcoholic drinks do you have in a typical week?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement noDrinks;
    
    public NoOfAlcoholicDrinksCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NoOfAlcoholicDrinksCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public NoOfAlcoholicDrinksCC enterNoOfDrinks(String text) {
        //typeTextWithoutClear(ageMig, text);
        typeText(noDrinks, text);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

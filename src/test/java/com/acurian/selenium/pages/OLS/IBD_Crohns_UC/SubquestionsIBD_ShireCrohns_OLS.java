package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionsIBD_ShireCrohns_OLS extends MainPageOLS{

    public final String titleExpected1 = "On an average day, how many liquid or very soft bowel movements do you have?";
    public final String titleExpected2 = "In the past 24 hours, how many liquid or very soft bowel movements did you have?";
    public final String titleExpected3 = "In the past 24 hours, what is your level of abdominal pain on a scale of 0 (no pain at all) to 10 (worst pain imaginable)?";

    //@FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    @FindBy(xpath = "(//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')])[1]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724A')]")
    WebElement avgDayBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724B')]")
    WebElement past24hrBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724C')]")
    WebElement abdominalpainScale;
    

    public SubquestionsIBD_ShireCrohns_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIBD_ShireCrohns_OLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionsIBD_ShireCrohns_OLS avgDayBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }
    
    @Step
    public SubquestionsIBD_ShireCrohns_OLS past24hrBowelMovements(String text) {
        typeText(past24hrBowel, text);
        return this;
    }
    
    @Step
    public SubquestionsIBD_ShireCrohns_OLS abdominalpainOnaScale(String text) {
        typeText(abdominalpainScale, text);
        return this;
    }


    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}

package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionsIBD_UlcerativeColitis_OLS extends MainPageOLS{

    public final String titleExpected1 = "On an average day, how many total bowel movements do you have?";
    public final String titleExpected2 = "In the past 24 hours, how many total bowel movements did you have?";
    public final String titleExpected3 = "Over the past 24 hours, did you notice any blood in your stool, on toilet tissue, or in the toilet bowl?";

    //@FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    @FindBy(xpath = "(//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')])[1]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;
    
    @FindBy(xpath = "//input[contains(@id,'QS5725A')]")
    WebElement avgDayBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5725B')]")
    WebElement past24hrBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5725C')]")
    WebElement bloodinstool;
    
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;
    

    public SubquestionsIBD_UlcerativeColitis_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIBD_UlcerativeColitis_OLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionsIBD_UlcerativeColitis_OLS totalBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }
    
    @Step
    public SubquestionsIBD_UlcerativeColitis_OLS totalpast24hrBowelMovements(String text) {
        typeText(past24hrBowel, text);
        return this;
    }    

    
    @Step
    public SubquestionsIBD_UlcerativeColitis_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}

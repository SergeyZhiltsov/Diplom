package com.acurian.selenium.pages.CC.IBD;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.SubquestionsIBD_ShireCrohns_OLS;

import ru.yandex.qatools.allure.annotations.Step;

public class SubquestionsIBD_ShireCrohns_CC extends MainPageCC{

    public final String titleExpected1 = "On an average day, how many liquid or very soft bowel movements do you have?";
    public final String titleExpected2 = "In the past 24 hours, how many liquid or very soft bowel movements did you have?";
    public final String titleExpected3 = "In the past 24 hours, what is your level of abdominal pain on a scale of 0 (no pain at all) to 10 (worst pain imaginable)?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//span[@class='sub_question_text']")
    List<WebElement> titlesText;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724A.rawAnswer')]")
    WebElement avgDayBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724B.rawAnswer')]")
    WebElement past24hrBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724C.rawAnswer')]")
    WebElement abdominalpainScale;
    

    public SubquestionsIBD_ShireCrohns_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIBD_ShireCrohns_CC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }
    
    @Step
    public SubquestionsIBD_ShireCrohns_CC avgDayBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }
    
    @Step
    public SubquestionsIBD_ShireCrohns_CC past24hrBowelMovements(String text) {
        typeText(past24hrBowel, text);
        return this;
    }
    
    @Step
    public SubquestionsIBD_ShireCrohns_CC abdominalpainOnaScale(String text) {
        typeText(abdominalpainScale, text);
        return this;
    }


    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
package com.acurian.selenium.pages.CC.IBD;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.SubquestionsIBD_ShireCrohns_OLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.SubquestionsIBD_UlcerativeColitis_OLS;

import ru.yandex.qatools.allure.annotations.Step;

public class SubquestionsIBD_UlcerativeColitis_CC extends MainPageCC{

    public final String titleExpected1 = "On an average day, how many total bowel movements do you have?";
    public final String titleExpected2 = "In the past 24 hours, how many total bowel movements did you have?";
    public final String titleExpected3 = "Over the past 24 hours, did you notice any blood in your stool, on toilet tissue, or in the toilet bowl?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//span[@class='sub_question_text']")
    List<WebElement> titlesText;
    
    @FindBy(xpath = "//input[contains(@id,'QS5725A.rawAnswer')]")
    WebElement avgDayBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5725B.rawAnswer')]")
    WebElement past24hrBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5725C.rawAnswer')]")
    WebElement abdominalpainScale;
    
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    

    public SubquestionsIBD_UlcerativeColitis_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIBD_UlcerativeColitis_CC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }
    
    @Step
    public SubquestionsIBD_UlcerativeColitis_CC totalBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }
    
    @Step
    public SubquestionsIBD_UlcerativeColitis_CC totalpast24hrBowelMovements(String text) {
        typeText(past24hrBowel, text);
        return this;
    }
    
    @Step
    public SubquestionsIBD_UlcerativeColitis_CC abdominalpainOnaScale(String text) {
        typeText(abdominalpainScale, text);
        return this;
    }

    @Step
    public SubquestionsIBD_UlcerativeColitis_CC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
    
    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.acurian.selenium.pages.BaseTest.getDriver;

public class SubquestionsIBDShireCrohnsPageOLS extends MainPageOLS {

    public final String titleExpected1 = "On an average day, how many liquid or very soft bowel movements do you have?";
    public final String titleExpected2 = "In the past 24 hours, how many liquid or very soft bowel movements did you have?";
    public final String titleExpected3 = "In the past 24 hours, what is your level of abdominal pain on a scale of 0 (no pain at all) to 10 (worst pain imaginable)?";
    public final String titleExpected4 = "Over the past week, how many liquid or very soft bowel movements, or episodes of diarrhea per day did you have on average?";
    public final String titleExpected5 = "Over the past week, how would you rate your average level of abdominal pain or cramping?";
    public final String titleExpected6 = "On an average day, how many total bowel movements do you have?";
    public final String titleExpected7 = "In the past 24 hours, how many total bowel movements did you have?";
    public final String titleExpected8 = "Over the past 24 hours, did you notice any blood in your stool, on toilet tissue, or in the toilet bowl?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;
    
    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//input")
    WebElement avgDayBowel;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//input")
    WebElement averageDayTotalBowelMovements;

    @FindBy(xpath = "//input[@id = 'answersQS5731A.rawAnswer']")
    WebElement overPastWeekAvgDayBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724B.rawAnswer')]")
    WebElement past24hrBowel;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//input")
    WebElement past24HoursTotalBowelMovements;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724C.rawAnswer')]")
    WebElement abdominalpainScale;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    

    public SubquestionsIBDShireCrohnsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIBDShireCrohnsPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }
    
    @Step
    public SubquestionsIBDShireCrohnsPageOLS avgDayBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageOLS setAverageDayTotalBowelMovements(String text) {
        typeText(averageDayTotalBowelMovements, text);
        return this;
    }
    
    @Step
    public SubquestionsIBDShireCrohnsPageOLS past24hrBowelMovements(String text) {
        typeText(past24hrBowel, text);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageOLS setPast24HoursTotalBowelMovements(String text) {
        typeText(past24HoursTotalBowelMovements, text);
        return this;
    }
    
    @Step
    public SubquestionsIBDShireCrohnsPageOLS abdominalpainOnaScale(String text) {
        typeText(abdominalpainScale, text);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageOLS overPastWeekAvgDayBowel(String text) {
        typeText(overPastWeekAvgDayBowel, text);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
package com.acurian.selenium.pages.CC.IBD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class SubquestionsIBDShireCrohnsPageCC extends MainPageCC{

    public final String titleExpected1 = "On an average day, how many liquid or very soft bowel movements do you have?";
    public final String titleExpected2 = "In the past 24 hours, how many liquid or very soft bowel movements did you have?";
    public final String titleExpected3 = "In the past 24 hours, what is your level of abdominal pain on a scale of 0 (no pain at all) to 10 (worst pain imaginable)?";
    public final String titleExpected4 = "Over the past week, how many liquid or very soft bowel movements, or episodes of diarrhea per day did you have on average?";
    public final String titleExpected5 = "Over the past week, how would you rate your average level of abdominal pain or cramping?";
    public final String titleExpected6 = "On an average day, how many total bowel movements do you have?";
    public final String titleExpected7 = "In the past 24 hours, how many total bowel movements did you have?";
    public final String titleExpected8 = "Over the past 24 hours, did you notice any blood in your stool, on toilet tissue, or in the toilet bowl?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//span[@class='sub_question_text']")
    List<WebElement> titlesText;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724A.rawAnswer')]")
    WebElement avgDayBowel;

    @FindBy(xpath = "//*[@id='answersQS5725A.rawAnswer']")
    WebElement averageDayTotalBowelMovements;

    @FindBy(xpath = "//input[@id = 'answersQS5731A.rawAnswer']")
    WebElement overPastWeekAvgDayBowel;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724B.rawAnswer')]")
    WebElement past24hrBowel;

    @FindBy(xpath = "//*[@id='answersQS5725B.rawAnswer']")
    WebElement past24HoursTotalBowelMovements;
    
    @FindBy(xpath = "//input[contains(@id,'QS5724C.rawAnswer')]")
    WebElement abdominalpainScale;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    

    public SubquestionsIBDShireCrohnsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIBDShireCrohnsPageCC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }
    
    @Step
    public SubquestionsIBDShireCrohnsPageCC avgDayBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageCC setAverageDayTotalBowelMovements(String text) {
        typeText(averageDayTotalBowelMovements, text);
        return this;
    }
    
    @Step
    public SubquestionsIBDShireCrohnsPageCC past24hrBowelMovements(String text) {
        typeText(past24hrBowel, text);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageCC setPast24HoursTotalBowelMovements(String text) {
        typeText(past24HoursTotalBowelMovements, text);
        return this;
    }
    
    @Step
    public SubquestionsIBDShireCrohnsPageCC abdominalpainOnaScale(String text) {
        typeText(abdominalpainScale, text);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageCC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionsIBDShireCrohnsPageCC overPastWeekAvgDayBowel(String text) {
        typeText(overPastWeekAvgDayBowel, text);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
package com.acurian.selenium.pages.CC.GERD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class WhenDidYouHaveAppendixRemoved_CC extends MainPageCC{

    public final String titleExpected1 = "When did you have your appendix removed (appendectomy)? (Agent Note: app-en-DECK-toe-mee)";
    public final String titleExpected2 = "When did you have your gallbladder removed (cholecystectomy)? (Agent Note: cole-leh-sis-TECK-toe-mee)";
    public final String titleExpected3 = "When did you have your hemorrhoids removed (hemorrhoidectomy)? (Agent Note: hem-roy-DECK-toe-mee)";
    public final String titleExpected4 = "When did you have the other surgery on your stomach, intestines, colon, or esophagus?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;


    public WhenDidYouHaveAppendixRemoved_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_CC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_CC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_CC clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
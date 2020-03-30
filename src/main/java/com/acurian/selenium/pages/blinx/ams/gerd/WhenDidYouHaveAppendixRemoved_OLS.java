package com.acurian.selenium.pages.blinx.ams.gerd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenDidYouHaveAppendixRemoved_OLS extends MainPageBlinx {

    public final String titleExpected1 = "When did you have your appendix removed (appendectomy)?";
    public final String titleExpected2 = "When did you have your gallbladder removed (cholecystectomy)?";
    public final String titleExpected3 = "When did you have your hemorrhoids removed (hemorrhoidectomy)?";
    public final String titleExpected4 = "When did you have the other surgery on your stomach, intestines, colon, or esophagus?";

    @FindBy(xpath = "//div[@id='questions']/div[2]/div[@class='question-text']")
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    List<WebElement> titlesText;

//    @FindBy(xpath = "following-sibling::div[@class='answers-container']" +
//            "//div[@class='single-choice-answers-container w-100']/button")
//    List<WebElement> checkBoxList;

    public WhenDidYouHaveAppendixRemoved_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex), expectedTitle);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber)
                .findElements(By.xpath("following-sibling::div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']/button"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling::div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']/button"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS clickOnAnswerForAllSubQuestion(String answerText) {
        titlesText.forEach(el -> {
            List<WebElement> checkBoxListFromTitle = el.findElements(
                    By.xpath("following-sibling::div[@class='answers-container']" +
                            "//div[@class='single-choice-answers-container w-100']/button"));
            clickOnRadioButton(checkBoxListFromTitle, answerText);
        });
        return this;
    }

//    @Step
//    public SubquestionExperiencedHeartPageOLS clickOnAnswers(String ...answerText) {
//        clickOnCheckBoxes(checkBoxList, answerText);
//        return this;
//    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex - 1));
    }

}

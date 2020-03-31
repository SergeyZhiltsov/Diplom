package com.acurian.selenium.pages.blinx.ams.gerd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.selenium.pages.blinx.ams.crohns.CurrentlyHaveAnyFollowingOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


public class WhenDidYouHaveAppendixRemoved_OLS extends MainPageBlinx {

    public final String titleExpected1 = "When did you have your appendix removed (appendectomy)?";
    public final String titleExpected2 = "When did you have your gallbladder removed (cholecystectomy)?";
    public final String titleExpected3 = "When did you have your hemorrhoids removed (hemorrhoidectomy)?";
    public final String titleExpected4 = "When did you have the other surgery on your stomach, intestines, colon, or esophagus?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')])[1]")
    WebElement maintitleText;

    @FindBy(xpath = "//div[contains(@data-answer-type, 'RADIO')]//div[contains(@class,'question-text')]")
    List<WebElement> titlesText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS waitForMainPageLoad() {
        waitForAnimation();
        waitforVisibility(maintitleText);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
//      waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex - 1), expectedTitle);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber)
                .findElements(By.xpath("following-sibling:://div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']//button"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling:://div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']//button"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS clickOnAnswersForSubQuestion(int questionNumber, String... answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("following-sibling:://div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']//button"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenDidYouHaveAppendixRemoved_OLS clickOnAnswersForSubQuestion(String questionText, String... answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling:://div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']//button"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex) {
        return getText(titlesText.get(titleIndex - 1));
    }

}
package com.acurian.selenium.pages.blinx.ams.diabetes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionExperiencedHeartPageOLS extends MainPageBlinx {

    public final String titleExpected1 = "When was the last time that you had a heart attack?";
    public final String titleExpected2 = "When was the last time that you had a stroke?";
    public final String titleExpected3 = "When was the last time that you had a mini-stroke or TIA?";
    public final String titleExpected4 = "When was the last time that you suffered from angina or chest pain that required you to stay in a hospital overnight?";

    @FindBy(xpath = "//div[@id='questions']/div[2]/div[@class='question-text']")
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    List<WebElement> titlesText;

//    @FindBy(xpath = "following-sibling::div[@class='answers-container']" +
//            "//div[@class='single-choice-answers-container w-100']/button")
//    List<WebElement> checkBoxList;

    public SubquestionExperiencedHeartPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionExperiencedHeartPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public SubquestionExperiencedHeartPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex), expectedTitle);
        return this;
    }

    @Step
    public SubquestionExperiencedHeartPageOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber)
                .findElements(By.xpath("following-sibling::div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']/button"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionExperiencedHeartPageOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling::div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']/button"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionExperiencedHeartPageOLS clickOnAnswerForAllSubQuestion(String answerText) {
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

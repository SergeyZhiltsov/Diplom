package com.acurian.selenium.pages.CC.LOWT;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC extends MainPageCC {

    public final String titleExpected1 = "When was the last time that you experienced a heart attack?";
    public final String titleExpected2 = "When was the last time that you experienced a stroke?";
    public final String titleExpected3 = "When was the last time that you experienced a TIA or mini-stroke?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;
    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    @Step
    public WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex - 1), expectedTitle);
        return this;
    }


    @Step
    public WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenWasTheLastTimeYouExperiencedHeartAttackEtcPageCC clickOnAnswerForAllSubQuestion(String answerText) {
        titlesText.forEach(el -> {
            List<WebElement> checkBoxListFromTitle = el.findElements(
                    By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
            clickOnRadioButton(checkBoxListFromTitle, answerText);
        });
        return this;
    }

    @Step
    public String getTitleText(int titleIndex) {
        return getText(titlesText.get(titleIndex - 1));
    }
}
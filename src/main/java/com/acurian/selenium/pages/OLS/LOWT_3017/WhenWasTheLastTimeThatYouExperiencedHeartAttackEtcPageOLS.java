package com.acurian.selenium.pages.OLS.LOWT_3017;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS extends MainPageOLS {

    public final String titleExpected1 = "When was the last time that you experienced a heart attack?";
    public final String titleExpected2 = "When was the last time that you experienced a stroke?";
    public final String titleExpected3 = "When was the last time that you experienced a TIA or mini-stroke?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;
    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    @Step
    public WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex - 1), expectedTitle);
        return this;
    }

    @Step
    public WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS clickOnAnswerForAllSubQuestion(String answerText) {
        titlesText.forEach(el -> {
            List<WebElement> checkBoxListFromTitle = el.findElements(
                    By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
            clickOnRadioButton(checkBoxListFromTitle, answerText);
        });
        return this;
    }

    @Step
    public WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex) {
        return getText(titlesText.get(titleIndex - 1));
    }
}
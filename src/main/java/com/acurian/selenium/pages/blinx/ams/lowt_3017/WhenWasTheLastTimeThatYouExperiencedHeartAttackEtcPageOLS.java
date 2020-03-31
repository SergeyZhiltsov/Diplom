package com.acurian.selenium.pages.blinx.ams.lowt_3017;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS extends MainPageBlinx {

    public final String titleExpected1 = "When was the last time that you experienced a heart attack?";
    public final String titleExpected2 = "When was the last time that you experienced a stroke?";
    public final String titleExpected3 = "When was the last time that you experienced a TIA or mini-stroke?";

    @FindBy(xpath = "//div[@id='questions']/div[2]/div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    List<WebElement> titlesText;
    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    @Step
    public WhenWasTheLastTimeThatYouExperiencedHeartAttackEtcPageOLS waitForPageLoad() {
        waitForAnimation();
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
        List<WebElement> radiobuttonListFromTitle = titlesText.get(questionNumber)
                .findElements(By.xpath("following-sibling::div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']/button"));
        clickOnRadioButton(radiobuttonListFromTitle, answerText);
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

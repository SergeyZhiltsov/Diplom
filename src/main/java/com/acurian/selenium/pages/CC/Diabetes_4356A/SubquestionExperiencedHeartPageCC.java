package com.acurian.selenium.pages.CC.Diabetes_4356A;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;

public class SubquestionExperiencedHeartPageCC extends MainPageCC{

    public final String titleExpected1 = "When was the last time that you had a heart attack?";
    public final String titleExpected2 = "When was the last time that you had a stroke?";
    public final String titleExpected3 = "When was the last time that you had a mini-stroke or TIA?";
    public final String titleExpected4 = "When was the last time that you suffered from angina or chest pain that required you to stay in a hospital overnight?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    @FindBy(xpath = "")
    List<WebElement> checkBoxList;
    
    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public SubquestionExperiencedHeartPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionExperiencedHeartPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public SubquestionExperiencedHeartPageCC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex - 1), expectedTitle);
        return this;
    }


    @Step
    public SubquestionExperiencedHeartPageCC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }
    
    @Step
    public SubquestionExperiencedHeartPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public SubquestionExperiencedHeartPageCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionExperiencedHeartPageCC clickOnAnswerForAllSubQuestion(String answerText) {
        titlesText.forEach(el -> {
            List<WebElement> checkBoxListFromTitle = el.findElements(
                    By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
            clickOnRadioButton(checkBoxListFromTitle, answerText);
        });
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex - 1));
    }
}
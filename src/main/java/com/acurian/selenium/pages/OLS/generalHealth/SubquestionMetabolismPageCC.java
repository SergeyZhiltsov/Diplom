package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class SubquestionMetabolismPageCC extends MainPageCC{

    public final String titleExpected1 = "Do you take any medications to control your high blood pressure or hypertension?";
    public final String titleExpected2 = "Do you require any of the following for your liver disease?\n" +
            "Agent Note: Select all that apply";
    public final String titleExpected3 = "Have you undergone or do you require any of the following treatments related to your kidney disease?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']/div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']/div[@class='show-in-cc']")
    List<WebElement> titlesText;

    public SubquestionMetabolismPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionMetabolismPageCC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionMetabolismPageCC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionMetabolismPageCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionMetabolismPageCC clickOnAnswersForSubQuestion(int questionNumber, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='checkboxes_container']//label"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionMetabolismPageCC clickOnAnswersForSubQuestion(String questionText, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='checkboxes_container']//label"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String ...answerText){
        List<String> answerTextList = Arrays.asList(answerText);
        checkBoxList.stream().filter(el -> answerTextList.parallelStream().anyMatch(el.getText()::contains))
                .forEach(el -> el.click());
        waitForAnimation();
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}

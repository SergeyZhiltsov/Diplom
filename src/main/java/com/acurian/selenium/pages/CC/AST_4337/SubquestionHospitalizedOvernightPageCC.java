package com.acurian.selenium.pages.CC.AST_4337;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionHospitalizedOvernightPageCC extends MainPageCC{

    public final String titleExpected1 = "In the past year, were you hospitalized overnight due to your asthma?";
    public final String titleExpected2 = "In the past year, did you go to the emergency room (ER) because of your asthma?";
    public final String titleExpected3 = "In the past year, did you visit an urgent care center because of your asthma?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    public SubquestionHospitalizedOvernightPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionHospitalizedOvernightPageCC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionHospitalizedOvernightPageCC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionHospitalizedOvernightPageCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
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

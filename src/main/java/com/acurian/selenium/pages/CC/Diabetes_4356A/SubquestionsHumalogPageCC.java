package com.acurian.selenium.pages.CC.Diabetes_4356A;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class SubquestionsHumalogPageCC extends MainPageCC{

    public final String titleExpected1 = "What type of Humalog do you currently use?";
    public final String titleExpected2 = "What type of Humulin do you currently use?";
    public final String titleExpected3 = "What type of Novolin do you currently use?";
    public final String titleExpected4 = "What type of Novolog do you currently use?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public SubquestionsHumalogPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsHumalogPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public SubquestionsHumalogPageCC clickOnAnswersForSubQuestion(int questionNumber, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='checkboxes_container']//label"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionsHumalogPageCC clickOnAnswersForSubQuestion(String questionText, String ...answerText) {
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

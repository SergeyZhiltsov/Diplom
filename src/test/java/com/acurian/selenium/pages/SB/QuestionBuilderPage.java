package com.acurian.selenium.pages.SB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


public class QuestionBuilderPage extends MainPageSB {

    @FindBy(xpath = "//div[@class='bootstrap-dialog-footer-buttons']/button[text() ='Yes']")
    WebElement confirmModify;
    @FindBy(xpath = "//button[@type='submit'][text() ='Save']")
    WebElement save;
    @FindBy(css = "#qbFormErr > div")
    WebElement studyAlertMessage;
    @FindBy(css = "div.form-control.question-editor")
    List<WebElement> questionEditorList;
    @FindBy(css = "div[contenteditable='true']")
    WebElement contentEditableTextField;
    @FindBy(css = "button[title='Save Question']")
    List<WebElement> saveQuestionList;
    @FindBy(css = "button[title='Save Child Question']")
    List<WebElement> saveChildQuestionList;
    @FindBy(css = "#qsSaveMsg")
    WebElement questionSaveAlertMessage;



    public QuestionBuilderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QuestionBuilderPage clickIntroLink(String introNumber) {
        waitAndClickWebElement(By.xpath(String.format("//label[@for='question.questionText'][text() ='%s']",
                introNumber)));
        return this;
    }

    @Step
    public QuestionBuilderPage clickIntroSubQuestionOLS(String introNumber) {
        waitAndClickWebElement(By.xpath(String.format("//div[@id='quest1OLS']//label[text() ='Intro']" +
                "/following-sibling::label[text() ='%s ']", introNumber)));
        return this;
    }

    @Step
    public QuestionBuilderPage clickIntroSubQuestionCC(String introNumber) {
        waitAndClickWebElement(By.xpath(String.format("//div[@id='quest1CC']//label[text() ='Intro']" +
                "/following-sibling::label[text() ='%s ']", introNumber)));
        return this;
    }

    @Step
    public QuestionBuilderPage clickIntroSubQuestionTab(String tabName) {
        waitAndClickWebElement(By.xpath(String.format("//a[@data-toggle='tab'][text() ='%s']", tabName)));
        return this;
    }

    @Step
    public QuestionBuilderPage typeQuestionTextInVisibleField(String text, int numberOfVisibleField) {
        for (WebElement questionEditorField: questionEditorList) {
            if (questionEditorField.isDisplayed()) {
                if (numberOfVisibleField > 1) {
                    numberOfVisibleField--;
                    continue;
                }
                getActions()
                        .moveToElement(questionEditorField)
                        .click(questionEditorField)
                        .build().perform();
                break;
            }
        }
        waitAndClickWebElement(confirmModify);
        typeText(contentEditableTextField, text);
        return this;
    }

    public QuestionBuilderPage clickSaveChildQuestion() {
        for (WebElement saveChildIcon: saveChildQuestionList) {
            if (saveChildIcon.isDisplayed()) {
                waitAndClickWebElement(saveChildIcon);
                break;
            }
        }
        return this;
    }

    @Step
    public QuestionBuilderPage clickSaveQuestion() {
        for (WebElement saveQuestion: saveQuestionList) {
            if (saveQuestion.isDisplayed()) {
                waitAndClickWebElement(saveQuestion);
                break;
            }
        }
        return this;
    }

    @Step()
    public QuestionBuilderPage clickSave() {
        waitAndClickWebElement(save);
        return this;
    }

    @Step
    public QuestionBuilderPage checkQuestionSaveAlertMessage(String expectedText) {
        waitForPresence(By.cssSelector("#qsSaveMsg"));
        Assert.assertEquals(questionSaveAlertMessage.getText(), expectedText, "Save alert message is different.");
        return this;
    }

    @Step
    public QuestionBuilderPage checkStudyAlertMessage(String projectCode) {
        waitForVisibility(studyAlertMessage);
        Assert.assertEquals(studyAlertMessage.getText(), projectCode);
        return this;
    }
}

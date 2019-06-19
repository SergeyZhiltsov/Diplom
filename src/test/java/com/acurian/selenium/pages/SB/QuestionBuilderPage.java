package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class QuestionBuilderPage extends BasePage {

    @FindBy(id = "intro-link")
    WebElement introduction;
    @FindBy(xpath = "//div[@class='bootstrap-dialog-footer-buttons']/button[text() ='Yes']")
    WebElement confirmModify;
    @FindBy(css = "#saveMsgCC0")
    WebElement firstQuestionSaveAlertMessage;
    @FindBy(xpath = "//button[@type='submit'][text() ='Save']")
    WebElement save;
    @FindBy(css = "#qbFormErr > div")
    WebElement studyAlertMessage;
    @FindBy(css = "#qsPanel0 > div:nth-child(1) > div.col-md-1 > div > div > button.btn.btn-default.glyphicon.glyphicon-floppy-disk")
    WebElement saveFlopyIcon;


    public QuestionBuilderPage() {
        PageFactory.initElements(getDriver(), this);
        waitForJavaScriptComplete(); //TODO Check and move to BasePage
    }

    @Step
    public QuestionBuilderPage clickOnIntroduction() {
        waitAndClickWebElement(introduction);
        return this;
    }

    @Step()
    public QuestionBuilderPage clickOnIntroQuestion(int introNumber) {
        waitAndClickWebElement(By.cssSelector(String.format("#frm-%d-item", introNumber - 1)));
        return this;
    }

    @Step()
    public QuestionBuilderPage typeQuestionTextToFirstIntro(String text) { //TODO change later
        waitAndClickWebElement(By.cssSelector("#qsTxtErr0 > div"));
        waitAndClickWebElement(confirmModify);
        WebElement textField = getDriver().findElement(By.cssSelector("#qsTxtErr0 > div > div.froala-wrapper.f-basic > div"));
        typeText(textField, text);
        waitAndClickWebElement(By.cssSelector("#Intro-questions-div > table > tbody > tr > td:nth-child(3)"));
        return this;
    }

    @Step
    public QuestionBuilderPage clickSaveFirstQuestion() {
        waitAndClickWebElement(saveFlopyIcon);
        checkFirstQuestionAlertMessage();
        return this;
    }

    @Step
    private QuestionBuilderPage checkFirstQuestionAlertMessage() {
        waitForVisibility(firstQuestionSaveAlertMessage);
        Assert.assertEquals(firstQuestionSaveAlertMessage.getText(), "Question saved successfully!!!",
                "Save alert message is diff.");
        return this;
    }

    @Step()
    public QuestionBuilderPage clickSave() {
        waitAndClickWebElement(save);
        return this;
    }

    public QuestionBuilderPage checkStudyAlertMessage(String projectCode) {
        waitForVisibility(studyAlertMessage);
        Assert.assertEquals(studyAlertMessage.getText(), projectCode);
        return this;
    }
}

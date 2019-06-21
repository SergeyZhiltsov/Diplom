package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionnaireDiffSummaryPage extends BasePage {

    @FindBy(id = "btnQuestionPublish")
    WebElement btnQuestionPublish;
    @FindBy(xpath = "//div[@class='bootstrap-dialog-footer-buttons']/button[text() ='Yes']")
    WebElement confirmPublish;
    @FindBy(id = "scrPublishBtn")
    WebElement scrPublishBtn;

    public QuestionnaireDiffSummaryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QuestionnaireDiffSummaryPage clickSaveAndPublish() {
        waitAndClickWebElement(btnQuestionPublish);
        return this;
    }

    @Step
    public QuestionnaireDiffSummaryPage clickConfirmPublishOnPopUp() {
        waitAndClickWebElement(confirmPublish);
        return this;
    }

    public StudyProjectsListPage clickPublishToEnvironment() {
        waitAndClickWebElement(scrPublishBtn);
        return new StudyProjectsListPage();
    }
}

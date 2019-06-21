package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogicDiffSummaryPage extends BasePage {

    @FindBy(id = "btnLogicPublish")
    WebElement btnLogicPublish;
    @FindBy(id="logicPublishBtn")
    WebElement logicPublishBtn;
    @FindBy(xpath = "//div[@class='bootstrap-dialog-footer-buttons']/button[text() ='Yes']")
    WebElement confirmPublish;

    public LogicDiffSummaryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LogicDiffSummaryPage clickSaveAndPublish() {
        waitAndClickWebElement(btnLogicPublish);
        return this;
    }

    @Step
    public LogicDiffSummaryPage clickConfirmPublishOnPopUp() {
        waitAndClickWebElement(confirmPublish);
        return new LogicDiffSummaryPage();
    }

    public StudyProjectsListPage clickPublishToEnvironment() {
        waitAndClickWebElement(logicPublishBtn);
        return new StudyProjectsListPage();
    }


}

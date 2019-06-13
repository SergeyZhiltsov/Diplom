package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StudySetupChangesSummaryPage extends BasePage {

    @FindBy(css = "div.alert.alert-warning.alert-dismissable")
    WebElement alertMessage;
    @FindBy(id = "btnPublishStudy")
    WebElement btnPublishStudy;
    @FindBy(xpath = "//div[@class='bootstrap-dialog-footer-buttons']/button[text() ='Yes']")
    WebElement confirmPublish;
    @FindBy(id = "publishBtn")
    WebElement publishButton;

    public StudySetupChangesSummaryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step()
    public StudySetupChangesSummaryPage checkPublishAlertMessage(String expectedMessage) {
        waitForVisibility(alertMessage);
        Assert.assertEquals(expectedMessage, alertMessage.findElement(By.tagName("label")).getText(), "Alert message is different");
        System.out.println(alertMessage.findElement(By.tagName("label")).getText());
        return this;
    }

    @Step
    public StudySetupChangesSummaryPage clickOnSaveAndPublish() {
        waitAndClickWebElement(btnPublishStudy);
        return this;
    }

    @Step
    public SaveStudyDiffSummaryPage clickConfirmPublishOnPopUp() {
        waitAndClickWebElement(confirmPublish);
        return new SaveStudyDiffSummaryPage();
    }

    @Step()
    public StudySetupChangesSummaryPage clickPublish() {
        waitAndClickWebElement(publishButton);
        return this;
    }
}

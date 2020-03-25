package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.OLS.debug.ConfigPageOLS;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class StudySetupDiffSummaryPage extends MainPageSB {

    private static Logger Log = LogManager.getLogger(StudySetupDiffSummaryPage.class.getName());

    @FindBy(xpath = "//label[@for='theraputicArea']//following-sibling::div/span")
    List<WebElement> therapeuticArea;
    @FindBy(xpath = "//label[@for='indication']//following-sibling::div/span")
    List<WebElement> indication;
    @FindBy(css = "div.alert.alert-warning.alert-dismissable")
    WebElement alertMessage;
    @FindBy(id = "btnPublishStudy")
    WebElement btnPublishStudy;
    @FindBy(xpath = "//div[@class='bootstrap-dialog-footer-buttons']/button[text() ='Yes']")
    WebElement confirmPublish;
    @FindBy(id = "publishBtn")
    WebElement publishButton;
    @FindBy(id = "study.comments")
    WebElement commentsField;

    public StudySetupDiffSummaryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step()
    public StudySetupDiffSummaryPage checkPublishAlertMessage(String expectedMessage) {
        waitForVisibility(alertMessage);
        Assert.assertEquals(expectedMessage, alertMessage.findElement(By.tagName("label")).getText(), "Alert message is different");
        Log.info(alertMessage.findElement(By.tagName("label")).getText());
        return this;
    }

    @Step
    public List<String> getTherapeuticArea() {
        List<String> therapeuticAreaList = new LinkedList<>();
        for (WebElement webElement: therapeuticArea) {
            therapeuticAreaList.add(webElement.getText());
        }
        return therapeuticAreaList;
    }

    @Step
    public List<String> getAddedTherapeutic() {
        By deletedTherapeutic = By.xpath("//label[@for='theraputicArea']//following-sibling::div/span/ins");
        return getTextBySelector(deletedTherapeutic);
    }

    @Step
    public List<String> getDeletedTherapeutic() {
        By deletedTherapeutic = By.xpath("//label[@for='theraputicArea']//following-sibling::div/span/del");
        return getTextBySelector(deletedTherapeutic);
    }

    @Step
    public List<String> getAddedIndication() {
        By addedIndication = By.xpath("//label[@for='indication']//following-sibling::div/span/ins");
        return getTextBySelector(addedIndication);
    }

    @Step
    public List<String> getDeletedIndication() {
        By deletedIndication  = By.xpath("//label[@for='indication']//following-sibling::div/span/del");
        return getTextBySelector(deletedIndication);
    }

    private List<String> getTextBySelector(By by) {
        List<String> textList = new LinkedList<>();
        List<WebElement> webElements = waitForVisibility(by).findElements(by);
        for (WebElement webElement: webElements) {
            textList.add(webElement.getText());
        }
        return textList;
    }

    @Step
    public StudySetupDiffSummaryPage checkAddedTherapeutic(String... expectedAdded) {
        List<String> actualAdded = getAddedTherapeutic();
        Assert.assertTrue(compareString(actualAdded, expectedAdded), "Added therapeutic items are NOT equal.");
        return this;
    }

    @Step
    public StudySetupDiffSummaryPage checkDeletedTherapeutic(String... expectedDeleted) {
        List<String> actualDeleted = getDeletedTherapeutic();
        Assert.assertTrue(compareString(actualDeleted, expectedDeleted), "Deleted therapeutic items are NOT equal.");
        return this;
    }

    @Step
    public StudySetupDiffSummaryPage checkAddedIndication(String... expectedAdded) {
        List<String> actualAdded = getAddedIndication();
        Assert.assertTrue(compareString(actualAdded, expectedAdded), "Deleted indication items are NOT equal.");
        return this;
    }

    @Step
    public StudySetupDiffSummaryPage checkDeletedIndication(String... expectedDeleted) {
        List<String> actualDeleted = getDeletedIndication();
        Assert.assertTrue(compareString(actualDeleted, expectedDeleted), "Deleted indication items are NOT equal.");
        return this;
    }

    private boolean compareString(List expected, String... actual) {
        boolean result = Arrays.equals(expected.toArray(), actual);
        System.out.printf("Comparing strings %s and %s. Result (are they equal?): %s %n",
                Arrays.toString(expected.toArray()), Arrays.toString(actual), result);
        return result;
    }

    @Step
    public StudySetupDiffSummaryPage clickSaveAndPublish() {
        waitAndClickWebElement(btnPublishStudy);
        return this;
    }

    @Step
    public SaveStudyDiffSummaryPage clickConfirmPublishOnPopUp() {
        waitAndClickWebElement(confirmPublish);
        return new SaveStudyDiffSummaryPage();
    }

    @Step()
    public StudySetupDiffSummaryPage clickPublish() {
        waitAndClickWebElement(publishButton);
        return this;
    }

    @Step
    public StudySetupDiffSummaryPage addComents(String comments) {
        waitForVisibility(commentsField).sendKeys(comments);
        return this;
    }
}
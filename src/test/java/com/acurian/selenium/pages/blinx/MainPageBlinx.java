package com.acurian.selenium.pages.blinx;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.utils.PassPID;
import com.acurian.selenium.utils.db.ChildResult;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageBlinx extends BasePage {

    String pid;
    String childPid;
    String dispoParent;
    String dispoChild;

    @FindBy(id = "submit")
    WebElement nextButton;
    @FindBy(id = "footerLinksContainer")
    WebElement footerLinksContainer;
    @FindBy(id = "previous")
    WebElement previousQuestion;

    public MainPageBlinx() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        waitForAbsence(By.xpath("//*[@id='questions-form'][contains(@class, 'animated fadeOutUp fast')]"));
        waitForAbsence(By.xpath("//*[@id='questions-form'][contains(@class, 'animated fadeInUp fast')]"));
        logTextToAllure(this.getClass().getSimpleName() + " class with: ");
        textToAttachment(titleExpected, "Title text expected");
        driverWait.waitforVisibility(titleText);
        try {
            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        } catch (TimeoutException ex) {
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
    }

    protected void clickOnRadioButton(List<WebElement> radioButtonList, String answerText) {
        radioButtonList.stream().filter(el -> el.getText().equals(answerText))
                .forEach(el -> {
                    try {
                        el.click();
                    } catch (WebDriverException ex) {
                        scrollToElement(el, true).click();
                    }
                });
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String... answerText) {
        List<String> answerTextList = Arrays.asList(answerText);
        List<String> elementsTextActual = checkBoxList.stream().map(el -> el.getText()).collect(Collectors.toList());
        List<String> answersNotIncluded = answerTextList.stream().filter(el -> elementsTextActual.parallelStream()
                .noneMatch(el2 -> el2.contains(el))).collect(Collectors.toList());
        Assert.assertFalse(answersNotIncluded.size() > 0, "Some answers are not correct " +
                answersNotIncluded + "\n" +
                "expected to click are " + answerTextList + "\n" +
                "actual on page are " + elementsTextActual);

        checkBoxList.stream().filter(el -> answerTextList.stream().anyMatch(el.getText()::startsWith))
                .forEach(el -> {
                    try {
                        el.click();
                    } catch (WebDriverException ex) {
                        scrollToElement(el, true).click();
                    }
                });
        waitForAnimation();
    }

    @Step
    public void clickPreviousQuestion() {
        waitAndClickWebElement(previousQuestion);
    }

    @Step
    public <T extends MainPageBlinx> T clickNextButton(T page) {
        try {
            waitAndClickWebElement(nextButton);
        } catch (WebDriverException ex) {
            scrollToElement(nextButton, true);
            waitAndClickWebElement(nextButton);
        }
        return (T) page;
    }

    protected WebElement waitToBeClickable(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitToBeClickable(By locator) {
        return driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitAndClickWebElement(WebElement element) {
        waitToBeClickable(element).click();
        return element;
    }

    protected WebElement waitAndClickWebElement(By locator) {
        WebElement element = waitToBeClickable(locator);
        element.click();
        return element;
    }

    public void waitForAbsence(WebElement element) {
        driverWait.getWaitDriver().until(driver -> !isElementPresent(element));
    }

    public void waitForAbsence(By locator) {
        driverWait.getWaitDriver().until(driver -> !isElementPresent(locator));
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (WebDriverException ignored) {
            return false;
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            WebElement element = getDriver().findElement(locator);
            element.getTagName();
            return true;
        } catch (WebDriverException ignored) {
            return false;
        }
    }

    @Step
    public <T extends MainPageBlinx> T getPage(T page) {
        return (T) page;
    }

    @Step
    public MainPageBlinx pidFromDbToLog(String env) {
        pid = PassPID.getInstance().getPidNumber();
        getDbConnection().dbReadPID(env, pid);
        dispoParent = getDbConnection().getDispo();
        logTextToAllure("Parent dispo = " + dispoParent + " for PID " + pid);
        return this;
    }

    @Step
    public MainPageBlinx childPidFromDbToLog(String env, String... firstPartOfChildPhoneNumber) {
        ChildResult childResult = getDbConnection().dbReadChildPID(env, pid, firstPartOfChildPhoneNumber);
        dispoChild = childResult.getDispoCd() + childResult.getApplicantStatus();
        childPid = childResult.getChildPid();
        logTextToAllure("Child dispo = " + childResult.getDispoCd() + childResult.getApplicantStatus() + " for PID " + pid +
                " with child pid = " + childResult.getChildPid());
        return this;
    }

    @Step
    public MainPageBlinx dispoShouldMatch(String expectedParentDispo, String... expectedChildDispo) {
        Assert.assertEquals(getDispoParent(), expectedParentDispo, "Dispo for Parent is different");
        if (expectedChildDispo.length == 1) {
            Assert.assertEquals(getDispoChild(), expectedChildDispo[0], "Dispo for Child is different");
        }
        return this;
    }

    public String getDispoParent() {
        return dispoParent;
    }

    public String getDispoChild() {
        return dispoChild;
    }
}

package com.acurian.selenium.pages.blinx;

import com.acurian.selenium.pages.BasePage;
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
        threadSleep(1000);
        logTextToAllure(this.getClass().getSimpleName() + " class with: ");
        textToAttachment(titleExpected, "Title text expected");
        waitForVisibility(titleText);
        try {
            driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        } catch (TimeoutException ex) {
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
    }

    protected void clickOnRadioButton(List<WebElement> radioButtonList, String answerText) {
        threadSleep(500);
        radioButtonList.stream().filter(el -> el.getText().equals(answerText))
                .findFirst()
                .get()
                .click();
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String... answerText) {
        threadSleep(500);
        List<String> answerTextList = Arrays.asList(answerText);
        List<String> elementsTextActual = checkBoxList.stream().map(el -> el.getText()).collect(Collectors.toList());
        List<String> answersNotIncluded = answerTextList.stream().filter(el -> elementsTextActual.parallelStream()
                .noneMatch(el2 -> el2.contains(el))).collect(Collectors.toList());
        Assert.assertFalse(answersNotIncluded.size() > 0, "Some answers are not correct " +
                answersNotIncluded + "\n" +
                "expected to click are " + answerTextList + "\n" +
                "actual on page are " + elementsTextActual);

        checkBoxList.stream().filter(el -> answerTextList.parallelStream().anyMatch(el.getText()::startsWith))
                .forEach(el -> scrollToElement(el, true).click());
        waitForAnimation();
    }

    @Step
    public void clickPreviousQuestion(){
        waitAndClickWebElement(previousQuestion);
    }

    @Step
    public <T extends MainPageBlinx> T clickNextButton(T page) {
        try {
            waitAndClickWebElement(nextButton);
        } catch (WebDriverException ex) {
            scrollToElement(nextButton, true);
            threadSleep(500);
            waitAndClickWebElement(nextButton);
        }
        return (T) page;
    }

    protected WebElement waitForVisibility(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.visibilityOf(element));
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

    protected void waitForAbsence(WebElement element) {
        driverWait.getWaitDriver().until(driver -> !isElementPresent(element));
        waitForAnimation();
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (WebDriverException ignored) {
            return false;
        }
    }
}

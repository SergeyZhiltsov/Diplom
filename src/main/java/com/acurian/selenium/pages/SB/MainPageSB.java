package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

public class MainPageSB extends BasePage {

    public MainPageSB() {
        waitForAnimation();
    }

    @Override
    public void waitForAnimation() {
        wait.until((ExpectedCondition<Boolean>) wdriver
                -> ((JavascriptExecutor) getDriver()).executeScript(
                "return document.readyState"
        ).equals("complete"));
    }

    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        textToAttachment(this.getClass().getSimpleName() + " class with:");
        textToAttachment(titleExpected, "Title text");
        waitForAnimation();
        waitforVisibility(titleText);
        try {
            wait.until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        } catch (TimeoutException ex) {
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
//        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
    }

    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step()
    protected WebElement waitAndClickWebElement(By locator) {

        WebElement element = waitToBeClickable(locator);
        element.click();
        return element;
    }

    @Step()
    protected WebElement waitAndClickWebElement(WebElement element) {
        waitToBeClickable(element).click();
        return element;
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForAbsence(WebElement element) {
        wait.until(driver -> !isElementPresent(element));
        waitForAnimation();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (WebDriverException ignored) {
            return false;
        }
    }
}
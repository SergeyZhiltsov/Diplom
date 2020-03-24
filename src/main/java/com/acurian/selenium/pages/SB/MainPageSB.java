package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

public class MainPageSB extends BasePage {

    public MainPageSB() {
        waitForAnimation();
    }

    @Override
    public void waitForAnimation() {
        driverWait.getWaitDriver().withTimeout(60, TimeUnit.SECONDS).until((ExpectedCondition<Boolean>) wdriver
                -> ((JavascriptExecutor) getDriver()).executeScript(
                "return document.readyState"
        ).equals("complete"));
    }

    public WebElement waitForVisibility(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibility(By locator) {
        return driverWait.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitToBeClickable(By locator) {
        return driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitToBeClickable(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(element));
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
        return driverWait.getWaitDriver().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForAbsence(WebElement element) {
        driverWait.getWaitDriver().until(driver -> !isElementPresent(element));
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
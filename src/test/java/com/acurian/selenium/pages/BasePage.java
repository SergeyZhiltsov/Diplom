package com.acurian.selenium.pages;


import com.acurian.selenium.listeners.TestListener;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage {
    private WebDriver driver;
    protected WebDriverWaitLogged driverWait;
    private Actions actions;
    protected NgWebDriver ngDriver;

//    @FindBy(xpath = "//input[@class='next_btn']")
//    WebElement nextButton;


    public BasePage() {
        driver = BaseTest.getDriver();
        actions = new Actions(driver);
        driverWait = new WebDriverWaitLogged(driver);
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected Actions getActions(){
        return actions;
    }

    @Step
    protected void openURL(String url) {
        driver.navigate().to(url);
    }

    protected void clickByActions(WebElement element){
        actions.moveToElement(element).click().build().perform();
    }

    protected void clickSimpleWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Step
    protected void hoverTo(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    @Step
    protected WebElement scrollToElement(WebElement element, boolean isIntoView) {
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].scrollIntoView(%b);", isIntoView),
                element);
        return element;
    }

    @Step
    protected void scroll(int y) {
        String script = String.format("scroll(0, %d);", y);
        ((JavascriptExecutor) driver).executeScript(script);
    }

    protected void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    @Step
    protected void scrollPageDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @Step
    protected BasePage refreshPage() {
        driver.navigate().to(driver.getCurrentUrl());
        waitForNetwork(5);
        return this;
    }

    @Step
    protected Screenshot getElementScreenshot(WebElement element) {
        return new AShot().takeScreenshot(driver, element);
    }

    @Step
    public ImageDiff getDiff(Screenshot start, Screenshot end) {
        ImageDiff diff = new ImageDiffer().makeDiff(start, end);
        TestListener.attachScreenshot(diff);
        return diff;
    }

    @Step
    protected void setElementAttributeWithJS(String attributeName, String attributeValue, WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", webElement, attributeName,
                attributeValue);
    }

    //work with text

    @Step
    protected void typeTextWithoutClear(WebElement webElement, String text) {
//        scrollToElement(webElement, false);
        webElement.sendKeys(text);
    }

    @Step
    protected void typeText(WebElement webElement, String text) {
//        scrollToElement(webElement, false);
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void typeTextByActions(WebElement element, String text){
        actions.moveToElement(element).click().sendKeys(text).build().perform();
    }

    protected void typeTextWithTime(WebElement webElement, String text, int timeInMilis) {
        for (char sign: text.toCharArray()) {
            webElement.sendKeys(String.valueOf(sign));
            threadSleep(timeInMilis);
        }
    }

    @Step
    protected String getText(WebElement element) {
        String type = element.getTagName().toLowerCase();

        if (type.equals("input") || type.equals("textarea")) {
            String placeholder = element.getAttribute("placeholder");
            return (placeholder != null && placeholder.length() > 0)
                    ? element.getAttribute("value").replace(placeholder, "")
                    : element.getAttribute("value");
        }
        if (type.equals("select")) {
            return new Select(element).getFirstSelectedOption().getText();
        }
        return element.getText();
    }


    /**
     * Select dropdown option by visible text, if not successful, tries select by value
     *
     * @param selectItemText visible text
     * @param element
     */
    protected void selectDropDownListOptionByText(WebElement element, String selectItemText) {
        Select dropDownList = new Select(element);
        // if element has wrong text we can try select item by value
        try {
            dropDownList.selectByVisibleText(selectItemText);
        } catch (NoSuchElementException e) {
            dropDownList.selectByValue(selectItemText);
        }
    }

    protected void selectDropDownListOptionByValue(WebElement element, String value) {

        Select dropDownList = new Select(element);
        dropDownList.selectByValue(value);
    }

    protected List<String> getDropDownListValues(WebElement select) {
        Select dropDownList = new Select(select);
        return dropDownList.getOptions().stream().map(e -> e.getAttribute("value")).collect(Collectors.toList());
    }

    //waits

    protected void waitForNetwork(int timeoutInSeconds) {
        System.out.println("Checking active ajax calls::");
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            for (int i = 0; i < timeoutInSeconds; i++) {
                Object numberOfAjaxConnections = jsDriver.executeScript("return angular.element(document.body).injector().get(\"$http\").pendingRequests.length");
                if (numberOfAjaxConnections instanceof Long) {
                    Long n = (Long) numberOfAjaxConnections;
                    System.out.println("Number of active ajax calls: " + n);
                    if (n == 0L)
                        break;
                }
                threadSleep(1000);
            }
        } else {
            System.out.println("Web getDriver: " + driver + " cannot execute javascript");
        }
    }

    public void waitForAnimation() {
//        threadSleep(3000);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState"
        ).equals("complete"));
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> (boolean)((JavascriptExecutor) driver).executeScript(
                "return jQuery.active == 0"
        ));
    }

    /**
     * Wait alert and accept.
     * <p><b>Does not work in Safari!</b></p>
     */
    protected void acceptAlert() {
        driverWait.getWaitDriver().until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    protected boolean isCheckBoxChecked(WebElement element) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checked", element);
    }


    @Step
    public void threadSleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //logs
    @Step("{0}")
    public void logTextToAllure(String text) {
        //empty method
    }

    // navigation
//    @Step
//    public <T extends BasePage> T clickNextButton(T page) {
//        nextButton.click();
//        return (T)page;
//    }

//    @Step
//    public <T extends BasePage> T clickNextButtonOLS(T page) {
//        nextButtonOLS.click();
//        return (T)page;
//    }

    public void back(){
        driver.navigate().back();
    }
    
    @Step
    public void maximizePage(){
    driver.manage().window().maximize();
    
    }


}

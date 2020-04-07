package com.acurian.selenium.pages;


import com.acurian.selenium.listeners.TestListener;
import com.acurian.utils.CSVParser;
import com.acurian.utils.DBConnection;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public abstract class BasePage {

    /**
     * The wait.
     */
    protected Wait<WebDriver> wait;

    /**
     * The minimal wait.
     */
    protected Wait<WebDriver> minimalWait;

    /**
     * The short wait.
     */
    protected Wait<WebDriver> shortWait;

    /**
     * The long wait.
     */
    protected Wait<WebDriver> longWait;

    /**
     * The no wait.
     */
    protected Wait<WebDriver> noWait;

    protected NgWebDriver ngDriver;
    private WebDriver driver;
    private Actions actions;
    private CSVParser csvParser;
    private DBConnection dbConnection;
    private Dimension dimension;
    private Logger Log = LogManager.getLogger(BasePage.class.getName());

    public BasePage() {
        driver = BaseTest.getDriver();
        actions = new Actions(driver);
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        csvParser = new CSVParser();
        dbConnection = new DBConnection();
        dimension = driver.manage().window().getSize();
        wait = new WebDriverWait(driver, 30);
        minimalWait = new WebDriverWait(driver, 5);
        shortWait = new WebDriverWait(driver, 10);
        longWait = new WebDriverWait(driver, 60);
        noWait = new FluentWait<>(driver).withTimeout(Duration.of(200, ChronoUnit.MILLIS));

        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected Actions getActions() {
        return actions;
    }

    protected CSVParser getCsvParser() {
        return csvParser;
    }

    protected DBConnection getDbConnection() {
        return dbConnection;
    }

    @Step
    protected void openURL(String url) {
        driver.navigate().to(url);
    }

    protected void clickByActions(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }

    protected void clickSimpleWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
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
        Log.info("scrolled to element");
        return element;
    }

    @Step
    protected void dragAndDropButton(WebElement element, int x, int y) {
        actions.dragAndDropBy(element, x, y).build().perform();
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
    public void attachPageScreenshot() {
        TestListener.attachScreenshot(new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver));
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
    protected void typeTextWithoutClearAndConfirm(WebElement webElement, String text) {
//        scrollToElement(webElement, false);
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    @Step
    protected void typeText(WebElement webElement, String text) {
//        scrollToElement(webElement, false);
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void typeTextByActions(WebElement element, String text) {
        actions.moveToElement(element).click().sendKeys(text).build().perform();
    }

    /**
     * Switch to frame.
     *
     * @param frameName the frame name
     */
    public final void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    //rewrite bad method
    protected void typeTextSlow(WebElement webElement, String text) {
        for (char sign : text.toCharArray()) {
            webElement.sendKeys(String.valueOf(sign));
            threadSleep(1);
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

    /**
     * Select item from navigation menu
     *
     * @param menuButtom to open navigation menu
     * @param menuItems  navigation menu items
     * @param item       navigation menu item
     */
    protected void selectFromNavigationMenu(WebElement menuButtom, List<WebElement> menuItems, String item) {
        try {
            waitforVisibility(menuButtom);
            actions.moveToElement(menuButtom).perform();
            menuItems.stream().filter(webElement -> webElement.getText().equals(item))
                    .findFirst()
                    .get()
                    .click();
        } catch (WebDriverException e) {
            Assert.fail("Navigation menu or its item wasn't found");
            throw e;
        }
    }

    //waits

    protected void waitForNetwork(int timeoutInSeconds) {
        Log.info("Checking active ajax calls::");
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            for (int i = 0; i < timeoutInSeconds; i++) {
                Object numberOfAjaxConnections = jsDriver.executeScript("return angular.element(document.body).injector().get(\"$http\").pendingRequests.length");
                if (numberOfAjaxConnections instanceof Long) {
                    Long n = (Long) numberOfAjaxConnections;
                    Log.info("Number of active ajax calls: " + n);
                    if (n == 0L)
                        break;
                }
                threadSleep(1);
            }
        } else {
            Log.info("Web getDriver: " + driver + " cannot execute javascript");
        }
    }

    public void waitforVisibility(WebElement element) {
        //if (element.isDisplayed() || element.isEnabled()) return;
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAnimation() {
        wait.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState"
        ).equals("complete"));
        wait.until((ExpectedCondition<Boolean>) wdriver -> (boolean) ((JavascriptExecutor) driver).executeScript(
                "return jQuery.active == 0"
        ));
    }

    /**
     * Wait alert and accept.
     * <p><b>Does not work in Safari!</b></p>
     */
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void typeAndAcceptAlert(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    protected boolean isCheckBoxChecked(WebElement element) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checked", element);
    }


    protected boolean isElementPresent(By by) {
        boolean isPresent = false;
        try {
            longWait.until(ExpectedConditions.presenceOfElementLocated(by));
            isPresent = true;
        } catch (WebDriverException e) {
        }
        return isPresent;
    }


    @Step
    public void threadSleep(int seconds) {
        if (seconds >= 1000) seconds /= 1000;
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // working with tabs

    @Step
    public <T extends BasePage> T switchTab() {
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        return (T) this;
    }

    @Step
    public void switchToMainTab() {
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(0));
    }

    @Step
    protected void switchTabsUsingPartOfUrl(String platform) {
        String currentHandle = null;
        try {
            final Set<String> handles = driver.getWindowHandles();
            if (handles.size() > 1) {
                currentHandle = driver.getWindowHandle();
            }
            if (currentHandle != null) {
                for (final String handle : handles) {
                    driver.switchTo().window(handle);
                    if (driver.getCurrentUrl().contains(platform) && !currentHandle.equals(handle)) {
                        break;
                    }
                }
            }
//            else {
//                for (final String handle : handles) {
//                    driver.switchTo().window(handle);
//                    if (driver.getCurrentUrl().contains(platform)) {
//                        break;
//                    }
//                }
//            }
        } catch (Exception e) {
            Log.info("Switching tabs failed");
        }
    }


    @Step()
    public void logTextToAllureAndConsole(String text) {
        textToAttachment(text);
        Log.info(text);
    }

    @Attachment(value = "Attachment", type = "plain/text", fileExtension = ".txt")
    public String textToAttachment(String... textToAttachment) {
        return textToAttachment[0];
    }

    @Step
    public void back() {
        driver.navigate().back();
    }

    @Step
    public void maximizePage() {
        driver.manage().window().maximize();
    }

}

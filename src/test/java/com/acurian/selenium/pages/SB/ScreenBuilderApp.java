package com.acurian.selenium.pages.SB;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ScreenBuilderApp extends BasePage {
    private WebDriver driver;

    @FindBy(id = "mytable_filter")
    WebElement search;

    @FindBy(id = "username")
    WebElement loginUsername;

    @FindBy(id ="password")
    WebElement loginPassword;

    @FindBy(xpath = "//table[@id='mytable']//span/a")
    List<WebElement> screeners;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu-right')]/li/a")
    List<WebElement> screenerActions;

    @FindBy(xpath = "//div[@class='btn-group']/button[contains(@id, 'clearCache')]")
    List<WebElement> clearCacheEnvs;

    @FindBy(id = "clearCacheBtn")
    WebElement clearCacheButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    public WebElement cacheClearedSuccessAlert;


    public ScreenBuilderApp() {
        PageFactory.initElements(getDriver(), this);
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    public enum CachEnv {
        DEV("Dev"),
        QA("Qa"),
        STAGING("Staging"),
        PRODUCTION("Production");

        CachEnv(String name) {
            this.name = name;
        }
        public String name;
        }

    @Step
    public ScreenBuilderApp openPage(String env) {
        switch (env) {
            case "QA":
                openURL(URLs.SB_QA);
                break;
            case "PRD":
                openURL(URLs.SB_PRD);
                break;
            default:
                openURL(URLs.SB_QA);
                break;
        }
        return this;
    }

    @Step
    public ScreenBuilderApp searchStudy(String studyName) {
        getActions()
                .moveToElement(search)
                .click()
                .sendKeys(studyName)
                .build()
                .perform();
        return this;
    }

    @Step
    public ScreenBuilderApp loginAs(String username, String password) {
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
        loginPassword.sendKeys(Keys.ENTER);
        return this;
    }

    @Step
    public ScreenBuilderApp clickOnScreener(String screenerName) {
        waitForAnimation();
        screeners.stream().filter(element -> element.getText().equals(screenerName))
                .findFirst()
                .get()
                .click();

        return this;
    }

    @Step
    public ScreenBuilderApp openActionsOf(String screenerName) {
        waitForAnimation();
        WebElement screenerRow = screeners.stream().filter(element -> element.getText().equals(screenerName))
                .findFirst()
                .get();
        screenerRow.findElement(By.xpath("//../../following-sibling::td/div[@class='dropdown']")).click();
        return this;
    }

    @Step
    public ScreenBuilderApp openSubActionsOf(String actionMenu) {
        getActions().moveToElement(screenerActions.stream().filter(element -> element.getText().equals(actionMenu))
                .findFirst()
                .get());
        return this;
    }

    @Step
    public ScreenBuilderApp clearStudyCacheOf(String screenerName, CachEnv env) {
        openActionsOf(screenerName);
        WebElement clearCacheDropdownItem = screenerActions.stream().filter(element -> element.getText().equals("Clear Cache"))
                .findFirst()
                .get();

        getActions()
                .moveToElement(clearCacheDropdownItem)
                .moveToElement(clearCacheDropdownItem.findElement(By.xpath("//following-sibling::ul/li[1]/a[contains(@id,'clear')]"))) // First Sub Menu of Clear Cache Menu
                .click()
                .build().perform();

        driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(clearCacheEnvs.get(0)));
        clearCacheEnvs.stream().filter(element -> element.getText().startsWith(env.name))
                .findFirst()
                .get()
                .click();
        clearCacheButton.click();
        return this;
    }
}

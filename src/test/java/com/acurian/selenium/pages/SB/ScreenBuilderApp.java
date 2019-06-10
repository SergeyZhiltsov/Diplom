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
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sun.webkit.network.URLs.newURL;

public class ScreenBuilderApp extends BasePage {
    private WebDriver driver;

    @FindBy(id = "mytable_filter")
    WebElement search;

    @FindBy(id = "username")
    WebElement loginUsername;

    @FindBy(id = "password")
    WebElement loginPassword;

    @FindBy(css = "img.customimg")
    WebElement logoImage;

    @FindBy(xpath = "//table[@id='mytable']//span/a")
    List<WebElement> screeners;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu-right')]/li/a")
    List<WebElement> screenerActions;

    @FindBy(xpath = "//div[@class='btn-group']/button[contains(@id, 'clearCache')]")
    List<WebElement> clearCacheEnvs;

    @FindBy(xpath = "//button[contains(@id, 'publish')][contains(@data-target, 'initStudy')]")
    List<WebElement> publishStudyEnvs;

    @FindBy(id = "clearCacheBtn")
    WebElement clearCacheButton;

    @FindBy(id = "publishBtn")
    WebElement publishButton;

    @FindBy(id = "btnPublishStudy")
    WebElement btnPublishStudy;

    @FindBy(xpath = "//div[@class='bootstrap-dialog-footer-buttons']/button[text() ='Yes']")
    WebElement confirmPublish;

    @FindBy(id = "comment")
    WebElement commentfield;

    @FindBy(id = "publishProd")
    WebElement prodEnvButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    public WebElement cacheClearedSuccessAlert;

    @FindBy(css = "div.alert.alert-warning.alert-dismissable")
    WebElement alertDismissableMessage;


    public ScreenBuilderApp() {
        PageFactory.initElements(getDriver(), this);
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    public enum SetupEnv {
        DEV("Dev"),
        QA("Qa"),
        STG("Staging"),
        PRD("Production");

        SetupEnv(String name) {
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
        driverWait.waitforVisibility(search);
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
    public ScreenBuilderApp publishStudySetup(String screenerName, SetupEnv setupEnv, String env) {
        openActionsOf(screenerName);
        WebElement publishdropdownItem = screenerActions.stream().filter(element -> element.getText().equals("Publish"))
                .findFirst()
                .get();
        getActions()
                .moveToElement(publishdropdownItem)
                .moveToElement(publishdropdownItem.findElement(By.xpath("//following-sibling::ul/li[1]/a[contains(@id,'publishStdy')]"))) // First Sub Menu of Clear Cache Menu
                .click()
                .build().perform();
        //------enter Comment before selecting environment to publish
        commentfield.sendKeys("No changes, testing publish feature for Healthcheck");

        driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(publishStudyEnvs.get(0)));
        publishStudyEnvs.stream().filter(element -> element.getText().startsWith(setupEnv.name))
                .findFirst()
                .get()
                .click();

        waitAndClickWebElement(publishButton);
        waitAndClickWebElement(btnPublishStudy);
        waitAndClickWebElement(confirmPublish);

        if (env.equals("QA")) {
            waitAndClickWebElement(publishButton);
        }
        return this;
    }

    @Step
    public ScreenBuilderApp clearStudyCacheOf(String screenerName, SetupEnv env) {
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

        waitAndClickWebElement(clearCacheButton);
        return this;
    }

    @Step("Getting actual image logo")
    public Screenshot getActualLogoImage() {
        String src = logoImage.getAttribute("src");
        try {
            return new Screenshot(ImageIO.read(newURL(src)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Step("Getting expected image logo")
    public Screenshot getExpectedLogoImage() {
        try {
            return new Screenshot(ImageIO.read((ScreenBuilderApp.class.getResource("/AcurianSB_wtint.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Step("Enter comment before PublishStudySetup")
    public ScreenBuilderApp entercomment()
    {
        typeText(commentfield, "No changes, testing publish feature for Healthcheck");
        return null;
    }

    public WebElement waitToBeClickable(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitAndClickWebElement(WebElement element) {
        waitToBeClickable(element).click();
        return element;
    }
}

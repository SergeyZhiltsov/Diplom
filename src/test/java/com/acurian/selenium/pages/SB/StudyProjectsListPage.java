package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


public class StudyProjectsListPage extends BasePage {

    @FindBy(id = "mytable_filter")
    WebElement search;
    @FindBy(id ="publishBtn")
    WebElement publishBtn;
    @FindBy(xpath = "//div[@class='btn-group']/button[contains(@id, 'clearCache')]")
    List<WebElement> clearCacheEnvs;
    @FindBy(xpath = "//button[contains(@id, 'publish')][contains(@data-target, 'initStudy')]")
    List<WebElement> publishStudyEnvs;
    @FindBy(id = "clearCacheBtn")
    WebElement clearCacheButton;
    @FindBy(xpath = "//table[@id='mytable']//span/a")
    List<WebElement> screeners;
    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu-right')]/li/a")
    List<WebElement> screenerActions;
    @FindBy(id = "comment")
    WebElement commentField;
    @FindBy(css = "div.alert.alert-success.alert-dismissable")
    WebElement alertMessage;


    public StudyProjectsListPage() {
        PageFactory.initElements(getDriver(), this);
        waitForJavaScriptComplete(); //TODO Check and move to BasePage
    }

    @Step
    public StudyProjectsListPage searchForStudy(String studyName) {
        driverWait.waitforVisibility(search);
        getActions()
                .moveToElement(search)
                .click()
                .sendKeys(studyName)
                .build()
                .perform();
        return this;
    }

    @Step()
    public StudyProjectsListPage checkAlertMessage(String expectedMessage) {
        Assert.assertEquals(alertMessage.getText(), expectedMessage,  "Alert message is different");
        return this;
    }

    public StudyEditPage clickOnStudyName(String studyName) {
        waitAndClickWebElement(By.xpath(String.format("//tr[@data-appid]//a[contains(.,'%s')]", studyName)));
        return new StudyEditPage();
    }

    @Step
    public StudySetupDiffSummaryPage clickPublishStudySetup(String studyName, SetupEnv setupEnv) {
        openActionsOf(studyName);
        WebElement publishdropdownItem = screenerActions.stream().filter(element -> element.getText().equals("Publish"))
                .findFirst()
                .get();
        getActions()
                .moveToElement(publishdropdownItem)
                .moveToElement(publishdropdownItem.findElement(By.xpath("//following-sibling::ul/li[1]/a[contains(@id,'publishStdy')]"))) // First Sub Menu of Clear Cache Menu
                .click()
                .build().perform();
        //------enter Comment before selecting environment to publish

        waitForVisibility(commentField);
        commentField.sendKeys("No changes, testing publish feature for Healthcheck");

        driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(publishStudyEnvs.get(0)));
        publishStudyEnvs.stream().filter(element -> element.getText().startsWith(setupEnv.name))
                .findFirst()
                .get()
                .click();
        waitAndClickWebElement(publishBtn);
        return new StudySetupDiffSummaryPage();
    }

    @Step
    public StudyProjectsListPage openActionsOf(String studyName) {
        waitForAnimation();
        WebElement screenerRow = screeners.stream().filter(element -> element.getText().equals(studyName))
                .findFirst()
                .get();
        screenerRow.findElement(By.xpath("//../../following-sibling::td/div[@class='dropdown']")).click();
        return this;
    }

    @Step
    public StudyProjectsListPage clearStudyCacheOf(String screenerName, SetupEnv env) {
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
}

package com.acurian.selenium.pages.SB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


public class StudyProjectsListPage extends MainPageSB {

    @FindBy(id = "mytable_filter")
    WebElement search;
    @FindBy(id ="publishBtn")
    WebElement publishStudySetup;
    @FindBy(id="scrPublishBtn")
    WebElement publishQuestions;
    @FindBy(id = "publishLogicBtn")
    WebElement publishLogic;
    @FindBy(xpath = "//div[@class='btn-group']/button[contains(@id, 'clearCache')]")
    List<WebElement> clearCacheEnvs;
    @FindBy(xpath = "//button[contains(@id, 'publish')][contains(@data-target, 'initStudy')]")
    List<WebElement> publishStudyEnvs;
    @FindBy(xpath = "//button[contains(@id, 'Publish')][contains(@data-target, 'initQBuilderDiffSummary')]")
    List<WebElement> publishQuestionEnvs;
    @FindBy(xpath = "//button[contains(@id, 'publish')][contains(@data-target, 'initLBuilderDiffSummary')]")
    List<WebElement> publishLogicEnvs;
    @FindBy(id = "clearCacheBtn")
    WebElement clearCacheButton;
    @FindBy(xpath = "//table[@id='mytable']//span/a")
    List<WebElement> screeners;
    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu-right')]/li/a")
    List<WebElement> screenerActions;
    @FindBy(id = "comment")
    WebElement commentStudySetupField;
    @FindBy(id = "scrComment")
    WebElement commentQuestionField;
    @FindBy(id = "logicComment")
    WebElement commentLogicField;
    @FindBy(css = "div.alert.alert-success.alert-dismissable")
    WebElement alertMessage;

    public StudyProjectsListPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StudyProjectsListPage searchForStudy(String studyName) {
        waitForVisibility(search);
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
        waitForVisibility(alertMessage);
        Assert.assertEquals(alertMessage.getText(), expectedMessage,  "Alert message is different");
        waitForAbsence(alertMessage);
        return this;
    }

    public StudyEditPage clickOnStudyName(String studyName) {
        waitAndClickWebElement(By.xpath(String.format("//tr[@data-appid]//a[contains(.,'%s')]", studyName)));
        return new StudyEditPage();
    }

    @Step
    public StudySetupDiffSummaryPage clickPublishStudySetup(String studyName, SetupEnv setupEnv) {
        openActionsOf(studyName);
        WebElement publishDropdownItem = screenerActions.stream().filter(element -> element.getText().equals("Publish"))
                .findFirst()
                .get();
        getActions()
                .moveToElement(publishDropdownItem)
                .moveToElement(publishDropdownItem.findElement(By.xpath("//following-sibling::ul/li[1]/a[contains(@id,'publishStdy')]"))) // First Sub Menu of Clear Cache Menu
                .click()
                .build().perform();
        //------enter Comment before selecting environment to publish

        waitForVisibility(commentStudySetupField);
        commentStudySetupField.sendKeys("Testing SB publish study setup");

        waitToBeClickable(publishStudyEnvs.get(0));
        publishStudyEnvs.stream().filter(element -> element.getText().startsWith(setupEnv.name))
                .findFirst()
                .get()
                .click();
        waitAndClickWebElement(publishStudySetup);
        return new StudySetupDiffSummaryPage();
    }

    @Step
    public QuestionnaireDiffSummaryPage clickPublishQuestions(String studyName, SetupEnv setupEnv) {
        openActionsOf(studyName);
        WebElement publishDropdownItem = screenerActions.stream().filter(element -> element.getText().equals("Publish"))
                .findFirst()
                .get();
        getActions()
                .moveToElement(publishDropdownItem)
                .moveToElement(publishDropdownItem.findElement(By.xpath("//following-sibling::ul/li[3]/a[contains(@id,'publishScr')]")))
                .click()
                .build().perform();
        waitForVisibility(commentQuestionField);
        commentQuestionField.sendKeys("Testing SB questions");

        waitToBeClickable(publishQuestionEnvs.get(0));
        publishQuestionEnvs.stream().filter(element -> element.getAttribute("data-env").startsWith(setupEnv.name))
                .findFirst()
                .get()
                .click();
        waitAndClickWebElement(publishQuestions);
        return new QuestionnaireDiffSummaryPage();
    }

    @Step
    public LogicDiffSummaryPage clickPublishLogic(String studyName, SetupEnv setupEnv) {
        waitForAnimation();
        openActionsOf(studyName);
        WebElement publishDropdownItem = screenerActions.stream().filter(element -> element.getText().equals("Publish"))
                .findFirst()
                .get();
        getActions()
                .moveToElement(publishDropdownItem)
                .moveToElement(publishDropdownItem.findElement(By.xpath("//following-sibling::ul/li[6]/a[contains(@id,'publishLogic')]")))
                .click()
                .build().perform();
        waitForVisibility(commentLogicField);
        commentLogicField.sendKeys("Testing SB logic");

        waitToBeClickable(publishLogicEnvs.get(0));
        publishLogicEnvs.stream().filter(element -> element.getAttribute("data-env").startsWith(setupEnv.name))
                .findFirst()
                .get()
                .click();
        waitAndClickWebElement(publishLogic);
        return new LogicDiffSummaryPage();
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
        waitForAnimation();
        openActionsOf(screenerName);
        WebElement clearCacheDropdownItem = screenerActions.stream().filter(element -> element.getText().equals("Clear Cache"))
                .findFirst()
                .get();
        getActions()
                .moveToElement(clearCacheDropdownItem)
                .moveToElement(clearCacheDropdownItem.findElement(By.xpath("//following-sibling::ul/li[1]/a[contains(@id,'clear')]"))) // First Sub Menu of Clear Cache Menu
                .click()
                .build().perform();
        waitToBeClickable(clearCacheEnvs.get(0));
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
        PRD("Prod");

        SetupEnv(String name) {
            this.name = name;
        }
        public String name;
    }
}

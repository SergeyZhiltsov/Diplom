package com.acurian.selenium.pages.SB;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;


public class StudyEditPage extends MainPageSB {

    @FindBy(id = "projectCode")
    WebElement projectCode;
    @FindBy(css = "label[for=theraputicArea] ~ div ul li")
    List<WebElement> therapeuticArea;
    @FindBy(css = "select[id='theraputicArea']")
    WebElement theraputicAreaSelect;
    @FindBy(css = "label[for=indication] ~ div ul li") //@FindBy(xpath = "//label[@for='indication']//following-sibling::*//ul/li")
    List<WebElement> indication;
    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[2]")
    WebElement indicationSelect;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;
    @FindBy(css = "a[data-nxtpage='Dashboard']")
    WebElement dashboardLink;
    @FindBy(css = "a[data-nxtpage='Study Setup']")
    WebElement studySetupLink;
    @FindBy(css = "a[data-nxtpage='Question Builder']")
    WebElement questionBuilderLink;
    @FindBy(css = "a[data-nxtpage='Logic Builder']")
    WebElement logicBuilderLink;
    @FindBy(css = "div.blockUI.blockOverlay")
    WebElement blockOverlay;

    public StudyEditPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<String> getTherapeuticArea() {
        List<String> therapeuticAreaList = new LinkedList<>();
        for (WebElement webElement: therapeuticArea) {
            therapeuticAreaList.add(webElement.getAttribute("title"));
        }
        return therapeuticAreaList;
    }

    public List<String> getIndication() {
        List<String> indicationList = new LinkedList<>();
        for (WebElement webElement: indication) {
            indicationList.add(webElement.getAttribute("title"));
        }
        return indicationList;
    }

    @Step()
    public String getProjectCode() {
        waitForVisibility(projectCode);
        return projectCode.getAttribute("value");
    }

    @Step()
    public StudyEditPage addTherapeutic(String therapeuticName) {
        Select theraputicList = new Select(theraputicAreaSelect);
        theraputicList.selectByVisibleText(therapeuticName);
        return this;
    }

    @Step()
    public StudyEditPage addIndication(String indicationName) {
        getActions().moveToElement(indicationSelect).click().sendKeys(indicationName).click().build().perform();
//        Select theraputicList = new Select(indicationSelect);
//        theraputicList.selectByVisibleText(indicationName);
        return this;
    }

    @Step()
    public StudyEditPage deleteIndication(String indicationName) {
        waitAndClickWebElement((By.xpath(String
                .format("//label[@for='indication']//following-sibling::*//ul/li[text() = \"%s\"]/span",
                        indicationName))));
        return this;
    }

    @Step()
    public StudyEditPage deleteTherapeutic(String therapeuticName) {
        waitAndClickWebElement((By.xpath(String
                .format("//label[@for='theraputicArea']//following-sibling::*//ul/li[text() = \"%s\"]/span",
                        therapeuticName))));
        return this;
    }

    @Step()
    public StudyEditPage clickSave() {
        waitAndClickWebElement(saveButton);
        return this;
    }
//---------------------------------------------------------- //TODO move to block LeftNavigationMenu
    @Step()
    public StudyProjectsListPage clickDashboard() {
        waitAndClickWebElement(dashboardLink);
        return new StudyProjectsListPage();
    }

    @Step()
    public StudyEditPage clickStudySetup() {
        waitAndClickWebElement(studySetupLink);
        return this;
    }

    @Step()
    public QuestionBuilderPage clickQuestionBuilderLink() {
        waitAndClickWebElement(questionBuilderLink);
        return new QuestionBuilderPage();
    }

    @Step()
    public LogicBuilderPage clickLogicBuilderLink() {
        waitAndClickWebElement(logicBuilderLink);
        waitForVisibility(blockOverlay);
        waitForAbsence(blockOverlay);
        return new LogicBuilderPage();
    }
//----------------------------------------------------------

    @Step()
    public StudyEditPage checkSaveAlertMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, getProjectCode() + " saved Successfully", "Alert message is different");
        return this;
    }
}
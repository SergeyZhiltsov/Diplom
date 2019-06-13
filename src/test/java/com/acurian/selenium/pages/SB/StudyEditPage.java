package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

//Project Information page
public class StudyEditPage extends BasePage {

    @FindBy(id = "projectCode")
    WebElement projectCode;
    @FindBy(css = "label[for=theraputicArea] ~ div ul li")
    List<WebElement> therapeuticArea;
    //@FindBy(css = "label[for=indication] ~ div ul li")
    @FindBy(xpath = "//label[@for='indication']//following-sibling::*//ul/li")
    List<WebElement> indication;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;
    @FindBy(css = "a[data-nxtpage='Dashboard']")
    WebElement dashboardLink;

    public StudyEditPage() {
        PageFactory.initElements(getDriver(), this);
        waitForAnimation(); //TODO Check and move to BasePage
    }

    public List<String> getIndicationList() {
        List<String> indicationList = new LinkedList<>();
        for (WebElement webElement: indication) {
            indicationList.add(webElement.getAttribute("title"));
        }
        return indicationList;
    }

    public List<String> getTherapeuticAreaList() {
        List<String> therapeuticAreaList = new LinkedList<>();
        for (WebElement webElement: therapeuticArea) {
            therapeuticAreaList.add(webElement.getText());
            System.out.println("Therapeutic");
            System.out.println(webElement.getText()); //TODO remove
        }
        return therapeuticAreaList;
    }

    @Step()
    public String getProjectCode() {
        waitForVisibility(projectCode);
        return projectCode.getAttribute("value");
    }

    public StudyEditPage addTherapeutic(String therapeuticName) {

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
    public StudyEditPage clickSave() {
        waitAndClickWebElement(saveButton);
        return this;
    }

    @Step()
    public HomePage clickDashboard() {
        waitAndClickWebElement(dashboardLink);
        return new HomePage();
    }

    @Step()
    public StudyEditPage checkSaveAlertMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, getProjectCode() + " saved Successfully", "Alert message is different");
        return this;
    }
}
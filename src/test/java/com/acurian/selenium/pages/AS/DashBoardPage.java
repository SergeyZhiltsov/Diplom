package com.acurian.selenium.pages.AS;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage extends MainPageAS {

    @FindBy(id = "srchAppName")
    WebElement searchAppList;
    @FindBy(id = "srchRequestedBy")
    WebElement searchRequestByList;
    @FindBy(id = "srchAudit")
    WebElement searchAuditButton;
    @FindBy(css = "div.blockUI.blockOverlay")
    WebElement searchResultsBlockOverlay;
    @FindBy(css = "#tblAuditLog > tbody > tr")
    List<WebElement> searchResultsList;
    @FindBy(xpath = "//*[@id='apiRequest']/ul/li[contains(., 'patientId:')]/span")
    WebElement patientIdFromRequestBody;
    @FindBy(xpath = "//*[@id='apiResponse']//li[contains(., 'code: ')]/span")
    WebElement codeFromResponseBody;

    public DashBoardPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DashBoardPage clickSideMenuLink(String link) {
        waitAndClickWebElement(By.xpath(String.format("//*[@id='side-menu']/li[contains(., '%s')]", link)));
        return this;
    }

    @Step
    public DashBoardPage setSearchAppFilter(String appName) {
        driverWait.waitforVisibility(searchAppList);
        selectDropDownListOptionByText(searchAppList, appName);
        return this;
    }

    @Step
    public DashBoardPage setRequestedByFilter(String requestedBy) {
        driverWait.waitforVisibility(searchRequestByList);
        selectDropDownListOptionByText(searchRequestByList, requestedBy);
        return this;
    }

    @Step
    public DashBoardPage clickSearchButtonAndWaitResults() {
        waitAndClickWebElement(searchAuditButton);
        driverWait.waitforVisibility(searchResultsBlockOverlay);
        waitForAbsence(searchResultsBlockOverlay);
        return this;
    }

    @Step
    public DashBoardPage clickFirstViewButtonFomList() {
        waitAndClickWebElement(searchResultsList.get(0).findElement(By.cssSelector("td > button")));
        return this;
    }

    @Step
    public String getPatientIdFromRequestBody() {
        driverWait.waitforVisibility(patientIdFromRequestBody);
        return patientIdFromRequestBody.getText();
    }

    @Step
    public String getResponseCodeFromResponseBody() {
        driverWait.waitforVisibility(codeFromResponseBody);
        return codeFromResponseBody.getText();
    }
}
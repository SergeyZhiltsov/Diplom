package com.acurian.selenium.pages.rpa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class RpaGeneratePage extends RpaMainPage {

    @FindBy(xpath = "//th[@id='project_header']")
    WebElement projectHeader;

    @FindBy(xpath = "//th[@id='site_header']")
    WebElement siteHeader;

    @FindBy(xpath = "//select[@id='studyId']")
    WebElement selectProject;

    @FindBy(xpath = "//select[@id='siteNumber']")
    WebElement selectSite;

    @FindBy(xpath = "//form[@id='command']/table[2]/tbody/tr[2]/td[3]//label")
    List<WebElement> pidsLabelsList;

    @FindBy(xpath = "//input[@id='submit_button']")
    WebElement submitButton;


    public RpaGeneratePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RpaGeneratePage waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(projectHeader);
        return this;
    }

    @Step
    public RpaGeneratePage clickSelectProjectByName(String projectName){
        waitforVisibility(projectHeader);
        selectDropDownListOptionByText(selectProject, projectName);
        return this;
    }

    @Step
    public RpaGeneratePage clickSelectSiteByName(String projectName){
        waitForAnimation();
        waitforVisibility(siteHeader);
        selectDropDownListOptionByText(selectSite, projectName);
        return this;
    }

    @Step
    public RpaGeneratePage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    @Step
    public boolean isPidIncluded(String pid){
        waitForAnimation();
        return pidsLabelsList.stream().anyMatch(el -> el.getText().contains(pid));
    }

    @Step
    public boolean isSubmitButtonPresent(){
        waitForAnimation();
        return isElementPresent(By.xpath("//input[@id='submit_button']"));
    }
}

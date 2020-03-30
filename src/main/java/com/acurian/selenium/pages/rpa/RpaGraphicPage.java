package com.acurian.selenium.pages.rpa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class RpaGraphicPage extends RpaMainPage {

    @FindBy(xpath = "//div[@id='menu']/ul/li[1]")
    WebElement indexLink;

    @FindBy(xpath = "//div[@id='menu']/ul/li[2]")
    WebElement generateLink;

    @FindBy(xpath = "//div[@id='menu']/ul/li[3]")
    WebElement logoutLink;

    @FindBy(xpath = "//select[@id='studyId']")
    WebElement selectProject;

    @FindBy(xpath = "//select[@id='studyId']")
    WebElement selectSite;

    @FindBy(xpath = "//h2")
    WebElement titleText;

    public RpaGraphicPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RpaGraphicPage waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(indexLink);
        return this;
    }

    @Step
    public RpaGraphicPage hoverIndexLink(){
        hoverTo(indexLink);
        return this;
    }

    @Step
    public RpaGraphicPage clickGenerateLink(){
        generateLink.click();
        return this;
    }

    @Step
    public RpaGeneratePage clickOnBySite() {
//        hoverGenerateLink();
        generateLink.findElement(By.xpath("//*[text()='By Site']")).click();
        return new RpaGeneratePage();
    }

}

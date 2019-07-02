package com.acurian.selenium.pages.SB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveStudyDiffSummaryPage extends MainPageSB {

    @FindBy(id = "publishBtn")
    WebElement publishBtn;

    public SaveStudyDiffSummaryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public StudyProjectsListPage clickPublishToEnvironment() {
        waitForAnimation();
        waitAndClickWebElement(publishBtn);
        return new StudyProjectsListPage();
    }
}

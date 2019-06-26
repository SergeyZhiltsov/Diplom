package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveStudyDiffSummaryPage extends BasePage {

    @FindBy(id = "publishBtn")
    WebElement publishBtn;

    public SaveStudyDiffSummaryPage() {
        PageFactory.initElements(getDriver(), this);
        waitForJavaScriptComplete();
    }

    public StudyProjectsListPage clickPublishToEnvironment() {
        waitForJavaScriptComplete();
        waitAndClickWebElement(publishBtn);
        return new StudyProjectsListPage();
    }
}

package com.acurian.selenium.pages.outer;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class TheStudyPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement projectHeader;

    @FindBy(xpath = "//div[@id='topcta']")
    WebElement getStartedButton;


    public TheStudyPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TheStudyPage openPage() {
        openURL("http://thehalomigrainestudy.com/");
        waitForAnimation();
        return this;
    }

    @Step
    public TheStudyPage waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(projectHeader);
        return this;
    }

    @Step
    public TheStudyPage clickGetStartedButton(){
        getStartedButton.click();
        return this;
    }

    @Step
    public String getTitleText(){
        return projectHeader.getText();
    }
}

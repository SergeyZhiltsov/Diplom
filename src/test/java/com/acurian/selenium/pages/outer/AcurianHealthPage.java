package com.acurian.selenium.pages.outer;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.rpa.RpaMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AcurianHealthPage extends BasePage {

    @FindBy(xpath = "//div[@class='feature']//h1")
    WebElement projectHeader;

    @FindBy(xpath = "//h3/a[text()='See if you qualify!']")
    WebElement seeIfYouQualifyButton;


    public AcurianHealthPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AcurianHealthPage openPage() {
        openURL("https://acurianhealth.com");
        waitForAnimation();
        return this;
    }

    @Step
    public AcurianHealthPage waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(projectHeader);
        Assert.assertEquals(getTitleText(), "AcurianHealth is your guide for getting connected to clinical research studies.",
                "Title is diff");
        return this;
    }

    @Step
    public DateOfBirthPageOLS clickSeeIfYouQualifyButton(){
        driverWait.waitforVisibility(seeIfYouQualifyButton);
        seeIfYouQualifyButton.click();
        return new DateOfBirthPageOLS();
    }

    @Step
    public String getTitleText(){
        return projectHeader.getText();
    }
}

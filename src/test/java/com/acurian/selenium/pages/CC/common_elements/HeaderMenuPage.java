package com.acurian.selenium.pages.CC.common_elements;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.faq.FaqPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenuPage extends BasePage {

    @FindBy(xpath = "//div[@id='menu']//a[text()='Find Patient']")
    WebElement findPatientTab;

    @FindBy(xpath = "//div[@id='menu']//a[text()='Call']")
    WebElement callTab;

    @FindBy(xpath = "//div[@id='menu']//a[text()='Support']")
    WebElement supportTab;

    @FindBy(xpath = "//div[@id='menu']//a[text()='FAQ']")
    WebElement faqTab;

    public HeaderMenuPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HeaderMenuPage clickFindPatientTab(){
        findPatientTab.click();
        return this;
    }

    @Step
    public HeaderMenuPage hoverCallTab(){
        hoverTo(callTab);
        return this;
    }

    @Step
    public HeaderMenuPage clickSupportTab(){
        supportTab.click();
        return this;
    }

    @Step
    public FaqPage clickFaqTab(){
        driverWait.waitforVisibility(faqTab);
        faqTab.click();
        return new FaqPage();
    }
}

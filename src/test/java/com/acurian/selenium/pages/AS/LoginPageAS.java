package com.acurian.selenium.pages.AS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageAS extends MainPageAS {

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameInput;
    @FindBy(xpath = "//input[@name='password']")
    WebElement userPasswordInput;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement signButton;
    @FindBy(css = "head > title")
    WebElement pageTitle;

    public LoginPageAS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LoginPageAS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(pageTitle);
        pageTitle.getText().equals("Dashboard");
        return this;
    }

    @Step
    public LoginPageAS openPage(String environment){
        switch (environment) {
            case "QA":openURL("https://qa-as.acurian.com/as/");
                break;
            case "PRD":openURL("https://as.acurian.com/as/");
                break;
            default:
            case "STG":openURL("https://stg-as.acurian.com/as/");
                break;
        }
        return this;
    }

    @Step
    public DashBoardPage loginToAs(String userName, String password) {
        typeUsername(userName);
        typePassword(password);
        clickLoginButton();
        return new DashBoardPage();
    }

    @Step
    public LoginPageAS typeUsername(String username) {
        driverWait.waitforVisibility(userNameInput);
        typeTextWithoutClear(userNameInput, username);
        return this;
    }

    @Step
    public LoginPageAS typePassword(String password) {
        driverWait.waitforVisibility(userPasswordInput);
        typeTextWithoutClear(userPasswordInput, password);
        return this;
    }

    @Step
    public LoginPageAS clickLoginButton() {
        waitAndClickWebElement(signButton);
        return this;
    }
}
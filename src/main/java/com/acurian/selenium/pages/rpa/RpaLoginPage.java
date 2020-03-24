package com.acurian.selenium.pages.rpa;

import com.acurian.selenium.constants.URLs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;


public class RpaLoginPage extends RpaMainPage {

    @FindBy(id = "username")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement userPasswordInput;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//h2")
    WebElement titleText;

    public RpaLoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RpaLoginPage openPage(String environment){
        switch (environment) {
            case "QA":openURL(URLs.RPA_QA);
                break;
            case "STG":openURL(URLs.RPA_STG);
                break;
            case "PRD":openURL(URLs.RPA_PROD);
                break;
            default:openURL(URLs.RPA_STG);
                break;
        }
        return this;
    }

    @Step
    public RpaLoginPage waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(loginButton);
        return this;
    }

    @Step
    public RpaLoginPage typeUsername(String username) {
        typeTextWithoutClear(userNameInput, username);
        return this;
    }

    @Step
    public RpaLoginPage typePassword(String password) {
        typeTextWithoutClear(userPasswordInput, password);
        return this;
    }

    @Step
    public RpaGraphicPage clickLoginButton() {
        loginButton.click();
        return new RpaGraphicPage();
    }

    public boolean isTitleTextDisplayed() {
        return titleText.isDisplayed();
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

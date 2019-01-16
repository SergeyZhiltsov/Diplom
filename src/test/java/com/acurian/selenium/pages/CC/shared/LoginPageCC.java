package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.utils.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class LoginPageCC extends MainPageCC {

    @FindBy(id = "username")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement userPasswordInput;

    @FindBy(id = "go_btn")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id=callcenter_header]")
    WebElement loginTop;

    @FindBy(xpath = "//div[@class='login_text']")
    WebElement titleText;

    public LoginPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LoginPageCC openPage(){
        openURL(Properties.getBaseURL());
        return this;
    }

    @Step
    public LoginPageCC openPage(String environment){
        switch (environment) {
            case "QA":openURL(URLs.CC_QA);
                break;
            case "STG":openURL(URLs.CC_STG);
                break;
            case "PRD":openURL(URLs.CC_PROD);
                break;
            default:openURL(Properties.getBaseURL());
                break;
        }
        return this;
    }

    @Step
    public LoginPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(loginButton);
        Assert.assertEquals(this.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        return this;
    }

    @Step
    public LoginPageCC typeUsername(String username) {
        typeTextWithoutClear(userNameInput, username);
        return this;
    }

    @Step
    public LoginPageCC typePassword(String password) {
        typeTextWithoutClear(userPasswordInput, password);
        return this;
    }

    @Step
    public SelectActionPageCC clickLoginButton() {
        loginButton.click();
        return new SelectActionPageCC();
    }

    public boolean isLoginTopDisplayed() {
        return loginTop.isDisplayed();
    }

    public LoginPageCC waitForText(){
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

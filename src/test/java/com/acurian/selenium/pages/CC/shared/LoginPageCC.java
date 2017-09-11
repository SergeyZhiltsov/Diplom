package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.MainPage;
import com.acurian.selenium.utils.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageCC extends BasePage {



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
    public LoginPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(loginButton);
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

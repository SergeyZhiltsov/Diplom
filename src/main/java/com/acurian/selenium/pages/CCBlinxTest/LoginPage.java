package com.acurian.selenium.pages.CCBlinxTest;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.Properties;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class LoginPage extends MainPageBlinx {

    public final String titleExpected = "Login";

    @FindBy(xpath = "//*[@id=\"loginForm\"]/div[1]")
    WebElement titleText;

    @FindBy(xpath = "(//input[contains(@class, 'input')])[1]")
    WebElement email;

    @FindBy(xpath = "(//input[contains(@class, 'input')])[2]")
    WebElement pass;

    @FindBy(xpath = "//button[@id='loginSubmit']")
    WebElement loginBtn;

    @Step
    public LoginPage openPage(String environment) {
        switch (environment) {
            case "STG":
                openURL(URLs.BLINX_CC_STG);
                break;
            case "PRD":
                break;
            case "QA":
                break;
            default:
                openURL(Properties.getBaseURL());
                break;
        }
        return this;
    }

    @Step
    public LoginPage waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LoginPage setEmail() {
        waitForAnimation();
        typeText(email, Properties.getUsernameCC());
        return this;
    }

    @Step
    public LoginPage setPass() {
        waitForAnimation();
        typeText(pass, Properties.getPasswordCC());
        return this;
    }

    public <T extends MainPageBlinx> T clickLogin(T page) {
        try {
            waitAndClickWebElement(loginBtn);
        } catch (WebDriverException ex) {
            scrollToElement(loginBtn, true);
            waitAndClickWebElement(loginBtn);
        }
        return (T) page;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

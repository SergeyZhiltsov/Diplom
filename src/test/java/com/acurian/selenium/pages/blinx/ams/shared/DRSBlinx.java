package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.pages.WebDriverWaitLogged;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DRSBlinx extends MainPageBlinx {

    public final String titleExpected = "Select a date and time for your appointment:";

    public final String titleExpectedClientDetailsMain = "Please confirm that the following details are correct before booking your appointment:";

    public final String titleExpected2 = "Client details";

    @FindBy(xpath = "//*[@id='siteScheduler']/div[1]/div/div[1]")
    WebElement titleText;

    @FindBy(xpath = "//*[@class='sb-widget-iframe']")
    WebElement frame;

    @FindBy(xpath = "//*[@id='confirmationPage']/div[1]/span")
    WebElement titleText2;

    @FindBy(xpath = "//*[@class='title-main']")
    WebElement titleTextClientDetailsMain;

    @FindBy(xpath = "(//div[contains(@class, 'cell-day')][not(contains(@class, 'disabled'))])[1]")
    WebElement dayBtn;

    @FindBy(xpath = "(//div[contains(@class, 'timeSlot-btn-container')][not(contains(@class, 'disabled'))])[1]")
    WebElement timeBtn;

    @FindBy(xpath = "//span[contains(@class, 'confirmationDate')]")
    WebElement date;

    @FindBy(xpath = "//span[contains(@class, 'confirmationTime')]")
    WebElement startAt;

    @FindBy(xpath = "(//span[contains(@class, 'confirmationAddress1')])[3]")
    WebElement serviceProvider;

    @FindBy(xpath = "(//*[contains(@class, 'custom-checkbox')])[1]")
    WebElement agreeBtn;

    @FindBy(xpath = "(//*[contains(@class, 'custom-checkbox')])[2]")
    WebElement sendSMS;

    @FindBy(xpath = "//*[@id='bookingSubmit']")
    WebElement nextBtn;

    @Step
    public DRSBlinx dateCheck() {
        logTextToAllureAndConsole(date.getText());
        return this;
    }

    @Step
    public DRSBlinx startsAtCheck() {
        logTextToAllureAndConsole(startAt.getText());
        return this;
    }

    @Step
    public DRSBlinx serviceProviderCheck() {
        logTextToAllureAndConsole(serviceProvider.getText());
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoadClientDetails() {
        waitForPageLoadMain(titleText2, titleExpectedClientDetailsMain);
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoad() {
        getDriver().switchTo().frame(frame);
        threadSleep(10000);
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoadBlinx() {
        threadSleep(10000);
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DRSBlinx clickOnDay() {
        WebDriverWaitLogged webDriverWaitLogged = new WebDriverWaitLogged(getDriver());
        webDriverWaitLogged.waitforVisibility(dayBtn);
        dayBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnTime() {
        WebDriverWaitLogged webDriverWaitLogged = new WebDriverWaitLogged(getDriver());
        webDriverWaitLogged.waitforVisibility(timeBtn);
        timeBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnAgree() {
        WebDriverWaitLogged webDriverWaitLogged = new WebDriverWaitLogged(getDriver());
        webDriverWaitLogged.waitforVisibility(agreeBtn);
        agreeBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnSendSMS() {
        WebDriverWaitLogged webDriverWaitLogged = new WebDriverWaitLogged(getDriver());
        webDriverWaitLogged.waitforVisibility(sendSMS);
        sendSMS.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnNext() {
        WebDriverWaitLogged webDriverWaitLogged = new WebDriverWaitLogged(getDriver());
        webDriverWaitLogged.waitforVisibility(nextBtn);
        nextBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

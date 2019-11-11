package com.acurian.selenium.pages.OLS.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class ScedulerOLS extends MainPageOLS {

    public final String titleExpected = "Time";

    public final String titleExpected2 = "Client details";

    @FindBy(xpath = "//*[@id='sb_dateview_container']/div/div/div[1]/div/div[2]/div/div")
    WebElement titleText;

    @FindBy(xpath = "(//*[@class='title-small'])[2]")
    WebElement titleText2;

    @FindBy(xpath = "//*[@class='title-main']")
    WebElement titleTextClientDetailsMain;

    @FindBy(xpath = "(//*[@class='day-off'])[16]")
    WebElement dayBtn;

    @FindBy(xpath = "(//*[contains(@class, 'sb-cell')])[40]")
    WebElement timeBtn;

    @FindBy(xpath = "(//*[@class='info'])[1]")
    WebElement date;

    @FindBy(xpath = "(//*[@class='info'])[2]")
    WebElement startAt;

    @FindBy(xpath = "(//*[@class='info'])[3]")
    WebElement serviceProvider;

    @Step
    public ScedulerOLS dateCheck() {
        logTextToAllureAndConsole(date.getText());
        return this;
    }

    @Step
    public ScedulerOLS startsAtCheck() {
        logTextToAllureAndConsole(startAt.getText());
        return this;
    }

    @Step
    public ScedulerOLS serviceProviderCheck() {
        logTextToAllureAndConsole(serviceProvider.getText());
        return this;
    }

    @Step
    public ScedulerOLS waitForPageLoadClientDetails() {
        waitForPageLoadMain(titleTextClientDetailsMain, titleExpected);
        return this;
    }

    @Step
    public ScedulerOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ScedulerOLS clickOnDay() {
        dayBtn.click();
        return this;
    }

    @Step
    public ScedulerOLS clickOnTime() {
        timeBtn.click();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

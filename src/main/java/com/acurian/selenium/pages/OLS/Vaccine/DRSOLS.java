package com.acurian.selenium.pages.OLS.Vaccine;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class DRSOLS extends MainPageOLS {

    public final String titleExpected = "Time";

    public final String titleExpectedClientDetailsMain = "Please, confirm details";

    public final String titleExpected2 = "Client details";

    @FindBy(xpath = "(//*[@class='title-small'])[1]")
    WebElement titleText;

    @FindBy(xpath = "//*[@class='sb-widget-iframe']")
    WebElement frame;

    @FindBy(xpath = "(//*[@class='title-small'])[2]")
    WebElement titleText2;

    @FindBy(xpath = "//*[@class='title-main']")
    WebElement titleTextClientDetailsMain;

    @FindBy(xpath = "(//*[@class='day-off'])[16]")
    WebElement dayBtn;

    @FindBy(xpath = "(//*[contains(@class, 'free')])[1]")
    WebElement timeBtn;

    @FindBy(xpath = "(//*[@class='info'])[1]")
    WebElement date;

    @FindBy(xpath = "(//*[@class='info'])[2]")
    WebElement startAt;

    @FindBy(xpath = "(//*[@class='info'])[3]")
    WebElement serviceProvider;

    @FindBy(xpath = "(//*[@class='custom-checkbox'])[1]")
    WebElement agreeBtn;

    @Step
    public DRSOLS dateCheck() {
        logTextToAllureAndConsole(date.getText());
        return this;
    }

    @Step
    public DRSOLS startsAtCheck() {
        logTextToAllureAndConsole(startAt.getText());
        return this;
    }

    @Step
    public DRSOLS serviceProviderCheck() {
        logTextToAllureAndConsole(serviceProvider.getText());
        return this;
    }

    @Step
    public DRSOLS waitForPageLoadClientDetails() {
        waitForPageLoadMain(titleTextClientDetailsMain, titleExpectedClientDetailsMain);
        return this;
    }

    @Step
    public DRSOLS waitForPageLoad() {
        getDriver().switchTo().frame(frame);
        threadSleep(10);
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DRSOLS clickOnDay() {
        waitforVisibility(dayBtn);
        dayBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSOLS clickOnTime() {

        waitforVisibility(timeBtn);
        timeBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSOLS clickOnAgree() {

        waitforVisibility(agreeBtn);
        agreeBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

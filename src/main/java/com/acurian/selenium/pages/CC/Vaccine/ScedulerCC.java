package com.acurian.selenium.pages.CC.Vaccine;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class ScedulerCC extends MainPageCC {

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
    public ScedulerCC dateCheck() {
        logTextToAllureAndConsole(date.getText());
        return this;
    }

    @Step
    public ScedulerCC startsAtCheck() {
        logTextToAllureAndConsole(startAt.getText());
        return this;
    }

    @Step
    public ScedulerCC serviceProviderCheck() {
        logTextToAllureAndConsole(serviceProvider.getText());
        return this;
    }

    @Step
    public ScedulerCC waitForPageLoadClientDetails() {
        waitForPageLoadMain(titleTextClientDetailsMain, titleExpectedClientDetailsMain);
        return this;
    }

    @Step
    public ScedulerCC waitForPageLoad() {
        getDriver().switchTo().frame(frame);
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ScedulerCC clickOnDay() {

        waitforVisibility(dayBtn);
        dayBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public ScedulerCC clickOnTime() {

        waitforVisibility(timeBtn);
        timeBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public ScedulerCC clickOnAgree() {

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

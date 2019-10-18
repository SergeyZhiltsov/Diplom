package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

public class AboutHealthPageOLS extends MainPageBlinx {

    public final String titleExpected = "Join Our Community";

    @FindBy(xpath = "//*[@id='menu-primary_menu']//span[contains(.,'Join Our Community')]")
    WebElement titleText;

    @Step
    public AboutHealthPageOLS waitForPageLoad() {
        try {
            acceptAlert();
        } catch (Exception ex) {
            logTextToAllureAndConsole("Alert was not appeared.");
        }
        driverWait.getWaitDriver().withTimeout(60, TimeUnit.SECONDS)
                .until(ExpectedConditions.visibilityOf(titleText));
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
}

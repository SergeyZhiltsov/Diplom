package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class AboutHealthPageOLS extends MainPageBlinx {

    public final String titleExpected = "Join Our Community";

    @FindBy(xpath = "//*[@id='menu-primary_menu']//span[contains(.,'Join Our Community')]")
    WebElement titleText;

    @Step
    public AboutHealthPageOLS waitForPageLoad() {
        try{
            waitForPageLoadMain(titleText, titleExpected);
        } catch (WebDriverException e) {
            logTextToAllureAndConsole("AboutHealth Page uploaded for more than 20 seconds");
            waitForPageLoadMain(titleText, titleExpected);
        }
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

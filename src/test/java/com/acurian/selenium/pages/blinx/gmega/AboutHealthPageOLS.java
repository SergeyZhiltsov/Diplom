package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class AboutHealthPageOLS extends MainPageBlinx {

    public final String titleExpected = "Join Our Community";

    @FindBy(xpath = "//*[@id='menu-primary_menu']//span[contains(.,'Join Our Community')]")
    WebElement titleText;

    @Step
    public AboutHealthPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
}

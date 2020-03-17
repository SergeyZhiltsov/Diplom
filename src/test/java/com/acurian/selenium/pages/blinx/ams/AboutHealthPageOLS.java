package com.acurian.selenium.pages.blinx.ams;

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
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

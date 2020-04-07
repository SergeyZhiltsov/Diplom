package com.acurian.selenium.pages.blinx.ams.CCBlinxBeginning;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class AdminPortalPage extends MainPageBlinx {
    public final String titleExpected = "Admin Portal";

    @FindBy(xpath = "(//div[contains(@class,'question-title')])[1]")
    WebElement titleText;

    @FindBy(xpath = "(//div[contains(@class,'question-title')])[3]")
    WebElement screenerBtn;

    @Step
    public AdminPortalPage waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public <T extends MainPageBlinx> T clickScreener(T page) {
        try {
            waitAndClickWebElement(screenerBtn);
        } catch (WebDriverException ex) {
            scrollToElement(screenerBtn, true);
            waitAndClickWebElement(screenerBtn);
        }
        return (T) page;
    }
    @Step

    public String getTitleText() {
        return getText(titleText);
    }
}

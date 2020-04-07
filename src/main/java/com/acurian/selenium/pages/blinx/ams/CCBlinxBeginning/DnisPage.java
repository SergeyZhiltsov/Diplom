package com.acurian.selenium.pages.blinx.ams.CCBlinxBeginning;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class DnisPage extends MainPageBlinx {

    public final String titleExpected = "Enter the DNIS to begin a call:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC_BLINX)
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class, 'input')]")
    WebElement dnisField;

    @FindBy(xpath = "//button[@id='dnisSubmit']")
    WebElement beginBtn;

    @Step
    public DnisPage waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DnisPage setDnis(String dnis) {
        waitForAnimation();
        typeText(dnisField, dnis);
        return this;
    }

    public <T extends MainPageBlinx> T clickBegin(T page) {
        try {
            waitAndClickWebElement(beginBtn);
        } catch (WebDriverException ex) {
            scrollToElement(beginBtn, true);
            waitAndClickWebElement(beginBtn);
        }
        return (T) page;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

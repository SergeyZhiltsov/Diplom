package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class NonQRtransitionPageCCBlinx extends MainPageBlinx {

    public final String titleExpected = "We may have other studies going on in your area. Let's see if there's something else that would be a better fit.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @Step
    public NonQRtransitionPageCCBlinx waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    public NonQRtransitionPageCCBlinx() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

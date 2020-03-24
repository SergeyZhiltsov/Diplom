package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class NonQRtransitionPageCC extends MainPageCC {

    public final String titleExpected = "We may have other studies going on in your area. Let's see if there's something else that would be a better fit.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @Step
    public NonQRtransitionPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

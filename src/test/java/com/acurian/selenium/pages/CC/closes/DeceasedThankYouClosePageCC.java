package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DeceasedThankYouClosePageCC extends MainPageCC {
    public final String titleExpected = "Your information will be removed from future mailings. Please know that the opt-out process may take up to 10 days to fully take effect. " +
            "You may visit www.Acurian.com to view our privacy policy. Thank you for contacting us. Goodbye.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public DeceasedThankYouClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DeceasedThankYouClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

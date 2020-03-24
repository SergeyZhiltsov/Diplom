package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class AutoCallOptOutThankYouClosePageCC extends MainPageCC {
    public final String titleExpected = "Thank you. You have been added to the do-not-call list. Please know that this process may take up to 10 days to fully take effect. " +
            "You may visit www.acurian.com to view Acurian's privacy policy. Thank you for contacting us. Goodbye.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public AutoCallOptOutThankYouClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AutoCallOptOutThankYouClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

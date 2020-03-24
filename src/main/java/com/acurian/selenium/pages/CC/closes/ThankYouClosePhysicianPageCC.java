package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouClosePhysicianPageCC extends MainPageCC {

    public final String titleExpected = "We will provide your information to the Sponsor Company and someone will contact you. " +
            "Thank you again for contacting Acurian's Research Information Center. Goodbye.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public ThankYouClosePhysicianPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouClosePhysicianPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

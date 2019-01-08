package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseGeneralInformationPageCC extends MainPageCC {

    public final String titleExpected = "For more information about Acurian and other clinical research study opportunities, please visit www.Acurian.com. " +
            "Thank you for contacting Acurian's Research Information Center.  Goodbye.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public ThankYouCloseGeneralInformationPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouCloseGeneralInformationPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

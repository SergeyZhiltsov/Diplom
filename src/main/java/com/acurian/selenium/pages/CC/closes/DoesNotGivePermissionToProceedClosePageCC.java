package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DoesNotGivePermissionToProceedClosePageCC extends MainPageCC {

    public final String titleExpected = "We're sorry that you're not interested in moving forward with the questionnaire. Please contact us again if you'd like to see if there is a study that's right for you.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public DoesNotGivePermissionToProceedClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoesNotGivePermissionToProceedClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

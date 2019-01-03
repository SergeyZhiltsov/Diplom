package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseSiteContactPageCC extends MainPageCC {

    public final String titleExpected = "Thank you again for contacting Acurian's Research Information Center. " +
            "We will remind the study physician's office of your continued interest in study participation. Goodbye.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public ThankYouCloseSiteContactPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouCloseSiteContactPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

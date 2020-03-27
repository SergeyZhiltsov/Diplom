package com.acurian.selenium.pages.blinx.ams.copd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenDidYouHaveYourMostRecentLungSurgeryOLS extends MainPageBlinx {

    public final String titleExpected = "When did you have your most recent lung surgery?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public WhenDidYouHaveYourMostRecentLungSurgeryOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDidYouHaveYourMostRecentLungSurgeryOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenDidYouHaveYourMostRecentLungSurgeryOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

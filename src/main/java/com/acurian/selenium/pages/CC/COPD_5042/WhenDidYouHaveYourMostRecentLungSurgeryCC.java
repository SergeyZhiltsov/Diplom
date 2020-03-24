package com.acurian.selenium.pages.CC.COPD_5042;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenDidYouHaveYourMostRecentLungSurgeryCC extends MainPageCC {

    public final String titleExpected = "When did you have your most recent lung surgery?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public WhenDidYouHaveYourMostRecentLungSurgeryCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDidYouHaveYourMostRecentLungSurgeryCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenDidYouHaveYourMostRecentLungSurgeryCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
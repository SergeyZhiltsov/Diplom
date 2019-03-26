package com.acurian.selenium.pages.CC.RA.standalone;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class StudiesThatAreCurrentlyEnrollingPageCC extends MainPageCC {

    public final String titleExpected = "We may have other research studies that are currently enrolling patients in your area. " +
            "Would you like to see if we have another study that you are interested in?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonList;

    public StudiesThatAreCurrentlyEnrollingPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StudiesThatAreCurrentlyEnrollingPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public StudiesThatAreCurrentlyEnrollingPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.CC.glaucoma;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SurgeryOrImplantOnOrAroundEyePastSixMonthsCC extends MainPageCC {

    public final String titleExpected = "Have you had any type of surgery or implant on or around your eye or eyelid in the past 6 months?\n" +
            "This includes laser surgery or surgery involving an incision.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public SurgeryOrImplantOnOrAroundEyePastSixMonthsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SurgeryOrImplantOnOrAroundEyePastSixMonthsCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

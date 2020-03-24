package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC extends MainPageCC {

    public final String titleExpected = "Are you currently receiving regular doses of any \"biologic\" medications?\n" +
            "\"Biologics\" are medications that affect the body’s immune system. They are given as an infusion (into a vein) or an injection (a shot under the skin).";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;


    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
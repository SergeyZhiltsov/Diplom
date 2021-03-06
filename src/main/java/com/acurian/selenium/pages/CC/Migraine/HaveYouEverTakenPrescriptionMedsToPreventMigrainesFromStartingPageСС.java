package com.acurian.selenium.pages.CC.Migraine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС extends MainPageCC {
    public final String titleExpected =
            "Have you ever taken prescription medications daily to prevent migraines from starting?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
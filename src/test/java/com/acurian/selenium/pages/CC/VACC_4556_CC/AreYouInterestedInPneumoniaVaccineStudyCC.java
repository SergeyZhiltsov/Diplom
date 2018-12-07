package com.acurian.selenium.pages.CC.VACC_4556_CC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.Vaccine_4556.AreYouInterestedInPneumoniaVaccineStudyOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouInterestedInPneumoniaVaccineStudyCC extends MainPageCC {
    private final String titleExpected = "Are you interested in taking part in a pneumonia vaccine research study? (Agent Note: noo-MOAN-yuh)";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    private WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    private List<WebElement> radioButtonsList;

    public AreYouInterestedInPneumoniaVaccineStudyCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouInterestedInPneumoniaVaccineStudyCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouInterestedInPneumoniaVaccineStudyCC clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.OLS.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouInterestedInPneumoniaVaccineStudyOLS extends MainPageOLS {

    private final String titleExpected = "Are you interested in taking part in a pneumonia vaccine research study?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    private WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    private List<WebElement> radioButtonsList;

    @Step
    public AreYouInterestedInPneumoniaVaccineStudyOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouInterestedInPneumoniaVaccineStudyOLS clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

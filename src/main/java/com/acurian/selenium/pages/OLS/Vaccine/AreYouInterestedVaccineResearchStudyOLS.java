package com.acurian.selenium.pages.OLS.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouInterestedVaccineResearchStudyOLS extends MainPageOLS {

    public final String titleExpected = "Are you interested in taking part in a vaccine research study?\n" +
            "The vaccine is for RSV (respiratory syncytial virus), a virus that can cause respiratory tract infections. It is also the most common cause of pneumonia in older adults.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public AreYouInterestedVaccineResearchStudyOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouInterestedVaccineResearchStudyOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
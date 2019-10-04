package com.acurian.selenium.pages.OLS.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AllergicToAnyVaccinesOLS extends MainPageOLS {

    public final String titleExpected = "Are you allergic to any vaccines; or have you ever had the severe and potentially life-threatening allergic reaction known as anaphylaxis after receiving a vaccine?\n" +
            "Anaphylaxis can occur within seconds or minutes of exposure to something you're allergic to and can cause swelling of the mouth and throat, and difficulty breathing.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public AllergicToAnyVaccinesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AllergicToAnyVaccinesOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

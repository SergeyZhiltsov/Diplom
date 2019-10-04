package com.acurian.selenium.pages.CC.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AllergicToAnyVaccinesCC extends MainPageCC {

    public final String titleExpected = "Are you allergic to any vaccines; or have you ever had the severe and potentially life-threatening allergic reaction known as anaphylaxis after receiving a vaccine?\n" +
            "Anaphylaxis can occur within seconds or minutes of exposure to something you're allergic to and can cause swelling of the mouth and throat, and difficulty breathing.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public AllergicToAnyVaccinesCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AllergicToAnyVaccinesCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

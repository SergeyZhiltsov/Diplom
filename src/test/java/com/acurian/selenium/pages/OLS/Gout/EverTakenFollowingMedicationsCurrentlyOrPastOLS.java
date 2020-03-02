package com.acurian.selenium.pages.OLS.Gout;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EverTakenFollowingMedicationsCurrentlyOrPastOLS extends MainPageOLS {

    public final String titleExpected = "Have you ever taken the following gout medications, either currently or in the past?  \n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxesList;

    @Step
    public EverTakenFollowingMedicationsCurrentlyOrPastOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverTakenFollowingMedicationsCurrentlyOrPastOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxesList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
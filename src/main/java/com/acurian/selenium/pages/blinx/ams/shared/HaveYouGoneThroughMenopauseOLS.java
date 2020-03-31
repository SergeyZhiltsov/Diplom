package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouGoneThroughMenopauseOLS extends MainPageBlinx {

    public final String titleExpected = "Menopause is the period in a woman's life in which menstruation stops permanently and she is no longer able to bear children.\n" +
            "Have you gone through menopause?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public HaveYouGoneThroughMenopauseOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouGoneThroughMenopauseOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.blinx.ams.ps;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverReceivedAnyBiologicMedicationsPageOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever received regular doses of any \"biologic\" medications?\n" +
            "\"Biologics\" are medications that affect the body’s immune system. They are given as an infusion " +
            "(into a vein) or an injection (a shot under the skin).";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public EverReceivedAnyBiologicMedicationsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverReceivedAnyBiologicMedicationsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

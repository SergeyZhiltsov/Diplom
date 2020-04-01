package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BiologicMedicationsPageOLS extends MainPageBlinx {

    public final String titleExpected = "\"Biologics\" are medications that affect the body's immune system. They are given as an infusion (into a vein) or a shot (injection).\n" +
            "Have you ever received any of the following \"biologic\" medications?\n" +
            "Please select all that apply.";
    public final String titleExpectedNew = "Are you currently receiving regular doses of any of the following \"biologic\" medications?\n" +
            "\"Biologics\" are medications that affect the body's immune system. They are given as an infusion (into a vein) or an injection (a shot under the skin).\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public BiologicMedicationsPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public BiologicMedicationsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

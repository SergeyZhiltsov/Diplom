package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BiologicMedicationsPageCC extends MainPageCC {

    public final String titleExpected = "\"Biologics\" are medications that affect the body's immune system. They are given as an infusion (into a vein) or a shot (injection).\n" +
            "Have you ever received any of the following \"biologic\" medications?\n" +
            "Agent Notes:\n" +
            "Please read the full list of medications to the respondent\n" +
            "Select all that apply";
    public final String titleExpectedNew = "Are you currently receiving regular doses of any of the following \"biologic\" medications?\n" +
            "\"Biologics\" are medications that affect the body's immune system. They are given as an infusion (into a vein) or an injection (a shot under the skin).\n" +
            "Agent Notes:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    @Step
    public BiologicMedicationsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public BiologicMedicationsPageCC waitForPageLoadNew() {
        waitForPageLoadMain(titleText, titleExpectedNew);
        return this;
    }

    @Step
    public BiologicMedicationsPageCC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

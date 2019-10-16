package com.acurian.selenium.pages.CC.Gout;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverTakenFollowingMedicationsCurrentlyOrPastCC extends MainPageCC {

    public final String titleExpected = "Have you ever taken the following gout medications, either currently or in the past?\n" +
            "Please select all that apply.\n" +
            "Agent Note: Select all that apply\n";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxesList;

    @Step
    public EverTakenFollowingMedicationsCurrentlyOrPastCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverTakenFollowingMedicationsCurrentlyOrPastCC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxesList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

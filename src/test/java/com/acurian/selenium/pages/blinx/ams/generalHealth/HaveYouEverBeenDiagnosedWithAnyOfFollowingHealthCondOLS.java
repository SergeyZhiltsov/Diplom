package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever been diagnosed with any of the following health conditions?\n" +
            "Please read through the whole list to ensure accuracy, and select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

//    @Step
//    public HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS clickOnAnswers(String... answerText) {
//        waitForAnimation();
//        clickOnCheckBoxes(checkBoxList, answerText);
//        return this;
//    }

    // Checkboxes are covered by the debug window panel, so, we use this method to scroll to the top, and then click on checkboxes.
    @Step
    public HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS clickOnAnswers(String... answerText) {
        waitForAnimation();
        clickOnCheckBoxesBlinx(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

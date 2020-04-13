package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.VersionGetter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever been diagnosed with any of the following health conditions?\n" +
            "Please read through the whole list to ensure accuracy, and select all that apply.";

    public final String titleExpectedСС = "Next, have you ever been diagnosed with any of the following health conditions?\n" +
            "Agent Note: Must read entire list; select all that apply";

    public final String titleExpectedССArea = "We may have other studies going on in your area. Let's see if there's something else that would be a better fit.";

    public final String titleExpectedССHistory = "Thank you for answering the questions about your fibromyalgia history.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent Note: If \"no\" to all items in a question, select \"None of the above\"";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS waitForPageLoad() {
        waitForAnimation();
        if (VersionGetter.getVersion().equals("OLS")) {
            waitForPageLoadMain(titleText, titleExpected);
        } else {
            waitForPageLoadMain(titleText, titleExpectedСС);
        }
        return this;
    }

    @Step
    public HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS waitForPageLoadArea() {
        waitForAnimation();
        if (VersionGetter.getVersion().equals("OLS")) {
            waitForPageLoadMain(titleText, titleExpected);
        } else {
            waitForPageLoadMain(titleText, titleExpectedССArea);
        }
        return this;
    }

    public HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS waitForPageLoadHistory() {
        waitForAnimation();
        if (VersionGetter.getVersion().equals("OLS")) {
            waitForPageLoadMain(titleText, titleExpected);
        } else {
            waitForPageLoadMain(titleText, titleExpectedССHistory);
        }
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

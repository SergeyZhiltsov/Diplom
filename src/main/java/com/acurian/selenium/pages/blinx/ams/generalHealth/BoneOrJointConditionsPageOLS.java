package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BoneOrJointConditionsPageOLS extends MainPageBlinx {

    public final String titleExpected = "Do you suffer from any of the following bone or joint conditions?\n" +
            "Please select all that apply.";

    public final String titleExpected2 = "You indicated that you have a condition that affects bones and joints.\n" +
            "Which of the following specific conditions have you been diagnosed with?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public BoneOrJointConditionsPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

   /* @Step
    public BoneOrJointConditionsPageOLS waitForPageLoadGMEGA() {
        waitForPageLoadMain(titleTextGMEGA, titleExpected);
        return this;
    }*/

    @Step
    public BoneOrJointConditionsPageOLS waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public BoneOrJointConditionsPageOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

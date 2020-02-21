package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BoneOrJointConditionsPageCC extends MainPageCC {

    public final String titleExpected = "Do you suffer from any of the following bone or joint conditions?\n" +
            "Agent Note: Select all that apply";

    public final String titleExpected2 = "You indicated that you have a condition that affects bones and joints.\n" +
            "Which of the following specific conditions have you been diagnosed with?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    @Step
    public BoneOrJointConditionsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public BoneOrJointConditionsPageCC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public BoneOrJointConditionsPageCC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

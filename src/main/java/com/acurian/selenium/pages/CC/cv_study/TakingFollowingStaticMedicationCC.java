package com.acurian.selenium.pages.CC.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TakingFollowingStaticMedicationCC extends MainPageCC {

    public final String titleExpected = "One of the most common kinds of medicines to manage high cholesterol, " +
            "triglycerides, or lipids is called a statin. Most people with these conditions are prescribed this kind of medicine. Statins are prescribed under many different names.\n" +
            "\n" +
            "Are you currently taking any of the following statin medications?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public TakingFollowingStaticMedicationCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TakingFollowingStaticMedicationCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TakingFollowingStaticMedicationCC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

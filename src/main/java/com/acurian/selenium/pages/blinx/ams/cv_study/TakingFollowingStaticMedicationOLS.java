package com.acurian.selenium.pages.blinx.ams.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TakingFollowingStaticMedicationOLS extends MainPageBlinx {

    public final String titleExpected = "One of the most common kinds of medicines to manage high cholesterol, " +
            "triglycerides, or lipids is called a statin. Most people with these conditions are prescribed this kind of medicine. Statins are prescribed under many different names.\n" +
            "\n" +
            "Are you currently taking any of the following statin medications?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public TakingFollowingStaticMedicationOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TakingFollowingStaticMedicationOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TakingFollowingStaticMedicationOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

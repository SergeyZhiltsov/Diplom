package com.acurian.selenium.pages.CC.Diabetes_4356A;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ApartFromMetforminPageCC extends MainPageCC{

    public final String titleExpected = "Apart from metformin, what other oral (taken by mouth) medications do you currently take for your diabetes?\n" +
            "Agent Notes:\n" +
            "Mark off per response the medication names below. If patient does not remember the name of the medication(s), read the full list to the patient.\n" +
            "If patient says they are not on any other oral medications for diabetes, select \"None of the above.\" It is not necessary to read the full list of medications.\n" +
            "Can be read to patients if needed: \"I will be happy to stay on hold while you retrieve your pill bottles.\"";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public ApartFromMetforminPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApartFromMetforminPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ApartFromMetforminPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

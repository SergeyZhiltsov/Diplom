package com.acurian.selenium.pages.CC.pediatric;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhatMedicalCoveragePageCC extends MainPageCC{

    public final String titleExpected = "What medical coverage do you have for your doctor visits, medication, surgery, and/or testing?\n" +
            "Please note that this is for informational purposes only.\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public WhatMedicalCoveragePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhatMedicalCoveragePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhatMedicalCoveragePageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

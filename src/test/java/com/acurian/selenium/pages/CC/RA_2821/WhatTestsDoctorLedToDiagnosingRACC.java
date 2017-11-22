package com.acurian.selenium.pages.CC.RA_2821;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class WhatTestsDoctorLedToDiagnosingRACC extends MainPageCC{

    public final String titleExpected = "What tests did you have that led to your doctor diagnosing your Rheumatoid Arthritis?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public WhatTestsDoctorLedToDiagnosingRACC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhatTestsDoctorLedToDiagnosingRACC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhatTestsDoctorLedToDiagnosingRACC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

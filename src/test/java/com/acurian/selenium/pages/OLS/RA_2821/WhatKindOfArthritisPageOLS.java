package com.acurian.selenium.pages.OLS.RA_2821;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhatKindOfArthritisPageOLS extends MainPageOLS{

    public final String titleExpected = "What kind of arthritis do you have?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText1;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS_MOBILE)
    WebElement titleText2;

    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList1;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_MOBILE)
    List<WebElement> checkBoxList2;

    List<WebElement> checkBoxList;

    public WhatKindOfArthritisPageOLS() {
        PageFactory.initElements(getDriver(), this);
        if (Locators.isEnvWeb) {
            titleText = titleText1;
            checkBoxList = checkBoxList1;
        }
        else {
            titleText = titleText2;
            checkBoxList = checkBoxList2;
        }
    }

    @Step
    public WhatKindOfArthritisPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhatKindOfArthritisPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

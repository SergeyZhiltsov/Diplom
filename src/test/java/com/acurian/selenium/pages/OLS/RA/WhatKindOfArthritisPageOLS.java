package com.acurian.selenium.pages.OLS.RA;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhatKindOfArthritisPageOLS extends MainPageOLS {

    public final String titleExpected = "What kind of arthritis do you have?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/span[@class='show-in-ols']")
    WebElement titleText1;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS_TABLET)
    WebElement titleText2;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS_MOBILE)
    WebElement titleText3;

    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList1;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_TABLET)
    List<WebElement> checkBoxList2;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_MOBILE)
    List<WebElement> checkBoxList3;

    List<WebElement> checkBoxList;

    public WhatKindOfArthritisPageOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                titleText = titleText1;
                checkBoxList = checkBoxList1;
                break;
            case Platforms.TABLET:
                titleText = titleText2;
                checkBoxList = checkBoxList2;
                break;
            case Platforms.MOBILE:
                titleText = titleText3;
                checkBoxList = checkBoxList3;
                break;
        }
    }

    @Step
    public WhatKindOfArthritisPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhatKindOfArthritisPageOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

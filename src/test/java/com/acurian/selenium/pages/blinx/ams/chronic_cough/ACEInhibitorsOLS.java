package com.acurian.selenium.pages.blinx.ams.chronic_cough;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ACEInhibitorsOLS extends MainPageBlinx {

    public final String titleExpected ="ACE inhibitors are medications commonly used to treat high blood pressure (hypertension) and heart failure. This medication is also used for some forms of kidney disease in diabetics, as well as to help protect the heart after heart attacks.\n" +
            "In the past 3 months, have you taken any of the following ACE Inhibitors?\n" +
            "Please select all that apply.";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public ACEInhibitorsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ACEInhibitorsOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }


    @Step
    public ACEInhibitorsOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

package com.acurian.selenium.pages.blinx.ams.dpn_5096;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhereDoYouExperienceDiabeticNervePain_OLS extends MainPageBlinx {

    public final String titleExpected = "Where do you experience diabetic nerve pain symptoms or sensations?\n" +
            "Please select all that apply.";
    public final String titleExpectedDPN = "Where do you experience pain?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public WhereDoYouExperienceDiabeticNervePain_OLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhereDoYouExperienceDiabeticNervePain_OLS waitForPageLoadDPN() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpectedDPN);
        return this;
    }

    @Step
    public WhereDoYouExperienceDiabeticNervePain_OLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

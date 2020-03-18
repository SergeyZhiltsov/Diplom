package com.acurian.selenium.pages.blinx.ams.osteoporosis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OsteoporosisRelatedFracturesOLS extends MainPageBlinx {

    public final String titleExpected = "Osteoporosis often causes fractures (bone breaks), usually from “low-energy” injuries such as a fall from standing height.\n\n" +
            "Have you ever had any of the following osteoporosis-related fractures?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public OsteoporosisRelatedFracturesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OsteoporosisRelatedFracturesOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

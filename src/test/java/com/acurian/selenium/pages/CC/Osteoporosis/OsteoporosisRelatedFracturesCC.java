package com.acurian.selenium.pages.CC.Osteoporosis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OsteoporosisRelatedFracturesCC extends MainPageCC {

    public final String titleExpected = "Osteoporosis often causes fractures (bone breaks), usually from “low-energy” injuries such as a fall from standing height.\n\n" +
            "Have you ever had any of the following osteoporosis-related fractures?" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxesList;

    @Step
    public OsteoporosisRelatedFracturesCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OsteoporosisRelatedFracturesCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxesList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

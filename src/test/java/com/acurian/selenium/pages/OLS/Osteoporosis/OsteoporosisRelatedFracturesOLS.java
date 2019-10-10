package com.acurian.selenium.pages.OLS.Osteoporosis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OsteoporosisRelatedFracturesOLS extends MainPageOLS {

    public final String titleExpected = "Osteoporosis often causes fractures (bone breaks), usually from “low-energy” injuries such as a fall from standing height.\n\n" +
            "Have you ever had any of the following osteoporosis-related fractures?" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxesList;

    @Step
    public OsteoporosisRelatedFracturesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OsteoporosisRelatedFracturesOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxesList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

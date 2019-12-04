package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CardiovascularDiseaseThanOthersPageOLS extends MainPageBlinx {

    private final String titleExpected = "Certain conditions are more closely linked to cardiovascular disease than others.\n" +
            "Has a doctor ever diagnosed you with any of the following medical conditions or diseases?\n" +
            "Please select all that apply:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> multipleChoiceButtonsList;

    @Step
    public CardiovascularDiseaseThanOthersPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CardiovascularDiseaseThanOthersPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(multipleChoiceButtonsList, answerText);
        return this;
    }
}

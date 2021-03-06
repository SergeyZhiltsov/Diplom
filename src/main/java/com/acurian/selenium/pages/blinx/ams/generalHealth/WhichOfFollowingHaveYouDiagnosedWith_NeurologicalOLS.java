package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS extends MainPageBlinx {

    public final String titleExpected = "You indicated that you have a neurological condition.\n" +
            "Which of the following have you been diagnosed with?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

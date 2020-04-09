package com.acurian.selenium.pages.blinx.ams.gerd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.VersionGetter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CurrentlySufferOfAnyOfFollowingOLS extends MainPageBlinx {

    public final String titleExpected = "Do you currently suffer from any of the following?";
    public final String titleExpectedCC = "Thank you, let me see if there are any follow-up questions that we need to ask based on the conditions that you experience.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public CurrentlySufferOfAnyOfFollowingOLS waitForPageLoad() {
        waitForAnimation();
        if (VersionGetter.getVersion().equals("OLS")) {
            waitForPageLoadMain(titleText, titleExpected);
        } else {
            waitForPageLoadMain(titleText, titleExpectedCC);
        }
        return this;
    }

    @Step
    public CurrentlySufferOfAnyOfFollowingOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

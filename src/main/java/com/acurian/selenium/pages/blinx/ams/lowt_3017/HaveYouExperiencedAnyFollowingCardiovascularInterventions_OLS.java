package com.acurian.selenium.pages.blinx.ams.lowt_3017;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS extends MainPageBlinx {

    public final String titleExpected = "Have you experienced any of the following cardiovascular interventions or surgeries?\n" +
            "Please select all that apply:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

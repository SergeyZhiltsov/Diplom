package com.acurian.selenium.pages.CC.Gout;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PastThreeMonthsTakenKrystexxaCC extends MainPageCC {
    public final String titleExpected = "In the past 3 months, have you taken Krystexxa (pegloticase)?\n" +
            "This is a medication given by IV infusion (into a vein)\n";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public PastThreeMonthsTakenKrystexxaCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PastThreeMonthsTakenKrystexxaCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.OLS.Gout;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.Gout.PastThreeMonthsTakenKrystexxaOLS;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PastThreeMonthsTakenKrystexxaOLS extends MainPageOLS {
    public final String titleExpected = "In the past 3 months, have you taken Krystexxa (pegloticase)\n" +
            "This is a medication given by IV infusion (into a vein)";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public PastThreeMonthsTakenKrystexxaOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PastThreeMonthsTakenKrystexxaOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

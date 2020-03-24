package com.acurian.selenium.pages.OLS.DPN_3769_4557;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ApproxHowlongYouBeenExpSymptomsOLS extends MainPageOLS {

    public final String titleExpected = "Approximately how long have you been experiencing symptoms or sensations of diabetic nerve pain?";
    public final String getTitleExpectedDPN = "Approximately how long have you been experiencing diabetic nerve pain?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public ApproxHowlongYouBeenExpSymptomsOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ApproxHowlongYouBeenExpSymptomsOLS waitForPageLoadDPN() {
        waitForPageLoadMain(titleText, getTitleExpectedDPN);
        return this;
    }

    @Step
    public ApproxHowlongYouBeenExpSymptomsOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
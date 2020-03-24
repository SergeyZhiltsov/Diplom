package com.acurian.selenium.pages.CC.END_4385;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyTimesDidYouGetYourPeriodInThreeMons_CC extends MainPageCC {

    public final String titleExpected = "Please think about your most recent menstrual cycles.\n" +
            "How many times did you get your period in the past three months?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HowManyTimesDidYouGetYourPeriodInThreeMons_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyTimesDidYouGetYourPeriodInThreeMons_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyTimesDidYouGetYourPeriodInThreeMons_CC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

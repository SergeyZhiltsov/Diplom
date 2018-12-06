package com.acurian.selenium.pages.CC.Obesity_4605;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenFirstNoticeHungerOrAbnormalFoodSeekingCC extends MainPageCC {
    private final String titleExpected = "When did you (or your parents or caregivers) first notice that you were showing signs of excessive hunger or abnormal food-seeking behaviors?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    private WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    private List<WebElement> radioButtonsList;

    public WhenFirstNoticeHungerOrAbnormalFoodSeekingCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenFirstNoticeHungerOrAbnormalFoodSeekingCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenFirstNoticeHungerOrAbnormalFoodSeekingCC clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

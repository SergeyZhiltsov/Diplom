package com.acurian.selenium.pages.CC.closes.standalone;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.RA_2821.standalone.ExperiencedAnyOfTheFollowingConditionsInPast6Months;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class UnqualifiedStudySwitchCloseOldCC extends MainPageCC {
    public final String titleExpected = "We certainly appreciate your interest in this study. Unfortunately, " +
            "from the information you have provided, you would not be a candidate for this study. We will contact you if study requirements change or if another study opens in your area.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    public UnqualifiedStudySwitchCloseOldCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public UnqualifiedStudySwitchCloseOldCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.OLS.PsoriaticArthritis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyJointsAreSoreTenderPainfulPageOLS extends MainPageOLS {

    public final String titleExpected = "How many of your joints are sore, tender, or painful?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = "//input[@type='tel']")
    WebElement joints;;

    @Step
    public HowManyJointsAreSoreTenderPainfulPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyJointsAreSoreTenderPainfulPageOLS setJointsPainful(String howManyJoints) {
        typeText(joints, howManyJoints);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

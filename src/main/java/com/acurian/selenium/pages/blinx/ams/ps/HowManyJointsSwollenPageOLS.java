package com.acurian.selenium.pages.blinx.ams.ps;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyJointsSwollenPageOLS extends MainPageBlinx {

    public final String titleExpected = "How many of your joints are swollen?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = "//input[@class='noTelephone error'] | //input[@class='noTelephone']")
    WebElement joints;;

    @Step
    public HowManyJointsSwollenPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyJointsSwollenPageOLS setJointsAreSwollen(String howManyJoints) {
        typeText(joints, howManyJoints);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

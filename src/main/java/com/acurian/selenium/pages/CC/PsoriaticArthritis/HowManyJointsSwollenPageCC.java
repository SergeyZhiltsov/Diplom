package com.acurian.selenium.pages.CC.PsoriaticArthritis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyJointsSwollenPageCC extends MainPageCC {

    public final String titleExpected = "How many of your joints are swollen?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = "//div[@class='question_text']/following-sibling::input")
    WebElement joints;

    @Step
    public HowManyJointsSwollenPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyJointsSwollenPageCC setJointsAreSwollen(String howManyJoints) {
        typeText(joints, howManyJoints);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

package com.acurian.selenium.pages.blinx.ams.fibromyalgia;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Version;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.VersionGetter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AnyFollowingPainfulConditionsOLS extends MainPageBlinx {

    public final String titleExpected = "Have you been diagnosed with any of the following painful conditions?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public AnyFollowingPainfulConditionsOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AnyFollowingPainfulConditionsOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}

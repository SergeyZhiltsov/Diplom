package com.acurian.selenium.pages.CC.LOWT;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class LevelOrHypogonadismPageСС extends MainPageCC {

    public final String titleExpected = "The following medications are prescribed for men who have been diagnosed with a low testosterone (male hormone) level or hypogonadism. (Agent note: tes-TOS-ter-one, hi-pō-gō-nad-izm)\n" +
            "Are you currently taking any of the following medications?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public LevelOrHypogonadismPageСС() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LevelOrHypogonadismPageСС waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LevelOrHypogonadismPageСС clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

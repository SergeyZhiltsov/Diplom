package com.acurian.selenium.pages.CC.SUI_3923;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouGoneThroughMenopauseCC extends MainPageCC {

    public final String titleExpected = "Menopause is the period in a woman's life in which menstruation stops permanently and she is no longer able to bear children.\n" +
            "Have you gone through menopause?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HaveYouGoneThroughMenopauseCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouGoneThroughMenopauseCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouGoneThroughMenopauseCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

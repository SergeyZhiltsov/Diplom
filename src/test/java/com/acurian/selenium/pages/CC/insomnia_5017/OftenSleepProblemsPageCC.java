package com.acurian.selenium.pages.CC.insomnia_5017;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OftenSleepProblemsPageCC extends MainPageCC {

    public final String titleExpected = "How often do you usually experience sleep problems?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public OftenSleepProblemsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OftenSleepProblemsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OftenSleepProblemsPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

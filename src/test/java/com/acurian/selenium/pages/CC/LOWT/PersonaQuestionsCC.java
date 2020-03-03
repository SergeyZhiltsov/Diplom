package com.acurian.selenium.pages.CC.LOWT;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class PersonaQuestionsCC extends MainPageCC {

    public final String titleExpected = "These next few rather personal questions will help us assess your health status to better match you with a research study in your area." +
            " We appreciate your participation.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @Step
    public PersonaQuestionsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}

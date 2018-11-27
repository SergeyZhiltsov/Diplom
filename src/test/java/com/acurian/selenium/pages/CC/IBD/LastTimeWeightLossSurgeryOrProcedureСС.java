package com.acurian.selenium.pages.CC.IBD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class LastTimeWeightLossSurgeryOrProcedureСС extends MainPageCC {
    private final String expectedQuestionTitle = "When was the last time that you had a surgery or medical procedure for weight loss?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    private WebElement questionTitle;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    private List<WebElement> radioButtonsList;

    public LastTimeWeightLossSurgeryOrProcedureСС() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LastTimeWeightLossSurgeryOrProcedureСС waitForPageLoad() {
        waitForPageLoadMain(questionTitle, expectedQuestionTitle);
        return this;
    }

    @Step
    public LastTimeWeightLossSurgeryOrProcedureСС clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
}
